package com.bytedance.android.live.liveinteract.chatroom.chatroom.list;

import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public abstract class a extends ge0.a<BaseTalkApplyListContract$View> {
    public abstract void d(long r1);

    public abstract void e(boolean r1, String r2, long r3, String r5, int r6, boolean r7);

    public abstract Pair<Integer, Integer> g();

    public abstract void h();

    public a(BaseTalkApplyListContract$View r2) {
        Intrinsics.checkNotNullParameter(r2, "view");
        super(r2);
    }

    public static /* synthetic */ void f(a r8, boolean r9, String r10, long r11, String r13, int r14) {
        r8.e(r9, r10, r11, r13, r14, false);
    }
}
