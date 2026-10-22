package com.obric.capabilitykit.common.intent;

import android.os.Parcel;
import android.os.Parcelable;
import com.obric.eventkit.eventstaskmanager.ITaskManager;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0013\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002B)\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\bJ\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0006HÆ\u0003J-\u0010\u0018\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eHÖ\u0003J\n\u0010\u001f\u001a\u0004\u0018\u00010\u0006H\u0016J\t\u0010 \u001a\u00020\u001aHÖ\u0001J\b\u0010!\u001a\u00020\u001cH\u0016J\u0012\u0010\"\u001a\u00020\u00012\b\u0010#\u001a\u0004\u0018\u00010\u001eH\u0016J\t\u0010$\u001a\u00020\u0006HÖ\u0001J\u0019\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020\u001aHÖ\u0001R&\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\f\"\u0004\b\u0014\u0010\u000e¨\u0006*"}, d2 = {"Lcom/obric/capabilitykit/common/intent/PhoneCallParams;", "Lcom/obric/capabilitykit/common/intent/IntentParams;", "Landroid/os/Parcelable;", "target", "Lcom/obric/capabilitykit/common/intent/ContactTarget;", "type", "", "simSlot", "(Lcom/obric/capabilitykit/common/intent/ContactTarget;Ljava/lang/String;Ljava/lang/String;)V", "getSimSlot$annotations", "()V", "getSimSlot", "()Ljava/lang/String;", "setSimSlot", "(Ljava/lang/String;)V", "getTarget", "()Lcom/obric/capabilitykit/common/intent/ContactTarget;", "setTarget", "(Lcom/obric/capabilitykit/common/intent/ContactTarget;)V", "getType", "setType", "component1", "component2", "component3", "copy", "describeContents", "", "equals", "", "other", "", "getSubActionValue", "hashCode", "isParamsCompleted", "mergeParams", "params", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "intentcommon_release"}, k = 1, mv = {1, 7, 1}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
public final class PhoneCallParams implements IntentParams, Parcelable {
    public static final Parcelable.Creator<PhoneCallParams> CREATOR = null;
    String simSlot;
    private ContactTarget target;
    private String type;

    static {
        CREATOR = new a();
    }

    public PhoneCallParams() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ PhoneCallParams copy$default(PhoneCallParams r0, ContactTarget r1, String r2, String r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.target;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.type;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.simSlot;
    L12:
        return r0.copy(r1, r2, r3);
    }

    public static /* synthetic */ void getSimSlot$annotations() {
    }

    public final ContactTarget component1() {
        return this.target;
    }

    public final String component2() {
        return this.type;
    }

    public final String component3() {
        return this.simSlot;
    }

    public final PhoneCallParams copy(ContactTarget r2, String r3, String r4) {
        return new PhoneCallParams(r2, r3, r4);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof PhoneCallParams) == true) goto L8;
        return false;
    L8:
        PhoneCallParams r6 = (PhoneCallParams) r5;
        if (Intrinsics.areEqual(this.target, r6.target) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.type, r6.type) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.simSlot, r6.simSlot) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        ContactTarget r0 = this.target;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.type;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.simSlot;
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
        return "PhoneCallParams(target=" + this.target + ", type=" + this.type + ", simSlot=" + this.simSlot + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r3, int r4) {
        r3.writeInt(1);
        Intrinsics.checkNotNullParameter(r3, "out");
        ContactTarget r1 = this.target;
        if (r1 != null) goto L5;
        r3.writeInt(0);
    L6:
        r3.writeString(this.type);
        r3.writeValue(this.simSlot);
        return;
    L5:
        r3.writeInt(1);
        r1.writeToParcel(r3, r4);
        goto L6
    }

    public String getSubActionValue() {
        ContactTarget r0 = this.target;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.toString();
    }

    public boolean isParamsCompleted() {
        if (this.target == null) goto L5;
        return true;
    L5:
        return false;
    }

    public final String getSimSlot() {
        return this.simSlot;
    }

    public final ContactTarget getTarget() {
        return this.target;
    }

    public final String getType() {
        return this.type;
    }

    public IntentParams mergeParams(Object r4) {
        if ((r4 instanceof PhoneCallParams) == true) goto L5;
        return this;
    L5:
        ContactTarget r0 = this.target;
        if (r0 != null) goto L8;
        r0 = ((PhoneCallParams) r4).target;
    L8:
        String r1 = this.type;
        if (r1 != null) goto L11;
        r1 = ((PhoneCallParams) r4).type;
    L11:
        String r2 = this.simSlot;
        if (r2 != null) goto L15;
        r2 = ((PhoneCallParams) r4).simSlot;
    L15:
        return new PhoneCallParams(r0, r1, r2);
    }

    public final void setSimSlot(String r1) {
        this.simSlot = r1;
    }

    public final void setTarget(ContactTarget r1) {
        this.target = r1;
    }

    public final void setType(String r1) {
        this.type = r1;
    }

    public PhoneCallParams(ContactTarget r1, String r2, String r3) {
        this.target = r1;
        this.type = r2;
        this.simSlot = r3;
    }

    public /* synthetic */ PhoneCallParams(ContactTarget r2, String r3, String r4, int r5, DefaultConstructorMarker r6) {
        if ((r5 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r3 = null;
    L9:
        if ((r5 & 4) == 0) goto L11;
        r4 = null;
    L11:
        this(r2, r3, r4);
    }
}
