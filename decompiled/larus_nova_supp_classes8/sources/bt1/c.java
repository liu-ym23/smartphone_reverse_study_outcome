package bt1;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Handler;
import android.os.Looper;
import com.bytedance.android.livesdk.closeroom.CloseRoomInterceptList;
import com.bytedance.android.livesdkapi.commerce.IHostCommerceServiceLive;
import com.bytedance.common.utility.Logger;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import java.util.concurrent.CopyOnWriteArrayList;
import jc1.k;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class c implements kf1.a {
    public final /* synthetic */ bt1.b a;
    public final /* synthetic */ CopyOnWriteArrayList b;
    public final /* synthetic */ com.bytedance.android.livesdk.coupon.expandcoupon.model.e c;

    public static final class a implements g {
        public final /* synthetic */ c a;
        public final /* synthetic */ Runnable b;

        @Override // bt1.g
        public final void a() {
            bt1.b.n(this.a.a, "close");
            bt1.a r0 = this.a.a.j;
            if (r0 == null) goto L6;
            d(r0);
            return;
        }

        @Override // bt1.g
        public final void b() {
            bt1.a r0 = this.a.a.j;
            if (r0 == null) goto L6;
            d(r0);
        L6:
            if (this.a.a.p() == false) goto L10;
            bt1.b.n(this.a.a, "go_use");
            IHostCommerceServiceLive r1 = k.f(IHostCommerceServiceLive.class);
            if (r1 == null) goto L12;
            r1.showLivePromotionListFragment(this.a.a.c.getContext(), new JSONObject());
            return;
        L12:
            return;
        L10:
            bt1.b.n(this.a.a, "keep");
        }

        @Override // bt1.g
        public final void c() {
            bt1.b.n(this.a.a, "quit");
            Runnable r0 = this.b;
            if (r0 == null) goto L6;
            r0.run();
            return;
        }

        public static void d(bt1.a r3) {
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

        public a(c r1, Runnable r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public static final class b implements DialogInterface.OnDismissListener {
        public final /* synthetic */ c a;

        public b(c r1) {
            this.a = r1;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public final void onDismiss(DialogInterface r2) {
            this.a.a.h = null;
        }
    }

    public final String tag() {
        return "ExpandCouponController";
    }

    public final CloseRoomInterceptList config() {
        return CloseRoomInterceptList.EXPAND_COUPON;
    }

    public final boolean qa(Runnable r13, boolean r14) {
        if (r14 == false) goto L5;
        return false;
    L5:
        CopyOnWriteArrayList r15 = this.b;
        if (r15 == null) goto L8;
        r15.remove(this.a.k);
    L8:
        bt1.b r16 = this.a;
        com.bytedance.android.livesdk.coupon.expandcoupon.model.e r1 = this.c;
        if (r16.n == null) goto L34;
        if (r1 == null) goto L34;
        if (r1.a() == true) goto L34;
        ct1.b r2 = r16.n;
        if (r2 == null) goto L20;
        if (r2.d == 0) goto L34;
    L20:
        if (r16.p() == true) goto L34;
        ct1.b r3 = r16.n;
        if (r3 == null) goto L25;
        long r4 = r3.b;
    L27:
        if (r4 <= 0) goto L34;
        StringBuilder r5 = new StringBuilder("couponTask state = ");
        ct1.b r17 = r16.n;
        if (r17 == null) goto L32;
        Integer r18 = Integer.valueOf(r17.d);
    L33:
        r5.append(r18);
        Logger.d("ExpandCouponController", r5.toString());
        boolean r19 = true;
    L35:
        if (r19 == false) goto L54;
        bt1.b r110 = this.a;
        Context r6 = this.a.c.getContext();
        com.bytedance.android.livesdk.coupon.expandcoupon.model.e r7 = this.c;
        Intrinsics.checkNotNull(r7);
        long r8 = r7.d();
        long r9 = this.c.c();
        ct1.b r10 = this.a.n;
        Intrinsics.checkNotNull(r10);
        long r11 = r10.j;
        ct1.b r12 = this.a.n;
        Intrinsics.checkNotNull(r12);
        com.bytedance.android.livesdk.coupon.expandcoupon.model.a r20 = new com.bytedance.android.livesdk.coupon.expandcoupon.model.a(r8, r9, r11, r12.k);
        ct1.b r21 = this.a.n;
        Intrinsics.checkNotNull(r21);
        r110.j = new bt1.a(r6, r20, r21.b);
        bt1.a r111 = this.a.j;
        if (r111 == null) goto L39;
        a r0 = new a(this, r13);
        Intrinsics.checkNotNullParameter(r0, "callback");
        r111.d = r0;
    L39:
        bt1.a r112 = this.a.j;
        if (r112 == null) goto L42;
        r112.setOnDismissListener(new b(this));
    L42:
        bt1.a r113 = this.a.j;
        if (r113 == null) goto L45;
        r113.setCanceledOnTouchOutside(true);
    L45:
        bt1.a r114 = this.a.j;
        if (r114 != null) goto L48;
    L52:
        this.a.q();
        return true;
    L48:
        if (DialogLancet.shouldBlockDialogShow(r114) == false) goto L56;
        DialogLancet.handleBlockedDialogShow(r114);
        goto L52
    L56:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L55
    L51:
        DialogLancet.beforeDialogShow(r114);
        r114.show();
        DialogLancet.afterDialogShow(r114);
        goto L52
    L54:
        return false;
    L32:
        r18 = null;
        goto L33
    L25:
        r4 = 0;
    L34:
        r19 = false;
        goto L35
    }

    public c(bt1.b r1, CopyOnWriteArrayList r2, com.bytedance.android.livesdk.coupon.expandcoupon.model.e r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
