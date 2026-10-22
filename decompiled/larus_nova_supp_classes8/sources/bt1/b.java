package bt1;

import am2.x;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Handler;
import android.os.Looper;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import com.bytedance.android.live.LiveGsonHelper;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.browser.IBrowserService;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.setting.LiveInfraSettingKeys;
import com.bytedance.android.live.core.setting.SettingKey;
import com.bytedance.android.live.core.utils.LiveResUtil;
import com.bytedance.android.live.core.utils.NetworkUtils;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.coupon.expandcoupon.ExpandCouponEnterRoomDialog;
import com.bytedance.android.livesdk.coupon.expandcoupon.ExpandCouponLoginDialog;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdk.user.l;
import com.bytedance.android.livesdk.utils.LiveNetworkBroadcastReceiver;
import com.bytedance.android.livesdk.widget.CommonBottomDialog;
import com.bytedance.android.livesdkapi.AppLifeCycleMonitor;
import com.bytedance.android.livesdkapi.ILiveOntologyInfoManager;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.service.IMiddlewareLiveService;
import com.bytedance.bpea.cert.token.TokenCert;
import com.bytedance.common.utility.Logger;
import com.bytedance.live.datacontext.j;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSyntaxException;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import io.reactivex.functions.Consumer;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import jc1.k;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class b extends com.bytedance.android.livesdk.coupon.a<com.bytedance.android.livesdk.coupon.expandcoupon.model.b> {
    public static final /* synthetic */ int q = 0;
    public final C0010b g;
    public ExpandCouponEnterRoomDialog h;
    public ExpandCouponLoginDialog i;
    public bt1.a j;
    public bt1.c k;
    public com.bytedance.android.livesdk.coupon.expandcoupon.model.e l;
    public com.bytedance.android.livesdk.coupon.expandcoupon.model.d m;
    public ct1.b n;
    public boolean o;
    public boolean p;

    public static final class a {
    }

    /* JADX INFO: renamed from: bt1.b$b, reason: collision with other inner class name */
    public final class C0010b implements com.bytedance.android.livesdk.coupon.jsb.f {
        public final /* synthetic */ b a;

        @Override // com.bytedance.android.livesdk.coupon.jsb.f
        public final com.bytedance.android.livesdk.coupon.expandcoupon.model.d a() {
            return this.a.m;
        }

        @Override // com.bytedance.android.livesdk.coupon.jsb.f
        public final ct1.b b() {
            return this.a.n;
        }

        @Override // com.bytedance.android.livesdk.coupon.jsb.f
        public final void c() {
            b.m(this.a, true);
        }

        public C0010b(b r1) {
            this.a = r1;
        }
    }

    public static final class c<T> implements Consumer {
        public static final c a = null;

        static {
            a = new c();
        }

        public c() {
        }

        public final void accept(Object r2) {
            IBaseUser r3 = (IBaseUser) r2;
            ALogger.d("ExpandCouponController", "loginBeforeObtainCoupon login success");
        }
    }

    public static final class d<T> implements Consumer {
        public static final d a = null;

        static {
            a = new d();
        }

        public d() {
        }

        public final void accept(Object r3) {
            ALogger.e("ExpandCouponController", "loginBeforeObtainCoupon login error, " + Log.getStackTraceString((Throwable) r3));
        }
    }

    public static final class e implements ExpandCouponEnterRoomDialog.b {
        public final /* synthetic */ b a;

        @Override // com.bytedance.android.livesdk.coupon.expandcoupon.ExpandCouponEnterRoomDialog.b
        public final void a() {
            this.a.getClass();
            b.r("close");
            ExpandCouponEnterRoomDialog r0 = this.a.h;
            if (r0 == null) goto L6;
            d(r0);
            return;
        }

        @Override // com.bytedance.android.livesdk.coupon.expandcoupon.ExpandCouponEnterRoomDialog.b
        public final void b() {
            this.a.getClass();
            if (b.o() == true) goto L5;
            this.a.s();
            return;
        L5:
            b r0 = this.a;
            com.bytedance.android.livesdk.coupon.expandcoupon.model.d r1 = r0.m;
            if (r1 == null) goto L8;
            r1.d = true;
        L8:
            r0.e();
            ExpandCouponEnterRoomDialog r2 = this.a.h;
            if (r2 == null) goto L11;
            d(r2);
        L11:
            this.a.getClass();
            b.r("receive_directly");
        }

        @Override // com.bytedance.android.livesdk.coupon.expandcoupon.ExpandCouponEnterRoomDialog.b
        public final void c() {
            b.m(this.a, false);
            IBrowserService r0 = k.f(IBrowserService.class);
            if (r0 == null) goto L6;
            int r1 = com.bytedance.android.livesdk.coupon.jsb.b.a;
            b r2 = this.a;
            r0.enqueueEvent("start_expand_task", com.bytedance.android.livesdk.coupon.jsb.b.a(r2.m, r2.n));
            return;
        }

        public e(b r1) {
            this.a = r1;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static void d(ExpandCouponEnterRoomDialog r3) {
            Handler r0 = DialogLancet.resolveDialogHandler(r3);
            if (r0 != null) goto L5;
        L8:
            DialogLancet.beforeDialogDismiss(r3);
            r3.dismiss();     // Catch: Throwable -> L11 Exception -> L13
        L17:
            DialogLancet.afterDialogDismiss(r3);
            return;
        L13:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L11
            Throwable r1 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L11
            if (r1 == null) goto L17;
            com.bytedance.crash.d.d(r1, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L11
        L11:
            th = move-exception;
            DialogLancet.afterDialogDismiss(r3);
            throw th;
        L5:
            if (Looper.myLooper() == r0.getLooper()) goto L8;
            r0.post(DialogLancet.createDismissRunnable(r3));
        }
    }

    public static final class f implements DialogInterface.OnDismissListener {
        public final /* synthetic */ b a;

        public f(b r1) {
            this.a = r1;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public final void onDismiss(DialogInterface r2) {
            this.a.h = null;
        }
    }

    static {
    }

    public static boolean o() {
        IUserService r0 = k.f(IUserService.class);
        if (r0 == null) goto L7;
        com.bytedance.android.livesdk.user.f r1 = r0.user();
        if (r1 == null) goto L7;
        return r1.isLogin();
    L7:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.android.livesdk.coupon.a
    public final Map<String, Object> a() {
        HashMap r0 = new HashMap();
        com.bytedance.android.livesdk.coupon.expandcoupon.model.b r1 = (com.bytedance.android.livesdk.coupon.expandcoupon.model.b) this.b;
        Long r2 = null;
        if (r1 == null) goto L5;
        Integer r3 = Integer.valueOf(r1.b());
    L6:
        r0.put("benefit_type", r3);
        com.bytedance.android.livesdk.coupon.expandcoupon.model.b r4 = (com.bytedance.android.livesdk.coupon.expandcoupon.model.b) this.b;
        if (r4 == null) goto L9;
        String r5 = r4.e();
    L10:
        r0.put("req_id", r5);
        com.bytedance.android.livesdk.coupon.expandcoupon.model.b r6 = (com.bytedance.android.livesdk.coupon.expandcoupon.model.b) this.b;
        if (r6 == null) goto L13;
        String r7 = r6.f();
    L14:
        r0.put("ad_token", r7);
        com.bytedance.android.livesdk.coupon.expandcoupon.model.b r8 = (com.bytedance.android.livesdk.coupon.expandcoupon.model.b) this.b;
        if (r8 == null) goto L17;
        Long r9 = Long.valueOf(r8.d());
    L18:
        r0.put("cid", r9);
        com.bytedance.android.livesdk.coupon.expandcoupon.model.b r10 = (com.bytedance.android.livesdk.coupon.expandcoupon.model.b) this.b;
        if (r10 == null) goto L21;
        Long r11 = Long.valueOf(r10.a());
    L22:
        r0.put("ad_id", r11);
        com.bytedance.android.livesdk.coupon.expandcoupon.model.b r12 = (com.bytedance.android.livesdk.coupon.expandcoupon.model.b) this.b;
        if (r12 == null) goto L25;
        String r13 = r12.c();
    L26:
        r0.put("ad_scene", r13);
        if (p() == false) goto L32;
        ct1.b r14 = this.n;
        if (r14 == null) goto L31;
        r2 = Long.valueOf(r14.j);
    L31:
        r0.put("qcpx_expansion_task_id_list", r2);
    L32:
        return r0;
    L25:
        r13 = null;
        goto L26
    L21:
        r11 = null;
        goto L22
    L17:
        r9 = null;
        goto L18
    L13:
        r7 = null;
        goto L14
    L9:
        r5 = null;
        goto L10
    L5:
        r3 = null;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.android.livesdk.coupon.a
    public final Map<String, Object> b() {
        LinkedHashMap r0 = new LinkedHashMap();
        com.bytedance.android.livesdk.coupon.expandcoupon.model.b r1 = (com.bytedance.android.livesdk.coupon.expandcoupon.model.b) this.b;
        Long r2 = null;
        if (r1 == null) goto L5;
        String r3 = r1.e();
    L6:
        r0.put("req_id", r3);
        com.bytedance.android.livesdk.coupon.expandcoupon.model.b r4 = (com.bytedance.android.livesdk.coupon.expandcoupon.model.b) this.b;
        if (r4 == null) goto L9;
        String r5 = r4.f();
    L10:
        r0.put("ad_token", r5);
        com.bytedance.android.livesdk.coupon.expandcoupon.model.b r6 = (com.bytedance.android.livesdk.coupon.expandcoupon.model.b) this.b;
        if (r6 == null) goto L13;
        Long r7 = Long.valueOf(r6.d());
    L14:
        r0.put("cid", r7);
        com.bytedance.android.livesdk.coupon.expandcoupon.model.b r8 = (com.bytedance.android.livesdk.coupon.expandcoupon.model.b) this.b;
        if (r8 == null) goto L17;
        r2 = Long.valueOf(r8.a());
    L17:
        r0.put("ad_id", r2);
        r0.put("popup_type", 2);
        return r0;
    L13:
        r7 = null;
        goto L14
    L9:
        r5 = null;
        goto L10
    L5:
        r3 = null;
        goto L6
    }

    @Override // com.bytedance.android.livesdk.coupon.a
    public final void j() {
        Logger.d("ExpandCouponController", "expandCouponController release");
        ct1.b r0 = this.n;
        if (r0 == null) goto L7;
        boolean r2 = true;
        if (r0.d != 1) goto L7;
    L8:
        if (r2 == false) goto L10;
        e();
    L10:
        RoomContext r1 = RoomContext.a.c(RoomContext.Companion, this.c.b, 0, 2);
        if (r1 == null) goto L17;
        j r3 = r1.getCloseRoomInterceptors();
        if (r3 == null) goto L17;
        CopyOnWriteArrayList r4 = (CopyOnWriteArrayList) r3.getValue();
        if (r4 == null) goto L17;
        r4.remove(this.k);
    L17:
        ct1.b r5 = this.n;
        if (r5 == null) goto L23;
        ct1.b.CountDownTimerC0377b r6 = r5.c;
        if (r6 == null) goto L22;
        r6.cancel();
    L22:
        r5.d = 0;
        r5.f = false;
        AppLifeCycleMonitor.INSTANCE.getAppEnterBackgroundOb().removeObserver(r5.h);
        r5.e.d();
        r5.e.c(r5.g);
        r5.a = null;
    L23:
        CommonBottomDialog r7 = this.i;
        if (r7 == null) goto L42;
        Handler r8 = DialogLancet.resolveDialogHandler(r7);
        if (r8 != null) goto L28;
    L30:
        DialogLancet.beforeDialogDismiss(r7);
        r7.dismiss();     // Catch: Throwable -> L33 Exception -> L35
    L39:
        DialogLancet.afterDialogDismiss(r7);
        goto L42
    L33:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r7);
        throw th;
    L35:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L33
        Throwable r9 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L33
        if (r9 == null) goto L39;
        com.bytedance.crash.d.d(r9, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L33
        goto L39
    L28:
        if (Looper.myLooper() == r8.getLooper()) goto L30;
        r8.post(DialogLancet.createDismissRunnable(r7));
    L42:
        ExpandCouponEnterRoomDialog r10 = this.h;
        if (r10 == null) goto L45;
        l(r10);
    L45:
        bt1.a r11 = this.j;
        if (r11 == null) goto L48;
        k(r11);
    L48:
        this.p = false;
        return;
    L7:
        r2 = false;
        goto L8
    }

    public final boolean p() {
        ct1.b r0 = this.n;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.d != 3) goto L7;
        return true;
    }

    public final void q() {
        HashMap r0 = new HashMap();
        if (p() == false) goto L5;
        String r1 = "1";
    L6:
        r0.put("is_expanded", r1);
        u.l().sendLog("tobsdk_livesdk_coupon_expand_quit_popup_show", r0, new Object[]{Room.class, x.class});
        return;
    L5:
        r1 = "0";
        goto L6
    }

    public final void s() {
        IUserService r0 = k.f(IUserService.class);
        if (r0 == null) goto L5;
        com.bytedance.android.livesdk.user.f r1 = r0.user();
    L6:
        if (r1 == null) goto L9;
        l.a r2 = new l.a();
        r2.d = "expand_coupon";
        r2.c = -1;
        l r3 = new l(r2);
        r1.login(this.c.getContext(), r3).subscribe(c.a, d.a);
        return;
    L9:
        return;
    L5:
        r1 = null;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v6, types: [android.app.Dialog, com.bytedance.android.livesdk.coupon.expandcoupon.ExpandCouponEnterRoomDialog] */
    public final void t() {
        com.bytedance.android.livesdk.coupon.expandcoupon.model.e r0 = this.l;
        if (r0 == null) goto L41;
        Map<Long, com.bytedance.android.livesdk.coupon.expandcoupon.model.c> r1 = r0.b();
        if (r1 == null) goto L42;
        int r2 = ct1.a.a;
        Context r3 = this.c.getContext();
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r1, "taskMap");
        if (r1.get(1L) == null) goto L9;
        com.bytedance.android.livesdk.coupon.expandcoupon.model.c r4 = r1.get(1L);
        Intrinsics.checkNotNull(r4);
        ct1.b r5 = new ct1.b(r3, r4);
    L10:
        this.n = r5;
        if (r5 == null) goto L14;
        r5.b(new bt1.d(this));
    L14:
        if (this.n != null) goto L16;
        return;
    L16:
        Context r6 = this.c.getContext();
        com.bytedance.android.livesdk.coupon.expandcoupon.model.e r7 = this.l;
        Intrinsics.checkNotNull(r7);
        long r8 = r7.d();
        com.bytedance.android.livesdk.coupon.expandcoupon.model.e r9 = this.l;
        Intrinsics.checkNotNull(r9);
        long r10 = r9.c();
        ct1.b r11 = this.n;
        Intrinsics.checkNotNull(r11);
        long r12 = r11.j;
        ct1.b r13 = this.n;
        Intrinsics.checkNotNull(r13);
        this.h = new ExpandCouponEnterRoomDialog(r6, new com.bytedance.android.livesdk.coupon.expandcoupon.model.a(r8, r10, r12, r13.k));
        com.bytedance.android.livesdk.coupon.expandcoupon.model.b r14 = (com.bytedance.android.livesdk.coupon.expandcoupon.model.b) this.b;
        if (r14 == null) goto L23;
        com.bytedance.android.livesdk.coupon.expandcoupon.model.d r15 = new com.bytedance.android.livesdk.coupon.expandcoupon.model.d(r14);
        com.bytedance.android.livesdk.coupon.expandcoupon.model.e r16 = this.l;
        if (r16 != null) goto L21;
    L24:
        this.m = r15;
        ?? r17 = this.h;
        if (r17 == 0) goto L27;
        r17.g = new e(this);
    L27:
        if (r17 == 0) goto L29;
        r17.setOnDismissListener(new f(this));
    L29:
        ExpandCouponEnterRoomDialog r18 = this.h;
        if (r18 != null) goto L32;
    L36:
        u.l().sendLog("tobsdk_livesdk_coupon_expand_popup_show", null, new Object[]{Room.class, x.class});
        return;
    L32:
        if (DialogLancet.shouldBlockDialogShow(r18) == false) goto L39;
        DialogLancet.handleBlockedDialogShow(r18);
        goto L36
    L39:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L38
    L35:
        DialogLancet.beforeDialogShow(r18);
        r18.show();
        DialogLancet.afterDialogShow(r18);
        goto L36
    L21:
        if (this.n == null) goto L24;
        com.bytedance.android.livesdk.coupon.util.a r19 = com.bytedance.android.livesdk.coupon.util.a.a;
        Intrinsics.checkNotNull(r16);
        long r20 = r16.d();
        r19.getClass();
        String r21 = com.bytedance.android.livesdk.coupon.util.a.a(r20);
        Intrinsics.checkNotNullParameter(r21, "<set-?>");
        r15.b = r21;
        com.bytedance.android.livesdk.coupon.expandcoupon.model.e r22 = this.l;
        Intrinsics.checkNotNull(r22);
        long r23 = r22.d();
        ct1.b r24 = this.n;
        Intrinsics.checkNotNull(r24);
        String r25 = com.bytedance.android.livesdk.coupon.util.a.a(r23 + r24.k.c());
        Intrinsics.checkNotNullParameter(r25, "<set-?>");
        r15.c = r25;
        goto L24
    L23:
        r15 = null;
        goto L24
    L9:
        r5 = null;
        goto L10
    L42:
        return;
    }

    @Override // com.bytedance.android.livesdk.coupon.a
    public final boolean d() {
        return this.p;
    }

    public static void k(bt1.a r3) {
        Handler r0 = DialogLancet.resolveDialogHandler(r3);
        if (r0 != null) goto L5;
    L8:
        DialogLancet.beforeDialogDismiss(r3);
        r3.dismiss();     // Catch: Throwable -> L11 Exception -> L13
    L17:
        DialogLancet.afterDialogDismiss(r3);
        return;
    L13:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L11
        Throwable r1 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L11
        if (r1 == null) goto L17;
        com.bytedance.crash.d.d(r1, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r3);
        throw th;
    L5:
        if (Looper.myLooper() == r0.getLooper()) goto L8;
        r0.post(DialogLancet.createDismissRunnable(r3));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void l(ExpandCouponEnterRoomDialog r3) {
        Handler r0 = DialogLancet.resolveDialogHandler(r3);
        if (r0 != null) goto L5;
    L8:
        DialogLancet.beforeDialogDismiss(r3);
        r3.dismiss();     // Catch: Throwable -> L11 Exception -> L13
    L17:
        DialogLancet.afterDialogDismiss(r3);
        return;
    L13:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L11
        Throwable r1 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L11
        if (r1 == null) goto L17;
        com.bytedance.crash.d.d(r1, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r3);
        throw th;
    L5:
        if (Looper.myLooper() == r0.getLooper()) goto L8;
        r0.post(DialogLancet.createDismissRunnable(r3));
    }

    public static void r(String r4) {
        HashMap r0 = new HashMap();
        r0.put("click_area", r4);
        u.l().sendLog("tobsdk_livesdk_coupon_expand_popup_click", r0, new Object[]{Room.class, x.class});
    }

    @Override // com.bytedance.android.livesdk.coupon.a
    public final void f(Throwable r3) {
        Intrinsics.checkNotNullParameter(r3, "throwable");
        bt1.a r0 = this.j;
        if (r0 == null) goto L5;
        k(r0);
    L5:
        ALogger.e("ExpandCouponController", "obtain coupon fail " + Log.getStackTraceString(r3));
    }

    @Override // com.bytedance.android.livesdk.coupon.a
    public final void g(com.bytedance.android.livesdk.coupon.balancecoupon.model.b r12) {
        Intrinsics.checkNotNullParameter(r12, "data");
        this.p = true;
        f2.c(r12.d(), 0);
        if (r12.c() == 1) goto L5;
        return;
    L5:
        if (p() == false) goto L22;
        com.bytedance.android.livesdk.log.g r1 = u.l();
        LinkedHashMap r3 = new LinkedHashMap();
        IUserService r4 = k.f(IUserService.class);
        if (r4 == null) goto L12;
        com.bytedance.android.livesdk.user.f r5 = r4.user();
        if (r5 == null) goto L12;
        String r6 = r5.n();
        if (r6 == null) goto L12;
    L13:
        r3.put("user_id", r6);
        ct1.b r7 = this.n;
        if (r7 == null) goto L16;
        Long r8 = Long.valueOf(r7.j);
    L17:
        r3.put("task_id", String.valueOf(r8));
        if (this.o == false) goto L20;
        String r9 = "任务面板";
    L21:
        r3.put("coupon_resource", r9);
        Unit r10 = Unit.INSTANCE;
        r1.sendLog("tobsdk_livesdk_coupon_expanded_toast_show", r3, new Object[]{Room.class, x.class});
        goto L22
    L20:
        r9 = "引导弹窗";
        goto L21
    L16:
        r8 = null;
    L12:
        r6 = "0";
    L22:
        bt1.a r0 = this.j;
        if (r0 == null) goto L30;
        r0.c.setText(LiveResUtil.getString(2131923015));
        int r2 = LiveResUtil.getColor(2131107039);
        SpannableStringBuilder r11 = new SpannableStringBuilder();
        r11.append("优惠券已膨胀为");     // Catch: Throwable -> L27
        int r13 = r11.length();     // Catch: Throwable -> L27
        StringBuilder r14 = new StringBuilder();     // Catch: Throwable -> L27
        com.bytedance.android.livesdk.coupon.util.a r15 = com.bytedance.android.livesdk.coupon.util.a.a;     // Catch: Throwable -> L27
        com.bytedance.android.livesdk.coupon.expandcoupon.model.a r16 = r0.f;     // Catch: Throwable -> L27
        long r17 = r16.a + r16.d.c();     // Catch: Throwable -> L27
        r15.getClass();     // Catch: Throwable -> L27
        r14.append(com.bytedance.android.livesdk.coupon.util.a.a(r17));     // Catch: Throwable -> L27
        r14.append("元");     // Catch: Throwable -> L27
        r11.append(r14.toString());     // Catch: Throwable -> L27
        r11.setSpan(new ForegroundColorSpan(r2), r13, r11.length(), 33);     // Catch: Throwable -> L27
        r0.b.setText(r11);     // Catch: Throwable -> L27
    L29:
        q();
    L27:
        th = move-exception;
        ALogger.e("ExpandCouponCloseRoomDialog", "onTaskFinish error " + Log.getStackTraceString(th));
    L30:
        com.bytedance.android.livesdk.coupon.expandcoupon.model.d r18 = this.m;
        if (r18 == null) goto L37;
        String r19 = r12.a();
        Intrinsics.checkNotNullParameter(r19, "<set-?>");
        r18.a = r19;
        return;
    }

    @Override // com.bytedance.android.livesdk.coupon.a
    public final void h(com.bytedance.android.livesdk.coupon.balancecoupon.model.c r3) {
        Intrinsics.checkNotNullParameter(r3, "data");
        if (r3.a() == false) goto L34;
        com.bytedance.android.livesdk.coupon.expandcoupon.model.e r0 = r3.c();
        if (r0 == null) goto L34;
        if (r0.a() == true) goto L34;
        com.bytedance.android.livesdk.coupon.expandcoupon.model.e r1 = r3.c();
        if (r1 == null) goto L11;
        Map<Long, com.bytedance.android.livesdk.coupon.expandcoupon.model.c> r2 = r1.b();
    L12:
        if (r2 == null) goto L34;
        com.bytedance.android.livesdk.coupon.expandcoupon.model.e r4 = r3.c();
        if (r4 == null) goto L42;
        this.l = r4;
        if (o() == true) goto L32;
        ExpandCouponLoginDialog r5 = new ExpandCouponLoginDialog(this.c.getContext(), r4);
        this.i = r5;
        bt1.e r6 = new bt1.e(this, r4);
        Intrinsics.checkNotNullParameter(r6, "callback");
        r5.d = r6;
        CommonBottomDialog r7 = this.i;
        if (r7 == null) goto L22;
        r7.setOnDismissListener(new bt1.f(this));
    L22:
        ExpandCouponLoginDialog r8 = this.i;
        if (r8 == null) goto L25;
        r8.setCanceledOnTouchOutside(true);
    L25:
        ExpandCouponLoginDialog r9 = this.i;
        if (r9 != null) goto L28;
        return;
    L28:
        if (DialogLancet.shouldBlockDialogShow(r9) == false) goto L37;
        DialogLancet.handleBlockedDialogShow(r9);
        return;
    L37:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L36
    L31:
        DialogLancet.beforeDialogShow(r9);
        r9.show();
        DialogLancet.afterDialogShow(r9);
        return;
    L32:
        t();
        return;
    L42:
        return;
    L11:
        r2 = null;
    L34:
        Logger.d("ExpandCouponController", "coupon can not show");
    }

    @Override // com.bytedance.android.livesdk.coupon.a
    public final com.bytedance.android.livesdk.coupon.expandcoupon.model.b i(at1.a r10) {
        String r0 = "";
        Intrinsics.checkNotNullParameter(r10, "couponContext");
        Long r3 = (Long) r10.b.get("data_room_id", 0L);
        IMiddlewareLiveService r4 = k.f(IMiddlewareLiveService.class);
        if (r4 == null) goto L5;
        ILiveOntologyInfoManager r5 = r4.getLiveOntologyRecord();
    L6:
        boolean r6 = false;
        if (r5 == null) goto L9;
        boolean r7 = r5.isFirstRoom(r3.longValue());
    L10:
        if (r7 == false) goto L59;
        SettingKey r8 = LiveInfraSettingKeys.LIVE_MOCK_EXPAND_COUPON_PARAM;
        CharSequence r9 = (CharSequence) r8.getValue();
        if (r9 != null) goto L15;
    L18:
        boolean r11 = true;
    L19:
        if (r11 == false) goto L54;
        String r12 = (String) r10.b.get("data_enter_ecom_live_params", "");     // Catch: JsonParseException -> L45 JsonSyntaxException -> L47 JSONException -> L49
        if (r12 == null) goto L26;
        r0 = r12;
    L26:
        if (TextUtils.isEmpty(r0) == false) goto L28;
        ALogger.i("ExpandCouponController", "could not find ecomParams");     // Catch: JsonParseException -> L45 JsonSyntaxException -> L47 JSONException -> L49
        JSONObject r13 = null;
    L29:
        if (r13 == null) goto L31;
        String r1 = r13.toString();     // Catch: JsonParseException -> L45 JsonSyntaxException -> L47 JSONException -> L49
    L32:
        if (r1 != null) goto L34;
    L35:
        r6 = true;
    L36:
        if (r6 == true) goto L55;
        Gson r2 = LiveGsonHelper.get();     // Catch: JsonParseException -> L45 JsonSyntaxException -> L47 JSONException -> L49
        if (r13 == null) goto L42;
        JSONObject r14 = r13.optJSONObject("expand_coupon");     // Catch: JsonParseException -> L45 JsonSyntaxException -> L47 JSONException -> L49
        if (r14 == null) goto L42;
        String r15 = r14.toString();     // Catch: JsonParseException -> L45 JsonSyntaxException -> L47 JSONException -> L49
    L43:
    L56:
        return (com.bytedance.android.livesdk.coupon.expandcoupon.model.b) GsonProtectorUtils.fromJson(r2, r15, com.bytedance.android.livesdk.coupon.expandcoupon.model.b.class);
    L42:
        r15 = null;
        goto L43
    L55:
        return null;
    L34:
        if (r1.length() != 0) goto L36;
    L31:
        r1 = null;
        goto L32
    L28:
        r13 = new JSONObject(r0);     // Catch: JsonParseException -> L45 JsonSyntaxException -> L47 JSONException -> L49
    L47:
        e = move-exception;
        ALogger.e("ExpandCouponController", "JsonSyntaxException, " + Log.getStackTraceString(e));
        return null;
    L49:
        e = move-exception;
        ALogger.e("ExpandCouponController", "build ecom params error: " + e);
        return null;
    L45:
        e = move-exception;
        ALogger.e("ExpandCouponController", "JsonSyntaxException, " + Log.getStackTraceString(e));
        return null;
    L54:
        return (com.bytedance.android.livesdk.coupon.expandcoupon.model.b) GsonProtectorUtils.fromJson(LiveGsonHelper.get(), (String) r8.getValue(), com.bytedance.android.livesdk.coupon.expandcoupon.model.b.class);
    L15:
        if (r9.length() == 0) goto L18;
        r11 = false;
        goto L19
    L59:
        return null;
    L9:
        r7 = false;
        goto L10
    L5:
        r5 = null;
        goto L6
    }

    public static final void m(b r7, boolean r8) {
        if (r7.l == null) goto L49;
        r7.o = r8;
        if (o() == true) goto L8;
        r7.s();
    L39:
        if (r8 == true) goto L46;
        IBrowserService r9 = k.f(IBrowserService.class);
        if (r9 == null) goto L47;
        w30.a r10 = r9.getStorageProcessor(r7.c.getContext());
        if (r10 == null) goto L48;
        r10.setStorage("task_center_flash_exchange_qcpx_coupon", String.valueOf(System.currentTimeMillis()));
        return;
    L48:
        return;
    L47:
        return;
    L46:
        return;
    L8:
        ExpandCouponEnterRoomDialog r0 = r7.h;
        if (r0 == null) goto L11;
        l(r0);
    L11:
        ct1.b r1 = r7.n;
        if (r1 != null) goto L14;
    L20:
        ct1.b r2 = r7.n;
        if (r2 == null) goto L39;
        if (r2.d != 1) goto L39;
        f2.c(LiveResUtil.getString(2131916074), 0);
        com.bytedance.android.livesdk.coupon.expandcoupon.model.e r3 = r7.l;
        ct1.b r4 = r7.n;
        if (r4 != null) goto L27;
    L38:
        r("expand");
        goto L39
    L27:
        if (r4.d != 1) goto L38;
        RoomContext r5 = RoomContext.a.c(RoomContext.Companion, r7.c.b, 0, 2);
        if (r5 == null) goto L34;
        j r6 = r5.getCloseRoomInterceptors();
        if (r6 == null) goto L34;
        CopyOnWriteArrayList r11 = (CopyOnWriteArrayList) r6.getValue();
    L35:
        bt1.c r12 = new bt1.c(r7, r11, r3);
        r7.k = r12;
        if (r11 == null) goto L38;
        Intrinsics.checkNotNull(r12);
        r11.add(0, r12);
    L34:
        r11 = null;
        goto L35
    L14:
        if (NetworkUtils.f(r1.i) == true) goto L16;
        f2.c(LiveResUtil.getString(2131922916), 0);
        goto L20
    L16:
        ct1.b.CountDownTimerC0377b r13 = r1.c;
        if (r13 == null) goto L19;
        r13.cancel();
    L19:
        AppLifeCycleMonitor r14 = AppLifeCycleMonitor.INSTANCE;
        r14.getAppEnterBackgroundOb().removeObserver(r1.h);
        r14.getAppEnterBackgroundOb().observeForever(r1.h);
        LiveNetworkBroadcastReceiver r15 = r1.e;
        Context r16 = r1.i;
        TokenCert r17 = LiveNetworkBroadcastReceiver.d;
        r15.b(r16, r17);
        r1.e.a(r1.g, r17);
        r1.a(r1.b);
        goto L20
    }

    public static final void n(b r3, String r4) {
        r3.getClass();
        HashMap r0 = new HashMap();
        if (r3.p() == false) goto L5;
        String r5 = "1";
    L6:
        r0.put("is_expanded", r5);
        r0.put("click_area", r4);
        u.l().sendLog("tobsdk_livesdk_coupon_expand_quit_popup_click", r0, new Object[]{Room.class, x.class});
        return;
    L5:
        r5 = "0";
        goto L6
    }

    public b(at1.a r2, int r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "couponContext");
        super(r2, r3, r4);
        this.g = new C0010b(this);
    }
}
