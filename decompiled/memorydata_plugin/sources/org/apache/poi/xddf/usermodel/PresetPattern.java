package org.apache.poi.xddf.usermodel;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;
import org.openxmlformats.schemas.drawingml.x2006.main.STPresetPatternVal;

/* JADX INFO: loaded from: classes7.dex */
public final enum PresetPattern extends Enum<PresetPattern> {
    private static final /* synthetic */ PresetPattern[] $VALUES = null;
    public static final PresetPattern CROSS = null;
    public static final PresetPattern DARK_DOWNWARD_DIAGONAL = null;
    public static final PresetPattern DARK_HORIZONTAL = null;
    public static final PresetPattern DARK_UPWARD_DIAGONAL = null;
    public static final PresetPattern DARK_VERTICAL = null;
    public static final PresetPattern DASH_DOWNWARD_DIAGONAL = null;
    public static final PresetPattern DASH_HORIZONTAL = null;
    public static final PresetPattern DASH_UPWARD_DIAGONAL = null;
    public static final PresetPattern DASH_VERTICAL = null;
    public static final PresetPattern DIAGONAL_BRICK = null;
    public static final PresetPattern DIAGONAL_CROSS = null;
    public static final PresetPattern DIVOT = null;
    public static final PresetPattern DOTTED_DIAMOND = null;
    public static final PresetPattern DOTTED_GRID = null;
    public static final PresetPattern DOWNWARD_DIAGONAL = null;
    public static final PresetPattern HORIZONTAL = null;
    public static final PresetPattern HORIZONTAL_BRICK = null;
    public static final PresetPattern LARGE_CHECKER_BOARD = null;
    public static final PresetPattern LARGE_CONFETTI = null;
    public static final PresetPattern LARGE_GRID = null;
    public static final PresetPattern LIGHT_DOWNWARD_DIAGONAL = null;
    public static final PresetPattern LIGHT_HORIZONTAL = null;
    public static final PresetPattern LIGHT_UPWARD_DIAGONAL = null;
    public static final PresetPattern LIGHT_VERTICAL = null;
    public static final PresetPattern NARROW_HORIZONTAL = null;
    public static final PresetPattern NARROW_VERTICAL = null;
    public static final PresetPattern OPEN_DIAMOND = null;
    public static final PresetPattern PERCENT_10 = null;
    public static final PresetPattern PERCENT_20 = null;
    public static final PresetPattern PERCENT_25 = null;
    public static final PresetPattern PERCENT_30 = null;
    public static final PresetPattern PERCENT_40 = null;
    public static final PresetPattern PERCENT_5 = null;
    public static final PresetPattern PERCENT_50 = null;
    public static final PresetPattern PERCENT_60 = null;
    public static final PresetPattern PERCENT_70 = null;
    public static final PresetPattern PERCENT_75 = null;
    public static final PresetPattern PERCENT_80 = null;
    public static final PresetPattern PERCENT_90 = null;
    public static final PresetPattern PLAID = null;
    public static final PresetPattern SHINGLE = null;
    public static final PresetPattern SMALL_CHECKER_BOARD = null;
    public static final PresetPattern SMALL_CONFETTI = null;
    public static final PresetPattern SMALL_GRID = null;
    public static final PresetPattern SOLID_DIAMOND = null;
    public static final PresetPattern SPHERE = null;
    public static final PresetPattern TRELLIS = null;
    public static final PresetPattern UPWARD_DIAGONAL = null;
    public static final PresetPattern VERTICAL = null;
    public static final PresetPattern WAVE = null;
    public static final PresetPattern WEAVE = null;
    public static final PresetPattern WIDE_DOWNWARD_DIAGONAL = null;
    public static final PresetPattern WIDE_UPWARD_DIAGONAL = null;
    public static final PresetPattern ZIG_ZAG = null;
    private static final HashMap<STPresetPatternVal.Enum, PresetPattern> reverse = null;
    final STPresetPatternVal.Enum underlying;

