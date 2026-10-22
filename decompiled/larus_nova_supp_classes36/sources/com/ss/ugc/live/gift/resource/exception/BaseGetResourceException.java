package com.ss.ugc.live.gift.resource.exception;

import qlc.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public class BaseGetResourceException extends RuntimeException {
    private a mRequest;

    public a getResourceRequest() {
        return null;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        throw null;
    }

    @Override // java.lang.Throwable
    public String toString() {
        String r0 = super.toString();
        Throwable r1 = getCause();
        if (r1 == null) goto L7;
        if (r1 != this) goto L6;
        return r0;
    L6:
        return r0 + "\n" + r1.toString();
    L7:
        return r0;
    }

    public long getId() {
        throw null;
    }

    public BaseGetResourceException(a r1) {
    }

    public BaseGetResourceException(String r1, a r2) {
        super(r1);
    }

    public BaseGetResourceException(String r1, Throwable r2, a r3) {
        super(r1, r2);
    }
}
