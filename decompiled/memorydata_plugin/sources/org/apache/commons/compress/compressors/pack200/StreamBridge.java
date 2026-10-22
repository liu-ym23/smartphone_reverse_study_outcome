package org.apache.commons.compress.compressors.pack200;

import java.io.FilterOutputStream;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes6.dex */
abstract class StreamBridge extends FilterOutputStream {
    private final Object inputLock;

    public StreamBridge() {
        this(null);
    }

    public StreamBridge(OutputStream r1) {
        super(r1);
        this.inputLock = new Object();
    }
}
