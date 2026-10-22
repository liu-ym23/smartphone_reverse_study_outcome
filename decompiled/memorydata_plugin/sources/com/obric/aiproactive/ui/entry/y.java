package com.obric.aiproactive.ui.entry;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\bJ\u0006\u0010\u000f\u001a\u00020\u000eJ\u0006\u0010\u0010\u001a\u00020\u000eJ\u0006\u0010\u0011\u001a\u00020\u0012J\u0006\u0010\u0013\u001a\u00020\u0005J\u0006\u0010\u0014\u001a\u00020\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/obric/aiproactive/ui/entry/SensingEventsPageCoordinator;", "", "<init>", "()V", "configured", "", "freshLaunch", "restoredAnchor", "Lcom/obric/aiproactive/ui/entry/SensingEventsScrollAnchor;", "collectionActive", "firstSnapshotHandled", "enterPageConsumed", "closeTransitionConsumed", "configure", "", "onCollectionStarted", "onCollectionStopped", "onSnapshot", "Lcom/obric/aiproactive/ui/entry/SensingEventsSnapshotDecision;", "consumeEnterPage", "consumeCloseTransition", "ai_proactive_ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f6642a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f6643b;
    private aa c;
    private boolean d;
    private boolean e;
    private boolean f;
    private boolean g;

    public y() {
    }

    public final void a() {
        this.d = true;
    }

    public final void a(boolean r3, aa r4) {
        if ((!this.f6642a) == false) goto L7;
        this.f6642a = true;
        this.f6643b = r3;
        this.c = r4;
        return;
    L7:
        throw new IllegalStateException("SensingEventsPageCoordinator is already configured".toString());
    }

    public final void b() {
        this.d = false;
    }

    public final ab c() {
        if (this.d == true) goto L8;
        Object r2 = ab.a.f6598a;
    L6:
        return (ab) ZeusTransformUtils.preCheckCast(r2, ab.class, "com.obric.memorydata.plugin");
    L8:
        if (this.e == false) goto L10;
        r2 = ab.b.f6599a;
        goto L6
    L10:
        this.e = true;
        if (this.f6643b == false) goto L16;
        Object r3 = ab.d.f6601a;
    L13:
        Object r4 = ZeusTransformUtils.preCheckCast(r3, ab.class, "com.obric.memorydata.plugin");
    L23:
        return (ab) r4;
    L16:
        if (this.c == null) goto L22;
        aa r5 = this.c;
        if (r5 == null) goto L21;
        r4 = ZeusTransformUtils.preCheckCast(new ab.c(r5), ab.class, "com.obric.memorydata.plugin");
        goto L23
    L21:
        throw new IllegalStateException("Required value was null.".toString());
    L22:
        r3 = ab.b.f6599a;
        goto L13
    }

    public final boolean d() {
        if (this.f6642a == true) goto L5;
        return false;
    L5:
        if (this.f6643b == true) goto L7;
        return false;
    L7:
        if (this.f == true) goto L14;
        this.f = true;
        return true;
    L14:
        return false;
    }

    public final boolean e() {
        if (this.f6642a == true) goto L5;
        return false;
    L5:
        if (this.g == true) goto L11;
        this.g = true;
        return true;
    L11:
        return false;
    }
}
