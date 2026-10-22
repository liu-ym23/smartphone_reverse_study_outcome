package com.bytedance.android.livesdk.gamecp.impl;

import android.content.Context;
import android.widget.FrameLayout;
import androidx.fragment.app.DialogFragment;
import com.bytedance.android.livesdkapi.view.IVideoFloatManager;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class m implements dw.g {
    public final HashMap<dw.h, IVideoFloatManager.VideoFloatManagerListener> a;
    public final k b;

    public final boolean isFloatViewShowing() {
        return this.b.isFloatViewShowing();
    }

    public final void stopFloatView() {
        this.b.stopFloatView();
    }

    public m() {
        this.a = new HashMap();
        this.b = new k();
    }

    public final void c(com.bytedance.android.gamecp.business.gamedetail.m r3) {
        Intrinsics.checkNotNullParameter(r3, "observer");
        IVideoFloatManager.VideoFloatManagerListener r0 = this.a.get(r3);
        if (r0 != null) goto L5;
        return;
    L5:
        this.b.removeFloatViewStatusObserver(r0);
        this.a.remove(r3);
    }

    public final void d(com.bytedance.android.gamecp.business.gamedetail.m r3) {
        Intrinsics.checkNotNullParameter(r3, "observer");
        l r0 = new l(r3);
        this.a.put(r3, r0);
        this.b.addFloatViewStatusObserver(r0);
    }

    public final void b(Context r8, HashMap r9) {
        this.b.showFloatViewNow(r8, null, true, false, null, r9);
    }

    public final void a(DialogFragment r9, FrameLayout r10, boolean r11, boolean r12, HashMap r13) {
        Intrinsics.checkNotNullParameter(r9, "fragment");
        Intrinsics.checkNotNullParameter(r10, "rootView");
        this.b.showFloatViewNow(r9, r10, null, r11, r12, null, r13);
    }
}
