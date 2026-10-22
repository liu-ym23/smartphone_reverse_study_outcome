package i8;

import com.bytedance.ies.web.jsbridge2.u;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class c implements k9.e {

    public static final class a implements k9.d {
        public a() {
        }

        @Override // k9.d
        public final void b(String r10, int r11) {
            Intrinsics.checkNotNullParameter(r10, "monitorId");
            Intrinsics.checkNotNullParameter("scene", "field");
            sz2.e r12 = g.a;
            Intrinsics.checkNotNullParameter(r10, "monitorId");
            Intrinsics.checkNotNullParameter("scene", "field");
            g.a.getClass();
            sz2.e.d(r10, "scene", r11);
        }

        @Override // k9.d
        public final void a(String r10, String r11, int r12) {
            Intrinsics.checkNotNullParameter(r10, "monitorId");
            Intrinsics.checkNotNullParameter(r11, "key");
            g.a(r10, r11, r12);
        }

        @Override // k9.d
        public final void c(String r10, String r11, long r12) {
            Intrinsics.checkNotNullParameter(r10, "monitorId");
            Intrinsics.checkNotNullParameter(r11, "field");
            g.c(r10, r11, r12);
        }

        @Override // k9.d
        public final void d(String r10, String r11, String r12) {
            Intrinsics.checkNotNullParameter(r10, "monitorId");
            Intrinsics.checkNotNullParameter(r11, "key");
            Intrinsics.checkNotNullParameter(r12, com.bytedance.android.ec.core.event.a.KEY_LUBAN_VALUE);
            g.b(r10, r11, r12);
        }
    }

    public c() {
    }

    @Override // k9.e
    public final List<b7.a> T() {
        List<b7.a> r0 = CollectionsKt.mutableListOf(new b7.a[]{new b(), new l8.c(), new com.bytedance.android.annie.monitor.common.performance.f(), new k8.a()});
        j8.b r1 = f.a;
        if (r1 == null) goto L5;
        r0.add(new j8.a(r1));
    L5:
        CopyOnWriteArrayList<i> r10 = f.b;
        ArrayList r11 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r10, 10));
        Iterator<i> r12 = r10.iterator();
    L7:
        if (r12.hasNext() == false) goto L9;
        r11.add(r12.next().provide());
        goto L7
    L9:
        r0.addAll(r11);
        return r0;
    }

    @Override // k9.e
    public final k9.d V0() {
        return new a();
    }

    @Override // k9.e
    public final List<u> Z0() {
        return CollectionsKt.emptyList();
    }

    @Override // k9.e
    public final j9.b H0() {
        return i8.a.a;
    }
}
