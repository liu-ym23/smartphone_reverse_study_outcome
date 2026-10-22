package com.bytedance.android.livesdk.interactivity.api.expression;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.style.ForegroundColorSpan;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.bdlocation.BuildConfig;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public class MentionSpan extends ForegroundColorSpan implements e90.a {
    public static final Parcelable.Creator<MentionSpan> CREATOR = null;
    public final IBaseUser a;
    public final String b;
    public final String c;
    public final TextExtraStruct d;
    public final String e;
    public final boolean f;

    public class a implements Parcelable.Creator<MentionSpan> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final MentionSpan createFromParcel(Parcel r2) {
            return new MentionSpan(r2);
        }

        @Override // android.os.Parcelable.Creator
        public final MentionSpan[] newArray(int r1) {
            return new MentionSpan[r1];
        }
    }

    public final int a() {
        return 4;
    }

    public final boolean b() {
        return true;
    }

    @Override // android.text.style.ForegroundColorSpan, android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public int getType() {
        return 2;
    }

    static {
        CREATOR = new a();
    }

    public final int hashCode() {
        String r0 = this.b;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        String r4 = this.c;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        TextExtraStruct r7 = this.d;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.e;
        if (r10 == null) goto L18;
        r1 = r10.hashCode();
    L18:
        return r9 + r1;
    L13:
        r8 = 0;
        goto L14
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public final String getDesc() {
        return this.c;
    }

    public MentionSpan(d r3) {
        super(r3.a);
        this.e = BuildConfig.FLAVOR;
        this.f = false;
        this.b = r3.c;
        this.c = r3.b;
        this.e = r3.d;
        this.a = r3.e;
        TextExtraStruct r0 = new TextExtraStruct();
        this.d = r0;
        r0.setUserId(r3.c);
        r0.setWebcastUid(r3.c);
        r0.setUser(r3.e);
        this.f = r3.f;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (r5 != null) goto L8;
    L41:
        return false;
    L8:
        if (getClass() != r5.getClass()) goto L41;
        MentionSpan r6 = (MentionSpan) r5;
        String r2 = this.b;
        if (r2 == null) goto L16;
        if (r2.equals(r6.b) == false) goto L17;
    L18:
        String r3 = this.c;
        if (r3 == null) goto L24;
        if (r3.equals(r6.c) == false) goto L25;
    L26:
        TextExtraStruct r4 = this.d;
        if (r4 == null) goto L32;
        if (r4.equals(r6.d) == false) goto L33;
    L34:
        String r7 = this.e;
        String r8 = r6.e;
        if (r7 != null) goto L42;
        if (r8 == null) goto L43;
        return false;
    L43:
        return true;
    L42:
        return r7.equals(r8);
    L33:
        return false;
    L32:
        if (r6.d == null) goto L34;
    L25:
        return false;
    L24:
        if (r6.c == null) goto L26;
    L17:
        return false;
    L16:
        if (r6.b == null) goto L18;
        goto L17
    }

    public MentionSpan(Parcel r2) {
        super(r2);
        this.e = BuildConfig.FLAVOR;
        this.f = false;
        this.b = r2.readString();
        this.c = r2.readString();
        this.d = (TextExtraStruct) r2.readParcelable(TextExtraStruct.class.getClassLoader());
        this.e = r2.readString();
    }

    @Override // android.text.style.ForegroundColorSpan, android.os.Parcelable
    public final void writeToParcel(Parcel r2, int r3) {
        r2.writeString(this.b);
        r2.writeString(this.c);
        r2.writeParcelable(this.d, r3);
        r2.writeString(this.e);
    }
}
