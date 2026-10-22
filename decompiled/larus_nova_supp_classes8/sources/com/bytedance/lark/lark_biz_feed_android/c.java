package com.bytedance.lark.lark_biz_feed_android;

import com.ss.android.lark.integrator.im.impl.IIMUserServiceImpl;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import lark_biz_feed.proto.FuncParamsX4199da73f91db0ad;
import lark_biz_feed.proto.MoltenContextExtra;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class c implements com.bytedance.lark.lark_biz_feed_android.a, u0 {
    public static final /* synthetic */ int b = 0;
    public final com.bytedance.lark.lark_biz_feed_android.a a;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.lark.lark_biz_feed_android.a
    public final void a(n r2) {
        Intrinsics.checkNotNullParameter(r2, "feedInfo");
        this.a.a(r2);
    }

    public c(IIMUserServiceImpl.onPrepared.1.1.1 r1) {
        this.a = r1;
    }

    @Override // com.bytedance.lark.lark_biz_feed_android.u0
    public final byte[] onInvoke(long r4, byte[] r6) {
        Intrinsics.checkNotNullParameter(r6, "params");
        if (r4 != (-6641117295906122853L)) goto L15;
        Object r5 = FuncParamsX4199da73f91db0ad.ADAPTER.decode(r6);
        Intrinsics.checkNotNull(r5);
        FuncParamsX4199da73f91db0ad r7 = (FuncParamsX4199da73f91db0ad) r5;
        Lazy<Long> r8 = MoltenFfiLibLarkBizFeed.a;
        Object r9 = MoltenFfiLibLarkBizFeed.a.d(r7._molten_ctx);
        a(s0.a(r7.feed_info));     // Catch: Throwable -> L8 Exception -> L10
        Unit r10 = Unit.INSTANCE;     // Catch: Throwable -> L8 Exception -> L10
        MoltenContextExtra r11 = new MoltenContextExtra(null);     // Catch: Throwable -> L8 Exception -> L10
        Pair r12 = new Pair(0L, MoltenContextExtra.ADAPTER.encode(r11));     // Catch: Throwable -> L8 Exception -> L10
        MoltenFfiLibLarkBizFeed.a.c(r9);
        return (byte[]) r12.getSecond();
    L10:
        e = move-exception;
        throw e;     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        Lazy<Long> r13 = MoltenFfiLibLarkBizFeed.a;
        MoltenFfiLibLarkBizFeed.a.c(r9);
        throw th;
    L15:
        throw new Exception("onInvoke $[methodId] $[desc]");
    }

    @Override // com.bytedance.lark.lark_biz_feed_android.u0
    public final void onInvokeAsync(long r1, long r3, byte[] r5) {
        Intrinsics.checkNotNullParameter(r5, "params");
        throw new RuntimeException("onInvokeAsync not implemented");
    }
}
