package com.bytedance.android.livesdk.coupon.customview;

import android.app.Dialog;
import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.Html;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.ImageUtil;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.BubbleId;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import io.reactivex.disposables.Disposable;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class UgCouponGoodsNewDialog extends Dialog {
    public final View a;
    public Disposable b;
    public final com.bytedance.android.livesdk.coupon.b c;
    public final dt1.a d;

    public static final class a {
    }

    static {
    }

    public static final void a(UgCouponGoodsNewDialog r3) {
        r3.getClass();
        Handler r0 = DialogLancet.resolveDialogHandler(r3);
        if (r0 != null) goto L5;
    L7:
        DialogLancet.beforeDialogDismiss(r3);
        r3.dismiss();     // Catch: Throwable -> L10 Exception -> L12
    L16:
        DialogLancet.afterDialogDismiss(r3);
    L17:
        dt1.a r1 = r3.d;
        com.bytedance.android.livesdk.coupon.b.C0114b r4 = r3.c.retainWindowInfoV2;
        if (r4 == null) goto L27;
        r1.a(r4);
        return;
    L27:
        return;
    L10:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r3);
        throw th;
    L12:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L10
        Throwable r2 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L10
        if (r2 == null) goto L16;
        com.bytedance.crash.d.d(r2, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L10
        goto L16
    L5:
        if (Looper.myLooper() == r0.getLooper()) goto L7;
        r0.post(DialogLancet.createDismissRunnable(r3));
        goto L17
    }

    public static SpannableString b(com.bytedance.android.livesdk.coupon.b.a r13) {
        UgCouponGoodsNewDialog$createPricingSpannableString$1 r0 = UgCouponGoodsNewDialog$createPricingSpannableString$1.INSTANCE;
        Long r1 = r13.discountPrice;
        if (r1 != null) goto L5;
    L14:
        com.bytedance.android.livesdk.coupon.util.a r2 = com.bytedance.android.livesdk.coupon.util.a.a;
        long r8 = r13.originalPrice;
        r2.getClass();
        String r14 = "￥" + com.bytedance.android.livesdk.coupon.util.a.d(r8);
        SpannableString r10 = new SpannableString(r14);
        r10.setSpan(new ForegroundColorSpan(ColorProtector.parseColor("#FF1C49")), 0, r14.length(), 17);
        r10.setSpan(new StyleSpan(1), 0, r14.length(), 17);
        Pair<Integer, Integer> r3 = r0.invoke(r14, "￥");
        if (r3 == null) goto L17;
        int r4 = ((Number) r3.component1()).intValue();
        int r5 = ((Number) r3.component2()).intValue();
        r10.setSpan(new RelativeSizeSpan(11.0f), r4, r5, 17);
        r10.setSpan(new RelativeSizeSpan(18.0f), r5, r14.length(), 17);
    L17:
        return r10;
    L5:
        if (r1.longValue() <= 0) goto L14;
        StringBuilder r9 = new StringBuilder("￥");
        com.bytedance.android.livesdk.coupon.util.a r11 = com.bytedance.android.livesdk.coupon.util.a.a;
        long r12 = r1.longValue();
        r11.getClass();
        r9.append(com.bytedance.android.livesdk.coupon.util.a.d(r12));
        String r6 = r9.toString();
        String r15 = "￥" + com.bytedance.android.livesdk.coupon.util.a.d(r13.originalPrice);
        String r16 = r6 + ' ' + r15;
        r10 = new SpannableString(r6 + ' ' + r15);
        Pair<Integer, Integer> r17 = r0.invoke(r16, r6);
        if (r17 == null) goto L11;
        int r18 = ((Number) r17.component1()).intValue();
        int r19 = ((Number) r17.component2()).intValue();
        r10.setSpan(new ForegroundColorSpan(ColorProtector.parseColor("#FF1C49")), r18, r19, 17);
        r10.setSpan(new StyleSpan(1), r18, r19, 17);
        Pair<Integer, Integer> r7 = r0.invoke(r6, "￥");
        if (r7 == null) goto L11;
        int r20 = ((Number) r7.component1()).intValue();
        int r21 = r20 + r18;
        int r110 = r18 + ((Number) r7.component2()).intValue();
        r10.setSpan(new RelativeSizeSpan(11.0f), r21, r110, 17);
        r10.setSpan(new RelativeSizeSpan(18.0f), r110, r19, 17);
    L11:
        Pair<Integer, Integer> r111 = r0.invoke(r16, r15);
        if (r111 == null) goto L17;
        int r22 = ((Number) r111.component1()).intValue();
        int r112 = ((Number) r111.component2()).intValue();
        r10.setSpan(new ForegroundColorSpan(ColorProtector.parseColor("#99161823")), r22, r112, 17);
        r10.setSpan(new RelativeSizeSpan(12.0f), r22, r112, 17);
        r10.setSpan(new StrikethroughSpan(), r22, r112, 17);
        goto L17
    }

    public UgCouponGoodsNewDialog(Context r9, com.bytedance.android.livesdk.coupon.b r10, com.bytedance.android.livesdk.coupon.h r11) {
        Intrinsics.checkNotNullParameter(r9, "context");
        Intrinsics.checkNotNullParameter(r10, "ugCouponResponse");
        Intrinsics.checkNotNullParameter(r11, "callback");
        super(r9, 2131954829);
        this.c = r10;
        this.d = r11;
        View r12 = LayoutInflater.from(r9).inflate(2131565443, null);
        this.a = r12;
        setContentView(r12);
        com.bytedance.android.livesdk.coupon.b.C0114b r13 = r10.retainWindowInfoV2;
        if (r13 == null) goto L11;
        String r14 = r13.title;
        if (r14 == null) goto L11;
        TextView r0 = (TextView) findViewById(2131390439);
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
        String r1 = r16.expireSuffixText;
        if (r1 == null) goto L26;
        long r2 = r16.countdownTime * ((long) BubbleId.PadCast);
        if (r1.length() != 0) goto L19;
        boolean r17 = true;
    L20:
        if (r17 == false) goto L22;
    L25:
        ALogger.d("UgCouponGoodsNewDialog", "initCountDown skip, expireSuffixText=" + r1 + " expireTime=" + r2);
        ((TextView) findViewById(2131390438)).setText("");
        goto L26
    L22:
        if (r2 == 0) goto L25;
        this.b = du2.a.b(0, 1, TimeUnit.SECONDS).compose(RxUtil.rxSchedulerHelper()).subscribe(new com.bytedance.android.livesdk.coupon.customview.a(this, r2, r1), b.a);
        goto L26
    L19:
        r17 = false;
    L26:
        com.bytedance.android.livesdk.coupon.b.C0114b r18 = r10.retainWindowInfoV2;
        if (r18 == null) goto L50;
        List<com.bytedance.android.livesdk.coupon.b.a> r19 = r18.productInfoList;
        if (r19 == null) goto L50;
        com.bytedance.android.livesdk.coupon.b.a r20 = (com.bytedance.android.livesdk.coupon.b.a) CollectionsKt.getOrNull(r19, 0);
        if (r20 == null) goto L50;
        ImageModel r3 = r20.image;
        if (r3 == null) goto L35;
        ImageUtil.loadImageWithRadius(findViewById(2131376154), r3, 2131249057, 8);
    L35:
        String r4 = r20.title;
        if (r4 == null) goto L38;
        ((TextView) findViewById(2131390433)).setText(r4);
    L38:
        ((TextView) findViewById(2131390432)).setText(b(r20));
        View r21 = findViewById(2131364126);
        if (r21 == null) goto L41;
        r21.setOnClickListener(new g(new UgCouponGoodsNewDialog$initGoods1$1$3(this)));
    L41:
        View r22 = findViewById(2131376154);
        if (r22 == null) goto L44;
        r22.setOnClickListener(new g(new UgCouponGoodsNewDialog$initGoods1$1$4(this)));
    L44:
        View r23 = findViewById(2131390433);
        if (r23 == null) goto L47;
        r23.setOnClickListener(new g(new UgCouponGoodsNewDialog$initGoods1$1$5(this)));
    L47:
        View r24 = findViewById(2131390432);
        if (r24 == null) goto L50;
        r24.setOnClickListener(new g(new UgCouponGoodsNewDialog$initGoods1$1$6(this)));
    L50:
        com.bytedance.android.livesdk.coupon.b.C0114b r25 = r10.retainWindowInfoV2;
        if (r25 == null) goto L74;
        List<com.bytedance.android.livesdk.coupon.b.a> r26 = r25.productInfoList;
        if (r26 == null) goto L74;
        com.bytedance.android.livesdk.coupon.b.a r27 = (com.bytedance.android.livesdk.coupon.b.a) CollectionsKt.getOrNull(r26, 1);
        if (r27 == null) goto L74;
        ImageModel r5 = r27.image;
        if (r5 == null) goto L59;
        ImageUtil.loadImageWithRadius(findViewById(2131376155), r5, 2131249057, 8);
    L59:
        String r6 = r27.title;
        if (r6 == null) goto L62;
        ((TextView) findViewById(2131390435)).setText(r6);
    L62:
        ((TextView) findViewById(2131390434)).setText(b(r27));
        View r28 = findViewById(2131364127);
        if (r28 == null) goto L65;
        r28.setOnClickListener(new g(new UgCouponGoodsNewDialog$initGoods2$1$3(this)));
    L65:
        View r29 = findViewById(2131376155);
        if (r29 == null) goto L68;
        r29.setOnClickListener(new g(new UgCouponGoodsNewDialog$initGoods2$1$4(this)));
    L68:
        View r30 = findViewById(2131390435);
        if (r30 == null) goto L71;
        r30.setOnClickListener(new g(new UgCouponGoodsNewDialog$initGoods2$1$5(this)));
    L71:
        View r31 = findViewById(2131390434);
        if (r31 == null) goto L74;
        r31.setOnClickListener(new g(new UgCouponGoodsNewDialog$initGoods2$1$6(this)));
    L74:
        com.bytedance.android.livesdk.coupon.b.C0114b r32 = r10.retainWindowInfoV2;
        if (r32 == null) goto L98;
        List<com.bytedance.android.livesdk.coupon.b.a> r33 = r32.productInfoList;
        if (r33 == null) goto L98;
        com.bytedance.android.livesdk.coupon.b.a r34 = (com.bytedance.android.livesdk.coupon.b.a) CollectionsKt.getOrNull(r33, 2);
        if (r34 == null) goto L98;
        ImageModel r7 = r34.image;
        if (r7 == null) goto L83;
        ImageUtil.loadImageWithRadius(findViewById(2131376156), r7, 2131249057, 8);
    L83:
        String r8 = r34.title;
        if (r8 == null) goto L86;
        ((TextView) findViewById(2131390437)).setText(r8);
    L86:
        ((TextView) findViewById(2131390436)).setText(b(r34));
        View r35 = findViewById(2131364128);
        if (r35 == null) goto L89;
        r35.setOnClickListener(new g(new UgCouponGoodsNewDialog$initGoods3$1$3(this)));
    L89:
        View r36 = findViewById(2131376156);
        if (r36 == null) goto L92;
        r36.setOnClickListener(new g(new UgCouponGoodsNewDialog$initGoods3$1$4(this)));
    L92:
        View r37 = findViewById(2131390437);
        if (r37 == null) goto L95;
        r37.setOnClickListener(new g(new UgCouponGoodsNewDialog$initGoods3$1$5(this)));
    L95:
        View r38 = findViewById(2131390436);
        if (r38 == null) goto L98;
        r38.setOnClickListener(new g(new UgCouponGoodsNewDialog$initGoods3$1$6(this)));
    L98:
        com.bytedance.android.livesdk.coupon.b.C0114b r39 = r10.retainWindowInfoV2;
        if (r39 == null) goto L103;
        String r40 = r39.buttonText;
        if (r40 == null) goto L103;
        ((TextView) findViewById(2131390441)).setText(r40);
    L103:
        View r41 = findViewById(2131390441);
        if (r41 == null) goto L106;
        r41.setOnClickListener(new g(new UgCouponGoodsNewDialog$initPositiveButton$2(this)));
    L106:
        com.bytedance.android.livesdk.coupon.b.C0114b r42 = r10.retainWindowInfoV2;
        if (r42 == null) goto L111;
        String r43 = r42.cancelText;
        if (r43 == null) goto L111;
        ((TextView) findViewById(2131390440)).setText(r43);
    L111:
        View r44 = findViewById(2131390440);
        if (r44 == null) goto L114;
        r44.setOnClickListener(new c(this));
    L114:
        View r45 = findViewById(2131376109);
        if (r45 == null) goto L117;
        r45.setOnClickListener(new d(this));
    L117:
        setCanceledOnTouchOutside(false);
        setOnCancelListener(new e(this));
        setOnDismissListener(new f(this));
    }
}
