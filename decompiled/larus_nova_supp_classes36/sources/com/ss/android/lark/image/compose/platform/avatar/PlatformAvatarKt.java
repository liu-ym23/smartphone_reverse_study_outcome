package com.ss.android.lark.image.compose.platform.avatar;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Density;
import com.ss.android.lark.image.compose.android_platform.BaseImageComponentKt;
import com.ss.android.lark.image.compose.common.ImageFormat;
import com.ss.android.lark.image.compose.common.avatar.c;
import com.ss.android.lark.image.entity.AvatarImage;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import tkb.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class PlatformAvatarKt {

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[ImageFormat.values().length];
            r0[ImageFormat.PNG.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r0[ImageFormat.HEIC.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r0[ImageFormat.JPEG.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r0[ImageFormat.WEBP.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            a = r0;
        }
    }

    public static final void a(final com.ss.android.lark.image.compose.common.avatar.a r23, final Modifier r24, final b r25, Painter r26, Painter r27, Function1<? super c, Unit> r28, Composer r29, final int r30, final int r31) {
        Intrinsics.checkNotNullParameter(r23, "avatarImage");
        Intrinsics.checkNotNullParameter(r24, "modifier");
        Intrinsics.checkNotNullParameter(r25, "imageOptions");
        Composer r13 = r29.startRestartGroup(-324350510);
        if ((r31 & 1) == 0) goto L6;
        int r3 = r30 | 6;
    L14:
        if ((r31 & 2) == 0) goto L17;
        r3 = r3 | 48;
    L24:
        if ((r31 & 4) == 0) goto L27;
        r3 = r3 | 384;
    L33:
        int r6 = r31 & 8;
        if (r6 == 0) goto L37;
        r3 = r3 | 3072;
    L43:
        Painter r7 = r26;
    L44:
        int r8 = r31 & 16;
        if (r8 == 0) goto L48;
        r3 = r3 | 24576;
    L54:
        Painter r9 = r27;
    L55:
        int r10 = r31 & 32;
        if (r10 == 0) goto L59;
        r3 = r3 | 196608;
    L65:
        Function1<? super c, Unit> r11 = r28;
    L67:
        if ((74899 & r3) != 74898) goto L73;
        if (r13.getSkipping() == false) goto L73;
        r13.skipToGroupEnd();
        final Painter r4 = r7;
        final Painter r5 = r9;
        final Function1<? super c, Unit> r12 = r11;
        Composer r22 = r13;
    L111:
        ScopeUpdateScope r14 = r22.endRestartGroup();
        if (r14 == null) goto L115;
        r14.updateScope(new PlatformAvatarKt$PlatformAvatar$1(r23, r24, r25, r4, r5, r12, r30, r31));
        return;
    L115:
        return;
    L73:
        if (r6 == 0) goto L75;
        Painter r18 = null;
    L76:
        if (r8 == 0) goto L78;
        Painter r19 = null;
    L79:
        if (r10 == 0) goto L81;
        Function1<? super c, Unit> r20 = null;
    L83:
        if (ComposerKt.isTraceInProgress() == false) goto L85;
        ComposerKt.traceEventStart(-324350510, r3, -1, "com.ss.android.lark.image.compose.platform.avatar.PlatformAvatar (PlatformAvatar.kt:24)");
    L85:
        Density r2 = (Density) r13.consume(CompositionLocalsKt.getLocalDensity());
        r13.startReplaceGroup(5004770);
        if ((r3 & 14) != 4) goto L88;
        boolean r15 = true;
    L89:
        Object r16 = r13.rememberedValue();
        if (r15 == false) goto L92;
    L93:
        int r17 = MathKt.roundToInt(r2.toPx-0680j_4(r23.c));
        AvatarImage.Builder r21 = AvatarImage.Builder.obtain(r23.a, r23.b, r17, r17);
        int r32 = a.a[r23.e.ordinal()];
        if (r32 != 1) goto L96;
        com.ss.android.lark.image.entity.ImageFormat r33 = com.ss.android.lark.image.entity.ImageFormat.PNG;
    L106:
        Intrinsics.checkNotNull(r33, "null cannot be cast to non-null type com.ss.android.lark.image.entity.ImageFormat");
        r16 = r21.format(r33).build();
        r13.updateRememberedValue(r16);
    L107:
        AvatarImage r34 = (AvatarImage) r16;
        r13.endReplaceGroup();
        Intrinsics.checkNotNull(r34);
        int r110 = (((57344 & (r3 << 6)) | 432) | ((r3 << 15) & 3670016)) | ((r3 << 12) & 1879048192);
        int r35 = r3 >> 9;
        r22 = r13;
        BaseImageComponentKt.a(new com.ss.android.lark.image.compose.android_platform.a.C0091a(r34), "", Alignment.Companion.getCenter(), null, r25, 0, r24, null, null, r20, r18, r19, r22, r110, (r35 & 14) | (r35 & 112), 424);
        if (ComposerKt.isTraceInProgress() == false) goto L110;
        ComposerKt.traceEventEnd();
    L110:
        r4 = r18;
        r5 = r19;
        r12 = r20;
        goto L111
    L96:
        if (r32 != 2) goto L98;
        r33 = com.ss.android.lark.image.entity.ImageFormat.HEIC;
        goto L106
    L98:
        if (r32 == 3) goto L103;
        if (r32 != 4) goto L102;
        r33 = com.ss.android.lark.image.entity.ImageFormat.WEBP;
        goto L106
    L102:
        throw new NoWhenBranchMatchedException();
    L103:
        r33 = com.ss.android.lark.image.entity.ImageFormat.JPEG;
        goto L106
    L92:
        if (r16 != Composer.Companion.getEmpty()) goto L107;
    L88:
        r15 = false;
        goto L89
    L81:
        r20 = r11;
        goto L83
    L78:
        r19 = r9;
        goto L79
    L75:
        r18 = r7;
        goto L76
    L59:
        if ((196608 & r30) != 0) goto L65;
        r11 = r28;
        if (r13.changedInstance(r11) == false) goto L63;
        int r111 = 131072;
    L64:
        r3 = r3 | r111;
        goto L67
    L63:
        r111 = 65536;
        goto L64
    L48:
        if ((r30 & 24576) != 0) goto L54;
        r9 = r27;
        if (r13.changedInstance(r9) == false) goto L52;
        int r112 = 16384;
    L53:
        r3 = r3 | r112;
        goto L55
    L52:
        r112 = 8192;
        goto L53
    L37:
        if ((r30 & 3072) != 0) goto L43;
        r7 = r26;
        if (r13.changedInstance(r7) == false) goto L41;
        int r36 = 2048;
    L42:
        r3 = r3 | r36;
        goto L44
    L41:
        r36 = 1024;
        goto L42
    L27:
        if ((r30 & 384) != 0) goto L33;
        if (r13.changed(r25) == false) goto L31;
        int r37 = 256;
    L32:
        r3 = r3 | r37;
        goto L33
    L31:
        r37 = 128;
        goto L32
    L17:
        if ((r30 & 48) != 0) goto L24;
        if (r13.changed(r24) == false) goto L21;
        int r38 = 32;
    L22:
        r3 = r3 | r38;
        goto L24
    L21:
        r38 = 16;
        goto L22
    L6:
        if ((r30 & 6) == 0) goto L8;
        r3 = r30;
        goto L14
    L8:
        if (r13.changed(r23) == false) goto L10;
        int r39 = 4;
    L11:
        r3 = r39 | r30;
        goto L14
    L10:
        r39 = 2;
        goto L11
    }
}
