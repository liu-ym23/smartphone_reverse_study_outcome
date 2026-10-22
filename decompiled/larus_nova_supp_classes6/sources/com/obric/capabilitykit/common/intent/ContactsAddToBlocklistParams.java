package com.obric.capabilitykit.common.intent;

import android.os.Parcel;
import android.os.Parcelable;
import com.obric.eventkit.eventstaskmanager.ITaskManager;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002B\u001d\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\bJ&\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010\u0013J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\u0013\u0010\u0016\u001a\u00020\u00062\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0015HÖ\u0001J\b\u0010\u001a\u001a\u00020\u0006H\u0016J\u0012\u0010\u001b\u001a\u00020\u00012\b\u0010\u001c\u001a\u0004\u0018\u00010\u0018H\u0016J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\u0019\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u0015HÖ\u0001R\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u000b\u001a\u0004\b\u0005\u0010\b\"\u0004\b\t\u0010\nR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006$"}, d2 = {"Lcom/obric/capabilitykit/common/intent/ContactsAddToBlocklistParams;", "Lcom/obric/capabilitykit/common/intent/IntentParams;", "Landroid/os/Parcelable;", "target", "Lcom/obric/capabilitykit/common/intent/BlockListTarget;", "isAdd", "", "(Lcom/obric/capabilitykit/common/intent/BlockListTarget;Ljava/lang/Boolean;)V", "()Ljava/lang/Boolean;", "setAdd", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getTarget", "()Lcom/obric/capabilitykit/common/intent/BlockListTarget;", "setTarget", "(Lcom/obric/capabilitykit/common/intent/BlockListTarget;)V", "component1", "component2", "copy", "(Lcom/obric/capabilitykit/common/intent/BlockListTarget;Ljava/lang/Boolean;)Lcom/obric/capabilitykit/common/intent/ContactsAddToBlocklistParams;", "describeContents", "", "equals", "other", "", "hashCode", "isParamsCompleted", "mergeParams", "params", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "intentcommon_release"}, k = 1, mv = {1, 7, 1}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
public final class ContactsAddToBlocklistParams implements IntentParams, Parcelable {
    public static final Parcelable.Creator<ContactsAddToBlocklistParams> CREATOR = null;
    private Boolean isAdd;
    private BlockListTarget target;

    static {
        CREATOR = new a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ContactsAddToBlocklistParams() {
        Object[] r0 = 0 == true ? 1 : 0;
        this(null, r0, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ ContactsAddToBlocklistParams copy$default(ContactsAddToBlocklistParams r0, BlockListTarget r1, Boolean r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.target;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.isAdd;
    L9:
        return r0.copy(r1, r2);
    }

    public final BlockListTarget component1() {
        return this.target;
    }

    public final Boolean component2() {
        return this.isAdd;
    }

    public final ContactsAddToBlocklistParams copy(BlockListTarget r2, Boolean r3) {
        return new ContactsAddToBlocklistParams(r2, r3);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof ContactsAddToBlocklistParams) == true) goto L8;
        return false;
    L8:
        ContactsAddToBlocklistParams r6 = (ContactsAddToBlocklistParams) r5;
        if (Intrinsics.areEqual(this.target, r6.target) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.isAdd, r6.isAdd) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public String getSubActionValue() {
        return null;
    }

    public int hashCode() {
        BlockListTarget r0 = this.target;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        Boolean r4 = this.isAdd;
        if (r4 == null) goto L11;
        r1 = r4.hashCode();
    L11:
        return r3 + r1;
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "ContactsAddToBlocklistParams(target=" + this.target + ", isAdd=" + this.isAdd + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r4, int r5) {
        r4.writeInt(0);
        Intrinsics.checkNotNullParameter(r4, "out");
        BlockListTarget r1 = this.target;
        if (r1 != null) goto L5;
        r4.writeInt(0);
    L6:
        Boolean r6 = this.isAdd;
        if (r6 != null) goto L9;
        r4.writeInt(0);
        return;
    L9:
        r4.writeInt(1);
        r4.writeInt(r6.booleanValue() ? 1 : 0);
        return;
    L5:
        r4.writeInt(1);
        r1.writeToParcel(r4, r5);
        goto L6
    }

    public boolean isParamsCompleted() {
        if (this.target == null) goto L5;
        return true;
    L5:
        return false;
    }

    public final BlockListTarget getTarget() {
        return this.target;
    }

    public final Boolean isAdd() {
        return this.isAdd;
    }

    public IntentParams mergeParams(Object r3) {
        if ((r3 instanceof ContactsAddToBlocklistParams) == true) goto L5;
        return this;
    L5:
        BlockListTarget r0 = this.target;
        if (r0 != null) goto L8;
        r0 = ((ContactsAddToBlocklistParams) r3).target;
    L8:
        Boolean r1 = this.isAdd;
        if (r1 != null) goto L12;
        r1 = ((ContactsAddToBlocklistParams) r3).isAdd;
    L12:
        return new ContactsAddToBlocklistParams(r0, r1);
    }

    public final void setAdd(Boolean r1) {
        this.isAdd = r1;
    }

    public final void setTarget(BlockListTarget r1) {
        this.target = r1;
    }

    public ContactsAddToBlocklistParams(BlockListTarget r1, Boolean r2) {
        this.target = r1;
        this.isAdd = r2;
    }

    public /* synthetic */ ContactsAddToBlocklistParams(BlockListTarget r2, Boolean r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 2) == 0) goto L8;
        r3 = null;
    L8:
        this(r2, r3);
    }
}
