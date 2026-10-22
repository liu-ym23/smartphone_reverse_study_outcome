package com.obric.flow.cardlistpage.ui.component.floatingbtn;

import android.view.View;
import cn.nubia.neopush.commons.Constant;
import com.obric.common.oea.foundation.animation.token.AnimationProperty$FloatProperty;
import com.obric.common.oea.foundation.animation.token.Token$Bounce;
import com.obric.common.oea.foundation.animation.token.Token$Duration;
import com.obric.flow.cardlistpage.ui.CardFeedLayout;
import com.obric.flow.cardlistpage.ui.component.feedlist.w;
import com.obric.oui.button.OIconButtonFloating;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class j extends com.obric.flow.cardlistpage.mvi.c {
    public final OIconButtonFloating d;
    public final OIconButtonFloating e;
    public jp.d f;

    public j(OIconButtonFloating r5, OIconButtonFloating r10, CoroutineScope r11, CardFeedLayout r12) {
        Intrinsics.checkNotNullParameter(r5, "btnGenCard");
        Intrinsics.checkNotNullParameter(r11, "coroutineScope");
        Intrinsics.checkNotNullParameter(r12, "parent");
        super(new w(new k(), 1), r11, r12);
        this.d = r5;
        this.e = r10;
        i();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r14v2, types: [kotlin.jvm.functions.Function0, wu.a] */
    /* JADX WARN: Type inference failed for: r1v8, types: [com.obric.flow.cardlistpage.ui.component.floatingbtn.FloatingBtnComponent$animateQsbFinish$3, java.lang.Object, kotlin.jvm.internal.Lambda] */
    /* JADX WARN: Type inference failed for: r2v15, types: [com.obric.flow.cardlistpage.ui.component.floatingbtn.FloatingBtnComponent$animateQsbFinish$2, java.lang.Object, kotlin.jvm.internal.Lambda] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // com.obric.flow.cardlistpage.mvi.c
    public final void g(com.obric.flow.cardlistpage.mvi.e r24) {
        h r5 = (h) r24;
        Intrinsics.checkNotNullParameter(r5, Constant.COMMAND);
        if (Intrinsics.areEqual(r5, g.f11636a) == false) goto L5;
        com.lynx.tasm.utils.k.r().a("click_add_widget_butoon", new JSONObject());
        e(a.f11631a);
        return;
    L5:
        boolean r10 = r5 instanceof e;
        OIconButtonFloating r11 = this.e;
        OIconButtonFloating r13 = this.d;
        if (r10 == false) goto L27;
        final float r12 = ((e) r5).f11634a;
        jp.d r14 = this.f;     // Catch: Exception -> L19
        if (r14 == null) goto L11;
        int r16 = jp.d.d;     // Catch: Exception -> L19
        r14.a(false);     // Catch: Exception -> L19
    L11:
        this.f = null;     // Catch: Exception -> L19
        final float r15 = r13.getTranslationX();     // Catch: Exception -> L19
        Token$Bounce r17 = Token$Bounce.OUI_ANIMATION_BOUNCE_SMOOTH;     // Catch: Exception -> L19
        com.obric.common.oea.foundation.animation.spec.spring.b r18 = ug.a.m(r17, Token$Duration.OUI_ANIMATION_DURATION_MEDIUM_2);     // Catch: Exception -> L19
        r18.f11323b = 0.01f;     // Catch: Exception -> L19
        Unit r19 = Unit.INSTANCE;     // Catch: Exception -> L19
        Intrinsics.checkNotNullParameter(r18, "spec");     // Catch: Exception -> L19
        Object r22 = null;
        hp.a r110 = new hp.a(r18, Float.valueOf(1.0f), Float.valueOf(0.0f), null, "valueAnimationPlaceholder", Reflection.getOrCreateKotlinClass(Float.TYPE));     // Catch: Exception -> L17
        Function3<String, Object, Object, Unit> r111 = new FloatingBtnComponent$animateQsbReady$2(this, r15, r12);     // Catch: Exception -> L17
        Intrinsics.checkNotNullParameter(r111, "callback");     // Catch: Exception -> L17
        new com.google.common.reflect.w(r110, r111, null).x();     // Catch: Exception -> L17
        com.obric.common.oea.foundation.animation.builder.a r20 = new com.obric.common.oea.foundation.animation.builder.a(r13);     // Catch: Exception -> L17
        com.obric.common.oea.foundation.animation.builder.a.a(r20);     // Catch: Exception -> L17
        AnimationProperty$FloatProperty r112 = AnimationProperty$FloatProperty.ALPHA;     // Catch: Exception -> L17
        Float r113 = Float.valueOf(r13.getAlpha());     // Catch: Exception -> L17
        Token$Duration r21 = Token$Duration.OUI_ANIMATION_DURATION_SHORT_2;     // Catch: Exception -> L17
        com.obric.common.oea.foundation.animation.spec.spring.b r23 = ug.a.m(r17, r21);     // Catch: Exception -> L17
        r23.f11323b = 0.01f;     // Catch: Exception -> L17
        r20.c(r112, r113, 0.0f, r23, null);     // Catch: Exception -> L17
        com.obric.common.oea.foundation.animation.builder.b.a(r20.b());     // Catch: Exception -> L17
        if (r11 == null) goto L69;
        com.obric.common.oea.foundation.animation.builder.a r25 = new com.obric.common.oea.foundation.animation.builder.a(r11);     // Catch: Exception -> L17
        com.obric.common.oea.foundation.animation.builder.a.a(r25);     // Catch: Exception -> L17
        Float r114 = Float.valueOf(r11.getAlpha());     // Catch: Exception -> L17
        com.obric.common.oea.foundation.animation.spec.spring.b r26 = ug.a.m(r17, r21);     // Catch: Exception -> L17
        r26.f11323b = 0.01f;     // Catch: Exception -> L17
        r25.c(r112, r114, 0.0f, r26, null);     // Catch: Exception -> L17
        com.obric.common.oea.foundation.animation.builder.b.a(r25.b());     // Catch: Exception -> L17
        return;
    L69:
        return;
    L17:
        e = e;
    L21:
        Intrinsics.checkNotNullParameter("FloatingBtnComponent", "tag");
        Intrinsics.checkNotNullParameter("animateQsbReady error", "msg");
        Intrinsics.checkNotNullParameter(e, "t");
        org.koin.core.a r27 = su.a.f22013b;
        if (r27 == null) goto L25;
        ?? r115 = r22;
        ((ju.b) r27.f20999a.d.b(r115, Reflection.getOrCreateKotlinClass(ju.b.class), r115)).e("FloatingBtnComponent", "animateQsbReady error", e);
        return;
    L25:
        throw new IllegalStateException("KoinApplication has not been started");
    L19:
        e = e;
        r22 = null;
        goto L21
    L27:
        if (Intrinsics.areEqual(r5, d.f11633a) == false) goto L56;
        jp.d r28 = this.f;     // Catch: Exception -> L38
        if (r28 == null) goto L31;
        int r29 = jp.d.d;     // Catch: Exception -> L38
        r28.a(false);     // Catch: Exception -> L38
    L31:
        this.f = null;     // Catch: Exception -> L38
        r13.setVisibility(0);     // Catch: Exception -> L38
        if (r11 == null) goto L36;
        r11.setVisibility(0);     // Catch: Exception -> L38
    L36:
        if (r13.getTranslationX() != 0.0f) goto L40;
        final float r30 = r13.getWidth();     // Catch: Exception -> L38
    L41:
        r13.setTranslationX(r30);     // Catch: Exception -> L38
        r13.setAlpha(0.0f);     // Catch: Exception -> L38
        if (r11 == null) goto L45;
        r11.setTranslationX(r30);     // Catch: Exception -> L38
    L45:
        if (r11 == null) goto L48;
        r11.setAlpha(0.0f);     // Catch: Exception -> L38
    L48:
        com.obric.common.oea.foundation.animation.builder.a r31 = new com.obric.common.oea.foundation.animation.builder.a(r13);     // Catch: Exception -> L38
        com.obric.common.oea.foundation.animation.builder.a.a(r31);     // Catch: Exception -> L38
        AnimationProperty$FloatProperty r116 = AnimationProperty$FloatProperty.ALPHA;     // Catch: Exception -> L38
        Float r117 = Float.valueOf(0.0f);     // Catch: Exception -> L38
        com.obric.common.oea.foundation.animation.spec.spring.b r32 = ug.a.m(Token$Bounce.OUI_ANIMATION_BOUNCE_SMOOTH, Token$Duration.OUI_ANIMATION_DURATION_MEDIUM_2);     // Catch: Exception -> L38
        r32.f11323b = 0.01f;     // Catch: Exception -> L38
        Unit r33 = Unit.INSTANCE;     // Catch: Exception -> L38
        r31.c(r116, r117, 1.0f, r32, null);     // Catch: Exception -> L38
        ?? r34 = new FloatingBtnComponent$animateQsbFinish$2(this, r30);     // Catch: Exception -> L38
        Intrinsics.checkNotNullParameter(r34, "callback");     // Catch: Exception -> L38
        r31.d = r34;     // Catch: Exception -> L38
        ?? r35 = new FloatingBtnComponent$animateQsbFinish$3(this);     // Catch: Exception -> L38
        Intrinsics.checkNotNullParameter(r35, "callback");     // Catch: Exception -> L38
        r31.e = r35;     // Catch: Exception -> L38
        this.f = com.obric.common.oea.foundation.animation.builder.b.a(r31.b());     // Catch: Exception -> L38
        return;
    L40:
        r30 = r13.getTranslationX();     // Catch: Exception -> L38
    L38:
        e = move-exception;
        Intrinsics.checkNotNullParameter("FloatingBtnComponent", "tag");
        Intrinsics.checkNotNullParameter("animateQsbFinish error", "msg");
        Intrinsics.checkNotNullParameter(e, "t");
        org.koin.core.a r36 = su.a.f22013b;
        if (r36 == null) goto L54;
        ((ju.b) r36.f20999a.d.b(null, Reflection.getOrCreateKotlinClass(ju.b.class), null)).e("FloatingBtnComponent", "animateQsbFinish error", e);
        return;
    L54:
        throw new IllegalStateException("KoinApplication has not been started");
    L56:
        if (Intrinsics.areEqual(r5, f.f11635a) == false) goto L72;
        jp.d r37 = this.f;
        if (r37 == null) goto L60;
        int r38 = jp.d.d;
        r37.a(false);
    L60:
        this.f = null;
        return;
    }

    @Override // com.obric.flow.cardlistpage.mvi.c
    public final void h() {
        final int r5 = 0;
        View.OnClickListener r10 = new i(this, r5);
        this.d.setOnClickListener(r10);
        OIconButtonFloating r11 = this.e;
        if (r11 == null) goto L6;
        final int r12 = 1;
        r11.setOnClickListener(new i(this, r12));
        return;
    }

    @Override // com.obric.flow.cardlistpage.mvi.c
    public final void j() {
        FloatingBtnComponent$observeState$$inlined$collectState$1 r5 = new FloatingBtnComponent$observeState$$inlined$collectState$1(null, this, this);
        BuildersKt.launch$default((CoroutineScope) this.f11532b, null, null, r5, 3, null);
    }
}
