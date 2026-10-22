package com.bytedance.android.ec.core.imagex;

import com.facebook.imagepipeline.request.ImageRequest;
import io.reactivex.ObservableEmitter;
import java.io.File;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class z extends u0 {
    public final /* synthetic */ ObservableEmitter c;
    public final /* synthetic */ int d;
    public final /* synthetic */ List e;
    public final /* synthetic */ r f;

    @Override // com.bytedance.android.ec.core.imagex.u0
    public final void a(File r10) {
        if (this.c.isDisposed() == false) goto L5;
        return;
    L5:
        if (r10 == null) goto L8;
        this.c.onNext(r10);
        this.c.onComplete();
        return;
    L8:
        if (this.d >= (this.e.size() - 1)) goto L10;
        ImageExtensionsKt.b(this.e, this.d + 1, this.f, this.c);
        return;
    L10:
        this.c.onError(new Throwable());
    }

    public z(ObservableEmitter r1, int r10, List r11, r r12, ImageRequest r13, r r14) {
        this.c = r1;
        this.d = r10;
        this.e = r11;
        this.f = r12;
        super(r13, r14);
    }
}
