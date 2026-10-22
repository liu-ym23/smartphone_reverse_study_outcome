package com.ss.ugc.effectplatform.model.net;

import com.ss.android.lark.notification.export.entity.INotificationHitPoint;
import com.ss.ugc.effectplatform.model.EffectCategoryModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b$\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B}\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\u0012\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\u0012\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0007\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0007¢\u0006\u0002\u0010\u000fJ\u000b\u0010&\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0011\u0010(\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007HÆ\u0003J\u0011\u0010)\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007HÆ\u0003J\u0011\u0010*\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0007HÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010-\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0007HÆ\u0003J\u0081\u0001\u0010.\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00072\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00072\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u00072\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0007HÆ\u0001J\u0013\u0010/\u001a\u0002002\b\u00101\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00102\u001a\u000203HÖ\u0001J\t\u00104\u001a\u00020\u0003HÖ\u0001R\"\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\"\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0011\"\u0004\b\u0015\u0010\u0013R\"\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0011\"\u0004\b\u0017\u0010\u0013R\u001c\u0010\f\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001c\u0010\r\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0019\"\u0004\b!\u0010\u001bR\"\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0011\"\u0004\b#\u0010\u0013R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u0019\"\u0004\b%\u0010\u001b¨\u00065"}, d2 = {"Lcom/ss/ugc/effectplatform/model/net/QueryInfoStickerListModel;", "", "version", "", "panel", "Lcom/ss/ugc/effectplatform/model/net/PanelDesc;", "effects", "", "Lcom/ss/ugc/effectplatform/model/net/InfoStickerEffect;", "collection", "category", "Lcom/ss/ugc/effectplatform/model/EffectCategoryModel;", "front_effect_id", "rear_effect_id", "url_prefix", "(Ljava/lang/String;Lcom/ss/ugc/effectplatform/model/net/PanelDesc;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getCategory", "()Ljava/util/List;", "setCategory", "(Ljava/util/List;)V", "getCollection", "setCollection", "getEffects", "setEffects", "getFront_effect_id", "()Ljava/lang/String;", "setFront_effect_id", "(Ljava/lang/String;)V", "getPanel", "()Lcom/ss/ugc/effectplatform/model/net/PanelDesc;", "setPanel", "(Lcom/ss/ugc/effectplatform/model/net/PanelDesc;)V", "getRear_effect_id", "setRear_effect_id", "getUrl_prefix", "setUrl_prefix", "getVersion", "setVersion", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "", INotificationHitPoint.NoticeType.OTHER, "hashCode", "", "toString", "effectplatform_release"}, k = 1, mv = {1, 1, 16})
public final class QueryInfoStickerListModel {
    private List<? extends EffectCategoryModel> category;
    private List<InfoStickerEffect> collection;
    private List<InfoStickerEffect> effects;
    private String front_effect_id;
    private PanelDesc panel;
    private String rear_effect_id;
    private List<String> url_prefix;
    private String version;

