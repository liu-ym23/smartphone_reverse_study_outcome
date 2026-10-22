package com.obric.capabilitykit.common.intent;

import android.os.Parcel;
import android.os.Parcelable;
import com.obric.capabilitykit.common.execution.urishare.IUriSharableParams;
import com.obric.capabilitykit.entity.app.ContactEntity;
import com.obric.eventkit.eventstaskmanager.ITaskManager;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0017\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\u0002\u0010\u0007J\u0016\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\tJ \u0010\r\u001a\u00020\u00002\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u000eJ\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\u0010\u0010\u0015\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00140\u0016H\u0016J\t\u0010\u0017\u001a\u00020\u0010HÖ\u0001J\b\u0010\u0018\u001a\u00020\u0012H\u0016J\u0012\u0010\u0019\u001a\u00020\u00012\b\u0010\u001a\u001a\u0004\u0018\u00010\u0014H\u0016J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\u0019\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u0010HÖ\u0001R$\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u000b\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u0007¨\u0006\""}, d2 = {"Lcom/obric/capabilitykit/common/intent/ContactsDeleteParams;", "Lcom/obric/capabilitykit/common/intent/IntentParams;", "Landroid/os/Parcelable;", "Lcom/obric/capabilitykit/common/execution/urishare/IUriSharableParams;", "targets", "", "Lcom/obric/capabilitykit/entity/app/ContactEntity;", "([Lcom/obric/capabilitykit/entity/app/ContactEntity;)V", "getTargets", "()[Lcom/obric/capabilitykit/entity/app/ContactEntity;", "setTargets", "[Lcom/obric/capabilitykit/entity/app/ContactEntity;", "component1", "copy", "([Lcom/obric/capabilitykit/entity/app/ContactEntity;)Lcom/obric/capabilitykit/common/intent/ContactsDeleteParams;", "describeContents", "", "equals", "", "other", "", "getUriSharableParams", "", "hashCode", "isParamsCompleted", "mergeParams", "params", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "intentcommon_release"}, k = 1, mv = {1, 7, 1}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
public final class ContactsDeleteParams implements IntentParams, Parcelable, IUriSharableParams {
    public static final Parcelable.Creator<ContactsDeleteParams> CREATOR = null;
    private ContactEntity[] targets;

    static {
        CREATOR = new a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ContactsDeleteParams() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ ContactsDeleteParams copy$default(ContactsDeleteParams r0, ContactEntity[] r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = r0.targets;
    L6:
        return r0.copy(r1);
    }

    public final ContactEntity[] component1() {
        return this.targets;
    }

    public final ContactsDeleteParams copy(ContactEntity[] r2) {
        return new ContactsDeleteParams(r2);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if ((r4 instanceof ContactsDeleteParams) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.targets, ((ContactsDeleteParams) r4).targets) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public String getSubActionValue() {
        return null;
    }

    public int hashCode() {
        ContactEntity[] r0 = this.targets;
        if (r0 != null) goto L6;
        return 0;
    L6:
        return Arrays.hashCode(r0);
    }

    public String toString() {
        return "ContactsDeleteParams(targets=" + Arrays.toString(this.targets) + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r5, int r6) {
        int r0 = 0;
        r5.writeInt(0);
        Intrinsics.checkNotNullParameter(r5, "out");
        ContactEntity[] r1 = this.targets;
        if (r1 != null) goto L5;
        r5.writeInt(0);
        return;
    L5:
        r5.writeInt(1);
        int r2 = r1.length;
        r5.writeInt(r2);
    L6:
        if (r0 == r2) goto L10;
        r5.writeParcelable(r1[r0], r6);
        r0 = r0 + 1;
        goto L6
    }

    @Override // com.obric.capabilitykit.common.execution.urishare.IUriSharableParams
    public List<Object> getUriSharableParams() {
        return CollectionsKt.listOf(this.targets);
    }

    public boolean isParamsCompleted() {
        if (this.targets == null) goto L5;
        return true;
    L5:
        return false;
    }

    public final ContactEntity[] getTargets() {
        return this.targets;
    }

    public ContactsDeleteParams(ContactEntity[] r1) {
        this.targets = r1;
    }

    public IntentParams mergeParams(Object r2) {
        if ((r2 instanceof ContactsDeleteParams) == true) goto L5;
        return this;
    L5:
        ContactEntity[] r0 = this.targets;
        if (r0 != null) goto L9;
        r0 = ((ContactsDeleteParams) r2).targets;
    L9:
        return new ContactsDeleteParams(r0);
    }

    public final void setTargets(ContactEntity[] r1) {
        this.targets = r1;
    }

    public /* synthetic */ ContactsDeleteParams(ContactEntity[] r1, int r2, DefaultConstructorMarker r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = null;
    L5:
        this(r1);
    }
}
