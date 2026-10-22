package com.obric.aiproactive.api;

import android.os.Parcel;
import android.os.Parcelable;
import com.obric.aikernel.sdk.ext.Params;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0013\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B;\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0019\u001a\u00020\tHÆ\u0003J\t\u0010\u001a\u001a\u00020\tHÆ\u0003JG\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\tHÆ\u0001J\u0006\u0010\u001c\u001a\u00020\u001dJ\u0013\u0010\u001e\u001a\u00020\u00072\b\u0010\u001f\u001a\u0004\u0018\u00010 HÖ\u0003J\t\u0010!\u001a\u00020\u001dHÖ\u0001J\t\u0010\"\u001a\u00020\u0003HÖ\u0001J\u0016\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u001dR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0011R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\n\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013¨\u0006("}, d2 = {"Lcom/obric/aiproactive/api/ProactiveUserSubscriptionDto;", "Landroid/os/Parcelable;", "subscriptionId", "", Params.CONTENT, "uiData", "isActive", "", "created", "", "updated", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZJJ)V", "getSubscriptionId", "()Ljava/lang/String;", "getContent", "getUiData", "()Z", "getCreated", "()J", "getUpdated", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "describeContents", "", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "ai_proactive_api_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ProactiveUserSubscriptionDto implements Parcelable {
    public static final Parcelable.Creator<ProactiveUserSubscriptionDto> CREATOR = null;
    private final String content;
    private final long created;
    private final boolean isActive;
    private final String subscriptionId;
    private final String uiData;
    private final long updated;

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class a implements Parcelable.Creator<ProactiveUserSubscriptionDto> {
        public a() {
        }

        public final ProactiveUserSubscriptionDto a(Parcel r10) {
            Intrinsics.checkNotNullParameter(r10, "parcel");
            String r1 = r10.readString();
            String r2 = r10.readString();
            String r3 = r10.readString();
            if (r10.readInt() == 0) goto L5;
            boolean r0 = true;
        L7:
            return new ProactiveUserSubscriptionDto(r1, r2, r3, r0, r10.readLong(), r10.readLong());
        L5:
            r0 = false;
            goto L7
        }

        public final ProactiveUserSubscriptionDto[] a(int r1) {
            return new ProactiveUserSubscriptionDto[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* synthetic */ ProactiveUserSubscriptionDto createFromParcel(Parcel r1) {
            return a(r1);
        }

        @Override // android.os.Parcelable.Creator
        public /* synthetic */ ProactiveUserSubscriptionDto[] newArray(int r1) {
            return a(r1);
        }
    }

    static {
        CREATOR = (Parcelable.Creator) ZeusTransformUtils.preCheckCast(new a(), Parcelable.Creator.class, "com.obric.memorydata.plugin");
    }

    public ProactiveUserSubscriptionDto(String r2, String r3, String r4, boolean r5, long r6, long r8) {
        Intrinsics.checkNotNullParameter(r2, "subscriptionId");
        Intrinsics.checkNotNullParameter(r3, Params.CONTENT);
        this.subscriptionId = r2;
        this.content = r3;
        this.uiData = r4;
        this.isActive = r5;
        this.created = r6;
        this.updated = r8;
    }

    public /* synthetic */ ProactiveUserSubscriptionDto(String r11, String r12, String r13, boolean r14, long r15, long r17, int r19, DefaultConstructorMarker r20) {
        if ((r19 & 4) == 0) goto L5;
        String r4 = null;
    L6:
        this(r11, r12, r4, r14, r15, r17);
        return;
    L5:
        r4 = r13;
        goto L6
    }

    public static /* synthetic */ ProactiveUserSubscriptionDto copy$default(ProactiveUserSubscriptionDto r9, String r10, String r11, String r12, boolean r13, long r14, long r16, int r18, Object r19) {
        if ((r18 & 1) == 0) goto L5;
        String r1 = r9.subscriptionId;
    L7:
        if ((r18 & 2) == 0) goto L9;
        String r2 = r9.content;
    L11:
        if ((r18 & 4) == 0) goto L13;
        String r3 = r9.uiData;
    L15:
        if ((r18 & 8) == 0) goto L17;
        boolean r4 = r9.isActive;
    L19:
        if ((r18 & 16) == 0) goto L21;
        long r5 = r9.created;
    L23:
        if ((r18 & 32) == 0) goto L25;
        long r7 = r9.updated;
    L27:
        return r9.copy(r1, r2, r3, r4, r5, r7);
    L25:
        r7 = r16;
        goto L27
    L21:
        r5 = r14;
        goto L23
    L17:
        r4 = r13;
        goto L19
    L13:
        r3 = r12;
        goto L15
    L9:
        r2 = r11;
        goto L11
    L5:
        r1 = r10;
        goto L7
    }

    public final String component1() {
        return this.subscriptionId;
    }

    public final String component2() {
        return this.content;
    }

    public final String component3() {
        return this.uiData;
    }

    public final boolean component4() {
        return this.isActive;
    }

    public final long component5() {
        return this.created;
    }

    public final long component6() {
        return this.updated;
    }

    public final ProactiveUserSubscriptionDto copy(String r11, String r12, String r13, boolean r14, long r15, long r17) {
        Intrinsics.checkNotNullParameter(r11, "subscriptionId");
        Intrinsics.checkNotNullParameter(r12, Params.CONTENT);
        return new ProactiveUserSubscriptionDto(r11, r12, r13, r14, r15, r17);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, ProactiveUserSubscriptionDto.class) == true) goto L8;
        return false;
    L8:
        ProactiveUserSubscriptionDto r10 = (ProactiveUserSubscriptionDto) ZeusTransformUtils.preCheckCast(r9, ProactiveUserSubscriptionDto.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.subscriptionId, r10.subscriptionId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.content, r10.content) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.uiData, r10.uiData) == true) goto L18;
        return false;
    L18:
        if (this.isActive == r10.isActive) goto L21;
        return false;
    L21:
        if (this.created == r10.created) goto L24;
        return false;
    L24:
        if (this.updated == r10.updated) goto L26;
        return false;
    L26:
        return true;
    }

    public final String getContent() {
        return this.content;
    }

    public final long getCreated() {
        return this.created;
    }

    public final String getSubscriptionId() {
        return this.subscriptionId;
    }

    public final String getUiData() {
        return this.uiData;
    }

    public final long getUpdated() {
        return this.updated;
    }

    public int hashCode() {
        int r0 = ((this.subscriptionId.hashCode() * 31) + this.content.hashCode()) * 31;
        String r1 = this.uiData;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return ((((((r0 + r2) * 31) + Boolean.hashCode(this.isActive)) * 31) + Long.hashCode(this.created)) * 31) + Long.hashCode(this.updated);
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    public final boolean isActive() {
        return this.isActive;
    }

    public String toString() {
        return "ProactiveUserSubscriptionDto(subscriptionId=" + this.subscriptionId + ", content=" + this.content + ", uiData=" + this.uiData + ", isActive=" + this.isActive + ", created=" + this.created + ", updated=" + this.updated + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "dest");
        r3.writeString(this.subscriptionId);
        r3.writeString(this.content);
        r3.writeString(this.uiData);
        r3.writeInt(this.isActive ? 1 : 0);
        r3.writeLong(this.created);
        r3.writeLong(this.updated);
    }
}
