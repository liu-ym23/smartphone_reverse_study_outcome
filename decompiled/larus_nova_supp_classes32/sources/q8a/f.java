package q8a;

import java.lang.reflect.Method;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class f {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static boolean b(Object r7) {
        if (r7 == null) goto L24;
        Method[] r8 = r7.getClass().getMethods();
        if (r8 == null) goto L25;
        int r1 = r8.length;
        int r2 = 0;
    L8:
        if (r2 >= r1) goto L18;
        Method r4 = r8[r2];
        if (Intrinsics.areEqual(r4.getName(), "getTabLayout") == true) goto L12;
    L14:
        boolean r5 = false;
    L15:
        if (r5 == true) goto L16;
        r2 = r2 + 1;
        goto L8
    L16:
        boolean r9 = true;
    L19:
        if (r9 != true) goto L26;
        return true;
    L26:
        return false;
    L12:
        if (r4.getParameterCount() != 0) goto L14;
        r5 = true;
        goto L15
    L18:
        r9 = false;
        goto L19
    L25:
        return false;
    L24:
        return false;
    }

    public static void a(Object r9, Object r10) {
        Intrinsics.checkNotNullParameter(r9, "pager");
        Intrinsics.checkNotNullParameter(r10, "tabOwner");
        Method[] r0 = r9.getClass().getMethods();
        int r1 = r0.length;
        int r3 = 0;
    L3:
        Method r5 = null;
        if (r3 >= r1) goto L16;
        Method r6 = r0[r3];
        if (Intrinsics.areEqual(r6.getName(), "setTabLayout") == true) goto L8;
    L12:
        boolean r7 = false;
    L13:
        if (r7 == true) goto L17;
        r3 = r3 + 1;
    L17:
        if (r6 == null) goto L19;
        r6.invoke(r9, new Object[]{r10});
    L19:
        Method[] r11 = r9.getClass().getMethods();
        int r2 = r11.length;
        int r4 = 0;
    L20:
        if (r4 >= r2) goto L30;
        Method r8 = r11[r4];
        if (Intrinsics.areEqual(r8.getName(), "setTabBarElementAdded") == true) goto L24;
    L26:
        boolean r12 = false;
    L27:
        if (r12 == true) goto L28;
        r4 = r4 + 1;
        goto L20
    L28:
        r5 = r8;
        goto L30
    L24:
        if (r8.getParameterCount() != 1) goto L26;
        r12 = true;
    L30:
        if (r5 == null) goto L37;
        r5.invoke(r9, new Object[]{Boolean.FALSE});
        return;
    L37:
        return;
    L8:
        if (r6.getParameterCount() != 1) goto L12;
        if (r6.getParameterTypes()[0].isAssignableFrom(r10.getClass()) == false) goto L12;
        r7 = true;
        goto L13
    L16:
        r6 = null;
        goto L17
    }
}
