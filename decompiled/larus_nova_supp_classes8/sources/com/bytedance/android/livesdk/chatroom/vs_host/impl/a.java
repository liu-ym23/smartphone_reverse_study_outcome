package com.bytedance.android.livesdk.chatroom.vs_host.impl;

import android.content.Context;
import com.bytedance.android.live.pushstream.IPushStreamService;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class a implements vr1.h, com.bytedance.android.scope.o {
    public a() {
    }

    public final void onStart() {
    }

    public final void onStop() {
    }

    @Override // vr1.h
    public final r a(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        return new r(new WeakReference(jc1.k.n(IPushStreamService.class).getRecordLiveStream(r3)));
    }

    @Override // vr1.h
    public final tp2.a c(Context r2, vr1.z r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "vsLiveStream");
        if ((r3 instanceof r) == true) goto L5;
        r3 = null;
    L5:
        r r4 = (r) r3;
        if (r4 == null) goto L10;
        WeakReference<com.bytedance.android.live.pushstream.d> r5 = r4.a;
        if (r5 == null) goto L10;
        com.bytedance.android.live.pushstream.d r6 = r5.get();
    L11:
        r6.J();
        throw null;
    L10:
        r6 = null;
        goto L11
    }
}
