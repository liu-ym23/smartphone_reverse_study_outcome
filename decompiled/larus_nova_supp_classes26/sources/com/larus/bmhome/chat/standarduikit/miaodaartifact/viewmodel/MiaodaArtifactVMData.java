package com.larus.bmhome.chat.standarduikit.miaodaartifact.viewmodel;

import android.os.Parcel;
import android.os.Parcelable;
import com.larus.im.bean.message.Message;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002B-\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0004HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0006HÆ\u0003J\u0010\u0010\u0017\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u0012J:\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001¢\u0006\u0002\u0010\u0019J\u0006\u0010\u001a\u001a\u00020\tJ\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eHÖ\u0003J\t\u0010\u001f\u001a\u00020\tHÖ\u0001J\t\u0010 \u001a\u00020\u0006HÖ\u0001J\u0016\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\tR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0015\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0011\u0010\u0012¨\u0006&"}, d2 = {"Lcom/larus/bmhome/chat/standarduikit/miaodaartifact/viewmodel/MiaodaArtifactVMData;", "Lcom/larus/bmhome/chat/standarduikit/FlowStandardVMData;", "Landroid/os/Parcelable;", "message", "Lcom/larus/im/bean/message/Message;", "resourceId", "", "fileName", "rootBackgroundRes", "", "<init>", "(Lcom/larus/im/bean/message/Message;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V", "getMessage", "()Lcom/larus/im/bean/message/Message;", "getResourceId", "()Ljava/lang/String;", "getFileName", "getRootBackgroundRes", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "component3", "component4", "copy", "(Lcom/larus/im/bean/message/Message;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)Lcom/larus/bmhome/chat/standarduikit/miaodaartifact/viewmodel/MiaodaArtifactVMData;", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MiaodaArtifactVMData implements Parcelable {
    public static final Parcelable.Creator<MiaodaArtifactVMData> CREATOR = null;
    public final Message a;
    public final String b;
    public final String c;
    public final Integer d;

    public static final class a implements Parcelable.Creator<MiaodaArtifactVMData> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final MiaodaArtifactVMData createFromParcel(Parcel r6) {
            Intrinsics.checkNotNullParameter(r6, "parcel");
            Message r1 = r6.readSerializable();
            String r2 = r6.readString();
            String r3 = r6.readString();
            if (r6.readInt() != 0) goto L5;
            Integer r7 = null;
        L7:
            return new MiaodaArtifactVMData(r1, r2, r3, r7);
        L5:
            r7 = Integer.valueOf(r6.readInt());
            goto L7
        }

        @Override // android.os.Parcelable.Creator
        public final MiaodaArtifactVMData[] newArray(int r1) {
            return new MiaodaArtifactVMData[r1];
        }
    }

    static {
        CREATOR = new a();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof MiaodaArtifactVMData) == true) goto L8;
        return false;
    L8:
        MiaodaArtifactVMData r6 = (MiaodaArtifactVMData) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r0 = this.a.hashCode() * 31;
        String r1 = this.b;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (((r0 + r3) * 31) + this.c.hashCode()) * 31;
        Integer r5 = this.d;
        if (r5 == null) goto L11;
        r2 = r5.hashCode();
    L11:
        return r4 + r2;
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public final String toString() {
        return "MiaodaArtifactVMData(message=" + this.a + ", resourceId=" + this.b + ", fileName=" + this.c + ", rootBackgroundRes=" + this.d + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "dest");
        r2.writeSerializable(this.a);
        r2.writeString(this.b);
        r2.writeString(this.c);
        Integer r4 = this.d;
        if (r4 != null) goto L5;
        int r5 = 0;
    L6:
        r2.writeInt(r5);
        return;
    L5:
        r2.writeInt(1);
        r5 = r4.intValue();
        goto L6
    }

    public MiaodaArtifactVMData(Message r2, String r3, String r4, Integer r5) {
        Intrinsics.checkNotNullParameter(r2, "message");
        Intrinsics.checkNotNullParameter(r4, "fileName");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
    }
}
