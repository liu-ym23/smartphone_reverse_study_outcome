package com.larus.dora.impl.device.settings.gesture.options;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import androidx.core.view.ViewGroupKt;
import com.airbnb.lottie.LottieAnimationView;
import com.larus.dora.impl.databinding.LarusDoraGPageOptionsBinding;
import com.larus.dora.impl.device.settings.gesture.DoraGGestureSettings;
import com.larus.dora.impl.resource.DoraResourceDeviceType;
import com.larus.dora.impl.util.u;
import com.larus.utils.e1;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.text.StringsKt;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class f<T> implements FlowCollector {
    public final /* synthetic */ DoraGOptionsFragment a;

    public f(DoraGOptionsFragment r1) {
        this.a = r1;
    }

    public final Object emit(Object r14, Continuation r15) {
        q r16 = (q) r14;
        g49.d.d("DoraGOptionsFragment", "gestureSettingsUpdateFlow collect: " + r16);
        if ((r16 instanceof q.b) == false) goto L82;
        DoraGOptionsFragment r17 = this.a;
        LarusDoraGPageOptionsBinding r0 = r17.f;
        if (r0 == null) goto L82;
        DoraGGestureSettings r18 = ((q.b) r16).a;
        byte r1 = r18.c;
        if (r1 != 1) goto L9;
        String r2 = "DoraG_Gesture_Settings/G_singleTap.json";
    L26:
        LottieAnimationView r6 = r0.d;
        if (r6 != null) goto L29;
    L48:
        r0.f.setText(r18.g());
        if (r18.b != 4) goto L55;
        r0.f.setVisibility(8);
        r0.b.setVisibility(0);
        ImageView r3 = r0.c;
        u r4 = u.a;
        Context r5 = r17.requireContext();
        if (r17.h == false) goto L53;
        String r110 = "larus_dora_g_closeup_m_dark";
    L54:
        r4.getClass();
        r3.setImageDrawable(u.c(r5, r110));
    L68:
        Iterator r111 = ViewGroupKt.getChildren(r0.e).iterator();
    L70:
        if (r111.hasNext() == false) goto L82;
        View r7 = (View) r111.next();
        Object r8 = r7.getTag();
        if ((r8 instanceof DoraGGestureSettings) == false) goto L74;
        DoraGGestureSettings r9 = (DoraGGestureSettings) r8;
    L75:
        if (r9 != null) goto L77;
    L79:
        boolean r10 = false;
    L80:
        r7.setSelected(r10);
        goto L70
    L77:
        if (r9.d != r18.d) goto L79;
        r10 = true;
        goto L80
    L74:
        r9 = null;
        goto L75
    L53:
        r110 = "larus_dora_g_closeup_m";
        goto L54
    L55:
        r0.f.setVisibility(0);
        r0.b.setVisibility(8);
        ImageView r11 = r0.c;
        u r12 = u.a;
        Context r13 = r17.requireContext();
        if (r18.a != 16) goto L58;
        boolean r20 = true;
    L60:
        if (r17.h != true) goto L64;
        if (r20 == false) goto L63;
        String r112 = "larus_dora_g_closeup_l_dark";
    L67:
        r12.getClass();
        r11.setImageDrawable(u.c(r13, r112));
        goto L68
    L63:
        r112 = "larus_dora_g_closeup_r_dark";
        goto L67
    L64:
        if (r20 == false) goto L66;
        r112 = "larus_dora_g_closeup_l";
        goto L67
    L66:
        r112 = "larus_dora_g_closeup_r";
        goto L67
    L58:
        r20 = false;
        goto L60
    L29:
        if (StringsKt.endsWith$default(r2, "G_mid_doubleTap.json", false, 2, null) == false) goto L31;
        DoraResourceDeviceType r21 = DoraResourceDeviceType.G1;
    L33:
        if (r2.length() <= 0) goto L35;
        boolean r22 = true;
    L36:
        if (r22 == false) goto L38;
        String r23 = r2;
    L39:
        if (r23 == null) goto L41;
        u r113 = u.a;
        Context r114 = r17.requireContext();
        String r24 = "assets/".concat(r23);
        r113.getClass();
        String r25 = u.e(r114, r21, r24);
    L42:
        if (r25 == null) goto L44;
        e1.x(r6);
        r6.setAnimationFromJson(r25, r2);
        r6.setRepeatMode(1);
        r6.setRepeatCount(-1);
        r6.playAnimation();
    L46:
        if (r18.a != 0) goto L48;
        r6.setScaleX(-1.0f);
        goto L48
    L44:
        r6.cancelAnimation();
        e1.o(r6);
        goto L46
    L41:
        r25 = null;
        goto L42
    L38:
        r23 = null;
        goto L39
    L35:
        r22 = false;
        goto L36
    L31:
        r21 = DoraResourceDeviceType.G_SERIES;
        goto L33
    L9:
        if (r1 != 2) goto L15;
        if (r18.b != 4) goto L13;
        r2 = "DoraG_Gesture_Settings/G_mid_doubleTap.json";
        goto L26
    L13:
        r2 = "DoraG_Gesture_Settings/G_doubleTap.json";
        goto L26
    L15:
        if (r1 != 3) goto L18;
        r2 = "DoraG_Gesture_Settings/G_tripleTap.json";
        goto L26
    L18:
        if (r1 == 6) goto L20;
        if (r1 != 16) goto L25;
        r2 = "DoraG_Gesture_Settings/G_slide.json";
        goto L26
    L25:
        r2 = "";
        goto L26
    L20:
        if (r18.b != 4) goto L22;
        r2 = "DoraG_Gesture_Settings/G_mid_longPress.json";
        goto L26
    L22:
        r2 = "DoraG_Gesture_Settings/G_longPress.json";
    L82:
        return Unit.INSTANCE;
    }
}
