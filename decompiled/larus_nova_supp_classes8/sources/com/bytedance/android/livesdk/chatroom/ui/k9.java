package com.bytedance.android.livesdk.chatroom.ui;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.Window;
import android.widget.RelativeLayout;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class k9 extends com.bytedance.android.livesdk.common.b {
    public Disposable b;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ k9 a;

        public a(k9 r1) {
            this.a = r1;
        }

        public final void accept(Object r1) {
            String r2 = (String) r1;
            k9.a(this.a);
        }
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ k9 a;

        public b(k9 r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r1) {
            Disposable r2 = this.a.b;
            if (r2 == null) goto L5;
            r2.dispose();
        L5:
            k9.a(this.a);
        }
    }

    @Override // com.bytedance.android.livesdk.common.b, android.app.Dialog
    public final void onStart() {
        super.onStart();
        if (getWindow() == null) goto L8;
        Window r0 = getWindow();
        if (r0 == null) goto L9;
        r0.setLayout(-1, -1);
        return;
    L9:
        return;
    }

    public k9(Context r2) {
        super(r2, true);
    }

    public static final void a(k9 r4) {
        if (r4.isShowing() == false) goto L37;
        Context r0 = r4.getContext();
        Context r2 = null;
        if ((r0 instanceof Activity) == true) goto L7;
        r0 = null;
    L7:
        Activity r1 = (Activity) r0;
        if (r1 != null) goto L10;
    L11:
        Context r3 = r4.getContext();
        if ((r3 instanceof Activity) == false) goto L15;
        r2 = r3;
    L15:
        Activity r5 = (Activity) r2;
        if (r5 != null) goto L18;
    L20:
        Handler r6 = DialogLancet.resolveDialogHandler(r4);
        if (r6 != null) goto L23;
    L25:
        DialogLancet.beforeDialogDismiss(r4);
        r4.dismiss();     // Catch: Throwable -> L28 Exception -> L30
    L34:
        DialogLancet.afterDialogDismiss(r4);
        return;
    L30:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L28
        Throwable r7 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L28
        if (r7 == null) goto L34;
        com.bytedance.crash.d.d(r7, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L28
    L28:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r4);
        throw th;
    L23:
        if (Looper.myLooper() == r6.getLooper()) goto L25;
        r6.post(DialogLancet.createDismissRunnable(r4));
        return;
    L18:
        if (r5.isDestroyed() != true) goto L20;
        return;
    L10:
        if (r1.isFinishing() != true) goto L11;
        return;
    }

    @Override // android.app.Dialog
    public final void onCreate(Bundle r4) {
        super.onCreate(r4);
        setContentView(2131566783);
        setCancelable(true);
        this.b = Observable.just("").delay(5000, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new a(this));
        RelativeLayout r5 = (RelativeLayout) findViewById(2131387246);
        if (r5 == null) goto L6;
        r5.setOnClickListener(new b(this));
        return;
    }
}
