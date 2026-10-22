package com.bytedance.ies.bullet.base.settings;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R$\u0010\u000b\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR$\u0010\u0012\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R$\u0010\u0019\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R$\u0010 \u001a\u0004\u0018\u00010\u001a8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u0005\u0010\u001d\"\u0004\b\u001e\u0010\u001fR$\u0010'\u001a\u0004\u0018\u00010!8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b\u001b\u0010$\"\u0004\b%\u0010&R$\u0010/\u001a\u0004\u0018\u00010(8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.¨\u00060"}, d2 = {"Lcom/bytedance/ies/bullet/base/settings/m;", "", "<init>", "()V", "Lcom/bytedance/ies/bullet/base/settings/f;", "a", "Lcom/bytedance/ies/bullet/base/settings/f;", "b", "()Lcom/bytedance/ies/bullet/base/settings/f;", "setJsbAuthStrategySettingConfig", "(Lcom/bytedance/ies/bullet/base/settings/f;)V", "jsbAuthStrategySettingConfig", "Lcom/bytedance/ies/bullet/base/settings/h;", "Lcom/bytedance/ies/bullet/base/settings/h;", "c", "()Lcom/bytedance/ies/bullet/base/settings/h;", "setLynxSignVerifyStrategyConfig", "(Lcom/bytedance/ies/bullet/base/settings/h;)V", "lynxSignVerifyStrategyConfig", "Lcom/bytedance/ies/bullet/base/settings/l;", "Lcom/bytedance/ies/bullet/base/settings/l;", "getSecLinkConfig", "()Lcom/bytedance/ies/bullet/base/settings/l;", "setSecLinkConfig", "(Lcom/bytedance/ies/bullet/base/settings/l;)V", "secLinkConfig", "Lcom/bytedance/ies/bullet/base/settings/e;", "d", "Lcom/bytedance/ies/bullet/base/settings/e;", "()Lcom/bytedance/ies/bullet/base/settings/e;", "setGeckoLoaderSecureConfig", "(Lcom/bytedance/ies/bullet/base/settings/e;)V", "geckoLoaderSecureConfig", "Lcom/bytedance/ies/bullet/base/settings/k;", "e", "Lcom/bytedance/ies/bullet/base/settings/k;", "()Lcom/bytedance/ies/bullet/base/settings/k;", "setMonitorConfig", "(Lcom/bytedance/ies/bullet/base/settings/k;)V", "monitorConfig", "Lcom/bytedance/ies/bullet/base/settings/LegacyWebcastConfig;", "f", "Lcom/bytedance/ies/bullet/base/settings/LegacyWebcastConfig;", "getWebcastConfig", "()Lcom/bytedance/ies/bullet/base/settings/LegacyWebcastConfig;", "setWebcastConfig", "(Lcom/bytedance/ies/bullet/base/settings/LegacyWebcastConfig;)V", "webcastConfig", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("jsb_auth")
    private f f5219a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @SerializedName("lynx_sign_verify")
    private h f5220b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @SerializedName("sec_link")
    private l f5221c;

    @SerializedName("gecko_loader_secure")
    private e d;

    @SerializedName("monitor_config")
    private k e;

    @SerializedName("legacy_webcast")
    private LegacyWebcastConfig f;

    public m() {
        this.f5219a = new f();
        this.f5220b = new h();
        this.f5221c = new l();
        this.d = new e();
        this.e = new k();
        this.f = new LegacyWebcastConfig();
    }

    public final e a() {
        return this.d;
    }

    public final f b() {
        return this.f5219a;
    }

    public final h c() {
        return this.f5220b;
    }

    public final k d() {
        return this.e;
    }
}
