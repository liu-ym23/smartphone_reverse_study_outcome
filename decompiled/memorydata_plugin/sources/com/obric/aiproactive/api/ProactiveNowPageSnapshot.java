package com.obric.aiproactive.api;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.apm6.consumer.slardar.Constants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 $2\u00020\u0001:\u0001$B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0004\b\t\u0010\nB\u0011\b\u0016\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0004\b\t\u0010\rJ\u0018\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\b\u0010\u0019\u001a\u00020\u0018H\u0016J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0005HÆ\u0003J\u000f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003J-\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0001J\u0013\u0010\u001e\u001a\u00020\u00052\b\u0010\u001f\u001a\u0004\u0018\u00010 HÖ\u0003J\t\u0010!\u001a\u00020\u0018HÖ\u0001J\t\u0010\"\u001a\u00020#HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006%"}, d2 = {"Lcom/obric/aiproactive/api/ProactiveNowPageSnapshot;", "Landroid/os/Parcelable;", "batchId", "", "hasNext", "", Constants.KEY_LIST, "", "Lcom/obric/aiproactive/api/ProactiveRecommendationDto;", "<init>", "(JZLjava/util/List;)V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "getBatchId", "()J", "getHasNext", "()Z", "getList", "()Ljava/util/List;", "writeToParcel", "", "dest", "flags", "", "describeContents", "component1", "component2", "component3", "copy", "equals", "other", "", "hashCode", "toString", "", "CREATOR", "ai_proactive_api_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ProactiveNowPageSnapshot implements Parcelable {
    public static final a CREATOR = null;
    private final long batchId;
    private final boolean hasNext;
    private final List<ProactiveRecommendationDto> list;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u001d\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016¢\u0006\u0002\u0010\f¨\u0006\r"}, d2 = {"Lcom/obric/aiproactive/api/ProactiveNowPageSnapshot$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/obric/aiproactive/api/ProactiveNowPageSnapshot;", "<init>", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/obric/aiproactive/api/ProactiveNowPageSnapshot;", "ai_proactive_api_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a implements Parcelable.Creator<ProactiveNowPageSnapshot> {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }

        public ProactiveNowPageSnapshot a(Parcel r1) {
            Intrinsics.checkNotNullParameter(r1, "parcel");
            return new ProactiveNowPageSnapshot(r1);
        }

        public ProactiveNowPageSnapshot[] a(int r1) {
            return new ProactiveNowPageSnapshot[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* synthetic */ ProactiveNowPageSnapshot createFromParcel(Parcel r1) {
            return a(r1);
        }

        @Override // android.os.Parcelable.Creator
        public /* synthetic */ ProactiveNowPageSnapshot[] newArray(int r1) {
            return a(r1);
        }
    }

    static {
        CREATOR = new a(null);
    }

    public ProactiveNowPageSnapshot(long r3, boolean r5, List<ProactiveRecommendationDto> r6) {
        List<ProactiveRecommendationDto> r7 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r7, Constants.KEY_LIST);
        this.batchId = r3;
        this.hasNext = r5;
        this.list = r7;
    }

    public ProactiveNowPageSnapshot(Parcel r8) {
        Intrinsics.checkNotNullParameter(r8, "parcel");
        long r0 = r8.readLong();
        int r3 = 0;
        if (r8.readInt() == 0) goto L5;
        boolean r2 = true;
    L6:
        List r4 = CollectionsKt.createListBuilder();
        int r5 = r8.readInt();
    L7:
        if (r3 >= r5) goto L9;
        r4.add(ProactiveRecommendationDto.CREATOR.a(r8));
        r3 = r3 + 1;
        goto L7
    L9:
        Unit r9 = Unit.INSTANCE;
        this(r0, r2, CollectionsKt.build(r4));
        return;
    L5:
        r2 = false;
        goto L6
    }

    public static /* synthetic */ ProactiveNowPageSnapshot copy$default(ProactiveNowPageSnapshot r1, long r2, boolean r4, List r5, int r6, Object r7) {
        List<ProactiveRecommendationDto> r8 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        if ((r6 & 1) == 0) goto L6;
        r2 = r1.batchId;
    L6:
        if ((r6 & 2) == 0) goto L9;
        r4 = r1.hasNext;
    L9:
        if ((r6 & 4) == 0) goto L12;
        r8 = r1.list;
    L12:
        return r1.copy(r2, r4, r8);
    }

    public final long component1() {
        return this.batchId;
    }

    public final boolean component2() {
        return this.hasNext;
    }

    public final List<ProactiveRecommendationDto> component3() {
        return this.list;
    }

    public final ProactiveNowPageSnapshot copy(long r2, boolean r4, List<ProactiveRecommendationDto> r5) {
        List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, Constants.KEY_LIST);
        return new ProactiveNowPageSnapshot(r2, r4, r1);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, ProactiveNowPageSnapshot.class) == true) goto L8;
        return false;
    L8:
        ProactiveNowPageSnapshot r10 = (ProactiveNowPageSnapshot) ZeusTransformUtils.preCheckCast(r9, ProactiveNowPageSnapshot.class, "com.obric.memorydata.plugin");
        if (this.batchId == r10.batchId) goto L12;
        return false;
    L12:
        if (this.hasNext == r10.hasNext) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.list, r10.list) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final long getBatchId() {
        return this.batchId;
    }

    public final boolean getHasNext() {
        return this.hasNext;
    }

    public final List<ProactiveRecommendationDto> getList() {
        return this.list;
    }

    public int hashCode() {
        return (((Long.hashCode(this.batchId) * 31) + Boolean.hashCode(this.hasNext)) * 31) + this.list.hashCode();
    }

    public String toString() {
        return "ProactiveNowPageSnapshot(batchId=" + this.batchId + ", hasNext=" + this.hasNext + ", list=" + this.list + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r4, int r5) {
        Intrinsics.checkNotNullParameter(r4, "dest");
        r4.writeLong(this.batchId);
        r4.writeInt(this.hasNext ? 1 : 0);
        r4.writeInt(this.list.size());
        Iterator r3 = ((Iterable) ZeusTransformUtils.preCheckCast(this.list, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        ((ProactiveRecommendationDto) ZeusTransformUtils.preCheckCast(r3.next(), ProactiveRecommendationDto.class, "com.obric.memorydata.plugin")).writeToParcel(r4, r5);
        goto L4
    }
}
