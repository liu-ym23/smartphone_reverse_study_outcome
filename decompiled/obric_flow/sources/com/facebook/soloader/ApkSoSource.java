package com.facebook.soloader;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Parcel;
import java.io.File;

/* JADX INFO: loaded from: classes2.dex */
public class ApkSoSource extends ExtractFromZipSoSource {
    public final int g;

    public class ApkUnpacker extends ExtractFromZipSoSource.ZipUnpacker {
        public final File e;
        public final int f;
        public final /* synthetic */ ApkSoSource g;

        public ApkUnpacker(ApkSoSource r5, ApkSoSource r10) {
            this.g = r5;
            super(r5, r10);
            this.e = new File(r5.f8483c.getApplicationInfo().nativeLibraryDir);
            this.f = r5.g;
        }
    }

    public ApkSoSource(Context r5, File r10, String r11) {
        super(r5, r11, r10);
        this.g = 1;
    }

    @Override // com.facebook.soloader.UnpackingSoSource
    public final byte[] a() {
        File r5 = this.e.getCanonicalFile();
        Parcel r10 = Parcel.obtain();
        r10.writeByte((byte) 2);     // Catch: Throwable -> L8
        r10.writeString(r5.getPath());     // Catch: Throwable -> L8
        r10.writeLong(r5.lastModified());     // Catch: Throwable -> L8
        Context r11 = this.f8483c;     // Catch: Throwable -> L8
        PackageManager r12 = r11.getPackageManager();     // Catch: Throwable -> L8
        if (r12 != null) goto L33;
    L10:
        int r13 = 0;
    L11:
        r10.writeInt(r13);     // Catch: Throwable -> L8
        if ((this.g & 1) != 0) goto L16;
        r10.writeByte((byte) 0);     // Catch: Throwable -> L8
        byte[] r14 = r10.marshall();     // Catch: Throwable -> L8
        r10.recycle();
        return r14;
    L16:
        String r15 = this.f8483c.getApplicationInfo().nativeLibraryDir;     // Catch: Throwable -> L8
        if (r15 != null) goto L21;
        r10.writeByte((byte) 1);     // Catch: Throwable -> L8
        byte[] r16 = r10.marshall();     // Catch: Throwable -> L8
        r10.recycle();
        return r16;
    L21:
        File r17 = new File(r15).getCanonicalFile();     // Catch: Throwable -> L8
        if (r17.exists() == true) goto L26;
        r10.writeByte((byte) 1);     // Catch: Throwable -> L8
        byte[] r18 = r10.marshall();     // Catch: Throwable -> L8
        r10.recycle();
        return r18;
    L26:
        r10.writeByte((byte) 2);     // Catch: Throwable -> L8
        r10.writeString(r17.getPath());     // Catch: Throwable -> L8
        r10.writeLong(r17.lastModified());     // Catch: Throwable -> L8
        byte[] r19 = r10.marshall();     // Catch: Throwable -> L8
        r10.recycle();
        return r19;
    L33:
        r13 = r12.getPackageInfo(r11.getPackageName(), 0).versionCode;     // Catch: Throwable -> L8 Throwable -> L31
    L8:
        th = move-exception;
        r10.recycle();
        throw th;
    }

    @Override // com.facebook.soloader.UnpackingSoSource
    public final UnpackingSoSource.Unpacker b() {
        return new ApkUnpacker(this, this);
    }
}
