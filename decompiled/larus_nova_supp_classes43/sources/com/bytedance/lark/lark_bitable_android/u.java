package com.bytedance.lark.lark_bitable_android;

import com.squareup.wire.ProtoAdapter;
import kotlin.jvm.internal.Intrinsics;
import lark_bitable.proto.FuncParamsX2998eb4c8f2d270e;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class u implements t, q0 {
    public static final /* synthetic */ int b = 0;
    public final t a;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.lark.lark_bitable_android.t
    public final void a(int r10, int r11) {
        this.a.a(r10, r11);
    }

    public u(com.bytedance.ee.bear.bitable.homepage.badge.b.c r1) {
        this.a = r1;
    }

    @Override // com.bytedance.lark.lark_bitable_android.q0
    public final BufferCallStatus c(long r10, RustBuffer.ByValue r11) {
        Intrinsics.checkNotNullParameter(r11, "params");
        if (r10 != 7378297650505920995L) goto L9;
        ProtoAdapter r12 = FuncParamsX2998eb4c8f2d270e.ADAPTER;
        RustBuffer.Companion.getClass();
        byte[] r13 = RustBuffer.a.b(r11);
        Intrinsics.checkNotNull(r13);
        FuncParamsX2998eb4c8f2d270e r14 = (FuncParamsX2998eb4c8f2d270e) r12.decode(r13);
        NativeLib.Companion r15 = NativeLib.Companion;
        ByteString r16 = r14._molten_ctx;
        r15.getClass();
        a(r14.homepage_tab_count.intValue(), r14.feed_tab_count.intValue());     // Catch: Exception -> L7
        BufferCallStatus r17 = BufferCallStatus.Companion.b(BufferCallStatus.Companion);     // Catch: Exception -> L7
    L8:
        NativeLib.Companion.getClass();
        return r17;
    L7:
        BufferCallStatus.Companion.getClass();
        r17 = BufferCallStatus.Companion.a("");
        goto L8
    L9:
        String r18 = "Unknown method[" + r10 + "] when invoke callback.";
        BufferCallStatus.Companion.getClass();
        return BufferCallStatus.Companion.a(r18);
    }
}
