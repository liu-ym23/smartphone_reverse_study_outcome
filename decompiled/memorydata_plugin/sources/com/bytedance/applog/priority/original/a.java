package com.bytedance.applog.priority.original;

import com.bytedance.crash.constants.Constants;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ(\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\fJ(\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0017\u001a\u00020\f2\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\fJ\u0006\u0010 \u001a\u00020\u0016J\u000e\u0010!\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\fJ\u000e\u0010\"\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\fJ#\u0010#\u001a\u00020\u001d2\u0006\u0010$\u001a\u00020%2\b\b\u0002\u0010&\u001a\u00020\u001dH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010'J\u0019\u0010(\u001a\u00020\u00162\u0006\u0010)\u001a\u00020*H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010+R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u000f\u001a\u00020\u00108BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0011\u0010\u0012\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006,"}, d2 = {"Lcom/bytedance/applog/priority/original/AppSession;", "", "context", "Lcom/bytedance/applog/priority/PriorityContext;", "listener", "Lcom/bytedance/applog/priority/original/AppSessionListener;", "eventTracker", "Lcom/bytedance/applog/priority/original/EventTracker;", "(Lcom/bytedance/applog/priority/PriorityContext;Lcom/bytedance/applog/priority/original/AppSessionListener;Lcom/bytedance/applog/priority/original/EventTracker;)V", "getContext", "()Lcom/bytedance/applog/priority/PriorityContext;", "currentSessionId", "", "packingHistorySessionMutex", "Lkotlinx/coroutines/sync/Mutex;", "store", "Lcom/bytedance/applog/priority/original/SessionDatabase;", "getStore", "()Lcom/bytedance/applog/priority/original/SessionDatabase;", "store$delegate", "Lkotlin/Lazy;", "addPageDuration", "", ObricMemoryConstants.KEY_SESSION_ID, "pageName", "duration", "", "extraParams", "newSession", "", "isForegroundSession", "timestamp", "packHistorySessionEvents", "removeLaunch", "removeTerminate", "trackLaunch", Constants.LAUNCH_TAG, "Lcom/bytedance/applog/priority/original/AppSessionLaunch;", "removable", "(Lcom/bytedance/applog/priority/original/AppSessionLaunch;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "trackTerminate", "session", "Lcom/bytedance/applog/priority/original/AppSessionTerminate;", "(Lcom/bytedance/applog/priority/original/AppSessionTerminate;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "priority_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.bytedance.applog.priority.g f1826a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final c f1827b;
    private final l c;
    private volatile String d;
    private final kotlinx.coroutines.sync.a e;
    private final Lazy f;

    public a(com.bytedance.applog.priority.g r3, c r4, l r5) {
        c r6 = (c) ZeusTransformUtils.wrapperContextForParams(r4, c.class, "com.obric.memorydata.plugin");
        l r7 = (l) ZeusTransformUtils.wrapperContextForParams(r5, l.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r6, "listener");
        Intrinsics.checkNotNullParameter(r7, "eventTracker");
        this.f1826a = r3;
        this.f1827b = r6;
        this.c = r7;
        this.e = kotlinx.coroutines.sync.c.a(false, 1, null);
        this.f = LazyKt.lazy((Function0) ZeusTransformUtils.preCheckCast(new AppSession$store$2(this), Function0.class, "com.obric.memorydata.plugin"));
    }

    public static final /* synthetic */ r a(a r0) {
        return r0.b();
    }

    public static /* synthetic */ Object a(a r1, b r2, boolean r3, Continuation r4, int r5, Object r6) {
        Continuation<? super Boolean> r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
        if ((r5 & 2) == 0) goto L6;
        r3 = true;
    L6:
        return r1.a(r2, r3, r7);
    }

    private final r b() {
        return (r) ZeusTransformUtils.preCheckCast(this.f.getValue(), r.class, "com.obric.memorydata.plugin");
    }

    public static final /* synthetic */ kotlinx.coroutines.sync.a b(a r0) {
        return r0.e;
    }

    public final Object a(final b r6, boolean r7, Continuation<? super Boolean> r8) {
        Continuation r9 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r8, Continuation.class, "com.obric.memorydata.plugin");
        this.f1826a.b().a("AppSession:trackLaunch", (Function0) ZeusTransformUtils.preCheckCast(new AppSession$trackLaunch$2(r6), Function0.class, "com.obric.memorydata.plugin"));
        final boolean r10 = this.c.a(Constants.LAUNCH_TAG, Model.EventType.Launch.getType(), LazyKt.lazy((Function0) ZeusTransformUtils.preCheckCast(new AppSession$trackLaunch$inserted$1(r6, this), Function0.class, "com.obric.memorydata.plugin")));
        this.f1826a.a().f().monitorIncreaseStats("priority_collect_launch", 1);
        this.f1826a.b().a("AppSession:trackLaunch", (Function0) ZeusTransformUtils.preCheckCast(new AppSession$trackLaunch$3(r6, r10), Function0.class, "com.obric.memorydata.plugin"));
        if (r10 == false) goto L7;
        if (r7 == false) goto L7;
        a(r6.a());
    L7:
        return Boxing.boxBoolean(r10);
    }

    public final Object a(final d r6, Continuation<? super Unit> r7) {
        Continuation r8 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r7, Continuation.class, "com.obric.memorydata.plugin");
        this.f1826a.b().a("AppSession:trackTerminate", (Function0) ZeusTransformUtils.preCheckCast(new AppSession$trackTerminate$2(r6), Function0.class, "com.obric.memorydata.plugin"));
        final boolean r9 = this.c.a("terminate", Model.EventType.Terminate.getType(), LazyKt.lazy((Function0) ZeusTransformUtils.preCheckCast(new AppSession$trackTerminate$inserted$1(r6, this), Function0.class, "com.obric.memorydata.plugin")));
        this.f1826a.a().f().monitorIncreaseStats("priority_collect_terminate", 1);
        this.f1826a.b().a("AppSession:trackTerminate", (Function0) ZeusTransformUtils.preCheckCast(new AppSession$trackTerminate$3(r6, r9), Function0.class, "com.obric.memorydata.plugin"));
        if (r9 == false) goto L6;
        b(r6.a());
    L6:
        return Unit.INSTANCE;
    }

    public final void a() {
        this.f1826a.b().a("AppSession:packHistorySessionEvents", (Function0) ZeusTransformUtils.preCheckCast(new AppSession$packHistorySessionEvents$1(this), Function0.class, "com.obric.memorydata.plugin"));
        e.a((Function1) ZeusTransformUtils.preCheckCast(new AppSession$packHistorySessionEvents$2(this, this.d, null), Function1.class, "com.obric.memorydata.plugin"));
    }

    public final void a(final String r5) {
        Intrinsics.checkNotNullParameter(r5, ObricMemoryConstants.KEY_SESSION_ID);
        this.f1826a.b().a("AppSession:removeSessionLaunch", (Function0) ZeusTransformUtils.preCheckCast(new AppSession$removeLaunch$1(r5), Function0.class, "com.obric.memorydata.plugin"));
        b().a(r5);
        this.f1826a.b().a("AppSession:removeSessionLaunch", (Function0) ZeusTransformUtils.preCheckCast(new AppSession$removeLaunch$2(r5), Function0.class, "com.obric.memorydata.plugin"));
    }

    public final void a(final String r10, final String r11, final long r12, String r14) {
        Intrinsics.checkNotNullParameter(r10, ObricMemoryConstants.KEY_SESSION_ID);
        Intrinsics.checkNotNullParameter(r11, "pageName");
        this.f1826a.b().a("AppSession:addDuration", (Function0) ZeusTransformUtils.preCheckCast(new AppSession$addPageDuration$1(r10, r11, r12), Function0.class, "com.obric.memorydata.plugin"));
        b().a(r10, r11, r12, r14);
    }

    public final boolean a(final String r16, final boolean r17, long r18, String r20) {
        Intrinsics.checkNotNullParameter(r16, ObricMemoryConstants.KEY_SESSION_ID);
        this.f1826a.b().a("AppSession:newSession", (Function0) ZeusTransformUtils.preCheckCast(new AppSession$newSession$1(r16, r17), Function0.class, "com.obric.memorydata.plugin"));
        final String r12 = this.d;
        this.d = r16;
        if (((Boolean) ZeusTransformUtils.preCheckCast(kotlinx.coroutines.i.a(null, (Function2) ZeusTransformUtils.preCheckCast(new AppSession$newSession$success$1(this, new b(r16, r17, e.b(r20), r18), r16, r17, r20, null), Function2.class, "com.obric.memorydata.plugin"), 1, null), Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == true) goto L7;
        return false;
    L7:
        if (Intrinsics.areEqual(r12, this.d) == true) goto L13;
        this.f1826a.b().a("AppSession:newSession", (Function0) ZeusTransformUtils.preCheckCast(new AppSession$newSession$2(r12, r16, r17), Function0.class, "com.obric.memorydata.plugin"));
        a();
        this.f1827b.a(r17, r16, r12);     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        this.f1826a.b().a("AppSession:newSession", th, (Function0) ZeusTransformUtils.preCheckCast(AppSession$newSession$3.INSTANCE, Function0.class, "com.obric.memorydata.plugin"));
    L13:
        return true;
    }

    public final void b(final String r5) {
        Intrinsics.checkNotNullParameter(r5, ObricMemoryConstants.KEY_SESSION_ID);
        this.f1826a.b().a("AppSession:removeSessionTerminate", (Function0) ZeusTransformUtils.preCheckCast(new AppSession$removeTerminate$1(r5), Function0.class, "com.obric.memorydata.plugin"));
        b().b(r5);
        this.f1826a.b().a("AppSession:removeSessionTerminate", (Function0) ZeusTransformUtils.preCheckCast(new AppSession$removeTerminate$2(r5), Function0.class, "com.obric.memorydata.plugin"));
    }

    public final com.bytedance.applog.priority.g getContext() {
        return this.f1826a;
    }
}
