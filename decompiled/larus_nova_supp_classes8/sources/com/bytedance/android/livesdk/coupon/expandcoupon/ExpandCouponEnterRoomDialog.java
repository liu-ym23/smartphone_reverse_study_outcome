package com.bytedance.android.livesdk.coupon.expandcoupon;

import android.content.Context;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.LiveResUtil;
import com.bytedance.android.live.ui.GradientTextView;
import com.bytedance.android.livesdk.widget.CommonBottomDialog;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0002\u0002\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/coupon/expandcoupon/ExpandCouponEnterRoomDialog;", "Lcom/bytedance/android/livesdk/widget/CommonBottomDialog;", "a", "b", "live-impl-saas_release"}, k = 1, mv = {1, 4, 3})
public final class ExpandCouponEnterRoomDialog extends CommonBottomDialog {
    public TextView a;
    public TextView b;
    public GradientTextView c;
    public TextView d;
    public GradientTextView e;
    public Button f;
    public b g;
    public GradientTextView h;
    public GradientTextView i;
    public View j;
    public final int[] k;
    public final f l;
    public final com.bytedance.android.livesdk.coupon.expandcoupon.model.a m;

    public static final class a {
    }

    public interface b {
        void a();

        void b();

        void c();
    }

    public static final class c implements View.OnClickListener {
        public final /* synthetic */ ExpandCouponEnterRoomDialog a;

        public c(ExpandCouponEnterRoomDialog r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r1) {
            b r2 = this.a.g;
            if (r2 == null) goto L6;
            r2.b();
            return;
        }
    }

    public static final class d implements View.OnClickListener {
        public final /* synthetic */ ExpandCouponEnterRoomDialog a;

        public d(ExpandCouponEnterRoomDialog r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r1) {
            b r2 = this.a.g;
            if (r2 == null) goto L6;
            r2.c();
            return;
        }
    }

    public static final class e implements View.OnClickListener {
        public final /* synthetic */ ExpandCouponEnterRoomDialog a;

        public e(ExpandCouponEnterRoomDialog r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r1) {
            b r2 = this.a.g;
            if (r2 == null) goto L6;
            r2.a();
            return;
        }
    }

    public static final class f implements GradientTextView.a {
        public final /* synthetic */ ExpandCouponEnterRoomDialog a;

        public f(ExpandCouponEnterRoomDialog r1) {
            this.a = r1;
        }

        public final LinearGradient a(int r9, int r10) {
            return new LinearGradient(0.0f, 0.0f, 0.0f, r10, this.a.k, null, Shader.TileMode.CLAMP);
        }
    }

    static {
    }

