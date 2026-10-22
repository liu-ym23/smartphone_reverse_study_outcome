package com.bytedance.android.live.lynx.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.bytedance.android.livesdkapi.roomplayer.LivePlayerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0010\u0010\u0011R$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/live/lynx/ui/LivePlayerContainer;", "Landroid/widget/FrameLayout;", "Lcom/bytedance/android/livesdkapi/roomplayer/LivePlayerView;", "a", "Lcom/bytedance/android/livesdkapi/roomplayer/LivePlayerView;", "getPlayerView$livehybrid_impl_saasRelease", "()Lcom/bytedance/android/livesdkapi/roomplayer/LivePlayerView;", "setPlayerView$livehybrid_impl_saasRelease", "(Lcom/bytedance/android/livesdkapi/roomplayer/LivePlayerView;)V", "playerView", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyle", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "livehybrid-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LivePlayerContainer extends FrameLayout {
    public LivePlayerView a;

    public LivePlayerContainer(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public LivePlayerContainer(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public final LivePlayerView getPlayerView$livehybrid_impl_saasRelease() {
        return this.a;
    }

    public final void setPlayerView$livehybrid_impl_saasRelease(LivePlayerView r1) {
        this.a = r1;
    }

    public LivePlayerContainer(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
    }

    public /* synthetic */ LivePlayerContainer(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
