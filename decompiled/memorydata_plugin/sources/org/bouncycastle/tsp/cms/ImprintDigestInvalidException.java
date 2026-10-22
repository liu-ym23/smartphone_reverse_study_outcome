package org.bouncycastle.tsp.cms;

import org.bouncycastle.tsp.TimeStampToken;

/* JADX INFO: loaded from: classes7.dex */
public class ImprintDigestInvalidException extends Exception {
    private TimeStampToken token;

    public ImprintDigestInvalidException(String r1, TimeStampToken r2) {
        super(r1);
        this.token = r2;
    }

    public TimeStampToken getTimeStampToken() {
        return this.token;
    }
}
