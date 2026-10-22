package com.bytedance.crash.dumper;

import android.os.Looper;
import android.text.TextUtils;
import com.bytedance.bdlocation.monitor.LBSLightLocationTraceLogger;
import com.bytedance.crash.dumper.tools.JsonDumper;
import com.bytedance.crash.util.FileSystemUtils;
import com.bytedance.crash.util.JSONUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.util.Iterator;
import java.util.Map;
import kotlin.text.Typography;
import org.apache.logging.log4j.message.ParameterizedMessage;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
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

        public StackResult(StackTraceElement[] r3) {
            this.mTime = System.currentTimeMillis();
            this.mStackTraceElement = r3;
            this.mStack = formatStackTraceElements(r3);
        }

        private String formatStackTraceElements(StackTraceElement[] r6) {
            StringBuilder r5 = new StringBuilder();
            int r0 = r6.length;
            int r1 = 0;
        L3:
            if (r1 >= r0) goto L6;
            StackTraceElement r2 = r6[r1];
            r5.append("  at ").append(r2.getClassName()).append(".").append(r2.getMethodName()).append("(").append(r2.getFileName()).append(ParameterizedMessage.ERROR_MSG_SEPARATOR).append(r2.getLineNumber()).append(")\n");
            r1 = r1 + 1;
            goto L3
        L6:
            return r5.toString();
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
        Map<Thread, StackTraceElement[]> r0 = Thread.getAllStackTraces();
        if (r0.isEmpty() == false) goto L5;
        return;
    L5:
        JsonDumper r1 = new JsonDumper(r11.getAbsolutePath() + "/" + ALL_THREAD_STACKS + ".json");
        r1.objectBegin();
        r1.key(ALL_THREAD_STACKS);
        r1.objectBegin();
        r1.key("thread_all_count").value(r0.size()).next();
        r1.key("thread_stacks");
        r1.arrayBegin();
        Iterator<Map.Entry<Thread, StackTraceElement[]>> r12 = r0.entrySet().iterator();
        boolean r2 = true;
    L7:
        if (r12.hasNext() == false) goto L22;
        Map.Entry r3 = (Map.Entry) ZeusTransformUtils.preCheckCast(r12.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        StackTraceElement[] r4 = (StackTraceElement[]) ZeusTransformUtils.preCheckCast(r3.getValue(), StackTraceElement[].class, "com.obric.memorydata.plugin");
        int r6 = 0;
        if (r2 == false) goto L11;
        r2 = false;
    L12:
        r1.objectBegin();
        Thread r5 = (Thread) ZeusTransformUtils.preCheckCast(r3.getKey(), Thread.class, "com.obric.memorydata.plugin");
        r1.key(LBSLightLocationTraceLogger.THREAD_NAME).append(Typography.quote).append(r5.getName()).append('(').append(r5.getId()).append(')').append(Typography.quote);
        r1.next();
        r1.key("thread_stack");
        r1.arrayBegin();
        if (r4.length > 0) goto L15;
        r1.append("\"(Native Method)\"");
    L21:
        r1.arrayEnd();
        r1.objectEnd();
    L15:
        if (r6 >= r4.length) goto L21;
        StackTraceElement r7 = r4[r6];
        r1.append(Typography.quote).append(r7.getClassName()).append('.').append(r7.getMethodName()).append('(').append(r7.getFileName()).append(':').append(r7.getLineNumber()).append(')').append(Typography.quote);
        if (r6 == (r4.length - 1)) goto L19;
        r1.next();
    L19:
        r6 = r6 + 1;
        goto L15
    L11:
        r1.next();
        goto L12
    L22:
        r1.arrayEnd();
        r1.objectEnd();
        r1.objectEnd();
        r1.release();
    }

    public static StackResult dumpMainStack(File r3) {
        StackResult r1 = new StackResult(Looper.getMainLooper().getThread().getStackTrace());
        FileSystemUtils.writeFile(r3, MAIN_STACK_FILE_NAME, r1.getStack());
        return r1;
    }

    public static String getMainStack(File r2) {
        return FileSystemUtils.readUtf8File(new File(r2, MAIN_STACK_FILE_NAME));
    }

    public static boolean isStackFromTrace(String r1) {
        if (TextUtils.isEmpty(r1) == false) goto L5;
    L7:
        return false;
    L5:
        if (r1.startsWith("{\"mainStackFromTrace\":\"\\\"main\\\"") == false) goto L7;
        return true;
    }

    public static void pushAllStackTo(JSONObject r2, File r3) {
        String r4 = FileSystemUtils.readUtf8File(new File(r3, "all_thread_stacks.json"));
        if (r4 == null) goto L9;
        JSONUtils.combineJson(r2, new JSONObject(r4));     // Catch: Throwable -> L6
        return;
    L10:
        return;
    }

    public static void pushStackCapturedAtNative(JSONObject r4, File r5) {
        File r0 = new File(r5, STACK_AT_NATIVE_FILE_NAME);
        File r1 = new File(r5, ABORT_MESSAGE_FILE_NAME);
        if (r0.exists() == false) goto L5;
        String r6 = FileSystemUtils.readUtf8File(r0);
    L7:
        if (r1.exists() == false) goto L16;
        String r2 = FileSystemUtils.readUtf8File(r1);
        if (r2 == null) goto L16;
        if (r2.startsWith(TTWEBVIEW_START_TAG) == false) goto L16;
        if (r2.contains("Please include Java exception stack in crash report ttwebview:") == false) goto L16;
        StringBuilder r3 = new StringBuilder();
        r3.append(r6);
        int r7 = r2.indexOf(TTWEBVIEW_END_TAG);
        r3.append("Caused by: ").append(TTWEBVIEW_MIDDLE_TAG).append("\n");
        r3.append(r2.substring(r7 + 11));
        r6 = r3.toString();
    L16:
        if (TextUtils.isEmpty(r6) == true) goto L19;
        JSONUtils.put(r4, "java_data", r6);
        return;
    L19:
        return;
    L5:
        r6 = null;
        goto L7
    }
}
