package com.larus.bmhome.block.holder.deepthink;

import android.content.Context;
import android.graphics.RectF;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.bmhome.chat.deepresearch.view.e1;
import com.larus.bmhome.utils.z3;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.block.Block;
import com.obric.assistant.spi.complextask.ComplexTaskDelegate;
import kotlin.jvm.internal.Intrinsics;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class a0 extends jc8.b<gb8.i> {
    public e1 d;

    @Override // jc8.b
    public final String c() {
        return "DeepThinkTextBlockHolder";
    }

    @Override // jc8.b
    public final void i() {
    }

    public a0() {
    }

    @Override // jc8.b
    public final jc8.d f(jc8.a r2) {
        Intrinsics.checkNotNullParameter((gb8.i) r2, "blockModel");
        return new jc8.d(0, 0, 0, 0);
    }

    @Override // jc8.b
    public final void g(jc8.a r25) {
        gb8.i r1 = (gb8.i) r25;
        Intrinsics.checkNotNullParameter(r1, "blockModel");
        Intrinsics.checkNotNullParameter(r1, "blockModel");
        e1 r3 = this.d;
        if (r3 == null) goto L57;
        Message r4 = r1.j();
        tb8.a r2 = (tb8.a) jc8.c.a(this, tb8.a.class);
        if (r2 != null) goto L8;
        r2 = new tb8.a(null, null, null, null, false, null, 63);
    L8:
        tb8.a r6 = r2;
        Block r5 = r1.a;
        jc8.d r7 = jc8.e.d(r1);
        ComplexTaskDelegate r8 = ComplexTaskDelegate.b;
        boolean r9 = true;
        if (r8.f(r4) == true) goto L11;
    L13:
        boolean r10 = false;
    L15:
        if (com.larus.bmhome.chat.bean.d.e0(r4) == false) goto L17;
    L21:
        boolean r12 = false;
    L23:
        if (r6.e == true) goto L25;
    L28:
        boolean r13 = false;
    L29:
        fh8.l r11 = new fh8.l(r12, r13, "deep_thinking_block_" + r5.getBlockId(), true, r4.getMessageId() + "-deepThink-" + r5.getBlockId(), false, false, false, false, null, null, 4064);
        jc8.k r14 = this.a;
        Integer r15 = null;
        if (r14 == null) goto L32;
        kc8.b r16 = (kc8.b) r14.a(kc8.b.class);
    L33:
        Context r17 = r3.getContext();
        if (r16 == null) goto L38;
        kc8.y r18 = r16.a;
        if (r18 == null) goto L38;
        boolean r19 = r18.a();
    L39:
        if (r16 == null) goto L43;
        kc8.y r110 = r16.a;
        if (r110 == null) goto L43;
        RecyclerView.Adapter<?> r111 = r110.w;
    L44:
        if (r111 != null) goto L47;
        r9 = false;
    L47:
        if (r16 == null) goto L51;
        kc8.y r20 = r16.a;
        if (r20 == null) goto L51;
        r15 = r20.j;
    L51:
        Intrinsics.checkNotNullParameter(r17, "context");
        fh8.t.a r21 = new fh8.t.a();
        r21.a = ContextCompat.getColor(r17, v19.c.b(2130972082, r17, 2131103146));
        r21.b = i5.o();
        r21.c = i5.E();
        r21.d = r19;
        r21.e = r9;
        r21.f = r15;
        r21.i = new RectF(r7.a, r7.b, r7.c, r7.d);
        r21.g = false;
        fh8.t r22 = r21.a();
        kc8.b r23 = (kc8.b) jc8.c.a(this, kc8.b.class);
        if (r23 == null) goto L54;
        fh8.f r24 = z3.a(r23, r1.j()).a();
    L55:
        r3.d(r4, r5, r6, r22, r11, r24);
        return;
    L54:
        r24 = new fh8.f(0);
    L43:
        r111 = null;
    L38:
        r19 = false;
        goto L39
    L32:
        r16 = null;
        goto L33
    L25:
        if (r1.n() == false) goto L28;
        if (r10 == true) goto L28;
        r13 = true;
        goto L29
    L17:
        if (r4.getMessageStatusLocal() != 23) goto L19;
    L20:
        r12 = true;
        goto L23
    L19:
        if (r4.getMessageStatusLocal() != 22) goto L21;
    L11:
        if (r8.i(r4, r1.a) == false) goto L13;
        r10 = true;
        goto L15
    }

    @Override // jc8.b
    public final View h(ViewGroup r2) {
        Intrinsics.checkNotNullParameter(r2, "viewGroup");
        e1 r0 = new e1(r2.getContext());
        this.d = r0;
        return r0;
    }
}
