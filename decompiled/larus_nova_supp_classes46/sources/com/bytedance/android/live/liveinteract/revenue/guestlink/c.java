package com.bytedance.android.live.liveinteract.revenue.guestlink;

import com.bytedance.android.live.liveinteract.playmode.SceneType;
import com.bytedance.ies.sdk.widgets.Widget;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class c extends com.bytedance.android.live.liveinteract.revenuebase.e {

    public static final class a implements ne0.d {
        public a() {
        }

        @Override // ne0.d
        public final void a(HashMap<String, String> r2) {
            Intrinsics.checkNotNullParameter(r2, "stateMapping");
        }

        @Override // ne0.d
        public final void b() {
        }
    }

    public c() {
    }

    @Override // xh0.e
    public final ne0.d a(SceneType r2) {
        Intrinsics.checkNotNullParameter(r2, "sceneType");
        return new a();
    }

    @Override // xh0.e
    public final Widget b(SceneType r2) {
        Intrinsics.checkNotNullParameter(r2, "sceneType");
        return new GuestLinkWidget();
    }

    @Override // xh0.e
    public final boolean c(SceneType r3) {
        Intrinsics.checkNotNullParameter(r3, "sceneType");
        int r4 = b.a[r3.ordinal()];
        if (r4 != 1) goto L5;
        return true;
    L5:
        if (r4 == 2) goto L9;
        return false;
    L9:
        return true;
    }
}
