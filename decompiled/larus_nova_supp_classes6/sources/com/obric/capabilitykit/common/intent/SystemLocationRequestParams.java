package com.obric.capabilitykit.common.intent;

import android.os.Parcel;
import android.os.Parcelable;
import com.obric.eventkit.eventstaskmanager.ITaskManager;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0010\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002B\u001d\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0002\u0010\tJ\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u000eJ&\u0010\u0014\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010\u0015J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\u0013\u0010\u0018\u001a\u00020\u00042\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aHÖ\u0003J\t\u0010\u001b\u001a\u00020\u0017HÖ\u0001J\u0012\u0010\u001c\u001a\u00020\u00012\b\u0010\u001d\u001a\u0004\u0018\u00010\u001aH\u0016J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\u0019\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u0017HÖ\u0001R\u001e\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0011\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006%"}, d2 = {"Lcom/obric/capabilitykit/common/intent/SystemLocationRequestParams;", "Lcom/obric/capabilitykit/common/intent/IntentParams;", "Landroid/os/Parcelable;", "needHighPrecision", "", "timeout", "", "(Ljava/lang/Boolean;Ljava/lang/Long;)V", "getNeedHighPrecision", "()Ljava/lang/Boolean;", "setNeedHighPrecision", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getTimeout", "()Ljava/lang/Long;", "setTimeout", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "component1", "component2", "copy", "(Ljava/lang/Boolean;Ljava/lang/Long;)Lcom/obric/capabilitykit/common/intent/SystemLocationRequestParams;", "describeContents", "", "equals", "other", "", "hashCode", "mergeParams", "params", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "intentcommon_release"}, k = 1, mv = {1, 7, 1}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
public final class SystemLocationRequestParams implements IntentParams, Parcelable {
    public static final Parcelable.Creator<SystemLocationRequestParams> CREATOR = null;
    private Boolean needHighPrecision;
    private Long timeout;

    static {
        CREATOR = new a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SystemLocationRequestParams() {
        Object[] r0 = 0 == true ? 1 : 0;
        this(null, r0, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ SystemLocationRequestParams copy$default(SystemLocationRequestParams r0, Boolean r1, Long r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.needHighPrecision;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.timeout;
    L9:
        return r0.copy(r1, r2);
    }

    public final Boolean component1() {
        return this.needHighPrecision;
    }

    public final Long component2() {
        return this.timeout;
    }

    public final SystemLocationRequestParams copy(Boolean r2, Long r3) {
        return new SystemLocationRequestParams(r2, r3);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof SystemLocationRequestParams) == true) goto L8;
        return false;
    L8:
        SystemLocationRequestParams r6 = (SystemLocationRequestParams) r5;
        if (Intrinsics.areEqual(this.needHighPrecision, r6.needHighPrecision) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.timeout, r6.timeout) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public String getSubActionValue() {
        return null;
    }

    public int hashCode() {
        Boolean r0 = this.needHighPrecision;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        Long r4 = this.timeout;
        if (r4 == null) goto L11;
        r1 = r4.hashCode();
    L11:
        return r3 + r1;
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public boolean isParamsCompleted() {
        return true;
    }

    public String toString() {
        return "SystemLocationRequestParams(needHighPrecision=" + this.needHighPrecision + ", timeout=" + this.timeout + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r3, int r4) {
        r3.writeInt(0);
        Intrinsics.checkNotNullParameter(r3, "out");
        Boolean r0 = this.needHighPrecision;
        if (r0 != null) goto L5;
        r3.writeInt(0);
    L6:
        Long r1 = this.timeout;
        if (r1 != null) goto L9;
        r3.writeInt(0);
        return;
    L9:
        r3.writeInt(1);
        r3.writeLong(r1.longValue());
        return;
    L5:
        r3.writeInt(1);
        r3.writeInt(r0.booleanValue() ? 1 : 0);
        goto L6
    }

    public final Boolean getNeedHighPrecision() {
        return this.needHighPrecision;
    }

    public final Long getTimeout() {
        return this.timeout;
    }

    public IntentParams mergeParams(Object r3) {
        if ((r3 instanceof SystemLocationRequestParams) == true) goto L5;
        return this;
    L5:
        Boolean r0 = this.needHighPrecision;
        if (r0 != null) goto L8;
        r0 = ((SystemLocationRequestParams) r3).needHighPrecision;
    L8:
        Long r1 = this.timeout;
        if (r1 != null) goto L12;
        r1 = ((SystemLocationRequestParams) r3).timeout;
    L12:
        return new SystemLocationRequestParams(r0, r1);
    }

    public final void setNeedHighPrecision(Boolean r1) {
        this.needHighPrecision = r1;
    }

    public final void setTimeout(Long r1) {
        this.timeout = r1;
    }

    public SystemLocationRequestParams(Boolean r1, Long r2) {
        this.needHighPrecision = r1;
        this.timeout = r2;
    }

    public /* synthetic */ SystemLocationRequestParams(Boolean r2, Long r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 2) == 0) goto L8;
        r3 = null;
    L8:
        this(r2, r3);
    }
}
