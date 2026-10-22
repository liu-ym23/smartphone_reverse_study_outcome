package com.obric.assistant.router;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.larus.utils.k0;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.IClearContextInKeyguardService;
import com.obric.assistant.spi.audio.IObricRealtimeCallExtService;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import q97.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class ObricRTCPageRouterInterceptor implements a {
    public final Lazy a;
    public final Lazy b;
    public final Lazy c;
    public final CoroutineScope d;

    static {
    }

    public ObricRTCPageRouterInterceptor() {
        this.a = LazyKt.lazy(new d());
        this.b = LazyKt.lazy(new e());
        this.c = LazyKt.lazy(new f());
        this.d = CoroutineScopeKt.MainScope();
    }

    public final boolean b(com.bytedance.router.c r2) {
        int r0 = k0.a;
        if (r2 == null) goto L7;
        Uri r3 = r2.d;
        if (r3 == null) goto L7;
        String r4 = r3.toString();
    L9:
        return Intrinsics.areEqual(k0.a(r4), "//flow/realtime_chat");
    L7:
        r4 = null;
        goto L9
    }

    public final boolean a(Context r13, com.bytedance.router.c r14) {
        if (r14 != null) goto L6;
        FLogger.a.w("ObricRTCPageRouterInterceptor", "onInterceptRoute: routeIntent is null");
        return false;
    L6:
        IObricRealtimeCallExtService r2 = (IObricRealtimeCallExtService) this.c.getValue();
        if (r2 != null) goto L9;
    L11:
        boolean r3 = false;
    L12:
        Intent r4 = r14.b;
        if (r4 == null) goto L15;
        boolean r5 = r4.getBooleanExtra("o_is_checked_clear_context", false);
    L16:
        FLogger r6 = FLogger.a;
        r6.i("ObricRTCPageRouterInterceptor", "onInterceptRoute: hasCheckedClearContext = " + r5 + ", hasRealtimeCallActivity = " + r3);
        if (r3 == true) goto L28;
        if (r5 == true) goto L28;
        IClearContextInKeyguardService r7 = (IClearContextInKeyguardService) this.a.getValue();
        if (r7 != null) goto L22;
    L24:
        boolean r8 = false;
    L25:
        if (r8 == false) goto L28;
        r6.i("ObricRTCPageRouterInterceptor", "onInterceptRoute: will clear context");
        BuildersKt.launch$default(this.d, null, null, new onInterceptRoute.1(this, r13, r14, null), 3, null);
        return true;
    L22:
        if (r7.b() != true) goto L24;
        r8 = true;
    L28:
        return false;
    L15:
        r5 = false;
        goto L16
    L9:
        if (r2.hasRealtimeCallActivity() != true) goto L11;
        r3 = true;
        goto L12
    }
}
