package com.ss.ugc.effectplatform.model.net;

import com.ss.android.lark.notification.export.entity.INotificationHitPoint;
import com.ss.ugc.effectplatform.extension.b;
import com.ss.ugc.effectplatform.model.CategoryEffectModel;
import com.ss.ugc.effectplatform.model.CategoryPageModel;
import com.ss.ugc.effectplatform.model.Effect;
import com.ss.ugc.effectplatform.model.e;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\u0000\n\u0002\b\u0014\b\u0087\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B)\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0006¢\u0006\u0004\b&\u0010'J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\t\u001a\u00020\bH\u0016J\b\u0010\n\u001a\u00020\bH\u0016J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\t\u0010\r\u001a\u00020\u0006HÆ\u0003J+\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0010\u001a\u00020\u0006HÆ\u0001J\t\u0010\u0012\u001a\u00020\u0004HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0006HÖ\u0001J\u0013\u0010\u0016\u001a\u00020\b2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014HÖ\u0003R$\u0010\u000e\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR$\u0010\u000f\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\"\u0010\u0010\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%¨\u0006("}, d2 = {"Lcom/ss/ugc/effectplatform/model/net/CategoryEffectListResponse;", "Lcom/ss/ugc/effectplatform/model/e;", "Lcom/ss/ugc/effectplatform/model/CategoryPageModel;", "getResponseData", "", "getResponseMessage", "", "getStatusCode", "", "checkValue", "verifySign", "component1", "component2", "component3", "data", INotificationHitPoint.NoticeType.MESSAGE, "status_code", "copy", "toString", "hashCode", "", INotificationHitPoint.NoticeType.OTHER, "equals", "Lcom/ss/ugc/effectplatform/model/CategoryPageModel;", "getData", "()Lcom/ss/ugc/effectplatform/model/CategoryPageModel;", "setData", "(Lcom/ss/ugc/effectplatform/model/CategoryPageModel;)V", "Ljava/lang/String;", "getMessage", "()Ljava/lang/String;", "setMessage", "(Ljava/lang/String;)V", "I", "getStatus_code", "()I", "setStatus_code", "(I)V", "<init>", "(Lcom/ss/ugc/effectplatform/model/CategoryPageModel;Ljava/lang/String;I)V", "effectplatform_release"}, k = 1, mv = {1, 4, 0})
public final class CategoryEffectListResponse extends e<CategoryPageModel> {
    private CategoryPageModel data;
    private String message;
    private int status_code;

    public CategoryEffectListResponse() {
        this(null, null, 0, 7, null);
    }

    public static /* synthetic */ CategoryEffectListResponse copy$default(CategoryEffectListResponse r0, CategoryPageModel r1, String r2, int r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.data;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.message;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.status_code;
    L12:
        return r0.copy(r1, r2, r3);
    }

    public final CategoryPageModel component1() {
        return this.data;
    }

    public final String component2() {
        return this.message;
    }

    public final int component3() {
        return this.status_code;
    }

    public final CategoryEffectListResponse copy(CategoryPageModel r2, String r3, int r4) {
        return new CategoryEffectListResponse(r2, r3, r4);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof CategoryEffectListResponse) == false) goto L12;
        CategoryEffectListResponse r4 = (CategoryEffectListResponse) r3;
        if (Intrinsics.areEqual(this.data, r4.data) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.message, r4.message) == true) goto L10;
        return false;
    L10:
        if (this.status_code == r4.status_code) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public int hashCode() {
        CategoryPageModel r0 = this.data;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        String r4 = this.message;
        if (r4 == null) goto L10;
        r1 = r4.hashCode();
    L10:
        return ((r3 + r1) * 31) + this.status_code;
    L5:
        r2 = 0;
        goto L6
    }

    public String toString() {
        return "CategoryEffectListResponse(data=" + this.data + ", message=" + this.message + ", status_code=" + this.status_code + ")";
    }

    public boolean checkValue() {
        CategoryPageModel r0 = this.data;
        if (r0 != null) goto L5;
        return false;
    L5:
        if (r0.getCategory_effects() == null) goto L9;
        return true;
    L9:
        return false;
    }

    public boolean verifySign() {
        CategoryPageModel r0 = this.data;
        if (r0 == null) goto L14;
        CategoryEffectModel r1 = r0.getCategory_effects();
        if (r1 == null) goto L14;
        List<Effect> r2 = r1.getCollection();
        if (r2 == null) goto L14;
        Iterator<T> r3 = r2.iterator();
    L10:
        if (r3.hasNext() == false) goto L14;
        if (b.a((Effect) r3.next()) == true) goto L10;
        return false;
    L14:
        CategoryPageModel r4 = this.data;
        if (r4 == null) goto L26;
        CategoryEffectModel r5 = r4.getCategory_effects();
        if (r5 == null) goto L26;
        List<Effect> r6 = r5.getBind_effects();
        if (r6 == null) goto L26;
        Iterator<T> r7 = r6.iterator();
    L22:
        if (r7.hasNext() == false) goto L26;
        if (b.a((Effect) r7.next()) == true) goto L22;
        return false;
    L26:
        CategoryPageModel r8 = this.data;
        if (r8 == null) goto L38;
        CategoryEffectModel r9 = r8.getCategory_effects();
        if (r9 == null) goto L49;
        List<Effect> r10 = r9.getCategory_effects();
        if (r10 == null) goto L50;
        Iterator<T> r11 = r10.iterator();
    L34:
        if (r11.hasNext() == false) goto L51;
        if (b.a((Effect) r11.next()) == true) goto L34;
        return false;
    L51:
        return true;
    L50:
        return true;
    L49:
        return true;
    L38:
        return true;
    }

    /* JADX INFO: renamed from: getResponseData, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m1529getResponseData() {
        return getResponseData();
    }

    public final CategoryPageModel getData() {
        return this.data;
    }

    public final String getMessage() {
        return this.message;
    }

    public String getResponseMessage() {
        return this.message;
    }

    public int getStatusCode() {
        return this.status_code;
    }

    public final int getStatus_code() {
        return this.status_code;
    }

    public CategoryPageModel getResponseData() {
        return this.data;
    }

    public final void setData(CategoryPageModel r1) {
        this.data = r1;
    }

    public final void setMessage(String r1) {
        this.message = r1;
    }

    public final void setStatus_code(int r1) {
        this.status_code = r1;
    }

    public CategoryEffectListResponse(CategoryPageModel r1, String r2, int r3) {
        this.data = r1;
        this.message = r2;
        this.status_code = r3;
    }

    public /* synthetic */ CategoryEffectListResponse(CategoryPageModel r2, String r3, int r4, int r5, DefaultConstructorMarker r6) {
        if ((r5 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r3 = null;
    L9:
        if ((r5 & 4) == 0) goto L11;
        r4 = 0;
    L11:
        this(r2, r3, r4);
    }
}
