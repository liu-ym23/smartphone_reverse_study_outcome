package com.ivy.ivykit.api.plugin;

import android.content.Context;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class f implements IvyPluginService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ f f9491a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f9492b = null;

    static {
        f9491a = new f();
        f9492b = LazyKt.lazy(IvyPluginService$Companion$impl$2.f9476a);
    }

    @Override // com.ivy.ivykit.api.plugin.IvyPluginService
    public final ql.a createPluginView(Context r10, String r11, ol.b r12, ol.c r13, String r14) {
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r11, "templateUrl");
        IvyPluginService r5 = (IvyPluginService) f9492b.getValue();
        if (r5 != null) goto L5;
        return null;
    L5:
        return r5.createPluginView(r10, r11, null, r13, r14);
    }

    @Override // com.ivy.ivykit.api.plugin.IvyPluginService
    public final boolean hasInit() {
        IvyPluginService r5 = (IvyPluginService) f9492b.getValue();
        if (r5 != null) goto L5;
    L7:
        return false;
    L5:
        if (r5.hasInit() != true) goto L7;
        return true;
    }

    @Override // com.ivy.ivykit.api.plugin.IvyPluginService
    public final void initContainer(h r5) {
        Intrinsics.checkNotNullParameter(r5, "pluginConfig");
        IvyPluginService r10 = (IvyPluginService) f9492b.getValue();
        if (r10 == null) goto L6;
        r10.initContainer(r5);
        return;
    }

    @Override // com.ivy.ivykit.api.plugin.IvyPluginService
    public final void openSchema(Context r5, String r10) {
        Intrinsics.checkNotNullParameter(r5, "context");
        Intrinsics.checkNotNullParameter(r10, "url");
        IvyPluginService r11 = (IvyPluginService) f9492b.getValue();
        if (r11 == null) goto L6;
        r11.openSchema(r5, r10);
        return;
    }

    @Override // com.ivy.ivykit.api.plugin.IvyPluginService
    public final void preload(List r5) {
        Intrinsics.checkNotNullParameter(r5, "schemaList");
        IvyPluginService r10 = (IvyPluginService) f9492b.getValue();
        if (r10 == null) goto L6;
        r10.preload(r5);
        return;
    }

    @Override // com.ivy.ivykit.api.plugin.IvyPluginService
    public final void setLynxVerifyConfig(pl.a r5) {
        Intrinsics.checkNotNullParameter(null, "config");
        IvyPluginService r10 = (IvyPluginService) f9492b.getValue();
        if (r10 == null) goto L6;
        r10.setLynxVerifyConfig(null);
        return;
    }
}
