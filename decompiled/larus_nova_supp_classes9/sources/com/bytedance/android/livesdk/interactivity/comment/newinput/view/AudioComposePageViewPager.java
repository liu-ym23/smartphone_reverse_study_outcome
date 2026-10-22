package com.bytedance.android.livesdk.interactivity.comment.newinput.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.bytedance.android.live.uikit.viewpager.SSViewPager;
import com.bytedance.bdlocation.BuildConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\n\u0010\u000bJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\f"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/comment/newinput/view/AudioComposePageViewPager;", "Lcom/bytedance/android/live/uikit/viewpager/SSViewPager;", BuildConfig.FLAVOR, "can", BuildConfig.FLAVOR, "setCanScroll", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AudioComposePageViewPager extends SSViewPager {
    public boolean a;

    public AudioComposePageViewPager(Context r2) {
        this(r2, null);
    }

    public final boolean onInterceptTouchEvent(MotionEvent r2) {
        if (this.a == true) goto L7;
        return false;
    L7:
        return super.onInterceptTouchEvent(r2);
    }

    public final void setCanScroll(boolean r1) {
        this.a = r1;
    }

    public AudioComposePageViewPager(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3);
        this.a = true;
    }
}
