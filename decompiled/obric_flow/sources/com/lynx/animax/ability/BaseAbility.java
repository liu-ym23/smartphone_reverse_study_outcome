package com.lynx.animax.ability;

import android.text.TextUtils;
import androidx.profileinstaller.a;
import com.lynx.animax.base.CalledByNative;
import com.lynx.animax.base.bridge.ReadableMap;
import com.lynx.animax.player.IVideoPlayer;
import com.lynx.animax.player.b;
import com.lynx.animax.player.e;
import com.lynx.animax.player.f;
import com.lynx.animax.player.i;
import com.lynx.animax.util.AnimaXLog;
import com.lynx.animax.util.LynxAnimaX;
import fm.c;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class BaseAbility {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CopyOnWriteArrayList f9575a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public WeakReference f9576b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final b f9577c;
    public final e d;
    public final c e;

    public BaseAbility() {
        this.f9575a = new CopyOnWriteArrayList();
        b r5 = new b(LynxAnimaX.inst().getScope());
        this.f9577c = r5;
        this.d = new e(r5);
        this.e = new c(r5);
    }

    @CalledByNative
    public IVideoPlayer createVideoPlayer(long r5) {
        String r10 = jm.b.a("ANIMAX_VIDEO_SURFACE_DESTROY_TIMEOUT", this);
    L8:
        e = move-exception;
        AnimaXLog.a(AnimaXLog.LogLevel.f9715c, "DeviceUtil", "getVideoSurfaceDestroyTimeout fail, message" + e.getMessage());
    L10:
        long r11 = 0;
    L11:
        e r12 = this.d;
        r12.f9666b = r11;
        int[] r13 = f.f9668a;
        r12.getClass();
        int r14 = r13[0];
        return new i(r12);
    L4:
        if (TextUtils.isEmpty(r10) == true) goto L10;
        r11 = Long.parseLong(r10);     // Catch: NumberFormatException -> L8
        goto L11
    }

    public String m(String r5) {
        return r5;
    }

    public final void n(HashMap r5, int r10) {
        a r11 = new a(this, r10, r5, 6);
        if (jm.c.i() == false) goto L6;
        r11.run();
        return;
    L6:
        jm.c.a().post(r11);
    }

    @CalledByNative
    public void sendEvent(int r5, ReadableMap r10) {
        n(r10.asHashMap(), r5);
    }
}
