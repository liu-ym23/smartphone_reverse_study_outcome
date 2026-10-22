package com.bytedance.common.utility.io;

import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.h;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import org.msgpack.core.MessagePack;

/* JADX INFO: loaded from: classes.dex */
public final class FileUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final byte[] f1989a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final byte[] f1990b = null;
    private static final byte[] c = null;
    private static final byte[] d = null;

    public static final enum ImageType extends Enum<ImageType> {
        private static final /* synthetic */ ImageType[] $VALUES = null;
        public static final ImageType GIF = null;
        public static final ImageType JPG = null;
        public static final ImageType PNG = null;
        public static final ImageType UNKNOWN = null;

        static {
            ImageType r0 = new ImageType("UNKNOWN", 0);
            UNKNOWN = r0;
            ImageType r1 = new ImageType("JPG", 1);
            JPG = r1;
            ImageType r3 = new ImageType("PNG", 2);
            PNG = r3;
            ImageType r5 = new ImageType("GIF", 3);
            GIF = r5;
            $VALUES = new ImageType[]{r0, r1, r3, r5};
        }

        private ImageType(String r1, int r2) {
            super(r1, r2);
        }

        public static ImageType valueOf(String r2) {
            return (ImageType) ZeusTransformUtils.preCheckCast(Enum.valueOf(ImageType.class, r2), ImageType.class, "com.obric.memorydata.plugin");
        }

        public static ImageType[] values() {
            return (ImageType[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), ImageType[].class, "com.obric.memorydata.plugin");
        }
    }

    static {
        f1989a = new byte[]{71, 73, 70, 56, 55, 97};
        f1990b = new byte[]{71, 73, 70, 56, 57, 97};
        c = new byte[]{-1, MessagePack.Code.FIXEXT16, -1};
        d = new byte[]{-119, 80, 78, 71, 13, 10, 26, 10};
    }

    public static boolean a(InputStream r4, String r5, String r6) {
        if (r4 != null) goto L5;
        return false;
    L5:
        FileOutputStream r1 = null;
        File r2 = new File(r5);     // Catch: Throwable -> L35 Exception -> L37
        if (r2.exists() == false) goto L9;
    L16:
        FileOutputStream r7 = new FileOutputStream(new File(r2, r6));     // Catch: Throwable -> L35 Exception -> L37
        byte[] r8 = new byte[1024];     // Catch: Throwable -> L31 Exception -> L33
    L19:
        int r3 = r4.read(r8);     // Catch: Throwable -> L31 Exception -> L33
        if (r3 == (-1)) goto L22;
        r7.write(r8, 0, r3);     // Catch: Throwable -> L31 Exception -> L33
        goto L19
    L22:
        r7.flush();     // Catch: Throwable -> L31 Exception -> L33
        r7.close();     // Catch: Throwable -> L31 Exception -> L33
        r4.close();     // Catch: Throwable -> L35 Exception -> L37
        if (r4 == null) goto L76;
        r4.close();     // Catch: Exception -> L27
        return true;
    L27:
        e = move-exception;
        e.printStackTrace();
        return true;
    L76:
        return true;
    L33:
        e = e;
        r1 = r7;
    L38:
        Logger.d("FileUtils", "save inputstream error: " + e);     // Catch: Throwable -> L35
        if (r1 != null) goto L67;
    L41:
        if (r4 != null) goto L59;
    L46:
        return false;
    L59:
        r4.close();     // Catch: Exception -> L44
    L44:
        e = move-exception;
        e.printStackTrace();
        goto L46
    L67:
        r1.close();     // Catch: Exception -> L56
    L31:
        th = th;
        r1 = r7;
    L47:
        if (r1 != null) goto L69;
    L49:
        if (r4 == null) goto L74;
        r4.close();     // Catch: Exception -> L52
        throw th;
    L52:
        e = move-exception;
        e.printStackTrace();
        throw th;
    L74:
        throw th;
    L69:
        r1.close();     // Catch: Exception -> L55
        goto L49
    L9:
        if (r2.mkdirs() == true) goto L16;
        if (r4 != null) goto L57;
    L15:
        return false;
    L57:
        r4.close();     // Catch: Exception -> L13
    L13:
        e = move-exception;
        e.printStackTrace();
    L35:
        th = th;
    L37:
        e = e;
        goto L38
    }

    public static boolean a(String r3, String r4, String r5) {
        if (h.a(r3) == false) goto L5;
    L37:
        return false;
    L5:
        if (h.a(r4) == true) goto L37;
        if (h.a(r5) == true) goto L37;
        FileInputStream r0 = null;
        FileInputStream r2 = new FileInputStream(r3);     // Catch: Throwable -> L21 Exception -> L23
        boolean r6 = a(r2, r4, r5);     // Catch: Throwable -> L17 Exception -> L19
        r2.close();     // Catch: Exception -> L14
    L16:
        return r6;
    L14:
        e = move-exception;
        e.printStackTrace();
        goto L16
    L19:
        e = e;
        r0 = r2;
    L24:
        e.printStackTrace();     // Catch: Throwable -> L21
        if (r0 != null) goto L40;
    L30:
        return false;
    L40:
        r0.close();     // Catch: Exception -> L28
    L28:
        e = move-exception;
        e.printStackTrace();
    L17:
        th = th;
        r0 = r2;
    L31:
        if (r0 != null) goto L42;
    L36:
        throw th;
    L42:
        r0.close();     // Catch: Exception -> L34
    L34:
        e = move-exception;
        e.printStackTrace();
    L23:
        e = e;
    L21:
        th = th;
        goto L31
    }
}
