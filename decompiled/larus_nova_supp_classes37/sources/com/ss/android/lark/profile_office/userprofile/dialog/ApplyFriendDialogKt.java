package com.ss.android.lark.profile_office.userprofile.dialog;

import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.ModalBottomSheetKt;
import androidx.compose.material3.SheetState;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.text.input.TextFieldValue;
import androidx.compose.ui.unit.Dp;
import com.ss.android.lark.compose.foundation.n;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import w1c.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class ApplyFriendDialogKt {
    public static final void a(final boolean r28, String r29, String r30, final Function2<? super String, ? super String, Unit> r31, final Function0<Unit> r32, Composer r33, final int r34, final int r35) {
        Intrinsics.checkNotNullParameter(r31, "onSendFriendRequest");
        Intrinsics.checkNotNullParameter(r32, "onDismiss");
        Composer r5 = r33.startRestartGroup(-1056606250);
        if ((r35 & 1) == 0) goto L6;
        int r6 = r34 | 6;
    L13:
        int r8 = r35 & 2;
        if (r8 == 0) goto L17;
        r6 = r6 | 48;
    L23:
        String r11 = r29;
    L24:
        int r12 = r35 & 4;
        if (r12 == 0) goto L28;
        r6 = r6 | 384;
    L34:
        String r14 = r30;
    L36:
        if ((r35 & 8) == 0) goto L39;
        r6 = r6 | 3072;
    L46:
        if ((r35 & 16) == 0) goto L49;
        r6 = r6 | 24576;
    L56:
        if ((r6 & 9363) != 9362) goto L62;
        if (r5.getSkipping() == false) goto L62;
        r5.skipToGroupEnd();
        Composer r0 = r5;
        String r26 = r11;
        String r27 = r14;
    L94:
        ScopeUpdateScope r9 = r0.endRestartGroup();
        if (r9 == null) goto L98;
        final String r2 = r26;
        final String r3 = r27;
        r9.updateScope(new ApplyFriendDialogKt$ApplyFriendDialog$2(r28, r2, r3, r31, r32, r34, r35));
        return;
    L98:
        return;
    L62:
        if (r8 == 0) goto L64;
        r26 = "";
    L65:
        if (r12 == 0) goto L67;
        String r10 = "";
    L69:
        if (ComposerKt.isTraceInProgress() == false) goto L71;
        ComposerKt.traceEventStart(-1056606250, r6, -1, "com.ss.android.lark.profile_office.userprofile.dialog.ApplyFriendDialog (ApplyFriendDialog.kt:51)");
    L71:
        r5.startReplaceGroup(5004770);
        if ((r6 & 112) != 32) goto L74;
        boolean r13 = true;
    L75:
        Object r15 = r5.rememberedValue();
        if (r13 == false) goto L78;
    L81:
        SnapshotMutationPolicy r16 = null;
        Object r17 = SnapshotStateKt.mutableStateOf$default(new TextFieldValue(r26, 0, null, 6, null), null, 2, null);
        r5.updateRememberedValue(r17);
    L82:
        final MutableState r18 = (MutableState) r17;
        r5.endReplaceGroup();
        r5.startReplaceGroup(5004770);
        if ((r6 & 896) != 256) goto L85;
        boolean r1 = true;
    L86:
        Object r19 = r5.rememberedValue();
        if (r1 == false) goto L89;
    L90:
        r19 = SnapshotStateKt.mutableStateOf$default(new TextFieldValue(a.b(r10, 16), 0, null, 6, null), r16, 2, r16);
        r5.updateRememberedValue(r19);
    L91:
        final MutableState r4 = (MutableState) r19;
        r5.endReplaceGroup();
        SheetState r7 = ModalBottomSheetKt.rememberModalBottomSheetState(true, r16, r5, 6, 2);
        float r110 = 16;
        float r111 = 0;
        r27 = r10;
        r0 = r5;
        ModalBottomSheetKt.ModalBottomSheet-YbuCTN8(r32, null, r7, 0.0f, false, RoundedCornerShapeKt.RoundedCornerShape-a9UjIt4(Dp.constructor-impl(r110), Dp.constructor-impl(r110), Dp.constructor-impl(r111), Dp.constructor-impl(r111)), n.a(r5, 0).c.e, 0, 0.0f, 0, ComposableSingletons$ApplyFriendDialogKt.b, null, null, ComposableLambdaKt.rememberComposableLambda(-263026248, true, new ApplyFriendDialogKt$ApplyFriendDialog$1(r18, r4, r28, r31), r5, 54), r0, (r6 >> 12) & 14, 3078, 7066);
        if (ComposerKt.isTraceInProgress() == false) goto L94;
        ComposerKt.traceEventEnd();
        goto L94
    L89:
        if (r19 != Composer.Companion.getEmpty()) goto L91;
    L85:
        r1 = false;
        goto L86
    L78:
        if (r15 == Composer.Companion.getEmpty()) goto L81;
        r17 = r15;
        r16 = null;
        goto L82
    L74:
        r13 = false;
        goto L75
    L67:
        r10 = r14;
        goto L69
    L64:
        r26 = r11;
        goto L65
    L49:
        if ((r34 & 24576) != 0) goto L56;
        if (r5.changedInstance(r32) == false) goto L53;
        int r112 = 16384;
    L54:
        r6 = r6 | r112;
        goto L56
    L53:
        r112 = 8192;
        goto L54
    L39:
        if ((r34 & 3072) != 0) goto L46;
        if (r5.changedInstance(r31) == false) goto L43;
        int r113 = 2048;
    L44:
        r6 = r6 | r113;
        goto L46
    L43:
        r113 = 1024;
        goto L44
    L28:
        if ((r34 & 384) != 0) goto L34;
        r14 = r30;
        if (r5.changed(r14) == false) goto L32;
        int r114 = 256;
    L33:
        r6 = r6 | r114;
        goto L36
    L32:
        r114 = 128;
        goto L33
    L17:
        if ((r34 & 48) != 0) goto L23;
        r11 = r29;
        if (r5.changed(r11) == false) goto L21;
        int r115 = 32;
    L22:
        r6 = r6 | r115;
        goto L24
    L21:
        r115 = 16;
        goto L22
    L6:
        if ((r34 & 6) == 0) goto L8;
        r6 = r34;
        goto L13
    L8:
        if (r5.changed(r28) == false) goto L10;
        int r20 = 4;
    L11:
        r6 = r20 | r34;
        goto L13
    L10:
        r20 = 2;
        goto L11
    }
}