    public final int getLayoutId() {
        return 2131565951;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void dismiss() {
        Handler r0 = DialogLancet.resolveDialogHandler(this);
        if (r0 != null) goto L5;
    L7:
        DialogLancet.beforeDialogDismiss(this);
        super.dismiss();     // Catch: Throwable -> L10 Exception -> L12
    L16:
        DialogLancet.afterDialogDismiss(this);
    L17:
        this.g = null;
        return;
    L12:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L10
        Throwable r1 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L10
        if (r1 == null) goto L16;
        com.bytedance.crash.d.d(r1, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        DialogLancet.afterDialogDismiss(this);
        throw th;
    L5:
        if (Looper.myLooper() == r0.getLooper()) goto L7;
        r0.post(DialogLancet.createDismissRunnable(this));
        goto L17
    }

    public final void onCreate(Bundle r12) {
        super.onCreate(r12);
        this.a = (TextView) findViewById(2131390449);
        this.b = (TextView) findViewById(2131390723);
        this.c = findViewById(2131390724);
        this.d = (TextView) findViewById(2131390719);
        this.e = findViewById(2131390720);
        this.f = (Button) findViewById(2131364710);
        this.h = findViewById(2131390725);
        this.i = findViewById(2131390721);
        this.j = findViewById(2131364266);
        Button r13 = this.f;
        if (r13 == null) goto L5;
        r13.setOnClickListener(new c(this));
    L5:
        Button r14 = (Button) findViewById(2131364697);
        if (r14 == null) goto L8;
        r14.setOnClickListener(new d(this));
    L8:
        View r15 = this.j;
        if (r15 == null) goto L11;
        r15.setOnClickListener(new e(this));
    L11:
        TextView r16 = this.a;
        if (r16 != null) goto L14;
    L21:
        GradientTextView r17 = this.h;
        if (r17 == null) goto L24;
        r17.setLinearGradientCreator(this.l);
    L24:
        GradientTextView r18 = this.i;
        if (r18 == null) goto L27;
        r18.setLinearGradientCreator(this.l);
    L27:
        GradientTextView r19 = this.c;
        if (r19 == null) goto L30;
        r19.setLinearGradientCreator(this.l);
    L30:
        GradientTextView r110 = this.e;
        if (r110 == null) goto L33;
        r110.setLinearGradientCreator(this.l);
    L33:
        TextView r111 = this.b;
        if (r111 == null) goto L36;
        com.bytedance.android.livesdk.coupon.util.a r4 = com.bytedance.android.livesdk.coupon.util.a.a;
        long r5 = this.m.b;
        r4.getClass();
        r111.setText(LiveResUtil.getString(2131916519, new Object[]{com.bytedance.android.livesdk.coupon.util.a.a(r5)}));
    L36:
        GradientTextView r112 = this.c;
        if (r112 == null) goto L39;
        com.bytedance.android.livesdk.coupon.util.a r3 = com.bytedance.android.livesdk.coupon.util.a.a;
        long r6 = this.m.a;
        r3.getClass();
        r112.setText(com.bytedance.android.livesdk.coupon.util.a.a(r6));
    L39:
        TextView r113 = this.d;
        if (r113 == null) goto L42;
        com.bytedance.android.livesdk.coupon.util.a r7 = com.bytedance.android.livesdk.coupon.util.a.a;
        com.bytedance.android.livesdk.coupon.expandcoupon.model.a r8 = this.m;
        long r9 = r8.b + r8.d.b();
        r7.getClass();
        r113.setText(LiveResUtil.getString(2131916519, new Object[]{com.bytedance.android.livesdk.coupon.util.a.a(r9)}));
    L42:
        GradientTextView r114 = this.e;
        if (r114 == null) goto L45;
        com.bytedance.android.livesdk.coupon.util.a r0 = com.bytedance.android.livesdk.coupon.util.a.a;
        com.bytedance.android.livesdk.coupon.expandcoupon.model.a r10 = this.m;
        long r11 = r10.a + r10.d.c();
        r0.getClass();
        r114.setText(com.bytedance.android.livesdk.coupon.util.a.a(r11));
    L45:
        Button r115 = this.f;
        if (r115 == null) goto L51;
        com.bytedance.android.livesdk.coupon.util.a r2 = com.bytedance.android.livesdk.coupon.util.a.a;
        long r20 = this.m.a;
        r2.getClass();
        r115.setText(LiveResUtil.getString(2131916513, new Object[]{com.bytedance.android.livesdk.coupon.util.a.a(r20)}));
        return;
    L51:
        return;
    L14:
        if (this.m.c == 1) goto L49;
    L19:
        SpannableStringBuilder r1 = null;
    L20:
        r16.setText(r1);
        goto L21
    L49:
        r1 = new SpannableStringBuilder();     // Catch: Throwable -> L17
        int r21 = LiveResUtil.getColor(2131107039);     // Catch: Throwable -> L17
        r1.append("观看直播间");     // Catch: Throwable -> L17
        int r22 = r1.length();     // Catch: Throwable -> L17
        r1.append(String.valueOf(this.m.d.a()) + "秒\n");     // Catch: Throwable -> L17
        r1.setSpan(new ForegroundColorSpan(r21), r22, r1.length(), 33);     // Catch: Throwable -> L17
        r1.append("优惠券金额可膨胀至");     // Catch: Throwable -> L17
        int r23 = r1.length();     // Catch: Throwable -> L17
        StringBuilder r24 = new StringBuilder();     // Catch: Throwable -> L17
        com.bytedance.android.livesdk.coupon.util.a r25 = com.bytedance.android.livesdk.coupon.util.a.a;     // Catch: Throwable -> L17
        com.bytedance.android.livesdk.coupon.expandcoupon.model.a r26 = this.m;     // Catch: Throwable -> L17
        long r27 = r26.a + r26.d.c();     // Catch: Throwable -> L17
        r25.getClass();     // Catch: Throwable -> L17
        r24.append(com.bytedance.android.livesdk.coupon.util.a.a(r27));     // Catch: Throwable -> L17
        r24.append("元");     // Catch: Throwable -> L17
        r1.append(r24.toString());     // Catch: Throwable -> L17
        r1.setSpan(new ForegroundColorSpan(r21), r23, r1.length(), 33);     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        ALogger.e("ExpandCouponDialog", "createTimeTaskTitle Error. " + Log.getStackTraceString(th));
        goto L19
    }

    public ExpandCouponEnterRoomDialog(Context r2, com.bytedance.android.livesdk.coupon.expandcoupon.model.a r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "couponData");
        super(r2, 2131954669);
        this.m = r3;
        this.k = new int[]{LiveResUtil.getColor(2131107444), LiveResUtil.getColor(2131107443), LiveResUtil.getColor(2131107442)};
        this.l = new f(this);
    }
}
