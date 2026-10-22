package com.bytedance.android.live.recharge.viewholder;

import android.graphics.Paint;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.LiveTextView;
import com.bytedance.android.live.recharge.deal.f;
import com.bytedance.android.live.recharge.deal.u;
import com.bytedance.android.live.recharge.platform.business.model.diamond.g;
import com.bytedance.android.live.recharge.platform.business.viewholder.AbsRechargeViewHolder;
import com.bytedance.android.live.recharge.platform.business.viewholder.RechargeItem;
import com.bytedance.android.live.recharge.platform.core.ui.DiamondFitTextView;
import com.bytedance.android.live.recharge.platform.core.ui.StrikeThroughText;
import com.bytedance.android.live.recharge.utils.q;
import com.bytedance.android.live.revenue.common.ViewUtilsKt;
import com.bytedance.android.livesdk.utils.r3;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/recharge/viewholder/DealViewHolder;", "Lcom/bytedance/android/live/recharge/platform/business/viewholder/AbsRechargeViewHolder;", "Lcom/bytedance/android/live/recharge/platform/business/viewholder/RechargeItem$a;", "liverecharge-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class DealViewHolder extends AbsRechargeViewHolder<RechargeItem.a> {
    public final TextView b;
    public final DiamondFitTextView c;
    public final TextView d;
    public final StrikeThroughText e;
    public final View f;

    @Override // com.bytedance.android.live.recharge.platform.business.viewholder.AbsRechargeViewHolder
    public final void U3() {
        ((RecyclerView.ViewHolder) this).itemView.setSelected(true);
    }

    @Override // com.bytedance.android.live.recharge.platform.business.viewholder.AbsRechargeViewHolder
    public final void V3() {
        ((RecyclerView.ViewHolder) this).itemView.setSelected(false);
    }

    public DealViewHolder(View r2) {
        Intrinsics.checkNotNullParameter(r2, "itemView");
        super(r2);
        this.b = (TextView) r2.findViewById(2131368819);
        this.c = (DiamondFitTextView) r2.findViewById(2131368992);
        this.d = (TextView) r2.findViewById(2131369138);
        this.e = (StrikeThroughText) r2.findViewById(2131381687);
        this.f = r2.findViewById(2131368999);
    }

    @Override // com.bytedance.android.live.recharge.platform.business.viewholder.AbsRechargeViewHolder
    public final void T3(RechargeItem r9) {
        RechargeItem.a r10 = (RechargeItem.a) r9;
        Intrinsics.checkNotNullParameter(r10, "item");
        Intrinsics.checkNotNullParameter(r10, "item");
        this.a = r10;
        f r12 = r10.a;
        g r0 = com.bytedance.android.live.recharge.deal.g.c(r12);
        if (r0 == null) goto L6;
        String r1 = r0.getDiamondDesc();
        if (r1 == null) goto L6;
    L8:
        if (TextUtils.isEmpty(r1) == true) goto L15;
        TextView r2 = this.b;
        if (r2 == null) goto L12;
        ViewUtilsKt.f(r2);
    L12:
        TextView r3 = this.b;
        if (r3 == null) goto L18;
        r3.setText(r1);
    L18:
        String r4 = r3.b();
        DiamondFitTextView r5 = this.c;
        if (r5 == null) goto L21;
        String r6 = String.valueOf(r12.e());
        r5.f = r6;
        r5.g = r4;
        r5.e = 2131108129;
        r5.z(r6, r5.d, true);
    L21:
        LiveTextView r7 = this.c;
        if (r7 == null) goto L25;
        r7.setTextAlignment(4);
    L25:
        if ((r12 instanceof u) == true) goto L27;
        r12 = null;
    L27:
        u r13 = (u) r12;
        if (r13 == null) goto L63;
        int r8 = r13.i;
        int r14 = r13.j;
        if (r8 <= 0) goto L50;
        if (r8 == r14) goto L50;
        TextView r15 = this.d;
        if (r15 == null) goto L35;
        ViewUtilsKt.f(r15);
    L35:
        TextView r16 = this.d;
        if (r16 == null) goto L38;
        r16.setTextColor(s1.h(2131108133));
    L38:
        TextView r17 = this.d;
        if (r17 == null) goto L41;
        r17.setText(s1.C(2131921889, new Object[]{q.b(r8)}));
    L41:
        StrikeThroughText r18 = this.e;
        if (r18 == null) goto L44;
        r18.setDrawLineEnable(true);
    L44:
        StrikeThroughText r19 = this.e;
        if (r19 == null) goto L47;
        s1.f(0.8f);
        int r20 = s1.h(2131108134);
        Intrinsics.checkNotNullParameter(Paint.Cap.ROUND, "cap");
        r19.b = r20;
        Paint r22 = r19.a;
        r22.setColor(r20);
        r22.setStrokeCap(r22.getStrokeCap());
        r22.setStrokeWidth(r22.getStrokeWidth());
    L47:
        StrikeThroughText r23 = this.e;
        if (r23 == null) goto L59;
        r23.setTextSize(1, 11.0f);
    L59:
        String r24 = q.a(r14);
        AppCompatTextView r25 = this.e;
        if (r25 == null) goto L64;
        r25.setText(s1.C(2131921889, new Object[]{r24}));
        return;
    L64:
        return;
    L50:
        TextView r26 = this.d;
        if (r26 == null) goto L53;
        ViewUtilsKt.e(r26);
    L53:
        StrikeThroughText r27 = this.e;
        if (r27 == null) goto L56;
        r27.setDrawLineEnable(false);
    L56:
        StrikeThroughText r28 = this.e;
        if (r28 == null) goto L59;
        r28.setTextSize(1, 12.0f);
        goto L59
    L63:
        return;
    L15:
        TextView r29 = this.b;
        if (r29 == null) goto L18;
        ViewUtilsKt.e(r29);
    L6:
        r1 = r12.d();
        goto L8
    }
}
