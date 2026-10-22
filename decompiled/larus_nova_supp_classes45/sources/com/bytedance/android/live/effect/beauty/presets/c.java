package com.bytedance.android.live.effect.beauty.presets;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final /* synthetic */ class c {
    public static final /* synthetic */ int[] a = null;
    public static final /* synthetic */ int[] b = null;

    static {
        int[] r0 = new int[PresetOperationType.values().length];
        a = r0;
        PresetOperationType r1 = PresetOperationType.INIT;
        r0[r1.ordinal()] = 1;
        PresetOperationType r2 = PresetOperationType.ADD_PRESET;
        r0[r2.ordinal()] = 2;
        PresetOperationType r4 = PresetOperationType.DELETE_PRESET;
        r0[r4.ordinal()] = 3;
        PresetOperationType r6 = PresetOperationType.RENAME_PRESET;
        r0[r6.ordinal()] = 4;
        PresetOperationType r8 = PresetOperationType.SELECT_PRESET;
        r0[r8.ordinal()] = 5;
        int[] r3 = new int[PresetOperationType.values().length];
        b = r3;
        r3[r2.ordinal()] = 1;
        r3[r1.ordinal()] = 2;
        r3[r4.ordinal()] = 3;
        r3[r6.ordinal()] = 4;
        r3[r8.ordinal()] = 5;
        r3[PresetOperationType.EDIT_MODE.ordinal()] = 6;
    }
}
