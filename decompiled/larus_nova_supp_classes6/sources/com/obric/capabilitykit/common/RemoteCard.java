package com.obric.capabilitykit.common;

import android.os.Parcel;
import android.os.Parcelable;
import com.obric.eventkit.eventstaskmanager.ITaskManager;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB%\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0012\b\u0002\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005¢\u0006\u0002\u0010\u0007J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\u0018\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0012H\u0016R&\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\b\u0002\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u001b"}, d2 = {"Lcom/obric/capabilitykit/common/RemoteCard;", "Landroid/os/Parcelable;", "isIndependent", "", "cardProviders", "", "Lcom/obric/capabilitykit/common/CardProvider;", "(Ljava/lang/Boolean;[Lcom/obric/capabilitykit/common/CardProvider;)V", "getCardProviders", "()[Lcom/obric/capabilitykit/common/CardProvider;", "setCardProviders", "([Lcom/obric/capabilitykit/common/CardProvider;)V", "[Lcom/obric/capabilitykit/common/CardProvider;", "()Ljava/lang/Boolean;", "setIndependent", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "describeContents", "", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "CREATOR", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
public final class RemoteCard implements Parcelable {
    public static final a CREATOR = null;
    private CardProvider[] cardProviders;
    private Boolean isIndependent;

    /* JADX WARN: Multi-variable type inference failed */
    public RemoteCard() {
        Object[] r0 = 0 == true ? 1 : 0;
        this(null, r0, 3, 0 == true ? 1 : 0);
    }

    public RemoteCard(Boolean r1, CardProvider[] r2) {
        this.isIndependent = r1;
        this.cardProviders = r2;
    }

    public /* synthetic */ RemoteCard(Boolean r1, CardProvider[] r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = Boolean.TRUE;
    L6:
        if ((r3 & 2) == 0) goto L8;
        r2 = null;
    L8:
        this(r1, r2);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final CardProvider[] getCardProviders() {
        return this.cardProviders;
    }

    public final Boolean isIndependent() {
        return this.isIndependent;
    }

    public final void setCardProviders(CardProvider[] r1) {
        this.cardProviders = r1;
    }

    public final void setIndependent(Boolean r1) {
        this.isIndependent = r1;
    }

    public String toString() {
        return "RemoteCard(isIndependent=" + this.isIndependent + ", cardProviders=" + Arrays.toString(this.cardProviders) + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r5, int r6) {
        int r0 = 0;
        r5.writeInt(0);
        Intrinsics.checkNotNullParameter(r5, "parcel");
        r5.writeValue(this.isIndependent);
        CardProvider[] r1 = this.cardProviders;
        if (r1 == null) goto L5;
        int r2 = r1.length;
    L6:
        r5.writeInt(r2);
        CardProvider[] r3 = this.cardProviders;
        if (r3 == null) goto L11;
        int r4 = r3.length;
    L9:
        if (r0 >= r4) goto L13;
        r5.writeParcelable(r3[r0], r6);
        r0 = r0 + 1;
        goto L9
    L13:
        return;
    L11:
        return;
    L5:
        r2 = 0;
        goto L6
    }

    static {
        CREATOR = new a();
    }
}
