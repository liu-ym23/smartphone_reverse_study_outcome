package com.bytedance.ies.bullet.base.settings;

import com.google.gson.annotations.SerializedName;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0011\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\"\u0010\u000b\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR6\u0010\u0015\u001a\u0016\u0012\u0004\u0012\u00020\r\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u000e\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\"\u0010\u0018\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0006\u001a\u0004\b\u0016\u0010\b\"\u0004\b\u0017\u0010\nR\"\u0010\u001a\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\u0006\u001a\u0004\b\u000f\u0010\b\"\u0004\b\u0019\u0010\nR0\u0010\u001e\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u001b\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u0010\u001a\u0004\b\u0005\u0010\u0012\"\u0004\b\u001d\u0010\u0014R$\u0010%\u001a\u0004\u0018\u00010\u001f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b \u0010\"\"\u0004\b#\u0010$R(\u0010(\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0004\b\u0011\u0010\u0006\u0012\u0004\b'\u0010\u0003\u001a\u0004\b\u001c\u0010\b\"\u0004\b&\u0010\n¨\u0006)"}, d2 = {"Lcom/bytedance/ies/bullet/base/settings/f;", "", "<init>", "()V", "", "a", "Z", "d", "()Z", "setEnableSafeWebJSBAuth", "(Z)V", "enableSafeWebJSBAuth", "", "", "", "b", "Ljava/util/Map;", "g", "()Ljava/util/Map;", "setPrivateDomains", "(Ljava/util/Map;)V", "privateDomains", "c", "setEnableJSBAuthV3", "enableJSBAuthV3", "setEnableAutoMatchUrl", "enableAutoMatchUrl", "Lcom/bytedance/ies/bullet/base/settings/i;", "e", "setCustomMethodAuthTypeSetting", "customMethodAuthTypeSetting", "Lcom/bytedance/ies/bullet/base/settings/g;", "f", "Lcom/bytedance/ies/bullet/base/settings/g;", "()Lcom/bytedance/ies/bullet/base/settings/g;", "setJsbRequestCheck", "(Lcom/bytedance/ies/bullet/base/settings/g;)V", "jsbRequestCheck", "setJsbAuthOnlyUseHostNamespace", "getJsbAuthOnlyUseHostNamespace$annotations", "jsbAuthOnlyUseHostNamespace", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("enable_safe_web_jsb_auth")
    private boolean f5202a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @SerializedName("private_domains")
    private Map<String, String[]> f5203b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @SerializedName("enable_jsb_auth_v3")
    private boolean f5204c;

    @SerializedName("enable_auto_match_url")
    private boolean d;

    @SerializedName("custom_method_auth_type_setting")
    private Map<String, i> e;

    @SerializedName("jsb_request_check")
    private g f;

    @SerializedName("jsb_auth_only_use_host_namespace")
    private boolean g;

    public f() {
        this.f5202a = true;
        this.f5203b = MapsKt.emptyMap();
        this.e = MapsKt.emptyMap();
        this.f = new g();
        this.g = true;
    }

    public final Map a() {
        return this.e;
    }

    public final boolean b() {
        return this.d;
    }

    public final boolean c() {
        return this.f5204c;
    }

    public final boolean d() {
        return this.f5202a;
    }

    public final boolean e() {
        return this.g;
    }

    public final g f() {
        return this.f;
    }

    public final Map g() {
        return this.f5203b;
    }
}
