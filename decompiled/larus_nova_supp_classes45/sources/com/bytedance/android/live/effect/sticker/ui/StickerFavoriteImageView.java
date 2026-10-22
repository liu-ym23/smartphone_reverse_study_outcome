package com.bytedance.android.live.effect.sticker.ui;

import android.content.Context;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatImageView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0002\u000e\u000fB'\b\u0007\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/live/effect/sticker/ui/StickerFavoriteImageView;", "Landroidx/appcompat/widget/AppCompatImageView;", "Lcom/bytedance/android/live/effect/sticker/ui/StickerFavoriteImageView$b;", "onStateChangeListener", "", "setOnStateChangeListener", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "b", "liveeffect_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class StickerFavoriteImageView extends AppCompatImageView {
    public final float a;
    public final int b;
    public b c;

    public static final class a {
    }

    public interface b {
        void onAnimationEnd();

        void onStateChange(int r1);
    }

    static {
    }

    public StickerFavoriteImageView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public StickerFavoriteImageView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public final void setOnStateChangeListener(b r2) {
        Intrinsics.checkNotNullParameter(r2, "onStateChangeListener");
        this.c = r2;
    }

    public StickerFavoriteImageView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.a = 1.08f;
        this.b = 100;
    }

    public /* synthetic */ StickerFavoriteImageView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
