package com.obric.aiproactive.api;

import android.os.Parcel;
import android.os.Parcelable;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 (2\u00020\u0001:\u0001(B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0005\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fB\u0011\b\u0016\u0012\u0006\u0010\r\u001a\u00020\u000e¢\u0006\u0004\b\u000b\u0010\u000fJ\u0018\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\b\u0010\u001c\u001a\u00020\u001bH\u0016J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\u000f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\b0\u0005HÆ\u0003J\t\u0010 \u001a\u00020\nHÆ\u0003J=\u0010!\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u00052\b\b\u0002\u0010\t\u001a\u00020\nHÆ\u0001J\u0013\u0010\"\u001a\u00020\n2\b\u0010#\u001a\u0004\u0018\u00010$HÖ\u0003J\t\u0010%\u001a\u00020\u001bHÖ\u0001J\t\u0010&\u001a\u00020'HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006)"}, d2 = {"Lcom/obric/aiproactive/api/ProactiveAllPageSnapshot;", "Landroid/os/Parcelable;", "batchId", "", "dayHeaders", "", "Lcom/obric/aiproactive/api/ProactiveDayHeaderDto;", "todayFirstPage", "Lcom/obric/aiproactive/api/ProactiveRecommendationDto;", "todayHasNext", "", "<init>", "(JLjava/util/List;Ljava/util/List;Z)V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "getBatchId", "()J", "getDayHeaders", "()Ljava/util/List;", "getTodayFirstPage", "getTodayHasNext", "()Z", "writeToParcel", "", "dest", "flags", "", "describeContents", "component1", "component2", "component3", "component4", "copy", "equals", "other", "", "hashCode", "toString", "", "CREATOR", "ai_proactive_api_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ProactiveAllPageSnapshot implements Parcelable {
    public static final a CREATOR = null;
    private final long batchId;
    private final List<ProactiveDayHeaderDto> dayHeaders;
    private final List<ProactiveRecommendationDto> todayFirstPage;
    private final boolean todayHasNext;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u001d\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016¢\u0006\u0002\u0010\f¨\u0006\r"}, d2 = {"Lcom/obric/aiproactive/api/ProactiveAllPageSnapshot$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/obric/aiproactive/api/ProactiveAllPageSnapshot;", "<init>", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/obric/aiproactive/api/ProactiveAllPageSnapshot;", "ai_proactive_api_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a implements Parcelable.Creator<ProactiveAllPageSnapshot> {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }

        public ProactiveAllPageSnapshot a(Parcel r1) {
            Intrinsics.checkNotNullParameter(r1, "parcel");
            return new ProactiveAllPageSnapshot(r1);
        }

        public ProactiveAllPageSnapshot[] a(int r1) {
            return new ProactiveAllPageSnapshot[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* synthetic */ ProactiveAllPageSnapshot createFromParcel(Parcel r1) {
            return a(r1);
        }

        @Override // android.os.Parcelable.Creator
        public /* synthetic */ ProactiveAllPageSnapshot[] newArray(int r1) {
            return a(r1);
        }
    }

    static {
        CREATOR = new a(null);
    }

    public ProactiveAllPageSnapshot(long r3, List<ProactiveDayHeaderDto> r5, List<ProactiveRecommendationDto> r6, boolean r7) {
        List<ProactiveDayHeaderDto> r8 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        List<ProactiveRecommendationDto> r9 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r8, "dayHeaders");
        Intrinsics.checkNotNullParameter(r9, "todayFirstPage");
        this.batchId = r3;
        this.dayHeaders = r8;
        this.todayFirstPage = r9;
        this.todayHasNext = r7;
    }

    public ProactiveAllPageSnapshot(Parcel r9) {
        Intrinsics.checkNotNullParameter(r9, "parcel");
        long r2 = r9.readLong();
        List r0 = CollectionsKt.createListBuilder();
        int r1 = r9.readInt();
        int r5 = 0;
    L3:
        if (r5 >= r1) goto L5;
        r0.add(ProactiveDayHeaderDto.CREATOR.a(r9));
        r5 = r5 + 1;
        goto L3
    L5:
        Unit r3 = Unit.INSTANCE;
        List r4 = CollectionsKt.build(r0);
        List r6 = CollectionsKt.createListBuilder();
        int r7 = r9.readInt();
        int r8 = 0;
    L6:
        if (r8 >= r7) goto L8;
        r6.add(ProactiveRecommendationDto.CREATOR.a(r9));
        r8 = r8 + 1;
        goto L6
    L8:
        Unit r10 = Unit.INSTANCE;
        List r11 = CollectionsKt.build(r6);
        if (r9.readInt() == 0) goto L11;
        boolean r12 = true;
    L12:
        this(r2, r4, r11, r12);
        return;
    L11:
        r12 = false;
        goto L12
    }

    public static /* synthetic */ ProactiveAllPageSnapshot copy$default(ProactiveAllPageSnapshot r6, long r7, List r9, List r10, boolean r11, int r12, Object r13) {
        List<ProactiveDayHeaderDto> r14 = (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.memorydata.plugin");
        List<ProactiveRecommendationDto> r15 = (List) ZeusTransformUtils.wrapperContextForParams(r10, List.class, "com.obric.memorydata.plugin");
        if ((r12 & 1) == 0) goto L5;
        r7 = r6.batchId;
    L5:
        long r1 = r7;
        if ((r12 & 2) == 0) goto L8;
        r14 = r6.dayHeaders;
    L8:
        List<ProactiveDayHeaderDto> r3 = r14;
        if ((r12 & 4) == 0) goto L11;
        r15 = r6.todayFirstPage;
    L11:
        List<ProactiveRecommendationDto> r4 = r15;
        if ((r12 & 8) == 0) goto L15;
        r11 = r6.todayHasNext;
    L15:
        return r6.copy(r1, r3, r4, r11);
    }

    public final long component1() {
        return this.batchId;
    }

    public final List<ProactiveDayHeaderDto> component2() {
        return this.dayHeaders;
    }

    public final List<ProactiveRecommendationDto> component3() {
        return this.todayFirstPage;
    }

    public final boolean component4() {
        return this.todayHasNext;
    }

    public final ProactiveAllPageSnapshot copy(long r8, List<ProactiveDayHeaderDto> r10, List<ProactiveRecommendationDto> r11, boolean r12) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r10, List.class, "com.obric.memorydata.plugin");
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r11, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "dayHeaders");
        Intrinsics.checkNotNullParameter(r5, "todayFirstPage");
        return new ProactiveAllPageSnapshot(r8, r4, r5, r12);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, ProactiveAllPageSnapshot.class) == true) goto L8;
        return false;
    L8:
        ProactiveAllPageSnapshot r10 = (ProactiveAllPageSnapshot) ZeusTransformUtils.preCheckCast(r9, ProactiveAllPageSnapshot.class, "com.obric.memorydata.plugin");
        if (this.batchId == r10.batchId) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.dayHeaders, r10.dayHeaders) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.todayFirstPage, r10.todayFirstPage) == true) goto L18;
        return false;
    L18:
        if (this.todayHasNext == r10.todayHasNext) goto L20;
        return false;
    L20:
        return true;
    }

    public final long getBatchId() {
        return this.batchId;
    }

    public final List<ProactiveDayHeaderDto> getDayHeaders() {
        return this.dayHeaders;
    }

    public final List<ProactiveRecommendationDto> getTodayFirstPage() {
        return this.todayFirstPage;
    }

    public final boolean getTodayHasNext() {
        return this.todayHasNext;
    }

    public int hashCode() {
        return (((((Long.hashCode(this.batchId) * 31) + this.dayHeaders.hashCode()) * 31) + this.todayFirstPage.hashCode()) * 31) + Boolean.hashCode(this.todayHasNext);
    }

    public String toString() {
        return "ProactiveAllPageSnapshot(batchId=" + this.batchId + ", dayHeaders=" + this.dayHeaders + ", todayFirstPage=" + this.todayFirstPage + ", todayHasNext=" + this.todayHasNext + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r5, int r6) {
        Intrinsics.checkNotNullParameter(r5, "dest");
        r5.writeLong(this.batchId);
        r5.writeInt(this.dayHeaders.size());
        Iterator r0 = ((Iterable) ZeusTransformUtils.preCheckCast(this.dayHeaders, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((ProactiveDayHeaderDto) ZeusTransformUtils.preCheckCast(r0.next(), ProactiveDayHeaderDto.class, "com.obric.memorydata.plugin")).writeToParcel(r5, r6);
        goto L4
    L6:
        r5.writeInt(this.todayFirstPage.size());
        Iterator r1 = ((Iterable) ZeusTransformUtils.preCheckCast(this.todayFirstPage, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L8:
        if (r1.hasNext() == false) goto L10;
        ((ProactiveRecommendationDto) ZeusTransformUtils.preCheckCast(r1.next(), ProactiveRecommendationDto.class, "com.obric.memorydata.plugin")).writeToParcel(r5, r6);
        goto L8
    L10:
        r5.writeInt(this.todayHasNext ? 1 : 0);
    }
}
