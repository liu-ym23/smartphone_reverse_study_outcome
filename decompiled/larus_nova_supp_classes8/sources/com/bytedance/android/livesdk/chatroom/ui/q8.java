package com.bytedance.android.livesdk.chatroom.ui;

import android.os.Handler;
import android.os.Looper;
import com.bytedance.android.live.core.utils.ExceptionUtils;
import com.bytedance.android.livesdkapi.depend.model.follow.FollowPair;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class q8 implements Observer<FollowPair> {
    public final /* synthetic */ r8 a;

    public final void onComplete() {
    }

    public final void onSubscribe(Disposable r1) {
    }

    public q8(r8 r1) {
        this.a = r1;
    }

    public final void onError(Throwable r3) {
        r8 r0 = this.a;
        if (r0.f == true) goto L5;
        return;
    L5:
        r0.e = false;
        ExceptionUtils.handleException(r0.getContext(), r3);
    }

    public final void onNext(Object r4) {
        FollowPair r5 = (FollowPair) r4;
        r8 r6 = this.a;
        if (r6.f == false) goto L27;
        r6.e = false;
        r6.b.setText(2131917325);
        r8 r7 = this.a;
        Handler r0 = DialogLancet.resolveDialogHandler(r7);
        if (r0 != null) goto L8;
    L10:
        DialogLancet.beforeDialogDismiss(r7);
        r7.dismiss();     // Catch: Throwable -> L13 Exception -> L15
    L19:
        DialogLancet.afterDialogDismiss(r7);
        return;
    L13:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r7);
        throw th;
    L15:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L13
        Throwable r1 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L13
        if (r1 == null) goto L19;
        com.bytedance.crash.d.d(r1, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L13
        goto L19
    L8:
        if (Looper.myLooper() == r0.getLooper()) goto L10;
        r0.post(DialogLancet.createDismissRunnable(r7));
        return;
    }
}
