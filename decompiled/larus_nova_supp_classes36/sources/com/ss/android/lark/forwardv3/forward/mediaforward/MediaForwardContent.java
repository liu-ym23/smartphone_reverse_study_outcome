package com.ss.android.lark.forwardv3.forward.mediaforward;

import android.os.Parcel;
import android.os.Parcelable;
import com.ss.android.lark.forwardv3.configuration.IShareContent;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 !2\u00020\u0001:\u0001!B\u0007¢\u0006\u0004\b\u0002\u0010\u0003B\u0011\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0002\u0010\u0006J\b\u0010\u001c\u001a\u00020\u0017H\u0016J\u0018\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u0017H\u0016R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\n\"\u0004\b\u000f\u0010\fR\u001a\u0010\u0010\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\n\"\u0004\b\u0012\u0010\fR\u001a\u0010\u0013\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\n\"\u0004\b\u0015\u0010\fR\u001a\u0010\u0016\u001a\u00020\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b¨\u0006\""}, d2 = {"Lcom/ss/android/lark/forwardv3/forward/mediaforward/MediaForwardContent;", "Lcom/ss/android/lark/forwardv3/configuration/IShareContent;", "<init>", "()V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "videoKey", "", "getVideoKey", "()Ljava/lang/String;", "setVideoKey", "(Ljava/lang/String;)V", "coverKey", "getCoverKey", "setCoverKey", "entityId", "getEntityId", "setEntityId", "messageId", "getMessageId", "setMessageId", "forwardScene", "", "getForwardScene", "()I", "setForwardScene", "(I)V", "describeContents", "writeToParcel", "", "dest", "flags", "CREATOR", "forward-new_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class MediaForwardContent implements IShareContent {
    public static final a CREATOR = null;
    public final String a;
    public final String b;
    public final String c;
    public final String d;
    public final int e;

    public static final class a implements Parcelable.Creator<MediaForwardContent> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final MediaForwardContent createFromParcel(Parcel r2) {
            Intrinsics.checkNotNullParameter(r2, "parcel");
            return new MediaForwardContent(r2);
        }

        @Override // android.os.Parcelable.Creator
        public final MediaForwardContent[] newArray(int r1) {
            return new MediaForwardContent[r1];
        }
    }

    static {
        CREATOR = new a();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public MediaForwardContent() {
        this.a = "";
        this.b = "";
        this.c = "";
        this.d = "";
        this.e = ForwardScene.UNKNOWN.getValue();
    }

    public MediaForwardContent(Parcel r3) {
        Intrinsics.checkNotNullParameter(r3, "parcel");
        this();
        String r0 = r3.readString();
        String r1 = "";
        if (r0 != null) goto L5;
        r0 = "";
    L5:
        this.a = r0;
        String r2 = r3.readString();
        if (r2 != null) goto L8;
        r2 = "";
    L8:
        this.b = r2;
        String r4 = r3.readString();
        if (r4 != null) goto L11;
        r4 = "";
    L11:
        this.c = r4;
        String r5 = r3.readString();
        if (r5 == null) goto L15;
        r1 = r5;
    L15:
        this.d = r1;
        this.e = r3.readInt();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "dest");
        r1.writeString(this.a);
        r1.writeString(this.b);
        r1.writeString(this.c);
        r1.writeString(this.d);
        r1.writeInt(this.e);
    }
}
