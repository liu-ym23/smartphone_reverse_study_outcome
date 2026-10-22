package com.bytedance.android.livesdk.gamesticker.hok;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.android.livesdk.chatroom.model.b2;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B'\b\u0007\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0014\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003J\b\u0010\b\u001a\u00020\u0007H\u0016R\u001b\u0010\u000e\u001a\u00020\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001b\u0010\u0011\u001a\u00020\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u000b\u001a\u0004\b\u0010\u0010\r¨\u0006\u001a"}, d2 = {"Lcom/bytedance/android/livesdk/gamesticker/hok/HokGameWinView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Lcom/bytedance/android/livesdk/gamesticker/hok/e;", "Lcom/bytedance/android/livesdk/chatroom/model/b2;", "liveInfo", "", "setLiveInfo", "Landroid/view/View;", "getView", "Landroid/widget/TextView;", "a", "Lkotlin/Lazy;", "getWinRateView", "()Landroid/widget/TextView;", "winRateView", "b", "getWinStreakView", "winStreakView", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "livecommonui_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class HokGameWinView extends ConstraintLayout implements e {
    public final Lazy a;
    public final Lazy b;

    public HokGameWinView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public HokGameWinView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    private final TextView getWinRateView() {
        return (TextView) this.a.getValue();
    }

    private final TextView getWinStreakView() {
        return (TextView) this.b.getValue();
    }

    @Override // com.bytedance.android.livesdk.gamesticker.hok.e
    public final void D2() {
        setLiveInfo(null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.android.livesdk.gamesticker.hok.e
    public View getView() {
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void setLiveInfo(b2 r3) {
        if (r3 != null) goto L5;
        setVisibility(8);
        return;
    L5:
        Integer r0 = r3.b();
        if (r0 == null) goto L11;
        if (r0.intValue() != 0) goto L11;
    L14:
        setVisibility(0);
        R5(getWinStreakView(), "");
        R5(getWinRateView(), "");
        return;
    L11:
        if (r3.b() == null) goto L14;
        R5(getWinStreakView(), r3.c());
        R5(getWinRateView(), r3.a());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void R5(TextView r4, String r5) {
        if (r5 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == true) goto L11;
        setVisibility(0);
        int r2 = g.a;
        g.a(r4.getPaint(), 400);
        r4.setText(r5);
        r4.setVisibility(0);
        return;
    L11:
        r4.setVisibility(8);
        return;
    L5:
        if (r5.length() == 0) goto L8;
        r1 = false;
        goto L9
    }

    /* JADX WARN: Multi-variable type inference failed */
    public HokGameWinView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.a = LazyKt.lazy(new HokGameWinView$winRateView$2(this));
        this.b = LazyKt.lazy(new HokGameWinView$winStreakView$2(this));
        LayoutInflater.from(r2).inflate(2131566104, this);
    }

    public /* synthetic */ HokGameWinView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
