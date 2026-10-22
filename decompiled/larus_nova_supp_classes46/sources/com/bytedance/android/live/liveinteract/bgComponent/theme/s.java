package com.bytedance.android.live.liveinteract.bgComponent.theme;

import android.os.Handler;
import android.os.Looper;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.live.base.exception.ApiServerException;
import com.bytedance.android.livesdkapi.depend.model.live.audio.ThemeUpLoadListener;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import io.reactivex.functions.Consumer;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class s<T> implements Consumer {
    public final /* synthetic */ j a;
    public final /* synthetic */ FragmentActivity b;

    public s(j r1, FragmentActivity r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r4) {
        ApiServerException r5 = (Throwable) r4;
        if ((r5 instanceof ApiServerException) == false) goto L10;
        String r0 = rm3.c.a;
        FragmentActivity r1 = this.b;
        String r6 = r5.getPrompt();
        if (r6 != null) goto L7;
        r6 = "";
    L7:
        Intrinsics.checkNotNullParameter(r6, "msg");
        if (r1 == null) goto L11;
        rm3.c.a(r1, r6, r1.getResources().getDrawable(2131253121), 0, false);
    L11:
        km3.g r7 = this.a.d;
        if (r7 != null) goto L14;
    L35:
        WeakReference<ThemeUpLoadListener> r8 = this.a.g;
        if (r8 == null) goto L44;
        ThemeUpLoadListener r9 = r8.get();
        if (r9 == null) goto L45;
        r9.onUploadFailed();
        return;
    L45:
        return;
    L44:
        return;
    L14:
        if (r7.isShowing() != true) goto L35;
        km3.g r10 = this.a.d;
        if (r10 == null) goto L34;
        Handler r2 = DialogLancet.resolveDialogHandler(r10);
        if (r2 != null) goto L20;
    L22:
        DialogLancet.beforeDialogDismiss(r10);
        r10.dismiss();     // Catch: Throwable -> L25 Exception -> L27
    L31:
        DialogLancet.afterDialogDismiss(r10);
        goto L34
    L27:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L25
        Throwable r3 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L25
        if (r3 == null) goto L31;
        com.bytedance.crash.d.d(r3, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L25
    L25:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r10);
        throw th;
    L20:
        if (Looper.myLooper() == r2.getLooper()) goto L22;
        r2.post(DialogLancet.createDismissRunnable(r10));
    L34:
        j r11 = this.a;
        km3.g r12 = r11.d;
        r11.d = null;
        goto L35
    L10:
        String r13 = rm3.c.a;
        rm3.c.d(this.b, 2131916133, 2131253121);
        goto L11
    }
}
