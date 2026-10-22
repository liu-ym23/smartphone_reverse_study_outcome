package com.bytedance.android.livesdk.gift.platform.business.effect.giftview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.GiftSwitchImageView;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.NewGiftSwitchImageView;
import com.bytedance.bdlocation.BuildConfig;
import io.reactivex.disposables.Disposable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/effect/giftview/LynxVideoView;", "Landroid/widget/FrameLayout;", "getVideoContainer", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", BuildConfig.FLAVOR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LynxVideoView extends FrameLayout {
    public final FrameLayout a;
    public final GiftSwitchImageView b;
    public final NewGiftSwitchImageView c;
    public boolean d;
    public Disposable e;

    public LynxVideoView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public LynxVideoView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public final FrameLayout getVideoContainer() {
        return this.a;
    }

    public LynxVideoView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        LayoutInflater.from(r2).inflate(2131567675, this, true);
        this.a = (FrameLayout) findViewById(2131379311);
        this.b = (GiftSwitchImageView) findViewById(2131387878);
        this.c = (NewGiftSwitchImageView) findViewById(2131387884);
    }

    public /* synthetic */ LynxVideoView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
