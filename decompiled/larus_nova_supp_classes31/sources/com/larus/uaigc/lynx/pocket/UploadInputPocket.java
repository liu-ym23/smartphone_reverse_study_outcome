package com.larus.uaigc.lynx.pocket;

import com.google.gson.annotations.SerializedName;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b!\b\u0087\b\u0018\u00002\u00020\u0001Bg\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u001f\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0014J\u0010\u0010 \u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u0017J\u000b\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0003HÆ\u0003Jn\u0010$\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010%J\u0013\u0010&\u001a\u00020\u00072\b\u0010'\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010(\u001a\u00020\tHÖ\u0001J\t\u0010)\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b\u0016\u0010\u0017R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0010R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0010R\u0018\u0010\f\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0010¨\u0006*"}, d2 = {"Lcom/larus/uaigc/lynx/pocket/UploadInputPocket;", "", "inputBoxTitle", "", "inputPlaceholder", "inputPlaceholderPrompt", "mustPhotos", "", "selectedPhotosCount", "", "preSetPhotoUrl", "preSetPhotoUri", "selectedModel", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getInputBoxTitle", "()Ljava/lang/String;", "getInputPlaceholder", "getInputPlaceholderPrompt", "getMustPhotos", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getSelectedPhotosCount", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getPreSetPhotoUrl", "getPreSetPhotoUri", "getSelectedModel", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/larus/uaigc/lynx/pocket/UploadInputPocket;", "equals", "other", "hashCode", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class UploadInputPocket {

    @SerializedName("input_box_title")
    private final String inputBoxTitle;

    @SerializedName("input_placeholder")
    private final String inputPlaceholder;

    @SerializedName("input_placeholder_prompt")
    private final String inputPlaceholderPrompt;

    @SerializedName("must_photos")
    private final Boolean mustPhotos;

    @SerializedName("pre_set_photo_uri")
    private final String preSetPhotoUri;

    @SerializedName("pre_set_photo_url")
    private final String preSetPhotoUrl;

    @SerializedName("selected_model")
    private final String selectedModel;

    @SerializedName("selected_photos_count")
    private final Integer selectedPhotosCount;

    public UploadInputPocket() {
        this(null, null, null, null, null, null, null, null, 255, null);
    }

    public static /* synthetic */ UploadInputPocket copy$default(UploadInputPocket r9, String r10, String r11, String r12, Boolean r13, Integer r14, String r15, String r16, String r17, int r18, Object r19) {
        if ((r18 & 1) == 0) goto L5;
        String r2 = r9.inputBoxTitle;
    L7:
        if ((r18 & 2) == 0) goto L9;
        String r3 = r9.inputPlaceholder;
    L11:
        if ((r18 & 4) == 0) goto L13;
        String r4 = r9.inputPlaceholderPrompt;
    L15:
        if ((r18 & 8) == 0) goto L17;
        Boolean r5 = r9.mustPhotos;
    L19:
        if ((r18 & 16) == 0) goto L21;
        Integer r6 = r9.selectedPhotosCount;
    L23:
        if ((r18 & 32) == 0) goto L25;
        String r7 = r9.preSetPhotoUrl;
    L27:
        if ((r18 & 64) == 0) goto L29;
        String r8 = r9.preSetPhotoUri;
    L31:
        if ((r18 & 128) == 0) goto L33;
        String r1 = r9.selectedModel;
    L35:
        return r9.copy(r2, r3, r4, r5, r6, r7, r8, r1);
    L33:
        r1 = r17;
        goto L35
    L29:
        r8 = r16;
        goto L31
    L25:
        r7 = r15;
        goto L27
    L21:
        r6 = r14;
        goto L23
    L17:
        r5 = r13;
        goto L19
    L13:
        r4 = r12;
        goto L15
    L9:
        r3 = r11;
        goto L11
    L5:
        r2 = r10;
        goto L7
    }

    public final String component1() {
        return this.inputBoxTitle;
    }

    public final String component2() {
        return this.inputPlaceholder;
    }

    public final String component3() {
        return this.inputPlaceholderPrompt;
    }

    public final Boolean component4() {
        return this.mustPhotos;
    }

    public final Integer component5() {
        return this.selectedPhotosCount;
    }

    public final String component6() {
        return this.preSetPhotoUrl;
    }

    public final String component7() {
        return this.preSetPhotoUri;
    }

    public final String component8() {
        return this.selectedModel;
    }

    public final UploadInputPocket copy(String r11, String r12, String r13, Boolean r14, Integer r15, String r16, String r17, String r18) {
        return new UploadInputPocket(r11, r12, r13, r14, r15, r16, r17, r18);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof UploadInputPocket) == true) goto L8;
        return false;
    L8:
        UploadInputPocket r6 = (UploadInputPocket) r5;
        if (Intrinsics.areEqual(this.inputBoxTitle, r6.inputBoxTitle) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.inputPlaceholder, r6.inputPlaceholder) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.inputPlaceholderPrompt, r6.inputPlaceholderPrompt) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.mustPhotos, r6.mustPhotos) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.selectedPhotosCount, r6.selectedPhotosCount) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.preSetPhotoUrl, r6.preSetPhotoUrl) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.preSetPhotoUri, r6.preSetPhotoUri) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.selectedModel, r6.selectedModel) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public int hashCode() {
        String r0 = this.inputBoxTitle;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.inputPlaceholder;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.inputPlaceholderPrompt;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        Boolean r10 = this.mustPhotos;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        Integer r13 = this.selectedPhotosCount;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        String r16 = this.preSetPhotoUrl;
        if (r16 != null) goto L25;
        int r17 = 0;
    L26:
        int r18 = (r15 + r17) * 31;
        String r19 = this.preSetPhotoUri;
        if (r19 != null) goto L29;
        int r20 = 0;
    L30:
        int r21 = (r18 + r20) * 31;
        String r22 = this.selectedModel;
        if (r22 == null) goto L35;
        r1 = r22.hashCode();
    L35:
        return r21 + r1;
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
        return "UploadInputPocket(inputBoxTitle=" + this.inputBoxTitle + ", inputPlaceholder=" + this.inputPlaceholder + ", inputPlaceholderPrompt=" + this.inputPlaceholderPrompt + ", mustPhotos=" + this.mustPhotos + ", selectedPhotosCount=" + this.selectedPhotosCount + ", preSetPhotoUrl=" + this.preSetPhotoUrl + ", preSetPhotoUri=" + this.preSetPhotoUri + ", selectedModel=" + this.selectedModel + ')';
    }

    public final String getInputBoxTitle() {
        return this.inputBoxTitle;
    }

    public final String getInputPlaceholder() {
        return this.inputPlaceholder;
    }

    public final String getInputPlaceholderPrompt() {
        return this.inputPlaceholderPrompt;
    }

    public final Boolean getMustPhotos() {
        return this.mustPhotos;
    }

    public final String getPreSetPhotoUri() {
        return this.preSetPhotoUri;
    }

    public final String getPreSetPhotoUrl() {
        return this.preSetPhotoUrl;
    }

    public final String getSelectedModel() {
        return this.selectedModel;
    }

    public final Integer getSelectedPhotosCount() {
        return this.selectedPhotosCount;
    }

    public UploadInputPocket(String r1, String r2, String r3, Boolean r4, Integer r5, String r6, String r7, String r8) {
        this.inputBoxTitle = r1;
        this.inputPlaceholder = r2;
        this.inputPlaceholderPrompt = r3;
        this.mustPhotos = r4;
        this.selectedPhotosCount = r5;
        this.preSetPhotoUrl = r6;
        this.preSetPhotoUri = r7;
        this.selectedModel = r8;
    }

    public /* synthetic */ UploadInputPocket(String r10, String r11, String r12, Boolean r13, Integer r14, String r15, String r16, String r17, int r18, DefaultConstructorMarker r19) {
        String r2 = null;
        if ((r18 & 1) == 0) goto L5;
        String r1 = null;
    L7:
        if ((r18 & 2) == 0) goto L9;
        String r3 = null;
    L11:
        if ((r18 & 4) == 0) goto L13;
        String r4 = null;
    L15:
        if ((r18 & 8) == 0) goto L17;
        Boolean r5 = Boolean.FALSE;
    L19:
        if ((r18 & 16) == 0) goto L21;
        Integer r6 = 0;
    L23:
        if ((r18 & 32) == 0) goto L25;
        String r7 = null;
    L27:
        if ((r18 & 64) == 0) goto L29;
        String r8 = null;
    L31:
        if ((r18 & 128) != 0) goto L34;
        r2 = r17;
    L34:
        this(r1, r3, r4, r5, r6, r7, r8, r2);
        return;
    L29:
        r8 = r16;
        goto L31
    L25:
        r7 = r15;
        goto L27
    L21:
        r6 = r14;
        goto L23
    L17:
        r5 = r13;
        goto L19
    L13:
        r4 = r12;
        goto L15
    L9:
        r3 = r11;
        goto L11
    L5:
        r1 = r10;
        goto L7
    }
}
