package com.bytedance.android.live.broadcastgame.opengame.control.out_report;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.bytedance.android.live.broadcastgame.opengame.network.q;
import com.bytedance.crash.d;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class OpenGameReportDialog$addData$onClickListener$1 implements View.OnClickListener {
    public final /* synthetic */ OpenGameReportDialog a;

    public static final class a implements DialogInterface.OnDismissListener {
        public final /* synthetic */ OpenGameReportSubmitDialog a;
        public final /* synthetic */ OpenGameReportDialog$addData$onClickListener$1 b;

        public a(OpenGameReportSubmitDialog r1, OpenGameReportDialog$addData$onClickListener$1 r2) {
            this.a = r1;
            this.b = r2;
        }

        /* JADX WARN: Type inference failed for: r4v6, types: [android.app.Dialog, com.bytedance.android.live.broadcastgame.opengame.control.out_report.OpenGameReportDialog, java.lang.Object] */
        @Override // android.content.DialogInterface.OnDismissListener
        public final void onDismiss(DialogInterface r4) {
            if (this.a.a != 0) goto L21;
            ?? r5 = this.b.a;
            Handler r0 = DialogLancet.resolveDialogHandler(r5);
            if (r0 != null) goto L7;
        L9:
            DialogLancet.beforeDialogDismiss(r5);
            r5.dismiss();     // Catch: Throwable -> L12 Exception -> L14
        L18:
            DialogLancet.afterDialogDismiss(r5);
            goto L21
        L14:
            e = move-exception;
            d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L12
            Throwable r1 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L12
            if (r1 == null) goto L18;
            d.d(r1, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L12
        L12:
            th = move-exception;
            DialogLancet.afterDialogDismiss(r5);
            throw th;
        L7:
            if (Looper.myLooper() == r0.getLooper()) goto L9;
            r0.post(DialogLancet.createDismissRunnable(r5));
        L21:
            OpenGameReportDialog r6 = this.b.a;
            int r2 = OpenGameReportDialog.h;
            r6.getClass();
        }
    }

    public OpenGameReportDialog$addData$onClickListener$1(OpenGameReportDialog r1) {
        this.a = r1;
    }

    /* JADX WARN: Type inference failed for: r7v0, types: [android.app.Dialog, com.bytedance.android.live.broadcastgame.opengame.control.out_report.OpenGameReportSubmitDialog, java.lang.Object] */
    @Override // android.view.View.OnClickListener
    public final void onClick(View r9) {
        this.a.getClass();
        OpenGameReportDialog r0 = this.a;
        Context r2 = this.a.getContext();
        Object r11 = r9.getTag(2131367728);
        if (r11 == null) goto L12;
        q.a r3 = (q.a) r11;
        OpenGameReportDialog r12 = this.a;
        ?? r7 = new OpenGameReportSubmitDialog(r2, r3, r12.d, r12.e, r12.f);
        r7.setOnDismissListener(new a(r7, this));
        q.a r13 = r7.f;
        Intrinsics.checkNotNullParameter(r13, "reasonInfo");
        r7.f = r13;
        if (DialogLancet.shouldBlockDialogShow(r7) == false) goto L14;
        DialogLancet.handleBlockedDialogShow(r7);
    L9:
        Function0<Unit> r14 = new OpenGameReportDialog$addData$onClickListener$1$$special$$inlined$apply$lambda$2(this);
        Intrinsics.checkNotNullParameter(r14, "listener");
        r7.b = r14;
        Function1<Boolean, Unit> r15 = new OpenGameReportDialog$addData$onClickListener$1$$special$$inlined$apply$lambda$3(this);
        Intrinsics.checkNotNullParameter(r15, "listener");
        r7.c = r15;
        Unit r16 = Unit.INSTANCE;
        r0.getClass();
        return;
    L14:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L13
    L8:
        DialogLancet.beforeDialogShow(r7);
        r7.show();
        DialogLancet.afterDialogShow(r7);
        goto L9
    L12:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.broadcastgame.opengame.network.GetReportReasonListResponse.ReasonInfo");
    }
}
