package com.obric.capabilitykit.common.intent;

import android.os.Parcel;
import android.os.Parcelable;
import com.obric.b.a;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.memorydata.middleware.impl.bdtracker.TrackerImpl;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002B#\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006¢\u0006\u0002\u0010\bJ\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0002\u0010\u000fJ\u0016\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\nJ,\u0010\u0015\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010\u0016J\t\u0010\u0017\u001a\u00020\u0004HÖ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bHÖ\u0003J\t\u0010\u001c\u001a\u00020\u0004HÖ\u0001J\u0012\u0010\u001d\u001a\u00020\u00012\b\u0010\u001e\u001a\u0004\u0018\u00010\u001bH\u0016J\t\u0010\u001f\u001a\u00020 HÖ\u0001J\u0019\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u0004HÖ\u0001R$\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\r\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001e\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0012\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006&"}, d2 = {"Lcom/obric/capabilitykit/common/intent/CommonViewEntitiesParams;", "Lcom/obric/capabilitykit/common/intent/IntentParams;", "Landroid/os/Parcelable;", "index", "", "entities", "", "Lcom/obric/capabilitykit/entity/app/AppEntity;", "(Ljava/lang/Integer;[Lcom/obric/capabilitykit/entity/app/AppEntity;)V", "getEntities", "()[Lcom/obric/capabilitykit/entity/app/AppEntity;", "setEntities", "([Lcom/obric/capabilitykit/entity/app/AppEntity;)V", "[Lcom/obric/capabilitykit/entity/app/AppEntity;", "getIndex", "()Ljava/lang/Integer;", "setIndex", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "component1", "component2", "copy", "(Ljava/lang/Integer;[Lcom/obric/capabilitykit/entity/app/AppEntity;)Lcom/obric/capabilitykit/common/intent/CommonViewEntitiesParams;", "describeContents", "equals", "", "other", "", "hashCode", "mergeParams", TrackerImpl.PARAMS, "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "intentcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class CommonViewEntitiesParams implements Parcelable, IntentParams {
    public static final Parcelable.Creator<CommonViewEntitiesParams> CREATOR = null;
    private AppEntity[] entities;
    private Integer index;

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<CommonViewEntitiesParams> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final CommonViewEntitiesParams createFromParcel(Parcel r10) {
            int r0 = r10.readInt();
            Intrinsics.checkNotNullParameter(r10, "parcel");
            AppEntity[] r2 = null;
            if (r10.readInt() != 0) goto L5;
            Integer r1 = null;
        L7:
            if (r10.readInt() == 0) goto L13;
            int r3 = r10.readInt();
            AppEntity[] r4 = new AppEntity[r3];
            int r5 = 0;
        L10:
            if (r5 == r3) goto L12;
            r4[r5] = (AppEntity) ZeusTransformUtils.preCheckCast(r10.readParcelable(CommonViewEntitiesParams.class.getClassLoader()), AppEntity.class, "com.obric.memorydata.plugin");
            r5 = r5 + 1;
            goto L10
        L12:
            r2 = r4;
        L13:
            CommonViewEntitiesParams r6 = new CommonViewEntitiesParams(r1, r2);
            int r7 = Math.min(r0, 0);
            ClassLoader r9 = getClass().getClassLoader();
            int r8 = 1;
        L14:
            if (r8 > r7) goto L16;
            r8 = r8 + 1;
        L16:
            if (r8 > r0) goto L18;
            a.a(r10, r9);
            r8 = r8 + 1;
            goto L16
        L18:
            return r6;
        L5:
            r1 = Integer.valueOf(r10.readInt());
            goto L7
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ CommonViewEntitiesParams createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final CommonViewEntitiesParams[] newArray(int r1) {
            return new CommonViewEntitiesParams[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ CommonViewEntitiesParams[] newArray(int r1) {
            return newArray(r1);
        }
    }

    static {
        CREATOR = (Parcelable.Creator) ZeusTransformUtils.preCheckCast(new Creator(), Parcelable.Creator.class, "com.obric.memorydata.plugin");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public CommonViewEntitiesParams() {
        Object[] r0 = 0 == true ? 1 : 0;
        this(null, r0, 3, 0 == true ? 1 : 0);
    }

    public CommonViewEntitiesParams(Integer r1, AppEntity[] r2) {
        this.index = r1;
        this.entities = r2;
    }

    public /* synthetic */ CommonViewEntitiesParams(Integer r2, AppEntity[] r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 2) == 0) goto L8;
        r3 = null;
    L8:
        this(r2, r3);
    }

    public static /* synthetic */ CommonViewEntitiesParams copy$default(CommonViewEntitiesParams r0, Integer r1, AppEntity[] r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.index;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.entities;
    L9:
        return r0.copy(r1, r2);
    }

    public final Integer component1() {
        return this.index;
    }

    public final AppEntity[] component2() {
        return this.entities;
    }

    public final CommonViewEntitiesParams copy(Integer r1, AppEntity[] r2) {
        return new CommonViewEntitiesParams(r1, r2);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, CommonViewEntitiesParams.class) == true) goto L8;
        return false;
    L8:
        CommonViewEntitiesParams r6 = (CommonViewEntitiesParams) ZeusTransformUtils.preCheckCast(r5, CommonViewEntitiesParams.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.index, r6.index) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.entities, r6.entities) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final AppEntity[] getEntities() {
        return this.entities;
    }

    public final Integer getIndex() {
        return this.index;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public String getSubActionValue() {
        return IntentParams.DefaultImpls.getSubActionValue(this);
    }

    public int hashCode() {
        Integer r0 = this.index;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        AppEntity[] r4 = this.entities;
        if (r4 == null) goto L11;
        r1 = Arrays.hashCode(r4);
    L11:
        return r3 + r1;
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public boolean isParamsCompleted() {
        return IntentParams.DefaultImpls.isParamsCompleted(this);
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public IntentParams mergeParams(Object r4) {
        if (ZeusTransformUtils.instanceOf(r4, CommonViewEntitiesParams.class) == true) goto L7;
        Object r3 = ZeusTransformUtils.preCheckCast(this, IntentParams.class, "com.obric.memorydata.plugin");
    L6:
        return (IntentParams) r3;
    L7:
        Integer r1 = this.index;
        if (r1 != null) goto L10;
        r1 = ((CommonViewEntitiesParams) ZeusTransformUtils.preCheckCast(r4, CommonViewEntitiesParams.class, "com.obric.memorydata.plugin")).index;
    L10:
        AppEntity[] r5 = this.entities;
        if (r5 != null) goto L13;
        r5 = ((CommonViewEntitiesParams) ZeusTransformUtils.preCheckCast(r4, CommonViewEntitiesParams.class, "com.obric.memorydata.plugin")).entities;
    L13:
        r3 = ZeusTransformUtils.preCheckCast(new CommonViewEntitiesParams(r1, r5), IntentParams.class, "com.obric.memorydata.plugin");
        goto L6
    }

    public final void setEntities(AppEntity[] r1) {
        this.entities = r1;
    }

    public final void setIndex(Integer r1) {
        this.index = r1;
    }

    public String toString() {
        return "CommonViewEntitiesParams(index=" + this.index + ", entities=" + Arrays.toString(this.entities) + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r6, int r7) {
        int r0 = 0;
        r6.writeInt(0);
        Intrinsics.checkNotNullParameter(r6, "out");
        Integer r1 = this.index;
        if (r1 != null) goto L5;
        r6.writeInt(0);
    L6:
        AppEntity[] r5 = this.entities;
        if (r5 != null) goto L9;
        r6.writeInt(0);
        return;
    L9:
        r6.writeInt(1);
        int r2 = r5.length;
        r6.writeInt(r2);
    L10:
        if (r0 == r2) goto L14;
        r6.writeParcelable((Parcelable) ZeusTransformUtils.preCheckCast(r5[r0], Parcelable.class, "com.obric.memorydata.plugin"), r7);
        r0 = r0 + 1;
        goto L10
    L14:
        return;
    L5:
        r6.writeInt(1);
        r6.writeInt(r1.intValue());
        goto L6
    }
}
