package com.bytedance.android.livesdk.dslservice.lynxair;

import com.bytedance.android.livesdk.dsl.api.DSLType;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import yt1.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class LynxAirDSLProcess$wrapCallback$1 implements m {
    public final /* synthetic */ String a;
    public final /* synthetic */ m b;

    @Override // yt1.m
    public final void onFetchSuccess() {
    }

    public LynxAirDSLProcess$wrapCallback$1(String r1, m r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // yt1.m
    public final void a(com.bytedance.android.livesdk.dslservice.a r6, boolean r7, String r8) {
        Intrinsics.checkNotNullParameter(r8, "loadFrom");
        if (r8.length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        String r1 = "UnKnown";
    L9:
        com.bytedance.android.livesdk.dslservice.util.m r2 = com.bytedance.android.livesdk.dslservice.util.m.h;
        r2.d(new LynxAirDSLProcess$wrapCallback$1$onLoadSuccess$1(this));
        String r3 = this.a;
        Intrinsics.checkNotNullParameter(r3, "id");
        Intrinsics.checkNotNullParameter(r1, "loadType");
        r2.f(DSLType.LynxAir, 1, r1, r3);
        m r4 = this.b;
        if (r4 == null) goto L13;
        r4.a(r6, r7, r8);
        return;
    L13:
        return;
    L8:
        r1 = r8;
        goto L9
    L5:
        r0 = false;
        goto L6
    }

    @Override // yt1.m
    public final void b(String r6, final String r7, final Throwable r8) {
        Intrinsics.checkNotNullParameter(r6, "type");
        Intrinsics.checkNotNullParameter(r7, "reason");
        com.bytedance.android.livesdk.dslservice.util.m r0 = com.bytedance.android.livesdk.dslservice.util.m.h;
        Function1<com.bytedance.android.livesdk.dslservice.util.f, Unit> r1 = new LynxAirDSLProcess$wrapCallback$1$onFailed$1(this, r7, r8);
        r0.getClass();
        Intrinsics.checkNotNullParameter(r1, "initBlock");
        r0.e(2, r1);
        String r2 = this.a;
        Intrinsics.checkNotNullParameter(r2, "id");
        Intrinsics.checkNotNullParameter("", "loadType");
        r0.f(DSLType.LynxAir, 0, "", r2);
        m r3 = this.b;
        if (r3 == null) goto L6;
        r3.b(r6, r7, r8);
        return;
    }
}
