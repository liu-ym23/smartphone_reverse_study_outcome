package com.ss.android.lark.qrcode.ui;

import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.callback.IGetDataCallback;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.vesdk.VEUtils;
import com.ss.android.vesdk.algorithm.VEBachQRCodeParam;
import com.ss.android.vesdk.algorithm.VEBachQRCodeResult;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class f implements Runnable {
    public final /* synthetic */ VEBachQRCodeParam a;
    public final /* synthetic */ IGetDataCallback b;
    public final /* synthetic */ h c;

    public class a implements Runnable {
        public final /* synthetic */ VEBachQRCodeResult a;
        public final /* synthetic */ f b;

        public final void a() {
            VEBachQRCodeResult r0 = this.a;
            if (r0 != null) goto L5;
            this.b.b.onError(new ErrorResult("QR result is null"));
        L10:
            if (this.b.a.getBitmap() != null) goto L12;
            return;
        L12:
            if (this.b.a.getBitmap().isRecycled() == true) goto L16;
            this.b.a.getBitmap().recycle();
            return;
        L16:
            return;
        L5:
            if (r0.getResult() == null) goto L7;
            IGetDataCallback r1 = this.b.b;
            String r2 = this.a.getResult();
            h r3 = this.b.c;
            int r4 = this.a.getCodeType();
            r3.getClass();
            h.f(r4);
            r1.onSuccess(new dxa.g(r2));
            goto L10
        L7:
            f r5 = this.b;
            IGetDataCallback r6 = r5.b;
            h r7 = r5.c;
            int r8 = this.a.getCodeType();
            r7.getClass();
            h.f(r8);
            r6.onSuccess(new dxa.g(""));
            goto L10
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

        public a(f r1, VEBachQRCodeResult r2) {
            this.b = r1;
            this.a = r2;
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        VEBachQRCodeParam r0 = this.a;     // Catch: Throwable -> L6
        if (r0 == null) goto L9;
        VEBachQRCodeResult r1 = VEUtils.scanPicture(r0);     // Catch: Throwable -> L6
        this.c.f.post(new a(this, r1));     // Catch: Throwable -> L6
        return;
    L9:
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }

    public f(h r1, VEBachQRCodeParam r2, IGetDataCallback r3) {
        this.c = r1;
        this.a = r2;
        this.b = r3;
    }
}
