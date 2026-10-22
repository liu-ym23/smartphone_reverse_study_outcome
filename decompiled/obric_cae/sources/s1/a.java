package s1;

import android.app.Application;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f11946a = null;

    static {
        f11946a = new a();
    }

    public final String a() {
        String r8 = Application.getProcessName();
        he.i.e(r8, "getProcessName()");
        return r8;
    }
}
