package com.bytedance.android.live.base.api.push;

import com.bytedance.android.live.broadcast.api.gamepromote.GamePromoteDataContext;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public interface ILivePush {

    public static final enum ClickType extends Enum<ClickType> {
        public static final ClickType CLOSE = null;
        public static final ClickType LIVE = null;
        public static final /* synthetic */ ClickType[] a = null;
        private final String value;

        static {
            ClickType r0 = new ClickType("LIVE", 0, GamePromoteDataContext.LIVE);
            LIVE = r0;
            ClickType r1 = new ClickType("CLOSE", 1, "close");
            CLOSE = r1;
            a = new ClickType[]{r0, r1};
        }

        public static ClickType[] values() {
            return (ClickType[]) a.clone();
        }

        public final String getValue() {
            return this.value;
        }

        public static ClickType valueOf(String r1) {
            return (ClickType) a.a(ClickType.class, r1);
        }

        public ClickType(String r1, int r2, String r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public static final enum PushType extends Enum<PushType> {
        public static final PushType CLOD_LAUNCH = null;
        public static final PushType SELF_DRIVING = null;
        public static final PushType VIDEO = null;
        public static final /* synthetic */ PushType[] a = null;
        private final int value;

        static {
            PushType r0 = new PushType("SELF_DRIVING", 0, 1);
            SELF_DRIVING = r0;
            PushType r1 = new PushType("CLOD_LAUNCH", 1, 2);
            CLOD_LAUNCH = r1;
            PushType r4 = new PushType("VIDEO", 2, 3);
            VIDEO = r4;
            a = new PushType[]{r0, r1, r4};
        }

        public static PushType[] values() {
            return (PushType[]) a.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public static PushType valueOf(String r1) {
            return (PushType) a.a(PushType.class, r1);
        }

        public PushType(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }
}
