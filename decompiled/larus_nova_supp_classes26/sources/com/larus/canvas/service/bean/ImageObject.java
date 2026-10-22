package com.larus.canvas.service.bean;

import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.larus.bmhome.share.panel.ShareType;
import com.larus.utils.gson.FilterNonNullTypeAdapterFactory;
import java.io.Serializable;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0013\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0087\b\u0018\u0000 \"2\u00020\u0001:\u0001\"B[\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\u0016\b\u0002\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\f\u0010\rJ\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0016J\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0016J\u0017\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\tHÆ\u0003J\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010\u001aJb\u0010\u001b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0016\b\u0002\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bHÆ\u0001¢\u0006\u0002\u0010\u001cJ\u0013\u0010\u001d\u001a\u00020\u000b2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fHÖ\u0003J\t\u0010 \u001a\u00020\u0006HÖ\u0001J\t\u0010!\u001a\u00020\u0003HÖ\u0001R\u0012\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\u000eR\u0014\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\u000eR\u001e\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\u000fR\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u00038F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012¨\u0006#"}, d2 = {"Lcom/larus/canvas/service/bean/ImageObject;", "Ljava/io/Serializable;", "uri", "", ShareType.URL, "width", "", "height", "urlFormats", "", "aiCreationImage", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/util/Map;Ljava/lang/Boolean;)V", "Ljava/lang/Integer;", "Ljava/lang/Boolean;", "heicUrl", "getHeicUrl", "()Ljava/lang/String;", "component1", "component2", "component3", "()Ljava/lang/Integer;", "component4", "component5", "component6", "()Ljava/lang/Boolean;", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/util/Map;Ljava/lang/Boolean;)Lcom/larus/canvas/service/bean/ImageObject;", "equals", "other", "", "hashCode", "toString", "Companion", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ImageObject implements Serializable {
    public static final a Companion = null;
    private static final long serialVersionUID = 1;

    @SerializedName("ai_creation_image")
    public final Boolean aiCreationImage;

    @SerializedName("height")
    public final Integer height;

    @SerializedName("uri")
    public final String uri;

    @SerializedName(ShareType.URL)
    public final String url;

    @SerializedName("url_formats")
    @JsonAdapter(FilterNonNullTypeAdapterFactory.class)
    public final Map<String, String> urlFormats;

    @SerializedName("width")
    public final Integer width;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public ImageObject() {
        this(null, null, null, null, null, null, 63, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ImageObject copy$default(ImageObject r4, String r5, String r6, Integer r7, Integer r8, Map r9, Boolean r10, int r11, Object r12) {
        if ((r11 & 1) == 0) goto L6;
        r5 = r4.uri;
    L6:
        if ((r11 & 2) == 0) goto L8;
        r6 = r4.url;
    L8:
        String r13 = r6;
        if ((r11 & 4) == 0) goto L11;
        r7 = r4.width;
    L11:
        Integer r0 = r7;
        if ((r11 & 8) == 0) goto L14;
        r8 = r4.height;
    L14:
        Integer r1 = r8;
        if ((r11 & 16) == 0) goto L17;
        r9 = r4.urlFormats;
    L17:
        Map r2 = r9;
        if ((r11 & 32) == 0) goto L20;
        r10 = r4.aiCreationImage;
    L20:
        String r14 = r5;
        return r4.copy(r14, r13, r0, r1, r2, r10);
    }

    public final String component1() {
        return this.uri;
    }

    public final String component2() {
        return this.url;
    }

    public final Integer component3() {
        return this.width;
    }

    public final Integer component4() {
        return this.height;
    }

    public final Map<String, String> component5() {
        return this.urlFormats;
    }

    public final Boolean component6() {
        return this.aiCreationImage;
    }

    public final ImageObject copy(String r9, String r10, Integer r11, Integer r12, Map<String, String> r13, Boolean r14) {
        return new ImageObject(r9, r10, r11, r12, r13, r14);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof ImageObject) == true) goto L8;
        return false;
    L8:
        ImageObject r6 = (ImageObject) r5;
        if (Intrinsics.areEqual(this.uri, r6.uri) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.url, r6.url) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.width, r6.width) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.height, r6.height) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.urlFormats, r6.urlFormats) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.aiCreationImage, r6.aiCreationImage) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public int hashCode() {
        String r0 = this.uri;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.url;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        Integer r7 = this.width;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        Integer r10 = this.height;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        Map<String, String> r13 = this.urlFormats;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        Boolean r16 = this.aiCreationImage;
        if (r16 == null) goto L27;
        r1 = r16.hashCode();
    L27:
        return r15 + r1;
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
        return "ImageObject(uri=" + this.uri + ", url=" + this.url + ", width=" + this.width + ", height=" + this.height + ", urlFormats=" + this.urlFormats + ", aiCreationImage=" + this.aiCreationImage + ')';
    }

    public final String getHeicUrl() {
        Map<String, String> r0 = this.urlFormats;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.get("heic");
    }

    public ImageObject(String r1, String r2, Integer r3, Integer r4, Map<String, String> r5, Boolean r6) {
        this.uri = r1;
        this.url = r2;
        this.width = r3;
        this.height = r4;
        this.urlFormats = r5;
        this.aiCreationImage = r6;
    }

    public /* synthetic */ ImageObject(String r6, String r7, Integer r8, Integer r9, Map r10, Boolean r11, int r12, DefaultConstructorMarker r13) {
        if ((r12 & 1) == 0) goto L5;
        String r14 = null;
    L7:
        if ((r12 & 2) == 0) goto L9;
        String r1 = null;
    L11:
        if ((r12 & 4) == 0) goto L13;
        r8 = 0;
    L13:
        Integer r2 = r8;
        if ((r12 & 8) == 0) goto L16;
        r9 = 0;
    L16:
        Integer r3 = r9;
        if ((r12 & 16) == 0) goto L19;
        Map r4 = null;
    L21:
        if ((r12 & 32) == 0) goto L23;
        Boolean r15 = null;
    L24:
        this(r14, r1, r2, r3, r4, r15);
        return;
    L23:
        r15 = r11;
        goto L24
    L19:
        r4 = r10;
        goto L21
    L9:
        r1 = r7;
        goto L11
    L5:
        r14 = r6;
        goto L7
    }
}
