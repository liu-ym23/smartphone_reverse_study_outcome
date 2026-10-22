package com.ss.android.lark.chat.api.service.impl.usergroup;

import a2b.n;
import a2b.o;
import com.ss.android.lark.passportc.dwarf.UserScope;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;
import javax.inject.Inject;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@UserScope
public final class UserGroupPush implements n {
    public final b a;
    public final o b;
    public final Executor c;
    public final CopyOnWriteArrayList<com.ss.android.lark.biz.im.api.usergroup.a> d;
    public final Function1<Throwable, Unit> e;

    public static final class a {
    }

    static {
    }

    @Override // a2b.n
    public final void C3(com.ss.android.lark.biz.im.api.usergroup.a r5) {
        if (this.b.isEnabled() == true) goto L5;
        return;
    L5:
        if (r5 != null) goto L7;
        return;
    L7:
        CopyOnWriteArrayList<com.ss.android.lark.biz.im.api.usergroup.a> r0 = this.d;
        if (r0.isEmpty() == false) goto L18;
        monitor-enter(r0);
    L15:
        th = move-exception;
        throw th;
    L11:
        if (r0.isEmpty() == false) goto L13;
        this.a.a(new UserGroupPush$startPush$1$1(this), this.e);     // Catch: Throwable -> L15
    L13:
        monitor-exit(r0);     // Catch: Throwable -> L15
    L18:
        r0.add(r5);
    }

    @Override // a2b.n
    public final void vc(com.ss.android.lark.biz.im.api.usergroup.a r2) {
        if (this.b.isEnabled() == true) goto L5;
        return;
    L5:
        if (r2 != null) goto L7;
        return;
    L7:
        CopyOnWriteArrayList<com.ss.android.lark.biz.im.api.usergroup.a> r0 = this.d;
        monitor-enter(r0);
        r0.remove(r2);     // Catch: Throwable -> L23
        monitor-exit(r0);     // Catch: Throwable -> L23
        if (r0.isEmpty() == false) goto L22;
        monitor-enter(r0);
    L19:
        th = move-exception;
        throw th;
    L15:
        if (r0.isEmpty() == false) goto L17;
        this.a.b();     // Catch: Throwable -> L19
    L17:
        monitor-exit(r0);     // Catch: Throwable -> L19
        return;
    L22:
        return;
    L23:
        th = move-exception;
        throw th;
    }

    @Inject
    public UserGroupPush(b r2, o r3) {
        Intrinsics.checkNotNullParameter(r2, "pushRepo");
        Intrinsics.checkNotNullParameter(r3, "userGroupService");
        this.a = r2;
        this.b = r3;
        this.c = PThreadExecutorsUtils.newSingleThreadExecutor(new com.larksuite.framework.thread.n("thread-pool-user-group-push"));
        this.d = new CopyOnWriteArrayList();
        this.e = UserGroupPush$onError$1.INSTANCE;
    }
}
