package com.lynx.animax.ability;

import android.os.Looper;
import android.text.TextUtils;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.lynx.animax.audio.AudioAsset;
import com.lynx.animax.audio.AudioPlayer;
import com.lynx.animax.base.bridge.ReadableMap;
import com.lynx.animax.player.IVideoPlayer;
import com.lynx.animax.player.VideoPlayerType;
import com.lynx.animax.player.g;
import com.lynx.animax.player.h;
import com.lynx.animax.service.IAnimaXVideoService;
import com.lynx.animax.util.AnimaXLog;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import q4a.b;
import t4a.c;
import t4a.f;
import w4a.d;
import w4a.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class BaseAbility {
    public final List<f> a;
    public WeakReference<b> b;
    public final d c;
    public final g d;
    public final v4a.d e;
    public boolean f;
    public c g;

    public static /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[Event.values().length];
            a = r0;
            r0[Event.COMPLETION.ordinal()] = 1;     // Catch: NoSuchFieldError -> L16
        L30:
            a[Event.START.ordinal()] = 2;     // Catch: NoSuchFieldError -> L17
        L36:
            a[Event.REPEAT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L18
        L50:
            a[Event.CANCEL.ordinal()] = 4;     // Catch: NoSuchFieldError -> L19
        L32:
            a[Event.READY.ordinal()] = 5;     // Catch: NoSuchFieldError -> L20
        L38:
            a[Event.ERROR.ordinal()] = 6;     // Catch: NoSuchFieldError -> L21
        L42:
            a[Event.UPDATE.ordinal()] = 7;     // Catch: NoSuchFieldError -> L22
        L46:
            a[Event.FPS.ordinal()] = 8;     // Catch: NoSuchFieldError -> L23
        L28:
            a[Event.COMPOSITION_READY.ordinal()] = 9;     // Catch: NoSuchFieldError -> L24
        L34:
            a[Event.TAP_LAYERS.ordinal()] = 10;     // Catch: NoSuchFieldError -> L25
        L40:
            a[Event.FIRST_FRAME.ordinal()] = 11;     // Catch: NoSuchFieldError -> L26
        L44:
            a[Event.WARNING.ordinal()] = 12;     // Catch: NoSuchFieldError -> L27
            return;
        }
    }

    public String h(String r1) {
        return r1;
    }

    public boolean disableByteVC1Decoder() {
        return y4a.a.e(y4a.a.b("ANIMAX_DISABLE_BYTEVC1_DECODER", this));
    }

    public BaseAbility() {
        this.a = new CopyOnWriteArrayList();
        d r0 = new d(f());
        this.c = r0;
        this.d = new g(r0);
        this.e = new v4a.d(r0);
        this.f = false;
    }

    public e f() {
        return e.b;
    }

    public AudioPlayer createAudioPlayer(AudioAsset r5) {
        if (r5.a() == false) goto L11;
        ByteBuffer r0 = r5.c;
        if (r0 == null) goto L11;
        return new AudioPlayer(r5.b, r0);
    L9:
        e = move-exception;
        AnimaXLog.a("AudioPlayer", "Failed to create AudioPlayer: " + e.getMessage());
        return null;
    L11:
        AnimaXLog.a("AudioPlayer", "Failed to create AudioPlayer: asset is not ready");
        return null;
    }

    public IVideoPlayer createVideoPlayer(long r7) {
        g r0 = this.d;
        String r1 = y4a.a.b("ANIMAX_VIDEO_SURFACE_DESTROY_TIMEOUT", this);
        long r2 = 0;
    L8:
        e = move-exception;
        AnimaXLog.a("DeviceUtil", "getVideoSurfaceDestroyTimeout fail, message" + e.getMessage());
    L10:
        r0.d = r2;
        g r3 = this.d;
        if (r3.b != VideoPlayerType.CUSTOM) goto L17;
        IAnimaXVideoService r4 = (IAnimaXVideoService) r3.a.a(IAnimaXVideoService.class);
        if (r4 != null) goto L20;
        AnimaXLog.a("VideoPlayerFactory", "IAnimaXVideoService not found, use default player");
        goto L17
    L20:
        return r4.createVideoPlayer(r7, r3);
    L17:
        return new h(r7, r3);
    L4:
        if (TextUtils.isEmpty(r1) == true) goto L10;
        r2 = CastLongProtector.parseLong(r1);     // Catch: NumberFormatException -> L8
        goto L10
    }

    public void sendEvent(int r2, ReadableMap r3) {
        o4a.a r0 = new o4a.a(this, r2, r3.asHashMap());
        if (ThreadMethodProxy.getLooperThread(Looper.getMainLooper()) != ThreadMethodProxy.currentThread()) goto L5;
        boolean r4 = true;
    L6:
        if (r4 == false) goto L8;
        r0.run();
        return;
    L8:
        y4a.d.a().post(r0);
        return;
    L5:
        r4 = false;
        goto L6
    }
}
