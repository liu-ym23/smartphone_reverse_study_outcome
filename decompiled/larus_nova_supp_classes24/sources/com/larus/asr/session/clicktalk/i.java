package com.larus.asr.session.clicktalk;

import com.larus.asr.session.e2;
import com.larus.asr.task.SamiCallAsrTask;
import com.larus.audio.IFlowAsrClientService;
import com.larus.audio.call.RealtimeCallParam;
import java.text.SimpleDateFormat;
import java.util.Date;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class i implements l {
    public final String a;
    public final Function0<String> b;
    public final Function0<String> c;
    public final Function0<com.larus.audio.call.a> d;
    public final k e;
    public SamiCallAsrTask f;

    public static final class a {
    }

    static {
    }

    @Override // com.larus.asr.session.clicktalk.l
    public final void a() {
        Intrinsics.checkNotNullParameter("", "endMethod");
        SamiCallAsrTask r2 = this.f;
        if (r2 == null) goto L10;
        Intrinsics.checkNotNullParameter("", "endMethod");
        com.larus.audio.call.a r1 = r2.n;
        if (r1 == null) goto L11;
        Function1<? super String, Unit> r3 = r1.g;
        if (r3 == null) goto L12;
        r3.invoke("");
        return;
    L12:
        return;
    L11:
        return;
    }

    @Override // com.larus.asr.session.clicktalk.l
    public final void p() {
        SamiCallAsrTask r0 = this.f;
        if (r0 == null) goto L8;
        com.larus.audio.call.a r1 = r0.n;
        if (r1 == null) goto L9;
        r1.c();
        return;
    L9:
        return;
    }

    @Override // com.larus.asr.session.clicktalk.l
    public final void q() {
        IFlowAsrClientService.a.getClass();
        IFlowAsrClientService.a.a().r(this.a);
    }

    @Override // com.larus.asr.session.clicktalk.l
    public final void release() {
        IFlowAsrClientService.a.getClass();
        IFlowAsrClientService.a.a().j(this.a);
        this.f = null;
    }

    @Override // com.larus.asr.session.clicktalk.l
    public final void stop() {
        IFlowAsrClientService.a.getClass();
        IFlowAsrClientService.a.a().f(this.a);
    }

    @Override // com.larus.asr.session.clicktalk.l
    public final void r(final RealtimeCallParam r31) {
        Intrinsics.checkNotNullParameter(r31, "param");
        String r5 = this.a;
        b68.b r2 = b68.b.a;
        String r3 = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        r2.getClass();
        String r4 = b68.b.c("/record/asr/pcm/", r3);
        if (r4 != null) goto L5;
        r4 = "";
    L5:
        String r8 = r4;
        final y58.a r6 = new y58.a(null, r5, (String) this.b.invoke(), null, r8, false, false, null, null, 0, 0, null, 0, 0, false, 0, 0, null, null, (String) this.c.invoke(), new y58.d(0), 0, "CALL_SAMI", 16777193);
        IFlowAsrClientService.a.getClass();
        IFlowAsrClientService.a.a().a(this.a, r6, new com.larus.asr.session.clicktalk.a(), new b(r31, this, r6), null);
    }

    @Override // com.larus.asr.session.clicktalk.l
    public final void updateScreenshotForAsr(String r3) {
        Intrinsics.checkNotNullParameter(r3, "tosKey");
        SamiCallAsrTask r0 = this.f;
        if (r0 == null) goto L6;
        r0.c(r3, null, null, null);
        return;
    }

    public i(String r2, Function0 r3, Function0 r4, m r5, e2 r6) {
        Intrinsics.checkNotNullParameter(r2, "taskId");
        Intrinsics.checkNotNullParameter(r3, "conversationIdProvider");
        Intrinsics.checkNotNullParameter(r4, "botIdProvider");
        Intrinsics.checkNotNullParameter(r5, "realtimeCallServiceProvider");
        Intrinsics.checkNotNullParameter(r6, "eventListener");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
    }
}
