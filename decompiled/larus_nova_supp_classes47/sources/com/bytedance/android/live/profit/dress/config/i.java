package com.bytedance.android.live.profit.dress.config;

import com.bytedance.android.live.base.model.message.a5;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\b\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002R\u001e\u0010\t\u001a\u00060\u0003j\u0002`\u00048&X§\u0004¢\u0006\f\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\"\u0010\u000f\u001a\n\u0018\u00010\nj\u0004\u0018\u0001`\u000b8&X§\u0004¢\u0006\f\u0012\u0004\b\u000e\u0010\b\u001a\u0004\b\f\u0010\rR\u001e\u0010\u0012\u001a\u00060\u0003j\u0002`\u00048&X§\u0004¢\u0006\f\u0012\u0004\b\u0011\u0010\b\u001a\u0004\b\u0010\u0010\u0006R\"\u0010\u0018\u001a\n\u0018\u00010\u0013j\u0004\u0018\u0001`\u00148&X§\u0004¢\u0006\f\u0012\u0004\b\u0017\u0010\b\u001a\u0004\b\u0015\u0010\u0016R\"\u0010\u001b\u001a\n\u0018\u00010\nj\u0004\u0018\u0001`\u000b8&X§\u0004¢\u0006\f\u0012\u0004\b\u001a\u0010\b\u001a\u0004\b\u0019\u0010\rR\u001a\u0010 \u001a\u00020\u001c8&X§\u0004¢\u0006\f\u0012\u0004\b\u001f\u0010\b\u001a\u0004\b\u001d\u0010\u001eR\u001e\u0010#\u001a\u00060\u0003j\u0002`\u00048&X§\u0004¢\u0006\f\u0012\u0004\b\"\u0010\b\u001a\u0004\b!\u0010\u0006R\"\u0010&\u001a\n\u0018\u00010\nj\u0004\u0018\u0001`\u000b8&X§\u0004¢\u0006\f\u0012\u0004\b%\u0010\b\u001a\u0004\b$\u0010\rR\"\u0010)\u001a\n\u0018\u00010\nj\u0004\u0018\u0001`\u000b8&X§\u0004¢\u0006\f\u0012\u0004\b(\u0010\b\u001a\u0004\b'\u0010\rR\"\u0010,\u001a\n\u0018\u00010\nj\u0004\u0018\u0001`\u000b8&X§\u0004¢\u0006\f\u0012\u0004\b+\u0010\b\u001a\u0004\b*\u0010\rR\u001a\u00101\u001a\u00020-8&X§\u0004¢\u0006\f\u0012\u0004\b0\u0010\b\u001a\u0004\b.\u0010/R\u001e\u00104\u001a\u00060\u0003j\u0002`\u00048&X§\u0004¢\u0006\f\u0012\u0004\b3\u0010\b\u001a\u0004\b2\u0010\u0006R\"\u00107\u001a\n\u0018\u00010\nj\u0004\u0018\u0001`\u000b8&X§\u0004¢\u0006\f\u0012\u0004\b6\u0010\b\u001a\u0004\b5\u0010\rR:\u0010>\u001a\"\u0012\u0004\u0012\u000209\u0012\u0004\u0012\u000209\u0018\u000108j\u0010\u0012\u0004\u0012\u000209\u0012\u0004\u0012\u000209\u0018\u0001`:8&X§\u0004¢\u0006\f\u0012\u0004\b=\u0010\b\u001a\u0004\b;\u0010<R\u001e\u0010A\u001a\u00060\u0003j\u0002`\u00048&X§\u0004¢\u0006\f\u0012\u0004\b@\u0010\b\u001a\u0004\b?\u0010\u0006R\u001c\u0010E\u001a\u0004\u0018\u0001098&X§\u0004¢\u0006\f\u0012\u0004\bD\u0010\b\u001a\u0004\bB\u0010CR\u001e\u0010H\u001a\u00060\u0003j\u0002`\u00048&X§\u0004¢\u0006\f\u0012\u0004\bG\u0010\b\u001a\u0004\bF\u0010\u0006R\u001e\u0010K\u001a\u00060\u0003j\u0002`\u00048&X§\u0004¢\u0006\f\u0012\u0004\bJ\u0010\b\u001a\u0004\bI\u0010\u0006R\"\u0010N\u001a\n\u0018\u00010\u0013j\u0004\u0018\u0001`\u00148&X§\u0004¢\u0006\f\u0012\u0004\bM\u0010\b\u001a\u0004\bL\u0010\u0016R\u001c\u0010S\u001a\u0004\u0018\u00010O8&X§\u0004¢\u0006\f\u0012\u0004\bR\u0010\b\u001a\u0004\bP\u0010QR\u001c\u0010V\u001a\u0004\u0018\u0001098&X§\u0004¢\u0006\f\u0012\u0004\bU\u0010\b\u001a\u0004\bT\u0010C¨\u0006W"}, d2 = {"Lcom/bytedance/android/live/profit/dress/config/i;", "Lvh7/c;", "", "", "Lcom/bytedance/revenue/platform/api/core/UnsafeLong;", "getType", "()J", "getType$annotations", "()V", "type", "Lpy/k;", "Lcom/bytedance/android/live/api/IImageModelKt;", "getIcon", "()Lpy/k;", "getIcon$annotations", "icon", "getAvatarPos", "getAvatarPos$annotations", "avatarPos", "Lcom/bytedance/android/live/base/model/message/a5;", "Lcom/bytedance/android/live/base/model/message/ITextKt;", "getText", "()Lcom/bytedance/android/live/base/model/message/a5;", "getText$annotations", "text", "getTextIcon", "getTextIcon$annotations", "textIcon", "", "getStayTime", "()I", "getStayTime$annotations", "stayTime", "getAnimAssetId", "getAnimAssetId$annotations", "animAssetId", "getBadge", "getBadge$annotations", "badge", "getTextIconOverlay", "getTextIconOverlay$annotations", "textIconOverlay", "getAnimatedBadge", "getAnimatedBadge$annotations", "animatedBadge", "", "getHasSweepLight", "()Z", "getHasSweepLight$annotations", "hasSweepLight", "getCenterAnimAssetId", "getCenterAnimAssetId$annotations", "centerAnimAssetId", "getDynamicImage", "getDynamicImage$annotations", "dynamicImage", "", "", "Lcom/bytedance/revenue/platform/api/core/KmpMap;", "getExtra", "()Ljava/util/Map;", "getExtra$annotations", "extra", "getMp4AnimAssetId", "getMp4AnimAssetId$annotations", "mp4AnimAssetId", "getDressId", "()Ljava/lang/String;", "getDressId$annotations", "dressId", "getAlignment", "getAlignment$annotations", "alignment", "getAlignmentOffset", "getAlignmentOffset$annotations", "alignmentOffset", "getTemplate", "getTemplate$annotations", "template", "Lcom/bytedance/android/live/profit/dress/config/h;", "getProfilePreviewConfig", "()Lcom/bytedance/android/live/profit/dress/config/h;", "getProfilePreviewConfig$annotations", "profilePreviewConfig", "getAvatarBorderDressId", "getAvatarBorderDressId$annotations", "avatarBorderDressId", "revenue-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface i extends vh7.c<i> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    /* synthetic */ vh7.e castTo(Class r1);

    /* synthetic */ vh7.e castToOrNull(Class r1);

    @FieldName(name = "alignment")
    long getAlignment();

    @FieldName(name = "alignment_offset")
    long getAlignmentOffset();

    @FieldName(name = "anim_asset_id")
    long getAnimAssetId();

    @FieldName(name = "animated_badge")
    py.k getAnimatedBadge();

    @FieldName(name = "link_avatar_border_id")
    String getAvatarBorderDressId();

    @FieldName(name = "avatar_pos")
    long getAvatarPos();

    @FieldName(name = "badge")
    py.k getBadge();

    @FieldName(name = "center_anim_asset_id")
    long getCenterAnimAssetId();

    @FieldName(name = "dress_id")
    String getDressId();

    @FieldName(name = "dynamic_image")
    py.k getDynamicImage();

    @FieldName(name = "extra")
    Map<String, String> getExtra();

    @FieldName(name = "has_sweep_light")
    boolean getHasSweepLight();

    @FieldName(name = "icon")
    py.k getIcon();

    @FieldName(name = "mp4_anim_asset_id")
    long getMp4AnimAssetId();

    @FieldName(name = "profile_preview")
    h getProfilePreviewConfig();

    @FieldName(name = "stay_time")
    int getStayTime();

    @FieldName(name = "template_text")
    a5 getTemplate();

    @FieldName(name = "text")
    a5 getText();

    @FieldName(name = "text_icon")
    py.k getTextIcon();

    @FieldName(name = "text_icon_overlay")
    py.k getTextIconOverlay();

    @FieldName(name = "type")
    long getType();
}
