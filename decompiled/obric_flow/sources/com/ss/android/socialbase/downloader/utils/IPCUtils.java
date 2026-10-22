package com.ss.android.socialbase.downloader.utils;

import android.os.Handler;
import android.os.Looper;
import android.os.RemoteException;
import androidx.core.view.PointerIconCompat;
import com.ss.android.socialbase.downloader.constants.ListenerType;
import com.ss.android.socialbase.downloader.depend.AbsDownloadMonitorDepend;
import com.ss.android.socialbase.downloader.depend.IDownloadAidlDepend;
import com.ss.android.socialbase.downloader.depend.IDownloadAidlFileProvider;
import com.ss.android.socialbase.downloader.depend.IDownloadAidlInterceptor;
import com.ss.android.socialbase.downloader.depend.IDownloadAidlListener;
import com.ss.android.socialbase.downloader.depend.IDownloadAidlMonitorDepend;
import com.ss.android.socialbase.downloader.depend.IDownloadCompleteAidlHandler;
import com.ss.android.socialbase.downloader.depend.IDownloadCompleteHandler;
import com.ss.android.socialbase.downloader.depend.IDownloadDepend;
import com.ss.android.socialbase.downloader.depend.IDownloadDiskSpaceAidlCallback;
import com.ss.android.socialbase.downloader.depend.IDownloadDiskSpaceAidlHandler;
import com.ss.android.socialbase.downloader.depend.IDownloadDiskSpaceCallback;
import com.ss.android.socialbase.downloader.depend.IDownloadDiskSpaceHandler;
import com.ss.android.socialbase.downloader.depend.IDownloadExtListener;
import com.ss.android.socialbase.downloader.depend.IDownloadFileUriProvider;
import com.ss.android.socialbase.downloader.depend.IDownloadForbiddenAidlCallback;
import com.ss.android.socialbase.downloader.depend.IDownloadForbiddenAidlHandler;
import com.ss.android.socialbase.downloader.depend.IDownloadForbiddenCallback;
import com.ss.android.socialbase.downloader.depend.IDownloadForbiddenHandler;
import com.ss.android.socialbase.downloader.depend.IDownloadInterceptor;
import com.ss.android.socialbase.downloader.depend.IDownloadListener;
import com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventAidlListener;
import com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventListener;
import com.ss.android.socialbase.downloader.depend.INotificationClickAidlCallback;
import com.ss.android.socialbase.downloader.depend.INotificationClickCallback;
import com.ss.android.socialbase.downloader.depend.ProcessAidlCallback;
import com.ss.android.socialbase.downloader.depend.ProcessCallback;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadAidlTask;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public abstract class IPCUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Handler f16145a = null;

    /* JADX INFO: renamed from: com.ss.android.socialbase.downloader.utils.IPCUtils$13, reason: invalid class name */
    final class AnonymousClass13 implements IDownloadNotificationEventListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ IDownloadNotificationEventAidlListener f16150a;

        public AnonymousClass13(IDownloadNotificationEventAidlListener r5) {
            this.f16150a = r5;
        }
    }

    /* JADX INFO: renamed from: com.ss.android.socialbase.downloader.utils.IPCUtils$14, reason: invalid class name */
    final class AnonymousClass14 implements IDownloadCompleteHandler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ IDownloadCompleteAidlHandler f16151a;

        public AnonymousClass14(IDownloadCompleteAidlHandler r5) {
            this.f16151a = r5;
        }

        @Override // com.ss.android.socialbase.downloader.depend.IDownloadCompleteHandler
        public final void e(DownloadInfo r5) {
            this.f16151a.e(r5);     // Catch: RemoteException -> L4
            return;
        L4:
            e = move-exception;
            throw new BaseException(PointerIconCompat.TYPE_TEXT, DownloadUtils.a(e));
        }

        @Override // com.ss.android.socialbase.downloader.depend.IDownloadCompleteHandler
        public final boolean k(DownloadInfo r5) {
            return this.f16151a.k(r5);
        L4:
            e = move-exception;
            e.printStackTrace();
            return false;
        }
    }

    /* JADX INFO: renamed from: com.ss.android.socialbase.downloader.utils.IPCUtils$17, reason: invalid class name */
    final class AnonymousClass17 implements IDownloadDepend {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ IDownloadAidlDepend f16154a;

        public AnonymousClass17(IDownloadAidlDepend r5) {
            this.f16154a = r5;
        }

        @Override // com.ss.android.socialbase.downloader.depend.IDownloadDepend
        public final void a(DownloadInfo r5, BaseException r10, int r11) {
            if (r5 == null) goto L11;
            this.f16154a.a(r5, r10, r11);     // Catch: RemoteException -> L6
            return;
        L6:
            e = move-exception;
            e.printStackTrace();
            return;
        }
    }

    /* JADX INFO: renamed from: com.ss.android.socialbase.downloader.utils.IPCUtils$18, reason: invalid class name */
    final class AnonymousClass18 extends AbsDownloadMonitorDepend {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ IDownloadAidlMonitorDepend f16155a;

        public AnonymousClass18(IDownloadAidlMonitorDepend r5) {
            this.f16155a = r5;
        }

        @Override // com.ss.android.socialbase.downloader.depend.IDownloadMonitorDepend
        public final void a(JSONObject r5) {
            this.f16155a.e(r5.toString());     // Catch: RemoteException -> L4
            return;
        L4:
            e = move-exception;
            e.printStackTrace();
        }

        @Override // com.ss.android.socialbase.downloader.depend.IDownloadMonitorDepend
        public final String g() {
            return this.f16155a.g();
        L4:
            e = move-exception;
            e.printStackTrace();
            return "";
        }

        @Override // com.ss.android.socialbase.downloader.depend.AbsDownloadMonitorDepend
        public final int[] a() {
            return this.f16155a.l();
        L4:
            e = move-exception;
            e.printStackTrace();
            return null;
        }
    }

    /* JADX INFO: renamed from: com.ss.android.socialbase.downloader.utils.IPCUtils$19, reason: invalid class name */
    final class AnonymousClass19 implements IDownloadForbiddenHandler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ IDownloadForbiddenAidlHandler f16156a;

        public AnonymousClass19(IDownloadForbiddenAidlHandler r5) {
            this.f16156a = r5;
        }

        @Override // com.ss.android.socialbase.downloader.depend.IDownloadForbiddenHandler
        public final boolean a(final IDownloadForbiddenCallback r5) {
            IDownloadForbiddenAidlHandler r10 = this.f16156a;     // Catch: RemoteException -> L8
            Handler r11 = IPCUtils.f16145a;     // Catch: RemoteException -> L8
            if (r5 != null) goto L5;
            IDownloadForbiddenAidlCallback.Stub r12 = null;
        L6:
            return r10.a(r12);
        L5:
            r12 = new AnonymousClass20(r5);     // Catch: RemoteException -> L8
        L8:
            e = move-exception;
            e.printStackTrace();
            return false;
        }
    }

    /* JADX INFO: renamed from: com.ss.android.socialbase.downloader.utils.IPCUtils$23, reason: invalid class name */
    final class AnonymousClass23 implements IDownloadDiskSpaceHandler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ IDownloadDiskSpaceAidlHandler f16189a;

        public AnonymousClass23(IDownloadDiskSpaceAidlHandler r5) {
            this.f16189a = r5;
        }

        @Override // com.ss.android.socialbase.downloader.depend.IDownloadDiskSpaceHandler
        public final boolean a(long r10, long r11, final IDownloadDiskSpaceCallback r12) {
            IDownloadDiskSpaceAidlHandler r5 = this.f16189a;     // Catch: RemoteException -> L9
            Handler r13 = IPCUtils.f16145a;     // Catch: RemoteException -> L9
            if (r12 != null) goto L6;
            IDownloadDiskSpaceAidlCallback.Stub r14 = null;
        L7:
            return r5.a(r10, r11, r14);
        L6:
            r14 = new AnonymousClass24(r12);     // Catch: RemoteException -> L9
        L9:
            e = move-exception;
            e.printStackTrace();
            return false;
        }
    }

    /* JADX INFO: renamed from: com.ss.android.socialbase.downloader.utils.IPCUtils$26, reason: invalid class name */
    final class AnonymousClass26 implements IDownloadFileUriProvider {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ IDownloadAidlFileProvider f16192a;

        public AnonymousClass26(IDownloadAidlFileProvider r5) {
            this.f16192a = r5;
        }
    }

    /* JADX INFO: renamed from: com.ss.android.socialbase.downloader.utils.IPCUtils$27, reason: invalid class name */
    final class AnonymousClass27 implements IDownloadExtListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ IDownloadAidlListener f16193a;

        public AnonymousClass27(IDownloadAidlListener r5) {
            this.f16193a = r5;
        }

        public final void a(DownloadInfo r5) {
            this.f16193a.p(r5);     // Catch: RemoteException -> L4
            return;
        L4:
            e = move-exception;
            e.printStackTrace();
        }

        @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
        public final void b(DownloadInfo r5, BaseException r10) {
            this.f16193a.b(r5, r10);     // Catch: RemoteException -> L4
            return;
        L4:
            e = move-exception;
            e.printStackTrace();
        }

        @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
        public final void c(DownloadInfo r5, BaseException r10) {
            this.f16193a.c(r5, r10);     // Catch: RemoteException -> L4
            return;
        L4:
            e = move-exception;
            e.printStackTrace();
        }

        @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
        public final void d(DownloadInfo r5) {
            this.f16193a.d(r5);     // Catch: RemoteException -> L4
            return;
        L4:
            e = move-exception;
            e.printStackTrace();
        }

        @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
        public final void f(DownloadInfo r5) {
            this.f16193a.f(r5);     // Catch: RemoteException -> L4
            return;
        L4:
            e = move-exception;
            e.printStackTrace();
        }

        @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
        public final void g(DownloadInfo r5) {
            this.f16193a.g(r5);     // Catch: RemoteException -> L4
            return;
        L4:
            e = move-exception;
            e.printStackTrace();
        }

        @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
        public final void i(DownloadInfo r5) {
            this.f16193a.i(r5);     // Catch: RemoteException -> L4
            return;
        L4:
            e = move-exception;
            e.printStackTrace();
        }

        @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
        public final void j(DownloadInfo r5) {
            this.f16193a.j(r5);     // Catch: RemoteException -> L4
            return;
        L4:
            e = move-exception;
            e.printStackTrace();
        }

        @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
        public final void l(DownloadInfo r5) {
            this.f16193a.l(r5);     // Catch: RemoteException -> L4
            return;
        L4:
            e = move-exception;
            e.printStackTrace();
        }

        @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
        public final void m(DownloadInfo r5) {
            this.f16193a.m(r5);     // Catch: RemoteException -> L4
            return;
        L4:
            e = move-exception;
            e.printStackTrace();
        }

        @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
        public final void n(DownloadInfo r5) {
            this.f16193a.n(r5);     // Catch: RemoteException -> L4
            return;
        L4:
            e = move-exception;
            e.printStackTrace();
        }

        @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
        public final void a(DownloadInfo r5, BaseException r10) {
            this.f16193a.a(r5, r10);     // Catch: RemoteException -> L4
            return;
        L4:
            e = move-exception;
            e.printStackTrace();
        }
    }

    static {
        f16145a = new Handler(Looper.getMainLooper());
    }

    public static DownloadAidlTask a(final DownloadTask r5) {
        if (r5 != null) goto L6;
        return null;
    L6:
        return new AnonymousClass1(r5);
    }

    public static IDownloadAidlListener a(final IDownloadListener r5, final boolean r10) {
        if (r5 != null) goto L6;
        return null;
    L6:
        return new AnonymousClass2(r5, r10);
    }

    public static IDownloadNotificationEventAidlListener a(final IDownloadNotificationEventListener r5) {
        if (r5 != null) goto L6;
        return null;
    L6:
        return new AnonymousClass3(r5);
    }

    public static INotificationClickAidlCallback a(final INotificationClickCallback r5) {
        if (r5 != null) goto L6;
        return null;
    L6:
        return new AnonymousClass4(r5);
    }

    public static IDownloadAidlFileProvider a(final IDownloadFileUriProvider r5) {
        if (r5 != null) goto L6;
        return null;
    L6:
        return new AnonymousClass6(r5);
    }

    public static DownloadTask a(DownloadAidlTask r10) {
        if (r10 != null) goto L68;
        return null;
    L68:
        DownloadInfo r5 = r10.m();     // Catch: RemoteException -> L36
        DownloadTask r11 = new DownloadTask();     // Catch: RemoteException -> L36
        r11.f15878a = r5;     // Catch: RemoteException -> L36
        r11.g = a(r10.s());     // Catch: RemoteException -> L36
        final IDownloadAidlInterceptor r12 = r10.p();     // Catch: RemoteException -> L36
        if (r12 != null) goto L8;
        IDownloadInterceptor r13 = null;
    L9:
        r11.f15881h = r13;     // Catch: RemoteException -> L36
        IDownloadAidlDepend r14 = r10.u();     // Catch: RemoteException -> L36
        if (r14 != null) goto L12;
        AnonymousClass17 r15 = null;
    L13:
        r11.f15882i = r15;     // Catch: RemoteException -> L36
        IDownloadAidlMonitorDepend r16 = r10.r();     // Catch: RemoteException -> L36
        if (r16 != null) goto L16;
        AnonymousClass18 r17 = null;
    L17:
        r11.f15883j = r17;     // Catch: RemoteException -> L36
        IDownloadForbiddenAidlHandler r18 = r10.o();     // Catch: RemoteException -> L36
        if (r18 != null) goto L20;
        AnonymousClass19 r19 = null;
    L21:
        r11.f15885l = r19;     // Catch: RemoteException -> L36
        IDownloadDiskSpaceAidlHandler r20 = r10.q();     // Catch: RemoteException -> L36
        if (r20 != null) goto L24;
        AnonymousClass23 r21 = null;
    L25:
        r11.f15886m = r21;     // Catch: RemoteException -> L36
        IDownloadAidlFileProvider r22 = r10.n();     // Catch: RemoteException -> L36
        if (r22 != null) goto L28;
        AnonymousClass26 r23 = null;
    L29:
        r11.f15889p = r23;     // Catch: RemoteException -> L36
        final INotificationClickAidlCallback r24 = r10.k();     // Catch: RemoteException -> L36
        if (r24 != null) goto L32;
        INotificationClickCallback r25 = null;
    L33:
        r11.f15887n = r25;     // Catch: RemoteException -> L36
        ListenerType r26 = ListenerType.f15280a;     // Catch: RemoteException -> L36
        int r27 = 0;
        IDownloadAidlListener r28 = r10.l(0);     // Catch: RemoteException -> L36
        if (r28 == null) goto L38;
        r11.a(r28.hashCode(), a(r28));     // Catch: RemoteException -> L36
    L38:
        ListenerType r29 = ListenerType.f15281b;     // Catch: RemoteException -> L36
        IDownloadAidlListener r30 = r10.l(1);     // Catch: RemoteException -> L36
        if (r30 == null) goto L41;
        r11.c(r30.hashCode(), a(r30));     // Catch: RemoteException -> L36
    L41:
        ListenerType r31 = ListenerType.f15282c;     // Catch: RemoteException -> L36
        IDownloadAidlListener r32 = r10.l(2);     // Catch: RemoteException -> L36
        if (r32 == null) goto L44;
        r11.b(r32.hashCode(), a(r32));     // Catch: RemoteException -> L36
    L44:
        a(r11, r10, r26);     // Catch: RemoteException -> L36
        a(r11, r10, r29);     // Catch: RemoteException -> L36
        a(r11, r10, r31);     // Catch: RemoteException -> L36
    L46:
        if (r27 >= r10.i()) goto L63;
        IDownloadCompleteAidlHandler r33 = r10.n(r27);     // Catch: RemoteException -> L36
        if (r33 == null) goto L62;
        AnonymousClass14 r34 = new AnonymousClass14(r33);     // Catch: RemoteException -> L36
        CopyOnWriteArrayList r35 = r11.f15890q;     // Catch: RemoteException -> L36
        monitor-enter(r35);     // Catch: RemoteException -> L36
        if (r11.f15890q.contains(r34) == false) goto L57;
        monitor-exit(r35);     // Catch: Throwable -> L55
        goto L62
    L57:
        r11.f15890q.add(r34);     // Catch: Throwable -> L55
        monitor-exit(r35);     // Catch: Throwable -> L55
        goto L62
    L55:
        th = move-exception;
        throw th;     // Catch: RemoteException -> L36
    L62:
        r27 = r27 + 1;
        goto L46
    L63:
        return r11;
    L32:
        r25 = new AnonymousClass16(r24);     // Catch: RemoteException -> L36
        goto L33
    L28:
        r23 = new AnonymousClass26(r22);     // Catch: RemoteException -> L36
        goto L29
    L24:
        r21 = new AnonymousClass23(r20);     // Catch: RemoteException -> L36
        goto L25
    L20:
        r19 = new AnonymousClass19(r18);     // Catch: RemoteException -> L36
        goto L21
    L16:
        r17 = new AnonymousClass18(r16);     // Catch: RemoteException -> L36
        goto L17
    L12:
        r15 = new AnonymousClass17(r14);     // Catch: RemoteException -> L36
        goto L13
    L8:
        r13 = new AnonymousClass25(r12);     // Catch: RemoteException -> L36
    L36:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    public static void a(DownloadTask r5, DownloadAidlTask r10, ListenerType r11) {
        ConcurrentHashMap r12 = new ConcurrentHashMap();
        int[] r13 = r10.m(r11.ordinal());
        if (r13 != null) goto L5;
    L51:
    L23:
        th = move-exception;
        th.printStackTrace();
        return;
    L14:
        if (r11 != ListenerType.f15280a) goto L26;
        ConcurrentHashMap r14 = r5.d;     // Catch: Throwable -> L23
        monitor-enter(r14);     // Catch: Throwable -> L23
        DownloadTask.b(r5.d, r12);     // Catch: Throwable -> L20
        monitor-exit(r14);     // Catch: Throwable -> L20
        return;
    L20:
        th = move-exception;
        throw th;     // Catch: Throwable -> L23
    L26:
        if (r11 != ListenerType.f15281b) goto L36;
        ConcurrentHashMap r15 = r5.e;     // Catch: Throwable -> L23
        monitor-enter(r15);     // Catch: Throwable -> L23
        DownloadTask.b(r5.e, r12);     // Catch: Throwable -> L32
        monitor-exit(r15);     // Catch: Throwable -> L32
        return;
    L32:
        th = move-exception;
        throw th;     // Catch: Throwable -> L23
    L36:
        if (r11 != ListenerType.f15282c) goto L56;
        ConcurrentHashMap r16 = r5.f;     // Catch: Throwable -> L23
        monitor-enter(r16);     // Catch: Throwable -> L23
        DownloadTask.b(r5.f, r12);     // Catch: Throwable -> L42
        monitor-exit(r16);     // Catch: Throwable -> L42
        return;
    L42:
        th = move-exception;
        throw th;     // Catch: Throwable -> L23
    L56:
        return;
    L5:
        if (r13.length <= 0) goto L51;
        int r17 = 0;
    L8:
        if (r17 >= r13.length) goto L51;
        IDownloadAidlListener r18 = r10.c(r11.ordinal(), r13[r17]);
        if (r18 == null) goto L12;
        r12.put(Integer.valueOf(r18.j()), a(r18));
    L12:
        r17 = r17 + 1;
        goto L8
    }

    public static IDownloadNotificationEventListener a(IDownloadNotificationEventAidlListener r5) {
        if (r5 != null) goto L6;
        return null;
    L6:
        return new AnonymousClass13(r5);
    }

    public static ProcessAidlCallback a(final ProcessCallback r5) {
        return new AnonymousClass21(r5);
    }

    public static ProcessCallback a(final ProcessAidlCallback r5) {
        if (r5 != null) goto L6;
        return null;
    L6:
        return new AnonymousClass22(r5);
    }

    public static IDownloadListener a(IDownloadAidlListener r5) {
        if (r5 != null) goto L6;
        return null;
    L6:
        return new AnonymousClass27(r5);
    }
}
