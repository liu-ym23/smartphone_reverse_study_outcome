package com.bytedance.android.live.liveinteract.plantform.model;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0013\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R$\u0010\t\u001a\u0004\u0018\u00010\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\u0003\u0010\u0004\"\u0004\b\u0005\u0010\u0006R*\u0010\u0011\u001a\n\u0018\u00010\nj\u0004\u0018\u0001`\u000b8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0010\u0010\b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0015\u001a\u0004\u0018\u00010\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0014\u0010\b\u001a\u0004\b\u0012\u0010\u0004\"\u0004\b\u0013\u0010\u0006R$\u0010\u0019\u001a\u0004\u0018\u00010\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0018\u0010\b\u001a\u0004\b\u0016\u0010\u0004\"\u0004\b\u0017\u0010\u0006R*\u0010\u001d\u001a\n\u0018\u00010\nj\u0004\u0018\u0001`\u000b8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u001c\u0010\b\u001a\u0004\b\u001a\u0010\r\"\u0004\b\u001b\u0010\u000f¨\u0006\u001e"}, d2 = {"Lcom/bytedance/android/live/liveinteract/plantform/model/ListUserTag;", "Lvh7/c;", "", "getContent", "()Ljava/lang/String;", "setContent", "(Ljava/lang/String;)V", "getContent$annotations", "()V", "content", "", "Lcom/bytedance/revenue/platform/api/core/UnsafeLong;", "getTextSize", "()Ljava/lang/Long;", "setTextSize", "(Ljava/lang/Long;)V", "getTextSize$annotations", "textSize", "getTextColor", "setTextColor", "getTextColor$annotations", "textColor", "getBgColor", "setBgColor", "getBgColor$annotations", "bgColor", "getBgRadius", "setBgRadius", "getBgRadius$annotations", "bgRadius", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface ListUserTag extends vh7.c<ListUserTag> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    /* synthetic */ vh7.e castTo(Class r1);

    /* synthetic */ vh7.e castToOrNull(Class r1);

    @FieldName(name = "bg_color")
    String getBgColor();

    @FieldName(name = "bg_radius")
    Long getBgRadius();

    @FieldName(name = "content")
    String getContent();

    @FieldName(name = "text_color")
    String getTextColor();

    @FieldName(name = "text_size")
    Long getTextSize();

    @FieldName(name = "bg_color#setter")
    void setBgColor(String r1);

    @FieldName(name = "bg_radius#setter")
    void setBgRadius(Long r1);

    @FieldName(name = "content#setter")
    void setContent(String r1);

    @FieldName(name = "text_color#setter")
    void setTextColor(String r1);

    @FieldName(name = "text_size#setter")
    void setTextSize(Long r1);
}
