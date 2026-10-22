package com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u001b\n\u0002\u0010\b\n\u0002\b\u000f\u0018\u00002\u00020\u0001:\u0001!B\u0007¢\u0006\u0004\b+\u0010,R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\"\u0010\u000f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\"\u0010\u0012\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0004\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR\"\u0010\u0015\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0004\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\bR\"\u0010\u0018\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0004\u001a\u0004\b\u0019\u0010\u0006\"\u0004\b\u001a\u0010\bR\"\u0010\u001b\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u0004\u001a\u0004\b\u001c\u0010\u0006\"\u0004\b\u001d\u0010\bR\"\u0010\u001f\u001a\u00020\u001e8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\"\u0010%\u001a\u00020\u001e8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b%\u0010 \u001a\u0004\b&\u0010\"\"\u0004\b'\u0010$R\"\u0010(\u001a\u00020\u001e8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b(\u0010 \u001a\u0004\b)\u0010\"\"\u0004\b*\u0010$¨\u0006-"}, d2 = {"Lcom/bytedance/android/livesdk/config/s31;", "", "", "enable", "Z", "e", "()Z", "setEnable", "(Z)V", "enableDebug", "f", "setEnableDebug", "enableDeviceMem", "g", "setEnableDeviceMem", "disableOldGcCollect", "c", "setDisableOldGcCollect", "disableOldMemCollect", "d", "setDisableOldMemCollect", "enableNewMemCollect", "i", "setEnableNewMemCollect", "enableFilterPutParam", "h", "setEnableFilterPutParam", "gcListenerAsync", "k", "setGcListenerAsync", "", "detailMemInterval", "I", "a", "()I", "setDetailMemInterval", "(I)V", "firstDetailMemInfoDelay", "j", "setFirstDetailMemInfoDelay", "disableFlags", "b", "setDisableFlags", "<init>", "()V", "liveutility_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class s31 {
    public static final s31 a = null;

    @SerializedName("detail_mem_info_interval")
    private int detailMemInterval;

    @SerializedName("disable_flags")
    private int disableFlags;

    @SerializedName("disable_old_gc_collect")
    private boolean disableOldGcCollect;

    @SerializedName("disable_old_mem_collect")
    private boolean disableOldMemCollect;

    @SerializedName("enable")
    private boolean enable;

    @SerializedName("enable_debug")
    private boolean enableDebug;

    @SerializedName("enable_device_mem")
    private boolean enableDeviceMem;

    @SerializedName("enable_filter_put_param")
    private boolean enableFilterPutParam;

    @SerializedName("enable_new_mem_collect")
    private boolean enableNewMemCollect;

    @SerializedName("first_detail_mem_info_delay")
    private int firstDetailMemInfoDelay;

    @SerializedName("gc_listener_async")
    private boolean gcListenerAsync;

    public static final class a {
    }

    static {
        a = new s31();
    }

    public s31() {
        this.enableDeviceMem = true;
        this.disableOldGcCollect = true;
        this.enableFilterPutParam = true;
        this.gcListenerAsync = true;
        this.detailMemInterval = 300000;
        this.firstDetailMemInfoDelay = 60000;
    }

    public final int a() {
        return this.detailMemInterval;
    }

    public final int b() {
        return this.disableFlags;
    }

    public final boolean c() {
        return this.disableOldGcCollect;
    }

    public final boolean d() {
        return this.disableOldMemCollect;
    }

    public final boolean e() {
        return this.enable;
    }

    public final boolean f() {
        return this.enableDebug;
    }

    public final boolean g() {
        return this.enableDeviceMem;
    }

    public final boolean h() {
        return this.enableFilterPutParam;
    }

    public final boolean i() {
        return this.enableNewMemCollect;
    }

    public final int j() {
        return this.firstDetailMemInfoDelay;
    }

    public final boolean k() {
        return this.gcListenerAsync;
    }
}
