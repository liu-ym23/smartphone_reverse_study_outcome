package s1;

import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
public final class o {
    static {
        he.i.e(androidx.work.m.f("ProcessUtils"), "tagWithPrefix(\"ProcessUtils\")");
    }

    public static final boolean a(Context r8, androidx.work.c r10) {
        he.i.f(r8, "context");
        he.i.f(r10, "configuration");
        String r11 = a.f11946a.a();
        String r12 = r10.f2801f;
        if (r12 != null) goto L5;
    L8:
        boolean r13 = true;
    L9:
        if (r13 == true) goto L12;
        return he.i.a(r11, r12);
    L12:
        return he.i.a(r11, r8.getApplicationInfo().processName);
    L5:
        if (r12.length() == 0) goto L8;
        r13 = false;
        goto L9
    }
}
