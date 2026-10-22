package okhttp3;

import java.nio.charset.Charset;
import java.util.regex.Pattern;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntProgression;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes3.dex */
public final class h0 {
    public static final Pattern e = null;
    public static final Pattern f = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f20657a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f20658b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f20659c;
    public final String[] d;

    static {
        e = Pattern.compile("([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)/([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)");
        f = Pattern.compile(";\\s*(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)=(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)|\"([^\"]*)\"))?");
    }

    public h0(String r5, String r10, String r11, String[] r12) {
        this.f20657a = r5;
        this.f20658b = r10;
        this.f20659c = r11;
        this.d = r12;
    }

    public final Charset a(Charset r10) {
        Intrinsics.checkNotNullParameter("charset", "name");
        String[] r5 = this.d;
        IntProgression r11 = RangesKt.step(ArraysKt.getIndices(r5), 2);
        int r12 = r11.getFirst();
        int r13 = r11.getLast();
        int r14 = r11.getStep();
        if (r14 < 0) goto L6;
        if (r12 <= r13) goto L8;
    L12:
        String r15 = null;
    L13:
        if (r15 == null) goto L22;
        return Charset.forName(r15);
    L23:
        return r10;
    L22:
        return r10;
    L8:
        if (StringsKt.l(r5[r12], "charset") == true) goto L9;
        if (r12 == r13) goto L12;
        r12 = r12 + r14;
        goto L8
    L9:
        r15 = r5[r12 + 1];
        goto L13
    L6:
        if (r12 < r13) goto L12;
        goto L12
    }

    public final boolean equals(Object r5) {
        if ((r5 instanceof h0) == true) goto L5;
    L7:
        return false;
    L5:
        if (Intrinsics.areEqual(((h0) r5).f20657a, this.f20657a) == false) goto L7;
        return true;
    }

    public final int hashCode() {
        return this.f20657a.hashCode();
    }

    public final String toString() {
        return this.f20657a;
    }
}
