package kotlin;

import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;

/* JADX INFO: loaded from: classes2.dex */
@SinceKotlin(version = "1.1")
public final class KotlinVersion implements Comparable<KotlinVersion> {

    @JvmField
    public static final KotlinVersion CURRENT = null;
    public static final Companion Companion = null;
    public static final int MAX_COMPONENT_VALUE = 255;
    private final int major;
    private final int minor;
    private final int patch;
    private final int version;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r10) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
        CURRENT = KotlinVersionCurrentValue.get();
    }

    public KotlinVersion(int r10, int r11) {
        this(r10, r11, 0);
    }

    public KotlinVersion(int r10, int r11, int r12) {
        this.major = r10;
        this.minor = r11;
        this.patch = r12;
        this.version = versionOf(r10, r11, r12);
    }

    private final int versionOf(int r10, int r11, int r12) {
        boolean r13 = false;
        if (new IntRange(0, 255).contains(r10) == true) goto L5;
    L9:
        if (r13 == false) goto L13;
        return ((r10 << 16) + (r11 << 8)) + r12;
    L13:
        throw new IllegalArgumentException(("Version components are out of range: " + r10 + '.' + r11 + '.' + r12).toString());
    L5:
        if (new IntRange(0, 255).contains(r11) == false) goto L9;
        if (new IntRange(0, 255).contains(r12) == false) goto L9;
        r13 = true;
        goto L9
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(KotlinVersion r10) {
        return compareTo2(r10);
    }

    /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
    public int compareTo2(KotlinVersion r10) {
        Intrinsics.checkNotNullParameter(r10, "other");
        return this.version - r10.version;
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof KotlinVersion) == false) goto L8;
        KotlinVersion r11 = (KotlinVersion) r10;
    L10:
        if (r11 != null) goto L13;
        return false;
    L13:
        if (this.version != r11.version) goto L16;
        return true;
    L16:
        return false;
    L8:
        r11 = null;
        goto L10
    }

    public final int getMajor() {
        return this.major;
    }

    public final int getMinor() {
        return this.minor;
    }

    public final int getPatch() {
        return this.patch;
    }

    public int hashCode() {
        return this.version;
    }

    public final boolean isAtLeast(int r10, int r11) {
        int r12 = this.major;
        if (r12 > r10) goto L9;
        if (r12 == r10) goto L6;
    L8:
        return false;
    L6:
        if (this.minor < r11) goto L8;
    L9:
        return true;
    }

    public final boolean isAtLeast(int r10, int r11, int r12) {
        int r13 = this.major;
        if (r13 > r10) goto L12;
        if (r13 != r10) goto L11;
        int r14 = this.minor;
        if (r14 > r11) goto L12;
        if (r14 != r11) goto L11;
        if (this.patch >= r12) goto L12;
    L11:
        return false;
    L12:
        return true;
    }

    public String toString() {
        StringBuilder r10 = new StringBuilder();
        r10.append(this.major);
        r10.append('.');
        r10.append(this.minor);
        r10.append('.');
        r10.append(this.patch);
        return r10.toString();
    }
}
