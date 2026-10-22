package com.ss.android.lark.profile_office.userprofile.dialog;

import android.content.Context;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.ModalBottomSheetKt;
import androidx.compose.material3.SheetState;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.focus.FocusRequester;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.text.TextRangeKt;
import androidx.compose.ui.text.input.TextFieldValue;
import androidx.compose.ui.unit.Dp;
import com.ss.android.lark.compose.foundation.n;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import w1c.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class EditAliasDialogKt {
    public static final void a(final String r30, final boolean r31, final Function1<? super String, Unit> r32, final Function0<Unit> r33, Composer r34, final int r35) {
        Intrinsics.checkNotNullParameter(r30, "initialAlias");
        Intrinsics.checkNotNullParameter(r32, "onSaveAlias");
        Intrinsics.checkNotNullParameter(r33, "onDismiss");
        Composer r9 = r34.startRestartGroup(408192430);
        if ((r35 & 6) == 0) goto L5;
        int r3 = r35;
    L11:
        if ((r35 & 48) != 0) goto L18;
        if (r9.changed(r31) == false) goto L15;
        int r6 = 32;
    L16:
        r3 = r3 | r6;
        goto L18
    L15:
        r6 = 16;
    L18:
        if ((r35 & 384) != 0) goto L25;
        if (r9.changedInstance(r32) == false) goto L22;
        int r7 = 256;
    L23:
        r3 = r3 | r7;
        goto L25
    L22:
        r7 = 128;
    L25:
        if ((r35 & 3072) == 0) goto L27;
    L31:
        int r10 = r3;
        if ((r10 & 1171) != 1170) goto L38;
        if (r9.getSkipping() == false) goto L38;
        r9.skipToGroupEnd();
        Composer r0 = r9;
    L60:
        ScopeUpdateScope r8 = r0.endRestartGroup();
        if (r8 == null) goto L64;
        r8.updateScope(new EditAliasDialogKt$EditAliasDialog$3(r30, r31, r32, r33, r35));
        return;
    L64:
        return;
    L38:
        if (ComposerKt.isTraceInProgress() == false) goto L40;
        ComposerKt.traceEventStart(408192430, r10, -1, "com.ss.android.lark.profile_office.userprofile.dialog.EditAliasDialog (EditAliasDialog.kt:60)");
    L40:
        final Context r11 = (Context) r9.consume(AndroidCompositionLocals_androidKt.getLocalContext());
        r9.startReplaceGroup(5004770);
        if ((r10 & 14) != 4) goto L43;
        boolean r2 = true;
    L44:
        Object r4 = r9.rememberedValue();
        if (r2 == false) goto L47;
    L48:
        String r17 = a.b(r30, 16);
        r4 = SnapshotStateKt.mutableStateOf$default(new TextFieldValue(r17, TextRangeKt.TextRange(r17.length()), null, 4, null), null, 2, null);
        r9.updateRememberedValue(r4);
    L49:
        final MutableState r5 = (MutableState) r4;
        r9.endReplaceGroup();
        r9.startReplaceGroup(1849434622);
        Object r12 = r9.rememberedValue();
        Composer.Companion r14 = Composer.Companion;
        if (r12 != r14.getEmpty()) goto L52;
        r12 = new FocusRequester();
        r9.updateRememberedValue(r12);
    L52:
        final FocusRequester r13 = (FocusRequester) r12;
        r9.endReplaceGroup();
        SheetState r15 = ModalBottomSheetKt.rememberModalBottomSheetState(true, null, r9, 6, 2);
        r9.startReplaceGroup(-1633490746);
        boolean r16 = r9.changed(r15);
        Object r18 = r9.rememberedValue();
        if (r16 == false) goto L55;
    L56:
        r18 = new EditAliasDialogKt$EditAliasDialog$1$1(r13, r15, null);
        r9.updateRememberedValue(r18);
    L57:
        r9.endReplaceGroup();
        EffectsKt.LaunchedEffect(r15, (Function2) r18, r9, 0);
        float r19 = 16;
        float r110 = 0;
        int r27 = (r10 >> 9) & 14;
        r0 = r9;
        ModalBottomSheetKt.ModalBottomSheet-YbuCTN8(r33, null, r15, 0.0f, false, RoundedCornerShapeKt.RoundedCornerShape-a9UjIt4(Dp.constructor-impl(r19), Dp.constructor-impl(r19), Dp.constructor-impl(r110), Dp.constructor-impl(r110)), n.a(r9, 0).c.e, 0, 0.0f, 0, ComposableSingletons$EditAliasDialogKt.b, null, null, ComposableLambdaKt.rememberComposableLambda(1883229452, true, new EditAliasDialogKt$EditAliasDialog$2(r5, r13, r11, r31, r32), r9, 54), r0, r27, 3078, 7066);
        if (ComposerKt.isTraceInProgress() == false) goto L60;
        ComposerKt.traceEventEnd();
        goto L60
    L55:
        if (r18 != r14.getEmpty()) goto L57;
    L47:
        if (r4 != Composer.Companion.getEmpty()) goto L49;
    L43:
        r2 = false;
        goto L44
    L27:
        if (r9.changedInstance(r33) == false) goto L29;
        int r20 = 2048;
    L30:
        r3 = r3 | r20;
        goto L31
    L29:
        r20 = 1024;
        goto L30
    L5:
        if (r9.changed(r30) == false) goto L7;
        int r21 = 4;
    L8:
        r3 = r21 | r35;
        goto L11
    L7:
        r21 = 2;
        goto L8
    }
}
