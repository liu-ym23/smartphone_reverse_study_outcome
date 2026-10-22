package com.bytedance.android.livesdk.interactivity.api.settings.config;

import com.bytedance.bdlocation.BuildConfig;
import com.google.gson.annotations.SerializedName;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\f\u0018\u00002\u00020\u0001:\u0001\fB\u0007¢\u0006\u0004\b\u0013\u0010\u0014R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0010\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0004\u001a\u0004\b\u0011\u0010\u0006\"\u0004\b\u0012\u0010\b¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/settings/config/PSHighlightCommonConfig;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "enable", "Z", "b", "()Z", "setEnable", "(Z)V", BuildConfig.FLAVOR, "defaultShowDuration", "J", "a", "()J", "setDefaultShowDuration", "(J)V", "enableMsgOperate", "c", "setEnableMsgOperate", "<init>", "()V", "interactivity-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PSHighlightCommonConfig {
    public static final Lazy a = null;
    public static final a b = null;

    @SerializedName("default_show_duration_ms")
    private long defaultShowDuration;

    @SerializedName("enable")
    private boolean enable;

    @SerializedName("enable_msg_operate")
    private boolean enableMsgOperate;

    public static final class a {
        public a() {
        }
    }

    static {
        b = new a();
        a = LazyKt.lazy(PSHighlightCommonConfig$Companion$setting$2.INSTANCE);
    }

    public PSHighlightCommonConfig() {
        this.defaultShowDuration = 300000;
        this.enableMsgOperate = true;
    }

    public final long a() {
        return this.defaultShowDuration;
    }

    public final boolean b() {
        return this.enable;
    }

    public final boolean c() {
        return this.enableMsgOperate;
    }
}
