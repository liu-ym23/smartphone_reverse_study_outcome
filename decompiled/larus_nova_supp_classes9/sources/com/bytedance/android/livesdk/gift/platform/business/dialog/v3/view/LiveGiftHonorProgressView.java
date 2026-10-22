package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.View;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.gift.platform.business.config.GiftConfigKey;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0002\u0007\u001fB\u0011\b\u0016\u0012\u0006\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\u0018\u0010\u0019B\u001b\b\u0016\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a¢\u0006\u0004\b\u0018\u0010\u001cB#\b\u0016\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a\u0012\u0006\u0010\u001d\u001a\u00020\u000e¢\u0006\u0004\b\u0018\u0010\u001eJ\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002R\"\u0010\r\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u0014\u0010\u0011\u001a\u00020\u000e8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0013\u001a\u00020\u000e8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0010R\u0014\u0010\u0015\u001a\u00020\u000e8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0010¨\u0006 "}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/view/LiveGiftHonorProgressView;", "Landroid/view/View;", "Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/view/LiveGiftHonorProgressView$b;", "honorProgressCallBack", BuildConfig.FLAVOR, "setHonorProgressCallBack", BuildConfig.FLAVOR, "a", "F", "getMProgress", "()F", "setMProgress", "(F)V", "mProgress", BuildConfig.FLAVOR, "getHighlightWidth", "()I", "highlightWidth", "getHighlightMargin", "highlightMargin", "getHighlightHeight", "highlightHeight", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "b", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveGiftHonorProgressView extends View {
    public float a;
    public GradientDrawable b;
    public GradientDrawable c;
    public GradientDrawable d;
    public ClipDrawable e;

    public static final class a {
    }

    public interface b {
    }

    static {
    }

    public final void setHonorProgressCallBack(b r1) {
    }

    public final void a() {
        GradientDrawable r0 = new GradientDrawable();
        this.b = r0;
        r0.setShape(0);
        if (getContext() != null) goto L5;
    L13:
        GradientDrawable r1 = this.b;
        if (r1 == null) goto L16;
        r1.setColor(s1.h(2131107744));
    L16:
        GradientDrawable r2 = new GradientDrawable();
        this.d = r2;
        r2.setShape(0);
        GradientDrawable r3 = this.d;
        if (r3 == null) goto L19;
        r3.setColor(ColorProtector.parseColor("#55ffffff"));
    L19:
        Drawable r4 = s1.m(2131249231);
        if ((r4 instanceof ClipDrawable) == false) goto L22;
        this.e = (ClipDrawable) r4;
    L22:
        Drawable r5 = s1.m(2131249236);
        if ((r5 instanceof GradientDrawable) == false) goto L25;
        this.c = (GradientDrawable) r5;
        return;
    L25:
        GradientDrawable r6 = new GradientDrawable();
        this.c = r6;
        r6.setColor(ColorProtector.parseColor("#face15"));
        GradientDrawable r7 = this.c;
        if (r7 == null) goto L30;
        r7.setShape(0);
        return;
    L30:
        return;
    L5:
        if (getContext().getResources() == null) goto L13;
        if (getContext().getResources().getConfiguration() == null) goto L13;
        if (getContext().getResources().getConfiguration().orientation != 2) goto L13;
        GradientDrawable r8 = this.b;
        if (r8 == null) goto L16;
        r8.setColor(ColorProtector.parseColor("#161823"));
        goto L16
    }

    private final int getHighlightHeight() {
        return s1.j(2131168723);
    }

    private final int getHighlightMargin() {
        return s1.j(2131168724);
    }

    private final int getHighlightWidth() {
        return getWidth() - (s1.j(2131168724) * 2);
    }

    public final float getMProgress() {
        return this.a;
    }

    @Override // android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    public LiveGiftHonorProgressView(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        new ArrayList();
        a();
    }

    @Override // android.view.View
    public final void onDraw(Canvas r9) {
        Intrinsics.checkNotNullParameter(r9, "canvas");
        super.onDraw(r9);
        GradientDrawable r0 = this.b;
        if (r0 == null) goto L5;
        r0.setCornerRadius(getHeight() / 2);
    L5:
        GradientDrawable r1 = this.b;
        if (r1 == null) goto L8;
        r1.setBounds(0, 0, getWidth(), getHeight());
    L8:
        int r2 = (int) (getHighlightWidth() * 0.0f);
        GradientDrawable r3 = this.c;
        if (r3 == null) goto L11;
        r3.setBounds(getHighlightMargin(), getHighlightMargin(), r2 + getHighlightMargin(), getHighlightMargin() + getHighlightHeight());
    L11:
        GradientDrawable r4 = this.c;
        if (r4 == null) goto L14;
        r4.setCornerRadius(getHighlightHeight() / 2);
    L14:
        GradientDrawable r5 = this.d;
        if (r5 == null) goto L17;
        r5.setBounds(0, 0, (int) (getWidth() * 0.0f), getHeight());
    L17:
        GradientDrawable r6 = this.d;
        if (r6 == null) goto L20;
        r6.setCornerRadius(getHeight() / 2);
    L20:
        ClipDrawable r7 = this.e;
        if (r7 == null) goto L27;
        if (r7 == null) goto L24;
        r7.setBounds(getHighlightMargin(), getHighlightMargin(), getHighlightWidth() + getHighlightMargin(), getHighlightMargin() + getHighlightHeight());
    L24:
        ClipDrawable r8 = this.e;
        if (r8 == null) goto L27;
        r8.setLevel((int) (10000 * 0.0f));
    L27:
        GradientDrawable r10 = this.b;
        if (r10 == null) goto L31;
        r10.draw(r9);
    L31:
        if (0.0f > 0) goto L33;
    L41:
        GradientDrawable r11 = this.c;
        if (r11 == null) goto L45;
        r11.draw(r9);
        return;
    L45:
        return;
    L33:
        if (((Boolean) com.bytedance.android.livesdk.gift.util.b.a().c(GiftConfigKey.KEY_CORE_HONOR_VIEW_USE_PIC, Boolean.FALSE)).booleanValue() == false) goto L38;
        ClipDrawable r13 = this.e;
        if (r13 == null) goto L38;
        if (r13 == null) goto L41;
        r13.draw(r9);
    L38:
        GradientDrawable r14 = this.d;
        if (r14 == null) goto L41;
        r14.draw(r9);
        goto L41
    }

    public final void setMProgress(float r1) {
        this.a = r1;
    }

    public LiveGiftHonorProgressView(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3);
        new ArrayList();
        a();
    }

    public LiveGiftHonorProgressView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        new ArrayList();
        a();
    }
}
