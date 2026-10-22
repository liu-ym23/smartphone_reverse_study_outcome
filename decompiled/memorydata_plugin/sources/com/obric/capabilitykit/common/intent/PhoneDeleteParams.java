package com.obric.capabilitykit.common.intent;

import android.os.Parcel;
import android.os.Parcelable;
import com.obric.b.a;
import com.obric.capabilitykit.entity.app.CallHistoryEntity;
import com.obric.memorydata.middleware.impl.bdtracker.TrackerImpl;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\u0012\u0010\b\u0002\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004¢\u0006\u0002\u0010\u0006J\u0016\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004HÆ\u0003¢\u0006\u0002\u0010\bJ \u0010\f\u001a\u00020\u00002\u0010\b\u0002\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004HÆ\u0001¢\u0006\u0002\u0010\rJ\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u000fHÖ\u0001J\b\u0010\u0015\u001a\u00020\u0011H\u0016J\u0012\u0010\u0016\u001a\u00020\u00012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0013H\u0016J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\u0019\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u000fHÖ\u0001R$\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\u0006¨\u0006\u001f"}, d2 = {"Lcom/obric/capabilitykit/common/intent/PhoneDeleteParams;", "Lcom/obric/capabilitykit/common/intent/IntentParams;", "Landroid/os/Parcelable;", "targets", "", "Lcom/obric/capabilitykit/entity/app/CallHistoryEntity;", "([Lcom/obric/capabilitykit/entity/app/CallHistoryEntity;)V", "getTargets", "()[Lcom/obric/capabilitykit/entity/app/CallHistoryEntity;", "setTargets", "[Lcom/obric/capabilitykit/entity/app/CallHistoryEntity;", "component1", "copy", "([Lcom/obric/capabilitykit/entity/app/CallHistoryEntity;)Lcom/obric/capabilitykit/common/intent/PhoneDeleteParams;", "describeContents", "", "equals", "", "other", "", "hashCode", "isParamsCompleted", "mergeParams", TrackerImpl.PARAMS, "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "intentcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class PhoneDeleteParams implements Parcelable, IntentParams {
    public static final Parcelable.Creator<PhoneDeleteParams> CREATOR = null;
    private CallHistoryEntity[] targets;

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<PhoneDeleteParams> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final PhoneDeleteParams createFromParcel(Parcel r9) {
            int r0 = r9.readInt();
            Intrinsics.checkNotNullParameter(r9, "parcel");
            if (r9.readInt() != 0) goto L5;
            CallHistoryEntity[] r1 = null;
        L9:
            PhoneDeleteParams r3 = new PhoneDeleteParams(r1);
            int r2 = Math.min(r0, 0);
            ClassLoader r8 = getClass().getClassLoader();
            int r4 = 1;
        L10:
            if (r4 > r2) goto L12;
            r4 = r4 + 1;
        L12:
            if (r4 > r0) goto L14;
            a.a(r9, r8);
            r4 = r4 + 1;
            goto L12
        L14:
            return r3;
        L5:
            int r5 = r9.readInt();
            CallHistoryEntity[] r6 = new CallHistoryEntity[r5];
            int r7 = 0;
        L6:
            if (r7 == r5) goto L8;
            r6[r7] = (CallHistoryEntity) ZeusTransformUtils.preCheckCast(r9.readParcelable(PhoneDeleteParams.class.getClassLoader()), CallHistoryEntity.class, "com.obric.memorydata.plugin");
            r7 = r7 + 1;
            goto L6
        L8:
            r1 = r6;
            goto L9
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ PhoneDeleteParams createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final PhoneDeleteParams[] newArray(int r1) {
            return new PhoneDeleteParams[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ PhoneDeleteParams[] newArray(int r1) {
            return newArray(r1);
        }
    }

    static {
        CREATOR = (Parcelable.Creator) ZeusTransformUtils.preCheckCast(new Creator(), Parcelable.Creator.class, "com.obric.memorydata.plugin");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public PhoneDeleteParams() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public PhoneDeleteParams(CallHistoryEntity[] r1) {
        this.targets = r1;
    }

    public /* synthetic */ PhoneDeleteParams(CallHistoryEntity[] r1, int r2, DefaultConstructorMarker r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = null;
    L5:
        this(r1);
    }

    public static /* synthetic */ PhoneDeleteParams copy$default(PhoneDeleteParams r0, CallHistoryEntity[] r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = r0.targets;
    L6:
        return r0.copy(r1);
    }

    public final CallHistoryEntity[] component1() {
        return this.targets;
    }

    public final PhoneDeleteParams copy(CallHistoryEntity[] r1) {
        return new PhoneDeleteParams(r1);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, PhoneDeleteParams.class) == true) goto L8;
        return false;
    L8:
        PhoneDeleteParams r6 = (PhoneDeleteParams) ZeusTransformUtils.preCheckCast(r5, PhoneDeleteParams.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.targets, r6.targets) == true) goto L11;
        return false;
    L11:
        return true;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public String getSubActionValue() {
        return IntentParams.DefaultImpls.getSubActionValue(this);
    }

    public final CallHistoryEntity[] getTargets() {
        return this.targets;
    }

    public int hashCode() {
        CallHistoryEntity[] r0 = this.targets;
        if (r0 != null) goto L6;
        return 0;
    L6:
        return Arrays.hashCode(r0);
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public boolean isParamsCompleted() {
        if (this.targets == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public IntentParams mergeParams(Object r4) {
        if (ZeusTransformUtils.instanceOf(r4, PhoneDeleteParams.class) == true) goto L7;
        Object r3 = ZeusTransformUtils.preCheckCast(this, IntentParams.class, "com.obric.memorydata.plugin");
    L6:
        return (IntentParams) r3;
    L7:
        CallHistoryEntity[] r5 = this.targets;
        if (r5 != null) goto L10;
        r5 = ((PhoneDeleteParams) ZeusTransformUtils.preCheckCast(r4, PhoneDeleteParams.class, "com.obric.memorydata.plugin")).targets;
    L10:
        r3 = ZeusTransformUtils.preCheckCast(new PhoneDeleteParams(r5), IntentParams.class, "com.obric.memorydata.plugin");
        goto L6
    }

    public final void setTargets(CallHistoryEntity[] r1) {
        this.targets = r1;
    }

    public String toString() {
        return "PhoneDeleteParams(targets=" + Arrays.toString(this.targets) + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r6, int r7) {
        int r0 = 0;
        r6.writeInt(0);
        Intrinsics.checkNotNullParameter(r6, "out");
        CallHistoryEntity[] r5 = this.targets;
        if (r5 != null) goto L5;
        r6.writeInt(0);
        return;
    L5:
        r6.writeInt(1);
        int r1 = r5.length;
        r6.writeInt(r1);
    L6:
        if (r0 == r1) goto L10;
        r6.writeParcelable((Parcelable) ZeusTransformUtils.preCheckCast(r5[r0], Parcelable.class, "com.obric.memorydata.plugin"), r7);
        r0 = r0 + 1;
        goto L6
    }
}
