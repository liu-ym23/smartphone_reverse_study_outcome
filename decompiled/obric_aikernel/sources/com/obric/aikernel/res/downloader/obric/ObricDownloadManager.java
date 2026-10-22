package com.obric.aikernel.res.downloader.obric;

import android.annotation.SuppressLint;
import androidx.core.app.NotificationCompat;
import com.obric.aikernel.res.PackageResourceManager;
import com.obric.aikernel.runtime.utils.d;
import com.obric.download.base.DownloadInfo;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.w;
import kotlinx.coroutines.y;
import w8.e;
import w8.f;
import w8.g;

/* JADX INFO: loaded from: classes2.dex */
public final class ObricDownloadManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ObricDownloadManager f4976a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @SuppressLint({"StaticFieldLeak"})
    private static w<f> f4977b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final a f4978c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final b f4979d = null;

    public static final class a implements w8.c {
        a() {
        }

        @Override // w8.c
        public void a() {
            d.f5417a.g("ObricDownloadManager", "onServiceDisconnected");
            ObricDownloadManager r10 = ObricDownloadManager.f4976a;
            ObricDownloadManager.b(null);
        }

        @Override // w8.c
        public void b() {
            d.f5417a.g("ObricDownloadManager", "onServiceConnected");
            w r10 = ObricDownloadManager.a();
            if (r10 == null) goto L6;
            r10.K(f.f13430q.a());
            return;
        }
    }

    public static final class b implements e {
        b() {
        }

        @Override // w8.e
        public void F(DownloadInfo r10, int r11, String r12) {
            Intrinsics.checkNotNullParameter(r10, "info");
            Intrinsics.checkNotNullParameter(r12, "errorMsg");
            d.f5417a.c("ObricDownloadManager", "onDownloadFailed: " + r10 + ' ' + r11 + ':' + r12);
        }

        @Override // w8.e
        public void G0(DownloadInfo r10) {
            Intrinsics.checkNotNullParameter(r10, "info");
            d.f5417a.c("ObricDownloadManager", "onDownloadCancel: " + r10);
        }

        @Override // w8.e
        public void K(DownloadInfo r10) {
            Intrinsics.checkNotNullParameter(r10, "info");
            d.f5417a.c("ObricDownloadManager", "onExtraInfoUpdate: " + r10);
        }

        @Override // w8.e
        public void X(DownloadInfo r10) {
            Intrinsics.checkNotNullParameter(r10, "info");
            d.f5417a.c("ObricDownloadManager", "onDownloadPending: " + r10);
        }

        @Override // w8.e
        public void a0(DownloadInfo r10) {
            Intrinsics.checkNotNullParameter(r10, "info");
            d.f5417a.c("ObricDownloadManager", "onDownloadPause: " + r10);
        }

        @Override // w8.e
        public void h0(DownloadInfo r10) {
            Intrinsics.checkNotNullParameter(r10, "info");
            d.f5417a.c("ObricDownloadManager", "onDownloadStart: " + r10);
        }

        @Override // w8.e
        public void u0(DownloadInfo r10) {
            Intrinsics.checkNotNullParameter(r10, "info");
            d.f5417a.c("ObricDownloadManager", "onDownloading: " + r10);
        }

        @Override // w8.e
        public void z0(DownloadInfo r10) {
            Intrinsics.checkNotNullParameter(r10, "info");
            d.f5417a.c("ObricDownloadManager", "onDownloadFinish: " + r10);
        }
    }

    public static final class c implements g.a {
        c() {
        }

        @Override // w8.g.a
        public void a(String r10, int r11, String r12, Throwable r13) {
            Intrinsics.checkNotNullParameter(r12, NotificationCompat.CATEGORY_MESSAGE);
            d r14 = d.f5417a;
            if (r10 != null) goto L5;
            r10 = "ObricDownloadManager";
        L5:
            StringBuilder r15 = new StringBuilder();
            r15.append(r12);
            if (r13 == null) goto L8;
            String r16 = r13.toString();
        L9:
            r15.append(r16);
            r14.a(r10, r15.toString(), r11);
            return;
        L8:
            r16 = null;
            goto L9
        }
    }

    static {
        f4976a = new ObricDownloadManager();
        f4978c = new a();
        f4979d = new b();
    }

    private ObricDownloadManager() {
    }

    public static final /* synthetic */ w a() {
        return f4977b;
    }

    public static final /* synthetic */ void b(w r10) {
        f4977b = r10;
    }

    public final <T> Object c(Function1<? super f, ? extends T> r10, Continuation<? super T> r11) {
        if ((r11 instanceof ObricDownloadManager$execute$1) == false) goto L7;
        ObricDownloadManager$execute$1 r12 = (ObricDownloadManager$execute$1) r11;
        int r13 = r12.label;
        if ((r13 & Integer.MIN_VALUE) == 0) goto L7;
        r12.label = r13 - Integer.MIN_VALUE;
    L8:
        Object r14 = r12.result;
        Object r15 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r16 = r12.label;
        if (r16 == 0) goto L14;
        if (r16 != 1) goto L13;
        r10 = (Function1) r12.L$0;
        ResultKt.throwOnFailure(r14);
    L22:
        f r17 = (f) r14;
        if (r17 != null) goto L25;
        return null;
    L25:
        return r10.invoke(r17);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r14);
        if (f4977b != null) goto L17;
        f4977b = y.b(null, 1, null);
        f r18 = f.f13430q.a();
        r18.B(f4979d);
        r18.u(f4978c);
    L17:
        w<f> r19 = f4977b;
        if (r19 == null) goto L26;
        r12.L$0 = r10;
        r12.label = 1;
        r14 = r19.r(r12);
        if (r14 != r15) goto L22;
        return r15;
    L26:
        return null;
    L7:
        r12 = new ObricDownloadManager$execute$1(this, r11);
        goto L8
    }

    public final void d(PackageResourceManager.PresmConfig r10) {
        Intrinsics.checkNotNullParameter(r10, "presmConfig");
        g.f(new c());
        w8.d.a r11 = new w8.d.a();
        String r12 = r10.getContext().getPackageName();
        Intrinsics.checkNotNullExpressionValue(r12, "presmConfig.context.packageName");
        w8.d.a r13 = r11.d(r12).c(r10.getParallelDownloadNum());
        String r14 = r10.getContext().getPackageName();
        Intrinsics.checkNotNullExpressionValue(r14, "presmConfig.context.packageName");
        w8.d r15 = r13.b(r14).a();
        f.f13430q.b(r10.getContext(), r15);
    }
}
