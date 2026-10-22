package com.obric.assistant;

import com.google.gson.annotations.SerializedName;
import com.obric.aivoice.core.data.NameKeys;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u00032\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/obric/assistant/ObricStateMachineMultitaskConfig;", NameKeys.UnloadStrategy_No_Strategy, "multitaskEnable", NameKeys.UnloadStrategy_No_Strategy, "powerManagerRefactorEnable", "<init>", "(ZZ)V", "getMultitaskEnable", "()Z", "getPowerManagerRefactorEnable", "component1", "component2", "copy", "equals", "other", "hashCode", NameKeys.UnloadStrategy_No_Strategy, "toString", NameKeys.UnloadStrategy_No_Strategy, "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricStateMachineMultitaskConfig {

    @SerializedName("multitask_enable")
    private final boolean multitaskEnable;

    @SerializedName("power_manager_refactor_enable")
    private final boolean powerManagerRefactorEnable;

    public ObricStateMachineMultitaskConfig() {
        boolean r2 = false;
        this(r2, r2, 3, null);
    }

    public static /* synthetic */ ObricStateMachineMultitaskConfig copy$default(ObricStateMachineMultitaskConfig r0, boolean r1, boolean r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.multitaskEnable;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.powerManagerRefactorEnable;
    L9:
        return r0.copy(r1, r2);
    }

    public final boolean component1() {
        return this.multitaskEnable;
    }

    public final boolean component2() {
        return this.powerManagerRefactorEnable;
    }

    public final ObricStateMachineMultitaskConfig copy(boolean r2, boolean r3) {
        return new ObricStateMachineMultitaskConfig(r2, r3);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof ObricStateMachineMultitaskConfig) == true) goto L8;
        return false;
    L8:
        ObricStateMachineMultitaskConfig r6 = (ObricStateMachineMultitaskConfig) r5;
        if (this.multitaskEnable == r6.multitaskEnable) goto L12;
        return false;
    L12:
        if (this.powerManagerRefactorEnable == r6.powerManagerRefactorEnable) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        int r1 = 1231;
        if (this.multitaskEnable == false) goto L5;
        int r0 = 1231;
    L6:
        int r2 = r0 * 31;
        if (this.powerManagerRefactorEnable == true) goto L11;
        r1 = 1237;
    L11:
        return r2 + r1;
    L5:
        r0 = 1237;
        goto L6
    }

    public String toString() {
        return "ObricStateMachineMultitaskConfig(multitaskEnable=" + this.multitaskEnable + ", powerManagerRefactorEnable=" + this.powerManagerRefactorEnable + ')';
    }

    public final boolean getMultitaskEnable() {
        return this.multitaskEnable;
    }

    public final boolean getPowerManagerRefactorEnable() {
        return this.powerManagerRefactorEnable;
    }

    public ObricStateMachineMultitaskConfig(boolean r1, boolean r2) {
        this.multitaskEnable = r1;
        this.powerManagerRefactorEnable = r2;
    }

    public /* synthetic */ ObricStateMachineMultitaskConfig(boolean r2, boolean r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 1) == 0) goto L6;
        r2 = true;
    L6:
        if ((r4 & 2) == 0) goto L8;
        r3 = true;
    L8:
        this(r2, r3);
    }
}
