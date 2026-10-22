package com.ss.android.lark.forwardv2.dto.template;

import android.os.Parcel;
import android.os.Parcelable;
import com.ss.android.lark.forwardv2.dto.StickImage;
import com.ss.android.lark.image.entity.Image;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public class BasicDialogContent implements Parcelable {
    public static final Parcelable.Creator<BasicDialogContent> CREATOR = null;
    public String a;
    public String b;
    public String c;
    public String d;
    public int e;
    public Image f;
    public Image g;
    public StickImage h;
    public int i;
    public boolean j;
    public boolean k;

    public class a implements Parcelable.Creator<BasicDialogContent> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final BasicDialogContent createFromParcel(Parcel r2) {
            return new BasicDialogContent(r2);
        }

        @Override // android.os.Parcelable.Creator
        public final BasicDialogContent[] newArray(int r1) {
            return new BasicDialogContent[r1];
        }
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    static {
        CREATOR = new a();
    }

    public BasicDialogContent() {
    }

    public BasicDialogContent(Parcel r4) {
        this.a = r4.readString();
        this.b = r4.readString();
        this.c = r4.readString();
        this.d = r4.readString();
        this.e = r4.readInt();
        this.g = (Image) r4.readSerializable();
        this.f = (Image) r4.readSerializable();
        this.h = (StickImage) r4.readSerializable();
        this.i = r4.readInt();
        boolean r1 = false;
        if (r4.readInt() != 1) goto L5;
        boolean r0 = true;
    L6:
        this.j = r0;
        if (r4.readInt() != 1) goto L9;
        r1 = true;
    L9:
        this.k = r1;
        return;
    L5:
        r0 = false;
        goto L6
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r1, int r2) {
        r1.writeString(this.a);
        r1.writeString(this.b);
        r1.writeString(this.c);
        r1.writeString(this.d);
        r1.writeInt(this.e);
        r1.writeSerializable(this.g);
        r1.writeSerializable(this.f);
        r1.writeSerializable(this.h);
        r1.writeInt(this.i);
        r1.writeInt(this.j ? 1 : 0);
        r1.writeInt(this.k ? 1 : 0);
    }
}
