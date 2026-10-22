package com.bytedance.frameworks.baselib.network.http.cronet;

import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public class TTNetThreadConfig {
    private static final int INVALID_THREAD_PRIORITY = 20;
    public int mThreadPriority;
    public int mThreadStackSize;
    public ThreadType mThreadType;

    public static final enum ThreadType extends Enum<ThreadType> {
        private static final /* synthetic */ ThreadType[] $VALUES = null;
        public static final ThreadType FILE_THREAD = null;
        public static final ThreadType INIT_THREAD = null;
        public static final ThreadType NETWORK_THREAD = null;
        public static final ThreadType THREAD_POOL_SERVICE_THREAD = null;
        public static final ThreadType WORKER_THREAD = null;

        static {
            ThreadType r0 = new ThreadType("INIT_THREAD", 0);
            INIT_THREAD = r0;
            ThreadType r1 = new ThreadType("NETWORK_THREAD", 1);
            NETWORK_THREAD = r1;
            ThreadType r3 = new ThreadType("FILE_THREAD", 2);
            FILE_THREAD = r3;
            ThreadType r5 = new ThreadType("THREAD_POOL_SERVICE_THREAD", 3);
            THREAD_POOL_SERVICE_THREAD = r5;
            ThreadType r7 = new ThreadType("WORKER_THREAD", 4);
            WORKER_THREAD = r7;
            $VALUES = new ThreadType[]{r0, r1, r3, r5, r7};
        }

        public static ThreadType[] values() {
            return (ThreadType[]) $VALUES.clone();
        }

        public static ThreadType valueOf(String r1) {
            return (ThreadType) a.a(ThreadType.class, r1);
        }

        private ThreadType(String r1, int r2) {
            super(r1, r2);
        }
    }

    public TTNetThreadConfig() {
        this.mThreadPriority = 20;
        this.mThreadStackSize = 0;
    }
}
