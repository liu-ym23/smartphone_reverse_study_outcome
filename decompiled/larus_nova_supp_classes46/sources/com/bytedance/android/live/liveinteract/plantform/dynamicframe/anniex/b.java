package com.bytedance.android.live.liveinteract.plantform.dynamicframe.anniex;

import android.view.View;
import com.bytedance.android.annie.api.card.HybridCard;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.liveinteract.utils.w0;
import com.bytedance.android.live.revenue.platform.container.impl.d0;
import com.bytedance.android.scope.m;
import com.google.gson.JsonObject;
import cy0.j;
import io.reactivex.Completable;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.json.JSONObject;
import vm2.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class b implements ih0.c, uh6.a {
    public final AtomicBoolean a;
    public final Boolean b;
    public Disposable c;
    public final boolean d;
    public final HybridCard e;

    @Override // ih0.c
    public final void N(long r1) {
    }

    @Override // ih0.c
    public final void f1() {
    }

    @Override // ih0.c
    public final void J() {
        HybridCard r0 = this.e;
        if (r0 == null) goto L6;
        UtilityKotlinExtentionsKt.q(r0);
        return;
    }

    public final void dispose() {
        this.c.dispose();
        if (this.a.getAndSet(true) == false) goto L5;
        return;
    L5:
        HybridCard r0 = this.e;
        if (r0 == null) goto L9;
        r0.release();
        return;
    }

    @Override // ih0.c
    public final View getHybridView() {
        HybridCard r0 = this.e;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getHybridView();
    }

    public final boolean isDisposed() {
        return this.a.get();
    }

    @Override // ih0.c
    public final void r1() {
        this.c.dispose();
        cy0.e.a.getClass();
        j r0 = cy0.e.a.a;
        m.e.getClass();
        Object r1 = m.b(r0).a(Reflection.getOrCreateKotlinClass(uh6.b.class));
        Intrinsics.checkNotNull(r1);
        this.c = ((f80.a) r1).h(this, null);
    }

    @Override // ih0.c
    public final Completable onLoadSuccess() {
        return Completable.complete();
    }

    @Override // ih0.c
    public final Boolean A() {
        return this.b;
    }

    @Override // ih0.c
    public final View S0() {
        return this.e;
    }

    @Override // ih0.c
    public final void release() {
        dispose();
    }

    public b(HybridCard r3) {
        this.e = r3;
        this.a = new AtomicBoolean(false);
        if (r3 == null) goto L5;
        r3.containerId();
    L5:
        if (r3 == null) goto L7;
        Boolean r4 = Boolean.valueOf(r3.getLoadSuccess());
    L8:
        this.b = r4;
        this.c = Disposables.disposed();
        int r5 = w0.a;
        this.d = h.i().enableJsbTransferOpt();
        return;
    L7:
        r4 = null;
        goto L8
    }

    @Override // ih0.c
    public final void updateData(Map<String, ? extends Object> r2) {
        Intrinsics.checkNotNullParameter(r2, "data");
        HybridCard r0 = this.e;
        if (r0 == null) goto L6;
        r0.updateData(r2);
        return;
    }

    @Override // ih0.c
    public final void updateGlobalProps(Map<String, ? extends Object> r2) {
        HybridCard r0 = this.e;
        if (r0 == null) goto L6;
        r0.updateGlobalProps(r2);
        return;
    }

    public final void b(String r2, d0 r3) {
        Intrinsics.checkNotNullParameter(r2, "eventName");
        Intrinsics.checkNotNullParameter(r3, "method");
        registerMethod(r2, new a(r3));
    }

    @Override // ih0.c
    public final void h(Map r2, Map r3) {
        HybridCard r4 = this.e;
        if (r4 == null) goto L6;
        a7.a.a(r4, null, null, 3);
        return;
    }

    @Override // ih0.c
    public final void registerMethod(String r2, com.bytedance.ies.web.jsbridge2.f.b r3) {
        Intrinsics.checkNotNullParameter(r2, "name");
        Intrinsics.checkNotNullParameter(r3, "methodProvider");
        HybridCard r0 = this.e;
        if (r0 == null) goto L6;
        r0.registerMethod(r2, r3);
        return;
    }

    @Override // ih0.c
    public final void sendJsEvent(String r2, Object r3) {
        Intrinsics.checkNotNullParameter(r2, "name");
        Intrinsics.checkNotNullParameter(r3, "data");
    L14:
        e = move-exception;
        ALogger.e("AnnieCardImpl_MultiLink", "sendJsEvent error", e);
        return;
    L4:
        if (this.d == true) goto L6;
    L10:
        HybridCard r0 = this.e;     // Catch: Exception -> L14
        if (r0 == null) goto L17;
        r0.sendJsEvent(r2, r3);     // Catch: Exception -> L14
    L17:
        return;
    L6:
        if ((r3 instanceof JsonObject) == false) goto L10;
        JSONObject r4 = tv5.a.b(r3);     // Catch: Exception -> L14
        HybridCard r1 = this.e;     // Catch: Exception -> L14
        if (r1 == null) goto L17;
        r1.sendJsEvent(r2, r4);     // Catch: Exception -> L14
        goto L17
    }
}
