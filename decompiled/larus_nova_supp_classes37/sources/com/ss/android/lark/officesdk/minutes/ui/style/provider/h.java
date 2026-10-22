package com.ss.android.lark.officesdk.minutes.ui.style.provider;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import androidx.appcompat.app.AlertDialog;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.lark.officesdk.minutes.ui.record.MmUiLogScene;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class h implements qub.d {
    public final Map<String, AlertDialog> a;

    public h() {
        this.a = new LinkedHashMap();
    }

    public static void X0(AlertDialog r3) {
        Handler r0 = DialogLancet.resolveDialogHandler(r3);
        if (r0 != null) goto L5;
    L8:
        DialogLancet.beforeDialogDismiss(r3);
        r3.dismiss();     // Catch: Throwable -> L11 Exception -> L13
    L10:
        DialogLancet.afterDialogDismiss(r3);
        return;
    L11:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r3);
        throw th;
    L13:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L11
        Throwable r1 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L11
        if (r1 == null) goto L10;
        com.bytedance.crash.d.d(r1, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L11
        goto L10
    L5:
        if (Looper.myLooper() == r0.getLooper()) goto L8;
        r0.post(DialogLancet.createDismissRunnable(r3));
    }

    @Override // qub.d
    public final void t0(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        Result.Companion r5 = Result.Companion;     // Catch: Throwable -> L9
        Iterator r6 = CollectionsKt.toList(((LinkedHashMap) this.a).values()).iterator();     // Catch: Throwable -> L9
    L5:
        if (r6.hasNext() == false) goto L7;
        X0((AlertDialog) r6.next());     // Catch: Throwable -> L9
        goto L5
    L7:
        ((LinkedHashMap) this.a).clear();     // Catch: Throwable -> L9
        Object r7 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L9
    L11:
        Throwable r8 = Result.exceptionOrNull-impl(r7);
        if (r8 == null) goto L18;
        int r0 = bwb.b.a;
        bwb.b.d(MmUiLogScene.OVERLAY, "hideAllLoadings", "hideAllLoadings failed e=" + r8, null);
        return;
    L18:
        return;
    L9:
        th = move-exception;
        Result.Companion r1 = Result.Companion;
        r7 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L11
    }
}
