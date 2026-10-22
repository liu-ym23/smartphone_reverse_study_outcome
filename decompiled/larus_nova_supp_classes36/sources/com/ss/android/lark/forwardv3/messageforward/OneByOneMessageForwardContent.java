package com.ss.android.lark.forwardv3.messageforward;

import android.os.Parcel;
import android.os.Parcelable;
import com.ss.android.lark.forwardv3.configuration.IForwardContent;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 #2\u00020\u0001:\u0002\"#B\u0007¢\u0006\u0004\b\u0002\u0010\u0003B\u0011\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0002\u0010\u0006J\u0018\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\bH\u0016J\b\u0010!\u001a\u00020\bH\u0016R$\u0010\u0007\u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\t\u0010\u0003\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R*\u0010\u0014\u001a\u0012\u0012\u0004\u0012\u00020\u000f0\u0015j\b\u0012\u0004\u0012\u00020\u000f`\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0011\"\u0004\b\u001d\u0010\u0013¨\u0006$"}, d2 = {"Lcom/ss/android/lark/forwardv3/messageforward/OneByOneMessageForwardContent;", "Lcom/ss/android/lark/forwardv3/configuration/IForwardContent;", "<init>", "()V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "oneByOneSource", "", "getOneByOneSource$annotations", "getOneByOneSource", "()I", "setOneByOneSource", "(I)V", "originMergeForwardId", "", "getOriginMergeForwardId", "()Ljava/lang/String;", "setOriginMergeForwardId", "(Ljava/lang/String;)V", "messageIds", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getMessageIds", "()Ljava/util/ArrayList;", "setMessageIds", "(Ljava/util/ArrayList;)V", "chatId", "getChatId", "setChatId", "writeToParcel", "", "flags", "describeContents", "Builder", "CREATOR", "forward-new_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class OneByOneMessageForwardContent implements IForwardContent {
    public static final b CREATOR = null;
    public int a;
    public String b;
    public ArrayList<String> c;
    public String d;

    public static final class a {
        public int a;
        public String b;
        public ArrayList<String> c;
        public String d;

        public a() {
            this.b = "";
            this.c = new ArrayList();
            this.d = "";
        }
    }

    public static final class b implements Parcelable.Creator<OneByOneMessageForwardContent> {
        public b() {
        }

        @Override // android.os.Parcelable.Creator
        public final OneByOneMessageForwardContent createFromParcel(Parcel r5) {
            Intrinsics.checkNotNullParameter(r5, "parcel");
            Intrinsics.checkNotNullParameter(r5, "parcel");
            OneByOneMessageForwardContent r1 = new OneByOneMessageForwardContent();
            r1.a = r5.readInt();
            String r0 = r5.readString();
            String r2 = "";
            if (r0 != null) goto L5;
            r0 = "";
        L5:
            r1.b = r0;
            ArrayList<String> r3 = r5.readArrayList(String.class.getClassLoader());
            Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type java.util.ArrayList<kotlin.String>");
            r1.c = r3;
            String r6 = r5.readString();
            if (r6 == null) goto L9;
            r2 = r6;
        L9:
            r1.d = r2;
            return r1;
        }

        @Override // android.os.Parcelable.Creator
        public final OneByOneMessageForwardContent[] newArray(int r1) {
            return new OneByOneMessageForwardContent[r1];
        }
    }

    static {
        CREATOR = new b();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public OneByOneMessageForwardContent() {
        this.b = "";
        this.c = new ArrayList();
        this.d = "";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "parcel");
        r1.writeInt(this.a);
        r1.writeString(this.b);
        r1.writeList(this.c);
        r1.writeString(this.d);
    }
}
