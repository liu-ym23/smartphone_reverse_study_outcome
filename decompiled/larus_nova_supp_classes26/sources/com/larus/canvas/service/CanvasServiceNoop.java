package com.larus.canvas.service;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import ny8.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0012\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0012\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u000bH\u0016J\n\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016R\u001c\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0012X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lcom/larus/canvas/service/CanvasServiceNoop;", "Lcom/larus/canvas/service/ICanvasService;", "<init>", "()V", "openCanvasPage", "", "param", "Lcom/larus/canvas/service/bean/ICanvasInitConfig;", "createCanvasRouterIntent", "Landroid/content/Intent;", "createCanvasPageArguments", "Landroid/os/Bundle;", "createCanvasFragment", "Landroidx/fragment/app/Fragment;", "args", "createCanvasRouterInterceptor", "Lcom/bytedance/router/interceptor/IInterceptor;", "anchorEventFlow", "Lkotlinx/coroutines/flow/Flow;", "Lcom/larus/canvas/service/bean/CanvasAnchorEvent;", "getAnchorEventFlow", "()Lkotlinx/coroutines/flow/Flow;", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CanvasServiceNoop implements ICanvasService {
    public CanvasServiceNoop() {
    }

    public final void a(e r2) {
        Intrinsics.checkNotNullParameter(r2, "param");
    }

    public final q97.a b() {
        return null;
    }

    public final Flow<ny8.a> c() {
        return null;
    }

    public final Fragment d(Bundle r2) {
        Intrinsics.checkNotNullParameter(r2, "args");
        return null;
    }

    public final Bundle f(e r2) {
        Intrinsics.checkNotNullParameter(r2, "param");
        return null;
    }
}
