package com.larus.common_ui;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.view.animation.PathInterpolator;
import android.widget.LinearLayout;
import androidx.cardview.widget.CardView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0005\u0018\u0000 (2\u00020\u0001:\u0001(B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ\b\u0010\u0017\u001a\u00020\u0018H\u0014J\u0006\u0010\u0019\u001a\u00020\u0018J\u0006\u0010\u001a\u001a\u00020\u0018J\b\u0010\u001b\u001a\u00020\u0018H\u0014J\u0010\u0010\u001c\u001a\u00020\u00182\u0006\u0010\u001d\u001a\u00020\u000fH\u0002J\u0016\u0010\u001e\u001a\u00020\u00182\u0006\u0010\u001f\u001a\u00020 H\u0086@¢\u0006\u0002\u0010!J\u000e\u0010\"\u001a\u00020\u00182\u0006\u0010#\u001a\u00020$J\u0010\u0010%\u001a\u00020\u000f2\u0006\u0010#\u001a\u00020$H\u0002J\u0010\u0010&\u001a\u00020\u00182\u0006\u0010'\u001a\u00020\u000fH\u0002R\u000e\u0010\f\u001a\u00020\nX\u0082D¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\u0013X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006)"}, d2 = {"Lcom/larus/common_ui/SoundWaveView;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "density", "amplitude", "", "", "prevScaleY", "barScaleY", "barViewRef", "", "Landroidx/cardview/widget/CardView;", "animators", "Landroid/animation/Animator;", "onAttachedToWindow", "", "pauseAnim", "resumeAnim", "onDetachedFromWindow", "startScaleAnimation", "nextScaleY", "setAudioData", "data", "", "([BLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setVolume", "before", "", "optAmplitude", "setAmplitude", "value", "Companion", "common-ui_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SoundWaveView extends LinearLayout {
    public static final /* synthetic */ int f = 0;
    public final int a;
    public float b;
    public final List<Float> c;
    public final List<CardView> d;
    public final List<? extends Animator> e;

    public static final class a {
    }

    static {
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        Iterator<T> r0 = this.e.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((Animator) r0.next()).start();
        goto L4
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Iterator<T> r0 = this.e.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((Animator) r0.next()).end();
        goto L4
    }

    public SoundWaveView(Context r12) {
        Intrinsics.checkNotNullParameter(r12, "context");
        super(r12);
        this.a = 45;
        new ArrayList(0);
        this.b = 1.0f;
        ArrayList r1 = new ArrayList(4);
        int r3 = 0;
    L3:
        if (r3 >= 4) goto L5;
        r1.add(Float.valueOf(1.0f));
        r3 = r3 + 1;
        goto L3
    L5:
        this.c = r1;
        ArrayList r2 = new ArrayList(7);
        int r4 = 0;
    L6:
        if (r4 >= 7) goto L8;
        CardView r5 = new CardView(getContext());
        LinearLayout.LayoutParams r6 = new LinearLayout.LayoutParams(i5.z(), i5.Y());
        r6.setMargins(i5.b(), 0, i5.b(), 0);
        r5.setLayoutParams(r6);
        r5.setRadius(i5.z());
        r5.setCardElevation(0.0f);
        r5.setCardBackgroundColor(-7829368);
        r2.add(r5);
        r4 = r4 + 1;
        goto L6
    L8:
        this.d = r2;
        this.e = CollectionsKt.emptyList();
        setOrientation(0);
        setGravity(17);
        ArrayList r7 = r2;
        ArrayList r8 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r7, 10));
        Iterator r9 = r7.iterator();
        final int r10 = 0;
    L10:
        if (r9.hasNext() == false) goto L15;
        Object r11 = r9.next();
        int r13 = r10 + 1;
        if (r10 >= 0) goto L14;
        CollectionsKt.throwIndexOverflow();
    L14:
        final CardView r14 = (CardView) r11;
        addView(r14);
        ValueAnimator r15 = ValueAnimator.ofInt(new int[]{i5.Y(), i5.r0(), i5.Y()});
        r15.setInterpolator(new PathInterpolator(0.4f, 0.8f, 0.74f, 1.0f));
        r15.setDuration(1000);
        r15.setStartDelay(Math.abs(((long) (r10 - 3)) * 400));
        r15.setRepeatCount(-1);
        r15.addUpdateListener(new c(r14, this, r10));
        r8.add(r15);
        r10 = r13;
        goto L10
    L15:
        this.e = r8;
    }

    public static float b(double r3) {
        if (r3 <= 0.5d) goto L5;
        double r4 = 1.0d;
    L7:
        return RangesKt.coerceAtMost(((float) r4) * 2.5f, 1.0f);
    L5:
        r4 = Math.sin(r3 * 3.141592653589793d);
        goto L7
    }

    private final void setAmplitude(float r12) {
        FLogger.a.i("SoundWaveView", "next amplitude " + r12);
        float r13 = r12 + 1.0f;
        if (r13 != this.b) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == true) goto L15;
        final int r2 = 0;
    L10:
        if (r2 >= 4) goto L12;
        ValueAnimator r4 = ValueAnimator.ofFloat(new float[]{this.b, r13});
        r4.setDuration(200);
        r4.setInterpolator(new PathInterpolator(0.4f, 0.8f, 0.74f, 1.0f));
        r4.setStartDelay(((long) r2) * 200);
        r4.addUpdateListener(new b(this, r2));
        r4.start();
        r2 = r2 + 1;
        goto L10
    L12:
        this.b = r13;
        return;
    L15:
        return;
    L5:
        r1 = false;
        goto L6
    }

    public final void setVolume(double r1) {
        setAmplitude(b(r1));
    }

    public SoundWaveView(Context r11, AttributeSet r12) {
        Intrinsics.checkNotNullParameter(r11, "context");
        super(r11, r12);
        this.a = 45;
        new ArrayList(0);
        this.b = 1.0f;
        ArrayList r0 = new ArrayList(4);
        int r2 = 0;
    L3:
        if (r2 >= 4) goto L5;
        r0.add(Float.valueOf(1.0f));
        r2 = r2 + 1;
        goto L3
    L5:
        this.c = r0;
        ArrayList r1 = new ArrayList(7);
        int r3 = 0;
    L6:
        if (r3 >= 7) goto L8;
        CardView r4 = new CardView(getContext());
        LinearLayout.LayoutParams r5 = new LinearLayout.LayoutParams(i5.z(), i5.Y());
        r5.setMargins(i5.b(), 0, i5.b(), 0);
        r4.setLayoutParams(r5);
        r4.setRadius(i5.z());
        r4.setCardElevation(0.0f);
        r4.setCardBackgroundColor(-7829368);
        r1.add(r4);
        r3 = r3 + 1;
        goto L6
    L8:
        this.d = r1;
        this.e = CollectionsKt.emptyList();
        setOrientation(0);
        setGravity(17);
        ArrayList r6 = r1;
        ArrayList r7 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r6, 10));
        Iterator r8 = r6.iterator();
        final int r9 = 0;
    L10:
        if (r8.hasNext() == false) goto L15;
        Object r10 = r8.next();
        int r13 = r9 + 1;
        if (r9 >= 0) goto L14;
        CollectionsKt.throwIndexOverflow();
    L14:
        final CardView r14 = (CardView) r10;
        addView(r14);
        ValueAnimator r15 = ValueAnimator.ofInt(new int[]{i5.Y(), i5.r0(), i5.Y()});
        r15.setInterpolator(new PathInterpolator(0.4f, 0.8f, 0.74f, 1.0f));
        r15.setDuration(1000);
        r15.setStartDelay(Math.abs(((long) (r9 - 3)) * 400));
        r15.setRepeatCount(-1);
        r15.addUpdateListener(new c(r14, this, r9));
        r7.add(r15);
        r9 = r13;
        goto L10
    L15:
        this.e = r7;
    }

    public final Object c(byte[] r5, Continuation<? super Unit> r6) {
        if ((r6 instanceof SoundWaveView$setAudioData$1) == false) goto L7;
        SoundWaveView$setAudioData$1 r0 = (SoundWaveView$setAudioData$1) r6;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r7 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        ResultKt.throwOnFailure(r7);
    L17:
        Iterator r8 = ((ArrayList) r7).iterator();
        if (r8.hasNext() == true) goto L20;
        Double r9 = null;
    L25:
        if (r9 == null) goto L27;
        double r10 = r9.doubleValue();
    L28:
        setAmplitude(b(r10));
        return Unit.INSTANCE;
    L27:
        r10 = 0.0d;
        goto L28
    L20:
        double r4 = Math.abs(((Number) r8.next()).doubleValue());
    L22:
        if (r8.hasNext() == false) goto L24;
        r4 = Math.max(r4, Math.abs(((Number) r8.next()).doubleValue()));
        goto L22
    L24:
        r9 = Boxing.boxDouble(r4);
        goto L25
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r7);
        int r11 = com.larus.common_ui.widget.input.a.a;
        int r12 = this.a;
        r0.label = 1;
        r7 = com.larus.common_ui.widget.input.a.a(r5, r12, r0);
        if (r7 != r2) goto L17;
        return r2;
    L7:
        r0 = new SoundWaveView$setAudioData$1(this, r6);
        goto L8
    }

    public SoundWaveView(Context r10, AttributeSet r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "context");
        super(r10, r11, r12);
        this.a = 45;
        new ArrayList(0);
        this.b = 1.0f;
        ArrayList r13 = new ArrayList(4);
        int r1 = 0;
    L3:
        if (r1 >= 4) goto L5;
        r13.add(Float.valueOf(1.0f));
        r1 = r1 + 1;
        goto L3
    L5:
        this.c = r13;
        ArrayList r14 = new ArrayList(7);
        int r2 = 0;
    L6:
        if (r2 >= 7) goto L8;
        CardView r3 = new CardView(getContext());
        LinearLayout.LayoutParams r4 = new LinearLayout.LayoutParams(i5.z(), i5.Y());
        r4.setMargins(i5.b(), 0, i5.b(), 0);
        r3.setLayoutParams(r4);
        r3.setRadius(i5.z());
        r3.setCardElevation(0.0f);
        r3.setCardBackgroundColor(-7829368);
        r14.add(r3);
        r2 = r2 + 1;
        goto L6
    L8:
        this.d = r14;
        this.e = CollectionsKt.emptyList();
        setOrientation(0);
        setGravity(17);
        ArrayList r15 = r14;
        ArrayList r0 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r15, 10));
        Iterator r16 = r15.iterator();
        final int r5 = 0;
    L10:
        if (r16.hasNext() == false) goto L15;
        Object r6 = r16.next();
        int r7 = r5 + 1;
        if (r5 >= 0) goto L14;
        CollectionsKt.throwIndexOverflow();
    L14:
        final CardView r8 = (CardView) r6;
        addView(r8);
        ValueAnimator r9 = ValueAnimator.ofInt(new int[]{i5.Y(), i5.r0(), i5.Y()});
        r9.setInterpolator(new PathInterpolator(0.4f, 0.8f, 0.74f, 1.0f));
        r9.setDuration(1000);
        r9.setStartDelay(Math.abs(((long) (r5 - 3)) * 400));
        r9.setRepeatCount(-1);
        r9.addUpdateListener(new c(r8, this, r5));
        r0.add(r9);
        r5 = r7;
        goto L10
    L15:
        this.e = r0;
    }

    public static void a(CardView r2, SoundWaveView r3, int r4, ValueAnimator r5) {
        Intrinsics.checkNotNullParameter(r5, "it");
        if (r2 == null) goto L5;
        ViewGroup.LayoutParams r0 = r2.getLayoutParams();
    L6:
        if (r0 == null) goto L8;
        Object r6 = r5.getAnimatedValue();
        Intrinsics.checkNotNull(r6, "null cannot be cast to non-null type kotlin.Int");
        r0.height = (int) (((Integer) r6).intValue() * ((Number) ListProtector.get(r3.c, Math.abs(r4 - 3))).floatValue());
    L8:
        if (r2 == null) goto L11;
        r2.setLayoutParams(r0);
        return;
    L11:
        return;
    L5:
        r0 = null;
        goto L6
    }
}
