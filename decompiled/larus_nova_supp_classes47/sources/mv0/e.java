package mv0;

import com.bytedance.android.live.core.tetris.layer.core.tetris.Tetris;
import com.bytedance.android.livesdk.chatroom.dsl.DSLContainerDynamicProxy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class e implements l71.b {
    public static final e a = null;

    public e() {
    }

    static {
        a = new e();
    }

    @Override // l71.b
    public final is2.k a(d90.d r3, Tetris r4) {
        Intrinsics.checkNotNullParameter(r3, "layerContext");
        Intrinsics.checkNotNullParameter("con_4_1", "tag");
        Intrinsics.checkNotNullParameter(r4, "provider");
        com.bytedance.android.livesdk.chatroom.dsl.b r0 = DSLContainerDynamicProxy.f;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.a(r3, "con_4_1", r4);
    }
}
