package com.ss.android.lark.flow.notification.online.process;

import com.larksuite.framework.thread.CoreThreadPool;
import com.ss.android.lark.notification.export.entity.CurrentProcess;
import com.ss.android.lark.notification.export.entity.Notice;
import com.ss.android.lark.passportc.api.m;
import com.ss.android.lark.passportc.api.s;
import com.ss.android.lark.passportc.dwarf.UserScope;
import f0c.h;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@UserScope
public final class e extends c0c.c implements zsb.c {
    public final m b;
    public final com.ss.android.lark.flow.notification.online.process.b c;
    public final AtomicBoolean d;
    public final b e;
    public final c f;
    public final d g;

    public static final class a {
    }

    public static final class b implements zsb.e {
        public b() {
        }
    }

    public static final class c implements zsb.e {
        public c() {
        }
    }

    public static final class d implements zsb.e {
        public d() {
        }
    }

    static {
    }

    @Inject
    public e(m r2) {
        Intrinsics.checkNotNullParameter(r2, "passportService");
        super(r2);
        this.b = r2;
        this.c = new com.ss.android.lark.flow.notification.online.process.b();
        this.d = new AtomicBoolean(false);
        this.e = new b();
        this.f = new c();
        this.g = new d();
        s.a(this);
    }

    public final void d(h r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
        Intrinsics.checkNotNullParameter(r2, "state");
        thb.a.b("FlowOnlineNotificationController", "user offline " + this.b.getUser().userId);
        this.c.getClass();
    }

    @Override // zsb.c
    public final void R2(Notice r3, CurrentProcess r4) {
        if (this.d.get() == true) goto L9;
        StringBuilder r0 = new StringBuilder("collectNotificationWrapperImpl currentProcess:");
        if (r4 == null) goto L7;
        String r5 = r4.name();
    L8:
        r0.append(r5);
        thb.a.b("FlowOnlineNotificationController", r0.toString());
        com.ss.android.lark.flow.notification.online.process.b r6 = this.c;
        this.f.getClass();
        int r1 = new com.ss.android.lark.flow.notification.online.type.message.a().getType();
        this.f.getClass();
        r6.b(r1, new com.ss.android.lark.flow.notification.online.type.message.a());
        com.ss.android.lark.flow.notification.online.process.b r7 = this.c;
        this.g.getClass();
        int r2 = new com.ss.android.lark.flow.notification.online.type.reaction.a().getType();
        this.g.getClass();
        r7.b(r2, new com.ss.android.lark.flow.notification.online.type.reaction.a());
        com.ss.android.lark.flow.notification.online.process.b r8 = this.c;
        this.e.getClass();
        int r9 = new com.ss.android.lark.flow.notification.online.type.appfeed.a().getType();
        this.e.getClass();
        r8.b(r9, new com.ss.android.lark.flow.notification.online.type.appfeed.a());
        this.d.compareAndSet(false, true);
        goto L9
    L7:
        r5 = null;
    L9:
        com.ss.android.lark.flow.notification.online.process.b r10 = this.c;
        r10.getClass();
        CoreThreadPool.getDefault().newSerialCpuDensityThreadPool("NotificationDispatcher").execute(new com.ss.android.lark.flow.notification.online.process.a(r10, r3));
    }
}
