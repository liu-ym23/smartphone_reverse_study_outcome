package com.obric.dejavu.library;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00018\u0000¢\u0006\u0002\u0010\u0006R\u0015\u0010\u0005\u001a\u0004\u0018\u00018\u0000¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/obric/dejavu/library/DbObjResult;", ExifInterface.GPS_DIRECTION_TRUE, "", "status", "Lcom/obric/dejavu/library/DbStatus;", "data", "(Lcom/obric/dejavu/library/DbStatus;Ljava/lang/Object;)V", "getData", "()Ljava/lang/Object;", "Ljava/lang/Object;", "getStatus", "()Lcom/obric/dejavu/library/DbStatus;", "library_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class DbObjResult<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final DbStatus f7868a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final T f7869b;

    public DbObjResult(DbStatus r2, T r3) {
        Intrinsics.checkNotNullParameter(r2, "status");
        this.f7868a = r2;
        this.f7869b = r3;
    }

    public final DbStatus a() {
        return this.f7868a;
    }

    public final T b() {
        return this.f7869b;
    }
}