    static {
        int r3 = 0;
        CROSS = new PresetPattern("CROSS", 0, STPresetPatternVal.y);
        DASH_DOWNWARD_DIAGONAL = new PresetPattern("DASH_DOWNWARD_DIAGONAL", 1, STPresetPatternVal.H);
        DASH_HORIZONTAL = new PresetPattern("DASH_HORIZONTAL", 2, STPresetPatternVal.w);
        DASH_UPWARD_DIAGONAL = new PresetPattern("DASH_UPWARD_DIAGONAL", 3, STPresetPatternVal.I);
        DASH_VERTICAL = new PresetPattern("DASH_VERTICAL", 4, STPresetPatternVal.x);
        DIAGONAL_BRICK = new PresetPattern("DIAGONAL_BRICK", 5, STPresetPatternVal.S);
        DIAGONAL_CROSS = new PresetPattern("DIAGONAL_CROSS", 6, STPresetPatternVal.f18637J);
        DIVOT = new PresetPattern("DIVOT", 7, STPresetPatternVal.Z);
        DARK_DOWNWARD_DIAGONAL = new PresetPattern("DARK_DOWNWARD_DIAGONAL", 8, STPresetPatternVal.D);
        DARK_HORIZONTAL = new PresetPattern("DARK_HORIZONTAL", 9, STPresetPatternVal.s);
        DARK_UPWARD_DIAGONAL = new PresetPattern("DARK_UPWARD_DIAGONAL", 10, STPresetPatternVal.E);
        DARK_VERTICAL = new PresetPattern("DARK_VERTICAL", 11, STPresetPatternVal.t);
        DOWNWARD_DIAGONAL = new PresetPattern("DOWNWARD_DIAGONAL", 12, STPresetPatternVal.z);
        DOTTED_DIAMOND = new PresetPattern("DOTTED_DIAMOND", 13, STPresetPatternVal.V);
        DOTTED_GRID = new PresetPattern("DOTTED_GRID", 14, STPresetPatternVal.O);
        HORIZONTAL = new PresetPattern("HORIZONTAL", 15, STPresetPatternVal.o);
        HORIZONTAL_BRICK = new PresetPattern("HORIZONTAL_BRICK", 16, STPresetPatternVal.R);
        LARGE_CHECKER_BOARD = new PresetPattern("LARGE_CHECKER_BOARD", 17, STPresetPatternVal.L);
        LARGE_CONFETTI = new PresetPattern("LARGE_CONFETTI", 18, STPresetPatternVal.Q);
        LARGE_GRID = new PresetPattern("LARGE_GRID", 19, STPresetPatternVal.N);
        LIGHT_DOWNWARD_DIAGONAL = new PresetPattern("LIGHT_DOWNWARD_DIAGONAL", 20, STPresetPatternVal.B);
        LIGHT_HORIZONTAL = new PresetPattern("LIGHT_HORIZONTAL", 21, STPresetPatternVal.q);
        LIGHT_UPWARD_DIAGONAL = new PresetPattern("LIGHT_UPWARD_DIAGONAL", 22, STPresetPatternVal.C);
        LIGHT_VERTICAL = new PresetPattern("LIGHT_VERTICAL", 23, STPresetPatternVal.r);
        NARROW_HORIZONTAL = new PresetPattern("NARROW_HORIZONTAL", 24, STPresetPatternVal.u);
        NARROW_VERTICAL = new PresetPattern("NARROW_VERTICAL", 25, STPresetPatternVal.v);
        OPEN_DIAMOND = new PresetPattern("OPEN_DIAMOND", 26, STPresetPatternVal.U);
        PERCENT_5 = new PresetPattern("PERCENT_5", 27, STPresetPatternVal.c);
        PERCENT_10 = new PresetPattern("PERCENT_10", 28, STPresetPatternVal.d);
        PERCENT_20 = new PresetPattern("PERCENT_20", 29, STPresetPatternVal.e);
        PERCENT_25 = new PresetPattern("PERCENT_25", 30, STPresetPatternVal.f);
        PERCENT_30 = new PresetPattern("PERCENT_30", 31, STPresetPatternVal.g);
        PERCENT_40 = new PresetPattern("PERCENT_40", 32, STPresetPatternVal.h);
        PERCENT_50 = new PresetPattern("PERCENT_50", 33, STPresetPatternVal.i);
        PERCENT_60 = new PresetPattern("PERCENT_60", 34, STPresetPatternVal.j);
        PERCENT_70 = new PresetPattern("PERCENT_70", 35, STPresetPatternVal.k);
        PERCENT_75 = new PresetPattern("PERCENT_75", 36, STPresetPatternVal.l);
        PERCENT_80 = new PresetPattern("PERCENT_80", 37, STPresetPatternVal.m);
        PERCENT_90 = new PresetPattern("PERCENT_90", 38, STPresetPatternVal.n);
        PLAID = new PresetPattern("PLAID", 39, STPresetPatternVal.W);
        SHINGLE = new PresetPattern("SHINGLE", 40, STPresetPatternVal.aa);
        SMALL_CHECKER_BOARD = new PresetPattern("SMALL_CHECKER_BOARD", 41, STPresetPatternVal.K);
        SMALL_CONFETTI = new PresetPattern("SMALL_CONFETTI", 42, STPresetPatternVal.P);
        SMALL_GRID = new PresetPattern("SMALL_GRID", 43, STPresetPatternVal.M);
        SOLID_DIAMOND = new PresetPattern("SOLID_DIAMOND", 44, STPresetPatternVal.T);
        SPHERE = new PresetPattern("SPHERE", 45, STPresetPatternVal.X);
        TRELLIS = new PresetPattern("TRELLIS", 46, STPresetPatternVal.ac);
        UPWARD_DIAGONAL = new PresetPattern("UPWARD_DIAGONAL", 47, STPresetPatternVal.A);
        VERTICAL = new PresetPattern("VERTICAL", 48, STPresetPatternVal.p);
        WAVE = new PresetPattern("WAVE", 49, STPresetPatternVal.ab);
        WEAVE = new PresetPattern("WEAVE", 50, STPresetPatternVal.Y);
        WIDE_DOWNWARD_DIAGONAL = new PresetPattern("WIDE_DOWNWARD_DIAGONAL", 51, STPresetPatternVal.F);
        WIDE_UPWARD_DIAGONAL = new PresetPattern("WIDE_UPWARD_DIAGONAL", 52, STPresetPatternVal.G);
        ZIG_ZAG = new PresetPattern("ZIG_ZAG", 53, STPresetPatternVal.ad);
        $VALUES = new PresetPattern[]{CROSS, DASH_DOWNWARD_DIAGONAL, DASH_HORIZONTAL, DASH_UPWARD_DIAGONAL, DASH_VERTICAL, DIAGONAL_BRICK, DIAGONAL_CROSS, DIVOT, DARK_DOWNWARD_DIAGONAL, DARK_HORIZONTAL, DARK_UPWARD_DIAGONAL, DARK_VERTICAL, DOWNWARD_DIAGONAL, DOTTED_DIAMOND, DOTTED_GRID, HORIZONTAL, HORIZONTAL_BRICK, LARGE_CHECKER_BOARD, LARGE_CONFETTI, LARGE_GRID, LIGHT_DOWNWARD_DIAGONAL, LIGHT_HORIZONTAL, LIGHT_UPWARD_DIAGONAL, LIGHT_VERTICAL, NARROW_HORIZONTAL, NARROW_VERTICAL, OPEN_DIAMOND, PERCENT_5, PERCENT_10, PERCENT_20, PERCENT_25, PERCENT_30, PERCENT_40, PERCENT_50, PERCENT_60, PERCENT_70, PERCENT_75, PERCENT_80, PERCENT_90, PLAID, SHINGLE, SMALL_CHECKER_BOARD, SMALL_CONFETTI, SMALL_GRID, SOLID_DIAMOND, SPHERE, TRELLIS, UPWARD_DIAGONAL, VERTICAL, WAVE, WEAVE, WIDE_DOWNWARD_DIAGONAL, WIDE_UPWARD_DIAGONAL, ZIG_ZAG};
        reverse = new HashMap();
        PresetPattern[] r0 = values();
        int r1 = r0.length;
    L3:
        if (r3 >= r1) goto L5;
        PresetPattern r2 = r0[r3];
        reverse.put(r2.underlying, r2);
        r3 = r3 + 1;
        goto L3
    }

    private PresetPattern(String r1, int r2, STPresetPatternVal.Enum r3) {
        super(r1, r2);
        this.underlying = r3;
    }

    public static PresetPattern valueOf(String r2) {
        return (PresetPattern) ZeusTransformUtils.preCheckCast(Enum.valueOf(PresetPattern.class, r2), PresetPattern.class, "com.obric.memorydata.plugin");
    }

    static PresetPattern valueOf(STPresetPatternVal.Enum r2) {
        return (PresetPattern) ZeusTransformUtils.preCheckCast(reverse.get(r2), PresetPattern.class, "com.obric.memorydata.plugin");
    }

    public static PresetPattern[] values() {
        return (PresetPattern[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), PresetPattern[].class, "com.obric.memorydata.plugin");
    }
}
