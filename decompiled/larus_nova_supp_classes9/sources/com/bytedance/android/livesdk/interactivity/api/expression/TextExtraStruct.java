package com.bytedance.android.livesdk.interactivity.api.expression;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.android.live.base.model.user.IBaseUser;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Objects;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public class TextExtraStruct implements Parcelable, Serializable, Cloneable {
    public static final Parcelable.Creator<TextExtraStruct> CREATOR = null;
    boolean boldText;
    int color;
    private Object customSpan;
    int end;
    public HashMap<String, Object> extraParams;
    int start;
    IBaseUser user;
    String userId;
    String webcastUid;

    public class a implements Parcelable.Creator<TextExtraStruct> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final TextExtraStruct createFromParcel(Parcel r2) {
            return new TextExtraStruct(r2);
        }

        @Override // android.os.Parcelable.Creator
        public final TextExtraStruct[] newArray(int r1) {
            return new TextExtraStruct[r1];
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    static {
        CREATOR = new a();
    }

    public int hashCode() {
        String r0 = this.userId;
        if (r0 == null) goto L5;
        int r1 = r0.hashCode();
    L7:
        return 0 + r1;
    L5:
        r1 = 0;
        goto L7
    }

    public TextExtraStruct clone() {
        return (TextExtraStruct) super.clone();
    L4:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    public TextExtraStruct() {
    }

    public int getColor() {
        return this.color;
    }

    public int getEnd() {
        return this.end;
    }

    public int getStart() {
        return this.start;
    }

    public IBaseUser getUser() {
        return this.user;
    }

    public String getUserId() {
        return this.userId;
    }

    public String getWebcastUid() {
        return this.webcastUid;
    }

    /* JADX INFO: renamed from: clone, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m449clone() throws CloneNotSupportedException {
        return clone();
    }

    public TextExtraStruct(Parcel r2) {
        this.start = r2.readInt();
        this.end = r2.readInt();
        this.userId = r2.readString();
        this.webcastUid = r2.readString();
    }

    public boolean equals(Object r2) {
        if (this != r2) goto L6;
        return true;
    L6:
        if ((r2 instanceof TextExtraStruct) == true) goto L10;
        return false;
    L10:
        return Objects.equals(this.userId, ((TextExtraStruct) r2).userId);
    }

    public void setEnd(int r1) {
        this.end = r1;
    }

    public void setStart(int r1) {
        this.start = r1;
    }

    public void setUser(IBaseUser r1) {
        this.user = r1;
    }

    public void setUserId(String r1) {
        this.userId = r1;
    }

    public void setWebcastUid(String r1) {
        this.webcastUid = r1;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r1, int r2) {
        r1.writeInt(this.start);
        r1.writeInt(this.end);
        r1.writeString(this.userId);
        r1.writeString(this.webcastUid);
    }
}
