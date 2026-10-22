package com.ss.android.lark.qrcode.ui;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.lark.biz.core.api.IQRCodeScanResultHandler;
import com.ss.android.lark.log.Log;
import java.util.ArrayList;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final /* synthetic */ class e implements Function0 {
    public final /* synthetic */ h a;
    public final /* synthetic */ int b;
    public final /* synthetic */ String c;

    public /* synthetic */ e(h r1, int r2, String r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final Object invoke() {
        h r0 = this.a;
        int r1 = this.b;
        String r2 = this.c;
        r0.getClass();
        Log.i("QRCodeScanManager", "prepare to handle parse result: *, source: " + r1);
        int r4 = 0;
    L4:
        if (r4 >= ((ArrayList) r0.b).size()) goto L21;
        dxa.d r5 = (IQRCodeScanResultHandler) ListProtector.get(r0.b, r4);
        if (r5 == null) goto L20;
        dxa.b r8 = r0.c;
        if (r8 == null) goto L20;
        if (r5.c(r2, r8) == false) goto L20;
        Log.i("QRCodeScanManager", r5.getClass().getName().concat(" handle result success"));
        r0.n();
        if ((r5 instanceof dxa.d) == false) goto L14;
        boolean r3 = r5.b();
    L16:
        if ((r5 instanceof dxa.e) == false) goto L18;
        boolean r6 = ((dxa.e) r5).a();
    L52:
        return new y(true, r3, r6);
    L18:
        r6 = true;
        goto L52
    L14:
        r3 = true;
    L20:
        r4 = r4 + 1;
        goto L4
    L21:
        int r7 = 0;
    L23:
        if (r7 >= ((ArrayList) r0.a).size()) goto L40;
        dxa.d r9 = (IQRCodeScanResultHandler) ListProtector.get(r0.a, r7);
        if (r9 == null) goto L39;
        dxa.b r10 = r0.c;
        if (r10 == null) goto L39;
        if (r9.c(r2, r10) == false) goto L39;
        Log.i("QRCodeScanManager", r9.getClass().getName().concat(" handle result success"));
        r0.n();
        if ((r9 instanceof dxa.d) == false) goto L33;
        boolean r11 = r9.b();
    L35:
        if ((r9 instanceof dxa.e) == false) goto L37;
        boolean r12 = ((dxa.e) r9).a();
    L53:
        return new y(true, r11, r12);
    L37:
        r12 = true;
        goto L53
    L33:
        r11 = true;
    L39:
        r7 = r7 + 1;
        goto L23
    L40:
        Log.i("QRCodeScanManager", "no handler to handle result");
        r0.n();
        return new y(false, false, false);
    }
}
