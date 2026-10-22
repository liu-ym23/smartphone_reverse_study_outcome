package com.ss.android.lark.forwardv3.messageforward;

import android.os.Parcel;
import android.os.Parcelable;
import com.ss.android.lark.forwardv3.configuration.IForwardContent;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 02\u00020\u0001:\u0002/0B\u0007¢\u0006\u0004\b\u0002\u0010\u0003B\u0011\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0002\u0010\u0006J\u0018\u0010+\u001a\u00020,2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010-\u001a\u00020\bH\u0016J\b\u0010.\u001a\u00020\bH\u0016R$\u0010\u0007\u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\t\u0010\u0003\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R*\u0010\u0014\u001a\u0012\u0012\u0004\u0012\u00020\u000f0\u0015j\b\u0012\u0004\u0012\u00020\u000f`\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0011\"\u0004\b\u001d\u0010\u0013R\u001a\u0010\u001e\u001a\u00020\u001fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010 \"\u0004\b!\u0010\"R\u001a\u0010#\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u0011\"\u0004\b%\u0010\u0013R\u001a\u0010&\u001a\u00020\u001fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010 \"\u0004\b'\u0010\"R\u001a\u0010(\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u0011\"\u0004\b*\u0010\u0013¨\u00061"}, d2 = {"Lcom/ss/android/lark/forwardv3/messageforward/MergeMessageForwardContent;", "Lcom/ss/android/lark/forwardv3/configuration/IForwardContent;", "<init>", "()V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "mergeSource", "", "getMergeSource$annotations", "getMergeSource", "()I", "setMergeSource", "(I)V", "originMergeForwardId", "", "getOriginMergeForwardId", "()Ljava/lang/String;", "setOriginMergeForwardId", "(Ljava/lang/String;)V", "messageIds", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getMessageIds", "()Ljava/util/ArrayList;", "setMessageIds", "(Ljava/util/ArrayList;)V", "quasiTitle", "getQuasiTitle", "setQuasiTitle", "isThread", "", "()Z", "setThread", "(Z)V", "threadId", "getThreadId", "setThreadId", "isLimit", "setLimit", "chatId", "getChatId", "setChatId", "writeToParcel", "", "flags", "describeContents", "Builder", "CREATOR", "forward-new_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class MergeMessageForwardContent implements IForwardContent {
    public static final b CREATOR = null;
    public int a;
    public String b;
    public ArrayList<String> c;
    public String d;
    public boolean e;
    public String f;
    public boolean g;
    public String h;

    public static final class a {
        public int a;
        public String b;
        public ArrayList<String> c;
        public String d;
        public boolean e;
        public String f;
        public String g;

        public final MergeMessageForwardContent a() {
            MergeMessageForwardContent r0 = new MergeMessageForwardContent();
            r0.a = this.a;
            String r1 = this.b;
            Intrinsics.checkNotNullParameter(r1, "<set-?>");
            r0.b = r1;
            ArrayList<String> r2 = this.c;
            Intrinsics.checkNotNullParameter(r2, "<set-?>");
            r0.c = r2;
            String r3 = this.d;
            Intrinsics.checkNotNullParameter(r3, "<set-?>");
            r0.d = r3;
            r0.e = this.e;
            String r4 = this.f;
            Intrinsics.checkNotNullParameter(r4, "<set-?>");
            r0.f = r4;
            r0.g = false;
            String r5 = this.g;
            Intrinsics.checkNotNullParameter(r5, "<set-?>");
            r0.h = r5;
            return r0;
        }

        public a() {
            this.b = "";
            this.c = new ArrayList();
            this.d = "";
            this.f = "";
            this.g = "";
        }
    }

    public static final class b implements Parcelable.Creator<MergeMessageForwardContent> {
        public b() {
        }

        @Override // android.os.Parcelable.Creator
        public final MergeMessageForwardContent createFromParcel(Parcel r6) {
            Intrinsics.checkNotNullParameter(r6, "parcel");
            Intrinsics.checkNotNullParameter(r6, "parcel");
            MergeMessageForwardContent r1 = new MergeMessageForwardContent();
            r1.a = r6.readInt();
            String r0 = r6.readString();
            String r2 = "";
            if (r0 != null) goto L5;
            r0 = "";
        L5:
            r1.b = r0;
            ArrayList<String> r3 = r6.readArrayList(String.class.getClassLoader());
            Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type java.util.ArrayList<kotlin.String>");
            r1.c = r3;
            String r4 = r6.readString();
            if (r4 != null) goto L8;
            r4 = "";
        L8:
            r1.d = r4;
            boolean r5 = true;
            if (r6.readByte() == 0) goto L11;
            boolean r7 = true;
        L12:
            r1.e = r7;
            String r8 = r6.readString();
            if (r8 != null) goto L15;
            r8 = "";
        L15:
            r1.f = r8;
            if (r6.readByte() != 0) goto L19;
            r5 = false;
        L19:
            r1.g = r5;
            String r9 = r6.readString();
            if (r9 == null) goto L23;
            r2 = r9;
        L23:
            r1.h = r2;
            return r1;
        L11:
            r7 = false;
            goto L12
        }

        @Override // android.os.Parcelable.Creator
        public final MergeMessageForwardContent[] newArray(int r1) {
            return new MergeMessageForwardContent[r1];
        }
    }

    static {
        CREATOR = new b();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public MergeMessageForwardContent() {
        this.b = "";
        this.c = new ArrayList();
        this.d = "";
        this.f = "";
        this.h = "";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "parcel");
        r1.writeInt(this.a);
        r1.writeString(this.b);
        r1.writeList(this.c);
        r1.writeString(this.d);
        r1.writeByte(this.e ? 1 : 0);
        r1.writeString(this.f);
        r1.writeByte(this.g ? 1 : 0);
        r1.writeString(this.h);
    }
}
