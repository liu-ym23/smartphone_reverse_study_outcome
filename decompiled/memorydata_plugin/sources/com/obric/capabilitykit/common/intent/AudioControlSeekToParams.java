package com.obric.capabilitykit.common.intent;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.b.a;
import com.obric.memorydata.middleware.impl.bdtracker.TrackerImpl;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002B\u001d\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\tJ&\u0010\u0013\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010\u0014J\t\u0010\u0015\u001a\u00020\u0006HÖ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0006HÖ\u0001J\b\u0010\u001b\u001a\u00020\u0017H\u0016J\u0012\u0010\u001c\u001a\u00020\u00012\b\u0010\u001d\u001a\u0004\u0018\u00010\u0019H\u0016J\t\u0010\u001e\u001a\u00020\u0004HÖ\u0001J\u0019\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u0006HÖ\u0001R\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006$"}, d2 = {"Lcom/obric/capabilitykit/common/intent/AudioControlSeekToParams;", "Lcom/obric/capabilitykit/common/intent/IntentParams;", "Landroid/os/Parcelable;", "valueType", "", OaidModel.KEY_TIME, "", "(Ljava/lang/String;Ljava/lang/Integer;)V", "getTime", "()Ljava/lang/Integer;", "setTime", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getValueType", "()Ljava/lang/String;", "setValueType", "(Ljava/lang/String;)V", "component1", "component2", "copy", "(Ljava/lang/String;Ljava/lang/Integer;)Lcom/obric/capabilitykit/common/intent/AudioControlSeekToParams;", "describeContents", "equals", "", "other", "", "hashCode", "isParamsCompleted", "mergeParams", TrackerImpl.PARAMS, "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "intentcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class AudioControlSeekToParams implements Parcelable, IntentParams {
    public static final Parcelable.Creator<AudioControlSeekToParams> CREATOR = null;
    private Integer time;
    private String valueType;

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<AudioControlSeekToParams> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final AudioControlSeekToParams createFromParcel(Parcel r5) {
            int r0 = r5.readInt();
            Intrinsics.checkNotNullParameter(r5, "parcel");
            String r2 = r5.readString();
            if (r5.readInt() != 0) goto L5;
            Integer r3 = null;
        L6:
            AudioControlSeekToParams r1 = new AudioControlSeekToParams(r2, r3);
            int r4 = Math.min(r0, 0);
            ClassLoader r6 = getClass().getClassLoader();
            int r7 = 1;
        L7:
            if (r7 > r4) goto L9;
            r7 = r7 + 1;
        L9:
            if (r7 > r0) goto L11;
            a.a(r5, r6);
            r7 = r7 + 1;
            goto L9
        L11:
            return r1;
        L5:
            r3 = Integer.valueOf(r5.readInt());
            goto L6
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ AudioControlSeekToParams createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final AudioControlSeekToParams[] newArray(int r1) {
            return new AudioControlSeekToParams[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ AudioControlSeekToParams[] newArray(int r1) {
            return newArray(r1);
        }
    }

    static {
        CREATOR = (Parcelable.Creator) ZeusTransformUtils.preCheckCast(new Creator(), Parcelable.Creator.class, "com.obric.memorydata.plugin");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public AudioControlSeekToParams() {
        Object[] r0 = 0 == true ? 1 : 0;
        this(null, r0, 3, 0 == true ? 1 : 0);
    }

    public AudioControlSeekToParams(String r1, Integer r2) {
        this.valueType = r1;
        this.time = r2;
    }

    public /* synthetic */ AudioControlSeekToParams(String r2, Integer r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 2) == 0) goto L8;
        r3 = null;
    L8:
        this(r2, r3);
    }

    public static /* synthetic */ AudioControlSeekToParams copy$default(AudioControlSeekToParams r0, String r1, Integer r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.valueType;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.time;
    L9:
        return r0.copy(r1, r2);
    }

    public final String component1() {
        return this.valueType;
    }

    public final Integer component2() {
        return this.time;
    }

    public final AudioControlSeekToParams copy(String r1, Integer r2) {
        return new AudioControlSeekToParams(r1, r2);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, AudioControlSeekToParams.class) == true) goto L8;
        return false;
    L8:
        AudioControlSeekToParams r6 = (AudioControlSeekToParams) ZeusTransformUtils.preCheckCast(r5, AudioControlSeekToParams.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.valueType, r6.valueType) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.time, r6.time) == true) goto L14;
        return false;
    L14:
        return true;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public String getSubActionValue() {
        return IntentParams.DefaultImpls.getSubActionValue(this);
    }

    public final Integer getTime() {
        return this.time;
    }

    public final String getValueType() {
        return this.valueType;
    }

    public int hashCode() {
        String r0 = this.valueType;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        Integer r4 = this.time;
        if (r4 == null) goto L11;
        r1 = r4.hashCode();
    L11:
        return r3 + r1;
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public boolean isParamsCompleted() {
        if (this.valueType == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public IntentParams mergeParams(Object r4) {
        if (ZeusTransformUtils.instanceOf(r4, AudioControlSeekToParams.class) == true) goto L7;
        Object r3 = ZeusTransformUtils.preCheckCast(this, IntentParams.class, "com.obric.memorydata.plugin");
    L6:
        return (IntentParams) r3;
    L7:
        String r1 = this.valueType;
        if (r1 != null) goto L10;
        r1 = ((AudioControlSeekToParams) ZeusTransformUtils.preCheckCast(r4, AudioControlSeekToParams.class, "com.obric.memorydata.plugin")).valueType;
    L10:
        Integer r5 = this.time;
        if (r5 != null) goto L13;
        r5 = ((AudioControlSeekToParams) ZeusTransformUtils.preCheckCast(r4, AudioControlSeekToParams.class, "com.obric.memorydata.plugin")).time;
    L13:
        r3 = ZeusTransformUtils.preCheckCast(new AudioControlSeekToParams(r1, r5), IntentParams.class, "com.obric.memorydata.plugin");
        goto L6
    }

    public final void setTime(Integer r1) {
        this.time = r1;
    }

    public final void setValueType(String r1) {
        this.valueType = r1;
    }

    public String toString() {
        return "AudioControlSeekToParams(valueType=" + this.valueType + ", time=" + this.time + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r2, int r3) {
        r2.writeInt(0);
        Intrinsics.checkNotNullParameter(r2, "out");
        r2.writeString(this.valueType);
        Integer r1 = this.time;
        if (r1 != null) goto L5;
        r2.writeInt(0);
        return;
    L5:
        r2.writeInt(1);
        r2.writeInt(r1.intValue());
    }
}
