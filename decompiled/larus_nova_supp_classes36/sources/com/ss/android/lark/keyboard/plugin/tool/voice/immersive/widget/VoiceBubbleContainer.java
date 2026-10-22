package com.ss.android.lark.keyboard.plugin.tool.voice.immersive.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\r\n\u0002\u0010\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u00018B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J(\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u000f2\u0006\u0010#\u001a\u00020\u000f2\u0006\u0010$\u001a\u00020\u000f2\u0006\u0010%\u001a\u00020\u000fH\u0014J\u000e\u0010&\u001a\u00020\u00002\u0006\u0010\u001b\u001a\u00020\u000fJ\u000e\u0010'\u001a\u00020\u00002\u0006\u0010(\u001a\u00020\u000fJ\u000e\u0010)\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u000fJ\u0006\u0010*\u001a\u00020\u000fJ\u000e\u0010+\u001a\u00020\u00002\u0006\u0010(\u001a\u00020\u000fJ\u000e\u0010,\u001a\u00020\u00002\u0006\u0010(\u001a\u00020\u000fJ\u000e\u0010-\u001a\u00020\u00002\u0006\u0010(\u001a\u00020\u000fJ\u000e\u0010.\u001a\u00020\u00002\u0006\u0010(\u001a\u00020\u000fJ\u000e\u0010/\u001a\u00020\u00002\u0006\u0010\u0019\u001a\u00020\u000fJ\u000e\u00100\u001a\u00020!2\u0006\u0010\u0017\u001a\u00020\u000fJ\b\u00101\u001a\u00020!H\u0002J\b\u00102\u001a\u00020!H\u0002J\b\u00103\u001a\u00020!H\u0016J\b\u00104\u001a\u00020!H\u0016J\u0010\u00105\u001a\u00020!2\u0006\u00106\u001a\u000207H\u0014R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u00069"}, d2 = {"Lcom/ss/android/lark/keyboard/plugin/tool/voice/immersive/widget/VoiceBubbleContainer;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "attributeSet", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "paint", "Landroid/graphics/Paint;", "path", "Landroid/graphics/Path;", "arrowOrientation", "Lcom/ss/android/lark/keyboard/plugin/tool/voice/immersive/widget/VoiceBubbleContainer$ArrowOrientation;", "bubblePadding", "", "mWidth", "mHeight", "left", "", "top", "right", "bottom", "arrowPosition", "arrowWidth", "arrowLength", "bubbleRadius", "bubbleColor", "arrowTopLeftRadius", "arrowTopRightRadius", "arrowDownLeftRadius", "arrowDownRightRadius", "onSizeChanged", "", "w", "h", "oldw", "oldh", "setBubbleColor", "setBubbleRadius", "radius", "setArrowWidth", "getArrowWidth", "setArrowTLRadius", "setArrowTRRadius", "setArrowDLRadius", "setArrowDRRadius", "setArrowLength", "setArrowPosition", "initPadding", "initData", "invalidate", "postInvalidate", "onDraw", "canvas", "Landroid/graphics/Canvas;", "ArrowOrientation", "keyboard-biz-voice_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class VoiceBubbleContainer extends ConstraintLayout {
    public final Paint a;
    public final Path b;
    public final ArrowOrientation c;
    public int d;
    public int e;
    public float f;
    public float g;
    public int h;
    public final int i;
    public final int j;
    public final float k;
    public final int l;
    public final int m;
    public final int n;
    public final int o;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\n\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0003R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\u000b"}, d2 = {"Lcom/ss/android/lark/keyboard/plugin/tool/voice/immersive/widget/VoiceBubbleContainer$ArrowOrientation;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "LEFT", "TOP", "RIGHT", "BOTTOM", "getType", "keyboard-biz-voice_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
    public static final enum ArrowOrientation extends Enum<ArrowOrientation> {
        public static final ArrowOrientation BOTTOM = null;
        public static final ArrowOrientation LEFT = null;
        public static final ArrowOrientation RIGHT = null;
        public static final ArrowOrientation TOP = null;
        public static final /* synthetic */ ArrowOrientation[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final int value;

        public static EnumEntries<ArrowOrientation> getEntries() {
            return b;
        }

        static {
            ArrowOrientation r0 = new ArrowOrientation("LEFT", 0, 1);
            LEFT = r0;
            ArrowOrientation r1 = new ArrowOrientation("TOP", 1, 2);
            TOP = r1;
            ArrowOrientation r4 = new ArrowOrientation("RIGHT", 2, 3);
            RIGHT = r4;
            ArrowOrientation r6 = new ArrowOrientation("BOTTOM", 3, 4);
            BOTTOM = r6;
            ArrowOrientation[] r8 = {r0, r1, r4, r6};
            a = r8;
            b = EnumEntriesKt.enumEntries(r8);
        }

        public static ArrowOrientation[] values() {
            return (ArrowOrientation[]) a.clone();
        }

        public static ArrowOrientation valueOf(String r1) {
            return (ArrowOrientation) r27.a.a(ArrowOrientation.class, r1);
        }

        public final ArrowOrientation getType(int r2) {
            if (r2 == 1) goto L15;
            if (r2 == 2) goto L19;
            if (r2 == 3) goto L18;
            if (r2 == 4) goto L17;
            return BOTTOM;
        L17:
            return BOTTOM;
        L18:
            return RIGHT;
        L19:
            return TOP;
        L15:
            return LEFT;
        }

        public ArrowOrientation(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[ArrowOrientation.values().length];
            r0[ArrowOrientation.BOTTOM.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r0[ArrowOrientation.TOP.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r0[ArrowOrientation.LEFT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r0[ArrowOrientation.RIGHT.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            a = r0;
        }
    }

    public final void R5() {
        float r0 = this.d;
        ArrowOrientation r1 = this.c;
        if (r1 != ArrowOrientation.RIGHT) goto L5;
        float r2 = this.j;
    L6:
        this.f = r0 - r2;
        float r3 = this.e;
        if (r1 != ArrowOrientation.BOTTOM) goto L9;
        float r4 = this.j;
    L10:
        this.g = r3 - r4;
        this.a.setColor(0);
        this.b.reset();
        int r5 = this.h;
        int r6 = this.j;
        float r7 = r5 + r6;
        float r8 = this.g;
        if (r7 <= r8) goto L13;
        float r9 = r8 - this.i;
    L14:
        float r10 = r6 + r5;
        float r11 = this.f;
        if (r10 <= r11) goto L17;
        float r12 = r11 - this.i;
    L18:
        int r13 = a.a[this.c.ordinal()];
        if (r13 != 1) goto L21;
        float r14 = this.k;
        int r15 = this.o;
        if (r12 < (r14 + r15)) goto L37;
        this.b.moveTo(r12 - r15, this.g);
        Path r16 = this.b;
        int r17 = this.o;
        int r18 = this.i;
        float r19 = r17 + ((r18 / 2.0f) - this.m);
        int r20 = this.j;
        r16.rCubicTo(r17, 0.0f, r19, r20, (r18 / 2.0f) + r17, r20);
    L38:
        int r21 = this.i;
        float r22 = r21 + r12;
        float r23 = this.f - this.k;
        int r24 = this.n;
        if (r22 >= (r23 - r24)) goto L41;
        int r25 = this.j;
        this.b.rCubicTo(this.l, 0.0f, r21 / 2.0f, -r25, (r21 / 2.0f) + r24, -r25);
        this.b.lineTo(this.f - this.k, this.g);
    L41:
        Path r26 = this.b;
        float r27 = this.f;
        float r28 = this.g;
        r26.quadTo(r27, r28, r27, r28 - this.k);
        r26.lineTo(this.f, this.k + 0.0f);
        float r29 = this.f;
        r26.quadTo(r29, 0.0f, r29 - this.k, 0.0f);
        r26.lineTo(this.k + 0.0f, 0.0f);
        r26.quadTo(0.0f, 0.0f, 0.0f, this.k + 0.0f);
        r26.lineTo(0.0f, this.g - this.k);
        float r30 = this.k;
        if (r12 < (this.o + r30)) goto L44;
        float r31 = this.g;
        r26.quadTo(0.0f, r31, r30 + 0.0f, r31);
    L45:
        this.b.close();
        return;
    L44:
        float r32 = this.g;
        r26.quadTo(0.0f, r32, r12 + (this.i / 2.0f), this.j + r32);
        goto L45
    L37:
        this.b.moveTo((this.i / 2.0f) + r12, this.g + this.j);
        goto L38
    L21:
        if (r13 != 3) goto L45;
        float r33 = this.k;
        int r34 = this.o;
        if (r9 < (r33 + r34)) goto L26;
        this.b.moveTo(0.0f, r9 - r34);
        Path r35 = this.b;
        int r36 = this.o;
        int r37 = this.j;
        int r38 = this.i;
        r35.rCubicTo(0.0f, r36, -r37, ((r38 / 2.0f) - this.m) + r36, -r37, (r38 / 2.0f) + r36);
    L27:
        int r39 = this.i;
        float r40 = r39 + r9;
        float r41 = this.g - this.k;
        int r42 = this.n;
        if (r40 >= (r41 - r42)) goto L30;
        Path r43 = this.b;
        float r44 = this.l;
        int r45 = this.j;
        r43.rCubicTo(0.0f, r44, r45, r39 / 2.0f, r45, (r39 / 2.0f) + r42);
        this.b.lineTo(0.0f, this.g - this.k);
    L30:
        Path r46 = this.b;
        float r47 = this.g;
        r46.quadTo(0.0f, r47, this.k + 0.0f, r47);
        this.b.lineTo(this.f - this.k, this.g);
        Path r48 = this.b;
        float r49 = this.f;
        float r50 = this.g;
        r48.quadTo(r49, r50, r49, r50 - this.k);
        this.b.lineTo(this.f, this.k + 0.0f);
        Path r51 = this.b;
        float r52 = this.f;
        r51.quadTo(r52, 0.0f, r52 - this.k, 0.0f);
        this.b.lineTo(this.k + 0.0f, 0.0f);
        float r53 = this.k;
        if (r9 < (this.o + r53)) goto L33;
        this.b.quadTo(0.0f, 0.0f, 0.0f, r53 + 0.0f);
        goto L45
    L33:
        this.b.quadTo(0.0f, 0.0f, 0.0f - this.j, r9 + (this.i / 2.0f));
        goto L45
    L26:
        this.b.moveTo(0.0f - this.j, (this.i / 2.0f) + r9);
        goto L27
    L17:
        r12 = r5;
        goto L18
    L13:
        r9 = r5;
        goto L14
    L9:
        r4 = 0.0f;
        goto L10
    L5:
        r2 = 0.0f;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void invalidate() {
        R5();
        super/*android.view.ViewGroup*/.invalidate();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void postInvalidate() {
        R5();
        super/*android.view.ViewGroup*/.postInvalidate();
    }

    public final int getArrowWidth() {
        return this.i;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onDraw(Canvas r3) {
        Intrinsics.checkNotNullParameter(r3, "canvas");
        super/*android.view.ViewGroup*/.onDraw(r3);
        r3.drawPath(this.b, this.a);
    }

    public final void setArrowPosition(int r1) {
        this.h = r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public VoiceBubbleContainer(Context r6, AttributeSet r7) {
        Intrinsics.checkNotNullParameter(r6, "context");
        super(r6, r7);
        Paint r8 = new Paint();
        this.a = r8;
        this.b = new Path();
        ArrowOrientation r0 = ArrowOrientation.BOTTOM;
        this.c = r0;
        int r1 = UIUtils.dp2px(r6, 0.0f);
        this.i = UIUtils.dp2px(r6, 12.0f);
        int r2 = UIUtils.dp2px(r6, 9.0f);
        this.j = r2;
        this.k = UIUtils.dp2px(r6, 10.0f);
        this.l = UIUtils.dp2px(r6, 2.0f);
        this.m = UIUtils.dp2px(r6, 2.0f);
        this.n = UIUtils.dp2px(r6, 4.0f);
        this.o = UIUtils.dp2px(r6, 4.0f);
        setWillNotDraw(false);
        r8.setFlags(5);
        r8.setStyle(Paint.Style.FILL);
        int r9 = a.a[r0.ordinal()];
        if (r9 != 1) goto L5;
        setPadding(r1, r1, r1, r2 + r1);
    L16:
        setLayerType(1, null);
        return;
    L5:
        if (r9 != 2) goto L7;
        setPadding(r1, r2 + r1, r1, r1);
        goto L16
    L7:
        if (r9 != 3) goto L9;
        setPadding(r2 + r1, r1, r1, r1);
        goto L16
    L9:
        if (r9 != 4) goto L12;
        setPadding(r1, r2 + r1, r1, r1);
        goto L16
    L12:
        throw new NoWhenBranchMatchedException();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onSizeChanged(int r1, int r2, int r3, int r4) {
        super/*android.view.ViewGroup*/.onSizeChanged(r1, r2, r3, r4);
        this.d = r1;
        this.e = r2;
        R5();
    }
}
