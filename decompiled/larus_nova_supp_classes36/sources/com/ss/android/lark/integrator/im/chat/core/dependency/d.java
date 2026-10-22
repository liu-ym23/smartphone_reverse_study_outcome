package com.ss.android.lark.integrator.im.chat.core.dependency;

import com.ss.android.lark.chat.core.dependency.ChatSettingDependency;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class d implements ChatSettingDependency {
    public d() {
    }

    public final void b() {
    }

    public final void a(aqb.c r2) {
        if (r2 == null) goto L5;
        CopyOnWriteArraySet r0 = e8b.a.a;
        Intrinsics.checkNotNullParameter(r2, "listener");
        e8b.a.a.add(r2);
        return;
    }

    public final void c(com.ss.android.lark.chat.chatwindow.chat.v2.push.q.b r2) {
        if (r2 == null) goto L5;
        CopyOnWriteArraySet r0 = e8b.a.a;
        Intrinsics.checkNotNullParameter(r2, "listener");
        e8b.a.a.remove(r2);
        return;
    }
}
