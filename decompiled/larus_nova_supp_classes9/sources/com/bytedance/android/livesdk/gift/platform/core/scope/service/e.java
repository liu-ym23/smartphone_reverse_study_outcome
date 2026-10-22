package com.bytedance.android.livesdk.gift.platform.core.scope.service;

import io.reactivex.SingleEmitter;
import io.reactivex.SingleOnSubscribe;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class e<T> implements SingleOnSubscribe {
    public final /* synthetic */ d a;
    public final /* synthetic */ com.bytedance.android.live.core.resources.e b;
    public final /* synthetic */ Map c;

    public e(d r1, com.bytedance.android.live.core.resources.e r2, Map r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void subscribe(SingleEmitter<Object> r7) {
        Intrinsics.checkNotNullParameter(r7, "it");
        HashMap<String, d.a> r8 = this.a.a;
        monitor-enter(r8);
        com.bytedance.android.live.core.resources.b r0 = this.b.getCleanStrategy();     // Catch: Throwable -> L33
        if (r0 != null) goto L7;
    L16:
        boolean r1 = false;
    L17:
        Map r2 = this.c;     // Catch: Throwable -> L33
        if (r2 == null) goto L27;
        Iterator r3 = r2.entrySet().iterator();     // Catch: Throwable -> L33
    L21:
        if (r3.hasNext() == false) goto L27;
        Map.Entry r4 = (Map.Entry) r3.next();     // Catch: Throwable -> L33
        Iterator<Map.Entry<String, d.a>> r5 = this.a.a.entrySet().iterator();     // Catch: Throwable -> L33
    L24:
        if (r5.hasNext() == false) goto L26;
        r5.next().getValue().get(r4.getKey());     // Catch: Throwable -> L33
        goto L24
    L26:
        r1 = true;
    L27:
        this.a.c("onAssetUsed");     // Catch: Throwable -> L33
        if (r1 == false) goto L30;
        d.a(this.a);     // Catch: Throwable -> L33
    L30:
        Unit r6 = Unit.INSTANCE;     // Catch: Throwable -> L33
        monitor-exit(r8);
        return;
    L7:
        if (r0.getCleanType() != 1) goto L16;
        com.bytedance.android.live.core.resources.b r9 = this.b.getCleanStrategy();     // Catch: Throwable -> L33
        if (r9 == null) goto L11;
        String r10 = r9.getAssetType();     // Catch: Throwable -> L33
    L12:
        d.a r11 = this.a.a.get(r10);     // Catch: Throwable -> L33
        if (r11 == null) goto L15;
        Pair<? extends Integer, ? extends String> r13 = r11.get(Long.valueOf(this.b.getId()));     // Catch: Throwable -> L33
    L15:
        r1 = true;
        goto L17
    L11:
        r10 = null;
    L33:
        th = move-exception;
        throw th;
    }
}
