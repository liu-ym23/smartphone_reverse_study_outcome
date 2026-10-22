package tb;

import ac.k;
import android.content.ComponentCallbacks2;
import android.content.res.Configuration;
import android.media.SoundPool;
import he.i;
import zc.b;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements ComponentCallbacks2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f12365a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f12366b = null;

    static {
        f12366b = new a();
    }

    @Override // android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration r8) {
        i.f(r8, "newConfig");
    }

    @Override // android.content.ComponentCallbacks
    public final void onLowMemory() {
        SoundPool r8 = k.f322a;
        b.a("OUISoundEffectHelper", "release");
        SoundPool r10 = k.f322a;
        if (r10 == null) goto L5;
        r10.release();
    L5:
        k.f322a = null;
        k.f323b.clear();
        k.f324c.clear();
    }

    @Override // android.content.ComponentCallbacks2
    public final void onTrimMemory(int r8) {
        SoundPool r10 = k.f322a;
        b.a("OUISoundEffectHelper", "release");
        SoundPool r11 = k.f322a;
        if (r11 == null) goto L5;
        r11.release();
    L5:
        k.f322a = null;
        k.f323b.clear();
        k.f324c.clear();
    }
}
