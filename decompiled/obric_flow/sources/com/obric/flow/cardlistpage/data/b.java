package com.obric.flow.cardlistpage.data;

import androidx.sqlite.db.SupportSQLiteStatement;
import java.util.concurrent.Callable;
import kotlin.Unit;

/* JADX INFO: loaded from: classes3.dex */
public final class b implements Callable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f11469a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ h f11470b;

    public b(h r5, int r10) {
        this.f11470b = r5;
        this.f11469a = r10;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        h r5 = this.f11470b;
        f r10 = r5.f;
        SupportSQLiteStatement r11 = r10.acquire();
        r11.bindLong(1, this.f11469a);
        r11.bindString(2, "card_instance_id");
        CardDatabase_Impl r12 = r5.f11479a;
        r12.beginTransaction();
        r11.executeUpdateDelete();     // Catch: Throwable -> L6
        r12.setTransactionSuccessful();     // Catch: Throwable -> L6
        Unit r13 = Unit.INSTANCE;     // Catch: Throwable -> L6
        r12.endTransaction();
        r10.release(r11);
        return r13;
    L6:
        th = move-exception;
        r12.endTransaction();
        r10.release(r11);
        throw th;
    }
}
