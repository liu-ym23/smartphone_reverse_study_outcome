package com.obric.assistant.settings.config;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import com.obric.assistant.interaction.api.service.IInteractionStateService$Companion;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\b\u0018\u0000 &2\u00020\u0001:\u0001&BC\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\t\u0010\nJ\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u000fJ\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u000fJ\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u000fJJ\u0010\u0018\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010\u0019J\u0006\u0010\u001a\u001a\u00020\u0006J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eHÖ\u0003J\t\u0010\u001f\u001a\u00020\u0006HÖ\u0001J\t\u0010 \u001a\u00020\u0003HÖ\u0001J\u0016\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u0006R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u0011\u0010\u000fR\u001a\u0010\b\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u0012\u0010\u000f¨\u0006'"}, d2 = {"Lcom/obric/assistant/settings/config/CompressParam;", "Landroid/os/Parcelable;", "scene", "", "id", "shortSize", "", "quality", "compressThreshold", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)V", "getScene", "()Ljava/lang/String;", "getId", "getShortSize", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getQuality", "getCompressThreshold", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/obric/assistant/settings/config/CompressParam;", "describeContents", "equals", "", IInteractionStateService$Companion.WAKE_UP_SOURCE_OTHER, "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "Companion", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CompressParam implements Parcelable {
    public static final Parcelable.Creator<CompressParam> CREATOR = null;
    public static final a Companion = null;
    public static final String ID_NO_COMPRESS = "no_compress";

    @SerializedName("compress_threshold")
    private final Integer compressThreshold;

    @SerializedName("id")
    private final String id;

    @SerializedName("quality")
    private final Integer quality;

    @SerializedName("scene")
    private final String scene;

    @SerializedName("short_size")
    private final Integer shortSize;

    public static final class a {
        public a() {
        }
    }

    public static final class b implements Parcelable.Creator<CompressParam> {
        public b() {
        }

        @Override // android.os.Parcelable.Creator
        public final CompressParam createFromParcel(Parcel r8) {
            Intrinsics.checkNotNullParameter(r8, "parcel");
            String r2 = r8.readString();
            String r3 = r8.readString();
            if (r8.readInt() != 0) goto L5;
            Integer r5 = null;
        L7:
            if (r8.readInt() != 0) goto L9;
            Integer r6 = null;
        L11:
            if (r8.readInt() != 0) goto L13;
            Integer r9 = null;
        L15:
            return new CompressParam(r2, r3, r5, r6, r9);
        L13:
            r9 = Integer.valueOf(r8.readInt());
            goto L15
        L9:
            r6 = Integer.valueOf(r8.readInt());
            goto L11
        L5:
            r5 = Integer.valueOf(r8.readInt());
            goto L7
        }

        @Override // android.os.Parcelable.Creator
        public final CompressParam[] newArray(int r1) {
            return new CompressParam[r1];
        }
    }

    static {
        Companion = new a();
        CREATOR = new b();
    }

    public CompressParam() {
        this(null, null, null, null, null, 31, null);
    }

    public static /* synthetic */ CompressParam copy$default(CompressParam r3, String r4, String r5, Integer r6, Integer r7, Integer r8, int r9, Object r10) {
        if ((r9 & 1) == 0) goto L6;
        r4 = r3.scene;
    L6:
        if ((r9 & 2) == 0) goto L8;
        r5 = r3.id;
    L8:
        String r11 = r5;
        if ((r9 & 4) == 0) goto L11;
        r6 = r3.shortSize;
    L11:
        Integer r0 = r6;
        if ((r9 & 8) == 0) goto L14;
        r7 = r3.quality;
    L14:
        Integer r1 = r7;
        if ((r9 & 16) == 0) goto L17;
        r8 = r3.compressThreshold;
    L17:
        String r12 = r4;
        return r3.copy(r12, r11, r0, r1, r8);
    }

    public final String component1() {
        return this.scene;
    }

    public final String component2() {
        return this.id;
    }

    public final Integer component3() {
        return this.shortSize;
    }

    public final Integer component4() {
        return this.quality;
    }

    public final Integer component5() {
        return this.compressThreshold;
    }

    public final CompressParam copy(String r8, String r9, Integer r10, Integer r11, Integer r12) {
        return new CompressParam(r8, r9, r10, r11, r12);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof CompressParam) == true) goto L8;
        return false;
    L8:
        CompressParam r6 = (CompressParam) r5;
        if (Intrinsics.areEqual(this.scene, r6.scene) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.id, r6.id) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.shortSize, r6.shortSize) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.quality, r6.quality) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.compressThreshold, r6.compressThreshold) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        String r0 = this.scene;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.id;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        Integer r7 = this.shortSize;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        Integer r10 = this.quality;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        Integer r13 = this.compressThreshold;
        if (r13 == null) goto L23;
        r1 = r13.hashCode();
    L23:
        return r12 + r1;
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
        return "CompressParam(scene=" + this.scene + ", id=" + this.id + ", shortSize=" + this.shortSize + ", quality=" + this.quality + ", compressThreshold=" + this.compressThreshold + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "dest");
        r3.writeString(this.scene);
        r3.writeString(this.id);
        Integer r5 = this.shortSize;
        if (r5 != null) goto L5;
        r3.writeInt(0);
    L6:
        Integer r6 = this.quality;
        if (r6 != null) goto L9;
        r3.writeInt(0);
    L10:
        Integer r7 = this.compressThreshold;
        if (r7 != null) goto L13;
        r3.writeInt(0);
        return;
    L13:
        r3.writeInt(1);
        r3.writeInt(r7.intValue());
        return;
    L9:
        r3.writeInt(1);
        r3.writeInt(r6.intValue());
        goto L10
    L5:
        r3.writeInt(1);
        r3.writeInt(r5.intValue());
        goto L6
    }

    public final Integer getCompressThreshold() {
        return this.compressThreshold;
    }

    public final String getId() {
        return this.id;
    }

    public final Integer getQuality() {
        return this.quality;
    }

    public final String getScene() {
        return this.scene;
    }

    public final Integer getShortSize() {
        return this.shortSize;
    }

    public CompressParam(String r1, String r2, Integer r3, Integer r4, Integer r5) {
        this.scene = r1;
        this.id = r2;
        this.shortSize = r3;
        this.quality = r4;
        this.compressThreshold = r5;
    }

    public /* synthetic */ CompressParam(String r5, String r6, Integer r7, Integer r8, Integer r9, int r10, DefaultConstructorMarker r11) {
        if ((r10 & 1) == 0) goto L5;
        String r12 = null;
    L7:
        if ((r10 & 2) == 0) goto L9;
        String r1 = null;
    L11:
        if ((r10 & 4) == 0) goto L13;
        Integer r2 = null;
    L15:
        if ((r10 & 8) == 0) goto L17;
        Integer r3 = null;
    L19:
        if ((r10 & 16) == 0) goto L21;
        Integer r13 = null;
    L22:
        this(r12, r1, r2, r3, r13);
        return;
    L21:
        r13 = r9;
        goto L22
    L17:
        r3 = r8;
        goto L19
    L13:
        r2 = r7;
        goto L15
    L9:
        r1 = r6;
        goto L11
    L5:
        r12 = r5;
        goto L7
    }
}
