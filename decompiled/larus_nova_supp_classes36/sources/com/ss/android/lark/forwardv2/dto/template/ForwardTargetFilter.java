package com.ss.android.lark.forwardv2.dto.template;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.ss.android.lark.forwardv2.dto.ForwardTarget;
import com.ss.android.lark.forwardv2.impl.IRemoteForwardTargetFilter;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public class ForwardTargetFilter implements Parcelable {
    public static final Parcelable.Creator<ForwardTargetFilter> CREATOR = null;
    public boolean a;
    public boolean b;
    public boolean c;
    public boolean d;
    public boolean e;
    public boolean f;
    public boolean g;
    public boolean h;
    public boolean i;
    public boolean j;
    public IRemoteForwardTargetFilter k;

    /* JADX INFO: renamed from: com.ss.android.lark.forwardv2.dto.template.ForwardTargetFilter$2, reason: invalid class name */
    class AnonymousClass2 extends IRemoteForwardTargetFilter.Stub {
        final /* synthetic */ ForwardTargetFilter this$0;
        final /* synthetic */ c val$customFilter;

        @Override // com.ss.android.lark.forwardv2.impl.IRemoteForwardTargetFilter
        public boolean filter(ForwardTarget r1) throws RemoteException {
            throw null;
        }

        public AnonymousClass2(ForwardTargetFilter r1, c r2) {
            this.this$0 = r1;
        }
    }

    public class a implements Parcelable.Creator<ForwardTargetFilter> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final ForwardTargetFilter createFromParcel(Parcel r2) {
            return new ForwardTargetFilter(r2);
        }

        @Override // android.os.Parcelable.Creator
        public final ForwardTargetFilter[] newArray(int r1) {
            return new ForwardTargetFilter[r1];
        }
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    static {
        CREATOR = new a();
    }

    public ForwardTargetFilter() {
        this.a = false;
        this.b = false;
        this.c = false;
        this.d = false;
        this.e = false;
        this.f = false;
        this.g = true;
        this.h = true;
        this.i = false;
        this.j = false;
    }

    public ForwardTargetFilter(Parcel r4) {
        boolean r0 = false;
        this.a = false;
        this.b = false;
        this.c = false;
        this.d = false;
        this.e = false;
        this.f = false;
        this.g = true;
        this.h = true;
        this.i = false;
        this.j = false;
        if (r4.readByte() == 0) goto L5;
        boolean r2 = true;
    L6:
        this.a = r2;
        if (r4.readByte() == 0) goto L9;
        boolean r3 = true;
    L10:
        this.b = r3;
        if (r4.readByte() == 0) goto L13;
        boolean r5 = true;
    L14:
        this.c = r5;
        if (r4.readByte() == 0) goto L17;
        boolean r6 = true;
    L18:
        this.d = r6;
        if (r4.readByte() == 0) goto L21;
        boolean r7 = true;
    L22:
        this.e = r7;
        if (r4.readByte() == 0) goto L25;
        boolean r8 = true;
    L26:
        this.f = r8;
        if (r4.readByte() == 0) goto L29;
        boolean r9 = true;
    L30:
        this.g = r9;
        if (r4.readByte() == 0) goto L33;
        boolean r10 = true;
    L34:
        this.i = r10;
        if (r4.readByte() == 0) goto L37;
        boolean r11 = true;
    L38:
        this.h = r11;
        if (r4.readByte() == 0) goto L41;
        r0 = true;
    L41:
        this.j = r0;
        if (r4.readInt() <= 0) goto L45;
        this.k = IRemoteForwardTargetFilter.Stub.asInterface(r4.readStrongBinder());
        return;
    L45:
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
        r5 = false;
        goto L14
    L9:
        r3 = false;
        goto L10
    L5:
        r2 = false;
        goto L6
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r1, int r2) {
        r1.writeByte(this.a ? 1 : 0);
        r1.writeByte(this.b ? 1 : 0);
        r1.writeByte(this.c ? 1 : 0);
        r1.writeByte(this.d ? 1 : 0);
        r1.writeByte(this.e ? 1 : 0);
        r1.writeByte(this.f ? 1 : 0);
        r1.writeByte(this.g ? 1 : 0);
        r1.writeByte(this.i ? 1 : 0);
        r1.writeByte(this.h ? 1 : 0);
        r1.writeByte(this.j ? 1 : 0);
        if (this.k == null) goto L5;
        r1.writeInt(1);
        r1.writeStrongBinder(this.k.asBinder());
        return;
    L5:
        r1.writeInt(0);
    }
}
