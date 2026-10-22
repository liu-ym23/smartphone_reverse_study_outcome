package com.larus.chat.gallery.impl.preview.provider;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.larus.chat.gallery.impl.preview.input.PreviewCameraParamProvider;
import com.larus.chat.gallery.impl.preview.toolbar.PreviewToolbarCoordinator;
import com.larus.chat.gallery.impl.preview.toolbar.PreviewToolbarView;
import com.larus.chat.gallery.impl.preview.toolbar.ToolbarButtonType;
import com.larus.chat.gallery.impl.preview.toolbar.ToolbarLayoutMode;
import com.larus.chat.gallery.impl.preview.toolbar.ToolbarVisualStyle;
import com.larus.chat.gallery.impl.preview.toolbar.action.ToolbarActionDispatcher;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class q extends com.larus.gallery.api.t<xy8.d> implements xy8.a {
    public final PreviewCameraParamProvider f;
    public final com.larus.chat.gallery.impl.preview.input.e0 g;
    public final com.larus.chat.gallery.api.q h;
    public final com.larus.chat.gallery.impl.preview.r i;
    public FrameLayout j;
    public TextView k;
    public PreviewToolbarCoordinator l;

    public final boolean n() {
        return false;
    }

    @Override // xy8.a
    public final void g() {
        PreviewToolbarCoordinator r0 = this.l;
        if (r0 == null) goto L8;
        ToolbarActionDispatcher r1 = r0.q;
        if (r1 == null) goto L9;
        r1.c(ToolbarButtonType.SET_PRIVATE);
        return;
    L9:
        return;
    }

    @Override // xy8.a
    public final void k() {
        PreviewToolbarCoordinator r0 = this.l;
        if (r0 == null) goto L8;
        ToolbarActionDispatcher r1 = r0.q;
        if (r1 == null) goto L9;
        r1.c(ToolbarButtonType.PUBLISH);
        return;
    L9:
        return;
    }

    public final ViewGroup.LayoutParams q() {
        int r1 = i5.c0();
        com.larus.utils.i0.a.getClass();
        return new ViewGroup.LayoutParams(-1, r1 + com.larus.utils.i0.g());
    }

    public final void t() {
        if (this.i.b != ToolbarLayoutMode.HORIZONTAL) goto L8;
        this.l = new PreviewToolbarCoordinator(this.i.b, ToolbarVisualStyle.MEDIA_SOURCE_V4, r(), new k(this), new l(this), new m(this), new n(this), new o(this), this.f, this.g, this.h, Boolean.valueOf(this.i.d), this.i.e, false, 8192);
        com.larus.gallery.api.w r1 = ((com.larus.gallery.api.t) this).e;
        if (r1 == null) goto L9;
        r1.Op(Reflection.getOrCreateKotlinClass(xy8.a.class), this);
        return;
    L9:
        return;
    }

    public final void u() {
        PreviewToolbarCoordinator r0 = this.l;
        if (r0 == null) goto L5;
        r0.c();
    L5:
        this.l = null;
        this.j = null;
        this.k = null;
    }

    public final View p(ViewGroup r5) {
        Context r0 = getContext();
        if (r0 != null) goto L6;
        return null;
    L6:
        View r6 = LayoutInflater.from(r0).inflate(2131563085, r5, false);
        com.larus.utils.e1.d(r6.findViewById(2131379809), new p(this));
        this.j = (FrameLayout) r6.findViewById(2131379814);
        this.k = (TextView) r6.findViewById(2131379813);
        PreviewToolbarCoordinator r1 = this.l;
        if (r1 == null) goto L11;
        PreviewToolbarView r2 = r1.b(r0);
        FrameLayout r3 = this.j;
        if (r3 == null) goto L11;
        r3.addView(r2);
    L11:
        return r6;
    }

    public final void x(com.larus.gallery.api.p r3) {
        Intrinsics.checkNotNullParameter(r3, "event");
        if ((r3 instanceof com.larus.gallery.api.p.e) == false) goto L10;
        PreviewToolbarCoordinator r4 = this.l;
        if (r4 == null) goto L15;
        ToolbarActionDispatcher r5 = r4.q;
        if (r5 == null) goto L16;
        r5.a(ToolbarButtonType.SHARE, false);
        return;
    L16:
        return;
    L15:
        return;
    L10:
        if ((r3 instanceof com.larus.gallery.api.p.k) == false) goto L18;
        PreviewToolbarCoordinator r0 = this.l;
        if (r0 == null) goto L19;
        r0.g((xy8.d) ((com.larus.gallery.api.t) this).d, (com.larus.gallery.api.p.k) r3);
        return;
    L19:
        return;
    }

    public final void w(Object r5, int r6) {
        xy8.d r7 = (xy8.d) r5;
        Intrinsics.checkNotNullParameter(r7, "data");
        ((com.larus.gallery.api.t) this).d = r7;
        String r1 = this.h.getTitle(r7.b);
        if (r1 == null) goto L16;
        Unit r3 = null;
        if ((!StringsKt.isBlank(r1)) == true) goto L8;
        r1 = null;
    L8:
        if (r1 == null) goto L16;
        TextView r2 = this.k;
        if (r2 == null) goto L12;
        r2.setText(r1);
    L12:
        TextView r4 = this.k;
        if (r4 == null) goto L15;
        com.larus.utils.e1.x(r4);
        r3 = Unit.INSTANCE;
    L15:
        if (r3 == null) goto L16;
    L19:
        PreviewToolbarCoordinator r8 = this.l;
        if (r8 == null) goto L23;
        Intrinsics.checkNotNullParameter(r7, "data");
        r8.t = r6;
        r8.h(r7);
        return;
    L23:
        return;
    L16:
        TextView r9 = this.k;
        if (r9 == null) goto L19;
        com.larus.utils.e1.o(r9);
        Unit r10 = Unit.INSTANCE;
        goto L19
    }

    public q(PreviewCameraParamProvider r2, com.larus.chat.gallery.impl.preview.input.e0 r3, com.larus.chat.gallery.api.q r4, com.larus.chat.gallery.impl.preview.r r5) {
        Intrinsics.checkNotNullParameter(r2, "paramProvider");
        Intrinsics.checkNotNullParameter(r4, "mediaSession");
        Intrinsics.checkNotNullParameter(r5, "policy");
        this.f = r2;
        this.g = r3;
        this.h = r4;
        this.i = r5;
    }
}
