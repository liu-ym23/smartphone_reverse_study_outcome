package com.bytedance.android.live.broadcast.api.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@ProtoMessage("webcast.api.room.CreateInfoResponse.ConfigInfo")
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\n\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0006\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0016\u0010\b\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\b\u0010\u0004R\u0016\u0010\t\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\t\u0010\u0007R\u0016\u0010\n\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\n\u0010\u0004R\u0016\u0010\u000b\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\u0007R\u0016\u0010\r\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\"\u0010\u000f\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0007\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/live/broadcast/api/model/u;", "", "", "pcLiveLynxSchema", "Ljava/lang/String;", "", "supportBothMiniAppAndCommerce", "Z", "redEnvelopeSchema", "showRedEnvelope", "customServiceSchema", "cameraDirectorNeedPolling", "", "morePanelStyle", "I", "ecomNewLiveMutexMountSwitch", "getEcomNewLiveMutexMountSwitch", "()Z", "setEcomNewLiveMutexMountSwitch", "(Z)V", "<init>", "()V", "livebroadcast-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class u implements vh7.h {

    @SerializedName("camera_director_need_polling")
    public boolean cameraDirectorNeedPolling;

    @SerializedName("customer_service_schema")
    public String customServiceSchema;

    @SerializedName("ecom_new_live_mutex_mount_switch")
    protected boolean ecomNewLiveMutexMountSwitch;

    @SerializedName("more_panel_style")
    public int morePanelStyle;

    @SerializedName("pc_live_lynx_schema")
    public String pcLiveLynxSchema;

    @SerializedName("red_envelope_schema")
    public String redEnvelopeSchema;

    @SerializedName("show_red_envelope")
    public boolean showRedEnvelope;

    @SerializedName("support_micro_app_new_slot")
    public boolean supportBothMiniAppAndCommerce;

    public u() {
        this.pcLiveLynxSchema = "";
        this.redEnvelopeSchema = "";
        this.customServiceSchema = "";
    }

    public u(am3.g r5) {
        long r0 = r5.c();
    L3:
        int r2 = r5.f();
        if (r2 == (-1)) goto L15;
        switch(r2) {
            case 1: goto L14;
            case 2: goto L13;
            case 3: goto L6;
            case 4: goto L12;
            case 5: goto L11;
            case 6: goto L10;
            case 7: goto L6;
            case 8: goto L6;
            case 9: goto L9;
            case 10: goto L8;
            case 11: goto L7;
            default: goto L6;
        };
    L7:
        this.ecomNewLiveMutexMountSwitch = am3.h.a(r5);
        goto L3
    L8:
        this.morePanelStyle = r5.i();
        goto L3
    L9:
        this.cameraDirectorNeedPolling = am3.h.a(r5);
        goto L3
    L10:
        this.redEnvelopeSchema = am3.h.c(r5);
        goto L3
    L11:
        this.showRedEnvelope = am3.h.a(r5);
        goto L3
    L12:
        this.customServiceSchema = am3.h.c(r5);
        goto L3
    L13:
        this.pcLiveLynxSchema = am3.h.c(r5);
        goto L3
    L14:
        this.supportBothMiniAppAndCommerce = am3.h.a(r5);
        goto L3
    L6:
        am3.h.e(r5);
        goto L3
    L15:
        r5.d(r0);
        if (this.pcLiveLynxSchema != null) goto L19;
        this.pcLiveLynxSchema = "";
    L19:
        if (this.redEnvelopeSchema != null) goto L22;
        this.redEnvelopeSchema = "";
    L22:
        if (this.customServiceSchema != null) goto L45;
        this.customServiceSchema = "";
        return;
    }
}
