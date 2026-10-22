package v4;

import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.bytedance.ai.debug.IAISDKDebugService$Gravity;
import com.bytedance.ai.debugscene.tag.DebugTagStyle;
import com.bytedance.ai.lynx.g;
import com.bytedance.ai.widget.view.WidgetBoxView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class c {
    public static volatile Function1<? super String, v4.a> a;
    public static final Handler b = null;
    public static final Object c = null;
    public static final WeakHashMap<View, a> d = null;
    public static final WeakHashMap<View, b> e = null;

    public static final class a {
        public final String a;
        public final IAISDKDebugService$Gravity b;
        public final String c;
        public final Function1<Boolean, Unit> d;

        public final boolean equals(Object r10) {
            if (this != r10) goto L6;
            return true;
        L6:
            if ((r10 instanceof a) == true) goto L8;
            return false;
        L8:
            a r11 = (a) r10;
            if (Intrinsics.areEqual(this.a, r11.a) == true) goto L12;
            return false;
        L12:
            if (this.b == r11.b) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r11.c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.d, r11.d) == true) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            int r0 = ((this.a.hashCode() * 31) + this.b.hashCode()) * 31;
            String r1 = this.c;
            int r10 = 0;
            if (r1 != null) goto L5;
            int r11 = 0;
        L6:
            int r12 = (r0 + r11) * 31;
            Function1<Boolean, Unit> r13 = this.d;
            if (r13 == null) goto L11;
            r10 = r13.hashCode();
        L11:
            return r12 + r10;
        L5:
            r11 = r1.hashCode();
            goto L6
        }

        public final String toString() {
            return "Binding(packageName=" + this.a + ", gravity=" + this.b + ", extraText=" + this.c + ", onVisibilityChanged=" + this.d + ')';
        }

        /* JADX WARN: Multi-variable type inference failed */
        public a(String r10, IAISDKDebugService$Gravity r11, String r12, Function1<? super Boolean, Unit> r13) {
            Intrinsics.checkNotNullParameter(r10, "packageName");
            Intrinsics.checkNotNullParameter(r11, "gravity");
            this.a = r10;
            this.b = r11;
            this.c = r12;
            this.d = r13;
        }
    }

    public static final class b {
        public final float a;
        public final float b;

        public final boolean equals(Object r10) {
            if (this != r10) goto L6;
            return true;
        L6:
            if ((r10 instanceof b) == true) goto L8;
            return false;
        L8:
            b r11 = (b) r10;
            if (Float.compare(this.a, r11.a) == 0) goto L12;
            return false;
        L12:
            if (Float.compare(this.b, r11.b) == 0) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (Float.floatToIntBits(this.a) * 31) + Float.floatToIntBits(this.b);
        }

        public final String toString() {
            return "DragPosition(left=" + this.a + ", top=" + this.b + ')';
        }

        public b(float r1, float r10) {
            this.a = r1;
            this.b = r10;
        }
    }

    static {
        b = new Handler(Looper.getMainLooper());
        c = new Object();
        d = new WeakHashMap();
        e = new WeakHashMap();
    }

    public static void c() {
        final Function1<? super String, v4.a> r0 = a;
        if (r0 != null) goto L5;
        return;
    L5:
        Object r1 = c;
        monitor-enter(r1);
        Set<Map.Entry<View, a>> r10 = d.entrySet();     // Catch: Throwable -> L21
        ArrayList r11 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r10, 10));     // Catch: Throwable -> L21
        Iterator<T> r12 = r10.iterator();     // Catch: Throwable -> L21
    L9:
        if (r12.hasNext() == false) goto L12;
        Map.Entry r13 = (Map.Entry) r12.next();     // Catch: Throwable -> L21
        Intrinsics.checkNotNull(r13);     // Catch: Throwable -> L21
        r11.add(new Pair(r13.getKey(), r13.getValue()));     // Catch: Throwable -> L21
        goto L9
    L12:
        monitor-exit(r1);
        Iterator r14 = r11.iterator();
    L15:
        if (r14.hasNext() == false) goto L20;
        Pair r15 = (Pair) r14.next();
        final View r16 = (View) r15.component1();
        final a r17 = (a) r15.component2();
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == true) goto L18;
        b.post(new v4.b(r16, r17, r0));
        goto L15
    L18:
        Intrinsics.checkNotNull(r16);
        Intrinsics.checkNotNull(r17);
        a(r16, r17, r0);
        goto L15
    L20:
        return;
    L21:
        th = move-exception;
        throw th;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void b(View r10) {
        if (r10.getWidth() <= 0) goto L32;
        if (r10.getHeight() <= 0) goto L32;
        if ((r10 instanceof WidgetBoxView) == false) goto L11;
        Object r0 = ((WidgetBoxView) r10).getDebugOverlay();
    L15:
        if ((r0 instanceof com.bytedance.ai.debug.e) == false) goto L17;
        com.bytedance.ai.debug.e r1 = (com.bytedance.ai.debug.e) r0;
    L18:
        if (r1 == null) goto L32;
        RectF r11 = r1.a(r10.getWidth(), r10.getHeight());
        if (r11.isEmpty() == true) goto L32;
        Object r12 = c;
        monitor-enter(r12);
        e.put(r10, new b(r11.left, r11.top));     // Catch: Throwable -> L28
        Unit r13 = Unit.INSTANCE;     // Catch: Throwable -> L28
        monitor-exit(r12);
    L28:
        th = move-exception;
        throw th;
    L17:
        r1 = null;
        goto L18
    L11:
        if ((r10 instanceof g) == false) goto L13;
        r0 = ((g) r10).getDebugOverlay();
        goto L15
    L13:
        r0 = r10.getForeground();
    L32:
        if ((r10 instanceof WidgetBoxView) == false) goto L36;
        ((WidgetBoxView) r10).setDebugOverlay(null);
        return;
    L36:
        if ((r10 instanceof g) == false) goto L39;
        ((g) r10).setDebugOverlay(null);
        return;
    L39:
        r10.setForeground(null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void d(View r10, Drawable r11) {
        if (r10.getWidth() <= 0) goto L50;
        if (r10.getHeight() <= 0) goto L50;
        RectF r1 = null;
        if ((r11 instanceof com.bytedance.ai.debug.e) == false) goto L10;
        com.bytedance.ai.debug.e r0 = (com.bytedance.ai.debug.e) r11;
    L11:
        if (r0 == null) goto L50;
        if ((r10 instanceof WidgetBoxView) == false) goto L17;
        Object r12 = ((WidgetBoxView) r10).getDebugOverlay();
    L21:
        if ((r12 instanceof com.bytedance.ai.debug.e) == false) goto L23;
        com.bytedance.ai.debug.e r13 = (com.bytedance.ai.debug.e) r12;
    L24:
        if (r13 == null) goto L32;
        RectF r14 = r13.a(r10.getWidth(), r10.getHeight());
        if (r14 == null) goto L32;
        if (r14.isEmpty() == true) goto L30;
        r1 = r14;
    L30:
        if (r1 == null) goto L32;
        b r15 = new b(r1.left, r1.top);
    L38:
        r0.b(r10.getWidth(), r10.getHeight(), r15.a, r15.b);
        Object r16 = c;
        monitor-enter(r16);
        e.put(r10, r15);     // Catch: Throwable -> L43
        Unit r17 = Unit.INSTANCE;     // Catch: Throwable -> L43
        monitor-exit(r16);
    L43:
        th = move-exception;
        throw th;
    L32:
        Object r18 = c;
        monitor-enter(r18);
        r15 = e.get(r10);     // Catch: Throwable -> L46
        monitor-exit(r18);
        if (r15 != null) goto L38;
    L46:
        th = move-exception;
        throw th;
    L23:
        r13 = null;
        goto L24
    L17:
        if ((r10 instanceof g) == false) goto L19;
        r12 = ((g) r10).getDebugOverlay();
        goto L21
    L19:
        r12 = r10.getForeground();
        goto L21
    L10:
        r0 = null;
    L50:
        if ((r10 instanceof WidgetBoxView) == false) goto L54;
        ((WidgetBoxView) r10).setDebugOverlay(r11);
        return;
    L54:
        if ((r10 instanceof g) == false) goto L57;
        ((g) r10).setDebugOverlay(r11);
        return;
    L57:
        r10.setForeground(r11);
    }

    public static void a(View r13, a r14, Function1 r15) {
        if (Build.VERSION.SDK_INT >= 23) goto L5;
        return;
    L5:
        v4.a r16 = (v4.a) r15.invoke(r14.a);
        if (r16.a == true) goto L11;
        b(r13);
        Function1<Boolean, Unit> r17 = r14.d;
        if (r17 == null) goto L52;
        r17.invoke(Boolean.FALSE);
        return;
    L52:
        return;
    L11:
        List r0 = CollectionsKt.listOf(new String[]{r16.b, r14.c});
        ArrayList r10 = new ArrayList();
        Iterator r1 = r0.iterator();
    L13:
        if (r1.hasNext() == false) goto L23;
        Object r11 = r1.next();
        String r12 = (String) r11;
        if (r12 != null) goto L17;
    L20:
        boolean r18 = true;
    L21:
        if (r18 == true) goto L13;
        r10.add(r11);
        goto L13
    L17:
        if (StringsKt.isBlank(r12) == true) goto L20;
        r18 = false;
        goto L21
    L23:
        String r19 = CollectionsKt.joinToString$default(r10, " ", null, null, 0, null, null, 62, null);
        if (StringsKt.isBlank(r19) == false) goto L29;
        b(r13);
        Function1<Boolean, Unit> r110 = r14.d;
        if (r110 == null) goto L53;
        r110.invoke(Boolean.FALSE);
        return;
    L53:
        return;
    L29:
        DebugTagStyle r111 = r16.c;
        DebugTagStyle r20 = DebugTagStyle.MODERN_DEBUG;
        if (r111 == r20) goto L32;
    L34:
        if (r111 != r20) goto L36;
        IAISDKDebugService$Gravity r21 = IAISDKDebugService$Gravity.BOTTOM_RIGHT;
    L38:
        if (r111 != r20) goto L43;
        f r112 = new f(r21);
        Intrinsics.checkNotNullParameter(r19, "text");
        r112.e = r19;
        r112.invalidateSelf();
        Unit r22 = Unit.INSTANCE;
        d(r13, r112);
        Function1<Boolean, Unit> r113 = r14.d;
        if (r113 == null) goto L54;
        r113.invoke(Boolean.TRUE);
        return;
    L54:
        return;
    L43:
        e r114 = new e(null, r21);
        Intrinsics.checkNotNullParameter(r19, "text");
        r114.f = r19;
        r114.invalidateSelf();
        Unit r23 = Unit.INSTANCE;
        d(r13, r114);
        Function1<Boolean, Unit> r115 = r14.d;
        if (r115 == null) goto L55;
        r115.invoke(Boolean.TRUE);
        return;
    L55:
        return;
    L36:
        r21 = IAISDKDebugService$Gravity.BOTTOM_LEFT;
        goto L38
    L32:
        if ((r13 instanceof WidgetBoxView) == false) goto L34;
        r21 = IAISDKDebugService$Gravity.TOP_RIGHT;
        goto L38
    }
}
