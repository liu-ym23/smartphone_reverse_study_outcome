package m;

import android.app.ActivityThread;
import android.content.Context;

/* JADX INFO: loaded from: classes3.dex */
public abstract class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Context f19879a;

    public static Context a() {
        Context r5 = f19879a;
        if (r5 == null) goto L6;
        return r5;
    L6:
        return ActivityThread.currentActivityThread().getApplication().getApplicationContext();
    }
}
