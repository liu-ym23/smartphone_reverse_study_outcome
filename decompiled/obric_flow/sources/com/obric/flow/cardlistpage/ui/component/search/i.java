package com.obric.flow.cardlistpage.ui.component.search;

import android.util.TypedValue;
import cn.nubia.neopush.commons.Constant;
import com.lynx.tasm.utils.k;
import com.obric.common.oea.foundation.animation.token.AnimationProperty$FloatProperty;
import com.obric.common.oea.foundation.animation.token.Token$Bounce;
import com.obric.common.oea.foundation.animation.token.Token$Duration;
import com.obric.common.oui.R$color;
import com.obric.flow.cardlistpage.ui.CardFeedLayout;
import com.obric.flow.cardlistpage.ui.component.feedlist.w;
import com.obric.oui.searchbar.v2.OSearchBar;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class i extends com.obric.flow.cardlistpage.mvi.c {
    public final OSearchBar d;
    public final Function1 e;
    public int f;
    public int g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public jp.d f11761h;

    public i(OSearchBar r5, CoroutineScope r10, CardFeedLayout r11, Function1 r12) {
        Intrinsics.checkNotNullParameter(r5, "searchBar");
        Intrinsics.checkNotNullParameter(r10, "coroutineScope");
        Intrinsics.checkNotNullParameter(r11, "parent");
        Intrinsics.checkNotNullParameter(r12, "onSearchBarLayoutBottomChanged");
        super(new w(new j(), 4), r10, r11);
        this.d = r5;
        this.e = r12;
        i();
    }

    /* JADX WARN: Type inference failed for: r1v18, types: [com.obric.flow.cardlistpage.ui.component.search.SearchComponent$animateQsbFinish$3, java.lang.Object, kotlin.jvm.internal.Lambda] */
    /* JADX WARN: Type inference failed for: r6v2, types: [com.obric.flow.cardlistpage.ui.component.search.SearchComponent$animateQsbFinish$2, java.lang.Object, kotlin.jvm.internal.Lambda] */
    @Override // com.obric.flow.cardlistpage.mvi.c
    public final void g(com.obric.flow.cardlistpage.mvi.e r30) {
        f r5 = (f) r30;
        Intrinsics.checkNotNullParameter(r5, Constant.COMMAND);
        if (Intrinsics.areEqual(r5, e.f11757a) == false) goto L6;
        k.r().a("click_search_bar", new JSONObject());
        e(a.f11752a);
        return;
    L6:
        if (Intrinsics.areEqual(r5, d.f11756a) == false) goto L11;
        jp.d r10 = this.f11761h;
        if (r10 == null) goto L10;
        int r11 = jp.d.d;
        r10.a(false);
    L10:
        this.f11761h = null;
        return;
    L11:
        boolean r12 = r5 instanceof c;
        OSearchBar r13 = this.d;
        if (r12 == false) goto L38;
        c r14 = (c) r5;
        jp.d r15 = this.f11761h;     // Catch: Exception -> L31
        if (r15 == null) goto L17;
        int r16 = jp.d.d;     // Catch: Exception -> L31
        r15.a(false);     // Catch: Exception -> L31
    L17:
        this.f11761h = null;     // Catch: Exception -> L31
        if (this.f != 0) goto L20;
        this.f = r13.getWidth();     // Catch: Exception -> L31
        this.g = r13.getHeight();     // Catch: Exception -> L31
    L20:
        final int r17 = r13.getWidth();     // Catch: Exception -> L31
        final int r23 = r13.getHeight();     // Catch: Exception -> L31
        int r18 = r14.f11754a;
        if (r18 <= 0) goto L24;
        int r24 = r18;
    L25:
        int r19 = r14.f11755b;
        if (r19 <= 0) goto L28;
        int r25 = r19;
    L29:
        final float r26 = TypedValue.applyDimension(1, -6.0f, r13.getContext().getResources().getDisplayMetrics());     // Catch: Exception -> L31
        Token$Bounce r20 = Token$Bounce.OUI_ANIMATION_BOUNCE_SMOOTH;     // Catch: Exception -> L31
        com.obric.common.oea.foundation.animation.spec.spring.b r21 = ug.a.m(r20, Token$Duration.OUI_ANIMATION_DURATION_MEDIUM_2);     // Catch: Exception -> L31
        r21.f11323b = 0.01f;     // Catch: Exception -> L31
        Unit r22 = Unit.INSTANCE;     // Catch: Exception -> L31
        Intrinsics.checkNotNullParameter(r21, "spec");     // Catch: Exception -> L31
        hp.a r27 = new hp.a(r21, Float.valueOf(1.0f), Float.valueOf(0.0f), null, "valueAnimationPlaceholder", Reflection.getOrCreateKotlinClass(Float.TYPE));     // Catch: Exception -> L31
        final int r28 = r24;
        final int r29 = r25;
        Function3<String, Object, Object, Unit> r31 = new SearchComponent$animateQsbReady$2(this, r17, r28, r23, r29, r26);     // Catch: Exception -> L31
        Intrinsics.checkNotNullParameter(r31, "callback");     // Catch: Exception -> L31
        new com.google.common.reflect.w(r27, r31, null).x();     // Catch: Exception -> L31
        com.obric.common.oea.foundation.animation.builder.a r32 = new com.obric.common.oea.foundation.animation.builder.a(r13);     // Catch: Exception -> L31
        com.obric.common.oea.foundation.animation.builder.a.a(r32);     // Catch: Exception -> L31
        AnimationProperty$FloatProperty r110 = AnimationProperty$FloatProperty.ALPHA;     // Catch: Exception -> L31
        Float r111 = Float.valueOf(r13.getAlpha());     // Catch: Exception -> L31
        com.obric.common.oea.foundation.animation.spec.spring.b r33 = ug.a.m(r20, Token$Duration.OUI_ANIMATION_DURATION_SHORT_2);     // Catch: Exception -> L31
        r33.f11323b = 0.01f;     // Catch: Exception -> L31
        r32.c(r110, r111, 0.0f, r33, null);     // Catch: Exception -> L31
        com.obric.common.oea.foundation.animation.builder.b.a(r32.b());     // Catch: Exception -> L31
        return;
    L28:
        r25 = r23;
        goto L29
    L24:
        r24 = r17;
    L31:
        e = move-exception;
        Intrinsics.checkNotNullParameter("SearchComponent", "tag");
        Intrinsics.checkNotNullParameter("animateQsbReady error", "msg");
        Intrinsics.checkNotNullParameter(e, "t");
        org.koin.core.a r34 = su.a.f22013b;
        if (r34 == null) goto L36;
        ((ju.b) r34.f20999a.d.b(null, Reflection.getOrCreateKotlinClass(ju.b.class), null)).e("SearchComponent", "animateQsbReady error", e);
        return;
    L36:
        throw new IllegalStateException("KoinApplication has not been started");
    L38:
        if (Intrinsics.areEqual(r5, b.f11753a) == true) goto L67;
        return;
    L67:
        jp.d r35 = this.f11761h;     // Catch: Exception -> L57
        if (r35 == null) goto L43;
        int r112 = jp.d.d;     // Catch: Exception -> L57
        r35.a(false);     // Catch: Exception -> L57
    L43:
        this.f11761h = null;     // Catch: Exception -> L57
        r13.setVisibility(0);     // Catch: Exception -> L57
        int r36 = this.f;     // Catch: Exception -> L57
        if (r36 <= 0) goto L46;
    L45:
        final int r37 = r36;
        int r38 = this.g;     // Catch: Exception -> L57
        if (r38 <= 0) goto L50;
    L49:
        final int r39 = r38;
        final int r113 = r13.getWidth();     // Catch: Exception -> L57
        final int r114 = r13.getHeight();     // Catch: Exception -> L57
        final float r115 = TypedValue.applyDimension(1, -6.0f, r13.getContext().getResources().getDisplayMetrics());     // Catch: Exception -> L57
        com.obric.common.oea.foundation.animation.builder.a r40 = new com.obric.common.oea.foundation.animation.builder.a(r13);     // Catch: Exception -> L57
        com.obric.common.oea.foundation.animation.builder.a.a(r40);     // Catch: Exception -> L57
        AnimationProperty$FloatProperty r210 = AnimationProperty$FloatProperty.ALPHA;     // Catch: Exception -> L57
        Float r211 = Float.valueOf(r13.getAlpha());     // Catch: Exception -> L57
        com.obric.common.oea.foundation.animation.spec.spring.b r41 = ug.a.m(Token$Bounce.OUI_ANIMATION_BOUNCE_SMOOTH, Token$Duration.OUI_ANIMATION_DURATION_MEDIUM_2);     // Catch: Exception -> L57
        r41.f11323b = 0.01f;     // Catch: Exception -> L57
        Unit r42 = Unit.INSTANCE;     // Catch: Exception -> L57
        r40.c(r210, r211, 1.0f, r41, null);     // Catch: Exception -> L57
        ?? r43 = new SearchComponent$animateQsbFinish$2(this, r113, r37, r114, r39, r115);     // Catch: Exception -> L55
        Intrinsics.checkNotNullParameter(r43, "callback");     // Catch: Exception -> L55
        r40.d = r43;     // Catch: Exception -> L55
        ?? r44 = new SearchComponent$animateQsbFinish$3(this, r37, r39);     // Catch: Exception -> L55
        Intrinsics.checkNotNullParameter(r44, "callback");     // Catch: Exception -> L55
        r40.e = r44;     // Catch: Exception -> L55
        this.f11761h = com.obric.common.oea.foundation.animation.builder.b.a(r40.b());     // Catch: Exception -> L55
        return;
    L55:
        e = e;
    L59:
        Intrinsics.checkNotNullParameter("SearchComponent", "tag");
        Intrinsics.checkNotNullParameter("animateQsbFinish error", "msg");
        Intrinsics.checkNotNullParameter(e, "t");
        org.koin.core.a r45 = su.a.f22013b;
        if (r45 == null) goto L63;
        ((ju.b) r45.f20999a.d.b(null, Reflection.getOrCreateKotlinClass(ju.b.class), null)).e("SearchComponent", "animateQsbFinish error", e);
        return;
    L63:
        throw new IllegalStateException("KoinApplication has not been started");
    L50:
        r38 = r13.getHeight();     // Catch: Exception -> L57
        goto L49
    L46:
        r36 = r13.getWidth();     // Catch: Exception -> L57
    L57:
        e = e;
        goto L59
    }

    @Override // com.obric.flow.cardlistpage.mvi.c
    public final void h() {
        OSearchBar r5 = this.d;
        r5.getInputView().setFocusable(false);
        r5.getInputView().setFocusableInTouchMode(false);
        r5.getInputView().setHintTextColor(r5.getContext().getResources().getColor(R$color.oui_dark_basic_text_4, null));
        if (r5.isLaidOut() == true) goto L5;
    L7:
        r5.addOnLayoutChangeListener(new h(this));
    L8:
        final int r10 = 0;
        r5.getInputView().setOnClickListener(new g(this, r10));
        final int r11 = 1;
        r5.setOnClickListener(new g(this, r11));
        return;
    L5:
        if (r5.isLayoutRequested() == true) goto L7;
        Integer r12 = Integer.valueOf(r5.getBottom());
        this.e.invoke(r12);
        goto L8
    }

    @Override // com.obric.flow.cardlistpage.mvi.c
    public final void j() {
        SearchComponent$observeState$$inlined$collectState$1 r5 = new SearchComponent$observeState$$inlined$collectState$1(null, this, this);
        BuildersKt.launch$default((CoroutineScope) this.f11532b, null, null, r5, 3, null);
    }
}
