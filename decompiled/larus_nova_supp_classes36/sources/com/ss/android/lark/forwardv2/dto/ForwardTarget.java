package com.ss.android.lark.forwardv2.dto;

import android.os.Parcel;
import android.os.Parcelable;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.chatter.Chatter;
import com.ss.android.lark.chat.export.entity.chat.OpenChat;
import com.ss.android.lark.chat.export.entity.chatter.OpenChatter;
import java.io.Serializable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public class ForwardTarget implements Parcelable {
    public static final Parcelable.Creator<ForwardTarget> CREATOR = null;
    public String a;
    public String b;
    public String c;
    public boolean d;
    public Serializable e;

    @Retention(RetentionPolicy.SOURCE)
    public @interface TargetType {
        public static final int CHAT = 0;
        public static final int CHATTER = 1;
        public static final int THREAD = 2;
        public static final int UNKNOWN = -1;
    }

    public class a implements Parcelable.Creator<ForwardTarget> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final ForwardTarget createFromParcel(Parcel r2) {
            return new ForwardTarget(r2);
        }

        @Override // android.os.Parcelable.Creator
        public final ForwardTarget[] newArray(int r1) {
            return new ForwardTarget[r1];
        }
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    static {
        CREATOR = new a();
    }

    public final Chatter a() {
        Chatter r0 = this.e;
        if (r0 != null) goto L5;
        return null;
    L5:
        if ((r0 instanceof Chatter) == true) goto L7;
        return null;
    L7:
        return r0;
    }

    public final int b() {
        Serializable r0 = this.e;
        if ((r0 instanceof OpenChat) == false) goto L7;
        return 0;
    L7:
        if ((r0 instanceof OpenChatter) == false) goto L11;
        return 1;
    L11:
        if ((r0 instanceof ThreadTarget) == false) goto L14;
        return 2;
    L14:
        return -1;
    }

    public final ThreadTarget c() {
        Serializable r0 = this.e;
        if ((r0 instanceof ThreadTarget) == true) goto L5;
        return null;
    L5:
        return (ThreadTarget) r0;
    }

    public ForwardTarget(Parcel r2) {
        this.a = r2.readString();
        this.b = r2.readString();
        this.c = r2.readString();
        this.e = r2.readSerializable();
        if (r2.readByte() == 0) goto L5;
        boolean r3 = true;
    L6:
        this.d = r3;
        return;
    L5:
        r3 = false;
        goto L6
    }

    public ForwardTarget(Chat r4) {
        String r0 = r4.getId();
        String r1 = r4.getName();
        String r2 = r4.getAvatarKey();
        this.a = r0;
        this.b = r1;
        this.c = r2;
        this.e = r4;
    }

    public ForwardTarget(Chatter r4) {
        String r0 = r4.getId();
        String r1 = r4.getLocalizedName();
        String r2 = r4.getAvatarKey();
        this.a = r0;
        this.b = r1;
        this.c = r2;
        this.e = r4;
    }

    public ForwardTarget(ThreadTarget r4) {
        String r0 = r4.getId();
        String r1 = r4.getName();
        String r2 = r4.getAvatar();
        this.a = r0;
        this.b = r1;
        this.c = r2;
        this.e = r4;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r1, int r2) {
        r1.writeString(this.a);
        r1.writeString(this.b);
        r1.writeString(this.c);
        r1.writeSerializable(this.e);
        r1.writeByte(this.d ? 1 : 0);
    }
}
