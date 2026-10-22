package com.larus.community.impl.update;

import com.bytedance.common.utility.NetworkUtils;
import com.larus.common.apphost.AppHost;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class CreationLLMUpdateShowHelper {
    public final Lazy a;
    public final Lazy b;

    public final void a() {
        if (z2.a.getActionBarEntryConfig().f == true) goto L6;
        return;
    L6:
        if (NetworkUtils.isNetworkAvailable(AppHost.a.getApplication()) == true) goto L9;
        FLogger.a.i("CreationLLMUpdateShowHelper", "network not available");
        return;
    L9:
        BuildersKt.launch$default(CoroutineScopeKt.MainScope(), null, null, new CreationLLMUpdateShowHelper$preloadImage$1(this, null), 3, null);
    }

    public CreationLLMUpdateShowHelper() {
        this.a = LazyKt.lazy(new h());
        this.b = LazyKt.lazy(new i());
    }
}
