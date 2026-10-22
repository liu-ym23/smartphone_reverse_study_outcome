package com.bytedance.ai.bridge.method.system.location;

import android.app.Activity;
import android.os.Looper;
import com.bytedance.ai.applet.permission.Scope;
import com.bytedance.ai.event.MessageIndication;
import com.google.gson.JsonObject;
import d3.a0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class LocationAuthorization {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public LocationAuthorization() {
    }

    public static void c(Function1 r10) {
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == false) goto L5;
        MainCoroutineDispatcher r0 = Dispatchers.getMain().getImmediate();
    L6:
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(r0), null, null, new LocationAuthorization$launchOnMainThread$1(r10, null), 3, null);
        return;
    L5:
        r0 = Dispatchers.getMain();
        goto L6
    }

    public static JsonObject b(String r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, MessageIndication.MESSAGE_TYPE_MSG);
        JsonObject r0 = new JsonObject();
        r0.addProperty("errCode", Integer.valueOf(r11));
        r0.addProperty("errMsg", r10);
        return r0;
    }

    public static void a(e3.d r12, f3.h r13, Scope r14, String r15, Function1 r16) {
        Intrinsics.checkNotNullParameter(r12, "bridgeContext");
        Intrinsics.checkNotNullParameter(r13, "callback");
        Intrinsics.checkNotNullParameter(r14, "scope");
        Intrinsics.checkNotNullParameter(r15, "permissionCheckDetail");
        Intrinsics.checkNotNullParameter(r16, "onSuccess");
        Activity r0 = r12.getOwnerActivity();
        if (r0 != null) goto L8;
        r0 = f2.k.b();
        if (r0 != null) goto L8;
        f3.h.a.a(r13, "context is null", f3.a.f, null, 10);
        return;
    L8:
        Activity r10 = r0;
        a0 r1 = r12.getContainerContext();
        if (r1 == null) goto L15;
        String r11 = r1.getAppletId();
        if (r11 == null) goto L15;
        c(new LocationAuthorization$authorize$1(r11, r13, r12, r15, r14, r16, r10, null));
        return;
    L15:
        f3.h.a.a(r13, "appId is null", f3.a.f, null, 10);
    }
}
