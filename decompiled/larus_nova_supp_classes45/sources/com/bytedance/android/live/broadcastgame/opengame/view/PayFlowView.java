package com.bytedance.android.live.broadcastgame.opengame.view;

import android.content.Context;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.android.live.base.model.message.n5;
import com.bytedance.android.live.core.utils.ImageUtil;
import com.bytedance.android.livesdk.utils.r3;
import com.bytedance.common.utility.Logger;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0014B\u000f\u0012\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0007\u001a\u00020\u00018\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\"\u0010\u000f\u001a\u00020\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/opengame/view/PayFlowView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "", "f", "Landroidx/constraintlayout/widget/ConstraintLayout;", "getWholeItem", "()Landroidx/constraintlayout/widget/ConstraintLayout;", "wholeItem", "", "g", "I", "getTextWidth", "()I", "setTextWidth", "(I)V", "textWidth", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "a", "livebroadcastgame-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PayFlowView extends ConstraintLayout {
    public static final /* synthetic */ int i = 0;
    public Map<Integer, View> a;
    public f b;
    public View c;
    public View d;
    public Function1<? super Boolean, Unit> e;
    public final ConstraintLayout f;
    public int g;
    public PayFlowView$startHideCountdown$2 h;

    public static final class a {
    }

    static {
    }

    public final boolean T5() {
        if (this.c.getVisibility() != 0) goto L5;
        boolean r0 = true;
    L7:
        if (com.bytedance.android.live.core.utils.v.a() == false) goto L9;
        Logger.d("PayFlowView", "PayFlowView, isFlowShowing: " + r0);
    L9:
        return r0;
    L5:
        r0 = false;
        goto L7
    }

    public final void S5() {
        if (com.bytedance.android.live.core.utils.v.a() == false) goto L5;
        Logger.d("PayFlowView", "PayFlowView, fetchPayMsg");
    L5:
        f r0 = this.b;
        if (r0 == null) goto L48;
        com.bytedance.android.live.broadcastgame.opengame.message.r r1 = r0.poll();
        if (r1 == null) goto L49;
        Function1<? super Boolean, Unit> r2 = this.e;
        if (r2 == null) goto L13;
        Unit r3 = (Unit) r2.invoke(Boolean.TRUE);
    L13:
        if (com.bytedance.android.live.core.utils.v.a() == false) goto L16;
        Logger.d("PayFlowView", "PayFlowView, onNewPayMsg");
    L16:
        if (T5() == false) goto L37;
        if (com.bytedance.android.live.core.utils.v.a() == false) goto L20;
        Logger.d("PayFlowView", "PayFlowView, 已有老流水，新流水替换老流水");
    L20:
        KeyEvent.Callback r4 = this.c;
        if (r4 == null) goto L35;
        ((d) r4).k(new PayFlowView$onNewPayMsg$3(this));
        KeyEvent.Callback r5 = this.d;
        if (r5 == null) goto L33;
        ((d) r5).y(r1.c, new PayFlowView$onNewPayMsg$4(this));
        KeyEvent.Callback r6 = this.d;
        if (r6 == null) goto L31;
        ((d) r6).o(new PayFlowView$onNewPayMsg$5(this));
        if (com.bytedance.android.live.core.utils.v.a() == false) goto L29;
        Logger.d("PayFlowView", "PayFlowView, 新老 Item 互换");
    L29:
        View r7 = this.c;
        this.c = this.d;
        this.d = r7;
        return;
    L31:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.broadcastgame.opengame.view.IFlowItemView");
    L33:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.broadcastgame.opengame.view.IFlowItemView");
    L35:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.broadcastgame.opengame.view.IFlowItemView");
    L37:
        if (com.bytedance.android.live.core.utils.v.a() == false) goto L39;
        Logger.d("PayFlowView", "PayFlowView,  没有老流水，新流水直接展示");
    L39:
        z.b(_$_findCachedViewById(2131382012));
        z.b(_$_findCachedViewById(2131381995));
        KeyEvent.Callback r8 = this.c;
        if (r8 == null) goto L47;
        ((d) r8).y(r1.c, new PayFlowView$onNewPayMsg$8(this));
        KeyEvent.Callback r9 = this.c;
        if (r9 == null) goto L45;
        ((d) r9).j(new PayFlowView$onNewPayMsg$9(this));
        return;
    L45:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.broadcastgame.opengame.view.IFlowItemView");
    L47:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.broadcastgame.opengame.view.IFlowItemView");
    L49:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onDetachedFromWindow() {
        super/*android.view.ViewGroup*/.onDetachedFromWindow();
        if (com.bytedance.android.live.core.utils.v.a() == false) goto L6;
        Logger.d("PayFlowView", "PayFlowView, onDetachedFromWindow");
    L6:
        if (com.bytedance.android.live.core.utils.v.a() == false) goto L8;
        Logger.d("PayFlowView", "PayFlowView, cancelHideCountdown");
    L8:
        PayFlowView$startHideCountdown$2 r0 = this.h;
        if (r0 == null) goto L12;
        removeCallbacks(r0);
        return;
    }

    public final int getTextWidth() {
        return this.g;
    }

    public final ConstraintLayout getWholeItem() {
        return this.f;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public PayFlowView(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        super(r4);
        this.a = new LinkedHashMap();
        this.c = new c(r4);
        this.d = new c(r4);
        ConstraintLayout r5 = LayoutInflater.from(r4).inflate(2131567095, this);
        if (r5 == null) goto L7;
        this.f = r5;
        ((ImageView) _$_findCachedViewById(2131381995)).setId(View.generateViewId());
        ImageUtil.loadImage((ImageView) _$_findCachedViewById(2131381995), r3.a(), 0);
        _$_findCachedViewById(2131381992).addView(this.c);
        _$_findCachedViewById(2131381992).addView(this.d);
        _$_findCachedViewById(2131382012).setVisibility(4);
        ((ImageView) _$_findCachedViewById(2131381995)).setVisibility(4);
        this.c.setVisibility(4);
        this.d.setVisibility(4);
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [com.bytedance.android.live.broadcastgame.opengame.view.PayFlowView$startHideCountdown$2] */
    public static final void R5(final PayFlowView r3) {
        r3.getClass();
        if (com.bytedance.android.live.core.utils.v.a() == false) goto L6;
        Logger.d("PayFlowView", "PayFlowView, startHideCountdown");
    L6:
        if (r3.h != null) goto L8;
        r3.h = new PayFlowView$startHideCountdown$2(r3);
    L8:
        PayFlowView$startHideCountdown$2 r0 = r3.h;
        if (r0 == null) goto L11;
        r3.removeCallbacks(r0);
    L11:
        r3.postDelayed(r3.h, n5.DEFAULT_SHOW_DURATION);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final View _$_findCachedViewById(int r3) {
        if (this.a != null) goto L5;
        this.a = new LinkedHashMap();
    L5:
        View r0 = this.a.get(Integer.valueOf(r3));
        if (r0 != null) goto L12;
        View r1 = findViewById(r3);
        if (r1 == null) goto L10;
        this.a.put(Integer.valueOf(r3), r1);
        return r1;
    L10:
        return null;
    L12:
        return r0;
    }

    public final void setTextWidth(int r1) {
        this.g = r1;
    }
}
