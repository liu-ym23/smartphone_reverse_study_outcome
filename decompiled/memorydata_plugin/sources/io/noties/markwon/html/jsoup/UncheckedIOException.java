package io.noties.markwon.html.jsoup;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.IOException;

/* JADX INFO: loaded from: classes6.dex */
public class UncheckedIOException extends RuntimeException {
    public UncheckedIOException(IOException r1) {
        super(r1);
    }

    public IOException ioException() {
        return (IOException) ZeusTransformUtils.preCheckCast(getCause(), IOException.class, "com.obric.memorydata.plugin");
    }
}
