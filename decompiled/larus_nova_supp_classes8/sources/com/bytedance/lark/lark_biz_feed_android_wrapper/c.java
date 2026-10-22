package com.bytedance.lark.lark_biz_feed_android_wrapper;

import com.bytedance.lark.lark_biz_feed_android.MoltenFfiLibLarkBizFeed;
import com.bytedance.lark.lark_biz_feed_android.g;
import com.bytedance.lark.lark_biz_feed_android.m;
import com.bytedance.lark.view_flow_wrapper.e;
import com.bytedance.lark.view_flow_wrapper.i;
import com.bytedance.lark.view_flow_wrapper.k;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public class c<VF extends i> {
    public final Function0<VF> a;

    public static final class a implements g {
        public a() {
        }

        @Override // com.bytedance.lark.lark_biz_feed_android.g
        public final byte[] a(m r10) {
            Intrinsics.checkNotNullParameter(r10, "info");
            e r1 = com.bytedance.lark.view_flow_wrapper.internal.a.a;
            k r2 = new k(r10.a, r10.b, r10.c, r10.d, r10.e);
            Intrinsics.checkNotNullParameter(r2, "info");
            e r11 = com.bytedance.lark.view_flow_wrapper.internal.a.a;
            if (r11 != null) goto L7;
            return null;
        L7:
            return r11.a(r2);
        }

        @Override // com.bytedance.lark.lark_biz_feed_android.g
        public final void onInvokeeEnd(Object r3) {
            Intrinsics.checkNotNullParameter(r3, "invokeeObj");
            e r1 = com.bytedance.lark.view_flow_wrapper.internal.a.a;
            Intrinsics.checkNotNullParameter(r3, "invokeeObj");
            e r0 = com.bytedance.lark.view_flow_wrapper.internal.a.a;
            if (r0 == null) goto L6;
            r0.onInvokeeEnd(r3);
            return;
        }

        @Override // com.bytedance.lark.lark_biz_feed_android.g
        public final Object onInvokeeStart(byte[] r3) {
            Intrinsics.checkNotNullParameter(r3, "hookBuf");
            e r1 = com.bytedance.lark.view_flow_wrapper.internal.a.a;
            Intrinsics.checkNotNullParameter(r3, "hookBuf");
            e r0 = com.bytedance.lark.view_flow_wrapper.internal.a.a;
            if (r0 != null) goto L7;
            return null;
        L7:
            return r0.onInvokeeStart(r3);
        }
    }

    public static final class b {
    }

    static {
        MoltenFfiLibLarkBizFeed.b = new a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public c(Function0<? extends VF> r2) {
        Intrinsics.checkNotNullParameter(r2, "viewFlowProvider");
        this.a = r2;
    }
}
