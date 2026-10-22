package com.bytedance.crash.dumper;

import android.os.Looper;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.bytedance.crash.dumper.tools.JsonDumper;
import com.bytedance.crash.util.FileSystemUtils;
import com.bytedance.crash.util.JSONUtils;
import java.io.File;
import java.util.Iterator;
import java.util.Map;
import kotlin.text.Typography;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class JavaStack {
    private static final String ABORT_MESSAGE_FILE_NAME = "abort.txt";
    public static final String ALL_THREAD_STACKS = "all_thread_stacks";
    private static final String MAIN_STACK_FILE_NAME = "main_stack.txt";
    private static final String STACK_AT_NATIVE_FILE_NAME = "jstack.txt";
    private static final String TTWEBVIEW_END_TAG = " ttwebview:";
    private static final String TTWEBVIEW_MIDDLE_TAG = "Please include Java exception stack in crash report";
    private static final String TTWEBVIEW_START_TAG = "[FATAL:";

    public static class StackResult {
        private final String mStack;
        private final StackTraceElement[] mStackTraceElement;
        private final long mTime;

        public StackResult(StackTraceElement[] r10) {
            this.mTime = System.currentTimeMillis();
            this.mStackTraceElement = r10;
            this.mStack = formatStackTraceElements(r10);
        }

        private String formatStackTraceElements(StackTraceElement[] r10) {
            StringBuilder r11 = new StringBuilder();
            int r12 = r10.length;
            int r13 = 0;
        L3:
            if (r13 >= r12) goto L6;
            StackTraceElement r14 = r10[r13];
            r11.append("  at ");
            r11.append(r14.getClassName());
            r11.append(".");
            r11.append(r14.getMethodName());
            r11.append("(");
            r11.append(r14.getFileName());
            r11.append(":");
            r11.append(r14.getLineNumber());
            r11.append(")\n");
            r13 = r13 + 1;
            goto L3
        L6:
            return r11.toString();
        }

        public String getStack() {
            return this.mStack;
        }

        public StackTraceElement[] getStackTraceElements() {
            return this.mStackTraceElement;
        }

        public long getTime() {
            return this.mTime;
        }
    }

    public JavaStack() {
    }

    public static void dumpAllStack(File r11) {
        Map<Thread, StackTraceElement[]> r10 = Thread.getAllStackTraces();
        if (r10.isEmpty() == false) goto L5;
        return;
    L5:
        JsonDumper r12 = new JsonDumper(r11.getAbsolutePath() + "/" + ALL_THREAD_STACKS + ".json");
        r12.objectBegin();
        r12.key(ALL_THREAD_STACKS);
        r12.objectBegin();
        r12.key("thread_all_count").value(r10.size()).next();
        r12.key("thread_stacks");
        r12.arrayBegin();
        Iterator<Map.Entry<Thread, StackTraceElement[]>> r13 = r10.entrySet().iterator();
        boolean r14 = true;
    L7:
        if (r13.hasNext() == false) goto L22;
        Map.Entry<Thread, StackTraceElement[]> r15 = r13.next();
        StackTraceElement[] r16 = r15.getValue();
        int r17 = 0;
        if (r14 == false) goto L11;
        r14 = false;
    L12:
        r12.objectBegin();
        Thread r18 = r15.getKey();
        r12.key("thread_name").append(Typography.quote).append(r18.getName()).append('(').append(r18.getId()).append(')').append(Typography.quote);
        r12.next();
        r12.key("thread_stack");
        r12.arrayBegin();
        if (r16.length > 0) goto L15;
        r12.append("\"(Native Method)\"");
    L21:
        r12.arrayEnd();
        r12.objectEnd();
    L15:
        if (r17 >= r16.length) goto L21;
        StackTraceElement r19 = r16[r17];
        r12.append(Typography.quote).append(r19.getClassName()).append('.').append(r19.getMethodName()).append('(').append(r19.getFileName()).append(':').append(r19.getLineNumber()).append(')').append(Typography.quote);
        if (r17 == (r16.length - 1)) goto L19;
        r12.next();
    L19:
        r17 = r17 + 1;
        goto L15
    L11:
        r12.next();
        goto L12
    L22:
        r12.arrayEnd();
        r12.objectEnd();
        r12.objectEnd();
        r12.release();
    }

    public static StackResult dumpMainStack(File r10) {
        StackResult r11 = new StackResult(Looper.getMainLooper().getThread().getStackTrace());
        FileSystemUtils.writeFile(r10, MAIN_STACK_FILE_NAME, r11.getStack());
        return r11;
    }

    public static String getMainStack(File r10) {
        return FileSystemUtils.readUtf8File(new File(r10, MAIN_STACK_FILE_NAME));
    }

    public static boolean isStackFromTrace(String r10) {
        if (TextUtils.isEmpty(r10) == false) goto L5;
    L7:
        return false;
    L5:
        if (r10.startsWith("{\"mainStackFromTrace\":\"\\\"main\\\"") == false) goto L7;
        return true;
    }

    public static void pushAllStackTo(@NonNull JSONObject r10, File r11) {
        String r12 = FileSystemUtils.readUtf8File(new File(r11, "all_thread_stacks.json"));
        if (r12 == null) goto L9;
        JSONUtils.combineJson(r10, new JSONObject(r12));     // Catch: Throwable -> L6
        return;
    L10:
        return;
    }

    public static void pushStackCapturedAtNative(@NonNull JSONObject r10, File r11) {
        File r12 = new File(r11, STACK_AT_NATIVE_FILE_NAME);
        File r13 = new File(r11, ABORT_MESSAGE_FILE_NAME);
        if (r12.exists() == false) goto L5;
        String r14 = FileSystemUtils.readUtf8File(r12);
    L7:
        if (r13.exists() == false) goto L16;
        String r15 = FileSystemUtils.readUtf8File(r13);
        if (r15 == null) goto L16;
        if (r15.startsWith(TTWEBVIEW_START_TAG) == false) goto L16;
        if (r15.contains("Please include Java exception stack in crash report ttwebview:") == false) goto L16;
        StringBuilder r16 = new StringBuilder();
        r16.append(r14);
        int r17 = r15.indexOf(TTWEBVIEW_END_TAG);
        r16.append("Caused by: ");
        r16.append(TTWEBVIEW_MIDDLE_TAG);
        r16.append("\n");
        r16.append(r15.substring(r17 + 11));
        r14 = r16.toString();
    L16:
        if (TextUtils.isEmpty(r14) == true) goto L19;
        JSONUtils.put(r10, "java_data", r14);
        return;
    L19:
        return;
    L5:
        r14 = null;
        goto L7
    }
}
