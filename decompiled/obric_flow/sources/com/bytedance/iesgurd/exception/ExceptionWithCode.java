package com.bytedance.iesgurd.exception;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00060\u0001j\u0002`\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/iesgurd/exception/ExceptionWithCode;", "Ljava/lang/RuntimeException;", "Lkotlin/RuntimeException;", "geckox_noasanRelease"}, k = 1, mv = {1, 4, 0})
public final class ExceptionWithCode extends RuntimeException {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f6623a;

    public ExceptionWithCode(int r5, String r10) {
        super(r10);
        this.f6623a = r5;
    }
}
