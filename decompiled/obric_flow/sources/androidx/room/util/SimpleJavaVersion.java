package androidx.room.util;

import ai.j0;
import androidx.room.jarjarred.org.antlr.runtime.a;
import com.ivy.ivykit.api.plugin.IIvyAIPackageResourceService;
import java.util.Comparator;
import java.util.List;
import kotlin.Metadata;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 \u001a2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u001aB!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0006J\u0011\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u0000H\u0096\u0002J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000bJ.\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u0013J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u000e\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000b¨\u0006\u001b"}, d2 = {"Landroidx/room/util/SimpleJavaVersion;", "", "major", "", "minor", "update", "(IILjava/lang/Integer;)V", "getMajor", "()I", "getMinor", "getUpdate", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "compareTo", "other", "component1", "component2", "component3", "copy", "(IILjava/lang/Integer;)Landroidx/room/util/SimpleJavaVersion;", "equals", "", "", "hashCode", "toString", "", "Companion", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class SimpleJavaVersion implements Comparable<SimpleJavaVersion> {
    public static final Companion Companion = null;
    private static final SimpleJavaVersion VERSION_11_0_0 = null;
    private static final SimpleJavaVersion VERSION_1_8_0_202 = null;
    private final int major;
    private final int minor;
    private final Integer update;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\t\u001a\u0004\u0018\u00010\u0004J\u000e\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\fJ\u0012\u0010\r\u001a\u0004\u0018\u00010\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\fJ\f\u0010\u000e\u001a\u00020\f*\u00020\fH\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006¨\u0006\u000f"}, d2 = {"Landroidx/room/util/SimpleJavaVersion$Companion;", "", "()V", "VERSION_11_0_0", "Landroidx/room/util/SimpleJavaVersion;", "getVERSION_11_0_0", "()Landroidx/room/util/SimpleJavaVersion;", "VERSION_1_8_0_202", "getVERSION_1_8_0_202", "getCurrentVersion", "parse", "version", "", "tryParse", "substringBeforeNonDigitChar", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r5) {
            this();
        }

        private final String substringBeforeNonDigitChar(String r5) {
            int r10 = r5.length();
            int r11 = 0;
        L4:
            if (r11 >= r10) goto L9;
            if (Character.isDigit(r5.charAt(r11)) == false) goto L10;
            r11 = r11 + 1;
        L10:
            if (r11 != (-1)) goto L13;
            return r5;
        L13:
            return r5.substring(0, r11);
        L9:
            r11 = -1;
            goto L10
        }

        public final SimpleJavaVersion getCurrentVersion() {
            return tryParse(System.getProperty("java.runtime.version"));
        }

        public final SimpleJavaVersion getVERSION_11_0_0() {
            return SimpleJavaVersion.access$getVERSION_11_0_0$cp();
        }

        public final SimpleJavaVersion getVERSION_1_8_0_202() {
            return SimpleJavaVersion.access$getVERSION_1_8_0_202$cp();
        }

        public final SimpleJavaVersion parse(String r5) {
            Intrinsics.checkNotNullParameter(r5, "version");
            SimpleJavaVersion r10 = tryParse(r5);
            if (r10 == null) goto L6;
            return r10;
        L6:
            throw new IllegalArgumentException(j0.C("Unable to parse Java version ", r5));
        }

        public final SimpleJavaVersion tryParse(String r10) {
            if (r10 != null) goto L5;
            return null;
        L5:
            List r11 = StringsKt.J(r10, new char[]{'.'}, 0, 6);
            if (r11.size() != 1) goto L11;
            return new SimpleJavaVersion(Integer.parseInt(substringBeforeNonDigitChar((String) r11.get(0))), 0, null, 4, null);
        L33:
            return null;
        L11:
            if (Intrinsics.areEqual(r11.get(0), IIvyAIPackageResourceService.SHOULD_INTERCEPT_REQUEST) == true) goto L13;
            return new SimpleJavaVersion(Integer.parseInt((String) r11.get(0)), Integer.parseInt(substringBeforeNonDigitChar((String) r11.get(1))), null, 4, null);
        L35:
            return null;
        L13:
            if (r11.size() >= 3) goto L15;
            return null;
        L15:
            String r12 = (String) r11.get(1);
            List r13 = StringsKt.J(StringsKt.W((String) r11.get(2), '-'), new char[]{'_'}, 0, 6);
            if (r13.size() == 2) goto L31;
            return null;
        L31:
            return new SimpleJavaVersion(Integer.parseInt(r12), Integer.parseInt((String) r13.get(0)), Integer.valueOf(Integer.parseInt((String) r13.get(1))));
        L34:
            return null;
        }

        private Companion() {
        }
    }

    static {
        Companion r5 = new Companion(null);
        Companion = r5;
        VERSION_11_0_0 = r5.parse("11.0.0");
        VERSION_1_8_0_202 = r5.parse("1.8.0_202");
    }

    public SimpleJavaVersion(int r5, int r10, Integer r11) {
        this.major = r5;
        this.minor = r10;
        this.update = r11;
    }

    public static final /* synthetic */ SimpleJavaVersion access$getVERSION_11_0_0$cp() {
        return VERSION_11_0_0;
    }

    public static final /* synthetic */ SimpleJavaVersion access$getVERSION_1_8_0_202$cp() {
        return VERSION_1_8_0_202;
    }

    public static /* synthetic */ SimpleJavaVersion copy$default(SimpleJavaVersion r5, int r10, int r11, Integer r12, int r13, Object r14) {
        if ((r13 & 1) == 0) goto L6;
        r10 = r5.major;
    L6:
        if ((r13 & 2) == 0) goto L9;
        r11 = r5.minor;
    L9:
        if ((r13 & 4) == 0) goto L12;
        r12 = r5.update;
    L12:
        return r5.copy(r10, r11, r12);
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(SimpleJavaVersion r5) {
        return compareTo2(r5);
    }

    public final int component1() {
        return this.major;
    }

    public final int component2() {
        return this.minor;
    }

    public final Integer component3() {
        return this.update;
    }

    public final SimpleJavaVersion copy(int r5, int r10, Integer r11) {
        return new SimpleJavaVersion(r5, r10, r11);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof SimpleJavaVersion) == true) goto L8;
        return false;
    L8:
        SimpleJavaVersion r10 = (SimpleJavaVersion) r5;
        if (this.major == r10.major) goto L12;
        return false;
    L12:
        if (this.minor == r10.minor) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.update, r10.update) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int getMajor() {
        return this.major;
    }

    public final int getMinor() {
        return this.minor;
    }

    public final Integer getUpdate() {
        return this.update;
    }

    public int hashCode() {
        int r5 = Integer.hashCode(this.major) * 31;
        int r10 = a.c(this.minor, r5, 31);
        Integer r11 = this.update;
        if (r11 != null) goto L5;
        int r12 = 0;
    L7:
        return r10 + r12;
    L5:
        r12 = r11.hashCode();
        goto L7
    }

    public String toString() {
        int r5 = this.major;
        int r10 = this.minor;
        Integer r11 = this.update;
        StringBuilder r12 = j0.v("SimpleJavaVersion(major=", r5, r10, ", minor=", ", update=");
        r12.append(r11);
        r12.append(")");
        return r12.toString();
    }

    /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
    public int compareTo2(SimpleJavaVersion r5) {
        Intrinsics.checkNotNullParameter(r5, "other");
        final Comparator r10 = new SimpleJavaVersion$compareTo$$inlined$compareBy$1();
        final Comparator r11 = new SimpleJavaVersion$compareTo$$inlined$thenBy$1(r10);
        final Comparator r12 = ComparisonsKt.nullsFirst(ComparisonsKt.naturalOrder());
        return new SimpleJavaVersion$compareTo$$inlined$thenBy$2(r11, r12).compare(this, r5);
    }

    public /* synthetic */ SimpleJavaVersion(int r5, int r10, Integer r11, int r12, DefaultConstructorMarker r13) {
        if ((r12 & 4) == 0) goto L5;
        r11 = null;
    L5:
        this(r5, r10, r11);
    }
}
