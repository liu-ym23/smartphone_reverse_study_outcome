package com.bytedance.android.annie.bridge.method;

import com.bytedance.android.annie.bridge.method.abs.PreloadResourceResultModel;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class l1<T> implements Consumer {
    public final /* synthetic */ n1 a;

    public l1(n1 r1) {
        this.a = r1;
    }

    public final void accept(Object r10) {
        Integer r11 = (Integer) r10;
        if (r11 != null) goto L6;
    L8:
        if (r11 != null) goto L11;
    L13:
        n1 r12 = this.a;
        PreloadResourceResultModel r0 = new PreloadResourceResultModel();
        r0.a(PreloadResourceResultModel.Code.Failed);
        r0.b("unknown case");
        r12.finishWithResult(r0);
        return;
    L11:
        if (r11.intValue() != 0) goto L13;
        n1 r13 = this.a;
        PreloadResourceResultModel r1 = new PreloadResourceResultModel();
        r1.a(PreloadResourceResultModel.Code.Success);
        r13.finishWithResult(r1);
        return;
    L6:
        if (r11.intValue() != (-1)) goto L8;
        n1 r14 = this.a;
        PreloadResourceResultModel r15 = new PreloadResourceResultModel();
        r15.a(PreloadResourceResultModel.Code.Failed);
        r15.b("forest not init");
        r14.finishWithResult(r15);
    }
}
