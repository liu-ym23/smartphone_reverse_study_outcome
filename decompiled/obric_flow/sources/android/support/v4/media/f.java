package android.support.v4.media;

import android.content.ComponentName;
import android.content.Context;
import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
public final class f {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final boolean f372b = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e f373a;

    static {
        f372b = Log.isLoggable("MediaBrowserCompat", 3);
    }

    public f(Context r5, ComponentName r10, d r11) {
        this.f373a = new e(r5, r10, r11);
    }
}
