package com.larus.bmhome.chat.bean;

import com.google.gson.annotations.SerializedName;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B7\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J9\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u0019"}, d2 = {"Lcom/larus/bmhome/chat/bean/NexPulseMedia;", "", "mediaLightUri", "", "mediaLightUrl", "mediaDarkUri", "mediaDarkUrl", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getMediaLightUri", "()Ljava/lang/String;", "getMediaLightUrl", "getMediaDarkUri", "getMediaDarkUrl", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class NexPulseMedia {

    @SerializedName("media_dark_uri")
    private final String mediaDarkUri;

    @SerializedName("media_dark_url")
    private final String mediaDarkUrl;

    @SerializedName("media_light_uri")
    private final String mediaLightUri;

    @SerializedName("media_light_url")
    private final String mediaLightUrl;

    public NexPulseMedia() {
        this(null, null, null, null, 15, null);
    }

    public static /* synthetic */ NexPulseMedia copy$default(NexPulseMedia r0, String r1, String r2, String r3, String r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = r0.mediaLightUri;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = r0.mediaLightUrl;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r3 = r0.mediaDarkUri;
    L12:
        if ((r5 & 8) == 0) goto L15;
        r4 = r0.mediaDarkUrl;
    L15:
        return r0.copy(r1, r2, r3, r4);
    }

    public final String component1() {
        return this.mediaLightUri;
    }

    public final String component2() {
        return this.mediaLightUrl;
    }

    public final String component3() {
        return this.mediaDarkUri;
    }

    public final String component4() {
        return this.mediaDarkUrl;
    }

    public final NexPulseMedia copy(String r2, String r3, String r4, String r5) {
        return new NexPulseMedia(r2, r3, r4, r5);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof NexPulseMedia) == true) goto L8;
        return false;
    L8:
        NexPulseMedia r6 = (NexPulseMedia) r5;
        if (Intrinsics.areEqual(this.mediaLightUri, r6.mediaLightUri) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.mediaLightUrl, r6.mediaLightUrl) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.mediaDarkUri, r6.mediaDarkUri) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.mediaDarkUrl, r6.mediaDarkUrl) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        String r0 = this.mediaLightUri;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.mediaLightUrl;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.mediaDarkUri;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.mediaDarkUrl;
        if (r10 == null) goto L19;
        r1 = r10.hashCode();
    L19:
        return r9 + r1;
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
        return "NexPulseMedia(mediaLightUri=" + this.mediaLightUri + ", mediaLightUrl=" + this.mediaLightUrl + ", mediaDarkUri=" + this.mediaDarkUri + ", mediaDarkUrl=" + this.mediaDarkUrl + ')';
    }

    public final String getMediaDarkUri() {
        return this.mediaDarkUri;
    }

    public final String getMediaDarkUrl() {
        return this.mediaDarkUrl;
    }

    public final String getMediaLightUri() {
        return this.mediaLightUri;
    }

    public final String getMediaLightUrl() {
        return this.mediaLightUrl;
    }

    public NexPulseMedia(String r1, String r2, String r3, String r4) {
        this.mediaLightUri = r1;
        this.mediaLightUrl = r2;
        this.mediaDarkUri = r3;
        this.mediaDarkUrl = r4;
    }

    public /* synthetic */ NexPulseMedia(String r2, String r3, String r4, String r5, int r6, DefaultConstructorMarker r7) {
        if ((r6 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r6 & 2) == 0) goto L9;
        r3 = null;
    L9:
        if ((r6 & 4) == 0) goto L12;
        r4 = null;
    L12:
        if ((r6 & 8) == 0) goto L14;
        r5 = null;
    L14:
        this(r2, r3, r4, r5);
    }
}
