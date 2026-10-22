package zs1;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.android.live.core.utils.LiveResUtil;
import com.bytedance.android.livesdk.coupon.balancecoupon.CouponSubType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class e extends Dialog {
    public final View a;

    public interface a {
        void a(com.bytedance.android.livesdk.coupon.balancecoupon.model.a r1);

        void b(com.bytedance.android.livesdk.coupon.balancecoupon.model.a r1);

        void onClose();
    }

    @Override // android.app.Dialog
    public final void onStart() {
        super.onStart();
        com.bytedance.android.livesdk.f.d().a();
    }

    @Override // android.app.Dialog
    public final void onStop() {
        super.onStop();
        com.bytedance.android.livesdk.f.d().f();
    }

    public static String a(long r4) {
        double r5 = r4 / ((double) 100);
        Double r0 = Double.valueOf(r5 % ((double) 1));
        Double r1 = Double.valueOf(0.0d);
        if (r0.equals(r1) == true) goto L9;
        if (Double.valueOf(r5 % ((double) 2)).equals(r1) == true) goto L9;
        return String.valueOf(r5);
    L9:
        return String.valueOf((int) r5);
    }

    public e(Context r11, com.bytedance.android.livesdk.coupon.balancecoupon.model.a r12, i r13) {
        Intrinsics.checkNotNullParameter(r11, "context");
        Intrinsics.checkNotNullParameter(r12, "data");
        Intrinsics.checkNotNullParameter(r13, "callback");
        super(r11, 2131954617);
        Long r1 = null;
        View r14 = LayoutInflater.from(getContext()).inflate(2131565401, null);
        this.a = r14;
        TextView r0 = (TextView) r14.findViewById(2131368119);
        TextView r2 = (TextView) r14.findViewById(2131363847);
        TextView r3 = (TextView) r14.findViewById(2131363849);
        TextView r4 = (TextView) r14.findViewById(2131363851);
        TextView r5 = (TextView) r14.findViewById(2131368061);
        TextView r6 = (TextView) r14.findViewById(2131368114);
        TextView r7 = (TextView) r14.findViewById(2131368112);
        ImageView r8 = (ImageView) r14.findViewById(2131368113);
        ImageView r9 = (ImageView) r14.findViewById(2131368063);
        setContentView(r14);
        r7.setOnClickListener(new zs1.a(r13, r12));
        r8.setOnClickListener(new b(r13, r12));
        r5.setOnClickListener(new c(r13, r12));
        r9.setOnClickListener(new d(r13));
        com.bytedance.android.livesdk.coupon.balancecoupon.model.a.c r15 = r12.d();
        if (r15 == null) goto L20;
        com.bytedance.android.livesdk.coupon.balancecoupon.model.a.d r16 = r15.b();
        if (r16 == null) goto L20;
        String r17 = r16.a();
        if (r17 == null) goto L20;
        if (r17.length() <= 0) goto L11;
        boolean r18 = true;
    L12:
        if (r18 != true) goto L20;
        com.bytedance.android.livesdk.coupon.balancecoupon.model.a.c r19 = r12.d();
        if (r19 == null) goto L18;
        com.bytedance.android.livesdk.coupon.balancecoupon.model.a.d r110 = r19.b();
        if (r110 == null) goto L18;
        String r111 = r110.a();
    L19:
        r0.setText(r111);
    L18:
        r111 = null;
        goto L19
    L11:
        r18 = false;
    L20:
        com.bytedance.android.livesdk.coupon.balancecoupon.model.a.c r112 = r12.d();
        if (r112 == null) goto L25;
        com.bytedance.android.livesdk.coupon.balancecoupon.model.a.b r113 = r112.a();
        if (r113 == null) goto L25;
        String r114 = a(r113.a());
    L26:
        r2.setText(r114);
        com.bytedance.android.livesdk.coupon.balancecoupon.model.a.c r115 = r12.d();
        if (r115 == null) goto L31;
        com.bytedance.android.livesdk.coupon.balancecoupon.model.a.d r116 = r115.b();
        if (r116 == null) goto L31;
        String r117 = a(r116.d());
    L32:
        r3.setText(r117);
        com.bytedance.android.livesdk.coupon.balancecoupon.model.a.c r118 = r12.d();
        if (r118 == null) goto L45;
        com.bytedance.android.livesdk.coupon.balancecoupon.model.a.d r119 = r118.b();
        if (r119 == null) goto L45;
        if (r119.b() != CouponSubType.CouponSubType_FullAmount.getValue()) goto L45;
        Object[] r120 = new Object[1];
        com.bytedance.android.livesdk.coupon.balancecoupon.model.a.c r10 = r12.d();
        if (r10 == null) goto L43;
        com.bytedance.android.livesdk.coupon.balancecoupon.model.a.d r20 = r10.b();
        if (r20 == null) goto L43;
        String r21 = a(r20.e());
    L44:
        r120[0] = r21;
        r4.setText(LiveResUtil.getString(2131915242, r120));
    L46:
        Object[] r121 = new Object[2];
        com.bytedance.android.livesdk.coupon.balancecoupon.model.a.c r22 = r12.d();
        if (r22 == null) goto L51;
        com.bytedance.android.livesdk.coupon.balancecoupon.model.a.b r23 = r22.a();
        if (r23 == null) goto L51;
        String r24 = a(r23.a());
    L52:
        r121[0] = r24;
        com.bytedance.android.livesdk.coupon.balancecoupon.model.a.c r25 = r12.d();
        if (r25 == null) goto L57;
        com.bytedance.android.livesdk.coupon.balancecoupon.model.a.d r26 = r25.b();
        if (r26 == null) goto L57;
        String r27 = a(r26.d());
    L58:
        r121[1] = r27;
        r5.setText(LiveResUtil.getString(2131915243, r121));
        Object[] r122 = new Object[1];
        com.bytedance.android.livesdk.coupon.balancecoupon.model.a.c r123 = r12.d();
        if (r123 == null) goto L63;
        com.bytedance.android.livesdk.coupon.balancecoupon.model.a.d r124 = r123.b();
        if (r124 == null) goto L63;
        r1 = Long.valueOf((long) Math.floor(r124.f() / ((long) 86400)));
    L63:
        r122[0] = r1;
        r6.setText(LiveResUtil.getString(2131915245, r122));
        return;
    L57:
        r27 = null;
    L51:
        r24 = null;
    L43:
        r21 = null;
    L45:
        r4.setText(LiveResUtil.getString(2131915241));
    L31:
        r117 = null;
    L25:
        r114 = null;
        goto L26
    }
}
