package com.bytedance.lark.lark_bitable_android;

import com.bytedance.ai.event.MessageIndication;
import com.squareup.wire.ProtoAdapter;
import kotlin.jvm.internal.Intrinsics;
import lark_bitable.proto.BitableTenantTypeInfo;
import lark_bitable.proto.FuncParamsXc2c78c6ed1e909d8;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class m implements l, q0 {
    public static final /* synthetic */ int b = 0;
    public final l a;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.lark.lark_bitable_android.l
    public final void a(n r10, long r11, String r12) {
        Intrinsics.checkNotNullParameter(r12, MessageIndication.MESSAGE_TYPE_MSG);
        this.a.a(r10, r11, r12);
    }

    public m(xs4.c.f r1) {
        this.a = r1;
    }

    @Override // com.bytedance.lark.lark_bitable_android.q0
    public final BufferCallStatus c(long r10, RustBuffer.ByValue r11) {
        Intrinsics.checkNotNullParameter(r11, "params");
        if (r10 != 5318428122049788352L) goto L13;
        ProtoAdapter r12 = FuncParamsXc2c78c6ed1e909d8.ADAPTER;
        RustBuffer.Companion.getClass();
        byte[] r13 = RustBuffer.a.b(r11);
        Intrinsics.checkNotNull(r13);
        FuncParamsXc2c78c6ed1e909d8 r14 = (FuncParamsXc2c78c6ed1e909d8) r12.decode(r13);
        NativeLib.Companion r15 = NativeLib.Companion;
        ByteString r16 = r14._molten_ctx;
        r15.getClass();
        BitableTenantTypeInfo r17 = r14.data;     // Catch: Exception -> L11
        if (r17 == null) goto L8;
        Intrinsics.checkNotNullParameter(r17, "<this>");     // Catch: Exception -> L11
        n r18 = new n(r17.solo_user.booleanValue(), r17.solo_base.booleanValue());     // Catch: Exception -> L11
    L9:
        a(r18, r14.error_code.longValue(), r14.msg);     // Catch: Exception -> L11
        BufferCallStatus r19 = BufferCallStatus.Companion.b(BufferCallStatus.Companion);     // Catch: Exception -> L11
    L12:
        NativeLib.Companion.getClass();
        return r19;
    L8:
        r18 = null;
    L11:
        BufferCallStatus.Companion.getClass();
        r19 = BufferCallStatus.Companion.a("");
        goto L12
    L13:
        String r20 = "Unknown method[" + r10 + "] when invoke callback.";
        BufferCallStatus.Companion.getClass();
        return BufferCallStatus.Companion.a(r20);
    }
}
