package com.bytedance.android.live.openplatform.impl.miniappanchor.api.response;

import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.live.base.model.x;
import com.bytedance.android.live.openplatform.api.model.shelf.ProductInfo;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@ProtoMessage("webcast.api.stamp.GetPresetCardResponse.Data")
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\t\b\u0087\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\r\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\t\u001a\u0004\b\u0012\u0010\u000bR\u001c\u0010\u0013\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u000e\u001a\u0004\b\u0014\u0010\u0010R\u001a\u0010\u0015\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0004\u001a\u0004\b\u0015\u0010\u0006R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u00168\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u001c\u0010\u001b\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001b\u0010\u000e\u001a\u0004\b\u001c\u0010\u0010R\u001c\u0010\u001d\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001d\u0010\u000e\u001a\u0004\b\u001e\u0010\u0010¨\u0006\u001f"}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/miniappanchor/api/response/e;", "", "", "hasSet", "Z", "d", "()Z", "Lcom/bytedance/android/live/base/model/ImageModel;", "image", "Lcom/bytedance/android/live/base/model/ImageModel;", "getImage", "()Lcom/bytedance/android/live/base/model/ImageModel;", "", "title", "Ljava/lang/String;", "getTitle", "()Ljava/lang/String;", "cacheImage", "getCacheImage", "cacheTitle", "getCacheTitle", "isProduct", "Lcom/bytedance/android/live/openplatform/api/model/shelf/ProductInfo;", "productInfo", "Lcom/bytedance/android/live/openplatform/api/model/shelf/ProductInfo;", "g", "()Lcom/bytedance/android/live/openplatform/api/model/shelf/ProductInfo;", "iconBackgroundColor", "e", "textPosterTitleColor", "h", "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class e implements vh7.h {

    @SerializedName("image_cache")
    protected ImageModel cacheImage;

    @SerializedName("title_cache")
    protected String cacheTitle;

    @SerializedName("has_set")
    protected boolean hasSet;

    @SerializedName("RGB")
    protected String iconBackgroundColor;

    @SerializedName("image")
    protected ImageModel image;

    @SerializedName("is_product")
    protected boolean isProduct;

    @SerializedName("product_info")
    protected ProductInfo productInfo;

    @SerializedName("word_RGB")
    protected String textPosterTitleColor;

    @SerializedName("title")
    protected String title;

    public e(boolean r1, ImageModel r2, String r3, ImageModel r4, String r5, boolean r6, ProductInfo r7, String r8, String r9) {
        this.hasSet = r1;
        this.image = r2;
        this.title = r3;
        this.cacheImage = r4;
        this.cacheTitle = r5;
        this.isProduct = r6;
        this.productInfo = r7;
        this.iconBackgroundColor = r8;
        this.textPosterTitleColor = r9;
    }

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof e) == false) goto L24;
        e r4 = (e) r3;
        if (this.hasSet == r4.hasSet) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.image, r4.image) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.title, r4.title) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.cacheImage, r4.cacheImage) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.cacheTitle, r4.cacheTitle) == true) goto L16;
        return false;
    L16:
        if (this.isProduct == r4.isProduct) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.productInfo, r4.productInfo) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.iconBackgroundColor, r4.iconBackgroundColor) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.textPosterTitleColor, r4.textPosterTitleColor) == true) goto L37;
        return false;
    L37:
        return true;
    L24:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v11, types: [int] */
    /* JADX WARN: Type inference failed for: r0v18 */
    /* JADX WARN: Type inference failed for: r0v19 */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v11 */
    public final int hashCode() {
        boolean r0 = this.hasSet;
        ?? r1 = 1;
        ?? r2 = r0;
        if (r0 == false) goto L5;
        r2 = 1;
    L5:
        int r3 = r2 * 31;
        ImageModel r4 = this.image;
        int r5 = 0;
        if (r4 == null) goto L8;
        int r6 = r4.hashCode();
    L9:
        int r7 = (r3 + r6) * 31;
        String r8 = this.title;
        if (r8 == null) goto L12;
        int r9 = r8.hashCode();
    L13:
        int r10 = (r7 + r9) * 31;
        ImageModel r11 = this.cacheImage;
        if (r11 == null) goto L16;
        int r12 = r11.hashCode();
    L17:
        int r13 = (r10 + r12) * 31;
        String r14 = this.cacheTitle;
        if (r14 == null) goto L20;
        int r15 = r14.hashCode();
    L21:
        int r16 = (r13 + r15) * 31;
        boolean r17 = this.isProduct;
        if (r17 == true) goto L25;
        r1 = r17;
    L25:
        int r18 = (r16 + r1) * 31;
        ProductInfo r19 = this.productInfo;
        if (r19 == null) goto L28;
        int r20 = r19.hashCode();
    L29:
        int r21 = (r18 + r20) * 31;
        String r22 = this.iconBackgroundColor;
        if (r22 == null) goto L32;
        int r23 = r22.hashCode();
    L33:
        int r24 = (r21 + r23) * 31;
        String r25 = this.textPosterTitleColor;
        if (r25 == null) goto L37;
        r5 = r25.hashCode();
    L37:
        return r24 + r5;
    L32:
        r23 = 0;
        goto L33
    L28:
        r20 = 0;
        goto L29
    L20:
        r15 = 0;
        goto L21
    L16:
        r12 = 0;
        goto L17
    L12:
        r9 = 0;
        goto L13
    L8:
        r6 = 0;
        goto L9
    }

    public final String toString() {
        return "GetPresetCardResponse(hasSet=" + this.hasSet + ", image=" + this.image + ", title=" + this.title + ", cacheImage=" + this.cacheImage + ", cacheTitle=" + this.cacheTitle + ", isProduct=" + this.isProduct + ", productInfo=" + this.productInfo + ", iconBackgroundColor=" + this.iconBackgroundColor + ", textPosterTitleColor=" + this.textPosterTitleColor + ")";
    }

    public final String b() {
        ImageModel r0 = this.cacheImage;
        if (r0 == null) goto L7;
        List r1 = r0.getUrls();
        if (r1 == null) goto L7;
        return (String) CollectionsKt.firstOrNull(r1);
    L7:
        return null;
    }

    public final String c() {
        String r0 = this.title;
        String r1 = this.cacheTitle;
        if (r1 != null) goto L5;
    L11:
        if (r0 != null) goto L13;
        return null;
    L13:
        if ((!StringsKt.isBlank(r0)) == true) goto L15;
        return null;
    L15:
        return r0;
    L5:
        if ((!StringsKt.isBlank(r1)) == true) goto L8;
        r1 = null;
    L8:
        if (r1 == null) goto L11;
        r0 = r1;
        goto L11
    }

    public final String f() {
        ImageModel r0 = this.image;
        if (r0 == null) goto L7;
        List r1 = r0.getUrls();
        if (r1 == null) goto L7;
        return (String) CollectionsKt.firstOrNull(r1);
    L7:
        return null;
    }

    public final boolean i() {
        ImageModel r0 = this.cacheImage;
        String r3 = null;
        if (r0 == null) goto L14;
        List r1 = r0.getUrls();
        if (r1 == null) goto L14;
        String r2 = (String) CollectionsKt.firstOrNull(r1);
        if (r2 == null) goto L14;
        if (r2.length() <= 0) goto L11;
        boolean r4 = true;
    L12:
        if (r4 == false) goto L14;
        r3 = r2;
        goto L14
    L11:
        r4 = false;
    L14:
        if (r3 != null) goto L18;
        return false;
    L18:
        return true;
    }

    public final boolean j() {
        String r0 = this.cacheTitle;
        if (r0 != null) goto L5;
    L7:
        r0 = null;
    L8:
        if (r0 != null) goto L12;
        return false;
    L12:
        return true;
    L5:
        if ((!StringsKt.isBlank(r0)) == false) goto L7;
        goto L7
    }

    public e() {
        this.hasSet = false;
        this.image = null;
        this.title = null;
        this.cacheImage = null;
        this.cacheTitle = null;
        this.isProduct = false;
        this.productInfo = null;
        this.iconBackgroundColor = null;
        this.textPosterTitleColor = null;
    }

    public final boolean d() {
        return this.hasSet;
    }

    public final String e() {
        return this.iconBackgroundColor;
    }

    public final ProductInfo g() {
        return this.productInfo;
    }

    public final String h() {
        return this.textPosterTitleColor;
    }

    public e(am3.g r7) {
        long r0 = r7.c();
        int r3 = 0;
    L3:
        int r4 = r7.f();
        if (r4 == (-1)) goto L20;
        if (r4 != 10) goto L8;
        this.iconBackgroundColor = am3.h.c(r7);
        goto L3
    L8:
        if (r4 != 12) goto L9;
        this.textPosterTitleColor = am3.h.c(r7);
        goto L3
    L9:
        switch(r4) {
            case 1: goto L17;
            case 2: goto L16;
            case 3: goto L15;
            case 4: goto L14;
            case 5: goto L13;
            case 6: goto L12;
            case 7: goto L11;
            default: goto L10;
        };
    L11:
        this.productInfo = new ProductInfo(r7);
        goto L3
    L12:
        this.isProduct = am3.h.a(r7);
        r3 = r3 | 2;
        goto L3
    L13:
        this.cacheTitle = am3.h.c(r7);
        goto L3
    L14:
        this.cacheImage = x.a(r7);
        goto L3
    L15:
        this.title = am3.h.c(r7);
        goto L3
    L16:
        this.image = x.a(r7);
        goto L3
    L17:
        this.hasSet = am3.h.a(r7);
        r3 = r3 | 1;
        goto L3
    L10:
        am3.h.e(r7);
        goto L3
    L20:
        r7.d(r0);
        if ((r3 & 1) != 0) goto L24;
        this.hasSet = false;
    L24:
        if (this.image != null) goto L27;
        this.image = null;
    L27:
        if (this.title != null) goto L30;
        this.title = null;
    L30:
        if (this.cacheImage != null) goto L33;
        this.cacheImage = null;
    L33:
        if (this.cacheTitle != null) goto L36;
        this.cacheTitle = null;
    L36:
        if ((r3 & 2) != 0) goto L39;
        this.isProduct = false;
    L39:
        if (this.productInfo != null) goto L42;
        this.productInfo = null;
    L42:
        if (this.iconBackgroundColor != null) goto L45;
        this.iconBackgroundColor = null;
    L45:
        if (this.textPosterTitleColor != null) goto L72;
        this.textPosterTitleColor = null;
        return;
    }

    public static e a(e r10, ProductInfo r11) {
        boolean r1 = r10.hasSet;
        ImageModel r2 = r10.image;
        String r3 = r10.title;
        ImageModel r4 = r10.cacheImage;
        String r5 = r10.cacheTitle;
        boolean r6 = r10.isProduct;
        String r8 = r10.iconBackgroundColor;
        String r9 = r10.textPosterTitleColor;
        r10.getClass();
        return new e(r1, r2, r3, r4, r5, r6, r11, r8, r9);
    }
}
