package com.bytedance.android.livesdk.interactivity.interactive.dialog.provider;

import android.animation.ValueAnimator;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.TextView;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.screen.FoldScreenUtils;
import com.bytedance.android.livesdk.chatroom.ui.t9;
import com.bytedance.android.livesdk.interactivity.interactive.dialog.SkinSelection;
import com.bytedance.android.livesdk.interactivity.interactive.dialog.framework.VSInputSectionType;
import com.bytedance.bdlocation.BuildConfig;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class VsMsgBoardBottomTipSectionProvider implements k82.d {
    public final VSInputSectionType a;
    public k82.a b;
    public View c;
    public TextView d;
    public final Interpolator e;
    public boolean f;
    public VSInputSectionType g;
    public final VsMsgBoardBottomTipSectionProvider$sectionBridge$1 h;
    public final Context i;

    public static final class a {
    }

    static {
    }

    @Override // k82.d
    public final void a() {
    }

    @Override // k82.d
    public final k82.c c() {
        return null;
    }

    @Override // k82.d
    public final void d() {
    }

    @Override // k82.d
    public final void e() {
    }

    @Override // k82.d
    public final VSInputSectionType b() {
        return this.a;
    }

    public final Context getContext() {
        return this.i;
    }

    public VsMsgBoardBottomTipSectionProvider(Context r3) {
        this.i = r3;
        this.a = VSInputSectionType.BOTTOM_TIP;
        this.e = PathInterpolatorCompat.create(0.0f, 0.0f, 0.58f, 1.0f);
        this.g = VSInputSectionType.KEYBOARD;
        this.h = new VsMsgBoardBottomTipSectionProvider$sectionBridge$1(this);
    }

    @Override // k82.d
    public final View g(h82.b r7) {
        Intrinsics.checkNotNullParameter(r7, "panelBridge");
        this.b = r7;
        LayoutInflater r0 = LayoutInflater.from(this.i);
        t9 r1 = r7.h.d;
        if (r1 != null) goto L5;
    L7:
        if (r1 != null) goto L9;
    L11:
        int r2 = 2131567431;
    L12:
        ViewGroup.LayoutParams r3 = null;
        View r4 = r0.inflate(r2, null);
        this.c = r4;
        if (r4 == null) goto L15;
        TextView r5 = (TextView) r4.findViewById(2131364665);
    L16:
        this.d = r5;
        t9 r6 = r7.h.d;
        if (r6 != null) goto L19;
    L27:
        TextView r8 = this.d;
        if (r8 == null) goto L30;
        r3 = r8.getLayoutParams();
    L30:
        t9 r9 = r7.h.d;
        if (r9 != null) goto L33;
    L35:
        double r10 = 0.42d;
    L36:
        if (r3 == null) goto L38;
        r3.width = (int) (((double) com.bytedance.android.annie.util.p.a.e()) * r10);
    L38:
        TextView r11 = this.d;
        if (r11 == null) goto L42;
        r11.setLayoutParams(r3);
    L42:
        return this.c;
    L33:
        if (r9.h != true) goto L35;
        r10 = 0.5d;
        goto L36
    L19:
        if (r6.g != true) goto L27;
        if (r6 == null) goto L24;
        if (r6.h == true) goto L27;
    L24:
        if (FoldScreenUtils.f() == false) goto L42;
        if (FoldScreenUtils.e() == false) goto L42;
    L15:
        r5 = null;
        goto L16
    L9:
        if (r1.g != true) goto L11;
        r2 = 2131567430;
        goto L12
    L5:
        if (r1.h != true) goto L7;
        r2 = 2131567432;
        goto L12
    }

    @Override // k82.d
    public final void h(VSInputSectionType r2, View r3) {
        Intrinsics.checkNotNullParameter(r2, "sectionType");
        Intrinsics.checkNotNullParameter(r3, "view");
        k82.d.a.a(r2, r3);
    }

    public static final void f(VsMsgBoardBottomTipSectionProvider r3, boolean r4, SkinSelection r5) {
        if (r4 == false) goto L21;
        r3.getClass();
        int r0 = l82.a.a;
        String r1 = BuildConfig.FLAVOR;
        if (r5 == null) goto L7;
        String r2 = r5.a;
        if (r2 == null) goto L7;
    L8:
        if (r5 == null) goto L13;
        String r6 = r5.b;
        if (r6 == null) goto L13;
        r1 = r6;
    L13:
        k82.a r7 = r3.b;
        if (r7 == null) goto L16;
        Map<String, String> r8 = r7.o();
    L17:
        Intrinsics.checkNotNullParameter(r2, "skinId");
        Intrinsics.checkNotNullParameter(r1, "badgeId");
        LinkedHashMap r9 = new LinkedHashMap();
        if (r8 == null) goto L20;
        r9.putAll(r8);
    L20:
        r9.put("vs_medal_id", r1);
        r9.put("vs_skin_id", r2);
        Unit r10 = Unit.INSTANCE;
        l82.a.e("livesdk_vs_guest_book_skin_buy_icon_show", r9);
        goto L21
    L16:
        r8 = null;
    L7:
        r2 = BuildConfig.FLAVOR;
    L21:
        k82.a r11 = r3.b;
        if (r11 == null) goto L25;
        r11.w(r4);
    L25:
        if (r4 == r3.f) goto L54;
        r3.f = r4;
        if (r3.g != VSInputSectionType.KEYBOARD) goto L46;
        if (r4 == false) goto L38;
        View r13 = r3.c;
        if (r13 == null) goto L33;
        UtilityKotlinExtentionsKt.z(r13, true);
    L33:
        View r14 = r3.c;
        if (r14 == null) goto L48;
        ViewGroup r15 = UtilityKotlinExtentionsKt.p(r14);
        if (r15 == null) goto L49;
        UtilityKotlinExtentionsKt.z(r15, true);
        return;
    L49:
        return;
    L48:
        return;
    L38:
        View r16 = r3.c;
        if (r16 == null) goto L41;
        UtilityKotlinExtentionsKt.z(r16, false);
    L41:
        View r17 = r3.c;
        if (r17 == null) goto L51;
        ViewGroup r18 = UtilityKotlinExtentionsKt.p(r17);
        if (r18 == null) goto L52;
        UtilityKotlinExtentionsKt.z(r18, false);
        return;
    L52:
        return;
    L51:
        return;
    L46:
        ValueAnimator r19 = ValueAnimator.ofInt(new int[]{0, 1}).setDuration(300);
        r19.addUpdateListener(new u(r3, r4, r19));
        r19.setInterpolator(r3.e);
        r19.start();
        return;
    }
}
