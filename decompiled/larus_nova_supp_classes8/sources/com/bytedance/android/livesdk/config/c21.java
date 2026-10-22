package com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0015\n\u0002\u0010\b\n\u0002\b\u0015\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b+\u0010,R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\"\u0010\u000f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\"\u0010\u0012\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0004\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR\"\u0010\u0015\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0004\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\bR\"\u0010\u0019\u001a\u00020\u00188\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\"\u0010\u001f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010\u0004\u001a\u0004\b \u0010\u0006\"\u0004\b!\u0010\bR\"\u0010\"\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\"\u0010\u0004\u001a\u0004\b#\u0010\u0006\"\u0004\b$\u0010\bR\"\u0010%\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b%\u0010\u0004\u001a\u0004\b&\u0010\u0006\"\u0004\b'\u0010\bR\"\u0010(\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b(\u0010\u0004\u001a\u0004\b)\u0010\u0006\"\u0004\b*\u0010\b¨\u0006-"}, d2 = {"Lcom/bytedance/android/livesdk/config/c21;", "", "", "enable", "Z", "a", "()Z", "setEnable", "(Z)V", "live_trigger_switch", "j", "setLive_trigger_switch", "live_switch_with_open", "i", "setLive_switch_with_open", "live_multi_room_switch", "f", "setLive_multi_room_switch", "live_room_toast", "g", "setLive_room_toast", "live_scene_dialog", "h", "setLive_scene_dialog", "", "pool_network_time", "I", "k", "()I", "setPool_network_time", "(I)V", "enable_multi_path", "c", "setEnable_multi_path", "enable_trigger_notify", "e", "setEnable_trigger_notify", "enable_preview_multi_path", "d", "setEnable_preview_multi_path", "enable_live_permission_push", "b", "setEnable_live_permission_push", "<init>", "()V", "liveutility_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class c21 {

    @SerializedName("enable")
    private boolean enable;

    @SerializedName("enable_live_permission_push")
    private boolean enable_live_permission_push;

    @SerializedName("enable_multi_path")
    private boolean enable_multi_path;

    @SerializedName("enable_preview_multi_path")
    private boolean enable_preview_multi_path;

    @SerializedName("enable_trigger_notify")
    private boolean enable_trigger_notify;

    @SerializedName("live_multi_room_switch")
    private boolean live_multi_room_switch;

    @SerializedName("live_room_toast")
    private boolean live_room_toast;

    @SerializedName("live_scene_dialog")
    private boolean live_scene_dialog;

    @SerializedName("live_switch_with_open")
    private boolean live_switch_with_open;

    @SerializedName("multi_room_switch")
    private boolean live_trigger_switch;

    @SerializedName("pool_network_time")
    private int pool_network_time;

    public c21() {
    }

    public final String toString() {
        return "LiveCellularConfig[enable:" + this.enable + ",multi_room_switch:" + this.live_trigger_switch + ",live_multi_room_switch:" + this.live_multi_room_switch + ",live_room_toast:" + this.live_room_toast + ']';
    }

    public final boolean a() {
        return this.enable;
    }

    public final boolean b() {
        return this.enable_live_permission_push;
    }

    public final boolean c() {
        return this.enable_multi_path;
    }

    public final boolean d() {
        return this.enable_preview_multi_path;
    }

    public final boolean e() {
        return this.enable_trigger_notify;
    }

    public final boolean f() {
        return this.live_multi_room_switch;
    }

    public final boolean g() {
        return this.live_room_toast;
    }

    public final boolean h() {
        return this.live_scene_dialog;
    }

    public final boolean i() {
        return this.live_switch_with_open;
    }

    public final boolean j() {
        return this.live_trigger_switch;
    }

    public final int k() {
        return this.pool_network_time;
    }
}
