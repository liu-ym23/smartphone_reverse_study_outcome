package com.bytedance.android.live.revlink.impl.pk.dialog.fragment;

import android.view.View;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.livesdk.link.model.p8;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class n {
    public Disposable a;
    public boolean b;
    public int c;
    public String d;
    public final com.bytedance.android.livesdk.revenue.room.a e;
    public final InteractPkReserveView f;

    public static final class a {
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ n a;

        public b(n r1) {
            this.a = r1;
        }

        public final void accept(Object r4) {
            n r0 = this.a;
            r0.b = false;
            p8 r5 = (p8) ((ExtraResponse) r4).data;
            r0.d = r5.getNextOffSetId();
            InteractPkReserveView r1 = this.a.f;
            View r2 = r1.d;
            if (r2 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("mPreloadProgressIcon");
        L5:
            r2.setVisibility(8);
            r1.R5(r5);
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ n a;

        public c(n r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            Throwable r4 = (Throwable) r3;
            n r5 = this.a;
            r5.b = false;
            InteractPkReserveView r6 = r5.f;
            View r0 = r6.d;
            if (r0 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("mPreloadProgressIcon");
        L5:
            r0.setVisibility(8);
            r6.R5(null);
        }
    }

    static {
    }

    public final void a() {
        Disposable r0 = this.a;
        if (r0 == null) goto L6;
        r0.dispose();
    L6:
        if (this.b == false) goto L8;
        return;
    L8:
        r31.a r1 = r31.b.a(r31.a.a);
        com.bytedance.android.livesdk.revenue.room.a r2 = this.e;
        if (r2 == null) goto L15;
        com.bytedance.live.datacontext.m r3 = r2.getRoom();
        if (r3 == null) goto L15;
        IRoom r4 = (IRoom) r3.getValue();
        if (r4 == null) goto L15;
        long r5 = r4.getRoomId();
    L16:
        Observable r6 = r1.m(r5, this.c, this.d);
        if (r6 == null) goto L21;
        Observable r7 = r6.compose(RxUtil.rxSchedulerHelper());
        if (r7 == null) goto L21;
        Disposable r8 = r7.subscribe(new b(this), new c(this));
    L22:
        this.a = r8;
        return;
    L21:
        r8 = null;
    L15:
        r5 = 0;
        goto L16
    }

    public n(InteractPkReserveView r2) {
        Intrinsics.checkNotNullParameter(r2, "view");
        this.f = r2;
        this.d = "";
        com.bytedance.android.livesdk.revenue.service.room.c r3 = (dy0.b) com.bytedance.android.live.revenue.core.util.e.c(com.bytedance.android.live.revenue.core.util.j.C0.a(), com.bytedance.android.livesdk.revenue.service.room.c.class);
        if (r3 == null) goto L5;
        com.bytedance.android.livesdk.revenue.room.a r4 = r3.getRoomContext();
    L6:
        this.e = r4;
        return;
    L5:
        r4 = null;
        goto L6
    }
}
