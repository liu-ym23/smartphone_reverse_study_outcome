package hf;

import ai.j0;
import android.util.Log;
import androidx.core.view.PointerIconCompat;
import cn.nubia.neopush.commons.Constant;
import com.bytedance.geckox.utils.BsPatch;
import com.bytedance.geckox.utils.MD5Utils;
import com.bytedance.iesgurd.exception.BytePatchException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import okhttp3.internal.ws.WebSocketProtocol;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final HashMap f17302h = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HashSet f17303a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public RandomAccessFile f17304b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public File f17305c;
    public File d;
    public File e;
    public int f;
    public String g;

    static {
        HashMap r5 = new HashMap();
        f17302h = r5;
        r5.put(1, "modify");
        r5.put(2, Constant.ClientMessageType.DELETE);
        r5.put(3, "add");
        r5.put(4, "rename");
        r5.put(5, "rewrite");
        r5.put(6, "same");
    }

    public a() {
        this.f17303a = new HashSet();
        this.g = "";
    }

    public final void a() {
    L2:
        RandomAccessFile r5 = this.f17304b;
        if (r5 != null) goto L5;
        Intrinsics.throwNpe();
    L5:
        long r10 = r5.getFilePointer();
        RandomAccessFile r11 = this.f17304b;
        if (r11 != null) goto L9;
        Intrinsics.throwNpe();
    L9:
        if (r10 == r11.length()) goto L10;
        RandomAccessFile r12 = this.f17304b;
        if (r12 != null) goto L14;
        Intrinsics.throwNpe();
    L14:
        String r13 = r12.readUTF();
        if (r13.length() == 0) goto L57;
        this.f17303a.add(r13);
        File r14 = new File(this.f17305c, r13);
        if (StringsKt.P(r13, "__MACOSX/") == true) goto L2;
        if (Intrinsics.areEqual(r13, ".DS_Store") == true) goto L2;
        RandomAccessFile r15 = this.f17304b;
        if (r15 != null) goto L24;
        Intrinsics.throwNpe();
    L24:
        byte r16 = r15.readByte();
        StringCompanionObject r17 = StringCompanionObject.INSTANCE;
        HashMap r18 = f17302h;
        this.g = String.format("patch failed, type:%s, path:%s, detail:", Arrays.copyOf(new Object[]{r18.get(Integer.valueOf(r16)), r13}, 2));
        switch(r16) {
            case 1: goto L55;
            case 2: goto L2;
            case 3: goto L45;
            case 4: goto L37;
            case 5: goto L29;
            case 6: goto L28;
            default: goto L27;
        };
    L27:
        throw new BytePatchException(PointerIconCompat.TYPE_CELL, j0.q(new StringBuilder(), this.g, "not support change type"));
    L28:
        g(r14, r13);
        goto L2
    L29:
        RandomAccessFile r19 = this.f17304b;
        if (r19 != null) goto L32;
        Intrinsics.throwNpe();
    L32:
        String r20 = r19.readUTF();
        if (r20.length() == 0) goto L36;
        this.g = String.format("patch failed, type:%s, path:%s, newPath: %s, detail:", Arrays.copyOf(new Object[]{r18.get(Integer.valueOf(r16)), r13, r20}, 3));
        e(r14, r20);
        goto L2
    L36:
        throw new BytePatchException(PointerIconCompat.TYPE_CELL, j0.q(new StringBuilder(), this.g, "read path is nil"));
    L37:
        RandomAccessFile r21 = this.f17304b;
        if (r21 != null) goto L40;
        Intrinsics.throwNpe();
    L40:
        String r22 = r21.readUTF();
        if (r22.length() == 0) goto L44;
        g(r14, r22);
        goto L2
    L44:
        throw new BytePatchException(PointerIconCompat.TYPE_CELL, j0.q(new StringBuilder(), this.g, "read path is nil"));
    L45:
        File r23 = new File(this.d, r13);
        b(r23.getParentFile());
        h(r23);
        if (this.f != 0) goto L2;
        byte[] r24 = new byte[32];
        RandomAccessFile r25 = this.f17304b;
        if (r25 != null) goto L50;
        Intrinsics.throwNpe();
    L50:
        r25.readFully(r24);
        String r26 = new String(r24, Charsets.UTF_8);
        String r27 = MD5Utils.INSTANCE.getMD5$geckox_noasanRelease(r23);
        if (Intrinsics.areEqual(r27, r26) == true) goto L2;
        StringBuilder r28 = new StringBuilder();
        f8.b.e(r28, this.g, "md5 check failed, local md5:", r27, ", expect md5:");
        r28.append(r26);
        throw new BytePatchException(PointerIconCompat.TYPE_COPY, r28.toString());
    L55:
        e(r14, r13);
        goto L2
    L57:
        throw new BytePatchException(PointerIconCompat.TYPE_CELL, "read path is empty");
    }

    public final void b(File r5) {
    L9:
        e = move-exception;
        throw new BytePatchException(PointerIconCompat.TYPE_NO_DROP, this.g + e.getMessage());
    L3:
        if (r5.exists() == false) goto L12;
        if (r5.isFile() == true) goto L8;
        return;
    L8:
        throw new RuntimeException("create dir failed: path is a file");     // Catch: Exception -> L9
    L12:
        if (r5.mkdirs() == false) goto L15;
        return;
    L15:
        throw new RuntimeException("create dir failed: " + r5.getPath());     // Catch: Exception -> L9
    }

    public final void c(File r17, File r18) {
        b(r18.getParentFile());
        FileChannel r5 = null;
        FileChannel r10 = new FileInputStream(r17).getChannel();     // Catch: Throwable -> L17 Exception -> L19
        r5 = new FileOutputStream(r18).getChannel();     // Catch: Throwable -> L11 Exception -> L13
        long r12 = r10.size();     // Catch: Throwable -> L11 Exception -> L13
        long r14 = 0;
    L6:
        if (r12 <= 0) goto L15;
        long r11 = r10.transferTo(r14, r12, r5);     // Catch: Throwable -> L11 Exception -> L13
    L9:
        if (r11 <= 0) goto L6;
        r14 = r14 + r11;
        r12 = r12 - r11;
        goto L6
    L15:
        com.bytedance.geckox.utils.d.c(r10);
        com.bytedance.geckox.utils.d.c(r5);
        return;
    L13:
        e = e;
        FileChannel r13 = r5;
        r5 = r10;
    L27:
    L23:
        th = th;
        r10 = r5;
        r5 = r13;
    L25:
        com.bytedance.geckox.utils.d.c(r10);
        com.bytedance.geckox.utils.d.c(r5);
        throw th;
    L22:
        throw new BytePatchException(PointerIconCompat.TYPE_NO_DROP, this.g + e.getMessage());     // Catch: Throwable -> L23
    L11:
        th = th;
        goto L25
    L19:
        e = e;
        r13 = null;
    L17:
        th = th;
        r10 = null;
        goto L25
    }

    public final void d(File r5, File r10, File r11) {
        if (r5 != null) goto L5;
    L67:
        StringBuilder r12 = new StringBuilder("param src error: ");
        if (r5 != null) goto L70;
        Intrinsics.throwNpe();
    L70:
        r12.append(r5.getPath());
        throw new BytePatchException(1000, r12.toString());
    L5:
        if (r5.exists() == false) goto L67;
        if (r5.isFile() == true) goto L67;
        if (r11 != null) goto L11;
    L62:
        StringBuilder r13 = new StringBuilder("param patch error: ");
        if (r11 != null) goto L65;
        Intrinsics.throwNpe();
    L65:
        r13.append(r11.getPath());
        throw new BytePatchException(1000, r13.toString());
    L11:
        if (r11.exists() == false) goto L62;
        if (r11.isDirectory() == true) goto L62;
        if (r10.exists() == false) goto L23;
        if (r10.isFile() == false) goto L23;
        throw new BytePatchException(1000, "param dest error,  is a file: " + r10.getPath());
    L23:
        if (r10.exists() == true) goto L25;
    L31:
        this.f17305c = r5;
        this.d = r10;
        this.e = r11;
        RandomAccessFile r14 = new RandomAccessFile(this.e, "rw");     // Catch: Throwable -> L37 Exception -> L39 BytePatchException -> L41
        this.f17304b = r14;     // Catch: Throwable -> L37 Exception -> L39 BytePatchException -> L41
        byte[] r15 = new byte[8];     // Catch: Throwable -> L37 Exception -> L39 BytePatchException -> L41
        r14.readFully(r15);     // Catch: Throwable -> L37 Exception -> L39 BytePatchException -> L41
        Charset r16 = Charsets.UTF_8;     // Catch: Throwable -> L37 Exception -> L39 BytePatchException -> L41
        if (Intrinsics.areEqual("BYTEDIFF", new String(r15, r16)) == false) goto L55;
        RandomAccessFile r17 = this.f17304b;     // Catch: Throwable -> L37 Exception -> L39 BytePatchException -> L41
        if (r17 != null) goto L43;
        Intrinsics.throwNpe();     // Catch: Throwable -> L37 Exception -> L39 BytePatchException -> L41
    L43:
        byte r18 = r17.readByte();     // Catch: Throwable -> L37 Exception -> L39 BytePatchException -> L41
        if (r18 > 1) goto L53;
        if (r18 < 0) goto L53;
        this.f = r18;     // Catch: Throwable -> L37 Exception -> L39 BytePatchException -> L41
        a();     // Catch: Throwable -> L37 Exception -> L39 BytePatchException -> L41
        this.g = "";     // Catch: Throwable -> L37 Exception -> L39 BytePatchException -> L41
        if (r18 != 0) goto L49;
        f(this.f17305c);     // Catch: Throwable -> L37 Exception -> L39 BytePatchException -> L41
    L49:
        Log.d("BytePatch", "patch success");     // Catch: Throwable -> L37 Exception -> L39 BytePatchException -> L41
        com.bytedance.geckox.utils.d.c(this.f17304b);
        return;
    L53:
        throw new BytePatchException(WebSocketProtocol.CLOSE_NO_STATUS_CODE, "unsupported version: " + r18);     // Catch: Throwable -> L37 Exception -> L39 BytePatchException -> L41
    L55:
        throw new BytePatchException(WebSocketProtocol.CLOSE_NO_STATUS_CODE, "not bytediff file: ".concat(new String(r15, r16)));     // Catch: Throwable -> L37 Exception -> L39 BytePatchException -> L41
    L37:
        th = move-exception;
        com.bytedance.geckox.utils.d.c(this.f17304b);
        throw th;
    L41:
        e = move-exception;
        com.bytedance.geckox.utils.d.j(this.d);     // Catch: Throwable -> L37
        throw e;     // Catch: Throwable -> L37
    L39:
        e = move-exception;
        com.bytedance.geckox.utils.d.j(this.d);     // Catch: Throwable -> L37
        throw new BytePatchException(1099, this.g + e.getMessage());     // Catch: Throwable -> L37
    L25:
        if (r10.isDirectory() == false) goto L31;
        if (com.bytedance.geckox.utils.d.j(r10) == true) goto L31;
        throw new BytePatchException(1000, "param dest error, remove failed: " + r10.getPath());
    }

    public final void e(File r5, String r10) {
        if (r5.exists() == false) goto L29;
        File r11 = new File(this.d, r10);
        b(r11.getParentFile());
        File r12 = this.e;
        if (r12 != null) goto L7;
        Intrinsics.throwNpe();
    L7:
        File r13 = new File(r12.getParentFile(), "bytepatch_patch_temp_file");
        h(r13);
        BsPatch r14 = BsPatch.f4780a;     // Catch: Exception -> L11
        File r15 = this.d;     // Catch: Exception -> L11
        if (r15 != null) goto L13;
        Intrinsics.throwNpe();     // Catch: Exception -> L11
    L13:
        r14.a(r5, r13, r15, r10);     // Catch: Exception -> L11
        r13.delete();
        byte[] r16 = new byte[32];
        RandomAccessFile r17 = this.f17304b;
        if (r17 != null) goto L17;
        Intrinsics.throwNpe();
    L17:
        r17.readFully(r16);
        String r18 = new String(r16, Charsets.UTF_8);
        MD5Utils r19 = MD5Utils.INSTANCE;
        String r20 = r19.getMD5$geckox_noasanRelease(r11);
        if (Intrinsics.areEqual(r20, r18) == false) goto L20;
        return;
    L20:
        if (Intrinsics.areEqual(r19.getMD5$geckox_noasanRelease(r5), r18) == true) goto L22;
        StringBuilder r21 = new StringBuilder();
        f8.b.e(r21, this.g, "md5 check failed, local md5:", r20, ", expect md5:");
        r21.append(r18);
        throw new BytePatchException(PointerIconCompat.TYPE_COPY, r21.toString());
    L22:
        throw new BytePatchException(1024, j0.q(new StringBuilder(), this.g, "old file is same"));
    L11:
        e = move-exception;
        throw new BytePatchException(PointerIconCompat.TYPE_ALIAS, this.g + "bspatch error:" + e.getMessage());
    L29:
        throw new BytePatchException(PointerIconCompat.TYPE_CELL, j0.q(new StringBuilder(), this.g, "path not exists: "));
    }

    public final void f(File r10) {
        if (r10 != null) goto L4;
        Intrinsics.throwNpe();
    L4:
        File[] r11 = r10.listFiles();
        if (r11 == null) goto L24;
        int r5 = r11.length;
        int r12 = 0;
    L7:
        if (r12 >= r5) goto L31;
        File r13 = r11[r12];
        if (r13.isFile() == false) goto L22;
        File r14 = this.f17305c;
        String r15 = r13.getAbsolutePath();
        if (r14 != null) goto L13;
        Intrinsics.throwNpe();
    L13:
        int r16 = r14.getAbsolutePath().length() + 1;
        if (r15 == null) goto L21;
        String r17 = r15.substring(r16);
        if (this.f17303a.contains(r17) == true) goto L23;
        if (StringsKt.k(r17, ".gkfsf") == true) goto L23;
        c(r13, new File(this.d, r17));
    L23:
        r12 = r12 + 1;
        goto L7
    L21:
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
    L22:
        f(r13);
        goto L23
    L31:
        return;
    }

    public final void g(File r10, String r11) {
        if (r10.exists() == false) goto L19;
        File r5 = new File(this.d, r11);
        c(r10, r5);
        if (this.f != 0) goto L17;
        byte[] r12 = new byte[32];
        RandomAccessFile r13 = this.f17304b;
        if (r13 != null) goto L9;
        Intrinsics.throwNpe();
    L9:
        r13.readFully(r12);
        String r14 = new String(r12, Charsets.UTF_8);
        MD5Utils r15 = MD5Utils.INSTANCE;
        String r16 = r15.getMD5$geckox_noasanRelease(r5);
        if (Intrinsics.areEqual(r16, r14) == true) goto L20;
        String r17 = r15.getMD5$geckox_noasanRelease(r10);
        if (Intrinsics.areEqual(r17, r16) == true) goto L15;
        StringBuilder r18 = new StringBuilder();
        f8.b.e(r18, this.g, "copy error, old file md5:", r17, ", new file md5:");
        throw new BytePatchException(PointerIconCompat.TYPE_ALL_SCROLL, f4.b.b(r18, r16, ", expect md5:", r14));
    L15:
        StringBuilder r19 = new StringBuilder();
        f8.b.e(r19, this.g, "md5 check failed, local md5:", r16, ", expect md5:");
        r19.append(r14);
        throw new BytePatchException(PointerIconCompat.TYPE_COPY, r19.toString());
    L20:
        return;
    L17:
        return;
    L19:
        throw new BytePatchException(PointerIconCompat.TYPE_CELL, j0.q(new StringBuilder(), this.g, "path not exists: "));
    }

    public final void h(File r13) {
        if (r13.exists() == true) goto L5;
    L9:
        FileOutputStream r5 = null;
        RandomAccessFile r10 = this.f17304b;     // Catch: Throwable -> L13 Exception -> L15
        if (r10 != null) goto L17;
        Intrinsics.throwNpe();     // Catch: Throwable -> L13 Exception -> L15
    L17:
        long r11 = r10.readLong();     // Catch: Throwable -> L13 Exception -> L15
        FileOutputStream r12 = new FileOutputStream(r13);     // Catch: Throwable -> L13 Exception -> L15
        byte[] r14 = new byte[8192];     // Catch: Throwable -> L27 Exception -> L29
        long r15 = 0;
    L21:
        if (r15 >= r11) goto L36;
        long r16 = r11 - r15;     // Catch: Throwable -> L27 Exception -> L29
        long r17 = 8192;
        if (r16 < r17) goto L32;
        r15 = r15 + r17;     // Catch: Throwable -> L27 Exception -> L29
        RandomAccessFile r18 = this.f17304b;     // Catch: Throwable -> L27 Exception -> L29
        if (r18 != null) goto L31;
        Intrinsics.throwNpe();     // Catch: Throwable -> L27 Exception -> L29
    L31:
        r18.readFully(r14);     // Catch: Throwable -> L27 Exception -> L29
        r12.write(r14);     // Catch: Throwable -> L27 Exception -> L29
        goto L21
    L32:
        RandomAccessFile r19 = this.f17304b;     // Catch: Throwable -> L27 Exception -> L29
        if (r19 != null) goto L35;
        Intrinsics.throwNpe();     // Catch: Throwable -> L27 Exception -> L29
    L35:
        int r20 = (int) r16;     // Catch: Throwable -> L27 Exception -> L29
        r19.readFully(r14, 0, r20);     // Catch: Throwable -> L27 Exception -> L29
        r12.write(r14, 0, r20);     // Catch: Throwable -> L27 Exception -> L29
    L36:
        com.bytedance.geckox.utils.d.c(r12);
        return;
    L29:
        e = e;
        r5 = r12;
    L40:
        throw new BytePatchException(PointerIconCompat.TYPE_CROSSHAIR, this.g + e.getMessage());     // Catch: Throwable -> L13
    L27:
        th = th;
    L42:
        com.bytedance.geckox.utils.d.c(r12);
        throw th;
    L15:
        e = e;
    L13:
        th = th;
        r12 = r5;
        goto L42
    L5:
        if (r13.delete() == true) goto L9;
        throw new BytePatchException(PointerIconCompat.TYPE_CROSSHAIR, this.g + "remove old file error: " + r13.getPath());
    }
}
