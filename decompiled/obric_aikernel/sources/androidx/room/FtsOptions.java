package androidx.room;

import androidx.annotation.RequiresApi;

/* JADX INFO: loaded from: classes.dex */
public final class FtsOptions {
    public static final FtsOptions INSTANCE = null;
    public static final String TOKENIZER_ICU = "icu";
    public static final String TOKENIZER_PORTER = "porter";
    public static final String TOKENIZER_SIMPLE = "simple";

    @RequiresApi(21)
    public static final String TOKENIZER_UNICODE61 = "unicode61";

    public static final enum MatchInfo extends Enum<MatchInfo> {
        private static final /* synthetic */ MatchInfo[] $VALUES = null;
        public static final MatchInfo FTS3 = null;
        public static final MatchInfo FTS4 = null;

        private static final /* synthetic */ MatchInfo[] $values() {
            return new MatchInfo[]{FTS3, FTS4};
        }

        static {
            FTS3 = new MatchInfo("FTS3", 0);
            FTS4 = new MatchInfo("FTS4", 1);
            $VALUES = $values();
        }

        private MatchInfo(String r10, int r11) {
            super(r10, r11);
        }

        public static MatchInfo valueOf(String r10) {
            return (MatchInfo) Enum.valueOf(MatchInfo.class, r10);
        }

        public static MatchInfo[] values() {
            return (MatchInfo[]) $VALUES.clone();
        }
    }

    public static final enum Order extends Enum<Order> {
        private static final /* synthetic */ Order[] $VALUES = null;
        public static final Order ASC = null;
        public static final Order DESC = null;

        private static final /* synthetic */ Order[] $values() {
            return new Order[]{ASC, DESC};
        }

        static {
            ASC = new Order("ASC", 0);
            DESC = new Order("DESC", 1);
            $VALUES = $values();
        }

        private Order(String r10, int r11) {
            super(r10, r11);
        }

        public static Order valueOf(String r10) {
            return (Order) Enum.valueOf(Order.class, r10);
        }

        public static Order[] values() {
            return (Order[]) $VALUES.clone();
        }
    }

    static {
        INSTANCE = new FtsOptions();
    }

    private FtsOptions() {
    }
}
