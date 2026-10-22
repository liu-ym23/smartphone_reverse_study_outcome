package com.ss.android.lark.image;

import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.image.impl.PerfCompressPicMonitor;
import com.ss.android.lark.utils.p;
import io.reactivex.functions.Consumer;
import java.io.File;
import java.util.Objects;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class g implements Consumer<File> {
    public final /* synthetic */ boolean a;
    public final /* synthetic */ String b;
    public final /* synthetic */ long c;
    public final /* synthetic */ IGetDataCallback d;

    public final void accept(Object r6) throws Exception {
        File r7 = (File) r6;
        String r0 = r7.getPath();
        if (this.a == false) goto L5;
    L7:
        boolean r1 = false;
    L8:
        if (r1 == false) goto L10;
        PerfCompressPicMonitor.reportCompressEvent(System.currentTimeMillis() - this.c, this.b, r0);
    L10:
        com.ss.android.lark.image.entity.d r2 = new com.ss.android.lark.image.entity.d(r7, p.g(r7.getPath()));
        this.d.onSuccess(r2);
        return;
    L5:
        if (Objects.equals(this.b, r0) == true) goto L7;
        r1 = true;
        goto L8
    }

    public g(boolean r1, String r2, long r3, IGetDataCallback r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r5;
    }
}
