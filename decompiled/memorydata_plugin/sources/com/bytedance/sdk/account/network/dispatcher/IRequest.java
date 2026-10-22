package com.bytedance.sdk.account.network.dispatcher;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public interface IRequest {

    public static final enum Priority extends Enum<Priority> {
        private static final /* synthetic */ Priority[] $VALUES = null;
        public static final Priority HIGH = null;
        public static final Priority IMMEDIATE = null;
        public static final Priority LOW = null;
        public static final Priority NORMAL = null;

        static {
            Priority r0 = new Priority("LOW", 0);
            LOW = r0;
            Priority r1 = new Priority("NORMAL", 1);
            NORMAL = r1;
            Priority r3 = new Priority("HIGH", 2);
            HIGH = r3;
            Priority r5 = new Priority("IMMEDIATE", 3);
            IMMEDIATE = r5;
            $VALUES = new Priority[]{r0, r1, r3, r5};
        }

        private Priority(String r1, int r2) {
            super(r1, r2);
        }

        public static Priority valueOf(String r2) {
            return (Priority) ZeusTransformUtils.preCheckCast(Enum.valueOf(Priority.class, r2), Priority.class, "com.obric.memorydata.plugin");
        }

        public static Priority[] values() {
            return (Priority[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), Priority[].class, "com.obric.memorydata.plugin");
        }
    }

    Priority g();

    int h();
}
