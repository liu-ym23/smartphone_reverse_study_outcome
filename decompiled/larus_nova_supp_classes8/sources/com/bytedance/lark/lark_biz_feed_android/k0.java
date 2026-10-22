package com.bytedance.lark.lark_biz_feed_android;

import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;
import lark_biz_feed.proto.ForegroundUserContainerScope;
import lark_biz_feed.proto.FuncErrorXb20506848349f8f4;
import lark_biz_feed.proto.FuncParamsX1481112f09a0a4cd;
import lark_biz_feed.proto.FuncResultX5fa2ad7ee23bcf9f;
import lark_biz_feed.proto.FuncReturnXfa2575f514facd38;
import lark_biz_feed.proto.LarkFeedListContext;
import lark_biz_feed.proto.LarkFeedListContextWrapped;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class k0 extends v0 {

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.lark.lark_biz_feed_android.v0
    public final void a() {
        Lazy<Long> r0 = MoltenFfiLibLarkBizFeed.a;     // Catch: RuntimeException -> L4
        MoltenFfiLibLarkBizFeed.molten_ffi_lark_biz_feed_free(MoltenFfiLibLarkBizFeed.a.b(), this.a, 3811217437165092864L);     // Catch: RuntimeException -> L4
        return;
    L4:
        e = move-exception;
        if (e.getMessage() == null) goto L9;
        int r1 = h.a;
        String r2 = e.getMessage();
        Intrinsics.checkNotNull(r2);
        UnhandledException r3 = new UnhandledException(r2);
        Intrinsics.checkNotNullParameter(r3, "e");
        throw r3;
    L9:
        int r4 = h.a;
        UnhandledException r5 = new UnhandledException("Rust panic");
        Intrinsics.checkNotNullParameter(r5, "e");
        throw r5;
    }

    public k0(g0 r13) {
        Intrinsics.checkNotNullParameter(r13, "context");
        Lazy<Long> r0 = MoltenFfiLibLarkBizFeed.a;
        ByteString r1 = MoltenFfiLibLarkBizFeed.a.a(new m("new"));
        r13.getClass();
        f0 r3 = r13.a;
        r3.getClass();
        Integer r5 = Integer.valueOf(r3.a);
        l r4 = r3.b;
        r4.getClass();
        LarkFeedListContext r6 = new LarkFeedListContext(r5, new ForegroundUserContainerScope(Long.valueOf(r4.a)));
        l r14 = r13.b;
        r14.getClass();
        byte[] r11 = new FuncParamsX1481112f09a0a4cd(new LarkFeedListContextWrapped(r6, new ForegroundUserContainerScope(Long.valueOf(r14.a))), r1).encode();
        long r7 = MoltenFfiLibLarkBizFeed.a.b();     // Catch: RuntimeException -> L10
        Intrinsics.checkNotNull(r11);     // Catch: RuntimeException -> L10
        byte[] r15 = MoltenFfiLibLarkBizFeed.molten_ffi_lark_biz_feed_call(r7, 0, -5255579277148925759L, r11);     // Catch: RuntimeException -> L10
        FuncResultX5fa2ad7ee23bcf9f r16 = (FuncResultX5fa2ad7ee23bcf9f) FuncResultX5fa2ad7ee23bcf9f.ADAPTER.decode(r15);
        FuncErrorXb20506848349f8f4 r2 = r16.err;
        if (r2 != null) goto L8;
        FuncReturnXfa2575f514facd38 r17 = r16.ret;
        Intrinsics.checkNotNull(r17);
        Long r18 = r17.ret;
        Intrinsics.checkNotNull(r18);
        super(r18.longValue());
        return;
    L8:
        Intrinsics.checkNotNull(r2);
        throw s0.d(r2.err);
    L10:
        e = move-exception;
        if (e.getMessage() == null) goto L15;
        int r8 = h.a;
        String r19 = e.getMessage();
        Intrinsics.checkNotNull(r19);
        UnhandledException r9 = new UnhandledException(r19);
        Intrinsics.checkNotNullParameter(r9, "e");
        throw r9;
    L15:
        int r110 = h.a;
        UnhandledException r111 = new UnhandledException("Rust panic");
        Intrinsics.checkNotNullParameter(r111, "e");
        throw r111;
    }
}
