package com.obric.capabilitykit.common.intent;

import android.os.Parcel;
import android.os.Parcelable;
import com.obric.eventkit.eventstaskmanager.ITaskManager;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u000f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002B#\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0016\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\tJ,\u0010\u0013\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010\u0014J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aHÖ\u0003J\t\u0010\u001b\u001a\u00020\u0016HÖ\u0001J\b\u0010\u001c\u001a\u00020\u0018H\u0016J\u0012\u0010\u001d\u001a\u00020\u00012\b\u0010\u001e\u001a\u0004\u0018\u00010\u001aH\u0016J\t\u0010\u001f\u001a\u00020\u0004HÖ\u0001J\u0019\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u0016HÖ\u0001R$\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006%"}, d2 = {"Lcom/obric/capabilitykit/common/intent/SystemQAWithSearchParams;", "Lcom/obric/capabilitykit/common/intent/IntentParams;", "Landroid/os/Parcelable;", "message", "", "entities", "", "(Ljava/lang/String;[Ljava/lang/String;)V", "getEntities", "()[Ljava/lang/String;", "setEntities", "([Ljava/lang/String;)V", "[Ljava/lang/String;", "getMessage", "()Ljava/lang/String;", "setMessage", "(Ljava/lang/String;)V", "component1", "component2", "copy", "(Ljava/lang/String;[Ljava/lang/String;)Lcom/obric/capabilitykit/common/intent/SystemQAWithSearchParams;", "describeContents", "", "equals", "", "other", "", "hashCode", "isParamsCompleted", "mergeParams", "params", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "intentcommon_release"}, k = 1, mv = {1, 7, 1}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
public final class SystemQAWithSearchParams implements IntentParams, Parcelable {
    public static final Parcelable.Creator<SystemQAWithSearchParams> CREATOR = null;
    private String[] entities;
    private String message;

    static {
        CREATOR = new a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SystemQAWithSearchParams() {
        Object[] r0 = 0 == true ? 1 : 0;
        this(null, r0, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ SystemQAWithSearchParams copy$default(SystemQAWithSearchParams r0, String r1, String[] r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.message;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.entities;
    L9:
        return r0.copy(r1, r2);
    }

    public final String component1() {
        return this.message;
    }

    public final String[] component2() {
        return this.entities;
    }

    public final SystemQAWithSearchParams copy(String r2, String[] r3) {
        return new SystemQAWithSearchParams(r2, r3);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof SystemQAWithSearchParams) == true) goto L8;
        return false;
    L8:
        SystemQAWithSearchParams r6 = (SystemQAWithSearchParams) r5;
        if (Intrinsics.areEqual(this.message, r6.message) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.entities, r6.entities) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public String getSubActionValue() {
        return null;
    }

    public int hashCode() {
        String r0 = this.message;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String[] r4 = this.entities;
        if (r4 == null) goto L11;
        r1 = Arrays.hashCode(r4);
    L11:
        return r3 + r1;
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "SystemQAWithSearchParams(message=" + this.message + ", entities=" + Arrays.toString(this.entities) + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r1, int r2) {
        r1.writeInt(0);
        Intrinsics.checkNotNullParameter(r1, "out");
        r1.writeString(this.message);
        r1.writeStringArray(this.entities);
    }

    public boolean isParamsCompleted() {
        if (this.message == null) goto L5;
        return true;
    L5:
        return false;
    }

    public final String[] getEntities() {
        return this.entities;
    }

    public final String getMessage() {
        return this.message;
    }

    public IntentParams mergeParams(Object r3) {
        if ((r3 instanceof SystemQAWithSearchParams) == true) goto L5;
        return this;
    L5:
        String r0 = this.message;
        if (r0 != null) goto L8;
        r0 = ((SystemQAWithSearchParams) r3).message;
    L8:
        String[] r1 = this.entities;
        if (r1 != null) goto L12;
        r1 = ((SystemQAWithSearchParams) r3).entities;
    L12:
        return new SystemQAWithSearchParams(r0, r1);
    }

    public final void setEntities(String[] r1) {
        this.entities = r1;
    }

    public final void setMessage(String r1) {
        this.message = r1;
    }

    public SystemQAWithSearchParams(String r1, String[] r2) {
        this.message = r1;
        this.entities = r2;
    }

    public /* synthetic */ SystemQAWithSearchParams(String r2, String[] r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 2) == 0) goto L8;
        r3 = null;
    L8:
        this(r2, r3);
    }
}
