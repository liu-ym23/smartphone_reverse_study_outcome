package com.obric.aiagent.assistant.idl.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.obric.capabilitykit.common.CardProvider;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.eventkit.eventstaskmanager.ITaskManager;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0013\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\b\u0018\u0000 &2\u00020\u0001:\u0001&B;\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\t\u0010\u0017\u001a\u00020\tHÆ\u0003J\t\u0010\u0018\u001a\u00020\tHÆ\u0003J?\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\tHÆ\u0001J\u0006\u0010\u001a\u001a\u00020\u0003J\u0013\u0010\u001b\u001a\u00020\t2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dHÖ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001f\u001a\u00020 HÖ\u0001J\u0016\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u0003R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0013R\u0011\u0010\n\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0013¨\u0006'"}, d2 = {"Lcom/obric/aiagent/assistant/idl/bean/AppIntentCardData;", "Landroid/os/Parcelable;", "type", "", "appEntity", "Lcom/obric/capabilitykit/entity/app/AppEntity;", "cardProvider", "Lcom/obric/capabilitykit/common/CardProvider;", "isDeleted", "", "isRefreshed", "<init>", "(ILcom/obric/capabilitykit/entity/app/AppEntity;Lcom/obric/capabilitykit/common/CardProvider;ZZ)V", "getType", "()I", "getAppEntity", "()Lcom/obric/capabilitykit/entity/app/AppEntity;", "getCardProvider", "()Lcom/obric/capabilitykit/common/CardProvider;", "()Z", "component1", "component2", "component3", "component4", "component5", "copy", "describeContents", "equals", "other", "", "hashCode", "toString", "", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "Companion", "assistant-ipc_release"}, k = 1, mv = {2, 1, 0}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
public final class AppIntentCardData implements Parcelable {
    public static final Parcelable.Creator<AppIntentCardData> CREATOR = null;
    public static final a Companion = null;
    public static final int TYPE_ENTITY = 0;
    public static final int TYPE_REMOTE = 1;
    private final AppEntity appEntity;
    private final CardProvider cardProvider;
    private final boolean isDeleted;
    private final boolean isRefreshed;
    private final int type;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
        CREATOR = new b();
    }

    public static /* synthetic */ AppIntentCardData copy$default(AppIntentCardData r3, int r4, AppEntity r5, CardProvider r6, boolean r7, boolean r8, int r9, Object r10) {
        if ((r9 & 1) == 0) goto L6;
        r4 = r3.type;
    L6:
        if ((r9 & 2) == 0) goto L8;
        r5 = r3.appEntity;
    L8:
        AppEntity r11 = r5;
        if ((r9 & 4) == 0) goto L11;
        r6 = r3.cardProvider;
    L11:
        CardProvider r0 = r6;
        if ((r9 & 8) == 0) goto L14;
        r7 = r3.isDeleted;
    L14:
        boolean r1 = r7;
        if ((r9 & 16) == 0) goto L17;
        r8 = r3.isRefreshed;
    L17:
        int r12 = r4;
        return r3.copy(r12, r11, r0, r1, r8);
    }

    public final int component1() {
        return this.type;
    }

    public final AppEntity component2() {
        return this.appEntity;
    }

    public final CardProvider component3() {
        return this.cardProvider;
    }

    public final boolean component4() {
        return this.isDeleted;
    }

    public final boolean component5() {
        return this.isRefreshed;
    }

    public final AppIntentCardData copy(int r8, AppEntity r9, CardProvider r10, boolean r11, boolean r12) {
        return new AppIntentCardData(r8, r9, r10, r11, r12);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof AppIntentCardData) == true) goto L8;
        return false;
    L8:
        AppIntentCardData r6 = (AppIntentCardData) r5;
        if (this.type == r6.type) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.appEntity, r6.appEntity) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.cardProvider, r6.cardProvider) == true) goto L18;
        return false;
    L18:
        if (this.isDeleted == r6.isDeleted) goto L21;
        return false;
    L21:
        if (this.isRefreshed == r6.isRefreshed) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        int r0 = this.type * 31;
        AppEntity r1 = this.appEntity;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        CardProvider r5 = this.cardProvider;
        if (r5 == null) goto L10;
        r2 = r5.hashCode();
    L10:
        int r6 = (r4 + r2) * 31;
        int r7 = 1231;
        if (this.isDeleted == false) goto L13;
        int r8 = 1231;
    L14:
        int r9 = (r6 + r8) * 31;
        if (this.isRefreshed == true) goto L19;
        r7 = 1237;
    L19:
        return r9 + r7;
    L13:
        r8 = 1237;
        goto L14
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public String toString() {
        return "AppIntentCardData(type=" + this.type + ", appEntity=" + this.appEntity + ", cardProvider=" + this.cardProvider + ", isDeleted=" + this.isDeleted + ", isRefreshed=" + this.isRefreshed + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "dest");
        r2.writeInt(this.type);
        r2.writeParcelable(this.appEntity, r3);
        r2.writeParcelable(this.cardProvider, r3);
        r2.writeInt(this.isDeleted ? 1 : 0);
        r2.writeInt(this.isRefreshed ? 1 : 0);
    }

    public final AppEntity getAppEntity() {
        return this.appEntity;
    }

    public final CardProvider getCardProvider() {
        return this.cardProvider;
    }

    public final int getType() {
        return this.type;
    }

    public final boolean isDeleted() {
        return this.isDeleted;
    }

    public final boolean isRefreshed() {
        return this.isRefreshed;
    }

    public AppIntentCardData(int r1, AppEntity r2, CardProvider r3, boolean r4, boolean r5) {
        this.type = r1;
        this.appEntity = r2;
        this.cardProvider = r3;
        this.isDeleted = r4;
        this.isRefreshed = r5;
    }

    public /* synthetic */ AppIntentCardData(int r8, AppEntity r9, CardProvider r10, boolean r11, boolean r12, int r13, DefaultConstructorMarker r14) {
        if ((r13 & 2) == 0) goto L5;
        AppEntity r3 = null;
    L7:
        if ((r13 & 4) == 0) goto L9;
        CardProvider r4 = null;
    L11:
        if ((r13 & 8) == 0) goto L13;
        boolean r5 = false;
    L15:
        if ((r13 & 16) == 0) goto L17;
        boolean r6 = false;
    L18:
        this(r8, r3, r4, r5, r6);
        return;
    L17:
        r6 = r12;
        goto L18
    L13:
        r5 = r11;
        goto L15
    L9:
        r4 = r10;
        goto L11
    L5:
        r3 = r9;
        goto L7
    }
}
