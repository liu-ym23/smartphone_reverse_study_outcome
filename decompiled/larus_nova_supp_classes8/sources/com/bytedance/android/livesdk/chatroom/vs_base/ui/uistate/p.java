package com.bytedance.android.livesdk.chatroom.vs_base.ui.uistate;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.android.live.commonui.LiveSettingKeys;
import com.bytedance.android.live.core.setting.SettingKey;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.chatroom.vs_base.base.util.ReplayRoomFragmentScopeUtil;
import com.bytedance.android.livesdk.chatroom.vs_base.util.UtilityKotlinExtentionsKt;
import com.bytedance.android.livesdk.chatroom.vs_base.util.t;
import com.bytedance.android.livesdkapi.model.VSFoldFixConfig;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class p extends ir1.c {
    public p() {
    }

    public final ConstraintLayout.LayoutParams o(Integer r9, Integer r10, Context r11) {
        Intrinsics.checkNotNullParameter(r11, "context");
        if (r10 == null) goto L5;
        int r12 = r10.intValue();
    L6:
        if (r9 == null) goto L8;
        int r13 = r9.intValue();
    L9:
        boolean r1 = true;
        if (r12 <= r13) goto L12;
        boolean r2 = true;
    L13:
        SettingKey r3 = LiveSettingKeys.LIVE_VS_FOLD_FIX_CONFIG;
        if (((VSFoldFixConfig) r3.getValue()).getEnable() == true) goto L16;
    L18:
        if (r2 == false) goto L20;
    L21:
        if (r2 == true) goto L23;
    L29:
        if (r2 == false) goto L31;
    L39:
        float r4 = 74.0f;
        if (r2 == false) goto L52;
        int r7 = com.bytedance.android.livesdk.chatroom.vs_base.util.m.a;
        Resources r8 = r11.getResources();
        if (r8 == null) goto L44;
        Configuration r14 = r8.getConfiguration();
    L46:
        if (com.bytedance.android.livesdk.chatroom.vs_base.util.m.b(r14) == false) goto L52;
        l();
        if (g() == false) goto L51;
        r4 = 0.0f;
    L51:
        int r15 = s1.f(r4);
        ConstraintLayout.LayoutParams r16 = new ConstraintLayout.LayoutParams(-1, -1);
        r16.topToTop = 0;
        ((ViewGroup.MarginLayoutParams) r16).topMargin = 0;
        r16.bottomToBottom = 0;
        ((ViewGroup.MarginLayoutParams) r16).bottomMargin = r15;
        return r16;
    L44:
        r14 = null;
    L52:
        if (r2 == false) goto L67;
        if (r12 > r13) goto L57;
        r1 = false;
    L57:
        if (l() == true) goto L60;
        if (r1 == true) goto L60;
    L62:
        r4 = 0.0f;
    L63:
        int r17 = s1.f(r4);
        int r18 = t.e() - r17;
        if (r11 == null) goto L66;
        com.bytedance.android.livesdk.chatroom.vs_base.base.d r19 = ReplayRoomFragmentScopeUtil.a;
        r18 = ((n) ReplayRoomFragmentScopeUtil.a(n.class)).o(r11) - r17;
    L66:
        ConstraintLayout.LayoutParams r20 = new ConstraintLayout.LayoutParams(-1, r18);
        r20.topToTop = 0;
        ((ViewGroup.MarginLayoutParams) r20).topMargin = 0;
        return r20;
    L60:
        if (g() == true) goto L62;
    L67:
        ConstraintLayout.LayoutParams r21 = new ConstraintLayout.LayoutParams(-1, 0);
        ((ViewGroup.MarginLayoutParams) r21).topMargin = (int) UtilityKotlinExtentionsKt.b(lr1.b.a());
        r21.dimensionRatio = "H,16:9";
        r21.topToTop = 0;
        r21.bottomToBottom = -1;
        return r21;
    L31:
        if (g() == true) goto L37;
        if (((VSFoldFixConfig) r3.getValue()).getEnable() == false) goto L39;
        if (a() == false) goto L39;
    L37:
        if (d() == false) goto L39;
        int r22 = t.a;
        DisplayMetrics r23 = s1.q(s1.getContext());
        int r24 = Math.max(r23.heightPixels, r23.widthPixels) - com.bytedance.android.livesdk.chatroom.vs_base.util.o.a;
        ConstraintLayout.LayoutParams r110 = new ConstraintLayout.LayoutParams(r24, (int) (r24 * 0.5625f));
        ((ViewGroup.MarginLayoutParams) r110).topMargin = 0;
        r110.dimensionRatio = "H,16:9";
        r110.topToTop = 0;
        r110.bottomToBottom = -1;
        return r110;
    L23:
        if (g() == false) goto L25;
    L70:
        return new ConstraintLayout.LayoutParams(-1, -1);
    L25:
        if (((VSFoldFixConfig) r3.getValue()).getEnable() == false) goto L29;
        if (a() == false) goto L29;
    L20:
        if (b() == true) goto L70;
    L16:
        if (a() == false) goto L18;
        ConstraintLayout.LayoutParams r25 = new ConstraintLayout.LayoutParams(-1, 0);
        ((ViewGroup.MarginLayoutParams) r25).topMargin = (int) UtilityKotlinExtentionsKt.b(lr1.b.a());
        r25.dimensionRatio = "H,16:9";
        r25.topToTop = 0;
        r25.bottomToBottom = -1;
        return r25;
    L12:
        r2 = false;
        goto L13
    L8:
        r13 = 0;
        goto L9
    L5:
        r12 = 0;
        goto L6
    }
}
