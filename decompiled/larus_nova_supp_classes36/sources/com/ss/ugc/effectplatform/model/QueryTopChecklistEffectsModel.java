package com.ss.ugc.effectplatform.model;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0013\b\u0017\u0018\u00002\u00020\u0001BK\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000bR \u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR \u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\r\"\u0004\b\u0011\u0010\u000fR\u001a\u0010\u0002\u001a\u00020\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R \u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\r\"\u0004\b\u0017\u0010\u000fR\u001e\u0010\t\u001a\u0004\u0018\u00010\nX\u0096\u000e¢\u0006\u0010\n\u0002\u0010\u001c\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b¨\u0006\u001d"}, d2 = {"Lcom/ss/ugc/effectplatform/model/QueryTopChecklistEffectsModel;", "", "cursor", "", "collection", "", "Lcom/ss/ugc/effectplatform/model/Effect;", "effects", "bind_effects", "last_updated_at", "", "(ILjava/util/List;Ljava/util/List;Ljava/util/List;Ljava/lang/Long;)V", "getBind_effects", "()Ljava/util/List;", "setBind_effects", "(Ljava/util/List;)V", "getCollection", "setCollection", "getCursor", "()I", "setCursor", "(I)V", "getEffects", "setEffects", "getLast_updated_at", "()Ljava/lang/Long;", "setLast_updated_at", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "effect_model_release"}, k = 1, mv = {1, 1, 16})
public class QueryTopChecklistEffectsModel {
    private List<? extends Effect> bind_effects;
    private List<? extends Effect> collection;
    private int cursor;
    private List<? extends Effect> effects;
    private Long last_updated_at;

    public QueryTopChecklistEffectsModel() {
        this(0, null, null, null, null, 31, null);
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

    public Long getLast_updated_at() {
        return this.last_updated_at;
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

    public void setLast_updated_at(Long r1) {
        this.last_updated_at = r1;
    }

    public QueryTopChecklistEffectsModel(int r1, List<? extends Effect> r2, List<? extends Effect> r3, List<? extends Effect> r4, Long r5) {
        this.cursor = r1;
        this.collection = r2;
        this.effects = r3;
        this.bind_effects = r4;
        this.last_updated_at = r5;
    }

    public /* synthetic */ QueryTopChecklistEffectsModel(int r4, List r5, List r6, List r7, Long r8, int r9, DefaultConstructorMarker r10) {
        if ((r9 & 1) == 0) goto L6;
        r4 = 0;
    L6:
        if ((r9 & 2) == 0) goto L8;
        r5 = new ArrayList();
    L8:
        List r11 = r5;
        if ((r9 & 4) == 0) goto L11;
        r6 = new ArrayList();
    L11:
        List r0 = r6;
        if ((r9 & 8) == 0) goto L14;
        r7 = new ArrayList();
    L14:
        List r1 = r7;
        if ((r9 & 16) == 0) goto L17;
        r8 = null;
    L17:
        int r12 = r4;
        this(r12, r11, r0, r1, r8);
    }
}
