package com.ss.android.lark.chat.entity.chat;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0016\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007B\u0011\b\u0016\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\u0006\u0010\nJ\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u0003H\u0016J\b\u0010\u0012\u001a\u00020\u0003H\u0016J\b\u0010\u0013\u001a\u00020\u0003H\u0016J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0096\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0019"}, d2 = {"Lcom/ss/android/lark/chat/entity/chat/PickChatEntity;", "Landroid/os/Parcelable;", "pickType", BuildConfig.FLAVOR, "id", BuildConfig.FLAVOR, "<init>", "(ILjava/lang/String;)V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "getPickType", "()I", "getId", "()Ljava/lang/String;", "writeToParcel", BuildConfig.FLAVOR, "flags", "describeContents", "hashCode", "equals", BuildConfig.FLAVOR, "other", BuildConfig.FLAVOR, "CREATOR", "im-sdk-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class PickChatEntity implements Parcelable {
    public static final a CREATOR = null;
    public final int a;
    public final String b;

    public static final class a implements Parcelable.Creator<PickChatEntity> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final PickChatEntity createFromParcel(Parcel r3) {
            Intrinsics.checkNotNullParameter(r3, "parcel");
            Intrinsics.checkNotNullParameter(r3, "parcel");
            return new PickChatEntity(r3.readInt(), r3.readString());
        }

        @Override // android.os.Parcelable.Creator
        public final PickChatEntity[] newArray(int r1) {
            return new PickChatEntity[r1];
        }
    }

    static {
        CREATOR = new a();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final int hashCode() {
        return (this.b + this.a).hashCode();
    }

    public final boolean equals(Object r4) {
        if ((r4 instanceof PickChatEntity) == true) goto L5;
        return false;
    L5:
        PickChatEntity r5 = (PickChatEntity) r4;
        if (this.a == r5.a) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.b, r5.b) == false) goto L12;
        return true;
    L12:
        return false;
    }

    public PickChatEntity(int r1, String r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "parcel");
        r1.writeInt(this.a);
        r1.writeString(this.b);
    }
}
