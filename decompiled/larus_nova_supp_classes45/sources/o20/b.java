package o20;

import com.bytedance.android.annie.xbridge.mix.StateMethodFinder;
import com.bytedance.ies.bullet.base.bridge.o;
import com.bytedance.ies.bullet.core.BulletContext;
import com.bytedance.sdk.xbridge.cn.protocol.MethodFinder;
import kotlin.jvm.internal.Intrinsics;
import ue7.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class b extends o {
    public final boolean I0() {
        if (Intrinsics.areEqual(((s26.a) this).a, "webcast") == false) goto L6;
        return true;
    L6:
        return this instanceof com.bytedance.caijing.sdk.infra.base.impl.container.annie_container.extension.a;
    }

    public final boolean J0() {
        if (Intrinsics.areEqual(((s26.a) this).a, "webcast") == false) goto L6;
        return true;
    L6:
        return this instanceof com.bytedance.caijing.sdk.infra.base.impl.container.annie_container.extension.a;
    }

    public b() {
    }

    public final MethodFinder G0(m16.b r4) {
        Intrinsics.checkNotNullParameter(r4, "providerFactory");
        BulletContext r0 = (BulletContext) r4.c(BulletContext.class);
        if (r0 == null) goto L5;
        String r1 = r0.f;
    L7:
        if (Intrinsics.areEqual(r1, "webcast") == true) goto L9;
        c r2 = (c) r4.c(c.class);
        if (r2 == null) goto L13;
        String r3 = r2.b();
    L15:
        if (Intrinsics.areEqual(r3, "webcast") == true) goto L17;
        return null;
    L17:
        return new StateMethodFinder(r4);
    L13:
        r3 = null;
        goto L15
    L9:
        return new StateMethodFinder(r4);
    L5:
        r1 = null;
        goto L7
    }
}
