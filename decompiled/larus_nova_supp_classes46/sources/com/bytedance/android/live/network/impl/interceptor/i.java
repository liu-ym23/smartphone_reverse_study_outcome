package com.bytedance.android.live.network.impl.interceptor;

import android.app.Activity;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.chatroom.ui.c9;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.larus.apm.impl.protector.RunnableProtector;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class i implements Runnable {
    public final /* synthetic */ com.bytedance.android.live.core.model.profit.a a;
    public final /* synthetic */ Activity b;

    public i(com.bytedance.android.live.core.model.profit.a r1, Activity r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void a() {
        if (this.a.a() == false) goto L10;
        Pattern r0 = DSLimitInterceptor.a;
        Activity r1 = this.b;
        com.bytedance.android.live.core.model.profit.a r7 = this.a;
        com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_face_verification_popup_show", null, new Object[]{am2.x.class, Room.class});
        c9.b r3 = new c9.b();
        r3.a = r1;
        r3.b = 2;
        r3.e = s1.B(2131923432);
        r3.f = r7.b();
        r3.g = 17;
        String r2 = s1.B(2131915442);
        f r4 = f.a;
        r3.j = r2;
        r3.k = r4;
        String r5 = s1.B(2131916307);
        g r6 = new g(r1);
        r3.l = r5;
        r3.m = r6;
        r3.p = false;
        r3.q = false;
        c9 r8 = new c9(r3.a, r3);
        if (DialogLancet.shouldBlockDialogShow(r8) == false) goto L21;
        DialogLancet.handleBlockedDialogShow(r8);
    L9:
        DSLimitInterceptor.b = r8;
        return;
    L21:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L17
    L8:
        DialogLancet.beforeDialogShow(r8);
        r8.show();
        DialogLancet.afterDialogShow(r8);
        goto L9
    L10:
        Pattern r9 = DSLimitInterceptor.a;
        Activity r10 = this.b;
        com.bytedance.android.live.core.model.profit.a r11 = this.a;
        com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_calm_period_popup_show", null, new Object[]{am2.x.class, Room.class});
        c9.b r12 = new c9.b();
        r12.a = r10;
        r12.b = 1;
        r12.e = s1.B(2131923432);
        r12.f = r11.b();
        r12.g = 17;
        String r13 = s1.B(2131914411);
        e r14 = e.a;
        r12.h = r13;
        r12.i = r14;
        r12.p = false;
        r12.q = false;
        c9 r15 = new c9(r12.a, r12);
        if (DialogLancet.shouldBlockDialogShow(r15) == false) goto L19;
        DialogLancet.handleBlockedDialogShow(r15);
    L15:
        DSLimitInterceptor.b = r15;
        return;
    L19:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L18
    L14:
        DialogLancet.beforeDialogShow(r15);
        r15.show();
        DialogLancet.afterDialogShow(r15);
        goto L15
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
