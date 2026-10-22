package com.bytedance.lark.lark_bitable_android;

import com.bytedance.ee.bear.bitable.homepage.list.newlist.SharedBitableHomeListNewViewModel;
import com.squareup.wire.ProtoAdapter;
import kotlin.jvm.internal.Intrinsics;
import lark_bitable.proto.FuncParamsX8f81da39e50895ee;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class e0 implements d0, q0 {
    public static final /* synthetic */ int b = 0;
    public final d0 a;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.lark.lark_bitable_android.d0
    public final void a(HomepageListType r10, String r11, String r12) {
        Intrinsics.checkNotNullParameter(r10, "listType");
        Intrinsics.checkNotNullParameter(r11, com.bytedance.android.ec.core.event.a.KEY_SHOPPING_GUIDE_NAME);
        this.a.a(r10, r11, r12);
    }

    public e0(SharedBitableHomeListNewViewModel.a r1) {
        this.a = r1;
    }

    @Override // com.bytedance.lark.lark_bitable_android.q0
    public final BufferCallStatus c(long r10, RustBuffer.ByValue r11) {
        Intrinsics.checkNotNullParameter(r11, "params");
        if (r10 != 4214640200547125441L) goto L9;
        ProtoAdapter r12 = FuncParamsX8f81da39e50895ee.ADAPTER;
        RustBuffer.Companion.getClass();
        byte[] r13 = RustBuffer.a.b(r11);
        Intrinsics.checkNotNull(r13);
        FuncParamsX8f81da39e50895ee r14 = (FuncParamsX8f81da39e50895ee) r12.decode(r13);
        NativeLib.Companion r15 = NativeLib.Companion;
        ByteString r16 = r14._molten_ctx;
        r15.getClass();
        a(n0.e(r14.list_type), r14.name, r14.space_token);     // Catch: Exception -> L7
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
