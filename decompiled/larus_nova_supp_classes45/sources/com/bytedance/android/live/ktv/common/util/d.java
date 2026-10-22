package com.bytedance.android.live.ktv.common.util;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class d implements m {
    public final tb0.a a;

    public d(tb0.a r2) {
        Intrinsics.checkNotNullParameter(r2, "lc");
        this.a = r2;
    }

    @Override // com.bytedance.android.live.ktv.common.util.m
    public final void b(tb0.c r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
        Intrinsics.checkNotNullParameter(r2, "state");
    }

    @Override // com.bytedance.android.live.ktv.common.util.m
    public final void a(tb0.b r2, tb0.c r3) {
        Intrinsics.checkNotNullParameter(r2, "e");
        Intrinsics.checkNotNullParameter(r3, "state");
        if ((r2 instanceof tb0.b.a) == false) goto L6;
        this.a.onBizEnterRoom();
        return;
    L6:
        if ((r2 instanceof tb0.b.C0280b) == false) goto L9;
        this.a.onBizLeaveRoom();
        return;
    L9:
        if ((r2 instanceof tb0.b.d) == false) goto L12;
        this.a.onBizShow();
        return;
    L12:
        if ((r2 instanceof tb0.b.c) == false) goto L15;
        this.a.onBizHide();
        return;
    L15:
        if ((r2 instanceof tb0.b.e) == false) goto L22;
        this.a.onBizDestory();
        return;
    }
}
