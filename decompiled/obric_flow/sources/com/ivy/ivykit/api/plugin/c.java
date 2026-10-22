package com.ivy.ivykit.api.plugin;

import android.app.Application;
import android.content.Context;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class c implements IIvyAIPackageResourceService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ c f9482a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f9483b = null;

    static {
        f9482a = new c();
        f9483b = LazyKt.lazy(IIvyAIPackageResourceService$Companion$impl$2.f9474a);
    }

    @Override // com.ivy.ivykit.api.plugin.IIvyAIPackageResourceService
    public final void closeSession(String r5) {
        Intrinsics.checkNotNullParameter(r5, "sessionId");
        IIvyAIPackageResourceService r10 = (IIvyAIPackageResourceService) f9483b.getValue();
        if (r10 == null) goto L6;
        r10.closeSession(r5);
        return;
    }

    @Override // com.ivy.ivykit.api.plugin.IIvyAIPackageResourceService
    public final void ensureInitLynx(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        IIvyAIPackageResourceService r10 = (IIvyAIPackageResourceService) f9483b.getValue();
        if (r10 == null) goto L6;
        r10.ensureInitLynx(r5);
        return;
    }

    @Override // com.ivy.ivykit.api.plugin.IIvyAIPackageResourceService
    public final String getBid() {
        IIvyAIPackageResourceService r5 = (IIvyAIPackageResourceService) f9483b.getValue();
        if (r5 != null) goto L5;
        return null;
    L5:
        return r5.getBid();
    }

    @Override // com.ivy.ivykit.api.plugin.IIvyAIPackageResourceService
    public final String getImageUrl(String r5, String r10, String r11) {
        Intrinsics.checkNotNullParameter(r11, "bid");
        IIvyAIPackageResourceService r12 = (IIvyAIPackageResourceService) f9483b.getValue();
        if (r12 != null) goto L5;
        return null;
    L5:
        return r12.getImageUrl(r5, r10, r11);
    }

    @Override // com.ivy.ivykit.api.plugin.IIvyAIPackageResourceService
    public final void initContainer(Application r10, String r11, String r12, h r13, d r14) {
        Intrinsics.checkNotNullParameter(r10, "application");
        Intrinsics.checkNotNullParameter(r11, "bid");
        Intrinsics.checkNotNullParameter(r13, "pluginConfig");
        Intrinsics.checkNotNullParameter(r14, "containerConfig");
        IIvyAIPackageResourceService r5 = (IIvyAIPackageResourceService) f9483b.getValue();
        if (r5 == null) goto L6;
        r5.initContainer(r10, r11, r12, r13, r14);
        return;
    }

    @Override // com.ivy.ivykit.api.plugin.IIvyAIPackageResourceService
    public final void loadAIPackageResourceAsync(String r10, String r11, Function1 r12, Function1 r13, boolean r14) {
        Intrinsics.checkNotNullParameter(r11, "url");
        Intrinsics.checkNotNullParameter(r12, "resolve");
        Intrinsics.checkNotNullParameter(r13, "reject");
        IIvyAIPackageResourceService r5 = (IIvyAIPackageResourceService) f9483b.getValue();
        if (r5 == null) goto L6;
        r5.loadAIPackageResourceAsync(r10, r11, r12, r13, r14);
        return;
    }

    @Override // com.ivy.ivykit.api.plugin.IIvyAIPackageResourceService
    public final void loadResourceAsync(String r10, String r11, Function1 r12, Function1 r13, boolean r14) {
        Intrinsics.checkNotNullParameter(r11, "url");
        Intrinsics.checkNotNullParameter(r12, "resolve");
        Intrinsics.checkNotNullParameter(r13, "reject");
        IIvyAIPackageResourceService r5 = (IIvyAIPackageResourceService) f9483b.getValue();
        if (r5 == null) goto L6;
        r5.loadResourceAsync(r10, r11, r12, r13, r14);
        return;
    }

    @Override // com.ivy.ivykit.api.plugin.IIvyAIPackageResourceService
    public final String openSession(String r5) {
        IIvyAIPackageResourceService r10 = (IIvyAIPackageResourceService) f9483b.getValue();
        if (r10 == null) goto L8;
        String r11 = r10.openSession(r5);
        if (r11 == null) goto L10;
        return r11;
    L10:
        return "";
    L8:
        return "";
    }
}
