package com.larus.drive.sdk.api.file;

import android.os.Parcel;
import android.os.Parcelable;
import com.larus.drive.biz.api.model.DriveFileType;
import java.util.Locale;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\b\u0018\u0000 G2\u00020\u0001:\u0001GBm\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\f\u001a\u00020\u0007\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0007\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010#\u001a\u00020\u00032\b\b\u0002\u0010$\u001a\u00020%J\u0006\u0010&\u001a\u00020\u0003J\u0006\u0010'\u001a\u00020%J\u0006\u0010(\u001a\u00020%J\u0006\u0010)\u001a\u00020%J\n\u0010,\u001a\u0004\u0018\u00010+H\u0002J\u0006\u0010-\u001a\u00020\nJ\u0006\u0010.\u001a\u00020%J\t\u0010/\u001a\u00020\u0003HÆ\u0003J\t\u00100\u001a\u00020\u0003HÆ\u0003J\t\u00101\u001a\u00020\u0003HÆ\u0003J\t\u00102\u001a\u00020\u0007HÆ\u0003J\t\u00103\u001a\u00020\u0003HÆ\u0003J\t\u00104\u001a\u00020\nHÆ\u0003J\t\u00105\u001a\u00020\nHÆ\u0003J\t\u00106\u001a\u00020\u0007HÆ\u0003J\t\u00107\u001a\u00020\u0003HÆ\u0003J\t\u00108\u001a\u00020\u000fHÆ\u0003J\t\u00109\u001a\u00020\u0007HÆ\u0003J\u000b\u0010:\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0083\u0001\u0010;\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\u00072\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00072\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0006\u0010<\u001a\u00020\u0007J\u0013\u0010=\u001a\u00020%2\b\u0010>\u001a\u0004\u0018\u00010?HÖ\u0003J\t\u0010@\u001a\u00020\u0007HÖ\u0001J\t\u0010A\u001a\u00020\u0003HÖ\u0001J\u0016\u0010B\u001a\u00020C2\u0006\u0010D\u001a\u00020E2\u0006\u0010F\u001a\u00020\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0015R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0015R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\u000b\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001cR\u0011\u0010\f\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0019R\u0011\u0010\r\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0015R\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0011\u0010\u0010\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0019R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0015R\u0010\u0010*\u001a\u0004\u0018\u00010+X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006H"}, d2 = {"Lcom/larus/drive/sdk/api/file/DriveFileItem;", "Landroid/os/Parcelable;", "fileName", "", "fileToken", "driveToken", "driveObjType", "", "fileURL", "openTime", "", "editTime", "iconResId", "iconInfo", "fileType", "Lcom/larus/drive/biz/api/model/DriveFileType;", "isOwner", "extra", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;JJILjava/lang/String;Lcom/larus/drive/biz/api/model/DriveFileType;ILjava/lang/String;)V", "getFileName", "()Ljava/lang/String;", "getFileToken", "getDriveToken", "getDriveObjType", "()I", "getFileURL", "getOpenTime", "()J", "getEditTime", "getIconResId", "getIconInfo", "getFileType", "()Lcom/larus/drive/biz/api/model/DriveFileType;", "getExtra", "getPostfix", "includeDot", "", "getNameWithoutPostfix", "isFileOwner", "isAIArtifact", "shouldImgLoadCover", "extraJson", "Lorg/json/JSONObject;", "getExtraJson", "getSize", "getImgAuditReject", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "copy", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "Companion", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DriveFileItem implements Parcelable {
    public static final Parcelable.Creator<DriveFileItem> CREATOR = null;
    public static final Set<String> n = null;
    public final String a;
    public final String b;
    public final String c;
    public final int d;
    public final String e;
    public final long f;
    public final long g;
    public final int h;
    public final String i;
    public final DriveFileType j;
    public final int k;
    public final String l;
    public JSONObject m;

    public static final class a {
    }

    public static final class b implements Parcelable.Creator<DriveFileItem> {
        public b() {
        }

        @Override // android.os.Parcelable.Creator
        public final DriveFileItem createFromParcel(Parcel r17) {
            Intrinsics.checkNotNullParameter(r17, "parcel");
            return new DriveFileItem(r17.readString(), r17.readString(), r17.readString(), r17.readInt(), r17.readString(), r17.readLong(), r17.readLong(), r17.readInt(), r17.readString(), DriveFileType.valueOf(r17.readString()), r17.readInt(), r17.readString());
        }

        @Override // android.os.Parcelable.Creator
        public final DriveFileItem[] newArray(int r1) {
            return new DriveFileItem[r1];
        }
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof DriveFileItem) == true) goto L8;
        return false;
    L8:
        DriveFileItem r9 = (DriveFileItem) r8;
        if (Intrinsics.areEqual(this.a, r9.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r9.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r9.c) == true) goto L18;
        return false;
    L18:
        if (this.d == r9.d) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r9.e) == true) goto L24;
        return false;
    L24:
        if (this.f == r9.f) goto L27;
        return false;
    L27:
        if (this.g == r9.g) goto L30;
        return false;
    L30:
        if (this.h == r9.h) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.i, r9.i) == true) goto L36;
        return false;
    L36:
        if (this.j == r9.j) goto L39;
        return false;
    L39:
        if (this.k == r9.k) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.l, r9.l) == true) goto L44;
        return false;
    L44:
        return true;
    }

    public final int hashCode() {
        int r0 = ((((((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d) * 31) + this.e.hashCode()) * 31;
        long r1 = this.f;
        int r2 = (r0 + ((int) (r1 ^ (r1 >>> 32)))) * 31;
        long r3 = this.g;
        int r4 = (((((((((r2 + ((int) (r3 ^ (r3 >>> 32)))) * 31) + this.h) * 31) + this.i.hashCode()) * 31) + this.j.hashCode()) * 31) + this.k) * 31;
        String r5 = this.l;
        if (r5 != null) goto L5;
        int r6 = 0;
    L7:
        return r4 + r6;
    L5:
        r6 = r5.hashCode();
        goto L7
    }

    public final String toString() {
        return "DriveFileItem(fileName=" + this.a + ", fileToken=" + this.b + ", driveToken=" + this.c + ", driveObjType=" + this.d + ", fileURL=" + this.e + ", openTime=" + this.f + ", editTime=" + this.g + ", iconResId=" + this.h + ", iconInfo=" + this.i + ", fileType=" + this.j + ", isOwner=" + this.k + ", extra=" + this.l + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "dest");
        r3.writeString(this.a);
        r3.writeString(this.b);
        r3.writeString(this.c);
        r3.writeInt(this.d);
        r3.writeString(this.e);
        r3.writeLong(this.f);
        r3.writeLong(this.g);
        r3.writeInt(this.h);
        r3.writeString(this.i);
        r3.writeString(this.j.name());
        r3.writeInt(this.k);
        r3.writeString(this.l);
    }

    static {
        CREATOR = new b();
        n = SetsKt.setOf(new String[]{".png", ".jpeg", ".jpg", ".gif", ".bmp", ".jfif", ".exif", ".tiff", ".bpg", ".webp", ".heic", ".heif"});
    }

    public final boolean b() {
        JSONObject r0 = this.m;
        if (r0 != null) goto L12;
        String r1 = this.l;     // Catch: JSONException -> L10
        if (r1 != null) goto L8;
        r1 = "{}";
    L8:
        r0 = new JSONObject(r1);     // Catch: JSONException -> L10
        this.m = r0;     // Catch: JSONException -> L10
    L10:
        r0 = null;
    L12:
        if (r0 != null) goto L15;
        return false;
    L15:
        if (this.j == DriveFileType.IMAGE) goto L17;
        return false;
    L17:
        if (r0.optInt("doubao_ai_skill_status", 1) != 20003) goto L23;
        return true;
    L23:
        return false;
    }

    public final String c() {
        int r0 = StringsKt.lastIndexOf$default(this.a, '.', 0, false, 6, null);
        if (r0 <= 0) goto L8;
        if (r0 >= (this.a.length() - 1)) goto L8;
        return this.a.substring(0, r0);
    L8:
        return this.a;
    }

    public final long e() {
        JSONObject r0 = this.m;
        if (r0 == null) goto L15;
    L11:
        if (r0 != null) goto L17;
        return 0;
    L17:
        return r0.optLong("size");
    L15:
        String r1 = this.l;     // Catch: JSONException -> L10
        if (r1 != null) goto L8;
        r1 = "{}";
    L8:
        r0 = new JSONObject(r1);     // Catch: JSONException -> L10
        this.m = r0;     // Catch: JSONException -> L10
    L10:
        r0 = null;
        goto L11
    }

    public final boolean g() {
        if (this.k == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public final boolean h() {
        return n.contains(d(true).toLowerCase(Locale.ROOT));
    }

    public final String d(boolean r7) {
        int r0 = StringsKt.lastIndexOf$default(this.a, '.', 0, false, 6, null);
        if (r0 > 0) goto L5;
    L9:
        return "";
    L5:
        if (r0 >= (this.a.length() - 1)) goto L9;
        if (r7 == false) goto L12;
        return this.a.substring(r0);
    L12:
        return this.a.substring(r0 + 1);
    }

    public static DriveFileItem a(DriveFileItem r110, String r20, String r21, String r22, int r23) {
        if ((r23 & 1) == 0) goto L5;
        String r4 = r110.a;
    L6:
        DriveFileType r3 = null;
        if ((r23 & 2) == 0) goto L9;
        String r5 = r110.b;
    L11:
        if ((r23 & 4) == 0) goto L13;
        String r6 = r110.c;
    L15:
        if ((r23 & 8) == 0) goto L17;
        int r2 = r110.d;
    L19:
        if ((r23 & 16) == 0) goto L21;
        String r8 = r110.e;
    L23:
        if ((r23 & 32) == 0) goto L25;
        long r12 = r110.f;
    L27:
        if ((r23 & 64) == 0) goto L29;
        long r14 = r110.g;
    L31:
        if ((r23 & 128) == 0) goto L33;
        int r16 = r110.h;
    L35:
        if ((r23 & 256) == 0) goto L37;
        String r11 = r110.i;
    L39:
        if ((r23 & 512) == 0) goto L41;
        r3 = r110.j;
    L41:
        DriveFileType r9 = r3;
        if ((r23 & 1024) == 0) goto L44;
        int r17 = r110.k;
    L46:
        if ((r23 & 2048) == 0) goto L48;
        String r1 = r110.l;
    L49:
        r110.getClass();
        Intrinsics.checkNotNullParameter(r4, "fileName");
        Intrinsics.checkNotNullParameter(r5, "fileToken");
        Intrinsics.checkNotNullParameter(r6, "driveToken");
        Intrinsics.checkNotNullParameter(r8, "fileURL");
        Intrinsics.checkNotNullParameter(r11, "iconInfo");
        Intrinsics.checkNotNullParameter(r9, "fileType");
        return new DriveFileItem(r4, r5, r6, r2, r8, r12, r14, r16, r11, r9, r17, r1);
    L48:
        r1 = r22;
        goto L49
    L44:
        r17 = 0;
        goto L46
    L37:
        r11 = null;
        goto L39
    L33:
        r16 = 0;
        goto L35
    L29:
        r14 = 0;
        goto L31
    L25:
        r12 = 0;
        goto L27
    L21:
        r8 = r21;
        goto L23
    L17:
        r2 = 0;
        goto L19
    L13:
        r6 = null;
        goto L15
    L9:
        r5 = null;
        goto L11
    L5:
        r4 = r20;
        goto L6
    }

    public DriveFileItem(String r2, String r3, String r4, int r5, String r6, long r7, long r9, int r11, String r12, DriveFileType r13, int r14, String r15) {
        Intrinsics.checkNotNullParameter(r2, "fileName");
        Intrinsics.checkNotNullParameter(r3, "fileToken");
        Intrinsics.checkNotNullParameter(r4, "driveToken");
        Intrinsics.checkNotNullParameter(r6, "fileURL");
        Intrinsics.checkNotNullParameter(r12, "iconInfo");
        Intrinsics.checkNotNullParameter(r13, "fileType");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r9;
        this.h = r11;
        this.i = r12;
        this.j = r13;
        this.k = r14;
        this.l = r15;
    }
}
