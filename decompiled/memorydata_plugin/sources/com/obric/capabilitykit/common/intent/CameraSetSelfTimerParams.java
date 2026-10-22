package com.obric.capabilitykit.common.intent;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.obric.b.a;
import com.obric.memorydata.middleware.impl.bdtracker.TrackerImpl;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\n\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0002\u0010\u0007J\u001a\u0010\u000b\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004HÆ\u0001¢\u0006\u0002\u0010\fJ\t\u0010\r\u001a\u00020\u0004HÖ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0004HÖ\u0001J\u0012\u0010\u0013\u001a\u00020\u00012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0011H\u0016J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\u0019\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0004HÖ\u0001R\u001e\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0005¨\u0006\u001c"}, d2 = {"Lcom/obric/capabilitykit/common/intent/CameraSetSelfTimerParams;", "Lcom/obric/capabilitykit/common/intent/IntentParams;", "Landroid/os/Parcelable;", CommonConsts.TIMER_TYPE, "", "(Ljava/lang/Integer;)V", "getTimer", "()Ljava/lang/Integer;", "setTimer", "Ljava/lang/Integer;", "component1", "copy", "(Ljava/lang/Integer;)Lcom/obric/capabilitykit/common/intent/CameraSetSelfTimerParams;", "describeContents", "equals", "", "other", "", "hashCode", "mergeParams", TrackerImpl.PARAMS, "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "intentcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class CameraSetSelfTimerParams implements Parcelable, IntentParams {
    public static final Parcelable.Creator<CameraSetSelfTimerParams> CREATOR = null;
    private Integer timer;

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<CameraSetSelfTimerParams> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final CameraSetSelfTimerParams createFromParcel(Parcel r5) {
            int r0 = r5.readInt();
            Intrinsics.checkNotNullParameter(r5, "parcel");
            if (r5.readInt() != 0) goto L5;
            Integer r2 = null;
        L6:
            CameraSetSelfTimerParams r1 = new CameraSetSelfTimerParams(r2);
            int r3 = Math.min(r0, 0);
            ClassLoader r4 = getClass().getClassLoader();
            int r6 = 1;
        L7:
            if (r6 > r3) goto L9;
            r6 = r6 + 1;
        L9:
            if (r6 > r0) goto L11;
            a.a(r5, r4);
            r6 = r6 + 1;
            goto L9
        L11:
            return r1;
        L5:
            r2 = Integer.valueOf(r5.readInt());
            goto L6
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ CameraSetSelfTimerParams createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final CameraSetSelfTimerParams[] newArray(int r1) {
            return new CameraSetSelfTimerParams[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ CameraSetSelfTimerParams[] newArray(int r1) {
            return newArray(r1);
        }
    }

    static {
        CREATOR = (Parcelable.Creator) ZeusTransformUtils.preCheckCast(new Creator(), Parcelable.Creator.class, "com.obric.memorydata.plugin");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public CameraSetSelfTimerParams() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public CameraSetSelfTimerParams(Integer r1) {
        this.timer = r1;
    }

    public /* synthetic */ CameraSetSelfTimerParams(Integer r1, int r2, DefaultConstructorMarker r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = null;
    L5:
        this(r1);
    }

    public static /* synthetic */ CameraSetSelfTimerParams copy$default(CameraSetSelfTimerParams r0, Integer r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = r0.timer;
    L6:
        return r0.copy(r1);
    }

    public final Integer component1() {
        return this.timer;
    }

    public final CameraSetSelfTimerParams copy(Integer r1) {
        return new CameraSetSelfTimerParams(r1);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, CameraSetSelfTimerParams.class) == true) goto L8;
        return false;
    L8:
        CameraSetSelfTimerParams r6 = (CameraSetSelfTimerParams) ZeusTransformUtils.preCheckCast(r5, CameraSetSelfTimerParams.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.timer, r6.timer) == true) goto L11;
        return false;
    L11:
        return true;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public String getSubActionValue() {
        return IntentParams.DefaultImpls.getSubActionValue(this);
    }

    public final Integer getTimer() {
        return this.timer;
    }

    public int hashCode() {
        Integer r0 = this.timer;
        if (r0 != null) goto L6;
        return 0;
    L6:
        return r0.hashCode();
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public boolean isParamsCompleted() {
        return IntentParams.DefaultImpls.isParamsCompleted(this);
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public IntentParams mergeParams(Object r4) {
        if (ZeusTransformUtils.instanceOf(r4, CameraSetSelfTimerParams.class) == true) goto L7;
        Object r3 = ZeusTransformUtils.preCheckCast(this, IntentParams.class, "com.obric.memorydata.plugin");
    L6:
        return (IntentParams) r3;
    L7:
        Integer r5 = this.timer;
        if (r5 != null) goto L10;
        r5 = ((CameraSetSelfTimerParams) ZeusTransformUtils.preCheckCast(r4, CameraSetSelfTimerParams.class, "com.obric.memorydata.plugin")).timer;
    L10:
        r3 = ZeusTransformUtils.preCheckCast(new CameraSetSelfTimerParams(r5), IntentParams.class, "com.obric.memorydata.plugin");
        goto L6
    }

    public final void setTimer(Integer r1) {
        this.timer = r1;
    }

    public String toString() {
        return "CameraSetSelfTimerParams(timer=" + this.timer + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r2, int r3) {
        r2.writeInt(0);
        Intrinsics.checkNotNullParameter(r2, "out");
        Integer r1 = this.timer;
        if (r1 != null) goto L5;
        r2.writeInt(0);
        return;
    L5:
        r2.writeInt(1);
        r2.writeInt(r1.intValue());
    }
}
