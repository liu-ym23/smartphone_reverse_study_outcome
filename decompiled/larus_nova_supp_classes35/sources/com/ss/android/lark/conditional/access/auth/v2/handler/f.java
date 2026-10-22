package com.ss.android.lark.conditional.access.auth.v2.handler;

import android.os.Handler;
import com.ss.android.lark.security.compliance.api.model.filepolicy.l;
import com.ss.android.lark.security.compliance.api.model.filepolicy.o;
import com.ss.android.lark.security.compliance.infra.log.ScsLogger;
import i8b.q;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class f implements c {
    public final Lazy a;
    public final Map<String, WeakReference<o>> b;

    public static final class a {
    }

    static {
    }

    private final void update(o.b r4) {
        qqb.a.h("VCFileProtectTimerHandler update");     // Catch: Throwable -> L5
        int r1 = ScsLogger.a;     // Catch: Throwable -> L5
        ScsLogger.d("SecurityPolicy_VCFileProtectTimerHandler", "update(), identifier is " + r4.getIdentifier());     // Catch: Throwable -> L5
        new ArrayList();     // Catch: Throwable -> L5
        throw null;     // Catch: Throwable -> L5
    L5:
        th = move-exception;
        qqb.a.a();
        throw th;
    }

    @Override // com.ss.android.lark.conditional.access.auth.v2.handler.c
    public final void c(l r6) {
        Intrinsics.checkNotNullParameter(r6, "event");
        if ((r6 instanceof o.b) == false) goto L6;
        o.b r7 = (o.b) r6;
        String r0 = r7.getIdentifier();
        this.b.put(r0, new WeakReference(r7.getContext()));
        int r2 = ScsLogger.a;
        ScsLogger.d("SecurityPolicy_VCFileProtectTimerHandler", "handleEvent(), event is OpenEvent, identifier is " + r0);
        ((Handler) this.a.getValue()).removeCallbacksAndMessages(r0);
        update(r7);
        return;
    L6:
        if ((r6 instanceof o.a) == false) goto L10;
        String r8 = ((o.a) r6).getIdentifier();
        this.b.remove(r8);
        int r1 = ScsLogger.a;
        ScsLogger.d("SecurityPolicy_VCFileProtectTimerHandler", "handleEvent(), event is LeaveEvent, identifier is " + r8);
        ((Handler) this.a.getValue()).removeCallbacksAndMessages(r8);
        return;
    }

    public f(q r2, Lazy<? extends Handler> r3) {
        Intrinsics.checkNotNullParameter(r2, "mManager");
        Intrinsics.checkNotNullParameter(r3, "timerHandler");
        this.a = r3;
        this.b = new LinkedHashMap();
    }
}
