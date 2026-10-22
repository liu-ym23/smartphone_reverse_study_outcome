package com.ss.android.lark.qrcode.ui;

import android.text.TextUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.callback.IGetDataCallback;
import com.larksuite.framework.utils.CollectionUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.log.Log;
import com.ss.android.vesdk.VEUtils;
import com.ss.android.vesdk.algorithm.VEBachQRCodeParam;
import com.ss.android.vesdk.algorithm.VEBachQRCodeResult;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class g implements Runnable {
    public final /* synthetic */ VEBachQRCodeParam a;
    public final /* synthetic */ IGetDataCallback b;
    public final /* synthetic */ h c;

    public class a implements Runnable {
        public final /* synthetic */ List a;
        public final /* synthetic */ g b;

        public final void a() {
            if (CollectionUtils.isEmpty(this.a) == true) goto L15;
            ArrayList r1 = new ArrayList();
            int r5 = 0;
        L6:
            if (r5 >= this.a.size()) goto L12;
            VEBachQRCodeResult r6 = (VEBachQRCodeResult) ListProtector.get(this.a, r5);
            h r7 = this.b.c;
            int r8 = r6.getCurrentFrameWidth();
            float[][] r9 = r6.getLocation();
            r7.getClass();
            int r12 = h.a(r8, r9, 0, true);
            h r10 = this.b.c;
            int r11 = r6.getCurrentFrameWidth();
            float[][] r13 = r6.getLocation();
            r10.getClass();
            int r14 = h.a(r11, r13, 0, false);
            h r15 = this.b.c;
            int r16 = r6.getCurrentFrameHeight();
            float[][] r17 = r6.getLocation();
            r15.getClass();
            int r18 = h.a(r16, r17, 1, true);
            h r19 = this.b.c;
            int r20 = r6.getCurrentFrameHeight();
            float[][] r110 = r6.getLocation();
            r19.getClass();
            int r111 = h.a(r20, r110, 1, false);
            if (TextUtils.isEmpty(r6.getResult()) == true) goto L10;
            String r112 = r6.getResult();
            r6.getIsFromBach();
            r6.getCurrentFrameWidth();
            r6.getCurrentFrameHeight();
            r6.getCurrentFrame();
            r1.add(new dxa.f(r112, r12, r14, r18, r111, r6.getCodeType()));
            Log.i("QRCodeScanManager", "res is * ,codeType is " + r6.getCodeType() + " ,left is " + r6.getLeft() + " ,right is " + r6.getRight() + " ,top is " + r6.getTop() + " ,bottom is " + r6.getBottom() + " ,isFromBach is " + r6.getIsFromBach());
        L10:
            r5 = r5 + 1;
            goto L6
        L12:
            if (CollectionUtils.isEmpty(r1) == true) goto L14;
            dxa.f r2 = (dxa.f) ListProtector.get(r1, 0);
            g r3 = this.b;
            IGetDataCallback r4 = r3.b;
            String r21 = r2.a;
            h r22 = r3.c;
            int r23 = r2.f;
            r22.getClass();
            h.f(r23);
            r4.onSuccess(new dxa.g(r21, r1));
        L17:
            if (this.b.a.getBitmap() != null) goto L19;
            return;
        L19:
            if (this.b.a.getBitmap().isRecycled() == true) goto L26;
            this.b.a.getBitmap().recycle();
            return;
        L26:
            return;
        L14:
            this.b.b.onError(new ErrorResult("QR result is null"));
            goto L17
        L15:
            Log.i("QRCodeScanManager", "failed to parse qr code from pic. return 0 code information");
            this.b.b.onError(new ErrorResult("QR result is null"));
            goto L17
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

        public a(g r1, List r2) {
            this.b = r1;
            this.a = r2;
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        VEBachQRCodeParam r0 = this.a;     // Catch: Throwable -> L6
        if (r0 == null) goto L9;
        List r1 = VEUtils.scanPicture(r0);     // Catch: Throwable -> L6
        this.c.f.post(new a(this, r1));     // Catch: Throwable -> L6
        return;
    L9:
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }

    public g(h r1, VEBachQRCodeParam r2, IGetDataCallback r3) {
        this.c = r1;
        this.a = r2;
        this.b = r3;
    }
}
