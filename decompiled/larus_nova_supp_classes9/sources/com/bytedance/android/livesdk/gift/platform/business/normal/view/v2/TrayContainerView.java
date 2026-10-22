package com.bytedance.android.livesdk.gift.platform.business.normal.view.v2;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.bdlocation.BuildConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0016\u001a\u00020\u0015\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0017\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0019¢\u0006\u0004\b\u001b\u0010\u001cR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\u0011\u001a\u00020\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\"\u0010\u0013\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0004\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\b¨\u0006\u001d"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/normal/view/v2/TrayContainerView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", BuildConfig.FLAVOR, "a", "Z", "getDrawMask", "()Z", "setDrawMask", "(Z)V", "drawMask", BuildConfig.FLAVOR, "b", "F", "getMaskWidth", "()F", "setMaskWidth", "(F)V", "maskWidth", "c", "isPk", "setPk", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", BuildConfig.FLAVOR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class TrayContainerView extends ConstraintLayout {
    public boolean a;
    public float b;
    public boolean c;

    public TrayContainerView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public TrayContainerView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public final boolean getDrawMask() {
        return this.a;
    }

    public final float getMaskWidth() {
        return this.b;
    }

    public final void dispatchDraw(Canvas r8) {
        Intrinsics.checkNotNullParameter(r8, "canvas");
        if (this.a == false) goto L11;
        Path r0 = new Path();
        if (this.c == false) goto L7;
        r0.addRoundRect(new RectF(0.0f, (s1.j(2131168772) - s1.j(2131168685)) - com.bytedance.android.live.revenue.common.i.a(4), this.b, s1.j(2131168772)), s1.j(2131168773), s1.j(2131168773), Path.Direction.CW);
    L8:
        if (r8 == null) goto L10;
        r8.clipPath(r0);
    L10:
        this.a = false;
        goto L11
    L7:
        r0.addRoundRect(new RectF(0.0f, s1.j(2131168771) - s1.j(2131168684), this.b, s1.j(2131168771)), s1.j(2131168773), s1.j(2131168773), Path.Direction.CW);
    L11:
        super.dispatchDraw(r8);
    }

    public final void setDrawMask(boolean r1) {
        this.a = r1;
    }

    public final void setMaskWidth(float r1) {
        this.b = r1;
    }

    public final void setPk(boolean r1) {
        this.c = r1;
    }

    public TrayContainerView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
    }

    public /* synthetic */ TrayContainerView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
