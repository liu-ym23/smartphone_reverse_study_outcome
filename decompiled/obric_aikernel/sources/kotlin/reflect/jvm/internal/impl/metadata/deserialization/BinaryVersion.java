package kotlin.reflect.jvm.internal.impl.metadata.deserialization;

import java.util.ArrayList;
import java.util.List;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public abstract class BinaryVersion {
    public static final Companion Companion = null;
    private final int major;
    private final int minor;
    private final int[] numbers;
    private final int patch;
    private final List<Integer> rest;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r10) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
    }

    public BinaryVersion(int... r10) {
        Intrinsics.checkNotNullParameter(r10, "numbers");
        this.numbers = r10;
        Integer r11 = ArraysKt.getOrNull(r10, 0);
        int r12 = -1;
        if (r11 == null) goto L5;
        int r13 = r11.intValue();
    L6:
        this.major = r13;
        Integer r14 = ArraysKt.getOrNull(r10, 1);
        if (r14 == null) goto L9;
        int r15 = r14.intValue();
    L10:
        this.minor = r15;
        Integer r16 = ArraysKt.getOrNull(r10, 2);
        if (r16 == null) goto L13;
        r12 = r16.intValue();
    L13:
        this.patch = r12;
        if (r10.length > 3) goto L16;
        List<Integer> r17 = CollectionsKt.emptyList();
    L21:
        this.rest = r17;
        return;
    L16:
        if (r10.length > 1024) goto L19;
        r17 = CollectionsKt.toList(ArraysKt.asList(r10).subList(3, r10.length));
        goto L21
    L19:
        throw new IllegalArgumentException("BinaryVersion with length more than 1024 are not supported. Provided length " + r10.length + '.');
    L9:
        r15 = -1;
        goto L10
    L5:
        r13 = -1;
        goto L6
    }

    public boolean equals(Object r10) {
        if (r10 != null) goto L4;
    L14:
        return false;
    L4:
        if (Intrinsics.areEqual(getClass(), r10.getClass()) == false) goto L14;
        BinaryVersion r11 = (BinaryVersion) r10;
        if (this.major != r11.major) goto L14;
        if (this.minor != r11.minor) goto L14;
        if (this.patch != r11.patch) goto L14;
        if (Intrinsics.areEqual(this.rest, r11.rest) == false) goto L14;
        return true;
    }

    public final int getMajor() {
        return this.major;
    }

    public final int getMinor() {
        return this.minor;
    }

    public int hashCode() {
        int r10 = this.major;
        int r11 = r10 + ((r10 * 31) + this.minor);
        int r12 = r11 + ((r11 * 31) + this.patch);
        return r12 + ((r12 * 31) + this.rest.hashCode());
    }

    public final boolean isAtLeast(int r10, int r11, int r12) {
        int r13 = this.major;
        if (r13 <= r10) goto L6;
        return true;
    L6:
        if (r13 >= r10) goto L8;
        return false;
    L8:
        int r14 = this.minor;
        if (r14 <= r11) goto L11;
        return true;
    L11:
        if (r14 >= r11) goto L14;
        return false;
    L14:
        if (this.patch < r12) goto L17;
        return true;
    L17:
        return false;
    }

    public final boolean isAtLeast(BinaryVersion r10) {
        Intrinsics.checkNotNullParameter(r10, "version");
        return isAtLeast(r10.major, r10.minor, r10.patch);
    }

    public final boolean isAtMost(int r10, int r11, int r12) {
        int r13 = this.major;
        if (r13 >= r10) goto L6;
        return true;
    L6:
        if (r13 <= r10) goto L8;
        return false;
    L8:
        int r14 = this.minor;
        if (r14 >= r11) goto L11;
        return true;
    L11:
        if (r14 <= r11) goto L14;
        return false;
    L14:
        if (this.patch > r12) goto L17;
        return true;
    L17:
        return false;
    }

    protected final boolean isCompatibleTo(BinaryVersion r10) {
        Intrinsics.checkNotNullParameter(r10, "ourVersion");
        int r11 = this.major;
        if (r11 != 0) goto L10;
        if (r10.major != 0) goto L15;
        if (this.minor != r10.minor) goto L15;
        return true;
    L15:
        return false;
    L10:
        if (r11 != r10.major) goto L15;
        if (this.minor > r10.minor) goto L15;
        return true;
    }

    public final int[] toArray() {
        return this.numbers;
    }

    public String toString() {
        int[] r10 = toArray();
        ArrayList r11 = new ArrayList();
        int r12 = r10.length;
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L12;
        int r14 = r10[r13];
        if (r14 == (-1)) goto L7;
        boolean r15 = true;
    L8:
        if (r15 == false) goto L12;
        r11.add(Integer.valueOf(r14));
        r13 = r13 + 1;
        goto L3
    L7:
        r15 = false;
    L12:
        if (r11.isEmpty() == false) goto L15;
        return "unknown";
    L15:
        return CollectionsKt.joinToString$default(r11, ".", null, null, 0, null, null, 62, null);
    }
}
