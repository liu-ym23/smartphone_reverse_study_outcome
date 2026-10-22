package com.bytedance.iesgurd.update;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00060\u0001j\u0002`\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/iesgurd/update/UpdateException;", "Ljava/lang/RuntimeException;", "Lkotlin/RuntimeException;", "geckox_noasanRelease"}, k = 1, mv = {1, 4, 0})
public final class UpdateException extends RuntimeException {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f6712a;

    public UpdateException(int r5, String r10) {
        super(r10);
        this.f6712a = r5;
    }

    public UpdateException(ErrorCode r5, String r10) {
        int r11 = r5.f6711a;
        if (r10 != null) goto L6;
        r10 = "";
    L6:
        super(r10);
        this.f6712a = r11;
    }
}
