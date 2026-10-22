package com.bytedance.android.live.recharge.view;

import am2.x;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.incentive.exchange.i;
import com.bytedance.android.live.recharge.utils.f;
import com.bytedance.android.live.recharge.utils.j;
import com.bytedance.android.live.recharge.utils.q;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import zz0.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0002\t\u0011B\u0011\b\u0016\u0012\u0006\u0010<\u001a\u00020;¢\u0006\u0004\b=\u0010>B\u001b\b\u0016\u0012\u0006\u0010<\u001a\u00020;\u0012\b\u0010@\u001a\u0004\u0018\u00010?¢\u0006\u0004\b=\u0010AB#\b\u0016\u0012\u0006\u0010<\u001a\u00020;\u0012\b\u0010@\u001a\u0004\u0018\u00010?\u0012\u0006\u0010C\u001a\u00020B¢\u0006\u0004\b=\u0010DJ\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004R$\u0010\u000f\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR$\u0010\u0017\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R$\u0010\u001b\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0012\u001a\u0004\b\u0019\u0010\u0014\"\u0004\b\u001a\u0010\u0016R$\u0010\u001f\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\n\u001a\u0004\b\u001d\u0010\f\"\u0004\b\u001e\u0010\u000eR$\u0010'\u001a\u0004\u0018\u00010 8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R$\u0010.\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R$\u00106\u001a\u0004\u0018\u00010/8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b0\u00101\u001a\u0004\b2\u00103\"\u0004\b4\u00105R$\u0010:\u001a\u0004\u0018\u00010/8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b7\u00101\u001a\u0004\b8\u00103\"\u0004\b9\u00105¨\u0006E"}, d2 = {"Lcom/bytedance/android/live/recharge/view/BalanceExchangeView;", "Landroid/widget/FrameLayout;", "", "getSelectStatus", "Lcom/bytedance/android/live/recharge/view/BalanceExchangeView$b;", "listener", "", "setOnSelectListener", "Landroid/widget/TextView;", "a", "Landroid/widget/TextView;", "getMBalanceExchangeText", "()Landroid/widget/TextView;", "setMBalanceExchangeText", "(Landroid/widget/TextView;)V", "mBalanceExchangeText", "Landroid/widget/ImageView;", "b", "Landroid/widget/ImageView;", "getMBalanceExchangeHintIcon", "()Landroid/widget/ImageView;", "setMBalanceExchangeHintIcon", "(Landroid/widget/ImageView;)V", "mBalanceExchangeHintIcon", "c", "getMBalanceExchangeSelectIcon", "setMBalanceExchangeSelectIcon", "mBalanceExchangeSelectIcon", "d", "getMCustomBalanceExchangeTip", "setMCustomBalanceExchangeTip", "mCustomBalanceExchangeTip", "Landroid/view/View;", "e", "Landroid/view/View;", "getMBalanceExchangeLayout", "()Landroid/view/View;", "setMBalanceExchangeLayout", "(Landroid/view/View;)V", "mBalanceExchangeLayout", "f", "Lcom/bytedance/android/live/recharge/view/BalanceExchangeView$b;", "getMOnSelectListener", "()Lcom/bytedance/android/live/recharge/view/BalanceExchangeView$b;", "setMOnSelectListener", "(Lcom/bytedance/android/live/recharge/view/BalanceExchangeView$b;)V", "mOnSelectListener", "", "g", "Ljava/lang/String;", "getMRequestPage", "()Ljava/lang/String;", "setMRequestPage", "(Ljava/lang/String;)V", "mRequestPage", "h", "getMChargeReason", "setMChargeReason", "mChargeReason", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "liverecharge-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class BalanceExchangeView extends FrameLayout {
    public TextView a;
    public ImageView b;
    public ImageView c;
    public TextView d;
    public View e;
    public b f;
    public String g;
    public String h;

    public static final class a {
    }

    public interface b {
        void a(boolean r1);
    }

    public static final class c implements View.OnClickListener {
        public final /* synthetic */ BalanceExchangeView a;

        public c(BalanceExchangeView r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r5) {
            HashMap r6 = new HashMap();
            String r0 = this.a.getMRequestPage();
            if (r0 == null) goto L5;
            String r1 = (String) r6.put("request_page", r0);
        L5:
            String r2 = this.a.getMChargeReason();
            if (r2 == null) goto L8;
            r6.put("charge_reason", r2);
        L8:
            HashMap<Class<?>, com.bytedance.android.livesdk.revenue.log.d<?>> r3 = f.a;
            f.d("livesdk_deduction_explanation_popup_show", r6, new Class[]{IRoom.class, x.class});
            BalanceExchangeView r7 = this.a;
            r7.getClass();
            if (i.a() == false) goto L11;
            String r4 = (String) j.t.getValue(null, j.a[17]);
        L12:
            ((g) com.bytedance.android.live.revenue.core.util.f.a(g.class)).S2(r7.getContext(), r4);
            return;
        L11:
            r4 = (String) j.s.getValue(null, j.a[16]);
            goto L12
        }
    }

    public static final class d implements View.OnClickListener {
        public final /* synthetic */ BalanceExchangeView a;

        public d(BalanceExchangeView r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r3) {
            boolean r4 = com.bytedance.android.live.recharge.combinedpay.a.a();
            ImageView r0 = this.a.getMBalanceExchangeSelectIcon();
            if (r0 == null) goto L8;
            if (r4 == false) goto L6;
            int r1 = 2131252742;
        L7:
            r0.setImageResource(r1);
            goto L8
        L6:
            r1 = 2131252741;
        L8:
            boolean r5 = !r4;
            com.bytedance.android.live.recharge.combinedpay.a.b.set(Boolean.valueOf(r5));
            b r2 = this.a.getMOnSelectListener();
            if (r2 == null) goto L12;
            r2.a(r5);
            return;
        }
    }

    static {
    }

    public final void a() {
        View r0 = FrameLayout.inflate(getContext(), 2131567257, this);
        this.a = (TextView) r0.findViewById(2131363856);
        this.b = (ImageView) r0.findViewById(2131363853);
        this.c = (ImageView) r0.findViewById(2131363855);
        this.e = r0.findViewById(2131363854);
        this.d = (TextView) r0.findViewById(2131368366);
        ImageView r1 = this.b;
        if (r1 == null) goto L5;
        r1.setOnClickListener(new c(this));
    L5:
        ImageView r2 = this.c;
        if (r2 == null) goto L9;
        r2.setOnClickListener(new d(this));
        return;
    }

    public final boolean getSelectStatus() {
        return com.bytedance.android.live.recharge.combinedpay.a.a();
    }

    public final ImageView getMBalanceExchangeHintIcon() {
        return this.b;
    }

    public final View getMBalanceExchangeLayout() {
        return this.e;
    }

    public final ImageView getMBalanceExchangeSelectIcon() {
        return this.c;
    }

    public final TextView getMBalanceExchangeText() {
        return this.a;
    }

    public final String getMChargeReason() {
        return this.h;
    }

    public final TextView getMCustomBalanceExchangeTip() {
        return this.d;
    }

    public final b getMOnSelectListener() {
        return this.f;
    }

    public final String getMRequestPage() {
        return this.g;
    }

    public BalanceExchangeView(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        this.g = "";
        this.h = "";
        a();
    }

    public final void setMBalanceExchangeHintIcon(ImageView r1) {
        this.b = r1;
    }

    public final void setMBalanceExchangeLayout(View r1) {
        this.e = r1;
    }

    public final void setMBalanceExchangeSelectIcon(ImageView r1) {
        this.c = r1;
    }

    public final void setMBalanceExchangeText(TextView r1) {
        this.a = r1;
    }

    public final void setMChargeReason(String r1) {
        this.h = r1;
    }

    public final void setMCustomBalanceExchangeTip(TextView r1) {
        this.d = r1;
    }

    public final void setMOnSelectListener(b r1) {
        this.f = r1;
    }

    public final void setMRequestPage(String r1) {
        this.g = r1;
    }

    public final void setOnSelectListener(b r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.f = r2;
    }

    public BalanceExchangeView(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3);
        this.g = "";
        this.h = "";
        a();
    }

    public final void b(int r6, String r7) {
        Intrinsics.checkNotNullParameter(r7, "source");
        long r0 = r6;
        if (i.a() == false) goto L5;
        int r8 = 2131921880;
    L6:
        TextView r2 = this.a;
        if (r2 == null) goto L9;
        r2.setText(s1.C(r8, new Object[]{q.b(r0)}));
    L9:
        boolean r9 = com.bytedance.android.live.recharge.combinedpay.a.a();
        ImageView r1 = this.c;
        if (r1 == null) goto L16;
        if (r9 == false) goto L13;
        int r10 = 2131252741;
    L14:
        r1.setImageResource(r10);
        goto L16
    L13:
        r10 = 2131252742;
    L16:
        if ("custom_recharge".equals(r7) == false) goto L21;
        View r12 = this.e;
        if (r12 == null) goto L22;
        r12.setBackgroundColor(getResources().getColor(2131107257));
        return;
    L22:
        return;
    L21:
        return;
    L5:
        r8 = 2131921877;
        goto L6
    }

    public BalanceExchangeView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.g = "";
        this.h = "";
        a();
    }
}
