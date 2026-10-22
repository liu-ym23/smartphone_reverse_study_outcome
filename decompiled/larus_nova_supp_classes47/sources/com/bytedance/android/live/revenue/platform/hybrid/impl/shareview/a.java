package com.bytedance.android.live.revenue.platform.hybrid.impl.shareview;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.larus.utils.logger.FLogger;
import com.lynx.tasm.LynxView;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public class a implements com.bytedance.android.live.revenue.platform.hybrid.api.shareview.c {
    public final Context a;
    public final zy0.b b;

    @Override // com.bytedance.android.live.revenue.platform.hybrid.api.shareview.c
    public final void b() {
        if (this.b.c().getParent() == null) goto L5;
        return;
    L5:
        Context r0 = getContext();
        if ((r0 instanceof Activity) == false) goto L18;
        jy0.b.d("HybridCardSharer", "attach sharer to decorView");
        View r1 = ((Activity) r0).getWindow().getDecorView();
        if (com.larus.home.impl.utils.c.e == false) goto L12;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r2 = ThreadMethodProxy.currentThread();
        if (r2 == com.larus.home.impl.utils.c.a) goto L12;
        com.larus.home.impl.utils.c.a(r2, "getDecorView");
    L12:
        if (r1 == null) goto L16;
        ((ViewGroup) r1).addView(this.b.c(), new ViewGroup.LayoutParams(0, 0));
        this.b.c().setAlpha(0.0f);
        return;
    L16:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
    L18:
        throw new Error("context is not Activity");
    }

    @Override // com.bytedance.android.live.revenue.platform.hybrid.api.shareview.c
    public final LynxView getLynxView() {
        xy0.a<?> r0 = this.b.g();
        Intrinsics.checkNotNull(r0);
        LynxView r1 = r0.getHybridView();
        if (r1 == null) goto L7;
        return r1;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type com.lynx.tasm.LynxView");
    }

    @Override // com.bytedance.android.live.revenue.platform.hybrid.api.shareview.c
    public final boolean isValid() {
        return !this.b.isDisposed();
    }

    @Override // com.bytedance.android.live.revenue.platform.hybrid.api.shareview.c
    public void release() {
        UtilityKotlinExtentionsKt.q(this.b.c());
        this.b.dispose();
    }

    @Override // com.bytedance.android.live.revenue.platform.hybrid.api.shareview.c
    public Context getContext() {
        return this.a;
    }

    public a(zy0.b r2) {
        Intrinsics.checkNotNullParameter(r2, "card");
        this.b = r2;
        this.a = r2.c().getContext();
    }

    @Override // com.bytedance.android.live.revenue.platform.hybrid.api.shareview.c
    public final void a(String r2, Map<String, ? extends Object> r3) {
        Intrinsics.checkNotNullParameter(r2, "eventName");
        Intrinsics.checkNotNullParameter(r3, "params");
        this.b.w().sendJsEvent(r2, r3);
    }
}
