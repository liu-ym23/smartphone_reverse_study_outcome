package com.ss.android.lark.image.impl.compress2;

import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
class FileImageSource implements IImageSource {
    private File file;

    @Override // com.ss.android.lark.image.impl.compress2.IImageSource
    public String uniqueKey() {
        return String.format("%s_%s_%s", new Object[]{this.file.getPath(), Long.valueOf(this.file.length()), Long.valueOf(this.file.lastModified())});
    }

    @Override // com.ss.android.lark.image.impl.compress2.IImageSource
    public String getPath() {
        return this.file.getAbsolutePath();
    }

    @Override // com.ss.android.lark.image.impl.compress2.IImageSource
    public InputStream open() throws IOException {
        return new PolarisFileInputStreamWrapper(this.file);
    }

    public FileImageSource(File r1) {
        this.file = r1;
    }
}
