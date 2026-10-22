package androidx.room.jarjarred.kotlinx.metadata.internal.metadata.deserialization;

import ai.j0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0015\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0002\b&\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB\u0011\u0012\n\u0010\u0002\u001a\u00020\u0003\"\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0014\u001a\u00020\u0004H\u0016J\u001e\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0004J\u000e\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u0000J\u001e\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0004J\u000e\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u0000J\b\u0010\u0018\u001a\u00020\u0012H&J\u0010\u0010\u0019\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\u0000H\u0004J\u0006\u0010\u001b\u001a\u00020\u0003J\b\u0010\u001c\u001a\u00020\u001dH\u0016R\u0011\u0010\u0006\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u000b\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\bR\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00040\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001f"}, d2 = {"Landroidx/room/jarjarred/kotlinx/metadata/internal/metadata/deserialization/BinaryVersion;", "", "numbers", "", "", "([I)V", "major", "getMajor", "()I", "minor", "getMinor", "patch", "getPatch", "rest", "", "getRest", "()Ljava/util/List;", "equals", "", "other", "hashCode", "isAtLeast", "version", "isAtMost", "isCompatible", "isCompatibleTo", "ourVersion", "toArray", "toString", "", "Companion", "metadata"}, k = 1, mv = {1, 7, 1}, xi = 48)
public abstract class BinaryVersion {
    public static final Companion Companion = null;
    public static final int MAX_LENGTH = 1024;
    private static final int UNKNOWN = -1;
    private final int major;
    private final int minor;
    private final int[] numbers;
    private final int patch;
    private final List<Integer> rest;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\tH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Landroidx/room/jarjarred/kotlinx/metadata/internal/metadata/deserialization/BinaryVersion$Companion;", "", "()V", "MAX_LENGTH", "", "UNKNOWN", "parseVersionArray", "", "string", "", "metadata"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r5) {
            this();
        }

        @JvmStatic
        public final int[] parseVersionArray(String r5) {
            Intrinsics.checkNotNullParameter(r5, "string");
            List r10 = StringsKt.K(r5, new String[]{"."}, 0, 6);
            ArrayList r11 = new ArrayList(CollectionsKt.h(r10));
            Iterator r12 = r10.iterator();
        L4:
            if (r12.hasNext() == false) goto L10;
            Integer r13 = StringsKt.toIntOrNull((String) r12.next());
            if (r13 == null) goto L8;
            r11.add(r13);
            goto L4
        L8:
            return null;
        L10:
            Object[] r14 = r11.toArray(new Integer[0]);
            Intrinsics.checkNotNull(r14, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            return ArraysKt.toIntArray((Integer[]) r14);
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

    @JvmStatic
    public static final int[] parseVersionArray(String r5) {
        return Companion.parseVersionArray(r5);
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

    public final int getPatch() {
        return this.patch;
    }

    public final List<Integer> getRest() {
        return this.rest;
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

    public final boolean isAtMost(BinaryVersion r5) {
        Intrinsics.checkNotNullParameter(r5, "version");
        return isAtMost(r5.major, r5.minor, r5.patch);
    }

    public abstract boolean isCompatible();

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
}
