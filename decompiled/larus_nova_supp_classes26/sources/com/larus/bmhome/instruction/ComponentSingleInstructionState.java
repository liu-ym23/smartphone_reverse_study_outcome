package com.larus.bmhome.instruction;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/larus/bmhome/instruction/ComponentSingleInstructionState;", "Lcom/larus/ui/arch/vm/external/ComponentState;", "botId", "", "menuItem", "Lcom/larus/bmhome/actionbar/model/CustomActionBarItem;", "<init>", "(Ljava/lang/String;Lcom/larus/bmhome/actionbar/model/CustomActionBarItem;)V", "getBotId", "()Ljava/lang/String;", "getMenuItem", "()Lcom/larus/bmhome/actionbar/model/CustomActionBarItem;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ComponentSingleInstructionState implements w1a.b {
    private final String botId;
    private final com.larus.bmhome.actionbar.model.z0 menuItem;

    public ComponentSingleInstructionState() {
        String r0 = null;
        this(r0, r0, 3, r0);
    }

    public static /* synthetic */ ComponentSingleInstructionState copy$default(ComponentSingleInstructionState r0, String r1, com.larus.bmhome.actionbar.model.z0 r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.botId;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.menuItem;
    L9:
        return r0.copy(r1, r2);
    }

    public final String component1() {
        return this.botId;
    }

    public final com.larus.bmhome.actionbar.model.z0 component2() {
        return this.menuItem;
    }

    public final ComponentSingleInstructionState copy(String r2, com.larus.bmhome.actionbar.model.z0 r3) {
        Intrinsics.checkNotNullParameter(r2, "botId");
        return new ComponentSingleInstructionState(r2, r3);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof ComponentSingleInstructionState) == true) goto L8;
        return false;
    L8:
        ComponentSingleInstructionState r6 = (ComponentSingleInstructionState) r5;
        if (Intrinsics.areEqual(this.botId, r6.botId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.menuItem, r6.menuItem) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        int r0 = this.botId.hashCode() * 31;
        com.larus.bmhome.actionbar.model.z0 r1 = this.menuItem;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return r0 + r2;
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    public String toString() {
        return "ComponentSingleInstructionState(botId=" + this.botId + ", menuItem=" + this.menuItem + ')';
    }

    public final String getBotId() {
        return this.botId;
    }

    public final com.larus.bmhome.actionbar.model.z0 getMenuItem() {
        return this.menuItem;
    }

    public ComponentSingleInstructionState(String r2, com.larus.bmhome.actionbar.model.z0 r3) {
        Intrinsics.checkNotNullParameter(r2, "botId");
        this.botId = r2;
        this.menuItem = r3;
    }

    public /* synthetic */ ComponentSingleInstructionState(String r1, com.larus.bmhome.actionbar.model.z0 r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = "";
    L6:
        if ((r3 & 2) == 0) goto L8;
        r2 = null;
    L8:
        this(r1, r2);
    }
}
