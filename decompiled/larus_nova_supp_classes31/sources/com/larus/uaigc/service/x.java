package com.larus.uaigc.service;

import com.larus.bmhome.resource.access.r0;
import com.larus.platform.model.upload.ResourceUploadError;
import java.util.UUID;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.j1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class x implements com.larus.bmhome.resource.access.b0 {
    public final p0 a;
    public final String b;
    public final r0 c;
    public final StateFlowImpl d;
    public final StateFlowImpl e;

    public final com.larus.bmhome.resource.access.z snapshot() {
        String r2 = this.b;
        r0 r3 = this.c;
        com.larus.bmhome.resource.access.a0 r4 = (com.larus.bmhome.resource.access.a0) this.d.getValue();
        p0 r1 = this.a;
        return new com.larus.bmhome.resource.access.z(r2, r3, r4, new com.larus.bmhome.resource.access.w(r1.a, r1.c, r1.b, new com.larus.bmhome.resource.access.g0(this.c.b, r1.d, null, null, null, false, null, new mr9.h(false, null, null, 31), null, null, new com.larus.bmhome.resource.access.v(false, false, false, 31), new com.larus.bmhome.resource.access.d0(null, null), MapsKt.emptyMap(), MapsKt.emptyMap())), 0, 0, 112);
    }

    public final StateFlowImpl a() {
        return this.e;
    }

    public final StateFlowImpl b() {
        return com.larus.bmhome.resource.access.s.a;
    }

    public final String getTaskId() {
        return this.b;
    }

    public x(p0 r5, ResourceUploadError r6) {
        Intrinsics.checkNotNullParameter(r5, "submitRequest");
        Intrinsics.checkNotNullParameter(r6, "error");
        this.a = r5;
        this.b = UUID.randomUUID().toString();
        com.larus.bmhome.resource.access.x r1 = r5.a;
        String r2 = r5.e;
        if (r2.length() <= 0) goto L5;
        boolean r3 = true;
    L6:
        if (r3 == true) goto L9;
        r2 = null;
    L9:
        if (r2 != null) goto L11;
        r2 = UUID.randomUUID().toString();
    L11:
        this.c = new r0(r1, r2, r5.b, r5.f);
        StateFlowImpl r7 = j1.a(new com.larus.bmhome.resource.access.a0.c(new com.larus.bmhome.resource.access.r("service", r6.getCode(), r6.getMsg(), r6)));
        this.d = r7;
        this.e = r7;
        return;
    L5:
        r3 = false;
        goto L6
    }
}
