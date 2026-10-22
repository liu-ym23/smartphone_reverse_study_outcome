package com.bytedance.android.live.openplatform.impl.miniappanchor.api.response;

import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.live.base.model.x;
import com.bytedance.android.live.openplatform.api.model.shelf.ProductInfo;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@ProtoMessage("webcast.api.stamp.PresetCard")
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0087\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\u000bR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\t\u001a\u0004\b\u000f\u0010\u000bR\u001a\u0010\u0011\u001a\u00020\u00108\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0011\u0010\u0013R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u00148\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/miniappanchor/api/response/l;", "", "Lcom/bytedance/android/live/base/model/ImageModel;", "image", "Lcom/bytedance/android/live/base/model/ImageModel;", "getImage", "()Lcom/bytedance/android/live/base/model/ImageModel;", "", "title", "Ljava/lang/String;", "getTitle", "()Ljava/lang/String;", "schema", "getSchema", "sourcePath", "getSourcePath", "", "isProduct", "Z", "()Z", "Lcom/bytedance/android/live/openplatform/api/model/shelf/ProductInfo;", "productInfo", "Lcom/bytedance/android/live/openplatform/api/model/shelf/ProductInfo;", "getProductInfo", "()Lcom/bytedance/android/live/openplatform/api/model/shelf/ProductInfo;", "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class l implements vh7.h {

    @SerializedName("image")
    protected ImageModel image;

    @SerializedName("is_product")
    protected boolean isProduct;

    @SerializedName("product_info")
    protected ProductInfo productInfo;

    @SerializedName("schema")
    protected String schema;

    @SerializedName("source_path")
    protected String sourcePath;

    @SerializedName("title")
    protected String title;

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof l) == false) goto L18;
        l r4 = (l) r3;
        if (Intrinsics.areEqual(this.image, r4.image) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.title, r4.title) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.schema, r4.schema) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.sourcePath, r4.sourcePath) == true) goto L14;
        return false;
    L14:
        if (this.isProduct == r4.isProduct) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.productInfo, r4.productInfo) == true) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v10, types: [int] */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v16 */
    public final int hashCode() {
        ImageModel r0 = this.image;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        String r4 = this.title;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.schema;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.sourcePath;
        if (r10 == null) goto L17;
        int r11 = r10.hashCode();
    L18:
        int r12 = (r9 + r11) * 31;
        boolean r13 = this.isProduct;
        ?? r14 = r13;
        if (r13 == false) goto L21;
        r14 = 1;
    L21:
        int r15 = (r12 + r14) * 31;
        ProductInfo r16 = this.productInfo;
        if (r16 == null) goto L25;
        r1 = r16.hashCode();
    L25:
        return r15 + r1;
    L17:
        r11 = 0;
        goto L18
    L13:
        r8 = 0;
        goto L14
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "PresetCard(image=" + this.image + ", title=" + this.title + ", schema=" + this.schema + ", sourcePath=" + this.sourcePath + ", isProduct=" + this.isProduct + ", productInfo=" + this.productInfo + ")";
    }

    public l() {
        this.image = null;
        this.title = null;
        this.schema = null;
        this.sourcePath = null;
        this.isProduct = false;
        this.productInfo = null;
    }

    public l(am3.g r7) {
        long r0 = r7.c();
        boolean r3 = false;
    L3:
        int r4 = r7.f();
        if (r4 == (-1)) goto L13;
        switch(r4) {
            case 1: goto L12;
            case 2: goto L11;
            case 3: goto L10;
            case 4: goto L9;
            case 5: goto L8;
            case 6: goto L7;
            default: goto L6;
        };
    L7:
        this.productInfo = new ProductInfo(r7);
        goto L3
    L8:
        this.isProduct = am3.h.a(r7);
        r3 = r3 | true;
        goto L3
    L9:
        this.sourcePath = am3.h.c(r7);
        goto L3
    L10:
        this.schema = am3.h.c(r7);
        goto L3
    L11:
        this.title = am3.h.c(r7);
        goto L3
    L12:
        this.image = x.a(r7);
        goto L3
    L6:
        am3.h.e(r7);
        goto L3
    L13:
        r7.d(r0);
        if (this.image != null) goto L17;
        this.image = null;
    L17:
        if (this.title != null) goto L20;
        this.title = null;
    L20:
        if (this.schema != null) goto L23;
        this.schema = null;
    L23:
        if (this.sourcePath != null) goto L26;
        this.sourcePath = null;
    L26:
        if ((r3 & true) == true) goto L29;
        this.isProduct = false;
    L29:
        if (this.productInfo != null) goto L48;
        this.productInfo = null;
        return;
    }
}
