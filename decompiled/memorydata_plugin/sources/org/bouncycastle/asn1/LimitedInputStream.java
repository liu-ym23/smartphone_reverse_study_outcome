package org.bouncycastle.asn1;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.InputStream;

/* JADX INFO: loaded from: classes7.dex */
abstract class LimitedInputStream extends InputStream {
    protected final InputStream _in;
    private int _limit;

    LimitedInputStream(InputStream r1, int r2) {
        this._in = r1;
        this._limit = r2;
    }

    int getLimit() {
        return this._limit;
    }

    public void setParentEofDetect(boolean r3) {
        if (ZeusTransformUtils.instanceOf(this._in, IndefiniteLengthInputStream.class) == false) goto L6;
        ((IndefiniteLengthInputStream) ZeusTransformUtils.preCheckCast(this._in, IndefiniteLengthInputStream.class, "com.obric.memorydata.plugin")).setEofOn00(r3);
        return;
    }
}
