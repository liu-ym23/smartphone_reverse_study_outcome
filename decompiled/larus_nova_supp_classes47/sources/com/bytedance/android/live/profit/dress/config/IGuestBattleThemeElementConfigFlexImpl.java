package com.bytedance.android.live.profit.dress.config;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@ProtoMessage("webcast.api.dress.GuestBattleThemeElementConfig")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010 \n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b5\u00106R$\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR$\u0010\n\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR$\u0010\r\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u0005\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\tR$\u0010\u0010\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0005\u001a\u0004\b\u0011\u0010\u0007\"\u0004\b\u0012\u0010\tR#\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u00138VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u001b\u0010\u001d\u001a\u00020\u00148VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u0016\u001a\u0004\b\u001b\u0010\u001cR\u001d\u0010\"\u001a\u0004\u0018\u00010\u001e8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u001f\u0010\u0016\u001a\u0004\b \u0010!R\u001d\u0010'\u001a\u0004\u0018\u00010#8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b$\u0010\u0016\u001a\u0004\b%\u0010&R\u001b\u0010,\u001a\u00020(8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b)\u0010\u0016\u001a\u0004\b*\u0010+R\u001d\u00101\u001a\u0004\u0018\u00010-8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b.\u0010\u0016\u001a\u0004\b/\u00100R\u001d\u00104\u001a\u0004\u0018\u00010-8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b2\u0010\u0016\u001a\u0004\b3\u00100¨\u00067"}, d2 = {"Lcom/bytedance/android/live/profit/dress/config/IGuestBattleThemeElementConfigFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/live/profit/dress/config/j;", "Lpy/k;", "bannerBackground", "Lpy/k;", "getBannerBackground", "()Lpy/k;", "setBannerBackground", "(Lpy/k;)V", "rankListCrownBackground", "getRankListCrownBackground", "setRankListCrownBackground", "roomBackground", "getRoomBackground", "setRoomBackground", "playRuleImage", "getPlayRuleImage", "setPlayRuleImage", "", "", "scenes$delegate", "Ljava/lang/Object;", "getScenes", "()Ljava/util/List;", "scenes", "allowListId$delegate", "getAllowListId", "()J", "allowListId", "Lcom/bytedance/android/live/profit/dress/config/IGuestBattleThemeElementConfig_IGuestBattleFirstConfigFlexImpl;", "firstConfig$delegate", "getFirstConfig", "()Lcom/bytedance/android/live/profit/dress/config/IGuestBattleThemeElementConfig_IGuestBattleFirstConfigFlexImpl;", "firstConfig", "Lcom/bytedance/android/live/profit/dress/config/IGuestBattleThemeElementConfig_IGuestBattleStragglerConfigFlexImpl;", "stragglerConfig$delegate", "getStragglerConfig", "()Lcom/bytedance/android/live/profit/dress/config/IGuestBattleThemeElementConfig_IGuestBattleStragglerConfigFlexImpl;", "stragglerConfig", "", "globalEnable$delegate", "getGlobalEnable", "()Z", "globalEnable", "Lcom/bytedance/android/live/profit/dress/config/IGuestBattleThemeElementConfig_IGuestBattlePlayerConfigFlexImpl;", "secondPlaceConfig$delegate", "getSecondPlaceConfig", "()Lcom/bytedance/android/live/profit/dress/config/IGuestBattleThemeElementConfig_IGuestBattlePlayerConfigFlexImpl;", "secondPlaceConfig", "thirdPlaceConfig$delegate", "getThirdPlaceConfig", "thirdPlaceConfig", "<init>", "()V", "revenue-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class IGuestBattleThemeElementConfigFlexImpl extends FlexModelBase<j> implements j, vh7.h {

    @SerializedName("allow_list_id")
    protected long _$$allowListId;

    @SerializedName("first_config")
    protected IGuestBattleThemeElementConfig_IGuestBattleFirstConfigFlexImpl _$$firstConfig;

    @SerializedName("global")
    protected boolean _$$globalEnable;

    @SerializedName("scenes")
    protected List<Long> _$$scenes;

    @SerializedName("second_place_config")
    protected IGuestBattleThemeElementConfig_IGuestBattlePlayerConfigFlexImpl _$$secondPlaceConfig;

    @SerializedName("straggler_config")
    protected IGuestBattleThemeElementConfig_IGuestBattleStragglerConfigFlexImpl _$$stragglerConfig;

    @SerializedName("third_place_config")
    protected IGuestBattleThemeElementConfig_IGuestBattlePlayerConfigFlexImpl _$$thirdPlaceConfig;

    @SerializedName("banner_bg")
    protected py.k bannerBackground;

    @SerializedName("play_rule_img")
    protected py.k playRuleImage;

    @SerializedName("battle_ranklist_crown_bg")
    protected py.k rankListCrownBackground;

    @SerializedName("play_bg")
    protected py.k roomBackground;

    public IGuestBattleThemeElementConfigFlexImpl() {
        super(j.class);
        this._$$globalEnable = false;
    }

    @Override // com.bytedance.android.live.profit.dress.config.j
    public /* bridge */ /* synthetic */ j.b getFirstConfig() {
        return getFirstConfig();
    }

    @Override // com.bytedance.android.live.profit.dress.config.j
    public /* bridge */ /* synthetic */ j.d getSecondPlaceConfig() {
        return getSecondPlaceConfig();
    }

    @Override // com.bytedance.android.live.profit.dress.config.j
    public /* bridge */ /* synthetic */ j.e getStragglerConfig() {
        return getStragglerConfig();
    }

    @Override // com.bytedance.android.live.profit.dress.config.j
    public /* bridge */ /* synthetic */ j.d getThirdPlaceConfig() {
        return getThirdPlaceConfig();
    }

    @Override // com.bytedance.android.live.profit.dress.config.j
    public final long getAllowListId() {
        return this._$$allowListId;
    }

    @Override // com.bytedance.android.live.profit.dress.config.j
    public py.k getBannerBackground() {
        return this.bannerBackground;
    }

    @Override // com.bytedance.android.live.profit.dress.config.j
    public final boolean getGlobalEnable() {
        return this._$$globalEnable;
    }

    @Override // com.bytedance.android.live.profit.dress.config.j
    public py.k getPlayRuleImage() {
        return this.playRuleImage;
    }

    @Override // com.bytedance.android.live.profit.dress.config.j
    public py.k getRankListCrownBackground() {
        return this.rankListCrownBackground;
    }

    @Override // com.bytedance.android.live.profit.dress.config.j
    public py.k getRoomBackground() {
        return this.roomBackground;
    }

    @Override // com.bytedance.android.live.profit.dress.config.j
    public final List<Long> getScenes() {
        return this._$$scenes;
    }

    @Override // com.bytedance.android.live.profit.dress.config.j
    public final IGuestBattleThemeElementConfig_IGuestBattleFirstConfigFlexImpl getFirstConfig() {
        return this._$$firstConfig;
    }

    @Override // com.bytedance.android.live.profit.dress.config.j
    public final IGuestBattleThemeElementConfig_IGuestBattlePlayerConfigFlexImpl getSecondPlaceConfig() {
        return this._$$secondPlaceConfig;
    }

    @Override // com.bytedance.android.live.profit.dress.config.j
    public final IGuestBattleThemeElementConfig_IGuestBattleStragglerConfigFlexImpl getStragglerConfig() {
        return this._$$stragglerConfig;
    }

    @Override // com.bytedance.android.live.profit.dress.config.j
    public final IGuestBattleThemeElementConfig_IGuestBattlePlayerConfigFlexImpl getThirdPlaceConfig() {
        return this._$$thirdPlaceConfig;
    }

    /* JADX WARN: Type inference failed for: r4v10, types: [java.lang.Object, py.k] */
    /* JADX WARN: Type inference failed for: r4v13, types: [java.lang.Object, py.k] */
    /* JADX WARN: Type inference failed for: r4v6, types: [java.lang.Object, py.k] */
    /* JADX WARN: Type inference failed for: r4v8, types: [java.lang.Object, py.k] */
    public IGuestBattleThemeElementConfigFlexImpl(am3.g r8) {
        super(j.class);
        this._$$scenes = new ArrayList();
        setThreadSafe(false);
        long r1 = r8.c();
        int r3 = 0;
    L3:
        int r4 = r8.f();
        if (r4 == (-1)) goto L19;
        am3.g.a r5 = decodeExtensionFields(r4, r8);
        switch(r4) {
            case 1: goto L18;
            case 2: goto L17;
            case 3: goto L16;
            case 4: goto L15;
            case 5: goto L14;
            case 6: goto L13;
            case 7: goto L12;
            case 8: goto L11;
            case 9: goto L10;
            case 10: goto L9;
            case 11: goto L8;
            default: goto L7;
        };
    L8:
        this._$$thirdPlaceConfig = new IGuestBattleThemeElementConfig_IGuestBattlePlayerConfigFlexImpl(r8);
        goto L3
    L9:
        this._$$secondPlaceConfig = new IGuestBattleThemeElementConfig_IGuestBattlePlayerConfigFlexImpl(r8);
        goto L3
    L10:
        this.playRuleImage = vh7.f.a(r8, py.k.class);
        goto L3
    L11:
        this._$$globalEnable = am3.h.a(r8);
        r3 = r3 | 2;
        goto L3
    L12:
        this.roomBackground = vh7.f.a(r8, py.k.class);
        goto L3
    L13:
        this.rankListCrownBackground = vh7.f.a(r8, py.k.class);
        goto L3
    L14:
        this.bannerBackground = vh7.f.a(r8, py.k.class);
        goto L3
    L15:
        this._$$stragglerConfig = new IGuestBattleThemeElementConfig_IGuestBattleStragglerConfigFlexImpl(r8);
        goto L3
    L16:
        this._$$firstConfig = new IGuestBattleThemeElementConfig_IGuestBattleFirstConfigFlexImpl(r8);
        goto L3
    L17:
        this._$$allowListId = r8.j();
        r3 = r3 | 1;
        goto L3
    L18:
        this._$$scenes.add(Long.valueOf(r8.j()));
        goto L3
    L7:
        am3.h.d(r5, r8);
        goto L3
    L19:
        r8.d(r1);
        setThreadSafe(true);
        if ((r3 & 2) != 0) goto L49;
        this._$$globalEnable = false;
        return;
    }

    public void setBannerBackground(py.k r1) {
        this.bannerBackground = r1;
    }

    public void setPlayRuleImage(py.k r1) {
        this.playRuleImage = r1;
    }

    public void setRankListCrownBackground(py.k r1) {
        this.rankListCrownBackground = r1;
    }

    public void setRoomBackground(py.k r1) {
        this.roomBackground = r1;
    }
}
