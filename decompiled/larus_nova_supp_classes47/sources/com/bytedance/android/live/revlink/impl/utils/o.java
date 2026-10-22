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
public final class o implements View.OnClickListener {
    public final /* synthetic */ o5 a;
    public final /* synthetic */ String b;
    public final /* synthetic */ String c;

    public o(o5 r1, String r2) {
        this.a = r1;
        this.b = r2;
        this.c = "pk";
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r4) {
        if (this.b == null) goto L21;
        ((vy0.c) com.bytedance.android.live.revenue.core.util.f.a(vy0.c.class)).j1(this.a.getContext(), this.b);
        o5 r5 = this.a;
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
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L12
        Throwable r1 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L12
        if (r1 == null) goto L18;
        com.bytedance.crash.d.d(r1, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r5);
        throw th;
    L7:
        if (Looper.myLooper() == r0.getLooper()) goto L9;
        r0.post(DialogLancet.createDismissRunnable(r5));
    L21:
        HashMap r6 = new HashMap();
        r6.put("ban_type", this.c);
        r6.put("click_position", "appeal");
        mz0.n r2 = new mz0.n();
        Map<String, String> r3 = r2.a;
        Intrinsics.checkNotNullParameter(r3, "map");
        Intrinsics.checkNotNullParameter(r6, "map");
        r3.putAll(r6);
        cy0.e.a.getClass();
        cy0.j r7 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r8 = com.bytedance.android.scope.m.b(r7).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r8);
        ((mz0.i) ((f80.a) r8)).w3("audience_ban_feature_disable_popup_click", r2.a, r2.b);
    }
}
