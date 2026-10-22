package com.ss.android.lark.compose.foundation.dialog;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.window.AndroidDialog_androidKt;
import androidx.compose.ui.window.DialogProperties;
import com.ss.android.lark.chameleon.container.webcontainer.util.ChameleonContainerUtils;
import com.ss.android.lark.compose.foundation.n;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class FlowAlertDialogKt {
    public static final void a(String r23, String r24, String r25, String r26, long r27, long r29, Function0<Unit> r31, Function0<Unit> r32, Function0<Unit> r33, boolean r34, boolean r35, Composer r36, final int r37, final int r38, final int r39) {
        Composer r1 = r36.startRestartGroup(-1582676335);
        int r2 = r39 & 1;
        if (r2 == 0) goto L6;
        int r6 = r37 | 6;
    L13:
        int r7 = r39 & 2;
        if (r7 == 0) goto L17;
        r6 = r6 | 48;
    L24:
        int r9 = r39 & 4;
        if (r9 == 0) goto L28;
        r6 = r6 | 384;
    L35:
        int r11 = r39 & 8;
        if (r11 == 0) goto L39;
        r6 = r6 | 3072;
    L45:
        String r12 = r26;
    L47:
        if ((r37 & 24576) != 0) goto L56;
        if ((r39 & 16) == 0) goto L51;
    L53:
        int r16 = 8192;
    L54:
        r6 = r6 | r16;
        goto L56
    L51:
        if (r1.changed(r27) == false) goto L53;
        r16 = 16384;
    L56:
        int r17 = r39 & 32;
        if (r17 == 0) goto L60;
        r6 = r6 | 196608;
    L66:
        int r18 = r39 & 64;
        if (r18 == 0) goto L70;
        r6 = r6 | 1572864;
    L76:
        Function0<Unit> r13 = r31;
    L77:
        int r14 = r39 & 128;
        if (r14 == 0) goto L81;
        r6 = r6 | 12582912;
    L87:
        int r0 = r39 & 256;
        if (r0 == 0) goto L91;
        r6 = r6 | 100663296;
    L97:
        int r4 = r39 & 512;
        if (r4 == 0) goto L101;
        r6 = r6 | 805306368;
    L107:
        int r3 = r39 & ChameleonContainerUtils.MAX_URL_LENGTH;
        if (r3 == 0) goto L111;
        int r20 = r38 | 6;
    L117:
        int r5 = r20;
    L120:
        if ((r6 & 306783379) == 306783378) goto L122;
    L127:
        r1.startDefaults();
        if ((r37 & 1) != 0) goto L130;
    L136:
        String r8 = BuildConfig.FLAVOR;
        if (r2 == 0) goto L139;
        String r10 = BuildConfig.FLAVOR;
    L140:
        if (r7 == 0) goto L142;
        String r15 = BuildConfig.FLAVOR;
    L143:
        if (r9 == 0) goto L145;
        String r19 = BuildConfig.FLAVOR;
    L146:
        if (r11 != 0) goto L150;
        r8 = r12;
    L150:
        if ((r39 & 16) == 0) goto L152;
        long r110 = n.a(r1, 6).d.a;
        r6 = r6 & (-57345);
    L153:
        if (r17 == 0) goto L155;
        long r111 = Color.Companion.getUnspecified-0d7_KjU();
    L157:
        if (r18 == 0) goto L162;
        r1.startReplaceGroup(1849434622);
        Object r112 = r1.rememberedValue();
        if (r112 != Composer.Companion.getEmpty()) goto L161;
        r112 = FlowAlertDialogKt$FlowAlertDialog$1$1.INSTANCE;
        r1.updateRememberedValue(r112);
    L161:
        Function0<Unit> r113 = (Function0) r112;
        r1.endReplaceGroup();
    L163:
        if (r14 == 0) goto L168;
        r1.startReplaceGroup(1849434622);
        Object r114 = r1.rememberedValue();
        if (r114 != Composer.Companion.getEmpty()) goto L167;
        r114 = FlowAlertDialogKt$FlowAlertDialog$2$1.INSTANCE;
        r1.updateRememberedValue(r114);
    L167:
        Function0<Unit> r115 = (Function0) r114;
        r1.endReplaceGroup();
    L169:
        if (r0 == 0) goto L174;
        r1.startReplaceGroup(1849434622);
        Object r21 = r1.rememberedValue();
        if (r21 != Composer.Companion.getEmpty()) goto L173;
        r21 = FlowAlertDialogKt$FlowAlertDialog$3$1.INSTANCE;
        r1.updateRememberedValue(r21);
    L173:
        Function0<Unit> r22 = (Function0) r21;
        r1.endReplaceGroup();
    L175:
        if (r4 == 0) goto L177;
        boolean r28 = true;
    L178:
        if (r3 == 0) goto L180;
        boolean r30 = true;
    L181:
        r1.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L184;
        ComposerKt.traceEventStart(-1582676335, r6, r5, "com.ss.android.lark.compose.foundation.dialog.FlowAlertDialog (FlowAlertDialog.kt:57)");
    L184:
        DialogProperties r40 = new DialogProperties(r28, r30, false, 4, null);
        final String r210 = r19;
        final String r211 = r8;
        final String r212 = r10;
        final String r213 = r15;
        final Function0<Unit> r214 = r115;
        final Function0<Unit> r215 = r22;
        final Function0<Unit> r310 = r113;
        final long r311 = r111;
        final long r312 = r110;
        Function2<Composer, Integer, Unit> r116 = new FlowAlertDialogKt$FlowAlertDialog$4(r210, r211, r212, r213, r214, r215, r310, r311, r312);
        String r216 = r10;
        boolean r313 = r30;
        Function0<Unit> r217 = r22;
        AndroidDialog_androidKt.Dialog(r217, r40, ComposableLambdaKt.rememberComposableLambda(297657754, true, r116, r1, 54), r1, ((r6 >> 24) & 14) | 384, 0);
        if (ComposerKt.isTraceInProgress() == false) goto L187;
        ComposerKt.traceEventEnd();
    L187:
        String r41 = r216;
        final String r42 = r19;
        final Function0<Unit> r43 = r113;
        final long r44 = r110;
        final Function0<Unit> r117 = r115;
        final boolean r118 = r313;
        final Function0<Unit> r119 = r22;
        final boolean r120 = r28;
        final String r45 = r8;
    L188:
        ScopeUpdateScope r121 = r1.endRestartGroup();
        if (r121 == null) goto L192;
        final String r46 = r41;
        final String r47 = r15;
        final long r48 = r111;
        r121.updateScope(new FlowAlertDialogKt$FlowAlertDialog$5(r46, r47, r42, r45, r44, r48, r43, r117, r119, r120, r118, r37, r38, r39));
        return;
    L192:
        return;
    L180:
        r30 = r35;
        goto L181
    L177:
        r28 = r34;
        goto L178
    L174:
        r22 = r33;
        goto L175
    L168:
        r115 = r32;
        goto L169
    L162:
        r113 = r13;
        goto L163
    L155:
        r111 = r29;
        goto L157
    L152:
        r110 = r27;
        goto L153
    L145:
        r19 = r25;
        goto L146
    L142:
        r15 = r24;
        goto L143
    L139:
        r10 = r23;
        goto L140
    L130:
        if (r1.getDefaultsInvalid() == true) goto L136;
        r1.skipToGroupEnd();
        if ((r39 & 16) == 0) goto L135;
        r6 = r6 & (-57345);
    L135:
        r10 = r23;
        r15 = r24;
        r19 = r25;
        r111 = r29;
        r22 = r33;
        r28 = r34;
        r30 = r35;
        r8 = r12;
        r113 = r13;
        r110 = r27;
        r115 = r32;
        goto L181
    L122:
        if ((r5 & 3) != 2) goto L127;
        if (r1.getSkipping() == false) goto L127;
        r1.skipToGroupEnd();
        r41 = r23;
        r15 = r24;
        r42 = r25;
        r44 = r27;
        r111 = r29;
        r117 = r32;
        r119 = r33;
        r45 = r12;
        r43 = r13;
        r120 = r34;
        r118 = r35;
        goto L188
    L111:
        if ((r38 & 6) == 0) goto L113;
        r5 = r38;
        goto L120
    L113:
        if (r1.changed(r35) == false) goto L115;
        int r218 = 4;
    L116:
        r20 = r38 | r218;
        goto L117
    L115:
        r218 = 2;
        goto L116
    L101:
        if ((r37 & 805306368) != 0) goto L107;
        if (r1.changed(r34) == false) goto L105;
        int r219 = 536870912;
    L106:
        r6 = r6 | r219;
        goto L107
    L105:
        r219 = 268435456;
        goto L106
    L91:
        if ((r37 & 100663296) != 0) goto L97;
        if (r1.changedInstance(r33) == false) goto L95;
        int r49 = 67108864;
    L96:
        r6 = r6 | r49;
        goto L97
    L95:
        r49 = 33554432;
        goto L96
    L81:
        if ((r37 & 12582912) != 0) goto L87;
        if (r1.changedInstance(r32) == false) goto L85;
        int r220 = 8388608;
    L86:
        r6 = r6 | r220;
        goto L87
    L85:
        r220 = 4194304;
        goto L86
    L70:
        if ((r37 & 1572864) != 0) goto L76;
        r13 = r31;
        if (r1.changedInstance(r13) == false) goto L74;
        int r122 = 1048576;
    L75:
        r6 = r6 | r122;
        goto L77
    L74:
        r122 = 524288;
        goto L75
    L60:
        if ((r37 & 196608) != 0) goto L66;
        if (r1.changed(r29) == false) goto L64;
        int r123 = 131072;
    L65:
        r6 = r6 | r123;
        goto L66
    L64:
        r123 = 65536;
        goto L65
    L39:
        if ((r37 & 3072) != 0) goto L45;
        r12 = r26;
        if (r1.changed(r12) == false) goto L43;
        int r124 = 2048;
    L44:
        r6 = r6 | r124;
        goto L47
    L43:
        r124 = ChameleonContainerUtils.MAX_URL_LENGTH;
        goto L44
    L28:
        if ((r37 & 384) != 0) goto L35;
        if (r1.changed(r25) == false) goto L32;
        int r125 = 256;
    L33:
        r6 = r6 | r125;
        goto L35
    L32:
        r125 = 128;
        goto L33
    L17:
        if ((r37 & 48) != 0) goto L24;
        if (r1.changed(r24) == false) goto L21;
        int r50 = 32;
    L22:
        r6 = r6 | r50;
        goto L24
    L21:
        r50 = 16;
        goto L22
    L6:
        if ((r37 & 6) == 0) goto L8;
        r6 = r37;
        goto L13
    L8:
        if (r1.changed(r23) == false) goto L10;
        int r51 = 4;
    L11:
        r6 = r51 | r37;
        goto L13
    L10:
        r51 = 2;
        goto L11
    }
}
