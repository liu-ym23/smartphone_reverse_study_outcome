package androidx.fragment.app;

import android.view.View;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class a0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c0 f1926a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final f0 f1927b = null;

    static {
        f1926a = new c0();
        f0 r8 = (f0) f1.f.class.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);     // Catch: Exception -> L5
    L6:
        f1927b = r8;
        return;
    L5:
        r8 = null;
        goto L6
    }

    public static void a(Fragment r8, Fragment r10, boolean r11) {
        if (r11 == false) goto L4;
        r10.getEnterTransitionCallback();
        return;
    L4:
        r8.getEnterTransitionCallback();
    }

    public static void b(ArrayList<View> r8, int r10) {
        if (r8 != null) goto L4;
        return;
    L4:
        int r11 = r8.size() - 1;
    L5:
        if (r11 < 0) goto L7;
        r8.get(r11).setVisibility(r10);
        r11 = r11 - 1;
        goto L5
    }
}
