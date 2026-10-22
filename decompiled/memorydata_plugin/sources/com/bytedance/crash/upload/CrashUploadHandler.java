package com.bytedance.crash.upload;

import com.bytedance.crash.CrashType;
import com.bytedance.crash.runtime.DefaultWorkThread;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public abstract class CrashUploadHandler {
    private static final ConcurrentLinkedQueue<CrashUploadHandler> sHandlers = null;
    private static final LinkedList<CrashInfo> sUploadData = null;
    private static volatile boolean sUploadEnd;

    public static class CrashInfo {
        private final CrashType mCrashType;

        public CrashInfo(CrashType r1) {
            this.mCrashType = r1;
        }

        static /* synthetic */ CrashType access$100(CrashInfo r0) {
            return r0.mCrashType;
        }

        @Deprecated
        public long getAppStartTime() {
            return 0;
        }

        @Deprecated
        public String getCrashStack() {
            return "";
        }

        @Deprecated
        public JSONObject getDataJson() {
            return null;
        }

        @Deprecated
        public JSONObject getHeaderJson() {
            return null;
        }

        @Deprecated
        public String getProcessName() {
            return "";
        }

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
        ConcurrentLinkedQueue<CrashUploadHandler> r0 = sHandlers;
        if (r0.isEmpty() == true) goto L10;
        Iterator<CrashUploadHandler> r1 = r0.iterator();
    L6:
        if (r1.hasNext() == false) goto L17;
        ((CrashUploadHandler) ZeusTransformUtils.preCheckCast(r1.next(), CrashUploadHandler.class, "com.obric.memorydata.plugin")).uploadEnd();     // Catch: Throwable -> L11
        goto L6
    L17:
        return;
    }

    public static void afterUploadOne(CrashType r5) {
        CrashInfo r0 = new CrashInfo(r5);
        sUploadData.add(r0);
        ConcurrentLinkedQueue<CrashUploadHandler> r1 = sHandlers;
        if (r1.isEmpty() == true) goto L10;
        Iterator<CrashUploadHandler> r2 = r1.iterator();
    L6:
        if (r2.hasNext() == false) goto L17;
        ((CrashUploadHandler) ZeusTransformUtils.preCheckCast(r2.next(), CrashUploadHandler.class, "com.obric.memorydata.plugin")).afterUploadOne(r5, r0);     // Catch: Throwable -> L11
        goto L6
    L17:
        return;
    }

    public static void set(final CrashUploadHandler r1) {
        if (sUploadEnd == false) goto L5;
        DefaultWorkThread.post(new AnonymousClass1(r1));
        return;
    L5:
        sHandlers.add(r1);
    }

    public abstract void afterUploadOne(CrashType r1, CrashInfo r2);

    public void uploadEnd() {
    }
}
