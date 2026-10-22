package com.larus.dora.impl.device.settings.gesture;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class a {
    public static final String a(DoraGGestureSettings r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        byte r3 = r2.d;
        if (r3 != 0) goto L6;
        return "none";
    L6:
        if (r3 != 16) goto L9;
        return "play_pause";
    L9:
        if (r3 != 19) goto L12;
        return "previous_track";
    L12:
        if (r3 != 20) goto L15;
        return "next_track";
    L15:
        if (r3 != 6) goto L18;
        return "volume_control";
    L18:
        if (r3 != 1) goto L21;
        return "answer_or_hang_up";
    L21:
        if (r3 != 2) goto L24;
        return "answer_only";
    L24:
        if (r3 != 3) goto L27;
        return "hang_up_only";
    L27:
        if (r3 != 33) goto L30;
        return "enter_exit_companion";
    L30:
        if (r3 != 34) goto L33;
        return "enter_exit_interpretation";
    L33:
        if (r3 != 35) goto L36;
        return "dora_radio";
    L36:
        if (r3 != 32) goto L39;
        return "continuous_dialogue";
    L39:
        if (r3 != 37) goto L42;
        return "enter_exit_audio_summary";
    L42:
        if (r3 != 38) goto L45;
        return "quick_note";
    L45:
        if (r3 != 40) goto L48;
        return "enter_exit_headphone_mode";
    L48:
        if (r3 != 39) goto L65;
        return "non_ai_recording";
    L65:
        return "none";
    }

    public static final String b(DoraGGestureSettings r8) {
        Intrinsics.checkNotNullParameter(r8, "<this>");
        byte r0 = r8.a;
        String r1 = "none";
        if (r0 != 0) goto L5;
        String r2 = "right";
    L10:
        byte r3 = r8.b;
        if (r3 != 6) goto L13;
        String r4 = "quick_control";
    L23:
        byte r9 = r8.c;
        if (r9 != 1) goto L26;
        r1 = "single_click";
    L36:
        return r2 + '_' + r4 + '_' + r1;
    L26:
        if (r9 != 2) goto L29;
        r1 = "double_click";
        goto L36
    L29:
        if (r9 != 3) goto L31;
        r1 = "tripple_click";
        goto L36
    L31:
        if (r9 != 6) goto L33;
        r1 = "long_press";
        goto L36
    L33:
        if (r9 != 16) goto L36;
        r1 = "swipe";
        goto L36
    L13:
        if (r3 != 0) goto L15;
        r4 = "media";
        goto L23
    L15:
        if (r3 != 1) goto L17;
        r4 = "call";
        goto L23
    L17:
        if (r3 != 2) goto L20;
        r4 = "doubao";
        goto L23
    L20:
        if (r3 != 4) goto L22;
        r4 = "button";
        goto L23
    L22:
        r4 = "none";
        goto L23
    L5:
        if (r0 == 16) goto L9;
        if (r0 == 16) goto L9;
        r2 = "none";
    L9:
        r2 = "left";
        goto L10
    }
}
