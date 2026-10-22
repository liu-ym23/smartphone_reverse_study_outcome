package com.ss.android.lark.integrator.security.compliance.export;

import com.ss.android.lark.featuregating.FeatureGatingModule;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.officesdk.container.OfficeSDKUserScope;
import com.ss.android.lark.pb.security_event.Event;
import javax.inject.Inject;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@OfficeSDKUserScope
public final class a implements b {

    /* JADX INFO: renamed from: com.ss.android.lark.integrator.security.compliance.export.a$a, reason: collision with other inner class name */
    public static final class C0122a {
    }

    static {
    }

    @Inject
    public a() {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L5
        com.ss.android.lark.auditsdk.wrapper.b.d.a.b();     // Catch: Throwable -> L5
        Object r1 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L5
    L7:
        Throwable r2 = Result.exceptionOrNull-impl(r1);
        if (r2 == null) goto L13;
        Log.e("BehaviorAuditService", "init AuditSdk failed", r2);
        return;
    L13:
        return;
    L5:
        th = move-exception;
        Result.Companion r3 = Result.Companion;
        r1 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L7
    }

    @Override // com.ss.android.lark.integrator.security.compliance.export.b
    public final void T3(Event.Builder r4) {
        Intrinsics.checkNotNullParameter(r4, "builder");
        if (FeatureGatingModule.getFeatureGatingService().isCurrentEnable("admin.security.activity_auditing_for_doubao_chat") == true) goto L14;
        Log.i("BehaviorAuditService", "auditEvent skipped: FG disabled");
        return;
    L14:
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L8
        owa.a.a().getClass();     // Catch: Throwable -> L8
        Intrinsics.checkNotNullParameter(r4, "builder");     // Catch: Throwable -> L8
        com.ss.android.lark.auditsdk.wrapper.b.d.a.a(r4);     // Catch: Throwable -> L8
        Object r5 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L8
    L10:
        Throwable r6 = Result.exceptionOrNull-impl(r5);
        if (r6 == null) goto L16;
        Log.e("BehaviorAuditService", "auditEvent failed", r6);
        return;
    L16:
        return;
    L8:
        th = move-exception;
        Result.Companion r0 = Result.Companion;
        r5 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L10
    }
}
