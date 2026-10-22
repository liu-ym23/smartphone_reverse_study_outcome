package com.bytedance.android.livesdk.chatroom.ui;

import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.livesdk.closeroom.CloseRoomInterceptList;
import com.bytedance.android.livesdkapi.floatview.IInnerFloatWindowSceneInterceptor;
import java.util.List;
import kotlin.Pair;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class m4 implements kf1.a {
    public final /* synthetic */ AbsInteractionFragment a;

    public final String tag() {
        return "AbsInteractionFragment_ChangeToSceneFloatWindow";
    }

    public final CloseRoomInterceptList config() {
        return CloseRoomInterceptList.DEFAULT;
    }

    public m4(AbsInteractionFragment r1) {
        this.a = r1;
    }

    public final boolean qa(Runnable r2, boolean r3) {
        if (r3 == false) goto L5;
        return false;
    L5:
        int r4 = jc1.k.f(IInteractService.class).getCurUILayout();
        if (r4 != 62) goto L8;
    L25:
        return false;
    L8:
        if (r4 == 63) goto L25;
        if (com.bytedance.android.livesdk.floatview.inner.h.b(this.a.getContext()) == false) goto L17;
        if (com.bytedance.android.livesdk.floatview.inner.h.a() == false) goto L17;
        List<Pair<IInnerFloatWindowSceneInterceptor, Integer>> r5 = com.bytedance.android.livesdk.floatview.inner.b.a;
        com.bytedance.android.livesdk.floatview.inner.b.c(null, true);
        return true;
    L17:
        if (tb1.c.a == false) goto L25;
        if (com.bytedance.android.livesdk.floatview.inner.h.c() == false) goto L25;
        lm3.d r6 = com.bytedance.android.livesdk.floatview.inner.h.e(this.a.getContext(), this.a.z3);
        if (r6 == null) goto L24;
        this.a.z3 = r6;
    L24:
        return true;
    }
}
