package com.obric.aikernel.middleware.api.appcontext.receiver;

import android.content.Context;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.p1;

/* JADX INFO: loaded from: classes2.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f f4546a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ConcurrentHashMap<String, SettingsFlowMonitor> f4547b = null;

    static {
        f4546a = new f();
        f4547b = new ConcurrentHashMap();
    }

    private f() {
    }

    public final p1<String> a(String r10) {
        Intrinsics.checkNotNullParameter(r10, "key");
        SettingsFlowMonitor r11 = f4547b.get(r10);
        if (r11 != null) goto L7;
        return null;
    L7:
        return r11.d();
    }

    public final String b(String r10) {
        Intrinsics.checkNotNullParameter(r10, "key");
        SettingsFlowMonitor r11 = f4547b.get(r10);
        if (r11 != null) goto L7;
        return null;
    L7:
        return r11.c();
    }

    public final void c(Context r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r11, "key");
        ConcurrentHashMap<String, SettingsFlowMonitor> r12 = f4547b;
        if (r12.containsKey(r11) == true) goto L7;
        r12.put(r11, new SettingsFlowMonitor(r10, r11));
        return;
    L7:
        throw new RuntimeException(r11 + " already listened.");
    }
}
