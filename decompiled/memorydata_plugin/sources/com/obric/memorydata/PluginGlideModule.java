package com.obric.memorydata;

import android.content.Context;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\f"}, d2 = {"Lcom/obric/memorydata/PluginGlideModule;", "Lcom/bumptech/glide/module/AppGlideModule;", "<init>", "()V", "applyOptions", "", "context", "Landroid/content/Context;", "builder", "Lcom/bumptech/glide/GlideBuilder;", "isManifestParsingEnabled", "", "app_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class PluginGlideModule extends com.bumptech.glide.c.a {
    public PluginGlideModule() {
    }

    @Override // com.bumptech.glide.c.a, com.bumptech.glide.c.b
    public void a(Context r2, com.bumptech.glide.d r3) {
        Intrinsics.checkNotNullParameter((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin"), "context");
        Intrinsics.checkNotNullParameter(r3, "builder");
    }

    @Override // com.bumptech.glide.c.a
    public boolean c() {
        return false;
    }
}
