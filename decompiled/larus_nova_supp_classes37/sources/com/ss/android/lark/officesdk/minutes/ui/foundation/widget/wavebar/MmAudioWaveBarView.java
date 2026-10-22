package com.ss.android.lark.officesdk.minutes.ui.foundation.widget.wavebar;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.View;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.framework.utils.UIUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.officesdk.minutes.ui.record.MmUiLogScene;
import com.ss.android.lark.picker.base.view.ItemViewType;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0000\n\u0002\u0010 \n\u0002\b\b\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b7\u0018\u0000 \u0080\u00012\u00020\u0001:\u0004\u0080\u0001\u0081\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010=\u001a\u00020>H\u0002J(\u0010?\u001a\u00020@2\u0006\u0010A\u001a\u00020\u00072\u0006\u0010B\u001a\u00020\u00072\u0006\u0010C\u001a\u00020\u00072\u0006\u0010D\u001a\u00020\u0007H\u0014J\u0010\u0010E\u001a\u00020@2\u0006\u0010F\u001a\u00020\u0016H\u0016J\u0006\u0010G\u001a\u00020@J\u0006\u0010H\u001a\u00020@J\u0010\u0010I\u001a\u00020@2\u0006\u0010J\u001a\u00020KH\u0014J\b\u0010L\u001a\u00020@H\u0014J\u0016\u0010M\u001a\u00020@2\u0006\u0010N\u001a\u00020\u00072\u0006\u0010O\u001a\u00020\u0007J\u000e\u0010P\u001a\u00020@2\u0006\u0010Q\u001a\u00020\u0007J\u000e\u0010R\u001a\u00020@2\u0006\u0010S\u001a\u00020\u000bJ\u000e\u0010T\u001a\u00020@2\u0006\u0010U\u001a\u00020\u000bJ\u0016\u0010V\u001a\u00020@2\u0006\u0010W\u001a\u00020\u000b2\u0006\u0010X\u001a\u00020\u000bJ\u0010\u0010Y\u001a\u00020@2\b\b\u0001\u0010Z\u001a\u00020\u0007J\u0006\u0010[\u001a\u00020@J\u0006\u0010\\\u001a\u00020@J\u000e\u0010]\u001a\u00020@2\u0006\u0010^\u001a\u00020\u0007J\b\u0010_\u001a\u00020@H\u0002J\b\u0010`\u001a\u00020@H\u0002J\u000e\u0010a\u001a\b\u0012\u0004\u0012\u00020\u000b0.H\u0002J\b\u0010b\u001a\u00020@H\u0002J\b\u0010c\u001a\u00020@H\u0002J\b\u0010d\u001a\u00020\u000bH\u0002J\u0010\u0010e\u001a\u00020\u000b2\u0006\u0010f\u001a\u00020\u000bH\u0002J\u0016\u0010g\u001a\u00020@2\f\u0010h\u001a\b\u0012\u0004\u0012\u00020\u000b0,H\u0002J\u001e\u0010i\u001a\u00020@2\u0006\u0010j\u001a\u00020\u000b2\f\u0010k\u001a\b\u0012\u0004\u0012\u00020\u000b0,H\u0002J\u0016\u0010l\u001a\u00020@2\f\u0010m\u001a\b\u0012\u0004\u0012\u00020\u000b0,H\u0002J\u0010\u0010n\u001a\u00020@2\u0006\u0010J\u001a\u00020KH\u0002J\b\u0010o\u001a\u00020@H\u0002J\u0010\u0010p\u001a\u00020\u00072\u0006\u0010q\u001a\u00020\u0007H\u0002J$\u0010r\u001a\u00020@2\f\u0010h\u001a\b\u0012\u0004\u0012\u00020\u000b0,2\f\u0010s\u001a\b\u0012\u0004\u0012\u00020\u000b0.H\u0002J\u0016\u0010t\u001a\u00020@2\f\u0010h\u001a\b\u0012\u0004\u0012\u00020\u000b0,H\u0002J$\u0010u\u001a\u00020@2\f\u0010v\u001a\b\u0012\u0004\u0012\u00020\u000b0.2\f\u0010w\u001a\b\u0012\u0004\u0012\u00020\u000b0,H\u0002J\b\u0010x\u001a\u00020@H\u0002J\u0010\u0010y\u001a\u00020\u000b2\u0006\u0010^\u001a\u00020\u0007H\u0002J\u0010\u0010z\u001a\u00020@2\u0006\u0010{\u001a\u00020\u001dH\u0002J\b\u0010|\u001a\u00020@H\u0002J\u0016\u0010}\u001a\b\u0012\u0004\u0012\u00020\u000b0.2\u0006\u0010{\u001a\u00020\u001dH\u0002J\u0014\u0010~\u001a\u00020\u001d*\u00020\u001d2\u0006\u0010\u007f\u001a\u00020\u001dH\u0002R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0016X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020&X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010(\u001a\u0004\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0004\n\u0002\u0010)R\u000e\u0010*\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R2\u0010+\u001a&\u0012\f\u0012\n -*\u0004\u0018\u00010\u000b0\u000b -*\u0012\u0012\f\u0012\n -*\u0004\u0018\u00010\u000b0\u000b\u0018\u00010.0,X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010/\u001a\b\u0012\u0004\u0012\u00020\u000b0,X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u00100\u001a\b\u0012\u0004\u0012\u00020\u000b0,X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u00101\u001a\b\u0012\u0004\u0012\u00020\u000b0,X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u00102\u001a\b\u0012\u0004\u0012\u00020\u000b0,X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u00103\u001a\b\u0012\u0004\u0012\u00020\u000b0,X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u00104\u001a\b\u0012\u0004\u0012\u00020\u000b0,X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u00105\u001a\b\u0012\u0004\u0012\u00020\u000b0,X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u000207X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u000209X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010:\u001a\u00020;X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010<\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0082\u0001"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/ui/foundation/widget/wavebar/MmAudioWaveBarView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "barWidth", "", "gapWidth", "sideMargin", "minBarHeight", "maxBarHeight", "visualizerWidth", "waveGroupNumber", "barCount", "startAlphaSize", "endAlphaSize", "isActive", "", "isPaused", "aggregatedIsVisible", "frameIndex", "isLowDevice", "targetFramesPerSecond", "defaultFrameIntervalMs", "", "animationIntervalMs", "effectiveFramesPerSecond", "framesPerSample", "peakGroupIndex", "targetAmplitude", "currentAmplitude", "rawVolume", "displayMode", "Lcom/ss/android/lark/officesdk/minutes/ui/foundation/widget/wavebar/MmAudioWaveBarView$WaveDisplayMode;", "usingIdleWave", "lowVolumeStartTimeMs", "Ljava/lang/Long;", "idleWaveStartTimeMs", "amplitudeSamples", "", "kotlin.jvm.PlatformType", "", "groupHeights", "activeGroupHeights", "prevMeters", "currMeters", "renderMeters", "generatedMeters", "tempMeterGroup", "alphaCache", "", "frameRunnable", "Ljava/lang/Runnable;", "paint", "Landroid/graphics/Paint;", "basePaintAlpha", "perfInfoLog", "", "onSizeChanged", "", "w", "h", "oldw", "oldh", "onVisibilityAggregated", "isVisible", "startAnimation", "stopAnimation", "onDraw", "canvas", "Landroid/graphics/Canvas;", "onDetachedFromWindow", "setGradient", "startSize", "endSize", "setSlideMargin", "margin", "setBarWidth", "widthPx", "setBarGap", "gapPx", "setBarHeightRange", "minHeightPx", "maxHeightPx", "setPaintColor", "color", "pause", "resume", "updateVolume", "volume", "rebuildMeterBuffers", "resetAllBarsToMinHeight", "generateGroups", "updatePeakGroupIndex", "updateAmplitudeFromSamples", "samplePendingAmplitude", "mapAmplitude", "rawAmplitude", "generateMeters", PickerReporterConstants.KEY.TARGET, "generateMetersForGroup", "groupHeight", "meterGroup", "shuffleInPlace", "array", "drawMeters", "rebuildAlphaCache", "paintAlpha", "index", "fillMeters", "source", "resetMeters", "copyMeters", "from", "to", "ensureMeterGroupSize", "mapVolumeToAmplitude", "maybeUpdateDisplayMode", "nowMs", "resetDisplayMode", "buildIdleMeters", "floorMod", "divisor", "Companion", "WaveDisplayMode", "officesdk-minutes-base-ui_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final class MmAudioWaveBarView extends View {
    public final List<Float> A;
    public final List<Float> B;
    public final List<Float> C;
    public int[] D;
    public final b E;
    public final Paint F;
    public int G;
    public float a;
    public float b;
    public float c;
    public final float d;
    public final float e;
    public float f;
    public int g;
    public int h;
    public boolean i;
    public boolean j;
    public boolean k;
    public int l;
    public final long m;
    public final int n;
    public int o;
    public float p;
    public int q;
    public WaveDisplayMode r;
    public boolean s;
    public Long t;
    public long u;
    public final List<Float> v;
    public final List<Float> w;
    public final List<Float> x;
    public final List<Float> y;
    public final List<Float> z;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/ui/foundation/widget/wavebar/MmAudioWaveBarView$WaveDisplayMode;", "", "<init>", "(Ljava/lang/String;I)V", "ACTIVE", "IDLE", "officesdk-minutes-base-ui_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    public static final enum WaveDisplayMode extends Enum<WaveDisplayMode> {
        public static final WaveDisplayMode ACTIVE = null;
        public static final WaveDisplayMode IDLE = null;
        public static final /* synthetic */ WaveDisplayMode[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static EnumEntries<WaveDisplayMode> getEntries() {
            return b;
        }

        static {
            WaveDisplayMode r0 = new WaveDisplayMode("ACTIVE", 0);
            ACTIVE = r0;
            WaveDisplayMode r1 = new WaveDisplayMode("IDLE", 1);
            IDLE = r1;
            WaveDisplayMode[] r3 = {r0, r1};
            a = r3;
            b = EnumEntriesKt.enumEntries(r3);
        }

        public static WaveDisplayMode[] values() {
            return (WaveDisplayMode[]) a.clone();
        }

        public static WaveDisplayMode valueOf(String r1) {
            return (WaveDisplayMode) r27.a.a(WaveDisplayMode.class, r1);
        }

        public WaveDisplayMode(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static final class a {
    }

    public static final class b implements Runnable {
        public final /* synthetic */ MmAudioWaveBarView a;

        public b(MmAudioWaveBarView r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.invalidate();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
    }

    public MmAudioWaveBarView(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public MmAudioWaveBarView(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    public final void b() {
        int r0 = bwb.b.a;
        bwb.b.g(MmUiLogScene.FOUNDATION, "pause", "aggregatedIsVisible=" + this.k + " isActive=" + this.i + " width=" + getWidth() + " height=" + getHeight() + ' ' + c(), null, 8);
        this.j = true;
        this.v.clear();
        this.p = 0.0f;
        this.r = WaveDisplayMode.ACTIVE;
        this.s = false;
        this.t = null;
        this.u = 0;
        f(this.y);
        f(this.z);
        f(this.A);
        f(this.B);
        this.l = 0;
        invalidate();
    }

    public final String c() {
        return "interval=" + this.m + " lowDevice=false";
    }

    public final void d() {
        int r0 = this.D.length;
        int r1 = this.h;
        if (r0 == r1) goto L5;
        this.D = new int[r1];
    L5:
        int r2 = 0;
    L6:
        if (r2 >= r1) goto L8;
        this.D[r2] = RangesKt.coerceIn((int) (this.G * (RangesKt.coerceIn((int) (255 * 1.0f), 0, 255) / 255.0f)), 0, 255);
        r2 = r2 + 1;
        goto L6
    }

    public final void e() {
        ((ArrayList) this.w).clear();
        List<Float> r0 = this.w;
        int r1 = this.g;
        if (r1 > 0) goto L5;
        List r2 = CollectionsKt.emptyList();
    L25:
        ((ArrayList) r0).addAll(r2);
        f(this.y);
        f(this.z);
        f(this.A);
        f(this.B);
    L27:
        if (((ArrayList) this.C).size() >= 5) goto L29;
        ((ArrayList) this.C).add(Float.valueOf(this.d));
        goto L27
    L29:
        d();
        return;
    L5:
        ArrayList r3 = new ArrayList(r1);
        int r4 = 0;
    L6:
        if (r4 >= r1) goto L8;
        r3.add(Float.valueOf(this.e));
        r4 = r4 + 1;
        goto L6
    L8:
        int r5 = this.g;
        if (r5 <= 2) goto L24;
        int r6 = 1;
        if (r5 != 3) goto L14;
        float r7 = this.d;
        float r8 = r7 + ((this.e - r7) * 0.5f);
        r2 = CollectionsKt.listOf(new Float[]{Float.valueOf(r8), Float.valueOf(this.e), Float.valueOf(r8)});
        goto L25
    L14:
        float r9 = (this.e - this.d) / RangesKt.coerceAtLeast((r5 - 1) / 2, 1);
        int r10 = this.g;
        int r11 = (r10 - 1) / 2;
        if ((r10 % 2) != 1) goto L17;
        int r12 = r11;
    L18:
        if (1 > r11) goto L24;
    L19:
        int r13 = r11 - r6;
        ListProtector.set(r3, r13, Float.valueOf(RangesKt.coerceAtLeast(((Number) ListProtector.get(r3, r13 + 1)).floatValue() - r9, this.d)));
        int r14 = r12 + r6;
        if (r14 >= this.g) goto L22;
        ListProtector.set(r3, r14, Float.valueOf(RangesKt.coerceAtLeast(((Number) ListProtector.get(r3, r14 - 1)).floatValue() - r9, this.d)));
    L22:
        if (r6 == r11) goto L24;
        r6 = r6 + 1;
        goto L19
    L17:
        r12 = r11 + 1;
    L24:
        r2 = r3;
        goto L25
    }

    public final void g() {
        int r0 = bwb.b.a;
        bwb.b.g(MmUiLogScene.FOUNDATION, "resume", "aggregatedIsVisible=" + this.k + " isActive=" + this.i + " width=" + getWidth() + " height=" + getHeight() + ' ' + c(), null, 8);
        this.j = false;
        this.i = true;
        this.r = WaveDisplayMode.ACTIVE;
        this.s = false;
        this.t = null;
        this.u = 0;
        h();
    }

    public final void h() {
        int r0 = bwb.b.a;
        bwb.b.g(MmUiLogScene.FOUNDATION, "startAnimation", "visibility=" + getVisibility() + " isShown=" + isShown() + " aggregatedIsVisible=" + this.k + " isPaused=" + this.j + " isActive=" + this.i + " width=" + getWidth() + " height=" + getHeight() + ' ' + c(), null, 8);
        removeCallbacks(this.E);
        if (getVisibility() == 0) goto L5;
        return;
    L5:
        if (isShown() == true) goto L7;
        return;
    L7:
        if (this.j == true) goto L12;
        this.k = true;
        invalidate();
        return;
    }

    public final void i() {
        int r0 = bwb.b.a;
        bwb.b.g(MmUiLogScene.FOUNDATION, "stopAnimation", "aggregatedIsVisible=" + this.k + " isPaused=" + this.j + " isActive=" + this.i + " width=" + getWidth() + " height=" + getHeight() + ' ' + c(), null, 8);
        removeCallbacks(this.E);
    }

    @Override // android.view.View
    public final void onDetachedFromWindow() {
        i();
        this.i = false;
        this.v.clear();
        super.onDetachedFromWindow();
    }

    public final void a(long r6) {
        if (this.j == false) goto L6;
        return;
    L6:
        if (this.q <= 25) goto L11;
        this.t = null;
        WaveDisplayMode r7 = this.r;
        WaveDisplayMode r8 = WaveDisplayMode.ACTIVE;
        if (r7 == r8) goto L23;
        this.r = r8;
        this.s = false;
        return;
    L23:
        return;
    L11:
        WaveDisplayMode r0 = this.r;
        WaveDisplayMode r1 = WaveDisplayMode.IDLE;
        if (r0 != r1) goto L15;
        this.t = null;
        return;
    L15:
        Long r2 = this.t;
        if (r2 != null) goto L20;
        this.t = Long.valueOf(r6);
        return;
    L20:
        if ((r6 - r2.longValue()) < 2000) goto L24;
        this.t = null;
        this.r = r1;
        return;
    }

    public final void f(List<Float> r4) {
        r4.clear();
        int r0 = this.h;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        r4.add(Float.valueOf(this.d));
        r1 = r1 + 1;
        goto L3
    }

    public final void j(int r4) {
        if (this.j == false) goto L5;
        return;
    L5:
        this.q = r4;
        a(SystemClock.uptimeMillis());
        List<Float> r0 = this.v;
        if (r4 > 0) goto L8;
        float r5 = 0.0f;
    L12:
        r0.add(Float.valueOf(r5));
        if (this.v.size() <= 10) goto L16;
        ListProtector.remove(this.v, 0);
        return;
    L16:
        return;
    L8:
        float r6 = r4;
        if (r6 > 80.0f) goto L11;
        r5 = r6 / 80.0f;
        goto L12
    L11:
        r5 = 1.0f;
        goto L12
    }

    @Override // android.view.View
    public final void onDraw(Canvas r24) {
        Intrinsics.checkNotNullParameter(r24, "canvas");
        super.onDraw(r24);
        if (this.i == true) goto L5;
        return;
    L5:
        if (this.k == true) goto L8;
        return;
    L8:
        if (this.h > 0) goto L11;
        return;
    L11:
        if (((ArrayList) this.A).size() == this.h) goto L16;
        e();
        if (((ArrayList) this.A).size() == this.h) goto L16;
        return;
    L16:
        if (this.l != 0) goto L148;
        List<Float> r1 = this.z;
        ArrayList r7 = (ArrayList) this.y;
        r7.clear();
        r7.addAll(r1);
        a(SystemClock.uptimeMillis());
        WaveDisplayMode r2 = this.r;
        WaveDisplayMode r8 = WaveDisplayMode.IDLE;
        if (r2 != r8) goto L20;
        this.p = 0.0f;
    L38:
        List<Float> r3 = this.B;
        if (this.r == r8) goto L41;
        this.s = false;
        int r4 = this.o;
        int r5 = this.g;
        if (r5 <= 1) goto L91;
        int r6 = r5 / 2;
        if (r5 > 3) goto L83;
        this.o = r6;
        goto L91
    L83:
        if (r4 == r6) goto L86;
    L90:
        this.o = r6;
        goto L91
    L86:
        if (ThreadLocalRandom.current().nextBoolean() == false) goto L88;
        int r9 = 1;
    L89:
        r6 = RangesKt.coerceIn(r6 + r9, 0, this.g - 1);
        goto L90
    L88:
        r9 = -1;
    L91:
        float r10 = Math.min(this.p * 1.7f, 1.0f);
        List<Float> r11 = this.w;
        ArrayList r12 = (ArrayList) this.x;
        r12.clear();
        r12.addAll(r11);
        if (r4 == this.o) goto L106;
        if (r4 >= 0) goto L95;
    L97:
        boolean r13 = false;
    L98:
        if (r13 == false) goto L106;
        int r14 = ((ArrayList) this.x).size();
        int r15 = this.o;
        if (r15 < 0) goto L103;
        if (r15 >= r14) goto L103;
        boolean r16 = true;
    L104:
        if (r16 == false) goto L106;
        float r17 = ((Number) ListProtector.get(this.x, r4)).floatValue();
        List<Float> r18 = this.x;
        ListProtector.set(r18, r4, ListProtector.get(r18, this.o));
        ListProtector.set(this.x, this.o, Float.valueOf(r17));
    L103:
        r16 = false;
        goto L104
    L95:
        if (r4 >= ((ArrayList) this.x).size()) goto L97;
        r13 = true;
    L106:
        Iterator r19 = ((ArrayList) this.x).iterator();
        int r20 = 0;
    L108:
        if (r19.hasNext() == false) goto L140;
        float r21 = RangesKt.coerceAtLeast(((Number) r19.next()).floatValue() * r10, this.d);
        List<Float> r22 = this.C;
    L111:
        if (((ArrayList) this.C).size() >= 5) goto L113;
        ((ArrayList) this.C).add(Float.valueOf(this.d));
        goto L111
    L113:
        int r23 = 0;
    L114:
        if (r23 >= 5) goto L116;
        ListProtector.set(r22, r23, Float.valueOf(r21));
        r23 = r23 + 1;
        goto L114
    L116:
        float r25 = (ThreadLocalRandom.current().nextFloat() * 0.3f) + 0.6f;
        int r26 = 1;
    L117:
        int r110 = 2 - r26;
        int r111 = r26 + 2;
        ListProtector.set(r22, r110, Float.valueOf(RangesKt.coerceAtLeast(((Number) ListProtector.get(r22, r110 + 1)).floatValue() * r25, this.d)));
        if (r111 >= 5) goto L121;
        ListProtector.set(r22, r111, Float.valueOf(RangesKt.coerceAtLeast(((Number) ListProtector.get(r22, r111 - 1)).floatValue() * r25, this.d)));
    L121:
        if (r26 == 2) goto L123;
        r26 = r26 + 1;
        goto L117
    L123:
        ArrayList r27 = (ArrayList) this.C;
        if (r27.size() <= 1) goto L132;
        int r28 = CollectionsKt.getLastIndex(r27);
    L127:
        if (r28 <= 0) goto L132;
        int r29 = ThreadLocalRandom.current().nextInt(r28 + 1);
        if (r28 == r29) goto L131;
        float r112 = ((Number) ListProtector.get(r27, r28)).floatValue();
        ListProtector.set(r27, r28, ListProtector.get(r27, r29));
        ListProtector.set(r27, r29, Float.valueOf(r112));
    L131:
        r28 = r28 - 1;
    L132:
        Iterator r30 = ((ArrayList) this.C).iterator();
    L134:
        if (r30.hasNext() == false) goto L108;
        float r31 = ((Number) r30.next()).floatValue();
        ArrayList r32 = (ArrayList) r3;
        if (r20 >= r32.size()) goto L138;
        ListProtector.set(r32, r20, Float.valueOf(r31));
    L139:
        r20 = r20 + 1;
        goto L134
    L138:
        r32.add(Float.valueOf(r31));
    L140:
        ArrayList r33 = (ArrayList) r3;
        if (r33.size() <= r20) goto L143;
        ListProtector.remove(r33, CollectionsKt.getLastIndex(r33));
    L143:
        List<Float> r34 = this.z;
        List<Float> r35 = this.B;
        ArrayList r36 = (ArrayList) r34;
        r36.clear();
        ArrayList r37 = (ArrayList) r35;
        if (r37.isEmpty() == true) goto L148;
        r36.addAll(r37);
        goto L148
    L41:
        if (this.s == true) goto L43;
        this.s = true;
        this.u = SystemClock.uptimeMillis();
    L43:
        long r113 = SystemClock.uptimeMillis();
        int r38 = this.h;
        if (r38 > 0) goto L46;
        List r39 = CollectionsKt.emptyList();
    L71:
        ArrayList r40 = (ArrayList) r3;
        r40.clear();
        if (r39.isEmpty() == true) goto L143;
        r40.addAll(r39);
        goto L143
    L46:
        long r114 = (r113 - this.u) % 3500;
        if (r114 >= 0) goto L51;
        r114 = r114 + 3500;
    L51:
        if (r114 <= 3500) goto L56;
        ArrayList r41 = new ArrayList(r38);
        int r42 = 0;
    L53:
        if (r42 >= r38) goto L55;
        r41.add(Float.valueOf(this.d));
        r42 = r42 + 1;
        goto L53
    L55:
        r39 = r41;
        goto L71
    L56:
        double r43 = 0.0d;
        if (r114 > 500) goto L59;
        Pair r44 = TuplesKt.to(Double.valueOf(0.0d), Double.valueOf(Math.sin(((r114 / 500) * 3.141592653589793d) * 0.5d)));
    L60:
        double r115 = ((Number) r44.component1()).doubleValue();
        double r45 = ((Number) r44.component2()).doubleValue();
        double r116 = ((double) (this.h - 1)) * 0.5d;
        float r46 = RangesKt.coerceAtLeast(getHeight() * 0.7f, this.d) - this.d;
        int r117 = this.h;
        ArrayList r47 = new ArrayList(r117);
        int r118 = 0;
    L61:
        if (r118 >= r117) goto L70;
        if (r116 != r43) goto L65;
        boolean r210 = true;
    L66:
        if (r210 == true) goto L69;
        r43 = (((double) r118) - r116) / r116;
    L69:
        r47.add(Float.valueOf(this.d + ((((float) Math.exp(Math.pow(Math.abs(r43) - r115, 2.0d) * (-12.0d))) * r46) * ((float) r45))));
        r118 = r118 + 1;
        r43 = 0.0d;
        goto L61
    L65:
        r210 = false;
        goto L66
    L70:
        r39 = r47;
        goto L71
    L59:
        double r48 = ((r114 - 500) / 3000) * 3.141592653589793d;
        r44 = TuplesKt.to(Double.valueOf(Math.sin(r48 * 0.5d) * 1.6d), Double.valueOf(((Math.cos(r48) - 1.0d) * 0.5d) + 1.0d));
        goto L60
    L20:
        Float r49 = CollectionsKt.maxOrNull(this.v);
        if (r49 == null) goto L23;
        float r50 = r49.floatValue();
    L24:
        this.v.clear();
        float r51 = Math.max(0.0f, r50);
        if (r51 > 0.001f) goto L28;
        float r52 = 0.0f;
    L31:
        float r119 = this.p;
        float r53 = r52 - r119;
        if (r52 <= r119) goto L34;
        float r120 = 0.2f;
    L35:
        float r121 = r119 + (r53 * r120);
        this.p = r121;
        if (r121 >= 5.0E-4f) goto L38;
        this.p = 0.0f;
        goto L38
    L34:
        r120 = 0.08f;
        goto L35
    L28:
        if (r51 > 1.0f) goto L30;
        r52 = RangesKt.coerceIn(r51, 0.0f, 1.0f);
        goto L31
    L30:
        r52 = (float) (1.0d - Math.exp(-r51));
        goto L31
    L23:
        r50 = 0.0f;
    L148:
        int r54 = this.n;
        if (r54 > 0) goto L151;
        return;
    L151:
        float r55 = this.l / r54;
        float r122 = 2;
        float r56 = RangesKt.coerceIn((r55 * r55) * (3 - (r55 * r122)), 0.0f, 1.0f);
        int r57 = this.h;
        int r58 = 0;
    L152:
        if (r58 >= r57) goto L154;
        ListProtector.set(this.A, r58, Float.valueOf(((Number) ListProtector.get(this.y, r58)).floatValue() + ((((Number) ListProtector.get(this.z, r58)).floatValue() - ((Number) ListProtector.get(this.y, r58)).floatValue()) * r56)));
        r58 = r58 + 1;
        goto L152
    L154:
        float r59 = ((getWidth() - this.f) / r122) + (this.a / r122);
        int r123 = this.h;
        int r60 = -1;
        int r124 = 0;
    L155:
        if (r124 >= r123) goto L173;
        Float r61 = (Float) CollectionsKt.getOrNull(this.A, r124);
        if (r61 == null) goto L159;
        float r62 = RangesKt.coerceAtLeast(r61.floatValue(), this.d);
    L160:
        int[] r63 = this.D;
        if (r124 >= 0) goto L163;
    L165:
        boolean r64 = false;
    L166:
        if (r64 == false) goto L168;
        int r65 = r63[r124];
    L169:
        if (r65 == r60) goto L171;
        this.F.setAlpha(r65);
        int r125 = r65;
    L172:
        float r66 = (getHeight() - r62) / r122;
        r24.drawLine(r59, r66, r59, r66 + r62, this.F);
        r59 = r59 + (this.a + this.b);
        r124 = r124 + 1;
        r60 = r125;
        goto L155
    L171:
        r125 = r60;
        goto L172
    L168:
        r65 = this.G;
        goto L169
    L163:
        if (r124 >= r63.length) goto L165;
        r64 = true;
        goto L166
    L159:
        r62 = this.d;
        goto L160
    L173:
        this.F.setAlpha(this.G);
        this.l = (this.l + 1) % this.n;
        if (this.j == true) goto L197;
        postDelayed(this.E, this.m);
        return;
    }

    @Override // android.view.View
    public final void onVisibilityAggregated(boolean r6) {
        super.onVisibilityAggregated(r6);
        if (this.k != r6) goto L5;
        return;
    L5:
        this.k = r6;
        int r0 = bwb.b.a;
        bwb.b.g(MmUiLogScene.FOUNDATION, "onVisibilityAggregated", "isVisible=" + r6, null, 8);
        if (r6 == false) goto L8;
        h();
        return;
    L8:
        i();
    }

    public final void setBarGap(float r2) {
        float r3 = RangesKt.coerceAtLeast(r2, 0.0f);
        if (this.b != r3) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        return;
    L8:
        this.b = r3;
        requestLayout();
        invalidate();
        return;
    L5:
        r0 = false;
        goto L6
    }

    public final void setBarWidth(float r2) {
        float r3 = RangesKt.coerceAtLeast(r2, 1.0f);
        if (this.a != r3) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        return;
    L8:
        this.a = r3;
        this.F.setStrokeWidth(r3);
        requestLayout();
        invalidate();
        return;
    L5:
        r0 = false;
        goto L6
    }

    public final void setPaintColor(int r2) {
        this.F.setColor(r2);
        this.G = Color.alpha(r2);
        d();
    }

    public final void setSlideMargin(int r1) {
        this.c = r1;
        requestLayout();
    }

    public MmAudioWaveBarView(Context r7, AttributeSet r8, int r9) {
        Intrinsics.checkNotNullParameter(r7, "context");
        super(r7, r8, r9);
        this.a = UIUtils.dp2px(r7, 3.0f);
        this.b = UIUtils.dp2px(r7, 3.0f);
        this.c = UIUtils.dp2px(r7, 1.0f);
        this.d = UIUtils.dp2px(r7, 3.0f);
        this.e = UIUtils.dp2px(r7, 48.0f);
        this.i = true;
        long r0 = RangesKt.coerceAtLeast(1000 / ((long) 30), 16);
        this.m = r0;
        this.n = RangesKt.coerceAtLeast(RangesKt.coerceAtLeast((int) (1000 / r0), 1) / 10, 1);
        this.r = WaveDisplayMode.ACTIVE;
        this.v = Collections.synchronizedList(new ArrayList());
        this.w = new ArrayList();
        this.x = new ArrayList();
        this.y = new ArrayList();
        this.z = new ArrayList();
        this.A = new ArrayList();
        this.B = new ArrayList();
        ArrayList r1 = new ArrayList(5);
        int r3 = 0;
    L3:
        if (r3 >= 5) goto L5;
        r1.add(Float.valueOf(this.d));
        r3 = r3 + 1;
        goto L3
    L5:
        this.C = r1;
        this.D = new int[0];
        this.E = new b(this);
        Paint r2 = new Paint();
        r2.setAntiAlias(true);
        r2.setFilterBitmap(true);
        r2.setStrokeCap(Paint.Cap.ROUND);
        r2.setStrokeWidth(this.a);
        r2.setColor(UIUtils.getColor(r7, 2131108742));
        this.F = r2;
        this.G = Color.alpha(r2.getColor());
        TypedArray r10 = r7.obtainStyledAttributes(r8, new int[]{2130972767, 2130972768, 2130972769, 2130972770, 2130972771});
        this.a = r10.getDimension(1, this.a);     // Catch: Throwable -> L9
        this.b = r10.getDimension(0, this.b);     // Catch: Throwable -> L9
        float r11 = r10.getDimension(3, this.d);     // Catch: Throwable -> L9
        this.d = r11;     // Catch: Throwable -> L9
        this.e = RangesKt.coerceAtLeast(r10.getDimension(2, this.e), r11);     // Catch: Throwable -> L9
        r2.setStrokeWidth(this.a);     // Catch: Throwable -> L9
        r2.setColor(r10.getColor(4, r2.getColor()));     // Catch: Throwable -> L9
        this.G = Color.alpha(r2.getColor());     // Catch: Throwable -> L9
        r10.recycle();
        return;
    L9:
        th = move-exception;
        r10.recycle();
        throw th;
    }

    public /* synthetic */ MmAudioWaveBarView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }

    @Override // android.view.View
    public final void onSizeChanged(int r4, int r5, int r6, int r7) {
        super.onSizeChanged(r4, r5, r6, r7);
        int r8 = (int) ((getWidth() - (this.c * 2)) / ((this.a * 5) + (this.b * 4)));
        this.g = r8;
        if ((r8 % 2) != 0) goto L5;
        this.g = r8 - 1;
    L5:
        int r9 = RangesKt.coerceAtLeast(this.g, 3);
        this.g = r9;
        this.o = r9 / 2;
        int r10 = r9 * 5;
        this.h = r10;
        if (r10 <= 0) goto L8;
        float r11 = (r10 * this.a) + ((r10 - 1) * this.b);
    L9:
        this.f = r11;
        e();
        int r12 = bwb.b.a;
        bwb.b.g(MmUiLogScene.FOUNDATION, "onSizeChanged", "w=" + r4 + " h=" + r5 + " waveGroupNumber=" + this.g + " barCount=" + this.h + " interval=" + this.m + " lowDevice=false", null, 8);
        return;
    L8:
        r11 = 0.0f;
        goto L9
    }
}
