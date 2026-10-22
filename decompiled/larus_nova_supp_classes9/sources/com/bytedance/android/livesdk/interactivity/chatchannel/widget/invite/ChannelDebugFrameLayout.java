package com.bytedance.android.livesdk.interactivity.chatchannel.widget.invite;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.bdlocation.BuildConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/chatchannel/widget/invite/ChannelDebugFrameLayout;", "Landroid/widget/FrameLayout;", "Landroid/view/ViewGroup$LayoutParams;", "params", BuildConfig.FLAVOR, "setLayoutParams", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", BuildConfig.FLAVOR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "interactivity-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class ChannelDebugFrameLayout extends FrameLayout {
    public final String a;

    public ChannelDebugFrameLayout(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public ChannelDebugFrameLayout(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        ViewParent r0 = getParent();
        if ((r0 instanceof ViewGroup) == true) goto L5;
        r0 = null;
    L5:
        ViewGroup r1 = (ViewGroup) r0;
    L6:
        if (r1 == null) goto L14;
        if (Intrinsics.areEqual(r1.getClass().getSimpleName(), "MatchRoomViewPager") == true) goto L9;
        ViewParent r2 = r1.getParent();
        if ((r2 instanceof ViewGroup) == true) goto L13;
        r2 = null;
    L13:
        r1 = (ViewGroup) r2;
        goto L6
    L9:
        return;
    L14:
        ALogger.e(this.a, "not attach to MatchRoomViewPager");
        ViewParent r3 = getParent();
        if ((r3 instanceof ViewGroup) == true) goto L17;
        r3 = null;
    L17:
        ViewGroup r4 = (ViewGroup) r3;
        int r5 = 0;
    L19:
        if (r5 >= 3) goto L28;
        ALogger.e(this.a, String.valueOf(r4));
        if (r4 == null) goto L23;
        ViewParent r6 = r4.getParent();
    L25:
        if ((r6 instanceof ViewGroup) == true) goto L27;
        r6 = null;
    L27:
        r4 = (ViewGroup) r6;
        r5 = r5 + 1;
        goto L19
    L23:
        r6 = null;
        goto L25
    }

    @Override // android.view.View
    public void setLayoutParams(ViewGroup.LayoutParams r4) {
        if (r4 != null) goto L4;
    L6:
        super.setLayoutParams(r4);
        return;
    L4:
        if (r4.height == (-1)) goto L6;
        ALogger.e(this.a, "params.height=" + r4.height, new RuntimeException());
        goto L6
    }

    public ChannelDebugFrameLayout(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.a = "ChannelDebugFrameLayout";
    }

    public /* synthetic */ ChannelDebugFrameLayout(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
