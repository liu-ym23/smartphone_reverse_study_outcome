package com.larus.doc.impl.operation.download;

import com.larus.platform.audit.BehaviorAuditApi;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class g implements p {
    public final /* synthetic */ p a;
    public final /* synthetic */ com.larus.platform.audit.b b;
    public final /* synthetic */ String c;

    @Override // com.larus.doc.impl.operation.download.p
    public final void onSuccess(String r3) {
        Intrinsics.checkNotNullParameter(r3, "filePath");
        this.a.onSuccess(r3);
        BehaviorAuditApi.c(this.b, MapsKt.mapOf(TuplesKt.to("scene", this.c)));
    }

    @Override // com.larus.doc.impl.operation.download.p
    public final void a(Integer r5, String r6) {
        Intrinsics.checkNotNullParameter(r6, "errorMsg");
        this.a.a(r5, r6);
        com.larus.platform.audit.b r0 = this.b;
        Pair[] r1 = new Pair[3];
        r1[0] = TuplesKt.to("scene", this.c);
        if (r5 == null) goto L5;
        int r7 = r5.intValue();
    L6:
        r1[1] = TuplesKt.to("error_code", Integer.valueOf(r7));
        r1[2] = TuplesKt.to("error_msg", r6);
        BehaviorAuditApi.c(r0, MapsKt.mapOf(r1));
        return;
    L5:
        r7 = -1;
        goto L6
    }

    public g(p r1, com.larus.platform.audit.b r2, String r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
