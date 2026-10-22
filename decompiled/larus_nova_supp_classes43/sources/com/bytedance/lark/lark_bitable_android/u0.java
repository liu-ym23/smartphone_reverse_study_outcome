package com.bytedance.lark.lark_bitable_android;

import com.bytedance.ai.event.MessageIndication;
import com.squareup.wire.ProtoAdapter;
import kotlin.jvm.internal.Intrinsics;
import lark_bitable.proto.FuncParamsX5f7e843510e32e23;
import lark_bitable.proto.FuncParamsX6a546484e25fe16c;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class u0 implements t0, q0 {
    public static final /* synthetic */ int b = 0;
    public final t0 a;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.lark.lark_bitable_android.t0
    public final void a(String r10) {
        Intrinsics.checkNotNullParameter(r10, "recordData");
        this.a.a(r10);
    }

    @Override // com.bytedance.lark.lark_bitable_android.t0
    public final void b(long r10, String r11) {
        Intrinsics.checkNotNullParameter(r11, MessageIndication.MESSAGE_TYPE_MSG);
        this.a.b(r10, r11);
    }

    public u0(yo4.a r1) {
        this.a = r1;
    }

    @Override // com.bytedance.lark.lark_bitable_android.q0
    public final BufferCallStatus c(long r10, RustBuffer.ByValue r11) {
        Intrinsics.checkNotNullParameter(r11, "params");
        if (r10 != (-5762565832228033837L)) goto L10;
        ProtoAdapter r12 = FuncParamsX5f7e843510e32e23.ADAPTER;
        RustBuffer.Companion.getClass();
        byte[] r13 = RustBuffer.a.b(r11);
        Intrinsics.checkNotNull(r13);
        FuncParamsX5f7e843510e32e23 r14 = (FuncParamsX5f7e843510e32e23) r12.decode(r13);
        NativeLib.Companion r15 = NativeLib.Companion;
        ByteString r16 = r14._molten_ctx;
        r15.getClass();
        a(r14.record_data);     // Catch: Exception -> L7
        BufferCallStatus r17 = BufferCallStatus.Companion.b(BufferCallStatus.Companion);     // Catch: Exception -> L7
    L8:
        NativeLib.Companion.getClass();
        return r17;
    L7:
        BufferCallStatus.Companion.getClass();
        r17 = BufferCallStatus.Companion.a("");
        goto L8
    L10:
        if (r10 != (-261539941716752714L)) goto L16;
        ProtoAdapter r18 = FuncParamsX6a546484e25fe16c.ADAPTER;
        RustBuffer.Companion.getClass();
        byte[] r19 = RustBuffer.a.b(r11);
        Intrinsics.checkNotNull(r19);
        FuncParamsX6a546484e25fe16c r20 = (FuncParamsX6a546484e25fe16c) r18.decode(r19);
        NativeLib.Companion r21 = NativeLib.Companion;
        ByteString r22 = r20._molten_ctx;
        r21.getClass();
        b(r20.error_code.longValue(), r20.msg);     // Catch: Exception -> L14
        BufferCallStatus r23 = BufferCallStatus.Companion.b(BufferCallStatus.Companion);     // Catch: Exception -> L14
    L15:
        NativeLib.Companion.getClass();
        return r23;
    L14:
        BufferCallStatus.Companion.getClass();
        r23 = BufferCallStatus.Companion.a("");
        goto L15
    L16:
        String r24 = "Unknown method[" + r10 + "] when invoke callback.";
        BufferCallStatus.Companion.getClass();
        return BufferCallStatus.Companion.a(r24);
    }
}
