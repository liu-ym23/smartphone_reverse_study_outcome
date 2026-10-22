package com.bytedance.android.livesdk.chatroom.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\nB'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/widget/AnimationLayer;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", "ctx", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "livedynamic_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AnimationLayer extends FrameLayout {

    public static final class a {
    }

    static {
    }

    public AnimationLayer(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public AnimationLayer(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public AnimationLayer(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "ctx");
        super(r2, r3, r4);
        FrameLayout r5 = new FrameLayout(getContext());
        r5.setClipChildren(false);
        r5.setTag("no_clip_children_container");
        addView(r5, -1, -1);
    }

    public /* synthetic */ AnimationLayer(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
