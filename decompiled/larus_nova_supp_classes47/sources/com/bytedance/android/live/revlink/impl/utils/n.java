package com.bytedance.android.live.revlink.impl.utils;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.bytedance.android.livesdk.chatroom.ui.o5;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class n implements View.OnClickListener {
    public final /* synthetic */ o5 a;
    public final /* synthetic */ String b;

    public n(o5 r1) {
        this.a = r1;
        this.b = "pk";
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r4) {
        o5 r5 = this.a;
        Handler r0 = DialogLancet.resolveDialogHandler(r5);
        if (r0 != null) goto L5;
    L7:
        DialogLancet.beforeDialogDismiss(r5);
        r5.dismiss();     // Catch: Throwable -> L10 Exception -> L12
    L16:
        DialogLancet.afterDialogDismiss(r5);
    L17:
        HashMap r6 = new HashMap();
        r6.put("ban_type", this.b);
        r6.put("click_position", "ok");
        mz0.n r1 = new mz0.n();
        Map<String, String> r2 = r1.a;
        Intrinsics.checkNotNullParameter(r2, "map");
        Intrinsics.checkNotNullParameter(r6, "map");
        r2.putAll(r6);
        cy0.e.a.getClass();
        cy0.j r7 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r8 = com.bytedance.android.scope.m.b(r7).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r8);
        ((mz0.i) ((f80.a) r8)).w3("audience_ban_feature_disable_popup_click", r1.a, r1.b);
        return;
    L10:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r5);
        throw th;
    L12:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L10
        Throwable r3 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L10
        if (r3 == null) goto L16;
        com.bytedance.crash.d.d(r3, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L10
        goto L16
    L5:
        if (Looper.myLooper() == r0.getLooper()) goto L7;
        r0.post(DialogLancet.createDismissRunnable(r5));
        goto L17
    }
}
