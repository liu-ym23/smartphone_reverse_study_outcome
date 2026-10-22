package com.bytedance.lark.lark_biz_feed_android;

import com.bytedance.lark.lark_biz_feed_android_wrapper.LarkFeedListViewFlowWrapper$action$2;
import com.squareup.wire.ProtoAdapter;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import lark_biz_feed.proto.FuncParamsX86234f93c431e40c;
import lark_biz_feed.proto.MoltenContextExtra;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class j0 implements i0, u0 {
    public static final /* synthetic */ int b = 0;
    public final i0 a;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.lark.lark_biz_feed_android.i0
    public final void a(ViewFlowError r2) {
        Intrinsics.checkNotNullParameter(r2, "error");
        this.a.a(r2);
    }

    @Override // com.bytedance.lark.lark_biz_feed_android.i0
    public final void onSuccess() {
        this.a.onSuccess();
    }

    public j0(LarkFeedListViewFlowWrapper$action$2.a r1) {
        this.a = r1;
    }

    @Override // com.bytedance.lark.lark_biz_feed_android.u0
    public final byte[] onInvoke(long r6, byte[] r8) {
        Intrinsics.checkNotNullParameter(r8, "params");
        if (r6 != 1353075466735300217L) goto L14;
        ProtoAdapter r7 = MoltenContextExtra.ADAPTER;
        Object r9 = r7.decode(r8);
        Intrinsics.checkNotNull(r9);
        Lazy<Long> r10 = MoltenFfiLibLarkBizFeed.a;
        Object r11 = MoltenFfiLibLarkBizFeed.a.d(((MoltenContextExtra) r9)._molten_ctx);
        onSuccess();     // Catch: Throwable -> L7 Exception -> L9
        Unit r12 = Unit.INSTANCE;     // Catch: Throwable -> L7 Exception -> L9
        Pair r1 = new Pair(0L, r7.encode(new MoltenContextExtra(null)));     // Catch: Throwable -> L7 Exception -> L9
        MoltenFfiLibLarkBizFeed.a.c(r11);
        return (byte[]) r1.getSecond();
    L7:
        th = move-exception;
        Lazy<Long> r13 = MoltenFfiLibLarkBizFeed.a;
        MoltenFfiLibLarkBizFeed.a.c(r11);
        throw th;
    L9:
        e = move-exception;
        throw e;     // Catch: Throwable -> L7
    L14:
        if (r6 != (-2999264081924187039L)) goto L26;
        Object r14 = FuncParamsX86234f93c431e40c.ADAPTER.decode(r8);
        Intrinsics.checkNotNull(r14);
        FuncParamsX86234f93c431e40c r15 = (FuncParamsX86234f93c431e40c) r14;
        Lazy<Long> r16 = MoltenFfiLibLarkBizFeed.a;
        Object r17 = MoltenFfiLibLarkBizFeed.a.d(r15._molten_ctx);
        a(s0.d(r15.error));     // Catch: Throwable -> L19 Exception -> L21
        Unit r18 = Unit.INSTANCE;     // Catch: Throwable -> L19 Exception -> L21
        MoltenContextExtra r19 = new MoltenContextExtra(null);     // Catch: Throwable -> L19 Exception -> L21
        Pair r20 = new Pair(0L, MoltenContextExtra.ADAPTER.encode(r19));     // Catch: Throwable -> L19 Exception -> L21
        MoltenFfiLibLarkBizFeed.a.c(r17);
        return (byte[]) r20.getSecond();
    L19:
        th = move-exception;
        Lazy<Long> r21 = MoltenFfiLibLarkBizFeed.a;
        MoltenFfiLibLarkBizFeed.a.c(r17);
        throw th;
    L21:
        e = move-exception;
        throw e;     // Catch: Throwable -> L19
    L26:
        throw new Exception("onInvoke $[methodId] $[desc]");
    }

    @Override // com.bytedance.lark.lark_biz_feed_android.u0
    public final void onInvokeAsync(long r1, long r3, byte[] r5) {
        Intrinsics.checkNotNullParameter(r5, "params");
        throw new RuntimeException("onInvokeAsync not implemented");
    }
}
