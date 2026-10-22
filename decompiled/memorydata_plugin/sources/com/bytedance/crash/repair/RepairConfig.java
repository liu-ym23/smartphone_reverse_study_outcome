package com.bytedance.crash.repair;

import com.bytedance.crash.npth_repair.utils.RepairPortrait;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes2.dex */
public class RepairConfig {
    private static final int DEFAULT_FIX_DUMP_STACK_DELAYED_TIME = 60000;
    private final boolean mDebuggable;
    private int mDelayedTime;
    private final RepairPortrait mRepairPortrait;
    private final int mRepairType;

    public RepairConfig(int r2, int r3, boolean r4, JSONArray r5) {
        this.mDelayedTime = DEFAULT_FIX_DUMP_STACK_DELAYED_TIME;
        this.mRepairType = r2;
        if (r3 <= 0) goto L5;
        this.mDelayedTime = r3;
    L5:
        this.mDebuggable = r4;
        this.mRepairPortrait = RepairPortrait.createRepairPortrait(r5);
    }

    public boolean getDebuggable() {
        return this.mDebuggable;
    }

    public int getDelayedTime() {
        return this.mDelayedTime;
    }

    public RepairPortrait getRepairPortrait() {
        return this.mRepairPortrait;
    }

    public int getRepairType() {
        return this.mRepairType;
    }
}
