package com.ss.android.lark.imagewidget.subsampling.decoder.custom;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import com.larksuite.framework.utils.FileUtils;
import com.ss.android.lark.imagewidget.subsampling.decoder.SkiaImageDecoder;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public class MSkiaImageDecoder extends SkiaImageDecoder {
    private static final String FILE_PREFIX = "file://";
    public boolean mIsSecret;

    public MSkiaImageDecoder() {
        this.mIsSecret = false;
    }

    public MSkiaImageDecoder(Bitmap.Config r1) {
        super(r1);
        this.mIsSecret = false;
    }

    @Override // com.ss.android.lark.imagewidget.subsampling.decoder.SkiaImageDecoder, rlb.c
    public Bitmap decode(Context r2, Uri r3) throws Exception {
        Bitmap r4 = super.decode(r2, r3);
        if (this.mIsSecret == false) goto L7;
        String r5 = r3.toString();
        if (r5.startsWith("file://") == false) goto L7;
        FileUtils.g(r5.substring(7));
    L7:
        return r4;
    }
}
