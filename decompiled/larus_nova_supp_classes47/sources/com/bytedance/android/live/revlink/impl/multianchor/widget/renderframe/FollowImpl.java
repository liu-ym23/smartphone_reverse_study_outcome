package com.bytedance.android.live.revlink.impl.multianchor.widget.renderframe;

import android.app.Activity;
import android.content.Context;
import com.bytedance.android.live.revenue.core.util.f;
import com.bytedance.android.live.revenue.core.util.j;
import com.bytedance.android.livesdk.revenue.user.RevLiveFollowScene;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.follow.IFollowPair;
import com.bytedance.revenue.platform.api.core.rx.h;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import yz0.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class FollowImpl {
    public boolean a;
    public final Context b;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ FollowImpl a;
        public final /* synthetic */ Function0 b;

        public a(FollowImpl r1, Function0 r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r2) {
            IFollowPair r3 = (IFollowPair) r2;
            this.a.a = false;
            this.b.invoke();
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ FollowImpl a;
        public final /* synthetic */ Function1 b;

        public b(FollowImpl r1, Function1 r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r3) {
            this.a.a = false;
            Function1 r0 = this.b;
            r0.invoke((Throwable) r3);
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ FollowImpl a;
        public final /* synthetic */ Function0 b;

        public c(FollowImpl r1, Function0 r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r2) {
            IFollowPair r3 = (IFollowPair) r2;
            this.a.a = false;
            this.b.invoke();
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ FollowImpl a;
        public final /* synthetic */ Function1 b;

        public d(FollowImpl r1, Function1 r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r3) {
            this.a.a = false;
            Function1 r0 = this.b;
            r0.invoke((Throwable) r3);
        }
    }

    public FollowImpl(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this.b = r2;
        new CompositeDisposable();
    }

    public final Disposable a(final String r4, final RevLiveFollowScene r5, Function0<Unit> r6, Function1<? super Throwable, Unit> r7) {
        Intrinsics.checkNotNullParameter(r4, "uid");
        Intrinsics.checkNotNullParameter(r5, "scene");
        Intrinsics.checkNotNullParameter(r6, "onSuccess");
        Intrinsics.checkNotNullParameter(r7, "onFail");
        if (this.a == false) goto L6;
        int r8 = h.a;
        return h.a(FollowImpl$follow$1.INSTANCE);
    L6:
        this.a = true;
        return vh6.c.b(com.bytedance.android.livesdk.revenue.service.user.a.class).om(null, null, new ds2.c(new FollowImpl$follow$2(r4, r5))).subscribe(new a(this, r6), new b(this, r7));
    }

    public final Disposable b(String r7, String r8, Function0<Unit> r9, Function1<? super Throwable, Unit> r10) {
        Intrinsics.checkNotNullParameter(r8, "source");
        Intrinsics.checkNotNullParameter(r9, "onSuccess");
        Intrinsics.checkNotNullParameter(r10, "onFail");
        if (this.a == false) goto L6;
        int r12 = h.a;
        return h.a(FollowImpl$unFollow$1.INSTANCE);
    L6:
        this.a = true;
        com.bytedance.android.livesdk.revenue.service.user.a r0 = vh6.c.b(com.bytedance.android.livesdk.revenue.service.user.a.class);
        k r13 = (k) f.d(j.C0.a(), k.class);
        if (r13 == null) goto L11;
        IRoom r14 = r13.getRoom();
        if (r14 == null) goto L11;
        long r1 = r14.getRoomId();
    L12:
        long r2 = r1;
        Context r15 = this.b;
        if ((r15 instanceof Activity) == true) goto L16;
        r15 = null;
    L16:
        return r0.rl(r7, r2, (Activity) r15, vh6.c.b(com.bytedance.android.livesdk.revenue.service.user.a.class).Kh(RevLiveFollowScene.MultiAnchorPanel)).subscribe(new c(this, r9), new d(this, r10));
    L11:
        r1 = 0;
        goto L12
    }
}
