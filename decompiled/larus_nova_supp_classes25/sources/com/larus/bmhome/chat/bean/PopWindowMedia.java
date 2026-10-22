package com.larus.bmhome.chat.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001Bs\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0012J\u000b\u0010 \u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u000eHÆ\u0003Jz\u0010(\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000eHÆ\u0001¢\u0006\u0002\u0010)J\u0006\u0010*\u001a\u00020\u0003J\u0013\u0010+\u001a\u00020,2\b\u0010-\u001a\u0004\u0018\u00010.HÖ\u0003J\t\u0010/\u001a\u00020\u0003HÖ\u0001J\t\u00100\u001a\u00020\u0007HÖ\u0001J\u0016\u00101\u001a\u0002022\u0006\u00103\u001a\u0002042\u0006\u00105\u001a\u00020\u0003R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0017R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0017R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0017R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0017R\u0018\u0010\f\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0017R\u0018\u0010\r\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001e¨\u00066"}, d2 = {"Lcom/larus/bmhome/chat/bean/PopWindowMedia;", "Landroid/os/Parcelable;", "mediaType", "", "size", "Lcom/larus/bmhome/chat/bean/PopWindowMediaSize;", "mediaUri", "", "mediaUrl", "mediaDarkUri", "mediaDarkUrl", "videoCoverUri", "videoCoverUrl", "color", "Lcom/larus/bmhome/chat/bean/PopWindowColor;", "<init>", "(Ljava/lang/Integer;Lcom/larus/bmhome/chat/bean/PopWindowMediaSize;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/larus/bmhome/chat/bean/PopWindowColor;)V", "getMediaType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getSize", "()Lcom/larus/bmhome/chat/bean/PopWindowMediaSize;", "getMediaUri", "()Ljava/lang/String;", "getMediaUrl", "getMediaDarkUri", "getMediaDarkUrl", "getVideoCoverUri", "getVideoCoverUrl", "getColor", "()Lcom/larus/bmhome/chat/bean/PopWindowColor;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/Integer;Lcom/larus/bmhome/chat/bean/PopWindowMediaSize;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/larus/bmhome/chat/bean/PopWindowColor;)Lcom/larus/bmhome/chat/bean/PopWindowMedia;", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class PopWindowMedia implements Parcelable {
    public static final Parcelable.Creator<PopWindowMedia> CREATOR = null;

    @SerializedName("color")
    private final PopWindowColor color;

    @SerializedName("media_dark_uri")
    private final String mediaDarkUri;

    @SerializedName("media_dark_url")
    private final String mediaDarkUrl;

    @SerializedName("media_type")
    private final Integer mediaType;

    @SerializedName("media_uri")
    private final String mediaUri;

    @SerializedName("media_url")
    private final String mediaUrl;

    @SerializedName("size")
    private final PopWindowMediaSize size;

    @SerializedName("video_cover_uri")
    private final String videoCoverUri;

    @SerializedName("video_cover_url")
    private final String videoCoverUrl;

    public static final class a implements Parcelable.Creator<PopWindowMedia> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final PopWindowMedia createFromParcel(Parcel r12) {
            Intrinsics.checkNotNullParameter(r12, "parcel");
            PopWindowColor r2 = null;
            if (r12.readInt() != 0) goto L5;
            Integer r3 = null;
        L7:
            if (r12.readInt() != 0) goto L9;
            PopWindowMediaSize r1 = null;
        L10:
            PopWindowMediaSize r4 = r1;
            String r5 = r12.readString();
            String r6 = r12.readString();
            String r7 = r12.readString();
            String r8 = r12.readString();
            String r9 = r12.readString();
            String r10 = r12.readString();
            if (r12.readInt() == 0) goto L15;
            r2 = PopWindowColor.CREATOR.createFromParcel(r12);
        L15:
            return new PopWindowMedia(r3, r4, r5, r6, r7, r8, r9, r10, r2);
        L9:
            r1 = PopWindowMediaSize.CREATOR.createFromParcel(r12);
            goto L10
        L5:
            r3 = Integer.valueOf(r12.readInt());
            goto L7
        }

        @Override // android.os.Parcelable.Creator
        public final PopWindowMedia[] newArray(int r1) {
            return new PopWindowMedia[r1];
        }
    }

    static {
        CREATOR = new a();
    }

    public PopWindowMedia() {
        this(null, null, null, null, null, null, null, null, null, 511, null);
    }

    public static /* synthetic */ PopWindowMedia copy$default(PopWindowMedia r10, Integer r11, PopWindowMediaSize r12, String r13, String r14, String r15, String r16, String r17, String r18, PopWindowColor r19, int r20, Object r21) {
        if ((r20 & 1) == 0) goto L5;
        Integer r2 = r10.mediaType;
    L7:
        if ((r20 & 2) == 0) goto L9;
        PopWindowMediaSize r3 = r10.size;
    L11:
        if ((r20 & 4) == 0) goto L13;
        String r4 = r10.mediaUri;
    L15:
        if ((r20 & 8) == 0) goto L17;
        String r5 = r10.mediaUrl;
    L19:
        if ((r20 & 16) == 0) goto L21;
        String r6 = r10.mediaDarkUri;
    L23:
        if ((r20 & 32) == 0) goto L25;
        String r7 = r10.mediaDarkUrl;
    L27:
        if ((r20 & 64) == 0) goto L29;
        String r8 = r10.videoCoverUri;
    L31:
        if ((r20 & 128) == 0) goto L33;
        String r9 = r10.videoCoverUrl;
    L35:
        if ((r20 & 256) == 0) goto L37;
        PopWindowColor r1 = r10.color;
    L39:
        return r10.copy(r2, r3, r4, r5, r6, r7, r8, r9, r1);
    L37:
        r1 = r19;
        goto L39
    L33:
        r9 = r18;
        goto L35
    L29:
        r8 = r17;
        goto L31
    L25:
        r7 = r16;
        goto L27
    L21:
        r6 = r15;
        goto L23
    L17:
        r5 = r14;
        goto L19
    L13:
        r4 = r13;
        goto L15
    L9:
        r3 = r12;
        goto L11
    L5:
        r2 = r11;
        goto L7
    }

    public final Integer component1() {
        return this.mediaType;
    }

    public final PopWindowMediaSize component2() {
        return this.size;
    }

    public final String component3() {
        return this.mediaUri;
    }

    public final String component4() {
        return this.mediaUrl;
    }

    public final String component5() {
        return this.mediaDarkUri;
    }

    public final String component6() {
        return this.mediaDarkUrl;
    }

    public final String component7() {
        return this.videoCoverUri;
    }

    public final String component8() {
        return this.videoCoverUrl;
    }

    public final PopWindowColor component9() {
        return this.color;
    }

    public final PopWindowMedia copy(Integer r12, PopWindowMediaSize r13, String r14, String r15, String r16, String r17, String r18, String r19, PopWindowColor r20) {
        return new PopWindowMedia(r12, r13, r14, r15, r16, r17, r18, r19, r20);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof PopWindowMedia) == true) goto L8;
        return false;
    L8:
        PopWindowMedia r6 = (PopWindowMedia) r5;
        if (Intrinsics.areEqual(this.mediaType, r6.mediaType) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.size, r6.size) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.mediaUri, r6.mediaUri) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.mediaUrl, r6.mediaUrl) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.mediaDarkUri, r6.mediaDarkUri) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.mediaDarkUrl, r6.mediaDarkUrl) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.videoCoverUri, r6.videoCoverUri) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.videoCoverUrl, r6.videoCoverUrl) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.color, r6.color) == true) goto L35;
        return false;
    L35:
        return true;
    }

    public int hashCode() {
        Integer r0 = this.mediaType;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        PopWindowMediaSize r4 = this.size;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.mediaUri;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.mediaUrl;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        String r13 = this.mediaDarkUri;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        String r16 = this.mediaDarkUrl;
        if (r16 != null) goto L25;
        int r17 = 0;
    L26:
        int r18 = (r15 + r17) * 31;
        String r19 = this.videoCoverUri;
        if (r19 != null) goto L29;
        int r20 = 0;
    L30:
        int r21 = (r18 + r20) * 31;
        String r22 = this.videoCoverUrl;
        if (r22 != null) goto L33;
        int r23 = 0;
    L34:
        int r24 = (r21 + r23) * 31;
        PopWindowColor r25 = this.color;
        if (r25 == null) goto L39;
        r1 = r25.hashCode();
    L39:
        return r24 + r1;
    L33:
        r23 = r22.hashCode();
        goto L34
    L29:
        r20 = r19.hashCode();
        goto L30
    L25:
        r17 = r16.hashCode();
        goto L26
    L21:
        r14 = r13.hashCode();
        goto L22
    L17:
        r11 = r10.hashCode();
        goto L18
    L13:
        r8 = r7.hashCode();
        goto L14
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "PopWindowMedia(mediaType=" + this.mediaType + ", size=" + this.size + ", mediaUri=" + this.mediaUri + ", mediaUrl=" + this.mediaUrl + ", mediaDarkUri=" + this.mediaDarkUri + ", mediaDarkUrl=" + this.mediaDarkUrl + ", videoCoverUri=" + this.videoCoverUri + ", videoCoverUrl=" + this.videoCoverUrl + ", color=" + this.color + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r4, int r5) {
        Intrinsics.checkNotNullParameter(r4, "dest");
        Integer r0 = this.mediaType;
        if (r0 != null) goto L5;
        r4.writeInt(0);
    L6:
        PopWindowMediaSize r1 = this.size;
        if (r1 != null) goto L9;
        r4.writeInt(0);
    L10:
        r4.writeString(this.mediaUri);
        r4.writeString(this.mediaUrl);
        r4.writeString(this.mediaDarkUri);
        r4.writeString(this.mediaDarkUrl);
        r4.writeString(this.videoCoverUri);
        r4.writeString(this.videoCoverUrl);
        PopWindowColor r2 = this.color;
        if (r2 != null) goto L13;
        r4.writeInt(0);
        return;
    L13:
        r4.writeInt(1);
        r2.writeToParcel(r4, r5);
        return;
    L9:
        r4.writeInt(1);
        r1.writeToParcel(r4, r5);
        goto L10
    L5:
        r4.writeInt(1);
        r4.writeInt(r0.intValue());
        goto L6
    }

    public final PopWindowColor getColor() {
        return this.color;
    }

    public final String getMediaDarkUri() {
        return this.mediaDarkUri;
    }

    public final String getMediaDarkUrl() {
        return this.mediaDarkUrl;
    }

    public final Integer getMediaType() {
        return this.mediaType;
    }

    public final String getMediaUri() {
        return this.mediaUri;
    }

    public final String getMediaUrl() {
        return this.mediaUrl;
    }

    public final PopWindowMediaSize getSize() {
        return this.size;
    }

    public final String getVideoCoverUri() {
        return this.videoCoverUri;
    }

    public final String getVideoCoverUrl() {
        return this.videoCoverUrl;
    }

    public PopWindowMedia(Integer r1, PopWindowMediaSize r2, String r3, String r4, String r5, String r6, String r7, String r8, PopWindowColor r9) {
        this.mediaType = r1;
        this.size = r2;
        this.mediaUri = r3;
        this.mediaUrl = r4;
        this.mediaDarkUri = r5;
        this.mediaDarkUrl = r6;
        this.videoCoverUri = r7;
        this.videoCoverUrl = r8;
        this.color = r9;
    }

    public /* synthetic */ PopWindowMedia(Integer r11, PopWindowMediaSize r12, String r13, String r14, String r15, String r16, String r17, String r18, PopWindowColor r19, int r20, DefaultConstructorMarker r21) {
        PopWindowColor r2 = null;
        if ((r20 & 1) == 0) goto L5;
        Integer r1 = null;
    L7:
        if ((r20 & 2) == 0) goto L9;
        PopWindowMediaSize r3 = null;
    L11:
        if ((r20 & 4) == 0) goto L13;
        String r4 = null;
    L15:
        if ((r20 & 8) == 0) goto L17;
        String r5 = null;
    L19:
        if ((r20 & 16) == 0) goto L21;
        String r6 = null;
    L23:
        if ((r20 & 32) == 0) goto L25;
        String r7 = null;
    L27:
        if ((r20 & 64) == 0) goto L29;
        String r8 = null;
    L31:
        if ((r20 & 128) == 0) goto L33;
        String r9 = null;
    L35:
        if ((r20 & 256) != 0) goto L38;
        r2 = r19;
    L38:
        this(r1, r3, r4, r5, r6, r7, r8, r9, r2);
        return;
    L33:
        r9 = r18;
        goto L35
    L29:
        r8 = r17;
        goto L31
    L25:
        r7 = r16;
        goto L27
    L21:
        r6 = r15;
        goto L23
    L17:
        r5 = r14;
        goto L19
    L13:
        r4 = r13;
        goto L15
    L9:
        r3 = r12;
        goto L11
    L5:
        r1 = r11;
        goto L7
    }
}
