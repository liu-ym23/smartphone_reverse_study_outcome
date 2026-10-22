package com.ss.ugc.effectplatform.model.net;

import com.ss.ugc.effectplatform.model.Effect;
import com.ss.ugc.effectplatform.model.EffectCategoryModel;
import com.ss.ugc.effectplatform.model.EffectPanelModel;
import com.ss.ugc.effectplatform.model.PanelInfoModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001Bw\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\u0002\u0010\u0011R\u001a\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/ss/ugc/effectplatform/model/net/PanelInfoWithOneEffectData;", "", "version", "", "category_list", "", "Lcom/ss/ugc/effectplatform/model/EffectCategoryModel;", "front_effect", "Lcom/ss/ugc/effectplatform/model/Effect;", "rear_effect", "url_prefix", "panel", "Lcom/ss/ugc/effectplatform/model/EffectPanelModel;", "category_effect_list", "Lcom/ss/ugc/effectplatform/model/net/CategoryEffect;", "extra", "Lcom/ss/ugc/effectplatform/model/PanelInfoModel$Extra;", "(Ljava/lang/String;Ljava/util/List;Lcom/ss/ugc/effectplatform/model/Effect;Lcom/ss/ugc/effectplatform/model/Effect;Ljava/util/List;Lcom/ss/ugc/effectplatform/model/EffectPanelModel;Ljava/util/List;Lcom/ss/ugc/effectplatform/model/PanelInfoModel$Extra;)V", "effectplatform_release"}, k = 1, mv = {1, 1, 16})
public final class PanelInfoWithOneEffectData {
    public List<CategoryEffect> category_effect_list;
    public List<? extends EffectCategoryModel> category_list;
    public PanelInfoModel.Extra extra;
    public Effect front_effect;
    public EffectPanelModel panel;
    public Effect rear_effect;
    public List<String> url_prefix;
    public String version;

    public PanelInfoWithOneEffectData() {
        this(null, null, null, null, null, null, null, null, 255, null);
    }

    public PanelInfoWithOneEffectData(String r1, List<? extends EffectCategoryModel> r2, Effect r3, Effect r4, List<String> r5, EffectPanelModel r6, List<CategoryEffect> r7, PanelInfoModel.Extra r8) {
        this.version = r1;
        this.category_list = r2;
        this.front_effect = r3;
        this.rear_effect = r4;
        this.url_prefix = r5;
        this.panel = r6;
        this.category_effect_list = r7;
        this.extra = r8;
    }

    public /* synthetic */ PanelInfoWithOneEffectData(String r10, List r11, Effect r12, Effect r13, List r14, EffectPanelModel r15, List r16, PanelInfoModel.Extra r17, int r18, DefaultConstructorMarker r19) {
        PanelInfoModel.Extra r2 = null;
        if ((r18 & 1) == 0) goto L5;
        String r1 = null;
    L7:
        if ((r18 & 2) == 0) goto L9;
        List r3 = null;
    L11:
        if ((r18 & 4) == 0) goto L13;
        Effect r4 = null;
    L15:
        if ((r18 & 8) == 0) goto L17;
        Effect r5 = null;
    L19:
        if ((r18 & 16) == 0) goto L21;
        List r6 = null;
    L23:
        if ((r18 & 32) == 0) goto L25;
        EffectPanelModel r7 = null;
    L27:
        if ((r18 & 64) == 0) goto L29;
        List r8 = null;
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
