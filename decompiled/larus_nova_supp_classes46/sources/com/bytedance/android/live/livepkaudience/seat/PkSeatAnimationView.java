package com.bytedance.android.live.livepkaudience.seat;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livesdk.chatroom.ui.DynamicEmojiView;
import com.bytedance.android.livesdk.chatroom.ui.e6;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0011\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0015\u0010\u0016J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006J\u000e\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bJ\b\u0010\f\u001a\u0004\u0018\u00010\u000bJ\b\u0010\u000e\u001a\u0004\u0018\u00010\r¨\u0006\u0017"}, d2 = {"Lcom/bytedance/android/live/livepkaudience/seat/PkSeatAnimationView;", "Landroid/widget/FrameLayout;", "Lcom/bytedance/android/live/livepkaudience/seat/d;", "taskChain", "", "setTaskChain", "Lcom/bytedance/android/live/livepkaudience/seat/SeatAnimTaskState;", "getTaskState", "Lcom/bytedance/android/livesdk/chatroom/ui/e6;", "emojiCallback", "setEmojiCallback", "Lcom/bytedance/android/livesdk/chatroom/ui/DynamicEmojiView;", "getDynamicEmojiView", "Lcom/bytedance/android/live/core/widget/HSImageView;", "getEmojiMaskLayer", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "livepkaudience-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PkSeatAnimationView extends FrameLayout {
    public g a;
    public View b;
    public DynamicEmojiView c;
    public HSImageView d;

    public PkSeatAnimationView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public PkSeatAnimationView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public final SeatAnimTaskState getTaskState() {
        g r0 = this.a;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.a;
    }

    public final DynamicEmojiView getDynamicEmojiView() {
        return this.c;
    }

    public final HSImageView getEmojiMaskLayer() {
        return this.d;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    public final void setEmojiCallback(e6 r2) {
        Intrinsics.checkNotNullParameter(r2, "emojiCallback");
        DynamicEmojiView r0 = this.c;
        if (r0 == null) goto L6;
        r0.setEmojiAnimCallback(r2);
        return;
    }

    public final void setTaskChain(d r3) {
        Intrinsics.checkNotNullParameter(r3, "taskChain");
        g r0 = this.a;
        if (r0 == null) goto L6;
        Intrinsics.checkNotNullParameter(r3, "chain");
        r0.b = r3;
        return;
    }

    public PkSeatAnimationView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
    }

    public /* synthetic */ PkSeatAnimationView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
