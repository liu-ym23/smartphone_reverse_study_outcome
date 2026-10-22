package com.obric.capabilitykit.common.intent;

import android.os.Parcel;
import android.os.Parcelable;
import com.obric.capabilitykit.common.execution.urishare.IUriSharableParams;
import com.obric.capabilitykit.entity.app.ContactEntity;
import com.obric.eventkit.eventstaskmanager.ITaskManager;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u001d\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\tJ&\u0010\u0013\u001a\u00020\u00002\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u0014J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\u0013\u0010\u0017\u001a\u00020\u00072\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\u0010\u0010\u001a\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00190\u001bH\u0016J\t\u0010\u001c\u001a\u00020\u0016HÖ\u0001J\b\u0010\u001d\u001a\u00020\u0007H\u0016J\u0012\u0010\u001e\u001a\u00020\u00012\b\u0010\u001f\u001a\u0004\u0018\u00010\u0019H\u0016J\t\u0010 \u001a\u00020!HÖ\u0001J\u0019\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u0016HÖ\u0001R\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\f\u001a\u0004\b\u0006\u0010\t\"\u0004\b\n\u0010\u000bR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006'"}, d2 = {"Lcom/obric/capabilitykit/common/intent/ContactsAddToFavoriteParams;", "Lcom/obric/capabilitykit/common/intent/IntentParams;", "Landroid/os/Parcelable;", "Lcom/obric/capabilitykit/common/execution/urishare/IUriSharableParams;", "target", "Lcom/obric/capabilitykit/entity/app/ContactEntity;", "isAdd", "", "(Lcom/obric/capabilitykit/entity/app/ContactEntity;Ljava/lang/Boolean;)V", "()Ljava/lang/Boolean;", "setAdd", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getTarget", "()Lcom/obric/capabilitykit/entity/app/ContactEntity;", "setTarget", "(Lcom/obric/capabilitykit/entity/app/ContactEntity;)V", "component1", "component2", "copy", "(Lcom/obric/capabilitykit/entity/app/ContactEntity;Ljava/lang/Boolean;)Lcom/obric/capabilitykit/common/intent/ContactsAddToFavoriteParams;", "describeContents", "", "equals", "other", "", "getUriSharableParams", "", "hashCode", "isParamsCompleted", "mergeParams", "params", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "intentcommon_release"}, k = 1, mv = {1, 7, 1}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
public final class ContactsAddToFavoriteParams implements IntentParams, Parcelable, IUriSharableParams {
    public static final Parcelable.Creator<ContactsAddToFavoriteParams> CREATOR = null;
    private Boolean isAdd;
    private ContactEntity target;

    static {
        CREATOR = new a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ContactsAddToFavoriteParams() {
        Object[] r0 = 0 == true ? 1 : 0;
        this(null, r0, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ ContactsAddToFavoriteParams copy$default(ContactsAddToFavoriteParams r0, ContactEntity r1, Boolean r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.target;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.isAdd;
    L9:
        return r0.copy(r1, r2);
    }

    public final ContactEntity component1() {
        return this.target;
    }

    public final Boolean component2() {
        return this.isAdd;
    }

    public final ContactsAddToFavoriteParams copy(ContactEntity r2, Boolean r3) {
        return new ContactsAddToFavoriteParams(r2, r3);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof ContactsAddToFavoriteParams) == true) goto L8;
        return false;
    L8:
        ContactsAddToFavoriteParams r6 = (ContactsAddToFavoriteParams) r5;
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
        ContactEntity r0 = this.target;
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
        return "ContactsAddToFavoriteParams(target=" + this.target + ", isAdd=" + this.isAdd + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r3, int r4) {
        r3.writeInt(0);
        Intrinsics.checkNotNullParameter(r3, "out");
        r3.writeParcelable(this.target, r4);
        Boolean r5 = this.isAdd;
        if (r5 != null) goto L5;
        r3.writeInt(0);
        return;
    L5:
        r3.writeInt(1);
        r3.writeInt(r5.booleanValue() ? 1 : 0);
    }

    @Override // com.obric.capabilitykit.common.execution.urishare.IUriSharableParams
    public List<Object> getUriSharableParams() {
        return CollectionsKt.listOf(this.target);
    }

    public boolean isParamsCompleted() {
        if (this.target == null) goto L5;
        return true;
    L5:
        return false;
    }

    public final ContactEntity getTarget() {
        return this.target;
    }

    public final Boolean isAdd() {
        return this.isAdd;
    }

    public IntentParams mergeParams(Object r3) {
        if ((r3 instanceof ContactsAddToFavoriteParams) == true) goto L5;
        return this;
    L5:
        ContactEntity r0 = this.target;
        if (r0 != null) goto L8;
        r0 = ((ContactsAddToFavoriteParams) r3).target;
    L8:
        Boolean r1 = this.isAdd;
        if (r1 != null) goto L12;
        r1 = ((ContactsAddToFavoriteParams) r3).isAdd;
    L12:
        return new ContactsAddToFavoriteParams(r0, r1);
    }

    public final void setAdd(Boolean r1) {
        this.isAdd = r1;
    }

    public final void setTarget(ContactEntity r1) {
        this.target = r1;
    }

    public ContactsAddToFavoriteParams(ContactEntity r1, Boolean r2) {
        this.target = r1;
        this.isAdd = r2;
    }

    public /* synthetic */ ContactsAddToFavoriteParams(ContactEntity r2, Boolean r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 2) == 0) goto L8;
        r3 = null;
    L8:
        this(r2, r3);
    }
}
