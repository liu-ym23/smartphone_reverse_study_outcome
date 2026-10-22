package com.suite.lark.platform.feature.forward.doubao.file;

import android.os.Parcel;
import android.os.Parcelable;
import com.ss.android.lark.forwardv3.configuration.IForwardContent;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 &2\u00020\u0001:\u0001&B\u0007¢\u0006\u0004\b\u0002\u0010\u0003B\u0011\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0002\u0010\u0006B\u0011\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\u0002\u0010\tJ\u0018\u0010\"\u001a\u00020#2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010$\u001a\u00020\u0014H\u0016J\b\u0010%\u001a\u00020\u0014H\u0016R\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR\u001a\u0010\u0013\u001a\u00020\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0019\u001a\u00020\u001aX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001a\u0010\u001f\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\r\"\u0004\b!\u0010\u000f¨\u0006'"}, d2 = {"Lcom/suite/lark/platform/feature/forward/doubao/file/DoubaoFileForwardContent;", "Lcom/ss/android/lark/forwardv3/configuration/IForwardContent;", "<init>", "()V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "request", "Lcom/suite/lark/platform/feature/forward/doubao/api/entity/DoubaoFileForwardRequest;", "(Lcom/suite/lark/platform/feature/forward/doubao/api/entity/DoubaoFileForwardRequest;)V", "resourceUri", "", "getResourceUri", "()Ljava/lang/String;", "setResourceUri", "(Ljava/lang/String;)V", "fileName", "getFileName", "setFileName", "storageType", "", "getStorageType", "()I", "setStorageType", "(I)V", "fileSize", "", "getFileSize", "()J", "setFileSize", "(J)V", "mimeType", "getMimeType", "setMimeType", "writeToParcel", "", "flags", "describeContents", "CREATOR", "forward-doubao_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class DoubaoFileForwardContent implements IForwardContent {
    public static final a CREATOR = null;
    public final String a;
    public final String b;
    public final int c;
    public final long d;
    public final String e;

    public static final class a implements Parcelable.Creator<DoubaoFileForwardContent> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final DoubaoFileForwardContent createFromParcel(Parcel r2) {
            Intrinsics.checkNotNullParameter(r2, "parcel");
            return new DoubaoFileForwardContent(r2);
        }

        @Override // android.os.Parcelable.Creator
        public final DoubaoFileForwardContent[] newArray(int r1) {
            return new DoubaoFileForwardContent[r1];
        }
    }

    static {
        CREATOR = new a();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public DoubaoFileForwardContent() {
        this.a = "";
        this.b = "";
        this.e = "";
    }

    public DoubaoFileForwardContent(Parcel r5) {
        Intrinsics.checkNotNullParameter(r5, "parcel");
        this();
        String r0 = r5.readString();
        String r1 = "";
        if (r0 != null) goto L5;
        r0 = "";
    L5:
        this.a = r0;
        String r2 = r5.readString();
        if (r2 != null) goto L8;
        r2 = "";
    L8:
        this.b = r2;
        this.c = r5.readInt();
        this.d = r5.readLong();
        String r6 = r5.readString();
        if (r6 == null) goto L12;
        r1 = r6;
    L12:
        this.e = r1;
    }

    public DoubaoFileForwardContent(npc.a r3) {
        Intrinsics.checkNotNullParameter(r3, "request");
        this();
        this.a = r3.a;
        this.b = r3.b;
        this.c = r3.c;
        this.d = r3.d;
        this.e = r3.e;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "parcel");
        r3.writeString(this.a);
        r3.writeString(this.b);
        r3.writeInt(this.c);
        r3.writeLong(this.d);
        r3.writeString(this.e);
    }
}
