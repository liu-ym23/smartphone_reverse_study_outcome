package com.ivy.ivykit.api.plugin;

import androidx.annotation.Keep;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Keep
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\bg\u0018\u0000 \u00072\u00020\u0001:\u0001\bJ\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0002H&¢\u0006\u0004\b\u0006\u0010\u0004¨\u0006\t"}, d2 = {"Lcom/ivy/ivykit/api/plugin/IvyResourceService;", "", "", "initGlobalConfig", "()V", "registerGecko", "syncGlobalSettings", "Companion", "com/ivy/ivykit/api/plugin/g", "ivy_api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public interface IvyResourceService {
    public static final g Companion = null;

    static {
        Companion = g.f9493a;
    }

    void initGlobalConfig();

    void registerGecko();

    void syncGlobalSettings();
}
