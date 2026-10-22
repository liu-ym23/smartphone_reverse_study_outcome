package l11;

import com.bytedance.android.live.revlink.impl.pk.service.i;
import com.bytedance.android.scope.o;
import k11.h;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class d implements h, o {
    public final com.bytedance.android.live.revlink.impl.global.c a;

    @Override // k11.h
    public final void dismissNativePanel(int r1) {
    }

    public final void onStart() {
    }

    public final void onStop() {
    }

    @Override // k11.h
    public final void openPanel(int r1) {
    }

    public d(com.bytedance.android.live.revlink.impl.global.c r1) {
        this.a = r1;
    }

    @Override // k11.h
    public final void showTipsOnPkIcon(String r2) {
        Intrinsics.checkNotNullParameter(r2, "tipString");
        com.bytedance.android.live.revlink.impl.global.c r0 = this.a;
        if (r0 == null) goto L5;
        i r1 = r0.Hg();
    L6:
        if (r1 == null) goto L9;
        r1.J2(r2);
        return;
    L9:
        return;
    L5:
        r1 = null;
        goto L6
    }
}
