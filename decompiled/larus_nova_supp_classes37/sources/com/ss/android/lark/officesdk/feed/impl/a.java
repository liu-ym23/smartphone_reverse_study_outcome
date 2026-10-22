package com.ss.android.lark.officesdk.feed.impl;

import android.app.Application;
import com.bytedance.lark.pb.basic.v1.Command;
import com.bytedance.lark.pb.tool.v1.PushLatestDoubaoIMFeatureOpened;
import com.bytedance.lark.rustclient.api.l;
import com.bytedance.lark.rustclient.api.t;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.passportc.api.m;
import com.ss.android.lark.passportc.dwarf.UserScope;
import e0c.k;
import f0c.h;
import io.reactivex.disposables.Disposable;
import java.util.concurrent.atomic.AtomicLong;
import javax.inject.Inject;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@UserScope
public final class a extends c0c.a {
    public static final /* synthetic */ int k = 0;
    public final l c;
    public final Application d;
    public final Object e;
    public final AtomicLong f;
    public final CoroutineScope g;
    public volatile String h;
    public Disposable i;
    public final FlowFeedApiProxy j;

    /* JADX INFO: renamed from: com.ss.android.lark.officesdk.feed.impl.a$a, reason: collision with other inner class name */
    public static final class C0008a {
    }

    static {
    }

    @Override // c0c.c
    public final void d(h r3) {
        Intrinsics.checkNotNullParameter(r3, "state");
        Intrinsics.checkNotNullParameter(r3, "state");
        Object r4 = this.e;
        monitor-enter(r4);
        this.f.incrementAndGet();     // Catch: Throwable -> L11
        this.h = null;     // Catch: Throwable -> L11
        Disposable r1 = this.i;     // Catch: Throwable -> L11
        if (r1 == null) goto L7;
        r1.dispose();     // Catch: Throwable -> L11
    L7:
        this.i = null;     // Catch: Throwable -> L11
        Unit r2 = Unit.INSTANCE;     // Catch: Throwable -> L11
        monitor-exit(r4);
        CoroutineScopeKt.cancel$default(this.g, null, 1, null);
        return;
    L11:
        th = move-exception;
        throw th;
    }

    @Override // c0c.c
    public final void i(h r11) {
        Intrinsics.checkNotNullParameter(r11, "state");
        Intrinsics.checkNotNullParameter(r11, "state");
        stb.a r0 = (stb.a) k.a(this.d, stb.a.class);     // Catch: Throwable -> L5
    L7:
        if (r0 == null) goto L11;
        String r1 = r0.a();
        if (r1 == null) goto L11;
        final String r2 = StringsKt.trim(r1).toString();
    L12:
        if (r2 != null) goto L15;
        r2 = "";
    L15:
        if (r2.length() != 0) goto L17;
        boolean r3 = true;
    L18:
        if (r3 == false) goto L20;
        Log.w("DoubaoIMFeatureSyncer", "start sync skipped: user id is empty");
        return;
    L20:
        this.j.K(r2);
        Log.i("DoubaoIMFeatureSyncer", "start sync");
        Ref.LongRef r4 = new Ref.LongRef();
        Object r5 = this.e;
        monitor-enter(r5);
    L36:
        th = move-exception;
        throw th;
    L23:
        if (Intrinsics.areEqual(this.h, r2) == true) goto L25;
    L29:
        Disposable r6 = this.i;     // Catch: Throwable -> L36
        if (r6 == null) goto L32;
        r6.dispose();     // Catch: Throwable -> L36
    L32:
        this.h = r2;     // Catch: Throwable -> L36
        final long r7 = this.f.incrementAndGet();     // Catch: Throwable -> L36
        r4.element = r7;     // Catch: Throwable -> L36
        this.i = t.g(this.c.i(Command.PUSH_DOUBAO_IM_FEATURE_OPENED, PushLatestDoubaoIMFeatureOpened.ADAPTER), new DoubaoIMFeatureOpenedSyncer$subscribePush$1(this, r2, r7), DoubaoIMFeatureOpenedSyncer$subscribePush$2.INSTANCE);     // Catch: Throwable -> L36
        Unit r8 = Unit.INSTANCE;     // Catch: Throwable -> L36
        monitor-exit(r5);
        BuildersKt.launch$default(this.g, null, null, new DoubaoIMFeatureOpenedSyncer$startSync$2(this, r2, r4, null), 3, null);
        return;
    L25:
        if (this.i == null) goto L29;
        Log.i("DoubaoIMFeatureSyncer", "startSync push return");     // Catch: Throwable -> L36
        monitor-exit(r5);
        return;
    L17:
        r3 = false;
    L11:
        r2 = null;
    L5:
        th = move-exception;
        Log.e("DoubaoIMFeatureSyncer", "resolve IOfficeSDKUserApi failed", th);
        r0 = null;
        goto L7
    }

    @Inject
    public a(l r2, Application r3, m r4) {
        Intrinsics.checkNotNullParameter(r2, "rustClient");
        Intrinsics.checkNotNullParameter(r3, "application");
        Intrinsics.checkNotNullParameter(r4, "passport");
        super(r4);
        this.c = r2;
        this.d = r3;
        this.e = new Object();
        this.f = new AtomicLong(0);
        this.g = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getIO()));
        this.j = new FlowFeedApiProxy();
    }

    public final void m(String r5, long r6, Boolean r8, Long r9, String r10) {
        if (r8 == null) goto L21;
        if (r9 == null) goto L21;
        Log.i("DoubaoIMFeatureSyncer", "persist IM feature update open=" + r8 + ", currentGeneration=" + r6 + ", updateTimestampMs=" + r9 + ", source=" + r10);
        Object r0 = this.e;
        monitor-enter(r0);
    L18:
        th = move-exception;
        throw th;
    L8:
        if (Intrinsics.areEqual(this.h, r5) == true) goto L10;
    L15:
        Log.w("DoubaoIMFeatureSyncer", "data not match, not updated");     // Catch: Throwable -> L18
        monitor-exit(r0);
        return;
    L10:
        if (this.f.get() != r6) goto L15;
        Log.i("DoubaoIMFeatureSyncer", r10 + " host update accepted=" + this.j.X1(r5, r8.booleanValue(), r9.longValue()));     // Catch: Throwable -> L18
        Unit r7 = Unit.INSTANCE;     // Catch: Throwable -> L18
        monitor-exit(r0);
        return;
    L21:
        Log.w("DoubaoIMFeatureSyncer", "ignore " + r10 + " without value or timestamp");
    }
}
