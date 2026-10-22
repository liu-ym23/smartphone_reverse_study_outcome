package com.ivy.ivykit.api.plugin;

import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: classes2.dex */
public final class g implements IvyResourceService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ g f9493a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f9494b = null;

    static {
        f9493a = new g();
        f9494b = LazyKt.lazy(IvyResourceService$Companion$impl$2.f9477a);
    }

    @Override // com.ivy.ivykit.api.plugin.IvyResourceService
    public final void initGlobalConfig() {
        IvyResourceService r5 = (IvyResourceService) f9494b.getValue();
        if (r5 == null) goto L6;
        r5.initGlobalConfig();
        return;
    }

    @Override // com.ivy.ivykit.api.plugin.IvyResourceService
    public final void registerGecko() {
        IvyResourceService r5 = (IvyResourceService) f9494b.getValue();
        if (r5 == null) goto L6;
        r5.registerGecko();
        return;
    }

    @Override // com.ivy.ivykit.api.plugin.IvyResourceService
    public final void syncGlobalSettings() {
        IvyResourceService r5 = (IvyResourceService) f9494b.getValue();
        if (r5 == null) goto L6;
        r5.syncGlobalSettings();
        return;
    }
}
