package com.ss.android.lark.forwardv3.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.ss.android.lark.chat.entity.Channel;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 )2\u00020\u0001:\u0002()B\u0007¢\u0006\u0004\b\u0002\u0010\u0003B\u0011\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0002\u0010\u0006J\u0006\u0010!\u001a\u00020\"J\u0006\u0010#\u001a\u00020\u0015J\u0018\u0010$\u001a\u00020%2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010&\u001a\u00020\bH\u0016J\b\u0010'\u001a\u00020\bH\u0016R$\u0010\u0007\u001a\u00020\b8\u0016@\u0016X\u0097\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\t\u0010\u0003\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001a\u001a\u00020\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0017\"\u0004\b\u001c\u0010\u0019R$\u0010\u001d\u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u001e\u0010\u0003\u001a\u0004\b\u001f\u0010\u000b\"\u0004\b \u0010\r¨\u0006*"}, d2 = {"Lcom/ss/android/lark/forwardv3/data/ForwardTargetThreadInfo;", "Lcom/ss/android/lark/forwardv3/data/ForwardTargetBaseInfoNew;", "<init>", "()V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "type", "", "getType$annotations", "getType", "()I", "setType", "(I)V", "channel", "Lcom/ss/android/lark/chat/entity/Channel;", "getChannel", "()Lcom/ss/android/lark/chat/entity/Channel;", "setChannel", "(Lcom/ss/android/lark/chat/entity/Channel;)V", "threadId", "", "getThreadId", "()Ljava/lang/String;", "setThreadId", "(Ljava/lang/String;)V", "p2pChatterId", "getP2pChatterId", "setP2pChatterId", "entityType", "getEntityType$annotations", "getEntityType", "setEntityType", "isReplyInThread", "", "getEntityId", "writeToParcel", "", "flags", "describeContents", "Builder", "CREATOR", "forward-new_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class ForwardTargetThreadInfo extends ForwardTargetBaseInfoNew {
    public static final b CREATOR = null;
    public int f;
    public Channel g;
    public String h;
    public String i;
    public int j;

    public static final class a {
        public Channel a;
        public String b;
        public String c;
        public int d;

        public final ForwardTargetThreadInfo a() {
            ForwardTargetThreadInfo r0 = new ForwardTargetThreadInfo();
            Channel r1 = this.a;
            Intrinsics.checkNotNullParameter(r1, "<set-?>");
            r0.g = r1;
            String r2 = this.b;
            Intrinsics.checkNotNullParameter(r2, "<set-?>");
            r0.h = r2;
            r0.j = this.d;
            String r3 = this.c;
            Intrinsics.checkNotNullParameter(r3, "<set-?>");
            r0.i = r3;
            return r0;
        }

        public a() {
            this.a = new Channel(Channel.Type.UNKNOWN, "");
            this.b = "";
            this.c = "";
            this.d = -1;
        }
    }

    public static final class b implements Parcelable.Creator<ForwardTargetThreadInfo> {
        public b() {
        }

        @Override // android.os.Parcelable.Creator
        public final ForwardTargetThreadInfo createFromParcel(Parcel r4) {
            Intrinsics.checkNotNullParameter(r4, "parcel");
            Intrinsics.checkNotNullParameter(r4, "parcel");
            ForwardTargetThreadInfo r1 = new ForwardTargetThreadInfo();
            r1.a(r4);
            Channel r0 = r4.readSerializable();
            Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type com.ss.android.lark.chat.entity.Channel");
            r1.g = r0;
            String r2 = r4.readString();
            String r3 = "";
            if (r2 != null) goto L5;
            r2 = "";
        L5:
            r1.h = r2;
            String r5 = r4.readString();
            if (r5 == null) goto L9;
            r3 = r5;
        L9:
            r1.i = r3;
            r1.j = r4.readInt();
            return r1;
        }

        @Override // android.os.Parcelable.Creator
        public final ForwardTargetThreadInfo[] newArray(int r1) {
            return new ForwardTargetThreadInfo[r1];
        }
    }

    static {
        CREATOR = new b();
    }

    @Override // com.ss.android.lark.forwardv3.data.ForwardTargetBaseInfoNew, android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public ForwardTargetThreadInfo() {
        this.f = 3;
        this.g = new Channel(Channel.Type.UNKNOWN, "");
        this.h = "";
        this.i = "";
        this.j = -1;
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
        r2.writeSerializable(this.g);
        r2.writeString(this.h);
        r2.writeString(this.i);
        r2.writeInt(this.j);
    }
}
