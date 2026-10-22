package com.bytedance.android.live.core.gl.primitive;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u0007\n\u0002\b\u0010\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002H&J\u0010\u0010\b\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002H&j\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/live/core/gl/primitive/Align;", "", "", "horizontalSize", "getLeftMargin", "getRightMargin", "verticalSize", "getTopMargin", "getBottomMargin", "CENTER", "CENTER_TOP", "CENTER_BOTTOM", "CENTER_LEFT", "CENTER_RIGHT", "LEFT_TOP", "LEFT_BOTTOM", "RIGHT_TOP", "RIGHT_BOTTOM", "livecommonui_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract enum Align extends Enum<Align> {
    public static final Align CENTER = null;
    public static final Align CENTER_BOTTOM = null;
    public static final Align CENTER_LEFT = null;
    public static final Align CENTER_RIGHT = null;
    public static final Align CENTER_TOP = null;
    public static final Align LEFT_BOTTOM = null;
    public static final Align LEFT_TOP = null;
    public static final Align RIGHT_BOTTOM = null;
    public static final Align RIGHT_TOP = null;
    public static final /* synthetic */ Align[] a = null;

    static {
        final String r2 = "CENTER";
        final int r3 = 0;
        Align r1 = new CENTER(r2, r3);
        CENTER = r1;
        final String r4 = "CENTER_TOP";
        final int r5 = 1;
        Align r6 = new CENTER_TOP(r4, r5);
        CENTER_TOP = r6;
        final String r7 = "CENTER_BOTTOM";
        final int r8 = 2;
        Align r9 = new CENTER_BOTTOM(r7, r8);
        CENTER_BOTTOM = r9;
        final String r11 = "CENTER_LEFT";
        final int r12 = 3;
        Align r13 = new CENTER_LEFT(r11, r12);
        CENTER_LEFT = r13;
        final String r14 = "CENTER_RIGHT";
        final int r15 = 4;
        Align r16 = new CENTER_RIGHT(r14, r15);
        CENTER_RIGHT = r16;
        final String r17 = "LEFT_TOP";
        final int r18 = 5;
        Align r19 = new LEFT_TOP(r17, r18);
        LEFT_TOP = r19;
        final String r21 = "LEFT_BOTTOM";
        final int r22 = 6;
        Align r23 = new LEFT_BOTTOM(r21, r22);
        LEFT_BOTTOM = r23;
        final String r24 = "RIGHT_TOP";
        final int r25 = 7;
        Align r26 = new RIGHT_TOP(r24, r25);
        RIGHT_TOP = r26;
        final String r27 = "RIGHT_BOTTOM";
        final int r28 = 8;
        Align r29 = new RIGHT_BOTTOM(r27, r28);
        RIGHT_BOTTOM = r29;
        a = new Align[]{r1, r6, r9, r13, r16, r19, r23, r26, r29};
    }

    public Align() {
        throw null;
    }

    public static Align valueOf(String r1) {
        return (Align) r27.a.a(Align.class, r1);
    }

    public static Align[] values() {
        return (Align[]) a.clone();
    }

    public abstract float getBottomMargin(float r1);

    public abstract float getLeftMargin(float r1);

    public abstract float getRightMargin(float r1);

    public abstract float getTopMargin(float r1);

    public Align(String r1, int r2, DefaultConstructorMarker r3) {
        super(r1, r2);
    }
}
