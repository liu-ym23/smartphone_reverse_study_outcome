package com.bytedance.android.live.revlink.impl.multianchor.dialog.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.bytedance.android.live.uikit.viewpager.SSViewPager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/multianchor/dialog/ui/NoSwipeViewPager;", "Lcom/bytedance/android/live/uikit/viewpager/SSViewPager;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class NoSwipeViewPager extends SSViewPager {
    public final boolean onInterceptTouchEvent(MotionEvent r1) {
        return false;
    }

    public final boolean onTouchEvent(MotionEvent r1) {
        return true;
    }

    public NoSwipeViewPager(Context r2) {
        this(r2, null);
    }

    public NoSwipeViewPager(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3);
    }
}
