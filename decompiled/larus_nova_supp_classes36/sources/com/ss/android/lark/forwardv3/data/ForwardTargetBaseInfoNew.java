package com.ss.android.lark.forwardv3.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0016\u0018\u0000 $2\u00020\u0001:\u0001$B\u0007¢\u0006\u0004\b\u0002\u0010\u0003B\u0011\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0002\u0010\u0006J\u000e\u0010\u001f\u001a\u00020 2\u0006\u0010\u0004\u001a\u00020\u0005J\u0018\u0010!\u001a\u00020 2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\"\u001a\u00020\u0019H\u0016J\b\u0010#\u001a\u00020\u0019H\u0016R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\n\"\u0004\b\u000f\u0010\fR\u001a\u0010\u0010\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\n\"\u0004\b\u0012\u0010\fR\u001a\u0010\u0013\u001a\u00020\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0015\"\u0004\b\u0016\u0010\u0017R$\u0010\u0018\u001a\u00020\u00198\u0016@\u0016X\u0097\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u001a\u0010\u0003\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001e¨\u0006%"}, d2 = {"Lcom/ss/android/lark/forwardv3/data/ForwardTargetBaseInfoNew;", "Landroid/os/Parcelable;", "<init>", "()V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "id", "", "getId", "()Ljava/lang/String;", "setId", "(Ljava/lang/String;)V", "name", "getName", "setName", "avatarKey", "getAvatarKey", "setAvatarKey", "isCrossTenant", "", "()Z", "setCrossTenant", "(Z)V", "type", "", "getType$annotations", "getType", "()I", "setType", "(I)V", "constructor", "", "writeToParcel", "flags", "describeContents", "CREATOR", "forward-new_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public class ForwardTargetBaseInfoNew implements Parcelable {
    public static final a CREATOR = null;
    public String a;
    public String b;
    public String c;
    public boolean d;
    public int e;

    public static final class a implements Parcelable.Creator<ForwardTargetBaseInfoNew> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final ForwardTargetBaseInfoNew createFromParcel(Parcel r3) {
            Intrinsics.checkNotNullParameter(r3, "parcel");
            Intrinsics.checkNotNullParameter(r3, "parcel");
            ForwardTargetBaseInfoNew r1 = new ForwardTargetBaseInfoNew();
            r1.a(r3);
            return r1;
        }

        @Override // android.os.Parcelable.Creator
        public final ForwardTargetBaseInfoNew[] newArray(int r1) {
            return new ForwardTargetBaseInfoNew[r1];
        }
    }

    static {
        CREATOR = new a();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public ForwardTargetBaseInfoNew() {
        this.a = "";
        this.b = "";
        this.c = "";
    }

    public int getType() {
        return this.e;
    }

    public final void a(Parcel r3) {
        Intrinsics.checkNotNullParameter(r3, "parcel");
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
        if (r4 == null) goto L12;
        r1 = r4;
    L12:
        this.c = r1;
        if (r3.readByte() == 0) goto L15;
        boolean r5 = true;
    L16:
        this.d = r5;
        b(r3.readInt());
        return;
    L15:
        r5 = false;
        goto L16
    }

    public void b(int r1) {
        this.e = r1;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "parcel");
        r1.writeString(this.a);
        r1.writeString(this.b);
        r1.writeString(this.c);
        r1.writeByte(this.d ? 1 : 0);
        r1.writeInt(getType());
    }
}
