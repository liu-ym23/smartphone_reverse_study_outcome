package com.ss.android.lark.image.impl.album;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.larksuite.framework.utils.FileUtils;
import com.ss.android.lark.image.entity.AlbumSerialImage;
import com.ss.android.lark.image.impl.resource.ResourceImageDataFetcher;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.lark.utils.p;
import com.ss.android.lark.vfs.VFSFile;
import com.ss.android.lark.vfs.VFSFiles;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import wkb.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public class AlbumSerialImageDataFetcher extends ResourceImageDataFetcher<AlbumSerialImage> {
    private final int height;
    private final int width;

    @Override // com.ss.android.lark.image.impl.resource.ResourceImageDataFetcher
    public String getLogTag() {
        return "AlbumSerialImageDataFetcher";
    }

    private String getThumbPath(String r6) {
        if (TextUtils.isEmpty(r6) == false) goto L6;
        return "";
    L6:
        VFSFile r0 = VFSFiles.b.i(r6);
        return b.a().getRealPath() + File.separator + r6.hashCode() + "_" + r0.lastModified() + "_" + (this.width + "*" + this.height) + ".jpg";
    }

    /* JADX INFO: renamed from: getResourceStream, reason: avoid collision after fix types in other method */
    public InputStream getResourceStream2(AlbumSerialImage r6) {
        if (r6 != null) goto L5;
        return null;
    L5:
        String r7 = r6.getPath();
        String r1 = getThumbPath(r7);     // Catch: Exception -> L11
        if (FileUtils.r(r1) == true) goto L9;
        p.i((Bitmap) Glide.with(LarkContext.getApplication()).asBitmap().load(r7).override(this.width, this.height).diskCacheStrategy(DiskCacheStrategy.RESOURCE).submit().get(), r1, Bitmap.CompressFormat.JPEG, 75);     // Catch: Exception -> L11
    L9:
        return VFSFiles.b.k(r1);
    L11:
        e = move-exception;
        Log.e("AlbumSerialImageDataFetcher", "getResourceStream error: " + e.getMessage() + ", path: " + r7);
        return null;
    }

    @Override // com.ss.android.lark.image.impl.resource.ResourceImageDataFetcher
    public /* bridge */ /* synthetic */ InputStream getResourceStream(AlbumSerialImage r1) throws FileNotFoundException {
        return getResourceStream2(r1);
    }

    public AlbumSerialImageDataFetcher(AlbumSerialImage r1, int r2, int r3) {
        super(r1);
        this.width = r2;
        this.height = r3;
    }
}
