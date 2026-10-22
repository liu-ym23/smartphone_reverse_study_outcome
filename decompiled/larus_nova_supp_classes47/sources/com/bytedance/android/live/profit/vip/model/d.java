package com.bytedance.android.live.profit.vip.model;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u001b\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R$\u0010\t\u001a\u0004\u0018\u00010\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\u0003\u0010\u0004\"\u0004\b\u0005\u0010\u0006R\"\u0010\u0010\u001a\u00020\n8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u000f\u0010\b\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR$\u0010\u0014\u001a\u0004\u0018\u00010\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0013\u0010\b\u001a\u0004\b\u0011\u0010\u0004\"\u0004\b\u0012\u0010\u0006R$\u0010\u0018\u001a\u0004\u0018\u00010\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0017\u0010\b\u001a\u0004\b\u0015\u0010\u0004\"\u0004\b\u0016\u0010\u0006R$\u0010\u001c\u001a\u0004\u0018\u00010\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u001b\u0010\b\u001a\u0004\b\u0019\u0010\u0004\"\u0004\b\u001a\u0010\u0006R$\u0010 \u001a\u0004\u0018\u00010\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u001f\u0010\b\u001a\u0004\b\u001d\u0010\u0004\"\u0004\b\u001e\u0010\u0006R$\u0010$\u001a\u0004\u0018\u00010\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b#\u0010\b\u001a\u0004\b!\u0010\u0004\"\u0004\b\"\u0010\u0006¨\u0006%"}, d2 = {"Lcom/bytedance/android/live/profit/vip/model/d;", "Lvh7/c;", "", "getDescribe", "()Ljava/lang/String;", "setDescribe", "(Ljava/lang/String;)V", "getDescribe$annotations", "()V", "describe", "", "getBtnShow", "()Z", "setBtnShow", "(Z)V", "getBtnShow$annotations", "btnShow", "getBtnText", "setBtnText", "getBtnText$annotations", "btnText", "getBtnSchema", "setBtnSchema", "getBtnSchema$annotations", "btnSchema", "getEmojiIconSelectUrl", "setEmojiIconSelectUrl", "getEmojiIconSelectUrl$annotations", "emojiIconSelectUrl", "getEmojiIconUnselectUrl", "setEmojiIconUnselectUrl", "getEmojiIconUnselectUrl$annotations", "emojiIconUnselectUrl", "getEmojiTabName", "setEmojiTabName", "getEmojiTabName$annotations", "emojiTabName", "revenue-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface d extends vh7.c<d> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    /* synthetic */ vh7.e castTo(Class r1);

    /* synthetic */ vh7.e castToOrNull(Class r1);

    @FieldName(name = "btn_schema")
    String getBtnSchema();

    @FieldName(name = "btn_show")
    boolean getBtnShow();

    @FieldName(name = "btn_text")
    String getBtnText();

    @FieldName(name = "describe")
    String getDescribe();

    @FieldName(name = "emoji_icon_select_url")
    String getEmojiIconSelectUrl();

    @FieldName(name = "emoji_icon_unselect_url")
    String getEmojiIconUnselectUrl();

    @FieldName(name = "emoji_tab_name")
    String getEmojiTabName();

    @FieldName(name = "btn_schema#setter")
    void setBtnSchema(String r1);

    @FieldName(name = "btn_show#setter")
    void setBtnShow(boolean r1);

    @FieldName(name = "btn_text#setter")
    void setBtnText(String r1);

    @FieldName(name = "describe#setter")
    void setDescribe(String r1);

    @FieldName(name = "emoji_icon_select_url#setter")
    void setEmojiIconSelectUrl(String r1);

    @FieldName(name = "emoji_icon_unselect_url#setter")
    void setEmojiIconUnselectUrl(String r1);

    @FieldName(name = "emoji_tab_name#setter")
    void setEmojiTabName(String r1);
}
