package com.ss.android.lark.flow.notification.online.process;

import com.ss.android.lark.notification.export.entity.INotificationHitPoint;
import com.ss.android.lark.passportc.api.m;
import com.ss.android.lark.passportc.dwarf.UserScope;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@UserScope
public final class c extends c0c.c implements INotificationHitPoint {
    public final m b;

    public static final class a {
    }

    static {
    }

    @Inject
    public c(m r2) {
        Intrinsics.checkNotNullParameter(r2, "passportService");
        super(r2);
        this.b = r2;
    }
}
