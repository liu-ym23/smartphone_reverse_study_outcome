package com.bytedance.android.livesdk.interactivity.comment;

import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.livesdk.chatroom.MiddlewareRoomContext;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.Widget;
import com.larus.apm.impl.protector.RunnableProtector;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class z0 implements Runnable {
    public final /* synthetic */ CommentWidget a;

    /* JADX WARN: Type inference failed for: r1v0, types: [com.bytedance.android.livesdk.interactivity.comment.x0, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v1, types: [com.bytedance.android.livesdk.interactivity.comment.y0, java.lang.Object] */
    public final void a() {
        Long r0 = com.bytedance.android.livesdk.interactivity.comment.utils.e.a;
        DataCenter r1 = ((Widget) this.a).dataCenter;
        ?? r2 = new x0(this);
        Intrinsics.checkNotNullParameter(r1, "dataCenter");
        Intrinsics.checkNotNullParameter(r2, "hint");
        MiddlewareRoomContext.a r4 = MiddlewareRoomContext.Companion;
        MiddlewareRoomContext r8 = MiddlewareRoomContext.a.c(r4, r1, 0, 2);
        if (r8 == null) goto L5;
        int r9 = r8.hashCode();
    L7:
        if (com.bytedance.android.livesdk.interactivity.comment.utils.e.b == r9) goto L16;
        Disposable r3 = Observable.timer(com.bytedance.android.livesdk.interactivity.comment.utils.e.a.longValue(), TimeUnit.MILLISECONDS).subscribe(new com.bytedance.android.livesdk.interactivity.comment.utils.c(r2, r9), RxUtil.getNoOp());
        MiddlewareRoomContext r5 = MiddlewareRoomContext.a.c(r4, r1, 0, 2);
        if (r5 == null) goto L16;
        com.bytedance.live.datacontext.i r6 = r5.getCompositeDisposable();
        if (r6 == null) goto L16;
        CompositeDisposable r7 = (CompositeDisposable) r6.getValue();
        if (r7 == null) goto L16;
        r7.add(r3);
    L16:
        DataCenter r10 = ((Widget) this.a).dataCenter;
        ?? r11 = new y0(this);
        Intrinsics.checkNotNullParameter(r10, "dataCenter");
        Intrinsics.checkNotNullParameter(r11, "hint");
        Disposable r13 = Observable.timer(com.bytedance.android.livesdk.interactivity.comment.utils.e.a.longValue(), TimeUnit.MILLISECONDS).subscribe(new com.bytedance.android.livesdk.interactivity.comment.utils.d(r11), RxUtil.getNoOp());
        MiddlewareRoomContext r14 = MiddlewareRoomContext.a.c(r4, r10, 0, 2);
        if (r14 == null) goto L24;
        com.bytedance.live.datacontext.i r15 = r14.getCompositeDisposable();
        if (r15 == null) goto L25;
        CompositeDisposable r16 = (CompositeDisposable) r15.getValue();
        if (r16 == null) goto L26;
        r16.add(r13);
        return;
    L26:
        return;
    L25:
        return;
    L24:
        return;
    L5:
        r9 = 0;
        goto L7
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public z0(CommentWidget r1) {
        this.a = r1;
    }
}
