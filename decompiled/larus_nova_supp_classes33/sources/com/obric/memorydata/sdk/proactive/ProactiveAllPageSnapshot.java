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
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 (2\u00020\u0001:\u0001(B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0005\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fB\u0011\b\u0016\u0012\u0006\u0010\r\u001a\u00020\u000e¢\u0006\u0004\b\u000b\u0010\u000fJ\u0018\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\b\u0010\u001c\u001a\u00020\u001bH\u0016J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\u000f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\b0\u0005HÆ\u0003J\t\u0010 \u001a\u00020\nHÆ\u0003J=\u0010!\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u00052\b\b\u0002\u0010\t\u001a\u00020\nHÆ\u0001J\u0013\u0010\"\u001a\u00020\n2\b\u0010#\u001a\u0004\u0018\u00010$HÖ\u0003J\t\u0010%\u001a\u00020\u001bHÖ\u0001J\t\u0010&\u001a\u00020'HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006)"}, d2 = {"Lcom/obric/memorydata/sdk/proactive/ProactiveAllPageSnapshot;", "Landroid/os/Parcelable;", "batchId", "", "dayHeaders", "", "Lcom/obric/memorydata/sdk/proactive/ProactiveDayHeaderDto;", "todayFirstPage", "Lcom/obric/memorydata/sdk/proactive/ProactiveRecommendationDto;", "todayHasNext", "", "<init>", "(JLjava/util/List;Ljava/util/List;Z)V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "getBatchId", "()J", "getDayHeaders", "()Ljava/util/List;", "getTodayFirstPage", "getTodayHasNext", "()Z", "writeToParcel", "", "dest", "flags", "", "describeContents", "component1", "component2", "component3", "component4", "copy", "equals", IInteractionStateService$Companion.WAKE_UP_SOURCE_OTHER, "", "hashCode", "toString", "", "CREATOR", "cocreationreview_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ProactiveAllPageSnapshot implements Parcelable {
    public static final a CREATOR = null;
    public final long a;
    public final List<ProactiveDayHeaderDto> b;
    public final List<ProactiveRecommendationDto> c;
    public final boolean d;

    public static final class a implements Parcelable.Creator<ProactiveAllPageSnapshot> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final ProactiveAllPageSnapshot createFromParcel(Parcel r10) {
            Intrinsics.checkNotNullParameter(r10, "parcel");
            Intrinsics.checkNotNullParameter(r10, "parcel");
            long r2 = r10.readLong();
            List r0 = CollectionsKt.createListBuilder();
            int r1 = r10.readInt();
            int r5 = 0;
        L3:
            if (r5 >= r1) goto L5;
            ProactiveDayHeaderDto.CREATOR.getClass();
            r0.add(ProactiveDayHeaderDto.a.a(r10));
            r5 = r5 + 1;
            goto L3
        L5:
            Unit r3 = Unit.INSTANCE;
            List r4 = CollectionsKt.build(r0);
            List r6 = CollectionsKt.createListBuilder();
            int r7 = r10.readInt();
            int r8 = 0;
        L6:
            if (r8 >= r7) goto L8;
            ProactiveRecommendationDto.CREATOR.getClass();
            r6.add(ProactiveRecommendationDto.a.a(r10));
            r8 = r8 + 1;
            goto L6
        L8:
            Unit r9 = Unit.INSTANCE;
            List r11 = CollectionsKt.build(r6);
            if (r10.readInt() == 0) goto L11;
            boolean r12 = true;
        L13:
            return new ProactiveAllPageSnapshot(r2, r4, r11, r12);
        L11:
            r12 = false;
            goto L13
        }

        @Override // android.os.Parcelable.Creator
        public final ProactiveAllPageSnapshot[] newArray(int r1) {
            return new ProactiveAllPageSnapshot[r1];
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
        if ((r8 instanceof ProactiveAllPageSnapshot) == true) goto L8;
        return false;
    L8:
        ProactiveAllPageSnapshot r9 = (ProactiveAllPageSnapshot) r8;
        if (this.a == r9.a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r9.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r9.c) == true) goto L18;
        return false;
    L18:
        if (this.d == r9.d) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        long r0 = this.a;
        int r1 = ((((((int) (r0 ^ (r0 >>> 32))) * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31;
        if (this.d == false) goto L5;
        int r2 = 1231;
    L7:
        return r1 + r2;
    L5:
        r2 = 1237;
        goto L7
    }

    public final String toString() {
        return "ProactiveAllPageSnapshot(batchId=" + this.a + ", dayHeaders=" + this.b + ", todayFirstPage=" + this.c + ", todayHasNext=" + this.d + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "dest");
        r3.writeLong(this.a);
        r3.writeInt(this.b.size());
        Iterator<T> r0 = this.b.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((ProactiveDayHeaderDto) r0.next()).writeToParcel(r3, r4);
        goto L4
    L6:
        r3.writeInt(this.c.size());
        Iterator<T> r1 = this.c.iterator();
    L8:
        if (r1.hasNext() == false) goto L10;
        ((ProactiveRecommendationDto) r1.next()).writeToParcel(r3, r4);
        goto L8
    L10:
        r3.writeInt(this.d ? 1 : 0);
    }

    public ProactiveAllPageSnapshot(long r2, List<ProactiveDayHeaderDto> r4, List<ProactiveRecommendationDto> r5, boolean r6) {
        Intrinsics.checkNotNullParameter(r4, "dayHeaders");
        Intrinsics.checkNotNullParameter(r5, "todayFirstPage");
        this.a = r2;
        this.b = r4;
        this.c = r5;
        this.d = r6;
    }
}
