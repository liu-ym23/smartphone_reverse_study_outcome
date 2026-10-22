package com.obric.flow.cardlistpage.data;

import java.util.concurrent.Callable;
import kotlin.Unit;

/* JADX INFO: loaded from: classes3.dex */
public final class g implements Callable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f11476a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ j f11477b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ h f11478c;

    public /* synthetic */ g(h r5, j r10, int r11) {
        this.f11476a = r11;
        this.f11478c = r5;
        this.f11477b = r10;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        switch(this.f11476a) {
            case 0: goto L11;
            default: goto L4;
        };
    L4:
        h r5 = this.f11478c;
        CardDatabase_Impl r10 = r5.f11479a;
        r10.beginTransaction();
        r5.f11481c.handle(this.f11477b);     // Catch: Throwable -> L8
        r10.setTransactionSuccessful();     // Catch: Throwable -> L8
        Unit r11 = Unit.INSTANCE;     // Catch: Throwable -> L8
        r10.endTransaction();
        return r11;
    L8:
        th = move-exception;
        r10.endTransaction();
        throw th;
    L11:
        h r12 = this.f11478c;
        CardDatabase_Impl r13 = r12.f11479a;
        r13.beginTransaction();
        r12.f11480b.insert(this.f11477b);     // Catch: Throwable -> L15
        r13.setTransactionSuccessful();     // Catch: Throwable -> L15
        Unit r14 = Unit.INSTANCE;     // Catch: Throwable -> L15
        r13.endTransaction();
        return r14;
    L15:
        th = move-exception;
        r13.endTransaction();
        throw th;
    }
}
