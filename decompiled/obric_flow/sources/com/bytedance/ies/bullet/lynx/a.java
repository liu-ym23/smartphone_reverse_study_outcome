package com.bytedance.ies.bullet.lynx;

import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final h f5596a;

    public a(h r5, ArrayList r10) {
        Intrinsics.checkNotNullParameter(r10, "delegates");
        this.f5596a = r5;
    }

    public final void a(final Iterator r18, final b r19, final Function1 r20, final Function1 r21) {
        vc.c r10 = (vc.c) r18.next();
        r10.p(this.f5596a, r19.f5597a, r19.f5598b, r19.f5599c, r19.d, r19.e, r19.f, new LynxClientDelegateChain$doLoadImage$1(this, r18, r19, r20, r21));     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        if (r18.hasNext() == false) goto L9;
        a(r18, r19, r20, r21);
        return;
    L9:
        r21.invoke(e);
    }
}
