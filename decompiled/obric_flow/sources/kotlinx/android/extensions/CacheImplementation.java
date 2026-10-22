package kotlinx.android.extensions;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import vt.a;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u0000 \u00022\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lkotlinx/android/extensions/CacheImplementation;", "", "Companion", "vt/a", "SPARSE_ARRAY", "HASH_MAP", "NO_CACHE", "kotlin-android-extensions-runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final enum CacheImplementation extends Enum<CacheImplementation> {
    public static final a Companion = null;
    public static final CacheImplementation HASH_MAP = null;
    public static final CacheImplementation NO_CACHE = null;
    public static final CacheImplementation SPARSE_ARRAY = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final CacheImplementation f18764a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ CacheImplementation[] f18765b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f18766c = null;

    static {
        CacheImplementation r5 = new CacheImplementation("SPARSE_ARRAY", 0);
        SPARSE_ARRAY = r5;
        CacheImplementation r10 = new CacheImplementation("HASH_MAP", 1);
        HASH_MAP = r10;
        CacheImplementation r11 = new CacheImplementation("NO_CACHE", 2);
        NO_CACHE = r11;
        CacheImplementation[] r12 = {r5, r10, r11};
        f18765b = r12;
        f18766c = EnumEntriesKt.enumEntries(r12);
        Companion = new a();
        f18764a = r10;
    }

    public static final /* synthetic */ CacheImplementation access$getDEFAULT$cp() {
        return f18764a;
    }

    public static EnumEntries<CacheImplementation> getEntries() {
        return f18766c;
    }

    public static CacheImplementation valueOf(String r5) {
        return (CacheImplementation) Enum.valueOf(CacheImplementation.class, r5);
    }

    public static CacheImplementation[] values() {
        return (CacheImplementation[]) f18765b.clone();
    }
}
