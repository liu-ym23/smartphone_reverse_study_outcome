package com.ss.android.lark.message.lynxcard.message;

import android.content.Context;
import android.util.AttributeSet;
import com.larksuite.component.ui.layout.LKUIRoundableLayout;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJp\u0010\u0014\u001a\u00020\u00122h\u0010\u0015\u001ad\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000f\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0010\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u000bj\u0004\u0018\u0001`\u0013J(\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0007H\u0014Rp\u0010\n\u001ad\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000f\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0010\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u000bj\u0004\u0018\u0001`\u0013X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/ss/android/lark/message/lynxcard/message/LynxCardMessageContentLayout;", "Lcom/larksuite/component/ui/layout/LKUIRoundableLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "sizeChangedListener", "Lkotlin/Function4;", "Lkotlin/ParameterName;", "name", "w", "h", "oldw", "oldh", "", "Lcom/ss/android/lark/message/lynxcard/message/OnSizeChangedListener;", "setOnSizeChangeListener", "listener", "onSizeChanged", "Companion", "message-card_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class LynxCardMessageContentLayout extends LKUIRoundableLayout {
    public Function4<? super Integer, ? super Integer, ? super Integer, ? super Integer, Unit> r;

    public static final class a {
    }

    static {
    }

    public LynxCardMessageContentLayout(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public LynxCardMessageContentLayout(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    public final void setOnSizeChangeListener(Function4<? super Integer, ? super Integer, ? super Integer, ? super Integer, Unit> r1) {
        this.r = r1;
    }

    public LynxCardMessageContentLayout(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
    }

    public /* synthetic */ LynxCardMessageContentLayout(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }

    public final void onSizeChanged(int r4, int r5, int r6, int r7) {
        hac.b.a.a("LynxCardMessageContentLayout", "onSizeChanged w:" + r4 + ", h:" + r5 + ", oldw:" + r6 + ", oldh:" + r7);
        super.onSizeChanged(r4, r5, r6, r7);
        Function4<? super Integer, ? super Integer, ? super Integer, ? super Integer, Unit> r0 = this.r;
        if (r0 == null) goto L6;
        r0.invoke(Integer.valueOf(r4), Integer.valueOf(r5), Integer.valueOf(r6), Integer.valueOf(r7));
        return;
    }
}
