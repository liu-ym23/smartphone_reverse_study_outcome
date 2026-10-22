package com.ttnet.org.chromium.net;

import com.ttnet.org.chromium.base.annotations.CalledByNative;
import com.ttnet.org.chromium.base.annotations.JNINamespace;

/* JADX INFO: loaded from: classes2.dex */
@JNINamespace("cronet")
public abstract class TTThreadConfigInfoProvider {
    public static final int INVALID_THREAD_PRIORITY = 20;

    public static final enum BindCore extends Enum<BindCore> {
        private static final /* synthetic */ BindCore[] $VALUES = null;
        public static final BindCore BIG_CORE = null;
        public static final BindCore CANCEL_BIND = null;
        public static final BindCore DEFAULT = null;
        public static final BindCore LITTLE_CORE = null;

        static {
            BindCore r10 = new BindCore("DEFAULT", 0);
            DEFAULT = r10;
            BindCore r11 = new BindCore("BIG_CORE", 1);
            BIG_CORE = r11;
            BindCore r12 = new BindCore("LITTLE_CORE", 2);
            LITTLE_CORE = r12;
            BindCore r13 = new BindCore("CANCEL_BIND", 3);
            CANCEL_BIND = r13;
            $VALUES = new BindCore[]{r10, r11, r12, r13};
        }

        private BindCore(String r10, int r11) {
            super(r10, r11);
        }

        public static BindCore valueOf(String r10) {
            return (BindCore) Enum.valueOf(BindCore.class, r10);
        }

        public static BindCore[] values() {
            return (BindCore[]) $VALUES.clone();
        }
    }

    public interface Callback {
        void bindBigCore(int r10);

        void bindLittleCore(int r10);

        void resetCoreBind(int r10);
    }

    public static class ThreadConfigInfo {
        private BindCore mBindCore;
        private int mThreadPriority;
        private ThreadType mThreadType;

        public ThreadConfigInfo() {
            this.mThreadPriority = 20;
        }

        @CalledByNative
        public int getThreadPriority() {
            return this.mThreadPriority;
        }

        @CalledByNative
        public int getThreadType() {
            return this.mThreadType.ordinal();
        }

        public void setThreadPriority(int r10) {
            this.mThreadPriority = r10;
        }

        public void setThreadType(ThreadType r10) {
            this.mThreadType = r10;
        }
    }

    public static final enum ThreadType extends Enum<ThreadType> {
        private static final /* synthetic */ ThreadType[] $VALUES = null;
        public static final ThreadType FILE_THREAD = null;
        public static final ThreadType INIT_THREAD = null;
        public static final ThreadType NETWORK_THREAD = null;

        static {
            ThreadType r10 = new ThreadType("INIT_THREAD", 0);
            INIT_THREAD = r10;
            ThreadType r11 = new ThreadType("NETWORK_THREAD", 1);
            NETWORK_THREAD = r11;
            ThreadType r12 = new ThreadType("FILE_THREAD", 2);
            FILE_THREAD = r12;
            $VALUES = new ThreadType[]{r10, r11, r12};
        }

        private ThreadType(String r10, int r11) {
            super(r10, r11);
        }

        public static ThreadType valueOf(String r10) {
            return (ThreadType) Enum.valueOf(ThreadType.class, r10);
        }

        public static ThreadType[] values() {
            return (ThreadType[]) $VALUES.clone();
        }
    }

    public TTThreadConfigInfoProvider() {
    }
}
