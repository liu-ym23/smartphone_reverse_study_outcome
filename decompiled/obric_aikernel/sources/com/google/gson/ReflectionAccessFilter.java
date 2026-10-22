package com.google.gson;

/* JADX INFO: loaded from: classes2.dex */
public interface ReflectionAccessFilter {

    public static final enum FilterResult extends Enum<FilterResult> {
        private static final /* synthetic */ FilterResult[] $VALUES = null;
        public static final FilterResult ALLOW = null;
        public static final FilterResult BLOCK_ALL = null;
        public static final FilterResult BLOCK_INACCESSIBLE = null;
        public static final FilterResult INDECISIVE = null;

        static {
            FilterResult r10 = new FilterResult("ALLOW", 0);
            ALLOW = r10;
            FilterResult r11 = new FilterResult("INDECISIVE", 1);
            INDECISIVE = r11;
            FilterResult r12 = new FilterResult("BLOCK_INACCESSIBLE", 2);
            BLOCK_INACCESSIBLE = r12;
            FilterResult r13 = new FilterResult("BLOCK_ALL", 3);
            BLOCK_ALL = r13;
            $VALUES = new FilterResult[]{r10, r11, r12, r13};
        }

        private FilterResult(String r10, int r11) {
            super(r10, r11);
        }

        public static FilterResult valueOf(String r10) {
            return (FilterResult) Enum.valueOf(FilterResult.class, r10);
        }

        public static FilterResult[] values() {
            return (FilterResult[]) $VALUES.clone();
        }
    }

    FilterResult a(Class<?> r10);
}
