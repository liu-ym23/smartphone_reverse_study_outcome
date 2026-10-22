package yrb;

import com.bytedance.lark.view_flow_wrapper.y;
import com.bytedance.lark.view_flow_wrapper.z;
import com.ss.android.lark.log.Log;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class c implements y {
    public c() {
    }

    public final void a(z r3) {
        Intrinsics.checkNotNullParameter(r3, "info");
        Log.i("ViewFlowLogCallback", "onCallbackInfo info:" + r3);
    }
}
