package io1;

import com.bytedance.android.live.core.tetris.componentx.component.ComponentCenter;
import com.bytedance.android.live.core.tetris.layer.core.descriptor.LayerDescriptorList;
import com.bytedance.android.live.core.tetris.layer.core.element.Element;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.live.core.framework.InteractionMonitorConfig;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.live.core.framework.LiveInteractionFrameworkOptHelper;
import j70.f;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class b {
    public final C0393b a;
    public final a b;

    public static final class a implements com.bytedance.android.live.core.tetris.componentx.component.c {
        public final Map<String, Long> a;
        public final Map<String, Long> b;
        public final InteractionMonitorConfig c;

        public final void a(Element r2) {
            Intrinsics.checkNotNullParameter(r2, "element");
        }

        public final void b(Element r2) {
            Intrinsics.checkNotNullParameter(r2, "element");
        }

        public final void c(f r2) {
            Intrinsics.checkNotNullParameter(r2, "elementType");
        }

        public final void d(Element r2, d70.a r3) {
            Intrinsics.checkNotNullParameter(r2, "element");
            Intrinsics.checkNotNullParameter(r3, "component");
        }

        public final void f(LayerDescriptorList r2) {
            Intrinsics.checkNotNullParameter(r2, "descriptors");
        }

        public final void h(Element r2, d70.a r3) {
            Intrinsics.checkNotNullParameter(r2, "element");
            Intrinsics.checkNotNullParameter(r3, "component");
        }

        public final void i(d70.a<h70.b> r2) {
            Intrinsics.checkNotNullParameter(r2, "component");
        }

        public final void j(ComponentCenter r2) {
            Intrinsics.checkNotNullParameter(r2, "componentCenter");
        }

        public final void k(d70.a<h70.b> r2) {
            Intrinsics.checkNotNullParameter(r2, "component");
        }

        public final void onDestroy() {
        }

        public a(InteractionMonitorConfig r2) {
            Intrinsics.checkNotNullParameter(r2, "config");
            this.c = r2;
            this.a = new LinkedHashMap();
            this.b = new LinkedHashMap();
        }

        public final void e(d70.a<h70.b> r5) {
            Intrinsics.checkNotNullParameter(r5, "component");
            f r6 = r5.getElementType();
            if (r6 != null) goto L5;
            return;
        L5:
            List r0 = this.c.getReportElementTypeList();
            if (r0 != null) goto L8;
            return;
        L8:
            if (r0.contains(r6.b) != true) goto L17;
            Map<String, Long> r1 = this.a;
            LinkedHashMap r2 = (LinkedHashMap) r1;
            Long r3 = (Long) r2.get(r6.b);
            if (r3 == null) goto L13;
            long r4 = r3.longValue();
            long r7 = System.currentTimeMillis() - r4;
        L14:
            this.b.put(r6.b, Long.valueOf(r7));
            return;
        L13:
            r7 = -1;
            goto L14
        }

        public final void g(d70.a<h70.b> r4) {
            Intrinsics.checkNotNullParameter(r4, "component");
            f r5 = r4.getElementType();
            if (r5 != null) goto L5;
            return;
        L5:
            List r0 = this.c.getReportElementTypeList();
            if (r0 != null) goto L8;
            return;
        L8:
            if (r0.contains(r5.b) != true) goto L13;
            this.a.put(r5.b, Long.valueOf(System.currentTimeMillis()));
            return;
        }
    }

    /* JADX INFO: renamed from: io1.b$b, reason: collision with other inner class name */
    public static final class C0393b {
        public long a;
        public long b;
        public final Map<String, Long> c;
        public final Map<String, Long> d;

        /* JADX INFO: renamed from: io1.b$b$a */
        public static final class a {
        }

        static {
        }

        public C0393b() {
            this.c = new LinkedHashMap();
            this.d = new LinkedHashMap();
        }

        public final void a(String r6) {
            Intrinsics.checkNotNullParameter(r6, "process");
            Map<String, Long> r0 = this.d;
            Long r1 = (Long) ((LinkedHashMap) this.c).get(r6);
            if (r1 == null) goto L5;
            long r2 = r1.longValue();
            long r3 = System.currentTimeMillis() - r2;
        L6:
            r0.put(r6, Long.valueOf(r3));
            return;
        L5:
            r3 = -1;
            goto L6
        }
    }

    public b() {
        InteractionMonitorConfig r0 = LiveInteractionFrameworkOptHelper.INSTANCE.monitorConfig();
        a r2 = null;
        if (r0.getEnableReportProcessCost() == false) goto L5;
        C0393b r1 = new C0393b();
    L6:
        this.a = r1;
        if (r0.getEnableReportWidgetCost() == false) goto L9;
        r2 = new a(r0);
    L9:
        this.b = r2;
        return;
    L5:
        r1 = null;
        goto L6
    }
}
