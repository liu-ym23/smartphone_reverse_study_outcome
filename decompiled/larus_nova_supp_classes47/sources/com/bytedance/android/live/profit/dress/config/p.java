package com.bytedance.android.live.profit.dress.config;

import com.bytedance.android.live.base.model.message.a5;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002R\u001e\u0010\t\u001a\u00060\u0003j\u0002`\u00048&X§\u0004¢\u0006\f\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u001e\u0010\f\u001a\u00060\u0003j\u0002`\u00048&X§\u0004¢\u0006\f\u0012\u0004\b\u000b\u0010\b\u001a\u0004\b\n\u0010\u0006R\u001e\u0010\u000f\u001a\u00060\u0003j\u0002`\u00048&X§\u0004¢\u0006\f\u0012\u0004\b\u000e\u0010\b\u001a\u0004\b\r\u0010\u0006R\u001e\u0010\u0012\u001a\u00060\u0003j\u0002`\u00048&X§\u0004¢\u0006\f\u0012\u0004\b\u0011\u0010\b\u001a\u0004\b\u0010\u0010\u0006R\u001a\u0010\u0017\u001a\u00020\u00138&X§\u0004¢\u0006\f\u0012\u0004\b\u0016\u0010\b\u001a\u0004\b\u0014\u0010\u0015R\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u00188&X§\u0004¢\u0006\f\u0012\u0004\b\u001b\u0010\b\u001a\u0004\b\u0019\u0010\u001aR\u001c\u0010\u001f\u001a\u0004\u0018\u00010\u00188&X§\u0004¢\u0006\f\u0012\u0004\b\u001e\u0010\b\u001a\u0004\b\u001d\u0010\u001aR\"\u0010%\u001a\n\u0018\u00010 j\u0004\u0018\u0001`!8&X§\u0004¢\u0006\f\u0012\u0004\b$\u0010\b\u001a\u0004\b\"\u0010#R\u001c\u0010(\u001a\u0004\u0018\u00010\u00188&X§\u0004¢\u0006\f\u0012\u0004\b'\u0010\b\u001a\u0004\b&\u0010\u001a¨\u0006)"}, d2 = {"Lcom/bytedance/android/live/profit/dress/config/p;", "Lvh7/c;", "", "", "Lcom/bytedance/revenue/platform/api/core/UnsafeLong;", "getAssetId", "()J", "getAssetId$annotations", "()V", "assetId", "getPrice", "getPrice$annotations", "price", "getTextWidth", "getTextWidth$annotations", "textWidth", "getTextHeight", "getTextHeight$annotations", "textHeight", "", "getAlignType", "()I", "getAlignType$annotations", "alignType", "", "getExtra", "()Ljava/lang/String;", "getExtra$annotations", "extra", "getAvatarBorderDressId", "getAvatarBorderDressId$annotations", "avatarBorderDressId", "Lcom/bytedance/android/live/base/model/message/a5;", "Lcom/bytedance/android/live/base/model/message/ITextKt;", "getTemplateText", "()Lcom/bytedance/android/live/base/model/message/a5;", "getTemplateText$annotations", "templateText", "getSchema", "getSchema$annotations", "schema", "revenue-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface p extends vh7.c<p> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    /* synthetic */ vh7.e castTo(Class r1);

    /* synthetic */ vh7.e castToOrNull(Class r1);

    @FieldName(name = "text_align_type")
    int getAlignType();

    @FieldName(name = "asset_id")
    long getAssetId();

    @FieldName(name = "link_avatar_border_id")
    String getAvatarBorderDressId();

    @FieldName(name = "extra")
    String getExtra();

    @FieldName(name = "price")
    long getPrice();

    @FieldName(name = "schema")
    String getSchema();

    @FieldName(name = "template_text")
    a5 getTemplateText();

    @FieldName(name = "text_height")
    long getTextHeight();

    @FieldName(name = "text_width")
    long getTextWidth();
}
