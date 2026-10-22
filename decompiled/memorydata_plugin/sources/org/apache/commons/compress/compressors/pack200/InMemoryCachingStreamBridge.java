package org.apache.commons.compress.compressors.pack200;

import java.io.ByteArrayOutputStream;

/* JADX INFO: loaded from: classes6.dex */
class InMemoryCachingStreamBridge extends StreamBridge {
    InMemoryCachingStreamBridge() {
        super(new ByteArrayOutputStream());
    }
}
