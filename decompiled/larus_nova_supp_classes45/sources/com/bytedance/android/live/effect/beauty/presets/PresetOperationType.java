package com.bytedance.android.live.effect.beauty.presets;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/android/live/effect/beauty/presets/PresetOperationType;", "", "INIT", "ADD_PRESET", "DELETE_PRESET", "RENAME_PRESET", "SELECT_PRESET", "EDIT_MODE", "liveeffect_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum PresetOperationType extends Enum<PresetOperationType> {
    public static final PresetOperationType ADD_PRESET = null;
    public static final PresetOperationType DELETE_PRESET = null;
    public static final PresetOperationType EDIT_MODE = null;
    public static final PresetOperationType INIT = null;
    public static final PresetOperationType RENAME_PRESET = null;
    public static final PresetOperationType SELECT_PRESET = null;
    public static final /* synthetic */ PresetOperationType[] a = null;

    static {
        PresetOperationType r1 = new PresetOperationType("INIT", 0);
        INIT = r1;
        PresetOperationType r2 = new PresetOperationType("ADD_PRESET", 1);
        ADD_PRESET = r2;
        PresetOperationType r3 = new PresetOperationType("DELETE_PRESET", 2);
        DELETE_PRESET = r3;
        PresetOperationType r4 = new PresetOperationType("RENAME_PRESET", 3);
        RENAME_PRESET = r4;
        PresetOperationType r5 = new PresetOperationType("SELECT_PRESET", 4);
        SELECT_PRESET = r5;
        PresetOperationType r6 = new PresetOperationType("EDIT_MODE", 5);
        EDIT_MODE = r6;
        a = new PresetOperationType[]{r1, r2, r3, r4, r5, r6};
    }

    public static PresetOperationType valueOf(String r1) {
        return (PresetOperationType) r27.a.a(PresetOperationType.class, r1);
    }

    public static PresetOperationType[] values() {
        return (PresetOperationType[]) a.clone();
    }

    public PresetOperationType(String r1, int r2) {
        super(r1, r2);
    }
}
