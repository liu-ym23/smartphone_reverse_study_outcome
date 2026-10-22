package com.ss.android.lark.movable.rcanvas;

import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u001f\b\u0086\u0081\u0002\u0018\u0000 !2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001!B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b ¨\u0006\""}, d2 = {"Lcom/ss/android/lark/movable/rcanvas/OpCode;", "", "v", "", "<init>", "(Ljava/lang/String;II)V", "getV", "()I", "SetFillRGBA", "FillRect", "SetStrokeRGBA", "StrokeRect", "SetFont", "DrawGlyphRun", "SaveGState", "RestoreGState", "Translate", "BeginPath", "MoveTo", "LineTo", "BezierCurveTo", "ClosePath", "FillPath", "StrokePath", "ClipPath", "SetLineWidth", "SetLineJoin", "SetLineCap", "SetMiterLimit", "Concatenate", "SetFillVariable", "SetStrokeVariable", "DrawText", "Companion", "movable_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final enum OpCode extends Enum<OpCode> {
    public static final OpCode BeginPath = null;
    public static final OpCode BezierCurveTo = null;
    public static final OpCode ClipPath = null;
    public static final OpCode ClosePath = null;
    public static final a Companion = null;
    public static final OpCode Concatenate = null;
    public static final OpCode DrawGlyphRun = null;
    public static final OpCode DrawText = null;
    public static final OpCode FillPath = null;
    public static final OpCode FillRect = null;
    public static final OpCode LineTo = null;
    public static final OpCode MoveTo = null;
    public static final OpCode RestoreGState = null;
    public static final OpCode SaveGState = null;
    public static final OpCode SetFillRGBA = null;
    public static final OpCode SetFillVariable = null;
    public static final OpCode SetFont = null;
    public static final OpCode SetLineCap = null;
    public static final OpCode SetLineJoin = null;
    public static final OpCode SetLineWidth = null;
    public static final OpCode SetMiterLimit = null;
    public static final OpCode SetStrokeRGBA = null;
    public static final OpCode SetStrokeVariable = null;
    public static final OpCode StrokePath = null;
    public static final OpCode StrokeRect = null;
    public static final OpCode Translate = null;
    public static final /* synthetic */ OpCode[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final int v;

    public static final class a {
        public a() {
        }
    }

    public static EnumEntries<OpCode> getEntries() {
        return b;
    }

    static {
        OpCode r0 = new OpCode("SetFillRGBA", 0, 1);
        SetFillRGBA = r0;
        OpCode r1 = new OpCode("FillRect", 1, 2);
        FillRect = r1;
        OpCode r4 = new OpCode("SetStrokeRGBA", 2, 3);
        SetStrokeRGBA = r4;
        OpCode r6 = new OpCode("StrokeRect", 3, 4);
        StrokeRect = r6;
        OpCode r8 = new OpCode("SetFont", 4, 5);
        SetFont = r8;
        OpCode r10 = new OpCode("DrawGlyphRun", 5, 6);
        DrawGlyphRun = r10;
        OpCode r12 = new OpCode("SaveGState", 6, 7);
        SaveGState = r12;
        OpCode r14 = new OpCode("RestoreGState", 7, 8);
        RestoreGState = r14;
        OpCode r13 = new OpCode("Translate", 8, 9);
        Translate = r13;
        OpCode r15 = new OpCode("BeginPath", 9, 10);
        BeginPath = r15;
        OpCode r11 = new OpCode("MoveTo", 10, 11);
        MoveTo = r11;
        OpCode r9 = new OpCode("LineTo", 11, 12);
        LineTo = r9;
        OpCode r7 = new OpCode("BezierCurveTo", 12, 13);
        BezierCurveTo = r7;
        OpCode r5 = new OpCode("ClosePath", 13, 14);
        ClosePath = r5;
        OpCode r3 = new OpCode("FillPath", 14, 15);
        FillPath = r3;
        OpCode r2 = new OpCode("StrokePath", 15, 16);
        StrokePath = r2;
        OpCode r16 = new OpCode("ClipPath", 16, 17);
        ClipPath = r16;
        OpCode r17 = new OpCode("SetLineWidth", 17, 18);
        SetLineWidth = r17;
        OpCode r18 = new OpCode("SetLineJoin", 18, 19);
        SetLineJoin = r18;
        OpCode r19 = new OpCode("SetLineCap", 19, 20);
        SetLineCap = r19;
        OpCode r20 = new OpCode("SetMiterLimit", 20, 21);
        SetMiterLimit = r20;
        OpCode r21 = new OpCode("Concatenate", 21, 22);
        Concatenate = r21;
        OpCode r22 = new OpCode("SetFillVariable", 22, 23);
        SetFillVariable = r22;
        OpCode r23 = new OpCode("SetStrokeVariable", 23, 24);
        SetStrokeVariable = r23;
        OpCode r24 = new OpCode("DrawText", 24, 25);
        DrawText = r24;
        OpCode[] r25 = {r0, r1, r4, r6, r8, r10, r12, r14, r13, r15, r11, r9, r7, r5, r3, r2, r16, r17, r18, r19, r20, r21, r22, r23, r24};
        a = r25;
        b = EnumEntriesKt.enumEntries(r25);
        Companion = new a();
    }

    public static OpCode[] values() {
        return (OpCode[]) a.clone();
    }

    public final int getV() {
        return this.v;
    }

    public static OpCode valueOf(String r1) {
        return (OpCode) r27.a.a(OpCode.class, r1);
    }

    public OpCode(String r1, int r2, int r3) {
        super(r1, r2);
        this.v = r3;
    }
}
