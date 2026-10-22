package com.larus.bmhome.chat.layout.widget;

import com.larus.common.apphost.AppHost;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class s0 {
    public static final CopyOnWriteArrayList<WeakReference<q0>> a = null;

    public static final class a implements f09.a.b {
        public a() {
        }

        public final void onAllActivityDestroyed() {
        }

        public final void onAppBackground() {
            CopyOnWriteArrayList<WeakReference<q0>> r0 = s0.a;
            CollectionsKt.removeAll(r0, new r0(null));
            Iterator<WeakReference<q0>> r1 = r0.iterator();
        L4:
            if (r1.hasNext() == false) goto L8;
            q0 r2 = r1.next().get();
            if (r2 == null) goto L4;
            Intrinsics.checkNotNullParameter(r2, "it");
            r2.onAppBackground();
            Unit r3 = Unit.INSTANCE;
            goto L4
        }

        public final void onAppForeground() {
            CopyOnWriteArrayList<WeakReference<q0>> r0 = s0.a;
            CollectionsKt.removeAll(r0, new r0(null));
            Iterator<WeakReference<q0>> r1 = r0.iterator();
        L4:
            if (r1.hasNext() == false) goto L8;
            q0 r2 = r1.next().get();
            if (r2 == null) goto L4;
            Intrinsics.checkNotNullParameter(r2, "it");
            r2.onAppForeground();
            Unit r3 = Unit.INSTANCE;
            goto L4
        }
    }

    public s0() {
    }

    static {
        a = new CopyOnWriteArrayList();
        a r0 = new a();
        AppHost.a.a().j(r0);
    }

    public static void a(q0 r2) {
        Intrinsics.checkNotNullParameter(r2, "observer");
        CopyOnWriteArrayList<WeakReference<q0>> r0 = a;
        CollectionsKt.removeAll(r0, new r0(r2));
        r0.add(new WeakReference(r2));
    }
}
