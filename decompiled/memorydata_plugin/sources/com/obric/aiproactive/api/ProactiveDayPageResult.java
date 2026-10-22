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
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0086\b\u0018\u0000 (2\u00020\u0001:\u0001(B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0004\b\u000b\u0010\fB\u0011\b\u0016\u0012\u0006\u0010\r\u001a\u00020\u000e¢\u0006\u0004\b\u000b\u0010\u000fJ\u0018\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u000e2\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\b\u0010\u001d\u001a\u00020\u001cH\u0016J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0005HÆ\u0003J\t\u0010 \u001a\u00020\u0007HÆ\u0003J\u000f\u0010!\u001a\b\u0012\u0004\u0012\u00020\n0\tHÆ\u0003J7\u0010\"\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tHÆ\u0001J\u0013\u0010#\u001a\u00020\u00072\b\u0010$\u001a\u0004\u0018\u00010%HÖ\u0003J\t\u0010&\u001a\u00020\u001cHÖ\u0001J\t\u0010'\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006)"}, d2 = {"Lcom/obric/aiproactive/api/ProactiveDayPageResult;", "Landroid/os/Parcelable;", "batchId", "", "dayKey", "", "hasNext", "", Constants.KEY_LIST, "", "Lcom/obric/aiproactive/api/ProactiveRecommendationDto;", "<init>", "(JLjava/lang/String;ZLjava/util/List;)V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "getBatchId", "()J", "getDayKey", "()Ljava/lang/String;", "getHasNext", "()Z", "getList", "()Ljava/util/List;", "writeToParcel", "", "dest", "flags", "", "describeContents", "component1", "component2", "component3", "component4", "copy", "equals", "other", "", "hashCode", "toString", "CREATOR", "ai_proactive_api_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ProactiveDayPageResult implements Parcelable {
    public static final a CREATOR = null;
    private final long batchId;
    private final String dayKey;
    private final boolean hasNext;
    private final List<ProactiveRecommendationDto> list;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u001d\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016¢\u0006\u0002\u0010\f¨\u0006\r"}, d2 = {"Lcom/obric/aiproactive/api/ProactiveDayPageResult$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/obric/aiproactive/api/ProactiveDayPageResult;", "<init>", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/obric/aiproactive/api/ProactiveDayPageResult;", "ai_proactive_api_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a implements Parcelable.Creator<ProactiveDayPageResult> {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }

        public ProactiveDayPageResult a(Parcel r1) {
            Intrinsics.checkNotNullParameter(r1, "parcel");
            return new ProactiveDayPageResult(r1);
        }

        public ProactiveDayPageResult[] a(int r1) {
            return new ProactiveDayPageResult[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* synthetic */ ProactiveDayPageResult createFromParcel(Parcel r1) {
            return a(r1);
        }

        @Override // android.os.Parcelable.Creator
        public /* synthetic */ ProactiveDayPageResult[] newArray(int r1) {
            return a(r1);
        }
    }

    static {
        CREATOR = new a(null);
    }

    public ProactiveDayPageResult(long r3, String r5, boolean r6, List<ProactiveRecommendationDto> r7) {
        List<ProactiveRecommendationDto> r8 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "dayKey");
        Intrinsics.checkNotNullParameter(r8, Constants.KEY_LIST);
        this.batchId = r3;
        this.dayKey = r5;
        this.hasNext = r6;
        this.list = r8;
    }

    public ProactiveDayPageResult(Parcel r9) {
        Intrinsics.checkNotNullParameter(r9, "parcel");
        long r2 = r9.readLong();
        String r0 = r9.readString();
        if (r0 != null) goto L5;
        r0 = "";
    L5:
        String r4 = r0;
        int r1 = 0;
        if (r9.readInt() == 0) goto L8;
        boolean r5 = true;
    L9:
        List r3 = CollectionsKt.createListBuilder();
        int r6 = r9.readInt();
    L10:
        if (r1 >= r6) goto L12;
        r3.add(ProactiveRecommendationDto.CREATOR.a(r9));
        r1 = r1 + 1;
        goto L10
    L12:
        Unit r10 = Unit.INSTANCE;
        this(r2, r4, r5, CollectionsKt.build(r3));
        return;
    L8:
        r5 = false;
        goto L9
    }

    public static /* synthetic */ ProactiveDayPageResult copy$default(ProactiveDayPageResult r6, long r7, String r9, boolean r10, List r11, int r12, Object r13) {
        List<ProactiveRecommendationDto> r14 = (List) ZeusTransformUtils.wrapperContextForParams(r11, List.class, "com.obric.memorydata.plugin");
        if ((r12 & 1) == 0) goto L5;
        r7 = r6.batchId;
    L5:
        long r1 = r7;
        if ((r12 & 2) == 0) goto L8;
        r9 = r6.dayKey;
    L8:
        String r3 = r9;
        if ((r12 & 4) == 0) goto L11;
        r10 = r6.hasNext;
    L11:
        boolean r4 = r10;
        if ((r12 & 8) == 0) goto L15;
        r14 = r6.list;
    L15:
        return r6.copy(r1, r3, r4, r14);
    }

    public final long component1() {
        return this.batchId;
    }

    public final String component2() {
        return this.dayKey;
    }

    public final boolean component3() {
        return this.hasNext;
    }

    public final List<ProactiveRecommendationDto> component4() {
        return this.list;
    }

    public final ProactiveDayPageResult copy(long r7, String r9, boolean r10, List<ProactiveRecommendationDto> r11) {
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r11, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r9, "dayKey");
        Intrinsics.checkNotNullParameter(r5, Constants.KEY_LIST);
        return new ProactiveDayPageResult(r7, r9, r10, r5);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, ProactiveDayPageResult.class) == true) goto L8;
        return false;
    L8:
        ProactiveDayPageResult r10 = (ProactiveDayPageResult) ZeusTransformUtils.preCheckCast(r9, ProactiveDayPageResult.class, "com.obric.memorydata.plugin");
        if (this.batchId == r10.batchId) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.dayKey, r10.dayKey) == true) goto L15;
        return false;
    L15:
        if (this.hasNext == r10.hasNext) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.list, r10.list) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final long getBatchId() {
        return this.batchId;
    }

    public final String getDayKey() {
        return this.dayKey;
    }

    public final boolean getHasNext() {
        return this.hasNext;
    }

    public final List<ProactiveRecommendationDto> getList() {
        return this.list;
    }

    public int hashCode() {
        return (((((Long.hashCode(this.batchId) * 31) + this.dayKey.hashCode()) * 31) + Boolean.hashCode(this.hasNext)) * 31) + this.list.hashCode();
    }

    public String toString() {
        return "ProactiveDayPageResult(batchId=" + this.batchId + ", dayKey=" + this.dayKey + ", hasNext=" + this.hasNext + ", list=" + this.list + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r4, int r5) {
        Intrinsics.checkNotNullParameter(r4, "dest");
        r4.writeLong(this.batchId);
        r4.writeString(this.dayKey);
        r4.writeInt(this.hasNext ? 1 : 0);
        r4.writeInt(this.list.size());
        Iterator r3 = ((Iterable) ZeusTransformUtils.preCheckCast(this.list, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        ((ProactiveRecommendationDto) ZeusTransformUtils.preCheckCast(r3.next(), ProactiveRecommendationDto.class, "com.obric.memorydata.plugin")).writeToParcel(r4, r5);
        goto L4
    }
}
