package com.bytedance.android.live.openplatform.impl.miniappaudience.explaincard.atmosphere.hot;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;
import com.bytedance.android.livesdk.utils.t6;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/miniappaudience/explaincard/atmosphere/hot/ItalicTextView;", "Landroid/widget/TextView;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
final class ItalicTextView extends TextView {
    public ItalicTextView(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3);
    }

    @Override // android.widget.TextView, android.view.View
    public final void onMeasure(int r2, int r3) {
        super.onMeasure(r2, r3);
        setMeasuredDimension(getMeasuredWidth() + ((int) t6.a(getContext(), 3.0f)), getMeasuredHeight());
    }
}
