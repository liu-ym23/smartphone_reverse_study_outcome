package com.bytedance.ies.bullet.base.settings;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\t\u001a\u00020\u00048\u0006X\u0087D¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR(\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u0005\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0012"}, d2 = {"Lcom/bytedance/ies/bullet/base/settings/LegacyWebcastConfig;", "", "<init>", "()V", "", "a", "Z", "getEnable", "()Z", "enable", "", "", "b", "Ljava/util/List;", "()Ljava/util/List;", "setDomainWhiteList", "(Ljava/util/List;)V", "domainWhiteList", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class LegacyWebcastConfig {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("enable")
    private final boolean f5189a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @SerializedName("domain_white_list")
    private List<String> f5190b;

    public LegacyWebcastConfig() {
        this.f5189a = true;
        this.f5190b = CollectionsKt.emptyList();
        LazyKt.lazy(new LegacyWebcastConfig$domainWhiteMap$2(this));
    }

    public final List a() {
        return this.f5190b;
    }
}
