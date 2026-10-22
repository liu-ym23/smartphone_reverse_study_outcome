package com.bytedance.android.livesdk.gift.platform.core.setting;

import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import java.lang.reflect.Constructor;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import m12.a;
import m12.c;
import vh7.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001:\u0001\u001cB\u0007¢\u0006\u0004\b\u001a\u0010\u001bR\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR \u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00070\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R \u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u000e\u001a\u0004\b\u0013\u0010\u0010R\u001a\u0010\u0015\u001a\u00020\u00148\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0019\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u0004\u001a\u0004\b\u0019\u0010\u0006¨\u0006\u001d"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/core/setting/HarmonyGiftPanelSettingSerializableObjectImpl;", "Lm12/c;", BuildConfig.FLAVOR, "enable", "Z", "getEnable", "()Z", BuildConfig.FLAVOR, "scheme", "Ljava/lang/String;", "getScheme", "()Ljava/lang/String;", BuildConfig.FLAVOR, "disableDiyCardList", "Ljava/util/List;", "getDisableDiyCardList", "()Ljava/util/List;", BuildConfig.FLAVOR, "disableBuffCardList", "getDisableBuffCardList", "Lm12/a;", "bannerOpenSchemaConfig", "Lm12/a;", "getBannerOpenSchemaConfig", "()Lm12/a;", "isSupportPersonSelection", "<init>", "()V", "Adapter", "livegift-kmp-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class HarmonyGiftPanelSettingSerializableObjectImpl implements c {

    @SerializedName("banner_open_schema_config")
    private final a bannerOpenSchemaConfig;

    @SerializedName("disable_buff_card_id_list")
    private final List<Integer> disableBuffCardList;

    @SerializedName("disable_diy_card_name_list")
    private final List<String> disableDiyCardList;

    @SerializedName("enable")
    private final boolean enable;

    @SerializedName("support_person_selection")
    private final boolean isSupportPersonSelection;

    @SerializedName("scheme")
    private final String scheme;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/core/setting/HarmonyGiftPanelSettingSerializableObjectImpl$Adapter;", "Lcom/bytedance/tools/kcp/modelx/runtime/internal/decode/SerializableObjectJsonAdapterBase;", "()V", "livegift-kmp-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class Adapter extends SerializableObjectJsonAdapterBase {
        public Adapter() {
            super(HarmonyGiftPanelSettingSerializableObjectImpl.class);
        }
    }

    public HarmonyGiftPanelSettingSerializableObjectImpl() {
        this.enable = false;
        this.scheme = "sslocal://webcast_lynxview?url=https%3A%2F%2Flf-webcast-gr-sourcecdn.bytegecko.com%2Fobj%2Fbyte-gurd-source-gr%2Fwebcast%2Fmono%2Flynx%2Frevenue_gift_panel_harmony%2Fpages%2Fgift_dynamic_panel%2Ftemplate.js&container_bg_color=%2300000000&type=popup&gravity=bottom&horizontal_width=375&height_percent=100&settings_keys=live_gift_harmony_gift_panel_config&aio_params=%7B%0A%20%20%20%20%22rpcs%22%3A%20%7B%0A%20%20%20%20%20%20%20%20%22panel_init_data%22%20%3A%20%7B%0A%20%20%20%20%20%20%20%20%20%20%20%20%22id%22%20%3A%20%22webcast.revenue.biz.gift.kmp.dialog.ShowGiftDialogDataUseCase.GetInitialPanelInfo%22%2C%0A%20%20%20%20%20%20%20%20%20%20%20%20%22param_names%22%20%3A%20%5B%5D%0A%20%20%20%20%20%20%20%20%7D%0A%20%20%20%20%7D%0A%7D";
        this.disableDiyCardList = CollectionsKt.emptyList();
        this.disableBuffCardList = CollectionsKt.emptyList();
        Class r1 = a.class.getAnnotation(JsonAdapter.class).value();
        ConcurrentHashMap r2 = b.a;
        Object r3 = r2.get(r1);
        if (r3 != null) goto L12;
        r3 = r1.getConstructor(new Class[0]);
        if (r3 == null) goto L11;
        Object r4 = r2.putIfAbsent(r1, r3);
        if (r4 == null) goto L12;
        r3 = r4;
        goto L12
    L11:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.reflect.Constructor<out com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase>");
    L12:
        Object r0 = ((SerializableObjectJsonAdapterBase) ((Constructor) r3).newInstance(new Object[0])).createInstance();
        if (r0 == null) goto L17;
        this.bannerOpenSchemaConfig = (a) r0;
        this.isSupportPersonSelection = true;
        return;
    L17:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.gift.platform.core.setting.GiftPanelBannerOpenSchemaConfig");
    }
}
