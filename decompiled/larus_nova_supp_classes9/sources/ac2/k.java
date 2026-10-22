package ac2;

import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class k {
    public static final /* synthetic */ int a = 0;

    @JvmStatic
    public static final long a() {
        return ((rb2.c) com.bytedance.android.livesdk.interactivity.service.settings.j.a.getValue()).c();
    }

    @JvmStatic
    public static final boolean c() {
        return ((rb2.c) com.bytedance.android.livesdk.interactivity.service.settings.j.a.getValue()).a();
    }

    @JvmStatic
    public static final boolean b() {
        if (c() == true) goto L5;
    L7:
        return false;
    L5:
        if (((rb2.c) com.bytedance.android.livesdk.interactivity.service.settings.j.a.getValue()).b() != 0) goto L7;
        return true;
    }

    @JvmStatic
    public static final boolean d() {
        if (c() == true) goto L5;
    L7:
        return false;
    L5:
        if (((rb2.c) com.bytedance.android.livesdk.interactivity.service.settings.j.a.getValue()).b() == 2) goto L7;
        return true;
    }

    static {
    }
}
