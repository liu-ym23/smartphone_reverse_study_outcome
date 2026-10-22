package com.obric.memorydata.sdk.proactive;

import android.os.Parcel;
import android.os.Parcelable;
import com.obric.assistant.interaction.api.service.IInteractionStateService$Companion;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0086\b\u0018\u0000 (2\u00020\u0001:\u0001(B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0004\b\u000b\u0010\fB\u0011\b\u0016\u0012\u0006\u0010\r\u001a\u00020\u000e¢\u0006\u0004\b\u000b\u0010\u000fJ\u0018\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u000e2\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\b\u0010\u001d\u001a\u00020\u001cH\u0016J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0005HÆ\u0003J\t\u0010 \u001a\u00020\u0007HÆ\u0003J\u000f\u0010!\u001a\b\u0012\u0004\u0012\u00020\n0\tHÆ\u0003J7\u0010\"\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tHÆ\u0001J\u0013\u0010#\u001a\u00020\u00072\b\u0010$\u001a\u0004\u0018\u00010%HÖ\u0003J\t\u0010&\u001a\u00020\u001cHÖ\u0001J\t\u0010'\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006)"}, d2 = {"Lcom/obric/memorydata/sdk/proactive/ProactiveDayPageResult;", "Landroid/os/Parcelable;", "batchId", "", "dayKey", "", "hasNext", "", "list", "", "Lcom/obric/memorydata/sdk/proactive/ProactiveRecommendationDto;", "<init>", "(JLjava/lang/String;ZLjava/util/List;)V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "getBatchId", "()J", "getDayKey", "()Ljava/lang/String;", "getHasNext", "()Z", "getList", "()Ljava/util/List;", "writeToParcel", "", "dest", "flags", "", "describeContents", "component1", "component2", "component3", "component4", "copy", "equals", IInteractionStateService$Companion.WAKE_UP_SOURCE_OTHER, "", "hashCode", "toString", "CREATOR", "cocreationreview_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ProactiveDayPageResult implements Parcelable {
    public static final a CREATOR = null;
    public final long a;
    public final String b;
    public final boolean c;
    public final List<ProactiveRecommendationDto> d;

    public static final class a implements Parcelable.Creator<ProactiveDayPageResult> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final ProactiveDayPageResult createFromParcel(Parcel r10) {
            Intrinsics.checkNotNullParameter(r10, "parcel");
            Intrinsics.checkNotNullParameter(r10, "parcel");
            long r2 = r10.readLong();
            String r0 = r10.readString();
            if (r0 != null) goto L5;
            r0 = "";
        L5:
            String r4 = r0;
            int r1 = 0;
            if (r10.readInt() == 0) goto L8;
            boolean r5 = true;
        L9:
            List r3 = CollectionsKt.createListBuilder();
            int r6 = r10.readInt();
        L10:
            if (r1 >= r6) goto L12;
            ProactiveRecommendationDto.CREATOR.getClass();
            r3.add(ProactiveRecommendationDto.a.a(r10));
            r1 = r1 + 1;
            goto L10
        L12:
            Unit r11 = Unit.INSTANCE;
            return new ProactiveDayPageResult(r2, r4, r5, CollectionsKt.build(r3));
        L8:
            r5 = false;
            goto L9
        }

        @Override // android.os.Parcelable.Creator
        public final ProactiveDayPageResult[] newArray(int r1) {
            return new ProactiveDayPageResult[r1];
        }
    }

    static {
        CREATOR = new a();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof ProactiveDayPageResult) == true) goto L8;
        return false;
    L8:
        ProactiveDayPageResult r9 = (ProactiveDayPageResult) r8;
        if (this.a == r9.a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r9.b) == true) goto L15;
        return false;
    L15:
        if (this.c == r9.c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r9.d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        long r0 = this.a;
        int r1 = ((((int) (r0 ^ (r0 >>> 32))) * 31) + this.b.hashCode()) * 31;
        if (this.c == false) goto L5;
        int r2 = 1231;
    L7:
        return ((r1 + r2) * 31) + this.d.hashCode();
    L5:
        r2 = 1237;
        goto L7
    }

    public final String toString() {
        return "ProactiveDayPageResult(batchId=" + this.a + ", dayKey=" + this.b + ", hasNext=" + this.c + ", list=" + this.d + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "dest");
        r3.writeLong(this.a);
        r3.writeString(this.b);
        r3.writeInt(this.c ? 1 : 0);
        r3.writeInt(this.d.size());
        Iterator<T> r0 = this.d.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((ProactiveRecommendationDto) r0.next()).writeToParcel(r3, r4);
        goto L4
    }

    public ProactiveDayPageResult(long r2, String r4, boolean r5, List<ProactiveRecommendationDto> r6) {
        Intrinsics.checkNotNullParameter(r4, "dayKey");
        Intrinsics.checkNotNullParameter(r6, "list");
        this.a = r2;
        this.b = r4;
        this.c = r5;
        this.d = r6;
    }
}
