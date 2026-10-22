package kotlinx.android.extensions;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0007B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\b"}, d2 = {"Lkotlinx/android/extensions/CacheImplementation;", "", "<init>", "(Ljava/lang/String;I)V", "SPARSE_ARRAY", "HASH_MAP", "NO_CACHE", "Companion", "kotlin-android-extensions-runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final enum CacheImplementation extends Enum<CacheImplementation> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ CacheImplementation[] $VALUES = null;
    public static final a Companion = null;
    private static final CacheImplementation DEFAULT = null;
    public static final CacheImplementation HASH_MAP = null;
    public static final CacheImplementation NO_CACHE = null;
    public static final CacheImplementation SPARSE_ARRAY = null;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lkotlinx/android/extensions/CacheImplementation$Companion;", "", "<init>", "()V", "DEFAULT", "Lkotlinx/android/extensions/CacheImplementation;", "getDEFAULT", "()Lkotlinx/android/extensions/CacheImplementation;", "kotlin-android-extensions-runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    private static final /* synthetic */ CacheImplementation[] $values() {
        return new CacheImplementation[]{SPARSE_ARRAY, HASH_MAP, NO_CACHE};
    }

    static {
        SPARSE_ARRAY = new CacheImplementation("SPARSE_ARRAY", 0);
        CacheImplementation r0 = new CacheImplementation("HASH_MAP", 1);
        HASH_MAP = r0;
        NO_CACHE = new CacheImplementation("NO_CACHE", 2);
        CacheImplementation[] r1 = $values();
        $VALUES = r1;
        $ENTRIES = EnumEntriesKt.enumEntries((Enum[]) ZeusTransformUtils.preCheckCast(r1, Enum[].class, "com.obric.memorydata.plugin"));
        Companion = new a(null);
        DEFAULT = r0;
    }

    private CacheImplementation(String r1, int r2) {
        super(r1, r2);
    }

    public static final /* synthetic */ CacheImplementation access$getDEFAULT$cp() {
        return DEFAULT;
    }

    public static EnumEntries<CacheImplementation> getEntries() {
        return $ENTRIES;
    }

    public static CacheImplementation valueOf(String r2) {
        return (CacheImplementation) ZeusTransformUtils.preCheckCast(Enum.valueOf(CacheImplementation.class, r2), CacheImplementation.class, "com.obric.memorydata.plugin");
    }

    public static CacheImplementation[] values() {
        return (CacheImplementation[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), CacheImplementation[].class, "com.obric.memorydata.plugin");
    }
}
