package com.bytedance.android.livesdk.chatroom.viewmodule.shortterm;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import com.bytedance.android.livesdkapi.sti.framework.IconTemplate;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B'\b\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eR\u0014\u0010\u0006\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/viewmodule/shortterm/CommonIconTemplate;", "Landroid/widget/FrameLayout;", "Lcom/bytedance/android/livesdkapi/sti/framework/IconTemplate;", "Landroid/view/View;", "getView", "()Landroid/view/View;", "view", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "livedynamic_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CommonIconTemplate extends FrameLayout implements IconTemplate {
    public Animator a;

    public CommonIconTemplate(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public CommonIconTemplate(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public View getView() {
        return this;
    }

    public final Animator getEntryAnimation(long r5) {
        getView().setScaleX(0.0f);
        getView().setScaleY(0.0f);
        AnimatorSet r0 = com.bytedance.android.live.core.utils.h.c(getView(), new float[]{1.0f});
        r0.setDuration(250);
        r0.setInterpolator(new DecelerateInterpolator());
        AnimatorSet r1 = new AnimatorSet();
        r1.setStartDelay(r5);
        r1.play(r0);
        return r1;
    }

    public CommonIconTemplate(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
    }

    public /* synthetic */ CommonIconTemplate(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
