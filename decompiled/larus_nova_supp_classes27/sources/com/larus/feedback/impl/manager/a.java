package com.larus.feedback.impl.manager;

import com.larus.feedback.impl.gateway.FlowFeedbackRemoteGateway;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import q99.i;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class a extends p99.c {
    public static final /* synthetic */ int b = 0;

    /* JADX INFO: renamed from: com.larus.feedback.impl.manager.a$a, reason: collision with other inner class name */
    public static final class C0118a {
    }

    static {
    }

    public a(FlowFeedbackRemoteGateway r2) {
        Intrinsics.checkNotNullParameter(r2, "gateway");
        super(r2);
    }

    @Override // p99.c
    public final void b(q99.e r8, i r9) {
        Intrinsics.checkNotNullParameter(r8, "delivery");
        Intrinsics.checkNotNullParameter(r9, "host");
        super.b(r8, r9);
        t99.a.b(r8.d, r9.d, r8.b, "dislike", (JSONObject) r9.p.invoke("feedback_popup_click", r8), 32);
    }

    @Override // p99.c
    public final void c(q99.e r8, i r9) {
        Intrinsics.checkNotNullParameter(r8, "delivery");
        Intrinsics.checkNotNullParameter(r9, "host");
        super.c(r8, r9);
        t99.a.b(r8.d, r9.d, r8.b, "like", (JSONObject) r9.p.invoke("feedback_popup_click", r8), 32);
    }

    @Override // p99.c
    public final void d(q99.e r2, i r3, q99.a r4) {
        Intrinsics.checkNotNullParameter(r2, "delivery");
        Intrinsics.checkNotNullParameter(r3, "host");
        Intrinsics.checkNotNullParameter(r4, "result");
        t99.a.a(r2.d, (JSONObject) r3.p.invoke("complete_dislike_reason", r2));
    }
}
