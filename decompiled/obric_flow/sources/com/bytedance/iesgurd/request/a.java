package com.bytedance.iesgurd.request;

import com.bytedance.geckox.logger.GeckoLogger;
import com.bytedance.iesgurd.core.ReqType;
import java.util.concurrent.ThreadPoolExecutor;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class a extends bb.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f6665c;
    public final /* synthetic */ Object d;

    public /* synthetic */ a(Object r5, int r10) {
        this.f6665c = r10;
        this.d = r5;
    }

    @Override // bb.a
    public final void a() {
        switch(this.f6665c) {
            case 0: goto L9;
            default: goto L4;
        };
    L4:
        l9.g r5 = (l9.g) this.d;
        ((com.bytedance.iesgurd.settings.a) r5.d).getClass();
        GeckoLogger.a("sync global settings retry");
        ReqType r10 = com.bytedance.iesgurd.settings.d.f6695h;
        if (r10 != null) goto L7;
        Intrinsics.throwNpe();
    L7:
        int r11 = 0;
        ((ThreadPoolExecutor) com.bytedance.geckox.utils.c.f4791a.getValue()).execute(new com.bytedance.iesgurd.settings.b(r11, true, r10));
        r5.c();
        return;
    L9:
        Long r12 = this.f892b;
        if (r12 != null) goto L12;
        Intrinsics.throwNpe();
    L12:
        long r13 = r12.longValue();
        if (b.e.contains(Long.valueOf(r13)) == false) goto L20;
        g r14 = ((b) this.d).f6667b;
        if (r14 == null) goto L19;
        ((ThreadPoolExecutor) com.bytedance.geckox.utils.c.f4791a.getValue()).execute(new f(r14, 0));
        return;
    L19:
        return;
    }

    @Override // bb.a
    public final int b() {
        switch(this.f6665c) {
            case 0: goto L6;
            default: goto L4;
        };
    L4:
        return 2;
    L6:
        return 1;
    }
}
