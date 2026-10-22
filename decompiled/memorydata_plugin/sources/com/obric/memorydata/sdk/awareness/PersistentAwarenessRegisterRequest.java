package com.obric.memorydata.sdk.awareness;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0007HÆ\u0003J'\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0006\u0010\u0014\u001a\u00020\u0015J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0015HÖ\u0001J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001J\u0016\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u0015R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006!"}, d2 = {"Lcom/obric/memorydata/sdk/awareness/PersistentAwarenessRegisterRequest;", "Landroid/os/Parcelable;", "subscriptionId", "", TypedValues.AttributesType.S_TARGET, "Lcom/obric/memorydata/sdk/awareness/AwarenessTarget;", "condition", "Lcom/obric/memorydata/sdk/awareness/AwarenessConditionConfig;", "<init>", "(Ljava/lang/String;Lcom/obric/memorydata/sdk/awareness/AwarenessTarget;Lcom/obric/memorydata/sdk/awareness/AwarenessConditionConfig;)V", "getSubscriptionId", "()Ljava/lang/String;", "getTarget", "()Lcom/obric/memorydata/sdk/awareness/AwarenessTarget;", "getCondition", "()Lcom/obric/memorydata/sdk/awareness/AwarenessConditionConfig;", "component1", "component2", "component3", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "memoryDataSDK_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class PersistentAwarenessRegisterRequest implements Parcelable {
    public static final Parcelable.Creator<PersistentAwarenessRegisterRequest> CREATOR = null;
    private final AwarenessConditionConfig condition;
    private final String subscriptionId;
    private final AwarenessTarget target;

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class a implements Parcelable.Creator<PersistentAwarenessRegisterRequest> {
        public a() {
        }

        public final PersistentAwarenessRegisterRequest a(Parcel r5) {
            Intrinsics.checkNotNullParameter(r5, "parcel");
            return new PersistentAwarenessRegisterRequest(r5.readString(), (AwarenessTarget) ZeusTransformUtils.preCheckCast(AwarenessTarget.CREATOR.createFromParcel(r5), AwarenessTarget.class, "com.obric.memorydata.plugin"), (AwarenessConditionConfig) ZeusTransformUtils.preCheckCast(AwarenessConditionConfig.CREATOR.createFromParcel(r5), AwarenessConditionConfig.class, "com.obric.memorydata.plugin"));
        }

        public final PersistentAwarenessRegisterRequest[] a(int r1) {
            return new PersistentAwarenessRegisterRequest[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* synthetic */ PersistentAwarenessRegisterRequest createFromParcel(Parcel r1) {
            return a(r1);
        }

        @Override // android.os.Parcelable.Creator
        public /* synthetic */ PersistentAwarenessRegisterRequest[] newArray(int r1) {
            return a(r1);
        }
    }

    static {
        CREATOR = (Parcelable.Creator) ZeusTransformUtils.preCheckCast(new a(), Parcelable.Creator.class, "com.obric.memorydata.plugin");
    }

    public PersistentAwarenessRegisterRequest(String r2, AwarenessTarget r3, AwarenessConditionConfig r4) {
        Intrinsics.checkNotNullParameter(r2, "subscriptionId");
        Intrinsics.checkNotNullParameter(r3, TypedValues.AttributesType.S_TARGET);
        Intrinsics.checkNotNullParameter(r4, "condition");
        this.subscriptionId = r2;
        this.target = r3;
        this.condition = r4;
    }

    public /* synthetic */ PersistentAwarenessRegisterRequest(String r1, AwarenessTarget r2, AwarenessConditionConfig r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 4) == 0) goto L5;
        r3 = AwarenessConditionConfig.Companion.a();
    L5:
        this(r1, r2, r3);
    }

    public static /* synthetic */ PersistentAwarenessRegisterRequest copy$default(PersistentAwarenessRegisterRequest r0, String r1, AwarenessTarget r2, AwarenessConditionConfig r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.subscriptionId;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.target;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.condition;
    L12:
        return r0.copy(r1, r2, r3);
    }

    public final String component1() {
        return this.subscriptionId;
    }

    public final AwarenessTarget component2() {
        return this.target;
    }

    public final AwarenessConditionConfig component3() {
        return this.condition;
    }

    public final PersistentAwarenessRegisterRequest copy(String r1, AwarenessTarget r2, AwarenessConditionConfig r3) {
        Intrinsics.checkNotNullParameter(r1, "subscriptionId");
        Intrinsics.checkNotNullParameter(r2, TypedValues.AttributesType.S_TARGET);
        Intrinsics.checkNotNullParameter(r3, "condition");
        return new PersistentAwarenessRegisterRequest(r1, r2, r3);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, PersistentAwarenessRegisterRequest.class) == true) goto L8;
        return false;
    L8:
        PersistentAwarenessRegisterRequest r6 = (PersistentAwarenessRegisterRequest) ZeusTransformUtils.preCheckCast(r5, PersistentAwarenessRegisterRequest.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.subscriptionId, r6.subscriptionId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.target, r6.target) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.condition, r6.condition) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final AwarenessConditionConfig getCondition() {
        return this.condition;
    }

    public final String getSubscriptionId() {
        return this.subscriptionId;
    }

    public final AwarenessTarget getTarget() {
        return this.target;
    }

    public int hashCode() {
        return (((this.subscriptionId.hashCode() * 31) + this.target.hashCode()) * 31) + this.condition.hashCode();
    }

    public String toString() {
        return "PersistentAwarenessRegisterRequest(subscriptionId=" + this.subscriptionId + ", target=" + this.target + ", condition=" + this.condition + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "dest");
        r2.writeString(this.subscriptionId);
        this.target.writeToParcel(r2, r3);
        this.condition.writeToParcel(r2, r3);
    }
}
