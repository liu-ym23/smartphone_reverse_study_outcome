package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.loader;

import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ExtendedToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.a2;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.y3;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.v0;
import com.bytedance.android.livesdkapi.floatview.IInnerFloatWindowSceneInterceptor;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/loader/LiveFloatWindowPlayLoader;", "Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/loader/AbsDynamicLoader;", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveFloatWindowPlayLoader extends AbsDynamicLoader {
    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.g.c
    public final List<a2> c() {
        ArrayList r0 = new ArrayList();
        List<Pair<IInnerFloatWindowSceneInterceptor, Integer>> r1 = com.bytedance.android.livesdk.floatview.inner.b.a;
        if (com.bytedance.android.livesdk.floatview.inner.b.a() == false) goto L5;
        ExtendedToolbarButton.a r2 = ExtendedToolbarButton.h;
        ToolbarButton r3 = ToolbarButton.LIVE_FLOAT_WINDOW_PLAY;
        r2.getClass();
        ExtendedToolbarButton.b r4 = ExtendedToolbarButton.a.a(r3);
    L6:
        if (r4 == null) goto L8;
        r0.add(r4);
    L8:
        return r0;
    L5:
        r4 = null;
        goto L6
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.loader.AbsDynamicLoader, com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.loader.AbsMiddlewareDynamicLoader, com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.g.c
    public final void onLoad() {
        y3.f(this.a).p(ToolbarButton.LIVE_FLOAT_WINDOW_PLAY.extended(), new v0());
    }

    public LiveFloatWindowPlayLoader(e r2) {
        Intrinsics.checkNotNullParameter(r2, "env");
        super(r2);
    }
}
