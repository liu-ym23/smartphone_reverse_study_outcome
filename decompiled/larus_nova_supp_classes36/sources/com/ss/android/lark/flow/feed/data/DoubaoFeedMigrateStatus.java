package com.ss.android.lark.flow.feed.data;

import com.bytedance.lark.rustclient.api.l;
import com.ss.android.lark.flow.feed.utils.b;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.passportc.api.m;
import com.ss.android.lark.passportc.api.r;
import com.ss.android.lark.passportc.dwarf.UserScope;
import com.ss.android.lark.storage.kv.repo.KVRepo;
import f0c.h;
import io.reactivex.disposables.Disposable;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@UserScope
public final class DoubaoFeedMigrateStatus implements com.ss.android.lark.flow.feed.data.a, r {
    public static final List<com.bytedance.lark.pb.feed.v1.DoubaoFeedMigrateStatus> j = null;
    public static final AtomicBoolean k = null;
    public final String a;
    public final l b;
    public final m c;
    public final Lazy d;
    public final Lazy e;
    public final Set<hza.a> f;
    public final AtomicBoolean g;
    public final CoroutineScope h;
    public final Lazy i;

    public static final class a {
    }

    public final void afterUserOffline(h r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
    }

    public final void onUserOnline(h r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
    }

    static {
        j = CollectionsKt.listOf(new com.bytedance.lark.pb.feed.v1.DoubaoFeedMigrateStatus[]{com.bytedance.lark.pb.feed.v1.DoubaoFeedMigrateStatus.MIGRATE_STATUS_PROCESSED_FIRST_SCREEN, com.bytedance.lark.pb.feed.v1.DoubaoFeedMigrateStatus.MIGRATE_STATUS_FINISHED});
        k = new AtomicBoolean(false);
    }

    public final void d() {
        Disposable r0 = (Disposable) this.i.getValue();
        if (f().get() == false) goto L7;
        b.d("DoubaoFeedMigrateStatus", "not need to fetch migrate status");
        return;
    L7:
        if (this.g.compareAndSet(false, true) == true) goto L10;
        b.d("DoubaoFeedMigrateStatus", "has already fetch migrate status");
        return;
    L10:
        BuildersKt.launch$default(this.h, null, null, new DoubaoFeedMigrateStatus$ensureSubscribed$1(this, null), 3, null);
    }

    public final KVRepo e() {
        return (KVRepo) this.d.getValue();
    }

    public final AtomicBoolean f() {
        return (AtomicBoolean) this.e.getValue();
    }

    @Override // com.ss.android.lark.flow.feed.data.a
    public final boolean b() {
        d();
        boolean r0 = f().get();
        b.d("DoubaoFeedMigrateStatus", "isMigrateFinished value: " + r0 + ' ');
        return r0;
    }

    public final void g() {
        if (f().compareAndSet(false, true) == false) goto L12;
        e().putBoolean("mixed_feed_migrate", true);
        b.d("DoubaoFeedMigrateStatus", "migrate finished, notify " + ((CopyOnWriteArraySet) this.f).size() + " listeners");
        Iterator<T> r0 = this.f.iterator();
    L6:
        if (r0.hasNext() == false) goto L19;
        hza.a r1 = (hza.a) r0.next();
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L10
        r1.a(this.c.getUser().userId);     // Catch: Throwable -> L10
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        Result.Companion r3 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L6
    L19:
        return;
    }

    public final m getPassport() {
        return this.c;
    }

    @Override // com.ss.android.lark.flow.feed.data.a
    public final void a(hza.a r3) {
        Intrinsics.checkNotNullParameter(r3, "listener");
        b.d("DoubaoFeedMigrateStatus", "add migrate listener");
        d();
        ((CopyOnWriteArraySet) this.f).add(r3);
        if (f().get() == false) goto L5;
        r3.a(this.c.getUser().userId);
        return;
    L5:
        b.d("DoubaoFeedMigrateStatus", "migrate is not finished yet");
    }

    public final void afterUserOnline(h r6) {
        Intrinsics.checkNotNullParameter(r6, "state");
        Intrinsics.checkNotNullParameter(r6, "state");
        if (k.compareAndSet(true, false) == false) goto L14;
        b.d("DoubaoFeedMigrateStatus", "afterUserOnline consume pendingClearMigrateStatus, force clear migrate status");
        b.d("DoubaoFeedMigrateStatus", "clearMigrateStatusAndRefresh invoked");
        f().set(false);
        Result.Companion r7 = Result.Companion;     // Catch: Throwable -> L7
        e().remove("mixed_feed_migrate");     // Catch: Throwable -> L7
        Object r8 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L7
    L9:
        Throwable r9 = Result.exceptionOrNull-impl(r8);
        if (r9 == null) goto L12;
        Intrinsics.checkNotNullParameter("DoubaoFeedMigrateStatus", "tag");
        Log.e("DoubaoFeedMigrateStatus", "[FlowFeedLog] ".concat("clearMigrateStatus error"), r9, true);
    L12:
        this.g.set(false);
        d();
        return;
    L7:
        th = move-exception;
        Result.Companion r3 = Result.Companion;
        r8 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L9
    L14:
        d();
    }

    @Override // com.ss.android.lark.flow.feed.data.a
    public final void c(hza.a r3) {
        Intrinsics.checkNotNullParameter(r3, "listener");
        b.d("DoubaoFeedMigrateStatus", "remove migrate listener");
        ((CopyOnWriteArraySet) this.f).remove(r3);
    }

    public final void onUserOffline(h r3) {
        Intrinsics.checkNotNullParameter(r3, "state");
        Intrinsics.checkNotNullParameter(r3, "state");
        Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L5
        ((Disposable) this.i.getValue()).dispose();     // Catch: Throwable -> L5
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L5
    L13:
        CoroutineScopeKt.cancel$default(this.h, null, 1, null);     // Catch: Throwable -> L9
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L9
    L11:
        ((CopyOnWriteArraySet) this.f).clear();
        return;
    L9:
        th = move-exception;
        Result.Companion r0 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
    L5:
        th = move-exception;
        Result.Companion r1 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L13
    }

    @Inject
    public DoubaoFeedMigrateStatus(String r2, l r3, m r4) {
        Intrinsics.checkNotNullParameter(r2, "currentUserId");
        Intrinsics.checkNotNullParameter(r3, "userRustClient");
        Intrinsics.checkNotNullParameter(r4, "passport");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        LazyThreadSafetyMode r5 = LazyThreadSafetyMode.SYNCHRONIZED;
        this.d = LazyKt.lazy(r5, DoubaoFeedMigrateStatus$kvRepo$2.INSTANCE);
        this.e = LazyKt.lazy(r5, new DoubaoFeedMigrateStatus$migrateFinished$2(this));
        this.f = new CopyOnWriteArraySet();
        this.g = new AtomicBoolean(false);
        this.h = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getIO()));
        this.i = LazyKt.lazy(r5, new DoubaoFeedMigrateStatus$pushDisposable$2(this));
        r4.d(this);
    }
}
