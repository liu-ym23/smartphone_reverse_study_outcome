package com.ss.android.lark.flow.feed.component.text_layer;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.utils.UIHelper;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import zz7.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bJ\b\u0010\u0016\u001a\u00020\u0017H\u0002J\u000e\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u001aR\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u000b\u001a\u00020\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000eR\u001b\u0010\u0011\u001a\u00020\u00128BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0010\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u001b"}, d2 = {"Lcom/ss/android/lark/flow/feed/component/text_layer/FlowTextLayerView;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "markTextSize", "", "textView", "Landroidx/appcompat/widget/AppCompatTextView;", "getTextView", "()Landroidx/appcompat/widget/AppCompatTextView;", "textView$delegate", "Lkotlin/Lazy;", "dividerImageView", "Landroidx/appcompat/widget/AppCompatImageView;", "getDividerImageView", "()Landroidx/appcompat/widget/AppCompatImageView;", "dividerImageView$delegate", "init", "", "bindTextLayer", "data", "Lcom/ss/android/lark/flow/feed/component/text_layer/FlowTextLayerComponent$FlowTextLayerParams;", "flow-feed_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class FlowTextLayerView extends LinearLayout {
    public final float a;
    public final Lazy b;
    public final Lazy c;

    private final AppCompatImageView getDividerImageView() {
        return (AppCompatImageView) this.c.getValue();
    }

    private final AppCompatTextView getTextView() {
        return (AppCompatTextView) this.b.getValue();
    }

    public FlowTextLayerView(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, null);
    }

    public final void a(a.C0046a r4) {
        Intrinsics.checkNotNullParameter(r4, "data");
        if (r4.a == false) goto L6;
        getTextView().setVisibility(0);
        getTextView().setText(UIHelper.getString(2131890016));
        getTextView().setTextColor(UIHelper.getColor(2131102080));
        getDividerImageView().setVisibility(0);
        return;
    L6:
        if (r4.b <= 0) goto L11;
        getTextView().setVisibility(0);
        int r5 = r4.b;
        if (r5 <= 99) goto L10;
        r5 = 99;
    L10:
        getTextView().setText(UIHelper.getQuantityString(2131755044, r5));
        getTextView().setTextColor(UIUtils.getColor(getContext(), 2131101973));
        getDividerImageView().setVisibility(0);
        return;
    L11:
        getTextView().setVisibility(8);
        getDividerImageView().setVisibility(8);
    }

    public FlowTextLayerView(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r3, r4, 0);
        this.a = b.h(getContext(), 14);
        this.b = LazyKt.lazy(new FlowTextLayerView$textView$2(this));
        this.c = LazyKt.lazy(new FlowTextLayerView$dividerImageView$2(this));
        addView(getTextView());
        AppCompatImageView r5 = getDividerImageView();
        LinearLayout.LayoutParams r6 = new LinearLayout.LayoutParams(-2, -2);
        r6.gravity = 16;
        r6.rightMargin = UIHelper.dp2px(6.0f);
        r6.leftMargin = UIHelper.dp2px(6.0f);
        Unit r0 = Unit.INSTANCE;
        addView(r5, r6);
        getDividerImageView().setVisibility(8);
    }
}
