package com.bytedance.android.live.broadcastgame.opengame.view.helper.imagescale;

import android.content.Context;
import android.util.AttributeSet;
import androidx.core.widget.NestedScrollView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u0011B'\b\u0007\u0012\u0006\u0010\n\u001a\u00020\t\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\b\b\u0002\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/opengame/view/helper/imagescale/PreShareNestedScrollView;", "Landroidx/core/widget/NestedScrollView;", "Lcom/bytedance/android/live/broadcastgame/opengame/view/helper/imagescale/PreShareNestedScrollView$a;", "preScrollListener", "Lcom/bytedance/android/live/broadcastgame/opengame/view/helper/imagescale/PreShareNestedScrollView$a;", "getPreScrollListener", "()Lcom/bytedance/android/live/broadcastgame/opengame/view/helper/imagescale/PreShareNestedScrollView$a;", "setPreScrollListener", "(Lcom/bytedance/android/live/broadcastgame/opengame/view/helper/imagescale/PreShareNestedScrollView$a;)V", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "livebroadcastgame-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PreShareNestedScrollView extends NestedScrollView {

    public interface a {
    }

    public PreShareNestedScrollView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public PreShareNestedScrollView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public final a getPreScrollListener() {
        return null;
    }

    public final void setPreScrollListener(a r1) {
    }

    public PreShareNestedScrollView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
    }

    public /* synthetic */ PreShareNestedScrollView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }

    public final boolean dispatchNestedPreScroll(int r3, int r4, int[] r5, int[] r6, int r7) {
        if (r5 == null) goto L5;
        int r0 = r5.length;
    L5:
        return super.dispatchNestedPreScroll(r3, r4, r5, r6, r7);
    }
}
