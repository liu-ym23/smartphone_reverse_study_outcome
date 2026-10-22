package com.bytedance.frameworks.baselib.network.http.cronet;

/* JADX INFO: loaded from: classes.dex */
public class TTNetThreadConfig {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ThreadType f1608a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f1609b;

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

    public interface a {
        void bindBigCore(int r10);

        void bindLittleCore(int r10);

        void resetCoreBind(int r10);
    }

    public TTNetThreadConfig() {
        this.f1609b = 20;
    }
}
