package com.bytedance.android.live.base.model.user;

import com.bytedance.android.live.base.annotation.ForMain;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R$\u0010\t\u001a\u0004\u0018\u00010\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\u0003\u0010\u0004\"\u0004\b\u0005\u0010\u0006R\"\u0010\u0010\u001a\u00020\n8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u000f\u0010\b\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR$\u0010\u0017\u001a\u0004\u0018\u00010\u00118&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0016\u0010\b\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\"\u0010\u001b\u001a\u00020\n8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u001a\u0010\b\u001a\u0004\b\u0018\u0010\f\"\u0004\b\u0019\u0010\u000e¨\u0006\u001c"}, d2 = {"Lcom/bytedance/android/live/base/model/user/w;", "Lvh7/c;", "", "getLevelStr", "()Ljava/lang/String;", "setLevelStr", "(Ljava/lang/String;)V", "getLevelStr$annotations", "()V", "levelStr", "", "getIconDiamond", "()I", "setIconDiamond", "(I)V", "getIconDiamond$annotations", "iconDiamond", "Lpy/k;", "getIcon", "()Lpy/k;", "setIcon", "(Lpy/k;)V", "getIcon$annotations", "icon", "getLevel", "setLevel", "getLevel$annotations", "level", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
@ForMain
public interface w extends vh7.c<w> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    /* synthetic */ vh7.e castTo(Class r1);

    /* synthetic */ vh7.e castToOrNull(Class r1);

    @FieldName(name = "icon")
    py.k getIcon();

    @FieldName(name = "icon_diamond")
    int getIconDiamond();

    @FieldName(name = "level")
    int getLevel();

    @FieldName(name = "level_str")
    String getLevelStr();

    @FieldName(name = "icon#setter")
    void setIcon(py.k r1);

    @FieldName(name = "icon_diamond#setter")
    void setIconDiamond(int r1);

    @FieldName(name = "level#setter")
    void setLevel(int r1);

    @FieldName(name = "level_str#setter")
    void setLevelStr(String r1);
}
