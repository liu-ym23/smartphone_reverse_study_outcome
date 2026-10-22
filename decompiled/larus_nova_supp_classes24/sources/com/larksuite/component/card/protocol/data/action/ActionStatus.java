package com.larksuite.component.card.protocol.data.action;

import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BO\u0012\u0018\b\u0002\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003\u0012,\b\u0002\u0010\u0005\u001a&\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0006j\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u0001`\u0007¢\u0006\u0004\b\b\u0010\tJ\u0019\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003HÆ\u0003J-\u0010\u0011\u001a&\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0006j\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u0001`\u0007HÆ\u0003JQ\u0010\u0012\u001a\u00020\u00002\u0018\b\u0002\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00032,\b\u0002\u0010\u0005\u001a&\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0006j\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u0001`\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0004HÖ\u0001R!\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR>\u0010\u0005\u001a&\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0006j\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u0001`\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u001a"}, d2 = {"Lcom/larksuite/component/card/protocol/data/action/ActionStatus;", "Ljava/io/Serializable;", "componentStatusByName", "", "", "componentStatusByActionID", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "<init>", "(Ljava/util/Map;Ljava/util/HashMap;)V", "getComponentStatusByName", "()Ljava/util/Map;", "getComponentStatusByActionID", "()Ljava/util/HashMap;", "setComponentStatusByActionID", "(Ljava/util/HashMap;)V", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "universalcard_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class ActionStatus implements Serializable {
    private HashMap<String, String> componentStatusByActionID;
    private final Map<String, String> componentStatusByName;

    public ActionStatus() {
        HashMap r0 = null;
        this(r0, r0, 3, r0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ActionStatus copy$default(ActionStatus r0, Map r1, HashMap r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.componentStatusByName;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.componentStatusByActionID;
    L9:
        return r0.copy(r1, r2);
    }

    public final Map<String, String> component1() {
        return this.componentStatusByName;
    }

    public final HashMap<String, String> component2() {
        return this.componentStatusByActionID;
    }

    public final ActionStatus copy(Map<String, String> r2, HashMap<String, String> r3) {
        return new ActionStatus(r2, r3);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof ActionStatus) == true) goto L8;
        return false;
    L8:
        ActionStatus r6 = (ActionStatus) r5;
        if (Intrinsics.areEqual(this.componentStatusByName, r6.componentStatusByName) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.componentStatusByActionID, r6.componentStatusByActionID) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        Map<String, String> r0 = this.componentStatusByName;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        HashMap<String, String> r4 = this.componentStatusByActionID;
        if (r4 == null) goto L11;
        r1 = r4.hashCode();
    L11:
        return r3 + r1;
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "ActionStatus(componentStatusByName=" + this.componentStatusByName + ", componentStatusByActionID=" + this.componentStatusByActionID + ')';
    }

    public final HashMap<String, String> getComponentStatusByActionID() {
        return this.componentStatusByActionID;
    }

    public final Map<String, String> getComponentStatusByName() {
        return this.componentStatusByName;
    }

    public final void setComponentStatusByActionID(HashMap<String, String> r1) {
        this.componentStatusByActionID = r1;
    }

    public ActionStatus(Map<String, String> r1, HashMap<String, String> r2) {
        this.componentStatusByName = r1;
        this.componentStatusByActionID = r2;
    }

    public /* synthetic */ ActionStatus(Map r2, HashMap r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 2) == 0) goto L8;
        r3 = null;
    L8:
        this(r2, r3);
    }
}
