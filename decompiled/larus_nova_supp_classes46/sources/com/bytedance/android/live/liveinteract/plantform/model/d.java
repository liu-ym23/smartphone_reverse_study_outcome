package com.bytedance.android.live.liveinteract.plantform.model;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0007\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\"\u0010\t\u001a\u00020\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\u0003\u0010\u0004\"\u0004\b\u0005\u0010\u0006R\"\u0010\r\u001a\u00020\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\f\u0010\b\u001a\u0004\b\n\u0010\u0004\"\u0004\b\u000b\u0010\u0006R*\u0010\u0015\u001a\n\u0018\u00010\u000ej\u0004\u0018\u0001`\u000f8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0014\u0010\b\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R$\u0010\u001c\u001a\u0004\u0018\u00010\u00168&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u001b\u0010\b\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR$\u0010#\u001a\u0004\u0018\u00010\u001d8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\"\u0010\b\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!¨\u0006$"}, d2 = {"Lcom/bytedance/android/live/liveinteract/plantform/model/d;", "Lvh7/c;", "", "getShowPanel", "()Z", "setShowPanel", "(Z)V", "getShowPanel$annotations", "()V", "showPanel", "getEnableDelegate", "setEnableDelegate", "getEnableDelegate$annotations", "enableDelegate", "Lpy/k;", "Lcom/bytedance/android/live/api/IImageModelKt;", "getTagImageUrl", "()Lpy/k;", "setTagImageUrl", "(Lpy/k;)V", "getTagImageUrl$annotations", "tagImageUrl", "", "getPrompt", "()Ljava/lang/String;", "setPrompt", "(Ljava/lang/String;)V", "getPrompt$annotations", "prompt", "", "getStatus", "()Ljava/lang/Integer;", "setStatus", "(Ljava/lang/Integer;)V", "getStatus$annotations", "status", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface d extends vh7.c<d> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    /* synthetic */ vh7.e castTo(Class r1);

    /* synthetic */ vh7.e castToOrNull(Class r1);

    @FieldName(name = "enable_delegate")
    boolean getEnableDelegate();

    @FieldName(name = "prompt")
    String getPrompt();

    @FieldName(name = "show_panel")
    boolean getShowPanel();

    @FieldName(name = "status")
    Integer getStatus();

    @FieldName(name = "tag_image_url")
    py.k getTagImageUrl();

    @FieldName(name = "enable_delegate#setter")
    void setEnableDelegate(boolean r1);

    @FieldName(name = "prompt#setter")
    void setPrompt(String r1);

    @FieldName(name = "show_panel#setter")
    void setShowPanel(boolean r1);

    @FieldName(name = "status#setter")
    void setStatus(Integer r1);

    @FieldName(name = "tag_image_url#setter")
    void setTagImageUrl(py.k r1);
}
