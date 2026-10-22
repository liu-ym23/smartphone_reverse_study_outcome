package com.ss.ugc.effectplatform.model.net;

import com.ss.ugc.effectplatform.model.Effect;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u001f\b\u0017\u0018\u00002\u00020\u0001Bs\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b\u0012\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b\u0012\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b¢\u0006\u0002\u0010\u000fR\"\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\"\u0010\r\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0011\"\u0004\b\u0015\u0010\u0013R\u001a\u0010\u0004\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\"\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0011\"\u0004\b\u001b\u0010\u0013R\u001a\u0010\u0002\u001a\u00020\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001c\u0010\b\u001a\u0004\u0018\u00010\u0007X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010!\"\u0004\b%\u0010#R\u001e\u0010\t\u001a\u0004\u0018\u00010\u0003X\u0096\u000e¢\u0006\u0010\n\u0002\u0010*\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)¨\u0006+"}, d2 = {"Lcom/ss/ugc/effectplatform/model/net/SearchEffectModel;", "", "has_more", "", "cursor", "", "search_id", "", "search_tips", "use_hot", "effects", "", "Lcom/ss/ugc/effectplatform/model/Effect;", "collection", "bind_effects", "(ZILjava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/util/List;Ljava/util/List;Ljava/util/List;)V", "getBind_effects", "()Ljava/util/List;", "setBind_effects", "(Ljava/util/List;)V", "getCollection", "setCollection", "getCursor", "()I", "setCursor", "(I)V", "getEffects", "setEffects", "getHas_more", "()Z", "setHas_more", "(Z)V", "getSearch_id", "()Ljava/lang/String;", "setSearch_id", "(Ljava/lang/String;)V", "getSearch_tips", "setSearch_tips", "getUse_hot", "()Ljava/lang/Boolean;", "setUse_hot", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "effectplatform_release"}, k = 1, mv = {1, 1, 16})
public class SearchEffectModel {
    private List<? extends Effect> bind_effects;
    private List<? extends Effect> collection;
    private int cursor;
    private List<? extends Effect> effects;
    private boolean has_more;
    private String search_id;
    private String search_tips;
    private Boolean use_hot;

    public SearchEffectModel() {
        this(false, 0, null, null, null, null, null, null, 255, null);
    }

    public List<Effect> getBind_effects() {
        return this.bind_effects;
    }

    public List<Effect> getCollection() {
        return this.collection;
    }

    public int getCursor() {
        return this.cursor;
    }

    public List<Effect> getEffects() {
        return this.effects;
    }

    public boolean getHas_more() {
        return this.has_more;
    }

    public String getSearch_id() {
        return this.search_id;
    }

    public String getSearch_tips() {
        return this.search_tips;
    }

    public Boolean getUse_hot() {
        return this.use_hot;
    }

    public void setBind_effects(List<? extends Effect> r1) {
        this.bind_effects = r1;
    }

    public void setCollection(List<? extends Effect> r1) {
        this.collection = r1;
    }

    public void setCursor(int r1) {
        this.cursor = r1;
    }

    public void setEffects(List<? extends Effect> r1) {
        this.effects = r1;
    }

    public void setHas_more(boolean r1) {
        this.has_more = r1;
    }

    public void setSearch_id(String r1) {
        this.search_id = r1;
    }

    public void setSearch_tips(String r1) {
        this.search_tips = r1;
    }

    public void setUse_hot(Boolean r1) {
        this.use_hot = r1;
    }

    public SearchEffectModel(boolean r1, int r2, String r3, String r4, Boolean r5, List<? extends Effect> r6, List<? extends Effect> r7, List<? extends Effect> r8) {
        this.has_more = r1;
        this.cursor = r2;
        this.search_id = r3;
        this.search_tips = r4;
        this.use_hot = r5;
        this.effects = r6;
        this.collection = r7;
        this.bind_effects = r8;
    }

    public /* synthetic */ SearchEffectModel(boolean r10, int r11, String r12, String r13, Boolean r14, List r15, List r16, List r17, int r18, DefaultConstructorMarker r19) {
        int r2 = 0;
        if ((r18 & 1) == 0) goto L5;
        boolean r1 = false;
    L7:
        if ((r18 & 2) != 0) goto L10;
        r2 = r11;
    L10:
        List r4 = null;
        if ((r18 & 4) == 0) goto L13;
        String r3 = null;
    L15:
        if ((r18 & 8) == 0) goto L17;
        String r5 = null;
    L19:
        if ((r18 & 16) == 0) goto L21;
        Boolean r6 = null;
    L23:
        if ((r18 & 32) == 0) goto L25;
        List r7 = null;
    L27:
        if ((r18 & 64) == 0) goto L29;
        List r8 = null;
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
    L5:
        r1 = r10;
        goto L7
    }
}
