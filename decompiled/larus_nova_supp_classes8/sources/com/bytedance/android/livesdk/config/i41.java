package com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0015\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b$\u0010%R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR(\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\"\u0010\u0018\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0004\u001a\u0004\b\u0019\u0010\u0006\"\u0004\b\u001a\u0010\bR\"\u0010\u001b\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u0004\u001a\u0004\b\u001c\u0010\u0006\"\u0004\b\u001d\u0010\bR(\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00110\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u0013\u001a\u0004\b\u001f\u0010\u0015\"\u0004\b \u0010\u0017R\"\u0010!\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b!\u0010\u0004\u001a\u0004\b\"\u0010\u0006\"\u0004\b#\u0010\b¨\u0006&"}, d2 = {"Lcom/bytedance/android/livesdk/config/i41;", "", "", "preloadEnable", "Z", "getPreloadEnable", "()Z", "setPreloadEnable", "(Z)V", "", "footStyle", "I", "c", "()I", "setFootStyle", "(I)V", "", "", "supportEntrances", "Ljava/util/List;", "f", "()Ljava/util/List;", "setSupportEntrances", "(Ljava/util/List;)V", "debugToast", "a", "setDebugToast", "preloadEnableV2", "d", "setPreloadEnableV2", "preloadSupportEntrances", "e", "setPreloadSupportEntrances", "enterVideoIdFix", "b", "setEnterVideoIdFix", "<init>", "()V", "liveutility_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class i41 {

    @SerializedName("debug_toast")
    private boolean debugToast;

    @SerializedName("enter_video_id_fix")
    private boolean enterVideoIdFix;

    @SerializedName("style")
    private int footStyle;

    @SerializedName("preload_enable")
    private boolean preloadEnable;

    @SerializedName("preload_enable_v2")
    private boolean preloadEnableV2;

    @SerializedName("preload_support_entrances")
    private List<String> preloadSupportEntrances;

    @SerializedName("support_entrances")
    private List<String> supportEntrances;

    public i41() {
        this.supportEntrances = CollectionsKt.emptyList();
        this.preloadSupportEntrances = CollectionsKt.emptyList();
    }

    public final boolean a() {
        return this.debugToast;
    }

    public final boolean b() {
        return this.enterVideoIdFix;
    }

    public final int c() {
        return this.footStyle;
    }

    public final boolean d() {
        return this.preloadEnableV2;
    }

    public final List<String> e() {
        return this.preloadSupportEntrances;
    }

    public final List<String> f() {
        return this.supportEntrances;
    }
}
