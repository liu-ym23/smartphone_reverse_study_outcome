package com.bytedance.ies.bullet.base.settings;

import com.google.gson.annotations.SerializedName;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\"\u0010\u000b\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR*\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\"\u0010\u0016\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\u0006\u001a\u0004\b\u000e\u0010\b\"\u0004\b\u0015\u0010\nR*\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u000f\u001a\u0004\b\u0017\u0010\u0011\"\u0004\b\u0018\u0010\u0013R0\u0010 \u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u001a8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u001c\u001a\u0004\b\u0005\u0010\u001d\"\u0004\b\u001e\u0010\u001f¨\u0006!"}, d2 = {"Lcom/bytedance/ies/bullet/base/settings/i;", "", "<init>", "()V", "", "a", "Z", "c", "()Z", "setEnableWebForcePrivate", "(Z)V", "enableWebForcePrivate", "", "", "b", "[Ljava/lang/String;", "e", "()[Ljava/lang/String;", "setWebPublicMethods", "([Ljava/lang/String;)V", "webPublicMethods", "setEnableLynxForcePrivate", "enableLynxForcePrivate", "d", "setLynxPublicMethods", "lynxPublicMethods", "", "", "Ljava/util/Map;", "()Ljava/util/Map;", "setCommonSecureMethods", "(Ljava/util/Map;)V", "commonSecureMethods", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("enable_web_force_private")
    private boolean f5209a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @SerializedName("web_public_method")
    private String[] f5210b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @SerializedName("enable_lynx_force_private")
    private boolean f5211c;

    @SerializedName("lynx_public_method")
    private String[] d;

    @SerializedName("common_secure_method")
    private Map<String, Integer> e;

    public i() {
        this.f5210b = new String[0];
        this.f5211c = true;
        this.d = new String[0];
        this.e = MapsKt.emptyMap();
    }

    public final Map a() {
        return this.e;
    }

    public final boolean b() {
        return this.f5211c;
    }

    public final boolean c() {
        return this.f5209a;
    }

    public final String[] d() {
        return this.d;
    }

    public final String[] e() {
        return this.f5210b;
    }
}
