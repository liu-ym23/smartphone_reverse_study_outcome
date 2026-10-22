package com.obric.common.oea.style.scene.alpha.alphaplayer.model;

import android.content.Context;
import androidx.lifecycle.LifecycleOwner;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Lcom/obric/common/oea/style/scene/alpha/alphaplayer/model/Configuration;", "", "context", "Landroid/content/Context;", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "(Landroid/content/Context;Landroidx/lifecycle/LifecycleOwner;)V", "alphaVideoViewType", "Lcom/obric/common/oea/style/scene/alpha/alphaplayer/model/AlphaVideoViewType;", "getAlphaVideoViewType", "()Lcom/obric/common/oea/style/scene/alpha/alphaplayer/model/AlphaVideoViewType;", "setAlphaVideoViewType", "(Lcom/obric/common/oea/style/scene/alpha/alphaplayer/model/AlphaVideoViewType;)V", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "getLifecycleOwner", "()Landroidx/lifecycle/LifecycleOwner;", "setLifecycleOwner", "(Landroidx/lifecycle/LifecycleOwner;)V", "style_standardRelease"}, k = 1, mv = {1, 4, 3})
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private AlphaVideoViewType f7787a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Context f7788b;
    private LifecycleOwner c;

    public a(Context r3, LifecycleOwner r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        LifecycleOwner r6 = (LifecycleOwner) ZeusTransformUtils.wrapperContextForParams(r4, LifecycleOwner.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "context");
        Intrinsics.checkNotNullParameter(r6, "lifecycleOwner");
        this.f7788b = ZeusTransformUtils.wrapperContext(r5, "com.obric.memorydata.plugin");
        this.c = r6;
        this.f7787a = AlphaVideoViewType.GL_SURFACE_VIEW;
    }

    public final AlphaVideoViewType a() {
        return this.f7787a;
    }

    public final void a(AlphaVideoViewType r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.f7787a = r2;
    }

    public final LifecycleOwner b() {
        return this.c;
    }

    public final Context getContext() {
        return this.f7788b;
    }
}
