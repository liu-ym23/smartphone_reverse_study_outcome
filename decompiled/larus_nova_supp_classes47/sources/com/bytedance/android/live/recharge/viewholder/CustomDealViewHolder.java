package com.bytedance.android.live.recharge.viewholder;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.LiveTextView;
import com.bytedance.android.live.recharge.platform.business.viewholder.AbsRechargeViewHolder;
import com.bytedance.android.live.recharge.platform.business.viewholder.RechargeItem;
import com.bytedance.android.live.recharge.platform.core.ui.DiamondFitTextView;
import com.bytedance.android.live.recharge.utils.q;
import com.bytedance.android.live.revenue.common.ViewUtilsKt;
import com.bytedance.android.livesdk.utils.r3;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/recharge/viewholder/CustomDealViewHolder;", "Lcom/bytedance/android/live/recharge/platform/business/viewholder/AbsRechargeViewHolder;", "Lcom/bytedance/android/live/recharge/platform/business/viewholder/RechargeItem$CustomItem;", "liverecharge-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class CustomDealViewHolder extends AbsRechargeViewHolder<RechargeItem.CustomItem> {
    public final TextView b;
    public final DiamondFitTextView c;
    public final TextView d;
    public final ViewGroup e;
    public final TextView f;
    public final TextView g;
    public final ViewGroup h;

    @Override // com.bytedance.android.live.recharge.platform.business.viewholder.AbsRechargeViewHolder
    public final void U3() {
        ((RecyclerView.ViewHolder) this).itemView.setSelected(true);
    }

    @Override // com.bytedance.android.live.recharge.platform.business.viewholder.AbsRechargeViewHolder
    public final void V3() {
        ((RecyclerView.ViewHolder) this).itemView.setSelected(false);
        RechargeItem.CustomItem r0 = (RechargeItem.CustomItem) this.a;
        if (r0 == null) goto L6;
        r0.a = 0;
        r0.c = "";
        r0.d = RechargeItem.CustomItem.Mode.INPUT;
        W3(r0);
        return;
    }

    public CustomDealViewHolder(View r2) {
        Intrinsics.checkNotNullParameter(r2, "itemView");
        super(r2);
        this.b = (TextView) r2.findViewById(2131368819);
        this.c = (DiamondFitTextView) r2.findViewById(2131368992);
        this.d = (TextView) r2.findViewById(2131382997);
        this.e = (ViewGroup) r2.findViewById(2131368999);
        this.f = (TextView) r2.findViewById(2131368371);
        this.g = (TextView) r2.findViewById(2131368373);
        this.h = (ViewGroup) r2.findViewById(2131368372);
    }

    @Override // com.bytedance.android.live.recharge.platform.business.viewholder.AbsRechargeViewHolder
    public final void T3(RechargeItem r8) {
        RechargeItem.CustomItem r9 = (RechargeItem.CustomItem) r8;
        Intrinsics.checkNotNullParameter(r9, "item");
        Intrinsics.checkNotNullParameter(r9, "item");
        this.a = r9;
        if (r9.d != RechargeItem.CustomItem.Mode.DIAMOND) goto L33;
        ViewGroup r0 = this.e;
        if (r0 == null) goto L7;
        ViewUtilsKt.f(r0);
    L7:
        ViewGroup r1 = this.h;
        if (r1 == null) goto L10;
        ViewUtilsKt.e(r1);
    L10:
        String r2 = r9.c;
        if (TextUtils.isEmpty(r2) == true) goto L18;
        TextView r3 = this.b;
        if (r3 == null) goto L15;
        ViewUtilsKt.f(r3);
    L15:
        TextView r4 = this.b;
        if (r4 == null) goto L21;
        r4.setText(r2);
    L21:
        String r5 = r3.b();
        DiamondFitTextView r6 = this.c;
        if (r6 == null) goto L24;
        String r7 = String.valueOf(r9.a / 10);
        r6.f = r7;
        r6.g = r5;
        r6.e = 2131108129;
        r6.z(r7, r6.d, true);
    L24:
        LiveTextView r10 = this.c;
        if (r10 == null) goto L27;
        r10.setTextAlignment(4);
    L27:
        TextView r12 = this.d;
        if (r12 == null) goto L30;
        r12.setTextSize(1, 12.0f);
    L30:
        String r13 = q.a(r9.a);
        TextView r14 = this.d;
        if (r14 == null) goto L35;
        r14.setText(s1.C(2131921889, new Object[]{r13}));
        return;
    L35:
        return;
    L18:
        TextView r15 = this.b;
        if (r15 == null) goto L21;
        ViewUtilsKt.e(r15);
        goto L21
    L33:
        W3(r9);
    }

    public final void W3(RechargeItem.CustomItem r5) {
        ViewGroup r0 = this.h;
        if (r0 == null) goto L5;
        ViewUtilsKt.f(r0);
    L5:
        ViewGroup r1 = this.e;
        if (r1 == null) goto L8;
        ViewUtilsKt.e(r1);
    L8:
        String r2 = r5.c;
        if (TextUtils.isEmpty(r2) == true) goto L16;
        TextView r3 = this.b;
        if (r3 == null) goto L13;
        ViewUtilsKt.f(r3);
    L13:
        TextView r4 = this.b;
        if (r4 == null) goto L19;
        r4.setText(r2);
    L19:
        TextView r6 = this.f;
        if (r6 == null) goto L22;
        r6.setText(s1.B(2131917444));
    L22:
        long r7 = r5.b;
        if (r7 <= 0) goto L30;
        TextView r8 = this.g;
        if (r8 == null) goto L27;
        ViewUtilsKt.f(r8);
    L27:
        TextView r9 = this.g;
        if (r9 == null) goto L34;
        r9.setText(s1.C(2131918949, new Object[]{Integer.valueOf((int) (r7 / 100.0f))}));
        return;
    L34:
        return;
    L30:
        TextView r10 = this.g;
        if (r10 == null) goto L36;
        ViewUtilsKt.e(r10);
        return;
    L36:
        return;
    L16:
        TextView r12 = this.b;
        if (r12 == null) goto L19;
        ViewUtilsKt.e(r12);
        goto L19
    }
}
