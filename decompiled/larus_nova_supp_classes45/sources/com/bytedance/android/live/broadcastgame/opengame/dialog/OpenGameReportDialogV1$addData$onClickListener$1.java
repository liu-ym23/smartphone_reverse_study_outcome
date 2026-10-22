package com.bytedance.android.live.broadcastgame.opengame.dialog;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.bytedance.android.live.broadcastgame.api.openplatform.PluginType;
import com.bytedance.android.live.broadcastgame.opengame.network.q;
import com.bytedance.crash.d;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class OpenGameReportDialogV1$addData$onClickListener$1 implements View.OnClickListener {
    public final /* synthetic */ OpenGameReportDialogV1 a;

    public static final class a implements DialogInterface.OnDismissListener {
        public final /* synthetic */ OpenGameReportSubmitDialog a;
        public final /* synthetic */ OpenGameReportDialogV1$addData$onClickListener$1 b;

        public a(OpenGameReportSubmitDialog r1, OpenGameReportDialogV1$addData$onClickListener$1 r2) {
            this.a = r1;
            this.b = r2;
        }

        /* JADX WARN: Type inference failed for: r4v1, types: [android.app.Dialog, com.bytedance.android.live.broadcastgame.opengame.dialog.OpenGameReportSubmitDialog, java.lang.Object] */
        @Override // android.content.DialogInterface.OnDismissListener
        public final void onDismiss(DialogInterface r4) {
            ?? r5 = this.a;
            if (r5.a != 0) goto L21;
            Handler r0 = DialogLancet.resolveDialogHandler(r5);
            if (r0 != null) goto L7;
        L9:
            DialogLancet.beforeDialogDismiss(r5);
            r5.dismiss();     // Catch: Throwable -> L12 Exception -> L14
        L18:
            DialogLancet.afterDialogDismiss(r5);
            goto L21
        L12:
            th = move-exception;
            DialogLancet.afterDialogDismiss(r5);
            throw th;
        L14:
            e = move-exception;
            d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L12
            Throwable r1 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L12
            if (r1 == null) goto L18;
            d.d(r1, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L12
            goto L18
        L7:
            if (Looper.myLooper() == r0.getLooper()) goto L9;
            r0.post(DialogLancet.createDismissRunnable(r5));
        L21:
            this.b.a.d = null;
        }
    }

    public OpenGameReportDialogV1$addData$onClickListener$1(OpenGameReportDialogV1 r1) {
        this.a = r1;
    }

    /* JADX WARN: Type inference failed for: r15v0, types: [android.app.Dialog, com.bytedance.android.live.broadcastgame.opengame.dialog.OpenGameReportSubmitDialog, java.lang.Object] */
    @Override // android.view.View.OnClickListener
    public final void onClick(View r17) {
        OpenGameReportDialogV1 r1 = this.a;
        r1.a = 1;
        Context r4 = this.a.getContext();
        Object r3 = r17.getTag(2131367728);
        if (r3 == null) goto L16;
        q.a r5 = (q.a) r3;
        String r6 = (String) this.a.g.getValue();
        long r7 = ((Number) this.a.f.getValue()).longValue();
        String r9 = (String) this.a.h.getValue();
        OpenGameReportDialogV1 r8 = this.a;
        boolean r11 = r8.k;
        if (((Number) r8.i.getValue()).intValue() != PluginType.MINI_APP.getValue()) goto L7;
        boolean r12 = false;
    L8:
        ?? r15 = new OpenGameReportSubmitDialog(r4, r5, r6, r7, r9, r11, r12, ((Number) this.a.i.getValue()).intValue(), null, this.a.l);
        r15.setOnDismissListener(new a(r15, this));
        q.a r2 = r15.e;
        Intrinsics.checkNotNullParameter(r2, "reasonInfo");
        r15.e = r2;
        if (DialogLancet.shouldBlockDialogShow(r15) == false) goto L18;
        DialogLancet.handleBlockedDialogShow(r15);
    L13:
        Function0<Unit> r13 = new OpenGameReportDialogV1$addData$onClickListener$1$$special$$inlined$apply$lambda$2(this);
        Intrinsics.checkNotNullParameter(r13, "lisenter");
        r15.b = r13;
        Unit r14 = Unit.INSTANCE;
        r1.d = r15;
        this.a.cancel();
        return;
    L18:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L17
    L12:
        DialogLancet.beforeDialogShow(r15);
        r15.show();
        DialogLancet.afterDialogShow(r15);
        goto L13
    L7:
        r12 = true;
        goto L8
    L16:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.broadcastgame.opengame.network.GetReportReasonListResponse.ReasonInfo");
    }
}
