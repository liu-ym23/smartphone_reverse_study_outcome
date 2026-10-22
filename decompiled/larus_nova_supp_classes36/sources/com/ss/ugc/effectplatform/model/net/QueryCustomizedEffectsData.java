package com.ss.ugc.effectplatform.model.net;

import com.ss.ugc.effectplatform.model.Effect;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0017\b\u0007\u0018\u00002\u00020\u0001B[\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0002\u0010\rR\u001e\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0012\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\"\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001e\u0010\b\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001b\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u0011\u0010\f\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\"\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0014\"\u0004\b\u001f\u0010\u0016R\"\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0014\"\u0004\b!\u0010\u0016¨\u0006\""}, d2 = {"Lcom/ss/ugc/effectplatform/model/net/QueryCustomizedEffectsData;", "", "url_prefix", "", "", "url_prefix2", "effects", "Lcom/ss/ugc/effectplatform/model/Effect;", "has_more", "", "cursor", "", "sorting_position", "(Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/lang/Boolean;Ljava/lang/Integer;I)V", "getCursor", "()Ljava/lang/Integer;", "setCursor", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getEffects", "()Ljava/util/List;", "setEffects", "(Ljava/util/List;)V", "getHas_more", "()Ljava/lang/Boolean;", "setHas_more", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getSorting_position", "()I", "getUrl_prefix", "setUrl_prefix", "getUrl_prefix2", "setUrl_prefix2", "effectplatform_release"}, k = 1, mv = {1, 1, 16})
public final class QueryCustomizedEffectsData {
    private Integer cursor;
    private List<? extends Effect> effects;
    private Boolean has_more;
    private final int sorting_position;
    private List<String> url_prefix;
    private List<String> url_prefix2;

    public final Integer getCursor() {
        return this.cursor;
    }

    public final List<Effect> getEffects() {
        return this.effects;
    }

    public final Boolean getHas_more() {
        return this.has_more;
    }

    public final int getSorting_position() {
        return this.sorting_position;
    }

    public final List<String> getUrl_prefix() {
        return this.url_prefix;
    }

    public final List<String> getUrl_prefix2() {
        return this.url_prefix2;
    }

    public final void setCursor(Integer r1) {
        this.cursor = r1;
    }

    public final void setEffects(List<? extends Effect> r1) {
        this.effects = r1;
    }

    public final void setHas_more(Boolean r1) {
        this.has_more = r1;
    }

    public final void setUrl_prefix(List<String> r1) {
        this.url_prefix = r1;
    }

    public final void setUrl_prefix2(List<String> r1) {
        this.url_prefix2 = r1;
    }

    public QueryCustomizedEffectsData(List<String> r1, List<String> r2, List<? extends Effect> r3, Boolean r4, Integer r5, int r6) {
        this.url_prefix = r1;
        this.url_prefix2 = r2;
        this.effects = r3;
        this.has_more = r4;
        this.cursor = r5;
        this.sorting_position = r6;
    }

    public /* synthetic */ QueryCustomizedEffectsData(List r10, List r11, List r12, Boolean r13, Integer r14, int r15, int r16, DefaultConstructorMarker r17) {
        if ((r16 & 1) == 0) goto L5;
        List r3 = null;
    L7:
        if ((r16 & 2) == 0) goto L9;
        List r4 = null;
    L11:
        if ((r16 & 4) == 0) goto L13;
        List r5 = null;
    L15:
        if ((r16 & 8) == 0) goto L17;
        Boolean r6 = null;
    L19:
        if ((r16 & 16) == 0) goto L21;
        Integer r7 = null;
    L22:
        this(r3, r4, r5, r6, r7, r15);
        return;
    L21:
        r7 = r14;
        goto L22
    L17:
        r6 = r13;
        goto L19
    L13:
        r5 = r12;
        goto L15
    L9:
        r4 = r11;
        goto L11
    L5:
        r3 = r10;
        goto L7
    }
}
