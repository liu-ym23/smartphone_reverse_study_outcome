package com.ss.android.lark.forwardv3.messageforward;

import android.os.Parcel;
import android.os.Parcelable;
import com.ss.android.lark.forwardv3.configuration.IForwardContent;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 !2\u00020\u0001:\u0002 !B\u0007¢\u0006\u0004\b\u0002\u0010\u0003B\u0011\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0002\u0010\u0006J\u0018\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\bH\u0016J\b\u0010\u001f\u001a\u00020\bH\u0016R$\u0010\u0007\u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\t\u0010\u0003\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0011\"\u0004\b\u0016\u0010\u0013R\u001a\u0010\u0017\u001a\u00020\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0019\"\u0004\b\u001a\u0010\u001b¨\u0006\""}, d2 = {"Lcom/ss/android/lark/forwardv3/messageforward/SingleMessageForwardContent;", "Lcom/ss/android/lark/forwardv3/configuration/IForwardContent;", "<init>", "()V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "singleSource", "", "getSingleSource$annotations", "getSingleSource", "()I", "setSingleSource", "(I)V", "originMergeForwardId", "", "getOriginMergeForwardId", "()Ljava/lang/String;", "setOriginMergeForwardId", "(Ljava/lang/String;)V", "favoriteId", "getFavoriteId", "setFavoriteId", "isThreadRootMsg", "", "()Z", "setThreadRootMsg", "(Z)V", "writeToParcel", "", "flags", "describeContents", "Builder", "CREATOR", "forward-new_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class SingleMessageForwardContent implements IForwardContent {
    public static final b CREATOR = null;
    public int a;
    public String b;
    public String c;
    public boolean d;

    public static final class a {
        public int a;
        public String b;
        public String c;
        public boolean d;

        public a() {
            this.b = "";
            this.c = "";
        }
    }

    public static final class b implements Parcelable.Creator<SingleMessageForwardContent> {
        public b() {
        }

        @Override // android.os.Parcelable.Creator
        public final SingleMessageForwardContent createFromParcel(Parcel r4) {
            Intrinsics.checkNotNullParameter(r4, "parcel");
            Intrinsics.checkNotNullParameter(r4, "parcel");
            SingleMessageForwardContent r1 = new SingleMessageForwardContent();
            r1.a = r4.readInt();
            String r0 = r4.readString();
            String r2 = "";
            if (r0 != null) goto L5;
            r0 = "";
        L5:
            r1.b = r0;
            String r3 = r4.readString();
            if (r3 == null) goto L9;
            r2 = r3;
        L9:
            r1.c = r2;
            boolean r5 = true;
            if (r4.readInt() == 1) goto L13;
            r5 = false;
        L13:
            r1.d = r5;
            return r1;
        }

        @Override // android.os.Parcelable.Creator
        public final SingleMessageForwardContent[] newArray(int r1) {
            return new SingleMessageForwardContent[r1];
        }
    }

    static {
        CREATOR = new b();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public SingleMessageForwardContent() {
        this.b = "";
        this.c = "";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "parcel");
        r1.writeInt(this.a);
        r1.writeString(this.b);
        r1.writeString(this.c);
        r1.writeInt(this.d ? 1 : 0);
    }
}
