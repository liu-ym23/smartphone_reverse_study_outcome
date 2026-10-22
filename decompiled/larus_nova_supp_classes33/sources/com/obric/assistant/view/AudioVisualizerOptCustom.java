package com.obric.assistant.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.View;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewTreeLifecycleOwner;
import com.larus.common_ui.utils.ViewExtKt;
import com.obric.assistant.interaction.impl.performance.WindowAnimationBoostCoordinator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u0000 K2\u00020\u0001:\u0002JKB\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ(\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\n2\u0006\u0010+\u001a\u00020\n2\u0006\u0010,\u001a\u00020\n2\u0006\u0010-\u001a\u00020\nH\u0014J\u0010\u0010.\u001a\u00020)2\u0006\u0010/\u001a\u00020\nH\u0002J\u0010\u00100\u001a\u00020)2\u0006\u00101\u001a\u000202H\u0014J\u0010\u00103\u001a\u00020)2\u0006\u00104\u001a\u00020\u000fH\u0002J\u0018\u00105\u001a\u00020)2\u0006\u00106\u001a\u00020\u00192\u0006\u00101\u001a\u000202H\u0002J\u000e\u00107\u001a\u00020)2\u0006\u00108\u001a\u000209J/\u0010:\u001a\u00020)2\u0016\u0010;\u001a\u0012\u0012\u0004\u0012\u00020=0<j\b\u0012\u0004\u0012\u00020=`>2\n\b\u0002\u00108\u001a\u0004\u0018\u000109¢\u0006\u0002\u0010?J\b\u0010@\u001a\u00020)H\u0014J\u0010\u0010A\u001a\u00020\u000f2\u0006\u0010B\u001a\u00020=H\u0002J\u0010\u0010C\u001a\u00020)2\u0006\u0010D\u001a\u00020\u000fH\u0002J\b\u0010E\u001a\u00020\u000fH\u0002J\u000e\u0010F\u001a\u00020)2\u0006\u0010G\u001a\u00020\nJ\u0006\u0010H\u001a\u00020)R\u000e\u0010\f\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\nX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u001c0\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010 \u001a\u00020!8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b\"\u0010#R\u0010\u0010&\u001a\u0004\u0018\u00010'X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010H\u001a\u000209X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010I\u001a\u000209X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u000209X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006L"}, d2 = {"Lcom/obric/assistant/view/AudioVisualizerOptCustom;", "Landroid/view/View;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "customWaveGroupCount", "density", "barWidth", "", "gapWidth", "sideMargin", "minBarHeight", "maxBarHeight", "visualizerWidth", "waveGroupNumber", "amplitude", "Ljava/util/LinkedList;", "lastTime", "", "barParams", "", "Lcom/obric/assistant/view/AudioVisualizerOptCustom$BarParam;", "barCount", "paint", "Landroid/graphics/Paint;", "lifecycleScope", "Lkotlinx/coroutines/CoroutineScope;", "getLifecycleScope", "()Lkotlinx/coroutines/CoroutineScope;", "lifecycleScope$delegate", "Lkotlin/Lazy;", "audioUpdateJob", "Lkotlinx/coroutines/Job;", "onSizeChanged", "", "w", "h", "oldw", "oldh", "ensureCapacity", "capacity", "onDraw", "canvas", "Landroid/graphics/Canvas;", "genBarData", "currAmp", "drawBars", "stage", "updateLongPressStatus", "onLongPress", "", "setAudioData", "sampleData", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "(Ljava/util/ArrayList;Ljava/lang/Boolean;)V", "onDetachedFromWindow", "optAmplitude", "before", "setAmplitude", "value", "getAmplitude", "setCustomWaveGroupCount", "count", "useCustomPaintShader", "alreadyGetAudioData", "BarParam", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AudioVisualizerOptCustom extends View {
    public static final /* synthetic */ int p = 0;
    public int a;
    public final float b;
    public final float c;
    public final float d;
    public final float e;
    public final float f;
    public float g;
    public int h;
    public final LinkedList<Float> i;
    public long j;
    public final Map<Integer, a> k;
    public int l;
    public final Paint m;
    public final Lazy n;
    public volatile boolean o;

    public static final class a {
        public final int a;
        public final int b;
        public final float c;
        public final float d;
        public final float e;

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

        public /* synthetic */ a(int r7) {
            this(2, 2, 0.0f, 0.0f, 0.0f);
        }

        public a(int r1, int r2, float r3, float r4, float r5) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
        }

        public static a a(a r6, int r7, int r8, float r9, float r10, float r11, int r12) {
            if ((r12 & 1) == 0) goto L5;
            r7 = r6.a;
        L5:
            int r1 = r7;
            if ((r12 & 2) == 0) goto L8;
            r8 = r6.b;
        L8:
            int r2 = r8;
            if ((r12 & 4) == 0) goto L11;
            r9 = r6.c;
        L11:
            float r3 = r9;
            if ((r12 & 8) == 0) goto L14;
            r10 = r6.d;
        L14:
            float r4 = r10;
            if ((r12 & 16) == 0) goto L18;
            r11 = r6.e;
        L18:
            return new a(r1, r2, r3, r4, r11);
        }
    }

    public static final class b {
    }

    static {
    }

    private final float getAmplitude() {
        Float r0 = CollectionsKt.maxOrNull(this.i);
        if (r0 == null) goto L5;
        float r1 = r0.floatValue();
    L6:
        this.i.clear();
        return r1;
    L5:
        r1 = 0.0f;
        goto L6
    }

    private final CoroutineScope getLifecycleScope() {
        return (CoroutineScope) this.n.getValue();
    }

    @Override // android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    public AudioVisualizerOptCustom(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r3);
        float r4 = i5.N();
        this.b = r4;
        this.c = i5.z();
        this.d = i5.l0();
        this.e = i5.N();
        this.f = i5.d0();
        this.i = new LinkedList();
        this.k = new LinkedHashMap();
        Paint r0 = new Paint();
        r0.setAntiAlias(true);
        r0.setFilterBitmap(true);
        r0.setStrokeCap(Paint.Cap.ROUND);
        r0.setStrokeWidth(r4);
        r0.setColor(-1);
        this.m = r0;
        this.n = LazyKt.lazy(new com.obric.assistant.view.a(this));
    }

    public static CoroutineScope a(AudioVisualizerOptCustom r2) {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L4
        Object r1 = Result.constructor-impl(LifecycleOwnerKt.getLifecycleScope(ViewExtKt.f(r2)));     // Catch: Throwable -> L4
    L7:
        if (Result.exceptionOrNull-impl(r1) == null) goto L16;
        LifecycleOwner r3 = ViewTreeLifecycleOwner.get(r2);
        if (r3 == null) goto L14;
        r1 = LifecycleOwnerKt.getLifecycleScope(r3);
        if (r1 != null) goto L16;
    L14:
        r1 = CoroutineScopeKt.MainScope();
    L16:
        return (CoroutineScope) r1;
    L4:
        th = move-exception;
        Result.Companion r4 = Result.Companion;
        r1 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L7
    }

    private final void setAmplitude(float r2) {
        this.i.offer(Float.valueOf(r2));
        if (this.i.size() <= 10) goto L6;
        this.i.poll();
        return;
    }

    @Override // android.view.View
    public final void onDraw(Canvas r33) {
        Intrinsics.checkNotNullParameter(r33, "canvas");
        super.onDraw(r33);
        long r1 = SystemClock.elapsedRealtime();
        long r3 = r1 - this.j;
        int r13 = 2;
        if (r3 < 400) goto L56;
        this.j = r1;
        float r2 = getAmplitude();
        if (r3 < 800) goto L7;
        r2 = 0.0f;
        r3 = 0;
    L8:
        int r4 = this.h / 2;
        int r6 = r4 + 3;
        int r5 = Random.Default.nextInt(r4, r6);
        int r7 = this.h;
        if (1 > r7) goto L56;
        int r12 = 1;
    L11:
        if (r12 != r5) goto L13;
        float r11 = 1.0f;
    L22:
        if (r12 != r5) goto L24;
        int r15 = 0;
    L31:
        int r9 = Random.Default.nextInt(r13, 5);
        float r14 = RangesKt.coerceAtLeast((this.f * r2) * r11, this.e);
        float r18 = r14 * 0.7f;
        float r28 = r2;
        float r8 = RangesKt.coerceAtLeast(r18 * r11, this.e);
        float r10 = RangesKt.coerceAtLeast(r11 * (r18 * 0.7f), this.e);
        int r16 = 1;
    L33:
        if (r16 >= 6) goto L52;
        int r17 = ((r12 - 1) * 5) + r16;
        if (r16 != r9) goto L39;
        int r29 = r4;
        long r30 = r3;
        a r19 = (a) ((LinkedHashMap) this.k).get(Integer.valueOf(r17));
        if (r19 == null) goto L51;
        a r20 = a.a(r19, 0, r15, r14, 0.0f, 0.0f, 24);
        this.k.put(Integer.valueOf(r17), r20);
    L51:
        r16 = r16 + 1;
        r4 = r29;
        r3 = r30;
        goto L33
    L39:
        r29 = r4;
        r30 = r3;
        int r21 = r9 - 1;
        if (r16 > (r9 + 1)) goto L43;
        if (r21 > r16) goto L43;
        boolean r22 = true;
    L44:
        if (r22 == false) goto L48;
        a r110 = (a) ((LinkedHashMap) this.k).get(Integer.valueOf(r17));
        if (r110 == null) goto L51;
        a r23 = a.a(r110, 1, r15, r8, 0.0f, 0.0f, 24);
        this.k.put(Integer.valueOf(r17), r23);
        goto L51
    L48:
        a r111 = (a) ((LinkedHashMap) this.k).get(Integer.valueOf(r17));
        if (r111 == null) goto L51;
        a r24 = a.a(r111, 2, r15, r10, 0.0f, 0.0f, 24);
        this.k.put(Integer.valueOf(r17), r24);
    L43:
        r22 = false;
        goto L44
    L52:
        int r210 = r4;
        long r31 = r3;
        if (r12 == r7) goto L57;
        r12 = r12 + 1;
        r2 = r28;
        r4 = r210;
        r3 = r31;
        r13 = 2;
    L57:
        float r25 = 2;
        float r26 = ((getWidth() - this.g) / r25) + (this.b / r25);
        int r112 = this.l;
        if (1 > r112) goto L200;
        int r113 = 1;
    L60:
        a r27 = (a) ((LinkedHashMap) this.k).get(Integer.valueOf(r113));
        if (r27 == null) goto L198;
        int r32 = r27.b;
        if (r32 == 0) goto L66;
    L68:
        boolean r34 = false;
    L69:
        if (r32 != 0) goto L73;
        int r35 = 1;
        if (r27.a != 1) goto L74;
    L77:
        boolean r36 = true;
    L79:
        if (r32 == 0) goto L81;
    L84:
        int r37 = 1;
        if (r32 == 1) goto L87;
    L89:
        boolean r38 = false;
    L90:
        if (r32 != r37) goto L94;
        int r114 = 2;
        if (r27.a != 2) goto L95;
    L96:
        boolean r39 = true;
    L98:
        float r40 = r27.e;
        if (0 <= r31) goto L101;
    L103:
        boolean r115 = false;
    L105:
        if (r115 == false) goto L114;
        if (r34 == false) goto L193;
        float r41 = r27.d;
        if (r41 > 0.0f) goto L111;
        r41 = this.e;
    L111:
        float r42 = r27.c;
    L153:
        float r211 = (r42 - r41) / 20;
    L194:
        float r43 = RangesKt.coerceAtLeast(r27.d + r211, this.e);
        this.k.put(Integer.valueOf(r113), a.a(r27, 0, 0, 0.0f, r43, r211, 7));
        float r44 = (getHeight() - r43) / r25;
        if (r113 <= 1) goto L197;
        r26 = r26 + (this.b + this.c);
    L197:
        r33.drawLine(r26, r44, r26, r44 + r43, this.m);
    L193:
        r211 = r40;
        goto L194
    L114:
        if (50 <= r31) goto L116;
    L118:
        boolean r116 = false;
    L119:
        if (r116 == false) goto L127;
        if (r36 == false) goto L193;
        r41 = r27.d;
        if (r41 > 0.0f) goto L125;
        r41 = this.e;
    L125:
        r42 = r27.c;
        goto L153
    L127:
        if (100 <= r31) goto L129;
    L131:
        boolean r117 = false;
    L132:
        if (r117 == false) goto L141;
        if (r38 == false) goto L193;
        r41 = r27.d;
        if (r41 > 0.0f) goto L138;
        r41 = this.e;
    L138:
        r42 = r27.c;
        goto L153
    L141:
        if (150 <= r31) goto L143;
    L145:
        boolean r118 = false;
    L146:
        if (r118 == false) goto L155;
        if (r39 == false) goto L193;
        r41 = r27.d;
        if (r41 > 0.0f) goto L152;
        r41 = this.e;
    L152:
        r42 = r27.c;
        goto L153
    L155:
        if (200 <= r31) goto L157;
    L159:
        boolean r119 = false;
    L160:
        if (r119 == false) goto L164;
        if (r34 == false) goto L193;
        float r45 = this.e;
        float r46 = r27.c;
    L192:
        r211 = (r45 - r46) / 20;
        goto L194
    L164:
        if (250 <= r31) goto L166;
    L168:
        boolean r47 = false;
    L169:
        if (r47 == false) goto L173;
        if (r36 == false) goto L193;
        r45 = this.e;
        r46 = r27.c;
        goto L192
    L173:
        if (300 <= r31) goto L175;
    L177:
        boolean r120 = false;
    L178:
        if (r120 == false) goto L184;
        if (r38 == false) goto L193;
        r45 = this.e;
        r46 = r27.c;
        goto L192
    L184:
        if (350 <= r31) goto L186;
    L188:
        boolean r48 = false;
    L189:
        if (r48 == false) goto L193;
        if (r39 == false) goto L193;
        r45 = this.e;
        r46 = r27.c;
        goto L192
    L186:
        if (r31 >= 400) goto L188;
        r48 = true;
        goto L189
    L175:
        if (r31 >= 350) goto L177;
        r120 = true;
        goto L178
    L166:
        if (r31 >= 300) goto L168;
        r47 = true;
        goto L169
    L157:
        if (r31 >= 250) goto L159;
        r119 = true;
        goto L160
    L143:
        if (r31 >= 200) goto L145;
        r118 = true;
        goto L146
    L129:
        if (r31 >= 150) goto L131;
        r117 = true;
        goto L132
    L116:
        if (r31 >= 100) goto L118;
        r116 = true;
        goto L119
    L101:
        if (r31 >= 50) goto L103;
        r115 = true;
    L95:
        if (r32 == r114) goto L96;
        r39 = false;
        goto L98
    L94:
        r114 = 2;
        goto L95
    L87:
        if (r27.a != 1) goto L89;
    L88:
        r38 = true;
        goto L90
    L81:
        if (r27.a != 2) goto L84;
        r37 = 1;
    L74:
        if (r32 == r35) goto L76;
    L78:
        r36 = false;
        goto L79
    L76:
        if (r27.a != 0) goto L78;
    L73:
        r35 = 1;
        goto L74
    L66:
        if (r27.a != 0) goto L68;
        r34 = true;
    L198:
        if (r113 == r112) goto L200;
        r113 = r113 + 1;
    L200:
        postInvalidateDelayed(10);
        return;
    L24:
        if (r4 > r12) goto L27;
        if (r12 > r6) goto L27;
        boolean r121 = true;
    L28:
        if (r121 == false) goto L30;
        r15 = 1;
        goto L31
    L30:
        r15 = 2;
    L27:
        r121 = false;
        goto L28
    L13:
        int r122 = r5 - 1;
        if (r12 > (r5 + 1)) goto L17;
        if (r122 > r12) goto L17;
        boolean r123 = true;
    L18:
        if (r123 == false) goto L20;
        float r124 = Random.Default.nextFloat() * 0.2f;
        float r125 = 0.6f;
    L21:
        r11 = r124 + r125;
        goto L22
    L20:
        r124 = Random.Default.nextFloat() * 0.1f;
        r125 = 0.4f;
    L17:
        r123 = false;
        goto L18
    L7:
        r3 = r3 - ((long) WindowAnimationBoostCoordinator.DEFAULT_WINDOW_ANIMATION_DURATION_MS);
    L56:
        r31 = r3;
        goto L57
    }

    public final void setCustomWaveGroupCount(int r1) {
        this.a = r1;
    }

    public AudioVisualizerOptCustom(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3);
        float r4 = i5.N();
        this.b = r4;
        this.c = i5.z();
        this.d = i5.l0();
        this.e = i5.N();
        this.f = i5.d0();
        this.i = new LinkedList();
        this.k = new LinkedHashMap();
        Paint r5 = new Paint();
        r5.setAntiAlias(true);
        r5.setFilterBitmap(true);
        r5.setStrokeCap(Paint.Cap.ROUND);
        r5.setStrokeWidth(r4);
        r5.setColor(-1);
        this.m = r5;
        this.n = LazyKt.lazy(new com.obric.assistant.view.a(this));
    }

    public static final /* synthetic */ void b(AudioVisualizerOptCustom r0, float r1) {
        r0.setAmplitude(r1);
    }

    public AudioVisualizerOptCustom(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        float r5 = i5.N();
        this.b = r5;
        this.c = i5.z();
        this.d = i5.l0();
        this.e = i5.N();
        this.f = i5.d0();
        this.i = new LinkedList();
        this.k = new LinkedHashMap();
        Paint r6 = new Paint();
        r6.setAntiAlias(true);
        r6.setFilterBitmap(true);
        r6.setStrokeCap(Paint.Cap.ROUND);
        r6.setStrokeWidth(r5);
        r6.setColor(-1);
        this.m = r6;
        this.n = LazyKt.lazy(new com.obric.assistant.view.a(this));
    }

    @Override // android.view.View
    public final void onSizeChanged(int r3, int r4, int r5, int r6) {
        super.onSizeChanged(r3, r4, r5, r6);
        float r7 = getWidth() - (this.d * 2);
        float r8 = (this.b + this.c) * 5;
        int r9 = (int) (r7 / r8);
        this.h = r9;
        int r0 = 1;
        if ((r9 % 2) != 0) goto L5;
        this.h = r9 - 1;
    L5:
        int r10 = this.a;
        if (r10 <= 0) goto L8;
        this.h = r10;
    L8:
        int r11 = RangesKt.coerceAtLeast(this.h, 3);
        this.h = r11;
        this.g = (r11 * r8) - this.c;
        int r12 = r11 * 5;
        this.l = r12;
        if (((LinkedHashMap) this.k).get(Integer.valueOf(r12)) != null) goto L18;
        ((LinkedHashMap) this.k).clear();
        if (1 > r12) goto L16;
    L13:
        this.k.put(Integer.valueOf(r0), new a(0));
        if (r0 == r12) goto L19;
        r0 = r0 + 1;
        goto L13
    L19:
        return;
    L16:
        return;
    }
}
