package com.bytedance.android.live.profit.scoreboard;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Handler;
import android.os.Looper;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import io.reactivex.SingleEmitter;
import io.reactivex.SingleOnSubscribe;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class h1<T> implements SingleOnSubscribe {
    public final /* synthetic */ r0 a;
    public final /* synthetic */ String b;
    public final /* synthetic */ String c;

    public static final class a implements ttc.c {
        public final /* synthetic */ Dialog a;

        public a(com.bytedance.android.livesdk.widget.x0 r1) {
            this.a = r1;
        }

        public final void cancel() {
            Dialog r0 = this.a;
            Handler r1 = DialogLancet.resolveDialogHandler(r0);
            if (r1 != null) goto L5;
        L7:
            DialogLancet.beforeDialogDismiss(r0);
            r0.dismiss();     // Catch: Throwable -> L10 Exception -> L12
        L16:
            DialogLancet.afterDialogDismiss(r0);
            return;
        L10:
            th = move-exception;
            DialogLancet.afterDialogDismiss(r0);
            throw th;
        L12:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L10
            Throwable r2 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L10
            if (r2 == null) goto L16;
            com.bytedance.crash.d.d(r2, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L10
            goto L16
        L5:
            if (Looper.myLooper() == r1.getLooper()) goto L7;
            r1.post(DialogLancet.createDismissRunnable(r0));
        }
    }

    public static final class b implements DialogInterface.OnClickListener {
        public final /* synthetic */ SingleEmitter a;

        public b(SingleEmitter r1) {
            this.a = r1;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface r2, int r3) {
            this.a.onSuccess(Boolean.TRUE);
            r2.dismiss();
        }
    }

    public static final class c implements DialogInterface.OnClickListener {
        public final /* synthetic */ SingleEmitter a;

        public c(SingleEmitter r1) {
            this.a = r1;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface r2, int r3) {
            this.a.onSuccess(Boolean.FALSE);
            r2.dismiss();
        }
    }

    public static final class d implements DialogInterface.OnDismissListener {
        public final /* synthetic */ SingleEmitter a;

        public d(SingleEmitter r1) {
            this.a = r1;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public final void onDismiss(DialogInterface r2) {
            if (this.a.isDisposed() == true) goto L6;
            this.a.onSuccess(Boolean.FALSE);
            return;
        }
    }

    public h1(r0 r1, String r2, String r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void subscribe(SingleEmitter<Boolean> r6) {
        Intrinsics.checkNotNullParameter(r6, "emitter");
        com.bytedance.android.livesdk.widget.z0 r0 = com.bytedance.android.livesdk.widget.z0.a();
        Context r1 = this.a.b.getContext();
        r0.getClass();
        com.bytedance.android.livesdk.widget.x0.b r2 = new com.bytedance.android.livesdk.widget.x0.b(r1, 4);
        String r3 = this.b;
        com.bytedance.android.livesdk.widget.x0.d r4 = r2.a;
        r4.c = r3;
        r4.d = this.c;
        r2.i(0, 2131922333, new b(r6));
        r2.i(1, 2131922334, new c(r6));
        com.bytedance.android.livesdk.widget.x0.d r5 = r2.a;
        r5.l = false;
        r5.i = new d(r6);
        r6.setCancellable(new a(r2.n()));
    }
}
