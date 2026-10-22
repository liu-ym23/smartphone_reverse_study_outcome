package com.larus.bmhome.chat.component.bottom.floating.button;

import android.animation.AnimatorSet;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\r\u0018\u0000  2\u00020\u0001:\u0002 !B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ\u000e\u0010\u0014\u001a\u00020\u00152\u0006\u0010\f\u001a\u00020\rJ\u0010\u0010\u0016\u001a\u00020\u00152\b\u0010\u0017\u001a\u0004\u0018\u00010\u000fJ\u0006\u0010\u0018\u001a\u00020\u0015J\u0010\u0010\u0019\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u000fH\u0002J\u0010\u0010\u001a\u001a\u00020\u00152\u0006\u0010\u001b\u001a\u00020\u000fH\u0002J\u0010\u0010\u001c\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u000fH\u0002J\b\u0010\u001d\u001a\u00020\u0015H\u0002J\b\u0010\u001e\u001a\u00020\u0015H\u0014J\b\u0010\u001f\u001a\u00020\u0015H\u0002R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/larus/bmhome/chat/component/bottom/floating/button/BottomFloatingButton;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "dependency", "Lcom/larus/bmhome/chat/component/bottom/floating/button/BottomFloatingButton$IDependency;", "currentType", "Lcom/larus/bmhome/chat/component/bottom/floating/button/ButtonType;", "showAnimator", "Landroid/animation/AnimatorSet;", "mainHandler", "Landroid/os/Handler;", "init", "", "show", "type", "hide", "firstShowWithAnimation", "changeTypeWithAnimation", "newType", "updateContent", "delayAutoHide", "onDetachedFromWindow", "cleanIfNeed", "Companion", "IDependency", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class BottomFloatingButton extends FrameLayout {
    public static final /* synthetic */ int e = 0;
    public b a;
    public ButtonType b;
    public AnimatorSet c;
    public final Handler d;

    public static final class a {
    }

    public interface b {
        void a();

        void b(BottomFloatingButton r1, ButtonType r2);
    }

    static {
    }

    public final void a() {
        FLogger.a.i("BottomFloatingButton", "cleanIfNeed");
        if (getVisibility() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
    L10:
        e1.o(this);
        setAlpha(1.0f);
        ViewGroup.LayoutParams r1 = getLayoutParams();
        if (r1 == null) goto L18;
        FrameLayout.LayoutParams r2 = (FrameLayout.LayoutParams) r1;
        r2.width = -2;
        setLayoutParams(r2);
        removeAllViews();
        this.d.removeCallbacksAndMessages(null);
        AnimatorSet r3 = this.c;
        if (r3 == null) goto L15;
        r3.cancel();
    L15:
        this.c = null;
        this.b = null;
        return;
    L18:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
    L8:
        if (getChildCount() != 0) goto L10;
        return;
    L5:
        r0 = false;
        goto L6
    }

    public final void b() {
        FLogger.a.i("BottomFloatingButton", "hide, currentType:" + this.b);
        a();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        FLogger.a.i("BottomFloatingButton", "onDetachedFromWindow");
        a();
    }

    public BottomFloatingButton(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        this.d = new Handler(Looper.getMainLooper());
    }

    public BottomFloatingButton(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3);
        this.d = new Handler(Looper.getMainLooper());
    }

    public BottomFloatingButton(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.d = new Handler(Looper.getMainLooper());
    }
}
