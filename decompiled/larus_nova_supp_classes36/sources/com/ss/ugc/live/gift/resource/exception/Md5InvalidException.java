package com.ss.ugc.live.gift.resource.exception;

import qlc.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public class Md5InvalidException extends BaseGetResourceException {
    private String mMd5;

    @Override // com.ss.ugc.live.gift.resource.exception.BaseGetResourceException, java.lang.Throwable
    public String getMessage() {
        return "md5:" + this.mMd5 + "\n" + super.getMessage();
    }

    public Md5InvalidException(a r1, String r2) {
        super(r1);
        this.mMd5 = r2;
    }

    public Md5InvalidException(String r1, a r2, String r3) {
        super(r1, r2);
        this.mMd5 = r3;
    }

    public Md5InvalidException(String r1, Throwable r2, a r3, String r4) {
        super(r1, r2, r3);
        this.mMd5 = r4;
    }
}
