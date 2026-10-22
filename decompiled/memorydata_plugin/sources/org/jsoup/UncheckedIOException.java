package org.jsoup;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.IOException;

/* JADX INFO: loaded from: classes7.dex */
public class UncheckedIOException extends RuntimeException {
    public UncheckedIOException(IOException r1) {
        super(r1);
    }

    public UncheckedIOException(String r2) {
        super(new IOException(r2));
    }

    public IOException ioException() {
        return (IOException) ZeusTransformUtils.preCheckCast(getCause(), IOException.class, "com.obric.memorydata.plugin");
    }
}
