package com.ss.android.lark.dto.group;

import android.os.Parcel;
import android.os.Parcelable;
import com.ss.android.lark.chat.entity.chat.PickChatEntity;
import com.ss.ttvideoengine.strategrycenter.IPortraitService;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B)\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bB\u0011\b\u0016\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0007\u0010\u000bJ\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u0003H\u0016J\b\u0010\u0011\u001a\u00020\u0003H\u0016R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0013"}, d2 = {"Lcom/ss/android/lark/dto/group/GroupRecallEntity;", "Lcom/ss/android/lark/chat/entity/chat/PickChatEntity;", "pickType", BuildConfig.FLAVOR, "id", BuildConfig.FLAVOR, IPortraitService.NAME, "<init>", "(ILjava/lang/String;Ljava/lang/String;)V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "getName", "()Ljava/lang/String;", "writeToParcel", BuildConfig.FLAVOR, "flags", "describeContents", "CREATOR", "chat-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class GroupRecallEntity extends PickChatEntity {
    public static final a CREATOR = null;
    public final String c;

    public static final class a implements Parcelable.Creator<PickChatEntity> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final PickChatEntity createFromParcel(Parcel r4) {
            Intrinsics.checkNotNullParameter(r4, "parcel");
            Intrinsics.checkNotNullParameter(r4, "parcel");
            return new GroupRecallEntity(r4.readInt(), r4.readString(), r4.readString());
        }

        @Override // android.os.Parcelable.Creator
        public final PickChatEntity[] newArray(int r1) {
            return new GroupRecallEntity[r1];
        }
    }

    static {
        CREATOR = new a();
    }

    @Override // com.ss.android.lark.chat.entity.chat.PickChatEntity, android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // com.ss.android.lark.chat.entity.chat.PickChatEntity, android.os.Parcelable
    public final void writeToParcel(Parcel r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "parcel");
        r1.writeInt(this.a);
        r1.writeString(this.b);
        r1.writeString(this.c);
    }

    public GroupRecallEntity(int r1, String r2, String r3) {
        super(r1, r2);
        this.c = r3;
    }
}
