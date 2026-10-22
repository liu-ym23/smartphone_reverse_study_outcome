package kotlin.reflect.jvm.internal.impl.metadata.deserialization;

import com.ss.android.ugc.effectmanager.EffectConfiguration;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
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

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
    }

    public int hashCode() {
        int r0 = this.major;
        int r1 = r0 + ((r0 * 31) + this.minor);
        int r2 = r1 + ((r1 * 31) + this.patch);
        return r2 + ((r2 * 31) + this.rest.hashCode());
    }

    public String toString() {
        int[] r0 = toArray();
        ArrayList r1 = new ArrayList();
        int r2 = r0.length;
        int r4 = 0;
    L3:
        if (r4 >= r2) goto L12;
        int r5 = r0[r4];
        if (r5 == (-1)) goto L7;
        boolean r6 = true;
    L8:
        if (r6 == false) goto L12;
        r1.add(Integer.valueOf(r5));
        r4 = r4 + 1;
        goto L3
    L7:
        r6 = false;
    L12:
        if (r1.isEmpty() == false) goto L15;
        return "unknown";
    L15:
        return CollectionsKt.joinToString$default(r1, ".", null, null, 0, null, null, 62, null);
    }

    public final int getMajor() {
        return this.major;
    }

    public final int getMinor() {
        return this.minor;
    }

    public final int[] toArray() {
        return this.numbers;
    }

    public BinaryVersion(int... r4) {
        Intrinsics.checkNotNullParameter(r4, "numbers");
        this.numbers = r4;
        Integer r0 = ArraysKt.getOrNull(r4, 0);
        int r1 = -1;
        if (r0 == null) goto L5;
        int r2 = r0.intValue();
    L6:
        this.major = r2;
        Integer r3 = ArraysKt.getOrNull(r4, 1);
        if (r3 == null) goto L9;
        int r5 = r3.intValue();
    L10:
        this.minor = r5;
        Integer r6 = ArraysKt.getOrNull(r4, 2);
        if (r6 == null) goto L13;
        r1 = r6.intValue();
    L13:
        this.patch = r1;
        if (r4.length > 3) goto L16;
        List<Integer> r7 = CollectionsKt.emptyList();
    L21:
        this.rest = r7;
        return;
    L16:
        if (r4.length > 1024) goto L19;
        r7 = CollectionsKt.toList(ArraysKt.asList(r4).subList(3, r4.length));
        goto L21
    L19:
        throw new IllegalArgumentException("BinaryVersion with length more than 1024 are not supported. Provided length " + r4.length + '.');
    L9:
        r5 = -1;
        goto L10
    L5:
        r2 = -1;
        goto L6
    }

    public boolean equals(Object r3) {
        if (r3 != null) goto L4;
    L14:
        return false;
    L4:
        if (Intrinsics.areEqual(getClass(), r3.getClass()) == false) goto L14;
        BinaryVersion r4 = (BinaryVersion) r3;
        if (this.major != r4.major) goto L14;
        if (this.minor != r4.minor) goto L14;
        if (this.patch != r4.patch) goto L14;
        if (Intrinsics.areEqual(this.rest, r4.rest) == false) goto L14;
        return true;
    }

    public final boolean isAtLeast(BinaryVersion r3) {
        Intrinsics.checkNotNullParameter(r3, EffectConfiguration.KEY_VERSION);
        return isAtLeast(r3.major, r3.minor, r3.patch);
    }

    public final boolean isCompatibleTo(BinaryVersion r5) {
        Intrinsics.checkNotNullParameter(r5, "ourVersion");
        int r0 = this.major;
        if (r0 != 0) goto L10;
        if (r5.major == 0) goto L7;
    L14:
        return false;
    L7:
        if (this.minor != r5.minor) goto L14;
        return true;
    L10:
        if (r0 != r5.major) goto L14;
        if (this.minor > r5.minor) goto L14;
        return true;
    }

    public final boolean isAtLeast(int r4, int r5, int r6) {
        int r0 = this.major;
        if (r0 <= r4) goto L6;
        return true;
    L6:
        if (r0 >= r4) goto L8;
        return false;
    L8:
        int r7 = this.minor;
        if (r7 <= r5) goto L11;
        return true;
    L11:
        if (r7 >= r5) goto L14;
        return false;
    L14:
        if (this.patch >= r6) goto L18;
        return false;
    L18:
        return true;
    }

    public final boolean isAtMost(int r4, int r5, int r6) {
        int r0 = this.major;
        if (r0 >= r4) goto L6;
        return true;
    L6:
        if (r0 <= r4) goto L8;
        return false;
    L8:
        int r7 = this.minor;
        if (r7 >= r5) goto L11;
        return true;
    L11:
        if (r7 <= r5) goto L14;
        return false;
    L14:
        if (this.patch <= r6) goto L18;
        return false;
    L18:
        return true;
    }
}
