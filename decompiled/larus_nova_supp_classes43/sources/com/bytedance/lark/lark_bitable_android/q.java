package com.bytedance.lark.lark_bitable_android;

import com.bytedance.ai.event.MessageIndication;
import com.squareup.wire.ProtoAdapter;
import kotlin.jvm.internal.Intrinsics;
import lark_bitable.proto.BitableMorePanelPermission;
import lark_bitable.proto.FuncParamsX41cc6cb809b521a6;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class q implements p, q0 {
    public static final /* synthetic */ int b = 0;
    public final p a;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.lark.lark_bitable_android.p
    public final void a(j r10, long r11, String r12) {
        Intrinsics.checkNotNullParameter(r10, "data");
        Intrinsics.checkNotNullParameter(r12, MessageIndication.MESSAGE_TYPE_MSG);
        this.a.a(r10, r11, r12);
    }

    public q(xs4.c.c r1) {
        this.a = r1;
    }

    @Override // com.bytedance.lark.lark_bitable_android.q0
    public final BufferCallStatus c(long r10, RustBuffer.ByValue r11) {
        Intrinsics.checkNotNullParameter(r11, "params");
        if (r10 != 7953617148342569298L) goto L9;
        ProtoAdapter r12 = FuncParamsX41cc6cb809b521a6.ADAPTER;
        RustBuffer.Companion.getClass();
        byte[] r13 = RustBuffer.a.b(r11);
        Intrinsics.checkNotNull(r13);
        FuncParamsX41cc6cb809b521a6 r14 = (FuncParamsX41cc6cb809b521a6) r12.decode(r13);
        NativeLib.Companion r15 = NativeLib.Companion;
        ByteString r16 = r14._molten_ctx;
        r15.getClass();
        BitableMorePanelPermission r17 = r14.data;     // Catch: Exception -> L7
        Intrinsics.checkNotNullParameter(r17, "<this>");     // Catch: Exception -> L7
        a(new j(r17.can_change_workspace.booleanValue(), r17.can_move_out_workspace.booleanValue(), r17.can_move_in_workspace.booleanValue(), r17.workspace_token, r17.workspace_name), r14.error_code.longValue(), r14.msg);     // Catch: Exception -> L7
        BufferCallStatus r18 = BufferCallStatus.Companion.b(BufferCallStatus.Companion);     // Catch: Exception -> L7
    L8:
        NativeLib.Companion.getClass();
        return r18;
    L7:
        BufferCallStatus.Companion.getClass();
        r18 = BufferCallStatus.Companion.a("");
        goto L8
    L9:
        String r19 = "Unknown method[" + r10 + "] when invoke callback.";
        BufferCallStatus.Companion.getClass();
        return BufferCallStatus.Companion.a(r19);
    }
}
