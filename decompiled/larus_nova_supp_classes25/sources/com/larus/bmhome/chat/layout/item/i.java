package com.larus.bmhome.chat.layout.item;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import com.larus.common.apphost.AppHost;
import com.larus.platform.api.IFlowThemeConfigProvider;
import com.larus.platform.api.ThemeColorKey;
import com.larus.platform.api.ThemeConfigScene;
import com.larus.platform.model.apptheme.AdaptThemeFeatureKey;
import com.obric.assistant.spi.chat.ObricChatSPIServiceDelegate;
import com.obric.assistant.spi.window.ChatWindowServiceDelegate;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import v19.c7;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public class i extends LinearLayout {
    public static final boolean o = false;
    public boolean a;
    public final f1 b;
    public Integer c;
    public boolean d;
    public dh8.a e;
    public boolean f;
    public Boolean g;
    public Function1<? super Boolean, Unit> h;
    public final int[] i;
    public Integer j;
    public boolean k;
    public int l;
    public int m;
    public int n;

    public static final class a {
    }

    static {
        o = com.larus.platform.service.z2.a.G2();
    }

    public Drawable getInboxBackground() {
        return com.larus.utils.e1.j(this, c7.c(Float.valueOf(16.0f)), v19.c.b(2130970533, getContext(), 2131102542));
    }

    public int getMaxWidth() {
        Integer r0 = this.c;
        if (r0 == null) goto L6;
        return r0.intValue();
    L6:
        return j();
    }

    public final int j() {
        Resources r0 = getResources();
        if (getImmerseBgColor() == null) goto L5;
        int r1 = r0.getDimensionPixelSize(2131167566);
        int r2 = r0.getDimensionPixelSize(2131167565);
    L6:
        int r3 = r1 + r2;
        Lazy r4 = com.larus.bmhome.utils.z1.a;
        t1a.b r5 = ei9.c.a(this);
        if (r5 == null) goto L11;
        va8.m r6 = r5.getAbility(va8.m.class);
        if (r6 == null) goto L11;
        Fragment r7 = r6.getChatFragment();
    L13:
        return RangesKt.coerceAtLeast(com.larus.bmhome.utils.z1.e(r7) - r3, i5.B());
    L11:
        r7 = null;
        goto L13
    L5:
        r1 = r0.getDimensionPixelSize(2131167568);
        r2 = r0.getDimensionPixelSize(2131167563);
        goto L6
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.b.e = -1;
    }

    public int getBoxType() {
        return this.l;
    }

    public Integer getImmerseBgColor() {
        return this.j;
    }

    public boolean getUseSubscribedColor() {
        return this.k;
    }

    public i(Context r2) {
        super(r2);
        setOrientation(1);
        setLayoutParams(new ConstraintLayout.LayoutParams(-2, -2));
        this.b = new f1(0);
        this.i = new int[2];
        this.l = -1;
        this.n = -1;
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration r4) {
        super.onConfigurationChanged(r4);
        com.larus.platform.service.e2 r0 = com.larus.platform.service.e2.a;
        Context r1 = getContext();
        if ((r1 instanceof Activity) == false) goto L5;
        Activity r2 = (Activity) r1;
    L7:
        if (r0.a(r2, r4) == false) goto L9;
        this.b.e = -1;
    L9:
        int r5 = getResources().getConfiguration().uiMode & 48;
        if (r5 == this.m) goto L14;
        this.m = r5;
        this.d = true;
        setBoxType(getBoxType());
        return;
    L14:
        return;
    L5:
        r2 = null;
        goto L7
    }

    public void setBoxType(int r13) {
        boolean r1 = true;
        if (this.d == true) goto L5;
    L7:
        boolean r0 = false;
    L8:
        this.d = false;
        this.l = r13;
        Drawable r3 = null;
        if (r0 == true) goto L12;
        this.c = null;
    L12:
        if (r13 != 0) goto L14;
        ed8.j.a.getClass();
        Intrinsics.checkNotNullParameter(this, "boxView");
        Context r14 = getContext();
        if (r14 != null) goto L60;
    L61:
        iga.d r15 = null;
    L63:
        if (r15 == null) goto L93;
        String r16 = StringsKt.trim(r15.a).toString();
        if (r16.length() != 0) goto L68;
        boolean r5 = true;
    L69:
        if (r5 == false) goto L72;
    L81:
        Integer r17 = null;
    L91:
        if (r17 == null) goto L93;
        Drawable r18 = com.larus.utils.e1.e(i5.q(), r17.intValue());
    L94:
        if (r18 != null) goto L96;
        r1 = false;
    L97:
        if (r1 == false) goto L99;
    L111:
        ViewGroup.LayoutParams r19 = getLayoutParams();
        if (r19 == null) goto L121;
        ConstraintLayout.LayoutParams r110 = (ConstraintLayout.LayoutParams) r19;
        Lazy r2 = com.larus.bmhome.utils.z1.a;
        t1a.b r4 = ei9.c.a(this);
        if (r4 == null) goto L118;
        va8.m r6 = r4.getAbility(va8.m.class);
        if (r6 == null) goto L118;
        r3 = r6.getChatFragment();
    L118:
        r110.setMarginStart(com.larus.bmhome.utils.z1.f(r3));
        r110.setMarginEnd(0);
        setLayoutParams(r110);
        return;
    L121:
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
    L99:
        if (getImmerseBgColor() == null) goto L107;
        Integer r111 = getImmerseBgColor();
        if (r111 == null) goto L111;
        int r112 = r111.intValue();
        if (com.larus.platform.service.z2.a.enableUgcBotBlockSwitch() == false) goto L105;
        Drawable r113 = com.larus.utils.e1.e(i5.q(), r112);
    L106:
        setBackground(r113);
        goto L111
    L105:
        r113 = com.larus.utils.e1.f(getWidth(), getHeight(), i5.q(), r112);
        goto L106
    L107:
        Drawable r114 = getInboxBackground();
        IFlowThemeConfigProvider r7 = (IFlowThemeConfigProvider) ServiceManager.get().getService(IFlowThemeConfigProvider.class);
        if (r7 == null) goto L110;
        ThemeConfigScene r8 = ThemeConfigScene.CHAT;
        ThemeColorKey r9 = ThemeColorKey.MESSAGE_RECEIVE_BUBBLE_COLOR;
        AdaptThemeFeatureKey r10 = AdaptThemeFeatureKey.RECEIVE_MESSAGE_BUBBLE;
        boolean r11 = v19.h.a;
        r7.g(r114, r9, r8, r10, Boolean.valueOf(v19.h.b(getContext())));
    L110:
        setBackground(r114);
        goto L111
    L96:
        setBackground(r18);
        goto L97
    L72:
        if (StringsKt.startsWith$default(r16, "#", false, 2, null) == false) goto L75;
        r16 = r16.substring(1);
    L77:
        int r12 = r16.length();
        if (r12 != 6) goto L80;
        r16 = "FF".concat(r16);
    L122:
        Result.Companion r20 = Result.Companion;     // Catch: Throwable -> L85
        Object r115 = Result.constructor-impl(Integer.valueOf(Color.parseColor("#" + r16)));     // Catch: Throwable -> L85
    L88:
        if (Result.isFailure-impl(r115) == false) goto L90;
        r115 = null;
    L90:
        r17 = (Integer) r115;
    L85:
        th = move-exception;
        Result.Companion r21 = Result.Companion;
        r115 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L88
    L80:
        if (r12 == 8) goto L122;
    L75:
        if (StringsKt.startsWith(r16, "0x", true) == false) goto L77;
        r16 = r16.substring(2);
        goto L77
    L68:
        r5 = false;
    L93:
        r18 = null;
        goto L94
    L60:
        if (ChatWindowServiceDelegate.b.d(r14) == false) goto L61;
        ObricChatSPIServiceDelegate r22 = ObricChatSPIServiceDelegate.b;
        boolean r23 = v19.h.a;
        r15 = r22.e(v19.h.b(r14));
        goto L63
    L14:
        if (r13 == 1) goto L36;
        if (r13 != 2) goto L17;
        Resources r116 = AppHost.a.getApplication().getResources();
        Lazy r24 = com.larus.bmhome.utils.z1.a;
        t1a.b r25 = ei9.c.a(this);
        if (r25 == null) goto L30;
        va8.m r26 = r25.getAbility(va8.m.class);
        if (r26 == null) goto L30;
        r3 = r26.getChatFragment();
    L30:
        this.c = Integer.valueOf(com.larus.bmhome.utils.z1.e(r3) - (r116.getDimensionPixelSize(2131167568) * 2));
        ViewGroup.LayoutParams r117 = getLayoutParams();
        if (r117 == null) goto L34;
        ConstraintLayout.LayoutParams r118 = (ConstraintLayout.LayoutParams) r117;
        r118.setMarginStart(getResources().getDimensionPixelSize(2131167568));
        r118.setMarginEnd(getResources().getDimensionPixelSize(2131167568));
        setLayoutParams(r118);
        return;
    L34:
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
    L17:
        if (r13 != 3) goto L127;
        Lazy r119 = com.larus.bmhome.utils.z1.a;
        t1a.b r120 = ei9.c.a(this);
        if (r120 == null) goto L24;
        va8.m r121 = r120.getAbility(va8.m.class);
        if (r121 == null) goto L24;
        r3 = r121.getChatFragment();
    L24:
        this.c = Integer.valueOf(com.larus.bmhome.utils.z1.e(r3));
        return;
    L127:
        return;
    L36:
        if (getImmerseBgColor() == null) goto L39;
        r3 = ContextCompat.getDrawable(getContext(), 2131239376);
    L47:
        setBackground(r3);
        ViewGroup.LayoutParams r122 = getLayoutParams();
        if (r122 == null) goto L55;
        ConstraintLayout.LayoutParams r123 = (ConstraintLayout.LayoutParams) r122;
        if (com.larus.platform.service.e2.a.isPad() == false) goto L52;
        int r27 = 0;
    L53:
        r123.setMarginEnd(r27);
        r123.setMarginStart(0);
        setLayoutParams(r123);
        return;
    L52:
        r27 = getResources().getDimensionPixelSize(2131167568);
        goto L53
    L55:
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
    L39:
        if (getUseSubscribedColor() == false) goto L41;
        r3 = ContextCompat.getDrawable(getContext(), 2131239378);
        goto L47
    L41:
        Drawable r124 = ContextCompat.getDrawable(getContext(), v19.c.b(2130970743, getContext(), 2131239374));
        if (r124 == null) goto L47;
        IFlowThemeConfigProvider r28 = (IFlowThemeConfigProvider) ServiceManager.get().getService(IFlowThemeConfigProvider.class);
        if (r28 == null) goto L46;
        ThemeConfigScene r29 = ThemeConfigScene.CHAT;
        ThemeColorKey r30 = ThemeColorKey.MESSAGE_BUBBLE_COLOR;
        AdaptThemeFeatureKey r125 = AdaptThemeFeatureKey.SEND_MESSAGE_BUBBLE;
        boolean r31 = v19.h.a;
        r28.g(r124, r30, r29, r125, Boolean.valueOf(v19.h.b(getContext())));
    L46:
        r3 = r124;
        goto L47
    L5:
        if (this.l != r13) goto L7;
        r0 = true;
        goto L8
    }

    public void setImmerseBgColor(Integer r1) {
        this.j = r1;
        if (o == false) goto L6;
        setMaxWidth(j());
        return;
    }

    public void setMaxWidth(int r1) {
        this.c = Integer.valueOf(r1);
    }

    public final void setRequestFocus(boolean r1) {
        this.a = r1;
    }

    public void setUseSubscribedColor(boolean r1) {
        this.k = r1;
    }

    public static View h(View r4, Class r5) {
        Intrinsics.checkNotNullParameter(r4, "parentView");
        Intrinsics.checkNotNullParameter(r5, "targetType");
        if ((r4 instanceof ViewGroup) == false) goto L14;
        ViewGroup r6 = (ViewGroup) r4;
        int r0 = r6.getChildCount();
        int r1 = 0;
    L5:
        if (r1 >= r0) goto L19;
        View r2 = r6.getChildAt(r1);
        if (r5.isInstance(r2) == true) goto L8;
        Intrinsics.checkNotNull(r2);
        View r3 = h(r2, r5);
        if (r3 != null) goto L12;
        r1 = r1 + 1;
        goto L5
    L12:
        return r3;
    L8:
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type T of com.larus.bmhome.chat.layout.item.BaseMessageBox.findChildViewByType");
        return r2;
    L19:
        return null;
    L14:
        return null;
    }

    public void l(boolean r6, boolean r7) {
        Lazy r0 = com.larus.bmhome.utils.z1.a;
        if (com.larus.bmhome.utils.z1.c(getBoxType(), getImmerseBgColor(), r6, r7) == false) goto L27;
        f1 r1 = this.b;
        Fragment r3 = null;
        if (r1.e != (-1)) goto L13;
        int r2 = getBoxType();
        Integer r4 = getImmerseBgColor();
        t1a.b r5 = ei9.c.a(this);
        if (r5 == null) goto L11;
        va8.m r8 = r5.getAbility(va8.m.class);
        if (r8 == null) goto L11;
        r3 = r8.getChatFragment();
    L11:
        int r9 = com.larus.bmhome.utils.z1.g(r2, r4, r6, r7, Integer.valueOf(com.larus.bmhome.utils.z1.e(r3)));
        f1 r10 = this.b;
        r10.e = r9;
        r10.a = getBoxType();
        r10.b = getImmerseBgColor();
        r10.c = Boolean.valueOf(r6);
        r10.d = Boolean.valueOf(r7);
        int r11 = this.b.e;
    L28:
        this.c = Integer.valueOf(r11);
        ViewGroup.LayoutParams r12 = getLayoutParams();
        if (r12 != null) goto L31;
        return;
    L31:
        if (r12.width == r11) goto L35;
        r12.width = r11;
        setLayoutParams(r12);
        return;
    L35:
        return;
    L13:
        if (Intrinsics.areEqual(r1.c, Boolean.valueOf(r6)) == true) goto L15;
    L21:
        int r13 = getBoxType();
        Integer r14 = getImmerseBgColor();
        t1a.b r15 = ei9.c.a(this);
        if (r15 == null) goto L26;
        va8.m r16 = r15.getAbility(va8.m.class);
        if (r16 == null) goto L26;
        r3 = r16.getChatFragment();
    L26:
        int r17 = com.larus.bmhome.utils.z1.g(r13, r14, r6, r7, Integer.valueOf(com.larus.bmhome.utils.z1.e(r3)));
        f1 r18 = this.b;
        r18.e = r17;
        r18.a = getBoxType();
        r18.b = getImmerseBgColor();
        r18.c = Boolean.valueOf(r6);
        r18.d = Boolean.valueOf(r7);
        r11 = this.b.e;
        goto L28
    L15:
        if (Intrinsics.areEqual(this.b.d, Boolean.valueOf(r7)) == false) goto L21;
        if (this.b.a != getBoxType()) goto L21;
        if (Intrinsics.areEqual(this.b.b, getImmerseBgColor()) == false) goto L21;
        r11 = this.b.e;
        goto L28
    L27:
        r11 = j();
        goto L28
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int r7, int r8) {
        Lazy r0 = com.larus.bmhome.utils.z1.a;
        t1a.b r1 = ei9.c.a(this);
        dh8.a r2 = null;
        if (r1 == null) goto L7;
        va8.m r3 = r1.getAbility(va8.m.class);
        if (r3 == null) goto L7;
        Fragment r4 = r3.getChatFragment();
    L8:
        int r5 = com.larus.bmhome.utils.z1.e(r4);
        final boolean r6 = false;
        if (this.n == r5) goto L20;
        if (r5 <= 0) goto L20;
        this.n = r5;
        this.c = null;
        f1 r9 = this.b;
        r9.e = -1;
        Boolean r10 = r9.c;
        if (r10 == null) goto L14;
        boolean r11 = r10.booleanValue();
    L15:
        Boolean r12 = this.b.d;
        if (r12 == null) goto L18;
        boolean r13 = r12.booleanValue();
    L19:
        l(r11, r13);
        goto L20
    L18:
        r13 = false;
        goto L19
    L14:
        r11 = false;
    L20:
        i(r7, r8, this.i);
        int[] r14 = this.i;
        super.onMeasure(r14[0], r14[1]);
        int r15 = getMeasuredHeight();
        dh8.a r16 = this.e;
        if (r16 == null) goto L41;
        dh8.b r17 = dh8.b.a;
        Context r18 = getContext();
        r17.getClass();
        Intrinsics.checkNotNullParameter(r18, "context");
        Intrinsics.checkNotNullParameter(r16, "config");
        if (r16.a == true) goto L26;
    L38:
        r2 = r16;
        this.e = r2;
        goto L41
    L26:
        if (Intrinsics.areEqual(r16.h, "send") == false) goto L28;
        int r19 = ra9.a.a;
        boolean r20 = ga9.a.b("message_send_long_message_collapse_enabled", false);
    L29:
        if (r20 == true) goto L31;
        r16 = dh8.a.a(r16, 0, 0, false, 32766);
        goto L38
    L31:
        int r21 = dh8.b.b(r18);
        int r22 = dh8.b.e(r21);
        if (Intrinsics.areEqual(r16.h, "send") == false) goto L35;
        r21 = r21 / 3;
    L35:
        if (r16.b == r22) goto L37;
    L39:
        r16 = dh8.a.a(r16, r22, r21, false, 32761);
        goto L38
    L37:
        if (r16.c != r21) goto L39;
    L28:
        int r23 = ra9.a.a;
        r20 = ga9.a.b("message_reply_long_message_collapse_enabled", false);
    L41:
        if (r2 != null) goto L43;
    L71:
        setClipToOutline(r6);
        if (r6 == false) goto L78;
        if (r2 == null) goto L76;
        setMeasuredDimension(getMeasuredWidth(), r2.b);
        goto L78
    L76:
        throw new IllegalArgumentException("Required value was null.".toString());
    L78:
        if (this.f == r6) goto L100;
        this.f = r6;
        final dh8.a r24 = this.e;
        if (r24 == null) goto L97;
        if (r6 == false) goto L84;
    L85:
        dh8.b r25 = dh8.b.a;
        String r26 = r24.g;
        String r27 = r24.f;
        r25.getClass();
        Intrinsics.checkNotNullParameter(r26, "stateScope");
        Intrinsics.checkNotNullParameter(r27, "messageKey");
        if (StringsKt.isBlank(r26) == true) goto L97;
        if (StringsKt.isBlank(r27) == true) goto L97;
        String r28 = dh8.b.d(r26, r27);
        if (r6 == false) goto L96;
        LinkedHashSet r29 = dh8.b.e;
        r29.remove(r28);
        r29.add(r28);
    L93:
        LinkedHashSet r30 = dh8.b.e;
        if (r30.size() <= 500) goto L97;
        r30.remove(CollectionsKt.first(r30));
        goto L93
    L96:
        dh8.b.e.remove(r28);
        goto L97
    L84:
        if (r24.d == false) goto L85;
    L97:
        final Function1<? super Boolean, Unit> r31 = this.h;
        post(new h(this, r24, r31, r6));
        return;
    L100:
        return;
    L43:
        if (r2.a == true) goto L45;
    L47:
        boolean r32 = false;
    L48:
        if (r32 == false) goto L68;
        if (r15 <= 0) goto L68;
        Boolean r33 = this.g;
        if (r33 == null) goto L53;
        boolean r34 = r33.booleanValue();
    L64:
        if (r34 == false) goto L68;
        if (r15 <= r2.b) goto L68;
        boolean r35 = true;
    L69:
        if (r35 != true) goto L71;
        r6 = true;
        goto L71
    L53:
        dh8.b r36 = dh8.b.a;
        String r37 = r2.f;
        r36.getClass();
        Intrinsics.checkNotNullParameter(r37, "key");
        Map r38 = dh8.b.j;
        Boolean r39 = (Boolean) ((LinkedHashMap) r38).get(r37);
        if (r39 == null) goto L57;
        r34 = r39.booleanValue();
        goto L64
    L57:
        if (r15 <= Math.max(r2.c, r2.b)) goto L59;
        boolean r40 = true;
    L60:
        String r41 = r2.f;
        Intrinsics.checkNotNullParameter(r41, "key");
        if (r38.containsKey(r41) == true) goto L63;
        r38.put(r41, Boolean.valueOf(r40));
    L63:
        r34 = r40;
        goto L64
    L59:
        r40 = false;
    L68:
        r35 = false;
        goto L69
    L45:
        if (r2.d == true) goto L47;
        r32 = true;
    L7:
        r4 = null;
        goto L8
    }

    public void i(int r2, int r3, int[] r4) {
        Intrinsics.checkNotNullParameter(r4, "outSpec");
        r4[0] = View.MeasureSpec.makeMeasureSpec(getMaxWidth(), Integer.MIN_VALUE);
        r4[1] = r3;
    }
}
