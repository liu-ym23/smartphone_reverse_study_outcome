package com.obric.capabilitykit.common.intent;

import android.os.Parcel;
import android.os.Parcelable;
import com.obric.b.a;
import com.obric.capabilitykit.common.execution.urishare.IUriSharableParams;
import com.obric.capabilitykit.entity.app.PhotoEntity;
import com.obric.memorydata.middleware.impl.bdtracker.TrackerImpl;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B#\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\u0016\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0010J\u0010\u0010\u0015\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u000bJ,\u0010\u0016\u001a\u00020\u00002\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0002\u0010\u0017J\t\u0010\u0018\u001a\u00020\bHÖ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cHÖ\u0003J\u0010\u0010\u001d\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001c0\u001eH\u0016J\t\u0010\u001f\u001a\u00020\bHÖ\u0001J\b\u0010 \u001a\u00020\u001aH\u0016J\u0012\u0010!\u001a\u00020\u00012\b\u0010\"\u001a\u0004\u0018\u00010\u001cH\u0016J\t\u0010#\u001a\u00020$HÖ\u0001J\u0019\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020\bHÖ\u0001R\u001e\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u000e\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR$\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0013\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006*"}, d2 = {"Lcom/obric/capabilitykit/common/intent/PhotoShowPhotoParams;", "Lcom/obric/capabilitykit/common/intent/IntentParams;", "Landroid/os/Parcelable;", "Lcom/obric/capabilitykit/common/execution/urishare/IUriSharableParams;", "targets", "", "Lcom/obric/capabilitykit/entity/app/PhotoEntity;", "index", "", "([Lcom/obric/capabilitykit/entity/app/PhotoEntity;Ljava/lang/Integer;)V", "getIndex", "()Ljava/lang/Integer;", "setIndex", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getTargets", "()[Lcom/obric/capabilitykit/entity/app/PhotoEntity;", "setTargets", "([Lcom/obric/capabilitykit/entity/app/PhotoEntity;)V", "[Lcom/obric/capabilitykit/entity/app/PhotoEntity;", "component1", "component2", "copy", "([Lcom/obric/capabilitykit/entity/app/PhotoEntity;Ljava/lang/Integer;)Lcom/obric/capabilitykit/common/intent/PhotoShowPhotoParams;", "describeContents", "equals", "", "other", "", "getUriSharableParams", "", "hashCode", "isParamsCompleted", "mergeParams", TrackerImpl.PARAMS, "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "intentcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class PhotoShowPhotoParams implements Parcelable, IUriSharableParams, IntentParams {
    public static final Parcelable.Creator<PhotoShowPhotoParams> CREATOR = null;
    private Integer index;
    private PhotoEntity[] targets;

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<PhotoShowPhotoParams> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final PhotoShowPhotoParams createFromParcel(Parcel r10) {
            int r0 = r10.readInt();
            Intrinsics.checkNotNullParameter(r10, "parcel");
            Integer r2 = null;
            if (r10.readInt() != 0) goto L5;
            PhotoEntity[] r4 = null;
        L9:
            if (r10.readInt() == 0) goto L12;
            r2 = Integer.valueOf(r10.readInt());
        L12:
            PhotoShowPhotoParams r1 = new PhotoShowPhotoParams(r4, r2);
            int r3 = Math.min(r0, 0);
            ClassLoader r9 = getClass().getClassLoader();
            int r5 = 1;
        L13:
            if (r5 > r3) goto L15;
            r5 = r5 + 1;
        L15:
            if (r5 > r0) goto L17;
            a.a(r10, r9);
            r5 = r5 + 1;
            goto L15
        L17:
            return r1;
        L5:
            int r6 = r10.readInt();
            r4 = new PhotoEntity[r6];
            int r7 = 0;
        L6:
            if (r7 == r6) goto L9;
            r4[r7] = (PhotoEntity) ZeusTransformUtils.preCheckCast(r10.readParcelable(PhotoShowPhotoParams.class.getClassLoader()), PhotoEntity.class, "com.obric.memorydata.plugin");
            r7 = r7 + 1;
            goto L6
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ PhotoShowPhotoParams createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final PhotoShowPhotoParams[] newArray(int r1) {
            return new PhotoShowPhotoParams[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ PhotoShowPhotoParams[] newArray(int r1) {
            return newArray(r1);
        }
    }

    static {
        CREATOR = (Parcelable.Creator) ZeusTransformUtils.preCheckCast(new Creator(), Parcelable.Creator.class, "com.obric.memorydata.plugin");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public PhotoShowPhotoParams() {
        Object[] r0 = 0 == true ? 1 : 0;
        this(null, r0, 3, 0 == true ? 1 : 0);
    }

    public PhotoShowPhotoParams(PhotoEntity[] r1, Integer r2) {
        this.targets = r1;
        this.index = r2;
    }

    public /* synthetic */ PhotoShowPhotoParams(PhotoEntity[] r2, Integer r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 2) == 0) goto L8;
        r3 = null;
    L8:
        this(r2, r3);
    }

    public static /* synthetic */ PhotoShowPhotoParams copy$default(PhotoShowPhotoParams r0, PhotoEntity[] r1, Integer r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.targets;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.index;
    L9:
        return r0.copy(r1, r2);
    }

    public final PhotoEntity[] component1() {
        return this.targets;
    }

    public final Integer component2() {
        return this.index;
    }

    public final PhotoShowPhotoParams copy(PhotoEntity[] r1, Integer r2) {
        return new PhotoShowPhotoParams(r1, r2);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, PhotoShowPhotoParams.class) == true) goto L8;
        return false;
    L8:
        PhotoShowPhotoParams r6 = (PhotoShowPhotoParams) ZeusTransformUtils.preCheckCast(r5, PhotoShowPhotoParams.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.targets, r6.targets) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.index, r6.index) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final Integer getIndex() {
        return this.index;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public String getSubActionValue() {
        return IntentParams.DefaultImpls.getSubActionValue(this);
    }

    public final PhotoEntity[] getTargets() {
        return this.targets;
    }

    @Override // com.obric.capabilitykit.common.execution.urishare.IUriSharableParams
    public List<Object> getUriSharableParams() {
        return CollectionsKt.listOf(this.targets);
    }

    public int hashCode() {
        PhotoEntity[] r0 = this.targets;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        Integer r4 = this.index;
        if (r4 == null) goto L11;
        r1 = r4.hashCode();
    L11:
        return r3 + r1;
    L5:
        r2 = Arrays.hashCode(r0);
        goto L6
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
        if (ZeusTransformUtils.instanceOf(r4, PhotoShowPhotoParams.class) == true) goto L7;
        Object r3 = ZeusTransformUtils.preCheckCast(this, IntentParams.class, "com.obric.memorydata.plugin");
    L6:
        return (IntentParams) r3;
    L7:
        PhotoEntity[] r1 = this.targets;
        if (r1 != null) goto L10;
        r1 = ((PhotoShowPhotoParams) ZeusTransformUtils.preCheckCast(r4, PhotoShowPhotoParams.class, "com.obric.memorydata.plugin")).targets;
    L10:
        Integer r5 = this.index;
        if (r5 != null) goto L13;
        r5 = ((PhotoShowPhotoParams) ZeusTransformUtils.preCheckCast(r4, PhotoShowPhotoParams.class, "com.obric.memorydata.plugin")).index;
    L13:
        r3 = ZeusTransformUtils.preCheckCast(new PhotoShowPhotoParams(r1, r5), IntentParams.class, "com.obric.memorydata.plugin");
        goto L6
    }

    public final void setIndex(Integer r1) {
        this.index = r1;
    }

    public final void setTargets(PhotoEntity[] r1) {
        this.targets = r1;
    }

    public String toString() {
        return "PhotoShowPhotoParams(targets=" + Arrays.toString(this.targets) + ", index=" + this.index + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r9, int r10) {
        r9.writeInt(0);
        Intrinsics.checkNotNullParameter(r9, "out");
        PhotoEntity[] r1 = this.targets;
        if (r1 != null) goto L5;
        r9.writeInt(0);
    L8:
        Integer r8 = this.index;
        if (r8 != null) goto L11;
        r9.writeInt(0);
        return;
    L11:
        r9.writeInt(1);
        r9.writeInt(r8.intValue());
        return;
    L5:
        r9.writeInt(1);
        int r3 = r1.length;
        r9.writeInt(r3);
        int r4 = 0;
    L6:
        if (r4 == r3) goto L8;
        r9.writeParcelable((Parcelable) ZeusTransformUtils.preCheckCast(r1[r4], Parcelable.class, "com.obric.memorydata.plugin"), r10);
        r4 = r4 + 1;
        goto L6
    }
}
