package com.ss.ugc.effectplatform.model.net;

import com.ss.ugc.effectplatform.model.CategoryEffectModel;
import com.ss.ugc.effectplatform.model.CategoryPageModel;
import com.ss.ugc.effectplatform.model.PanelInfoModel;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0011"}, d2 = {"Lcom/ss/ugc/effectplatform/model/net/PanelInfoPagingCheckedModel;", "", "panelInfoResponse", "Lcom/ss/ugc/effectplatform/model/net/PanelInfoCheckedResponse;", "categoryEffectsResponse", "Lcom/ss/ugc/effectplatform/model/net/CategoryEffectListResponse;", "(Lcom/ss/ugc/effectplatform/model/net/PanelInfoCheckedResponse;Lcom/ss/ugc/effectplatform/model/net/CategoryEffectListResponse;)V", "getCategoryEffectsResponse", "()Lcom/ss/ugc/effectplatform/model/net/CategoryEffectListResponse;", "setCategoryEffectsResponse", "(Lcom/ss/ugc/effectplatform/model/net/CategoryEffectListResponse;)V", "getPanelInfoResponse", "()Lcom/ss/ugc/effectplatform/model/net/PanelInfoCheckedResponse;", "setPanelInfoResponse", "(Lcom/ss/ugc/effectplatform/model/net/PanelInfoCheckedResponse;)V", "getPanelInfo", "Lcom/ss/ugc/effectplatform/model/PanelInfoModel;", "effectplatform_release"}, k = 1, mv = {1, 1, 16})
public final class PanelInfoPagingCheckedModel {
    private CategoryEffectListResponse categoryEffectsResponse;
    private PanelInfoCheckedResponse panelInfoResponse;

    public final PanelInfoModel getPanelInfo() {
        PanelInfoCheckedResponse r0 = this.panelInfoResponse;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getData();
    }

    public final CategoryEffectListResponse getCategoryEffectsResponse() {
        return this.categoryEffectsResponse;
    }

    public final PanelInfoCheckedResponse getPanelInfoResponse() {
        return this.panelInfoResponse;
    }

    public final void setCategoryEffectsResponse(CategoryEffectListResponse r1) {
        this.categoryEffectsResponse = r1;
    }

    public final void setPanelInfoResponse(PanelInfoCheckedResponse r1) {
        this.panelInfoResponse = r1;
    }

    public PanelInfoPagingCheckedModel(PanelInfoCheckedResponse r1, CategoryEffectListResponse r2) {
        this.panelInfoResponse = r1;
        this.categoryEffectsResponse = r2;
        if (r1 == null) goto L13;
        PanelInfoModel r3 = r1.getData();
        if (r3 == null) goto L13;
        CategoryEffectListResponse r4 = this.categoryEffectsResponse;
        if (r4 == null) goto L11;
        CategoryPageModel r5 = r4.getData();
        if (r5 == null) goto L11;
        CategoryEffectModel r6 = r5.getCategory_effects();
    L12:
        r3.setCategory_effects(r6);
    L11:
        r6 = null;
    L13:
        CategoryEffectListResponse r7 = this.categoryEffectsResponse;
        if (r7 == null) goto L24;
        CategoryPageModel r8 = r7.getData();
        if (r8 == null) goto L24;
        List<String> r9 = r8.getUrl_prefix();
        if (r9 == null) goto L24;
        PanelInfoCheckedResponse r10 = this.panelInfoResponse;
        if (r10 == null) goto L24;
        PanelInfoModel r11 = r10.getData();
        if (r11 == null) goto L24;
        r11.setUrl_prefix(r9);
    L24:
        CategoryEffectListResponse r12 = this.categoryEffectsResponse;
        if (r12 == null) goto L38;
        CategoryPageModel r13 = r12.getData();
        if (r13 == null) goto L39;
        CategoryPageModel.Extra r14 = r13.getExtra();
        if (r14 == null) goto L40;
        String r15 = r14.getRec_id();
        if (r15 == null) goto L41;
        PanelInfoModel.Extra r16 = new PanelInfoModel.Extra();
        r16.setRec_id(r15);
        PanelInfoCheckedResponse r17 = this.panelInfoResponse;
        if (r17 == null) goto L42;
        PanelInfoModel r18 = r17.getData();
        if (r18 == null) goto L43;
        r18.setExtra(r16);
        return;
    L43:
        return;
    L42:
        return;
    L41:
        return;
    L40:
        return;
    L39:
        return;
    }
}
