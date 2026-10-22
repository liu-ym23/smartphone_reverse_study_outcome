package com.suite.lark.platform.service.resourcerepository.api;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.lark.pb.basic.v1.Trace;
import com.larksuite.framework.callback.Entity.ErrorResult;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public class Resource implements Parcelable {
    public static final Parcelable.Creator<Resource> CREATOR = null;
    public final String a;
    public String b;
    public final Boolean c;
    public Trace d;
    public ErrorResult e;

    public class a implements Parcelable.Creator<Resource> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final Resource createFromParcel(Parcel r2) {
            return new Resource(r2);
        }

        @Override // android.os.Parcelable.Creator
        public final Resource[] newArray(int r1) {
            return new Resource[r1];
        }
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    static {
        CREATOR = new a();
    }

    public Resource() {
    }

    public Resource(Parcel r3) {
        this.a = r3.readString();
        this.b = r3.readString();
        boolean r1 = true;
        if (r3.readInt() == 1) goto L6;
        r1 = false;
    L6:
        this.c = Boolean.valueOf(r1);
        this.d = r3.readSerializable();
        this.e = r3.readSerializable();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r1, int r2) {
        r1.writeString(this.a);
        r1.writeString(this.b);
        r1.writeInt(this.c.booleanValue() ? 1 : 0);
        r1.writeSerializable(this.d);
        r1.writeSerializable(this.e);
    }

    public Resource(String r1, String r2, Boolean r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
