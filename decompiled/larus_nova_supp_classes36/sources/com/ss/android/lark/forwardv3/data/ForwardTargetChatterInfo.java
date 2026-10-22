package com.ss.android.lark.forwardv3.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.ss.android.lark.chat.entity.chatter.Chatter;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 $2\u00020\u0001:\u0002#$B\u0007¢\u0006\u0004\b\u0002\u0010\u0003B\u0011\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0002\u0010\u0006J\u0006\u0010\u001d\u001a\u00020\u001eJ\u0018\u0010\u001f\u001a\u00020 2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010!\u001a\u00020\bH\u0016J\b\u0010\"\u001a\u00020\bH\u0016R$\u0010\u0007\u001a\u00020\b8\u0016@\u0016X\u0097\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\t\u0010\u0003\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0011\"\u0004\b\u0016\u0010\u0013R\u001a\u0010\u0017\u001a\u00020\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001c¨\u0006%"}, d2 = {"Lcom/ss/android/lark/forwardv3/data/ForwardTargetChatterInfo;", "Lcom/ss/android/lark/forwardv3/data/ForwardTargetBaseInfoNew;", "<init>", "()V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "type", "", "getType$annotations", "getType", "()I", "setType", "(I)V", "chatterId", "", "getChatterId", "()Ljava/lang/String;", "setChatterId", "(Ljava/lang/String;)V", "p2pChatId", "getP2pChatId", "setP2pChatId", "chatterType", "Lcom/ss/android/lark/chat/entity/chatter/Chatter$ChatterType;", "getChatterType", "()Lcom/ss/android/lark/chat/entity/chatter/Chatter$ChatterType;", "setChatterType", "(Lcom/ss/android/lark/chat/entity/chatter/Chatter$ChatterType;)V", "isBot", "", "writeToParcel", "", "flags", "describeContents", "Builder", "CREATOR", "forward-new_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class ForwardTargetChatterInfo extends ForwardTargetBaseInfoNew {
    public static final b CREATOR = null;
    public int f;
    public String g;
    public String h;
    public Chatter.ChatterType i;

    public static final class a {
        public String a;
        public String b;
        public Chatter.ChatterType c;

        public a() {
            this.a = "";
            this.b = "";
            this.c = Chatter.ChatterType.UNKNOWN;
        }
    }

    public static final class b implements Parcelable.Creator<ForwardTargetChatterInfo> {
        public b() {
        }

        @Override // android.os.Parcelable.Creator
        public final ForwardTargetChatterInfo createFromParcel(Parcel r4) {
            Intrinsics.checkNotNullParameter(r4, "parcel");
            Intrinsics.checkNotNullParameter(r4, "parcel");
            ForwardTargetChatterInfo r1 = new ForwardTargetChatterInfo();
            r1.a(r4);
            String r0 = r4.readString();
            String r2 = "";
            if (r0 != null) goto L5;
            r0 = "";
        L5:
            r1.g = r0;
            String r3 = r4.readString();
            if (r3 == null) goto L9;
            r2 = r3;
        L9:
            r1.h = r2;
            r1.i = Chatter.ChatterType.forNumber(r4.readInt());
            return r1;
        }

        @Override // android.os.Parcelable.Creator
        public final ForwardTargetChatterInfo[] newArray(int r1) {
            return new ForwardTargetChatterInfo[r1];
        }
    }

    static {
        CREATOR = new b();
    }

    @Override // com.ss.android.lark.forwardv3.data.ForwardTargetBaseInfoNew, android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public ForwardTargetChatterInfo() {
        this.f = 2;
        this.g = "";
        this.h = "";
        this.i = Chatter.ChatterType.UNKNOWN;
    }

    @Override // com.ss.android.lark.forwardv3.data.ForwardTargetBaseInfoNew
    public int getType() {
        return this.f;
    }

    @Override // com.ss.android.lark.forwardv3.data.ForwardTargetBaseInfoNew
    public final void b(int r1) {
        this.f = r1;
    }

    @Override // com.ss.android.lark.forwardv3.data.ForwardTargetBaseInfoNew, android.os.Parcelable
    public final void writeToParcel(Parcel r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "parcel");
        super.writeToParcel(r2, r3);
        r2.writeString(this.g);
        r2.writeString(this.h);
        r2.writeInt(this.i.getNumber());
    }
}
