package com.larus.dora.impl.device.manage.widget;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.core.view.ViewCompat;
import com.larus.common_ui.refresh.AbsRefreshHeaderLayout;
import com.larus.common_ui.refresh.SuperSwipeRefreshLayout;
import com.larus.dora.impl.resource.DoraDrawableDensity;
import com.larus.dora.impl.resource.DoraResourceDeviceType;
import com.larus.dora.impl.resource.j0;
import com.larus.utils.e1;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0004\u0018\u0000 #2\u00020\u0001:\u0001#B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ\u001a\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0002J\b\u0010\u0015\u001a\u00020\u0014H\u0016J\u0018\u0010\u0016\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\nH\u0016J\u001a\u0010\u001a\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\u001a\u0010\u001d\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\u0010\u0010\u001e\u001a\u00020\u00142\u0006\u0010\u001f\u001a\u00020 H\u0002J\b\u0010!\u001a\u00020\u0014H\u0002J\b\u0010\"\u001a\u00020\u0014H\u0002R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lcom/larus/dora/impl/device/manage/widget/DoraGDeviceManagementRefreshHeader;", "Lcom/larus/common_ui/refresh/AbsRefreshHeaderLayout;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "loadingView", "Landroid/widget/ImageView;", "fakeRefreshingAnimator", "Landroid/animation/ValueAnimator;", "fakeFinishAnimator", "rotationAnimator", "Landroid/animation/ObjectAnimator;", "init", "", "resetState", "dispatchTopAndBottomOffset", "refreshLayout", "Lcom/larus/common_ui/refresh/SuperSwipeRefreshLayout;", "offset", "dispatchRefreshing", "listener", "Landroid/animation/Animator$AnimatorListener;", "dispatchRefreshCancel", "setHeaderViewScale", "scale", "", "startRotationAnimation", "stopRotationAnimation", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DoraGDeviceManagementRefreshHeader extends AbsRefreshHeaderLayout {
    public ImageView a;
    public ValueAnimator b;
    public ValueAnimator c;
    public ObjectAnimator d;

    public static final class a {
    }

    static {
    }

    @Override // com.larus.common_ui.refresh.AbsRefreshHeaderLayout
    public final void d() {
        setHeaderViewScale(0.0f);
        ImageView r0 = this.a;
        if (r0 == null) goto L5;
        e1.o(r0);
    L5:
        ObjectAnimator r1 = this.d;
        if (r1 == null) goto L8;
        r1.cancel();
    L8:
        this.d = null;
    }

    public DoraGDeviceManagementRefreshHeader(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        e(r2);
    }

    private final void setHeaderViewScale(float r3) {
        if (r3 > 0.0f) goto L6;
        r3 = 0.0f;
    L8:
        ImageView r0 = this.a;
        if (r0 == null) goto L11;
        r0.setScaleX(r3);
    L11:
        ImageView r1 = this.a;
        if (r1 == null) goto L15;
        r1.setScaleY(r3);
        return;
    L15:
        return;
    L6:
        if (r3 < 1.0f) goto L8;
        r3 = 1.0f;
        goto L8
    }

    @Override // com.larus.common_ui.refresh.AbsRefreshHeaderLayout
    public final void b(SuperSwipeRefreshLayout r5) {
        Intrinsics.checkNotNullParameter(r5, "refreshLayout");
        g49.d.d("DoraGDeviceManagementRefreshHeader", "dispatchRefreshing...");
        ImageView r6 = this.a;
        if (r6 == null) goto L5;
        e1.x(r6);
    L5:
        ObjectAnimator r7 = this.d;
        if (r7 == null) goto L8;
        r7.cancel();
    L8:
        this.d = null;
        ImageView r8 = this.a;
        if (r8 == null) goto L11;
        ObjectAnimator r9 = ObjectAnimator.ofFloat(r8, "rotation", new float[]{r8.getRotation(), r8.getRotation() + 360.0f});
        r9.setDuration(1000);
        r9.setRepeatCount(-1);
        r9.setInterpolator(new LinearInterpolator());
        r9.start();
        this.d = r9;
    L11:
        ValueAnimator r10 = this.b;
        if (r10 == null) goto L14;
        r10.cancel();
    L14:
        ValueAnimator r11 = this.c;
        if (r11 == null) goto L17;
        r11.cancel();
    L17:
        setHeaderViewScale(1.0f);
        ValueAnimator r12 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        r12.addListener(new e());
        r12.setInterpolator(new LinearInterpolator());
        r12.setDuration(200);
        r12.start();
        this.b = r12;
    }

    public final void e(Context r8) {
        FrameLayout.inflate(r8, 2131562187, this);
        ImageView r0 = (ImageView) findViewById(2131383333);
        this.a = r0;
        if (r0 == null) goto L6;
        r0.setImageDrawable(j0.f(j0.a, r8, DoraResourceDeviceType.G1, "larus_dora_g_device_management_loading_ios", DoraDrawableDensity.XXHDPI, 8));
        return;
    }

    public DoraGDeviceManagementRefreshHeader(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3);
        e(r2);
    }

    @Override // com.larus.common_ui.refresh.AbsRefreshHeaderLayout
    public final void a(SuperSwipeRefreshLayout r3, q19.c r4) {
        Intrinsics.checkNotNullParameter(r3, "refreshLayout");
        g49.d.d("DoraGDeviceManagementRefreshHeader", "dispatchRefreshCancel...");
        ImageView r5 = this.a;
        if (r5 == null) goto L5;
        e1.o(r5);
    L5:
        ObjectAnimator r6 = this.d;
        if (r6 == null) goto L8;
        r6.cancel();
    L8:
        this.d = null;
        ValueAnimator r7 = this.b;
        if (r7 == null) goto L11;
        r7.cancel();
    L11:
        ValueAnimator r8 = this.c;
        if (r8 == null) goto L14;
        r8.cancel();
    L14:
        ValueAnimator r9 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        r9.addListener(new d());
        r9.setInterpolator(new LinearInterpolator());
        r9.addListener(r4);
        r9.setDuration(200);
        r9.start();
        this.c = r9;
    }

    @Override // com.larus.common_ui.refresh.AbsRefreshHeaderLayout
    public final void c(SuperSwipeRefreshLayout r6, int r7) {
        Intrinsics.checkNotNullParameter(r6, "refreshLayout");
        g49.d.d("DoraGDeviceManagementRefreshHeader", "dispatchTopAndBottomOffset... offset=" + r7);
        ViewCompat.offsetTopAndBottom(this, r7);
        int r0 = getBottom();
        int r1 = getMeasuredHeight();
        if (r7 <= 0) goto L7;
        ImageView r2 = this.a;
        if (r2 == null) goto L7;
        e1.x(r2);
    L7:
        ValueAnimator r3 = this.b;
        boolean r4 = false;
        if (r3 != null) goto L10;
    L15:
        boolean r5 = false;
    L16:
        if (r5 == true) goto L42;
        ValueAnimator r8 = r6.v;
        if (r8 != null) goto L20;
    L22:
        boolean r9 = false;
    L23:
        if (r9 == true) goto L33;
        ValueAnimator r10 = r6.w;
        if (r10 != null) goto L27;
    L29:
        boolean r11 = false;
    L30:
        if (r11 == true) goto L33;
        boolean r12 = false;
    L34:
        if (r12 == true) goto L42;
        setHeaderViewScale(1.0f);
        if (r6.f == true) goto L54;
        float r13 = (r7 / r1) * 360.0f;
        ImageView r14 = this.a;
        if (r14 == null) goto L55;
        r14.setRotation(r13);
        return;
    L55:
        return;
    L54:
        return;
    L27:
        if (r10.isRunning() == false) goto L29;
        r11 = true;
    L33:
        r12 = true;
        goto L34
    L20:
        if (r8.isRunning() == false) goto L22;
        r9 = true;
    L42:
        ValueAnimator r15 = r6.w;
        if (r15 != null) goto L45;
    L47:
        if (r4 == false) goto L56;
        float r16 = r0;
        float r17 = r1 * 0.5f;
        float r18 = (r16 - r17) / r17;
        if (r18 >= 0.0f) goto L52;
        r18 = 0.0f;
    L52:
        setHeaderViewScale(r18);
        return;
    L56:
        return;
    L45:
        if (r15.isRunning() == false) goto L47;
        r4 = true;
        goto L47
    L10:
        if (r3.isRunning() != true) goto L12;
        boolean r20 = true;
    L13:
        if (r20 == false) goto L15;
        r5 = true;
        goto L16
    L12:
        r20 = false;
        goto L13
    }

    public DoraGDeviceManagementRefreshHeader(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        e(r2);
    }
}
