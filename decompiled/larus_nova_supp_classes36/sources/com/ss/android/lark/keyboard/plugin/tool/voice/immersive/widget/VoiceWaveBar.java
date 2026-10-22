package com.ss.android.lark.keyboard.plugin.tool.voice.immersive.widget;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.framework.utils.UIUtils;
import com.larksuite.framework.utils.v;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.log.Log;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlin.ranges.RangesKt;
import y9c.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000i\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0004\n\u0002\b\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001e*\u0001'\u0018\u0000 N2\u00020\u0001:\u0001NB\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010.\u001a\u00020/2\u0006\u00100\u001a\u000201H\u0014J(\u00102\u001a\u00020/2\u0006\u00103\u001a\u00020\t2\u0006\u00104\u001a\u00020\t2\u0006\u00105\u001a\u00020\t2\u0006\u00106\u001a\u00020\tH\u0014J\u0016\u00107\u001a\u00020/2\u0006\u00108\u001a\u00020\t2\u0006\u00109\u001a\u00020 J\u000e\u00107\u001a\u00020/2\u0006\u00108\u001a\u00020\tJ\u0006\u0010:\u001a\u00020/J\u0006\u0010;\u001a\u00020/J\u0006\u0010<\u001a\u00020/J\u0006\u0010=\u001a\u00020/J\u0010\u0010>\u001a\u00020/2\b\b\u0002\u0010?\u001a\u00020$J \u0010@\u001a\u0012\u0012\u0004\u0012\u00020\f0\u001aj\b\u0012\u0004\u0012\u00020\f`\u001b2\u0006\u0010A\u001a\u00020\tH\u0002J\u0010\u0010B\u001a\u00020\f2\u0006\u0010C\u001a\u00020$H\u0002J0\u0010D\u001a\u0012\u0012\u0004\u0012\u00020\f0\u001aj\b\u0012\u0004\u0012\u00020\f`\u001b2\u0006\u0010E\u001a\u00020\t2\u0006\u0010\r\u001a\u00020$2\u0006\u0010\u000e\u001a\u00020$H\u0002J8\u0010F\u001a\u00020/2\u0016\u0010G\u001a\u0012\u0012\u0004\u0012\u00020\f0\u001aj\b\u0012\u0004\u0012\u00020\f`\u001b2\u0016\u0010H\u001a\u0012\u0012\u0004\u0012\u00020\f0\u001aj\b\u0012\u0004\u0012\u00020\f`\u001bH\u0002J \u0010I\u001a\u00020\u001e2\u0006\u0010J\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\f2\u0006\u0010K\u001a\u00020\fH\u0002J\u0014\u0010L\u001a\u00020/*\u0002012\u0006\u0010I\u001a\u00020\u001eH\u0002J\b\u0010M\u001a\u00020/H\u0002R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\tX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\fX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\fX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0019\u001a\u0012\u0012\u0004\u0012\u00020\f0\u001aj\b\u0012\u0004\u0012\u00020\f`\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u001c\u001a\u0012\u0012\u0004\u0012\u00020\f0\u001aj\b\u0012\u0004\u0012\u00020\f`\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u001d\u001a\u0012\u0012\u0004\u0012\u00020\u001e0\u001aj\b\u0012\u0004\u0012\u00020\u001e`\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020$X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010&\u001a\u00020'X\u0082\u0004¢\u0006\u0004\n\u0002\u0010(R\u000e\u0010)\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006O"}, d2 = {"Lcom/ss/android/lark/keyboard/plugin/tool/voice/immersive/widget/VoiceWaveBar;", "Landroid/view/View;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "eachFlameWidth", "", "spaceBetweenFlames", "maxWidth", "", "maxHeight", "minHeight", "axisY", "r", "nFlames", "startX", "endX", "smoothFactor", "rateFactor", "zoom", "flamesPaint", "Landroid/graphics/Paint;", "orgHeightArr", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "newHeightArr", "rectArr", "Landroid/graphics/RectF;", "sigmoidXOffset", "", "shouldRefresh", "", "lastVolume", "", "maxVolume", "rectFPool", "com/ss/android/lark/keyboard/plugin/tool/voice/immersive/widget/VoiceWaveBar$rectFPool$1", "Lcom/ss/android/lark/keyboard/plugin/tool/voice/immersive/widget/VoiceWaveBar$rectFPool$1;", "dp5", "dp7", "dp9", "dp11", "currentX", "onDraw", "", "canvas", "Landroid/graphics/Canvas;", "onSizeChanged", "w", "h", "oldw", "oldh", "setWaveBarColor", "colorResId", "alpha", "reset", "pauseRefresh", "resumeRefresh", "stopRefresh", "refresh", "volume", "generateHeight", "barItemCounts", "sigmoidTransformation", "num", "randomHeightArray", "n", "startAnimation", "orgArr", "newArr", "rectF", "left", "height", "drawRoundRectF", "calculateNFlames", "Companion", "keyboard-biz-voice_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class VoiceWaveBar extends View {
    public final int a;
    public final int b;
    public float c;
    public float d;
    public final float e;
    public float f;
    public final float g;
    public int h;
    public float i;
    public final int j;
    public final float k;
    public final float l;
    public final Paint m;
    public ArrayList<Float> n;
    public final ArrayList<Float> o;
    public final ArrayList<RectF> p;
    public final double q;
    public boolean r;
    public float s;
    public final b t;
    public final int u;
    public final int v;
    public final int w;
    public final int x;
    public int y;

    public static final class a {
    }

    public static final class b extends v<RectF> {
        public b() {
            super(100);
        }

        public final Object a(Object[] r2) {
            Intrinsics.checkNotNullParameter(r2, "args");
            return new RectF();
        }
    }

    static {
    }

    public final void a(Number r15) {
        Intrinsics.checkNotNullParameter(r15, "volume");
        if (this.r == true) goto L5;
        return;
    L5:
        this.s = RangesKt.coerceAtLeast(this.s, r15.floatValue());
        ArrayList<Float> r0 = this.n;
        if (r0.size() == this.h) goto L12;
        r0.clear();
        int r1 = this.h;
        ArrayList r2 = new ArrayList(r1);
        int r5 = 0;
    L8:
        if (r5 >= r1) goto L10;
        r2.add(Float.valueOf(0.0f));
        r5 = r5 + 1;
        goto L8
    L10:
        r0.addAll(r2);
    L12:
        if (this.o.size() == this.h) goto L17;
        this.o.clear();
        ArrayList<Float> r3 = this.o;
        int r4 = this.h;
        ArrayList r6 = new ArrayList(r4);
        int r7 = 0;
    L14:
        if (r7 >= r4) goto L16;
        r6.add(Float.valueOf(0.0f));
        r7 = r7 + 1;
        goto L14
    L16:
        r3.addAll(r6);
    L17:
        float r8 = Math.max(this.e, (float) (((double) this.d) / (Math.exp(-(r15.doubleValue() - this.q)) + 1.0d)));
        if (r8 >= 0.0f) goto L21;
        r8 = 0.0f;
    L21:
        if (r15.floatValue() <= 46.7f) goto L23;
        this.y = 0;
        int r16 = this.h;
        Float r9 = Float.valueOf(r8);
        float r10 = 2;
        Float r11 = Float.valueOf(this.g * r10);
        Intrinsics.checkNotNullParameter(r9, "maxHeight");
        ArrayList r12 = new ArrayList(r16);
        int r13 = 0;
    L45:
        if (r13 >= r16) goto L47;
        r12.add(Float.valueOf(Random.Default.nextFloat() * r9.floatValue()));
        r13 = r13 + 1;
        goto L45
    L47:
        ArrayList<Float> r14 = new ArrayList(r16);
        int r17 = 0;
    L48:
        if (r17 >= r16) goto L58;
        float r18 = ((Number) ListProtector.get(r12, r17)).floatValue();
        if (r17 != 0) goto L52;
        float r19 = 0.0f;
    L53:
        int r110 = r16 - 1;
        if (r17 != r110) goto L56;
        float r111 = 0.0f;
    L57:
        r14.add(Float.valueOf(Math.max(Math.min((r18 + Math.min(((r19 + r111) - (r10 * r18)) / this.j, this.k * r18)) * (((float) Math.sin((r17 * 3.1415927f) / r110)) * this.l), r9.floatValue()), r11.floatValue())));
        r17 = r17 + 1;
        goto L48
    L56:
        r111 = ((Number) ListProtector.get(r12, r17 + 1)).floatValue();
        goto L57
    L52:
        r19 = ((Number) ListProtector.get(r12, r17 - 1)).floatValue();
        goto L53
    L58:
        ArrayList<Float> r112 = r14;
    L59:
        float r20 = this.i;
        Iterator<T> r21 = r0.iterator();
        int r22 = 0;
    L61:
        if (r21.hasNext() == false) goto L67;
        int r23 = r22 + 1;
        float r24 = ((Number) r21.next()).floatValue();
        float r25 = this.f;
        float r26 = r24 / 2;
        float r27 = r25 - r26;
        float r28 = r25 + r26;
        float r29 = this.a + r20;
        RectF r113 = (RectF) this.t.c(new Object[0]);
        r113.set(r20, r27, r29, r28);
        if (this.p.size() > r22) goto L65;
        this.p.add(r113);
    L66:
        r20 = r20 + (this.a + this.b);
        r22 = r23;
        goto L61
    L65:
        ListProtector.set(this.p, r22, r113);
        goto L66
    L67:
        int r30 = r0.size();
        if (r30 == r112.size()) goto L70;
    L73:
        Log.e("AudioWaveBar", "size not equal");
    L74:
        this.n = r112;
        return;
    L70:
        if (r30 != this.p.size()) goto L73;
        ValueAnimator r31 = ValueAnimator.ofFloat(new float[]{0.0f, 12.0f});
        r31.addUpdateListener(new c(this, r0, r112));
        r31.setDuration(200);
        r31.start();
        goto L74
    L23:
        if (this.y > 0) goto L25;
        this.y = 1;
    L25:
        int r114 = this.h;
        int r32 = 0;
    L26:
        if (r32 >= r114) goto L43;
        int r33 = Math.abs((r114 / 2) - r32);
        int r34 = this.y;
        if (r34 > r33) goto L30;
        int r35 = this.u;
    L42:
        ListProtector.set(this.o, r32, Float.valueOf(r35));
        r32 = r32 + 1;
        goto L26
    L30:
        switch(((r34 - r33) % 9)) {
            case 0: goto L40;
            case 1: goto L39;
            case 2: goto L38;
            case 3: goto L37;
            case 4: goto L36;
            case 5: goto L35;
            case 6: goto L34;
            case 7: goto L33;
            case 8: goto L32;
            default: goto L31;
        };
    L31:
        r35 = this.u;
        goto L42
    L32:
        r35 = this.u;
        goto L42
    L33:
        r35 = this.u;
        goto L42
    L34:
        r35 = this.v;
        goto L42
    L35:
        r35 = this.w;
        goto L42
    L36:
        r35 = this.x;
        goto L42
    L37:
        r35 = this.w;
        goto L42
    L38:
        r35 = this.v;
        goto L42
    L39:
        r35 = this.u;
        goto L42
    L40:
        r35 = this.u;
        goto L42
    L43:
        this.y = (this.y + 1) % 16;
        r112 = this.o;
        goto L59
    }

    public final void b(int r5) {
        this.m.setColor(UIUtils.getColor(getContext(), r5));
        this.m.setAlpha((int) (0.8d * ((double) 255)));
    }

    @Override // android.view.View
    public final void onDraw(Canvas r5) {
        Intrinsics.checkNotNullParameter(r5, "canvas");
        super.onDraw(r5);
        Iterator<T> r0 = this.p.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        RectF r1 = (RectF) r0.next();
        float r2 = this.g;
        r5.drawRoundRect(r1, r2, r2, this.m);
        this.t.d(r1);
        goto L4
    }

    public final void setWaveBarColor(int r3) {
        this.m.setColor(d.c(getContext(), r3));
    }

    public VoiceWaveBar(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r3, r4);
        int r0 = d.a(2);
        this.a = r0;
        this.b = d.a(2);
        this.e = d.a(5);
        this.g = r0 / 2.0f;
        this.j = 4;
        this.k = 0.5f;
        this.l = 1.15f;
        Paint r5 = new Paint();
        this.m = r5;
        this.n = new ArrayList(this.h);
        this.o = new ArrayList(this.h);
        this.p = new ArrayList(this.h);
        this.q = 5.0d;
        this.r = true;
        this.t = new b();
        this.u = d.b(r3, 5.0f);
        this.v = d.b(r3, 7.0f);
        this.w = d.b(r3, 9.0f);
        this.x = d.b(r3, 11.0f);
        this.y = 1;
        r5.setStyle(Paint.Style.FILL);
    }

    @Override // android.view.View
    public final void onSizeChanged(int r1, int r2, int r3, int r4) {
        this.c = r1;
        float r5 = r2;
        this.d = r5;
        this.f = r5 / 2.0f;
        this.p.clear();
        this.n.clear();
        this.h = 0;
        float r6 = this.c;
    L3:
        int r7 = this.a;
        float r8 = r6 - r7;
        int r9 = this.b;
        if (r8 <= (r7 + r9)) goto L6;
        this.h++;
        r6 = r8 - r9;
        goto L3
    L6:
        this.i = r8 / 2;
        a(Float.valueOf(this.s));
    }
}
