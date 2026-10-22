package com.larus.drive.sdk.api.gallery.datasource;

import com.larus.drive.sdk.api.file.DriveFileItem;
import com.larus.gallery.api.IGalleryDataSource;
import com.larus.gallery.api.k;
import java.util.List;
import kotlin.Pair;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public abstract class a<T> implements IGalleryDataSource<T> {
    public final DriveFileItem a;
    public final int b;

    public final boolean b() {
        return false;
    }

    public final Object f(T r1, Continuation<? super T> r2) {
        return r1;
    }

    public final boolean h() {
        return true;
    }

    public final int k() {
        return this.b;
    }

    public a(DriveFileItem r1) {
        this.a = r1;
        this.b = 10;
    }

    public final Object e(List<? extends T> r1, Continuation<? super List<? extends Pair<? extends T, k>>> r2) {
        return IGalleryDataSource.DefaultImpls.c(this, r1, r2);
    }

    public final boolean j(T r1, T r2) {
        return Intrinsics.areEqual(r1, r2);
    }
}
