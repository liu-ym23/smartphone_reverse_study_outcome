package com.bytedance.android.live.browser.jsbridge.newmethods;

import android.os.ParcelFileDescriptor;
import com.bytedance.android.live.broadcast.api.IBroadcastService;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.FileUtils;
import com.bytedance.android.live.core.utils.MainThreadPostUtils;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.apm.impl.protector.RunnableProtector;
import java.io.FileDescriptor;
import java.util.Map;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class s2 implements Runnable {
    public final /* synthetic */ r2 a;
    public final /* synthetic */ Map b;
    public final /* synthetic */ Ref.ObjectRef c;
    public final /* synthetic */ String d;
    public final /* synthetic */ ParcelFileDescriptor e;
    public final /* synthetic */ String f;

    public static final class a implements Runnable {
        public final /* synthetic */ s2 a;

        public a(s2 r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.bytedance.android.live.core.utils.f2.c(this.a.f, 0);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public s2(r2 r1, Map r2, Ref.ObjectRef r3, String r4, ParcelFileDescriptor r5, String r6) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
    }

    public final void a() {
        if ((!this.b.isEmpty()) == false) goto L8;
        this.c.element = new PolarisFileWrapper(this.d).getPath() + ".temp";
        IBroadcastService r0 = (IBroadcastService) jc1.k.f(IBroadcastService.class);
        if (r0 == null) goto L7;
        r0.setMetadata(this.d, (String) this.c.element, this.b);
    L7:
        r2.k(this.a);
    L8:
        PolarisFileInputStreamWrapper r1 = new PolarisFileInputStreamWrapper((String) this.c.element);
        ParcelFileDescriptor r2 = this.e;
        if (r2 == null) goto L11;
        FileDescriptor r3 = r2.getFileDescriptor();
    L12:
        PolarisFileOutputStreamWrapper r4 = new PolarisFileOutputStreamWrapper(r3);
        int r5 = r2.a;
        ALogger.i("JSB_DownloadMedia", "copy from " + r1 + " to " + r4);
        FileUtils.fileChannelCopy(r1, r4);
        if ((!this.b.isEmpty()) == false) goto L15;
        r2.j(this.a, new PolarisFileWrapper((String) this.c.element));
    L15:
        r2 r6 = this.a;
        String r7 = this.d;
        r6.getClass();
        r2.o(r7);
        if ((!StringsKt.isBlank(this.f)) == false) goto L18;
        MainThreadPostUtils.b(new a(this));
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
