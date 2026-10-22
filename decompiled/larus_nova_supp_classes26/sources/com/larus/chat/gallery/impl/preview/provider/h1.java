package com.larus.chat.gallery.impl.preview.provider;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.larus.chat.gallery.impl.preview.data.SourceType;
import com.larus.chat.gallery.impl.preview.input.PreviewCameraParamProvider;
import com.larus.chat.gallery.impl.preview.toolbar.PreviewToolbarCoordinator;
import com.larus.chat.gallery.impl.preview.toolbar.PreviewToolbarView;
import com.larus.chat.gallery.impl.preview.toolbar.ToolbarButtonType;
import com.larus.chat.gallery.impl.preview.toolbar.ToolbarLayoutMode;
import com.larus.chat.gallery.impl.preview.toolbar.action.ToolbarActionDispatcher;
import com.larus.utils.logger.FLogger;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class h1 extends com.larus.gallery.api.t<xy8.d> implements xy8.a {
    public final PreviewCameraParamProvider f;
    public final com.larus.chat.gallery.impl.preview.input.e0 g;
    public final com.larus.chat.gallery.impl.preview.r h;
    public final Lazy i;
    public final Lazy j;
    public PreviewToolbarCoordinator k;

    public static final class a {
    }

    static {
    }

    @Override // xy8.a
    public final void g() {
        PreviewToolbarCoordinator r0 = this.k;
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
        PreviewToolbarCoordinator r0 = this.k;
        if (r0 == null) goto L8;
        ToolbarActionDispatcher r1 = r0.q;
        if (r1 == null) goto L9;
        r1.c(ToolbarButtonType.PUBLISH);
        return;
    L9:
        return;
    }

    public final void t() {
        if (((ToolbarLayoutMode) this.j.getValue()) != ToolbarLayoutMode.VERTICAL) goto L21;
        ToolbarLayoutMode r5 = (ToolbarLayoutMode) this.j.getValue();
        CoroutineScope r7 = r();
        Function0 r8 = new c1(this);
        Function0 r9 = new d1(this);
        Function0 r10 = new e1(this);
        Function0 r11 = new f1(this);
        Function0 r12 = new g1(this);
        PreviewCameraParamProvider r13 = this.f;
        com.larus.chat.gallery.impl.preview.input.e0 r14 = this.g;
        com.larus.chat.gallery.impl.preview.r r2 = this.h;
        Function1<SourceType, sq9.a0> r4 = null;
        if (r2 == null) goto L7;
        Boolean r16 = Boolean.valueOf(r2.d);
    L8:
        com.larus.chat.gallery.impl.preview.r r3 = this.h;
        if (r3 == null) goto L11;
        r4 = r3.e;
    L11:
        Function1<SourceType, sq9.a0> r17 = r4;
        if (r3 != null) goto L14;
    L16:
        boolean r18 = false;
    L17:
        this.k = new PreviewToolbarCoordinator(r5, null, r7, r8, r9, r10, r11, r12, r13, r14, null, r16, r17, r18, 1026);
        com.larus.gallery.api.w r1 = ((com.larus.gallery.api.t) this).e;
        if (r1 == null) goto L20;
        r1.Op(Reflection.getOrCreateKotlinClass(xy8.a.class), this);
    L20:
        FLogger.a.i("PreviewSideBarProvider", "onAttach: 竖排模式，创建 Coordinator 并注册 capability");
        return;
    L14:
        if (r3.f != true) goto L16;
        r18 = true;
        goto L17
    L7:
        r16 = null;
        goto L8
    L21:
        FLogger.a.i("PreviewSideBarProvider", "onAttach: 横排模式，不参与 Toolbar");
    }

    public final void u() {
        PreviewToolbarCoordinator r0 = this.k;
        if (r0 == null) goto L5;
        r0.c();
    L5:
        this.k = null;
    }

    public final View p(ViewGroup r4) {
        PreviewToolbarView r2 = null;
        if (((ToolbarLayoutMode) this.j.getValue()) == ToolbarLayoutMode.VERTICAL) goto L6;
        FLogger.a.i("PreviewSideBarProvider", "createView: 横排模式返回 null");
        return null;
    L6:
        Context r5 = getContext();
        if (r5 != null) goto L9;
        return null;
    L9:
        PreviewToolbarCoordinator r0 = this.k;
        if (r0 == null) goto L12;
        r2 = r0.b(r5);
    L12:
        FLogger.a.i("PreviewSideBarProvider", "createView: 竖排模式创建工具栏");
        return r2;
    }

    public final void x(com.larus.gallery.api.p r4) {
        Intrinsics.checkNotNullParameter(r4, "event");
        if ((r4 instanceof com.larus.gallery.api.p.e) == false) goto L8;
        PreviewToolbarCoordinator r5 = this.k;
        if (r5 == null) goto L13;
        FLogger.a.i("PreviewSideBarProvider", "onReceivedEvent: ItemLongPress, 触发分享");
        r5.q.a(ToolbarButtonType.SHARE, false);
        return;
    L13:
        return;
    L8:
        if ((r4 instanceof com.larus.gallery.api.p.k) == false) goto L15;
        PreviewToolbarCoordinator r0 = this.k;
        if (r0 == null) goto L16;
        r0.g((xy8.d) ((com.larus.gallery.api.t) this).d, (com.larus.gallery.api.p.k) r4);
        return;
    L16:
        return;
    }

    public final void w(Object r3, int r4) {
        xy8.d r5 = (xy8.d) r3;
        Intrinsics.checkNotNullParameter(r5, "data");
        ((com.larus.gallery.api.t) this).d = r5;
        PreviewToolbarCoordinator r1 = this.k;
        if (r1 == null) goto L6;
        Intrinsics.checkNotNullParameter(r5, "data");
        r1.t = r4;
        r1.h(r5);
        return;
    }

    public h1(PreviewCameraParamProvider r1, com.larus.chat.gallery.impl.preview.input.e0 r2, com.larus.chat.gallery.impl.preview.r r3) {
        this.f = r1;
        this.g = r2;
        this.h = r3;
        this.i = LazyKt.lazy(new a1());
        this.j = LazyKt.lazy(new b1(this));
    }
}
