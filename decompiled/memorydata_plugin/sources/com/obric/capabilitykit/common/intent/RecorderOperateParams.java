package com.obric.capabilitykit.common.intent;

import android.os.Parcel;
import android.os.Parcelable;
import com.obric.b.a;
import com.obric.memorydata.middleware.impl.bdtracker.TrackerImpl;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0013\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002B)\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0007J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0004HÆ\u0003J-\u0010\u0016\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004HÆ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cHÖ\u0003J\t\u0010\u001d\u001a\u00020\u0018HÖ\u0001J\b\u0010\u001e\u001a\u00020\u001aH\u0016J\u0012\u0010\u001f\u001a\u00020\u00012\b\u0010 \u001a\u0004\u0018\u00010\u001cH\u0016J\t\u0010!\u001a\u00020\u0004HÖ\u0001J\u0019\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u0018HÖ\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR&\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\t\"\u0004\b\u000f\u0010\u000bR&\u0010\u0006\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0010\u0010\r\u001a\u0004\b\u0011\u0010\t\"\u0004\b\u0012\u0010\u000b¨\u0006'"}, d2 = {"Lcom/obric/capabilitykit/common/intent/RecorderOperateParams;", "Lcom/obric/capabilitykit/common/intent/IntentParams;", "Landroid/os/Parcelable;", "action", "", "doraBluetoothId", "doraProductId", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAction", "()Ljava/lang/String;", "setAction", "(Ljava/lang/String;)V", "getDoraBluetoothId$annotations", "()V", "getDoraBluetoothId", "setDoraBluetoothId", "getDoraProductId$annotations", "getDoraProductId", "setDoraProductId", "component1", "component2", "component3", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "isParamsCompleted", "mergeParams", TrackerImpl.PARAMS, "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "intentcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class RecorderOperateParams implements Parcelable, IntentParams {
    public static final Parcelable.Creator<RecorderOperateParams> CREATOR = null;
    private String action;
    String doraBluetoothId;
    String doraProductId;

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<RecorderOperateParams> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final RecorderOperateParams createFromParcel(Parcel r10) {
            int r0 = r10.readInt();
            Intrinsics.checkNotNullParameter(r10, "parcel");
            RecorderOperateParams r1 = new RecorderOperateParams(r10.readString(), null, null, 6, null);
            int r3 = Math.min(r0, 2);
            ClassLoader r9 = getClass().getClassLoader();
            int r5 = 1;
        L3:
            if (r5 > r3) goto L14;
            if (r5 != 1) goto L9;
            Object r7 = a.b(r10, r9);
            if (r7 == null) goto L13;
            r1.doraBluetoothId = (String) ZeusTransformUtils.preCheckCast(r7, String.class, "com.obric.memorydata.plugin");
        L13:
            r5 = r5 + 1;
            goto L3
        L9:
            if (r5 != 2) goto L13;
            Object r8 = a.b(r10, r9);
            if (r8 == null) goto L13;
            r1.doraProductId = (String) ZeusTransformUtils.preCheckCast(r8, String.class, "com.obric.memorydata.plugin");
        L14:
            if (r5 > r0) goto L16;
            a.a(r10, r9);
            r5 = r5 + 1;
            goto L14
        L16:
            return r1;
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ RecorderOperateParams createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final RecorderOperateParams[] newArray(int r1) {
            return new RecorderOperateParams[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ RecorderOperateParams[] newArray(int r1) {
            return newArray(r1);
        }
    }

    static {
        CREATOR = (Parcelable.Creator) ZeusTransformUtils.preCheckCast(new Creator(), Parcelable.Creator.class, "com.obric.memorydata.plugin");
    }

    public RecorderOperateParams() {
        this(null, null, null, 7, null);
    }

    public RecorderOperateParams(String r1, String r2, String r3) {
        this.action = r1;
        this.doraBluetoothId = r2;
        this.doraProductId = r3;
    }

    public /* synthetic */ RecorderOperateParams(String r2, String r3, String r4, int r5, DefaultConstructorMarker r6) {
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

    public static /* synthetic */ RecorderOperateParams copy$default(RecorderOperateParams r0, String r1, String r2, String r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.action;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.doraBluetoothId;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.doraProductId;
    L12:
        return r0.copy(r1, r2, r3);
    }

    public static /* synthetic */ void getDoraBluetoothId$annotations() {
    }

    public static /* synthetic */ void getDoraProductId$annotations() {
    }

    public final String component1() {
        return this.action;
    }

    public final String component2() {
        return this.doraBluetoothId;
    }

    public final String component3() {
        return this.doraProductId;
    }

    public final RecorderOperateParams copy(String r1, String r2, String r3) {
        return new RecorderOperateParams(r1, r2, r3);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, RecorderOperateParams.class) == true) goto L8;
        return false;
    L8:
        RecorderOperateParams r6 = (RecorderOperateParams) ZeusTransformUtils.preCheckCast(r5, RecorderOperateParams.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.action, r6.action) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.doraBluetoothId, r6.doraBluetoothId) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.doraProductId, r6.doraProductId) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final String getAction() {
        return this.action;
    }

    public final String getDoraBluetoothId() {
        return this.doraBluetoothId;
    }

    public final String getDoraProductId() {
        return this.doraProductId;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public String getSubActionValue() {
        return IntentParams.DefaultImpls.getSubActionValue(this);
    }

    public int hashCode() {
        String r0 = this.action;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.doraBluetoothId;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.doraProductId;
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

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public boolean isParamsCompleted() {
        if (this.action == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public IntentParams mergeParams(Object r5) {
        if (ZeusTransformUtils.instanceOf(r5, RecorderOperateParams.class) == true) goto L7;
        Object r4 = ZeusTransformUtils.preCheckCast(this, IntentParams.class, "com.obric.memorydata.plugin");
    L6:
        return (IntentParams) r4;
    L7:
        String r1 = this.action;
        if (r1 != null) goto L10;
        r1 = ((RecorderOperateParams) ZeusTransformUtils.preCheckCast(r5, RecorderOperateParams.class, "com.obric.memorydata.plugin")).action;
    L10:
        String r3 = this.doraBluetoothId;
        if (r3 != null) goto L13;
        r3 = ((RecorderOperateParams) ZeusTransformUtils.preCheckCast(r5, RecorderOperateParams.class, "com.obric.memorydata.plugin")).doraBluetoothId;
    L13:
        String r6 = this.doraProductId;
        if (r6 != null) goto L16;
        r6 = ((RecorderOperateParams) ZeusTransformUtils.preCheckCast(r5, RecorderOperateParams.class, "com.obric.memorydata.plugin")).doraProductId;
    L16:
        r4 = ZeusTransformUtils.preCheckCast(new RecorderOperateParams(r1, r3, r6), IntentParams.class, "com.obric.memorydata.plugin");
        goto L6
    }

    public final void setAction(String r1) {
        this.action = r1;
    }

    public final void setDoraBluetoothId(String r1) {
        this.doraBluetoothId = r1;
    }

    public final void setDoraProductId(String r1) {
        this.doraProductId = r1;
    }

    public String toString() {
        return "RecorderOperateParams(action=" + this.action + ", doraBluetoothId=" + this.doraBluetoothId + ", doraProductId=" + this.doraProductId + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r1, int r2) {
        r1.writeInt(2);
        Intrinsics.checkNotNullParameter(r1, "out");
        r1.writeString(this.action);
        r1.writeValue(this.doraBluetoothId);
        r1.writeValue(this.doraProductId);
    }
}
