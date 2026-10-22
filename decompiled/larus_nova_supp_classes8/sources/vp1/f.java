package vp1;

import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.config.a0;
import com.bytedance.android.livesdk.widgetdescriptor.e0;
import com.bytedance.android.scope.o;
import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.jvm.internal.Intrinsics;
import nm1.y;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class f implements y, o {
    public f() {
    }

    public final void onStart() {
    }

    public final void onStop() {
    }

    public final l c() {
        return new l();
    }

    public final k d() {
        return new k();
    }

    public final void g() {
        e r0 = e.a;
    }

    public final com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.config.y a(DataCenter r2) {
        Intrinsics.checkNotNullParameter(r2, "dataCenter");
        return new com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.config.y(r2);
    }

    public final a0 f(DataCenter r2) {
        Intrinsics.checkNotNullParameter(r2, "dataCenter");
        return new a0(r2);
    }

    public final g h(e0 r3, mg2.d r4, jm1.a.a r5) {
        Intrinsics.checkNotNullParameter(r3, "mLayerContext");
        Intrinsics.checkNotNullParameter(r4, "mComponentManager");
        if ((r3 instanceof d90.d) == true) goto L6;
        r3 = null;
    L6:
        return new g(r3, r4, r5);
    }
}
