package com.bytedance.lark.lark_biz_feed_android;

import com.bytedance.lark.lark_biz_feed_android_wrapper.LarkFeedListViewFlowWrapper;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import lark_biz_feed.proto.FuncParamsX863fc13505d7d967;
import lark_biz_feed.proto.MoltenContextExtra;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class m0 implements l0, u0 {
    public static final /* synthetic */ int b = 0;
    public final l0 a;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.lark.lark_biz_feed_android.l0
    public final void a(o0 r2) {
        Intrinsics.checkNotNullParameter(r2, "field");
        this.a.a(r2);
    }

    public m0(LarkFeedListViewFlowWrapper.AnonymousClass1.a r1) {
        this.a = r1;
    }

    @Override // com.bytedance.lark.lark_biz_feed_android.u0
    public final byte[] onInvoke(long r4, byte[] r6) {
        Intrinsics.checkNotNullParameter(r6, "params");
        if (r4 != (-4974733442146425286L)) goto L15;
        Object r5 = FuncParamsX863fc13505d7d967.ADAPTER.decode(r6);
        Intrinsics.checkNotNull(r5);
        FuncParamsX863fc13505d7d967 r7 = (FuncParamsX863fc13505d7d967) r5;
        Lazy<Long> r8 = MoltenFfiLibLarkBizFeed.a;
        Object r9 = MoltenFfiLibLarkBizFeed.a.d(r7._molten_ctx);
        a(s0.b(r7.field));     // Catch: Throwable -> L8 Exception -> L10
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
