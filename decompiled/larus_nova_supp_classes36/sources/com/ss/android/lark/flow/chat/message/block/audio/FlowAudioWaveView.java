package com.ss.android.lark.flow.chat.message.block.audio;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u0014\n\u0002\b\t\b\u0007\u0018\u0000 [2\u00020\u0001:\u0003YZ[B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010 J\u0010\u0010'\u001a\u00020%2\b\u0010(\u001a\u0004\u0018\u00010\u0016J\u000e\u0010)\u001a\u00020%2\u0006\u0010\u0017\u001a\u00020\u0018J\u0006\u0010*\u001a\u00020%J\u0006\u0010+\u001a\u00020%J\u0006\u0010,\u001a\u00020%J\u000e\u0010-\u001a\u00020%2\u0006\u0010.\u001a\u00020\u0007J\u000e\u0010/\u001a\u00020%2\u0006\u00100\u001a\u00020\u0007J\u000e\u00101\u001a\u00020%2\u0006\u00102\u001a\u00020\u0007J\u000e\u00103\u001a\u00020%2\u0006\u00104\u001a\u00020\u0007J\u000e\u00105\u001a\u00020%2\u0006\u00106\u001a\u00020\u0007J\u000e\u00107\u001a\u00020%2\u0006\u00106\u001a\u00020\u0007J\u0010\u00108\u001a\u00020%2\u0006\u00109\u001a\u00020\u001dH\u0016J\u0010\u0010:\u001a\u00020%2\u0006\u0010;\u001a\u00020<H\u0014J\u0010\u0010=\u001a\u00020\u001d2\u0006\u0010>\u001a\u00020?H\u0016J\u0010\u0010@\u001a\u00020\u00182\u0006\u0010A\u001a\u00020\u0018H\u0002J@\u0010B\u001a\u00020%2\u0006\u0010;\u001a\u00020<2\u0006\u0010C\u001a\u00020\u00182\u0006\u0010D\u001a\u00020\u00182\u0006\u0010E\u001a\u00020\u00182\u0006\u0010F\u001a\u00020\u00182\u0006\u0010G\u001a\u00020\u00182\u0006\u0010H\u001a\u00020\u000bH\u0002J\u0018\u0010I\u001a\u00020\u00072\u0006\u0010(\u001a\u00020\u00162\u0006\u0010J\u001a\u00020\u0007H\u0002J\u0010\u0010K\u001a\u00020\u00182\u0006\u0010L\u001a\u00020\u0018H\u0002J\u0010\u0010M\u001a\u00020\u00072\u0006\u0010L\u001a\u00020\u0018H\u0002J \u0010N\u001a\u00020\u00072\u0006\u0010O\u001a\u00020\u00182\u0006\u0010P\u001a\u00020\u00182\u0006\u0010Q\u001a\u00020\u0018H\u0002J\u0018\u0010R\u001a\u00020S2\u0006\u0010T\u001a\u00020\u00072\u0006\u0010U\u001a\u00020\u0018H\u0002J\u0010\u0010V\u001a\u00020\u00072\u0006\u0010(\u001a\u00020\u0016H\u0002J\u0018\u0010W\u001a\u00020\u00182\u0006\u0010J\u001a\u00020\u00072\u0006\u0010X\u001a\u00020\u0007H\u0002R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010 X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\\"}, d2 = {"Lcom/ss/android/lark/flow/chat/message/block/audio/FlowAudioWaveView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "wavePaint", "Landroid/graphics/Paint;", "playedPaint", "drawRect", "Landroid/graphics/RectF;", "unPlayedColor", "playedColor", "barWidthPx", "barSpacingPx", "minBarHeightPx", "cornerRadiusPx", "waveformBytes", "", "progress", "", "lastMonotonicProgress", "playState", "Lcom/ss/android/lark/flow/chat/message/block/audio/FlowAudioWaveView$PlayState;", "isDraggingInternal", "", "dragProgress", "dragListener", "Lcom/ss/android/lark/flow/chat/message/block/audio/FlowAudioWaveView$OnProgressDragListener;", "initialTouchX", "initialTouchY", "touchSlop", "setOnProgressDragListener", "", "listener", "setWaveformBytes", "bytes", "setProgress", "setPlaying", "setPaused", "setStopped", "setBarWidthPx", "widthPx", "setBarSpacingPx", "spacingPx", "setMinBarHeightPx", "minHeightPx", "setCornerRadiusPx", "radiusPx", "setUnPlayedColor", "color", "setPlayedColor", "setEnabled", "enabled", "onDraw", "canvas", "Landroid/graphics/Canvas;", "onTouchEvent", "event", "Landroid/view/MotionEvent;", "calcProgressByX", "x", "drawRoundRect", "left", "top", "right", "bottom", "radius", "paint", "decode5BitsValue", "index", "dpToPx", "dp", "dpToPxInt", "computeBarCount", "contentWidth", "barWidth", "barSpacing", "buildBarHalfHeightsPx", "", "barCount", "contentHeight", "stableSeedFromBytes", "stableNoise", "seed", "OnProgressDragListener", "PlayState", "Companion", "flow-chat_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class FlowAudioWaveView extends View {
    public final Paint a;
    public final Paint b;
    public final RectF c;
    public int d;
    public int e;
    public int f;
    public int g;
    public int h;
    public int i;
    public byte[] j;
    public float k;
    public float l;
    public PlayState m;
    public boolean n;
    public float o;
    public b p;
    public float q;
    public float r;
    public final int s;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/ss/android/lark/flow/chat/message/block/audio/FlowAudioWaveView$PlayState;", "", "<init>", "(Ljava/lang/String;I)V", "PLAYING", "PAUSED", "STOPPED", "flow-chat_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
    public static final enum PlayState extends Enum<PlayState> {
        public static final PlayState PAUSED = null;
        public static final PlayState PLAYING = null;
        public static final PlayState STOPPED = null;
        public static final /* synthetic */ PlayState[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static EnumEntries<PlayState> getEntries() {
            return b;
        }

        static {
            PlayState r0 = new PlayState("PLAYING", 0);
            PLAYING = r0;
            PlayState r1 = new PlayState("PAUSED", 1);
            PAUSED = r1;
            PlayState r3 = new PlayState("STOPPED", 2);
            STOPPED = r3;
            PlayState[] r5 = {r0, r1, r3};
            a = r5;
            b = EnumEntriesKt.enumEntries(r5);
        }

        public static PlayState[] values() {
            return (PlayState[]) a.clone();
        }

        public static PlayState valueOf(String r1) {
            return (PlayState) r27.a.a(PlayState.class, r1);
        }

        public PlayState(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static final class a {
    }

    public interface b {
        void a(FlowAudioWaveView r1, float r2);

        void c(FlowAudioWaveView r1, float r2);

        void d(FlowAudioWaveView r1, float r2);
    }

    static {
    }

    public FlowAudioWaveView(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public FlowAudioWaveView(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    public final float a(float r6) {
        float r0 = (getWidth() - getPaddingLeft()) - getPaddingRight();
        if (r0 > 0.0f) goto L6;
        return 0.0f;
    L6:
        return RangesKt.coerceIn((RangesKt.coerceIn(r6, getPaddingLeft(), getWidth() - getPaddingRight()) - getPaddingLeft()) / r0, 0.0f, 1.0f);
    }

    public final float b(float r3) {
        Resources r0 = getResources();
        return TypedValue.applyDimension(1, r3, WindowDisplayMetricsOverride.apply(r0, r0.getDisplayMetrics()));
    }

    @Override // android.view.View
    public final void onDraw(Canvas r24) {
        Intrinsics.checkNotNullParameter(r24, "canvas");
        float r2 = (getWidth() - getPaddingLeft()) - getPaddingRight();
        float r3 = (getHeight() - getPaddingTop()) - getPaddingBottom();
        if (r2 > 0.0f) goto L5;
        return;
    L5:
        if (r3 <= 0.0f) goto L160;
        byte[] r5 = this.j;
        int r8 = 1;
        if (r5.length != 0) goto L10;
        boolean r6 = true;
    L11:
        if (r6 == false) goto L13;
        return;
    L13:
        float r7 = this.f;
        float r9 = this.g + r7;
        if (r9 > 0.0f) goto L16;
        return;
    L16:
        if (r9 > 0.0f) goto L18;
    L21:
        int r10 = 0;
    L22:
        if (r10 > 0) goto L24;
        return;
    L24:
        int r11 = (r5.length * 8) / 5;
        if (r11 <= 0) goto L107;
        if (r10 <= 0) goto L107;
        float[] r14 = new float[r11];
        int r15 = 0;
    L29:
        if (r15 >= r11) goto L40;
        byte[] r13 = this.j;
        int r17 = r15 * 5;
        int r4 = r17 / 8;
        int r18 = r17 - (r4 * 8);
        int r12 = 8 - r18;
        int r20 = 5 - r12;
        Byte r21 = ArraysKt.getOrNull(r13, r4);
        if (r21 == null) goto L33;
        int r16 = r21.byteValue() & 255;
    L34:
        int r19 = (r16 >> r18) & ((1 << Math.min(5, r12)) - 1);
        if (r20 <= 0) goto L39;
        int r22 = r4 + 1;
        if (r22 >= r13.length) goto L39;
        r19 = (r19 << r20) | ((r13[r22] & 255) & ((1 << r20) - 1));
    L39:
        r14[r15] = r19;
        r15 = r15 + 1;
        goto L29
    L33:
        r16 = 0;
        goto L34
    L40:
        float[] r23 = new float[r10];
        if (r11 <= r10) goto L55;
        int r25 = 0;
    L43:
        if (r25 >= r10) goto L54;
        int r110 = (r25 * r11) / r10;
        int r111 = r25 + 1;
        int r112 = (r111 * r11) / r10;
        if (r112 > r110) goto L47;
        r112 = RangesKt.coerceAtMost(r110 + 1, r11);
    L47:
        int r113 = RangesKt.coerceAtLeast(r112 - r110, r8);
        float r114 = 0.0f;
        float r26 = 0.0f;
    L48:
        if (r110 >= r112) goto L53;
        float r27 = r14[r110];
        if (r27 <= r26) goto L52;
        r26 = r27;
    L52:
        r114 = r114 + (r27 * r27);
        r110 = r110 + 1;
        goto L48
    L53:
        r23[r25] = (((float) Math.sqrt(r114 / r113)) * 0.7f) + (r26 * 0.3f);
        r25 = r111;
        r9 = r9;
        r8 = 1;
        goto L43
    L54:
        float r115 = r9;
    L66:
        float r28 = r23[0];
        float r29 = r28;
        int r30 = 1;
    L67:
        if (r30 >= r10) goto L75;
        float r31 = r23[r30];
        if (r31 >= r29) goto L72;
        r29 = r31;
    L72:
        if (r31 <= r28) goto L74;
        r28 = r31;
    L74:
        r30 = r30 + 1;
        goto L67
    L75:
        float[] r32 = new float[r10];
        float r33 = r28 - r29;
        if (r33 >= 0.001f) goto L83;
        byte[] r34 = this.j;
        int r35 = r34.length;
        int r36 = 0;
        int r116 = 1;
    L78:
        if (r36 >= r35) goto L80;
        r116 = (r116 * 31) + (r34[r36] & 255);
        r36 = r36 + 1;
        goto L78
    L80:
        int r37 = 0;
    L81:
        if (r37 >= r10) goto L86;
        int r38 = ((-1640531527) * r37) ^ r116;
        int r39 = (r38 ^ (r38 >>> 16)) * 2146121005;
        int r40 = (r39 ^ (r39 >>> 15)) * (-2073254261);
        r32[r37] = RangesKt.coerceIn(((((((r40 ^ (r40 >>> 16)) >>> 8) & 65535) / 65535.0f) - 0.5f) * 0.05f) + 0.5f, 0.0f, 1.0f);
        r37 = r37 + 1;
    L86:
        float[] r41 = new float[r10];
        int r42 = 0;
    L87:
        if (r42 >= r10) goto L89;
        r41[r42] = (float) Math.pow(r32[r42], 0.8f);
        r42 = r42 + 1;
        goto L87
    L89:
        float r43 = RangesKt.coerceAtMost(Math.max(this.h, b(4.0f)), r3);
        float r44 = RangesKt.coerceAtLeast(Math.min(b(20.0f), r3), r43);
        float[] r45 = new float[r10];
        int r46 = 0;
    L90:
        if (r46 >= r10) goto L92;
        r45[r46] = RangesKt.coerceIn((r41[r46] * (r44 - r43)) + r43, r43, r44);
        r46 = r46 + 1;
        goto L90
    L92:
        float[] r47 = new float[r10];
        int r48 = 0;
    L93:
        if (r48 >= r10) goto L103;
        Float r117 = ArraysKt.getOrNull(r45, r48 - 1);
        if (r117 == null) goto L97;
        float r118 = r117.floatValue();
    L98:
        int r119 = r48 + 1;
        Float r120 = ArraysKt.getOrNull(r45, r119);
        if (r120 == null) goto L101;
        float r121 = r120.floatValue();
    L102:
        r47[r48] = RangesKt.coerceIn(((r118 * 0.2f) + (r45[r48] * 0.6f)) + (r121 * 0.2f), r43, r44);
        r48 = r119;
        goto L93
    L101:
        r121 = r45[r48];
        goto L102
    L97:
        r118 = r45[r48];
        goto L98
    L103:
        float r49 = 2.0f;
        float r50 = r43 / 2.0f;
        float r51 = RangesKt.coerceAtMost(r44 / 2.0f, r3 / 2.0f);
        float[] r52 = new float[r10];
        int r122 = 0;
    L104:
        if (r122 >= r10) goto L108;
        r52[r122] = RangesKt.coerceIn(r47[r122] / r49, r50, r51);
        r122 = r122 + 1;
        r49 = 2.0f;
    L108:
        this.a.setColor(this.d);
        this.b.setColor(this.e);
        float r53 = r3 / 2.0f;
        float r54 = getPaddingTop() + r53;
        float r55 = this.h / 2.0f;
        if (this.n == false) goto L112;
        float r56 = this.o;
    L114:
        float r123 = 0.0f;
        float r124 = getPaddingLeft() + (RangesKt.coerceIn(r56, 0.0f, 1.0f) * r2);
        if (this.n == true) goto L120;
        r123 = r7 / 2.0f;
    L120:
        int r57 = 0;
    L121:
        if (r57 >= r10) goto L161;
        float r58 = getPaddingLeft() + (r57 * r115);
        float r125 = r58 + r7;
        if (r125 > (getPaddingLeft() + r2)) goto L162;
        Float r126 = ArraysKt.getOrNull(r52, r57);
        if (r126 == null) goto L127;
        float r127 = r126.floatValue();
    L128:
        float r128 = RangesKt.coerceIn(r127, r55, r53);
        float r129 = r2;
        float r130 = r53;
        float r59 = Math.min(this.i, Math.min(r7 / 2.0f, r128));
        float r60 = r54 - r128;
        float r131 = r128 + r54;
        if ((r58 + r123) < r124) goto L131;
        Paint r61 = this.a;
        this.c.set(r58, r60, r125, r131);
        r24.drawRoundRect(this.c, r59, r59, r61);
    L132:
        r57 = r57 + 1;
        r2 = r129;
        r53 = r130;
        r54 = r54;
        r7 = r7;
        goto L121
    L131:
        Paint r62 = this.b;
        this.c.set(r58, r60, r125, r131);
        r24.drawRoundRect(this.c, r59, r59, r62);
        goto L132
    L127:
        r127 = r55;
        goto L128
    L162:
        return;
    L161:
        return;
    L112:
        if (this.m != PlayState.STOPPED) goto L115;
        r56 = 1.0f;
        goto L114
    L115:
        r56 = this.k;
        goto L114
    L83:
        float r63 = 1.0f;
        float r132 = 0.0f;
        int r133 = 0;
    L84:
        if (r133 >= r10) goto L86;
        r32[r133] = RangesKt.coerceIn((r23[r133] - r29) / r33, r132, r63);
        r133 = r133 + 1;
        r63 = 1.0f;
        r132 = 0.0f;
        goto L84
    L55:
        r115 = r9;
        if (r11 < r10) goto L58;
        int r64 = 0;
    L64:
        if (r64 >= r10) goto L66;
        r23[r64] = r14[r64];
        r64 = r64 + 1;
        goto L64
    L58:
        if (r10 != 1) goto L60;
        r23[0] = r14[0];
        goto L66
    L60:
        int r65 = 0;
        int r66 = RangesKt.coerceAtLeast(r11 - 1, 0);
        int r67 = 0;
    L61:
        if (r67 >= r10) goto L66;
        float r134 = (r67 * r66) / (r10 - 1);
        int r135 = RangesKt.coerceIn((int) r134, r65, r66);
        int r136 = RangesKt.coerceIn(r135 + 1, r65, r66);
        float r137 = RangesKt.coerceIn(r134 - r135, 0.0f, 1.0f);
        r23[r67] = (r14[r135] * (1.0f - r137)) + (r14[r136] * r137);
        r67 = r67 + 1;
        r65 = 0;
    L107:
        r115 = r9;
        r52 = new float[0];
        goto L108
    L18:
        if (r2 < r7) goto L21;
        r10 = ((int) ((r2 - r7) / r9)) + 1;
        goto L22
    L10:
        r6 = false;
        goto L11
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r6) {
        Intrinsics.checkNotNullParameter(r6, "event");
        boolean r1 = false;
        if (isEnabled() == true) goto L5;
        return false;
    L5:
        int r0 = r6.getActionMasked();
        if (r0 != 0) goto L8;
        super.onTouchEvent(r6);
        this.q = r6.getX();
        this.r = r6.getY();
        this.n = false;
        return true;
    L8:
        if (r0 == 1) goto L40;
        if (r0 == 2) goto L14;
        if (r0 == 3) goto L40;
        return super.onTouchEvent(r6);
    L14:
        super.onTouchEvent(r6);
        if (this.n == true) goto L30;
        float r2 = Math.abs(r6.getX() - this.q);
        float r3 = Math.abs(r6.getY() - this.r);
        int r4 = this.s;
        if (r2 <= r4) goto L19;
    L20:
        this.n = true;
        ViewParent r5 = getParent();
        if (r5 == null) goto L23;
        r5.requestDisallowInterceptTouchEvent(true);
    L23:
        cancelLongPress();
        float r7 = a(r6.getX());
        this.o = r7;
        b r8 = this.p;
        if (r8 == null) goto L26;
        r8.a(this, r7);
    L26:
        b r9 = this.p;
        if (r9 == null) goto L29;
        r9.c(this, r7);
    L29:
        invalidate();
    L38:
        return true;
    L19:
        if (r3 <= r4) goto L38;
    L30:
        float r10 = a(r6.getX());
        if (r10 != this.o) goto L33;
        r1 = true;
    L33:
        if (r1 == true) goto L38;
        this.o = r10;
        b r11 = this.p;
        if (r11 == null) goto L37;
        r11.c(this, r10);
    L37:
        invalidate();
    L40:
        if (this.n == false) goto L48;
        r6.setAction(3);
        super.onTouchEvent(r6);
        float r12 = a(r6.getX());
        this.o = r12;
        b r13 = this.p;
        if (r13 == null) goto L44;
        r13.d(this, r12);
    L44:
        this.n = false;
        this.k = r12;
        this.l = r12;
        ViewParent r14 = getParent();
        if (r14 == null) goto L47;
        r14.requestDisallowInterceptTouchEvent(false);
    L47:
        invalidate();
    L49:
        return true;
    L48:
        super.onTouchEvent(r6);
        goto L49
    }

    public final void setBarSpacingPx(int r2) {
        this.g = RangesKt.coerceAtLeast(r2, 0);
        invalidate();
    }

    public final void setBarWidthPx(int r2) {
        this.f = RangesKt.coerceAtLeast(r2, 0);
        invalidate();
    }

    public final void setCornerRadiusPx(int r2) {
        this.i = RangesKt.coerceAtLeast(r2, 0);
        invalidate();
    }

    @Override // android.view.View
    public void setEnabled(boolean r1) {
        super.setEnabled(r1);
        if (r1 == false) goto L5;
        return;
    L5:
        if (this.n == false) goto L9;
        this.n = false;
        invalidate();
        return;
    }

    public final void setMinBarHeightPx(int r2) {
        this.h = RangesKt.coerceAtLeast(r2, 0);
        invalidate();
    }

    public final void setOnProgressDragListener(b r1) {
        this.p = r1;
    }

    public final void setPlayedColor(int r1) {
        this.e = r1;
        invalidate();
    }

    public final void setProgress(float r3) {
        float r4 = RangesKt.coerceIn(r3, 0.0f, 1.0f);
        if (this.m == PlayState.PLAYING) goto L5;
    L7:
        this.k = r4;
        invalidate();
        return;
    L5:
        if (this.n == true) goto L7;
        r4 = Math.max(r4, this.l);
        this.l = r4;
        goto L7
    }

    public final void setUnPlayedColor(int r1) {
        this.d = r1;
        invalidate();
    }

    public final void setWaveformBytes(byte[] r2) {
        if (r2 != null) goto L4;
    L8:
        r2 = new byte[64];
    L9:
        this.j = r2;
        invalidate();
        return;
    L4:
        if (r2.length != 0) goto L6;
        boolean r0 = true;
    L7:
        if (r0 == false) goto L9;
    L6:
        r0 = false;
        goto L7
    }

    public FlowAudioWaveView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        Paint r5 = new Paint(1);
        r5.setStyle(Paint.Style.FILL);
        this.a = r5;
        Paint r6 = new Paint(1);
        r6.setStyle(Paint.Style.FILL);
        this.b = r6;
        this.c = new RectF();
        this.d = Color.argb(51, 255, 255, 255);
        this.e = Color.rgb(255, 255, 255);
        this.f = MathKt.roundToInt(b(2.5f));
        this.g = MathKt.roundToInt(b(2.0f));
        this.h = MathKt.roundToInt(b(4.0f));
        this.i = MathKt.roundToInt(b(2.0f));
        this.j = new byte[64];
        this.m = PlayState.STOPPED;
        setClickable(false);
        this.s = ViewConfiguration.get(r2).getScaledTouchSlop();
    }

    public /* synthetic */ FlowAudioWaveView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
