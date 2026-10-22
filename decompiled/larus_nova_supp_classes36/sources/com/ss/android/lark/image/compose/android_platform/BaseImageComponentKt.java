package com.ss.android.lark.image.compose.android_platform;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import androidx.compose.foundation.ImageKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import com.ss.android.lark.image.compose.common.CachePolicy;
import com.ss.android.lark.image.compose.common.avatar.c;
import kotlin.Unit;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import tkb.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class BaseImageComponentKt {
    public static final Handler a = null;

    static {
        a = new Handler(Looper.getMainLooper());
    }

    public static final long b(Drawable r6) {
        if (r6.getIntrinsicWidth() < 0) goto L8;
        if (r6.getIntrinsicHeight() < 0) goto L8;
        float r0 = r6.getIntrinsicWidth();
        float r7 = r6.getIntrinsicHeight();
        return Size.constructor-impl((Float.floatToRawIntBits(r0) << 32) | (((long) Float.floatToRawIntBits(r7)) & 4294967295L));
    L8:
        return Size.Companion.getUnspecified-NH-jbRc();
    }

    public static final void a(final a r32, final String r33, final Alignment r34, ContentScale r35, final b r36, int r37, final Modifier r38, CachePolicy r39, CachePolicy r40, Function1<? super c, Unit> r41, Painter r42, Painter r43, Composer r44, final int r45, final int r46, final int r47) {
        Intrinsics.checkNotNullParameter(r32, "imageSource");
        Intrinsics.checkNotNullParameter(r34, "alignment");
        Intrinsics.checkNotNullParameter(r36, "imageOptions");
        Intrinsics.checkNotNullParameter(r38, "modifier");
        Composer r10 = r44.startRestartGroup(2128425289);
        if ((r47 & 1) == 0) goto L6;
        int r3 = r45 | 6;
    L17:
        if ((r47 & 2) == 0) goto L20;
        r3 = r3 | 48;
    L28:
        if ((r47 & 4) == 0) goto L31;
        r3 = r3 | 384;
    L37:
        int r7 = r47 & 8;
        if (r7 == 0) goto L41;
        r3 = r3 | 3072;
    L49:
        if ((r47 & 16) == 0) goto L52;
        r3 = r3 | 24576;
    L58:
        int r9 = r47 & 32;
        if (r9 == 0) goto L62;
        r3 = r3 | 196608;
    L69:
        if ((r47 & 64) == 0) goto L73;
        int r21 = 1572864;
    L71:
        r3 = r3 | r21;
    L78:
        int r2 = r47 & 128;
        if (r2 == 0) goto L82;
        r3 = r3 | 12582912;
    L91:
        int r4 = r47 & 256;
        if (r4 == 0) goto L95;
        r3 = r3 | 100663296;
    L104:
        int r5 = r47 & 512;
        if (r5 == 0) goto L108;
        r3 = r3 | 805306368;
    L114:
        int r6 = r47 & 1024;
        if (r6 == 0) goto L118;
        int r22 = r46 | 6;
    L125:
        int r12 = r47 & 2048;
        if (r12 == 0) goto L129;
        r22 = r22 | 48;
    L135:
        int r11 = r22;
        if ((r3 & 306783379) == 306783378) goto L138;
    L143:
        if (r7 == 0) goto L145;
        ContentScale r23 = ContentScale.Companion.getFit();
    L146:
        if (r9 == 0) goto L148;
        int r15 = 0;
    L149:
        if (r2 == 0) goto L151;
        CachePolicy r13 = CachePolicy.Enabled;
    L152:
        if (r4 == 0) goto L154;
        CachePolicy r14 = CachePolicy.Enabled;
    L155:
        if (r5 == 0) goto L157;
        Function1<? super c, Unit> r8 = null;
    L158:
        if (r6 == 0) goto L160;
        Painter r16 = null;
    L161:
        if (r12 == 0) goto L163;
        Painter r17 = null;
    L165:
        if (ComposerKt.isTraceInProgress() == false) goto L167;
        ComposerKt.traceEventStart(2128425289, r3, r11, "com.ss.android.lark.image.compose.android_platform.BaseImageComponent (BaseImageComponent.kt:64)");
    L167:
        CachePolicy r18 = CachePolicy.Enabled;
        if (r14 != r18) goto L170;
    L173:
        boolean r19 = true;
    L174:
        if (r19 == false) goto L249;
        if (r13 != r18) goto L177;
    L180:
        boolean r20 = true;
    L181:
        if (r20 == false) goto L247;
        int r24 = r3 >> 9;
        int r25 = ((r3 & 14) | (r24 & 112)) | (r24 & 896);
        int r26 = r3 >> 12;
        int r27 = r11 << 15;
        int r28 = ((((r25 | (r26 & 7168)) | (r26 & 57344)) | (458752 & r27)) | (r27 & 3670016)) | ((r3 >> 6) & 29360128);
        Intrinsics.checkNotNullParameter(r32, "imageSource");
        Intrinsics.checkNotNullParameter(r36, "imageOptions");
        r10.startReplaceGroup(-363190735);
        if (ComposerKt.isTraceInProgress() == false) goto L185;
        ComposerKt.traceEventStart(-363190735, r28, -1, "com.ss.android.lark.image.compose.android_platform.rememberGlidePainter (BaseImageComponent.kt:219)");
    L185:
        Context r1 = (Context) r10.consume(AndroidCompositionLocals_androidKt.getLocalContext());
        Object r0 = r10.rememberedValue();
        Composer.Companion r29 = Composer.Companion;
        if (r0 != r29.getEmpty()) goto L188;
        r0 = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, r10);
        r10.updateRememberedValue(r0);
    L188:
        CoroutineScope r210 = (CoroutineScope) r0;
        r10.startReplaceGroup(-1224400529);
        if (((r28 & 14) ^ 6) <= 4) goto L193;
        if (r10.changed(r32) == false) goto L193;
    L194:
        boolean r30 = true;
    L196:
        int r211 = r3;
        if (((r28 & 112) ^ 48) <= 32) goto L201;
        if (r10.changed(r36) == false) goto L201;
    L202:
        boolean r31 = true;
    L204:
        boolean r48 = r30 | r31;
        if (((r28 & 896) ^ 384) <= 256) goto L209;
        if (r10.changed(r15) == false) goto L209;
    L210:
        boolean r49 = true;
    L212:
        boolean r50 = r48 | r49;
        if (((r28 & 7168) ^ 3072) <= 2048) goto L217;
        if (r10.changed(r13.ordinal()) == false) goto L217;
    L218:
        boolean r51 = true;
    L220:
        boolean r52 = r50 | r51;
        if (((r28 & 57344) ^ 24576) <= 16384) goto L225;
        if (r10.changed(r14.ordinal()) == false) goto L225;
    L226:
        boolean r53 = true;
    L228:
        boolean r54 = ((r52 | r53) | r10.changed(r16)) | r10.changed(r17);
        Object r55 = r10.rememberedValue();
        if (r54 == false) goto L231;
    L234:
        Function1<? super c, Unit> r110 = r8;
        int r212 = r26;
        GlidePainter r111 = new GlidePainter(r1, r32, r36, r13, r14, r16, r17);
        BuildersKt.launch$default(r210, null, null, new BaseImageComponentKt$rememberGlidePainter$painter$1$1$1(r111, r110, null), 3, null);
        r10.updateRememberedValue(r111);
        r55 = r111;
    L235:
        GlidePainter r56 = (GlidePainter) r55;
        r10.endReplaceGroup();
        if (ComposerKt.isTraceInProgress() == false) goto L238;
        ComposerKt.traceEventEnd();
    L238:
        r10.endReplaceGroup();
        int r57 = r211 << 3;
        int r112 = (((r211 & 112) | (r212 & 896)) | (r57 & 7168)) | (r57 & 57344);
        CachePolicy r58 = r14;
        Composer r59 = r10;
        Painter r60 = r17;
        CachePolicy r61 = r13;
        Function1<? super c, Unit> r62 = r110;
        int r63 = r15;
        ImageKt.Image(r56, r33, r38, r34, r23, 0.0f, null, r59, r112, 96);
        if (ComposerKt.isTraceInProgress() == false) goto L241;
        ComposerKt.traceEventEnd();
    L241:
        final Function1<? super c, Unit> r113 = r62;
        final CachePolicy r64 = r58;
        final Painter r114 = r60;
        final CachePolicy r65 = r61;
        final int r66 = r63;
        final Painter r115 = r16;
        final ContentScale r67 = r23;
    L242:
        ScopeUpdateScope r116 = r59.endRestartGroup();
        if (r116 == null) goto L250;
        r116.updateScope(new BaseImageComponentKt$BaseImageComponent$3(r32, r33, r34, r67, r36, r66, r38, r65, r64, r113, r115, r114, r45, r46, r47));
        return;
    L250:
        return;
    L231:
        if (r55 == r29.getEmpty()) goto L234;
        r212 = r26;
        r110 = r8;
    L225:
        if ((r28 & 24576) == 16384) goto L226;
        r53 = false;
    L217:
        if ((r28 & 3072) == 2048) goto L218;
        r51 = false;
    L209:
        if ((r28 & 384) == 256) goto L210;
        r49 = false;
    L201:
        if ((r28 & 48) == 32) goto L202;
        r31 = false;
    L193:
        if ((r28 & 6) == 4) goto L194;
        r30 = false;
        goto L196
    L247:
        throw new IllegalArgumentException(("Glide does not support an equivalent disk cache policy: " + r13 + " (only Enabled/Disabled are supported).").toString());
    L177:
        if (r13 == CachePolicy.Disabled) goto L180;
        r20 = false;
        goto L181
    L249:
        throw new IllegalArgumentException(("Glide does not support an equivalent memory cache policy: " + r14 + " (only Enabled/Disabled are supported).").toString());
    L170:
        if (r14 == CachePolicy.Disabled) goto L173;
        r19 = false;
        goto L174
    L163:
        r17 = r43;
        goto L165
    L160:
        r16 = r42;
        goto L161
    L157:
        r8 = r41;
        goto L158
    L154:
        r14 = r40;
        goto L155
    L151:
        r13 = r39;
        goto L152
    L148:
        r15 = r37;
        goto L149
    L145:
        r23 = r35;
        goto L146
    L138:
        if ((r11 & 19) != 18) goto L143;
        if (r10.getSkipping() == false) goto L143;
        r10.skipToGroupEnd();
        r67 = r35;
        r66 = r37;
        r65 = r39;
        r64 = r40;
        r115 = r42;
        r114 = r43;
        r59 = r10;
        r113 = r41;
        goto L242
    L129:
        if ((r46 & 48) != 0) goto L135;
        if (r10.changedInstance(r43) == false) goto L133;
        int r117 = 32;
    L134:
        r22 = r22 | r117;
        goto L135
    L133:
        r117 = 16;
        goto L134
    L118:
        if ((r46 & 6) == 0) goto L120;
        r22 = r46;
        goto L125
    L120:
        if (r10.changedInstance(r42) == false) goto L122;
        int r213 = 4;
    L123:
        r22 = r46 | r213;
        goto L125
    L122:
        r213 = 2;
        goto L123
    L108:
        if ((r45 & 805306368) != 0) goto L114;
        if (r10.changedInstance(r41) == false) goto L112;
        int r214 = 536870912;
    L113:
        r3 = r3 | r214;
        goto L114
    L112:
        r214 = 268435456;
        goto L113
    L95:
        if ((r45 & 100663296) != 0) goto L104;
        if (r40 != null) goto L98;
        int r68 = -1;
    L100:
        if (r10.changed(r68) == false) goto L102;
        int r69 = 67108864;
    L103:
        r3 = r3 | r69;
        goto L104
    L102:
        r69 = 33554432;
        goto L103
    L98:
        r68 = r40.ordinal();
        goto L100
    L82:
        if ((r45 & 12582912) != 0) goto L91;
        if (r39 != null) goto L85;
        int r70 = -1;
    L87:
        if (r10.changed(r70) == false) goto L89;
        int r71 = 8388608;
    L90:
        r3 = r3 | r71;
        goto L91
    L89:
        r71 = 4194304;
        goto L90
    L85:
        r70 = r39.ordinal();
        goto L87
    L73:
        if ((r45 & 1572864) != 0) goto L78;
        if (r10.changed(r38) == false) goto L77;
        r21 = 1048576;
        goto L71
    L77:
        r21 = 524288;
        goto L71
    L62:
        if ((r45 & 196608) != 0) goto L69;
        if (r10.changed(r37) == false) goto L66;
        int r215 = 131072;
    L67:
        r3 = r3 | r215;
        goto L69
    L66:
        r215 = 65536;
        goto L67
    L52:
        if ((r45 & 24576) != 0) goto L58;
        if (r10.changed(r36) == false) goto L56;
        int r72 = 16384;
    L57:
        r3 = r3 | r72;
        goto L58
    L56:
        r72 = 8192;
        goto L57
    L41:
        if ((r45 & 3072) != 0) goto L49;
        if (r10.changed(r35) == false) goto L45;
        int r118 = 2048;
    L46:
        r3 = r3 | r118;
        goto L49
    L45:
        r118 = 1024;
        goto L46
    L31:
        if ((r45 & 384) != 0) goto L37;
        if (r10.changed(r34) == false) goto L35;
        int r73 = 256;
    L36:
        r3 = r3 | r73;
        goto L37
    L35:
        r73 = 128;
        goto L36
    L20:
        if ((r45 & 48) != 0) goto L28;
        if (r10.changed(r33) == false) goto L24;
        int r119 = 32;
    L25:
        r3 = r3 | r119;
        goto L28
    L24:
        r119 = 16;
        goto L25
    L6:
        if ((r45 & 6) == 0) goto L8;
        r3 = r45;
        goto L17
    L8:
        if ((r45 & 8) != 0) goto L10;
        boolean r74 = r10.changed(r32);
    L11:
        if (r74 == false) goto L13;
        int r75 = 4;
    L14:
        r3 = r75 | r45;
        goto L17
    L13:
        r75 = 2;
        goto L14
    L10:
        r74 = r10.changedInstance(r32);
        goto L11
    }
}
