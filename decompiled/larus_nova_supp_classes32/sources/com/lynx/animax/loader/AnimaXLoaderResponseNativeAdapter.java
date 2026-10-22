package com.lynx.animax.loader;

import com.obric.aivoice.core.data.NameKeys;
import u4a.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class AnimaXLoaderResponseNativeAdapter {
    public final AnimaXLoaderResponse<?> a;

    public AnimaXCloseableBitmapReferenceNativeAdapter getBitmap() {
        return new AnimaXCloseableBitmapReferenceNativeAdapter((j) this.a.b);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public byte[] getData() {
        return (byte[]) this.a.b;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public String getErrorMessage() {
        if (this.a.getType() != AnimaXLoaderResponse.Type.ERROR) goto L8;
        Throwable r0 = (Throwable) this.a.b;
        if (r0 != null) goto L7;
        return NameKeys.UnloadStrategy_No_Strategy;
    L7:
        return r0.getMessage();
    L8:
        return NameKeys.UnloadStrategy_No_Strategy;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public String getFilePath() {
        return (String) this.a.b;
    }

    public int getType() {
        return this.a.getType().ordinal();
    }

    public AnimaXLoaderResponseNativeAdapter(AnimaXLoaderResponse<?> r1) {
        this.a = r1;
    }
}
