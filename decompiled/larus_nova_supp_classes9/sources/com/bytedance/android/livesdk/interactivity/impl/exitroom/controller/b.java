package com.bytedance.android.livesdk.interactivity.impl.exitroom.controller;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.bytedance.android.live.base.model.user.IUser;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.eventbus.LogEvent;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.crash.d;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import java.util.HashMap;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class b implements View.OnClickListener {
    public final /* synthetic */ Function0 a;
    public final /* synthetic */ mp2.a b;
    public final /* synthetic */ Room c;

    public b(Function0 r1, mp2.a r2, Room r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r4) {
        xs2.b.a().post(new LogEvent("toast"));
        new Bundle().putString("pull_type", "toast");
        this.a.invoke();
        mp2.a r5 = this.b;
        Handler r0 = DialogLancet.resolveDialogHandler(r5);
        if (r0 != null) goto L5;
    L7:
        DialogLancet.beforeDialogDismiss(r5);
        r5.dismiss();     // Catch: Throwable -> L10 Exception -> L12
    L16:
        DialogLancet.afterDialogDismiss(r5);
    L17:
        Room r6 = this.c;
        if (r6 == null) goto L20;
        IUser r7 = r6.author();
    L21:
        if (r7 == null) goto L34;
        HashMap r8 = new HashMap();
        r8.put("room_id", String.valueOf(this.c.id));
        IUser r1 = this.c.author();
        if (r1 == null) goto L26;
        String r2 = r1.getUserId();
        if (r2 == null) goto L26;
    L27:
        r8.put("anchor_id", r2);
        u.l().sendLog("livesdk_exit_room_pop_click", r8, new Object[0]);
        return;
    L26:
        r2 = BuildConfig.FLAVOR;
        goto L27
    L34:
        return;
    L20:
        r7 = null;
        goto L21
    L12:
        e = move-exception;
        d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L10
        Throwable r3 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L10
        if (r3 == null) goto L16;
        d.d(r3, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r5);
        throw th;
    L5:
        if (Looper.myLooper() == r0.getLooper()) goto L7;
        r0.post(DialogLancet.createDismissRunnable(r5));
        goto L17
    }
}
