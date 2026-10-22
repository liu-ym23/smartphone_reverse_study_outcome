package com.larus.uaigc.creation.gallery.providers;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.larus.bmhome.chat.api.q0;
import com.larus.bmhome.utils.c4;
import com.larus.gallery.impl.databinding.LarusGalleryChatTitleBinding;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.Message;
import com.larus.utils.e1;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import tx9.a4;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class y extends com.larus.chat.gallery.api.g<sz9.b> {
    public final jy9.x g;
    public final Lazy h;

    public final String B() {
        sz9.b r0 = (sz9.b) ((com.larus.gallery.api.t) this).d;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.j;
    }

    public final bb9.a C() {
        sz9.b r1 = (sz9.b) ((com.larus.gallery.api.t) this).d;
        if (r1 == null) goto L5;
        Message r2 = r1.a;
    L6:
        Function0<wc9.e> r3 = this.g.p;
        if (r3 == null) goto L10;
        wc9.e r4 = (wc9.e) r3.invoke();
        if (r4 == null) goto L10;
    L16:
        Function0<BotModel> r5 = this.g.o;
        if (r5 == null) goto L20;
        BotModel r6 = (BotModel) r5.invoke();
        if (r6 == null) goto L20;
    L27:
        return new bb9.a(r2, null, r4, r6);
    L20:
        q0.a r7 = this.g.b;
        if (r7 == null) goto L25;
        com.larus.bmhome.chat.component.cvs.y r8 = r7.u0();
        if (r8 == null) goto L25;
        r6 = r8.j0();
    L25:
        r6 = null;
    L10:
        q0.a r9 = this.g.b;
        if (r9 == null) goto L15;
        com.larus.bmhome.chat.component.cvs.y r10 = r9.u0();
        if (r10 == null) goto L15;
        r4 = r10.h();
    L15:
        r4 = null;
        goto L16
    L5:
        r2 = null;
        goto L6
    }

    public final by7.e D() {
        return this.g.i;
    }

    public final void E() {
        sz9.b r0 = (sz9.b) ((com.larus.gallery.api.t) this).d;
        String r1 = null;
        if (r0 == null) goto L5;
        zo8.e r2 = r0.d;
    L6:
        if (r2 == null) goto L36;
        if (r0 == null) goto L13;
        zo8.e r3 = r0.d;
        if (r3 == null) goto L13;
        nr9.g r4 = r3.c;
        if (r4 == null) goto L13;
        String r5 = r4.a;
    L14:
        if (r0 == null) goto L20;
        zo8.e r6 = r0.d;
        if (r6 == null) goto L20;
        c4 r7 = r6.b;
        if (r7 == null) goto L20;
        String r8 = r7.b;
    L21:
        if (r0 == null) goto L27;
        zo8.e r9 = r0.d;
        if (r9 == null) goto L27;
        c4 r10 = r9.b;
        if (r10 == null) goto L27;
        String r11 = r10.a;
    L28:
        if (r0 == null) goto L34;
        zo8.e r12 = r0.d;
        if (r12 == null) goto L34;
        c4 r13 = r12.b;
        if (r13 == null) goto L34;
        r1 = r13.c;
    L34:
        a4.i(r5, r8, r11, r1, "0", null, 224);
        return;
    L27:
        r11 = null;
    L20:
        r8 = null;
    L13:
        r5 = null;
        goto L14
    L36:
        return;
    L5:
        r2 = null;
        goto L6
    }

    public final void F() {
        b0 r0 = (b0) this.h.getValue();
        if (r0 == null) goto L6;
        r0.e("detail_click");
        return;
    }

    public final void G() {
        b0 r0 = (b0) this.h.getValue();
        if (r0 == null) goto L6;
        r0.d();
        return;
    }

    public final void u() {
        jy9.x r0 = this.g;
        rd8.b r1 = r0.s;
        if (r1 == null) goto L5;
        r1.q3().g();
        return;
    L5:
        q0.a r2 = r0.b;
        if (r2 == null) goto L14;
        qd8.b r3 = r2.H9();
        if (r3 == null) goto L15;
        kh8.a r4 = r3.q3();
        if (r4 == null) goto L16;
        r4.g();
        return;
    L16:
        return;
    L15:
        return;
    }

    public final void v() {
        sz9.b r0 = (sz9.b) ((com.larus.gallery.api.t) this).d;
        if (r0 == null) goto L12;
        zo8.e r1 = r0.d;
        if (r1 == null) goto L13;
        if (r0 == null) goto L14;
        if (r1 == null) goto L15;
        Function2 r2 = r1.g;
        if (r2 == null) goto L16;
        String r3 = r1.c.a;
        Lazy r4 = com.larus.gallery.adapter.p.a;
        r2.invoke(r3, com.larus.gallery.adapter.p.b(r1.e, "ugc_video", "immersive_preview"));
        return;
    L16:
        return;
    L15:
        return;
    L14:
        return;
    L13:
        return;
    }

    public y(jy9.x r2) {
        Intrinsics.checkNotNullParameter(r2, "galleryContext");
        this.g = r2;
        this.h = LazyKt.lazy(new x(this));
    }

    public final View p(ViewGroup r2) {
        View r3 = super.p(r2);
        if (this.g.r == false) goto L9;
        LarusGalleryChatTitleBinding r0 = ((com.larus.chat.gallery.api.g) this).f;
        if (r0 == null) goto L9;
        ImageView r1 = r0.c;
        if (r1 == null) goto L9;
        e1.o(r1);
    L9:
        return r3;
    }

    public final void w(Object r4, int r5) {
        sz9.b r6 = (sz9.b) r4;
        Intrinsics.checkNotNullParameter(r6, "data");
        super.w(r6, r5);
        Message r7 = r6.a;
        zo8.e r0 = null;
        if (r7 == null) goto L5;
        String r8 = r7.getMessageId();
    L6:
        Message r1 = this.g.a;
        if (r1 == null) goto L9;
        String r2 = r1.getMessageId();
    L11:
        if (Intrinsics.areEqual(r8, r2) == false) goto L24;
        com.larus.bmhome.bigimg.e r9 = this.g.m;
        if (r9 == null) goto L25;
        sz9.b r3 = (sz9.b) ((com.larus.gallery.api.t) this).d;
        if (r3 == null) goto L19;
        zo8.e r10 = r3.d;
        if (r10 == null) goto L19;
    L22:
        r9.b(r5, r10);
        return;
    L19:
        if (r3 == null) goto L21;
        r0 = r3.c;
    L21:
        r10 = r0;
        goto L22
    L25:
        return;
    L24:
        return;
    L9:
        r2 = null;
        goto L11
    L5:
        r8 = null;
        goto L6
    }
}
