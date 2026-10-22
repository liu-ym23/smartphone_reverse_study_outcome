package com.ss.ugc.effectplatform.model.net;

import com.ss.android.lark.notification.export.entity.INotificationHitPoint;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B#\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\u0002\u0010\u0007J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J'\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\"\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0019"}, d2 = {"Lcom/ss/ugc/effectplatform/model/net/RecommendSearchWordsModel;", "", "search_tips", "", "effects", "", "Lcom/ss/ugc/effectplatform/model/net/EffectNameModel;", "(Ljava/lang/String;Ljava/util/List;)V", "getEffects", "()Ljava/util/List;", "setEffects", "(Ljava/util/List;)V", "getSearch_tips", "()Ljava/lang/String;", "setSearch_tips", "(Ljava/lang/String;)V", "component1", "component2", "copy", "equals", "", INotificationHitPoint.NoticeType.OTHER, "hashCode", "", "toString", "effectplatform_release"}, k = 1, mv = {1, 1, 16})
public final class RecommendSearchWordsModel {
    private List<EffectNameModel> effects;
    private String search_tips;

    /* JADX WARN: Multi-variable type inference failed */
    public RecommendSearchWordsModel() {
        Object[] r0 = 0 == true ? 1 : 0;
        this(null, r0, 3, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ RecommendSearchWordsModel copy$default(RecommendSearchWordsModel r0, String r1, List r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.search_tips;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.effects;
    L9:
        return r0.copy(r1, r2);
    }

    public final String component1() {
        return this.search_tips;
    }

    public final List<EffectNameModel> component2() {
        return this.effects;
    }

    public final RecommendSearchWordsModel copy(String r2, List<EffectNameModel> r3) {
        return new RecommendSearchWordsModel(r2, r3);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof RecommendSearchWordsModel) == false) goto L10;
        RecommendSearchWordsModel r4 = (RecommendSearchWordsModel) r3;
        if (Intrinsics.areEqual(this.search_tips, r4.search_tips) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.effects, r4.effects) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public int hashCode() {
        String r0 = this.search_tips;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        List<EffectNameModel> r4 = this.effects;
        if (r4 == null) goto L10;
        r1 = r4.hashCode();
    L10:
        return r3 + r1;
    L5:
        r2 = 0;
        goto L6
    }

    public String toString() {
        return "RecommendSearchWordsModel(search_tips=" + this.search_tips + ", effects=" + this.effects + ")";
    }

    public final List<EffectNameModel> getEffects() {
        return this.effects;
    }

    public final String getSearch_tips() {
        return this.search_tips;
    }

    public final void setEffects(List<EffectNameModel> r1) {
        this.effects = r1;
    }

    public final void setSearch_tips(String r1) {
        this.search_tips = r1;
    }

    public RecommendSearchWordsModel(String r1, List<EffectNameModel> r2) {
        this.search_tips = r1;
        this.effects = r2;
    }

    public /* synthetic */ RecommendSearchWordsModel(String r2, List r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 2) == 0) goto L8;
        r3 = null;
    L8:
        this(r2, r3);
    }
}
