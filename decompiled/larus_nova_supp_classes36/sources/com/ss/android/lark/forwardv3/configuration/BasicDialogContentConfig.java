package com.ss.android.lark.forwardv3.configuration;

import android.os.Parcel;
import android.os.Parcelable;
import com.ss.android.lark.forwardv3.configuration.dto.StickImage;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.image.entity.Image;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 ;2\u00020\u0001:\u0002:;B\u0007¢\u0006\u0004\b\u0002\u0010\u0003B\u0011\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0002\u0010\u0006J\u0018\u00106\u001a\u0002072\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u00108\u001a\u00020\u0017H\u0016J\b\u00109\u001a\u00020\u0017H\u0016R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\n\"\u0004\b\u000f\u0010\fR\u001a\u0010\u0010\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\n\"\u0004\b\u0012\u0010\fR\u001a\u0010\u0013\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\n\"\u0004\b\u0015\u0010\fR\u001a\u0010\u0016\u001a\u00020\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001c\u001a\u00020\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0019\"\u0004\b\u001e\u0010\u001bR\u001c\u0010\u001f\u001a\u0004\u0018\u00010 X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001c\u0010%\u001a\u0004\u0018\u00010 X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\"\"\u0004\b'\u0010$R\u001c\u0010(\u001a\u0004\u0018\u00010)X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u001a\u0010.\u001a\u00020/X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u00100\"\u0004\b1\u00102R\u001a\u00103\u001a\u00020/X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u00100\"\u0004\b5\u00102¨\u0006<"}, d2 = {"Lcom/ss/android/lark/forwardv3/configuration/BasicDialogContentConfig;", "Landroid/os/Parcelable;", "<init>", "()V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "label", "", "getLabel", "()Ljava/lang/String;", "setLabel", "(Ljava/lang/String;)V", "title", "getTitle", "setTitle", "content", "getContent", "setContent", "description", "getDescription", "setDescription", "subscriptRes", "", "getSubscriptRes", "()I", "setSubscriptRes", "(I)V", "thumbnailRes", "getThumbnailRes", "setThumbnailRes", "encryptThumbnailImage", "Lcom/ss/android/lark/image/entity/Image;", "getEncryptThumbnailImage", "()Lcom/ss/android/lark/image/entity/Image;", "setEncryptThumbnailImage", "(Lcom/ss/android/lark/image/entity/Image;)V", "avatarThumbnailImage", "getAvatarThumbnailImage", "setAvatarThumbnailImage", "thumbnailStick", "Lcom/ss/android/lark/forwardv3/configuration/dto/StickImage;", "getThumbnailStick", "()Lcom/ss/android/lark/forwardv3/configuration/dto/StickImage;", "setThumbnailStick", "(Lcom/ss/android/lark/forwardv3/configuration/dto/StickImage;)V", "isVideoType", "", "()Z", "setVideoType", "(Z)V", "clickable", "getClickable", "setClickable", "writeToParcel", "", "flags", "describeContents", "Builder", "CREATOR", "forward-new_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class BasicDialogContentConfig implements Parcelable {
    public static final b CREATOR = null;
    public String a;
    public String b;
    public String c;
    public String d;
    public int e;
    public int f;
    public Image g;
    public Image h;
    public StickImage i;
    public boolean j;
    public boolean k;

    public static final class a {
        public String a;
        public String b;
        public String c;
        public String d;
        public int e;
        public int f;
        public Image g;
        public Image h;
        public StickImage i;
        public boolean j;
        public boolean k;

        public final BasicDialogContentConfig a() {
            BasicDialogContentConfig r0 = new BasicDialogContentConfig();
            String r1 = this.a;
            Intrinsics.checkNotNullParameter(r1, "<set-?>");
            r0.a = r1;
            String r2 = this.b;
            Intrinsics.checkNotNullParameter(r2, "<set-?>");
            r0.b = r2;
            String r3 = this.c;
            Intrinsics.checkNotNullParameter(r3, "<set-?>");
            r0.c = r3;
            String r4 = this.d;
            Intrinsics.checkNotNullParameter(r4, "<set-?>");
            r0.d = r4;
            r0.e = this.e;
            r0.f = this.f;
            r0.g = this.g;
            r0.h = this.h;
            r0.i = this.i;
            r0.j = this.j;
            r0.k = this.k;
            return r0;
        }

        public a() {
            this.a = "";
            this.b = "";
            this.c = "";
            this.d = "";
        }
    }

    public static final class b implements Parcelable.Creator<BasicDialogContentConfig> {
        public b() {
        }

        @Override // android.os.Parcelable.Creator
        public final BasicDialogContentConfig createFromParcel(Parcel r5) {
            Intrinsics.checkNotNullParameter(r5, "parcel");
            Intrinsics.checkNotNullParameter(r5, "parcel");
            BasicDialogContentConfig r1 = new BasicDialogContentConfig();
            String r0 = r5.readString();
            String r2 = "";
            if (r0 != null) goto L5;
            r0 = "";
        L5:
            r1.a = r0;
            String r3 = r5.readString();
            if (r3 != null) goto L8;
            r3 = "";
        L8:
            r1.b = r3;
            String r4 = r5.readString();
            if (r4 != null) goto L11;
            r4 = "";
        L11:
            r1.c = r4;
            String r6 = r5.readString();
            if (r6 == null) goto L15;
            r2 = r6;
        L15:
            r1.d = r2;
            r1.e = r5.readInt();
            r1.f = r5.readInt();
            r1.g = (Image) r5.readSerializable();
            r1.h = (Image) r5.readSerializable();
            r1.i = (StickImage) r5.readParcelable(BasicDialogContentConfig.class.getClassLoader());
            boolean r7 = true;
            if (r5.readByte() == 0) goto L18;
            boolean r8 = true;
        L19:
            r1.j = r8;
            if (r5.readByte() != 0) goto L23;
            r7 = false;
        L23:
            r1.k = r7;
            return r1;
        L18:
            r8 = false;
            goto L19
        }

        @Override // android.os.Parcelable.Creator
        public final BasicDialogContentConfig[] newArray(int r1) {
            return new BasicDialogContentConfig[r1];
        }
    }

    static {
        CREATOR = new b();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public BasicDialogContentConfig() {
        this.a = "";
        this.b = "";
        this.c = "";
        this.d = "";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "parcel");
        r2.writeString(this.a);
        r2.writeString(this.b);
        r2.writeString(this.c);
        r2.writeString(this.d);
        r2.writeInt(this.e);
        r2.writeInt(this.f);
        r2.writeSerializable(this.g);
        r2.writeSerializable(this.h);
        r2.writeParcelable(this.i, r3);
        r2.writeByte(this.j ? 1 : 0);
        r2.writeByte(this.k ? 1 : 0);
    }
}
