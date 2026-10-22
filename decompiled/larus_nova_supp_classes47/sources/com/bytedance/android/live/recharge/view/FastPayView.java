package com.bytedance.android.live.recharge.view;

import am2.x;
import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.android.live.core.arch.mvvm.PropertyOwner;
import com.bytedance.android.live.recharge.RechargeDialogContext;
import com.bytedance.android.live.recharge.a0;
import com.bytedance.android.live.recharge.deal.f;
import com.bytedance.android.live.recharge.model.d;
import com.bytedance.android.live.recharge.order.Order;
import com.bytedance.android.live.recharge.platform.business.model.diamond.a;
import com.bytedance.android.live.recharge.platform.business.model.diamond.g;
import com.bytedance.android.live.recharge.service.e;
import com.bytedance.android.live.recharge.utils.m;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.live.datacontext.n;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import rw0.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010G\u001a\u00020F¢\u0006\u0004\bH\u0010IB\u001b\b\u0016\u0012\u0006\u0010G\u001a\u00020F\u0012\b\u0010K\u001a\u0004\u0018\u00010J¢\u0006\u0004\bH\u0010LB#\b\u0016\u0012\u0006\u0010G\u001a\u00020F\u0012\b\u0010K\u001a\u0004\u0018\u00010J\u0012\u0006\u0010N\u001a\u00020M¢\u0006\u0004\bH\u0010OR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\r\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u0004\u001a\u0004\b\u000b\u0010\u0006\"\u0004\b\f\u0010\bR$\u0010\u0015\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R$\u0010\u001d\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\"\u0010%\u001a\u00020\u001e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R$\u0010-\u001a\u0004\u0018\u00010&8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R$\u00101\u001a\u0004\u0018\u00010&8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b.\u0010(\u001a\u0004\b/\u0010*\"\u0004\b0\u0010,R$\u00109\u001a\u0004\u0018\u0001028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b3\u00104\u001a\u0004\b5\u00106\"\u0004\b7\u00108R$\u0010=\u001a\u0004\u0018\u00010&8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b:\u0010(\u001a\u0004\b;\u0010*\"\u0004\b<\u0010,R.\u0010E\u001a\u000e\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020&0>8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b?\u0010@\u001a\u0004\bA\u0010B\"\u0004\bC\u0010D¨\u0006P"}, d2 = {"Lcom/bytedance/android/live/recharge/view/FastPayView;", "Landroid/widget/FrameLayout;", "Landroid/widget/TextView;", "a", "Landroid/widget/TextView;", "getMFastMsg", "()Landroid/widget/TextView;", "setMFastMsg", "(Landroid/widget/TextView;)V", "mFastMsg", "b", "getMFastOtherPayHint", "setMFastOtherPayHint", "mFastOtherPayHint", "Landroid/widget/ImageView;", "c", "Landroid/widget/ImageView;", "getMFastOtherPayArrow", "()Landroid/widget/ImageView;", "setMFastOtherPayArrow", "(Landroid/widget/ImageView;)V", "mFastOtherPayArrow", "Landroid/app/Activity;", "d", "Landroid/app/Activity;", "getMActivity", "()Landroid/app/Activity;", "setMActivity", "(Landroid/app/Activity;)V", "mActivity", "", "e", "J", "getMRoomId", "()J", "setMRoomId", "(J)V", "mRoomId", "", "f", "Ljava/lang/String;", "getMRequestPage", "()Ljava/lang/String;", "setMRequestPage", "(Ljava/lang/String;)V", "mRequestPage", "g", "getMChargeScene", "setMChargeScene", "mChargeScene", "Lcom/bytedance/android/live/recharge/deal/f;", "i", "Lcom/bytedance/android/live/recharge/deal/f;", "getMChargeDeal", "()Lcom/bytedance/android/live/recharge/deal/f;", "setMChargeDeal", "(Lcom/bytedance/android/live/recharge/deal/f;)V", "mChargeDeal", "j", "getMChargeReason", "setMChargeReason", "mChargeReason", "Ljava/util/HashMap;", "k", "Ljava/util/HashMap;", "getMExtraData", "()Ljava/util/HashMap;", "setMExtraData", "(Ljava/util/HashMap;)V", "mExtraData", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "liverecharge-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class FastPayView extends FrameLayout {
    public TextView a;
    public TextView b;
    public ImageView c;
    public Activity d;
    public long e;
    public String f;
    public String g;
    public RechargeDialogContext h;
    public f i;
    public String j;
    public HashMap<String, String> k;

    public final void b() {
        View r0 = FrameLayout.inflate(getContext(), 2131567262, this);
        this.a = (TextView) r0.findViewById(2131372169);
        this.b = (TextView) r0.findViewById(2131372170);
        this.c = (ImageView) r0.findViewById(2131372171);
    }

    public final Activity getMActivity() {
        return this.d;
    }

    public final f getMChargeDeal() {
        return this.i;
    }

    public final String getMChargeReason() {
        return this.j;
    }

    public final String getMChargeScene() {
        return this.g;
    }

    public final HashMap<String, String> getMExtraData() {
        return this.k;
    }

    public final TextView getMFastMsg() {
        return this.a;
    }

    public final ImageView getMFastOtherPayArrow() {
        return this.c;
    }

    public final TextView getMFastOtherPayHint() {
        return this.b;
    }

    public final String getMRequestPage() {
        return this.f;
    }

    public final long getMRoomId() {
        return this.e;
    }

    public FastPayView(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        this.f = "";
        this.g = "";
        this.k = new HashMap();
        b();
    }

    public static final void a(FastPayView r14) {
        Activity r0 = r14.d;
        f r1 = r14.i;
        if (r0 == null) goto L54;
        if (r1 == null) goto L55;
        g r2 = com.bytedance.android.live.recharge.deal.g.c(r1);
        HashMap<String, String> r3 = r14.k;
        if (r2 == null) goto L9;
        String r4 = r2.getDiamondDesc();
        if (r4 == null) goto L9;
    L10:
        r3.put("giving_diamond_badge", r4);
        HashMap<String, String> r5 = r14.k;
        String r6 = "";
        if (r2 == null) goto L16;
        a r7 = r2.getCouponBarInfo();
        if (r7 == null) goto L16;
        String r8 = r7.getDesc();
        if (r8 == null) goto L16;
    L17:
        r5.put("giving_diamond_bar", r8);
        HashMap<String, String> r9 = r14.k;
        if (r2 == null) goto L23;
        String r10 = r2.getPreCalcInfo();
        if (r10 == null) goto L23;
        r6 = r10;
    L23:
        r9.put("pre_calc_info", r6);
        Context r12 = r14.getContext();
        HashMap<String, String> r13 = r14.k;
        RechargeDialogContext r15 = r14.h;
        if (r15 == null) goto L26;
        d r16 = r15.getMDialogEntranceParams();
    L27:
        d r17 = r16;
        RechargeDialogContext r18 = r14.h;
        if (r18 == null) goto L36;
        a0 r19 = r18.getRepository();
        if (r19 == null) goto L36;
        PropertyOwner r20 = r19.c;
        if (r20 == null) goto L36;
        Long r22 = (Long) r20.a;
        if (r22 == null) goto L36;
        long r23 = r22.longValue();
    L37:
        Order r24 = e.b(r1, r12, r13, r17, false, 0, false, false, r23, null, null, 7920);
        RechargeDialogContext r25 = r14.h;
        if (r25 == null) goto L42;
        n<Order> r26 = r25.getOrder();
        if (r26 == null) goto L42;
        r26.setValue(r24);
    L42:
        HashMap r27 = new HashMap();
        int r28 = m.a;
        RechargeDialogContext r29 = r14.h;
        if (r29 == null) goto L46;
        d r30 = r29.getMDialogEntranceParams();
        if (r30 == null) goto L46;
    L47:
        m.b(r27, r30, new Object[]{b.class});
        RechargeDialogContext r110 = r14.h;
        if (r110 == null) goto L51;
        Map<String, String> r111 = r110.getReportExtraInfo("livesdk_recharge_page_pay_click");
        if (r111 == null) goto L51;
    L52:
        r27.putAll(r111);
        HashMap<Class<?>, com.bytedance.android.livesdk.revenue.log.d<?>> r112 = com.bytedance.android.live.recharge.utils.f.a;
        com.bytedance.android.live.recharge.utils.f.d("livesdk_rd_fast_pay_other_click", r27, new Class[]{IRoom.class, x.class});
        return;
    L51:
        r111 = MapsKt.emptyMap();
    L46:
        r30 = d.p;
    L36:
        r23 = -1;
        goto L37
    L26:
        r16 = null;
    L16:
        r8 = "";
    L9:
        r4 = r1.d();
        goto L10
    L55:
        return;
    }

    public final void setMActivity(Activity r1) {
        this.d = r1;
    }

    public final void setMChargeDeal(f r1) {
        this.i = r1;
    }

    public final void setMChargeReason(String r1) {
        this.j = r1;
    }

    public final void setMChargeScene(String r1) {
        this.g = r1;
    }

    public final void setMExtraData(HashMap<String, String> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.k = r2;
    }

    public final void setMFastMsg(TextView r1) {
        this.a = r1;
    }

    public final void setMFastOtherPayArrow(ImageView r1) {
        this.c = r1;
    }

    public final void setMFastOtherPayHint(TextView r1) {
        this.b = r1;
    }

    public final void setMRequestPage(String r1) {
        this.f = r1;
    }

    public final void setMRoomId(long r1) {
        this.e = r1;
    }

    public FastPayView(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3);
        this.f = "";
        this.g = "";
        this.k = new HashMap();
        b();
    }

    public FastPayView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.f = "";
        this.g = "";
        this.k = new HashMap();
        b();
    }
}
