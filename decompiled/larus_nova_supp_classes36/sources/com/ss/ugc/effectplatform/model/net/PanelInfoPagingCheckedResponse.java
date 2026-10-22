package com.ss.ugc.effectplatform.model.net;

import com.ss.android.lark.notification.export.entity.INotificationHitPoint;
import com.ss.ugc.effectplatform.extension.b;
import com.ss.ugc.effectplatform.model.CategoryEffectModel;
import com.ss.ugc.effectplatform.model.Effect;
import com.ss.ugc.effectplatform.model.PanelInfoModel;
import com.ss.ugc.effectplatform.model.e;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0000\n\u0002\b\u0015\b\u0081\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B5\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0007¢\u0006\u0004\b+\u0010,J\u000b\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÂ\u0003J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0016J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0003H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\b\u0010\u000b\u001a\u00020\tH\u0016J\u000b\u0010\r\u001a\u0004\u0018\u00010\fHÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÆ\u0003J\t\u0010\u0010\u001a\u00020\u0007HÆ\u0003J7\u0010\u0015\u001a\u00020\u00002\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0014\u001a\u00020\u0007HÆ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0007HÖ\u0001J\u0013\u0010\u001a\u001a\u00020\t2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018HÖ\u0003R$\u0010\u0011\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR$\u0010\u0012\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010%R\"\u0010\u0014\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010&\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*¨\u0006-"}, d2 = {"Lcom/ss/ugc/effectplatform/model/net/PanelInfoPagingCheckedResponse;", "Lcom/ss/ugc/effectplatform/model/e;", "Lcom/ss/ugc/effectplatform/model/PanelInfoModel;", "", "component3", "getResponseData", "getResponseMessage", "", "getStatusCode", "", "checkValue", "verifySign", "Lcom/ss/ugc/effectplatform/model/net/PanelInfoCheckedResponse;", "component1", "Lcom/ss/ugc/effectplatform/model/net/CategoryEffectListResponse;", "component2", "component4", "PanelInfoResponse", "CategoryEffectsResponse", INotificationHitPoint.NoticeType.MESSAGE, "status_code", "copy", "toString", "hashCode", "", INotificationHitPoint.NoticeType.OTHER, "equals", "Lcom/ss/ugc/effectplatform/model/net/PanelInfoCheckedResponse;", "getPanelInfoResponse", "()Lcom/ss/ugc/effectplatform/model/net/PanelInfoCheckedResponse;", "setPanelInfoResponse", "(Lcom/ss/ugc/effectplatform/model/net/PanelInfoCheckedResponse;)V", "Lcom/ss/ugc/effectplatform/model/net/CategoryEffectListResponse;", "getCategoryEffectsResponse", "()Lcom/ss/ugc/effectplatform/model/net/CategoryEffectListResponse;", "setCategoryEffectsResponse", "(Lcom/ss/ugc/effectplatform/model/net/CategoryEffectListResponse;)V", "Ljava/lang/String;", "I", "getStatus_code", "()I", "setStatus_code", "(I)V", "<init>", "(Lcom/ss/ugc/effectplatform/model/net/PanelInfoCheckedResponse;Lcom/ss/ugc/effectplatform/model/net/CategoryEffectListResponse;Ljava/lang/String;I)V", "effectplatform_release"}, k = 1, mv = {1, 4, 0})
public final class PanelInfoPagingCheckedResponse extends e<PanelInfoModel> {
    private CategoryEffectListResponse CategoryEffectsResponse;
    private PanelInfoCheckedResponse PanelInfoResponse;
    private String message;
    private int status_code;

    public PanelInfoPagingCheckedResponse() {
        this(null, null, null, 0, 15, null);
    }

    private final String component3() {
        return this.message;
    }

    public static /* synthetic */ PanelInfoPagingCheckedResponse copy$default(PanelInfoPagingCheckedResponse r0, PanelInfoCheckedResponse r1, CategoryEffectListResponse r2, String r3, int r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = r0.PanelInfoResponse;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = r0.CategoryEffectsResponse;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r3 = r0.message;
    L12:
        if ((r5 & 8) == 0) goto L15;
        r4 = r0.status_code;
    L15:
        return r0.copy(r1, r2, r3, r4);
    }

    public final PanelInfoCheckedResponse component1() {
        return this.PanelInfoResponse;
    }

    public final CategoryEffectListResponse component2() {
        return this.CategoryEffectsResponse;
    }

    public final int component4() {
        return this.status_code;
    }

