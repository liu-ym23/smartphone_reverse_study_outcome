package org.apache.poi.xddf.usermodel;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;
import org.openxmlformats.schemas.drawingml.x2006.main.STPresetLineDashVal;

/* JADX INFO: loaded from: classes7.dex */
public final enum PresetLineDash extends Enum<PresetLineDash> {
    private static final /* synthetic */ PresetLineDash[] $VALUES = null;
    public static final PresetLineDash DASH = null;
    public static final PresetLineDash DASH_DOT = null;
    public static final PresetLineDash DOT = null;
    public static final PresetLineDash LARGE_DASH = null;
    public static final PresetLineDash LARGE_DASH_DOT = null;
    public static final PresetLineDash LARGE_DASH_DOT_DOT = null;
    public static final PresetLineDash SOLID = null;
    public static final PresetLineDash SYSTEM_DASH = null;
    public static final PresetLineDash SYSTEM_DASH_DOT = null;
    public static final PresetLineDash SYSTEM_DASH_DOT_DOT = null;
    public static final PresetLineDash SYSTEM_DOT = null;
    private static final HashMap<STPresetLineDashVal.Enum, PresetLineDash> reverse = null;
    final STPresetLineDashVal.Enum underlying;

    static {
        int r3 = 0;
        PresetLineDash r0 = new PresetLineDash("DASH", 0, STPresetLineDashVal.e);
        DASH = r0;
        PresetLineDash r1 = new PresetLineDash("DASH_DOT", 1, STPresetLineDashVal.g);
        DASH_DOT = r1;
        PresetLineDash r2 = new PresetLineDash("DOT", 2, STPresetLineDashVal.d);
        DOT = r2;
        PresetLineDash r4 = new PresetLineDash("LARGE_DASH", 3, STPresetLineDashVal.f);
        LARGE_DASH = r4;
        PresetLineDash r6 = new PresetLineDash("LARGE_DASH_DOT", 4, STPresetLineDashVal.h);
        LARGE_DASH_DOT = r6;
        PresetLineDash r8 = new PresetLineDash("LARGE_DASH_DOT_DOT", 5, STPresetLineDashVal.i);
        LARGE_DASH_DOT_DOT = r8;
        PresetLineDash r10 = new PresetLineDash("SOLID", 6, STPresetLineDashVal.c);
        SOLID = r10;
        PresetLineDash r12 = new PresetLineDash("SYSTEM_DASH", 7, STPresetLineDashVal.j);
        SYSTEM_DASH = r12;
        PresetLineDash r14 = new PresetLineDash("SYSTEM_DASH_DOT", 8, STPresetLineDashVal.l);
        SYSTEM_DASH_DOT = r14;
        PresetLineDash r13 = new PresetLineDash("SYSTEM_DASH_DOT_DOT", 9, STPresetLineDashVal.m);
        SYSTEM_DASH_DOT_DOT = r13;
        PresetLineDash r11 = new PresetLineDash("SYSTEM_DOT", 10, STPresetLineDashVal.k);
        SYSTEM_DOT = r11;
        $VALUES = new PresetLineDash[]{r0, r1, r2, r4, r6, r8, r10, r12, r14, r13, r11};
        reverse = new HashMap();
        PresetLineDash[] r5 = values();
        int r7 = r5.length;
    L3:
        if (r3 >= r7) goto L5;
        PresetLineDash r9 = r5[r3];
        reverse.put(r9.underlying, r9);
        r3 = r3 + 1;
        goto L3
    }

    private PresetLineDash(String r1, int r2, STPresetLineDashVal.Enum r3) {
        super(r1, r2);
        this.underlying = r3;
    }

    public static PresetLineDash valueOf(String r2) {
        return (PresetLineDash) ZeusTransformUtils.preCheckCast(Enum.valueOf(PresetLineDash.class, r2), PresetLineDash.class, "com.obric.memorydata.plugin");
    }

    static PresetLineDash valueOf(STPresetLineDashVal.Enum r2) {
        return (PresetLineDash) ZeusTransformUtils.preCheckCast(reverse.get(r2), PresetLineDash.class, "com.obric.memorydata.plugin");
    }

    public static PresetLineDash[] values() {
        return (PresetLineDash[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), PresetLineDash[].class, "com.obric.memorydata.plugin");
    }
}
