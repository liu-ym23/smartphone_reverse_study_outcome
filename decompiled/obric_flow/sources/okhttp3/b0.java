package okhttp3;

import com.lynx.serval.svg.SVGRenderEngine;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntProgression;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes3.dex */
public final class b0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList f20620a;

    public b0() {
        this.f20620a = new ArrayList(20);
    }

    public final void a(String r5, String r10) {
        Intrinsics.checkNotNullParameter(r5, "name");
        Intrinsics.checkNotNullParameter(r10, "value");
        z.b(r5);
        z.c(r10, r5);
        c(r5, r10);
    }

    public final void b(String r10) {
        Intrinsics.checkNotNullParameter(r10, SVGRenderEngine.LINE);
        int r5 = StringsKt.q(r10, ':', 1, 4);
        if (r5 == (-1)) goto L6;
        c(r10.substring(0, r5), r10.substring(r5 + 1));
        return;
    L6:
        if (r10.charAt(0) != ':') goto L8;
        c("", r10.substring(1));
        return;
    L8:
        c("", r10);
    }

    public final void c(String r5, String r10) {
        Intrinsics.checkNotNullParameter(r5, "name");
        Intrinsics.checkNotNullParameter(r10, "value");
        ArrayList r11 = this.f20620a;
        r11.add(r5);
        r11.add(StringsKt.trim(r10).toString());
    }

    public final c0 d() {
        Object[] r5 = this.f20620a.toArray(new String[0]);
        if (r5 == null) goto L7;
        return new c0((String[]) r5);
    L7:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    }

    public final String e(String r5) {
        Intrinsics.checkNotNullParameter(r5, "name");
        ArrayList r10 = this.f20620a;
        IntProgression r11 = RangesKt.step(RangesKt.downTo(r10.size() - 2, 0), 2);
        int r12 = r11.getFirst();
        int r13 = r11.getLast();
        int r14 = r11.getStep();
        if (r14 < 0) goto L6;
        if (r12 <= r13) goto L8;
        return null;
    L8:
        if (StringsKt.l(r5, (String) r10.get(r12)) == true) goto L10;
        if (r12 == r13) goto L19;
        r12 = r12 + r14;
        goto L8
    L19:
        return null;
    L10:
        return (String) r10.get(r12 + 1);
    L6:
        if (r12 >= r13) goto L8;
        return null;
    }

    public final void f(String r5) {
        Intrinsics.checkNotNullParameter(r5, "name");
        int r10 = 0;
    L3:
        ArrayList r11 = this.f20620a;
        if (r10 >= r11.size()) goto L9;
        if (StringsKt.l(r5, (String) r11.get(r10)) == false) goto L8;
        r11.remove(r10);
        r11.remove(r10);
        r10 = r10 - 2;
    L8:
        r10 = r10 + 2;
        goto L3
    }
}
