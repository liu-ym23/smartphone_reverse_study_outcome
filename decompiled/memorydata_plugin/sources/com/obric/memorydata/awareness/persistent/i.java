package com.obric.memorydata.awareness.persistent;

import android.content.Context;
import com.obric.memorydata.database.dao.ContextAwarenessSubscriptionDao;
import com.obric.memorydata.database.entity.at;
import com.obric.memorydata.database.manager.ContextAwarenessDbEngine;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 !2\u00020\u0001:\u0001!B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fJ\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000eJ\u001c\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u000e2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011J\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\f0\u000e2\u0006\u0010\u0010\u001a\u00020\u0011J\u0016\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011J\u000e\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0010\u001a\u00020\u0011J\u0016\u0010\u0017\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\u0019J\f\u0010\u001e\u001a\u00020\u001f*\u00020\fH\u0002J\f\u0010 \u001a\u00020\f*\u00020\u001fH\u0002R\u0018\u0010\u0006\u001a\n \u0007*\u0004\u0018\u00010\u00030\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\bR\u0014\u0010\u001a\u001a\u00020\u001b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001d¨\u0006\""}, d2 = {"Lcom/obric/memorydata/awareness/persistent/PersistentAwarenessSubscriptionStore;", "", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "appContext", "kotlin.jvm.PlatformType", "Landroid/content/Context;", "insert", "", "entity", "Lcom/obric/memorydata/awareness/persistent/PersistentAwarenessSubscription;", "listAll", "", "listByOwnerAndSubscription", "ownerPackage", "", "subscriptionId", "listByOwner", "deleteByOwnerAndSubscription", "", "deleteAllByOwner", "updateLastMatched", "matched", "", "dao", "Lcom/obric/memorydata/database/dao/ContextAwarenessSubscriptionDao;", "getDao", "()Lcom/obric/memorydata/database/dao/ContextAwarenessSubscriptionDao;", "toDbEntity", "Lcom/obric/memorydata/database/entity/ContextAwarenessSubscriptionEntity;", "toRuntimeEntity", "Companion", "awareness_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final a f8777a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Context f8778b;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/obric/memorydata/awareness/persistent/PersistentAwarenessSubscriptionStore$Companion;", "", "<init>", "()V", "TAG", "", "awareness_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        f8777a = new a(null);
    }

    public i(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "context");
        this.f8778b = ZeusTransformUtils.wrapperContext((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r4.getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin");
    }

    private final h a(at r8) {
        return new h(r8.b(), r8.c(), r8.d(), r8.e(), r8.f(), r8.g());
    }

    private final at a(h r12) {
        return new at(0, r12.a(), r12.b(), r12.c(), r12.d(), r12.e(), r12.f(), 1, null);
    }

    private final ContextAwarenessSubscriptionDao b() {
        ContextAwarenessDbEngine r0 = ContextAwarenessDbEngine.f9556a;
        Context r2 = this.f8778b;
        Intrinsics.checkNotNullExpressionValue(r2, "appContext");
        return r0.a(r2).subscriptionDao();
    }

    public final synchronized List<h> a() {
        monitor-enter(this);
        Iterable r0 = (Iterable) ZeusTransformUtils.preCheckCast(b().listAll(), Iterable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        Collection r1 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r0, 10)), Collection.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        Iterator r2 = r0.iterator();     // Catch: Throwable -> L10
    L5:
        if (r2.hasNext() == false) goto L7;
        r1.add(a((at) ZeusTransformUtils.preCheckCast(r2.next(), at.class, "com.obric.memorydata.plugin")));     // Catch: Throwable -> L10
        goto L5
    L7:
        List<h> r3 = (List) ZeusTransformUtils.preCheckCast(r1, List.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "PersistentAwarenessSubscriptionStore", "listAll subscriptions size=" + r3.size(), false, 4, null);     // Catch: Throwable -> L10
        monitor-exit(this);
        return r3;
    L10:
        th = move-exception;
        throw th;
    }

    public final synchronized List<h> a(String r9) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r9, "ownerPackage");     // Catch: Throwable -> L10
        Iterable r0 = (Iterable) ZeusTransformUtils.preCheckCast(b().listByOwner(r9), Iterable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        Collection r1 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r0, 10)), Collection.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        Iterator r2 = r0.iterator();     // Catch: Throwable -> L10
    L5:
        if (r2.hasNext() == false) goto L7;
        r1.add(a((at) ZeusTransformUtils.preCheckCast(r2.next(), at.class, "com.obric.memorydata.plugin")));     // Catch: Throwable -> L10
        goto L5
    L7:
        List<h> r3 = (List) ZeusTransformUtils.preCheckCast(r1, List.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "PersistentAwarenessSubscriptionStore", "listByOwner owner=" + r9 + " size=" + r3.size(), false, 4, null);     // Catch: Throwable -> L10
        monitor-exit(this);
        return r3;
    L10:
        th = move-exception;
        throw th;
    }

    public final synchronized List<h> a(String r9, String r10) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r9, "ownerPackage");     // Catch: Throwable -> L10
        Intrinsics.checkNotNullParameter(r10, "subscriptionId");     // Catch: Throwable -> L10
        Iterable r0 = (Iterable) ZeusTransformUtils.preCheckCast(b().listByOwnerAndSubscription(r9, r10), Iterable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        Collection r1 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r0, 10)), Collection.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        Iterator r2 = r0.iterator();     // Catch: Throwable -> L10
    L5:
        if (r2.hasNext() == false) goto L7;
        r1.add(a((at) ZeusTransformUtils.preCheckCast(r2.next(), at.class, "com.obric.memorydata.plugin")));     // Catch: Throwable -> L10
        goto L5
    L7:
        List<h> r3 = (List) ZeusTransformUtils.preCheckCast(r1, List.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "PersistentAwarenessSubscriptionStore", "listByOwnerAndSubscription owner=" + r9 + " subscriptionId=" + r10 + " size=" + r3.size(), false, 4, null);     // Catch: Throwable -> L10
        monitor-exit(this);
        return r3;
    L10:
        th = move-exception;
        throw th;
    }

    public final synchronized void a(h r9, boolean r10) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r9, "entity");     // Catch: Throwable -> L6
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "PersistentAwarenessSubscriptionStore", "updateLastMatched count=" + b().updateLastMatched(r9.a(), r9.b(), r9.c(), r9.d(), r10) + " matched=" + r10 + ' ' + r9.i(), false, 4, null);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public final synchronized int b(String r9) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r9, "ownerPackage");     // Catch: Throwable -> L6
        int r0 = b().deleteAllByOwner(r9);     // Catch: Throwable -> L6
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "PersistentAwarenessSubscriptionStore", "deleteAllByOwner count=" + r0 + " owner=" + r9, false, 4, null);     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    public final synchronized int b(String r9, String r10) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r9, "ownerPackage");     // Catch: Throwable -> L6
        Intrinsics.checkNotNullParameter(r10, "subscriptionId");     // Catch: Throwable -> L6
        int r0 = b().deleteByOwnerAndSubscription(r9, r10);     // Catch: Throwable -> L6
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "PersistentAwarenessSubscriptionStore", "deleteByOwnerAndSubscription count=" + r0 + " owner=" + r9 + " subscriptionId=" + r10, false, 4, null);     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    public final synchronized void insert(h r10) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r10, "entity");     // Catch: Throwable -> L6
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "PersistentAwarenessSubscriptionStore", "insert subscription rowId=" + b().insert(a(r10)) + ' ' + r10.i(), false, 4, null);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }
}
