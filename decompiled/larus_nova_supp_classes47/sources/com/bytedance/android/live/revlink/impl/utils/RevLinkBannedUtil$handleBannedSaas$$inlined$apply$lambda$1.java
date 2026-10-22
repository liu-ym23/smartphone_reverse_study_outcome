package com.bytedance.android.live.revlink.impl.utils;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.livesdk.chatroom.ui.o5;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class RevLinkBannedUtil$handleBannedSaas$$inlined$apply$lambda$1 implements View.OnClickListener {
    public final /* synthetic */ o5 a;
    public final /* synthetic */ Context b;
    public final /* synthetic */ ExtraResponse c;
    public final /* synthetic */ String d;

    public RevLinkBannedUtil$handleBannedSaas$$inlined$apply$lambda$1(o5 r1, Context r2, ExtraResponse r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = "pk";
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r4) {
        String r5 = ((bf2.a) this.c.data).getDetailUrl();
        if (r5 == null) goto L21;
        ((vy0.c) com.bytedance.android.live.revenue.core.util.f.a(vy0.c.class)).x6(this.b, r5, new AnonymousClass1(this));
        o5 r6 = this.a;
        Handler r0 = DialogLancet.resolveDialogHandler(r6);
        if (r0 != null) goto L7;
    L9:
        DialogLancet.beforeDialogDismiss(r6);
        r6.dismiss();     // Catch: Throwable -> L12 Exception -> L14
    L18:
        DialogLancet.afterDialogDismiss(r6);
        goto L21
    L14:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L12
        Throwable r1 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L12
        if (r1 == null) goto L18;
        com.bytedance.crash.d.d(r1, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r6);
        throw th;
    L7:
        if (Looper.myLooper() == r0.getLooper()) goto L9;
        r0.post(DialogLancet.createDismissRunnable(r6));
    L21:
        HashMap r7 = new HashMap();
        r7.put("ban_type", this.d);
        r7.put("click_position", "ban_detail");
        mz0.n r2 = new mz0.n();
        Map<String, String> r3 = r2.a;
        Intrinsics.checkNotNullParameter(r3, "map");
        Intrinsics.checkNotNullParameter(r7, "map");
        r3.putAll(r7);
        cy0.e.a.getClass();
        cy0.j r8 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r9 = com.bytedance.android.scope.m.b(r8).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r9);
        ((mz0.i) ((f80.a) r9)).w3("audience_ban_feature_disable_popup_click", r2.a, r2.b);
    }
}
