package com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.bdlocation.BuildConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0010\u0010\u0011R\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v2/view/GiftListRecyclerView;", "Landroidx/recyclerview/widget/RecyclerView;", BuildConfig.FLAVOR, "a", "J", "getStartTime", "()J", "setStartTime", "(J)V", "startTime", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", BuildConfig.FLAVOR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class GiftListRecyclerView extends RecyclerView {
    public long a;

    public GiftListRecyclerView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public GiftListRecyclerView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public final long getStartTime() {
        return this.a;
    }

    public final boolean onInterceptTouchEvent(MotionEvent r6) {
        if (r6 == null) goto L4;
        Integer r0 = Integer.valueOf(r6.getAction());
    L5:
        if (r0 != null) goto L8;
    L10:
        if (r0 == null) goto L19;
        if (r0.intValue() != 2) goto L19;
        if ((System.currentTimeMillis() - this.a) <= 500) goto L31;
        return false;
    L31:
        return super.onInterceptTouchEvent(r6);
    L19:
        if (r0 != null) goto L22;
    L24:
        if (r0 != null) goto L27;
    L29:
        this.a = 0;
        goto L31
    L27:
        if (r0.intValue() != 3) goto L29;
    L28:
        this.a = 0;
        goto L31
    L22:
        if (r0.intValue() != 1) goto L24;
    L8:
        if (r0.intValue() != 0) goto L10;
        this.a = System.currentTimeMillis();
        goto L31
    L4:
        r0 = null;
        goto L5
    }

    public final void setStartTime(long r1) {
        this.a = r1;
    }

    public GiftListRecyclerView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
    }

    public /* synthetic */ GiftListRecyclerView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
