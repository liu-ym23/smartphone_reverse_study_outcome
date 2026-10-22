package com.ss.ugc.effectplatform.model;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0018\b\u0017\u0018\u00002\u00020\u0001BM\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\rR\u001a\u0010\u0004\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\f\u001a\u0004\u0018\u00010\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0006\u001a\u00020\u0007X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0013\"\u0004\b\u001b\u0010\u0015R \u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0013\"\u0004\b!\u0010\u0015¨\u0006\""}, d2 = {"Lcom/ss/ugc/effectplatform/model/ProviderEffectModel;", "", "search_tips", "", "cursor", "", "has_more", "", "sticker_list", "", "Lcom/ss/ugc/effectplatform/model/ProviderEffect;", "subtitle", "extra", "(Ljava/lang/String;IZLjava/util/List;Ljava/lang/String;Ljava/lang/String;)V", "getCursor", "()I", "setCursor", "(I)V", "getExtra", "()Ljava/lang/String;", "setExtra", "(Ljava/lang/String;)V", "getHas_more", "()Z", "setHas_more", "(Z)V", "getSearch_tips", "setSearch_tips", "getSticker_list", "()Ljava/util/List;", "setSticker_list", "(Ljava/util/List;)V", "getSubtitle", "setSubtitle", "effect_model_release"}, k = 1, mv = {1, 1, 16})
public class ProviderEffectModel {
    private int cursor;
    private String extra;
    private boolean has_more;
    private String search_tips;
    private List<? extends ProviderEffect> sticker_list;
    private String subtitle;

    public ProviderEffectModel() {
        this(null, 0, false, null, null, null, 63, null);
    }

    public int getCursor() {
        return this.cursor;
    }

    public String getExtra() {
        return this.extra;
    }

    public boolean getHas_more() {
        return this.has_more;
    }

    public String getSearch_tips() {
        return this.search_tips;
    }

    public List<ProviderEffect> getSticker_list() {
        return this.sticker_list;
    }

    public String getSubtitle() {
        return this.subtitle;
    }

    public void setCursor(int r1) {
        this.cursor = r1;
    }

    public void setExtra(String r1) {
        this.extra = r1;
    }

    public void setHas_more(boolean r1) {
        this.has_more = r1;
    }

    public void setSearch_tips(String r1) {
        this.search_tips = r1;
    }

    public void setSticker_list(List<? extends ProviderEffect> r1) {
        this.sticker_list = r1;
    }

    public void setSubtitle(String r1) {
        this.subtitle = r1;
    }

    public ProviderEffectModel(String r1, int r2, boolean r3, List<? extends ProviderEffect> r4, String r5, String r6) {
        this.search_tips = r1;
        this.cursor = r2;
        this.has_more = r3;
        this.sticker_list = r4;
        this.subtitle = r5;
        this.extra = r6;
    }

    public /* synthetic */ ProviderEffectModel(String r6, int r7, boolean r8, List r9, String r10, String r11, int r12, DefaultConstructorMarker r13) {
        if ((r12 & 1) == 0) goto L5;
        String r14 = null;
    L6:
        boolean r1 = false;
        if ((r12 & 2) == 0) goto L9;
        int r2 = 0;
    L11:
        if ((r12 & 4) != 0) goto L15;
        r1 = r8;
    L15:
        if ((r12 & 8) == 0) goto L17;
        r9 = new ArrayList();
    L17:
        List r3 = r9;
        if ((r12 & 16) == 0) goto L20;
        String r4 = null;
    L22:
        if ((r12 & 32) == 0) goto L24;
        String r15 = null;
    L25:
        this(r14, r2, r1, r3, r4, r15);
        return;
    L24:
        r15 = r11;
        goto L25
    L20:
        r4 = r10;
        goto L22
    L9:
        r2 = r7;
        goto L11
    L5:
        r14 = r6;
        goto L6
    }
}
