package com.bytedance.android.live.network.impl.interceptor;

import android.app.Activity;
import android.content.DialogInterface;
import com.bytedance.android.live.base.exception.ApiServerException;
import com.bytedance.android.live.core.monitor.LiveSlardarMonitor;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livehostapi.business.IHostVerify;
import com.bytedance.android.livehostapi.foundation.IHostApp;
import com.bytedance.android.livesdk.chatroom.ui.c9;
import com.bytedance.android.livesdk.verify.TicketSubmitApi;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.common.utility.Logger;
import com.larus.apm.impl.protector.RunnableProtector;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import io.reactivex.functions.Consumer;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class n implements Runnable {
    public final /* synthetic */ String a;
    public final /* synthetic */ Activity b;
    public final /* synthetic */ String c;
    public final /* synthetic */ String d;

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
            com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_sms_verification_popup_click", r7, new Object[]{am2.x.class, Room.class});
            r5.dismiss();
        }
    }

    public static final class b implements DialogInterface.OnClickListener {
        public final /* synthetic */ n a;

        public static final class a<T> implements Consumer {
            public static final a a = null;

            static {
                a = new a();
            }

            public a() {
            }

            public final void accept(Object r5) {
                String r6 = (String) r5;
                Logger.d("DSLimitInterceptor", "sms verify success, ticket=" + r6);
                f2.c(s1.B(2131923057), 0);
                int r0 = do0.b.a;
                HashMap r1 = new HashMap();
                r1.put("ticket", String.valueOf(r6));
                r1.put("type", "sms");
                LiveSlardarMonitor.monitorStatus("ttlive_service_ds_limit", 0, r1);
                Pattern r2 = DSLimitInterceptor.a;
                if (r6 != null) goto L5;
                r6 = "";
            L5:
                ((TicketSubmitApi) com.bytedance.android.live.network.c.b().e(TicketSubmitApi.class)).submitTicket(1, r6).compose(RxUtil.rxSchedulerHelper()).subscribe(k.a, l.a);
                com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_sms_verification_popup_result", MapsKt.mapOf(TuplesKt.to("verification_result", "succeed")), new Object[]{am2.x.class, Room.class});
            }
        }

        /* JADX INFO: renamed from: com.bytedance.android.live.network.impl.interceptor.n$b$b, reason: collision with other inner class name */
        public static final class C0136b<T> implements Consumer {
            public static final C0136b a = null;

            static {
                a = new C0136b();
            }

            public C0136b() {
            }

            public final void accept(Object r6) {
                ApiServerException r7 = (Throwable) r6;
                if ((r7 instanceof ApiServerException) == false) goto L11;
                ApiServerException r0 = r7;
                int r2 = r0.getErrorCode();
                if (r2 != 2) goto L7;
            L10:
                Logger.d("DSLimitInterceptor", "sms verify cancel");
                goto L11
            L7:
                if (r2 == 3) goto L10;
                Logger.d("DSLimitInterceptor", "sms verify fail, " + r0.getErrorMsg());
            L11:
                int r1 = do0.b.a;
                HashMap r3 = new HashMap();
                r3.put("error", String.valueOf(r7));
                r3.put("type", "sms");
                LiveSlardarMonitor.monitorStatus("ttlive_service_ds_limit", 1, r3);
                com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_sms_verification_popup_result", MapsKt.mapOf(TuplesKt.to("verification_result", "failed")), new Object[]{am2.x.class, Room.class});
            }
        }

        public b(n r1) {
            this.a = r1;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface r6, int r7) {
            Map r8 = MapsKt.mapOf(TuplesKt.to("button_type", "confirm"));
            boolean r3 = false;
            com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_sms_verification_popup_click", r8, new Object[]{am2.x.class, Room.class});
            String r9 = this.a.d;
            if (r9 != null) goto L5;
        L6:
            r3 = true;
        L7:
            if (r3 == false) goto L9;
            jc1.k.n(IHostApp.class).startBindMobileFullFragment(this.a.b, "live_detail", "live_detail", null);
        L10:
            r6.dismiss();
            return;
        L9:
            jc1.k.n(IHostVerify.class).startTwiceVerify(this.a.b, "block-sms").compose(RxUtil.rxSchedulerHelper()).subscribe(a.a, C0136b.a);
            goto L10
        L5:
            if (r9.length() != 0) goto L7;
            goto L6
        }
    }

    public n(String r1, Activity r2, String r3, String r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }

    public final void a() {
        String r0 = this.a;
        if (r0 == null) goto L17;
        boolean r3 = true;
        if (r0.length() <= 0) goto L7;
        boolean r2 = true;
    L8:
        if (r2 == true) goto L10;
    L12:
        r3 = false;
    L13:
        if (r3 == true) goto L16;
        r0 = null;
    L16:
        if (r0 == null) goto L17;
    L18:
        Pattern r4 = DSLimitInterceptor.a;
        Activity r5 = this.b;
        c9.b r6 = new c9.b();
        r6.a = r5;
        r6.b = 2;
        r6.e = s1.B(2131923432);
        r6.f = r0;
        r6.g = 17;
        String r1 = s1.B(2131915442);
        a r7 = a.a;
        r6.j = r1;
        r6.k = r7;
        String r8 = this.c;
        b r9 = new b(this);
        r6.l = r8;
        r6.m = r9;
        r6.p = false;
        r6.q = false;
        c9 r10 = new c9(r6.a, r6);
        if (DialogLancet.shouldBlockDialogShow(r10) == false) goto L26;
        DialogLancet.handleBlockedDialogShow(r10);
    L23:
        DSLimitInterceptor.b = r10;
        return;
    L26:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L25
    L22:
        DialogLancet.beforeDialogShow(r10);
        r10.show();
        DialogLancet.afterDialogShow(r10);
        goto L23
    L10:
        if (r0.equals(s1.B(2131916038)) == true) goto L12;
    L7:
        r2 = false;
    L17:
        r0 = s1.B(2131916306);
        goto L18
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
