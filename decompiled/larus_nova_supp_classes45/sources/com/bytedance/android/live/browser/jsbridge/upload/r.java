package com.bytedance.android.live.browser.jsbridge.upload;

import android.os.ParcelFileDescriptor;
import com.bytedance.android.livesdk.config.k4;
import com.bytedance.android.livesdk.config.ki1;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import java.io.File;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class r implements js0.b {
    public final /* synthetic */ ParcelFileDescriptor a;
    public final /* synthetic */ String b;
    public final /* synthetic */ int c;
    public final /* synthetic */ q d;

    public final void onSuccess(String r12) {
        final q r13 = this.d;
        final ParcelFileDescriptor r2 = this.a;
        final String r5 = this.b;
        final int r6 = this.c;
        if (r13.g != null) goto L5;
        r13.finishWithFailure();
        return;
    L5:
        final String r3 = r13.g.getContext().getCacheDir().getAbsolutePath() + File.separator + System.currentTimeMillis() + ".mp4";
        final PolarisFileWrapper r4 = new PolarisFileWrapper(r3);
        boolean r0 = false;
        int r1 = CastIntegerProtector.parseInt(String.valueOf((int) (r2.getStatSize() / 1048576)));     // Catch: Exception -> L8
    L9:
        r13.K = false;
        if (r1 >= ((Integer) ki1.a.getValue()).intValue()) goto L12;
    L14:
        r13.J = r0;
        r13.c = Observable.create(new h(r13, r2, r3, r4, r5)).subscribeOn(Schedulers.io()).observeOn(Schedulers.io()).flatMap(new i(r13, r6)).map(new j(r13)).observeOn(AndroidSchedulers.mainThread()).subscribe(new k(r13), new l(r13));
        return;
    L12:
        if (((Boolean) k4.a.getValue()).booleanValue() == false) goto L14;
        r0 = true;
    L8:
        r1 = 0;
        goto L9
    }

    public r(q r1, ParcelFileDescriptor r2, String r3, int r4) {
        this.d = r1;
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
