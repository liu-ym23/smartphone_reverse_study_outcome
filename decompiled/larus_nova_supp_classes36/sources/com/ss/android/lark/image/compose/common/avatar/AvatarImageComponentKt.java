package com.ss.android.lark.image.compose.common.avatar;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.painter.Painter;
import com.ss.android.lark.image.compose.platform.avatar.PlatformAvatarKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class AvatarImageComponentKt {
    public static final void a(final a r21, final Modifier r22, final Function0<Unit> r23, final Function0<Unit> r24, final Function0<Unit> r25, final Function0<Unit> r26, Painter r27, Painter r28, Composer r29, final int r30, final int r31) {
        Intrinsics.checkNotNullParameter(r21, "avatarImage");
        Intrinsics.checkNotNullParameter(r22, "modifier");
        Composer r7 = r29.startRestartGroup(835012478);
        if ((r31 & 1) == 0) goto L6;
        int r1 = r30 | 6;
    L14:
        if ((r31 & 2) == 0) goto L17;
        r1 = r1 | 48;
    L24:
        if ((r31 & 4) == 0) goto L27;
        r1 = r1 | 384;
    L34:
        if ((r31 & 8) == 0) goto L37;
        r1 = r1 | 3072;
    L44:
        if ((r31 & 16) == 0) goto L47;
        r1 = r1 | 24576;
    L54:
        if ((r31 & 32) == 0) goto L57;
        r1 = r1 | 196608;
    L64:
        if ((1572864 & r30) == 0) goto L66;
        Painter r2 = r27;
    L75:
        if ((r30 & 12582912) == 0) goto L77;
        Painter r6 = r28;
    L86:
        if ((r1 & 4793491) == 4793490) goto L88;
    L91:
        r7.startDefaults();
        if ((r30 & 1) == 0) goto L103;
        if (r7.getDefaultsInvalid() == true) goto L103;
        r7.skipToGroupEnd();
        if ((r31 & 64) == 0) goto L100;
        r1 = r1 & (-3670017);
    L100:
        if ((r31 & 128) == 0) goto L108;
        r1 = r1 & (-29360129);
    L108:
        Painter r18 = r2;
        Painter r19 = r6;
    L109:
        r7.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L112;
        ComposerKt.traceEventStart(835012478, r1, -1, "com.ss.android.lark.image.compose.common.avatar.AvatarImageComponent (AvatarImageComponent.kt:29)");
    L112:
        tkb.b r3 = new tkb.b();
        r7.startReplaceGroup(-1224400529);
        if ((r1 & 896) != 256) goto L115;
        boolean r0 = true;
    L117:
        if ((r1 & 7168) != 2048) goto L119;
        boolean r4 = true;
    L120:
        boolean r5 = r0 | r4;
        if ((r1 & 57344) != 16384) goto L123;
        boolean r8 = true;
    L124:
        boolean r9 = r5 | r8;
        if ((458752 & r1) != 131072) goto L127;
        boolean r10 = true;
    L128:
        boolean r11 = r9 | r10;
        Object r12 = r7.rememberedValue();
        if (r11 == false) goto L131;
    L132:
        r12 = new AvatarImageComponentKt$AvatarImageComponent$1$1(r23, r24, r25, r26);
        r7.updateRememberedValue(r12);
    L133:
        Function1 r13 = (Function1) r12;
        r7.endReplaceGroup();
        int r14 = (r1 & 14) | (r1 & 112);
        int r15 = r1 >> 9;
        int r16 = (r14 | (r15 & 7168)) | (r15 & 57344);
        PlatformAvatarKt.a(r21, r22, r3, r18, r19, r13, r7, r16, 0);
        if (ComposerKt.isTraceInProgress() == false) goto L136;
        ComposerKt.traceEventEnd();
    L136:
        final Painter r17 = r18;
        final Painter r20 = r19;
    L137:
        ScopeUpdateScope r32 = r7.endRestartGroup();
        if (r32 == null) goto L141;
        r32.updateScope(new AvatarImageComponentKt$AvatarImageComponent$2(r21, r22, r23, r24, r25, r26, r17, r20, r30, r31));
        return;
    L141:
        return;
    L131:
        if (r12 != Composer.Companion.getEmpty()) goto L133;
    L127:
        r10 = false;
        goto L128
    L123:
        r8 = false;
        goto L124
    L119:
        r4 = false;
        goto L120
    L115:
        r0 = false;
    L103:
        if ((r31 & 64) == 0) goto L106;
        r2 = tkb.a.a(r7);
        r1 = r1 & (-3670017);
    L106:
        if ((r31 & 128) == 0) goto L108;
        r1 = r1 & (-29360129);
        r18 = r2;
        r19 = tkb.a.a(r7);
        goto L109
    L88:
        if (r7.getSkipping() == false) goto L91;
        r7.skipToGroupEnd();
        r20 = r6;
        r17 = r2;
        goto L137
    L77:
        if ((r31 & 128) != 0) goto L81;
        r6 = r28;
        if (r7.changedInstance(r6) == false) goto L82;
        int r110 = 8388608;
    L83:
        r1 = r1 | r110;
    L82:
        r110 = 4194304;
        goto L83
    L81:
        r6 = r28;
        goto L82
    L66:
        if ((r31 & 64) != 0) goto L70;
        r2 = r27;
        if (r7.changedInstance(r2) == false) goto L71;
        int r111 = 1048576;
    L72:
        r1 = r1 | r111;
    L71:
        r111 = 524288;
        goto L72
    L70:
        r2 = r27;
        goto L71
    L57:
        if ((r30 & 196608) != 0) goto L64;
        if (r7.changedInstance(r26) == false) goto L61;
        int r33 = 131072;
    L62:
        r1 = r1 | r33;
        goto L64
    L61:
        r33 = 65536;
        goto L62
    L47:
        if ((r30 & 24576) != 0) goto L54;
        if (r7.changedInstance(r25) == false) goto L51;
        int r34 = 16384;
    L52:
        r1 = r1 | r34;
        goto L54
    L51:
        r34 = 8192;
        goto L52
    L37:
        if ((r30 & 3072) != 0) goto L44;
        if (r7.changedInstance(r24) == false) goto L41;
        int r35 = 2048;
    L42:
        r1 = r1 | r35;
        goto L44
    L41:
        r35 = 1024;
        goto L42
    L27:
        if ((r30 & 384) != 0) goto L34;
        if (r7.changedInstance(r23) == false) goto L31;
        int r36 = 256;
    L32:
        r1 = r1 | r36;
        goto L34
    L31:
        r36 = 128;
        goto L32
    L17:
        if ((r30 & 48) != 0) goto L24;
        if (r7.changed(r22) == false) goto L21;
        int r37 = 32;
    L22:
        r1 = r1 | r37;
        goto L24
    L21:
        r37 = 16;
        goto L22
    L6:
        if ((r30 & 6) == 0) goto L8;
        r1 = r30;
        goto L14
    L8:
        if (r7.changed(r21) == false) goto L10;
        int r38 = 4;
    L11:
        r1 = r38 | r30;
        goto L14
    L10:
        r38 = 2;
        goto L11
    }
}
