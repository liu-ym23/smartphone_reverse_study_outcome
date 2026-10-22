package com.ss.android.lark.compose.util;

import androidx.compose.foundation.ClickableKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.ui.Modifier;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class e {
    public static final Modifier a(Modifier r17, final Function0 r18, Composer r19, int r20) {
        Intrinsics.checkNotNullParameter(r17, "$this$clickWithDebounce");
        Intrinsics.checkNotNullParameter(r18, "onClick");
        r19.startReplaceGroup(-1238623111);
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(-1238623111, r20, -1, "com.ss.android.lark.compose.util.clickWithDebounce (ModifierExtensions.kt:31)");
    L5:
        r19.startReplaceGroup(1849434622);
        Object r3 = r19.rememberedValue();
        Composer.Companion r8 = Composer.Companion;
        if (r3 != r8.getEmpty()) goto L8;
        r3 = SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        r19.updateRememberedValue(r3);
    L8:
        final MutableState r4 = (MutableState) r3;
        r19.endReplaceGroup();
        r19.startReplaceGroup(-1746271574);
        final long r13 = 500;
        if (((r20 & 112) ^ 48) <= 32) goto L13;
        if (r19.changed(500) == false) goto L13;
    L14:
        boolean r10 = true;
    L17:
        if (((458752 & r20) ^ 196608) <= 131072) goto L21;
        if (r19.changed(r18) == false) goto L21;
    L22:
        boolean r11 = true;
    L24:
        boolean r2 = r10 | r11;
        Object r12 = r19.rememberedValue();
        if (r2 == false) goto L27;
    L28:
        r12 = new ModifierExtensionsKt$clickWithDebounce$1$1(r13, r18, r4);
        r19.updateRememberedValue(r12);
    L29:
        r19.endReplaceGroup();
        Modifier r0 = ClickableKt.clickable-oSLSa3U$default(r17, true, null, null, null, (Function0) r12, 8, null);
        if (ComposerKt.isTraceInProgress() == false) goto L32;
        ComposerKt.traceEventEnd();
    L32:
        r19.endReplaceGroup();
        return r0;
    L27:
        if (r12 != r8.getEmpty()) goto L29;
    L21:
        if ((r20 & 196608) == 131072) goto L22;
        r11 = false;
    L13:
        if ((r20 & 48) == 32) goto L14;
        r10 = false;
        goto L17
    }
}
