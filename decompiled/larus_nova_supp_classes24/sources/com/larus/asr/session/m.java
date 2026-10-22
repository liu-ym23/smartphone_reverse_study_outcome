package com.larus.asr.session;

import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class m implements com.larus.asr.session.component.n0 {
    public final /* synthetic */ ComponentAsrSession a;

    public m(ComponentAsrSession r1) {
        this.a = r1;
    }

    @Override // com.larus.asr.session.component.n0
    public final void c(Integer r3) {
        com.larus.asr.session.component.f0 r0 = this.a.h;
        if (r0 == null) goto L5;
        this.a.h(r0);
    L5:
        Iterator r1 = ComponentAsrSession.a(this.a).iterator();
    L7:
        if (r1.hasNext() == false) goto L9;
        ((com.larus.asr.session.component.n0) r1.next()).c(r3);
        goto L7
    }

    @Override // com.larus.asr.session.component.n0
    public final void a(String r3, JSONObject r4) {
        Intrinsics.checkNotNullParameter(r3, "taskId");
        Intrinsics.checkNotNullParameter(r4, "params");
        Iterator r0 = ((ArrayList) ComponentAsrSession.a(this.a)).iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((com.larus.asr.session.component.n0) r0.next()).a(r3, r4);
        goto L4
    }

    @Override // com.larus.asr.session.component.p0
    public final void b(com.larus.asr.session.component.b0 r2, i r3) {
        Intrinsics.checkNotNullParameter(r2, "event");
        Intrinsics.checkNotNullParameter(r3, "complete");
        r3.invoke(com.larus.asr.session.component.c0.b.a);
    }
}
