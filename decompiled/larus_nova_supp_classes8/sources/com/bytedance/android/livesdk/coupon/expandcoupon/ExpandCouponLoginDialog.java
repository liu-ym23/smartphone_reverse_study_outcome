package com.bytedance.android.livesdk.coupon.expandcoupon;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import bt1.h;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.utils.LiveResUtil;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livesdk.coupon.expandcoupon.model.e;
import com.bytedance.android.livesdk.user.f;
import com.bytedance.android.livesdk.user.l;
import com.bytedance.android.livesdk.widget.CommonBottomDialog;
import com.bytedance.crash.d;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import io.reactivex.functions.Consumer;
import jc1.k;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/coupon/expandcoupon/ExpandCouponLoginDialog;", "Lcom/bytedance/android/livesdk/widget/CommonBottomDialog;", "live-impl-saas_release"}, k = 1, mv = {1, 4, 3})
public final class ExpandCouponLoginDialog extends CommonBottomDialog {
    public TextView a;
    public TextView b;
    public Button c;
    public h d;
    public final e e;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ ExpandCouponLoginDialog a;

        /* JADX INFO: renamed from: com.bytedance.android.livesdk.coupon.expandcoupon.ExpandCouponLoginDialog$a$a, reason: collision with other inner class name */
        public static final class C0116a<T> implements Consumer {
            public final /* synthetic */ a a;

            public C0116a(a r1) {
                this.a = r1;
            }

            public final void accept(Object r2) {
                IBaseUser r3 = (IBaseUser) r2;
                h r4 = this.a.a.d;
                if (r4 == null) goto L5;
                r4.onSuccess();
            L5:
                this.a.a.d = null;
            }
        }

        public static final class b<T> implements Consumer {
            public final /* synthetic */ a a;

            public b(a r1) {
                this.a = r1;
            }

            public final void accept(Object r2) {
                Throwable r3 = (Throwable) r2;
                h r4 = this.a.a.d;
                if (r4 == null) goto L5;
                r4.onFail();
            L5:
                this.a.a.d = null;
            }
        }

        public a(ExpandCouponLoginDialog r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r4) {
            IUserService r5 = k.f(IUserService.class);
            if (r5 == null) goto L5;
            f r6 = r5.user();
        L6:
            if (r6 == null) goto L8;
            l.a r0 = new l.a();
            r0.d = "expand_coupon";
            r0.c = -1;
            l r1 = new l(r0);
            r6.login(this.a.getContext(), r1).subscribe(new C0116a(this), new b(this));
        L8:
            CommonBottomDialog r7 = this.a;
            Handler r2 = DialogLancet.resolveDialogHandler(r7);
            if (r2 != null) goto L11;
        L13:
            DialogLancet.beforeDialogDismiss(r7);
            r7.dismiss();     // Catch: Throwable -> L16 Exception -> L18
        L22:
            DialogLancet.afterDialogDismiss(r7);
            return;
        L18:
            e = move-exception;
            d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L16
            Throwable r3 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L16
            if (r3 == null) goto L22;
            d.d(r3, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L16
        L16:
            th = move-exception;
            DialogLancet.afterDialogDismiss(r7);
            throw th;
        L11:
            if (Looper.myLooper() == r2.getLooper()) goto L13;
            r2.post(DialogLancet.createDismissRunnable(r7));
            return;
        L5:
            r6 = null;
            goto L6
        }
    }

    public final int getLayoutId() {
        return 2131565952;
    }

    public final void onCreate(Bundle r5) {
        super.onCreate(r5);
        this.a = (TextView) findViewById(2131371892);
        this.b = (TextView) findViewById(2131371893);
        this.c = (Button) findViewById(2131371890);
        TextView r6 = this.a;
        if (r6 == null) goto L5;
        com.bytedance.android.livesdk.coupon.util.a r1 = com.bytedance.android.livesdk.coupon.util.a.a;
        long r2 = this.e.c();
        r1.getClass();
        r6.setText(LiveResUtil.getString(2131916519, new Object[]{com.bytedance.android.livesdk.coupon.util.a.a(r2)}));
    L5:
        TextView r7 = this.b;
        if (r7 == null) goto L8;
        com.bytedance.android.livesdk.coupon.util.a r0 = com.bytedance.android.livesdk.coupon.util.a.a;
        long r3 = this.e.d();
        r0.getClass();
        r7.setText(com.bytedance.android.livesdk.coupon.util.a.a(r3));
    L8:
        Button r8 = this.c;
        if (r8 == null) goto L12;
        r8.setOnClickListener(new a(this));
        return;
    }

    public ExpandCouponLoginDialog(Context r2, e r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "couponInfo");
        super(r2, 2131954669);
        this.e = r3;
    }
}
