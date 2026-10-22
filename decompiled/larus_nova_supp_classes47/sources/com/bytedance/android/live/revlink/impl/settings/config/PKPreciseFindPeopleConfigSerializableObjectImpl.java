package com.bytedance.android.live.revlink.impl.settings.config;

import com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import r41.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u000e\u0018\u00002\u00020\u0001:\u0001\u001aB\u0007¢\u0006\u0004\b\u0018\u0010\u0019R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001a\u0010\t\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001a\u0010\u000b\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u000f\u001a\u0004\b\u0013\u0010\u0011R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u000f\u001a\u0004\b\u0015\u0010\u0011R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u000f\u001a\u0004\b\u0017\u0010\u0011¨\u0006\u001b"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/settings/config/PKPreciseFindPeopleConfigSerializableObjectImpl;", "Lr41/h;", "", "enable", "Z", "getEnable", "()Z", "supportAudio", "Y3", "preciseMatchInviteInterceptErrorToast", "v5", "updatePkTopTabPadding", "n9", "", "findPeopleSettingPanelSchema", "Ljava/lang/String;", "V4", "()Ljava/lang/String;", "findPeopleSettingPanelUrl", "f6", "findPeopleInvitePanelSchema", "S6", "findPeopleInvitePanelUrl", "Y8", "<init>", "()V", "Adapter", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class PKPreciseFindPeopleConfigSerializableObjectImpl implements h {

    @SerializedName("enable")
    private final boolean enable;

    @SerializedName("find_people_invite_panel_schema")
    private final String findPeopleInvitePanelSchema;

    @SerializedName("find_people_invite_panel_url")
    private final String findPeopleInvitePanelUrl;

    @SerializedName("find_people_setting_panel_schema")
    private final String findPeopleSettingPanelSchema;

    @SerializedName("find_people_setting_panel_url")
    private final String findPeopleSettingPanelUrl;

    @SerializedName("precise_match_invite_intercept_error_toast")
    private final boolean preciseMatchInviteInterceptErrorToast;

    @SerializedName("support_audio")
    private final boolean supportAudio;

    @SerializedName("update_pk_top_tab_padding")
    private final boolean updatePkTopTabPadding;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/settings/config/PKPreciseFindPeopleConfigSerializableObjectImpl$Adapter;", "Lcom/bytedance/tools/kcp/modelx/runtime/internal/decode/SerializableObjectJsonAdapterBase;", "()V", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class Adapter extends SerializableObjectJsonAdapterBase {
        public Adapter() {
            super(PKPreciseFindPeopleConfigSerializableObjectImpl.class);
        }
    }

    public PKPreciseFindPeopleConfigSerializableObjectImpl() {
        this.enable = false;
        this.supportAudio = false;
        this.preciseMatchInviteInterceptErrorToast = true;
        this.updatePkTopTabPadding = true;
        this.findPeopleSettingPanelSchema = "sslocal://webcast_lynxview?gravity=bottom&type=popup&height=569&radius=20";
        this.findPeopleSettingPanelUrl = "https://lf-webcast-gr-sourcecdn.bytegecko.com/obj/byte-gurd-source-gr/webcast/mono/lynx/revenue_pk_panel_lynx_douyin/pages/precise_match_setting/template.js";
        this.findPeopleInvitePanelSchema = "sslocal://webcast_lynxview?gravity=bottom&type=popup&height=580&radius=8&business_type=link_control_center&group=link_control_center";
        this.findPeopleInvitePanelUrl = "https://lf-webcast-gr-sourcecdn.bytegecko.com/obj/byte-gurd-source-gr/webcast/mono/lynx/revenue_pk_panel_lynx_douyin/pages/precise_match_invite/template.js";
    }

    @Override // r41.h
    public final String S6() {
        return this.findPeopleInvitePanelSchema;
    }

    @Override // r41.h
    public final String V4() {
        return this.findPeopleSettingPanelSchema;
    }

    @Override // r41.h
    public final boolean Y3() {
        return this.supportAudio;
    }

    @Override // r41.h
    public final String Y8() {
        return this.findPeopleInvitePanelUrl;
    }

    @Override // r41.h
    public final String f6() {
        return this.findPeopleSettingPanelUrl;
    }

    @Override // r41.h
    public final boolean getEnable() {
        return this.enable;
    }

    @Override // r41.h
    public final boolean n9() {
        return this.updatePkTopTabPadding;
    }

    @Override // r41.h
    public final boolean v5() {
        return this.preciseMatchInviteInterceptErrorToast;
    }
}
