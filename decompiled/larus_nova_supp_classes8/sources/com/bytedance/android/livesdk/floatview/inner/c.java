package com.bytedance.android.livesdk.floatview.inner;

import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.floatwindow.applywindow.LinkmicApplyFloatWindowManager;
import com.bytedance.android.live.liveinteract.floatwindow.onlinewindow.LinkmicOnlineFloatWindowManager;
import com.bytedance.android.livesdkapi.floatview.IInnerFloatWindowManager;
import com.bytedance.android.livesdkapi.floatview.IInnerFloatWindowSceneInterceptor;
import java.util.List;
import kotlin.Lazy;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class c {
    public static final List<c> d = null;
    public final IInnerFloatWindowManager a;
    public final IInnerFloatWindowSceneInterceptor b;
    public final int c;

    public static final class a {
    }

    static {
        c[] r0 = new c[3];
        Lazy r2 = VideoWatchingInnerFloatWindowManager.p;
        VideoWatchingInnerFloatWindowManager r3 = (VideoWatchingInnerFloatWindowManager) r2.getValue();
        LinkmicOnlineFloatWindowManager r5 = null;
        if ((r3 instanceof IInnerFloatWindowManager) == true) goto L5;
        r3 = null;
    L5:
        VideoWatchingInnerFloatWindowManager r4 = (VideoWatchingInnerFloatWindowManager) r2.getValue();
        if ((r4 instanceof IInnerFloatWindowSceneInterceptor) == true) goto L8;
        r4 = null;
    L8:
        r0[0] = new c(r3, r4, 0);
        IInteractService r6 = jc1.k.f(IInteractService.class);
        if (r6 != null) goto L11;
    L13:
        LinkmicApplyFloatWindowManager r7 = null;
    L14:
        IInteractService r8 = jc1.k.f(IInteractService.class);
        if (r8 != null) goto L17;
    L19:
        LinkmicApplyFloatWindowManager r9 = null;
    L21:
        if ((r9 instanceof IInnerFloatWindowSceneInterceptor) == true) goto L23;
        r9 = null;
    L23:
        r0[1] = new c(r7, r9, 1);
        IInteractService r10 = jc1.k.f(IInteractService.class);
        if (r10 != null) goto L26;
    L28:
        LinkmicOnlineFloatWindowManager r11 = null;
    L29:
        IInteractService r12 = jc1.k.f(IInteractService.class);
        if (r12 != null) goto L32;
    L34:
        LinkmicOnlineFloatWindowManager r13 = null;
    L36:
        if ((r13 instanceof IInnerFloatWindowSceneInterceptor) == false) goto L39;
        r5 = r13;
    L39:
        r0[2] = new c(r11, r5, 2);
        d = CollectionsKt.mutableListOf(r0);
        return;
    L32:
        if (r12.getInteractFloatWindowService() == null) goto L34;
        String r14 = LinkmicOnlineFloatWindowManager.Y;
        r13 = LinkmicOnlineFloatWindowManager.c.a();
        goto L36
    L26:
        if (r10.getInteractFloatWindowService() == null) goto L28;
        String r15 = LinkmicOnlineFloatWindowManager.Y;
        r11 = LinkmicOnlineFloatWindowManager.c.a();
        goto L29
    L17:
        if (r8.getInteractFloatWindowService() == null) goto L19;
        LinkmicApplyFloatWindowManager.d r16 = LinkmicApplyFloatWindowManager.y;
        r9 = LinkmicApplyFloatWindowManager.e.a();
        goto L21
    L11:
        if (r6.getInteractFloatWindowService() == null) goto L13;
        LinkmicApplyFloatWindowManager.d r17 = LinkmicApplyFloatWindowManager.y;
        r7 = LinkmicApplyFloatWindowManager.e.a();
        goto L14
    }

    public c(IInnerFloatWindowManager r1, IInnerFloatWindowSceneInterceptor r2, int r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
