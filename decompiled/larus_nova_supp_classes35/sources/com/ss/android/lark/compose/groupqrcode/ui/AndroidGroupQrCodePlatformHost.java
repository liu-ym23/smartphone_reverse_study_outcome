package com.ss.android.lark.compose.groupqrcode.ui;

import android.content.Context;
import android.graphics.Bitmap;
import androidx.compose.foundation.ImageKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionContext;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.AndroidImageBitmap_androidKt;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.platform.ComposeView;
import androidx.compose.ui.viewinterop.AndroidView_androidKt;
import androidx.fragment.app.FragmentActivity;
import c7c.b;
import com.ss.android.lark.chameleon.container.webcontainer.util.ChameleonContainerUtils;
import com.ss.android.lark.time.format.entity.DisplayPattern;
import com.ss.android.lark.time.format.entity.LengthType;
import java.util.Date;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class AndroidGroupQrCodePlatformHost implements a {
    public final FragmentActivity a;
    public final Lazy b;
    public final Lazy c;
    public volatile Bitmap d;
    public final Lazy e;

    @Override // com.ss.android.lark.compose.groupqrcode.ui.a
    public final String i() {
        return (String) this.e.getValue();
    }

    public AndroidGroupQrCodePlatformHost(FragmentActivity r2) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        this.a = r2;
        this.b = LazyKt.lazy(AndroidGroupQrCodePlatformHost$qrCodeHandler$2.INSTANCE);
        this.c = LazyKt.lazy(AndroidGroupQrCodePlatformHost$sharePanelProtocol$2.INSTANCE);
        this.e = LazyKt.lazy(AndroidGroupQrCodePlatformHost$brandName$2.INSTANCE);
    }

    @Override // com.ss.android.lark.compose.groupqrcode.ui.a
    public final String m(long r17) {
        Context r1 = this.a.getApplicationContext();
        Date r2 = new Date(((long) 1000) * r17);
        LengthType r8 = LengthType.SHORT;
        return b.a(r1, r2, new c7c.a(null, DisplayPattern.ABSOLUTE, r8, null, null, false, false, false, false, 2041));
    }

    @Override // com.ss.android.lark.compose.groupqrcode.ui.a
    public final void l(final Modifier r8, Composer r9, final int r10) {
        Intrinsics.checkNotNullParameter(r8, "modifier");
        Composer r11 = r9.startRestartGroup(1196728023);
        if ((r10 & 6) == 0) goto L5;
        int r1 = r10;
    L11:
        if ((r10 & 48) != 0) goto L18;
        if (r11.changedInstance(this) == false) goto L15;
        int r2 = 32;
    L16:
        r1 = r1 | r2;
        goto L18
    L15:
        r2 = 16;
    L18:
        if ((r1 & 19) != 18) goto L24;
        if (r11.getSkipping() == false) goto L24;
        r11.skipToGroupEnd();
    L34:
        ScopeUpdateScope r12 = r11.endRestartGroup();
        if (r12 == null) goto L38;
        r12.updateScope(new AndroidGroupQrCodePlatformHost$SharePanel$2(this, r8, r10));
        return;
    L38:
        return;
    L24:
        if (ComposerKt.isTraceInProgress() == false) goto L26;
        ComposerKt.traceEventStart(1196728023, r1, -1, "com.ss.android.lark.compose.groupqrcode.ui.AndroidGroupQrCodePlatformHost.SharePanel (AndroidGroupQrCodePlatformHost.kt:133)");
    L26:
        r11.startReplaceGroup(5004770);
        boolean r0 = r11.changedInstance(this);
        Object r3 = r11.rememberedValue();
        if (r0 == false) goto L29;
    L30:
        r3 = new AndroidGroupQrCodePlatformHost$SharePanel$1$1(this);
        r11.updateRememberedValue(r3);
    L31:
        r11.endReplaceGroup();
        AndroidView_androidKt.AndroidView((Function1) r3, r8, null, r11, (r1 << 3) & 112, 4);
        if (ComposerKt.isTraceInProgress() == false) goto L34;
        ComposerKt.traceEventEnd();
        goto L34
    L29:
        if (r3 != Composer.Companion.getEmpty()) goto L31;
    L5:
        if (r11.changed(r8) == false) goto L7;
        int r4 = 4;
    L8:
        r1 = r4 | r10;
        goto L11
    L7:
        r4 = 2;
        goto L8
    }

    @Override // com.ss.android.lark.compose.groupqrcode.ui.a
    public final void k(final boolean r19, final Modifier r20, final Function2<? super Composer, ? super Integer, Unit> r21, Composer r22, final int r23) {
        Intrinsics.checkNotNullParameter(r20, "modifier");
        Intrinsics.checkNotNullParameter(r21, "content");
        Composer r1 = r22.startRestartGroup(1678385494);
        if ((r23 & 6) == 0) goto L5;
        int r7 = r23;
    L11:
        if ((r23 & 48) != 0) goto L18;
        if (r1.changed(r20) == false) goto L15;
        int r9 = 32;
    L16:
        r7 = r7 | r9;
        goto L18
    L15:
        r9 = 16;
    L18:
        if ((r23 & 384) != 0) goto L25;
        if (r1.changedInstance(r21) == false) goto L22;
        int r10 = 256;
    L23:
        r7 = r7 | r10;
        goto L25
    L22:
        r10 = 128;
    L25:
        if ((r23 & 3072) == 0) goto L27;
    L31:
        int r14 = r7;
        if ((r14 & 1171) != 1170) goto L38;
        if (r1.getSkipping() == false) goto L38;
        r1.skipToGroupEnd();
    L60:
        ScopeUpdateScope r8 = r1.endRestartGroup();
        if (r8 == null) goto L64;
        r8.updateScope(new AndroidGroupQrCodePlatformHost$CapturableCard$3(this, r19, r20, r21, r23));
        return;
    L64:
        return;
    L38:
        if (ComposerKt.isTraceInProgress() == false) goto L40;
        ComposerKt.traceEventStart(1678385494, r14, -1, "com.ss.android.lark.compose.groupqrcode.ui.AndroidGroupQrCodePlatformHost.CapturableCard (AndroidGroupQrCodePlatformHost.kt:107)");
    L40:
        final CompositionContext r11 = ComposablesKt.rememberCompositionContext(r1, 0);
        final State r12 = SnapshotStateKt.rememberUpdatedState(r21, r1, (r14 >> 6) & 14);
        r1.startReplaceGroup(1849434622);
        Object r13 = r1.rememberedValue();
        Composer.Companion r15 = Composer.Companion;
        if (r13 != r15.getEmpty()) goto L43;
        r13 = SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        r1.updateRememberedValue(r13);
    L43:
        final MutableState r16 = (MutableState) r13;
        r1.endReplaceGroup();
        r1.startReplaceGroup(-1746271574);
        boolean r17 = r1.changedInstance(r11) | r1.changed(r12);
        Object r0 = r1.rememberedValue();
        if (r17 == false) goto L46;
    L47:
        r0 = new AndroidGroupQrCodePlatformHost$CapturableCard$1$1(r11, r12, r16);
        r1.updateRememberedValue(r0);
    L48:
        r1.endReplaceGroup();
        AndroidView_androidKt.AndroidView((Function1) r0, r20, null, r1, r14 & 112, 4);
        Boolean r18 = Boolean.valueOf(r19);
        ComposeView r24 = (ComposeView) r16.getValue();
        r1.startReplaceGroup(-1746271574);
        int r25 = r14 & 14;
        if (r25 != 4) goto L51;
        boolean r110 = true;
    L52:
        boolean r111 = r110 | r1.changedInstance(this);
        Object r112 = r1.rememberedValue();
        if (r111 == false) goto L55;
    L56:
        r112 = new AndroidGroupQrCodePlatformHost$CapturableCard$2$1(r19, this, r16, null);
        r1.updateRememberedValue(r112);
    L57:
        r1.endReplaceGroup();
        EffectsKt.LaunchedEffect(r18, r24, (Function2) r112, r1, (ComposeView.$stable << 3) | r25);
        if (ComposerKt.isTraceInProgress() == false) goto L60;
        ComposerKt.traceEventEnd();
        goto L60
    L55:
        if (r112 != r15.getEmpty()) goto L57;
    L51:
        r110 = false;
        goto L52
    L46:
        if (r0 != r15.getEmpty()) goto L48;
    L27:
        if (r1.changedInstance(this) == false) goto L29;
        int r26 = 2048;
    L30:
        r7 = r7 | r26;
        goto L31
    L29:
        r26 = ChameleonContainerUtils.MAX_URL_LENGTH;
        goto L30
    L5:
        if (r1.changed(r19) == false) goto L7;
        int r27 = 4;
    L8:
        r7 = r27 | r23;
        goto L11
    L7:
        r27 = 2;
        goto L8
    }

    @Override // com.ss.android.lark.compose.groupqrcode.ui.a
    public final void j(final String r23, final int r24, final Modifier r25, final Function0<Unit> r26, final Function1<? super Throwable, Unit> r27, Composer r28, final int r29) {
        Intrinsics.checkNotNullParameter(r23, "url");
        Intrinsics.checkNotNullParameter(r25, "modifier");
        Intrinsics.checkNotNullParameter(r26, "onReady");
        Intrinsics.checkNotNullParameter(r27, "onError");
        Composer r12 = r28.startRestartGroup(52020746);
        if ((r29 & 6) == 0) goto L5;
        int r1 = r29;
    L11:
        if ((r29 & 48) != 0) goto L18;
        if (r12.changed(r24) == false) goto L15;
        int r4 = 32;
    L16:
        r1 = r1 | r4;
        goto L18
    L15:
        r4 = 16;
    L18:
        if ((r29 & 384) != 0) goto L25;
        if (r12.changed(r25) == false) goto L22;
        int r5 = 256;
    L23:
        r1 = r1 | r5;
        goto L25
    L22:
        r5 = 128;
    L25:
        if ((r29 & 3072) != 0) goto L32;
        if (r12.changedInstance(r26) == false) goto L29;
        int r6 = 2048;
    L30:
        r1 = r1 | r6;
        goto L32
    L29:
        r6 = ChameleonContainerUtils.MAX_URL_LENGTH;
    L32:
        if ((r29 & 24576) != 0) goto L39;
        if (r12.changedInstance(r27) == false) goto L36;
        int r7 = 16384;
    L37:
        r1 = r1 | r7;
        goto L39
    L36:
        r7 = 8192;
    L39:
        if ((196608 & r29) == 0) goto L41;
    L45:
        int r8 = r1;
        if ((74899 & r8) != 74898) goto L52;
        if (r12.getSkipping() == false) goto L52;
        r12.skipToGroupEnd();
        Composer r9 = r12;
    L116:
        ScopeUpdateScope r10 = r9.endRestartGroup();
        if (r10 == null) goto L120;
        r10.updateScope(new AndroidGroupQrCodePlatformHost$QrCodeImage$5(this, r23, r24, r25, r26, r27, r29));
        return;
    L120:
        return;
    L52:
        if (ComposerKt.isTraceInProgress() == false) goto L54;
        ComposerKt.traceEventStart(52020746, r8, -1, "com.ss.android.lark.compose.groupqrcode.ui.AndroidGroupQrCodePlatformHost.QrCodeImage (AndroidGroupQrCodePlatformHost.kt:73)");
    L54:
        r12.startReplaceGroup(-1633490746);
        int r2 = r8 & 14;
        boolean r16 = true;
        if (r2 != 4) goto L57;
        boolean r17 = true;
    L58:
        int r11 = r8 & 112;
        if (r11 != 32) goto L61;
        boolean r19 = true;
    L62:
        boolean r18 = r17 | r19;
        Object r0 = r12.rememberedValue();
        if (r18 == false) goto L65;
    L66:
        r0 = SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        r12.updateRememberedValue(r0);
    L67:
        MutableState r3 = (MutableState) r0;
        r12.endReplaceGroup();
        r12.startReplaceGroup(-1633490746);
        if (r2 != 4) goto L70;
        boolean r13 = true;
    L72:
        if (r11 != 32) goto L74;
        boolean r14 = true;
    L75:
        boolean r15 = r13 | r14;
        Object r110 = r12.rememberedValue();
        if (r15 == false) goto L78;
    L79:
        r110 = SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        r12.updateRememberedValue(r110);
    L80:
        MutableState r111 = (MutableState) r110;
        r12.endReplaceGroup();
        Integer r20 = Integer.valueOf(r24);
        r12.startReplaceGroup(-1224400529);
        boolean r21 = r12.changedInstance(this);
        if (r2 != 4) goto L83;
        boolean r22 = true;
    L84:
        boolean r30 = ((r21 | r22) | r12.changed(r3)) | r12.changed(r111);
        Object r31 = r12.rememberedValue();
        if (r30 == false) goto L87;
    L90:
        Continuation r112 = null;
        AndroidGroupQrCodePlatformHost$QrCodeImage$1$1 r32 = new AndroidGroupQrCodePlatformHost$QrCodeImage$1$1(this, r23, r3, r111, null);
        r12.updateRememberedValue(r32);
        r31 = r32;
    L91:
        r12.endReplaceGroup();
        EffectsKt.LaunchedEffect(r23, r20, (Function2) r31, r12, r2 | r11);
        Bitmap r33 = (Bitmap) r3.getValue();
        r12.startReplaceGroup(-1633490746);
        boolean r34 = r12.changed(r3);
        if ((r8 & 7168) != 2048) goto L94;
        boolean r35 = true;
    L95:
        boolean r36 = r34 | r35;
        Object r37 = r12.rememberedValue();
        if (r36 == false) goto L98;
    L99:
        r37 = new AndroidGroupQrCodePlatformHost$QrCodeImage$2$1(r26, r3, r112);
        r12.updateRememberedValue(r37);
    L100:
        r12.endReplaceGroup();
        EffectsKt.LaunchedEffect(r33, (Function2) r37, r12, 0);
        Throwable r38 = (Throwable) r111.getValue();
        r12.startReplaceGroup(-1633490746);
        boolean r39 = r12.changed(r111);
        if ((57344 & r8) == 16384) goto L104;
        r16 = false;
    L104:
        boolean r40 = r39 | r16;
        Object r41 = r12.rememberedValue();
        if (r40 == false) goto L107;
    L108:
        r41 = new AndroidGroupQrCodePlatformHost$QrCodeImage$3$1(r27, r111, r112);
        r12.updateRememberedValue(r41);
    L109:
        r12.endReplaceGroup();
        EffectsKt.LaunchedEffect(r38, (Function2) r41, r12, 0);
        Bitmap r42 = (Bitmap) r3.getValue();
        if (r42 != null) goto L112;
        r9 = r12;
    L114:
        if (ComposerKt.isTraceInProgress() == false) goto L116;
        ComposerKt.traceEventEnd();
        goto L116
    L112:
        int r43 = (r8 & 896) | 24624;
        r9 = r12;
        ImageKt.Image-5h-nEew(AndroidImageBitmap_androidKt.asImageBitmap(r42), null, r25, null, ContentScale.Companion.getFillBounds(), 0.0f, null, 0, r9, r43, 232);
        goto L114
    L107:
        if (r41 != Composer.Companion.getEmpty()) goto L109;
    L98:
        if (r37 != Composer.Companion.getEmpty()) goto L100;
    L94:
        r35 = false;
        goto L95
    L87:
        if (r31 == Composer.Companion.getEmpty()) goto L90;
        r112 = null;
        goto L91
    L83:
        r22 = false;
        goto L84
    L78:
        if (r110 != Composer.Companion.getEmpty()) goto L80;
    L74:
        r14 = false;
        goto L75
    L70:
        r13 = false;
        goto L72
    L65:
        if (r0 != Composer.Companion.getEmpty()) goto L67;
    L61:
        r19 = false;
        goto L62
    L57:
        r17 = false;
        goto L58
    L41:
        if (r12.changedInstance(this) == false) goto L43;
        int r44 = 131072;
    L44:
        r1 = r1 | r44;
        goto L45
    L43:
        r44 = 65536;
        goto L44
    L5:
        if (r12.changed(r23) == false) goto L7;
        int r45 = 4;
    L8:
        r1 = r45 | r29;
        goto L11
    L7:
        r45 = 2;
        goto L8
    }
}
