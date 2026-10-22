package kotlinx.android.extensions;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes3.dex */
public final enum CacheImplementation extends Enum<CacheImplementation> {
    private static final /* synthetic */ CacheImplementation[] $VALUES = null;
    public static final a Companion = null;
    private static final CacheImplementation DEFAULT = null;
    public static final CacheImplementation HASH_MAP = null;
    public static final CacheImplementation NO_CACHE = null;
    public static final CacheImplementation SPARSE_ARRAY = null;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }
    }

    private static final /* synthetic */ CacheImplementation[] $values() {
        return new CacheImplementation[]{SPARSE_ARRAY, HASH_MAP, NO_CACHE};
    }

    static {
        SPARSE_ARRAY = new CacheImplementation("SPARSE_ARRAY", 0);
        CacheImplementation r10 = new CacheImplementation("HASH_MAP", 1);
        HASH_MAP = r10;
        NO_CACHE = new CacheImplementation("NO_CACHE", 2);
        $VALUES = $values();
        Companion = new a(null);
        DEFAULT = r10;
    }

    private CacheImplementation(String r10, int r11) {
        super(r10, r11);
    }

    public static final /* synthetic */ CacheImplementation access$getDEFAULT$cp() {
        return DEFAULT;
    }

    public static CacheImplementation valueOf(String r10) {
        return (CacheImplementation) Enum.valueOf(CacheImplementation.class, r10);
    }

    public static CacheImplementation[] values() {
        return (CacheImplementation[]) $VALUES.clone();
    }
}
