package com.bytedance.android.annie.service.network;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/annie/service/network/AnnieNetworkError;", "", "()V", com.bytedance.android.ec.core.event.a.KEY_MSG, "", "getMessage", "()Ljava/lang/String;", "setMessage", "(Ljava/lang/String;)V", com.bytedance.android.ec.core.event.a.KEY_STATUS_CODE, "", "getStatusCode", "()I", "setStatusCode", "(I)V", "annie_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class AnnieNetworkError extends Throwable {
    private String message;
    private int statusCode;

    public AnnieNetworkError() {
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return this.message;
    }

    public final int getStatusCode() {
        return this.statusCode;
    }

    public void setMessage(String r1) {
        this.message = r1;
    }

    public final void setStatusCode(int r1) {
        this.statusCode = r1;
    }
}
