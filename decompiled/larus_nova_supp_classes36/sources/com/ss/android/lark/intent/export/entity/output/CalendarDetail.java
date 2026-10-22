package com.ss.android.lark.intent.export.entity.output;

import android.os.Parcel;
import android.os.Parcelable;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.notification.export.entity.INotificationHitPoint;
import com.ss.android.lark.search.dto.info.CalendarResult;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0006\u0010\n\u001a\u00020\u000bJ\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u000bHÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\u0016\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u000bR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0018"}, d2 = {"Lcom/ss/android/lark/intent/export/entity/output/CalendarDetail;", "Landroid/os/Parcelable;", "calendarResult", "Lcom/ss/android/lark/search/dto/info/CalendarResult;", "<init>", "(Lcom/ss/android/lark/search/dto/info/CalendarResult;)V", "getCalendarResult", "()Lcom/ss/android/lark/search/dto/info/CalendarResult;", "component1", "copy", "describeContents", "", "equals", "", INotificationHitPoint.NoticeType.OTHER, "", "hashCode", "toString", "", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "intent-export_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class CalendarDetail implements Parcelable {
    public static final Parcelable.Creator<CalendarDetail> CREATOR = null;
    private final CalendarResult calendarResult;

    @Metadata(k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
    public static final class Creator implements Parcelable.Creator<CalendarDetail> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final CalendarDetail createFromParcel(Parcel r3) {
            Intrinsics.checkNotNullParameter(r3, "parcel");
            return new CalendarDetail(r3.readParcelable(CalendarDetail.class.getClassLoader()));
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ CalendarDetail createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final CalendarDetail[] newArray(int r1) {
            return new CalendarDetail[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ CalendarDetail[] newArray(int r1) {
            return newArray(r1);
        }
    }

    static {
        CREATOR = new Creator();
    }

    public static /* synthetic */ CalendarDetail copy$default(CalendarDetail r0, CalendarResult r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = r0.calendarResult;
    L6:
        return r0.copy(r1);
    }

    public final CalendarResult component1() {
        return this.calendarResult;
    }

    public final CalendarDetail copy(CalendarResult r2) {
        return new CalendarDetail(r2);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if ((r4 instanceof CalendarDetail) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.calendarResult, ((CalendarDetail) r4).calendarResult) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        CalendarResult r0 = this.calendarResult;
        if (r0 != null) goto L6;
        return 0;
    L6:
        return r0.hashCode();
    }

    public String toString() {
        return "CalendarDetail(calendarResult=" + this.calendarResult + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "dest");
        r2.writeParcelable(this.calendarResult, r3);
    }

    public final CalendarResult getCalendarResult() {
        return this.calendarResult;
    }

    public CalendarDetail(CalendarResult r1) {
        this.calendarResult = r1;
    }
}
