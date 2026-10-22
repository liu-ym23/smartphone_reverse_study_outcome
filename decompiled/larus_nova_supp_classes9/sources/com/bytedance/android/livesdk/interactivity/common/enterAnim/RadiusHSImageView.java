package com.bytedance.android.livesdk.interactivity.common.enterAnim;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.bdlocation.BuildConfig;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\n\u0010\u000bJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\f"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/common/enterAnim/RadiusHSImageView;", "Lcom/bytedance/android/live/core/widget/HSImageView;", BuildConfig.FLAVOR, "radius", BuildConfig.FLAVOR, "setRadius", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "interactivity-platform-base_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class RadiusHSImageView extends HSImageView {
    public float a;

    public RadiusHSImageView(Context r2) {
        this(r2, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onDraw(Canvas r6) {
        Intrinsics.checkNotNullParameter(r6, "canvas");
        r6.save();
        Path r0 = new Path();
        RectF r1 = new RectF(0.0f, 0.0f, getWidth(), getHeight());
        float r2 = this.a;
        r0.addRoundRect(r1, r2, r2, Path.Direction.CCW);
        Unit r3 = Unit.INSTANCE;
        r6.clipPath(r0);
        super/*android.widget.ImageView*/.onDraw(r6);
    }

    public final void setRadius(float r1) {
        this.a = r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public RadiusHSImageView(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3);
        setWillNotDraw(false);
    }
}
