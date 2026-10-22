package com.google.gson;

/* JADX INFO: loaded from: classes2.dex */
public interface ReflectionAccessFilter {
    public static final ReflectionAccessFilter BLOCK_ALL_ANDROID = null;
    public static final ReflectionAccessFilter BLOCK_ALL_JAVA = null;
    public static final ReflectionAccessFilter BLOCK_ALL_PLATFORM = null;
    public static final ReflectionAccessFilter BLOCK_INACCESSIBLE_JAVA = null;

    public static final enum FilterResult extends Enum<FilterResult> {
        private static final /* synthetic */ FilterResult[] $VALUES = null;
        public static final FilterResult ALLOW = null;
        public static final FilterResult BLOCK_ALL = null;
        public static final FilterResult BLOCK_INACCESSIBLE = null;
        public static final FilterResult INDECISIVE = null;

        private static /* synthetic */ FilterResult[] $values() {
            return new FilterResult[]{ALLOW, INDECISIVE, BLOCK_INACCESSIBLE, BLOCK_ALL};
        }

        static {
            ALLOW = new FilterResult("ALLOW", 0);
            INDECISIVE = new FilterResult("INDECISIVE", 1);
            BLOCK_INACCESSIBLE = new FilterResult("BLOCK_INACCESSIBLE", 2);
            BLOCK_ALL = new FilterResult("BLOCK_ALL", 3);
            $VALUES = $values();
        }

        private FilterResult(String r5, int r10) {
            super(r5, r10);
        }

        public static FilterResult valueOf(String r5) {
            return (FilterResult) Enum.valueOf(FilterResult.class, r5);
        }

        public static FilterResult[] values() {
            return (FilterResult[]) $VALUES.clone();
        }
    }

    static {
        BLOCK_INACCESSIBLE_JAVA = new AnonymousClass1();
        BLOCK_ALL_JAVA = new AnonymousClass2();
        BLOCK_ALL_ANDROID = new AnonymousClass3();
        BLOCK_ALL_PLATFORM = new AnonymousClass4();
    }

    FilterResult check(Class<?> r5);
}
