package com.ss.android.lark.forwardv2.dto.template;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public class ForwardViewDependency implements Parcelable {
    public static final Parcelable.Creator<ForwardViewDependency> CREATOR = null;
    public boolean a;
    public String b;
    public String c;
    public String d;
    public BasicDialogContent e;
    public ForwardEnhancedView f;
    public String g;
    public String h;
    public boolean i;
    public boolean j;

    public class a implements Parcelable.Creator<ForwardViewDependency> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final ForwardViewDependency createFromParcel(Parcel r2) {
            return new ForwardViewDependency(r2);
        }

        @Override // android.os.Parcelable.Creator
        public final ForwardViewDependency[] newArray(int r1) {
            return new ForwardViewDependency[r1];
        }
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    static {
        CREATOR = new a();
    }

    public ForwardViewDependency() {
        this.i = true;
        this.j = true;
    }

    public ForwardViewDependency(Parcel r4) {
        boolean r0 = true;
        this.i = true;
        this.j = true;
        if (r4.readByte() == 0) goto L5;
        boolean r1 = true;
    L6:
        this.i = r1;
        if (r4.readByte() == 0) goto L9;
        boolean r2 = true;
    L10:
        this.a = r2;
        this.b = r4.readString();
        this.c = r4.readString();
        this.d = r4.readString();
        this.g = r4.readString();
        this.h = r4.readString();
        this.e = (BasicDialogContent) r4.readParcelable(BasicDialogContent.class.getClassLoader());
        this.f = (ForwardEnhancedView) r4.readParcelable(BasicDialogContent.class.getClassLoader());
        if (r4.readByte() != 0) goto L14;
        r0 = false;
    L14:
        this.j = r0;
        return;
    L9:
        r2 = false;
        goto L10
    L5:
        r1 = false;
        goto L6
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r2, int r3) {
        r2.writeByte(this.i ? 1 : 0);
        r2.writeByte(this.a ? 1 : 0);
        r2.writeString(this.b);
        r2.writeString(this.c);
        r2.writeString(this.d);
        r2.writeString(this.g);
        r2.writeString(this.h);
        r2.writeParcelable(this.e, r3);
        r2.writeParcelable(this.f, r3);
        r2.writeByte(this.j ? 1 : 0);
    }
}
