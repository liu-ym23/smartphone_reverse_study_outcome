package com.bytedance.android.live.browser.jsbridge.newmethods;

import android.content.ContentResolver;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import com.bytedance.android.live.broadcast.api.IBroadcastService;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.FileUtils;
import com.bytedance.android.live.core.utils.MainThreadPostUtils;
import com.bytedance.common.utility.concurrent.TTExecutors;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.security.android.aopcheck.ContentResolverWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.socialbase.downloader.depend.AbsDownloadListener;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.io.FileDescriptor;
import java.util.ArrayList;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class t2 extends AbsDownloadListener {
    public final /* synthetic */ r2 a;
    public final /* synthetic */ String b;
    public final /* synthetic */ String c;
    public final /* synthetic */ CallContext d;
    public final /* synthetic */ Ref.ObjectRef e;
    public final /* synthetic */ String f;
    public final /* synthetic */ String g;

    public static final class a implements Runnable {
        public final /* synthetic */ t2 a;
        public final /* synthetic */ Ref.ObjectRef b;
        public final /* synthetic */ DownloadInfo c;
        public final /* synthetic */ String d;
        public final /* synthetic */ ParcelFileDescriptor e;

        /* JADX INFO: renamed from: com.bytedance.android.live.browser.jsbridge.newmethods.t2$a$a, reason: collision with other inner class name */
        public static final class RunnableC0117a implements Runnable {
            public final /* synthetic */ a a;

            public RunnableC0117a(a r1) {
                this.a = r1;
            }

            @Override // java.lang.Runnable
            public final void run() {
                com.bytedance.android.live.core.utils.f2.c(this.a.a.f, 0);     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }
        }

        public a(t2 r1, Ref.ObjectRef r2, DownloadInfo r3, String r4, ParcelFileDescriptor r5) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
        }

        public final void a() {
            if ((!((Map) this.a.e.element).isEmpty()) == false) goto L8;
            this.b.element = this.c.getTargetFilePath() + ".temp";
            IBroadcastService r0 = (IBroadcastService) jc1.k.f(IBroadcastService.class);
            if (r0 == null) goto L7;
            r0.setMetadata(this.d, (String) this.b.element, (Map) this.a.e.element);
        L7:
            r2.k(this.a.a);
        L8:
            PolarisFileInputStreamWrapper r1 = new PolarisFileInputStreamWrapper((String) this.b.element);
            ParcelFileDescriptor r2 = this.e;
            if (r2 == null) goto L11;
            FileDescriptor r3 = r2.getFileDescriptor();
        L12:
            PolarisFileOutputStreamWrapper r4 = new PolarisFileOutputStreamWrapper(r3);
            int r5 = r2.a;
            ALogger.i("JSB_DownloadMedia", "copy from " + r1 + " to " + r4);
            FileUtils.fileChannelCopy(r1, r4);
            new PolarisFileWrapper(this.c.getTargetFilePath()).delete();
            if ((!((Map) this.a.e.element).isEmpty()) == false) goto L15;
            r2.j(this.a.a, new PolarisFileWrapper((String) this.b.element));
        L15:
            r2 r6 = this.a.a;
            String r7 = this.d;
            r6.getClass();
            r2.o(r7);
            if ((!StringsKt.isBlank(this.a.f)) == false) goto L18;
            MainThreadPostUtils.b(new RunnableC0117a(this));
        L18:
            ALogger.i("JSB_DownloadMedia", "copy complete, updating media index");
            return;
        L11:
            r3 = null;
            goto L12
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public final void onSuccessed(DownloadInfo r9) {
        Intrinsics.checkNotNullParameter(r9, "entity");
        super.onSuccessed(r9);
        String r5 = r9.getTargetFilePath();
        Ref.ObjectRef r3 = new Ref.ObjectRef();     // Catch: Throwable -> L5
        r3.element = r5;     // Catch: Throwable -> L5
        r2 r0 = this.a;     // Catch: Throwable -> L5
        String r1 = this.b;     // Catch: Throwable -> L5
        String r2 = this.c;     // Catch: Throwable -> L5
        r0.getClass();     // Catch: Throwable -> L5
        Uri r4 = r2.m(r1, r2);     // Catch: Throwable -> L5
        ParcelFileDescriptor r6 = a(this.d.getContext().getContentResolver(), r4);     // Catch: Throwable -> L5
        TTExecutors.getNormalExecutor().submit(new a(this, r3, r9, r5, r6));     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        this.a.getClass();
        r2.o(null);
        ALogger.w("JSB_DownloadMedia", th.getMessage());
    }

    public static ParcelFileDescriptor a(ContentResolver r21, Uri r22) {
        ArrayList r1 = new ArrayList();
        Object[] r2 = {r22, "w"};
        f06.b r13 = new f06.b();
        g06.a r3 = (g06.a) ApiHookConfig.b.get(240020);
        if (r3 == null) goto L5;
        f06.a[] r4 = r3.i;
    L6:
        f06.a[] r11 = r4;
        int r9 = r11.length;
        int r8 = 0;
    L8:
        if (r8 >= r9) goto L15;
        f06.a r7 = r11[r8];
        int r17 = r8;
        int r18 = r9;
        f06.a[] r19 = r11;
        f06.d r5 = r7.preInvoke(240020, "android/content/ContentResolver", "openFileDescriptor", r21, r2, "android.os.ParcelFileDescriptor", r13);     // Catch: Exception -> L22
        if (r5.a == true) goto L17;
        r1.add(r7);     // Catch: Exception -> L22
    L17:
        if (r5.a == false) goto L21;
        return (ParcelFileDescriptor) r5.b;
    L21:
        return ContentResolverWrapper.openFileDescriptor(r21, r22, "w");
    L14:
        r8 = r17 + 1;
        r9 = r18;
        r11 = r19;
        goto L8
    L15:
        r5 = new f06.d(false, null);
        goto L17
    L5:
        r4 = ApiHookConfig.d;
        goto L6
    }

    public final void onFailed(DownloadInfo r2, BaseException r3) {
        Intrinsics.checkNotNullParameter(r2, "entity");
        Intrinsics.checkNotNullParameter(r3, "e");
        super.onFailed(r2, r3);
        this.a.getClass();
        r2.o(null);
        ALogger.w("JSB_DownloadMedia", "download failed, with url " + this.g);
    }

    public t2(r2 r1, String r2, String r3, CallContext r4, Ref.ObjectRef r5, String r6, String r7) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
    }
}
