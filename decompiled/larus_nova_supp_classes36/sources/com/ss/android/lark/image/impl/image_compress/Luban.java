package com.ss.android.lark.image.impl.image_compress;

import android.content.Context;
import android.graphics.Bitmap;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ss.android.lark.log.Log;
import io.reactivex.Observable;
import java.io.File;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public class Luban {
    private static String DEFAULT_DISK_CACHE_DIR = "luban_disk_cache";
    private LubanBuilder mBuilder;
    private File mFile;
    private List<File> mFileList;

    public Observable<File> asObservable() {
        return new LubanCompresser(this.mBuilder).singleAction(this.mFile);
    }

    private Luban(File r2) {
        this.mBuilder = new LubanBuilder(r2);
    }

    private static File getPhotoCacheDir(Context r1) {
        return getPhotoCacheDir(r1, DEFAULT_DISK_CACHE_DIR);
    }

    public Luban putGear(int r2) {
        this.mBuilder.gear = r2;
        return this;
    }

    public Luban setCompressFormat(Bitmap.CompressFormat r2) {
        this.mBuilder.compressFormat = r2;
        return this;
    }

    public Luban setMaxSize(int r2) {
        this.mBuilder.maxSize = r2;
        return this;
    }

    public static Luban compress(Context r1, File r2) {
        Luban r0 = new Luban(getPhotoCacheDir(r1));
        r0.mFile = r2;
        r0.mFileList = Collections.singletonList(r2);
        return r0;
    }

    private static File getPhotoCacheDir(Context r2, String r3) {
        File r4 = r2.getCacheDir();
        if (r4 == null) goto L12;
        PolarisFileWrapper r1 = new PolarisFileWrapper(r4, r3);
        if (r1.mkdirs() == false) goto L7;
    L11:
        return r1;
    L7:
        if (r1.exists() == true) goto L9;
    L10:
        return null;
    L9:
        if (r1.isDirectory() == true) goto L11;
    L12:
        Log.e("Luban", "default disk cache dir is null");
        return null;
    }
}
