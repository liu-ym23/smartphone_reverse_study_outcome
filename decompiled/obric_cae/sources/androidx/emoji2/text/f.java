package androidx.emoji2.text;

import android.os.Handler;
import android.os.Looper;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* JADX INFO: loaded from: classes.dex */
public final class f {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final Object f1746i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static volatile f f1747j;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ReentrantReadWriteLock f1748a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final n.d f1749b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile int f1750c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Handler f1751d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final a f1752e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final g f1753f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f1754g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final androidx.emoji2.text.d f1755h;

    public static final class a extends b {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public volatile j f1756b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public volatile n f1757c;
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final f f1758a;

        public b(f r8) {
            this.f1758a = r8;
        }
    }

    public static abstract class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final g f1759a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f1760b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final androidx.emoji2.text.d f1761c;

        public c(g r8) {
            this.f1760b = 0;
            this.f1761c = new androidx.emoji2.text.d();
            this.f1759a = r8;
        }
    }

    public interface d {
    }

    public static abstract class e {
        public e() {
        }

        public void a() {
        }
    }

    /* JADX INFO: renamed from: androidx.emoji2.text.f$f, reason: collision with other inner class name */
    public static class RunnableC0014f implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ArrayList f1762a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f1763b;

        public RunnableC0014f(List r8, int r10, Throwable r11) {
            t2.b.n(r8, "initCallbacks cannot be null");
            this.f1762a = new ArrayList(r8);
            this.f1763b = r10;
        }

        @Override // java.lang.Runnable
        public final void run() {
            ArrayList r8 = this.f1762a;
            int r10 = r8.size();
            int r11 = 0;
            if (this.f1763b == 1) goto L6;
        L4:
            if (r11 >= r10) goto L8;
            ((e) r8.get(r11)).getClass();
            r11 = r11 + 1;
            goto L4
        L8:
            return;
        L6:
            if (r11 >= r10) goto L11;
            ((e) r8.get(r11)).a();
            r11 = r11 + 1;
            goto L6
        }
    }

    public interface g {
        void a(h r8);
    }

    public static abstract class h {
        public abstract void a(Throwable r8);

        public abstract void b(n r8);
    }

    public static class i {
    }

    static {
        f1746i = new Object();
    }

    public f(EmojiCompatInitializer.a r8) {
        ReentrantReadWriteLock r10 = new ReentrantReadWriteLock();
        this.f1748a = r10;
        this.f1750c = 3;
        g r11 = r8.f1759a;
        this.f1753f = r11;
        int r12 = r8.f1760b;
        this.f1754g = r12;
        this.f1755h = r8.f1761c;
        this.f1751d = new Handler(Looper.getMainLooper());
        this.f1749b = new n.d();
        a r13 = new a(this);
        this.f1752e = r13;
        r10.writeLock().lock();
        if (r12 == 0) goto L19;
    L10:
        r10.writeLock().unlock();
        if (b() != 0) goto L21;
        r11.a(new androidx.emoji2.text.e(r13));     // Catch: Throwable -> L14
        return;
    L14:
        th = move-exception;
        d(th);
        return;
    L21:
        return;
    L19:
        this.f1750c = 0;     // Catch: Throwable -> L7
    L7:
        th = move-exception;
        this.f1748a.writeLock().unlock();
        throw th;
    }

    public static f a() {
        Object r8 = f1746i;
        monitor-enter(r8);
        f r10 = f1747j;     // Catch: Throwable -> L14
        if (r10 == null) goto L7;
        boolean r11 = true;
    L9:
        if (r11 == false) goto L13;
        monitor-exit(r8);     // Catch: Throwable -> L14
        return r10;
    L13:
        throw new IllegalStateException("EmojiCompat is not initialized.\n\nYou must initialize EmojiCompat prior to referencing the EmojiCompat instance.\n\nThe most likely cause of this error is disabling the EmojiCompatInitializer\neither explicitly in AndroidManifest.xml, or by including\nandroidx.emoji2:emoji2-bundled.\n\nAutomatic initialization is typically performed by EmojiCompatInitializer. If\nyou are not expecting to initialize EmojiCompat manually in your application,\nplease check to ensure it has not been removed from your APK's manifest. You can\ndo this in Android Studio using Build > Analyze APK.\n\nIn the APK Analyzer, ensure that the startup entry for\nEmojiCompatInitializer and InitializationProvider is present in\n AndroidManifest.xml. If it is missing or contains tools:node=\"remove\", and you\nintend to use automatic configuration, verify:\n\n  1. Your application does not include emoji2-bundled\n  2. All modules do not contain an exclusion manifest rule for\n     EmojiCompatInitializer or InitializationProvider. For more information\n     about manifest exclusions see the documentation for the androidx startup\n     library.\n\nIf you intend to use emoji2-bundled, please call EmojiCompat.init. You can\nlearn more in the documentation for BundledEmojiCompatConfig.\n\nIf you intended to perform manual configuration, it is recommended that you call\nEmojiCompat.init immediately on application startup.\n\nIf you still cannot resolve this issue, please open a bug with your specific\nconfiguration to help improve error message.");     // Catch: Throwable -> L14
    L7:
        r11 = false;
    L14:
        th = move-exception;
        throw th;
    }

    public final int b() {
        this.f1748a.readLock().lock();
        int r8 = this.f1750c;     // Catch: Throwable -> L6
        this.f1748a.readLock().unlock();
        return r8;
    L6:
        th = move-exception;
        this.f1748a.readLock().unlock();
        throw th;
    }

    public final void c() {
        boolean r8 = true;
        if (this.f1754g != 1) goto L5;
        boolean r10 = true;
    L6:
        if (r10 == false) goto L29;
        if (b() == 1) goto L11;
        r8 = false;
    L11:
        if (r8 == false) goto L13;
        return;
    L13:
        this.f1748a.writeLock().lock();
    L25:
        th = move-exception;
        this.f1748a.writeLock().unlock();
        throw th;
    L15:
        if (this.f1750c != 0) goto L18;
        this.f1748a.writeLock().unlock();
        return;
    L18:
        this.f1750c = 0;     // Catch: Throwable -> L25
        this.f1748a.writeLock().unlock();
        a r11 = this.f1752e;
        f r12 = r11.f1758a;
        r12.f1753f.a(new androidx.emoji2.text.e(r11));     // Catch: Throwable -> L22
        return;
    L22:
        th = move-exception;
        r12.d(th);
        return;
    L29:
        throw new IllegalStateException("Set metadataLoadStrategy to LOAD_STRATEGY_MANUAL to execute manual loading");
    L5:
        r10 = false;
        goto L6
    }

    public final void d(Throwable r8) {
        ArrayList r10 = new ArrayList();
        this.f1748a.writeLock().lock();
        this.f1750c = 2;     // Catch: Throwable -> L6
        r10.addAll(this.f1749b);     // Catch: Throwable -> L6
        this.f1749b.clear();     // Catch: Throwable -> L6
        this.f1748a.writeLock().unlock();
        this.f1751d.post(new RunnableC0014f(r10, this.f1750c, r8));
        return;
    L6:
        th = move-exception;
        this.f1748a.writeLock().unlock();
        throw th;
    }

    public final void e() {
        ArrayList r8 = new ArrayList();
        this.f1748a.writeLock().lock();
        this.f1750c = 1;     // Catch: Throwable -> L6
        r8.addAll(this.f1749b);     // Catch: Throwable -> L6
        this.f1749b.clear();     // Catch: Throwable -> L6
        this.f1748a.writeLock().unlock();
        this.f1751d.post(new RunnableC0014f(r8, this.f1750c, null));
        return;
    L6:
        th = move-exception;
        this.f1748a.writeLock().unlock();
        throw th;
    }

    public final CharSequence f(int r12, int r13, CharSequence r14) {
        boolean r8 = false;
        if (b() != 1) goto L5;
        boolean r10 = true;
    L6:
        if (r10 == false) goto L116;
        if (r12 < 0) goto L114;
        if (r13 < 0) goto L112;
        if (r12 > r13) goto L11;
        boolean r11 = true;
    L12:
        t2.b.l("start should be <= than end", r11);
        q r15 = null;
        if (r14 != null) goto L16;
        return null;
    L16:
        if (r12 > r14.length()) goto L18;
        boolean r16 = true;
    L19:
        t2.b.l("start should be < than charSequence length", r16);
        if (r13 > r14.length()) goto L22;
        boolean r17 = true;
    L23:
        t2.b.l("end should be < than charSequence length", r17);
        if (r14.length() == 0) goto L110;
        if (r12 == r13) goto L110;
        j r18 = this.f1752e.f1756b;
        r18.getClass();
        boolean r19 = r14 instanceof o;
        if (r19 == false) goto L31;
        ((o) r14).a();
    L31:
        if (r19 == false) goto L117;
    L40:
        r15 = new q((Spannable) r14);     // Catch: Throwable -> L106
    L41:
        if (r15 == null) goto L52;
        k[] r20 = (k[]) r15.getSpans(r12, r13, k.class);     // Catch: Throwable -> L106
        if (r20 == null) goto L52;
        if (r20.length <= 0) goto L52;
        int r21 = r20.length;     // Catch: Throwable -> L106
        int r22 = 0;
    L47:
        if (r22 >= r21) goto L52;
        k r23 = r20[r22];     // Catch: Throwable -> L106
        int r24 = r15.getSpanStart(r23);     // Catch: Throwable -> L106
        int r25 = r15.getSpanEnd(r23);     // Catch: Throwable -> L106
        if (r24 == r13) goto L51;
        r15.removeSpan(r23);     // Catch: Throwable -> L106
    L51:
        r12 = Math.min(r24, r12);     // Catch: Throwable -> L106
        r13 = Math.max(r25, r13);     // Catch: Throwable -> L106
        r22 = r22 + 1;     // Catch: Throwable -> L106
    L52:
        if (r12 != r13) goto L54;
    L103:
        if (r19 == false) goto L139;
    L104:
        ((o) r14).b();
        return r14;
    L139:
        return r14;
    L54:
        if (r12 >= r14.length()) goto L103;
        j.b r26 = new j.b(r18.f1775b.f1798c);     // Catch: Throwable -> L106
        int r27 = Character.codePointAt(r14, r12);     // Catch: Throwable -> L106
        int r28 = 0;
    L57:
        int r29 = r27;
        int r30 = r12;
    L59:
        if (r12 >= r13) goto L81;
        if (r28 >= Integer.MAX_VALUE) goto L81;
        int r31 = r26.a(r29);     // Catch: Throwable -> L106
        if (r31 != 1) goto L63;
        r30 = r30 + Character.charCount(Character.codePointAt(r14, r30));     // Catch: Throwable -> L106
        if (r30 >= r13) goto L79;
        r29 = Character.codePointAt(r14, r30);     // Catch: Throwable -> L106
    L79:
        r12 = r30;
        goto L59
    L63:
        if (r31 != 2) goto L65;
        r12 = r12 + Character.charCount(r29);     // Catch: Throwable -> L106
        if (r12 >= r13) goto L59;
        r29 = Character.codePointAt(r14, r12);     // Catch: Throwable -> L106
        goto L59
    L65:
        if (r31 != 3) goto L59;
        if (r18.c(r14, r30, r12, r26.f1780d.f1801b) == true) goto L72;
        if (r15 != null) goto L71;
        r15 = new q(new SpannableString(r14));     // Catch: Throwable -> L106
    L71:
        androidx.emoji2.text.i r32 = r26.f1780d.f1801b;     // Catch: Throwable -> L106
        r18.f1774a.getClass();     // Catch: Throwable -> L106
        r15.setSpan(new p(r32), r30, r12, 33);     // Catch: Throwable -> L106
        r28 = r28 + 1;     // Catch: Throwable -> L106
    L72:
        r27 = r29;
    L81:
        if (r26.f1777a == 2) goto L83;
    L89:
        if (r8 == false) goto L96;
        if (r28 >= Integer.MAX_VALUE) goto L96;
        if (r18.c(r14, r30, r12, r26.f1779c.f1801b) == true) goto L96;
        if (r15 != null) goto L95;
        r15 = new q(r14);     // Catch: Throwable -> L106
    L95:
        androidx.emoji2.text.i r110 = r26.f1779c.f1801b;     // Catch: Throwable -> L106
        r18.f1774a.getClass();     // Catch: Throwable -> L106
        r15.setSpan(new p(r110), r30, r12, 33);     // Catch: Throwable -> L106
    L96:
        if (r15 == null) goto L101;
        Spannable r111 = r15.f1807b;     // Catch: Throwable -> L106
        if (r19 == false) goto L137;
        ((o) r14).b();
    L137:
        return r111;
    L106:
        th = move-exception;
        if (r19 == false) goto L109;
        ((o) r14).b();
    L109:
        throw th;
    L101:
        if (r19 == true) goto L104;
        return r14;
    L83:
        if (r26.f1779c.f1801b == null) goto L89;
        if (r26.f1782f <= 1) goto L87;
    L88:
        r8 = true;
        goto L89
    L87:
        if (r26.c() == false) goto L89;
    L117:
        if ((r14 instanceof Spannable) == true) goto L40;
        if ((r14 instanceof Spanned) == false) goto L41;
        if (((Spanned) r14).nextSpanTransition(r12 - 1, r13 + 1, k.class) > r13) goto L41;
        r15 = new q(r14);     // Catch: Throwable -> L106
    L110:
        return r14;
    L22:
        r17 = false;
        goto L23
    L18:
        r16 = false;
        goto L19
    L11:
        r11 = false;
        goto L12
    L112:
        throw new IllegalArgumentException("end cannot be negative");
    L114:
        throw new IllegalArgumentException("start cannot be negative");
    L116:
        throw new IllegalStateException("Not initialized yet");
    L5:
        r10 = false;
        goto L6
    }

    public final CharSequence g(CharSequence r8, int r10) {
        return f(0, r10, r8);
    }

    public final void h(e r8) {
        t2.b.n(r8, "initCallback cannot be null");
        this.f1748a.writeLock().lock();
    L12:
        th = move-exception;
        this.f1748a.writeLock().unlock();
        throw th;
    L4:
        if (this.f1750c != 1) goto L6;
    L9:
        Handler r10 = this.f1751d;     // Catch: Throwable -> L12
        int r11 = this.f1750c;     // Catch: Throwable -> L12
        r10.post(new RunnableC0014f(Arrays.asList(new e[]{r8}), r11, null));     // Catch: Throwable -> L12
    L10:
        this.f1748a.writeLock().unlock();
        return;
    L6:
        if (this.f1750c == 2) goto L9;
        this.f1749b.add(r8);     // Catch: Throwable -> L12
        goto L10
    }
}
