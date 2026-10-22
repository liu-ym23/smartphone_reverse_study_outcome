package com.larus.dora.obric.device_management.setting.g.gesture;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.core.view.ViewGroupKt;
import com.airbnb.lottie.LottieAnimationView;
import com.larus.dora.impl.databinding.LarusDoraPageObricGGestureOptionsBinding;
import com.larus.dora.impl.device.settings.gesture.DoraGGestureSettings;
import com.larus.dora.impl.resource.DoraResourceDeviceType;
import com.larus.dora.impl.resource.j0;
import com.larus.dora.impl.util.u;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.sectiontitlebar.OSectionTitleBar;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class i<T> implements FlowCollector {
    public final /* synthetic */ DoraObricGGestureOptionsFragment a;

    public i(DoraObricGGestureOptionsFragment r1) {
        this.a = r1;
    }

    public final Object emit(Object r21, Continuation r22) {
        com.larus.dora.impl.device.settings.gesture.options.q r1 = (com.larus.dora.impl.device.settings.gesture.options.q) r21;
        g49.d.d("DoraObricGGestureOptionsFragment", "selectedGestureStateFlow collect: " + r1);
        if ((r1 instanceof com.larus.dora.impl.device.settings.gesture.options.q.b) == false) goto L148;
        DoraGGestureSettings r2 = ((com.larus.dora.impl.device.settings.gesture.options.q.b) r1).a;
        DoraObricGGestureOptionsFragment r3 = this.a;
        int r4 = DoraObricGGestureOptionsFragment.j;
        DoraResourceDeviceType r5 = (DoraResourceDeviceType) r3.i.getValue();
        DoraResourceDeviceType r6 = DoraResourceDeviceType.G1;
        if (r5 != r6) goto L20;
        byte r7 = r2.c;
        if (r7 != 1) goto L9;
        String r8 = "DoraG_Gesture_Settings/G_singleTap.json";
    L42:
        if (((DoraResourceDeviceType) r3.i.getValue()) != r6) goto L44;
        DoraResourceDeviceType r9 = r6;
    L45:
        LarusDoraPageObricGGestureOptionsBinding r10 = r3.f;
        if (r10 == null) goto L76;
        LottieAnimationView r11 = r10.c;
        if (r11 == null) goto L76;
        if (r8.length() <= 0) goto L52;
        boolean r14 = true;
    L53:
        if (r14 == false) goto L55;
        String r15 = r8;
    L56:
        if (r15 == null) goto L58;
        u r16 = u.a;
        Context r12 = r3.requireContext();
        String r13 = "assets/".concat(r15);
        r16.getClass();
        String r17 = u.e(r12, r9, r13);
    L59:
        StringBuilder r18 = new StringBuilder("resolve gesture animation: resourceDeviceType=");
        r18.append(r9);
        r18.append(", jsonPath=");
        r18.append(r8);
        r18.append(", found=");
        if (r17 == null) goto L62;
        boolean r110 = true;
    L63:
        r18.append(r110);
        g49.d.d("DoraObricGGestureOptionsFragment", r18.toString());
        if (r17 == null) goto L66;
        r11.setVisibility(0);
        r11.setAnimationFromJson(r17, r8);
        r11.setRepeatMode(1);
        r11.setRepeatCount(-1);
        r11.playAnimation();
    L68:
        if (((DoraResourceDeviceType) r3.i.getValue()) == r6) goto L70;
    L74:
        float r20 = 1.0f;
    L75:
        r11.setScaleX(r20);
        goto L76
    L70:
        if (r2.b == 4) goto L74;
        if (r2.a != 0) goto L74;
        r20 = -1.0f;
        goto L75
    L66:
        g49.d.d("DoraObricGGestureOptionsFragment", "gesture animation missing: resourceDeviceType=" + r9 + ", jsonPath=" + r8);
        r11.cancelAnimation();
        r11.setVisibility(8);
        goto L68
    L62:
        r110 = false;
        goto L63
    L58:
        r17 = null;
        goto L59
    L55:
        r15 = null;
        goto L56
    L52:
        r14 = false;
    L76:
        DoraObricGGestureOptionsFragment r23 = this.a;
        LarusDoraPageObricGGestureOptionsBinding r24 = r23.f;
        if (r24 == null) goto L148;
        byte r25 = r2.b;
        if (r25 != 4) goto L81;
        boolean r26 = true;
    L82:
        OSectionTitleBar r111 = r24.e;
        if (r25 != 4) goto L85;
        String r27 = r23.getString(2131902358);
        Intrinsics.checkNotNull(r27);
    L86:
        r111.setTitleText(r27);
        r24.e.setVisibility(0);
        LarusDoraPageObricGGestureOptionsBinding r28 = r23.f;
        if (r28 == null) goto L99;
        LinearLayout r30 = r28.d;
        if (r30 == null) goto L99;
        ViewGroup.LayoutParams r31 = r30.getLayoutParams();
        if ((r31 instanceof LinearLayout.LayoutParams) == false) goto L94;
        LinearLayout.LayoutParams r32 = (LinearLayout.LayoutParams) r31;
    L95:
        if (r32 == null) goto L99;
        r32.topMargin = 0;
        r30.setLayoutParams(r32);
        goto L99
    L94:
        r32 = null;
    L99:
        if (((DoraResourceDeviceType) r23.i.getValue()) != r6) goto L118;
        ImageView r33 = r24.b;
        u r34 = u.a;
        Context r35 = r23.requireContext();
        if (r2.a != 16) goto L103;
        boolean r36 = true;
    L104:
        if (r26 == false) goto L110;
        if (r23.h == false) goto L108;
        String r37 = "larus_dora_g_closeup_m_dark";
    L117:
        r34.getClass();
        r33.setImageDrawable(u.c(r35, r37));
        r24.b.setScaleX(1.0f);
    L129:
        Iterator r38 = ViewGroupKt.getChildren(r24.d).iterator();
    L131:
        if (r38.hasNext() == false) goto L148;
        OCardListItem r40 = (View) r38.next();
        Object r41 = r40.getTag();
        if ((r41 instanceof DoraGGestureSettings) == false) goto L135;
        DoraGGestureSettings r42 = (DoraGGestureSettings) r41;
    L137:
        if ((r40 instanceof OCardListItem) == false) goto L139;
        OCardListItem r43 = r40;
    L140:
        if (r43 == null) goto L131;
        if (r42 != null) goto L143;
    L145:
        boolean r44 = false;
    L146:
        DoraObricGGestureOptionsFragment.Y90(r43, r44);
        goto L131
    L143:
        if (r42.d != r2.d) goto L145;
        r44 = true;
        goto L146
    L139:
        r43 = null;
        goto L140
    L135:
        r42 = null;
        goto L137
    L108:
        r37 = "larus_dora_g_closeup_m";
        goto L117
    L110:
        if (r23.h == false) goto L114;
        if (r36 == false) goto L113;
        r37 = "larus_dora_g_closeup_l_dark";
        goto L117
    L113:
        r37 = "larus_dora_g_closeup_r_dark";
        goto L117
    L114:
        if (r36 == false) goto L116;
        r37 = "larus_dora_g_closeup_l";
        goto L117
    L116:
        r37 = "larus_dora_g_closeup_r";
        goto L117
    L103:
        r36 = false;
        goto L104
    L118:
        if (r26 == false) goto L124;
        ImageView r45 = r24.b;
        j0 r112 = j0.a;
        Context r113 = r23.requireContext();
        DoraResourceDeviceType r114 = DoraResourceDeviceType.G2;
        if (r23.h == false) goto L122;
        String r46 = "larus_dora_g2_btn_area_dark.png";
    L123:
        r45.setImageDrawable(j0.f(r112, r113, r114, r46, null, 24));
        r24.b.setScaleX(1.0f);
        goto L129
    L122:
        r46 = "larus_dora_g2_btn_area_light.png";
        goto L123
    L124:
        ImageView r47 = r24.b;
        j0 r115 = j0.a;
        Context r116 = r23.requireContext();
        DoraResourceDeviceType r117 = DoraResourceDeviceType.G2;
        if (r23.h == false) goto L127;
        String r48 = "larus_dora_g2_touch_area_dark.png";
    L128:
        r47.setImageDrawable(j0.f(r115, r116, r117, r48, null, 24));
        r24.b.setScaleX(1.0f);
        goto L129
    L127:
        r48 = "larus_dora_g2_touch_area_light.png";
        goto L128
    L85:
        r27 = r2.g();
        goto L86
    L81:
        r26 = false;
        goto L82
    L44:
        r9 = DoraResourceDeviceType.G_SERIES;
        goto L45
    L9:
        if (r7 != 2) goto L11;
        r8 = "DoraG_Gesture_Settings/G_doubleTap.json";
        goto L42
    L11:
        if (r7 != 3) goto L13;
        r8 = "DoraG_Gesture_Settings/G_tripleTap.json";
        goto L42
    L13:
        if (r7 == 6) goto L15;
        if (r7 != 16) goto L40;
        r8 = "DoraG_Gesture_Settings/G_slide.json";
    L40:
        r8 = "";
        goto L42
    L15:
        if (r2.b != 4) goto L17;
        r8 = "DoraG_Gesture_Settings/G_mid_longPress.json";
        goto L42
    L17:
        r8 = "DoraG_Gesture_Settings/G_longPress.json";
        goto L42
    L20:
        byte r50 = r2.c;
        if (r50 == 1) goto L23;
        if (r50 == 2) goto L28;
        if (r50 != 3) goto L33;
        r8 = "DoraG2_Gesture_Settings/G2_touchTripleTap.json";
        goto L42
    L33:
        if (r50 == 6) goto L35;
        if (r50 != 16) goto L40;
        r8 = "DoraG2_Gesture_Settings/G2_touchSlide.json";
        goto L42
    L35:
        if (r2.b != 4) goto L37;
        r8 = "DoraG2_Gesture_Settings/G2_BtnLongPress.json";
        goto L42
    L37:
        r8 = "DoraG2_Gesture_Settings/G2_touchLongPress.json";
        goto L42
    L28:
        if (r2.b != 4) goto L30;
        r8 = "DoraG2_Gesture_Settings/G2_BtnDoubleTap.json";
        goto L42
    L30:
        r8 = "DoraG2_Gesture_Settings/G2_touchDoubleTap.json";
        goto L42
    L23:
        if (r2.b != 4) goto L25;
        r8 = "DoraG2_Gesture_Settings/G2_BtnSingleTap.json";
        goto L42
    L25:
        r8 = "DoraG2_Gesture_Settings/G2_touchSingleTap.json";
    L148:
        return Unit.INSTANCE;
    }
}
