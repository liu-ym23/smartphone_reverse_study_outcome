package r4;

import android.content.Context;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public interface j {

    public static final class a {
        public static /* synthetic */ void a(j r10, e3.d r11) {
            r10.closeView(r11, null, false);
        }

        public static boolean b(j r10, e3.d r11, String r12, Map<String, ? extends Object> r13, Context r14) {
            Intrinsics.checkNotNullParameter(r12, com.bytedance.android.ec.core.event.a.KEY_SCHEMA);
            Intrinsics.checkNotNullParameter(r13, "extraParams");
            List<b> r0 = r10.provideRouteOpenHandlerList(r11);
            b r15 = r10.provideRouteOpenExceptionHandler(r11);
            Iterator<T> r16 = r0.iterator();
            b r1 = null;
            b r17 = null;
        L4:
            if (r16.hasNext() == false) goto L11;
            b r18 = (b) r16.next();
            if (r17 != null) goto L8;
            r1 = r18;
        L8:
            if (r17 == null) goto L10;
            r17.a = r18;
        L10:
            r18.b = r15;
            r17 = r18;
            goto L4
        L11:
            boolean r19 = false;
            if (r1 != null) goto L14;
            return false;
        L14:
            if (r19 == true) goto L22;
            if (r1 == null) goto L22;
            r19 = r1.a(r12, r13, r14);     // Catch: Throwable -> L21
            if (r19 == true) goto L22;
            r1 = r1.a;     // Catch: Throwable -> L21
        L21:
            r1 = r1.b;
        L22:
            return r19;
        }
    }

    boolean closeView(e3.d r1, String r10, boolean r11);

    boolean openSchema(e3.d r1, String r10, Map<String, ? extends Object> r11, Context r12);

    b provideRouteOpenExceptionHandler(e3.d r1);

    List<b> provideRouteOpenHandlerList(e3.d r1);
}
