package com.ss.ugc.effectplatform.model;

import com.ss.android.ugc.effectmanager.EffectConfiguration;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001e\b\u0017\u0018\u00002\u00020\u0001B\u007f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00060\t\u0012\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\t\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\t\u0012\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00030\t¢\u0006\u0002\u0010\u0010R \u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00060\tX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R \u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\tX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0012\"\u0004\b\u0016\u0010\u0014R \u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\tX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0012\"\u0004\b\u0018\u0010\u0014R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001a\u0010\f\u001a\u00020\rX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0006X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u001a\"\u0004\b&\u0010\u001cR \u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00030\tX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\u0012\"\u0004\b(\u0010\u0014R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u001e\"\u0004\b*\u0010 ¨\u0006+"}, d2 = {"Lcom/ss/ugc/effectplatform/model/EffectChannelResponse;", "", EffectConfiguration.KEY_PANEL, "", EffectConfiguration.KEY_VERSION, "front_effect", "Lcom/ss/ugc/effectplatform/model/Effect;", "rear_effect", "all_category_effects", "", "category_responses", "Lcom/ss/ugc/effectplatform/model/EffectCategoryResponse;", "panel_model", "Lcom/ss/ugc/effectplatform/model/EffectPanelModel;", "collection_list", "url_prefix", "(Ljava/lang/String;Ljava/lang/String;Lcom/ss/ugc/effectplatform/model/Effect;Lcom/ss/ugc/effectplatform/model/Effect;Ljava/util/List;Ljava/util/List;Lcom/ss/ugc/effectplatform/model/EffectPanelModel;Ljava/util/List;Ljava/util/List;)V", "getAll_category_effects", "()Ljava/util/List;", "setAll_category_effects", "(Ljava/util/List;)V", "getCategory_responses", "setCategory_responses", "getCollection_list", "setCollection_list", "getFront_effect", "()Lcom/ss/ugc/effectplatform/model/Effect;", "setFront_effect", "(Lcom/ss/ugc/effectplatform/model/Effect;)V", "getPanel", "()Ljava/lang/String;", "setPanel", "(Ljava/lang/String;)V", "getPanel_model", "()Lcom/ss/ugc/effectplatform/model/EffectPanelModel;", "setPanel_model", "(Lcom/ss/ugc/effectplatform/model/EffectPanelModel;)V", "getRear_effect", "setRear_effect", "getUrl_prefix", "setUrl_prefix", "getVersion", "setVersion", "effect_model_release"}, k = 1, mv = {1, 1, 16})
public class EffectChannelResponse {
    private List<? extends Effect> all_category_effects;
    private List<? extends EffectCategoryResponse> category_responses;
    private List<? extends Effect> collection_list;
    private Effect front_effect;
    private String panel;
    private EffectPanelModel panel_model;
    private Effect rear_effect;
    private List<String> url_prefix;
    private String version;

    public EffectChannelResponse() {
        this(null, null, null, null, null, null, null, null, null, 511, null);
    }

    public List<Effect> getAll_category_effects() {
        return this.all_category_effects;
    }

    public List<EffectCategoryResponse> getCategory_responses() {
        return this.category_responses;
    }

    public List<Effect> getCollection_list() {
        return this.collection_list;
    }

    public Effect getFront_effect() {
        return this.front_effect;
    }

    public String getPanel() {
        return this.panel;
    }

    public EffectPanelModel getPanel_model() {
        return this.panel_model;
    }

    public Effect getRear_effect() {
        return this.rear_effect;
    }

    public List<String> getUrl_prefix() {
        return this.url_prefix;
    }

    public String getVersion() {
        return this.version;
    }

    public void setAll_category_effects(List<? extends Effect> r1) {
        this.all_category_effects = r1;
    }

    public void setCategory_responses(List<? extends EffectCategoryResponse> r1) {
        this.category_responses = r1;
    }

    public void setCollection_list(List<? extends Effect> r1) {
        this.collection_list = r1;
    }

    public void setFront_effect(Effect r1) {
        this.front_effect = r1;
    }

    public void setPanel(String r1) {
        this.panel = r1;
    }

    public void setPanel_model(EffectPanelModel r1) {
        this.panel_model = r1;
    }

    public void setRear_effect(Effect r1) {
        this.rear_effect = r1;
    }

    public void setUrl_prefix(List<String> r1) {
        this.url_prefix = r1;
    }

    public void setVersion(String r1) {
        this.version = r1;
    }

    public EffectChannelResponse(String r1, String r2, Effect r3, Effect r4, List<? extends Effect> r5, List<? extends EffectCategoryResponse> r6, EffectPanelModel r7, List<? extends Effect> r8, List<String> r9) {
        this.panel = r1;
        this.version = r2;
        this.front_effect = r3;
        this.rear_effect = r4;
        this.all_category_effects = r5;
        this.category_responses = r6;
        this.panel_model = r7;
        this.collection_list = r8;
        this.url_prefix = r9;
        getPanel_model().setId(getPanel());
    }

    public /* synthetic */ EffectChannelResponse(String r18, String r19, Effect r20, Effect r21, List r22, List r23, EffectPanelModel r24, List r25, List r26, int r27, DefaultConstructorMarker r28) {
        Effect r2 = null;
        if ((r27 & 1) == 0) goto L5;
        String r1 = null;
    L7:
        if ((r27 & 2) == 0) goto L9;
        String r3 = null;
    L11:
        if ((r27 & 4) == 0) goto L13;
        Effect r4 = null;
    L15:
        if ((r27 & 8) != 0) goto L19;
        r2 = r21;
    L19:
        if ((r27 & 16) == 0) goto L21;
        List r5 = new ArrayList();
    L23:
        if ((r27 & 32) == 0) goto L25;
        List r6 = new ArrayList();
    L27:
        if ((r27 & 64) == 0) goto L29;
        EffectPanelModel r7 = new EffectPanelModel(null, null, null, null, null, null, 63, null);
    L31:
        if ((r27 & 128) == 0) goto L33;
        List r8 = new ArrayList();
    L35:
        if ((r27 & 256) == 0) goto L37;
        List r0 = new ArrayList();
    L38:
        this(r1, r3, r4, r2, r5, r6, r7, r8, r0);
        return;
    L37:
        r0 = r26;
        goto L38
    L33:
        r8 = r25;
        goto L35
    L29:
        r7 = r24;
        goto L31
    L25:
        r6 = r23;
        goto L27
    L21:
        r5 = r22;
        goto L23
    L13:
        r4 = r20;
        goto L15
    L9:
        r3 = r19;
        goto L11
    L5:
        r1 = r18;
        goto L7
    }
}
