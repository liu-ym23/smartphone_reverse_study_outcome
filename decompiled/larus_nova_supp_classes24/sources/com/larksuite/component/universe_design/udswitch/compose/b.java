package com.larksuite.component.universe_design.udswitch.compose;

import android.content.Context;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class b {
    static {
    }

    public static a a(Composer r42) {
        r42.startReplaceGroup(1929690746);
        Color.Companion r2 = Color.Companion;
        long r3 = r2.getUnspecified-0d7_KjU();
        long r5 = r2.getUnspecified-0d7_KjU();
        long r7 = r2.getUnspecified-0d7_KjU();
        long r9 = r2.getUnspecified-0d7_KjU();
        long r11 = r2.getUnspecified-0d7_KjU();
        long r13 = r2.getUnspecified-0d7_KjU();
        long r14 = r2.getUnspecified-0d7_KjU();
        long r1 = r2.getUnspecified-0d7_KjU();
        if (ComposerKt.isTraceInProgress() == false) goto L6;
        ComposerKt.traceEventStart(1929690746, 100663296, -1, "com.larksuite.component.universe_design.udswitch.compose.UDSwitchDefaults.colors (UDSwitch.kt:202)");
    L6:
        float r4 = UDSwitchKt.a;
        r42.startReplaceGroup(-1215089426);
        if (ComposerKt.isTraceInProgress() == false) goto L9;
        ComposerKt.traceEventStart(-1215089426, 0, -1, "com.larksuite.component.universe_design.udswitch.compose.defaultSwitchColors (UDSwitch.kt:284)");
    L9:
        Context r6 = (Context) r42.consume(AndroidCompositionLocals_androidKt.getLocalContext());
        r42.startReplaceGroup(5004770);
        boolean r8 = r42.changed(r6);
        Object r15 = r42.rememberedValue();
        if (r8 == false) goto L12;
    L13:
        r15 = new a(UDSwitchKt.c(r6, 2131108993, true, true), UDSwitchKt.c(r6, 2131108993, false, true), UDSwitchKt.c(r6, 2131108993, true, false), UDSwitchKt.c(r6, 2131108993, false, false), UDSwitchKt.c(r6, 2131108994, true, true), UDSwitchKt.c(r6, 2131108994, false, true), UDSwitchKt.c(r6, 2131108994, true, false), UDSwitchKt.c(r6, 2131108994, false, false));
        r42.updateRememberedValue(r15);
    L14:
        a r16 = (a) r15;
        r42.endReplaceGroup();
        if (ComposerKt.isTraceInProgress() == false) goto L17;
        ComposerKt.traceEventEnd();
    L17:
        r42.endReplaceGroup();
        r42.startReplaceGroup(-1224400529);
        boolean r10 = r42.changed(r16);
        if (r42.changed(r3) == true) goto L20;
        boolean r12 = false;
    L21:
        boolean r17 = r10 | r12;
        if (r42.changed(r5) == true) goto L24;
        boolean r19 = false;
    L25:
        boolean r20 = r17 | r19;
        if (r42.changed(r7) == true) goto L28;
        boolean r21 = false;
    L29:
        boolean r22 = r20 | r21;
        if (r42.changed(r9) == true) goto L32;
        boolean r23 = false;
    L33:
        boolean r24 = r22 | r23;
        if (r42.changed(r11) == true) goto L36;
        boolean r25 = false;
    L37:
        boolean r26 = r24 | r25;
        if (r42.changed(r13) == true) goto L40;
        boolean r110 = false;
    L41:
        boolean r27 = r26 | r110;
        if (r42.changed(r14) == true) goto L44;
        boolean r111 = false;
    L45:
        boolean r29 = r27 | r111;
        if (r42.changed(r1) == true) goto L48;
        boolean r210 = false;
    L49:
        boolean r30 = r210 | r29;
        Object r31 = r42.rememberedValue();
        if (r30 == false) goto L52;
    L53:
        a r32 = new a(UDSwitchKt.b(r3, r16.a(true, true)), UDSwitchKt.b(r5, r16.a(false, true)), UDSwitchKt.b(r7, r16.a(true, false)), UDSwitchKt.b(r9, r16.a(false, false)), UDSwitchKt.b(r11, r16.b(true, true)), UDSwitchKt.b(r13, r16.b(false, true)), UDSwitchKt.b(r14, r16.b(true, false)), UDSwitchKt.b(r1, r16.b(false, false)));
        r42.updateRememberedValue(r32);
        r31 = r32;
    L54:
        a r33 = (a) r31;
        r42.endReplaceGroup();
        if (ComposerKt.isTraceInProgress() == false) goto L57;
        ComposerKt.traceEventEnd();
    L57:
        r42.endReplaceGroup();
        return r33;
    L52:
        if (r31 != Composer.Companion.getEmpty()) goto L54;
    L48:
        r210 = true;
        goto L49
    L44:
        r111 = true;
        goto L45
    L40:
        r110 = true;
        goto L41
    L36:
        r25 = true;
        goto L37
    L32:
        r23 = true;
        goto L33
    L28:
        r21 = true;
        goto L29
    L24:
        r19 = true;
        goto L25
    L20:
        r12 = true;
        goto L21
    L12:
        if (r15 != Composer.Companion.getEmpty()) goto L14;
        goto L13
    }

    public static c b(Composer r11) {
        r11.startReplaceGroup(-975328308);
        Color.Companion r1 = Color.Companion;
        long r2 = r1.getUnspecified-0d7_KjU();
        long r4 = r1.getUnspecified-0d7_KjU();
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(-975328308, 384, -1, "com.larksuite.component.universe_design.udswitch.compose.UDSwitchDefaults.loadingColors (UDSwitch.kt:232)");
    L5:
        float r0 = UDSwitchKt.a;
        r11.startReplaceGroup(759053894);
        boolean r7 = false;
        if (ComposerKt.isTraceInProgress() == false) goto L8;
        ComposerKt.traceEventStart(759053894, 0, -1, "com.larksuite.component.universe_design.udswitch.compose.defaultSwitchLoadingColors (UDSwitch.kt:301)");
    L8:
        Context r3 = (Context) r11.consume(AndroidCompositionLocals_androidKt.getLocalContext());
        r11.startReplaceGroup(5004770);
        boolean r5 = r11.changed(r3);
        Object r6 = r11.rememberedValue();
        if (r5 == false) goto L11;
    L12:
        r6 = new c(UDSwitchKt.c(r3, 2131108982, true, true), UDSwitchKt.c(r3, 2131108982, false, true));
        r11.updateRememberedValue(r6);
    L13:
        c r8 = (c) r6;
        r11.endReplaceGroup();
        if (ComposerKt.isTraceInProgress() == false) goto L16;
        ComposerKt.traceEventEnd();
    L16:
        r11.endReplaceGroup();
        r11.startReplaceGroup(-1746271574);
        boolean r9 = r11.changed(r8);
        if (r11.changed(r2) == true) goto L19;
        boolean r10 = false;
    L20:
        boolean r12 = r9 | r10;
        if (r11.changed(r4) == false) goto L24;
        r7 = true;
    L24:
        boolean r13 = r12 | r7;
        Object r14 = r11.rememberedValue();
        if (r13 == false) goto L27;
    L28:
        r14 = new c(UDSwitchKt.b(r2, r8.a), UDSwitchKt.b(r4, r8.b));
        r11.updateRememberedValue(r14);
    L29:
        c r15 = (c) r14;
        r11.endReplaceGroup();
        if (ComposerKt.isTraceInProgress() == false) goto L32;
        ComposerKt.traceEventEnd();
    L32:
        r11.endReplaceGroup();
        return r15;
    L27:
        if (r14 != Composer.Companion.getEmpty()) goto L29;
    L19:
        r10 = true;
        goto L20
    L11:
        if (r6 != Composer.Companion.getEmpty()) goto L13;
        goto L12
    }
}
