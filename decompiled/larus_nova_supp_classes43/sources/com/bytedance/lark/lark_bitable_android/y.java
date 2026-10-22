package com.bytedance.lark.lark_bitable_android;

import com.byted.mgl.merge.service.api.share.BdpShareBaseInfo;
import com.bytedance.ai.event.MessageIndication;
import com.squareup.wire.ProtoAdapter;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import lark_bitable.proto.FuncParamsX4657aabcd36f0e4f;
import lark_bitable.proto.FuncParamsXbf3e1164f098d39a;
import lark_bitable.proto.FuncParamsXf0e8b7511932e1a5;
import lark_bitable.proto.FuncParamsXf9c6ac1ffb03e79e;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class y implements x, q0 {
    public static final /* synthetic */ int b = 0;
    public final x a;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.lark.lark_bitable_android.x
    public final void a(HomepageAction r10, String r11, long r12, String r13) {
        Intrinsics.checkNotNullParameter(r10, "action");
        Intrinsics.checkNotNullParameter(r11, BdpShareBaseInfo.CHANNEL_TOKEN);
        Intrinsics.checkNotNullParameter(r13, MessageIndication.MESSAGE_TYPE_MSG);
        this.a.a(r10, r11, r12, r13);
    }

    @Override // com.bytedance.lark.lark_bitable_android.x
    public final void b(HomepageListType r10, HomepageAction r11, i0 r12) {
        Intrinsics.checkNotNullParameter(r10, "listType");
        Intrinsics.checkNotNullParameter(r11, "action");
        Intrinsics.checkNotNullParameter(r12, "data");
        this.a.b(r10, r11, r12);
    }

    @Override // com.bytedance.lark.lark_bitable_android.x
    public final void d(HomepageAction r10, String r11, Map<String, String> r12) {
        Intrinsics.checkNotNullParameter(r10, "action");
        Intrinsics.checkNotNullParameter(r11, BdpShareBaseInfo.CHANNEL_TOKEN);
        Intrinsics.checkNotNullParameter(r12, "ext");
        this.a.d(r10, r11, r12);
    }

    @Override // com.bytedance.lark.lark_bitable_android.x
    public final void e(HomepageListType r10, HomepageAction r11, long r12, String r13) {
        Intrinsics.checkNotNullParameter(r10, "listType");
        Intrinsics.checkNotNullParameter(r11, "action");
        Intrinsics.checkNotNullParameter(r13, MessageIndication.MESSAGE_TYPE_MSG);
        this.a.e(r10, r11, r12, r13);
    }

    public y(x r1) {
        this.a = r1;
    }

    @Override // com.bytedance.lark.lark_bitable_android.q0
    public final BufferCallStatus c(long r10, RustBuffer.ByValue r12) {
        Intrinsics.checkNotNullParameter(r12, "params");
        if (r10 != (-8353522927257321916L)) goto L10;
        ProtoAdapter r11 = FuncParamsXf0e8b7511932e1a5.ADAPTER;
        RustBuffer.Companion.getClass();
        byte[] r13 = RustBuffer.a.b(r12);
        Intrinsics.checkNotNull(r13);
        FuncParamsXf0e8b7511932e1a5 r14 = (FuncParamsXf0e8b7511932e1a5) r11.decode(r13);
        NativeLib.Companion r15 = NativeLib.Companion;
        ByteString r16 = r14._molten_ctx;
        r15.getClass();
        b(n0.e(r14.list_type), n0.c(r14.action), n0.d(r14.data));     // Catch: Exception -> L7
        BufferCallStatus r17 = BufferCallStatus.Companion.b(BufferCallStatus.Companion);     // Catch: Exception -> L7
    L8:
        NativeLib.Companion.getClass();
        return r17;
    L7:
        BufferCallStatus.Companion.getClass();
        r17 = BufferCallStatus.Companion.a("");
        goto L8
    L10:
        if (r10 != (-5000738828788111096L)) goto L17;
        ProtoAdapter r18 = FuncParamsX4657aabcd36f0e4f.ADAPTER;
        RustBuffer.Companion.getClass();
        byte[] r19 = RustBuffer.a.b(r12);
        Intrinsics.checkNotNull(r19);
        FuncParamsX4657aabcd36f0e4f r110 = (FuncParamsX4657aabcd36f0e4f) r18.decode(r19);
        NativeLib.Companion r111 = NativeLib.Companion;
        ByteString r112 = r110._molten_ctx;
        r111.getClass();
        e(n0.e(r110.list_type), n0.c(r110.action), r110.error_code.longValue(), r110.msg);     // Catch: Exception -> L14
        BufferCallStatus r113 = BufferCallStatus.Companion.b(BufferCallStatus.Companion);     // Catch: Exception -> L14
    L15:
        NativeLib.Companion.getClass();
        return r113;
    L14:
        BufferCallStatus.Companion.getClass();
        r113 = BufferCallStatus.Companion.a("");
        goto L15
    L17:
        if (r10 != 2240601315713602371L) goto L24;
        ProtoAdapter r114 = FuncParamsXf9c6ac1ffb03e79e.ADAPTER;
        RustBuffer.Companion.getClass();
        byte[] r115 = RustBuffer.a.b(r12);
        Intrinsics.checkNotNull(r115);
        FuncParamsXf9c6ac1ffb03e79e r116 = (FuncParamsXf9c6ac1ffb03e79e) r114.decode(r115);
        NativeLib.Companion r117 = NativeLib.Companion;
        ByteString r118 = r116._molten_ctx;
        r117.getClass();
        d(n0.c(r116.action), r116.token, r116.ext);     // Catch: Exception -> L21
        BufferCallStatus r119 = BufferCallStatus.Companion.b(BufferCallStatus.Companion);     // Catch: Exception -> L21
    L22:
        NativeLib.Companion.getClass();
        return r119;
    L21:
        BufferCallStatus.Companion.getClass();
        r119 = BufferCallStatus.Companion.a("");
        goto L22
    L24:
        if (r10 != 6469028469354300685L) goto L30;
        ProtoAdapter r120 = FuncParamsXbf3e1164f098d39a.ADAPTER;
        RustBuffer.Companion.getClass();
        byte[] r121 = RustBuffer.a.b(r12);
        Intrinsics.checkNotNull(r121);
        FuncParamsXbf3e1164f098d39a r122 = (FuncParamsXbf3e1164f098d39a) r120.decode(r121);
        NativeLib.Companion r123 = NativeLib.Companion;
        ByteString r124 = r122._molten_ctx;
        r123.getClass();
        a(n0.c(r122.action), r122.token, r122.error_code.longValue(), r122.msg);     // Catch: Exception -> L28
        BufferCallStatus r125 = BufferCallStatus.Companion.b(BufferCallStatus.Companion);     // Catch: Exception -> L28
    L29:
        NativeLib.Companion.getClass();
        return r125;
    L28:
        BufferCallStatus.Companion.getClass();
        r125 = BufferCallStatus.Companion.a("");
        goto L29
    L30:
        String r126 = "Unknown method[" + r10 + "] when invoke callback.";
        BufferCallStatus.Companion.getClass();
        return BufferCallStatus.Companion.a(r126);
    }
}
