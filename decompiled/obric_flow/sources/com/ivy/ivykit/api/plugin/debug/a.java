package com.ivy.ivykit.api.plugin.debug;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements IvyDebugService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ a f9487a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f9488b = null;

    static {
        f9487a = new a();
        f9488b = LazyKt.lazy(IvyDebugService$Companion$impl$2.f9485a);
    }

    @Override // com.ivy.ivykit.api.plugin.debug.IvyDebugService
    public final boolean handleSchema(String r5) {
        Intrinsics.checkNotNullParameter(r5, "schema");
        IvyDebugService r10 = (IvyDebugService) f9488b.getValue();
        if (r10 != null) goto L5;
        return false;
    L5:
        return r10.handleSchema(r5);
    }

    @Override // com.ivy.ivykit.api.plugin.debug.IvyDebugService
    public final boolean isEnable() {
        IvyDebugService r5 = (IvyDebugService) f9488b.getValue();
        if (r5 != null) goto L5;
        return false;
    L5:
        return r5.isEnable();
    }

    @Override // com.ivy.ivykit.api.plugin.debug.IvyDebugService
    public final void log(IvyDebugService.LogLevel r10, String r11, String r12, Object r13, Object r14) {
        Intrinsics.checkNotNullParameter(r10, "level");
        Intrinsics.checkNotNullParameter(r11, "type");
        Intrinsics.checkNotNullParameter(r12, "tag");
        IvyDebugService r5 = (IvyDebugService) f9488b.getValue();
        if (r5 == null) goto L6;
        r5.log(r10, r11, r12, r13, r14);
        return;
    }

    @Override // com.ivy.ivykit.api.plugin.debug.IvyDebugService
    public final void registerScanCallback(Function1 r5) {
        Intrinsics.checkNotNullParameter(r5, "scanCallback");
        IvyDebugService r10 = (IvyDebugService) f9488b.getValue();
        if (r10 == null) goto L6;
        r10.registerScanCallback(r5);
        return;
    }

    @Override // com.ivy.ivykit.api.plugin.debug.IvyDebugService
    public final void setEnable(boolean r5) {
        IvyDebugService r10 = (IvyDebugService) f9488b.getValue();
        if (r10 == null) goto L6;
        r10.setEnable(r5);
        return;
    }
}
