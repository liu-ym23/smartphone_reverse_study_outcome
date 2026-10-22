package com.larus.common_ui.widget.input;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.util.AttributeSet;
import android.view.View;
import androidx.lifecycle.LifecycleCoroutineScope;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.ArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0012\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 U2\u00020\u00012\u00020\u0002:\u0001UB\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006B\u001b\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u0005\u0010\tB#\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\u0005\u0010\fJ\u001a\u00101\u001a\u0002022\u0006\u0010\u0003\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0002J\b\u00103\u001a\u000202H\u0002J(\u00104\u001a\u0002022\u0006\u00105\u001a\u00020\u000b2\u0006\u00106\u001a\u00020\u000b2\u0006\u00107\u001a\u00020\u000b2\u0006\u00108\u001a\u00020\u000bH\u0014J\u0010\u00109\u001a\u0002022\u0006\u0010:\u001a\u00020;H\u0014J\b\u0010<\u001a\u000202H\u0002J0\u0010=\u001a\u0012\u0012\u0004\u0012\u00020 0\"j\b\u0012\u0004\u0012\u00020 `#2\u0016\u0010>\u001a\u0012\u0012\u0004\u0012\u00020 0\"j\b\u0012\u0004\u0012\u00020 `#H\u0002J\u0010\u0010?\u001a\u00020 2\u0006\u0010@\u001a\u00020 H\u0002J\u000e\u0010A\u001a\u0002022\u0006\u0010B\u001a\u00020CJ\u000e\u0010D\u001a\u0002022\u0006\u0010E\u001a\u00020\u0010J\u000e\u0010F\u001a\u0002022\u0006\u0010G\u001a\u00020\u0010J\u0016\u0010H\u001a\u0002022\u0006\u0010I\u001a\u00020CH\u0096@¢\u0006\u0002\u0010JJ\b\u0010K\u001a\u000202H\u0016J\b\u0010L\u001a\u000202H\u0016J\b\u0010M\u001a\u00020NH\u0016J\u0010\u0010O\u001a\u0002022\u0006\u0010P\u001a\u00020QH\u0016J\u0012\u0010R\u001a\u0002022\b\u0010S\u001a\u0004\u0018\u00010TH\u0016R\u000e\u0010\r\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000bX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010!\u001a\u0012\u0012\u0004\u0012\u00020 0\"j\b\u0012\u0004\u0012\u00020 `#X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010$\u001a\u0012\u0012\u0004\u0012\u00020 0\"j\b\u0012\u0004\u0012\u00020 `#X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010%\u001a\u0012\u0012\u0004\u0012\u00020 0\"j\b\u0012\u0004\u0012\u00020 `#X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010&\u001a\u0012\u0012\u0004\u0012\u00020 0\"j\b\u0012\u0004\u0012\u00020 `#X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020)X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010+\u001a\u00020,8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b/\u00100\u001a\u0004\b-\u0010.¨\u0006V"}, d2 = {"Lcom/larus/common_ui/widget/input/AudioVisualizerEx;", "Landroid/view/View;", "Lcom/larus/common_ui/widget/input/audiowave/IAudioWaveView;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "duration", "density", "visualizerWidth", "", "visualizerHeight", "_visualizerWidth", "_visualizerHeight", "barWidth", "gapWidth", "sideMargin", "minBarHeight", "maxBarHeight", "_minBarHeight", "_maxBarHeight", "barColor", "alphaNum", "paint", "Landroid/graphics/Paint;", "maxSampleData", "", "prepareData", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "lastData", "currentData", "nextData", "times", "frameTime", "", "maxTimes", "lifecycleScope", "Landroidx/lifecycle/LifecycleCoroutineScope;", "getLifecycleScope", "()Landroidx/lifecycle/LifecycleCoroutineScope;", "lifecycleScope$delegate", "Lkotlin/Lazy;", "init", "", "initData", "onSizeChanged", "w", "h", "oldw", "oldh", "onDraw", "canvas", "Landroid/graphics/Canvas;", "handleData", "copy", "target", "optSample", "sample", "setAudioData", "data", "", "setWidth", "width", "setHeight", "height", "updateAudioData", "audioData", "([BLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "startWaveAnim", "stopWaveAnim", "isAnimating", "", "setWaveTintList", "tint", "Landroid/content/res/ColorStateList;", "setWaveTintMode", "mode", "Landroid/graphics/PorterDuff$Mode;", "Companion", "common-ui_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AudioVisualizerEx extends View {
    public static final /* synthetic */ int w = 0;
    public final int a;
    public final float b;
    public float c;
    public float d;
    public float e;
    public float f;
    public final float g;
    public final float h;
    public final float i;
    public float j;
    public float k;
    public final int l;
    public Paint m;
    public final double n;
    public ArrayList<Double> o;
    public ArrayList<Double> p;
    public ArrayList<Double> q;
    public ArrayList<Double> r;
    public int s;
    public final long t;
    public final int u;
    public final Lazy v;

    public static final class a {
    }

    /* JADX INFO: renamed from: com.larus.common_ui.widget.input.AudioVisualizerEx$setAudioData$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.common_ui.widget.input.AudioVisualizerEx$setAudioData$1", f = "AudioVisualizerEx.kt", i = {}, l = {219}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ byte[] $data;
        int label;
        final /* synthetic */ AudioVisualizerEx this$0;

        public AnonymousClass1(byte[] r1, AudioVisualizerEx r2, Continuation<? super AnonymousClass1> r3) {
            this.$data = r1;
            this.this$0 = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new AnonymousClass1(this.$data, this.this$0, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r4) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r4);
        L11:
            this.this$0.o = (ArrayList) r4;
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r4);
            int r5 = com.larus.common_ui.widget.input.a.a;
            byte[] r6 = this.$data;
            int r2 = this.this$0.a;
            this.label = 1;
            r4 = com.larus.common_ui.widget.input.a.a(r6, r2, this);
            if (r4 != r0) goto L11;
            return r0;
        }
    }

    static {
    }

    public void setWaveTintList(ColorStateList r2) {
        Intrinsics.checkNotNullParameter(r2, "tint");
    }

    public void setWaveTintMode(PorterDuff.Mode r1) {
    }

    private final LifecycleCoroutineScope getLifecycleScope() {
        return (LifecycleCoroutineScope) this.v.getValue();
    }

    public final void b() {
        int r2 = 0;
        if (this.s != this.u) goto L5;
        this.q = a(this.r);
        this.p = a(this.r);
        this.r = a(this.o);
        this.s = 0;
        return;
    L5:
        int r0 = this.a;
    L6:
        if (r2 >= r0) goto L18;
        if (this.p.size() <= r2) goto L10;
        Double r1 = (Double) ListProtector.get(this.p, r2);
    L11:
        Intrinsics.checkNotNull(r1);
        double r5 = r1.doubleValue();
        if (this.r.size() <= r2) goto L14;
        Double r3 = (Double) ListProtector.get(this.r, r2);
    L15:
        Intrinsics.checkNotNull(r3);
        double r4 = r3.doubleValue();
        if (this.q.size() <= r2) goto L18;
        ListProtector.set(this.q, r2, Double.valueOf(r5 + ((((double) this.s) * (r4 - r5)) / ((double) this.u))));
        r2 = r2 + 1;
        goto L6
    L14:
        r3 = Double.valueOf(0.0d);
        goto L15
    L10:
        r1 = Double.valueOf(0.0d);
    L18:
        this.s++;
    }

    public final void c() {
        Paint r0 = new Paint();
        r0.setAntiAlias(true);
        r0.setFilterBitmap(true);
        r0.setStrokeCap(Paint.Cap.ROUND);
        r0.setColor(this.l);
        this.m = r0;
        d();
        postInvalidate();
    }

    public final void d() {
        int r0 = this.a;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        this.o.add(Double.valueOf(0.0d));
        r1 = r1 + 1;
        goto L3
    L5:
        this.p = a(this.o);
        this.r = a(this.o);
        this.q = a(this.o);
    }

    public AudioVisualizerEx(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        super(r5);
        this.a = 45;
        float r0 = i5.J();
        this.b = r0;
        this.c = 0.0f;
        this.d = r0;
        this.e = i5.N();
        this.f = i5.z();
        this.g = i5.W();
        float r1 = i5.j0();
        this.h = r1;
        float r2 = i5.Q();
        this.i = r2;
        this.j = r1;
        this.k = r2;
        this.l = -1;
        this.n = 0.1d;
        this.o = new ArrayList(45);
        this.p = new ArrayList(45);
        this.q = new ArrayList(45);
        this.r = new ArrayList(45);
        this.t = 10;
        this.u = (int) (((long) 40) / 10);
        this.v = LazyKt.lazy(new b(this));
        c();
    }

    public static ArrayList a(ArrayList r1) {
        ArrayList r0 = new ArrayList();
        r0.addAll(r1);
        return r0;
    }

    @Override // android.view.View
    public final void onDraw(Canvas r17) {
        Intrinsics.checkNotNullParameter(r17, "canvas");
        super.onDraw(r17);
        b();     // Catch: NullPointerException -> L5
    L8:
        if ((!this.q.isEmpty()) == false) goto L18;
        Paint r0 = this.m;
        Intrinsics.checkNotNull(r0);
        r0.setStrokeWidth(this.e);
        float r10 = 2;
        float r1 = (getWidth() - this.c) / r10;
        float r11 = (getHeight() - this.d) / r10;
        int r12 = this.q.size();
        int r13 = 0;
    L10:
        if (r13 >= r12) goto L18;
        double r2 = Math.abs(((Number) ListProtector.get(this.q, r13)).doubleValue());
        if (r2 >= 0.01d) goto L14;
        double r3 = 0.0d;
    L17:
        float r4 = this.j;
        float r7 = this.k;
        float r5 = ((float) (((double) r4) + ((r3 * ((double) (r7 - r4))) / this.n))) / r10;
        float r6 = (r7 / r10) + r5;
        float r8 = (r7 / r10) - r5;
        float r9 = this.e;
        float r14 = (r13 * (this.f + r9)) + (r9 / r10);
        Paint r15 = this.m;
        Intrinsics.checkNotNull(r15);
        int r16 = this.l;
        r15.setColor(Color.argb(255, (r16 >> 16) & 255, (r16 >> 8) & 255, r16 & 255));
        float r18 = r14 + r1;
        float r20 = r8 + r11;
        Paint r21 = this.m;
        Intrinsics.checkNotNull(r21);
        r17.drawLine(r18, r6 + r11, r18, r20, r21);
        r13 = r13 + 1;
        goto L10
    L14:
        r3 = r2 * ((double) 2);
        double r22 = this.n;
        if (r3 <= r22) goto L17;
        r3 = r22;
    L18:
        postInvalidateDelayed(this.t);
        return;
    L5:
        e = move-exception;
        FLogger.a.d("AudioVisualizerEx", "onDraw called, handleData() throw NullPointerException, e.message = " + e.getMessage());
        d();
        goto L8
    }

    public final void setAudioData(byte[] r10) {
        Intrinsics.checkNotNullParameter(r10, "data");
        FLogger.a.i("AudioVisualizerEx", "setAudioData called, current calculate Thread = " + ThreadMethodProxy.currentThread().getName());
        BuildersKt.launch$default(getLifecycleScope(), Dispatchers.getMain(), null, new AnonymousClass1(r10, this, null), 2, null);
    }

    public final void setHeight(float r2) {
        int r3 = (int) r2;
        getLayoutParams().height = r3;
        requestLayout();
    }

    public final void setWidth(float r2) {
        int r3 = (int) r2;
        getLayoutParams().width = r3;
        requestLayout();
    }

    public AudioVisualizerEx(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r3, r4);
        this.a = 45;
        float r5 = i5.J();
        this.b = r5;
        this.c = 0.0f;
        this.d = r5;
        this.e = i5.N();
        this.f = i5.z();
        this.g = i5.W();
        float r6 = i5.j0();
        this.h = r6;
        float r0 = i5.Q();
        this.i = r0;
        this.j = r6;
        this.k = r0;
        this.l = -1;
        this.n = 0.1d;
        this.o = new ArrayList(45);
        this.p = new ArrayList(45);
        this.q = new ArrayList(45);
        this.r = new ArrayList(45);
        this.t = 10;
        this.u = (int) (((long) 40) / 10);
        this.v = LazyKt.lazy(new b(this));
        c();
    }

    public AudioVisualizerEx(Context r3, AttributeSet r4, int r5) {
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r3, r4, r5);
        this.a = 45;
        float r6 = i5.J();
        this.b = r6;
        this.c = 0.0f;
        this.d = r6;
        this.e = i5.N();
        this.f = i5.z();
        this.g = i5.W();
        float r7 = i5.j0();
        this.h = r7;
        float r8 = i5.Q();
        this.i = r8;
        this.j = r7;
        this.k = r8;
        this.l = -1;
        this.n = 0.1d;
        this.o = new ArrayList(45);
        this.p = new ArrayList(45);
        this.q = new ArrayList(45);
        this.r = new ArrayList(45);
        this.t = 10;
        this.u = (int) (((long) 40) / 10);
        this.v = LazyKt.lazy(new b(this));
        c();
    }

    @Override // android.view.View
    public final void onSizeChanged(int r3, int r4, int r5, int r6) {
        super.onSizeChanged(r3, r4, r5, r6);
        float r7 = this.e;
        int r8 = this.a;
        float r9 = (r7 * r8) + (this.f * (r8 - 1));
        float r10 = getWidth() - (2 * this.g);
        if (r10 > r9) goto L6;
        r9 = r10;
    L6:
        this.c = r9;
        float r11 = getHeight();
        float r12 = this.b;
        if (r11 > r12) goto L10;
        r12 = getHeight();
    L10:
        this.d = r12;
        float r13 = this.c;
        int r14 = this.a;
        float r15 = (1.0f * r13) / r14;
        float r0 = this.e;
        if (r0 > r15) goto L14;
        r15 = r0;
    L14:
        this.e = r15;
        this.f = (r13 - (r15 * r14)) / (r14 - 1);
        float r16 = this.i;
        if (r12 <= r16) goto L17;
        float r17 = r16;
    L18:
        this.k = r17;
        float r18 = this.h;
        if (r12 <= r18) goto L24;
        if (r16 <= r18) goto L26;
        r12 = r18;
    L27:
        this.j = r12;
        return;
    L26:
        r12 = r16;
        goto L27
    L24:
        if (r16 <= r12) goto L26;
    L17:
        r17 = r12;
        goto L18
    }
}
