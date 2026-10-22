package com.obric.memorydata.sdk.proactive;

import android.os.Parcel;
import android.os.Parcelable;
import com.obric.assistant.interaction.api.service.IInteractionStateService$Companion;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0086\b\u0018\u0000 !2\u00020\u0001:\u0001!B+\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bB\u0011\b\u0016\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0007\u0010\u000bJ\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\b\u0010\u0016\u001a\u00020\u0015H\u0016J\u000f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0004HÆ\u0003J3\u0010\u001a\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0004HÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eHÖ\u0003J\t\u0010\u001f\u001a\u00020\u0015HÖ\u0001J\t\u0010 \u001a\u00020\u0004HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\""}, d2 = {"Lcom/obric/memorydata/sdk/proactive/ProactiveLabelingFeedbackConfigDto;", "Landroid/os/Parcelable;", "positiveReasons", "", "", "negativeReasons", "feedbackPlaceholder", "<init>", "(Ljava/util/List;Ljava/util/List;Ljava/lang/String;)V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "getPositiveReasons", "()Ljava/util/List;", "getNegativeReasons", "getFeedbackPlaceholder", "()Ljava/lang/String;", "writeToParcel", "", "dest", "flags", "", "describeContents", "component1", "component2", "component3", "copy", "equals", "", IInteractionStateService$Companion.WAKE_UP_SOURCE_OTHER, "", "hashCode", "toString", "CREATOR", "cocreationreview_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ProactiveLabelingFeedbackConfigDto implements Parcelable {
    public static final a CREATOR = null;
    public final List<String> a;
    public final List<String> b;
    public final String c;

    public static final class a implements Parcelable.Creator<ProactiveLabelingFeedbackConfigDto> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final ProactiveLabelingFeedbackConfigDto createFromParcel(Parcel r4) {
            Intrinsics.checkNotNullParameter(r4, "parcel");
            Intrinsics.checkNotNullParameter(r4, "parcel");
            List r0 = r4.createStringArrayList();
            if (r0 != null) goto L5;
            r0 = CollectionsKt.emptyList();
        L5:
            List r2 = r4.createStringArrayList();
            if (r2 != null) goto L8;
            r2 = CollectionsKt.emptyList();
        L8:
            String r5 = r4.readString();
            if (r5 != null) goto L12;
            r5 = "";
        L12:
            return new ProactiveLabelingFeedbackConfigDto(r0, r2, r5);
        }

        @Override // android.os.Parcelable.Creator
        public final ProactiveLabelingFeedbackConfigDto[] newArray(int r1) {
            return new ProactiveLabelingFeedbackConfigDto[r1];
        }
    }

    static {
        CREATOR = new a();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof ProactiveLabelingFeedbackConfigDto) == true) goto L8;
        return false;
    L8:
        ProactiveLabelingFeedbackConfigDto r6 = (ProactiveLabelingFeedbackConfigDto) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        return (((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode();
    }

    public final String toString() {
        return "ProactiveLabelingFeedbackConfigDto(positiveReasons=" + this.a + ", negativeReasons=" + this.b + ", feedbackPlaceholder=" + this.c + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "dest");
        r1.writeStringList(this.a);
        r1.writeStringList(this.b);
        r1.writeString(this.c);
    }

    public ProactiveLabelingFeedbackConfigDto(List<String> r2, List<String> r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "positiveReasons");
        Intrinsics.checkNotNullParameter(r3, "negativeReasons");
        Intrinsics.checkNotNullParameter(r4, "feedbackPlaceholder");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
