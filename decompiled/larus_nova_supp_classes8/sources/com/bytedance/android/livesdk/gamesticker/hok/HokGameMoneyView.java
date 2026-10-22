package com.bytedance.android.livesdk.gamesticker.hok;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.android.livesdk.chatroom.model.k2;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B'\b\u0007\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0018\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u001a¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003J\b\u0010\b\u001a\u00020\u0007H\u0016R\u001b\u0010\u000e\u001a\u00020\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001b\u0010\u0012\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u000b\u001a\u0004\b\u0010\u0010\u0011R\u001b\u0010\u0015\u001a\u00020\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u000b\u001a\u0004\b\u0014\u0010\r¨\u0006\u001e"}, d2 = {"Lcom/bytedance/android/livesdk/gamesticker/hok/HokGameMoneyView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Lcom/bytedance/android/livesdk/gamesticker/hok/e;", "Lcom/bytedance/android/livesdk/chatroom/model/k2;", "moneyCount", "", "setMoneyCount", "Landroid/view/View;", "getView", "Landroid/widget/TextView;", "a", "Lkotlin/Lazy;", "getMoneyFirstView", "()Landroid/widget/TextView;", "moneyFirstView", "b", "getMoneyDividerView", "()Landroid/view/View;", "moneyDividerView", "c", "getMoneySecondView", "moneySecondView", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "livecommonui_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class HokGameMoneyView extends ConstraintLayout implements e {
    public final Lazy a;
    public final Lazy b;
    public final Lazy c;

    public HokGameMoneyView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public HokGameMoneyView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    private final View getMoneyDividerView() {
        return (View) this.b.getValue();
    }

    private final TextView getMoneyFirstView() {
        return (TextView) this.a.getValue();
    }

    private final TextView getMoneySecondView() {
        return (TextView) this.c.getValue();
    }

    @Override // com.bytedance.android.livesdk.gamesticker.hok.e
    public final void D2() {
        setMoneyCount(null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.android.livesdk.gamesticker.hok.e
    public View getView() {
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void setMoneyCount(k2 r7) {
        if (r7 != null) goto L6;
        setVisibility(8);
        return;
    L6:
        String r1 = r7.a();
        String r8 = r7.b();
        boolean r2 = true;
        if (r1 != null) goto L9;
    L12:
        boolean r4 = true;
    L14:
        if (r4 == true) goto L23;
        if (r8 != null) goto L17;
    L20:
        boolean r5 = true;
    L21:
        if (r5 == true) goto L23;
        setVisibility(0);
        int r0 = g.a;
        g.a(getMoneyFirstView().getPaint(), 400);
        g.a(getMoneySecondView().getPaint(), 400);
        getMoneyFirstView().setText(r8);
        getMoneySecondView().setText(r1);
        getMoneyDividerView().setVisibility(0);
        getMoneyFirstView().setVisibility(0);
        getMoneySecondView().setVisibility(0);
        return;
    L17:
        if (r8.length() == 0) goto L20;
        r5 = false;
    L23:
        if (r1 != null) goto L25;
    L28:
        boolean r6 = true;
    L29:
        if (r6 == true) goto L31;
        setVisibility(0);
        int r9 = g.a;
        g.a(getMoneySecondView().getPaint(), 400);
        getMoneySecondView().setText(r1);
        getMoneyDividerView().setVisibility(8);
        getMoneyFirstView().setVisibility(8);
        getMoneySecondView().setVisibility(0);
        return;
    L31:
        if (r8 != null) goto L33;
    L36:
        if (r2 == true) goto L41;
        setVisibility(0);
        int r3 = g.a;
        g.a(getMoneySecondView().getPaint(), 400);
        getMoneySecondView().setText(r8);
        getMoneyDividerView().setVisibility(8);
        getMoneyFirstView().setVisibility(8);
        getMoneySecondView().setVisibility(0);
        return;
    L41:
        return;
    L33:
        if (r8.length() == 0) goto L36;
        r2 = false;
        goto L36
    L25:
        if (r1.length() == 0) goto L28;
        r6 = false;
        goto L29
    L9:
        if (r1.length() == 0) goto L12;
        r4 = false;
        goto L14
    }

    /* JADX WARN: Multi-variable type inference failed */
    public HokGameMoneyView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.a = LazyKt.lazy(new HokGameMoneyView$moneyFirstView$2(this));
        this.b = LazyKt.lazy(new HokGameMoneyView$moneyDividerView$2(this));
        this.c = LazyKt.lazy(new HokGameMoneyView$moneySecondView$2(this));
        LayoutInflater.from(r2).inflate(2131566102, this);
    }

    public /* synthetic */ HokGameMoneyView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
