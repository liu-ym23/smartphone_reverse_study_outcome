package com.bytedance.android.live.profit.dress.config;

import com.bytedance.android.live.base.model.message.a5;
import com.bytedance.android.live.saas.middleware.fresco.DefaultConfig;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@ProtoMessage("webcast.api.dress.EnterEffectConfig")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\n\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\bW\u0010XR$\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR$\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R$\u0010\u0011\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0005\u001a\u0004\b\u0012\u0010\u0007\"\u0004\b\u0013\u0010\tR$\u0010\u0014\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0005\u001a\u0004\b\u0015\u0010\u0007\"\u0004\b\u0016\u0010\tR$\u0010\u0017\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0005\u001a\u0004\b\u0018\u0010\u0007\"\u0004\b\u0019\u0010\tR$\u0010\u001a\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u0005\u001a\u0004\b\u001b\u0010\u0007\"\u0004\b\u001c\u0010\tR$\u0010\u001d\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u0005\u001a\u0004\b\u001e\u0010\u0007\"\u0004\b\u001f\u0010\tR$\u0010 \u001a\u0004\u0018\u00010\n8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b \u0010\f\u001a\u0004\b!\u0010\u000e\"\u0004\b\"\u0010\u0010R\u001b\u0010(\u001a\u00020#8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'R\u001b\u0010+\u001a\u00020#8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b)\u0010%\u001a\u0004\b*\u0010'R\u001b\u00100\u001a\u00020,8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b-\u0010%\u001a\u0004\b.\u0010/R\u001b\u00103\u001a\u00020#8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b1\u0010%\u001a\u0004\b2\u0010'R\u001b\u00108\u001a\u0002048VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b5\u0010%\u001a\u0004\b6\u00107R\u001b\u0010;\u001a\u00020#8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b9\u0010%\u001a\u0004\b:\u0010'R)\u0010A\u001a\u0010\u0012\u0004\u0012\u00020=\u0012\u0004\u0012\u00020=\u0018\u00010<8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b>\u0010%\u001a\u0004\b?\u0010@R\u001b\u0010D\u001a\u00020#8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\bB\u0010%\u001a\u0004\bC\u0010'R\u001d\u0010H\u001a\u0004\u0018\u00010=8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\bE\u0010%\u001a\u0004\bF\u0010GR\u001b\u0010K\u001a\u00020#8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\bI\u0010%\u001a\u0004\bJ\u0010'R\u001b\u0010N\u001a\u00020#8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\bL\u0010%\u001a\u0004\bM\u0010'R\u001d\u0010S\u001a\u0004\u0018\u00010O8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\bP\u0010%\u001a\u0004\bQ\u0010RR\u001d\u0010V\u001a\u0004\u0018\u00010=8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\bT\u0010%\u001a\u0004\bU\u0010G¨\u0006Y"}, d2 = {"Lcom/bytedance/android/live/profit/dress/config/IEnterEffectConfigFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/live/profit/dress/config/i;", "Lpy/k;", "icon", "Lpy/k;", "getIcon", "()Lpy/k;", "setIcon", "(Lpy/k;)V", "Lcom/bytedance/android/live/base/model/message/a5;", "text", "Lcom/bytedance/android/live/base/model/message/a5;", "getText", "()Lcom/bytedance/android/live/base/model/message/a5;", "setText", "(Lcom/bytedance/android/live/base/model/message/a5;)V", "textIcon", "getTextIcon", "setTextIcon", "badge", "getBadge", "setBadge", "textIconOverlay", "getTextIconOverlay", "setTextIconOverlay", "animatedBadge", "getAnimatedBadge", "setAnimatedBadge", "dynamicImage", "getDynamicImage", "setDynamicImage", "template", "getTemplate", "setTemplate", "", "type$delegate", "Ljava/lang/Object;", "getType", "()J", "type", "avatarPos$delegate", "getAvatarPos", "avatarPos", "", "stayTime$delegate", "getStayTime", "()I", "stayTime", "animAssetId$delegate", "getAnimAssetId", "animAssetId", "", "hasSweepLight$delegate", "getHasSweepLight", "()Z", "hasSweepLight", "centerAnimAssetId$delegate", "getCenterAnimAssetId", "centerAnimAssetId", "", "", "extra$delegate", "getExtra", "()Ljava/util/Map;", "extra", "mp4AnimAssetId$delegate", "getMp4AnimAssetId", "mp4AnimAssetId", "dressId$delegate", "getDressId", "()Ljava/lang/String;", "dressId", "alignment$delegate", "getAlignment", "alignment", "alignmentOffset$delegate", "getAlignmentOffset", "alignmentOffset", "Lcom/bytedance/android/live/profit/dress/config/IDressProfilePreviewConfigFlexImpl;", "profilePreviewConfig$delegate", "getProfilePreviewConfig", "()Lcom/bytedance/android/live/profit/dress/config/IDressProfilePreviewConfigFlexImpl;", "profilePreviewConfig", "avatarBorderDressId$delegate", "getAvatarBorderDressId", "avatarBorderDressId", "<init>", "()V", "revenue-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class IEnterEffectConfigFlexImpl extends FlexModelBase<i> implements i, vh7.h {

    @SerializedName("alignment")
    protected long _$$alignment;

    @SerializedName("alignment_offset")
    protected long _$$alignmentOffset;

    @SerializedName("anim_asset_id")
    protected long _$$animAssetId;

    @SerializedName("link_avatar_border_id")
    protected String _$$avatarBorderDressId;

    @SerializedName("avatar_pos")
    protected long _$$avatarPos;

    @SerializedName("center_anim_asset_id")
    protected long _$$centerAnimAssetId;

    @SerializedName("dress_id")
    protected String _$$dressId;

    @SerializedName("extra")
    protected Map<String, String> _$$extra;

    @SerializedName("has_sweep_light")
    protected boolean _$$hasSweepLight;

    @SerializedName("mp4_anim_asset_id")
    protected long _$$mp4AnimAssetId;

    @SerializedName("profile_preview")
    protected IDressProfilePreviewConfigFlexImpl _$$profilePreviewConfig;

    @SerializedName("stay_time")
    protected int _$$stayTime;

    @SerializedName("type")
    protected long _$$type;

    @SerializedName("animated_badge")
    protected py.k animatedBadge;

    @SerializedName("badge")
    protected py.k badge;

    @SerializedName("dynamic_image")
    protected py.k dynamicImage;

    @SerializedName("icon")
    protected py.k icon;

    @SerializedName("template_text")
    protected a5 template;

    @SerializedName("text")
    protected a5 text;

    @SerializedName("text_icon")
    protected py.k textIcon;

    @SerializedName("text_icon_overlay")
    protected py.k textIconOverlay;

    public IEnterEffectConfigFlexImpl() {
        super(i.class);
        this._$$hasSweepLight = false;
    }

    @Override // com.bytedance.android.live.profit.dress.config.i
    public /* bridge */ /* synthetic */ h getProfilePreviewConfig() {
        return getProfilePreviewConfig();
    }

    @Override // com.bytedance.android.live.profit.dress.config.i
    public final long getAlignment() {
        return this._$$alignment;
    }

    @Override // com.bytedance.android.live.profit.dress.config.i
    public final long getAlignmentOffset() {
        return this._$$alignmentOffset;
    }

    @Override // com.bytedance.android.live.profit.dress.config.i
    public final long getAnimAssetId() {
        return this._$$animAssetId;
    }

    @Override // com.bytedance.android.live.profit.dress.config.i
    public py.k getAnimatedBadge() {
        return this.animatedBadge;
    }

    @Override // com.bytedance.android.live.profit.dress.config.i
    public final String getAvatarBorderDressId() {
        return this._$$avatarBorderDressId;
    }

    @Override // com.bytedance.android.live.profit.dress.config.i
    public final long getAvatarPos() {
        return this._$$avatarPos;
    }

    @Override // com.bytedance.android.live.profit.dress.config.i
    public py.k getBadge() {
        return this.badge;
    }

    @Override // com.bytedance.android.live.profit.dress.config.i
    public final long getCenterAnimAssetId() {
        return this._$$centerAnimAssetId;
    }

    @Override // com.bytedance.android.live.profit.dress.config.i
    public final String getDressId() {
        return this._$$dressId;
    }

    @Override // com.bytedance.android.live.profit.dress.config.i
    public py.k getDynamicImage() {
        return this.dynamicImage;
    }

    @Override // com.bytedance.android.live.profit.dress.config.i
    public final Map<String, String> getExtra() {
        return this._$$extra;
    }

    @Override // com.bytedance.android.live.profit.dress.config.i
    public final boolean getHasSweepLight() {
        return this._$$hasSweepLight;
    }

    @Override // com.bytedance.android.live.profit.dress.config.i
    public py.k getIcon() {
        return this.icon;
    }

    @Override // com.bytedance.android.live.profit.dress.config.i
    public final long getMp4AnimAssetId() {
        return this._$$mp4AnimAssetId;
    }

    @Override // com.bytedance.android.live.profit.dress.config.i
    public final int getStayTime() {
        return this._$$stayTime;
    }

    @Override // com.bytedance.android.live.profit.dress.config.i
    public a5 getTemplate() {
        return this.template;
    }

    @Override // com.bytedance.android.live.profit.dress.config.i
    public a5 getText() {
        return this.text;
    }

    @Override // com.bytedance.android.live.profit.dress.config.i
    public py.k getTextIcon() {
        return this.textIcon;
    }

    @Override // com.bytedance.android.live.profit.dress.config.i
    public py.k getTextIconOverlay() {
        return this.textIconOverlay;
    }

    @Override // com.bytedance.android.live.profit.dress.config.i
    public final long getType() {
        return this._$$type;
    }

    @Override // com.bytedance.android.live.profit.dress.config.i
    public final IDressProfilePreviewConfigFlexImpl getProfilePreviewConfig() {
        return this._$$profilePreviewConfig;
    }

    /* JADX WARN: Type inference failed for: r4v12, types: [java.lang.Object, py.k] */
    /* JADX WARN: Type inference failed for: r4v14, types: [java.lang.Object, py.k] */
    /* JADX WARN: Type inference failed for: r4v16, types: [java.lang.Object, py.k] */
    /* JADX WARN: Type inference failed for: r4v20, types: [java.lang.Object, py.k] */
    /* JADX WARN: Type inference failed for: r4v3, types: [java.lang.Object, py.k] */
    /* JADX WARN: Type inference failed for: r4v30, types: [com.bytedance.android.live.base.model.message.a5, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v6, types: [com.bytedance.android.live.base.model.message.a5, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v8, types: [java.lang.Object, py.k] */
    public IEnterEffectConfigFlexImpl(am3.g r13) {
        super(i.class);
        this._$$extra = new HashMap();
        setThreadSafe(false);
        long r1 = r13.c();
        int r3 = 0;
    L3:
        int r4 = r13.f();
        if (r4 == (-1)) goto L45;
        am3.g.a r7 = decodeExtensionFields(r4, r13);
        switch(r4) {
            case 1: goto L44;
            case 2: goto L43;
            case 3: goto L42;
            case 4: goto L41;
            case 5: goto L40;
            case 6: goto L39;
            case 7: goto L38;
            case 8: goto L37;
            case 9: goto L7;
            case 10: goto L36;
            case 11: goto L35;
            case 12: goto L34;
            case 13: goto L7;
            case 14: goto L33;
            case 15: goto L32;
            case 16: goto L15;
            case 17: goto L14;
            case 18: goto L7;
            case 19: goto L7;
            case 20: goto L13;
            case 21: goto L12;
            case 22: goto L11;
            case 23: goto L10;
            case 24: goto L9;
            case 25: goto L8;
            default: goto L7;
        };
    L8:
        this._$$avatarBorderDressId = am3.h.c(r13);
        goto L3
    L9:
        this._$$profilePreviewConfig = new IDressProfilePreviewConfigFlexImpl(r13);
        goto L3
    L10:
        this.template = vh7.f.a(r13, a5.class);
        goto L3
    L11:
        this._$$alignmentOffset = r13.j();
        r3 = r3 | DefaultConfig.MAX_CACHE_ENTRIES;
        goto L3
    L12:
        this._$$alignment = r13.j();
        r3 = r3 | 128;
        goto L3
    L13:
        this._$$dressId = am3.h.c(r13);
        goto L3
    L14:
        this._$$mp4AnimAssetId = r13.j();
        r3 = r3 | 64;
        goto L3
    L15:
        long r8 = r13.c();
        String r5 = null;
        String r9 = null;
    L16:
        int r10 = r13.f();
        if (r10 == (-1)) goto L24;
        if (r10 != 1) goto L20;
        r5 = am3.h.c(r13);
        goto L16
    L20:
        if (r10 != 2) goto L21;
        r9 = am3.h.c(r13);
        goto L16
    L21:
        am3.h.e(r13);
        goto L16
    L24:
        r13.d(r8);
        Map<String, String> r6 = this._$$extra;
        if (r5 == null) goto L31;
        if (r9 == null) goto L29;
        r6.put(r5, r9);
        goto L3
    L29:
        throw new IllegalStateException("Value must not be null");
    L31:
        throw new IllegalStateException("Key must not be null");
    L32:
        this.dynamicImage = vh7.f.a(r13, py.k.class);
        goto L3
    L33:
        this._$$centerAnimAssetId = r13.j();
        r3 = r3 | 32;
        goto L3
    L34:
        this._$$hasSweepLight = am3.h.a(r13);
        r3 = r3 | 16;
        goto L3
    L35:
        this.animatedBadge = vh7.f.a(r13, py.k.class);
        goto L3
    L36:
        this.textIconOverlay = vh7.f.a(r13, py.k.class);
        goto L3
    L37:
        this.badge = vh7.f.a(r13, py.k.class);
        goto L3
    L38:
        this._$$animAssetId = r13.j();
        r3 = r3 | 8;
        goto L3
    L39:
        this._$$stayTime = r13.i();
        r3 = r3 | 4;
        goto L3
    L40:
        this.textIcon = vh7.f.a(r13, py.k.class);
        goto L3
    L41:
        this.text = vh7.f.a(r13, a5.class);
        goto L3
    L42:
        this._$$avatarPos = r13.j();
        r3 = r3 | 2;
        goto L3
    L43:
        this.icon = vh7.f.a(r13, py.k.class);
        goto L3
    L44:
        this._$$type = r13.j();
        r3 = r3 | 1;
        goto L3
    L7:
        am3.h.d(r7, r13);
        goto L3
    L45:
        r13.d(r1);
        setThreadSafe(true);
        if ((r3 & 16) != 0) goto L106;
        this._$$hasSweepLight = false;
        return;
    }

    public void setAnimatedBadge(py.k r1) {
        this.animatedBadge = r1;
    }

    public void setBadge(py.k r1) {
        this.badge = r1;
    }

    public void setDynamicImage(py.k r1) {
        this.dynamicImage = r1;
    }

    public void setIcon(py.k r1) {
        this.icon = r1;
    }

    public void setTemplate(a5 r1) {
        this.template = r1;
    }

    public void setText(a5 r1) {
        this.text = r1;
    }

    public void setTextIcon(py.k r1) {
        this.textIcon = r1;
    }

    public void setTextIconOverlay(py.k r1) {
        this.textIconOverlay = r1;
    }
}
