package com.obric.aiproactive.ui.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.View;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.crash.entity.EventBody;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u0014\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u0012\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 12\u00020\u0001:\u00011B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0006\u0010\u001b\u001a\u00020\u001cJ\u0006\u0010\u001d\u001a\u00020\u001cJ\u000e\u0010\u001e\u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020\u0019J\u000e\u0010 \u001a\u00020\u001c2\u0006\u0010!\u001a\u00020\"J(\u0010#\u001a\u00020\u001c2\u0006\u0010$\u001a\u00020\u00072\u0006\u0010%\u001a\u00020\u00072\u0006\u0010&\u001a\u00020\u00072\u0006\u0010'\u001a\u00020\u0007H\u0014J\u0010\u0010(\u001a\u00020\u001c2\u0006\u0010)\u001a\u00020*H\u0014J\u0010\u0010+\u001a\u00020\u001c2\u0006\u0010,\u001a\u00020\u0017H\u0002J\b\u0010-\u001a\u00020\u001cH\u0002R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u0010.\u001a\u00020\u000b*\u00020\u000b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b/\u00100¨\u00062"}, d2 = {"Lcom/obric/aiproactive/ui/widget/RequirementVoiceVisualizerView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "barWidth", "", "gapWidth", "minHeight", "maxHeight", "currentHeights", "", "startHeights", "targetHeights", "paint", "Landroid/graphics/Paint;", "amplitude", "cycleStartedAt", "", "cancelling", "", "animating", CommonConsts.APM_INNER_EVENT_COST_START, "", "stop", "setCancelling", EventBody.KEY_VALUE, "updateAudioData", "data", "", "onSizeChanged", "width", "height", "oldWidth", "oldHeight", "onDraw", "canvas", "Landroid/graphics/Canvas;", "beginNextCycle", "now", "updateShader", "dp", "getDp", "(F)F", "Companion", "ai_proactive_ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class RequirementVoiceVisualizerView extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f6924a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final float f6925b;
    private final float c;
    private final float d;
    private final float e;
    private final float[] f;
    private final float[] g;
    private final float[] h;
    private final Paint i;
    private float j;
    private long k;
    private boolean l;
    private boolean m;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/obric/aiproactive/ui/widget/RequirementVoiceVisualizerView$Companion;", "", "<init>", "()V", "BAR_COUNT", "", "PULSE_DURATION_MS", "", "FRAME_DELAY_MS", "CANCEL_COLOR", "ai_proactive_ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        f6924a = new a(null);
    }

    public RequirementVoiceVisualizerView(Context r7) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "context");
        this(r1, null, 0, 6, null);
    }

    public RequirementVoiceVisualizerView(Context r9, AttributeSet r10) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r4 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r10, AttributeSet.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 0, 4, null);
    }

    public RequirementVoiceVisualizerView(Context r3, AttributeSet r4, int r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r7 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "context");
        super(r6, r7, r5);
        this.f6925b = a(3.0f);
        this.c = a(2.0f);
        this.d = a(3.0f);
        this.e = a(48.0f);
        float[] r8 = new float[25];
        int r9 = 0;
        int r0 = 0;
    L3:
        if (r0 >= 25) goto L5;
        r8[r0] = this.d;
        r0 = r0 + 1;
        goto L3
    L5:
        this.f = r8;
        float[] r10 = new float[25];
        int r1 = 0;
    L6:
        if (r1 >= 25) goto L8;
        r10[r1] = this.d;
        r1 = r1 + 1;
        goto L6
    L8:
        this.g = r10;
        float[] r11 = new float[25];
    L9:
        if (r9 >= 25) goto L11;
        r11[r9] = this.d;
        r9 = r9 + 1;
        goto L9
    L11:
        this.h = r11;
        Paint r12 = new Paint(1);
        r12.setStrokeCap(Paint.Cap.ROUND);
        r12.setStrokeWidth(this.f6925b);
        r12.setColor(-1);
        this.i = r12;
    }

    public /* synthetic */ RequirementVoiceVisualizerView(Context r2, AttributeSet r3, int r4, int r5, DefaultConstructorMarker r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r8 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r3, AttributeSet.class, "com.obric.memorydata.plugin");
        if ((r5 & 2) == 0) goto L6;
        r8 = null;
    L6:
        if ((r5 & 4) == 0) goto L8;
        r4 = 0;
    L8:
        this(r7, r8, r4);
    }

    private final float a(float r2) {
        return r2 * ZeusTransformUtils.getResources(this, "com.obric.memorydata.plugin").getDisplayMetrics().density;
    }

    private final void a(long r14) {
        this.k = r14;
        ArraysKt.copyInto$default(this.f, this.g, 0, 0, 0, 14, null);
        Float r15 = Float.valueOf(this.j);
        if (((Number) ZeusTransformUtils.preCheckCast(r15, Number.class, "com.obric.memorydata.plugin")).floatValue() <= 0.0f) goto L5;
        boolean r16 = true;
    L6:
        if (r16 == true) goto L9;
        r15 = null;
    L9:
        if (r15 == null) goto L11;
        float r17 = r15.floatValue();
    L12:
        this.j = 0.0f;
        int r18 = Random.Default.nextInt(1, 4);
        int r3 = 0;
    L14:
        if (r3 >= 5) goto L32;
        int r5 = Math.abs(r3 - r18);
        if (r5 == 0) goto L21;
        if (r5 == 1) goto L19;
        float r6 = 0.4f;
        float r7 = Random.Default.nextFloat();
        float r8 = 0.1f;
    L20:
        float r9 = (r7 * r8) + r6;
    L22:
        int r10 = Random.Default.nextInt(1, 4);
        int r11 = 0;
    L23:
        if (r11 >= 5) goto L31;
        int r12 = Math.abs(r11 - r10);
        if (r12 == 0) goto L29;
        if (r12 == 1) goto L28;
        float r13 = 0.49f;
    L30:
        this.h[(r3 * 5) + r11] = RangesKt.coerceAtLeast(((this.e * r17) * r9) * r13, this.d);
        r11 = r11 + 1;
        goto L23
    L28:
        r13 = 0.7f;
        goto L30
    L29:
        r13 = 1.0f;
        goto L30
    L31:
        r3 = r3 + 1;
        goto L14
    L19:
        r6 = 0.65f;
        r7 = Random.Default.nextFloat();
        r8 = 0.15f;
        goto L20
    L21:
        r9 = 1.0f;
        goto L22
    L32:
        return;
    L11:
        r17 = 0.16f;
        goto L12
    L5:
        r16 = false;
        goto L6
    }

    private final void b() {
        if (this.l == false) goto L7;
        this.i.setShader(null);
        this.i.setColor(-42663);
        return;
    L7:
        if ((ZeusTransformUtils.getResources(this, "com.obric.memorydata.plugin").getConfiguration().uiMode & 48) != 32) goto L9;
        int[] r1 = {-8282369, -25956, -15222};
    L10:
        int[] r9 = r1;
        float r2 = (25 * this.f6925b) + (24 * this.c);
        float r5 = (getWidth() - r2) / 2.0f;
        this.i.setShader((Shader) ZeusTransformUtils.preCheckCast(new LinearGradient(r5, 0.0f, r5 + r2, 0.0f, r9, new float[]{0.38f, 0.74f, 1.0f}, Shader.TileMode.CLAMP), Shader.class, "com.obric.memorydata.plugin"));
        return;
    L9:
        r1 = new int[]{-13146369, -35979, -19867};
        goto L10
    }

    public final void a() {
        this.m = false;
        this.j = 0.0f;
        ArraysKt.fill$default(this.f, this.d, 0, 0, 6, null);
        invalidate();
    }

    @Override // android.view.View
    public void onDraw(Canvas r13) {
        Intrinsics.checkNotNullParameter(r13, "canvas");
        super.onDraw(r13);
        long r0 = SystemClock.elapsedRealtime();
        long r2 = this.k;
        if (r2 != 0) goto L5;
    L6:
        a(r0);
    L7:
        float r1 = RangesKt.coerceIn((r0 - this.k) / 400, 0.0f, 1.0f);
        if (r1 > 0.5f) goto L10;
        float r3 = r1 * 2.0f;
    L11:
        float r4 = ((getWidth() - ((25 * this.f6925b) + (24 * this.c))) / 2.0f) + (this.f6925b / 2.0f);
        Iterator r5 = ((Iterable) ZeusTransformUtils.preCheckCast(ArraysKt.getIndices(this.f), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L13:
        if (r5.hasNext() == false) goto L16;
        int r6 = ((IntIterator) ZeusTransformUtils.preCheckCast(r5, IntIterator.class, "com.obric.memorydata.plugin")).nextInt();
        float[] r7 = this.g;
        this.f[r6] = RangesKt.coerceAtLeast(r7[r6] + ((this.h[r6] - r7[r6]) * r3), this.d);
        float r8 = getHeight();
        float[] r9 = this.f;
        float r10 = (r8 - r9[r6]) / 2.0f;
        r13.drawLine(r4, r10, r4, r10 + r9[r6], this.i);
        r4 = r4 + (this.f6925b + this.c);
        goto L13
    L16:
        if (this.m == false) goto L20;
        postInvalidateDelayed(16);
        return;
    L20:
        return;
    L10:
        r3 = (1.0f - r1) * 2.0f;
        goto L11
    L5:
        if ((r0 - r2) < 400) goto L7;
        goto L6
    }

    @Override // android.view.View
    public void onSizeChanged(int r1, int r2, int r3, int r4) {
        super.onSizeChanged(r1, r2, r3, r4);
        b();
    }

    public final void setCancelling(boolean r2) {
        if (this.l != r2) goto L5;
        return;
    L5:
        this.l = r2;
        b();
        invalidate();
    }
}
