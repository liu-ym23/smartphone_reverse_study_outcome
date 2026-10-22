package com.bytedance.frameworks.baselib.network.dispatcher;

/* JADX INFO: loaded from: classes.dex */
public interface IRequest {

    public static final enum Priority extends Enum<Priority> {
        private static final /* synthetic */ Priority[] $VALUES = null;
        public static final Priority HIGH = null;
        public static final Priority IMMEDIATE = null;
        public static final Priority LOW = null;
        public static final Priority LOWEST = null;
        public static final Priority NORMAL = null;

        static {
            Priority r10 = new Priority("LOWEST", 0);
            LOWEST = r10;
            Priority r11 = new Priority("LOW", 1);
            LOW = r11;
            Priority r12 = new Priority("NORMAL", 2);
            NORMAL = r12;
            Priority r13 = new Priority("HIGH", 3);
            HIGH = r13;
            Priority r14 = new Priority("IMMEDIATE", 4);
            IMMEDIATE = r14;
            $VALUES = new Priority[]{r10, r11, r12, r13, r14};
        }

        private Priority(String r10, int r11) {
            super(r10, r11);
        }

        public static Priority valueOf(String r10) {
            return (Priority) Enum.valueOf(Priority.class, r10);
        }

        public static Priority[] values() {
            return (Priority[]) $VALUES.clone();
        }
    }

    Priority a();

    int b();
}
