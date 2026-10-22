package com.bytedance.android.live.broadcastgame.opengame.runtime;

import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u0006B\u0011\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/opengame/runtime/BootInfoService;", "Ly10/a;", "Lcom/bytedance/android/live/broadcastgame/opengame/runtime/PluginContext;", "pluginContext", "<init>", "(Lcom/bytedance/android/live/broadcastgame/opengame/runtime/PluginContext;)V", "a", "livebroadcastgame-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class BootInfoService implements y10.a {
    public static final /* synthetic */ int c = 0;
    public final Lazy a;
    public final PluginContext b;

    public static final class a {
    }

    static {
    }

    public final g c() {
        return (g) this.a.getValue();
    }

    @Override // y10.a
    public final void g() {
    }

    public final boolean a() {
        g r0 = c();
        if (r0 == null) goto L15;
        j r1 = r0.b;
        if (r1 == null) goto L20;
        List<com.bytedance.android.live.broadcastgame.opengame.network.a.C0064a> r2 = r1.a;
        if (r2 == null) goto L21;
        Iterator<T> r3 = r2.iterator();
    L10:
        if (r3.hasNext() == false) goto L22;
        if (Intrinsics.areEqual(((com.bytedance.android.live.broadcastgame.opengame.network.a.C0064a) r3.next()).c(), "switchScreen") == false) goto L10;
        return true;
    L22:
        return false;
    L21:
        return false;
    L20:
        return false;
    L15:
        return false;
    }

    public final String e() {
        g r0 = c();
        if (r0 == null) goto L8;
        j r1 = r0.b;
        if (r1 == null) goto L8;
        String r2 = r1.f;
        if (r2 == null) goto L8;
        return r2;
    L8:
        return "unknown";
    }

    public BootInfoService(PluginContext r2) {
        Intrinsics.checkNotNullParameter(r2, "pluginContext");
        this.b = r2;
        this.a = LazyKt.lazy(new BootInfoService$bootInfo$2(this));
    }

    public final String b(String r6) {
        Intrinsics.checkNotNullParameter(r6, "cipherText");
        long r0 = this.b.m.a;
        g r2 = c();
        if (r2 == null) goto L5;
        String r3 = r2.a;
    L6:
        if (r3 != null) goto L8;
    L15:
        return null;
    L8:
        if (r6.length() != 0) goto L10;
        boolean r4 = true;
    L11:
        if (r4 == true) goto L15;
        return com.bytedance.android.live.broadcastgame.opengame.utils.f.b(r6, r0, r3);
    L10:
        r4 = false;
        goto L11
    L5:
        r3 = null;
        goto L6
    }

    public final com.bytedance.android.live.broadcastgame.opengame.openapi.p d(String r4) {
        Intrinsics.checkNotNullParameter(r4, "method");
        g r0 = c();
        if (r0 == null) goto L15;
        j r1 = r0.b;
        if (r1 == null) goto L20;
        List<com.bytedance.android.live.broadcastgame.opengame.network.a.C0064a> r2 = r1.a;
        if (r2 == null) goto L21;
        Iterator<T> r3 = r2.iterator();
    L10:
        if (r3.hasNext() == false) goto L22;
        com.bytedance.android.live.broadcastgame.opengame.network.a.C0064a r5 = (com.bytedance.android.live.broadcastgame.opengame.network.a.C0064a) r3.next();
        if (Intrinsics.areEqual(r4, r5.c()) == false) goto L10;
        return new com.bytedance.android.live.broadcastgame.opengame.openapi.p(r5.b(), r5.d());
    L22:
        return null;
    L21:
        return null;
    L20:
        return null;
    L15:
        return null;
    }
}
