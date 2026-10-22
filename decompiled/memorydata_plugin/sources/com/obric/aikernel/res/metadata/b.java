package com.obric.aikernel.res.metadata;

import com.obric.aikernel.res.PackageResourceManager;
import com.obric.aikernel.runtime.utils.d;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.al;
import kotlinx.coroutines.channels.i;
import kotlinx.coroutines.channels.l;
import kotlinx.coroutines.channels.m;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u0010J\u000e\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u000bJ\u000e\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u000bR\u001a\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/obric/aikernel/res/metadata/PackagesListener;", "", "scope", "Lkotlinx/coroutines/CoroutineScope;", "(Lkotlinx/coroutines/CoroutineScope;)V", "listenerChannel", "Lkotlinx/coroutines/channels/Channel;", "Lkotlin/Function0;", "", "packageListener", "", "Lcom/obric/aikernel/res/metadata/IPackageListener;", "notifyPackageChanged", "pkg", "Lcom/obric/aikernel/res/metadata/data/AIPackage;", "remove", "", "registerPackageListener", "observer", "unregisterPackageListener", "resource_manager_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<a> f6056a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final i<Function0<Unit>> f6057b;

    public b(al r9) {
        al r2 = (al) ZeusTransformUtils.wrapperContextForParams(r9, al.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r2, "scope");
        this.f6056a = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        this.f6057b = l.a(Integer.MAX_VALUE, null, null, 6, null);
        kotlinx.coroutines.i.a(r2, null, null, (Function2) ZeusTransformUtils.preCheckCast(new PackagesListener$1(this, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
    }

    public static final /* synthetic */ i a(b r0) {
        return r0.f6057b;
    }

    public static /* synthetic */ void a(b r0, com.obric.aikernel.res.metadata.data.b r1, boolean r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = false;
    L5:
        r0.a(r1, r2);
    }

    public final void a(a r3) {
        a r4 = (a) ZeusTransformUtils.wrapperContextForParams(r3, a.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "observer");
        List<a> r0 = this.f6056a;
        monitor-enter(r0);
        this.f6056a.add(r4);     // Catch: Throwable -> L7
        monitor-exit(r0);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public final void a(final com.obric.aikernel.res.metadata.data.b r8, final boolean r9) {
        Intrinsics.checkNotNullParameter(r8, "pkg");
        List<a> r0 = this.f6056a;
        monitor-enter(r0);
        Iterator r1 = ((Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.toList((Iterable) ZeusTransformUtils.preCheckCast(this.f6056a, Iterable.class, "com.obric.memorydata.plugin")), Iterable.class, "com.obric.memorydata.plugin")).iterator();     // Catch: Throwable -> L13
    L6:
        if (r1.hasNext() == false) goto L10;
        final a r2 = (a) ZeusTransformUtils.preCheckCast(r1.next(), a.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L13
        Object r3 = this.f6057b.mo54trySendJP2dKIU(new PackagesListener$notifyPackageChanged$1$1$1(r2, r8, r9));     // Catch: Throwable -> L13
        if (ZeusTransformUtils.instanceOf(r3, m.c.class) == false) goto L6;
        d.f6216a.g(PackageResourceManager.TAG, "send onPackageChanged " + r8 + ' ' + r9 + " error: " + m.e(r3));     // Catch: Throwable -> L13
        goto L6
    L10:
        Unit r7 = Unit.INSTANCE;     // Catch: Throwable -> L13
        monitor-exit(r0);
        return;
    L13:
        th = move-exception;
        throw th;
    }

    public final void b(a r3) {
        a r4 = (a) ZeusTransformUtils.wrapperContextForParams(r3, a.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "observer");
        List<a> r0 = this.f6056a;
        monitor-enter(r0);
        this.f6056a.remove(r4);     // Catch: Throwable -> L7
        monitor-exit(r0);
        return;
    L7:
        th = move-exception;
        throw th;
    }
}
