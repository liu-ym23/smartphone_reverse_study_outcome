package com.google.devtools.ksp;

import il.p;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0007\b\u0007\u0018\u00002\u00060\u0001j\u0002`\u0002B\u001d\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tR\u001d\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0006¢\u0006\f\n\u0004\b\u0005\u0010\n\u001a\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/google/devtools/ksp/KSTypesNotPresentException;", "Ljava/lang/RuntimeException;", "Lkotlin/RuntimeException;", "", "Lil/p;", "ksTypes", "", "cause", "<init>", "(Ljava/util/List;Ljava/lang/Throwable;)V", "Ljava/util/List;", "getKsTypes", "()Ljava/util/List;", "api"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class KSTypesNotPresentException extends RuntimeException {
    private final List<p> ksTypes;

    /* JADX WARN: Multi-variable type inference failed */
    public KSTypesNotPresentException(List<? extends p> r5, Throwable r10) {
        Intrinsics.checkNotNullParameter(r5, "ksTypes");
        Intrinsics.checkNotNullParameter(r10, "cause");
        super(r10);
        this.ksTypes = r5;
    }

    public final List<p> getKsTypes() {
        return this.ksTypes;
    }
}
