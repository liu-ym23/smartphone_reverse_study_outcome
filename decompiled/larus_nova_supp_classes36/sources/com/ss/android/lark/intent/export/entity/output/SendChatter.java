package com.ss.android.lark.intent.export.entity.output;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.notification.export.entity.INotificationHitPoint;
import java.io.File;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002B+\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\t\u0010\nJ\b\u0010\u0011\u001a\u00020\u0004H\u0016J\t\u0010\u0012\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0004HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0004HÆ\u0003J5\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0004HÆ\u0001J\u0006\u0010\u0017\u001a\u00020\u0018J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cHÖ\u0003J\t\u0010\u001d\u001a\u00020\u0018HÖ\u0001J\u0016\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u0018R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\f¨\u0006#"}, d2 = {"Lcom/ss/android/lark/intent/export/entity/output/SendChatter;", "Ljava/io/Serializable;", "Landroid/os/Parcelable;", "id", "", "name", "avatar", "Ljava/io/File;", "department", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/io/File;Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "getName", "getAvatar", "()Ljava/io/File;", "getDepartment", "toString", "component1", "component2", "component3", "component4", "copy", "describeContents", "", "equals", "", INotificationHitPoint.NoticeType.OTHER, "", "hashCode", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "intent-export_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class SendChatter implements Serializable, Parcelable {
    public static final Parcelable.Creator<SendChatter> CREATOR = null;
    private final File avatar;
    private final String department;
    private final String id;
    private final String name;

    @Metadata(k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
    public static final class Creator implements Parcelable.Creator<SendChatter> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final SendChatter createFromParcel(Parcel r5) {
            Intrinsics.checkNotNullParameter(r5, "parcel");
            return new SendChatter(r5.readString(), r5.readString(), (File) r5.readSerializable(), r5.readString());
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ SendChatter createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final SendChatter[] newArray(int r1) {
            return new SendChatter[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ SendChatter[] newArray(int r1) {
            return newArray(r1);
        }
    }

    static {
        CREATOR = new Creator();
    }

    public static /* synthetic */ SendChatter copy$default(SendChatter r0, String r1, String r2, File r3, String r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = r0.id;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = r0.name;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r3 = r0.avatar;
    L12:
        if ((r5 & 8) == 0) goto L15;
        r4 = r0.department;
    L15:
        return r0.copy(r1, r2, r3, r4);
    }

    public final String component1() {
        return this.id;
    }

    public final String component2() {
        return this.name;
    }

    public final File component3() {
        return this.avatar;
    }

    public final String component4() {
        return this.department;
    }

    public final SendChatter copy(String r2, String r3, File r4, String r5) {
        Intrinsics.checkNotNullParameter(r2, "id");
        Intrinsics.checkNotNullParameter(r3, "name");
        return new SendChatter(r2, r3, r4, r5);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof SendChatter) == true) goto L8;
        return false;
    L8:
        SendChatter r6 = (SendChatter) r5;
        if (Intrinsics.areEqual(this.id, r6.id) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.name, r6.name) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.avatar, r6.avatar) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.department, r6.department) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        int r0 = ((this.id.hashCode() * 31) + this.name.hashCode()) * 31;
        File r1 = this.avatar;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        String r5 = this.department;
        if (r5 == null) goto L11;
        r2 = r5.hashCode();
    L11:
        return r4 + r2;
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "dest");
        r1.writeString(this.id);
        r1.writeString(this.name);
        r1.writeSerializable(this.avatar);
        r1.writeString(this.department);
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder("SendChatter(id='");
        r0.append(this.id);
        r0.append("', name='");
        r0.append(this.name);
        r0.append("', avatar=");
        File r1 = this.avatar;
        if (r1 == null) goto L5;
        Uri r2 = Uri.fromFile(r1);
    L6:
        r0.append(r2);
        r0.append(", department=");
        r0.append(this.department);
        r0.append(')');
        return r0.toString();
    L5:
        r2 = null;
        goto L6
    }

    public final File getAvatar() {
        return this.avatar;
    }

    public final String getDepartment() {
        return this.department;
    }

    public final String getId() {
        return this.id;
    }

    public final String getName() {
        return this.name;
    }

    public SendChatter(String r2, String r3, File r4, String r5) {
        Intrinsics.checkNotNullParameter(r2, "id");
        Intrinsics.checkNotNullParameter(r3, "name");
        this.id = r2;
        this.name = r3;
        this.avatar = r4;
        this.department = r5;
    }
}
