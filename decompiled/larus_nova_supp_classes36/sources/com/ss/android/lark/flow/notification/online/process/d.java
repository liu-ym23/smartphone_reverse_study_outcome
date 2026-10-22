package com.ss.android.lark.flow.notification.online.process;

import android.util.LruCache;
import com.bytedance.lark.pb.basic.v1.Command;
import com.bytedance.lark.pb.basic.v1.Notification;
import com.bytedance.lark.rustclient.api.l;
import com.bytedance.lark.rustclient.api.t;
import com.ss.android.lark.passportc.api.m;
import com.ss.android.lark.passportc.api.s;
import com.ss.android.lark.passportc.dwarf.UserScope;
import io.reactivex.disposables.CompositeDisposable;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@UserScope
public final class d extends c0c.c implements zsb.a {
    public final l b;
    public final CopyOnWriteArrayList<ctb.a> c;
    public final CompositeDisposable d;
    public CoroutineScope e;
    public final LruCache<String, Boolean> f;

    public static final class a {
    }

    static {
    }

    public final void c() {
        thb.a.b("FlowNotificationPushManager", "destroy");
        this.d.dispose();
        this.d.clear();
        CoroutineScope r0 = this.e;
        if (r0 == null) goto L5;
        CoroutineScopeKt.cancel$default(r0, null, 1, null);
    L5:
        this.e = null;
    }

    public final void k() {
        thb.a.b("FlowNotificationPushManager", "registerNotificationPush, userId = " + ((c0c.c) this).a.getUser().userId);
        this.d.add(t.g(this.b.i(Command.PUSH_NOTIFICATION, Notification.ADAPTER), new FlowNotificationPushManager$registerNotificationPush$1(this), FlowNotificationPushManager$registerNotificationPush$2.INSTANCE));
        this.e = CoroutineScopeKt.CoroutineScope(Dispatchers.getMain().plus(SupervisorKt.SupervisorJob$default(null, 1, null)));
    }

    @Override // zsb.a
    public final void n9(ctb.a r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.c.remove(r2);
    }

    @Override // zsb.a
    public final void t4(ctb.a r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.c.add(r2);
    }

    @Inject
    public d(m r2, l r3) {
        Intrinsics.checkNotNullParameter(r2, "passport");
        Intrinsics.checkNotNullParameter(r3, "rustClient");
        super(r2);
        this.b = r3;
        this.c = new CopyOnWriteArrayList();
        this.d = new CompositeDisposable();
        this.f = new LruCache(100);
        s.a(this);
    }
}
