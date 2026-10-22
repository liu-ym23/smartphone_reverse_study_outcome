package com.bytedance.android.live.network.impl.interceptor.business;

import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a implements b {
    public final CopyOnWriteArrayList<b> a;

    /* JADX INFO: renamed from: com.bytedance.android.live.network.impl.interceptor.business.a$a, reason: collision with other inner class name */
    public static final class C0135a {
    }

    static {
    }

    public a() {
        this.a = new CopyOnWriteArrayList();
    }

    @Override // com.bytedance.android.live.network.impl.interceptor.business.b
    public final void a(String r3, Map<String, String> r4) {
        Intrinsics.checkNotNullParameter(r3, "url");
        Intrinsics.checkNotNullParameter(r4, "paramMapInOut");
        Iterator<b> r0 = this.a.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.next().a(r3, r4);
        goto L4
    }
}
