package org.apache.commons.compress.compressors.pack200;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.OpenOption;

/* JADX INFO: loaded from: classes6.dex */
class TempFileCachingStreamBridge extends StreamBridge {
    private final File f;

    TempFileCachingStreamBridge() {
        File r0 = File.createTempFile("commons-compress", "packtemp");
        this.f = r0;
        r0.deleteOnExit();
        this.out = Files.newOutputStream(r0.toPath(), new OpenOption[0]);
    }
}
