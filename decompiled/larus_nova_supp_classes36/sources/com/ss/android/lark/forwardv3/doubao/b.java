package com.ss.android.lark.forwardv3.doubao;

import android.content.Intent;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.ss.android.lark.forwardv3.plugins.i;
import com.ss.android.lark.log.Log;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class b implements i {
    public final long a;
    public final Function0<Boolean> b;

    public static final class a {
    }

    static {
    }

    @Override // com.ss.android.lark.forwardv3.plugins.i
    public final void a(Intent r1) {
    }

    @Override // com.ss.android.lark.forwardv3.plugins.i
    public final i b(FragmentActivity r1, Fragment r2, View r3) {
        Intrinsics.checkNotNullParameter(r3, "pluginTarget");
        return this;
    }

    @Override // com.ss.android.lark.forwardv3.plugins.i
    public final void c() {
    }

    @Override // com.ss.android.lark.forwardv3.plugins.i
    public final void e(Object r2) {
        Intrinsics.checkNotNullParameter(r2, "params");
    }

    @Override // com.ss.android.lark.forwardv3.plugins.i
    public final void d() {
        if (((Boolean) this.b.invoke()).booleanValue() == true) goto L28;
        AtomicReference<com.ss.android.lark.forwardv3.doubao.a> r0 = c.a;
        long r1 = this.a;
        Intrinsics.checkNotNullParameter("forward session plugin destroy", "reason");
        AtomicReference<com.ss.android.lark.forwardv3.doubao.a> r2 = c.a;
        com.ss.android.lark.forwardv3.doubao.a r3 = r2.get();
        boolean r4 = true;
        if (r3 != null) goto L7;
    L9:
        boolean r5 = false;
    L11:
        if (r5 == true) goto L18;
        StringBuilder r6 = new StringBuilder("skip clearing doubao forward session: reason=forward session plugin destroy, hasCurrent=");
        if (r3 != null) goto L16;
        r4 = false;
    L16:
        r6.append(r4);
        Log.i("NewForward", r6.toString());
        return;
    L18:
        if (r2.compareAndSet(r3, null) == true) goto L23;
        if (r2.get() == r3) goto L18;
        r4 = false;
    L23:
        Log.i("NewForward", "clear doubao forward session: reason=forward session plugin destroy, cleared=" + r4);
        return;
    L7:
        if (0 != r1) goto L9;
        r5 = true;
        goto L11
    }

    public b(long r2, Function0<Boolean> r4) {
        Intrinsics.checkNotNullParameter(r4, "isChangingConfigurations");
        this.a = r2;
        this.b = r4;
    }
}
