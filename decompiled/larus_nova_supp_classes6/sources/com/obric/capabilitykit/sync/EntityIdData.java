package com.obric.capabilitykit.sync;

import com.obric.eventkit.eventstaskmanager.ITaskManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0012\u001a\u00020\u0005H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0013"}, d2 = {"Lcom/obric/capabilitykit/sync/EntityIdData;", "", "id", "", "type", "", "lastModifyTime", "", "(Ljava/lang/String;IJ)V", "getId", "()Ljava/lang/String;", "getLastModifyTime", "()J", "getType", "()I", "equals", "", "other", "hashCode", "capabilitykit_release"}, k = 1, mv = {1, 7, 1}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
public final class EntityIdData {
    private final String id;
    private final long lastModifyTime;
    private final int type;

    public EntityIdData(String r2, int r3, long r4) {
        Intrinsics.checkNotNullParameter(r2, "id");
        this.id = r2;
        this.type = r3;
        this.lastModifyTime = r4;
    }

    public boolean equals(Object r4) {
        if ((r4 instanceof EntityIdData) == false) goto L10;
        EntityIdData r5 = (EntityIdData) r4;
        if (Intrinsics.areEqual(r5.id, this.id) == true) goto L7;
        return false;
    L7:
        if (r5.type != this.type) goto L12;
        return true;
    L12:
        return false;
    L10:
        return false;
    }

    public final String getId() {
        return this.id;
    }

    public final long getLastModifyTime() {
        return this.lastModifyTime;
    }

    public final int getType() {
        return this.type;
    }

    public int hashCode() {
        return (this.id.hashCode() * 31) + this.type;
    }
}
