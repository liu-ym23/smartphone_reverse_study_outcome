package com.bytedance.android.live.recharge.exchange.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.android.live.incentive.exchange.i;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\u0003B\u0011\b\u0016\u0012\u0006\u0010\u001b\u001a\u00020\u001a¢\u0006\u0004\b\u001c\u0010\u001dB\u001b\b\u0016\u0012\u0006\u0010\u001b\u001a\u00020\u001a\u0012\b\u0010\u001f\u001a\u0004\u0018\u00010\u001e¢\u0006\u0004\b\u001c\u0010 B#\b\u0016\u0012\u0006\u0010\u001b\u001a\u00020\u001a\u0012\b\u0010\u001f\u001a\u0004\u0018\u00010\u001e\u0012\u0006\u0010\"\u001a\u00020!¢\u0006\u0004\b\u001c\u0010#R$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\u0011\u001a\u00020\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R$\u0010\u0019\u001a\u0004\u0018\u00010\u00128\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018¨\u0006$"}, d2 = {"Lcom/bytedance/android/live/recharge/exchange/view/ExchangeConfirmDefaultView;", "Landroid/widget/FrameLayout;", "Landroid/widget/ImageView;", "a", "Landroid/widget/ImageView;", "getMSelectIcon", "()Landroid/widget/ImageView;", "setMSelectIcon", "(Landroid/widget/ImageView;)V", "mSelectIcon", "", "b", "Z", "getMSelect", "()Z", "setMSelect", "(Z)V", "mSelect", "Lcom/bytedance/android/live/recharge/exchange/view/ExchangeConfirmDefaultView$a;", "c", "Lcom/bytedance/android/live/recharge/exchange/view/ExchangeConfirmDefaultView$a;", "getMOnSelectClickListner", "()Lcom/bytedance/android/live/recharge/exchange/view/ExchangeConfirmDefaultView$a;", "setMOnSelectClickListner", "(Lcom/bytedance/android/live/recharge/exchange/view/ExchangeConfirmDefaultView$a;)V", "mOnSelectClickListner", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "liverecharge-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class ExchangeConfirmDefaultView extends FrameLayout {
    public ImageView a;
    public boolean b;
    public a c;

    public interface a {
        void a(boolean r1);
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ ExchangeConfirmDefaultView a;

        public b(ExchangeConfirmDefaultView r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            ImageView r3 = this.a.getMSelectIcon();
            if (r3 != null) goto L5;
        L9:
            ExchangeConfirmDefaultView r4 = this.a;
            r4.setMSelect(!r4.getMSelect());
            com.bytedance.android.live.recharge.combinedpay.a.C0060a r5 = com.bytedance.android.live.recharge.combinedpay.a.a;
            com.bytedance.android.live.recharge.combinedpay.a.b.set(Boolean.valueOf(this.a.getMSelect()));
            a r6 = this.a.getMOnSelectClickListner();
            if (r6 == null) goto L13;
            r6.a(this.a.getMSelect());
            return;
        L13:
            return;
        L5:
            if (this.a.getMSelect() == false) goto L7;
            int r0 = 2131252742;
        L8:
            r3.setImageResource(r0);
            goto L9
        L7:
            r0 = 2131252741;
            goto L8
        }
    }

    public final void a() {
        this.a = (ImageView) FrameLayout.inflate(getContext(), 2131565457, this).findViewById(2131371845);
        if (i.a() == false) goto L7;
        TextView r0 = (TextView) findViewById(2131371846);
        if (r0 == null) goto L7;
        r0.setText(2131915252);
    L7:
        ImageView r1 = this.a;
        if (r1 == null) goto L11;
        r1.setOnClickListener(new b(this));
        return;
    }

    public final a getMOnSelectClickListner() {
        return this.c;
    }

    public final boolean getMSelect() {
        return this.b;
    }

    public final ImageView getMSelectIcon() {
        return this.a;
    }

    public ExchangeConfirmDefaultView(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        a();
    }

    public final void setMOnSelectClickListner(a r1) {
        this.c = r1;
    }

    public final void setMSelect(boolean r1) {
        this.b = r1;
    }

    public final void setMSelectIcon(ImageView r1) {
        this.a = r1;
    }

    public ExchangeConfirmDefaultView(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3);
        a();
    }

    public ExchangeConfirmDefaultView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        a();
    }
}
