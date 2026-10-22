package com.larus.chat.gallery.impl.preview.provider;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.larus.chat.gallery.impl.preview.input.PreviewCameraParamProvider;
import com.larus.chat.gallery.impl.preview.toolbar.PreviewToolbarCoordinator;
import com.larus.chat.gallery.impl.preview.toolbar.ToolbarButtonType;
import com.larus.chat.gallery.impl.preview.toolbar.ToolbarLayoutMode;
import com.larus.chat.gallery.impl.preview.toolbar.ToolbarVisualStyle;
import com.larus.chat.gallery.impl.preview.toolbar.action.ToolbarActionDispatcher;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class j extends com.larus.gallery.api.t<xy8.d> implements xy8.a {
    public final PreviewCameraParamProvider f;
    public final com.larus.chat.gallery.impl.preview.input.e0 g;
    public final com.larus.chat.gallery.api.q h;
    public final com.larus.chat.gallery.impl.preview.r i;
    public PreviewToolbarCoordinator j;

    @Override // xy8.a
    public final void g() {
        PreviewToolbarCoordinator r0 = this.j;
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
        PreviewToolbarCoordinator r0 = this.j;
        if (r0 == null) goto L8;
        ToolbarActionDispatcher r1 = r0.q;
        if (r1 == null) goto L9;
        r1.c(ToolbarButtonType.PUBLISH);
        return;
    L9:
        return;
    }

    public final void t() {
        if (this.i.b != ToolbarLayoutMode.VERTICAL) goto L8;
        this.j = new PreviewToolbarCoordinator(this.i.b, ToolbarVisualStyle.MEDIA_SOURCE_V4, r(), new e(this), new f(this), new g(this), new h(this), new i(this), this.f, this.g, this.h, Boolean.valueOf(this.i.d), this.i.e, false, 8192);
        com.larus.gallery.api.w r1 = ((com.larus.gallery.api.t) this).e;
        if (r1 == null) goto L9;
        r1.Op(Reflection.getOrCreateKotlinClass(xy8.a.class), this);
        return;
    L9:
        return;
    }

    public final void u() {
        PreviewToolbarCoordinator r0 = this.j;
        if (r0 == null) goto L5;
        r0.c();
    L5:
        this.j = null;
    }

    public final View p(ViewGroup r3) {
        if (this.i.b == ToolbarLayoutMode.VERTICAL) goto L5;
        return null;
    L5:
        Context r4 = getContext();
        if (r4 != null) goto L8;
        return null;
    L8:
        PreviewToolbarCoordinator r0 = this.j;
        if (r0 != null) goto L11;
        return null;
    L11:
        return r0.b(r4);
    }

    public final void x(com.larus.gallery.api.p r3) {
        Intrinsics.checkNotNullParameter(r3, "event");
        if ((r3 instanceof com.larus.gallery.api.p.e) == false) goto L10;
        PreviewToolbarCoordinator r4 = this.j;
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
        PreviewToolbarCoordinator r0 = this.j;
        if (r0 == null) goto L19;
        r0.g((xy8.d) ((com.larus.gallery.api.t) this).d, (com.larus.gallery.api.p.k) r3);
        return;
    L19:
        return;
    }

    public final void w(Object r3, int r4) {
        xy8.d r5 = (xy8.d) r3;
        Intrinsics.checkNotNullParameter(r5, "data");
        ((com.larus.gallery.api.t) this).d = r5;
        PreviewToolbarCoordinator r1 = this.j;
        if (r1 == null) goto L6;
        Intrinsics.checkNotNullParameter(r5, "data");
        r1.t = r4;
        r1.h(r5);
        return;
    }

    public j(PreviewCameraParamProvider r2, com.larus.chat.gallery.impl.preview.input.e0 r3, com.larus.chat.gallery.api.q r4, com.larus.chat.gallery.impl.preview.r r5) {
        Intrinsics.checkNotNullParameter(r2, "paramProvider");
        Intrinsics.checkNotNullParameter(r4, "mediaSession");
        Intrinsics.checkNotNullParameter(r5, "policy");
        this.f = r2;
        this.g = r3;
        this.h = r4;
        this.i = r5;
    }
}
