package vw8;

import android.text.style.ForegroundColorSpan;
import kotlin.jvm.internal.Intrinsics;
import lsc.m;
import lsc.y;
import lw8.d;
import msc.s;
import org.commonmark.node.BlockQuote;
import uvc.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class a implements m.c<BlockQuote> {
    public final d a;

    public a(d r2) {
        Intrinsics.checkNotNullParameter(r2, "customMarkDownInfo");
        this.a = r2;
    }

    public final void a(m r8, b r9) {
        BlockQuote r10 = (BlockQuote) r9;
        Intrinsics.checkNotNullParameter(r8, "visitor");
        Intrinsics.checkNotNullParameter(r10, "blockQuote");
        r8.C(r10);
        int r0 = r8.length();
        r8.c(r10);
        lw8.a r1 = this.a.t;
        if (r1 == null) goto L7;
        Integer r2 = r1.f;
        if (r2 == null) goto L7;
        int r3 = r2.intValue();
        y r4 = r8.builder();
        r4.setSpan(new ForegroundColorSpan(r3), r0, r4.length(), 33);
    L7:
        s r5 = r8.B().a;
        lw8.a r6 = this.a.t;
        int r7 = 0;
        if (r6 == null) goto L12;
        Integer r11 = r6.d;
        if (r11 == null) goto L12;
        int r12 = r11.intValue();
    L13:
        lw8.a r13 = this.a.t;
        if (r13 == null) goto L18;
        Integer r14 = r13.e;
        if (r14 == null) goto L18;
        r7 = r14.intValue();
    L18:
        sw8.a r15 = new sw8.a(r5, r12, r7);
        y r16 = r8.builder();
        r16.setSpan(r15, r0, r16.length(), 33);
        r8.q(r10);
        return;
    L12:
        r12 = 0;
        goto L13
    }
}