    public final PanelInfoPagingCheckedResponse copy(PanelInfoCheckedResponse r2, CategoryEffectListResponse r3, String r4, int r5) {
        return new PanelInfoPagingCheckedResponse(r2, r3, r4, r5);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof PanelInfoPagingCheckedResponse) == false) goto L14;
        PanelInfoPagingCheckedResponse r4 = (PanelInfoPagingCheckedResponse) r3;
        if (Intrinsics.areEqual(this.PanelInfoResponse, r4.PanelInfoResponse) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.CategoryEffectsResponse, r4.CategoryEffectsResponse) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.message, r4.message) == true) goto L12;
        return false;
    L12:
        if (this.status_code == r4.status_code) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public int hashCode() {
        PanelInfoCheckedResponse r0 = this.PanelInfoResponse;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        CategoryEffectListResponse r4 = this.CategoryEffectsResponse;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.message;
        if (r7 == null) goto L14;
        r1 = r7.hashCode();
    L14:
        return ((r6 + r1) * 31) + this.status_code;
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public String toString() {
        return "PanelInfoPagingCheckedResponse(PanelInfoResponse=" + this.PanelInfoResponse + ", CategoryEffectsResponse=" + this.CategoryEffectsResponse + ", message=" + this.message + ", status_code=" + this.status_code + ")";
    }

    public boolean checkValue() {
        PanelInfoCheckedResponse r0 = this.PanelInfoResponse;
        if (r0 == null) goto L18;
        PanelInfoModel r2 = null;
        if (r0 == null) goto L8;
        Boolean r1 = r0.getUpdated();
    L10:
        if (Intrinsics.areEqual(r1, Boolean.TRUE) == false) goto L15;
        PanelInfoCheckedResponse r3 = this.PanelInfoResponse;
        if (r3 == null) goto L14;
        r2 = r3.getData();
    L14:
        if (r2 != null) goto L15;
        return false;
    L15:
        return true;
    L8:
        r1 = null;
        goto L10
    L18:
        return false;
    }

    public PanelInfoModel getResponseData() {
        return new PanelInfoPagingCheckedModel(this.PanelInfoResponse, this.CategoryEffectsResponse).getPanelInfo();
    }

    public boolean verifySign() {
        PanelInfoCheckedResponse r0 = this.PanelInfoResponse;
        if (r0 == null) goto L16;
        PanelInfoModel r1 = r0.getData();
        if (r1 == null) goto L16;
        CategoryEffectModel r2 = r1.getCategory_effects();
        if (r2 == null) goto L16;
        List<Effect> r3 = r2.getCollection();
        if (r3 == null) goto L16;
        Iterator<T> r4 = r3.iterator();
    L12:
        if (r4.hasNext() == false) goto L16;
        if (b.a((Effect) r4.next()) == true) goto L12;
        return false;
    L16:
        PanelInfoCheckedResponse r5 = this.PanelInfoResponse;
        if (r5 == null) goto L30;
        PanelInfoModel r6 = r5.getData();
        if (r6 == null) goto L30;
        CategoryEffectModel r7 = r6.getCategory_effects();
        if (r7 == null) goto L30;
        List<Effect> r8 = r7.getBind_effects();
        if (r8 == null) goto L30;
        Iterator<T> r9 = r8.iterator();
    L26:
        if (r9.hasNext() == false) goto L30;
        if (b.a((Effect) r9.next()) == true) goto L26;
        return false;
    L30:
        PanelInfoCheckedResponse r10 = this.PanelInfoResponse;
        if (r10 == null) goto L44;
        PanelInfoModel r11 = r10.getData();
        if (r11 == null) goto L55;
        CategoryEffectModel r12 = r11.getCategory_effects();
        if (r12 == null) goto L56;
        List<Effect> r13 = r12.getCategory_effects();
        if (r13 == null) goto L57;
        Iterator<T> r14 = r13.iterator();
    L40:
        if (r14.hasNext() == false) goto L58;
        if (b.a((Effect) r14.next()) == true) goto L40;
        return false;
    L58:
        return true;
    L57:
        return true;
    L56:
        return true;
    L55:
        return true;
    L44:
        return true;
    }

    public final CategoryEffectListResponse getCategoryEffectsResponse() {
        return this.CategoryEffectsResponse;
    }

    public final PanelInfoCheckedResponse getPanelInfoResponse() {
        return this.PanelInfoResponse;
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

    /* JADX INFO: renamed from: getResponseData, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m1545getResponseData() {
        return getResponseData();
    }

    public final void setCategoryEffectsResponse(CategoryEffectListResponse r1) {
        this.CategoryEffectsResponse = r1;
    }

    public final void setPanelInfoResponse(PanelInfoCheckedResponse r1) {
        this.PanelInfoResponse = r1;
    }

    public final void setStatus_code(int r1) {
        this.status_code = r1;
    }

    public PanelInfoPagingCheckedResponse(PanelInfoCheckedResponse r1, CategoryEffectListResponse r2, String r3, int r4) {
        this.PanelInfoResponse = r1;
        this.CategoryEffectsResponse = r2;
        this.message = r3;
        this.status_code = r4;
    }

    public /* synthetic */ PanelInfoPagingCheckedResponse(PanelInfoCheckedResponse r2, CategoryEffectListResponse r3, String r4, int r5, int r6, DefaultConstructorMarker r7) {
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
        r5 = 0;
    L14:
        this(r2, r3, r4, r5);
    }
}
