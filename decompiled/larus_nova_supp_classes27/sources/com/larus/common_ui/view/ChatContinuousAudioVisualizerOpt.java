package com.larus.common_ui.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.View;
import com.larus.utils.l0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0012\n\u0002\b\t\n\u0002\u0010\u0006\n\u0002\b\u0007\u0018\u0000 S2\u00020\u00012\u00020\u0002:\u0002RSB\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006B\u001b\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u0005\u0010\tB#\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\u0005\u0010\fJ\u0012\u0010(\u001a\u00020)2\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0002J(\u0010*\u001a\u00020)2\u0006\u0010+\u001a\u00020\u000b2\u0006\u0010,\u001a\u00020\u000b2\u0006\u0010-\u001a\u00020\u000b2\u0006\u0010.\u001a\u00020\u000bH\u0014J\u001a\u0010/\u001a\u00020)2\u0006\u00100\u001a\u00020\u000b2\b\b\u0002\u00101\u001a\u000202H\u0002J\u0018\u00103\u001a\u00020)2\u0006\u00104\u001a\u00020\u00012\u0006\u00105\u001a\u00020\u000bH\u0014J\u0006\u00106\u001a\u00020)J\u0010\u00107\u001a\u00020)2\u0006\u00108\u001a\u000209H\u0014J\u0010\u0010:\u001a\u00020)2\u0006\u0010;\u001a\u00020\u000fH\u0002J\u0018\u0010<\u001a\u00020)2\u0006\u0010=\u001a\u00020\u001b2\u0006\u00108\u001a\u000209H\u0002J\u0010\u0010>\u001a\u00020)2\u0006\u00105\u001a\u00020\u000bH\u0016J\u0010\u0010?\u001a\u00020)2\u0006\u0010@\u001a\u00020\u000bH\u0016J\u0010\u0010A\u001a\u00020)2\u0006\u0010B\u001a\u00020CH\u0016J\u0010\u0010D\u001a\u00020)2\u0006\u0010E\u001a\u000202H\u0016J\u0018\u0010F\u001a\u00020)2\u0006\u0010G\u001a\u00020\u000b2\u0006\u0010H\u001a\u000202H\u0016J\u0010\u0010I\u001a\u00020)2\u0006\u0010J\u001a\u00020\u000bH\u0016J\u0010\u0010K\u001a\u00020\u000f2\u0006\u0010L\u001a\u00020MH\u0002J\u0010\u0010N\u001a\u00020)2\u0006\u0010O\u001a\u00020\u000fH\u0002J\b\u0010P\u001a\u00020\u000fH\u0002J\u0006\u0010Q\u001a\u00020)R\u000e\u0010\r\u001a\u00020\u000bX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u001e0\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\"\u001a\u00020#8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b$\u0010%¨\u0006T"}, d2 = {"Lcom/larus/common_ui/view/ChatContinuousAudioVisualizerOpt;", "Landroid/view/View;", "Lcom/larus/common_ui/view/IAudioVisualizer;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "density", "barWidth", "", "gapWidth", "sideMargin", "minBarHeight", "maxBarHeight", "barCountInGroup", "topGroupCount", "visualizerWidth", "waveGroupNumber", "amplitude", "Ljava/util/LinkedList;", "lastTime", "", "barParams", "", "Lcom/larus/common_ui/view/ChatContinuousAudioVisualizerOpt$BarParam;", "barCount", "paint", "Landroid/graphics/Paint;", "lifecycleScope", "Lkotlinx/coroutines/CoroutineScope;", "getLifecycleScope", "()Lkotlinx/coroutines/CoroutineScope;", "lifecycleScope$delegate", "Lkotlin/Lazy;", "init", "", "onSizeChanged", "w", "h", "oldw", "oldh", "ensureCapacity", "capacity", "force", "", "onVisibilityChanged", "changedView", "visibility", "resetData", "onDraw", "canvas", "Landroid/graphics/Canvas;", "genBarData", "currAmp", "drawBars", "stage", "changeVisibility", "setColor", "color", "setAudioData", "data", "", "switchPostInvalidateDelayed", "enable", "setMultipleFactor", "multipleFactor", "needOpt", "setFps", "fps", "optAmplitude", "before", "", "setAmplitude", "value", "getAmplitude", "clearData", "BarParam", "Companion", "common-ui_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ChatContinuousAudioVisualizerOpt extends View implements u {
    public static final /* synthetic */ int q = 0;
    public final int a;
    public final float b;
    public final float c;
    public float d;
    public float e;
    public float f;
    public int g;
    public int h;
    public float i;
    public int j;
    public final LinkedList<Float> k;
    public long l;
    public final Map<Integer, a> m;
    public int n;
    public final Paint o;
    public final Lazy p;

    public static final class a {
        public int a;
        public int b;
        public float c;
        public float d;
        public float e;

        public a() {
            this(0);
        }

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof a) == true) goto L8;
            return false;
        L8:
            a r6 = (a) r5;
            if (this.a == r6.a) goto L12;
            return false;
        L12:
            if (this.b == r6.b) goto L15;
            return false;
        L15:
            if (Float.compare(this.c, r6.c) == 0) goto L18;
            return false;
        L18:
            if (Float.compare(this.d, r6.d) == 0) goto L21;
            return false;
        L21:
            if (Float.compare(this.e, r6.e) == 0) goto L23;
            return false;
        L23:
            return true;
        }

        public final int hashCode() {
            return (((((((this.a * 31) + this.b) * 31) + Float.floatToIntBits(this.c)) * 31) + Float.floatToIntBits(this.d)) * 31) + Float.floatToIntBits(this.e);
        }

        public final String toString() {
            return "BarParam(barType=" + this.a + ", groupType=" + this.b + ", barHeight=" + this.c + ", curBarHeight=" + this.d + ", change=" + this.e + ')';
        }

        public a(int r1) {
            this.a = 2;
            this.b = 2;
            this.c = 0.0f;
            this.d = 0.0f;
            this.e = 0.0f;
        }
    }

    public static final class b {
    }

    /* JADX INFO: renamed from: com.larus.common_ui.view.ChatContinuousAudioVisualizerOpt$setAudioData$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.common_ui.view.ChatContinuousAudioVisualizerOpt$setAudioData$1", f = "ChatContinuousAudioVisualizerOpt.kt", i = {}, l = {316}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ byte[] $data;
        int label;
        final /* synthetic */ ChatContinuousAudioVisualizerOpt this$0;

        public AnonymousClass1(byte[] r1, ChatContinuousAudioVisualizerOpt r2, Continuation<? super AnonymousClass1> r3) {
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

        public final Object invokeSuspend(Object r6) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r6);
        L11:
            Iterator r7 = ((ArrayList) r6).iterator();
            if (r7.hasNext() == true) goto L14;
            Double r8 = null;
        L19:
            if (r8 == null) goto L21;
            double r2 = r8.doubleValue();
        L22:
            ChatContinuousAudioVisualizerOpt r9 = this.this$0;
            int r3 = ChatContinuousAudioVisualizerOpt.q;
            r9.getClass();
            if (r2 <= 0.5d) goto L25;
            double r4 = 1.0d;
        L26:
            ChatContinuousAudioVisualizerOpt.e(r9, RangesKt.coerceAtMost(((float) r4) * 2.5f, 1.0f));
            return Unit.INSTANCE;
        L25:
            r4 = Math.sin(r2 * 3.141592653589793d);
            goto L26
        L21:
            r2 = 0.0d;
            goto L22
        L14:
            double r5 = Math.abs(((Number) r7.next()).doubleValue());
        L16:
            if (r7.hasNext() == false) goto L18;
            r5 = Math.max(r5, Math.abs(((Number) r7.next()).doubleValue()));
            goto L16
        L18:
            r8 = Boxing.boxDouble(r5);
            goto L19
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r6);
            int r10 = com.larus.common_ui.widget.input.a.a;
            byte[] r11 = this.$data;
            int r12 = this.this$0.a;
            this.label = 1;
            r6 = com.larus.common_ui.widget.input.a.a(r11, r12, this);
            if (r6 != r0) goto L11;
            return r0;
        }
    }

    static {
    }

    @Override // com.larus.common_ui.view.u
    public final void b() {
    }

    @Override // com.larus.common_ui.view.u
    public final void c(boolean r1) {
    }

    @Override // com.larus.common_ui.view.u
    public void setFps(int r1) {
    }

    private final float getAmplitude() {
        Float r0 = CollectionsKt.maxOrNull(this.k);
        if (r0 == null) goto L5;
        float r1 = r0.floatValue();
    L6:
        this.k.clear();
        return Math.min(r1 * 1.5f, 1.0f);
    L5:
        r1 = 0.0f;
        goto L6
    }

    private final CoroutineScope getLifecycleScope() {
        return (CoroutineScope) this.p.getValue();
    }

    public ChatContinuousAudioVisualizerOpt(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r3);
        this.a = 45;
        float r4 = i5.N();
        this.b = r4;
        this.c = i5.z();
        this.d = i5.l0();
        this.e = i5.N();
        this.f = i5.d0();
        this.g = 5;
        this.h = 3;
        this.k = new LinkedList();
        this.m = new LinkedHashMap();
        Paint r0 = new Paint();
        r0.setAntiAlias(true);
        r0.setFilterBitmap(true);
        r0.setStrokeCap(Paint.Cap.ROUND);
        r0.setStrokeWidth(r4);
        r0.setColor(-1);
        this.o = r0;
        this.p = LazyKt.lazy(new g(this));
    }

    public static CoroutineScope d(final ChatContinuousAudioVisualizerOpt r2) {
        int r0 = l0.a;
        return (CoroutineScope) l0.a(CoroutineScopeKt.MainScope(), new h(r2));
    }

    private final void setAmplitude(float r2) {
        this.k.offer(Float.valueOf(r2));
        if (this.k.size() <= 10) goto L6;
        this.k.poll();
        return;
    }

    @Override // com.larus.common_ui.view.u
    public final void a(int r1) {
        setVisibility(r1);
    }

    public final void g(AttributeSet r4) {
        if (r4 == null) goto L5;
        TypedArray r5 = getContext().obtainStyledAttributes(r4, new int[]{2130970526, 2130970527, 2130970528, 2130971622, 2130972257, 2130972345});
        this.f = r5.getDimension(1, this.f);
        this.e = r5.getDimension(2, this.e);
        this.d = r5.getDimension(4, this.d);
        this.g = r5.getInteger(3, this.g);
        this.h = r5.getInteger(5, this.h);
        this.o.setColor(r5.getColor(0, -1));
        r5.recycle();
        return;
    }

    @Override // android.view.View
    public final void onDraw(Canvas r25) {
        Intrinsics.checkNotNullParameter(r25, "canvas");
        super.onDraw(r25);
        long r1 = SystemClock.elapsedRealtime();
        long r3 = r1 - this.l;
        int r12 = 2;
        int r14 = 1;
        if (r3 < 400) goto L71;
        this.l = r1;
        float r2 = getAmplitude();
        if (r3 < 800) goto L7;
        r2 = 0.0f;
        r3 = 0;
    L8:
        int r4 = this.j / 2;
        if (this.h != 1) goto L11;
        int r5 = r4 + 1;
    L12:
        int r6 = this.j;
        if (1 > r6) goto L71;
        int r7 = 1;
    L16:
        if (r7 != r5) goto L18;
        float r11 = 1.0f;
    L26:
        if (r7 != r5) goto L28;
        int r15 = 0;
    L36:
        int r9 = Random.Default.nextInt(r12, this.g);
        float r10 = RangesKt.coerceAtLeast((this.f * r2) * r11, this.e);
        float r13 = RangesKt.coerceAtLeast((0.7f * r10) * r11, this.e);
        float r16 = RangesKt.coerceAtLeast(r11 * (0.4f * r10), this.e);
        int r17 = this.g;
        if (r14 > r17) goto L68;
    L38:
        float r22 = r2;
        int r21 = ((r7 - 1) * this.g) + r14;
        int r23 = r4;
        a r8 = this.m.get(Integer.valueOf(r21));
        if (r8 == null) goto L41;
        r8.b = r15;
    L41:
        if (r14 != r9) goto L48;
        a r18 = this.m.get(Integer.valueOf(r21));
        if (r18 == null) goto L45;
        r18.a = 0;
    L45:
        a r20 = this.m.get(Integer.valueOf(r21));
        if (r20 == null) goto L66;
        r20.c = r10;
    L66:
        if (r14 == r17) goto L69;
        r14 = r14 + 1;
        r2 = r22;
        r4 = r23;
    L69:
        if (r7 == r6) goto L71;
        r7 = r7 + 1;
        r2 = r22;
        r4 = r23;
        r12 = 2;
        r14 = 1;
        goto L16
    L48:
        int r24 = r9 - 1;
        if (r14 > (r9 + 1)) goto L52;
        if (r24 > r14) goto L52;
        boolean r26 = true;
    L53:
        if (r26 == false) goto L60;
        a r27 = this.m.get(Integer.valueOf(r21));
        if (r27 == null) goto L57;
        r27.a = 1;
    L57:
        a r28 = this.m.get(Integer.valueOf(r21));
        if (r28 == null) goto L66;
        r28.c = r13;
        goto L66
    L60:
        a r30 = this.m.get(Integer.valueOf(r21));
        if (r30 == null) goto L63;
        r30.a = 2;
    L63:
        a r31 = this.m.get(Integer.valueOf(r21));
        if (r31 == null) goto L66;
        r31.c = r16;
    L52:
        r26 = false;
        goto L53
    L68:
        r22 = r2;
        r23 = r4;
        goto L69
    L28:
        if (r4 <= r7) goto L30;
    L32:
        boolean r110 = false;
    L33:
        if (r110 == false) goto L35;
        r15 = 1;
        goto L36
    L35:
        r15 = 2;
        goto L36
    L30:
        if (r7 > (r4 + 3)) goto L32;
        r110 = true;
        goto L33
    L18:
        int r111 = r5 - 1;
        if (r7 > (r5 + 1)) goto L22;
        if (r111 > r7) goto L22;
        boolean r112 = true;
    L23:
        if (r112 == false) goto L25;
        r11 = (Random.Default.nextFloat() * 0.2f) + 0.6f;
        goto L26
    L25:
        r11 = (Random.Default.nextFloat() * 0.1f) + 0.4f;
    L22:
        r112 = false;
        goto L23
    L11:
        r5 = Random.Default.nextInt(r4, r4 + 3);
        goto L12
    L7:
        r3 = r3 - ((long) 400);
    L71:
        long r32 = r3;
        if (this.h != 1) goto L74;
        float r33 = 0.0f;
    L75:
        int r113 = this.n;
        if (1 > r113) goto L210;
        int r114 = 1;
    L78:
        a r34 = this.m.get(Integer.valueOf(r114));
        if (r34 == null) goto L208;
        int r35 = r34.b;
        if (r35 == 0) goto L84;
    L86:
        boolean r36 = false;
    L87:
        if (r35 != 0) goto L91;
        int r37 = 1;
        if (r34.a != 1) goto L92;
    L95:
        boolean r38 = true;
    L97:
        if (r35 == 0) goto L99;
    L102:
        int r115 = 1;
        if (r35 == 1) goto L105;
    L107:
        boolean r40 = false;
    L108:
        if (r35 != r115) goto L112;
        int r116 = 2;
        if (r34.a != 2) goto L113;
    L114:
        boolean r41 = true;
    L117:
        if (0 <= r32) goto L119;
    L121:
        boolean r42 = false;
    L123:
        if (r42 == false) goto L133;
        if (r36 == false) goto L207;
        float r43 = r34.d;
        if (r43 > 0.0f) goto L129;
        r43 = this.e;
    L129:
        r34.e = (r34.c - r43) / 20;
    L207:
        float r44 = RangesKt.coerceAtLeast(r34.d + r34.e, this.e);
        r34.d = r44;
        float r45 = (getHeight() - r44) / 2;
        r33 = r33 + (this.b + this.c);
        r25.drawLine(r33, r45, r33, r45 + r44, this.o);
        goto L208
    L133:
        if (50 <= r32) goto L135;
    L137:
        boolean r46 = false;
    L138:
        if (r46 == false) goto L146;
        if (r38 == false) goto L207;
        float r47 = r34.d;
        if (r47 > 0.0f) goto L144;
        r47 = this.e;
    L144:
        r34.e = (r34.c - r47) / 20;
        goto L207
    L146:
        if (100 <= r32) goto L148;
    L150:
        boolean r48 = false;
    L151:
        if (r48 == false) goto L159;
        if (r40 == false) goto L207;
        float r50 = r34.d;
        if (r50 > 0.0f) goto L157;
        r50 = this.e;
    L157:
        r34.e = (r34.c - r50) / 20;
        goto L207
    L159:
        if (150 <= r32) goto L161;
    L163:
        boolean r51 = false;
    L164:
        if (r51 == false) goto L172;
        if (r41 == false) goto L207;
        float r52 = r34.d;
        if (r52 > 0.0f) goto L170;
        r52 = this.e;
    L170:
        r34.e = (r34.c - r52) / 20;
        goto L207
    L172:
        if (200 <= r32) goto L174;
    L176:
        boolean r53 = false;
    L177:
        if (r53 == false) goto L181;
        if (r36 == false) goto L207;
        r34.e = (this.e - r34.c) / 20;
        goto L207
    L181:
        if (250 <= r32) goto L183;
    L185:
        boolean r54 = false;
    L186:
        if (r54 == false) goto L190;
        if (r38 == false) goto L207;
        r34.e = (this.e - r34.c) / 20;
        goto L207
    L190:
        if (300 <= r32) goto L192;
    L194:
        boolean r55 = false;
    L195:
        if (r55 == false) goto L199;
        if (r40 == false) goto L207;
        r34.e = (this.e - r34.c) / 20;
        goto L207
    L199:
        if (350 <= r32) goto L201;
    L203:
        boolean r56 = false;
    L204:
        if (r56 == false) goto L207;
        if (r41 == false) goto L207;
        r34.e = (this.e - r34.c) / 20;
        goto L207
    L201:
        if (r32 >= 400) goto L203;
        r56 = true;
        goto L204
    L192:
        if (r32 >= 350) goto L194;
        r55 = true;
        goto L195
    L183:
        if (r32 >= 300) goto L185;
        r54 = true;
        goto L186
    L174:
        if (r32 >= 250) goto L176;
        r53 = true;
        goto L177
    L161:
        if (r32 >= 200) goto L163;
        r51 = true;
        goto L164
    L148:
        if (r32 >= 150) goto L150;
        r48 = true;
        goto L151
    L135:
        if (r32 >= 100) goto L137;
        r46 = true;
        goto L138
    L119:
        if (r32 >= 50) goto L121;
        r42 = true;
    L113:
        if (r35 == r116) goto L114;
        r41 = false;
        goto L117
    L112:
        r116 = 2;
        goto L113
    L105:
        if (r34.a != 1) goto L107;
    L106:
        r40 = true;
        goto L108
    L99:
        if (r34.a != 2) goto L102;
        r115 = 1;
    L92:
        if (r35 == r37) goto L94;
    L96:
        r38 = false;
        goto L97
    L94:
        if (r34.a != 0) goto L96;
    L91:
        r37 = 1;
        goto L92
    L84:
        if (r34.a != 0) goto L86;
        r36 = true;
    L208:
        if (r114 == r113) goto L210;
        r114 = r114 + 1;
    L210:
        postInvalidateDelayed(10);
        return;
    L74:
        r33 = (getWidth() - this.i) / 2;
        goto L75
    }

    @Override // com.larus.common_ui.view.u
    public void setAudioData(byte[] r8) {
        Intrinsics.checkNotNullParameter(r8, "data");
        BuildersKt.launch$default(getLifecycleScope(), Dispatchers.getMain(), null, new AnonymousClass1(r8, this, null), 2, null);
    }

    @Override // com.larus.common_ui.view.u
    public void setColor(int r2) {
        this.o.setColor(r2);
    }

    public ChatContinuousAudioVisualizerOpt(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r3, r4);
        this.a = 45;
        float r5 = i5.N();
        this.b = r5;
        this.c = i5.z();
        this.d = i5.l0();
        this.e = i5.N();
        this.f = i5.d0();
        this.g = 5;
        this.h = 3;
        this.k = new LinkedList();
        this.m = new LinkedHashMap();
        Paint r0 = new Paint();
        r0.setAntiAlias(true);
        r0.setFilterBitmap(true);
        r0.setStrokeCap(Paint.Cap.ROUND);
        r0.setStrokeWidth(r5);
        r0.setColor(-1);
        this.o = r0;
        this.p = LazyKt.lazy(new g(this));
        g(r4);
    }

    public static final /* synthetic */ void e(ChatContinuousAudioVisualizerOpt r0, float r1) {
        r0.setAmplitude(r1);
    }

    public final void f(int r5, boolean r6) {
        Map<Integer, a> r0 = this.m;
        LinkedHashMap r1 = (LinkedHashMap) r0;
        if (r1.get(Integer.valueOf(r5)) == null) goto L6;
        if (r6 == true) goto L6;
        return;
    L6:
        ((LinkedHashMap) this.m).clear();
        int r7 = 1;
        if (1 > r5) goto L11;
    L8:
        Integer r2 = Integer.valueOf(r7);
        this.m.put(r2, new a(0));
        if (r7 == r5) goto L13;
        r7 = r7 + 1;
        goto L8
    L13:
        return;
    }

    @Override // android.view.View
    public final void onVisibilityChanged(View r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "changedView");
        super.onVisibilityChanged(r2, r3);
        if (r3 == 0) goto L8;
        int r4 = this.n;
        if (r4 <= 0) goto L9;
        f(r4, true);
        this.l = 0;
        return;
    L9:
        return;
    }

    public ChatContinuousAudioVisualizerOpt(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.a = 45;
        float r5 = i5.N();
        this.b = r5;
        this.c = i5.z();
        this.d = i5.l0();
        this.e = i5.N();
        this.f = i5.d0();
        this.g = 5;
        this.h = 3;
        this.k = new LinkedList();
        this.m = new LinkedHashMap();
        Paint r6 = new Paint();
        r6.setAntiAlias(true);
        r6.setFilterBitmap(true);
        r6.setStrokeCap(Paint.Cap.ROUND);
        r6.setStrokeWidth(r5);
        r6.setColor(-1);
        this.o = r6;
        this.p = LazyKt.lazy(new g(this));
        g(r3);
    }

    @Override // android.view.View
    public final void onSizeChanged(int r1, int r2, int r3, int r4) {
        super.onSizeChanged(r1, r2, r3, r4);
        float r5 = getWidth() - (this.d * 2);
        float r6 = (this.b + this.c) * this.g;
        int r7 = (int) (r5 / r6);
        this.j = r7;
        if ((r7 % 2) != 0) goto L5;
        this.j = r7 - 1;
    L5:
        int r8 = RangesKt.coerceAtLeast(this.j, 3);
        this.j = r8;
        this.i = r8 * r6;
        int r9 = r8 * this.g;
        this.n = r9;
        f(r9, false);
    }
}
