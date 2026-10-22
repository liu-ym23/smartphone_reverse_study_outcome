package com.obric.assistant.interaction.impl.activityresult;

import com.obric.assistant.interaction.api.service.ActivityProxyListener;
import com.obric.assistant.interaction.impl.window.event.WindowEvent;
import com.obric.capabilitykit.common.Ext;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\rJ\u0010\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000f\u001a\u00020\bJ(\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016J\u0006\u0010\u0017\u001a\u00020\u0018J\b\u0010\u0019\u001a\u00020\bH\u0002J\u0018\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u0016H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/obric/assistant/interaction/impl/activityresult/ActivityProxyRequestStore;", "", "scheduler", "Lcom/obric/assistant/interaction/impl/activityresult/ActivityProxyRequestScheduler;", "<init>", "(Lcom/obric/assistant/interaction/impl/activityresult/ActivityProxyRequestScheduler;)V", "lock", "nextToken", "", "current", "Lcom/obric/assistant/interaction/impl/activityresult/ProxyRequest;", "install", "listener", "Lcom/obric/assistant/interaction/api/service/ActivityProxyListener;", "consume", "token", "clearIfCurrent", "", Ext.KEY_REQUEST, WindowEvent.Params.REASON, "", "cancelReason", "Lcom/obric/assistant/interaction/impl/activityresult/ActivityProxyCancelReason;", "resetForTest", "", "nextTokenLocked", "dispatchCancel", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ActivityProxyRequestStore {
    private ProxyRequest current;
    private final Object lock;
    private long nextToken;
    private final ActivityProxyRequestScheduler scheduler;

    public static /* synthetic */ void a(ActivityProxyRequestStore r0, long r1, Ref.ObjectRef r3) {
        install$lambda$1$lambda$0(r0, r1, r3);
    }

    public static /* synthetic */ void b(ActivityProxyCancelCallback r0, ActivityProxyCancelReason r1) {
        dispatchCancel$lambda$8(r0, r1);
    }

    private final long nextTokenLocked() {
        long r0 = this.nextToken + 1;
        this.nextToken = r0;
        if (r0 >= 1) goto L6;
        this.nextToken = 1;
    L6:
        return this.nextToken;
    }

    public final void resetForTest() {
        Object r0 = this.lock;
        monitor-enter(r0);
        ProxyRequest r1 = this.current;     // Catch: Throwable -> L9
        this.current = null;     // Catch: Throwable -> L9
        this.nextToken = 0;     // Catch: Throwable -> L9
        monitor-exit(r0);
        if (r1 == null) goto L14;
        this.scheduler.removeCallbacks(r1.getTimeoutRunnable());
        return;
    L14:
        return;
    L9:
        th = move-exception;
        throw th;
    }

    public ActivityProxyRequestStore(ActivityProxyRequestScheduler r2) {
        Intrinsics.checkNotNullParameter(r2, "scheduler");
        this.scheduler = r2;
        this.lock = new Object();
    }

    public final ActivityProxyListener consume(long r8) {
        if (r8 >= 1) goto L5;
        return null;
    L5:
        Object r0 = this.lock;
        monitor-enter(r0);
        ProxyRequest r1 = this.current;     // Catch: Throwable -> L21
        boolean r3 = false;
        if (r1 != null) goto L10;
    L12:
        if (r3 == false) goto L15;
        this.current = null;     // Catch: Throwable -> L21
    L16:
        monitor-exit(r0);
        if (r1 != null) goto L19;
        return null;
    L19:
        this.scheduler.removeCallbacks(r1.getTimeoutRunnable());
        return r1.getListener();
    L15:
        r1 = null;
        goto L16
    L10:
        if (r1.getToken() != r8) goto L12;
        r3 = true;
    L21:
        th = move-exception;
        throw th;
    }

    public final ProxyRequest install(ActivityProxyListener r7) {
        Intrinsics.checkNotNullParameter(r7, "listener");
        final Ref.ObjectRef r0 = new Ref.ObjectRef();
        Object r1 = this.lock;
        monitor-enter(r1);
        final long r2 = nextTokenLocked();     // Catch: Throwable -> L20
        ProxyRequest r4 = new ProxyRequest(r2, r7, new a(this, r2, r0));     // Catch: Throwable -> L20
        r0.element = r4;     // Catch: Throwable -> L20
        ProxyRequest r8 = this.current;     // Catch: Throwable -> L20
        ProxyRequest r3 = r4;     // Catch: Throwable -> L20
        this.current = r4;     // Catch: Throwable -> L20
        Unit r5 = Unit.INSTANCE;     // Catch: Throwable -> L20
        monitor-exit(r1);
        if (r8 == null) goto L8;
        this.scheduler.removeCallbacks(r8.getTimeoutRunnable());
    L8:
        ActivityProxyRequestScheduler r6 = this.scheduler;
        Object r9 = r0.element;
        if (r9 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException(Ext.KEY_REQUEST);
        ProxyRequest r10 = null;
    L12:
        r6.postDelayed(r10.getTimeoutRunnable(), ActivityProxyRequestStoreKt.PROXY_CREATE_TIMEOUT_MS);
        if (r8 == null) goto L15;
        dispatchCancel(r8, ActivityProxyCancelReason.START_REPLACED);
    L15:
        Object r11 = r0.element;
        if (r11 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException(Ext.KEY_REQUEST);
        return null;
    L19:
        return (ProxyRequest) r11;
    L11:
        r10 = (ProxyRequest) r9;
    L20:
        th = move-exception;
        throw th;
    }

    private final void dispatchCancel(ProxyRequest r3, final ActivityProxyCancelReason r4) {
        ActivityProxyListener r5 = r3.getListener();
        if ((r5 instanceof ActivityProxyCancelCallback) == false) goto L5;
        final ActivityProxyCancelCallback r6 = (ActivityProxyCancelCallback) r5;
    L6:
        if (r6 != null) goto L8;
        return;
    L8:
        this.scheduler.post(new b(r6, r4));
        return;
    L5:
        r6 = null;
        goto L6
    }

    private static final void dispatchCancel$lambda$8(ActivityProxyCancelCallback r0, ActivityProxyCancelReason r1) {
        r0.onProxyCanceled(r1);
    }

    private static final void install$lambda$1$lambda$0(ActivityProxyRequestStore r6, long r7, Ref.ObjectRef r9) {
        Object r10 = r9.element;
        if (r10 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException(Ext.KEY_REQUEST);
        ProxyRequest r11 = null;
    L6:
        r6.clearIfCurrent(r7, r11, "timeout_before_on_create", ActivityProxyCancelReason.TIMEOUT_BEFORE_ON_CREATE);
        return;
    L5:
        r11 = (ProxyRequest) r10;
        goto L6
    }

    public final boolean clearIfCurrent(long r6, ProxyRequest r8, String r9, ActivityProxyCancelReason r10) {
        Intrinsics.checkNotNullParameter(r8, Ext.KEY_REQUEST);
        Intrinsics.checkNotNullParameter(r9, WindowEvent.Params.REASON);
        if (r6 >= 1) goto L5;
        return false;
    L5:
        Object r0 = this.lock;
        monitor-enter(r0);
        ProxyRequest r1 = this.current;     // Catch: Throwable -> L22
        if (r1 == r8) goto L10;
    L13:
        r1 = null;
    L14:
        monitor-exit(r0);
        if (r1 != null) goto L17;
        return false;
    L17:
        this.scheduler.removeCallbacks(r1.getTimeoutRunnable());
        if (r10 == null) goto L27;
        dispatchCancel(r1, r10);
        return true;
    L27:
        return true;
    L10:
        if (r1.getToken() != r6) goto L13;
        this.current = null;     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        throw th;
    }
}
