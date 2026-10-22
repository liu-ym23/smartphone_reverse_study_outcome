package io.noties.markwon.html;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.IOException;

/* JADX INFO: loaded from: classes6.dex */
abstract class a {
    static void a(Appendable r2, char r3) {
        ((Appendable) ZeusTransformUtils.wrapperContextForParams(r2, Appendable.class, "com.obric.memorydata.plugin")).append(r3);     // Catch: IOException -> L5
        return;
    L5:
        e = move-exception;
        throw new RuntimeException(e);
    }

    static void a(Appendable r2, CharSequence r3) {
        ((Appendable) ZeusTransformUtils.wrapperContextForParams(r2, Appendable.class, "com.obric.memorydata.plugin")).append((CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin"));     // Catch: IOException -> L5
        return;
    L5:
        e = move-exception;
        throw new RuntimeException(e);
    }
}
