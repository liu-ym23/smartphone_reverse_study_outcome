package com.bytedance.android.livesdk.chatroom.ui.framework.widget.room;

import com.bytedance.android.live.liveinteract.linkpanel.util.o;
import com.bytedance.android.livesdk.closeroom.CloseRoomInterceptList;
import com.bytedance.android.livesdkapi.floatview.IInnerFloatWindowSceneInterceptor;
import java.util.List;
import kotlin.Pair;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class h implements kf1.a {
    public final /* synthetic */ RoomCloseInterceptorWidget a;

    public final String tag() {
        return "ChangeToSceneFloatWindowInterceptor";
    }

    public final CloseRoomInterceptList config() {
        return CloseRoomInterceptList.DEFAULT;
    }

    public h(RoomCloseInterceptorWidget r1) {
        this.a = r1;
    }

    public final boolean qa(Runnable r3, boolean r4) {
        if (r4 == false) goto L6;
        return false;
    L6:
        if (o.o(null) == false) goto L9;
        return false;
    L9:
        if (com.bytedance.android.livesdk.floatview.inner.h.b(this.a.getContext()) == false) goto L15;
        if (com.bytedance.android.livesdk.floatview.inner.h.a() == false) goto L15;
        List<Pair<IInnerFloatWindowSceneInterceptor, Integer>> r5 = com.bytedance.android.livesdk.floatview.inner.b.a;
        com.bytedance.android.livesdk.floatview.inner.b.c(null, true);
        return true;
    L15:
        if (tb1.c.a == true) goto L17;
    L23:
        return false;
    L17:
        if (com.bytedance.android.livesdk.floatview.inner.h.c() == false) goto L23;
        lm3.d r6 = com.bytedance.android.livesdk.floatview.inner.h.e(this.a.getContext(), this.a.c);
        if (r6 == null) goto L22;
        this.a.c = r6;
    L22:
        return true;
    }
}
