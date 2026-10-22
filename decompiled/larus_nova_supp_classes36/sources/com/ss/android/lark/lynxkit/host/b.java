package com.ss.android.lark.lynxkit.host;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;
import tqb.c;
import tqb.d;
import tqb.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class b extends tqb.a implements ILarkLynxFragmentHolder {
    public String g;
    public LarkLynxFragment h;

    @Override // tqb.a, tqb.g
    public final void d() {
        this.g = null;
        this.h = null;
    }

    @Override // tqb.a, com.ss.android.lark.lynxkit.host.ILarkLynxHostHolder
    public final void destroy() {
        super.destroy();
        ConcurrentHashMap<String, d> r0 = f.a;
        f.c(this.g);
        this.g = null;
        this.h = null;
    }

    @Override // tqb.a, tqb.g
    public final void c(c r2) {
        Intrinsics.checkNotNullParameter(r2, "controller");
        Intrinsics.checkNotNullParameter(r2, "controller");
        this.f = r2;
        if ((r2 instanceof LarkLynxFragment) == false) goto L6;
        this.h = (LarkLynxFragment) r2;
        return;
    }

    @Override // com.ss.android.lark.lynxkit.host.ILarkLynxFragmentHolder
    public final Fragment getFragment(boolean r4) {
        if (r4 == false) goto L5;
        this.d = true;
    L5:
        LarkLynxFragment r5 = this.h;
        if (r5 == null) goto L9;
        return r5;
    L9:
        if ((!isDestroyed()) == false) goto L13;
        ConcurrentHashMap<String, d> r6 = f.a;
        String r7 = f.b(this.a, this.b, false, this);
        this.g = r7;
        int r0 = LarkLynxFragment.j;
        Intrinsics.checkNotNullParameter(r7, "hostId");
        LarkLynxFragment r1 = new LarkLynxFragment();
        Bundle r2 = new Bundle();
        r2.putString("extra_lynx_host_id", r7);
        r1.setArguments(r2);
        this.h = r1;
        return r1;
    L13:
        throw new IllegalStateException("LynxFragmentHolder is destroyed".toString());
    }

    public b(LarkLynxHostParams r2, LarkLynxHostOptions r3) {
        Intrinsics.checkNotNullParameter(r2, "params");
        Intrinsics.checkNotNullParameter(r3, "options");
        super(r2, r3);
    }
}
