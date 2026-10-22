package com.ss.android.lark.feed.cardcomponent.preview;

import android.content.Context;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.content.ContextCompat;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.log.Log;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u0000 82\u00020\u0001:\u00018B\u001d\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0006\u0010!\u001a\u00020\"J\u0006\u0010#\u001a\u00020\"J\u0015\u0010$\u001a\u00020\"2\b\u0010%\u001a\u0004\u0018\u00010\u000f¢\u0006\u0002\u0010&J\u0006\u0010'\u001a\u00020\"J)\u0010(\u001a\u00020\"2\b\u0010)\u001a\u0004\u0018\u00010\t2\b\u0010*\u001a\u0004\u0018\u00010+2\b\u0010,\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010-J\u0006\u0010.\u001a\u00020\"J\u001a\u0010/\u001a\u00020\"2\u0006\u00100\u001a\u00020 2\b\b\u0002\u00101\u001a\u000202H\u0002J\b\u00103\u001a\u00020\"H\u0014J\u0010\u00104\u001a\u00020\"2\u0006\u00105\u001a\u000202H\u0016J\b\u00106\u001a\u00020\"H\u0002J\b\u00107\u001a\u00020\"H\u0002R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020 0\u001fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u00069"}, d2 = {"Lcom/ss/android/lark/feed/cardcomponent/preview/FeedVCStatusIconView;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "dotIconSize", BuildConfig.FLAVOR, "dotIconEndMargin", "lottieIconSize", "lottieIconPadding", "lottieIconEndMargin", "recordingDotTranslationY", BuildConfig.FLAVOR, "uploadIconSize", "uploadIconEndMargin", "summarizingIconSize", "summarizingIconEndMargin", "dotIconDrawable", "Landroid/graphics/drawable/ShapeDrawable;", "connectedIcon", "Landroidx/appcompat/widget/AppCompatImageView;", "uploadingIcon", "Lcom/ss/android/lark/feed/cardcomponent/preview/FileSyncingView;", "recordingIcon", "Lcom/ss/android/lark/feed/cardcomponent/preview/RecordingDotView;", "summarizingIcon", "Lcom/ss/android/lark/feed/cardcomponent/preview/SummarizingProgressView;", "iconSet", BuildConfig.FLAVOR, "Landroid/view/View;", "setRecordingMode", BuildConfig.FLAVOR, "setRecordingPausedMode", "setUploadMode", "progress", "(Ljava/lang/Float;)V", "setConnectedMode", "setSummarizingMode", "progressSpeed", "progressStartTime", BuildConfig.FLAVOR, "startProgress", "(Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/Integer;)V", "setViewGone", "setViewVisible", "visibleView", "breathingEnabled", BuildConfig.FLAVOR, "onDetachedFromWindow", "onVisibilityAggregated", "isVisible", "startUploadingRotation", "stopUploadingRotation", "Companion", "feed-card-component_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FeedVCStatusIconView extends LinearLayout {
    public final FileSyncingView a;
    public final RecordingDotView b;
    public final SummarizingProgressView c;
    public final Set<View> d;

    public static final class a {
    }

    static {
    }

    public final void a() {
        FileSyncingView r0 = this.a;
        r0.getClass();
        Log.d("FileSyncingView", "startRotateAnim");
        MinuteHardwareSyncBarDashedLoadingView r1 = r0.a;
        if (r1 != null) goto L5;
        return;
    L5:
        if (r1.o == false) goto L8;
        return;
    L8:
        if (r1.getVisibility() == 0) goto L10;
        return;
    L10:
        if (r1.p == true) goto L13;
        return;
    L13:
        if (r1.getLayerType() == 2) goto L15;
        r1.setLayerType(2, null);
    L15:
        r1.o = true;
        r1.removeCallbacks(r1.q);
        r1.post(r1.q);
    }

    public final void b() {
        FileSyncingView r0 = this.a;
        r0.getClass();
        Log.d("FileSyncingView", "stopRotateAnim");
        MinuteHardwareSyncBarDashedLoadingView r1 = r0.a;
        if (r1 == null) goto L6;
        r1.b();
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.b.b();
        b();
        this.c.getClass();
    }

    public FeedVCStatusIconView(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, null);
    }

    @Override // android.view.View
    public final void onVisibilityAggregated(boolean r12) {
        if (r12 == true) goto L4;
    L6:
        if (r12 == true) goto L9;
        b();
    L9:
        if (this.c.getVisibility() != 0) goto L16;
        if (r12 == false) goto L15;
        SummarizingProgressView r0 = this.c;
        r0.getClass();
        if (r0.isShown() == false) goto L16;
        long r1 = System.currentTimeMillis() / 1000;
        int r2 = (int) RangesKt.coerceIn(((double) r0.b) + (RangesKt.coerceAtLeast(r1 - r1, 0) * ((double) 0)), 1.0d, 99.0d);
        r0.getClass();
        r0.a.setProgress(r2);
        goto L16
    L15:
        this.c.getClass();
    L16:
        super.onVisibilityAggregated(r12);
        return;
    L4:
        if (this.a.getVisibility() != 0) goto L6;
        a();
        goto L6
    }

    public final void setUploadMode(Float r6) {
        FileSyncingView r0 = this.a;
        setVisibility(0);
        r0.setVisibility(0);
        Iterator<T> r2 = this.d.iterator();
    L4:
        if (r2.hasNext() == false) goto L9;
        View r3 = (View) r2.next();
        if (Intrinsics.areEqual(r3, r0) == true) goto L4;
        r3.setVisibility(8);
        goto L4
    L9:
        if (Intrinsics.areEqual(r0, this.a) == false) goto L11;
        a();
    L13:
        if (Intrinsics.areEqual(r0, this.b) == false) goto L15;
        this.b.setBreathingEnabled(false);
    L17:
        if (Intrinsics.areEqual(r0, this.c) == true) goto L19;
        SummarizingProgressView r1 = this.c;
        r1.getClass();
        r1.b = 1;
        r1.getClass();
        r1.a.setProgress(0);
    L19:
        FileSyncingView r4 = this.a;
        if (r6 == null) goto L22;
        float r7 = r6.floatValue();
    L23:
        r4.setProgress(r7);
        return;
    L22:
        r7 = 0.0f;
        goto L23
    L15:
        this.b.b();
        goto L17
    L11:
        b();
        goto L13
    }

    public FeedVCStatusIconView(Context r18, AttributeSet r19) {
        Intrinsics.checkNotNullParameter(r18, "context");
        super(r18, r19);
        int r3 = UIUtils.dp2px(r18, 6.0f);
        int r4 = UIUtils.dp2px(r18, 4.0f);
        int r6 = UIUtils.dp2px(r18, 16.0f);
        int r7 = UIUtils.dp2px(r18, 3.0f);
        int r8 = UIUtils.dp2px(r18, 2.0f);
        float r9 = UIUtils.dp2px(r18, 1.0f);
        int r5 = UIUtils.dp2px(r18, 16.0f);
        int r10 = UIUtils.dp2px(r18, 6.0f);
        int r11 = UIUtils.dp2px(r18, 14.0f);
        int r2 = UIUtils.dp2px(r18, 6.0f);
        ShapeDrawable r12 = new ShapeDrawable(new OvalShape());
        r12.setIntrinsicWidth(r3);
        r12.setIntrinsicHeight(r3);
        r12.getPaint().setColor(ContextCompat.getColor(r18, 2131101113));
        r12.setBounds(0, 0, r3, r3);
        LinkedHashSet r14 = new LinkedHashSet();
        this.d = r14;
        LinearLayout.LayoutParams r15 = new LinearLayout.LayoutParams(-2, -1);
        r15.gravity = 16;
        setLayoutParams(r15);
        AppCompatImageView r16 = new AppCompatImageView(r18);
        r16.setScaleType(ImageView.ScaleType.FIT_CENTER);
        r16.setAdjustViewBounds(true);
        r16.setImageDrawable(r12);
        r16.setVisibility(8);
        LinearLayout.LayoutParams r17 = new LinearLayout.LayoutParams(r3, r3);
        r17.gravity = 16;
        r17.setMargins(0, 0, r4, 0);
        r16.setLayoutParams(r17);
        r16.setImageTintList(null);
        addView(r16);
        FileSyncingView r110 = new FileSyncingView(r18);
        LinearLayout.LayoutParams r13 = new LinearLayout.LayoutParams(r5, r5);
        r13.gravity = 16;
        r13.setMargins(0, 0, r10, 0);
        r110.setLayoutParams(r13);
        r110.setVisibility(8);
        this.a = r110;
        addView(r110);
        RecordingDotView r20 = new RecordingDotView(r18, null, 6, 0);
        LinearLayout.LayoutParams r111 = new LinearLayout.LayoutParams(r6, r6);
        r111.gravity = 16;
        r111.setMargins(0, 0, r8, 0);
        r20.setLayoutParams(r111);
        r20.setPadding(r7, r7, r7, r7);
        r20.setTranslationY(r9);
        r20.setVisibility(8);
        this.b = r20;
        addView(r20);
        SummarizingProgressView r21 = new SummarizingProgressView(r18, null, 6, 0);
        LinearLayout.LayoutParams r1 = new LinearLayout.LayoutParams(r11, r11);
        r1.gravity = 16;
        r1.setMargins(0, 0, r2, 0);
        r21.setLayoutParams(r1);
        r21.setVisibility(8);
        this.c = r21;
        addView(r21);
        r14.add(r16);
        r14.add(r110);
        r14.add(r20);
        r14.add(r21);
    }
}
