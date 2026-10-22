package com.bytedance.android.live.profit.dress;

import com.bytedance.android.live.profit.dress.config.IAvatarBorderConfigFlexImpl;
import com.bytedance.android.live.profit.dress.config.IBadgeConfigFlexImpl;
import com.bytedance.android.live.profit.dress.config.IEnterEffectConfigFlexImpl;
import com.bytedance.android.live.profit.dress.config.IGuestBattleThemeElementConfigFlexImpl;
import com.bytedance.android.live.profit.dress.config.ILinkmicDecorationConfigFlexImpl;
import com.bytedance.android.live.profit.dress.config.ILinkmicRealTimeChorusConfigFlexImpl;
import com.bytedance.android.live.profit.dress.config.IOpenAssetConfigFlexImpl;
import com.bytedance.android.live.profit.dress.config.IProfileSkinConfigFlexImpl;
import com.bytedance.android.live.profit.dress.config.IRedEnvelopeSkinFlexImpl;
import com.bytedance.android.live.profit.dress.config.IRolePropConfigFlexImpl;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@ProtoMessage("webcast.api.dress.Dress")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\bH\u0010IR\u001b\u0010\b\u001a\u00020\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\r\u001a\u00020\t8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\fR\u001b\u0010\u0010\u001a\u00020\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u0005\u001a\u0004\b\u000f\u0010\u0007R\u001b\u0010\u0015\u001a\u00020\u00118VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0005\u001a\u0004\b\u0013\u0010\u0014R\u001d\u0010\u001a\u001a\u0004\u0018\u00010\u00168VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0005\u001a\u0004\b\u0018\u0010\u0019R\u001d\u0010\u001f\u001a\u0004\u0018\u00010\u001b8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u0005\u001a\u0004\b\u001d\u0010\u001eR\u001d\u0010$\u001a\u0004\u0018\u00010 8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b!\u0010\u0005\u001a\u0004\b\"\u0010#R\u001d\u0010)\u001a\u0004\u0018\u00010%8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b&\u0010\u0005\u001a\u0004\b'\u0010(R\u001d\u0010.\u001a\u0004\u0018\u00010*8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b+\u0010\u0005\u001a\u0004\b,\u0010-R\u001d\u00103\u001a\u0004\u0018\u00010/8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b0\u0010\u0005\u001a\u0004\b1\u00102R\u001d\u00108\u001a\u0004\u0018\u0001048VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b5\u0010\u0005\u001a\u0004\b6\u00107R\u001d\u0010=\u001a\u0004\u0018\u0001098VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b:\u0010\u0005\u001a\u0004\b;\u0010<R\u001d\u0010B\u001a\u0004\u0018\u00010>8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b?\u0010\u0005\u001a\u0004\b@\u0010AR\u001d\u0010G\u001a\u0004\u0018\u00010C8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\bD\u0010\u0005\u001a\u0004\bE\u0010F¨\u0006J"}, d2 = {"Lcom/bytedance/android/live/profit/dress/IDressModelFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/live/profit/dress/o;", "", "dressId$delegate", "Ljava/lang/Object;", "getDressId", "()Ljava/lang/String;", "dressId", "", "dressType$delegate", "getDressType", "()I", "dressType", "dressName$delegate", "getDressName", "dressName", "", "priority$delegate", "getPriority", "()J", "priority", "Lcom/bytedance/android/live/profit/dress/config/IAvatarBorderConfigFlexImpl;", "avatarBorderConfig$delegate", "getAvatarBorderConfig", "()Lcom/bytedance/android/live/profit/dress/config/IAvatarBorderConfigFlexImpl;", "avatarBorderConfig", "Lcom/bytedance/android/live/profit/dress/config/IEnterEffectConfigFlexImpl;", "enterEffectConfig$delegate", "getEnterEffectConfig", "()Lcom/bytedance/android/live/profit/dress/config/IEnterEffectConfigFlexImpl;", "enterEffectConfig", "Lcom/bytedance/android/live/profit/dress/config/IBadgeConfigFlexImpl;", "badgeConfig$delegate", "getBadgeConfig", "()Lcom/bytedance/android/live/profit/dress/config/IBadgeConfigFlexImpl;", "badgeConfig", "Lcom/bytedance/android/live/profit/dress/config/IProfileSkinConfigFlexImpl;", "profileSkinConfig$delegate", "getProfileSkinConfig", "()Lcom/bytedance/android/live/profit/dress/config/IProfileSkinConfigFlexImpl;", "profileSkinConfig", "Lcom/bytedance/android/live/profit/dress/config/IGuestBattleThemeElementConfigFlexImpl;", "guestBattleThemeElement$delegate", "getGuestBattleThemeElement", "()Lcom/bytedance/android/live/profit/dress/config/IGuestBattleThemeElementConfigFlexImpl;", "guestBattleThemeElement", "Lcom/bytedance/android/live/profit/dress/config/IOpenAssetConfigFlexImpl;", "openAssetConfig$delegate", "getOpenAssetConfig", "()Lcom/bytedance/android/live/profit/dress/config/IOpenAssetConfigFlexImpl;", "openAssetConfig", "Lcom/bytedance/android/live/profit/dress/config/IRedEnvelopeSkinFlexImpl;", "redEnvelopeSkin$delegate", "getRedEnvelopeSkin", "()Lcom/bytedance/android/live/profit/dress/config/IRedEnvelopeSkinFlexImpl;", "redEnvelopeSkin", "Lcom/bytedance/android/live/profit/dress/config/IRolePropConfigFlexImpl;", "rolePropConfig$delegate", "getRolePropConfig", "()Lcom/bytedance/android/live/profit/dress/config/IRolePropConfigFlexImpl;", "rolePropConfig", "Lcom/bytedance/android/live/profit/dress/config/ILinkmicDecorationConfigFlexImpl;", "linkmicDecorationConfig$delegate", "getLinkmicDecorationConfig", "()Lcom/bytedance/android/live/profit/dress/config/ILinkmicDecorationConfigFlexImpl;", "linkmicDecorationConfig", "Lcom/bytedance/android/live/profit/dress/config/ILinkmicRealTimeChorusConfigFlexImpl;", "linkmicRealTimeChorusConfig$delegate", "getLinkmicRealTimeChorusConfig", "()Lcom/bytedance/android/live/profit/dress/config/ILinkmicRealTimeChorusConfigFlexImpl;", "linkmicRealTimeChorusConfig", "<init>", "()V", "revenue-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class IDressModelFlexImpl extends FlexModelBase<o> implements o, vh7.h {

    @SerializedName("avatar_border_config")
    protected IAvatarBorderConfigFlexImpl _$$avatarBorderConfig;

    @SerializedName("badge_config")
    protected IBadgeConfigFlexImpl _$$badgeConfig;

    @SerializedName("dress_id")
    protected String _$$dressId;

    @SerializedName("dress_name")
    protected String _$$dressName;

    @SerializedName("dress_type")
    protected int _$$dressType;

    @SerializedName("enter_effect_config")
    protected IEnterEffectConfigFlexImpl _$$enterEffectConfig;

    @SerializedName("guest_battle_theme_element")
    protected IGuestBattleThemeElementConfigFlexImpl _$$guestBattleThemeElement;

    @SerializedName("LinkmicDecorationConfig")
    protected ILinkmicDecorationConfigFlexImpl _$$linkmicDecorationConfig;

    @SerializedName("linkmic_real_time_chorus_config")
    protected ILinkmicRealTimeChorusConfigFlexImpl _$$linkmicRealTimeChorusConfig;

    @SerializedName("open_asset_config")
    protected IOpenAssetConfigFlexImpl _$$openAssetConfig;

    @SerializedName("priority")
    protected long _$$priority;

    @SerializedName("profile_skin_config")
    protected IProfileSkinConfigFlexImpl _$$profileSkinConfig;

    @SerializedName("red_envelope_skin")
    protected IRedEnvelopeSkinFlexImpl _$$redEnvelopeSkin;

    @SerializedName("role_prop_config")
    protected IRolePropConfigFlexImpl _$$rolePropConfig;

    public IDressModelFlexImpl() {
        super(o.class);
        this._$$dressId = "";
        this._$$dressName = "";
    }

    @Override // com.bytedance.android.live.profit.dress.o
    public /* bridge */ /* synthetic */ com.bytedance.android.live.profit.dress.config.b getAvatarBorderConfig() {
        return getAvatarBorderConfig();
    }

    @Override // com.bytedance.android.live.profit.dress.o
    public /* bridge */ /* synthetic */ com.bytedance.android.live.profit.dress.config.c getBadgeConfig() {
        return getBadgeConfig();
    }

    @Override // com.bytedance.android.live.profit.dress.o
    public /* bridge */ /* synthetic */ com.bytedance.android.live.profit.dress.config.i getEnterEffectConfig() {
        return getEnterEffectConfig();
    }

    @Override // com.bytedance.android.live.profit.dress.o
    public /* bridge */ /* synthetic */ com.bytedance.android.live.profit.dress.config.j getGuestBattleThemeElement() {
        return getGuestBattleThemeElement();
    }

    @Override // com.bytedance.android.live.profit.dress.o
    public /* bridge */ /* synthetic */ com.bytedance.android.live.profit.dress.config.k getLinkmicDecorationConfig() {
        return getLinkmicDecorationConfig();
    }

    @Override // com.bytedance.android.live.profit.dress.o
    public /* bridge */ /* synthetic */ com.bytedance.android.live.profit.dress.config.m getLinkmicRealTimeChorusConfig() {
        return getLinkmicRealTimeChorusConfig();
    }

    @Override // com.bytedance.android.live.profit.dress.o
    public /* bridge */ /* synthetic */ com.bytedance.android.live.profit.dress.config.p getOpenAssetConfig() {
        return getOpenAssetConfig();
    }

    @Override // com.bytedance.android.live.profit.dress.o
    public /* bridge */ /* synthetic */ com.bytedance.android.live.profit.dress.config.r getProfileSkinConfig() {
        return getProfileSkinConfig();
    }

    @Override // com.bytedance.android.live.profit.dress.o
    public /* bridge */ /* synthetic */ com.bytedance.android.live.profit.dress.config.t getRedEnvelopeSkin() {
        return getRedEnvelopeSkin();
    }

    @Override // com.bytedance.android.live.profit.dress.o
    public /* bridge */ /* synthetic */ com.bytedance.android.live.profit.dress.config.u getRolePropConfig() {
        return getRolePropConfig();
    }

    @Override // com.bytedance.android.live.profit.dress.o
    public final String getDressId() {
        return this._$$dressId;
    }

    @Override // com.bytedance.android.live.profit.dress.o
    public final String getDressName() {
        return this._$$dressName;
    }

    @Override // com.bytedance.android.live.profit.dress.o
    public final int getDressType() {
        return this._$$dressType;
    }

    @Override // com.bytedance.android.live.profit.dress.o
    public final long getPriority() {
        return this._$$priority;
    }

    @Override // com.bytedance.android.live.profit.dress.o
    public final IAvatarBorderConfigFlexImpl getAvatarBorderConfig() {
        return this._$$avatarBorderConfig;
    }

    @Override // com.bytedance.android.live.profit.dress.o
    public final IBadgeConfigFlexImpl getBadgeConfig() {
        return this._$$badgeConfig;
    }

    @Override // com.bytedance.android.live.profit.dress.o
    public final IEnterEffectConfigFlexImpl getEnterEffectConfig() {
        return this._$$enterEffectConfig;
    }

    @Override // com.bytedance.android.live.profit.dress.o
    public final IGuestBattleThemeElementConfigFlexImpl getGuestBattleThemeElement() {
        return this._$$guestBattleThemeElement;
    }

    @Override // com.bytedance.android.live.profit.dress.o
    public final ILinkmicDecorationConfigFlexImpl getLinkmicDecorationConfig() {
        return this._$$linkmicDecorationConfig;
    }

    @Override // com.bytedance.android.live.profit.dress.o
    public final ILinkmicRealTimeChorusConfigFlexImpl getLinkmicRealTimeChorusConfig() {
        return this._$$linkmicRealTimeChorusConfig;
    }

    @Override // com.bytedance.android.live.profit.dress.o
    public final IOpenAssetConfigFlexImpl getOpenAssetConfig() {
        return this._$$openAssetConfig;
    }

    @Override // com.bytedance.android.live.profit.dress.o
    public final IProfileSkinConfigFlexImpl getProfileSkinConfig() {
        return this._$$profileSkinConfig;
    }

    @Override // com.bytedance.android.live.profit.dress.o
    public final IRedEnvelopeSkinFlexImpl getRedEnvelopeSkin() {
        return this._$$redEnvelopeSkin;
    }

    @Override // com.bytedance.android.live.profit.dress.o
    public final IRolePropConfigFlexImpl getRolePropConfig() {
        return this._$$rolePropConfig;
    }

    public IDressModelFlexImpl(am3.g r6) {
        super(o.class);
        setThreadSafe(false);
        long r0 = r6.c();
    L3:
        int r2 = r6.f();
        if (r2 == (-1)) goto L36;
        am3.g.a r3 = decodeExtensionFields(r2, r6);
        if (r2 != 1) goto L8;
        this._$$dressId = am3.h.c(r6);
        goto L3
    L8:
        if (r2 != 2) goto L10;
        this._$$dressType = r6.i();
        goto L3
    L10:
        if (r2 != 3) goto L12;
        this._$$dressName = am3.h.c(r6);
        goto L3
    L12:
        if (r2 != 4) goto L14;
        this._$$priority = r6.j();
        goto L3
    L14:
        if (r2 != 110) goto L16;
        this._$$profileSkinConfig = new IProfileSkinConfigFlexImpl(r6);
        goto L3
    L16:
        if (r2 != 120) goto L18;
        this._$$guestBattleThemeElement = new IGuestBattleThemeElementConfigFlexImpl(r6);
        goto L3
    L18:
        if (r2 != 123) goto L19;
        this._$$openAssetConfig = new IOpenAssetConfigFlexImpl(r6);
        goto L3
    L19:
        switch(r2) {
            case 100: goto L28;
            case 101: goto L27;
            case 102: goto L26;
            default: goto L20;
        };
    L26:
        this._$$badgeConfig = new IBadgeConfigFlexImpl(r6);
        goto L3
    L27:
        this._$$enterEffectConfig = new IEnterEffectConfigFlexImpl(r6);
        goto L3
    L28:
        this._$$avatarBorderConfig = new IAvatarBorderConfigFlexImpl(r6);
        goto L3
    L20:
        switch(r2) {
            case 125: goto L25;
            case 126: goto L24;
            case 127: goto L23;
            case 128: goto L22;
            default: goto L21;
        };
    L22:
        this._$$linkmicRealTimeChorusConfig = new ILinkmicRealTimeChorusConfigFlexImpl(r6);
        goto L3
    L23:
        this._$$linkmicDecorationConfig = new ILinkmicDecorationConfigFlexImpl(r6);
        goto L3
    L24:
        this._$$rolePropConfig = new IRolePropConfigFlexImpl(r6);
        goto L3
    L25:
        this._$$redEnvelopeSkin = new IRedEnvelopeSkinFlexImpl(r6);
        goto L3
    L21:
        am3.h.d(r3, r6);
        goto L3
    L36:
        r6.d(r0);
        setThreadSafe(true);
        if (this._$$dressId != null) goto L40;
        this._$$dressId = "";
    L40:
        if (this._$$dressName != null) goto L83;
        this._$$dressName = "";
        return;
    }
}
