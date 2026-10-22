package knc;

import com.suite.component.logger.api.f;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class b implements f {
    public static final /* synthetic */ int a = 0;

    public static final class a {
        @JvmStatic
        public static void a(com.suite.component.logger.c r5) {
            Intrinsics.checkNotNullParameter(r5, "logEntity");
            if (r5.g == null) goto L5;
            return;
        L5:
            if (r5.h != null) goto L34;
            ThreadLocal<c.a> r0 = c.a;
            c.a r1 = r0.get();
            if (r1 == null) goto L33;
            r5.g = r1.a;
            String r2 = r1.b;
            boolean r3 = true;
            if (r2 != null) goto L12;
        L15:
            boolean r4 = true;
        L16:
            if (r4 == true) goto L26;
            String r6 = r5.b;
            if (r6 != null) goto L20;
        L23:
            if (r3 == true) goto L26;
            String r7 = r1.b + '#' + r5.b;
        L27:
            r5.h = r7;
            r5.i = r1.c;
            c.a r8 = r0.get();
            if (r8 != null) goto L30;
            r8 = new c.a();
        L30:
            r8.a = null;
            r8.b = null;
            r8.c = -1;
            r0.set(r8);
            return;
        L20:
            if (r6.length() == 0) goto L23;
            r3 = false;
        L26:
            r7 = r1.b;
            goto L27
        L12:
            if (r2.length() == 0) goto L15;
            r4 = false;
            goto L16
        L33:
            return;
        }
    }

    static {
    }

    public b() {
    }

    @Override // com.suite.component.logger.api.f
    public final boolean a(com.suite.component.logger.b r2, com.suite.component.logger.c r3) {
        Intrinsics.checkNotNullParameter(r2, "logContext");
        Intrinsics.checkNotNullParameter(r3, "logEntity");
        a.a(r3);
        return true;
    }
}
