package com.google.devtools.ksp;

import il.p;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0007\b\u0007\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0017\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/google/devtools/ksp/KSTypeNotPresentException;", "Ljava/lang/RuntimeException;", "Lkotlin/RuntimeException;", "Lil/p;", "ksType", "", "cause", "<init>", "(Lil/p;Ljava/lang/Throwable;)V", "Lil/p;", "getKsType", "()Lil/p;", "api"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class KSTypeNotPresentException extends RuntimeException {
    private final p ksType;

    public KSTypeNotPresentException(p r5, Throwable r10) {
        Intrinsics.checkNotNullParameter(r5, "ksType");
        Intrinsics.checkNotNullParameter(r10, "cause");
        super(r10);
    }

    public final p getKsType() {
        return null;
    }
}
