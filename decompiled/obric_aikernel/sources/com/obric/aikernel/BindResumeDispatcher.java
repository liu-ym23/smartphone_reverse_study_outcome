package com.obric.aikernel;

import android.content.Intent;
import com.obric.aikernel.core.data.IdlKeys;
import com.obric.aikernel.middleware.api.log.AIKLog;
import kotlinx.coroutines.h;
import kotlinx.coroutines.k0;
import kotlinx.coroutines.l0;
import kotlinx.coroutines.m0;
import kotlinx.coroutines.q2;
import kotlinx.coroutines.z0;

/* JADX INFO: loaded from: classes2.dex */
public final class BindResumeDispatcher {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final BindResumeDispatcher f4383a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final l0 f4384b = null;

    static {
        f4383a = new BindResumeDispatcher();
        f4384b = m0.a(z0.b().plus(new k0("BindResumeDispatcher")).plus(q2.b(null, 1, null)));
    }

    private BindResumeDispatcher() {
    }

    private final void c(String r10, Intent r11) {
        boolean r12 = true;
        if (r11 != null) goto L5;
    L7:
        r12 = false;
    L9:
        if (d.c(r12) == true) goto L12;
        AIKLog.INSTANCE.d("BindResumeDispatcher", "skip bind resume source=" + r10 + " keepAlive=true");
        return;
    L12:
        h.d(f4384b, null, null, new BindResumeDispatcher$triggerIfNeeded$1(d.a(r10), r10, null), 3, null);
        return;
    L5:
        if (r11.getBooleanExtra(IdlKeys.Args_SkipBindResume, false) != true) goto L7;
        goto L7
    }

    public final void a(Intent r10) {
        c("provider", r10);
    }

    public final void b(Intent r10) {
        c("service", r10);
    }
}
