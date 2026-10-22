package com.ss.ugc.effectplatform.model.net;

import com.ss.ugc.effectplatform.model.PanelInfoModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B/\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tR\u0014\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/ss/ugc/effectplatform/model/net/CategoryEffectsWithThemeData;", "", "category_effects_theme", "Lcom/ss/ugc/effectplatform/model/net/CategoryEffect;", "url_prefix", "", "", "extra", "Lcom/ss/ugc/effectplatform/model/PanelInfoModel$Extra;", "(Lcom/ss/ugc/effectplatform/model/net/CategoryEffect;Ljava/util/List;Lcom/ss/ugc/effectplatform/model/PanelInfoModel$Extra;)V", "effectplatform_release"}, k = 1, mv = {1, 1, 16})
public final class CategoryEffectsWithThemeData {
    public CategoryEffect category_effects_theme;
    public PanelInfoModel.Extra extra;
    public List<String> url_prefix;

    public CategoryEffectsWithThemeData() {
        this(null, null, null, 7, null);
    }

    public CategoryEffectsWithThemeData(CategoryEffect r1, List<String> r2, PanelInfoModel.Extra r3) {
        this.category_effects_theme = r1;
        this.url_prefix = r2;
        this.extra = r3;
    }

    public /* synthetic */ CategoryEffectsWithThemeData(CategoryEffect r2, List r3, PanelInfoModel.Extra r4, int r5, DefaultConstructorMarker r6) {
        if ((r5 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r3 = null;
    L9:
        if ((r5 & 4) == 0) goto L11;
        r4 = null;
    L11:
        this(r2, r3, r4);
    }
}
