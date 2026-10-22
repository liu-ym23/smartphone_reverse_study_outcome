package kotlin.reflect.jvm.internal.impl.metadata.deserialization;

import ai.j0;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: loaded from: classes3.dex */
@SourceDebugExtension({"SMAP\nBinaryVersion.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BinaryVersion.kt\norg/jetbrains/kotlin/metadata/deserialization/BinaryVersion\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,101:1\n5306#2,7:102\n*S KotlinDebug\n*F\n+ 1 BinaryVersion.kt\norg/jetbrains/kotlin/metadata/deserialization/BinaryVersion\n*L\n73#1:102,7\n*E\n"})
public abstract class BinaryVersion {
    public static final Companion Companion = null;
    private final int major;
    private final int minor;
    private final int[] numbers;
    private final int patch;
    private final List<Integer> rest;

    @SourceDebugExtension({"SMAP\nBinaryVersion.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BinaryVersion.kt\norg/jetbrains/kotlin/metadata/deserialization/BinaryVersion$Companion\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,101:1\n1549#2:102\n1620#2,3:103\n37#3,2:106\n*S KotlinDebug\n*F\n+ 1 BinaryVersion.kt\norg/jetbrains/kotlin/metadata/deserialization/BinaryVersion$Companion\n*L\n97#1:102\n97#1:103,3\n98#1:106,2\n*E\n"})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r5) {
            this();
        }

        private Companion() {
        }
    }

    static {
        Companion = new Companion(null);
    }

    public BinaryVersion(int... r5) {
        Intrinsics.checkNotNullParameter(r5, "numbers");
        this.numbers = r5;
        Integer r10 = ArraysKt.getOrNull(r5, 0);
        int r11 = -1;
        if (r10 == null) goto L5;
        int r12 = r10.intValue();
    L6:
        this.major = r12;
        Integer r13 = ArraysKt.getOrNull(r5, 1);
        if (r13 == null) goto L9;
        int r14 = r13.intValue();
    L10:
        this.minor = r14;
        Integer r15 = ArraysKt.getOrNull(r5, 2);
        if (r15 == null) goto L13;
        r11 = r15.intValue();
    L13:
        this.patch = r11;
        if (r5.length > 3) goto L16;
        List<Integer> r16 = CollectionsKt.emptyList();
    L21:
        this.rest = r16;
        return;
    L16:
        if (r5.length > 1024) goto L19;
        r16 = CollectionsKt.toList(ArraysKt.asList(r5).subList(3, r5.length));
        goto L21
    L19:
        throw new IllegalArgumentException(j0.n(new StringBuilder("BinaryVersion with length more than 1024 are not supported. Provided length "), r5.length, '.'));
    L9:
        r14 = -1;
        goto L10
    L5:
        r12 = -1;
        goto L6
    }

    public boolean equals(Object r5) {
        if (r5 != null) goto L4;
    L14:
        return false;
    L4:
        if (Intrinsics.areEqual(getClass(), r5.getClass()) == false) goto L14;
        BinaryVersion r10 = (BinaryVersion) r5;
        if (this.major != r10.major) goto L14;
        if (this.minor != r10.minor) goto L14;
        if (this.patch != r10.patch) goto L14;
        if (Intrinsics.areEqual(this.rest, r10.rest) == false) goto L14;
        return true;
    }

    public final int getMajor() {
        return this.major;
    }

    public final int getMinor() {
        return this.minor;
    }

    public int hashCode() {
        int r5 = this.major;
        int r10 = ((r5 * 31) + this.minor) + r5;
        int r11 = ((r10 * 31) + this.patch) + r10;
        int r12 = this.rest.hashCode();
        return (r12 + (r11 * 31)) + r11;
    }

    public final boolean isAtLeast(BinaryVersion r5) {
        Intrinsics.checkNotNullParameter(r5, "version");
        return isAtLeast(r5.major, r5.minor, r5.patch);
    }

    public final boolean isAtMost(int r5, int r10, int r11) {
        int r12 = this.major;
        if (r12 >= r5) goto L6;
        return true;
    L6:
        if (r12 <= r5) goto L8;
        return false;
    L8:
        int r13 = this.minor;
        if (r13 >= r10) goto L11;
        return true;
    L11:
        if (r13 <= r10) goto L14;
        return false;
    L14:
        if (this.patch > r11) goto L17;
        return true;
    L17:
        return false;
    }

    public final boolean isCompatibleTo(BinaryVersion r5) {
        Intrinsics.checkNotNullParameter(r5, "ourVersion");
        int r10 = this.major;
        if (r10 != 0) goto L10;
        if (r5.major == 0) goto L7;
        return false;
    L7:
        if (this.minor == r5.minor) goto L16;
        return false;
    L16:
        return true;
    L10:
        if (r10 == r5.major) goto L12;
        return false;
    L12:
        if (this.minor <= r5.minor) goto L16;
        return false;
    }

    public final int[] toArray() {
        return this.numbers;
    }

    public String toString() {
        int[] r10 = toArray();
        ArrayList r5 = new ArrayList();
        int r11 = r10.length;
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L8;
        int r13 = r10[r12];
        if (r13 == (-1)) goto L8;
        r12 = j0.d(r13, r5, r12, 1);
    L8:
        if (r5.isEmpty() == false) goto L11;
        return "unknown";
    L11:
        return CollectionsKt.q(r5, ".", null, null, 0, null, null, 62);
    }

    public final boolean isAtLeast(int r5, int r10, int r11) {
        int r12 = this.major;
        if (r12 <= r5) goto L6;
        return true;
    L6:
        if (r12 >= r5) goto L8;
        return false;
    L8:
        int r13 = this.minor;
        if (r13 <= r10) goto L11;
        return true;
    L11:
        if (r13 >= r10) goto L14;
        return false;
    L14:
        if (this.patch < r11) goto L17;
        return true;
    L17:
        return false;
    }
}
