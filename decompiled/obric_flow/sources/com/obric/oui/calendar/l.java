package com.obric.oui.calendar;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes3.dex */
public final class l implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel r10) {
        MaterialCalendarView.SavedState r5 = new MaterialCalendarView.SavedState(r10);
        r5.f12191a = 4;
        boolean r11 = true;
        r5.f12192b = true;
        r5.f12193c = null;
        r5.d = null;
        r5.e = new ArrayList();
        r5.f = true;
        r5.g = 1;
        r5.f12194h = false;
        r5.f12195i = null;
        r5.f12191a = r10.readInt();
        if (r10.readByte() == 0) goto L5;
        boolean r12 = true;
    L6:
        r5.f12192b = r12;
        ClassLoader r13 = CalendarDay.class.getClassLoader();
        r5.f12193c = (CalendarDay) r10.readParcelable(r13);
        r5.d = (CalendarDay) r10.readParcelable(r13);
        r10.readTypedList(r5.e, CalendarDay.CREATOR);
        if (r10.readInt() != 1) goto L9;
        boolean r14 = true;
    L10:
        r5.f = r14;
        r5.g = r10.readInt();
        if (r10.readInt() != 1) goto L13;
        boolean r15 = true;
    L14:
        r5.f12194h = r15;
        r5.f12195i = (CalendarDay) r10.readParcelable(r13);
        if (r10.readByte() != 0) goto L18;
        r11 = false;
    L18:
        r5.f12196j = r11;
        return r5;
    L13:
        r15 = false;
        goto L14
    L9:
        r14 = false;
        goto L10
    L5:
        r12 = false;
        goto L6
    }

    @Override // android.os.Parcelable.Creator
    public final Object[] newArray(int r5) {
        return new MaterialCalendarView.SavedState[r5];
    }
}
