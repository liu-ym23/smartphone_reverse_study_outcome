package com.ss.android.lark.image.compose.common.url;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.ContentScale;
import com.ss.android.lark.image.compose.common.CachePolicy;
import com.ss.android.lark.image.compose.platform.url.PlatformURLImageKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import tkb.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class URLImageComponentKt {
    public static final a b(Composer r4) {
        r4.startReplaceGroup(1777658182);
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(1777658182, 0, -1, "com.ss.android.lark.image.compose.common.url.rememberURLImageState (URLImageComponent.kt:44)");
    L5:
        r4.startReplaceGroup(1849434622);
        Object r0 = r4.rememberedValue();
        if (r0 != Composer.Companion.getEmpty()) goto L8;
        r0 = new a(0);
        r4.updateRememberedValue(r0);
    L8:
        a r1 = (a) r0;
        r4.endReplaceGroup();
        if (ComposerKt.isTraceInProgress() == false) goto L11;
        ComposerKt.traceEventEnd();
    L11:
        r4.endReplaceGroup();
        return r1;
    }

    public static final void a(final String r29, final Modifier r30, b r31, ContentScale r32, final Function0<Unit> r33, final Function0<Unit> r34, final Function0<Unit> r35, final Function0<Unit> r36, a r37, CachePolicy r38, CachePolicy r39, Painter r40, Painter r41, Composer r42, final int r43, final int r44, final int r45) {
        Intrinsics.checkNotNullParameter(r29, "url");
        Intrinsics.checkNotNullParameter(r30, "modifier");
        Composer r6 = r42.startRestartGroup(342957240);
        if ((r45 & 1) == 0) goto L6;
        int r1 = r43 | 6;
    L13:
        int r16 = 16;
        if ((r45 & 2) == 0) goto L17;
        r1 = r1 | 48;
    L23:
        int r17 = 128;
        if ((r43 & 384) != 0) goto L34;
        if ((r45 & 4) != 0) goto L31;
        if (r6.changed(r31) == false) goto L31;
        int r19 = 256;
    L32:
        r1 = r1 | r19;
    L31:
        r19 = 128;
    L34:
        int r110 = r45 & 8;
        if (r110 == 0) goto L38;
        r1 = r1 | 3072;
    L46:
        if ((r45 & 16) == 0) goto L49;
        r1 = r1 | 24576;
    L56:
        if ((r45 & 32) == 0) goto L59;
        r1 = r1 | 196608;
    L66:
        if ((r45 & 64) == 0) goto L69;
        r1 = r1 | 1572864;
    L75:
        int r24 = 12582912;
        if ((r45 & 128) == 0) goto L79;
    L84:
        r1 = r1 | r24;
    L86:
        if ((100663296 & r43) != 0) goto L96;
        if ((r45 & 256) != 0) goto L93;
        if (r6.changed(r37) == false) goto L93;
        int r25 = 67108864;
    L94:
        r1 = r1 | r25;
    L93:
        r25 = 33554432;
    L96:
        int r3 = r45 & 512;
        if (r3 == 0) goto L100;
        r1 = r1 | 805306368;
    L109:
        int r0 = r45 & 1024;
        if (r0 == 0) goto L113;
        int r21 = r44 | 6;
    L124:
        if ((r44 & 48) != 0) goto L134;
        if ((r45 & 2048) != 0) goto L131;
        if (r6.changedInstance(r40) == false) goto L131;
        r16 = 32;
    L131:
        r21 = r21 | r16;
    L134:
        if ((r44 & 384) != 0) goto L143;
        if ((r45 & 4096) != 0) goto L141;
        if (r6.changedInstance(r41) == false) goto L141;
        r17 = 256;
    L141:
        r21 = r21 | r17;
    L143:
        int r2 = r21;
        if ((r1 & 306783379) == 306783378) goto L146;
    L151:
        r6.startDefaults();
        if ((r43 & 1) == 0) goto L170;
        if (r6.getDefaultsInvalid() == true) goto L170;
        r6.skipToGroupEnd();
        if ((r45 & 4) == 0) goto L160;
        r1 = r1 & (-897);
    L160:
        if ((r45 & 256) == 0) goto L163;
        r1 = r1 & (-234881025);
    L163:
        if ((r45 & 2048) == 0) goto L166;
        r2 = r2 & (-113);
    L166:
        if ((r45 & 4096) == 0) goto L168;
        r2 = r2 & (-897);
    L168:
        b r18 = r31;
        ContentScale r111 = r32;
        a r5 = r37;
        CachePolicy r112 = r38;
        CachePolicy r113 = r39;
        Painter r20 = r40;
        Painter r22 = r41;
    L195:
        r6.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L198;
        ComposerKt.traceEventStart(342957240, r1, r2, "com.ss.android.lark.image.compose.common.url.URLImageComponent (URLImageComponent.kt:71)");
    L198:
        int r4 = ((Number) r5.a.getValue()).intValue();
        r6.startReplaceGroup(-1224400529);
        if ((57344 & r1) != 16384) goto L201;
        boolean r7 = true;
    L202:
        a r23 = r5;
        if ((458752 & r1) != 131072) goto L205;
        boolean r8 = true;
    L206:
        boolean r9 = r7 | r8;
        if ((3670016 & r1) != 1048576) goto L209;
        boolean r10 = true;
    L210:
        boolean r11 = r9 | r10;
        if ((29360128 & r1) != 8388608) goto L213;
        boolean r12 = true;
    L214:
        boolean r13 = r11 | r12;
        Object r14 = r6.rememberedValue();
        if (r13 == false) goto L217;
    L218:
        r14 = new URLImageComponentKt$URLImageComponent$1$1(r33, r34, r35, r36);
        r6.updateRememberedValue(r14);
    L219:
        Function1 r26 = (Function1) r14;
        r6.endReplaceGroup();
        int r15 = (((((r1 & 14) | (r1 & 112)) | ((r1 >> 3) & 896)) | ((r1 << 3) & 7168)) | ((r1 >> 12) & 458752)) | ((r2 << 18) & 3670016);
        int r27 = r2 << 21;
        int r28 = (r15 | (234881024 & r27)) | (r27 & 1879048192);
        Composer r210 = r6;
        PlatformURLImageKt.a(r29, r30, r111, r18, r4, r112, r113, r26, r20, r22, r210, r28, 0);
        if (ComposerKt.isTraceInProgress() == false) goto L222;
        ComposerKt.traceEventEnd();
    L222:
        final b r46 = r18;
        final ContentScale r47 = r111;
        final CachePolicy r114 = r112;
        final CachePolicy r115 = r113;
        final Painter r116 = r20;
        final a r48 = r23;
    L223:
        ScopeUpdateScope r49 = r210.endRestartGroup();
        if (r49 == null) goto L227;
        final Painter r117 = r22;
        r49.updateScope(new URLImageComponentKt$URLImageComponent$2(r29, r30, r46, r47, r33, r34, r35, r36, r48, r114, r115, r116, r117, r43, r44, r45));
        return;
    L227:
        return;
    L217:
        if (r14 != Composer.Companion.getEmpty()) goto L219;
    L213:
        r12 = false;
        goto L214
    L209:
        r10 = false;
        goto L210
    L205:
        r8 = false;
        goto L206
    L201:
        r7 = false;
    L170:
        if ((r45 & 4) == 0) goto L172;
        b r50 = new b();
        r1 = r1 & (-897);
    L173:
        if (r110 == 0) goto L175;
        ContentScale r51 = ContentScale.Companion.getFit();
    L176:
        b r310 = r50;
        if ((r45 & 256) == 0) goto L179;
        a r52 = b(r6);
        r1 = r1 & (-234881025);
    L180:
        if (r3 == 0) goto L182;
        CachePolicy r53 = CachePolicy.Enabled;
    L183:
        if (r0 == 0) goto L185;
        CachePolicy r54 = CachePolicy.Enabled;
    L186:
        CachePolicy r311 = r54;
        if ((r45 & 2048) == 0) goto L189;
        Painter r55 = tkb.a.a(r6);
        r2 = r2 & (-113);
    L190:
        Painter r312 = r55;
        if ((r45 & 4096) == 0) goto L193;
        Painter r56 = tkb.a.a(r6);
        r2 = r2 & (-897);
    L194:
        r18 = r310;
        r113 = r311;
        r20 = r312;
        r22 = r56;
        r112 = r53;
        r111 = r51;
        r5 = r52;
        goto L195
    L193:
        r56 = r41;
        goto L194
    L189:
        r55 = r40;
        goto L190
    L185:
        r54 = r39;
        goto L186
    L182:
        r53 = r38;
        goto L183
    L179:
        r52 = r37;
        goto L180
    L175:
        r51 = r32;
        goto L176
    L172:
        r50 = r31;
        goto L173
    L146:
        if ((r2 & 147) != 146) goto L151;
        if (r6.getSkipping() == false) goto L151;
        r6.skipToGroupEnd();
        r46 = r31;
        r47 = r32;
        r48 = r37;
        r114 = r38;
        r115 = r39;
        r116 = r40;
        r22 = r41;
        r210 = r6;
        goto L223
    L113:
        if ((r44 & 6) != 0) goto L122;
        if (r39 != null) goto L116;
        int r57 = -1;
    L118:
        if (r6.changed(r57) == false) goto L120;
        int r58 = 4;
    L121:
        r21 = r44 | r58;
        goto L124
    L120:
        r58 = 2;
        goto L121
    L116:
        r57 = r39.ordinal();
        goto L118
    L122:
        r21 = r44;
        goto L124
    L100:
        if ((r43 & 805306368) != 0) goto L109;
        if (r38 != null) goto L103;
        int r59 = -1;
    L105:
        if (r6.changed(r59) == false) goto L107;
        int r60 = 536870912;
    L108:
        r1 = r1 | r60;
        goto L109
    L107:
        r60 = 268435456;
        goto L108
    L103:
        r59 = r38.ordinal();
        goto L105
    L79:
        if ((r43 & 12582912) != 0) goto L86;
        if (r6.changedInstance(r36) == false) goto L83;
        r24 = 8388608;
        goto L84
    L83:
        r24 = 4194304;
        goto L84
    L69:
        if ((r43 & 1572864) != 0) goto L75;
        if (r6.changedInstance(r35) == false) goto L73;
        int r61 = 1048576;
    L74:
        r1 = r1 | r61;
        goto L75
    L73:
        r61 = 524288;
        goto L74
    L59:
        if ((r43 & 196608) != 0) goto L66;
        if (r6.changedInstance(r34) == false) goto L63;
        int r62 = 131072;
    L64:
        r1 = r1 | r62;
        goto L66
    L63:
        r62 = 65536;
        goto L64
    L49:
        if ((r43 & 24576) != 0) goto L56;
        if (r6.changedInstance(r33) == false) goto L53;
        int r63 = 16384;
    L54:
        r1 = r1 | r63;
        goto L56
    L53:
        r63 = 8192;
        goto L54
    L38:
        if ((r43 & 3072) != 0) goto L46;
        if (r6.changed(r32) == false) goto L42;
        int r211 = 2048;
    L43:
        r1 = r1 | r211;
        goto L46
    L42:
        r211 = 1024;
        goto L43
    L17:
        if ((r43 & 48) != 0) goto L23;
        if (r6.changed(r30) == false) goto L21;
        int r64 = 32;
    L22:
        r1 = r1 | r64;
        goto L23
    L21:
        r64 = 16;
        goto L22
    L6:
        if ((r43 & 6) == 0) goto L8;
        r1 = r43;
        goto L13
    L8:
        if (r6.changed(r29) == false) goto L10;
        int r65 = 4;
    L11:
        r1 = r65 | r43;
        goto L13
    L10:
        r65 = 2;
        goto L11
    }
}
