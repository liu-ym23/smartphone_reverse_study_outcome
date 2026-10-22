package com.bytedance.android.livesdk.config;

import com.bytedance.android.livesdk.feed.services.AppointmentService;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b!\u0010\"R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0011\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\"\u0010\u0017\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0012\u001a\u0004\b\u0018\u0010\u0014\"\u0004\b\u0019\u0010\u0016R\"\u0010\u001b\u001a\u00020\u001a8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 ¨\u0006#"}, d2 = {"Lcom/bytedance/android/livesdk/config/b71;", "", "", "enable", "Z", "a", "()Z", "setEnable", "(Z)V", "", "timeout", "J", "getTimeout", "()J", "setTimeout", "(J)V", "", "maxScale", "I", "getMaxScale", "()I", "setMaxScale", "(I)V", "imagePickerType", "getImagePickerType", "setImagePickerType", "", "schema", "Ljava/lang/String;", "getSchema", "()Ljava/lang/String;", "setSchema", "(Ljava/lang/String;)V", "<init>", "()V", "liveutility_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class b71 {

    @SerializedName("enable")
    private boolean enable;

    @SerializedName("image_picker_type")
    private int imagePickerType;

    @SerializedName("max_scale")
    private int maxScale;

    @SerializedName("schema")
    private String schema;

    @SerializedName("timeout")
    private long timeout;

    public b71() {
        this.timeout = AppointmentService.SOURCE_UNDEFINED;
        this.maxScale = 5;
        this.imagePickerType = 1;
        this.schema = "sslocal://webcast_lynxview?type=popup&hide_nav_bar=1&hide_status_bar=1&gravity=bottom&height=600&enable_latch=1&url=https://lf-webcast-gr-sourcecdn.bytegecko.com/obj/byte-gurd-source-gr/webcast/mono/lynx/community_openlive_douyin/pages/apply_live_permission_platform/template.js";
    }

    public final boolean a() {
        return this.enable;
    }
}
