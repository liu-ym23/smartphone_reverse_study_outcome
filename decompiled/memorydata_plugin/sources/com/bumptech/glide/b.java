package com.bumptech.glide;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public final class b<TranscodeType> extends j<b<TranscodeType>, TranscodeType> {
    public b() {
    }

    @Override // com.bumptech.glide.j
    public boolean equals(Object r2) {
        if (ZeusTransformUtils.instanceOf(r2, b.class) == true) goto L5;
    L7:
        return false;
    L5:
        if (super.equals(r2) == false) goto L7;
        return true;
    }

    @Override // com.bumptech.glide.j
    public int hashCode() {
        return super.hashCode();
    }
}
