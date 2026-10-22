package com.obric.clockwidgets.data;

import ai.j0;
import android.os.Parcel;
import android.os.Parcelable;
import cp.a;
import java.util.TimeZone;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\b\u0018\u0000 \u00022\u00020\u0001:\u0001\u0003¨\u0006\u0004"}, d2 = {"Lcom/obric/clockwidgets/data/WidgetClockCity;", "Landroid/os/Parcelable;", "CREATOR", "cp/a", "clockwidgets_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class WidgetClockCity implements Parcelable {
    public static final a CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f11257a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f11258b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f11259c;
    public final long d;
    public final TimeZone e;
    public final String f;

    static {
        CREATOR = new a();
    }

    public /* synthetic */ WidgetClockCity(String r10, String r11, long r12, TimeZone r13) {
        this(r10, null, r11, r12, r13, null);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof WidgetClockCity) == true) goto L8;
        return false;
    L8:
        WidgetClockCity r11 = (WidgetClockCity) r10;
        String r5 = r11.f11257a;
        if (Intrinsics.areEqual(this.f11257a, r5) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f11258b, r11.f11258b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f11259c, r11.f11259c) == true) goto L18;
        return false;
    L18:
        if (this.d == r11.d) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r11.e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f, r11.f) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        int r5 = 0;
        String r10 = this.f11257a;
        if (r10 != null) goto L5;
        int r11 = 0;
    L6:
        int r12 = r11 * 31;
        String r13 = this.f11258b;
        if (r13 != null) goto L9;
        int r14 = 0;
    L10:
        int r15 = (r12 + r14) * 31;
        String r16 = this.f11259c;
        if (r16 != null) goto L13;
        int r17 = 0;
    L14:
        int r18 = androidx.room.jarjarred.org.antlr.runtime.a.e((r15 + r17) * 31, this.d, 31);
        TimeZone r19 = this.e;
        if (r19 != null) goto L17;
        int r20 = 0;
    L18:
        int r21 = (r18 + r20) * 31;
        String r22 = this.f;
        if (r22 == null) goto L23;
        r5 = r22.hashCode();
    L23:
        return r21 + r5;
    L17:
        r20 = r19.hashCode();
        goto L18
    L13:
        r17 = r16.hashCode();
        goto L14
    L9:
        r14 = r13.hashCode();
        goto L10
    L5:
        r11 = r10.hashCode();
        goto L6
    }

    public final String toString() {
        StringBuilder r5 = new StringBuilder("WidgetClockCity(cityId=");
        r5.append(this.f11257a);
        r5.append(", cityName=");
        r5.append(this.f11258b);
        r5.append(", cityTimeZone=");
        r5.append(this.f11259c);
        r5.append(", time=");
        r5.append(this.d);
        r5.append(", timeZone=");
        r5.append(this.e);
        r5.append(", country=");
        return j0.p(r5, this.f, ')');
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r5, int r10) {
        Intrinsics.checkNotNullParameter(r5, "dest");
        r5.writeString(this.f11257a);
        r5.writeString(this.f11258b);
        r5.writeString(this.f11259c);
        r5.writeLong(this.d);
        TimeZone r11 = this.e;
        if (r11 == null) goto L5;
        String r12 = r11.getID();
    L6:
        r5.writeString(r12);
        r5.writeString(this.f);
        return;
    L5:
        r12 = null;
        goto L6
    }

    public WidgetClockCity(String r5, String r10, String r11, long r12, TimeZone r13, String r14) {
        this.f11257a = r5;
        this.f11258b = r10;
        this.f11259c = r11;
        this.d = r12;
        this.e = r13;
        this.f = r14;
    }
}
