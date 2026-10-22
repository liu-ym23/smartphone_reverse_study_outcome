package com.bytedance.android.live.network.impl.interceptor;

import android.app.Activity;
import android.content.DialogInterface;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.chatroom.ui.c9;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.larus.apm.impl.protector.RunnableProtector;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import java.util.Map;
import java.util.regex.Pattern;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class m implements Runnable {
    public final /* synthetic */ Activity a;

    public static final class a implements DialogInterface.OnClickListener {
        public static final a a = null;

        static {
            a = new a();
        }

        public a() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface r5, int r6) {
            Map r7 = MapsKt.mapOf(TuplesKt.to("button_type", "cancel"));
            com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_name_verification_popup_click", r7, new Object[]{am2.x.class, Room.class});
            r5.dismiss();
        }
    }

    public static final class b implements DialogInterface.OnClickListener {
        public final /* synthetic */ m a;

        public b(m r1) {
            this.a = r1;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface r5, int r6) {
            Map r7 = MapsKt.mapOf(TuplesKt.to("button_type", "confirm"));
            com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_name_verification_popup_click", r7, new Object[]{am2.x.class, Room.class});
            Pattern r8 = DSLimitInterceptor.a;
            DSLimitInterceptor.d(this.a.a, "consume_certifi");
            r5.dismiss();
        }
    }

    public m(Activity r1) {
        this.a = r1;
    }

    public final void a() {
        String r0 = s1.B(2131916539);
        Pattern r1 = DSLimitInterceptor.a;
        Activity r2 = this.a;
        c9.b r3 = new c9.b();
        r3.a = r2;
        r3.b = 2;
        r3.e = s1.B(2131923432);
        r3.f = r0;
        r3.g = 17;
        String r4 = s1.B(2131915442);
        a r5 = a.a;
        r3.j = r4;
        r3.k = r5;
        String r6 = s1.B(2131916307);
        b r7 = new b(this);
        r3.l = r6;
        r3.m = r7;
        r3.p = false;
        r3.q = false;
        c9 r8 = new c9(r3.a, r3);
        if (DialogLancet.shouldBlockDialogShow(r8) == false) goto L10;
        DialogLancet.handleBlockedDialogShow(r8);
    L7:
        DSLimitInterceptor.b = r8;
        return;
    L10:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L9
    L6:
        DialogLancet.beforeDialogShow(r8);
        r8.show();
        DialogLancet.afterDialogShow(r8);
        goto L7
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
