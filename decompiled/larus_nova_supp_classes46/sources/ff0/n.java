package ff0;

import android.content.Context;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.IOException;
import java.io.InputStream;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class n {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void a(Context r12, String r13, PolarisFileWrapper r14) throws IOException {
        String[] r0 = r12.getAssets().list(r13);
        if (r0 != null) goto L6;
        return;
    L6:
        if (r14.exists() == true) goto L8;
        r14.mkdirs();
    L8:
        int r1 = r0.length;
        int r3 = 0;
    L9:
        if (r3 >= r1) goto L78;
        String r4 = r0[r3];
        if (r13.length() != 0) goto L13;
        boolean r5 = true;
    L14:
        if (r5 == false) goto L16;
        String r6 = r4;
    L17:
        String[] r7 = r12.getAssets().list(r6);
        if (r7 != null) goto L20;
    L26:
        boolean r8 = true;
    L27:
        if (r8 == false) goto L73;
        InputStream r9 = r12.getAssets().open(r6);
        int r10 = r4.length();     // Catch: Throwable -> L43
        int r11 = 0;
    L31:
        if (r11 >= r10) goto L39;
        if (r4.charAt(r11) != '_') goto L35;
        boolean r15 = true;
    L36:
        if (r15 == true) goto L40;
        r11 = r11 + 1;     // Catch: Throwable -> L43
    L40:
        String r16 = r4.substring(0, r11);     // Catch: Throwable -> L43
        String r17 = r4.substring(r11 + 1, r4.length());     // Catch: Throwable -> L43
        PolarisFileWrapper r18 = new PolarisFileWrapper(r14, r16);     // Catch: Throwable -> L43
        if (r18.exists() == false) goto L45;
        com.ss.ugc.effectplatform.util.i r19 = com.ss.ugc.effectplatform.util.i.a;     // Catch: Throwable -> L43
        String r20 = com.ss.ugc.effectplatform.util.i.d(r18.getAbsolutePath());     // Catch: Throwable -> L43
    L47:
        if (r18.exists() == false) goto L52;
        if (r20 == null) goto L52;
        if ((!Intrinsics.areEqual(r17, r20)) == true) goto L52;
    L62:
        Unit r21 = Unit.INSTANCE;     // Catch: Throwable -> L43
        CloseableKt.closeFinally(r9, null);
    L77:
        r3 = r3 + 1;
    L52:
        if (r18.exists() == false) goto L54;
        r18.delete();     // Catch: Throwable -> L43
    L54:
        r18.createNewFile();     // Catch: Throwable -> L43
        PolarisFileOutputStreamWrapper r22 = new PolarisFileOutputStreamWrapper(r18);     // Catch: Throwable -> L43
        byte[] r23 = new byte[1024];     // Catch: Throwable -> L64
    L57:
        int r24 = r9.read(r23);     // Catch: Throwable -> L64
        if (r24 == (-1)) goto L60;
        r22.write(r23, 0, r24);     // Catch: Throwable -> L64
        goto L57
    L60:
        r22.flush();     // Catch: Throwable -> L64
        Unit r25 = Unit.INSTANCE;     // Catch: Throwable -> L64
        CloseableKt.closeFinally(r22, null);     // Catch: Throwable -> L43
        goto L62
    L64:
        th = move-exception;
        throw th;     // Catch: Throwable -> L66
    L66:
        th = move-exception;
        CloseableKt.closeFinally(r22, th);     // Catch: Throwable -> L43
        throw th;     // Catch: Throwable -> L43
    L45:
        r20 = null;
        goto L47
    L35:
        r15 = false;
        goto L36
    L39:
        r11 = -1;
    L43:
        th = move-exception;
        throw th;     // Catch: Throwable -> L70
    L70:
        th = move-exception;
        CloseableKt.closeFinally(r9, th);
        throw th;
    L73:
        PolarisFileWrapper r26 = new PolarisFileWrapper(r14, r4);
        if (r26.exists() == true) goto L76;
        r26.mkdirs();
    L76:
        a(r12, r6, r26);
        goto L77
    L20:
        if (r7.length != 0) goto L22;
        boolean r27 = true;
    L23:
        if (r27 == true) goto L26;
        r8 = false;
        goto L27
    L22:
        r27 = false;
        goto L23
    L16:
        r6 = r13 + '/' + r4;
        goto L17
    L13:
        r5 = false;
        goto L14
    }
}
