package com.bytedance.crash.upload;

import androidx.annotation.Nullable;
import com.bytedance.crash.CrashType;
import com.bytedance.crash.runtime.DefaultWorkThread;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public abstract class CrashUploadHandler {
    private static final ConcurrentLinkedQueue<CrashUploadHandler> sHandlers = null;
    private static final LinkedList<CrashInfo> sUploadData = null;
    private static volatile boolean sUploadEnd;

    public static class CrashInfo {
        private final CrashType mCrashType;

        public CrashInfo(CrashType r10) {
            this.mCrashType = r10;
        }

        static /* synthetic */ CrashType access$100(CrashInfo r10) {
            return r10.mCrashType;
        }

        @Deprecated
        public long getAppStartTime() {
            return 0;
        }

        @Nullable
        @Deprecated
        public String getCrashStack() {
            return "";
        }

        @Nullable
        @Deprecated
        public JSONObject getDataJson() {
            return null;
        }

        @Nullable
        @Deprecated
        public JSONObject getHeaderJson() {
            return null;
        }

        @Nullable
        @Deprecated
        public String getProcessName() {
            return "";
        }

        @Nullable
        @Deprecated
        public String getThreadName() {
            return "";
        }
    }

    static {
        sHandlers = new ConcurrentLinkedQueue();
        sUploadEnd = false;
        sUploadData = new LinkedList();
    }

    public CrashUploadHandler() {
    }

    static /* synthetic */ LinkedList access$000() {
        return sUploadData;
    }

    public static void afterUploadEnd() {
        sUploadEnd = true;
        ConcurrentLinkedQueue<CrashUploadHandler> r10 = sHandlers;
        if (r10.isEmpty() == true) goto L10;
        Iterator<CrashUploadHandler> r11 = r10.iterator();
    L6:
        if (r11.hasNext() == false) goto L17;
        r11.next().uploadEnd();     // Catch: Throwable -> L11
        goto L6
    L17:
        return;
    }

    public static void afterUploadOne(CrashType r10) {
        CrashInfo r11 = new CrashInfo(r10);
        sUploadData.add(r11);
        ConcurrentLinkedQueue<CrashUploadHandler> r12 = sHandlers;
        if (r12.isEmpty() == true) goto L10;
        Iterator<CrashUploadHandler> r13 = r12.iterator();
    L6:
        if (r13.hasNext() == false) goto L17;
        r13.next().afterUploadOne(r10, r11);     // Catch: Throwable -> L11
        goto L6
    L17:
        return;
    }

    public static void set(final CrashUploadHandler r10) {
        if (sUploadEnd == false) goto L5;
        DefaultWorkThread.post(new AnonymousClass1(r10));
        return;
    L5:
        sHandlers.add(r10);
    }

    public abstract void afterUploadOne(CrashType r10, CrashInfo r11);

    public void uploadEnd() {
    }
}
