package o9;

import android.content.Context;
import android.media.AudioAttributes;
import android.media.SoundPool;
import android.provider.Settings;
import androidx.annotation.RawRes;
import androidx.annotation.RequiresApi;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@RequiresApi(24)
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static SoundPool f11589a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ConcurrentHashMap<Integer, Integer> f11590b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final ConcurrentHashMap.KeySetView<Integer, Boolean> f11591c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final Object f11592d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final m f11593e = null;

    static final class a implements SoundPool.OnLoadCompleteListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f11594a = null;

        static {
            f11594a = new a();
        }

        a() {
        }

        @Override // android.media.SoundPool.OnLoadCompleteListener
        public final void onLoadComplete(SoundPool r10, int r11, int r12) {
            if (r12 != 0) goto L22;
            Set r13 = m.b(m.f11593e).entrySet();
            Intrinsics.checkNotNullExpressionValue(r13, "soundIdMap.entries");
            Iterator r14 = r13.iterator();
        L5:
            Integer r15 = null;
            if (r14.hasNext() == false) goto L16;
            Object r16 = r14.next();
            Integer r17 = (Integer) ((Map.Entry) r16).getValue();
            if (r17 != null) goto L11;
        L13:
            boolean r18 = false;
        L14:
            if (r18 == false) goto L5;
        L17:
            Map.Entry r19 = (Map.Entry) r16;
            if (r19 == null) goto L20;
            r15 = (Integer) r19.getKey();
        L20:
            if (r15 == null) goto L29;
            m.a(m.f11593e).add(r15);
            ea.b.a("OUISoundEffectHelper", "loaded: resId=" + r15);
            return;
        L29:
            return;
        L11:
            if (r17.intValue() != r11) goto L13;
            r18 = true;
            goto L14
        L16:
            r16 = null;
            goto L17
        L22:
            ea.b.b("OUISoundEffectHelper", "load failed, sampleId=" + r11 + ", status=" + r12);
        }
    }

    static {
        f11593e = new m();
        f11590b = new ConcurrentHashMap();
        f11591c = ConcurrentHashMap.newKeySet();
        f11592d = new Object();
    }

    private m() {
    }

    public static final /* synthetic */ ConcurrentHashMap.KeySetView a(m r10) {
        return f11591c;
    }

    public static final /* synthetic */ ConcurrentHashMap b(m r10) {
        return f11590b;
    }

    private final void c(Context r10) {
        if (f11589a != null) goto L17;
        Object r11 = f11592d;
        monitor-enter(r11);
    L14:
        th = move-exception;
        throw th;
    L7:
        if (f11589a != null) goto L11;
        ea.b.a("OUISoundEffectHelper", "init soundPool");     // Catch: Throwable -> L14
        AudioAttributes r12 = new AudioAttributes.Builder().setUsage(13).setContentType(4).build();     // Catch: Throwable -> L14
        SoundPool r13 = new SoundPool.Builder().setMaxStreams(5).setAudioAttributes(r12).build();     // Catch: Throwable -> L14
        f11589a = r13;     // Catch: Throwable -> L14
        if (r13 == null) goto L11;
        r13.setOnLoadCompleteListener(a.f11594a);     // Catch: Throwable -> L14
    L11:
        Unit r14 = Unit.INSTANCE;     // Catch: Throwable -> L14
        monitor-exit(r11);
        return;
    }

    private final int d(Context r10) {
        return Settings.System.getInt(r10.getContentResolver(), "sound_effects_enabled", 0);
    L5:
        e = move-exception;
        ea.b.c("OUISoundEffectHelper", "get sound effect enabled failed", e);
        return 0;
    }

    public final void e(Context r12, int... r13) {
        Intrinsics.checkNotNullParameter(r12, "context");
        Intrinsics.checkNotNullParameter(r13, "soundResIds");
        c(r12);     // Catch: Exception -> L14
        int r11 = 0;
        int r10 = r13.length;     // Catch: Exception -> L14
    L4:
        if (r11 >= r10) goto L26;
        int r14 = r13[r11];     // Catch: Exception -> L14
        r11 = r11 + 1;     // Catch: Exception -> L14
        ConcurrentHashMap<Integer, Integer> r15 = f11590b;     // Catch: Exception -> L14
        if (r15.containsKey(Integer.valueOf(r14)) == true) goto L4;
        SoundPool r16 = f11589a;     // Catch: Exception -> L14
        if (r16 == null) goto L10;
        Integer r17 = Integer.valueOf(r16.load(r12.getApplicationContext(), r14, 1));     // Catch: Exception -> L14
    L11:
        if (r17 == null) goto L4;
        r15.put(Integer.valueOf(r14), r17);     // Catch: Exception -> L14
        ea.b.a("OUISoundEffectHelper", "start load, resId=" + r14 + ", 分配的 soundId=" + r17);     // Catch: Exception -> L14
        goto L4
    L10:
        r17 = null;
        goto L11
    L26:
        return;
    L14:
        e = move-exception;
        ea.b.c("OUISoundEffectHelper", "load failed, resIds=" + ArraysKt.joinToString$default(r13, ", ", null, null, 0, null, null, 62, null), e);
    }

    public final void f(Context r10, @RawRes int r11) {
        if (r10 != null) goto L7;
        ea.b.j("OUISoundEffectHelper", "can't play, context is null");
        return;
    L7:
        if (d(r10) != 0) goto L25;
        return;
    L25:
        c(r10);     // Catch: Exception -> L21
        if (f11591c.contains(Integer.valueOf(r11)) == false) goto L12;
        Integer r12 = f11590b.get(Integer.valueOf(r11));     // Catch: Exception -> L21
        if (r12 == null) goto L24;
        SoundPool r13 = f11589a;     // Catch: Exception -> L21
        if (r13 == null) goto L24;
        Intrinsics.checkNotNullExpressionValue(r12, "soundId");     // Catch: Exception -> L21
        r13.play(r12.intValue(), 1.0f, 1.0f, 1, 0, 1.0f);     // Catch: Exception -> L21
    L24:
        return;
    L12:
        if (f11590b.containsKey(Integer.valueOf(r11)) == true) goto L14;
        ea.b.j("OUISoundEffectHelper", "not loaded, start now: resId=" + r11);     // Catch: Exception -> L21
        e(r10, new int[]{r11});     // Catch: Exception -> L21
        goto L24
    L14:
        ea.b.a("OUISoundEffectHelper", "loading: resId=" + r11);     // Catch: Exception -> L21
    L21:
        e = move-exception;
        ea.b.c("OUISoundEffectHelper", "play failed, resId=" + r11, e);
    }

    public final void g() {
        ea.b.a("OUISoundEffectHelper", "release");
        SoundPool r10 = f11589a;
        if (r10 == null) goto L5;
        r10.release();
    L5:
        f11589a = null;
        f11590b.clear();
        f11591c.clear();
    }
}
