package com.bytedance.android.live.network.impl.interceptor;

import android.app.Activity;
import android.content.DialogInterface;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.network.response.RequestError;
import com.bytedance.android.livesdk.chatroom.ui.c9;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.larus.apm.impl.protector.RunnableProtector;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class h implements Runnable {
    public final /* synthetic */ int a;
    public final /* synthetic */ RequestError b;
    public final /* synthetic */ Activity c;

    public static final class a implements DialogInterface.OnClickListener {
        public static final a a = null;

        static {
            a = new a();
        }

        public a() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface r4, int r5) {
            com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_consume_interrupt_popup_click", null, new Object[]{am2.x.class, Room.class});
            r4.dismiss();
        }
    }

    public h(int r1, RequestError r2, Activity r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void a() {
        if (this.a != 4017006) goto L5;
        String r0 = s1.B(2131916304);
    L6:
        RequestError r1 = this.b;
        if (r1 == null) goto L25;
        String r2 = r1.prompts;
        if (r2 == null) goto L25;
        if (r2.length() <= 0) goto L13;
        boolean r4 = true;
    L14:
        if (r4 == true) goto L16;
    L18:
        boolean r5 = false;
    L19:
        if (r5 == true) goto L22;
        r2 = null;
    L22:
        if (r2 == null) goto L25;
        r0 = r2;
        goto L25
    L16:
        if (r2.equals(s1.B(2131916038)) == true) goto L18;
        r5 = true;
        goto L19
    L13:
        r4 = false;
    L25:
        Pattern r3 = DSLimitInterceptor.a;
        Activity r6 = this.c;
        c9.b r7 = new c9.b();
        r7.a = r6;
        r7.b = 1;
        r7.e = s1.B(2131923432);
        r7.f = r0;
        r7.g = 17;
        String r8 = s1.B(2131914411);
        a r9 = a.a;
        r7.h = r8;
        r7.i = r9;
        r7.p = false;
        r7.q = false;
        c9 r10 = new c9(r7.a, r7);
        if (DialogLancet.shouldBlockDialogShow(r10) == false) goto L33;
        DialogLancet.handleBlockedDialogShow(r10);
    L30:
        DSLimitInterceptor.b = r10;
        return;
    L33:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L32
    L29:
        DialogLancet.beforeDialogShow(r10);
        r10.show();
        DialogLancet.afterDialogShow(r10);
        goto L30
    L5:
        r0 = s1.B(2131916305);
        goto L6
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
