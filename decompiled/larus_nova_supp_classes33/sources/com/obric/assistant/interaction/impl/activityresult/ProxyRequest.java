package com.obric.assistant.interaction.impl.activityresult;

import com.obric.assistant.interaction.api.service.ActivityProxyListener;
import com.obric.assistant.interaction.api.service.IInteractionStateService$Companion;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0007HÆ\u0003J'\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001b"}, d2 = {"Lcom/obric/assistant/interaction/impl/activityresult/ProxyRequest;", "", "token", "", "listener", "Lcom/obric/assistant/interaction/api/service/ActivityProxyListener;", "timeoutRunnable", "Ljava/lang/Runnable;", "<init>", "(JLcom/obric/assistant/interaction/api/service/ActivityProxyListener;Ljava/lang/Runnable;)V", "getToken", "()J", "getListener", "()Lcom/obric/assistant/interaction/api/service/ActivityProxyListener;", "getTimeoutRunnable", "()Ljava/lang/Runnable;", "component1", "component2", "component3", "copy", "equals", "", IInteractionStateService$Companion.WAKE_UP_SOURCE_OTHER, "hashCode", "", "toString", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ProxyRequest {
    private final ActivityProxyListener listener;
    private final Runnable timeoutRunnable;
    private final long token;

    public static /* synthetic */ ProxyRequest copy$default(ProxyRequest r0, long r1, ActivityProxyListener r3, Runnable r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = r0.token;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r3 = r0.listener;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r4 = r0.timeoutRunnable;
    L12:
        return r0.copy(r1, r3, r4);
    }

    public final long component1() {
        return this.token;
    }

    public final ActivityProxyListener component2() {
        return this.listener;
    }

    public final Runnable component3() {
        return this.timeoutRunnable;
    }

    public final ProxyRequest copy(long r2, ActivityProxyListener r4, Runnable r5) {
        Intrinsics.checkNotNullParameter(r4, "listener");
        Intrinsics.checkNotNullParameter(r5, "timeoutRunnable");
        return new ProxyRequest(r2, r4, r5);
    }

    public boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof ProxyRequest) == true) goto L8;
        return false;
    L8:
        ProxyRequest r9 = (ProxyRequest) r8;
        if (this.token == r9.token) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.listener, r9.listener) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.timeoutRunnable, r9.timeoutRunnable) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        long r0 = this.token;
        return (((((int) (r0 ^ (r0 >>> 32))) * 31) + this.listener.hashCode()) * 31) + this.timeoutRunnable.hashCode();
    }

    public String toString() {
        return "ProxyRequest(token=" + this.token + ", listener=" + this.listener + ", timeoutRunnable=" + this.timeoutRunnable + ')';
    }

    public final ActivityProxyListener getListener() {
        return this.listener;
    }

    public final Runnable getTimeoutRunnable() {
        return this.timeoutRunnable;
    }

    public final long getToken() {
        return this.token;
    }

    public ProxyRequest(long r2, ActivityProxyListener r4, Runnable r5) {
        Intrinsics.checkNotNullParameter(r4, "listener");
        Intrinsics.checkNotNullParameter(r5, "timeoutRunnable");
        this.token = r2;
        this.listener = r4;
        this.timeoutRunnable = r5;
    }
}
