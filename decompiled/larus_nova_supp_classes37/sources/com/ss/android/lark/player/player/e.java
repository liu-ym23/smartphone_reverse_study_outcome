package com.ss.android.lark.player.player;

import com.ss.ttvideoengine.TTVideoEngine;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class e implements q {
    public final /* synthetic */ WeakReference<TTVideoEngine> a;

    public e(WeakReference<TTVideoEngine> r1) {
        this.a = r1;
    }

    @Override // com.ss.android.lark.player.player.q
    public final void a(Map<String, String> r4) {
        Intrinsics.checkNotNullParameter(r4, "headers");
        TTVideoEngine r0 = this.a.get();
        if (r0 == null) goto L8;
        Iterator<Map.Entry<String, String>> r5 = r4.entrySet().iterator();
    L6:
        if (r5.hasNext() == false) goto L10;
        Map.Entry<String, String> r1 = r5.next();
        r0.setCustomHeader(r1.getKey(), r1.getValue());
        goto L6
    L10:
        return;
    }
}
