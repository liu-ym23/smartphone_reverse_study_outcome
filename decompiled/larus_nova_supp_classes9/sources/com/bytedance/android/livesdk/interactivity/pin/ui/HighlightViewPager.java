package com.bytedance.android.livesdk.interactivity.pin.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.bytedance.android.live.uikit.viewpager.SSViewPager;
import com.bytedance.bdlocation.BuildConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u000e\u0010\u000fR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/pin/ui/HighlightViewPager;", "Lcom/bytedance/android/live/uikit/viewpager/SSViewPager;", BuildConfig.FLAVOR, "a", "I", "getContentHeight", "()I", "setContentHeight", "(I)V", "contentHeight", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "interactivity-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class HighlightViewPager extends SSViewPager {
    public int a;

    public final int getContentHeight() {
        return this.a;
    }

    public HighlightViewPager(Context r2) {
        this(r2, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean dispatchTouchEvent(MotionEvent r3) {
        Intrinsics.checkNotNullParameter(r3, "ev");
        float r0 = r3.getY();
        int r1 = this.a;
        if (r1 <= 0) goto L11;
        if (r0 <= r1) goto L11;
        if (r3.getAction() != 0) goto L11;
        return false;
    L11:
        return super/*android.view.ViewGroup*/.dispatchTouchEvent(r3);
    }

    public final void setContentHeight(int r1) {
        this.a = r1;
    }

    public HighlightViewPager(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3);
    }
}
