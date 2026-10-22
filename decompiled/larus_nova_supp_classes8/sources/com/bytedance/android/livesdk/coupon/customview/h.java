package com.bytedance.android.livesdk.coupon.customview;

import android.app.Dialog;
import android.content.Context;
import android.os.Build;
import android.text.Html;
import android.text.Spanned;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.BubbleId;
import io.reactivex.disposables.Disposable;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class h extends Dialog {
    public final View a;
    public Disposable b;
    public final com.bytedance.android.livesdk.coupon.b c;
    public final dt1.a d;

    public static final class a {
    }

    static {
    }

    public h(Context r9, com.bytedance.android.livesdk.coupon.b r10, com.bytedance.android.livesdk.coupon.g r11) {
        Intrinsics.checkNotNullParameter(r9, "context");
        Intrinsics.checkNotNullParameter(r10, "ugCouponResponse");
        Intrinsics.checkNotNullParameter(r11, "callback");
        super(r9, 2131954829);
        this.c = r10;
        this.d = r11;
        View r12 = LayoutInflater.from(r9).inflate(2131565444, null);
        this.a = r12;
        setContentView(r12);
        com.bytedance.android.livesdk.coupon.b.C0114b r13 = r10.retainWindowInfoV2;
        if (r13 == null) goto L11;
        String r14 = r13.title;
        if (r14 == null) goto L11;
        TextView r0 = (TextView) findViewById(2131390431);
        if (Build.VERSION.SDK_INT < 24) goto L9;
        Spanned r15 = Html.fromHtml(r14, 0);
    L10:
        r0.setText(r15);
        goto L11
    L9:
        r15 = Html.fromHtml(r14);
    L11:
        com.bytedance.android.livesdk.coupon.b.C0114b r16 = r10.retainWindowInfoV2;
        if (r16 == null) goto L26;
        String r3 = r16.expireSuffixText;
        if (r3 == null) goto L26;
        long r4 = r16.countdownTime * ((long) BubbleId.PadCast);
        if (r3.length() != 0) goto L19;
        boolean r17 = true;
    L20:
        if (r17 == false) goto L22;
    L25:
        ALogger.d("UgCouponOnlyNewDialog", "initCountDown skip, expireSuffixText=" + r3 + " expireTime=" + r4);
        ((TextView) findViewById(2131390430)).setText("");
        goto L26
    L22:
        if (r4 == 0) goto L25;
        this.b = du2.a.b(0, 1000, TimeUnit.MILLISECONDS).compose(RxUtil.rxSchedulerHelper()).subscribe(new i(this, r4, r3), j.a);
        goto L26
    L19:
        r17 = false;
    L26:
        com.bytedance.android.livesdk.coupon.b.C0114b r18 = r10.retainWindowInfoV2;
        if (r18 == null) goto L31;
        com.bytedance.android.livesdk.coupon.b.c r19 = r18.couponData;
        if (r19 == null) goto L31;
        long r5 = r19.credit;
        TextView r20 = (TextView) findViewById(2131390443);
        com.bytedance.android.livesdk.coupon.util.a.a.getClass();
        r20.setText(com.bytedance.android.livesdk.coupon.util.a.c(r5));
    L31:
        com.bytedance.android.livesdk.coupon.b.C0114b r21 = r10.retainWindowInfoV2;
        if (r21 == null) goto L49;
        com.bytedance.android.livesdk.coupon.b.c r22 = r21.couponData;
        if (r22 == null) goto L49;
        String r6 = r22.discountInfoDesc;
        if (r6 != null) goto L38;
    L41:
        boolean r7 = true;
    L43:
        if (r7 == true) goto L45;
        ((TextView) findViewById(2131390444)).setText(r22.discountInfoDesc);
        goto L49
    L45:
        long r8 = r22.threshold;
        if (r8 > 0) goto L48;
        ((TextView) findViewById(2131390444)).setText(getContext().getString(2131916075));
        goto L49
    L48:
        com.bytedance.android.livesdk.coupon.util.a.a.getClass();
        ((TextView) findViewById(2131390444)).setText(getContext().getString(2131916076, new Object[]{com.bytedance.android.livesdk.coupon.util.a.c(r8)}));
        goto L49
    L38:
        if (r6.length() == 0) goto L41;
        r7 = false;
    L49:
        com.bytedance.android.livesdk.coupon.b.C0114b r23 = r10.retainWindowInfoV2;
        if (r23 == null) goto L56;
        com.bytedance.android.livesdk.coupon.b.c r24 = r23.couponData;
        if (r24 == null) goto L56;
        String r25 = r24.title;
        if (r25 == null) goto L56;
        ((TextView) findViewById(2131390428)).setText(r25);
    L56:
        com.bytedance.android.livesdk.coupon.b.C0114b r26 = r10.retainWindowInfoV2;
        if (r26 == null) goto L63;
        com.bytedance.android.livesdk.coupon.b.c r27 = r26.couponData;
        if (r27 == null) goto L63;
        String r28 = r27.description;
        if (r28 == null) goto L63;
        ((TextView) findViewById(2131390453)).setText(r28);
    L63:
        com.bytedance.android.livesdk.coupon.b.C0114b r29 = r10.retainWindowInfoV2;
        if (r29 == null) goto L68;
        String r30 = r29.buttonText;
        if (r30 == null) goto L68;
        ((TextView) findViewById(2131390441)).setText(r30);
    L68:
        findViewById(2131390441).setOnClickListener(new l(this));
        com.bytedance.android.livesdk.coupon.b.C0114b r31 = r10.retainWindowInfoV2;
        if (r31 == null) goto L73;
        String r32 = r31.cancelText;
        if (r32 == null) goto L73;
        ((TextView) findViewById(2131390440)).setText(r32);
    L73:
        findViewById(2131390440).setOnClickListener(new k(this));
        findViewById(2131376109).setOnClickListener(new m(this));
        setCanceledOnTouchOutside(false);
        setOnCancelListener(new n(this));
        setOnDismissListener(new o(this));
        Window r33 = getWindow();
        if (r33 == null) goto L77;
        r33.setLayout(ov2.c.b(getContext(), 280.0f), ov2.c.b(getContext(), 283.0f));
        return;
    }
}
