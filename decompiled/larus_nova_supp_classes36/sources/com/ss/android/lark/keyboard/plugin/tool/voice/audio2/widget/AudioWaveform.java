package com.ss.android.lark.keyboard.plugin.tool.voice.audio2.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.keyboard.plugin.tool.voice.audio2.utils.AudioPluginEnums$WaveformState;
import com.ss.android.lark.keyboard.plugin.tool.voice.audio2.utils.c;
import com.ss.android.lark.log.Log;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadTimer;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 42\u00020\u0001:\u00014B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J(\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u000f2\u0006\u0010#\u001a\u00020\u000f2\u0006\u0010$\u001a\u00020\u000f2\u0006\u0010%\u001a\u00020\u000fH\u0014J\u0010\u0010&\u001a\u00020!2\u0006\u0010'\u001a\u00020(H\u0014J\u000e\u0010)\u001a\u00020!2\u0006\u0010*\u001a\u00020\u000fJ\u001a\u0010+\u001a\u00020!2\b\b\u0001\u0010,\u001a\u00020\u000f2\b\b\u0001\u0010-\u001a\u00020\u000fJ\u0006\u0010.\u001a\u00020!J\u0006\u0010/\u001a\u00020!J\u0006\u00100\u001a\u00020!J\b\u00101\u001a\u00020!H\u0002J\b\u00102\u001a\u00020!H\u0002J\b\u00103\u001a\u00020!H\u0002R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\t0\u0011j\b\u0012\u0004\u0012\u00020\t`\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u00065"}, d2 = {"Lcom/ss/android/lark/keyboard/plugin/tool/voice/audio2/widget/AudioWaveform;", "Landroid/view/View;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "singleWidth", "", "minHeight", "radius", "gapWidth", "mHorizonLine", "mCountInScreen", "", "mWaveHeightList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "mScaledHeightList", "", "mLastVolume", "mPaintWave", "Landroid/graphics/Paint;", "mPathWave", "Landroid/graphics/Path;", "mPaintFade", "mPathFade", "mTimer", "Ljava/util/Timer;", "mState", "Lcom/ss/android/lark/keyboard/plugin/tool/voice/audio2/utils/AudioPluginEnums$WaveformState;", "onSizeChanged", "", "w", "h", "oldw", "oldh", "onDraw", "canvas", "Landroid/graphics/Canvas;", "setVolume", "volume", "setColor", "colorWave", "colorFade", "startRecord", "stopRecord", "reset", "updateShowCount", "addNewHeight", "scaleAndDraw", "Companion", "keyboard-biz-voice_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class AudioWaveform extends View {
    public final float a;
    public final float b;
    public final float c;
    public final float d;
    public float e;
    public int f;
    public final ArrayList<Float> g;
    public List<Float> h;
    public final Paint i;
    public final Path j;
    public final Paint k;
    public final Path l;
    public PthreadTimer m;
    public AudioPluginEnums$WaveformState n;

    public static final class a {
    }

    static {
    }

    public final void setVolume(int r1) {
    }

    public final void a() {
        if (this.f > 0) goto L5;
        return;
    L5:
        int r0 = this.g.size();
        ArrayList r1 = new ArrayList(this.f);
        int r3 = this.f;
        float r2 = r0 / r3;
        int r5 = 0;
    L6:
        if (r5 >= r3) goto L18;
        int r6 = (int) Math.floor(r5 * r2);
        r5 = r5 + 1;
        float r7 = r5 * r2;
        float r8 = 0.0f;
        int r9 = 0;
    L9:
        if (r6 >= r7) goto L12;
        if (r6 >= r0) goto L12;
        r8 = r8 + ((Number) ListProtector.get(this.g, r6)).floatValue();     // Catch: Throwable -> L16
        r6 = r6 + 1;     // Catch: Throwable -> L16
        r9 = r9 + 1;     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        Log.e("AudioWaveform", th.getClass().getSimpleName() + " / " + th.getMessage() + ", heightList size: " + this.g.size() + ", indexStart: " + r6);
        Unit r10 = Unit.INSTANCE;
    L12:
        if (r9 > 0) goto L14;
        Log.w("AudioWaveform", "scaleAndDraw / itemCount error");     // Catch: Throwable -> L16
        r9 = 1;
    L14:
        r1.add(Float.valueOf(Math.max(r8 / r9, this.b)));     // Catch: Throwable -> L16
        goto L6
    L18:
        this.h = r1;
        invalidate();
    }

    @Override // android.view.View
    public final void onDraw(Canvas r13) {
        Intrinsics.checkNotNullParameter(r13, "canvas");
        this.e = getMeasuredHeight() / 2.0f;
        this.j.reset();
        this.l.reset();
        int r0 = this.g.size();
        float r1 = getMeasuredWidth() - this.d;
        int r2 = this.f;
        int r3 = 0;
    L3:
        if (r3 >= r2) goto L18;
        Path r4 = this.j;
        AudioPluginEnums$WaveformState r5 = this.n;
        if (r5 != AudioPluginEnums$WaveformState.RECORDING) goto L9;
        if (r0 <= r3) goto L9;
        float r6 = Math.max(((Number) ListProtector.get(this.g, (r0 - 1) - r3)).floatValue(), this.b);
    L17:
        float r7 = r1 - this.a;
        float r8 = this.e;
        float r9 = r6 / 2;
        float r10 = this.c;
        r4.addRoundRect(r7, r8 - r9, r1, r8 + r9, r10, r10, Path.Direction.CW);
        r1 = r1 - (this.a + this.d);
        r3 = r3 + 1;
    L9:
        if (r5 != AudioPluginEnums$WaveformState.DISPLAY) goto L16;
        List<Float> r11 = this.h;
        if (r11 == null) goto L15;
        Float r12 = (Float) CollectionsKt.getOrNull(r11, (this.f - 1) - r3);
        if (r12 == null) goto L15;
        r6 = r12.floatValue();
    L15:
        r6 = this.b;
        goto L17
    L16:
        r4 = this.l;
        r6 = this.b;
        goto L17
    L18:
        r13.drawPath(this.j, this.i);
        r13.drawPath(this.l, this.k);
    }

    public AudioWaveform(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3);
        int r4 = c.a;
        float r5 = c.n(this, 2);
        this.a = r5;
        this.b = c.n(this, 2);
        this.c = r5 / 2.0f;
        this.d = c.n(this, 2);
        this.g = new ArrayList(1024);
        this.i = new Paint(1);
        this.j = new Path();
        this.k = new Paint(1);
        this.l = new Path();
        this.n = AudioPluginEnums$WaveformState.INIT;
    }

    @Override // android.view.View
    public final void onSizeChanged(int r1, int r2, int r3, int r4) {
        this.f = 0;
        float r5 = getMeasuredWidth();
    L3:
        float r6 = this.a;
        if (r5 <= r6) goto L6;
        r5 = r5 - (r6 + this.d);
        this.f++;
        goto L3
    L6:
        a();
    }
}
