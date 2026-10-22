package com.ss.android.lark.compose.chatsetting.main.ui.sections.memberpreview;

import androidx.compose.foundation.layout.BoxWithConstraintsKt;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.unit.Dp;
import com.lark.kmp.pb.basic.v1.Chatter;
import com.lark.kmp.rustclient.api.d;
import com.ss.android.lark.chameleon.container.webcontainer.util.ChameleonContainerUtils;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class MemberPreviewGridKt {
    public static final void a(Modifier r20, final List<Chatter> r21, final boolean r22, final boolean r23, final d r24, final Function1<? super Chatter, Unit> r25, final Function0<Unit> r26, final Function0<Unit> r27, Composer r28, final int r29, final int r30) {
        Intrinsics.checkNotNullParameter(r21, "members");
        Intrinsics.checkNotNullParameter(r24, "rustClient");
        Intrinsics.checkNotNullParameter(r25, "onChatterClick");
        Intrinsics.checkNotNullParameter(r26, "onAddClick");
        Intrinsics.checkNotNullParameter(r27, "onRemoveClick");
        Composer r15 = r28.startRestartGroup(360649159);
        int r1 = r30 & 1;
        if (r1 == 0) goto L6;
        int r4 = r29 | 6;
        Modifier r3 = r20;
    L14:
        if ((r30 & 2) == 0) goto L17;
        r4 = r4 | 48;
    L24:
        if ((r30 & 4) == 0) goto L27;
        r4 = r4 | 384;
    L34:
        if ((r30 & 8) == 0) goto L37;
        r4 = r4 | 3072;
    L45:
        if ((r30 & 16) == 0) goto L48;
        r4 = r4 | 24576;
    L55:
        if ((r30 & 32) == 0) goto L58;
        r4 = r4 | 196608;
    L65:
        if ((r30 & 64) == 0) goto L68;
        r4 = r4 | 1572864;
    L75:
        if ((r30 & 128) == 0) goto L78;
        r4 = r4 | 12582912;
    L85:
        if ((4793491 & r4) == 4793490) goto L87;
    L90:
        if (r1 == 0) goto L92;
        Modifier r6 = Modifier.Companion;
    L94:
        if (ComposerKt.isTraceInProgress() == false) goto L96;
        ComposerKt.traceEventStart(360649159, r4, -1, "com.ss.android.lark.compose.chatsetting.main.ui.sections.memberpreview.MemberPreviewGrid (MemberPreviewGrid.kt:36)");
    L96:
        Modifier r19 = r6;
        BoxWithConstraintsKt.BoxWithConstraints(PaddingKt.padding-VpY3zN4$default(r6, Dp.constructor-impl(16), 0.0f, 2, null), null, false, ComposableLambdaKt.rememberComposableLambda(1627277981, true, new MemberPreviewGridKt$MemberPreviewGrid$1(r22, r23, r21, r24, r25, r26, r27), r15, 54), r15, 3072, 6);
        if (ComposerKt.isTraceInProgress() == false) goto L99;
        ComposerKt.traceEventEnd();
    L99:
        final Modifier r2 = r19;
    L100:
        ScopeUpdateScope r16 = r15.endRestartGroup();
        if (r16 == null) goto L104;
        r16.updateScope(new MemberPreviewGridKt$MemberPreviewGrid$2(r2, r21, r22, r23, r24, r25, r26, r27, r29, r30));
        return;
    L104:
        return;
    L92:
        r6 = r3;
        goto L94
    L87:
        if (r15.getSkipping() == false) goto L90;
        r15.skipToGroupEnd();
        r2 = r3;
        goto L100
    L78:
        if ((r29 & 12582912) != 0) goto L85;
        if (r15.changedInstance(r27) == false) goto L82;
        int r5 = 8388608;
    L83:
        r4 = r4 | r5;
        goto L85
    L82:
        r5 = 4194304;
        goto L83
    L68:
        if ((r29 & 1572864) != 0) goto L75;
        if (r15.changedInstance(r26) == false) goto L72;
        int r7 = 1048576;
    L73:
        r4 = r4 | r7;
        goto L75
    L72:
        r7 = 524288;
        goto L73
    L58:
        if ((r29 & 196608) != 0) goto L65;
        if (r15.changedInstance(r25) == false) goto L62;
        int r8 = 131072;
    L63:
        r4 = r4 | r8;
        goto L65
    L62:
        r8 = 65536;
        goto L63
    L48:
        if ((r29 & 24576) != 0) goto L55;
        if (r15.changedInstance(r24) == false) goto L52;
        int r9 = 16384;
    L53:
        r4 = r4 | r9;
        goto L55
    L52:
        r9 = 8192;
        goto L53
    L37:
        if ((r29 & 3072) != 0) goto L45;
        if (r15.changed(r23) == false) goto L41;
        int r17 = 2048;
    L42:
        r4 = r4 | r17;
        goto L45
    L41:
        r17 = ChameleonContainerUtils.MAX_URL_LENGTH;
        goto L42
    L27:
        if ((r29 & 384) != 0) goto L34;
        if (r15.changed(r22) == false) goto L31;
        int r10 = 256;
    L32:
        r4 = r4 | r10;
        goto L34
    L31:
        r10 = 128;
        goto L32
    L17:
        if ((r29 & 48) != 0) goto L24;
        if (r15.changedInstance(r21) == false) goto L21;
        int r11 = 32;
    L22:
        r4 = r4 | r11;
        goto L24
    L21:
        r11 = 16;
        goto L22
    L6:
        if ((r29 & 6) != 0) goto L12;
        r3 = r20;
        if (r15.changed(r3) == false) goto L10;
        int r12 = 4;
    L11:
        r4 = r12 | r29;
        goto L14
    L10:
        r12 = 2;
        goto L11
    L12:
        r3 = r20;
        r4 = r29;
        goto L14
    }
}
