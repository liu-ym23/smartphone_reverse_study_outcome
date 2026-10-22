package com.ss.ugc.effectplatform.model;

import com.ss.android.ugc.effectmanager.EffectConfiguration;
import java.util.ArrayList;
import java.util.List;
import kotlin.KotlinVersion;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b!\n\u0002\u0010\u000b\n\u0000\b\u0017\u0018\u00002\u00020\u0001Bs\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0005\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\u0002\u0010\u000fJ\u0006\u0010+\u001a\u00020,R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R0\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\b0\u00052\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\b0\u00058F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R0\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0017\u0010\u0013\"\u0004\b\u0018\u0010\u0015R0\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u001a\u0010\u0013\"\u0004\b\u001b\u0010\u0015R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010 \u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\n8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001c\u0010\f\u001a\u0004\u0018\u00010\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u001d\"\u0004\b&\u0010\u001fR \u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\u0013\"\u0004\b(\u0010\u0015R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u001d\"\u0004\b*\u0010\u001f¨\u0006-"}, d2 = {"Lcom/ss/ugc/effectplatform/model/EffectChannelModel;", "", EffectConfiguration.KEY_VERSION, "", "effects", "", "Lcom/ss/ugc/effectplatform/model/Effect;", EffectConfiguration.KEY_CATEGORY, "Lcom/ss/ugc/effectplatform/model/EffectCategoryModel;", EffectConfiguration.KEY_PANEL, "Lcom/ss/ugc/effectplatform/model/EffectPanelModel;", "front_effect_id", "rear_effect_id", "collection", "url_prefix", "(Ljava/lang/String;Ljava/util/List;Ljava/util/List;Lcom/ss/ugc/effectplatform/model/EffectPanelModel;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;)V", "value", "category_list", "getCategory_list", "()Ljava/util/List;", "setCategory_list", "(Ljava/util/List;)V", "collection_list", "getCollection_list", "setCollection_list", "effect_list", "getEffect_list", "setEffect_list", "getFront_effect_id", "()Ljava/lang/String;", "setFront_effect_id", "(Ljava/lang/String;)V", "panel_model", "getPanel_model", "()Lcom/ss/ugc/effectplatform/model/EffectPanelModel;", "setPanel_model", "(Lcom/ss/ugc/effectplatform/model/EffectPanelModel;)V", "getRear_effect_id", "setRear_effect_id", "getUrl_prefix", "setUrl_prefix", "getVersion", "setVersion", "checkValued", "", "effect_model_release"}, k = 1, mv = {1, 1, 16})
public class EffectChannelModel {
    private List<? extends EffectCategoryModel> category;
    private List<? extends Effect> collection;
    private List<? extends Effect> effects;
    private String front_effect_id;
    private EffectPanelModel panel;
    private String rear_effect_id;
    private List<String> url_prefix;
    private String version;

    public EffectChannelModel() {
        this(null, null, null, null, null, null, null, null, KotlinVersion.MAX_COMPONENT_VALUE, null);
    }

    public final boolean checkValued() {
        return getPanel_model().checkValued();
    }

    public final List<EffectCategoryModel> getCategory_list() {
        return this.category;
    }

    public final List<Effect> getCollection_list() {
        return this.collection;
    }

    public final List<Effect> getEffect_list() {
        return this.effects;
    }

    public String getFront_effect_id() {
        return this.front_effect_id;
    }

    public final EffectPanelModel getPanel_model() {
        return this.panel;
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

    public final void setCategory_list(List<? extends EffectCategoryModel> r1) {
        this.category = r1;
    }

    public final void setCollection_list(List<? extends Effect> r1) {
        this.collection = r1;
    }

    public final void setEffect_list(List<? extends Effect> r1) {
        this.effects = r1;
    }

    public void setFront_effect_id(String r1) {
        this.front_effect_id = r1;
    }

    public final void setPanel_model(EffectPanelModel r1) {
        this.panel = r1;
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

    public EffectChannelModel(String r1, List<? extends Effect> r2, List<? extends EffectCategoryModel> r3, EffectPanelModel r4, String r5, String r6, List<? extends Effect> r7, List<String> r8) {
        this.version = r1;
        this.effects = r2;
        this.category = r3;
        this.panel = r4;
        this.front_effect_id = r5;
        this.rear_effect_id = r6;
        this.collection = r7;
        this.url_prefix = r8;
    }

    public /* synthetic */ EffectChannelModel(String r16, List r17, List r18, EffectPanelModel r19, String r20, String r21, List r22, List r23, int r24, DefaultConstructorMarker r25) {
        String r2 = null;
        if ((r24 & 1) == 0) goto L5;
        String r1 = null;
    L7:
        if ((r24 & 2) == 0) goto L9;
        List r3 = new ArrayList();
    L11:
        if ((r24 & 4) == 0) goto L13;
        List r4 = new ArrayList();
    L15:
        if ((r24 & 8) == 0) goto L17;
        EffectPanelModel r5 = new EffectPanelModel(null, null, null, null, null, null, 63, null);
    L19:
        if ((r24 & 16) == 0) goto L21;
        String r6 = null;
    L23:
        if ((r24 & 32) != 0) goto L27;
        r2 = r21;
    L27:
        if ((r24 & 64) == 0) goto L29;
        List r7 = new ArrayList();
    L31:
        if ((r24 & 128) == 0) goto L33;
        List r0 = new ArrayList();
    L34:
        this(r1, r3, r4, r5, r6, r2, r7, r0);
        return;
    L33:
        r0 = r23;
        goto L34
    L29:
        r7 = r22;
        goto L31
    L21:
        r6 = r20;
        goto L23
    L17:
        r5 = r19;
        goto L19
    L13:
        r4 = r18;
        goto L15
    L9:
        r3 = r17;
        goto L11
    L5:
        r1 = r16;
        goto L7
    }
}
