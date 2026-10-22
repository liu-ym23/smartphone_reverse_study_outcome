package com.ss.android.socialbase.downloader.impls;

import android.util.Log;
import com.ss.android.socialbase.downloader.constants.ListenerType;
import com.ss.android.socialbase.downloader.depend.IDownloadListener;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes3.dex */
public abstract class BaseDownloadEngine extends AbsDownloadEngine {

    /* JADX INFO: renamed from: com.ss.android.socialbase.downloader.impls.BaseDownloadEngine$1, reason: invalid class name */
    class AnonymousClass1 implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DownloadTask f15646a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ BaseDownloadEngine f15647b;

        public AnonymousClass1(BaseDownloadEngine r5, DownloadTask r10) {
            this.f15647b = r5;
            this.f15646a = r10;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f15647b.d(this.f15646a);
        }
    }

    /* JADX INFO: renamed from: com.ss.android.socialbase.downloader.impls.BaseDownloadEngine$11, reason: invalid class name */
    class AnonymousClass11 implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f15651a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f15652b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ IDownloadListener f15653c;
        public final /* synthetic */ ListenerType d;
        public final /* synthetic */ boolean e;
        public final /* synthetic */ boolean f;
        public final /* synthetic */ BaseDownloadEngine g;

        public AnonymousClass11(BaseDownloadEngine r5, int r10, int r11, IDownloadListener r12, ListenerType r13, boolean r14, boolean r15) {
            this.g = r5;
            this.f15651a = r10;
            this.f15652b = r11;
            this.f15653c = r12;
            this.d = r13;
            this.e = r14;
            this.f = r15;
        }

        @Override // java.lang.Runnable
        public final void run() {
            BaseDownloadEngine r5 = this.g;
            int r10 = this.f15651a;
            int r11 = this.f15652b;
            final IDownloadListener r12 = this.f15653c;
            final ListenerType r13 = this.d;
            boolean r14 = this.e;
            boolean r15 = this.f;
            NewDownloadEngine r16 = (NewDownloadEngine) r5;
            final DownloadTask r17 = r16.r(r10);
            if (r17 == null) goto L20;
            r17.a(r11, r12, r13, r14);
            final DownloadInfo r18 = r17.f15878a;
            if (r15 == false) goto L29;
            if (r18 != null) goto L8;
            return;
        L8:
            if (r16.i(r10) == false) goto L10;
            return;
        L10:
            if (r13 == ListenerType.f15280a) goto L14;
            if (r13 == ListenerType.f15282c) goto L14;
            return;
        L14:
            if (r13 == ListenerType.f15282c) goto L16;
        L18:
            final int r19 = r18.o();
            r16.f15711t.post(new NewDownloadEngine.AnonymousClass2(r12, r19, r18, r17, r13));
            return;
        L16:
            if (r18.b() == true) goto L18;
            return;
        L29:
            return;
        L20:
            DownloadInfo r20 = r16.s.a(r10);
            if (r20 != null) goto L23;
            return;
        L23:
            if (r20.o() == (-3)) goto L34;
            DownloadTask r21 = (DownloadTask) r16.f15709q.get(Integer.valueOf(r10));
            if (r21 != null) goto L27;
            r21 = new DownloadTask();
            r21.f15878a = r20;
            r16.f15709q.put(Integer.valueOf(r10), r21);
        L27:
            r21.a(r11, r12, r13, r14);
            return;
        }
    }

    /* JADX INFO: renamed from: com.ss.android.socialbase.downloader.impls.BaseDownloadEngine$9, reason: invalid class name */
    class AnonymousClass9 implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f15669a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f15670b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f15671c;
        public final /* synthetic */ BaseDownloadEngine d;

        public AnonymousClass9(BaseDownloadEngine r5, int r10, int r11, int r12) {
            this.d = r5;
            this.f15669a = r10;
            this.f15670b = r11;
            this.f15671c = r12;
        }

        @Override // java.lang.Runnable
        public final void run() {
            BaseDownloadEngine r5 = this.d;
            int r10 = this.f15669a;
            int r11 = this.f15670b;
            int r12 = this.f15671c;
            NewDownloadEngine r13 = (NewDownloadEngine) r5;
            r13.getClass();
            if (r12 != (-7)) goto L5;
        L34:
            DownloadTask r14 = (DownloadTask) r13.f15704l.get(Integer.valueOf(r10));
            if (r14 != null) goto L37;
        L40:
            r13.s(r10);
            return;
        L37:
            if (r13.f15706n.get(Integer.valueOf(r10)) != null) goto L39;
            r13.f15706n.put(Integer.valueOf(r10), r14);
        L39:
            r13.c(r10, r11);
            goto L40
        L5:
            if (r12 != (-6)) goto L7;
            DownloadTask r15 = (DownloadTask) r13.f15704l.get(Integer.valueOf(r10));
            if (r15 == null) goto L32;
            r13.f15705m.put(Integer.valueOf(r10), r15);
        L32:
            r13.c(r10, r11);
            return;
        L7:
            if (r12 != (-4)) goto L9;
            r13.c(r10, r11);
            r13.s(r10);
            return;
        L9:
            if (r12 != (-3)) goto L11;
            DownloadTask r16 = (DownloadTask) r13.f15704l.get(Integer.valueOf(r10));
            if (r16 == null) goto L25;
            r13.f15705m.put(Integer.valueOf(r10), r16);
        L25:
            r13.c(r10, r11);
            r13.s(r10);
            return;
        L11:
            if (r12 == (-1)) goto L34;
            if (r12 == 8) goto L15;
            return;
        L15:
            DownloadTask r17 = (DownloadTask) r13.f15704l.get(Integer.valueOf(r10));
            if (r17 != null) goto L18;
        L20:
            r13.s(r10);
            return;
        L18:
            if (r13.f15707o.get(Integer.valueOf(r10)) != null) goto L20;
            r13.f15707o.put(Integer.valueOf(r10), r17);
            goto L20
        }
    }

    public BaseDownloadEngine() {
    }

    @Override // com.ss.android.socialbase.downloader.impls.AbsDownloadEngine
    public final void a(final int r10, final boolean r11) {
        if (Logger.b() == false) goto L5;
        Logger.a("BaseDownloadEngine", r10, null, "cancel", "Trace:" + Log.getStackTraceString(new Throwable()), false);
    L5:
        a(new AnonymousClass3(this, r10, r11));
    }

    @Override // com.ss.android.socialbase.downloader.impls.AbsDownloadEngine
    public final void b(DownloadTask r5) {
        a(new AnonymousClass1(this, r5));
    }

    public abstract void d(DownloadTask r5);

    @Override // com.ss.android.socialbase.downloader.impls.AbsDownloadEngine
    public final void k(final int r10) {
        if (Logger.b() == false) goto L5;
        Logger.a("BaseDownloadEngine", r10, null, "pause", "Trace:" + Log.getStackTraceString(new Throwable()), false);
    L5:
        a(new AnonymousClass2(this, r10));
    }

    @Override // com.ss.android.socialbase.downloader.impls.AbsDownloadEngine
    public final void n(final int r10) {
        if (Logger.b() == false) goto L5;
        Logger.a("BaseDownloadEngine", r10, null, "restart", "Trace:" + Log.getStackTraceString(new Throwable()), false);
    L5:
        a(new AnonymousClass5(this, r10));
    }

    @Override // com.ss.android.socialbase.downloader.impls.AbsDownloadEngine
    public final void o(final int r5) {
        a(new AnonymousClass6(this, r5));
    }

    @Override // com.ss.android.socialbase.downloader.impls.AbsDownloadEngine
    public final void p(final int r10) {
        if (Logger.b() == false) goto L5;
        Logger.a("BaseDownloadEngine", r10, null, "resume", "Trace:" + Log.getStackTraceString(new Throwable()), false);
    L5:
        a(new AnonymousClass4(this, r10));
    }

    @Override // com.ss.android.socialbase.downloader.impls.AbsDownloadEngine
    public final void b(final ArrayList r5) {
        a(new AnonymousClass8(this, r5));
    }

    @Override // com.ss.android.socialbase.downloader.impls.AbsDownloadEngine
    public final void b(final int r10, final long r11, final int r12) {
        a(new AnonymousClass10(this, r10, r11, r12));
    }

    @Override // com.ss.android.socialbase.downloader.impls.AbsDownloadEngine
    public final void a(final ArrayList r5) {
        a(new AnonymousClass7(this, r5));
    }

    @Override // com.ss.android.socialbase.downloader.impls.AbsDownloadEngine
    public final void a(int r5, int r10, int r11) {
        a(new AnonymousClass9(this, r5, r10, r11));
    }

    @Override // com.ss.android.socialbase.downloader.impls.AbsDownloadEngine
    public final void a(int r10, int r11, IDownloadListener r12, ListenerType r13, boolean r14, boolean r15) {
        a(new AnonymousClass11(this, r10, r11, r12, r13, r14, r15));
    }

    public static void a(Runnable r5) {
        if ("DTP-Single".equals(Thread.currentThread().getName()) == false) goto L6;
        r5.run();
        return;
    L6:
        DownloadComponentManager.b(r5);
    }
}
