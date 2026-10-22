package com.ss.android.lark.officesdk.minutes.ui.style.provider;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Handler;
import android.os.Looper;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.lark.foundation.dialog.FlowAlertDialog;
import com.ss.android.lark.officesdk.minutes.ui.record.MmUiLogScene;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class MmDoubaoDialogProvider implements qub.c {
    public final Map<String, FlowAlertDialog> a;

    public static final class a implements DialogInterface.OnShowListener {
        public final /* synthetic */ rub.b a;

        public a(rub.b r1) {
            this.a = r1;
        }

        @Override // android.content.DialogInterface.OnShowListener
        public final void onShow(DialogInterface r1) {
            Function0<Unit> r2 = this.a.n;
            if (r2 == null) goto L6;
            r2.invoke();
            return;
        }
    }

    public static final class b implements DialogInterface.OnDismissListener {
        public final /* synthetic */ MmDoubaoDialogProvider a;
        public final /* synthetic */ rub.b b;

        public b(MmDoubaoDialogProvider r1, rub.b r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public final void onDismiss(DialogInterface r2) {
            this.a.a.remove(this.b.a);
            Function0<Unit> r3 = this.b.m;
            if (r3 == null) goto L6;
            r3.invoke();
            return;
        }
    }

    public MmDoubaoDialogProvider() {
        this.a = new LinkedHashMap();
    }

    public static void X0(FlowAlertDialog r3) {
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

    @Override // qub.c
    public final void B(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        Result.Companion r5 = Result.Companion;     // Catch: Throwable -> L9
        Iterator r6 = CollectionsKt.toList(((LinkedHashMap) this.a).values()).iterator();     // Catch: Throwable -> L9
    L5:
        if (r6.hasNext() == false) goto L7;
        X0((FlowAlertDialog) r6.next());     // Catch: Throwable -> L9
        goto L5
    L7:
        ((LinkedHashMap) this.a).clear();     // Catch: Throwable -> L9
        Object r7 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L9
    L11:
        Throwable r8 = Result.exceptionOrNull-impl(r7);
        if (r8 == null) goto L18;
        int r0 = bwb.b.a;
        bwb.b.d(MmUiLogScene.OVERLAY, "dismissAllDialogs", "dismissAllDialogs failed e=" + r8, null);
        return;
    L18:
        return;
    L9:
        th = move-exception;
        Result.Companion r1 = Result.Companion;
        r7 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L11
    }

    public final void Z1(Context r5, String r6) {
        Intrinsics.checkNotNullParameter(r5, "context");
        Intrinsics.checkNotNullParameter(r6, "id");
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L9
        FlowAlertDialog r1 = this.a.remove(r6);     // Catch: Throwable -> L9
        if (r1 == null) goto L6;
        X0(r1);     // Catch: Throwable -> L9
        Unit r2 = Unit.INSTANCE;     // Catch: Throwable -> L9
    L7:
        Object r3 = Result.constructor-impl(r2);     // Catch: Throwable -> L9
    L11:
        Throwable r4 = Result.exceptionOrNull-impl(r3);
        if (r4 == null) goto L17;
        int r7 = bwb.b.a;
        bwb.b.d(MmUiLogScene.OVERLAY, "dismissDialog", "dismissDialog failed id=" + r6 + " e=" + r4, null);
        return;
    L17:
        return;
    L6:
        r2 = null;
    L9:
        th = move-exception;
        Result.Companion r8 = Result.Companion;
        r3 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L11
    }

    @Override // qub.c
    public final void u0(Context r7, final rub.b r8) {
        Intrinsics.checkNotNullParameter(r7, "context");
        Intrinsics.checkNotNullParameter(r8, "config");
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L39
        Z1(r7, r8.a);     // Catch: Throwable -> L39
        boolean r1 = false;
        FlowAlertDialog r2 = new FlowAlertDialog(r7, 0);     // Catch: Throwable -> L39
        String r9 = r8.b;     // Catch: Throwable -> L39
        if (r9 == null) goto L7;
        Intrinsics.checkNotNullParameter(r9, "text");     // Catch: Throwable -> L39
        r2.a = r9;     // Catch: Throwable -> L39
    L7:
        String r10 = r8.c;     // Catch: Throwable -> L39
        if (r10 == null) goto L10;
        Intrinsics.checkNotNullParameter(r10, "text");     // Catch: Throwable -> L39
        r2.b = r10;     // Catch: Throwable -> L39
    L10:
        r2.setCancelable(r8.i);     // Catch: Throwable -> L39
        r2.setCanceledOnTouchOutside(r8.j);     // Catch: Throwable -> L39
        String r11 = r8.d;     // Catch: Throwable -> L39
        String r3 = r8.e;     // Catch: Throwable -> L39
        if (r11 != null) goto L13;
    L16:
        boolean r5 = true;
    L17:
        if (r5 == true) goto L19;
        Function1<FlowAlertDialog, Unit> r6 = new MmDoubaoDialogProvider$showDialog$1$1$3(r8);     // Catch: Throwable -> L39
        Intrinsics.checkNotNullParameter(r11, "text");     // Catch: Throwable -> L39
        r2.c = r11;     // Catch: Throwable -> L39
        r2.g = r6;     // Catch: Throwable -> L39
    L19:
        if (r3 != null) goto L21;
    L22:
        r1 = true;
    L23:
        if (r1 == true) goto L25;
        Function1<FlowAlertDialog, Unit> r12 = new MmDoubaoDialogProvider$showDialog$1$1$4(r8);     // Catch: Throwable -> L39
        Intrinsics.checkNotNullParameter(r3, "text");     // Catch: Throwable -> L39
        r2.d = r3;     // Catch: Throwable -> L39
        r2.h = r12;     // Catch: Throwable -> L39
    L25:
        Integer r13 = r8.f;     // Catch: Throwable -> L39
        if (r13 == null) goto L28;
        r2.e = Integer.valueOf(r13.intValue());     // Catch: Throwable -> L39
    L28:
        Integer r14 = r8.g;     // Catch: Throwable -> L39
        if (r14 == null) goto L31;
        r2.f = Integer.valueOf(r14.intValue());     // Catch: Throwable -> L39
    L31:
        r2.setOnShowListener(new a(r8));     // Catch: Throwable -> L39
        r2.setOnDismissListener(new b(this, r8));     // Catch: Throwable -> L39
        if (DialogLancet.shouldBlockDialogShow(r2) == false) goto L46;
        DialogLancet.handleBlockedDialogShow(r2);     // Catch: Throwable -> L39
    L37:
        this.a.put(r8.a, r2);     // Catch: Throwable -> L39
        Object r15 = Result.constructor-impl(r2);     // Catch: Throwable -> L39
    L41:
        Throwable r16 = Result.exceptionOrNull-impl(r15);
        if (r16 == null) goto L50;
        int r17 = bwb.b.a;
        bwb.b.d(MmUiLogScene.OVERLAY, "showDialog", "showDialog failed e=" + r16, null);
        return;
    L50:
        return;
    L46:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L45 Throwable -> L39
    L36:
        DialogLancet.beforeDialogShow(r2);     // Catch: Throwable -> L39
        r2.show();     // Catch: Throwable -> L39
        DialogLancet.afterDialogShow(r2);     // Catch: Throwable -> L39
        goto L37
    L21:
        if (r3.length() != 0) goto L23;
    L13:
        if (r11.length() == 0) goto L16;
        r5 = false;
    L39:
        th = move-exception;
        Result.Companion r18 = Result.Companion;
        r15 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L41
    }
}
