package ria;

import android.content.Context;
import android.media.SoundPool;
import com.larus.utils.logger.FLogger;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class c {
    public static final c a = null;
    public static Context b;
    public static int c;
    public static float d;
    public static final Map<Integer, Integer> e = null;
    public static final Map<Integer, Integer> f = null;
    public static SoundPool g;
    public static final b h = null;

    public c() {
    }

    /* JADX WARN: Type inference failed for: r0v6, types: [ria.b] */
    static {
        a = new c();
        c = -1;
        e = MapsKt.mapOf(new Pair[]{TuplesKt.to(0, 2131820660), TuplesKt.to(1, 2131820661), TuplesKt.to(2, 2131820662), TuplesKt.to(3, 2131820663), TuplesKt.to(4, 2131820664)});
        f = new LinkedHashMap();
        h = new b();
    }

    public final Context getContext() {
        return b;
    }

    public final synchronized void a(int r8, float r9) {
        monitor-enter(this);
        FLogger r2 = FLogger.a;     // Catch: Throwable -> L14
        r2.i("SoundPlayer", "playSound soundId = " + r8 + ", playingSoundId = " + c);     // Catch: Throwable -> L14
        if (r8 == c) goto L8;
        monitor-exit(this);
        return;
    L8:
        r2.i("SoundPlayer", "do play sound id = " + r8);     // Catch: Throwable -> L14
        SoundPool r0 = g;     // Catch: Throwable -> L14
        if (r0 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("soundPool");     // Catch: Throwable -> L14
        r0 = null;
    L11:
        r0.play(r8, r9, r9, 0, 0, 1.0f);     // Catch: Throwable -> L14
        monitor-exit(this);
        return;
    L14:
        th = move-exception;
        throw th;
    }
}
