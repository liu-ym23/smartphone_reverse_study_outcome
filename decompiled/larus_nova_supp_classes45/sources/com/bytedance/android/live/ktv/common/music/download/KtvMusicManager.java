package com.bytedance.android.live.ktv.common.music.download;

import android.text.TextUtils;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.ktv.common.util.KtvUtilsKt;
import com.bytedance.android.livesdk.message.model.KtvMusic;
import com.bytedance.android.livesdk.message.model.MusicPanel;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class KtvMusicManager {
    public static m a;
    public static long b;
    public static final Lazy c = null;
    public static final w d = null;
    public static final List<Pair<MusicPanel, p.a>> e = null;
    public static final List<Pair<MusicPanel, p.a>> f = null;
    public static final List<w> g = null;
    public static final w h = null;
    public static final CopyOnWriteArrayList<Pair<MusicPanel, p.a>> i = null;
    public static final Function1<String, Boolean> j = null;
    public static com.bytedance.android.live.ktv.common.music.download.e k;
    public static Disposable l;
    public static final KtvMusicManager m = null;

    public static final class a<T> implements ObservableOnSubscribe {
        public final /* synthetic */ boolean a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ p c;
        public final /* synthetic */ MusicPanel d;
        public final /* synthetic */ int e;

        public a(boolean r1, boolean r2, p r3, MusicPanel r4, int r5) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
        }

        public final void subscribe(ObservableEmitter<Integer> r13) {
            Intrinsics.checkNotNullParameter(r13, "it");
            if (this.a == true) goto L5;
            this.d.i.put(Integer.valueOf(this.e), 25);
            r13.onComplete();
            return;
        L5:
            if (this.b == false) goto L7;
            int r0 = 0;
        L8:
            long r5 = System.currentTimeMillis();
            final p r9 = this.c;
            MusicPanel r11 = this.d;
            m r3 = KtvMusicManager.a;
            int r4 = this.e;
            KtvMusic r6 = r11.a;
            v r7 = r9.a;
            if (r7 == null) goto L13;
            if (r6 == null) goto L13;
            String r8 = r7.c(r6);
        L14:
            q r12 = new q(r4, r5, r13, r8);
            if (r9.b == true) goto L50;
            r9.c = r11;
            String r14 = r9.a.c(r11.a);
            r9.b = true;
            String r15 = r9.b(r11.a);     // Catch: Exception -> L38
            if (new PolarisFileWrapper(r15).exists() == false) goto L26;
            r9.b = false;
            PolarisFileWrapper r1 = new PolarisFileWrapper(h.b(r11.a.getId()));
            if (r1.isDirectory() == false) goto L24;
            r1.setLastModified(System.currentTimeMillis());
        L24:
            r12.a(r9.c, r14, r9.a.getType());
            return;
        L26:
            if (TextUtils.isEmpty(r14) == false) goto L28;
            r9.b = false;
            r12.b(r9.c, 101, "url empty");
            return;
        L28:
            Long r16 = Long.valueOf(System.currentTimeMillis());
            r9.d = Downloader.with(s1.getContext()).url(r14).name(h.c(r15)).savePath(h.f(r15)).monitorScene("musicpack_midi");
            Class r17 = p.a();     // Catch: Exception -> L31
            Object r18 = r17.newInstance();     // Catch: Exception -> L31
            Method r19 = r17.getDeclaredMethod("setCacheLifeTimeMax", new Class[0]);     // Catch: Exception -> L31
            r19.setAccessible(true);     // Catch: Exception -> L31
            r19.invoke(r18, new Object[]{1209600});     // Catch: Exception -> L31
        L32:
            r9.d.subThreadListener(new o(r9, r12, r14, r16));
            if (((Boolean) vm2.h.V1.getValue(null, vm2.h.a[150(0x96, float:2.1E-43)])).booleanValue() == false) goto L37;
            r9.d.autoSetHashCodeForSameTask(true);
            if (r0 <= 0) goto L37;
            r9.d.retryCount(r0);
        L37:
            Single.create(new n(r9)).subscribeOn(Schedulers.io()).subscribe(new com.bytedance.android.livesdk.user.h());
            return;
        L38:
            e = move-exception;
            r9.b = false;
            r12.b(r9.c, 100, e.getMessage());
            return;
        L50:
            return;
        L13:
            r8 = null;
            goto L14
        L7:
            r0 = ((Number) vm2.d.L3.getValue(null, vm2.d.a[243(0xf3, float:3.4E-43)])).intValue();
            goto L8
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ w a;
        public final /* synthetic */ MusicPanel b;
        public final /* synthetic */ p.a c;

        public b(w r1, MusicPanel r2, p.a r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void accept(Object r4) {
            Integer r5 = (Integer) r4;
            if ((!this.a.a.isEmpty()) == false) goto L8;
            w r0 = this.a;
            MusicPanel r1 = this.b;
            int r6 = r5.intValue();
            r0.getClass();
            Intrinsics.checkNotNullParameter(r1, "panel");
            Iterator<p.a> r2 = r0.a.iterator();
        L6:
            if (r2.hasNext() == false) goto L11;
            r2.next().c(r1, r6);
            goto L6
        L11:
            return;
        L8:
            this.c.c(this.b, r5.intValue());
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ w a;
        public final /* synthetic */ MusicPanel b;
        public final /* synthetic */ p.a c;
        public final /* synthetic */ boolean d;

        public c(w r1, MusicPanel r2, p.a r3, boolean r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }

        public final void accept(Object r7) {
            Throwable r8 = (Throwable) r7;
            int r1 = 1;
            Throwable r2 = null;
            String r3 = "";
            if ((!this.a.a.isEmpty()) == false) goto L18;
            w r0 = this.a;
            MusicPanel r4 = this.b;
            if ((r8 instanceof DownLoadFailException) == false) goto L8;
            r2 = r8;
        L8:
            DownLoadFailException r5 = (DownLoadFailException) r2;
            if (r5 == null) goto L11;
            r1 = r5.getErrCode();
        L11:
            String r6 = r8.getMessage();
            if (r6 != null) goto L14;
            r6 = "";
        L14:
            r0.getClass();
            Intrinsics.checkNotNullParameter(r4, "panel");
            Iterator<p.a> r9 = r0.a.iterator();
        L16:
            if (r9.hasNext() == false) goto L29;
            r9.next().b(r4, r1, r6);
        L29:
            KtvMusicManager.m.k(this.d);
            StringBuilder r11 = new StringBuilder("toDownloadPanel = ");
            r11.append(this.b);
            r11.append(", download Fail:");
            String r12 = r8.getMessage();
            if (r12 == null) goto L33;
            r3 = r12;
        L33:
            r11.append(r3);
            r.a(r11.toString());
            return;
        L18:
            p.a r13 = this.c;
            MusicPanel r14 = this.b;
            if ((r8 instanceof DownLoadFailException) == false) goto L22;
            r2 = r8;
        L22:
            DownLoadFailException r15 = (DownLoadFailException) r2;
            if (r15 == null) goto L25;
            r1 = r15.getErrCode();
        L25:
            String r16 = r8.getMessage();
            if (r16 != null) goto L28;
            r16 = "";
        L28:
            r13.b(r14, r1, r16);
            goto L29
        }
    }

    public static final class d implements Action {
        public final /* synthetic */ w a;
        public final /* synthetic */ MusicPanel b;
        public final /* synthetic */ p.a c;
        public final /* synthetic */ boolean d;

        public d(w r1, MusicPanel r2, p.a r3, boolean r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }

        public final void run() {
            if ((!this.a.a.isEmpty()) == false) goto L8;
            w r0 = this.a;
            MusicPanel r3 = this.b;
            r0.getClass();
            Intrinsics.checkNotNullParameter(r3, "panel");
            Iterator<p.a> r1 = r0.a.iterator();
        L6:
            if (r1.hasNext() == false) goto L9;
            r1.next().a(r3, null, null);
        L9:
            KtvMusicManager r2 = KtvMusicManager.m;
            KtvMusicManager.i(this.b.a.getMIdStr(), new List[]{KtvMusicManager.e, KtvMusicManager.f, KtvMusicManager.i});
            r2.k(this.d);
            r.a("toDownloadPanel = " + this.b + ", download success");
            return;
        L8:
            this.c.a(this.b, null, null);
            goto L9
        }
    }

    public static final class e<T> implements Consumer {
        public static final e a = null;

        static {
            a = new e();
        }

        public e() {
        }

        public final void accept(Object r2) {
            Long r3 = (Long) r2;
            KtvMusicManager.m.k(false);
        }
    }

    public KtvMusicManager() {
    }

    static {
        m = new KtvMusicManager();
        a = new m(false, false, 63);
        Lazy r0 = LazyKt.lazy(KtvMusicManager$maxDownloaderCount$2.INSTANCE);
        c = r0;
        d = c();
        e = new CopyOnWriteArrayList();
        f = new CopyOnWriteArrayList();
        g = new ArrayList();
        h = c();
        i = new CopyOnWriteArrayList();
        j = KtvMusicManager$causeByNetworkError$1.INSTANCE;
        int r1 = ((Number) r0.getValue()).intValue();
        int r2 = 1;
        if (1 > r1) goto L7;
    L4:
        List<w> r3 = g;
        ArrayList r4 = (ArrayList) r3;
        r4.add(c());
        if (r2 == r1) goto L9;
        r2 = r2 + 1;
        goto L4
    L9:
        return;
    }

    public static w c() {
        return new w(new p(new t()), new p(new com.bytedance.android.live.ktv.common.music.download.d()), new p(new com.bytedance.android.live.ktv.common.music.download.a()), new p(new u()), new p(new y()), new p(new z()));
    }

    public static void d() {
        Disposable r0 = l;
        if (r0 != null) goto L5;
    L7:
        l = null;
        k = null;
        d.f();
        ((CopyOnWriteArrayList) e).clear();
        Iterator r1 = ((ArrayList) g).iterator();
    L9:
        if (r1.hasNext() == false) goto L11;
        ((w) r1.next()).f();
        goto L9
    L11:
        ((CopyOnWriteArrayList) f).clear();
        if (vm2.h.q() == false) goto L14;
        h.f();
        i.clear();
    L14:
        a = new m(false, false, 63);
        b = 0;
        return;
    L5:
        if (r0.isDisposed() == true) goto L7;
        r0.dispose();
        goto L7
    }

    public static boolean g() {
        if (d.a() == true) goto L5;
    L8:
        return true;
    L5:
        if (((CopyOnWriteArrayList) e).isEmpty() == false) goto L8;
        return false;
    }

    public static void j() {
        Disposable r0 = l;
        if (r0 != null) goto L5;
    L7:
        l = null;
        l = Observable.interval(3, TimeUnit.SECONDS).subscribe(e.a);
        return;
    L5:
        if (r0.isDisposed() == true) goto L7;
        r0.dispose();
        goto L7
    }

    public final void l() {
        CopyOnWriteArrayList<Pair<MusicPanel, p.a>> r0 = i;
        if (r0.isEmpty() == false) goto L5;
        return;
    L5:
        Pair<MusicPanel, p.a> r2 = r0.get(0);
        r0.remove(0);
        StringBuilder r1 = new StringBuilder("KtvMusicManager#tryConsumeOneInWifi, start download, songId: ");
        MusicPanel r3 = (MusicPanel) r2.getFirst();
        String r4 = null;
        if (r3 == null) goto L10;
        KtvMusic r5 = r3.a;
        if (r5 == null) goto L10;
        Long r6 = Long.valueOf(r5.getMId());
    L11:
        r1.append(r6.longValue());
        r1.append(", title: ");
        MusicPanel r7 = (MusicPanel) r2.getFirst();
        if (r7 == null) goto L16;
        KtvMusic r8 = r7.a;
        if (r8 == null) goto L16;
        r4 = r8.getMTitle();
    L16:
        r1.append(r4);
        r.a(r1.toString());
        e(this, (MusicPanel) r2.getFirst(), (p.a) r2.getSecond(), true, null, false, 24);
        return;
    L10:
        r6 = null;
        goto L11
    }

    public static void a(final MusicPanel r4) {
        Intrinsics.checkNotNullParameter(r4, "panel");
        w r0 = d;
        if (Intrinsics.areEqual(r0.c(r4), Boolean.TRUE) == false) goto L5;
        r0.f();
    L5:
        CollectionsKt.removeAll(e, new KtvMusicManager$cancelDownload$1(r4));
        Iterator r1 = ((ArrayList) g).iterator();
    L7:
        if (r1.hasNext() == false) goto L11;
        w r2 = (w) r1.next();
        if (Intrinsics.areEqual(r2.c(r4), Boolean.TRUE) == false) goto L7;
        r2.f();
        goto L7
    L11:
        CollectionsKt.removeAll(f, new KtvMusicManager$cancelDownload$3(r4));
        w r3 = h;
        if (Intrinsics.areEqual(r3.c(r4), Boolean.TRUE) == false) goto L14;
        r3.f();
    L14:
        CollectionsKt.removeAll(i, new KtvMusicManager$cancelDownload$4(r4));
    }

    public static boolean h(MusicPanel r5) {
        Intrinsics.checkNotNullParameter(r5, "panel");
        if (d.b(r5.a.getMId()) == false) goto L5;
        return true;
    L5:
        Iterator r0 = ((ArrayList) g).iterator();
    L7:
        if (r0.hasNext() == false) goto L12;
        if (((w) r0.next()).b(r5.a.getMId()) == false) goto L7;
        return true;
    L12:
        if (h.b(r5.a.getMId()) == false) goto L14;
        return true;
    L14:
        return false;
    }

    public final void k(boolean r11) {
        CopyOnWriteArrayList r0 = (CopyOnWriteArrayList) e;
        String r3 = null;
        if ((!r0.isEmpty()) == true) goto L5;
        if (r11 == true) goto L35;
        List<Pair<MusicPanel, p.a>> r12 = f;
        if (((CopyOnWriteArrayList) r12).isEmpty() == true) goto L40;
        Pair r1 = (Pair) ListProtector.get(r12, 0);
        ListProtector.remove(r12, 0);
        StringBuilder r13 = new StringBuilder("KtvMusicManager#tryConsumeOneDefault, start download, songId: ");
        MusicPanel r2 = (MusicPanel) r1.getFirst();
        if (r2 == null) goto L28;
        KtvMusic r4 = r2.a;
        if (r4 == null) goto L28;
        Long r5 = Long.valueOf(r4.getMId());
    L29:
        r13.append(r5.longValue());
        r13.append(", title: ");
        MusicPanel r6 = (MusicPanel) r1.getFirst();
        if (r6 == null) goto L34;
        KtvMusic r7 = r6.a;
        if (r7 == null) goto L34;
        r3 = r7.getMTitle();
    L34:
        r13.append(r3);
        r.a(r13.toString());
        e(this, (MusicPanel) r1.getFirst(), (p.a) r1.getSecond(), false, null, false, 24);
        return;
    L28:
        r5 = null;
        goto L29
    L40:
        return;
    L35:
        l();
        return;
    L5:
        if (r0.isEmpty() == true) goto L39;
        Pair r8 = (Pair) ListProtector.get(r0, 0);
        ListProtector.remove(r0, 0);
        StringBuilder r9 = new StringBuilder("KtvMusicManager#tryConsumeOnePriority, start download, songId: ");
        MusicPanel r14 = (MusicPanel) r8.getFirst();
        if (r14 == null) goto L12;
        KtvMusic r15 = r14.a;
        if (r15 == null) goto L12;
        Long r16 = Long.valueOf(r15.getMId());
    L13:
        r9.append(r16.longValue());
        r9.append(", title: ");
        MusicPanel r17 = (MusicPanel) r8.getFirst();
        if (r17 == null) goto L18;
        KtvMusic r18 = r17.a;
        if (r18 == null) goto L18;
        r3 = r18.getMTitle();
    L18:
        r9.append(r3);
        r.a(r9.toString());
        e(this, (MusicPanel) r8.getFirst(), (p.a) r8.getSecond(), r11, null, true, 8);
        return;
    L12:
        r16 = null;
        goto L13
    }

    public static void i(final String r4, List... r5) {
        int r0 = r5.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        CollectionsKt.removeAll(r5[r1], new KtvMusicManager$removeTaskFromQueues$$inlined$forEach$lambda$1(r4));
        r1 = r1 + 1;
        goto L3
    }

    public static void m(List r8, MusicPanel r9, p.a r11) {
        long r0 = r9.c();
        CopyOnWriteArrayList r12 = (CopyOnWriteArrayList) r8;
        Iterator r2 = r12.iterator();
        int r4 = 0;
    L4:
        if (r2.hasNext() == false) goto L12;
        if (((MusicPanel) ((Pair) r2.next()).getFirst()).c() != r0) goto L8;
        boolean r5 = true;
    L9:
        if (r5 == true) goto L13;
        r4 = r4 + 1;
    L13:
        String r1 = null;
        if (r4 < 0) goto L23;
        ListProtector.set(r12, r4, new Pair(r9, r11));
        StringBuilder r13 = new StringBuilder("KtvMusicManager#updateQueueIfNeeded, replace task, songId: ");
        KtvMusic r14 = r9.a;
        if (r14 == null) goto L18;
        Long r15 = Long.valueOf(r14.getMId());
    L19:
        r13.append(r15.longValue());
        r13.append(", title: ");
        KtvMusic r16 = r9.a;
        if (r16 == null) goto L22;
        r1 = r16.getMTitle();
    L22:
        r13.append(r1);
        r.a(r13.toString());
        return;
    L18:
        r15 = null;
        goto L19
    L23:
        StringBuilder r3 = new StringBuilder("KtvMusicManager#updateQueueIfNeeded, add task, songId: ");
        KtvMusic r6 = r9.a;
        if (r6 == null) goto L26;
        Long r7 = Long.valueOf(r6.getMId());
    L27:
        r3.append(r7.longValue());
        r3.append(", title: ");
        KtvMusic r17 = r9.a;
        if (r17 == null) goto L30;
        r1 = r17.getMTitle();
    L30:
        r3.append(r1);
        r.a(r3.toString());
        r12.add(new Pair(r9, r11));
        return;
    L26:
        r7 = null;
        goto L27
    L8:
        r5 = false;
        goto L9
    L12:
        r4 = -1;
        goto L13
    }

    public final void f(w r23, MusicPanel r24, p.a r25, boolean r26) {
        if (r24.a.getMusicType() != 0) goto L79;
        p r8 = r23.b;
        p r9 = r23.c;
        p r11 = r23.d;
        p r12 = r23.e;
        p r13 = r23.g;
        r23.e(r25);
    L39:
        e = e;
        boolean r16 = false;
    L41:
        boolean r17 = false;
    L42:
        boolean r18 = false;
    L43:
        boolean r19 = false;
    L44:
        r.a("handleDownload ;; errorMessage == " + e.getMessage() + " ;; stackTrace == " + e.getStackTrace());
        String r0 = e.getMessage();
        if (r0 != null) goto L47;
        r0 = "";
    L47:
        r25.b(r24, -1, r0);
    L48:
        boolean r1 = r16;
        boolean r14 = r17;
        boolean r15 = r18;
        boolean r21 = r19;
        boolean r22 = false;
    L50:
        if (a.a == false) goto L55;
        Intrinsics.checkNotNullParameter(r24, "panel");
        if (KtvUtilsKt.m(r24) == false) goto L55;
        r25.a(r24, null, null);
        i(r24.a.getMIdStr(), new List[]{e, f, i});
        k(r26);
        r.a("handleDownload, music has been downloaded, no need to download again: " + r24.a.getMTitle());
        return;
    L55:
        if (r14 == true) goto L63;
        if (r15 == true) goto L63;
        r25.b(r24, -1, "full track and accompaniment track are both empty");
        if (r14 == true) goto L60;
        String r2 = "full_track";
    L61:
        mb0.d.c(r24, r2, "", 0, "full track and accompaniment track are both empty");
        k(r26);
        return;
    L60:
        r2 = "accompaniment_track";
    L63:
        ArrayList r6 = new ArrayList();
        m r110 = a;
        if (r110.d == false) goto L67;
        r6.add(b(r1, 0, r8, r24, r26));
    L67:
        if (r110.b == false) goto L70;
        r6.add(b(r14, 1, r9, r24, r26));
    L70:
        if (r110.c == false) goto L73;
        r6.add(b(r15, 2, r11, r24, r26));
    L73:
        if (r110.e == false) goto L76;
        r6.add(b(r21, 3, r12, r24, r26));
    L76:
        if (r110.f == false) goto L78;
        r6.add(b(r22, 5, r13, r24, r26));
    L78:
        r.a("toDownloadPanel == " + r24 + ", handleDownload,wifiOnly" + r26 + ", config == " + a);
        Observable.merge(r6).observeOn(AndroidSchedulers.mainThread()).subscribe(new b(r23, r24, r25), new c(r23, r24, r25, r26), new d(r23, r24, r25, r26));
        return;
    L7:
        if (KtvUtilsKt.A(r24) == false) goto L9;
        r24.i(r8.b(r24.a));     // Catch: Exception -> L39
        r16 = true;
    L85:
    L14:
        e = e;
        goto L41
    L12:
        if (KtvUtilsKt.G(r24) == false) goto L16;
        String r3 = r9.b(r24.a);     // Catch: Exception -> L14
        Intrinsics.checkNotNullParameter(r3, "<set-?>");     // Catch: Exception -> L14
        r24.n = r3;     // Catch: Exception -> L14
        r17 = true;
    L81:
    L21:
        e = e;
        goto L42
    L19:
        if (KtvUtilsKt.z(r24) == false) goto L23;
        String r4 = r11.b(r24.a);     // Catch: Exception -> L21
        Intrinsics.checkNotNullParameter(r4, "<set-?>");     // Catch: Exception -> L21
        r24.o = r4;     // Catch: Exception -> L21
        r18 = true;
    L84:
    L37:
        e = e;
        goto L43
    L26:
        if (KtvUtilsKt.C(r24) == false) goto L28;
        r24.j(r12.b(r24.a));     // Catch: Exception -> L37
        r19 = true;
    L82:
    L33:
        e = e;
        goto L44
    L31:
        if (KtvUtilsKt.H(r24) == false) goto L35;
        String r5 = r13.b(r24.a);     // Catch: Exception -> L33
        Intrinsics.checkNotNullParameter(r5, "<set-?>");     // Catch: Exception -> L33
        r24.p = r5;     // Catch: Exception -> L33
        r1 = r16;
        r14 = r17;
        r15 = r18;
        r21 = r19;
        r22 = true;
        goto L50
    L35:
        Intrinsics.checkNotNullParameter("", "<set-?>");     // Catch: Exception -> L33
        r24.p = "";     // Catch: Exception -> L33
        goto L48
    L28:
        Intrinsics.checkNotNullParameter("", "<set-?>");     // Catch: Exception -> L37
        r24.q = "";     // Catch: Exception -> L37
        r19 = false;
        goto L82
    L23:
        Intrinsics.checkNotNullParameter("", "<set-?>");     // Catch: Exception -> L21
        r24.o = "";     // Catch: Exception -> L21
        r18 = false;
        goto L84
    L16:
        Intrinsics.checkNotNullParameter("", "<set-?>");     // Catch: Exception -> L14
        r24.n = "";     // Catch: Exception -> L14
        r17 = false;
        goto L81
    L9:
        Intrinsics.checkNotNullParameter("", "<set-?>");     // Catch: Exception -> L39
        r24.l = "";     // Catch: Exception -> L39
        r16 = false;
        goto L85
    L79:
        r.a("handleDownload ;; toDownloadPanel.music.musicType === " + r24.a.getMusicType());
        r25.b(r24, -1, "music type is not support");
        k(r26);
    }

    public static Observable b(boolean r7, int r8, p r9, MusicPanel r11, boolean r12) {
        return Observable.create(new a(r7, r12, r9, r11, r8));
    }

    public static void e(KtvMusicManager r8, final MusicPanel r9, final p.a r11, boolean r12, m r13, boolean r14, int r15) {
        boolean r1 = false;
        int r2 = 0;
        if ((r15 & 4) == 0) goto L6;
        r12 = false;
    L6:
        if ((r15 & 8) == 0) goto L9;
        r13 = new m(false, false, 63);
    L9:
        if ((r15 & 16) == 0) goto L11;
        r14 = false;
    L11:
        r8.getClass();
        Intrinsics.checkNotNullParameter(r9, "panel");
        Intrinsics.checkNotNullParameter(r11, "callback");
        Intrinsics.checkNotNullParameter(r13, "ktvMusicDownloadConfig");
        boolean r3 = true;
        String r4 = null;
        if (r13.a == false) goto L16;
        Intrinsics.checkNotNullParameter(r9, "panel");
        if (KtvUtilsKt.m(r9) == false) goto L16;
        r11.a(r9, null, null);
        i(r9.a.getMIdStr(), new List[]{e, f, i});
        r.a("music has been downloaded, no need to download again : " + r9.a.getMTitle());
        r8.k(r12);
        return;
    L16:
        a = r13;
        if (r14 == false) goto L23;
        Iterator r16 = ((ArrayList) g).iterator();
    L20:
        if (r16.hasNext() == false) goto L22;
        ((w) r16.next()).d();
        goto L20
    L22:
        h.d();
    L23:
        KtvMusicManager r17 = m;
        if (r14 == true) goto L43;
        if (g() == true) goto L43;
        List<w> r18 = g;
        List<Pair<MusicPanel, p.a>> r0 = f;
        Iterator r19 = ((ArrayList) r18).iterator();
    L29:
        if (r19.hasNext() == false) goto L36;
        Pair<Boolean, MusicPanel> r5 = ((w) r19.next()).g();
        boolean r6 = ((Boolean) r5.component1()).booleanValue();
        MusicPanel r7 = (MusicPanel) r5.component2();
        if (r6 == true) goto L29;
        if (r7 == null) goto L29;
        if (h(r7) == true) goto L29;
        m(r0, r7, r11);
        goto L29
    L36:
        Pair<Boolean, MusicPanel> r110 = h.g();
        boolean r21 = ((Boolean) r110.component1()).booleanValue();
        MusicPanel r111 = (MusicPanel) r110.component2();
        if (r21 == true) goto L43;
        if (r111 == null) goto L43;
        if (h(r111) == true) goto L43;
        m(i, r111, r11);
    L43:
        if (r14 == false) goto L54;
        w r22 = d;
        if (r22.b(r9.a.getMId()) == false) goto L54;
        r22.e(r11);
        StringBuilder r23 = new StringBuilder("KtvMusicManager#download, priorityDownloader: ");
        r23.append(r22);
        r23.append(" registerCallback , songId: ");
        KtvMusic r112 = r9.a;
        if (r112 == null) goto L49;
        Long r113 = Long.valueOf(r112.getMId());
    L50:
        r23.append(r113.longValue());
        r23.append(", title: ");
        KtvMusic r24 = r9.a;
        if (r24 == null) goto L53;
        r4 = r24.getMTitle();
    L53:
        r23.append(r4);
        r.a(r23.toString());
        return;
    L49:
        r113 = null;
    L54:
        if (r14 == false) goto L56;
    L79:
        StringBuilder r25 = new StringBuilder("KtvMusicManager# start download, openPriorityDownload: ");
        r25.append(r14);
        r25.append(" , wifiOnly: ");
        r25.append(r12);
        r25.append(", songId: ");
        KtvMusic r26 = r9.a;
        if (r26 == null) goto L82;
        Long r27 = Long.valueOf(r26.getMId());
    L83:
        r25.append(r27.longValue());
        r25.append(", title: ");
        KtvMusic r28 = r9.a;
        if (r28 == null) goto L86;
        String r29 = r28.getMTitle();
    L87:
        r25.append(r29);
        r.a(r25.toString());
        if (r14 == false) goto L137;
        List<Pair<MusicPanel, p.a>> r114 = e;
        long r115 = r9.c();
        if ((r114 instanceof Collection) == true) goto L92;
    L94:
        Iterator r116 = ((CopyOnWriteArrayList) r114).iterator();
    L96:
        if (r116.hasNext() == false) goto L103;
        if (((MusicPanel) ((Pair) r116.next()).getFirst()).a.getMId() != r115) goto L100;
        boolean r31 = true;
    L101:
        if (r31 == false) goto L96;
    L104:
        if (r3 == false) goto L123;
        Iterator r32 = ((CopyOnWriteArrayList) e).iterator();
    L107:
        if (r32.hasNext() == false) goto L115;
        Object r117 = r32.next();
        int r118 = r2 + 1;
        if (r2 >= 0) goto L112;
        CollectionsKt.throwIndexOverflow();
    L112:
        if (((MusicPanel) ((Pair) r117).getFirst()).a.getMId() != r9.c()) goto L114;
        ListProtector.set(e, r2, new Pair(r9, r11));
    L114:
        r2 = r118;
        goto L107
    L115:
        StringBuilder r33 = new StringBuilder("KtvMusicManager#download, is in queue, so update callback, songId: ");
        KtvMusic r119 = r9.a;
        if (r119 == null) goto L118;
        Long r120 = Long.valueOf(r119.getMId());
    L119:
        r33.append(r120.longValue());
        r33.append(", title: ");
        KtvMusic r34 = r9.a;
        if (r34 == null) goto L122;
        r4 = r34.getMTitle();
    L122:
        r33.append(r4);
        r.a(r33.toString());
        return;
    L118:
        r120 = null;
        goto L119
    L123:
        w r121 = d;
        if (r121.a() == false) goto L128;
        r121.f();
        r8.f(r121, r9, r11, false);
        if (r3 == false) goto L271;
        CollectionsKt.removeAll(e, new KtvMusicManager$tryDownloadMusicWithPriority$2(r9));
        return;
    L271:
        return;
    L128:
        if (r3 == true) goto L273;
        StringBuilder r35 = new StringBuilder("KtvMusicManager#download, add priority queue, songId: ");
        KtvMusic r122 = r9.a;
        if (r122 == null) goto L132;
        Long r123 = Long.valueOf(r122.getMId());
    L133:
        r35.append(r123.longValue());
        r35.append(", title: ");
        KtvMusic r124 = r9.a;
        if (r124 == null) goto L136;
        r4 = r124.getMTitle();
    L136:
        r35.append(r4);
        r.a(r35.toString());
        ((CopyOnWriteArrayList) e).add(new Pair(r9, r11));
        return;
    L132:
        r123 = null;
        goto L133
    L273:
        return;
    L100:
        r31 = false;
    L103:
        r3 = false;
        goto L104
    L92:
        if (((CopyOnWriteArrayList) r114).isEmpty() == false) goto L94;
    L137:
        if (r12 == true) goto L195;
        w r125 = h;
        if (r125.b(r9.a.getMId()) == false) goto L141;
        CollectionsKt.removeAll(i, new KtvMusicManager$tryDownloadMusicWithDefault$1(r9));
        r125.f();
        r8.l();
    L158:
        final Ref.BooleanRef r36 = new Ref.BooleanRef();
        r36.element = false;
        List<Pair<MusicPanel, p.a>> r126 = f;
        if ((r126 instanceof Collection) == true) goto L161;
    L163:
        Iterator r127 = ((CopyOnWriteArrayList) r126).iterator();
    L165:
        if (r127.hasNext() == false) goto L172;
        if (((MusicPanel) ((Pair) r127.next()).getFirst()).a.getMId() != r9.a.getMId()) goto L169;
        boolean r128 = true;
    L170:
        if (r128 == false) goto L165;
        final boolean r129 = true;
    L174:
        if (g() == true) goto L185;
        Iterator r130 = ((ArrayList) g).iterator();
    L178:
        if (r130.hasNext() == false) goto L185;
        w r37 = (w) r130.next();
        if (r37.a() == false) goto L178;
        r37.f();
        r17.f(r37, r9, r11, false);
        r36.element = true;
        if (r129 == false) goto L185;
        CollectionsKt.removeAll(f, new KtvMusicManager$tryDownloadMusicWithDefault$$inlined$run$lambda$1(r9, r11, r36, r129));
    L185:
        if (r36.element == true) goto L275;
        if (r129 == true) goto L276;
        StringBuilder r38 = new StringBuilder("KtvMusicManager#download, add download queue, songId: ");
        KtvMusic r131 = r9.a;
        if (r131 == null) goto L190;
        Long r132 = Long.valueOf(r131.getMId());
    L191:
        r38.append(r132.longValue());
        r38.append(", title: ");
        KtvMusic r133 = r9.a;
        if (r133 == null) goto L194;
        r4 = r133.getMTitle();
    L194:
        r38.append(r4);
        r.a(r38.toString());
        ((CopyOnWriteArrayList) f).add(new Pair(r9, r11));
        return;
    L190:
        r132 = null;
        goto L191
    L276:
        return;
    L275:
        return;
    L169:
        r128 = false;
    L172:
        r129 = false;
        goto L174
    L161:
        if (((CopyOnWriteArrayList) r126).isEmpty() == false) goto L163;
    L141:
        CopyOnWriteArrayList<Pair<MusicPanel, p.a>> r39 = i;
        if ((r39 instanceof Collection) == true) goto L144;
    L146:
        Iterator<Pair<MusicPanel, p.a>> r41 = r39.iterator();
    L148:
        if (r41.hasNext() == false) goto L155;
        if (((MusicPanel) r41.next().getFirst()).a.getMId() != r9.a.getMId()) goto L152;
        boolean r134 = true;
    L153:
        if (r134 == false) goto L148;
        boolean r42 = true;
    L156:
        if (r42 == false) goto L158;
        CollectionsKt.removeAll(i, new KtvMusicManager$tryDownloadMusicWithDefault$3(r9));
        goto L158
    L152:
        r134 = false;
    L155:
        r42 = false;
        goto L156
    L144:
        if (r39.isEmpty() == false) goto L146;
    L195:
        CopyOnWriteArrayList<Pair<MusicPanel, p.a>> r135 = i;
        if ((r135 instanceof Collection) == true) goto L198;
    L200:
        Iterator<Pair<MusicPanel, p.a>> r136 = r135.iterator();
    L202:
        if (r136.hasNext() == false) goto L209;
        if (((MusicPanel) r136.next().getFirst()).a.getMId() != r9.a.getMId()) goto L206;
        boolean r137 = true;
    L207:
        if (r137 == false) goto L202;
        boolean r138 = true;
    L211:
        if (g() == true) goto L214;
        r1 = h.a();
    L214:
        if (r1 == false) goto L218;
        w r139 = h;
        r139.f();
        r8.f(r139, r9, r11, true);
        if (r138 == false) goto L278;
        CollectionsKt.removeAll(i, new KtvMusicManager$tryDownloadMusicWithWifi$1(r9));
        return;
    L278:
        return;
    L218:
        if (r138 == true) goto L280;
        StringBuilder r43 = new StringBuilder("KtvMusicManager#download, add wifi queue, songId: ");
        KtvMusic r140 = r9.a;
        if (r140 == null) goto L222;
        Long r141 = Long.valueOf(r140.getMId());
    L223:
        r43.append(r141.longValue());
        r43.append(", title: ");
        KtvMusic r142 = r9.a;
        if (r142 == null) goto L226;
        r4 = r142.getMTitle();
    L226:
        r43.append(r4);
        r.a(r43.toString());
        i.add(new Pair(r9, r11));
        return;
    L222:
        r141 = null;
        goto L223
    L280:
        return;
    L206:
        r137 = false;
    L209:
        r138 = false;
        goto L211
    L198:
        if (r135.isEmpty() == false) goto L200;
    L86:
        r29 = null;
        goto L87
    L82:
        r27 = null;
        goto L83
    L56:
        if (h(r9) == false) goto L79;
        w r44 = d;
        if (r44.b(r9.a.getMId()) == true) goto L70;
        Iterator r45 = ((ArrayList) g).iterator();
    L62:
        if (r45.hasNext() == false) goto L66;
        w r46 = (w) r45.next();
        if (r46.b(r9.a.getMId()) == false) goto L62;
        r44 = r46;
        goto L70
    L66:
        r44 = h;
        if (r44.b(r9.a.getMId()) == true) goto L70;
        r44 = null;
    L70:
        if (r44 == null) goto L79;
        r44.e(r11);
        StringBuilder r47 = new StringBuilder("KtvMusicManager#download, downloader: ");
        r47.append(r44);
        r47.append(" registerCallback, songId: ");
        KtvMusic r143 = r9.a;
        if (r143 == null) goto L74;
        Long r144 = Long.valueOf(r143.getMId());
    L75:
        r47.append(r144.longValue());
        r47.append(", title: ");
        KtvMusic r48 = r9.a;
        if (r48 == null) goto L78;
        r4 = r48.getMTitle();
    L78:
        r47.append(r4);
        r.a(r47.toString());
        return;
    L74:
        r144 = null;
        goto L75
    }
}
