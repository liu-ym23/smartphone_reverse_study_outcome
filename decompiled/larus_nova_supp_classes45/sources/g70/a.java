package g70;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.tetris.ComponentManagerFactory$config$1;
import com.bytedance.android.live.core.tetris.layer.core.descriptor.LayerDescriptorList;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class a {
    public final e a;
    public final d b;
    public final C0233a c;
    public final c d;
    public final Map<Class<s70.b<h70.b>>, s70.a<s70.b<h70.b>, h70.b>> e;
    public final b f;
    public final h70.b g;
    public final f h;

    /* JADX INFO: renamed from: g70.a$a, reason: collision with other inner class name */
    public static final class C0233a {
        public final h70.b a;
        public final String b;

        public C0233a(ComponentManagerFactory$config$1 r2) {
            Intrinsics.checkNotNullParameter(r2, "config");
            this.a = r2.b;
            this.b = "CanLoadFilter";
        }
    }

    public static final class b {
        public final String a;
        public final h70.b b;
        public final com.bytedance.android.live.core.tetris.componentx.a c;
        public final Map<Class<s70.b<h70.b>>, s70.a<s70.b<h70.b>, h70.b>> d;

        /* JADX WARN: Multi-variable type inference failed */
        public final Pair<s70.b<h70.b>, s70.a<s70.b<h70.b>, h70.b>> a(j70.h<h70.b> r7) {
            Intrinsics.checkNotNullParameter(r7, "descriptor");
            if (this.d.isEmpty() == false) goto L6;
            return null;
        L6:
            if ((r7 instanceof s70.b) == true) goto L8;
            return null;
        L8:
            s70.b r0 = (s70.b) r7;
            if (r0.A(this.b) == true) goto L11;
            return null;
        L11:
            Iterator<Map.Entry<Class<s70.b<h70.b>>, s70.a<s70.b<h70.b>, h70.b>>> r2 = this.d.entrySet().iterator();
        L13:
            if (r2.hasNext() == false) goto L18;
            Map.Entry<Class<s70.b<h70.b>>, s70.a<s70.b<h70.b>, h70.b>> r3 = r2.next();
            if (r3.getKey().isAssignableFrom(r0.getClass()) == false) goto L13;
            int r1 = h70.a.a;
            StringBuilder r4 = new StringBuilder();
            Intrinsics.checkNotNullParameter(r7, "$this$toLayerDescriptor");
            r4.append(r7.C(this.b));
            r4.append(" should be pending.");
            ALogger.i("Layer", r4.toString());
            return new Pair(r0, r3.getValue());
        L18:
            return null;
        }

        public b(ComponentManagerFactory$config$1 r2, Map r3) {
            Intrinsics.checkNotNullParameter(r2, "config");
            Intrinsics.checkNotNullParameter(r3, "handlerMap");
            this.c = r2;
            this.d = r3;
            this.a = "PendingFlagFilter";
            this.b = r2.b;
        }
    }

    public static final class c {
        public final h70.b a;
        public final r70.a<h70.b> b;
        public final String c;

        public c(ComponentManagerFactory$config$1 r2) {
            Intrinsics.checkNotNullParameter(r2, "config");
            this.a = r2.b;
            this.b = r2.g.g();
            this.c = "RoomModeCanLoadFilter";
        }
    }

    public static final class d {
        public final h70.b a;
        public final List<j70.f> b;
        public final r70.a<h70.b> c;
        public final String d;

        public d(ComponentManagerFactory$config$1 r3) {
            Intrinsics.checkNotNullParameter(r3, "config");
            h70.b r0 = r3.b;
            this.a = r0;
            r70.b<h70.b> r1 = r3.g.c();
            if (r1 == null) goto L6;
            List<j70.f> r2 = r1.a(r0);
            if (r2 == null) goto L6;
        L7:
            this.b = r2;
            this.c = r3.g.a();
            this.d = "WhiteAndBlackListFilter";
            return;
        L6:
            r2 = CollectionsKt.emptyList();
            goto L7
        }

        public final boolean a(j70.h<h70.b> r4) {
            Intrinsics.checkNotNullParameter(r4, "descriptor");
            j70.f r5 = r4.C(this.a);
            if ((!this.b.isEmpty()) == true) goto L5;
        L7:
            r70.a<h70.b> r0 = this.c;
            if (r0 != null) goto L10;
            return false;
        L10:
            if (r0.a(r5, this.a) == false) goto L14;
            return true;
        L14:
            return false;
        L5:
            if (this.b.contains(r5) == true) goto L7;
            return true;
        }
    }

    public static final class e {
        public final String a;

        public e(ComponentManagerFactory$config$1 r2) {
            Intrinsics.checkNotNullParameter(r2, "config");
            this.a = "WidgetAlreadyLoadedFilter";
        }
    }

    /* JADX WARN: Type inference failed for: r4v0, types: [T extends h70.b, h70.b, java.lang.Object] */
    public a(ComponentManagerFactory$config$1 r7) {
        Intrinsics.checkNotNullParameter(r7, "config");
        this.a = new e(r7);
        this.b = new d(r7);
        this.c = new C0233a(r7);
        this.d = new c(r7);
        this.g = r7.b;
        this.h = r7.i;
        Map<Class<s70.b<h70.b>>, s70.a<s70.b<h70.b>, h70.b>> r0 = r7.g.e();
        b r1 = null;
        if (r0 != null) goto L5;
    L13:
        r0 = MapsKt.emptyMap();
    L14:
        this.e = r0;
        if ((!r0.isEmpty()) == false) goto L17;
        r1 = new b(r7, r0);
    L17:
        this.f = r1;
        return;
    L5:
        if ((!r0.isEmpty()) == true) goto L8;
        r0 = null;
    L8:
        if (r0 == null) goto L13;
        Iterator<Map.Entry<Class<s70.b<h70.b>>, s70.a<s70.b<h70.b>, h70.b>>> r2 = r0.entrySet().iterator();
    L11:
        if (r2.hasNext() == false) goto L14;
        s70.a<s70.b<h70.b>, h70.b> r3 = r2.next().getValue();
        ?? r4 = r7.b;
        r3.getClass();
        Intrinsics.checkNotNullParameter(r4, "<set-?>");
        r3.a = r4;
        goto L11
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final LayerDescriptorList a(LayerDescriptorList r13) {
        Intrinsics.checkNotNullParameter(r13, "descriptorList");
        LayerDescriptorList r0 = new LayerDescriptorList();
        LinkedHashMap r1 = new LinkedHashMap();
        LinkedHashMap r2 = new LinkedHashMap();
        Iterator<j70.h<? extends h70.b>> r14 = r13.iterator();
    L4:
        if (r14.hasNext() == false) goto L31;
        j70.h<? extends h70.b> r3 = r14.next();
        Intrinsics.checkNotNullParameter(r3, "$this$toLayerDescriptor");
        j70.f r4 = r3.C(this.g);
        this.a.getClass();
        Intrinsics.checkNotNullParameter(r3, "descriptor");
        if (WidgetService.getInstance().isLayerLoaded(r3.getClass().getCanonicalName()) == true) goto L7;
        if (this.b.a(r3) == true) goto L10;
        c r6 = this.d;
        r6.getClass();
        Intrinsics.checkNotNullParameter(r3, "descriptor");
        j70.f r7 = r3.C(r6.a);
        r70.a<h70.b> r8 = r6.b;
        if (r8 != null) goto L14;
    L16:
        boolean r9 = false;
    L17:
        if (r9 == true) goto L18;
        C0233a r11 = this.c;
        r11.getClass();
        Intrinsics.checkNotNullParameter(r3, "descriptor");
        if ((!r3.D(r11.a)) == true) goto L21;
        b r5 = this.f;
        if (r5 == 0) goto L30;
        Pair<s70.b<h70.b>, s70.a<s70.b<h70.b>, h70.b>> r12 = r5.a(r3);
        if (r12 == null) goto L30;
        r1.put(r4, this.f.a);
        Object r15 = r12.getSecond();
        Object r16 = r2.get(r15);
        if (r16 != null) goto L29;
        r16 = new ArrayList();
        r2.put(r15, r16);
    L29:
        ((ArrayList) r16).add(r12.getFirst());
    L30:
        r0.add(r3);
        goto L4
    L21:
        r1.put(r4, this.c.b);
        goto L4
    L18:
        r1.put(r4, this.d.c);
        goto L4
    L14:
        if (r8.a(r7, r6.a) == false) goto L16;
        r9 = true;
        goto L17
    L10:
        r1.put(r4, this.b.d);
        goto L4
    L7:
        r1.put(r4, this.a.a);
        goto L4
    L31:
        Iterator r17 = r2.entrySet().iterator();
    L33:
        if (r17.hasNext() == false) goto L35;
        Map.Entry r18 = (Map.Entry) r17.next();
        ((s70.a) r18.getKey()).a((List) r18.getValue());
        goto L33
    L35:
        f r19 = this.h;
        Intrinsics.checkNotNullParameter(r19, "$this$traceFilterDescriptors");
        Intrinsics.checkNotNullParameter(r1, "filterMap");
        if (r19.a() == false) goto L42;
        ArrayList r21 = new ArrayList(r1.size());
        Iterator r22 = r1.entrySet().iterator();
    L39:
        if (r22.hasNext() == false) goto L41;
        Map.Entry r23 = (Map.Entry) r22.next();
        r21.add(((j70.f) r23.getKey()).a + "-" + ((String) r23.getValue()));
        goto L39
    L41:
        r19.log("[" + r19.hashCode() + "]filter descriptors, size is " + r1.size() + ", element is [" + CollectionsKt.joinToString$default(CollectionsKt.toList(r21), ", ", null, null, 0, null, null, 62, null) + ']');
    L42:
        return r0;
    }
}
