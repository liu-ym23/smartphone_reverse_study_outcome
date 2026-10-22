package com.larus.avlink.gallery.plugin;

import com.larus.mirabridge.api.bean.PluginLoadBuilder;
import com.larus.mirabridge.api.pluginservice.IDoraPluginService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Result;
import kotlinx.coroutines.i;
import kotlinx.coroutines.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class e implements PluginLoadBuilder.b {
    public final /* synthetic */ AtomicBoolean a;
    public final /* synthetic */ i<IDoraPluginService> b;

    public final void onFailed() {
        if (this.a.compareAndSet(false, true) == false) goto L6;
        this.b.resumeWith(Result.constructor-impl(null));
        return;
    }

    public final void onSuccess() {
        IDoraPluginService r0 = (IDoraPluginService) ServiceManager.get().getService(IDoraPluginService.class);
        f.b(r0);
        if (this.a.compareAndSet(false, true) == false) goto L6;
        this.b.resumeWith(Result.constructor-impl(r0));
        return;
    }

    public e(AtomicBoolean r1, j r2) {
        this.a = r1;
        this.b = r2;
    }
}
