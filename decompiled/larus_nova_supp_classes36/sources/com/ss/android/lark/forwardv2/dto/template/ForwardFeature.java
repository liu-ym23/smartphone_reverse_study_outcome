package com.ss.android.lark.forwardv2.dto.template;

import android.os.Parcel;
import android.os.Parcelable;
import com.ss.android.lark.forwardv2.dto.template.choosechat.PreSelectedPair;
import java.util.ArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public class ForwardFeature implements Parcelable {
    public static final Parcelable.Creator<ForwardFeature> CREATOR = null;
    public ArrayList<PreSelectedPair> a;
    public boolean b;
    public boolean c;
    public boolean d;
    public int e;
    public boolean f;
    public boolean g;
    public boolean h;
    public boolean i;
    public boolean j;
    public boolean k;
    public boolean l;
    public IForwardCancelListener m;
    public IForwardSelectListener n;

    public class a implements Parcelable.Creator<ForwardFeature> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final ForwardFeature createFromParcel(Parcel r2) {
            return new ForwardFeature(r2);
        }

        @Override // android.os.Parcelable.Creator
        public final ForwardFeature[] newArray(int r1) {
            return new ForwardFeature[r1];
        }
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    static {
        CREATOR = new a();
    }

    public final void a() {
        if (this.b == false) goto L6;
        com.ss.android.lark.forwardv3.utils.b.d();
        return;
    }

    public ForwardFeature() {
        this.a = new ArrayList();
        this.b = true;
        this.g = true;
        this.h = true;
        this.i = false;
        this.j = true;
        this.k = false;
        this.l = false;
    }

    public ForwardFeature(Parcel r5) {
        ArrayList<PreSelectedPair> r0 = new ArrayList();
        this.a = r0;
        boolean r1 = true;
        this.b = true;
        this.g = true;
        this.h = true;
        this.i = false;
        this.j = true;
        this.k = false;
        this.l = false;
        r5.readTypedList(r0, PreSelectedPair.CREATOR);
        if (r5.readByte() == 0) goto L5;
        boolean r2 = true;
    L6:
        this.b = r2;
        if (r5.readByte() == 0) goto L9;
        boolean r3 = true;
    L10:
        this.c = r3;
        if (r5.readByte() == 0) goto L13;
        boolean r4 = true;
    L14:
        this.d = r4;
        this.e = r5.readInt();
        if (r5.readByte() == 0) goto L17;
        boolean r6 = true;
    L18:
        this.g = r6;
        if (r5.readByte() == 0) goto L21;
        boolean r7 = true;
    L22:
        this.h = r7;
        if (r5.readByte() == 0) goto L25;
        boolean r8 = true;
    L26:
        this.f = r8;
        if (r5.readByte() == 0) goto L29;
        boolean r9 = true;
    L30:
        this.i = r9;
        if (r5.readByte() == 0) goto L33;
        boolean r10 = true;
    L34:
        this.j = r10;
        if (r5.readByte() == 0) goto L37;
        boolean r11 = true;
    L38:
        this.k = r11;
        if (r5.readByte() != 0) goto L42;
        r1 = false;
    L42:
        this.l = r1;
        this.m = (IForwardCancelListener) r5.readParcelable(ForwardFeature.class.getClassLoader());
        this.n = (IForwardSelectListener) r5.readParcelable(ForwardFeature.class.getClassLoader());
        return;
    L37:
        r11 = false;
        goto L38
    L33:
        r10 = false;
        goto L34
    L29:
        r9 = false;
        goto L30
    L25:
        r8 = false;
        goto L26
    L21:
        r7 = false;
        goto L22
    L17:
        r6 = false;
        goto L18
    L13:
        r4 = false;
        goto L14
    L9:
        r3 = false;
        goto L10
    L5:
        r2 = false;
        goto L6
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r2, int r3) {
        r2.writeTypedList(this.a);
        r2.writeByte(this.b ? 1 : 0);
        r2.writeByte(this.c ? 1 : 0);
        r2.writeByte(this.d ? 1 : 0);
        r2.writeInt(this.e);
        r2.writeByte(this.g ? 1 : 0);
        r2.writeByte(this.h ? 1 : 0);
        r2.writeByte(this.f ? 1 : 0);
        r2.writeByte(this.i ? 1 : 0);
        r2.writeByte(this.j ? 1 : 0);
        r2.writeByte(this.k ? 1 : 0);
        r2.writeByte(this.l ? 1 : 0);
        r2.writeParcelable(this.m, r3);
        r2.writeParcelable(this.n, r3);
    }
}
