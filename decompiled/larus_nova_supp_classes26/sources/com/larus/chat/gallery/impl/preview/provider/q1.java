package com.larus.chat.gallery.impl.preview.provider;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.larus.bmhome.chat.tips.GuidePriority;
import com.larus.chat.gallery.impl.preview.data.SourceType;
import com.larus.chat.gallery.impl.preview.input.PreviewCameraParamProvider;
import com.larus.chat.gallery.impl.preview.toolbar.PreviewToolbarCoordinator;
import com.larus.chat.gallery.impl.preview.toolbar.PreviewToolbarView;
import com.larus.chat.gallery.impl.preview.toolbar.ToolbarButtonType;
import com.larus.chat.gallery.impl.preview.toolbar.ToolbarLayoutMode;
import com.larus.chat.gallery.impl.preview.toolbar.ToolbarVisualStyle;
import com.larus.chat.gallery.impl.preview.toolbar.action.ToolbarActionDispatcher;
import com.larus.gallery.impl.databinding.LarusGalleryChatTitleBinding;
import com.larus.utils.logger.FLogger;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class q1 extends com.larus.gallery.api.t<xy8.d> implements xy8.a {
    public final PreviewCameraParamProvider f;
    public final com.larus.chat.gallery.impl.preview.input.e0 g;
    public final com.larus.chat.gallery.impl.preview.r h;
    public LarusGalleryChatTitleBinding i;
    public FrameLayout j;
    public final Lazy k;
    public final Lazy l;
    public PreviewToolbarCoordinator m;
    public String n;

    public static final class a {
    }

    static {
    }

    public final boolean n() {
        return false;
    }

    @Override // xy8.a
    public final void g() {
        PreviewToolbarCoordinator r0 = this.m;
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
        PreviewToolbarCoordinator r0 = this.m;
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
        if (((ToolbarLayoutMode) this.l.getValue()) == ToolbarLayoutMode.VERTICAL) goto L26;
        ToolbarLayoutMode r5 = (ToolbarLayoutMode) this.l.getValue();
        com.larus.chat.gallery.impl.preview.r r2 = this.h;
        if (r2 == null) goto L8;
        ToolbarVisualStyle r3 = r2.c;
        if (r3 == null) goto L8;
    L9:
        ToolbarVisualStyle r6 = r3;
        CoroutineScope r7 = r();
        Function0 r8 = new j1(this);
        Function0 r9 = new k1(this);
        Function0 r10 = new l1(this);
        Function0 r11 = new m1(this);
        Function0 r12 = new n1(this);
        PreviewCameraParamProvider r13 = this.f;
        com.larus.chat.gallery.impl.preview.input.e0 r14 = this.g;
        com.larus.chat.gallery.impl.preview.r r4 = this.h;
        Function1<SourceType, sq9.a0> r15 = null;
        if (r4 == null) goto L12;
        Boolean r16 = Boolean.valueOf(r4.d);
    L13:
        com.larus.chat.gallery.impl.preview.r r17 = this.h;
        if (r17 == null) goto L16;
        r15 = r17.e;
    L16:
        Function1<SourceType, sq9.a0> r18 = r15;
        if (r17 != null) goto L19;
    L21:
        boolean r19 = false;
    L22:
        this.m = new PreviewToolbarCoordinator(r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, null, r16, r18, r19, 1024);
        com.larus.gallery.api.w r1 = ((com.larus.gallery.api.t) this).e;
        if (r1 == null) goto L25;
        r1.Op(Reflection.getOrCreateKotlinClass(xy8.a.class), this);
    L25:
        FLogger.a.i("PreviewTopProvider", "onAttach: 横排模式，创建 Coordinator 并注册 capability");
        return;
    L19:
        if (r17.f != true) goto L21;
        r19 = true;
        goto L22
    L12:
        r16 = null;
    L8:
        r3 = ToolbarVisualStyle.LEGACY;
        goto L9
    L26:
        FLogger.a.i("PreviewTopProvider", "onAttach: 竖排模式，不参与 Toolbar");
    }

    public final void u() {
        PreviewToolbarCoordinator r0 = this.m;
        if (r0 == null) goto L5;
        r0.c();
    L5:
        this.m = null;
        this.i = null;
        this.j = null;
    }

    public final View p(ViewGroup r7) {
        Context r0 = getContext();
        if (r0 != null) goto L5;
        return null;
    L5:
        LarusGalleryChatTitleBinding r8 = LarusGalleryChatTitleBinding.a(LayoutInflater.from(r0), r7);
        this.i = r8;
        ImageView r9 = r8.b;
        if (r9 == null) goto L10;
        com.larus.utils.e1.d(r9, new i1(this));
        if (((ToolbarLayoutMode) this.l.getValue()) == ToolbarLayoutMode.VERTICAL) goto L10;
        r9.setBackgroundResource(2131243168);
    L10:
        LarusGalleryChatTitleBinding r10 = this.i;
        if (r10 == null) goto L15;
        ImageView r11 = r10.c;
        if (r11 == null) goto L15;
        r11.setVisibility(8);
    L15:
        LarusGalleryChatTitleBinding r12 = this.i;
        if (r12 == null) goto L25;
        ConstraintLayout r13 = r12.e;
        if (r13 == null) goto L25;
        ConstraintLayout.LayoutParams r14 = r13.getLayoutParams();
        if ((r14 instanceof ConstraintLayout.LayoutParams) == false) goto L22;
        ConstraintLayout.LayoutParams r15 = r14;
    L23:
        if (r15 == null) goto L25;
        r15.startToEnd = -1;
        r15.endToStart = -1;
        r15.startToStart = 0;
        r15.endToEnd = 0;
        goto L25
    L22:
        r15 = null;
    L25:
        LarusGalleryChatTitleBinding r16 = this.i;
        if (r16 == null) goto L30;
        ImageView r17 = r16.c;
        if (r17 == null) goto L30;
        ViewParent r18 = r17.getParent();
    L32:
        if ((r18 instanceof ConstraintLayout) == false) goto L34;
        ConstraintLayout r19 = (ConstraintLayout) r18;
    L35:
        if (r19 == null) goto L38;
        FrameLayout r3 = new FrameLayout(r0);
        r3.setId(View.generateViewId());
        ConstraintLayout.LayoutParams r4 = new ConstraintLayout.LayoutParams(-2, 0);
        r4.endToEnd = 0;
        r4.topToTop = 0;
        r4.bottomToBottom = 0;
        r3.setLayoutParams(r4);
        this.j = r3;
        r19.addView(r3);
    L38:
        if (((ToolbarLayoutMode) this.l.getValue()) == ToolbarLayoutMode.VERTICAL) goto L45;
        PreviewToolbarCoordinator r20 = this.m;
        if (r20 == null) goto L45;
        PreviewToolbarView r21 = r20.b(r0);
        FrameLayout r1 = this.j;
        if (r1 == null) goto L44;
        r1.addView(r21);
    L44:
        FLogger.a.i("PreviewTopProvider", "createView: 横排模式创建 ToolbarView");
    L45:
        LarusGalleryChatTitleBinding r22 = this.i;
        if (r22 != null) goto L48;
        return null;
    L48:
        return r22.a;
    L34:
        r19 = null;
    L30:
        r18 = null;
        goto L32
    }

    public final void x(com.larus.gallery.api.p r4) {
        Intrinsics.checkNotNullParameter(r4, "event");
        if ((r4 instanceof com.larus.gallery.api.p.e) == false) goto L8;
        PreviewToolbarCoordinator r5 = this.m;
        if (r5 == null) goto L13;
        FLogger.a.i("PreviewTopProvider", "onReceivedEvent: ItemLongPress, 触发分享");
        r5.q.a(ToolbarButtonType.SHARE, false);
        return;
    L13:
        return;
    L8:
        if ((r4 instanceof com.larus.gallery.api.p.k) == false) goto L15;
        PreviewToolbarCoordinator r0 = this.m;
        if (r0 == null) goto L16;
        r0.g((xy8.d) ((com.larus.gallery.api.t) this).d, (com.larus.gallery.api.p.k) r4);
        return;
    L16:
        return;
    }

    public final void w(Object r11, int r12) {
        xy8.d r13 = (xy8.d) r11;
        Intrinsics.checkNotNullParameter(r13, "data");
        ((com.larus.gallery.api.t) this).d = r13;
        xy8.b r1 = r13.c;
        Unit r2 = null;
        if (r1 == null) goto L17;
        String r3 = r1.d;
        if (r3 == null) goto L17;
        if (com.larus.utils.o0.d(r3) == true) goto L10;
        r3 = null;
    L10:
        if (r3 == null) goto L17;
        if (Intrinsics.areEqual(r3, this.n) == true) goto L17;
        this.n = r3;
        BuildersKt.launch$default(r(), null, null, new PreviewTopProvider$prefetchRawImageIfNeeded$1(r3, null), 3, null);
    L17:
        if (((ToolbarLayoutMode) this.l.getValue()) == ToolbarLayoutMode.VERTICAL) goto L26;
        LarusGalleryChatTitleBinding r4 = this.i;
        if (r4 == null) goto L23;
        ConstraintLayout r5 = r4.e;
        if (r5 == null) goto L23;
        com.larus.utils.e1.o(r5);
    L23:
        PreviewToolbarCoordinator r6 = this.m;
        if (r6 == null) goto L65;
        Intrinsics.checkNotNullParameter(r13, "data");
        r6.t = r12;
        r6.h(r13);
        return;
    L65:
        return;
    L26:
        long r0 = r13.h * ((long) GuidePriority.COMMERCE_CREDIT_PRIORITY);
        if (r0 <= 0) goto L29;
        boolean r7 = true;
    L30:
        LarusGalleryChatTitleBinding r8 = this.i;
        if (r8 == null) goto L38;
        TextView r9 = r8.g;
        if (r9 == null) goto L38;
        if (r7 == false) goto L36;
        String r14 = oo8.b.a(r0, false);
    L37:
        r9.setText(r14);
        goto L38
    L36:
        r14 = "";
    L38:
        LarusGalleryChatTitleBinding r15 = this.i;
        if (r15 == null) goto L43;
        ImageView r16 = r15.d;
        if (r16 == null) goto L43;
        com.larus.utils.e1.o(r16);
    L43:
        String r17 = r13.g;
        if (com.larus.utils.o0.d(r17) == true) goto L47;
        r17 = null;
    L47:
        if (r17 == null) goto L59;
        LarusGalleryChatTitleBinding r18 = this.i;
        if (r18 == null) goto L53;
        TextView r19 = r18.f;
        if (r19 == null) goto L53;
        r19.setText(r17);
    L53:
        LarusGalleryChatTitleBinding r110 = this.i;
        if (r110 == null) goto L58;
        TextView r111 = r110.f;
        if (r111 == null) goto L58;
        com.larus.utils.e1.x(r111);
        r2 = Unit.INSTANCE;
    L58:
        if (r2 == null) goto L59;
        return;
    L59:
        LarusGalleryChatTitleBinding r112 = this.i;
        if (r112 == null) goto L68;
        TextView r113 = r112.f;
        if (r113 == null) goto L69;
        com.larus.utils.e1.o(r113);
        Unit r114 = Unit.INSTANCE;
        return;
    L69:
        return;
    L68:
        return;
    L29:
        r7 = false;
        goto L30
    }

    public q1(PreviewCameraParamProvider r1, com.larus.chat.gallery.impl.preview.input.e0 r2, com.larus.chat.gallery.impl.preview.r r3) {
        this.f = r1;
        this.g = r2;
        this.h = r3;
        this.k = LazyKt.lazy(new o1());
        this.l = LazyKt.lazy(new p1(this));
    }
}
