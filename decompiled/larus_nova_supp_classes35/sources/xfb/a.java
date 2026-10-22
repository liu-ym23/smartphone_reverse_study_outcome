package xfb;

import com.ss.android.lark.appcontext.applifecycle.AppLifecycle;
import com.ss.android.lark.floating.enums.ShowPattern;
import com.ss.android.lark.floating.widget.appfloat.AppFloatManager;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Unit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a {
    public static final tfb.a.c a = null;
    public static boolean b;
    public static final b c = null;

    /* JADX INFO: renamed from: xfb.a$a, reason: collision with other inner class name */
    public interface InterfaceC0321a {
        void a(boolean r1, String r2);
    }

    public static final class b implements InterfaceC0321a {
        public b() {
        }

        @Override // xfb.a.InterfaceC0321a
        public final void a(boolean r1, String r2) {
            a.b = r1;
            if (r1 == false) goto L5;
            a.b(r2);
            return;
        L5:
            a.a();
        }
    }

    public a() {
    }

    static {
        c = new b();
        tfb.a.b r0 = tfb.a.a;
        tfb.a.c r1 = tfb.a.c;
        a = r1;
        if (r1 == null) goto L5;
        boolean r2 = AppLifecycle.a.a.h();
    L6:
        b = r2;
        return;
    L5:
        r2 = false;
        goto L6
    }

    public static final void a() {
        if (b == true) goto L15;
        Iterator r0 = ((LinkedHashMap) com.ss.android.lark.floating.widget.appfloat.c.b).entrySet().iterator();
    L7:
        if (r0.hasNext() == false) goto L19;
        Map.Entry r1 = (Map.Entry) r0.next();
        String r2 = (String) r1.getKey();
        vfb.a r3 = ((AppFloatManager) r1.getValue()).b;
        if (r3.n != ShowPattern.FOREGROUND) goto L11;
    L13:
        boolean r4 = false;
    L14:
        c(r4, r2);
        goto L7
    L11:
        if (r3.H == false) goto L13;
        r4 = true;
        goto L14
    L19:
        return;
    }

    public static final void b(String r5) {
        if (r5 == null) goto L13;
        Iterator r0 = ((LinkedHashMap) com.ss.android.lark.floating.widget.appfloat.c.b).entrySet().iterator();
    L6:
        if (r0.hasNext() == false) goto L22;
        Map.Entry r1 = (Map.Entry) r0.next();
        String r2 = (String) r1.getKey();
        vfb.a r3 = ((AppFloatManager) r1.getValue()).b;
        if (r3.n == ShowPattern.BACKGROUND) goto L9;
        if (r3.H == false) goto L6;
        c(!r3.F.contains(r5), r2);
        goto L6
    L9:
        c(false, r2);
        goto L6
    L22:
        return;
    }

    public static void c(boolean r2, String r3) {
        LinkedHashMap r0 = (LinkedHashMap) com.ss.android.lark.floating.widget.appfloat.c.b;
        AppFloatManager r1 = (AppFloatManager) r0.get(r3);
        if (r1 == null) goto L7;
        vfb.a r4 = r1.b;
        if (r4 == null) goto L7;
        boolean r5 = r4.H;
    L8:
        if (r3 != null) goto L10;
        r3 = "default";
    L10:
        AppFloatManager r6 = (AppFloatManager) r0.get(r3);
        if (r6 == null) goto L17;
        if (r2 == false) goto L14;
        int r7 = 0;
    L15:
        r6.h(r7, r5);
        Unit r8 = Unit.INSTANCE;
        return;
    L14:
        r7 = 8;
        goto L15
    L17:
        return;
    L7:
        r5 = true;
        goto L8
    }
}
