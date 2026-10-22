package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.container;

import android.view.View;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.a0;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.o;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.p000new.ComponentConfigManager;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.s;
import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import ot2.d;
import zo1.e;
import zo1.f;
import zo1.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class ContainerContextEnv implements o, h, e {
    public ComponentConfigManager a;
    public h b;
    public d c;
    public e d;
    public f<s> e;
    public DataCenter f;
    public final Lazy g;

    @Override // zo1.d
    public final void a() {
        Intrinsics.checkNotNullParameter("onRoomExit", "event");
        f<s> r0 = this.e;
        if (r0 == null) goto L5;
        r0.a();
    L5:
        h r1 = this.b;
        if (r1 == null) goto L8;
        r1.a();
    L8:
        e r2 = this.d;
        if (r2 == null) goto L12;
        r2.a();
        return;
    }

    public ContainerContextEnv() {
        this.g = LazyKt.lazy(new ContainerContextEnv$isAnchor$2(this));
    }

    @Override // zo1.h
    public final boolean c(int r2) {
        h r0 = this.b;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.c(r2) != true) goto L7;
        return true;
    }

    @Override // zo1.h
    public final int g(int r2) {
        h r0 = this.b;
        if (r0 != null) goto L7;
        return -1;
    L7:
        return r0.g(r2);
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.o
    public final a0 getToolbarConfig(int r2) {
        ComponentConfigManager r0 = this.a;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getToolbarConfig(r2);
    }

    @Override // zo1.h
    public final void h(s r2) {
        Intrinsics.checkNotNullParameter(r2, "model");
        h r0 = this.b;
        if (r0 == null) goto L6;
        r0.h(r2);
        return;
    }

    @Override // zo1.e
    public final c0.b j(int r2) {
        e r0 = this.d;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.j(r2);
    }

    @Override // zo1.h
    public final View k(s r2) {
        Intrinsics.checkNotNullParameter(r2, "model");
        h r0 = this.b;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.k(r2);
    }

    @Override // zo1.h
    public final View l(int r2) {
        h r0 = this.b;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.l(r2);
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.o
    public final void register(a0 r3) {
        Intrinsics.checkNotNullParameter(r3, "config");
        ComponentConfigManager r1 = this.a;
        if (r1 == null) goto L6;
        Intrinsics.checkNotNullParameter(r3, "config");
        r1.d(r3);
        return;
    }
}
