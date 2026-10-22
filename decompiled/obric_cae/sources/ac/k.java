package ac;

import android.content.Context;
import android.media.AudioAttributes;
import android.media.SoundPool;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes2.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static SoundPool f322a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ConcurrentHashMap<Integer, Integer> f323b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ConcurrentHashMap.KeySetView<Integer, Boolean> f324c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Object f325d = null;

    static {
        f323b = new ConcurrentHashMap();
        f324c = ConcurrentHashMap.newKeySet();
        f325d = new Object();
    }

    public static void a() {
        if (f322a != null) goto L17;
        Object r8 = f325d;
        monitor-enter(r8);
    L14:
        th = move-exception;
        throw th;
    L7:
        if (f322a != null) goto L11;
        zc.b.a("OUISoundEffectHelper", "init soundPool");     // Catch: Throwable -> L14
        AudioAttributes r10 = new AudioAttributes.Builder().setUsage(13).setContentType(4).build();     // Catch: Throwable -> L14
        SoundPool r11 = new SoundPool.Builder().setMaxStreams(5).setAudioAttributes(r10).build();     // Catch: Throwable -> L14
        f322a = r11;     // Catch: Throwable -> L14
        if (r11 == null) goto L11;
        r11.setOnLoadCompleteListener(j.f321a);     // Catch: Throwable -> L14
    L11:
        xd.j r12 = xd.j.f13877a;     // Catch: Throwable -> L14
        monitor-exit(r8);
        return;
    }

    public static void b(Context r10, int... r11) {
        int r8 = 0;
        a();     // Catch: Exception -> L14
        int r12 = r11.length;     // Catch: Exception -> L14
        int r13 = 0;
    L4:
        if (r13 >= r12) goto L35;
        int r14 = r11[r13];     // Catch: Exception -> L14
        r13 = r13 + 1;     // Catch: Exception -> L14
        ConcurrentHashMap<Integer, Integer> r15 = f323b;     // Catch: Exception -> L14
        if (r15.containsKey(Integer.valueOf(r14)) == true) goto L4;
        SoundPool r16 = f322a;     // Catch: Exception -> L14
        if (r16 == null) goto L10;
        Integer r17 = Integer.valueOf(r16.load(r10.getApplicationContext(), r14, 1));     // Catch: Exception -> L14
    L11:
        if (r17 == null) goto L4;
        r15.put(Integer.valueOf(r14), r17);     // Catch: Exception -> L14
        zc.b.a("OUISoundEffectHelper", "start load, resId=" + r14 + ", 分配的 soundId=" + r17);     // Catch: Exception -> L14
        goto L4
    L10:
        r17 = null;
        goto L11
    L35:
        return;
    L14:
        e = move-exception;
        StringBuilder r18 = new StringBuilder("load failed, resIds=");
        StringBuilder r19 = new StringBuilder();
        r19.append("");
        int r20 = r11.length;
        int r21 = 0;
    L16:
        if (r8 >= r20) goto L21;
        int r22 = r11[r8];
        r21 = r21 + 1;
        if (r21 <= 1) goto L20;
        r19.append(", ");
    L20:
        r19.append(String.valueOf(r22));
        r8 = r8 + 1;
        goto L16
    L21:
        r19.append("");
        String r110 = r19.toString();
        he.i.e(r110, "joinTo(StringBuilder(), …ed, transform).toString()");
        r18.append(r110);
        zc.b.c("OUISoundEffectHelper", r18.toString(), e);
    }
}
