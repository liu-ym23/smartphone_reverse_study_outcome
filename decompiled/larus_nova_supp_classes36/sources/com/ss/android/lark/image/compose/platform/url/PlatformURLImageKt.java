package com.ss.android.lark.image.compose.platform.url;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.ContentScale;
import com.ss.android.lark.image.compose.android_platform.BaseImageComponentKt;
import com.ss.android.lark.image.compose.android_platform.a;
import com.ss.android.lark.image.compose.common.CachePolicy;
import com.ss.android.lark.image.compose.common.avatar.c;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import tkb.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class PlatformURLImageKt {
    public static final void a(final String r25, final Modifier r26, ContentScale r27, final b r28, final int r29, CachePolicy r30, CachePolicy r31, Function1<? super c, Unit> r32, Painter r33, Painter r34, Composer r35, final int r36, final int r37) {
        Intrinsics.checkNotNullParameter(r25, "url");
        Intrinsics.checkNotNullParameter(r26, "modifier");
        Intrinsics.checkNotNullParameter(r28, "imageOptions");
        Composer r12 = r35.startRestartGroup(-474559543);
        if ((r37 & 1) == 0) goto L6;
        int r3 = r36 | 6;
    L14:
        if ((r37 & 2) == 0) goto L17;
        r3 = r3 | 48;
    L23:
        int r4 = r37 & 4;
        if (r4 == 0) goto L27;
        r3 = r3 | 384;
    L35:
        if ((r37 & 8) == 0) goto L38;
        r3 = r3 | 3072;
    L45:
        if ((r37 & 16) == 0) goto L48;
        r3 = r3 | 24576;
    L54:
        int r6 = r37 & 32;
        int r7 = 196608;
        if (r6 == 0) goto L58;
    L56:
        r3 = r3 | r7;
    L66:
        int r8 = r37 & 64;
        int r9 = 1572864;
        if (r8 == 0) goto L70;
    L68:
        r3 = r3 | r9;
    L78:
        int r10 = r37 & 128;
        if (r10 == 0) goto L82;
        r3 = r3 | 12582912;
    L88:
        Function1<? super c, Unit> r11 = r32;
    L89:
        int r2 = r37 & 256;
        if (r2 == 0) goto L93;
        r3 = r3 | 100663296;
    L99:
        int r0 = r37 & 512;
        if (r0 == 0) goto L103;
        r3 = r3 | 805306368;
    L110:
        if ((r3 & 306783379) == 306783378) goto L112;
    L115:
        if (r4 == 0) goto L117;
        ContentScale r18 = ContentScale.Companion.getFit();
    L118:
        if (r6 == 0) goto L120;
        CachePolicy r19 = CachePolicy.Enabled;
    L121:
        if (r8 == 0) goto L123;
        CachePolicy r20 = CachePolicy.Enabled;
    L125:
        if (r10 == 0) goto L127;
        Function1<? super c, Unit> r21 = null;
    L128:
        if (r2 == 0) goto L130;
        Painter r22 = null;
    L131:
        if (r0 == 0) goto L133;
        Painter r1 = null;
    L135:
        if (ComposerKt.isTraceInProgress() == false) goto L137;
        ComposerKt.traceEventStart(-474559543, r3, -1, "com.ss.android.lark.image.compose.platform.url.PlatformURLImage (PlatformURLImage.kt:29)");
    L137:
        int r13 = r3 << 3;
        int r14 = ((r13 & 458752) | (((r13 & 7168) | 432) | (57344 & r13))) | ((r3 << 15) & 3670016);
        int r15 = r3 << 6;
        int r5 = r3 >> 24;
        Composer r24 = r12;
        BaseImageComponentKt.a(new a.d(r25), "", Alignment.Companion.getCenter(), r18, r28, r29, r26, r19, r20, r21, r22, r1, r24, ((r14 | (29360128 & r15)) | (234881024 & r15)) | (r15 & 1879048192), (r5 & 14) | (r5 & 112), 0);
        if (ComposerKt.isTraceInProgress() == false) goto L140;
        ComposerKt.traceEventEnd();
    L140:
        final Painter r16 = r1;
        final ContentScale r17 = r18;
        final CachePolicy r23 = r19;
        final CachePolicy r38 = r20;
        final Function1<? super c, Unit> r39 = r21;
        final Painter r40 = r22;
    L141:
        ScopeUpdateScope r110 = r24.endRestartGroup();
        if (r110 == null) goto L145;
        r110.updateScope(new PlatformURLImageKt$PlatformURLImage$1(r25, r26, r17, r28, r29, r23, r38, r39, r40, r16, r36, r37));
        return;
    L145:
        return;
    L133:
        r1 = r34;
        goto L135
    L130:
        r22 = r33;
        goto L131
    L127:
        r21 = r11;
        goto L128
    L123:
        r20 = r31;
        goto L125
    L120:
        r19 = r30;
        goto L121
    L117:
        r18 = r27;
        goto L118
    L112:
        if (r12.getSkipping() == false) goto L115;
        r12.skipToGroupEnd();
        r17 = r27;
        r23 = r30;
        r38 = r31;
        r40 = r33;
        r39 = r11;
        r24 = r12;
        r16 = r34;
        goto L141
    L103:
        if ((r36 & 805306368) != 0) goto L110;
        if (r12.changedInstance(r34) == false) goto L107;
        int r111 = 536870912;
    L108:
        r3 = r3 | r111;
        goto L110
    L107:
        r111 = 268435456;
        goto L108
    L93:
        if ((r36 & 100663296) != 0) goto L99;
        if (r12.changedInstance(r33) == false) goto L97;
        int r112 = 67108864;
    L98:
        r3 = r3 | r112;
        goto L99
    L97:
        r112 = 33554432;
        goto L98
    L82:
        if ((12582912 & r36) != 0) goto L88;
        r11 = r32;
        if (r12.changedInstance(r11) == false) goto L86;
        int r113 = 8388608;
    L87:
        r3 = r3 | r113;
        goto L89
    L86:
        r113 = 4194304;
        goto L87
    L70:
        if ((1572864 & r36) != 0) goto L78;
        if (r31 != null) goto L73;
        int r41 = -1;
    L75:
        if (r12.changed(r41) == false) goto L77;
        r9 = 1048576;
        goto L68
    L77:
        r9 = 524288;
        goto L68
    L73:
        r41 = r31.ordinal();
        goto L75
    L58:
        if ((196608 & r36) != 0) goto L66;
        if (r30 != null) goto L61;
        int r42 = -1;
    L63:
        if (r12.changed(r42) == false) goto L65;
        r7 = 131072;
        goto L56
    L65:
        r7 = 65536;
        goto L56
    L61:
        r42 = r30.ordinal();
        goto L63
    L48:
        if ((r36 & 24576) != 0) goto L54;
        if (r12.changed(r29) == false) goto L52;
        int r43 = 16384;
    L53:
        r3 = r3 | r43;
        goto L54
    L52:
        r43 = 8192;
        goto L53
    L38:
        if ((r36 & 3072) != 0) goto L45;
        if (r12.changed(r28) == false) goto L42;
        int r44 = 2048;
    L43:
        r3 = r3 | r44;
        goto L45
    L42:
        r44 = 1024;
        goto L43
    L27:
        if ((r36 & 384) != 0) goto L35;
        if (r12.changed(r27) == false) goto L31;
        int r45 = 256;
    L32:
        r3 = r3 | r45;
        goto L35
    L31:
        r45 = 128;
        goto L32
    L17:
        if ((r36 & 48) != 0) goto L23;
        if (r12.changed(r26) == false) goto L21;
        int r46 = 32;
    L22:
        r3 = r3 | r46;
        goto L23
    L21:
        r46 = 16;
        goto L22
    L6:
        if ((r36 & 6) == 0) goto L8;
        r3 = r36;
        goto L14
    L8:
        if (r12.changed(r25) == false) goto L10;
        int r47 = 4;
    L11:
        r3 = r47 | r36;
        goto L14
    L10:
        r47 = 2;
        goto L11
    }
}
