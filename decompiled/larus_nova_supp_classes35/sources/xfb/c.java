package xfb;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class c implements wfb.c {
    public c() {
    }

    @Override // wfb.c
    public final int a(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        int r1 = d.a;
        Intrinsics.checkNotNullParameter(r3, "context");
        return d.a(r3) - e.a(r3);
    }
}
