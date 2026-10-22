package com.larus.dora.obric.device_management.device_home;

import com.google.gson.annotations.SerializedName;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0016\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000bJ\u0011\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÂ\u0003J\u001b\u0010\u0010\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u000bHÖ\u0001J\t\u0010\u0015\u001a\u00020\rHÖ\u0001R\u0018\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0002X\u0083\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038F¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\u0016"}, d2 = {"Lcom/larus/dora/obric/device_management/device_home/DoraObricDeviceHomeQuickActionConfig;", "", "rawActions", "", "Lcom/larus/dora/obric/device_management/device_home/DoraObricDeviceHomeQuickActionConfigItem;", "<init>", "(Ljava/util/List;)V", "actions", "getActions", "()Ljava/util/List;", "resolveOrder", "", "key", "", "defaultOrder", "component1", "copy", "equals", "", "other", "hashCode", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DoraObricDeviceHomeQuickActionConfig {

    @SerializedName("actions")
    private final List<DoraObricDeviceHomeQuickActionConfigItem> rawActions;

    public DoraObricDeviceHomeQuickActionConfig() {
        List r0 = null;
        this(r0, 1, r0);
    }

    private final List<DoraObricDeviceHomeQuickActionConfigItem> component1() {
        return this.rawActions;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ DoraObricDeviceHomeQuickActionConfig copy$default(DoraObricDeviceHomeQuickActionConfig r0, List r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = r0.rawActions;
    L6:
        return r0.copy(r1);
    }

    public final DoraObricDeviceHomeQuickActionConfig copy(List<DoraObricDeviceHomeQuickActionConfigItem> r2) {
        return new DoraObricDeviceHomeQuickActionConfig(r2);
    }

    public boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if ((r4 instanceof DoraObricDeviceHomeQuickActionConfig) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.rawActions, ((DoraObricDeviceHomeQuickActionConfig) r4).rawActions) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        List<DoraObricDeviceHomeQuickActionConfigItem> r0 = this.rawActions;
        if (r0 != null) goto L6;
        return 0;
    L6:
        return r0.hashCode();
    }

    public String toString() {
        return "DoraObricDeviceHomeQuickActionConfig(rawActions=" + this.rawActions + ')';
    }

    public final List<DoraObricDeviceHomeQuickActionConfigItem> getActions() {
        List<DoraObricDeviceHomeQuickActionConfigItem> r0 = this.rawActions;
        if (r0 == null) goto L5;
        return r0;
    L5:
        return CollectionsKt.emptyList();
    }

    public DoraObricDeviceHomeQuickActionConfig(List<DoraObricDeviceHomeQuickActionConfigItem> r1) {
        this.rawActions = r1;
    }

    public final int resolveOrder(String r5, int r6) {
        Intrinsics.checkNotNullParameter(r5, "key");
        Iterator<T> r0 = getActions().iterator();
    L3:
        Integer r2 = null;
        if (r0.hasNext() == false) goto L8;
        Object r1 = r0.next();
        if (Intrinsics.areEqual(((DoraObricDeviceHomeQuickActionConfigItem) r1).getKey(), r5) == false) goto L3;
    L9:
        DoraObricDeviceHomeQuickActionConfigItem r3 = (DoraObricDeviceHomeQuickActionConfigItem) r1;
        if (r3 == null) goto L25;
        Integer r7 = r3.getOrder();
        if (r7 != null) goto L14;
        return r6;
    L14:
        if (r7.intValue() < 0) goto L16;
        boolean r4 = true;
    L17:
        if (r4 == false) goto L19;
        r2 = r7;
    L19:
        if (r2 != null) goto L21;
        return r6;
    L21:
        return r2.intValue();
    L16:
        r4 = false;
        goto L17
    L25:
        return r6;
    L8:
        r1 = null;
        goto L9
    }

    public /* synthetic */ DoraObricDeviceHomeQuickActionConfig(List r1, int r2, DefaultConstructorMarker r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = null;
    L5:
        this(r1);
    }
}
