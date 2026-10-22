package com.larus.bmhome.chat.standarduikit.codeartifact.viewmodel;

import android.os.Parcel;
import android.os.Parcelable;
import com.larus.im.bean.message.Message;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002B9\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\f\u0010\rJ\t\u0010\u0019\u001a\u00020\u0004HÆ\u0003J\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0011J\t\u0010\u001b\u001a\u00020\bHÆ\u0003J\u0010\u0010\u001c\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010\u0016J\u0010\u0010\u001d\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010\u0016JF\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\nHÆ\u0001¢\u0006\u0002\u0010\u001fJ\u0006\u0010 \u001a\u00020\nJ\u0013\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010$HÖ\u0003J\t\u0010%\u001a\u00020\nHÖ\u0001J\t\u0010&\u001a\u00020\bHÖ\u0001J\u0016\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\nR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0015\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u0015\u0010\u0016R\u0015\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u0018\u0010\u0016¨\u0006,"}, d2 = {"Lcom/larus/bmhome/chat/standarduikit/codeartifact/viewmodel/CodeArtifactVMData;", "Lcom/larus/bmhome/chat/standarduikit/FlowStandardVMData;", "Landroid/os/Parcelable;", "message", "Lcom/larus/im/bean/message/Message;", "codeId", "", "fileName", "", "version", "", "rootBackgroundRes", "<init>", "(Lcom/larus/im/bean/message/Message;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;)V", "getMessage", "()Lcom/larus/im/bean/message/Message;", "getCodeId", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getFileName", "()Ljava/lang/String;", "getVersion", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getRootBackgroundRes", "component1", "component2", "component3", "component4", "component5", "copy", "(Lcom/larus/im/bean/message/Message;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/larus/bmhome/chat/standarduikit/codeartifact/viewmodel/CodeArtifactVMData;", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CodeArtifactVMData implements Parcelable {
    public static final Parcelable.Creator<CodeArtifactVMData> CREATOR = null;
    public final Message a;
    public final Long b;
    public final String c;
    public final Integer d;
    public final Integer e;

    public static final class a implements Parcelable.Creator<CodeArtifactVMData> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final CodeArtifactVMData createFromParcel(Parcel r8) {
            Intrinsics.checkNotNullParameter(r8, "parcel");
            Message r2 = r8.readSerializable();
            if (r8.readInt() != 0) goto L5;
            Long r4 = null;
        L6:
            String r5 = r8.readString();
            if (r8.readInt() != 0) goto L9;
            Integer r6 = null;
        L11:
            if (r8.readInt() != 0) goto L13;
            Integer r9 = null;
        L15:
            return new CodeArtifactVMData(r2, r4, r5, r6, r9);
        L13:
            r9 = Integer.valueOf(r8.readInt());
            goto L15
        L9:
            r6 = Integer.valueOf(r8.readInt());
            goto L11
        L5:
            r4 = Long.valueOf(r8.readLong());
            goto L6
        }

        @Override // android.os.Parcelable.Creator
        public final CodeArtifactVMData[] newArray(int r1) {
            return new CodeArtifactVMData[r1];
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
        if ((r5 instanceof CodeArtifactVMData) == true) goto L8;
        return false;
    L8:
        CodeArtifactVMData r6 = (CodeArtifactVMData) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r6.e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r0 = this.a.hashCode() * 31;
        Long r1 = this.b;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (((r0 + r3) * 31) + this.c.hashCode()) * 31;
        Integer r5 = this.d;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (r4 + r6) * 31;
        Integer r8 = this.e;
        if (r8 == null) goto L15;
        r2 = r8.hashCode();
    L15:
        return r7 + r2;
    L9:
        r6 = r5.hashCode();
        goto L10
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public final String toString() {
        return "CodeArtifactVMData(message=" + this.a + ", codeId=" + this.b + ", fileName=" + this.c + ", version=" + this.d + ", rootBackgroundRes=" + this.e + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r5, int r6) {
        Intrinsics.checkNotNullParameter(r5, "dest");
        r5.writeSerializable(this.a);
        Long r7 = this.b;
        if (r7 != null) goto L5;
        r5.writeInt(0);
    L6:
        r5.writeString(this.c);
        Integer r8 = this.d;
        if (r8 != null) goto L9;
        r5.writeInt(0);
    L10:
        Integer r9 = this.e;
        if (r9 != null) goto L13;
        r5.writeInt(0);
        return;
    L13:
        r5.writeInt(1);
        r5.writeInt(r9.intValue());
        return;
    L9:
        r5.writeInt(1);
        r5.writeInt(r8.intValue());
        goto L10
    L5:
        r5.writeInt(1);
        r5.writeLong(r7.longValue());
        goto L6
    }

    public CodeArtifactVMData(Message r2, Long r3, String r4, Integer r5, Integer r6) {
        Intrinsics.checkNotNullParameter(r2, "message");
        Intrinsics.checkNotNullParameter(r4, "fileName");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
    }
}
