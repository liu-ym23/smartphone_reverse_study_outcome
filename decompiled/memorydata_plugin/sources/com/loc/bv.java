package com.loc;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes3.dex */
public final class bv extends fg {
    bv(ByteBuffer r1) {
        super(r1);
    }

    @Override // com.loc.fg
    public final int a(CharSequence r3) {
        return super.a((CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin"));
    L5:
        th = move-exception;
        de.a(th);
        return super.a("");
    }
}
