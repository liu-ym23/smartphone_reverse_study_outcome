package com.ss.android.lark.movable.rcanvas;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.fonts.Font;
import com.larksuite.component.universe_design.color.UDColorUtils;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.movable.utils.g;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a {
    public final Context a;
    public final Paint b;
    public final Paint c;
    public Path d;
    public float e;
    public Font f;
    public boolean g;

    /* JADX INFO: renamed from: com.ss.android.lark.movable.rcanvas.a$a, reason: collision with other inner class name */
    public static final class C0189a {
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[OpCode.values().length];
            r0[OpCode.SetFillRGBA.ordinal()] = 1;     // Catch: NoSuchFieldError -> L30
        L87:
            r0[OpCode.FillRect.ordinal()] = 2;     // Catch: NoSuchFieldError -> L31
        L103:
            r0[OpCode.SetStrokeRGBA.ordinal()] = 3;     // Catch: NoSuchFieldError -> L32
        L63:
            r0[OpCode.StrokeRect.ordinal()] = 4;     // Catch: NoSuchFieldError -> L33
        L67:
            r0[OpCode.SetFont.ordinal()] = 5;     // Catch: NoSuchFieldError -> L34
        L81:
            r0[OpCode.DrawGlyphRun.ordinal()] = 6;     // Catch: NoSuchFieldError -> L35
        L97:
            r0[OpCode.DrawText.ordinal()] = 7;     // Catch: NoSuchFieldError -> L36
        L73:
            r0[OpCode.SaveGState.ordinal()] = 8;     // Catch: NoSuchFieldError -> L37
        L91:
            r0[OpCode.RestoreGState.ordinal()] = 9;     // Catch: NoSuchFieldError -> L38
        L93:
            r0[OpCode.Translate.ordinal()] = 10;     // Catch: NoSuchFieldError -> L39
        L57:
            r0[OpCode.SetLineWidth.ordinal()] = 11;     // Catch: NoSuchFieldError -> L40
        L85:
            r0[OpCode.SetLineJoin.ordinal()] = 12;     // Catch: NoSuchFieldError -> L41
        L101:
            r0[OpCode.SetLineCap.ordinal()] = 13;     // Catch: NoSuchFieldError -> L42
        L55:
            r0[OpCode.SetMiterLimit.ordinal()] = 14;     // Catch: NoSuchFieldError -> L43
        L69:
            r0[OpCode.BeginPath.ordinal()] = 15;     // Catch: NoSuchFieldError -> L44
        L99:
            r0[OpCode.MoveTo.ordinal()] = 16;     // Catch: NoSuchFieldError -> L45
        L61:
            r0[OpCode.LineTo.ordinal()] = 17;     // Catch: NoSuchFieldError -> L46
        L65:
            r0[OpCode.BezierCurveTo.ordinal()] = 18;     // Catch: NoSuchFieldError -> L47
        L83:
            r0[OpCode.ClosePath.ordinal()] = 19;     // Catch: NoSuchFieldError -> L48
        L59:
            r0[OpCode.FillPath.ordinal()] = 20;     // Catch: NoSuchFieldError -> L49
        L77:
            r0[OpCode.StrokePath.ordinal()] = 21;     // Catch: NoSuchFieldError -> L50
        L79:
            r0[OpCode.ClipPath.ordinal()] = 22;     // Catch: NoSuchFieldError -> L51
        L95:
            r0[OpCode.Concatenate.ordinal()] = 23;     // Catch: NoSuchFieldError -> L52
        L71:
            r0[OpCode.SetFillVariable.ordinal()] = 24;     // Catch: NoSuchFieldError -> L53
        L89:
            r0[OpCode.SetStrokeVariable.ordinal()] = 25;     // Catch: NoSuchFieldError -> L54
        L28:
            a = r0;
        }
    }

    static {
    }

    public a(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this.a = r3;
        Paint r4 = new Paint(1);
        r4.setStyle(Paint.Style.FILL);
        this.b = r4;
        Paint r5 = new Paint(1);
        r5.setStyle(Paint.Style.STROKE);
        this.c = r5;
        this.d = new Path();
        this.e = 16.0f;
    }

    public final float b(float r2) {
        return com.ss.android.lark.movable.utils.b.d(r2, this.a);
    }

    public final int c(String r2) {
        Integer r0 = g.a(r2);
        if (r0 == null) goto L5;
        int r3 = r0.intValue();
    L7:
        return UDColorUtils.getColor(this.a, r3);
    L5:
        Log.i("CanvasApplier", "receive unknow color variable: ".concat(r2));
        r3 = 2131108998;
        goto L7
    }

    public static int a(float r2, float r3, float r4, float r5) {
        return Color.argb(RangesKt.coerceIn(MathKt.roundToInt(RangesKt.coerceIn(r2, 0.0f, 1.0f) * 255.0f), 0, 255), RangesKt.coerceIn(MathKt.roundToInt(r3), 0, 255), RangesKt.coerceIn(MathKt.roundToInt(r4), 0, 255), RangesKt.coerceIn(MathKt.roundToInt(r5), 0, 255));
    }
}
