package com.bytedance.common.utility.io;

import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.g;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;

/* JADX INFO: loaded from: classes.dex */
public final class FileUtils {

    public static final enum ImageType extends Enum<ImageType> {
        private static final /* synthetic */ ImageType[] $VALUES = null;
        public static final ImageType GIF = null;
        public static final ImageType JPG = null;
        public static final ImageType PNG = null;
        public static final ImageType UNKNOWN = null;

        static {
            ImageType r10 = new ImageType("UNKNOWN", 0);
            UNKNOWN = r10;
            ImageType r11 = new ImageType("JPG", 1);
            JPG = r11;
            ImageType r12 = new ImageType("PNG", 2);
            PNG = r12;
            ImageType r13 = new ImageType("GIF", 3);
            GIF = r13;
            $VALUES = new ImageType[]{r10, r11, r12, r13};
        }

        private ImageType(String r10, int r11) {
            super(r10, r11);
        }

        public static ImageType valueOf(String r10) {
            return (ImageType) Enum.valueOf(ImageType.class, r10);
        }

        public static ImageType[] values() {
            return (ImageType[]) $VALUES.clone();
        }
    }

    static {
    }

    public static boolean a(String r10, String r11, String r12) {
        if (g.b(r10) == false) goto L5;
    L37:
        return false;
    L5:
        if (g.b(r11) == true) goto L37;
        if (g.b(r12) == true) goto L37;
        FileInputStream r13 = null;
        FileInputStream r14 = new FileInputStream(r10);     // Catch: Throwable -> L21 Exception -> L23
        boolean r15 = b(r14, r11, r12);     // Catch: Throwable -> L17 Exception -> L19
        r14.close();     // Catch: Exception -> L14
    L16:
        return r15;
    L14:
        e = move-exception;
        e.printStackTrace();
        goto L16
    L19:
        e = e;
        r13 = r14;
    L24:
        e.printStackTrace();     // Catch: Throwable -> L21
        if (r13 != null) goto L40;
    L30:
        return false;
    L40:
        r13.close();     // Catch: Exception -> L28
    L28:
        e = move-exception;
        e.printStackTrace();
    L17:
        th = th;
        r13 = r14;
    L31:
        if (r13 != null) goto L42;
    L36:
        throw th;
    L42:
        r13.close();     // Catch: Exception -> L34
    L34:
        e = move-exception;
        e.printStackTrace();
    L23:
        e = e;
    L21:
        th = th;
        goto L31
    }

    public static boolean b(InputStream r10, String r11, String r12) {
        if (r10 != null) goto L5;
        return false;
    L5:
        FileOutputStream r13 = null;
        File r14 = new File(r11);     // Catch: Throwable -> L33 Exception -> L35
        if (r14.exists() == false) goto L9;
    L15:
        FileOutputStream r15 = new FileOutputStream(new File(r14, r12));     // Catch: Throwable -> L33 Exception -> L35
        byte[] r16 = new byte[1024];     // Catch: Throwable -> L29 Exception -> L31
    L18:
        int r17 = r10.read(r16);     // Catch: Throwable -> L29 Exception -> L31
        if (r17 == (-1)) goto L21;
        r15.write(r16, 0, r17);     // Catch: Throwable -> L29 Exception -> L31
        goto L18
    L21:
        r15.flush();     // Catch: Throwable -> L29 Exception -> L31
        r15.close();     // Catch: Throwable -> L29 Exception -> L31
        r10.close();     // Catch: Throwable -> L33 Exception -> L35
        r10.close();     // Catch: Exception -> L25
        return true;
    L25:
        e = move-exception;
        e.printStackTrace();
        return true;
    L31:
        e = e;
        r13 = r15;
    L36:
        Logger.d("FileUtils", "save inputstream error: " + e);     // Catch: Throwable -> L33
        if (r13 == null) goto L62;
        r13.close();     // Catch: Exception -> L52
    L62:
        r10.close();     // Catch: Exception -> L41
    L43:
        return false;
    L41:
        e = move-exception;
        e.printStackTrace();
    L29:
        th = th;
        r13 = r15;
    L44:
        if (r13 == null) goto L65;
        r13.close();     // Catch: Exception -> L51
    L65:
        r10.close();     // Catch: Exception -> L48
        throw th;
    L48:
        e = move-exception;
        e.printStackTrace();
        throw th;
    L9:
        if (r14.mkdirs() == true) goto L15;
        r10.close();     // Catch: Exception -> L12
    L14:
        return false;
    L12:
        e = move-exception;
        e.printStackTrace();
    L33:
        th = th;
    L35:
        e = e;
        goto L36
    }
}
