package com.obric.capabilitykit.entity;

import com.obric.assistant.interaction.api.service.IInteractionStateService;
import com.obric.capabilitykit.EntitySupplier;
import com.obric.capabilitykit.sync.EntitySyncDataSupplier;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B'\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0007HÆ\u0003J-\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0005HÖ\u0001R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0019"}, d2 = {"Lcom/obric/capabilitykit/entity/EntityInitParam;", "", "supplier", "Lcom/obric/capabilitykit/EntitySupplier;", "runProcessName", "", "entitySyncDataSupplier", "Lcom/obric/capabilitykit/sync/EntitySyncDataSupplier;", "(Lcom/obric/capabilitykit/EntitySupplier;Ljava/lang/String;Lcom/obric/capabilitykit/sync/EntitySyncDataSupplier;)V", "getEntitySyncDataSupplier", "()Lcom/obric/capabilitykit/sync/EntitySyncDataSupplier;", "getRunProcessName", "()Ljava/lang/String;", "getSupplier", "()Lcom/obric/capabilitykit/EntitySupplier;", "component1", "component2", "component3", "copy", "equals", "", IInteractionStateService.WAKE_UP_SOURCE_OTHER, "hashCode", "", "toString", "capabilitykit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class EntityInitParam {
    private final EntitySyncDataSupplier entitySyncDataSupplier;
    private final String runProcessName;
    private final EntitySupplier supplier;

    public EntityInitParam(EntitySupplier r1, String r2, EntitySyncDataSupplier r3) {
        this.supplier = r1;
        this.runProcessName = r2;
        this.entitySyncDataSupplier = r3;
    }

    public /* synthetic */ EntityInitParam(EntitySupplier r2, String r3, EntitySyncDataSupplier r4, int r5, DefaultConstructorMarker r6) {
        if ((r5 & 2) == 0) goto L6;
        r3 = null;
    L6:
        if ((r5 & 4) == 0) goto L8;
        r4 = null;
    L8:
        this(r2, r3, r4);
    }

    public static /* synthetic */ EntityInitParam copy$default(EntityInitParam r0, EntitySupplier r1, String r2, EntitySyncDataSupplier r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.supplier;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.runProcessName;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.entitySyncDataSupplier;
    L12:
        return r0.copy(r1, r2, r3);
    }

    public final EntitySupplier component1() {
        return this.supplier;
    }

    public final String component2() {
        return this.runProcessName;
    }

    public final EntitySyncDataSupplier component3() {
        return this.entitySyncDataSupplier;
    }

    public final EntityInitParam copy(EntitySupplier r2, String r3, EntitySyncDataSupplier r4) {
        return new EntityInitParam(r2, r3, r4);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof EntityInitParam) == true) goto L8;
        return false;
    L8:
        EntityInitParam r6 = (EntityInitParam) r5;
        if (Intrinsics.areEqual(this.supplier, r6.supplier) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.runProcessName, r6.runProcessName) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.entitySyncDataSupplier, r6.entitySyncDataSupplier) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final EntitySyncDataSupplier getEntitySyncDataSupplier() {
        return this.entitySyncDataSupplier;
    }

    public final String getRunProcessName() {
        return this.runProcessName;
    }

    public final EntitySupplier getSupplier() {
        return this.supplier;
    }

    public int hashCode() {
        EntitySupplier r0 = this.supplier;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.runProcessName;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        EntitySyncDataSupplier r7 = this.entitySyncDataSupplier;
        if (r7 == null) goto L15;
        r1 = r7.hashCode();
    L15:
        return r6 + r1;
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "EntityInitParam(supplier=" + this.supplier + ", runProcessName=" + this.runProcessName + ", entitySyncDataSupplier=" + this.entitySyncDataSupplier + ')';
    }
}
