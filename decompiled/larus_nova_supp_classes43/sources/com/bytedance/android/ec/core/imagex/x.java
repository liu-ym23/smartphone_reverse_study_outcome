package com.bytedance.android.ec.core.imagex;

import android.graphics.Bitmap;
import com.facebook.datasource.DataSource;
import io.reactivex.ObservableEmitter;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class x extends t0 {
    public final /* synthetic */ DataSource b;
    public final /* synthetic */ ObservableEmitter c;
    public final /* synthetic */ int d;
    public final /* synthetic */ List e;
    public final /* synthetic */ r f;

    @Override // com.bytedance.android.ec.core.imagex.t0
    public final void a(Bitmap r10) {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L13
        if (this.c.isDisposed() == false) goto L5;
        return;
    L5:
        if (r10 == null) goto L8;
        this.c.onNext(r10);     // Catch: Throwable -> L13
        this.c.onComplete();     // Catch: Throwable -> L13
    L11:
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L13
        return;
    L8:
        if (this.d >= (this.e.size() - 1)) goto L10;
        ImageExtensionsKt.a(this.e, this.d + 1, this.f, this.c);     // Catch: Throwable -> L13
        goto L11
    L10:
        this.c.onError(new Throwable());     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        Result.Companion r1 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
    }

    public x(DataSource r1, DataSource r10, ObservableEmitter r11, int r12, List r13, r r14) {
        this.b = r1;
        this.c = r11;
        this.d = r12;
        this.e = r13;
        this.f = r14;
        super(r10);
    }
}
