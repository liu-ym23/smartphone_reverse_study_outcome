package com.ss.android.lark.chameleonv2.container.webcontainer.config;

import com.google.gson.annotations.SerializedName;
import com.ss.android.lark.appsetting.annotation.AppConfig;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.ArrayList;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@AppConfig(key = "chameleon_interceptor_config")
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR.\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\f0\u000bj\b\u0012\u0004\u0012\u00020\f`\r8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/ss/android/lark/chameleonv2/container/webcontainer/config/ChameleonInterceptorGlobalConfig;", BuildConfig.FLAVOR, "<init>", "()V", "enable", BuildConfig.FLAVOR, "getEnable", "()Z", "setEnable", "(Z)V", "interceptors", "Ljava/util/ArrayList;", "Lcom/ss/android/lark/chameleonv2/container/webcontainer/config/ChameleonInterceptorConfig;", "Lkotlin/collections/ArrayList;", "getInterceptors", "()Ljava/util/ArrayList;", "setInterceptors", "(Ljava/util/ArrayList;)V", "chameleon_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ChameleonInterceptorGlobalConfig {

    @SerializedName("enable")
    private boolean enable;

    @SerializedName("interceptors")
    private ArrayList<ChameleonInterceptorConfig> interceptors;

    public ChameleonInterceptorGlobalConfig() {
        this.interceptors = new ArrayList();
    }

    public final boolean a() {
        return this.enable;
    }

    public final ArrayList<ChameleonInterceptorConfig> b() {
        return this.interceptors;
    }
}
