package com.bytedance.android.live.messagewindow.business.util;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.ViewCompat;
import com.bytedance.android.live.core.tetris.layer.core.element.widget.WidgetElement;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.a0;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.utils.v;
import com.bytedance.android.live.room.api.messagewindow.constraint.CardConstraint;
import com.bytedance.android.live.room.api.messagewindow.identity.CardTypeAndPriority;
import com.bytedance.android.livesdk.chatroom.MiddlewareRoomContext;
import com.bytedance.android.livesdk.chatroom.o;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.live.datacontext.m;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import x61.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a {
    public final List<String> a;
    public final CardConstraint b;
    public final int c;
    public final InterfaceC0127a d;

    /* JADX INFO: renamed from: com.bytedance.android.live.messagewindow.business.util.a$a, reason: collision with other inner class name */
    public interface InterfaceC0127a {
        WidgetElement a(Class<? extends Widget> r1, ViewGroup r2, boolean r3, Object[] r4, boolean r5);
    }

    public a(InterfaceC0127a r3) {
        Intrinsics.checkNotNullParameter(r3, "callback");
        this.d = r3;
        this.a = CollectionsKt.listOf(new String[]{CardTypeAndPriority.DrawAndGuess.getType(), CardTypeAndPriority.WatchVideo.getType(), CardTypeAndPriority.AudienceLink.getType(), CardTypeAndPriority.VideoTalk.getType()});
        this.b = new CardConstraint(-2, -2);
        this.c = ColorProtector.parseColor("#88008800");
    }

    public static ViewGroup a(Context r1) {
        FrameLayout r0 = new FrameLayout(r1);
        r0.setId(ViewCompat.generateViewId());
        return r0;
    }

    public static ViewGroup b(v61.a r2) {
        View r3 = r2.d;
        if ((r3 instanceof ViewGroup) == true) goto L5;
        r3 = null;
    L5:
        ViewGroup r4 = (ViewGroup) r3;
        if (r4 != null) goto L8;
        return null;
    L8:
        if (r4.getTag(2131389887) == null) goto L10;
        boolean r0 = true;
    L11:
        if (r0 == true) goto L13;
        return null;
    L13:
        return r4;
    L10:
        r0 = false;
        goto L11
    }

    public static void c(View r4, CardConstraint r5) {
        Intrinsics.checkNotNullParameter(r4, "cardContainer");
        Intrinsics.checkNotNullParameter(r5, "constraint");
        ViewGroup.LayoutParams r0 = r4.getLayoutParams();
        if ((r0 instanceof ConstraintLayout.LayoutParams) == true) goto L5;
        r0 = null;
    L5:
        ConstraintLayout.LayoutParams r1 = (ConstraintLayout.LayoutParams) r0;
        if (r1 != null) goto L9;
        r1 = new ConstraintLayout.LayoutParams(r5.f, r5.g);
    L9:
        if ((r5 instanceof CardConstraint) == true) goto L12;
        r5 = new CardConstraint(r5);
    L12:
        ((ViewGroup.MarginLayoutParams) r1).leftMargin = r5.b;
        ((ViewGroup.MarginLayoutParams) r1).topMargin = r5.c;
        ((ViewGroup.MarginLayoutParams) r1).rightMargin = r5.d;
        ((ViewGroup.MarginLayoutParams) r1).bottomMargin = r5.e;
        ((ViewGroup.MarginLayoutParams) r1).width = r5.f;
        ((ViewGroup.MarginLayoutParams) r1).height = r5.g;
        CardConstraint.Position r6 = r5.a;
        int r7 = b.a[r6.ordinal()];
        if (r7 != 1) goto L15;
        r1.topToTop = 0;
        r1.leftToLeft = 0;
        r1.bottomToBottom = -1;
    L22:
        r4.setLayoutParams(r1);
        return;
    L15:
        if (r7 != 2) goto L17;
        r1.topToTop = 0;
        r1.rightToRight = 0;
        r1.bottomToBottom = -1;
        goto L22
    L17:
        if (r7 == 3) goto L19;
        r1.bottomToBottom = 0;
        r1.rightToRight = 0;
        r1.topToTop = -1;
        goto L22
    L19:
        r1.topToTop = 0;
        r1.rightToRight = 0;
        r1.bottomToBottom = 0;
        goto L22
    }

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
    public final void d(Context r19, ViewGroup r20, v61.a r21, Function3<? super v61.a, ? super ViewGroup, ? super WidgetElement, Unit> r22) {
        Intrinsics.checkNotNullParameter(r19, "context");
        Intrinsics.checkNotNullParameter(r20, "rootView");
        Intrinsics.checkNotNullParameter(r21, "window");
        Intrinsics.checkNotNullParameter(r22, "onLoaded");
        x61.c r5 = r21.content();
        if ((r5 instanceof x61.c) == false) goto L25;
        ViewGroup r6 = b(r21);
        if (r6 != null) goto L81;
        r6 = a(r19);
        View r1 = (View) r5.a(new x61.c.a(r19, r6));
        ViewParent r7 = r1.getParent();
        if (r7 != null) goto L9;
    L23:
        r6.addView(r1);
        Unit r2 = Unit.INSTANCE;
        goto L81
    L9:
        if (v.a() == true) goto L22;
        if ((!Intrinsics.areEqual(r7, r6)) == true) goto L14;
        r7 = null;
    L14:
        if (r7 == null) goto L23;
        if ((r7 instanceof ViewGroup) == true) goto L18;
        r7 = null;
    L18:
        ViewGroup r8 = (ViewGroup) r7;
        if (r8 == null) goto L23;
        r8.clearAnimation();
        r8.removeView(r1);
        r6.addView(r1);
        goto L81
    L22:
        throw new IllegalStateException("card view must not be attached when created. Ensure that you are not passing 'true' to the attachToRoot parameter of LayoutInflater.inflate(..., boolean attachToRoot)");
    L81:
        ViewGroup r3 = r6;
    L82:
        WidgetElement r12 = null;
    L86:
        if (r3 == null) goto L118;
        c(r3, r21.z());
        r3.setTag(2131389887, "cardContainer");
        Intrinsics.checkNotNullParameter(r3, "container");
        r21.d = r3;
        if (r21.e == true) goto L90;
        r21.N(r3);
        r21.e = true;
    L90:
        ViewParent r9 = r3.getParent();
        if ((r9 instanceof ViewGroup) == true) goto L93;
        ViewParent r11 = null;
    L94:
        ViewGroup r13 = (ViewGroup) r11;
        if (r13 == null) goto L98;
        r13.removeView(r3);
    L98:
        if (CollectionsKt.contains(this.a, r21.j) == false) goto L100;
        r20.addView(r3, 0);
    L102:
        if (v.a() == false) goto L118;
        if (r21.C() == false) goto L106;
    L107:
        TextView r10 = new TextView(r20.getContext());
        r10.setBackgroundColor(this.c);
        r10.setTextColor(-1);
        r10.setText("id：" + r21.j);
        r10.setGravity(8388693);
        if ((r3 instanceof FrameLayout) == false) goto L111;
        ConstraintLayout.LayoutParams r4 = new FrameLayout.LayoutParams(-2, -2);
        ((FrameLayout.LayoutParams) r4).gravity = 8388693;
    L117:
        r10.setLayoutParams(r4);
        r3.addView(r10);
        goto L118
    L111:
        if ((r3 instanceof RelativeLayout) == false) goto L114;
        ConstraintLayout.LayoutParams r14 = new RelativeLayout.LayoutParams(-2, -2);
        r14.addRule(12, -1);
        r14.addRule(21, -1);
        r4 = r14;
        goto L117
    L114:
        if ((r3 instanceof ConstraintLayout) == false) goto L116;
        r4 = new ConstraintLayout.LayoutParams(-2, -2);
        r4.rightToRight = 0;
        r4.bottomToBottom = 0;
        goto L117
    L116:
        r4 = new ViewGroup.LayoutParams(-2, -2);
        goto L117
    L106:
        if (v71.a.e() == false) goto L118;
    L100:
        r20.addView(r3);
        goto L102
    L93:
        r11 = r9;
    L118:
        r22.invoke(r21, r3, r12);
        return;
    L25:
        if ((r5 instanceof x61.b) == false) goto L32;
        int r15 = ((Number) ((x61.b) r5).a(Unit.INSTANCE)).intValue();
        if (r15 <= 0) goto L85;
        r6 = b(r21);
        if (r6 != null) goto L81;
        r6 = a(r19);
        LayoutInflater.from(r19).inflate(r15, r6, true);
    L85:
        r3 = null;
        goto L82
    L32:
        if ((r5 instanceof d) == false) goto L44;
        d r16 = (d) r5;
        Class<? extends Widget> r17 = (Class) r16.a(Unit.INSTANCE);
        ViewGroup r18 = b(r21);
        if (r18 != null) goto L36;
        r18 = r16.c(new d.a(r19, r20));
    L36:
        if (r18 != null) goto L38;
        r18 = a(r19);
    L38:
        r3 = r18;
        r3.removeAllViewsInLayout();
        r12 = this.d.a(r17, r3, false, null, false);
        if (r12 == null) goto L86;
        Widget r23 = (Widget) r12.f(r17);
        if (r23 == null) goto L86;
        r16.b(r23);
        goto L86
    L44:
        if ((r5 instanceof x61.a) == false) goto L84;
        if (v71.a.e() == false) goto L85;
        r6 = b(r21);
        if (r6 != null) goto L81;
        if (Intrinsics.areEqual(this.b, r21.z()) == false) goto L80;
        final int r24 = UtilityKotlinExtentionsKt.i(12);
        DataCenter r25 = r21.getDataCenter();
        o r110 = z51.a.h(r25, 2);
        if (r25 != null) goto L54;
    L57:
        boolean r111 = true;
    L58:
        final Ref.IntRef r112 = new Ref.IntRef();
        MiddlewareRoomContext r26 = MiddlewareRoomContext.a.c(MiddlewareRoomContext.Companion, r25, 0, 2);
        if (r26 == null) goto L67;
        m r27 = r26.getOpenVoiceKtvRoom();
        if (r27 == null) goto L67;
        if (((Boolean) r27.getValue()).booleanValue() != true) goto L67;
        if (((Boolean) m71.d.a.getValue()).booleanValue() == false) goto L67;
        int r28 = UtilityKotlinExtentionsKt.i(128);
    L76:
        r112.element = r28;
        if (PadConfigUtils.c() == false) goto L79;
        r112.element += s1.f(8.0f);
    L79:
        int r29 = CardConstraint.h;
        CardConstraint r30 = new CardConstraint(UtilityKotlinExtentionsKt.i(112), -2);
        r30.a(new CardContentHelper$getDebugCardConstraint$1(r24, r112));
        r30.b(CardConstraint.Position.BottomRight);
        r21.P(r30);
    L67:
        if (r111 == true) goto L69;
        r28 = UtilityKotlinExtentionsKt.i(76);
        goto L76
    L69:
        if (r110 != null) goto L71;
    L75:
        r28 = s1.j(com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.a.a(Boolean.valueOf(a0.d(r25, false))));
        goto L76
    L71:
        if (r110.isVSFirstShow() != true) goto L75;
        if (Intrinsics.areEqual(r110.isVSVerticalStream(), Boolean.TRUE) == false) goto L75;
        r28 = UtilityKotlinExtentionsKt.i(54) + s1.f(r110.getVsVerticalProgressBarHeight());
        goto L76
    L54:
        if (a0.l(r25, true) == true) goto L57;
        r111 = false;
    L80:
        r6 = a(r19);
        r6.setBackgroundColor(1711276032);
        goto L81
    L84:
        if (v.a() == false) goto L85;
        throw new IllegalArgumentException("the card content type is unknown");
    }
}
