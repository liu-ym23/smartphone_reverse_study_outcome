package com.ivy.ivykit.plugin.impl.applet;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00060\u0001j\u0002`\u0002¨\u0006\u0003"}, d2 = {"Lcom/ivy/ivykit/plugin/impl/applet/ResourcesLoadException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "ivy_plugin_impl_bullet_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class ResourcesLoadException extends Exception {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f9504a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f9505b;

    public ResourcesLoadException(int r5, String r10) {
        super(r10);
        this.f9504a = r5;
        this.f9505b = r10;
    }
}
