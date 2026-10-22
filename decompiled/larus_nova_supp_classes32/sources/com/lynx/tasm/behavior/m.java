package com.lynx.tasm.behavior;

import android.content.Context;
import javax.xml.transform.Transformer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public interface m {

    public interface a {
        void a(Object r1, Throwable r2);
    }

    void loadImage(Context r1, String r2, String r3, float r4, float r5, Transformer r6, a r7);

    String shouldRedirectImageUrl(String r1);
}