    public QueryInfoStickerListModel() {
        this(null, null, null, null, null, null, null, null, 255, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ QueryInfoStickerListModel copy$default(QueryInfoStickerListModel r9, String r10, PanelDesc r11, List r12, List r13, List r14, String r15, String r16, List r17, int r18, Object r19) {
        if ((r18 & 1) == 0) goto L5;
        String r2 = r9.version;
    L7:
        if ((r18 & 2) == 0) goto L9;
        PanelDesc r3 = r9.panel;
    L11:
        if ((r18 & 4) == 0) goto L13;
        List r4 = r9.effects;
    L15:
        if ((r18 & 8) == 0) goto L17;
        List r5 = r9.collection;
    L19:
        if ((r18 & 16) == 0) goto L21;
        List r6 = r9.category;
    L23:
        if ((r18 & 32) == 0) goto L25;
        String r7 = r9.front_effect_id;
    L27:
        if ((r18 & 64) == 0) goto L29;
        String r8 = r9.rear_effect_id;
    L31:
        if ((r18 & 128) == 0) goto L33;
        List r1 = r9.url_prefix;
    L35:
        return r9.copy(r2, r3, r4, r5, r6, r7, r8, r1);
    L33:
        r1 = r17;
        goto L35
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
        r2 = r10;
        goto L7
    }

    public final String component1() {
        return this.version;
    }

    public final PanelDesc component2() {
        return this.panel;
    }

    public final List<InfoStickerEffect> component3() {
        return this.effects;
    }

    public final List<InfoStickerEffect> component4() {
        return this.collection;
    }

    public final List<EffectCategoryModel> component5() {
        return this.category;
    }

    public final String component6() {
        return this.front_effect_id;
    }

    public final String component7() {
        return this.rear_effect_id;
    }

    public final List<String> component8() {
        return this.url_prefix;
    }

    public final QueryInfoStickerListModel copy(String r11, PanelDesc r12, List<InfoStickerEffect> r13, List<InfoStickerEffect> r14, List<? extends EffectCategoryModel> r15, String r16, String r17, List<String> r18) {
        return new QueryInfoStickerListModel(r11, r12, r13, r14, r15, r16, r17, r18);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof QueryInfoStickerListModel) == false) goto L22;
        QueryInfoStickerListModel r4 = (QueryInfoStickerListModel) r3;
        if (Intrinsics.areEqual(this.version, r4.version) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.panel, r4.panel) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.effects, r4.effects) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.collection, r4.collection) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.category, r4.category) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.front_effect_id, r4.front_effect_id) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.rear_effect_id, r4.rear_effect_id) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.url_prefix, r4.url_prefix) == true) goto L34;
        return false;
    L34:
        return true;
    L22:
        return false;
    }

    public int hashCode() {
        String r0 = this.version;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        PanelDesc r4 = this.panel;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        List<InfoStickerEffect> r7 = this.effects;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        List<InfoStickerEffect> r10 = this.collection;
        if (r10 == null) goto L17;
        int r11 = r10.hashCode();
    L18:
        int r12 = (r9 + r11) * 31;
        List<? extends EffectCategoryModel> r13 = this.category;
        if (r13 == null) goto L21;
        int r14 = r13.hashCode();
    L22:
        int r15 = (r12 + r14) * 31;
        String r16 = this.front_effect_id;
        if (r16 == null) goto L25;
        int r17 = r16.hashCode();
    L26:
        int r18 = (r15 + r17) * 31;
        String r19 = this.rear_effect_id;
        if (r19 == null) goto L29;
        int r20 = r19.hashCode();
    L30:
        int r21 = (r18 + r20) * 31;
        List<String> r22 = this.url_prefix;
        if (r22 == null) goto L34;
        r1 = r22.hashCode();
    L34:
        return r21 + r1;
    L29:
        r20 = 0;
        goto L30
    L25:
        r17 = 0;
        goto L26
    L21:
        r14 = 0;
        goto L22
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

    public String toString() {
        return "QueryInfoStickerListModel(version=" + this.version + ", panel=" + this.panel + ", effects=" + this.effects + ", collection=" + this.collection + ", category=" + this.category + ", front_effect_id=" + this.front_effect_id + ", rear_effect_id=" + this.rear_effect_id + ", url_prefix=" + this.url_prefix + ")";
    }

    public final List<EffectCategoryModel> getCategory() {
        return this.category;
    }

    public final List<InfoStickerEffect> getCollection() {
        return this.collection;
    }

    public final List<InfoStickerEffect> getEffects() {
        return this.effects;
    }

    public final String getFront_effect_id() {
        return this.front_effect_id;
    }

    public final PanelDesc getPanel() {
        return this.panel;
    }

    public final String getRear_effect_id() {
        return this.rear_effect_id;
    }

    public final List<String> getUrl_prefix() {
        return this.url_prefix;
    }

    public final String getVersion() {
        return this.version;
    }

    public final void setCategory(List<? extends EffectCategoryModel> r1) {
        this.category = r1;
    }

    public final void setCollection(List<InfoStickerEffect> r1) {
        this.collection = r1;
    }

    public final void setEffects(List<InfoStickerEffect> r1) {
        this.effects = r1;
    }

    public final void setFront_effect_id(String r1) {
        this.front_effect_id = r1;
    }

    public final void setPanel(PanelDesc r1) {
        this.panel = r1;
    }

    public final void setRear_effect_id(String r1) {
        this.rear_effect_id = r1;
    }

    public final void setUrl_prefix(List<String> r1) {
        this.url_prefix = r1;
    }

    public final void setVersion(String r1) {
        this.version = r1;
    }

    public QueryInfoStickerListModel(String r1, PanelDesc r2, List<InfoStickerEffect> r3, List<InfoStickerEffect> r4, List<? extends EffectCategoryModel> r5, String r6, String r7, List<String> r8) {
        this.version = r1;
        this.panel = r2;
        this.effects = r3;
        this.collection = r4;
        this.category = r5;
        this.front_effect_id = r6;
        this.rear_effect_id = r7;
        this.url_prefix = r8;
    }

    public /* synthetic */ QueryInfoStickerListModel(String r10, PanelDesc r11, List r12, List r13, List r14, String r15, String r16, List r17, int r18, DefaultConstructorMarker r19) {
        List r2 = null;
        if ((r18 & 1) == 0) goto L5;
        String r1 = null;
    L7:
        if ((r18 & 2) == 0) goto L9;
        PanelDesc r3 = null;
    L11:
        if ((r18 & 4) == 0) goto L13;
        List r4 = null;
    L15:
        if ((r18 & 8) == 0) goto L17;
        List r5 = null;
    L19:
        if ((r18 & 16) == 0) goto L21;
        List r6 = null;
    L23:
        if ((r18 & 32) == 0) goto L25;
        String r7 = null;
    L27:
        if ((r18 & 64) == 0) goto L29;
        String r8 = null;
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
