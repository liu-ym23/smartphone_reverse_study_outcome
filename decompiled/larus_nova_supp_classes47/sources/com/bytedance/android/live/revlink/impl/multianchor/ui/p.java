package com.bytedance.android.live.revlink.impl.multianchor.ui;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.bytedance.android.live.base.exception.ApiServerException;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.revenue.common.ToastUtil;
import com.bytedance.android.live.uikit.util.IESUIUtils;
import com.bytedance.android.livesdk.widget.x0;
import com.bytedance.android.livesdk.widget.z0;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import io.reactivex.disposables.CompositeDisposable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class p {
    public x0 a;
    public final CompositeDisposable b;
    public boolean c;
    public final Context d;

    public p(Context r1) {
        this.d = r1;
        this.b = new CompositeDisposable();
    }

    public static final void a(p r1, Throwable r2) {
        r1.getClass();
        if ((r2 instanceof ApiServerException) == false) goto L5;
        IESUIUtils.displayToast(r1.d, ((ApiServerException) r2).getPrompt());
        return;
    L5:
        ToastUtil.a(2131919727, 0);
    }

    public final void b(final String r5, boolean r6) {
        Intrinsics.checkNotNullParameter("connection_manage_setting", "source");
        if (r6 == true) goto L32;
        x0 r7 = this.a;
        if (r7 == null) goto L28;
        if (r7.isShowing() != true) goto L28;
        x0 r8 = this.a;
        if (r8 == null) goto L28;
        Handler r1 = DialogLancet.resolveDialogHandler(r8);
        if (r1 != null) goto L13;
    L15:
        DialogLancet.beforeDialogDismiss(r8);
        r8.dismiss();     // Catch: Throwable -> L18 Exception -> L20
    L24:
        DialogLancet.afterDialogDismiss(r8);
        goto L28
    L20:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L18
        Throwable r2 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L18
        if (r2 == null) goto L24;
        com.bytedance.crash.d.d(r2, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r8);
        throw th;
    L13:
        if (Looper.myLooper() == r1.getLooper()) goto L15;
        r1.post(DialogLancet.createDismissRunnable(r8));
    L28:
        if (this.d != null) goto L30;
        return;
    L30:
        z0 r9 = z0.a();
        Context r3 = this.d;
        r9.getClass();
        x0.b r10 = z0.b(r3);
        r10.l(2131922205);
        r10.i(0, 2131920806, new l(this, r5));
        r10.i(1, 2131915442, m.a);
        this.a = r10.n();
        return;
    L32:
        if (this.c == true) goto L40;
        this.c = true;
        RxUtilKt.c(vh6.c.b(com.bytedance.android.livesdk.revenue.service.user.a.class).om(null, null, new ds2.c(new MultiFollowHelper$follow$1(r5))).subscribe(new j(this, r5), new k(this)), this.b);
        return;
    }
}
