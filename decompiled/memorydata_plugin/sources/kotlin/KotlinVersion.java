package kotlin;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00172\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0017B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\u0011\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u0000H\u0096\u0002J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u000e\u001a\u0004\u0018\u00010\u0011H\u0096\u0002J\b\u0010\u0012\u001a\u00020\u0003H\u0016J\u0016\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003J\u001e\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0003J\b\u0010\u0014\u001a\u00020\u0015H\u0016J \u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0003H\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u000e\u0010\f\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lkotlin/KotlinVersion;", "", "major", "", "minor", "(II)V", "patch", "(III)V", "getMajor", "()I", "getMinor", "getPatch", "version", "compareTo", "other", "equals", "", "", "hashCode", "isAtLeast", "toString", "", "versionOf", "Companion", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class KotlinVersion implements Comparable<KotlinVersion> {
    public static final KotlinVersion CURRENT = null;
    public static final Companion Companion = null;
    public static final int MAX_COMPONENT_VALUE = 255;
    private final int major;
    private final int minor;
    private final int patch;
    private final int version;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lkotlin/KotlinVersion$Companion;", "", "()V", "CURRENT", "Lkotlin/KotlinVersion;", "MAX_COMPONENT_VALUE", "", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
        CURRENT = KotlinVersionCurrentValue.get();
    }

    public KotlinVersion(int r2, int r3) {
        this(r2, r3, 0);
    }

    public KotlinVersion(int r1, int r2, int r3) {
        this.major = r1;
        this.minor = r2;
        this.patch = r3;
        this.version = versionOf(r1, r2, r3);
    }

    private final int versionOf(int r4, int r5, int r6) {
        boolean r0 = true;
        if (r4 < 0) goto L6;
        if (r4 >= 256) goto L6;
        boolean r2 = true;
    L7:
        if (r2 == false) goto L19;
        if (r5 < 0) goto L11;
        if (r5 >= 256) goto L11;
        boolean r3 = true;
    L12:
        if (r3 == false) goto L19;
        if (r6 < 0) goto L16;
        if (r6 >= 256) goto L16;
        boolean r7 = true;
    L17:
        if (r7 == false) goto L19;
    L20:
        if (r0 == false) goto L24;
        return ((r4 << 16) + (r5 << 8)) + r6;
    L24:
        throw new IllegalArgumentException(("Version components are out of range: " + r4 + '.' + r5 + '.' + r6).toString());
    L16:
        r7 = false;
    L11:
        r3 = false;
    L19:
        r0 = false;
    L6:
        r2 = false;
        goto L7
    }

    @Override // java.lang.Comparable
    public /* synthetic */ int compareTo(KotlinVersion r3) {
        return compareTo2((KotlinVersion) ZeusTransformUtils.preCheckCast(r3, KotlinVersion.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
    public int compareTo2(KotlinVersion r2) {
        Intrinsics.checkNotNullParameter(r2, "other");
        return this.version - r2.version;
    }

    public boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r4, KotlinVersion.class) == false) goto L8;
        KotlinVersion r5 = (KotlinVersion) ZeusTransformUtils.preCheckCast(r4, KotlinVersion.class, "com.obric.memorydata.plugin");
    L10:
        if (r5 != null) goto L13;
        return false;
    L13:
        if (this.version != r5.version) goto L16;
        return true;
    L16:
        return false;
    L8:
        r5 = null;
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

    public final boolean isAtLeast(int r2, int r3) {
        int r0 = this.major;
        if (r0 > r2) goto L9;
        if (r0 == r2) goto L6;
    L8:
        return false;
    L6:
        if (this.minor < r3) goto L8;
    L9:
        return true;
    }

    public final boolean isAtLeast(int r2, int r3, int r4) {
        int r0 = this.major;
        if (r0 > r2) goto L12;
        if (r0 != r2) goto L11;
        int r5 = this.minor;
        if (r5 > r3) goto L12;
        if (r5 != r3) goto L11;
        if (this.patch >= r4) goto L12;
    L11:
        return false;
    L12:
        return true;
    }

    public String toString() {
        return new StringBuilder().append(this.major).append('.').append(this.minor).append('.').append(this.patch).toString();
    }
}
