package com.bytedance.android.livesdk.dslservice.slice;

import com.bytedance.android.livesdk.dsl.api.DSLType;
import com.bytedance.android.livesdk.dslservice.util.f;
import com.bytedance.android.livesdk.dslservice.util.o;
import com.bytedance.android.livesdk.dslservice.util.p;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import yt1.m;
import yt1.q;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class SliceDSLProcess$wrapInnerCallback$1 implements m {
    public final /* synthetic */ q a;
    public final /* synthetic */ p b;
    public final /* synthetic */ m c;

    @Override // yt1.m
    public final void onFetchSuccess() {
    }

    public SliceDSLProcess$wrapInnerCallback$1(q r1, p r2, m r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    @Override // yt1.m
    public final void a(com.bytedance.android.livesdk.dslservice.a r6, boolean r7, String r8) {
        Intrinsics.checkNotNullParameter(r8, "loadFrom");
        if (r8.length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        final String r1 = "UnKnown";
    L9:
        o r2 = o.f;
        r2.d(new SliceDSLProcess$wrapInnerCallback$1$onLoadSuccess$1(this, r1));
        p r3 = this.b;
        if (r3 == null) goto L12;
        r3.a(new e(this, r1));
    L12:
        String r4 = this.a.a;
        Intrinsics.checkNotNullParameter(r4, "id");
        Intrinsics.checkNotNullParameter(r1, "loadType");
        r2.f(DSLType.Slice, 1, r1, r4);
        m r5 = this.c;
        if (r5 == null) goto L16;
        r5.a(r6, r7, r8);
        return;
    L16:
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
        o r0 = o.f;
        String r1 = this.a.a;
        r0.getClass();
        Intrinsics.checkNotNullParameter(r1, "id");
        Intrinsics.checkNotNullParameter("", "loadType");
        r0.f(DSLType.Slice, 0, "", r1);
        Function1<f, Unit> r2 = new SliceDSLProcess$wrapInnerCallback$1$onFailed$1(this, r7, r8);
        Intrinsics.checkNotNullParameter(r2, "initBlock");
        r0.e(2, r2);
        m r3 = this.c;
        if (r3 == null) goto L6;
        r3.b(r6, r7, r8);
        return;
    }
}
