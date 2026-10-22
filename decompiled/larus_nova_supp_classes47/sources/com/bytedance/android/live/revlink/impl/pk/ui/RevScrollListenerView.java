package com.bytedance.android.live.revlink.impl.pk.ui;

import android.content.Context;
import android.util.AttributeSet;
import androidx.core.widget.NestedScrollView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0003B'\b\u0007\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0010\u0010\u0011R$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/pk/ui/RevScrollListenerView;", "Landroidx/core/widget/NestedScrollView;", "Lcom/bytedance/android/live/revlink/impl/pk/ui/RevScrollListenerView$a;", "a", "Lcom/bytedance/android/live/revlink/impl/pk/ui/RevScrollListenerView$a;", "getScrollListener", "()Lcom/bytedance/android/live/revlink/impl/pk/ui/RevScrollListenerView$a;", "setScrollListener", "(Lcom/bytedance/android/live/revlink/impl/pk/ui/RevScrollListenerView$a;)V", "scrollListener", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class RevScrollListenerView extends NestedScrollView {
    public a a;

    public interface a {
        void a(int r1);
    }

    public RevScrollListenerView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public RevScrollListenerView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public final a getScrollListener() {
        return this.a;
    }

    public final void setScrollListener(a r1) {
        this.a = r1;
    }

    public RevScrollListenerView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
    }

    public /* synthetic */ RevScrollListenerView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }

    public final void onScrollChanged(int r1, int r2, int r3, int r4) {
        super.onScrollChanged(r1, r2, r3, r4);
        a r5 = this.a;
        if (r5 == null) goto L6;
        r5.a(r2);
        return;
    }
}
