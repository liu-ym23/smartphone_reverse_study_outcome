package com.bytedance.android.livesdk.interactivity.zdanmaku.cast;

import android.view.View;
import com.bytedance.android.livehostapi.business.castscreen.interfaces.ICastDanmakuManager;
import com.bytedance.android.livesdk.interactivity.zdanmaku.widget.LandscapeDanmakuPresenterV2;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a implements ICastDanmakuManager {
    public final WeakReference<LandscapeDanmakuPresenterV2.IView> a;
    public final WeakReference<View> b;

    public final void destroy() {
    }

    public final View getRenderEngineView() {
        return this.b.get();
    }

    public final void startDanmaku() {
        LandscapeDanmakuPresenterV2.IView r0 = this.a.get();
        if (r0 == null) goto L6;
        r0.startDanmaku();
        return;
    }

    public final void stopDanmaku() {
        LandscapeDanmakuPresenterV2.IView r0 = this.a.get();
        if (r0 == null) goto L6;
        r0.stopDanmaku();
        return;
    }

    public a(WeakReference<LandscapeDanmakuPresenterV2.IView> r2, WeakReference<View> r3) {
        Intrinsics.checkNotNullParameter(r2, "weakRef");
        Intrinsics.checkNotNullParameter(r3, "viewRef");
        this.a = r2;
        this.b = r3;
    }
}
