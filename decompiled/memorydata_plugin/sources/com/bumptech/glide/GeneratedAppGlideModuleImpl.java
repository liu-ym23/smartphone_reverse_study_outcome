package com.bumptech.glide;

import android.content.Context;
import android.util.Log;
import com.bumptech.glide.manager.n;
import com.obric.memorydata.PluginGlideModule;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collections;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
final class GeneratedAppGlideModuleImpl extends GeneratedAppGlideModule {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final PluginGlideModule f501a;

    public GeneratedAppGlideModuleImpl(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        this.f501a = new PluginGlideModule();
        if (Log.isLoggable("Glide", 3) == false) goto L6;
        Log.d("Glide", "Discovered AppGlideModule from annotation: com.obric.memorydata.PluginGlideModule");
        return;
    }

    @Override // com.bumptech.glide.GeneratedAppGlideModule
    public Set<Class<?>> a() {
        return Collections.emptySet();
    }

    @Override // com.bumptech.glide.c.d, com.bumptech.glide.c.f
    public void a(Context r3, c r4, Registry r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        this.f501a.a(r6, r4, r5);
    }

    @Override // com.bumptech.glide.c.a, com.bumptech.glide.c.b
    public void a(Context r3, d r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        this.f501a.a(r5, r4);
    }

    @Override // com.bumptech.glide.GeneratedAppGlideModule
    /* synthetic */ n.a b() {
        return d();
    }

    @Override // com.bumptech.glide.c.a
    public boolean c() {
        return this.f501a.c();
    }

    a d() {
        return new a();
    }
}
