package zk8;

import android.content.Context;
import android.media.AudioAttributes;
import android.media.MediaPlayer;
import android.os.Handler;
import android.os.Looper;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.bmhome.music.applet.MusicAppletPage;
import com.larus.media.MediaLevel;
import com.larus.media.MediaOccupyStrategy;
import com.larus.media.MediaResourceManager;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import java.util.concurrent.ExecutorService;
import kotlin.Lazy;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class n {
    public static final n a = null;
    public static MediaPlayer b;
    public static String c;
    public static Function1<? super vl8.g, Unit> d;
    public static boolean e;
    public static boolean f;
    public static boolean g;
    public static final Handler h = null;
    public static j i;
    public static final ExecutorService j = null;
    public static final b k = null;
    public static final com.larus.media.model.a l = null;

    public static final class a implements com.larus.media.v {
        public a() {
        }

        public final boolean b(lk9.g r2) {
            Intrinsics.checkNotNullParameter(r2, "applicant");
            return false;
        }

        public final void e(lk9.g r2) {
            Intrinsics.checkNotNullParameter(r2, "applicant");
            n.h.post(new l());
        }

        public final void f(MediaResourceManager.a r2) {
            Intrinsics.checkNotNullParameter(r2, "event");
        }

        public final void a(lk9.g r1, float r2) {
            Intrinsics.checkNotNullParameter(r1, "applicant");
            n.h.post(new k(this));
        }

        public final void d(lk9.g r1, lk9.g r2) {
            com.larus.media.v.a.c(r1, r2);
        }

        public final void g(lk9.g r1, float r2) {
            com.larus.media.v.a.g(r1, r2);
        }

        public final void i(lk9.g r2, lk9.g r3) {
            Intrinsics.checkNotNullParameter(r2, "current");
            Intrinsics.checkNotNullParameter(r3, "applicant");
            n.h.post(new m(this));
        }

        public final MediaOccupyStrategy c(lk9.g r1, lk9.g r2, int r3) {
            return com.larus.media.v.a.a(this, r1, r2, r3);
        }

        public final MediaOccupyStrategy h(lk9.g r1, lk9.g r2, int r3) {
            Intrinsics.checkNotNullParameter(r1, "current");
            Intrinsics.checkNotNullParameter(r2, "applicant");
            return MediaOccupyStrategy.PAUSE;
        }
    }

    public static final class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            n.a.getClass();     // Catch: Throwable -> L11
            n.d();     // Catch: Throwable -> L11
            MediaPlayer r0 = n.b;     // Catch: Throwable -> L11
            if (r0 == null) goto L7;
            boolean r1 = true;
            if (r0.isPlaying() != true) goto L7;
        L8:
            if (r1 == false) goto L14;
            n.h.postDelayed(this, 200);     // Catch: Throwable -> L11
            return;
        L14:
            return;
        L7:
            r1 = false;
        L11:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L18;
            throw th;
        }
    }

    public n() {
    }

    public final synchronized void e() {
        monitor-enter(this);
        b();     // Catch: Throwable -> L20
        h.removeCallbacks(k);     // Catch: Throwable -> L20
        Function1<? super vl8.g, Unit> r0 = d;     // Catch: Throwable -> L20
        if (r0 == null) goto L6;
        r0.invoke(new vl8.g(false, false, false, 0.0f, 15));     // Catch: Throwable -> L20
    L6:
        final MediaPlayer r1 = b;     // Catch: Throwable -> L20
        b = null;     // Catch: Throwable -> L20
        c = null;     // Catch: Throwable -> L20
        d = null;     // Catch: Throwable -> L20
        e = false;     // Catch: Throwable -> L20
        g = false;     // Catch: Throwable -> L20
        if (f == false) goto L10;
        f = false;     // Catch: Throwable -> L20
        Lazy r2 = MediaResourceManager.a;     // Catch: Throwable -> L20
        MediaResourceManager.a(l);     // Catch: Throwable -> L20
    L10:
        if (r1 != null) goto L25;
        monitor-exit(this);
        return;
    L25:
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L15
        r1.setOnPreparedListener(null);     // Catch: Throwable -> L15
        r1.setOnCompletionListener(null);     // Catch: Throwable -> L15
        r1.setOnErrorListener(null);     // Catch: Throwable -> L15
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L15
    L17:
        j.execute(new zk8.b(r1));     // Catch: Throwable -> L20
        monitor-exit(this);
        return;
    L15:
        th = move-exception;
        Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L20
        Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        throw th;
    }

    static {
        a = new n();
        h = new Handler(Looper.getMainLooper());
        j = PThreadExecutorsUtils.newSingleThreadExecutor(new zk8.a());
        k = new b();
        l = new com.larus.media.model.a("file_audio", "music", false, 0, 2, false, 0, false, false, MediaLevel.PLAY_HIGH.getValue(), false, new a(), 236);
    }

    public static vl8.g a() {
        MediaPlayer r0 = b;
        if (r0 != null) goto L7;
        return new vl8.g(false, false, false, 0.0f, 15);
    L7:
        if (e == false) goto L9;
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L12
        Object r2 = Result.constructor-impl(Integer.valueOf(r0.getDuration()));     // Catch: Throwable -> L12
    L15:
        if (Result.isFailure-impl(r2) == false) goto L17;
        r2 = 0;
    L17:
        int r3 = ((Number) r2).intValue();
        Object r4 = Result.constructor-impl(Integer.valueOf(r0.getCurrentPosition()));     // Catch: Throwable -> L20
    L23:
        if (Result.isFailure-impl(r4) == false) goto L25;
        r4 = 0;
    L25:
        int r5 = ((Number) r4).intValue();
        Object r6 = Result.constructor-impl(Boolean.valueOf(r0.isPlaying()));     // Catch: Throwable -> L28
    L30:
        Boolean r7 = Boolean.FALSE;
        if (Result.isFailure-impl(r6) == false) goto L33;
        r6 = r7;
    L33:
        boolean r8 = ((Boolean) r6).booleanValue();
        boolean r9 = !r8;
        if (r3 <= 0) goto L36;
        float r10 = r5 / r3;
    L38:
        return new vl8.g(r8, false, r9, r10, 2);
    L36:
        r10 = 0.0f;
    L28:
        th = move-exception;
        Result.Companion r11 = Result.Companion;
        r6 = Result.constructor-impl(ResultKt.createFailure(th));
    L20:
        th = move-exception;
        Result.Companion r12 = Result.Companion;
        r4 = Result.constructor-impl(ResultKt.createFailure(th));
    L12:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        r2 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L15
    L9:
        return new vl8.g(false, true, false, 0.0f, 13);
    }

    public static void b() {
        j r0 = i;
        if (r0 == null) goto L5;
        h.removeCallbacks(r0);
    L5:
        i = null;
    }

    public static void d() {
        Function1<? super vl8.g, Unit> r0 = d;
        if (r0 == null) goto L6;
        r0.invoke(a());
        return;
    }

    public final synchronized vl8.g c(String r7) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r7, MusicAppletPage.KEY_PATH);     // Catch: Throwable -> L11
        if (Intrinsics.areEqual(r7, c) == true) goto L8;
        vl8.g r8 = new vl8.g(false, false, false, 0.0f, 15);     // Catch: Throwable -> L11
        monitor-exit(this);
        return r8;
    L8:
        vl8.g r9 = a();     // Catch: Throwable -> L11
        monitor-exit(this);
        return r9;
    L11:
        th = move-exception;
        throw th;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v13, types: [java.lang.Runnable, zk8.j] */
    public final synchronized void f(Context r9, final String r10, Function1<? super vl8.g, Unit> r11, final Function0<Unit> r12) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r9, "context");     // Catch: Throwable -> L79
        Intrinsics.checkNotNullParameter(r10, MusicAppletPage.KEY_PATH);     // Catch: Throwable -> L79
        Intrinsics.checkNotNullParameter(r11, "onStateChanged");     // Catch: Throwable -> L79
        Intrinsics.checkNotNullParameter(r12, "onError");     // Catch: Throwable -> L79
        ch8.a.a.getClass();     // Catch: Throwable -> L79
        ch8.b.b r3 = ch8.a.a(r10);     // Catch: Throwable -> L79
        Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L7
        Object r5 = Result.constructor-impl(UriProtector.parse(r10).getScheme());     // Catch: Throwable -> L7
    L10:
        if (Result.isFailure-impl(r5) == false) goto L12;
        r5 = null;
    L12:
        String r6 = (String) r5;     // Catch: Throwable -> L79
        if (StringsKt.equals(r6, "http", true) == false) goto L15;
    L18:
        boolean r7 = true;
    L19:
        if (r3 != null) goto L25;
        if (r7 == true) goto L25;
        FLogger.a.e("FileAudioPlayer", "play failed, invalid or missing file: ".concat(r10));     // Catch: Throwable -> L79
        r12.invoke();     // Catch: Throwable -> L79
        monitor-exit(this);
        return;
    L25:
        if ((r3 instanceof ch8.b.b) == false) goto L32;
        if (r3.a.isFile() == true) goto L32;
        FLogger.a.e("FileAudioPlayer", "play failed, file does not exist: ".concat(r10));     // Catch: Throwable -> L79
        r12.invoke();     // Catch: Throwable -> L79
        monitor-exit(this);
        return;
    L32:
        if (Intrinsics.areEqual(c, r10) == false) goto L59;
        final MediaPlayer r1 = b;     // Catch: Throwable -> L79
        if (r1 == null) goto L59;
        d = r11;     // Catch: Throwable -> L79
        if (e == true) goto L40;
        monitor-exit(this);
        return;
    L40:
        if (r1.isPlaying() == false) goto L51;
        if (fna.g.d() == true) goto L44;
        r1.pause();     // Catch: Throwable -> L79
    L46:
        if (f == false) goto L49;
        f = false;     // Catch: Throwable -> L79
        Lazy r13 = MediaResourceManager.a;     // Catch: Throwable -> L79
        MediaResourceManager.a(l);     // Catch: Throwable -> L79
    L49:
        h.removeCallbacks(k);     // Catch: Throwable -> L79
        d();     // Catch: Throwable -> L79
    L57:
        monitor-exit(this);
        return;
    L44:
        r1.pause();     // Catch: Throwable -> L79
        gna.a.a(r1.hashCode());     // Catch: Throwable -> L79
        goto L46
    L51:
        if (g == true) goto L53;
    L56:
        Function0 r14 = new c(r1);     // Catch: Throwable -> L79
        g = false;     // Catch: Throwable -> L79
        Lazy r15 = MediaResourceManager.a;     // Catch: Throwable -> L79
        MediaResourceManager.m(l, new h(r14), new i(r12), 0, 8);     // Catch: Throwable -> L79
        goto L57
    L53:
        if (f == false) goto L56;
        f = false;     // Catch: Throwable -> L79
        Lazy r16 = MediaResourceManager.a;     // Catch: Throwable -> L79
        MediaResourceManager.a(l);     // Catch: Throwable -> L79
    L59:
        e();     // Catch: Throwable -> L79
        c = r10;     // Catch: Throwable -> L79
        d = r11;     // Catch: Throwable -> L79
        e = false;     // Catch: Throwable -> L79
        final MediaPlayer r17 = new MediaPlayer();     // Catch: Throwable -> L79
        b = r17;     // Catch: Throwable -> L79
        d();     // Catch: Throwable -> L79
        r17.setAudioAttributes(new AudioAttributes.Builder().setContentType(2).setUsage(1).build());     // Catch: Throwable -> L69
        if ((r3 instanceof ch8.b.b) == false) goto L64;
        r17.setDataSource(r3.a.getPath());     // Catch: Throwable -> L69
    L68:
        r17.setOnPreparedListener(new d(this, r12));     // Catch: Throwable -> L69
        r17.setOnCompletionListener(new e(this));     // Catch: Throwable -> L69
        r17.setOnErrorListener(new f(this, r12));     // Catch: Throwable -> L69
        r17.prepareAsync();     // Catch: Throwable -> L69
        b();     // Catch: Throwable -> L69
        ?? r18 = new j(r17, r10, r12);     // Catch: Throwable -> L69
        i = r18;     // Catch: Throwable -> L69
        h.postDelayed(r18, 3000);     // Catch: Throwable -> L69
        Object r19 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L69
    L74:
        Throwable r20 = Result.exceptionOrNull-impl(r19);     // Catch: Throwable -> L79
        if (r20 == null) goto L77;
        FLogger.a.e("FileAudioPlayer", "play failed, path=".concat(r10), r20);     // Catch: Throwable -> L79
        a.e();     // Catch: Throwable -> L79
        r12.invoke();     // Catch: Throwable -> L79
    L77:
        monitor-exit(this);
        return;
    L64:
        if ((r3 instanceof ch8.b.a) == false) goto L66;
        r17.setDataSource(r9.getApplicationContext(), ((ch8.b.a) r3).a);     // Catch: Throwable -> L69
        goto L68
    L66:
        if (r3 != null) goto L72;
        r17.setDataSource(r10);     // Catch: Throwable -> L69
        goto L68
    L72:
        throw new NoWhenBranchMatchedException();     // Catch: Throwable -> L69
    L69:
        th = move-exception;
        Result.Companion r110 = Result.Companion;     // Catch: Throwable -> L79
        r19 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L79
        goto L74
    L15:
        if (StringsKt.equals(r6, "https", true) == true) goto L18;
        r7 = false;
    L7:
        th = move-exception;
        Result.Companion r8 = Result.Companion;     // Catch: Throwable -> L79
        r5 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L79
    L79:
        th = move-exception;
        throw th;
    }
}
