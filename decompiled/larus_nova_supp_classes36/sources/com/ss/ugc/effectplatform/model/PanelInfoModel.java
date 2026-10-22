package com.ss.ugc.effectplatform.model;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u001f\b\u0017\u0018\u00002\u00020\u0001:\u0001-Bk\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\u0002\u0010\u0010R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R \u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R(\u0010\u001a\u001a\u0004\u0018\u00010\n2\b\u0010\u0019\u001a\u0004\u0018\u00010\n8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\f\u001a\u0004\u0018\u00010\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010$\"\u0004\b(\u0010&R \u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u0016\"\u0004\b*\u0010\u0018R\u001a\u0010\u0002\u001a\u00020\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010$\"\u0004\b,\u0010&¨\u0006."}, d2 = {"Lcom/ss/ugc/effectplatform/model/PanelInfoModel;", "", "version", "", "category_list", "", "Lcom/ss/ugc/effectplatform/model/EffectCategoryModel;", "category_effects", "Lcom/ss/ugc/effectplatform/model/CategoryEffectModel;", "panel", "Lcom/ss/ugc/effectplatform/model/EffectPanelModel;", "front_effect_id", "rear_effect_id", "url_prefix", "extra", "Lcom/ss/ugc/effectplatform/model/PanelInfoModel$Extra;", "(Ljava/lang/String;Ljava/util/List;Lcom/ss/ugc/effectplatform/model/CategoryEffectModel;Lcom/ss/ugc/effectplatform/model/EffectPanelModel;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Lcom/ss/ugc/effectplatform/model/PanelInfoModel$Extra;)V", "getCategory_effects", "()Lcom/ss/ugc/effectplatform/model/CategoryEffectModel;", "setCategory_effects", "(Lcom/ss/ugc/effectplatform/model/CategoryEffectModel;)V", "getCategory_list", "()Ljava/util/List;", "setCategory_list", "(Ljava/util/List;)V", "value", "effect_panel", "getEffect_panel", "()Lcom/ss/ugc/effectplatform/model/EffectPanelModel;", "setEffect_panel", "(Lcom/ss/ugc/effectplatform/model/EffectPanelModel;)V", "getExtra", "()Lcom/ss/ugc/effectplatform/model/PanelInfoModel$Extra;", "setExtra", "(Lcom/ss/ugc/effectplatform/model/PanelInfoModel$Extra;)V", "getFront_effect_id", "()Ljava/lang/String;", "setFront_effect_id", "(Ljava/lang/String;)V", "getRear_effect_id", "setRear_effect_id", "getUrl_prefix", "setUrl_prefix", "getVersion", "setVersion", "Extra", "effect_model_release"}, k = 1, mv = {1, 1, 16})
public class PanelInfoModel {
    private CategoryEffectModel category_effects;
    private List<? extends EffectCategoryModel> category_list;
    private Extra extra;
    private String front_effect_id;
    private EffectPanelModel panel;
    private String rear_effect_id;
    private List<String> url_prefix;
    private String version;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/ss/ugc/effectplatform/model/PanelInfoModel$Extra;", "", "()V", "rec_id", "", "getRec_id", "()Ljava/lang/String;", "setRec_id", "(Ljava/lang/String;)V", "effect_model_release"}, k = 1, mv = {1, 1, 16})
    public static final class Extra {
        private String rec_id;

        public Extra() {
            this.rec_id = "";
        }

        public final String getRec_id() {
            return this.rec_id;
        }

        public final void setRec_id(String r1) {
            this.rec_id = r1;
        }
    }

    public PanelInfoModel() {
        this(null, null, null, null, null, null, null, null, 255, null);
    }

    public CategoryEffectModel getCategory_effects() {
        return this.category_effects;
    }

    public List<EffectCategoryModel> getCategory_list() {
        return this.category_list;
    }

    public final EffectPanelModel getEffect_panel() {
        return this.panel;
    }

    public final Extra getExtra() {
        return this.extra;
    }

    public String getFront_effect_id() {
        return this.front_effect_id;
    }

    public String getRear_effect_id() {
        return this.rear_effect_id;
    }

    public List<String> getUrl_prefix() {
        return this.url_prefix;
    }

    public String getVersion() {
        return this.version;
    }

    public void setCategory_effects(CategoryEffectModel r1) {
        this.category_effects = r1;
    }

    public void setCategory_list(List<? extends EffectCategoryModel> r1) {
        this.category_list = r1;
    }

    public final void setEffect_panel(EffectPanelModel r1) {
        this.panel = r1;
    }

    public final void setExtra(Extra r1) {
        this.extra = r1;
    }

    public void setFront_effect_id(String r1) {
        this.front_effect_id = r1;
    }

    public void setRear_effect_id(String r1) {
        this.rear_effect_id = r1;
    }

    public void setUrl_prefix(List<String> r1) {
        this.url_prefix = r1;
    }

    public void setVersion(String r1) {
        this.version = r1;
    }

    public PanelInfoModel(String r1, List<? extends EffectCategoryModel> r2, CategoryEffectModel r3, EffectPanelModel r4, String r5, String r6, List<String> r7, Extra r8) {
        this.version = r1;
        this.category_list = r2;
        this.category_effects = r3;
        this.panel = r4;
        this.front_effect_id = r5;
        this.rear_effect_id = r6;
        this.url_prefix = r7;
        this.extra = r8;
    }

    public /* synthetic */ PanelInfoModel(String r10, List r11, CategoryEffectModel r12, EffectPanelModel r13, String r14, String r15, List r16, Extra r17, int r18, DefaultConstructorMarker r19) {
        if ((r18 & 1) == 0) goto L5;
        String r1 = "";
    L7:
        if ((r18 & 2) == 0) goto L9;
        List r2 = new ArrayList();
    L10:
        Extra r4 = null;
        if ((r18 & 4) == 0) goto L13;
        CategoryEffectModel r3 = null;
    L15:
        if ((r18 & 8) == 0) goto L17;
        EffectPanelModel r5 = null;
    L19:
        if ((r18 & 16) == 0) goto L21;
        String r6 = null;
    L23:
        if ((r18 & 32) == 0) goto L25;
        String r7 = null;
    L27:
        if ((r18 & 64) == 0) goto L29;
        List r8 = new ArrayList();
    L31:
        if ((r18 & 128) != 0) goto L34;
        r4 = r17;
    L34:
        this(r1, r2, r3, r5, r6, r7, r8, r4);
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
        r3 = r12;
        goto L15
    L9:
        r2 = r11;
        goto L10
    L5:
        r1 = r10;
        goto L7
    }
}
