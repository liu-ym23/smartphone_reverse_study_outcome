package com.bytedance.android.livesdk.gift.platform.core.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@ProtoMessage("webcast.api.gift.GiftsInfo")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\bG\u0010HR$\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001b\u0010\u000f\u001a\u00020\n8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR!\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00110\u00108VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\f\u001a\u0004\b\u0013\u0010\u0014R!\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\n0\u00108VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\f\u001a\u0004\b\u0017\u0010\u0014R\u001b\u0010\u001b\u001a\u00020\n8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\f\u001a\u0004\b\u001a\u0010\u000eR\u001b\u0010 \u001a\u00020\u001c8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\f\u001a\u0004\b\u001e\u0010\u001fR!\u0010#\u001a\b\u0012\u0004\u0012\u00020\n0\u00108VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b!\u0010\f\u001a\u0004\b\"\u0010\u0014R!\u0010&\u001a\b\u0012\u0004\u0012\u00020\n0\u00108VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b$\u0010\f\u001a\u0004\b%\u0010\u0014R!\u0010*\u001a\b\u0012\u0004\u0012\u00020'0\u00108VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b(\u0010\f\u001a\u0004\b)\u0010\u0014R\u001d\u0010/\u001a\u0004\u0018\u00010+8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b,\u0010\f\u001a\u0004\b-\u0010.R\u001b\u00102\u001a\u00020\n8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b0\u0010\f\u001a\u0004\b1\u0010\u000eR'\u00107\u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u001c038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b4\u0010\f\u001a\u0004\b5\u00106R\u001d\u0010<\u001a\u0004\u0018\u0001088VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b9\u0010\f\u001a\u0004\b:\u0010;R\u001d\u0010A\u001a\u0004\u0018\u00010=8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b>\u0010\f\u001a\u0004\b?\u0010@R\u001d\u0010F\u001a\u0004\u0018\u00010B8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\bC\u0010\f\u001a\u0004\bD\u0010E¨\u0006I"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/core/model/IGiftsInfoFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/gift/platform/core/model/u;", "Lpy/k;", "giftEntranceIcon", "Lpy/k;", "getGiftEntranceIcon", "()Lpy/k;", "setGiftEntranceIcon", "(Lpy/k;)V", BuildConfig.FLAVOR, "fastGiftId$delegate", "Ljava/lang/Object;", "getFastGiftId", "()J", "fastGiftId", BuildConfig.FLAVOR, "Lcom/bytedance/android/livesdk/gift/platform/core/model/h;", "groupCountInfo$delegate", "getGroupCountInfo", "()Ljava/util/List;", "groupCountInfo", "fansClubIds$delegate", "getFansClubIds", "fansClubIds", "newGiftId$delegate", "getNewGiftId", "newGiftId", BuildConfig.FLAVOR, "newGiftTip$delegate", "getNewGiftTip", "()Ljava/lang/String;", "newGiftTip", "honorLevelGiftIds$delegate", "getHonorLevelGiftIds", "honorLevelGiftIds", "nobleGiftIds$delegate", "getNobleGiftIds", "nobleGiftIds", "Lcom/bytedance/android/livesdk/gift/platform/core/model/e;", "giftComboInfoList$delegate", "getGiftComboInfoList", "giftComboInfoList", "Lcom/bytedance/android/livesdk/gift/platform/core/model/e0;", "speedyGiftPopupInfo$delegate", "getSpeedyGiftPopupInfo", "()Lcom/bytedance/android/livesdk/gift/platform/core/model/e0;", "speedyGiftPopupInfo", "firstChargeSpeedyGiftId$delegate", "getFirstChargeSpeedyGiftId", "firstChargeSpeedyGiftId", BuildConfig.FLAVOR, "msgProcessFilter$delegate", "getMsgProcessFilter", "()Ljava/util/Map;", "msgProcessFilter", "Lcom/bytedance/android/livesdk/gift/platform/core/model/g;", "extraParam$delegate", "getExtraParam", "()Lcom/bytedance/android/livesdk/gift/platform/core/model/g;", "extraParam", "Lcom/bytedance/android/livesdk/gift/platform/core/model/GiftSearchConfigFlexImpl;", "giftSearchConfig$delegate", "getGiftSearchConfig", "()Lcom/bytedance/android/livesdk/gift/platform/core/model/GiftSearchConfigFlexImpl;", "giftSearchConfig", "Lcom/bytedance/android/livesdk/gift/platform/core/model/GiftAgentConfigFlexImpl;", "giftAgentConfig$delegate", "getGiftAgentConfig", "()Lcom/bytedance/android/livesdk/gift/platform/core/model/GiftAgentConfigFlexImpl;", "giftAgentConfig", "<init>", "()V", "livegift-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class IGiftsInfoFlexImpl extends FlexModelBase<u> implements u, vh7.h {

    @SerializedName("extra_params")
    protected g _$$extraParam;

    @SerializedName("fansclub_gift_ids")
    protected List<Long> _$$fansClubIds;

    @SerializedName("speedy_gift_id")
    protected long _$$fastGiftId;

    @SerializedName("first_recharge_speedy_gift_id")
    protected long _$$firstChargeSpeedyGiftId;

    @SerializedName("gift_agent_config")
    protected GiftAgentConfigFlexImpl _$$giftAgentConfig;

    @SerializedName("gift_combo_infos")
    protected List<e> _$$giftComboInfoList;

    @SerializedName("gift_search_config")
    protected GiftSearchConfigFlexImpl _$$giftSearchConfig;

    @SerializedName("gift_group_infos")
    protected List<h> _$$groupCountInfo;

    @SerializedName("honor_gift_ids")
    protected List<Long> _$$honorLevelGiftIds;

    @SerializedName("msg_process_filter")
    protected Map<String, String> _$$msgProcessFilter;

    @SerializedName("new_gift_id")
    protected long _$$newGiftId;

    @SerializedName("gift_words")
    protected String _$$newGiftTip;

    @SerializedName("noble_gift_ids")
    protected List<Long> _$$nobleGiftIds;

    @SerializedName("speedy_gift_popup_info")
    protected e0 _$$speedyGiftPopupInfo;

    @SerializedName("gift_entrance_icon")
    protected py.k giftEntranceIcon;

    public IGiftsInfoFlexImpl() {
        super(u.class);
        this._$$groupCountInfo = $defaultValue_groupCountInfo$();
        this._$$fansClubIds = $defaultValue_fansClubIds$();
        this._$$newGiftTip = BuildConfig.FLAVOR;
        this._$$honorLevelGiftIds = $defaultValue_honorLevelGiftIds$();
        this._$$nobleGiftIds = $defaultValue_nobleGiftIds$();
        this._$$giftComboInfoList = $defaultValue_giftComboInfoList$();
        this._$$msgProcessFilter = $defaultValue_msgProcessFilter$();
    }

    public final List<Long> $defaultValue_fansClubIds$() {
        return CollectionsKt.emptyList();
    }

    public final List<e> $defaultValue_giftComboInfoList$() {
        return CollectionsKt.emptyList();
    }

    public final List<h> $defaultValue_groupCountInfo$() {
        return CollectionsKt.emptyList();
    }

    public final List<Long> $defaultValue_honorLevelGiftIds$() {
        return CollectionsKt.emptyList();
    }

    public final Map<String, String> $defaultValue_msgProcessFilter$() {
        return com.bytedance.tools.kcp.modelx.runtime.internal.reflect.d.b();
    }

    public final List<Long> $defaultValue_nobleGiftIds$() {
        return CollectionsKt.emptyList();
    }

    @Override // com.bytedance.android.livesdk.gift.platform.core.model.u
    public /* bridge */ /* synthetic */ d getGiftAgentConfig() {
        return getGiftAgentConfig();
    }

    @Override // com.bytedance.android.livesdk.gift.platform.core.model.u
    public /* bridge */ /* synthetic */ m getGiftSearchConfig() {
        return getGiftSearchConfig();
    }

    @Override // com.bytedance.android.livesdk.gift.platform.core.model.u
    public final g getExtraParam() {
        return this._$$extraParam;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.core.model.u
    public final List<Long> getFansClubIds() {
        return this._$$fansClubIds;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.core.model.u
    public final long getFastGiftId() {
        return this._$$fastGiftId;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.core.model.u
    public final long getFirstChargeSpeedyGiftId() {
        return this._$$firstChargeSpeedyGiftId;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.core.model.u
    public final List<e> getGiftComboInfoList() {
        return this._$$giftComboInfoList;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.core.model.u
    public py.k getGiftEntranceIcon() {
        return this.giftEntranceIcon;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.core.model.u
    public final List<h> getGroupCountInfo() {
        return this._$$groupCountInfo;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.core.model.u
    public final List<Long> getHonorLevelGiftIds() {
        return this._$$honorLevelGiftIds;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.core.model.u
    public final Map<String, String> getMsgProcessFilter() {
        return this._$$msgProcessFilter;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.core.model.u
    public final long getNewGiftId() {
        return this._$$newGiftId;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.core.model.u
    public final String getNewGiftTip() {
        return this._$$newGiftTip;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.core.model.u
    public final List<Long> getNobleGiftIds() {
        return this._$$nobleGiftIds;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.core.model.u
    public final e0 getSpeedyGiftPopupInfo() {
        return this._$$speedyGiftPopupInfo;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.core.model.u
    public final GiftAgentConfigFlexImpl getGiftAgentConfig() {
        return this._$$giftAgentConfig;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.core.model.u
    public final GiftSearchConfigFlexImpl getGiftSearchConfig() {
        return this._$$giftSearchConfig;
    }

    /* JADX WARN: Type inference failed for: r2v10, types: [java.lang.Object, py.k] */
    public IGiftsInfoFlexImpl(am3.g r11) {
        super(u.class);
        this._$$groupCountInfo = new ArrayList();
        this._$$fansClubIds = new ArrayList();
        this._$$honorLevelGiftIds = new ArrayList();
        this._$$nobleGiftIds = new ArrayList();
        this._$$giftComboInfoList = new ArrayList();
        this._$$msgProcessFilter = new HashMap();
        setThreadSafe(false);
        long r0 = r11.c();
    L3:
        int r2 = r11.f();
        if (r2 == (-1)) goto L41;
        am3.g.a r5 = decodeExtensionFields(r2, r11);
        switch(r2) {
            case 1: goto L40;
            case 2: goto L37;
            case 3: goto L36;
            case 4: goto L35;
            case 5: goto L34;
            case 6: goto L7;
            case 7: goto L33;
            case 8: goto L7;
            case 9: goto L32;
            case 10: goto L7;
            case 11: goto L31;
            case 12: goto L7;
            case 13: goto L30;
            case 14: goto L29;
            case 15: goto L28;
            case 16: goto L11;
            case 17: goto L10;
            case 18: goto L9;
            case 19: goto L8;
            default: goto L7;
        };
    L8:
        this._$$giftAgentConfig = new GiftAgentConfigFlexImpl(r11);
        goto L3
    L9:
        this._$$giftSearchConfig = new GiftSearchConfigFlexImpl(r11);
        goto L3
    L10:
        this._$$extraParam = new g(r11);
        goto L3
    L11:
        long r6 = r11.c();
        String r3 = null;
        String r7 = null;
    L12:
        int r8 = r11.f();
        if (r8 == (-1)) goto L20;
        if (r8 != 1) goto L16;
        r3 = am3.h.c(r11);
        goto L12
    L16:
        if (r8 != 2) goto L17;
        r7 = am3.h.c(r11);
        goto L12
    L17:
        am3.h.e(r11);
        goto L12
    L20:
        r11.d(r6);
        Map<String, String> r4 = this._$$msgProcessFilter;
        if (r3 == null) goto L27;
        if (r7 == null) goto L25;
        r4.put(r3, r7);
        goto L3
    L25:
        throw new IllegalStateException("Value must not be null");
    L27:
        throw new IllegalStateException("Key must not be null");
    L28:
        this._$$firstChargeSpeedyGiftId = r11.j();
        goto L3
    L29:
        this._$$speedyGiftPopupInfo = new e0(r11);
        goto L3
    L30:
        List r9 = this._$$giftComboInfoList;
        vh7.h r10 = new e(r11);
    L39:
        r9.add(r10);
        goto L3
    L31:
        this.giftEntranceIcon = vh7.f.a(r11, py.k.class);
        goto L3
    L32:
        r9 = this._$$nobleGiftIds;
    L38:
        r10 = Long.valueOf(r11.j());
        goto L39
    L33:
        r9 = this._$$honorLevelGiftIds;
        goto L38
    L34:
        r9 = this._$$groupCountInfo;
        r10 = new h(r11);
        goto L39
    L35:
        this._$$newGiftTip = am3.h.c(r11);
        goto L3
    L36:
        this._$$fastGiftId = r11.j();
        goto L3
    L37:
        r9 = this._$$fansClubIds;
        goto L38
    L40:
        this._$$newGiftId = r11.j();
        goto L3
    L7:
        am3.h.d(r5, r11);
        goto L3
    L41:
        r11.d(r0);
        setThreadSafe(true);
        if (this._$$groupCountInfo.isEmpty() == false) goto L45;
        this._$$groupCountInfo = $defaultValue_groupCountInfo$();
    L45:
        if (this._$$fansClubIds.isEmpty() == false) goto L48;
        this._$$fansClubIds = $defaultValue_fansClubIds$();
    L48:
        if (this._$$newGiftTip != null) goto L51;
        this._$$newGiftTip = BuildConfig.FLAVOR;
    L51:
        if (this._$$honorLevelGiftIds.isEmpty() == false) goto L54;
        this._$$honorLevelGiftIds = $defaultValue_honorLevelGiftIds$();
    L54:
        if (this._$$nobleGiftIds.isEmpty() == false) goto L57;
        this._$$nobleGiftIds = $defaultValue_nobleGiftIds$();
    L57:
        if (this._$$giftComboInfoList.isEmpty() == false) goto L60;
        this._$$giftComboInfoList = $defaultValue_giftComboInfoList$();
    L60:
        if (this._$$msgProcessFilter != null) goto L104;
        this._$$msgProcessFilter = $defaultValue_msgProcessFilter$();
        return;
    }

    public void setGiftEntranceIcon(py.k r1) {
        this.giftEntranceIcon = r1;
    }
}
