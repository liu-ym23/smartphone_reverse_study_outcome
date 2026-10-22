package com.bytedance.android.livesdk.interactivity.comment;

import com.bytedance.android.live.core.log.ALogger;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.subjects.SingleSubject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class f1 implements a32.a {
    public static final /* synthetic */ int d = 0;
    public final CompositeDisposable a;
    public u22.k b;
    public SingleSubject<u22.k> c;

    public static final class a {
    }

    static {
    }

    @Override // a32.a
    public final void destroy() {
        this.b = null;
        this.c = null;
        this.a.clear();
    }

    @Override // a32.a
    public final SingleSubject a() {
        if (this.c != null) goto L5;
        this.c = SingleSubject.create();
    L5:
        SingleSubject<u22.k> r0 = this.c;
        if (r0 == null) goto L9;
        return r0;
    L9:
        return SingleSubject.create();
    }

    @Override // a32.a
    public final void b() {
        ALogger.i("ToolbarAndCommentShowCtrlManager", "notifyToolbarReady");
        u22.k r0 = d();
        if (r0 == null) goto L5;
        r0.a = true;
    L5:
        e();
    }

    @Override // a32.a
    public final void c() {
        ALogger.i("ToolbarAndCommentShowCtrlManager", "notifyCommentReady");
        u22.k r0 = d();
        if (r0 == null) goto L5;
        r0.b = true;
    L5:
        e();
    }

    public final u22.k d() {
        if (this.b != null) goto L6;
        this.b = new u22.k(0);
    L6:
        return this.b;
    }

    public f1() {
        this.a = new CompositeDisposable();
    }

    public final void e() {
        u22.k r0 = d();
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.a == true) goto L7;
    L9:
        boolean r1 = false;
    L10:
        if (r1 != true) goto L19;
        ALogger.i("ToolbarAndCommentShowCtrlManager", "notifyWidgetReady isAllReady");
        if (this.c != null) goto L14;
        this.c = SingleSubject.create();
    L14:
        SingleSubject<u22.k> r2 = this.c;
        if (r2 == null) goto L20;
        r2.onSuccess(r0);
        return;
    L20:
        return;
    L19:
        return;
    L7:
        if (r0.b == false) goto L9;
        r1 = true;
        goto L10
    }
}
