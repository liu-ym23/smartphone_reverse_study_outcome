package com.larus.uaigc.lynx.pocket;

import com.google.gson.annotations.SerializedName;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u001a\b\u0087\b\u0018\u00002\u00020\u0001BC\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\rJ\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0010J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0007HÆ\u0003JJ\u0010\u001b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u001cJ\u0013\u0010\u001d\u001a\u00020\u00032\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020\u0005HÖ\u0001J\t\u0010 \u001a\u00020\u0007HÖ\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0013¨\u0006!"}, d2 = {"Lcom/larus/uaigc/lynx/pocket/SendMsgPocket;", "", "allowPhotos", "", "selectedPhotosCount", "", "selectedModel", "", "presetImageUrl", "presetImageUri", "<init>", "(Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAllowPhotos", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getSelectedPhotosCount", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getSelectedModel", "()Ljava/lang/String;", "getPresetImageUrl", "getPresetImageUri", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/larus/uaigc/lynx/pocket/SendMsgPocket;", "equals", "other", "hashCode", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class SendMsgPocket {

    @SerializedName("allow_photos")
    private final Boolean allowPhotos;

    @SerializedName("preset_image_uri")
    private final String presetImageUri;

    @SerializedName("preset_image_url")
    private final String presetImageUrl;

    @SerializedName("selected_model")
    private final String selectedModel;

    @SerializedName("selected_photos_count")
    private final Integer selectedPhotosCount;

    public SendMsgPocket() {
        this(null, null, null, null, null, 31, null);
    }

    public static /* synthetic */ SendMsgPocket copy$default(SendMsgPocket r3, Boolean r4, Integer r5, String r6, String r7, String r8, int r9, Object r10) {
        if ((r9 & 1) == 0) goto L6;
        r4 = r3.allowPhotos;
    L6:
        if ((r9 & 2) == 0) goto L8;
        r5 = r3.selectedPhotosCount;
    L8:
        Integer r11 = r5;
        if ((r9 & 4) == 0) goto L11;
        r6 = r3.selectedModel;
    L11:
        String r0 = r6;
        if ((r9 & 8) == 0) goto L14;
        r7 = r3.presetImageUrl;
    L14:
        String r1 = r7;
        if ((r9 & 16) == 0) goto L17;
        r8 = r3.presetImageUri;
    L17:
        Boolean r12 = r4;
        return r3.copy(r12, r11, r0, r1, r8);
    }

    public final Boolean component1() {
        return this.allowPhotos;
    }

    public final Integer component2() {
        return this.selectedPhotosCount;
    }

    public final String component3() {
        return this.selectedModel;
    }

    public final String component4() {
        return this.presetImageUrl;
    }

    public final String component5() {
        return this.presetImageUri;
    }

    public final SendMsgPocket copy(Boolean r8, Integer r9, String r10, String r11, String r12) {
        return new SendMsgPocket(r8, r9, r10, r11, r12);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof SendMsgPocket) == true) goto L8;
        return false;
    L8:
        SendMsgPocket r6 = (SendMsgPocket) r5;
        if (Intrinsics.areEqual(this.allowPhotos, r6.allowPhotos) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.selectedPhotosCount, r6.selectedPhotosCount) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.selectedModel, r6.selectedModel) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.presetImageUrl, r6.presetImageUrl) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.presetImageUri, r6.presetImageUri) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        Boolean r0 = this.allowPhotos;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        Integer r4 = this.selectedPhotosCount;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.selectedModel;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.presetImageUrl;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        String r13 = this.presetImageUri;
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
        return "SendMsgPocket(allowPhotos=" + this.allowPhotos + ", selectedPhotosCount=" + this.selectedPhotosCount + ", selectedModel=" + this.selectedModel + ", presetImageUrl=" + this.presetImageUrl + ", presetImageUri=" + this.presetImageUri + ')';
    }

    public final Boolean getAllowPhotos() {
        return this.allowPhotos;
    }

    public final String getPresetImageUri() {
        return this.presetImageUri;
    }

    public final String getPresetImageUrl() {
        return this.presetImageUrl;
    }

    public final String getSelectedModel() {
        return this.selectedModel;
    }

    public final Integer getSelectedPhotosCount() {
        return this.selectedPhotosCount;
    }

    public SendMsgPocket(Boolean r1, Integer r2, String r3, String r4, String r5) {
        this.allowPhotos = r1;
        this.selectedPhotosCount = r2;
        this.selectedModel = r3;
        this.presetImageUrl = r4;
        this.presetImageUri = r5;
    }

    public /* synthetic */ SendMsgPocket(Boolean r4, Integer r5, String r6, String r7, String r8, int r9, DefaultConstructorMarker r10) {
        if ((r9 & 1) == 0) goto L6;
        r4 = Boolean.FALSE;
    L6:
        if ((r9 & 2) == 0) goto L8;
        r5 = 0;
    L8:
        Integer r11 = r5;
        if ((r9 & 4) == 0) goto L11;
        r6 = "";
    L11:
        String r0 = r6;
        if ((r9 & 8) == 0) goto L14;
        String r1 = null;
    L16:
        if ((r9 & 16) == 0) goto L18;
        String r2 = null;
    L19:
        this(r4, r11, r0, r1, r2);
        return;
    L18:
        r2 = r8;
        goto L19
    L14:
        r1 = r7;
        goto L16
    }
}
