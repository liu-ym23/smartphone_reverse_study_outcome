package com.bytedance.android.live.broadcastgame.openplatform.miniapp;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class a {
    public final List<b> a;
    public int b;

    /* JADX INFO: renamed from: com.bytedance.android.live.broadcastgame.openplatform.miniapp.a$a, reason: collision with other inner class name */
    public static final class C0095a {
        public final List<b> a;

        public final a b() {
            a r0 = new a();
            Iterator<T> r1 = this.a.iterator();
        L4:
            if (r1.hasNext() == false) goto L6;
            b r2 = (b) r1.next();
            ((ArrayList) r0.a).add(r2);
            goto L4
        L6:
            return r0;
        }

        public C0095a() {
            this.a = new ArrayList();
        }

        public final void a(b r2) {
            Intrinsics.checkNotNullParameter(r2, "node");
            ((ArrayList) this.a).add(r2);
        }
    }

    public static abstract class b {
        public b() {
        }

        public abstract void a(a r1);
    }

    public final void a() {
        List<b> r0 = this.a;
        int r1 = this.b;
        this.b = r1 + 1;
        b r2 = (b) CollectionsKt.getOrNull(r0, r1);
        if (r2 == null) goto L6;
        r2.a(this);
        return;
    }

    public a() {
        this.a = new ArrayList();
    }
}
