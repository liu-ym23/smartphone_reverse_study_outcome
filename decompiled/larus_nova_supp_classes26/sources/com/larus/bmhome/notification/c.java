package com.larus.bmhome.notification;

import com.larus.bmhome.chat.model.repo.b2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class c implements com.larus.platform.api.b {
    public final /* synthetic */ NotifyRedDotLifecycleObserver a;

    public final void a(com.larus.platform.api.c r2) {
        Intrinsics.checkNotNullParameter(r2, "event");
    }

    public c(NotifyRedDotLifecycleObserver r1) {
        this.a = r1;
    }

    public final void b(com.larus.platform.api.c r2) {
        Intrinsics.checkNotNullParameter(r2, "event");
        this.a.b.getClass();
        b2.b.postValue(0);
    }
}
