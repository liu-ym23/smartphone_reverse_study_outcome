package com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b'\u0010(R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0010\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR\"\u0010\u0013\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0004\u001a\u0004\b\u0014\u0010\u0006\"\u0004\b\u0015\u0010\bR\"\u0010\u0016\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0004\u001a\u0004\b\u0017\u0010\u0006\"\u0004\b\u0018\u0010\bR\"\u0010\u001a\u001a\u00020\u00198\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR*\u0010!\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010 8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&¨\u0006)"}, d2 = {"Lcom/bytedance/android/livesdk/config/d91;", "", "", "enable", "Z", "a", "()Z", "setEnable", "(Z)V", "", "localPageIp", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "setLocalPageIp", "(Ljava/lang/String;)V", "channel", "getChannel", "setChannel", "useTextureView", "getUseTextureView", "setUseTextureView", "needLowLatency", "getNeedLowLatency", "setNeedLowLatency", "", "seiTimeFps", "J", "getSeiTimeFps", "()J", "setSeiTimeFps", "(J)V", "", "virtualGiftList", "Ljava/util/List;", "c", "()Ljava/util/List;", "setVirtualGiftList", "(Ljava/util/List;)V", "<init>", "()V", "liveutility_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class d91 {

    @SerializedName("channel")
    private String channel;

    @SerializedName("enable")
    private boolean enable;

    @SerializedName("local_page_ip")
    private String localPageIp;

    @SerializedName("need_low_latency")
    private boolean needLowLatency;

    @SerializedName("sei_time_fps")
    private long seiTimeFps;

    @SerializedName("use_textureView")
    private boolean useTextureView;

    @SerializedName("virtual_gift_list")
    private List<Long> virtualGiftList;

    public d91() {
        this.enable = true;
        this.localPageIp = "";
        this.channel = "";
        this.useTextureView = true;
        this.needLowLatency = true;
        this.seiTimeFps = 2000;
        this.virtualGiftList = CollectionsKt.listOf(new Long[]{11650L, 11651L, 11741L, 11779L, 11790L, 2002L, 164L});
    }

    public final boolean a() {
        return this.enable;
    }

    public final String b() {
        return this.localPageIp;
    }

    public final List<Long> c() {
        return this.virtualGiftList;
    }
}
