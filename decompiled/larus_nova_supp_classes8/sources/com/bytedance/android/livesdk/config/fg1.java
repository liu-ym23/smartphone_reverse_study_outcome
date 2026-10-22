package com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u000f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b!\u0010\"R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0010\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR*\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\"\u0010\u001b\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u000b\u001a\u0004\b\u001c\u0010\r\"\u0004\b\u001d\u0010\u000fR\"\u0010\u001e\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u000b\u001a\u0004\b\u001f\u0010\r\"\u0004\b \u0010\u000f¨\u0006#"}, d2 = {"Lcom/bytedance/android/livesdk/config/fg1;", "", "", "innerPreEnterConfig", "I", "d", "()I", "setInnerPreEnterConfig", "(I)V", "", "enableLogCallbackListenerHighPriority", "Z", "a", "()Z", "setEnableLogCallbackListenerHighPriority", "(Z)V", "innerPreEnterOpt", "e", "setInnerPreEnterOpt", "", "", "preEnterScene", "Ljava/util/List;", "f", "()Ljava/util/List;", "setPreEnterScene", "(Ljava/util/List;)V", "enableSplitBackendRequest", "b", "setEnableSplitBackendRequest", "enableUpdatePreEnterInfo", "c", "setEnableUpdatePreEnterInfo", "<init>", "()V", "liveutility_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class fg1 {

    @SerializedName("enable_log_callback_listener_high_priority")
    private boolean enableLogCallbackListenerHighPriority;

    @SerializedName("enable_split_backend_request")
    private boolean enableSplitBackendRequest;

    @SerializedName("enable_update_pre_enter_info")
    private boolean enableUpdatePreEnterInfo;

    @SerializedName("inner_pre_enter_config")
    private int innerPreEnterConfig;

    @SerializedName("inner_pre_enter_opt")
    private boolean innerPreEnterOpt;

    @SerializedName("pre_enter_scene")
    private List<String> preEnterScene;

    public fg1() {
        this.preEnterScene = new ArrayList();
    }

    public final boolean a() {
        return this.enableLogCallbackListenerHighPriority;
    }

    public final boolean b() {
        return this.enableSplitBackendRequest;
    }

    public final boolean c() {
        return this.enableUpdatePreEnterInfo;
    }

    public final int d() {
        return this.innerPreEnterConfig;
    }

    public final boolean e() {
        return this.innerPreEnterOpt;
    }

    public final List<String> f() {
        return this.preEnterScene;
    }
}
