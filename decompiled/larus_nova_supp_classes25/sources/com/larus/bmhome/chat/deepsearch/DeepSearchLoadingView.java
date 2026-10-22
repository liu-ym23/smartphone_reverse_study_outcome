package com.larus.bmhome.chat.deepsearch;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBindings;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.common_ui.widget.roundlayout.RoundImageView;
import com.larus.mainbot.impl.databinding.LarusDeepSearchLoadingBinding;
import com.lynx.lottieadapter.LottieAdapterView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u001d\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0006\u0010\f\u001a\u00020\rJ\b\u0010\u000e\u001a\u00020\rH\u0014R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/larus/bmhome/chat/deepsearch/DeepSearchLoadingView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "binding", "Lcom/larus/mainbot/impl/databinding/LarusDeepSearchLoadingBinding;", "startTime", "", "showLottieView", "", "onDetachedFromWindow", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class DeepSearchLoadingView extends RelativeLayout {
    public static final /* synthetic */ int c = 0;
    public final LarusDeepSearchLoadingBinding a;
    public final long b;

    public static final class a {
    }

    static {
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.a.c.cancelAnimation();
    }

    public DeepSearchLoadingView(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, null);
    }

    public DeepSearchLoadingView(Context r4, AttributeSet r5) {
        Intrinsics.checkNotNullParameter(r4, "context");
        super(r4, r5);
        View r6 = LayoutInflater.from(r4).inflate(2131562022, this, false);
        addView(r6);
        int r7 = 2131368726;
        RoundImageView r0 = ViewBindings.findChildViewById(r6, 2131368726);
        if (r0 == null) goto L11;
        r7 = 2131368727;
        LottieAdapterView r1 = ViewBindings.findChildViewById(r6, 2131368727);
        if (r1 == null) goto L11;
        r7 = 2131368728;
        TextView r2 = (TextView) ViewBindings.findChildViewById(r6, 2131368728);
        if (r2 == null) goto L11;
        this.a = new LarusDeepSearchLoadingBinding((RelativeLayout) r6, r0, r1, r2);
        this.b = System.currentTimeMillis();
        return;
    L11:
        throw new NullPointerException("Missing required view with ID: ".concat(r6.getResources().getResourceName(r7)));
    }
}
