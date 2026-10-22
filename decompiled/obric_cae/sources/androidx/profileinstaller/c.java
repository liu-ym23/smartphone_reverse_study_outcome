package androidx.profileinstaller;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.util.Log;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.Arrays;
import java.util.concurrent.Executor;
import v0.g;
import v0.h;

/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f2224a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final b f2225b = null;

    public class a implements InterfaceC0019c {
        @Override // androidx.profileinstaller.c.InterfaceC0019c
        public final void a() {
        }

        @Override // androidx.profileinstaller.c.InterfaceC0019c
        public final void b(int r8, Object r10) {
        }
    }

    public class b implements InterfaceC0019c {
        @Override // androidx.profileinstaller.c.InterfaceC0019c
        public final void a() {
            Log.d("ProfileInstaller", "DIAGNOSTIC_PROFILE_IS_COMPRESSED");
        }

        @Override // androidx.profileinstaller.c.InterfaceC0019c
        public final void b(int r8, Object r10) {
            switch(r8) {
                case 1: goto L13;
                case 2: goto L12;
                case 3: goto L11;
                case 4: goto L10;
                case 5: goto L9;
                case 6: goto L8;
                case 7: goto L7;
                case 8: goto L6;
                case 9: goto L3;
                case 10: goto L5;
                case 11: goto L4;
                default: goto L3;
            };
        L3:
            String r11 = "";
        L15:
            if (r8 != 6) goto L17;
        L21:
            Log.e("ProfileInstaller", r11, (Throwable) r10);
            return;
        L17:
            if (r8 == 7) goto L21;
            if (r8 == 8) goto L21;
            Log.d("ProfileInstaller", r11);
            return;
        L4:
            r11 = "RESULT_DELETE_SKIP_FILE_SUCCESS";
            goto L15
        L5:
            r11 = "RESULT_INSTALL_SKIP_FILE_SUCCESS";
            goto L15
        L6:
            r11 = "RESULT_PARSE_EXCEPTION";
            goto L15
        L7:
            r11 = "RESULT_IO_EXCEPTION";
            goto L15
        L8:
            r11 = "RESULT_BASELINE_PROFILE_NOT_FOUND";
            goto L15
        L9:
            r11 = "RESULT_DESIRED_FORMAT_UNSUPPORTED";
            goto L15
        L10:
            r11 = "RESULT_NOT_WRITABLE";
            goto L15
        L11:
            r11 = "RESULT_UNSUPPORTED_ART_VERSION";
            goto L15
        L12:
            r11 = "RESULT_ALREADY_INSTALLED";
            goto L15
        L13:
            r11 = "RESULT_INSTALL_SUCCESS";
            goto L15
        }
    }

    /* JADX INFO: renamed from: androidx.profileinstaller.c$c, reason: collision with other inner class name */
    public interface InterfaceC0019c {
        void a();

        void b(int r8, Object r10);
    }

    static {
        f2224a = new a();
        f2225b = new b();
    }

    public static void a(PackageInfo r8, File r10) {
        DataOutputStream r11 = new DataOutputStream(new FileOutputStream(new File(r10, "profileinstaller_profileWrittenFor_lastUpdateTime.dat")));     // Catch: IOException -> L14
        r11.writeLong(r8.lastUpdateTime);     // Catch: Throwable -> L7
        r11.close();     // Catch: IOException -> L14
        return;
    L7:
        th = move-exception;
        r11.close();     // Catch: Throwable -> L10
    L12:
        throw th;     // Catch: IOException -> L14
    L10:
        th = move-exception;
        th.addSuppressed(th);     // Catch: IOException -> L14
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v14, types: [java.io.ByteArrayOutputStream, java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r6v10 */
    /* JADX WARN: Type inference failed for: r6v11 */
    /* JADX WARN: Type inference failed for: r6v12 */
    /* JADX WARN: Type inference failed for: r6v13 */
    /* JADX WARN: Type inference failed for: r6v21 */
    /* JADX WARN: Type inference failed for: r6v22 */
    /* JADX WARN: Type inference failed for: r6v23 */
    /* JADX WARN: Type inference failed for: r6v24 */
    /* JADX WARN: Type inference failed for: r6v25 */
    /* JADX WARN: Type inference failed for: r6v26 */
    /* JADX WARN: Type inference failed for: r6v27 */
    /* JADX WARN: Type inference failed for: r6v28 */
    /* JADX WARN: Type inference failed for: r6v29 */
    /* JADX WARN: Type inference failed for: r6v30 */
    /* JADX WARN: Type inference failed for: r6v8, types: [byte[]] */
    /* JADX WARN: Type inference failed for: r6v9 */
    /* JADX WARN: Type inference failed for: r9v2 */
    /* JADX WARN: Type inference failed for: r9v3, types: [boolean] */
    /* JADX WARN: Type inference failed for: r9v4 */
    public static void b(Context r16, Executor r17, InterfaceC0019c r18, boolean r19) {
        Context r8 = r16.getApplicationContext();
        String r10 = r8.getPackageName();
        ApplicationInfo r11 = r8.getApplicationInfo();
        AssetManager r12 = r8.getAssets();
        String r13 = new File(r11.sourceDir).getName();
        PackageInfo r14 = r16.getPackageManager().getPackageInfo(r10, 0);     // Catch: PackageManager.NameNotFoundException -> L255
        File r15 = r16.getFilesDir();
        if (r19 == true) goto L30;
        File r20 = new File(r15, "profileinstaller_profileWrittenFor_lastUpdateTime.dat");
        if (r20.exists() == true) goto L267;
        boolean r21 = false;
    L27:
        if (r21 == false) goto L30;
        Log.d("ProfileInstaller", "Skipping profile installation for " + r16.getPackageName());
        d.b(r16, false);
        return;
    L267:
        DataInputStream r22 = new DataInputStream(new FileInputStream(r20));     // Catch: IOException -> L26
        long r110 = r22.readLong();     // Catch: Throwable -> L18
        r22.close();     // Catch: IOException -> L26
        if (r110 != r14.lastUpdateTime) goto L15;
        r21 = true;
    L16:
        if (r21 == false) goto L27;
        r18.b(2, null);
        goto L27
    L15:
        r21 = false;
        goto L16
    L18:
        th = move-exception;
        r22.close();     // Catch: Throwable -> L22
    L311:
        throw th;     // Catch: IOException -> L26
    L22:
        th = move-exception;
        th.addSuppressed(th);     // Catch: IOException -> L26
        throw th;     // Catch: IOException -> L26
    L26:
        r21 = false;
    L30:
        Log.d("ProfileInstaller", "Installing profile for " + r16.getPackageName());
        File r23 = new File(new File("/data/misc/profiles/cur/0", r10), "primary.prof");
        androidx.profileinstaller.b r24 = new androidx.profileinstaller.b(r12, r17, r18, r13, r23);
        if (r23.exists() == true) goto L33;
        if (r23.createNewFile() == true) goto L39;
        r24.b(4, null);     // Catch: IOException -> L258
    L41:
        boolean r25 = false;
    L42:
        if (r25 == true) goto L44;
        ?? r26 = 1;
        boolean r27 = false;
    L243:
        if (r27 == false) goto L246;
        if (r19 == false) goto L246;
        ?? r28 = r26;
    L247:
        d.b(r16, r28);
        return;
    L246:
        r28 = 0;
        goto L247
    L44:
        AssetManager r29 = r24.f2216a;
        InterfaceC0019c r30 = r24.f2218c;
        if (r24.f2221f == false) goto L254;
        FileInputStream r31 = r24.a(r29, "dexopt/baseline.prof");     // Catch: IOException -> L48 FileNotFoundException -> L50
    L53:
        byte[] r32 = g.f12692a;
        int r111 = 8;
        if (r31 != null) goto L271;
    L84:
        v0.b[] r33 = r24.f2222g;
        ?? r34 = h.f12694a;
        if (r33 != null) goto L308;
    L116:
        InterfaceC0019c r35 = r24.f2218c;
        v0.b[] r36 = r24.f2222g;
        if (r36 != null) goto L119;
    L145:
        byte[] r37 = r24.f2223h;
        if (r37 != null) goto L302;
        ?? r38 = 1;
    L240:
        r27 = false;
        r26 = r38;
    L241:
        if (r27 == false) goto L243;
        a(r14, r15);
        goto L243
    L302:
        if (r24.f2221f == false) goto L252;
        ByteArrayInputStream r39 = new ByteArrayInputStream(r37);     // Catch: IOException -> L229 Throwable -> L234 FileNotFoundException -> L236
        FileOutputStream r40 = new FileOutputStream(r24.f2219d);     // Catch: Throwable -> L216
        FileChannel r41 = r40.getChannel();     // Catch: Throwable -> L205
        FileLock r42 = r41.tryLock();     // Catch: Throwable -> L193
        if (r42 != null) goto L294;
    L160:
        boolean r43 = false;
    L292:
        if (r43 == false) goto L181;
        byte[] r44 = new byte[512];     // Catch: Throwable -> L177
    L164:
        int r45 = r39.read(r44);     // Catch: Throwable -> L177
        if (r45 <= 0) goto L169;
        r40.write(r44, 0, r45);     // Catch: Throwable -> L158
    L158:
        th = move-exception;
        Throwable r46 = th;
    L184:
        if (r42 == null) goto L315;
        r42.close();     // Catch: Throwable -> L187
    L316:
        throw r46;     // Catch: Throwable -> L191
    L187:
        th = move-exception;
        r46.addSuppressed(th);     // Catch: Throwable -> L191
        throw r46;     // Catch: Throwable -> L191
    L315:
        throw r46;     // Catch: Throwable -> L191
    L169:
        r26 = 1;
        r24.b(1, null);     // Catch: Throwable -> L182
        if (r42 == null) goto L173;
        r42.close();     // Catch: Throwable -> L191
    L173:
        r41.close();     // Catch: Throwable -> L203
        r40.close();     // Catch: Throwable -> L214
        r39.close();     // Catch: IOException -> L225 FileNotFoundException -> L227 Throwable -> L234
        r24.f2223h = null;
        r24.f2222g = null;
        r27 = true;
    L177:
        th = th;
    L183:
        r46 = th;
        goto L184
    L181:
        throw new IOException("Unable to acquire a lock on the underlying file channel.");     // Catch: Throwable -> L182
    L182:
        th = th;
        goto L183
    L294:
        if (r42.isValid() == false) goto L160;
        r43 = true;
    L191:
        th = th;
    L195:
        Throwable r47 = th;
        if (r41 == null) goto L317;
        r41.close();     // Catch: Throwable -> L199
    L318:
        throw r47;     // Catch: Throwable -> L203
    L199:
        th = move-exception;
        r47.addSuppressed(th);     // Catch: Throwable -> L203
        throw r47;     // Catch: Throwable -> L203
    L317:
        throw r47;     // Catch: Throwable -> L203
    L193:
        th = th;
    L203:
        th = th;
    L207:
        Throwable r48 = th;
        r40.close();     // Catch: Throwable -> L210
    L319:
        throw r48;     // Catch: Throwable -> L214
    L210:
        th = move-exception;
        r48.addSuppressed(th);     // Catch: Throwable -> L214
        throw r48;     // Catch: Throwable -> L214
    L205:
        th = th;
    L214:
        th = th;
    L218:
        Throwable r49 = th;
        r39.close();     // Catch: Throwable -> L221
        throw r49;     // Catch: IOException -> L225 FileNotFoundException -> L227 Throwable -> L234
    L221:
        th = move-exception;
        r49.addSuppressed(th);     // Catch: IOException -> L225 FileNotFoundException -> L227 Throwable -> L234
        throw r49;     // Catch: IOException -> L225 FileNotFoundException -> L227 Throwable -> L234
    L216:
        th = th;
        goto L218
    L236:
        e = e;
        r34 = 1;
    L238:
        int r50 = 6;
        ?? r51 = r34;
    L232:
        r24.b(r50, e);     // Catch: Throwable -> L234
        r24.f2223h = null;
        r24.f2222g = null;
        r38 = r51;
    L229:
        e = e;
        r34 = 1;
    L231:
        r50 = 7;
        r51 = r34;
    L227:
        e = e;
    L225:
        e = e;
        goto L231
    L252:
        throw new IllegalStateException("This device doesn't support aot. Did you call deviceSupportsAotProfile()?");
    L234:
        th = move-exception;
        r24.f2223h = null;
        r24.f2222g = null;
        throw th;
    L119:
        if (r24.f2221f == false) goto L144;
        ?? r52 = new ByteArrayOutputStream();     // Catch: IllegalStateException -> L137 IOException -> L139
        r52.write(r32);     // Catch: Throwable -> L129
        r52.write(r34);     // Catch: Throwable -> L129
        if (g.j(r52, r34, r36) == true) goto L126;
        r35.b(5, null);     // Catch: Throwable -> L129
        r24.f2222g = null;     // Catch: Throwable -> L129
        r52.close();     // Catch: IllegalStateException -> L137 IOException -> L139
        goto L145
    L126:
        r24.f2223h = r52.toByteArray();     // Catch: Throwable -> L129
        r52.close();     // Catch: IllegalStateException -> L137 IOException -> L139
    L142:
        r24.f2222g = null;
    L129:
        th = move-exception;
        r52.close();     // Catch: Throwable -> L133
    L314:
        throw th;     // Catch: IllegalStateException -> L137 IOException -> L139
    L133:
        th = move-exception;
        th.addSuppressed(th);     // Catch: IllegalStateException -> L137 IOException -> L139
        throw th;     // Catch: IllegalStateException -> L137 IOException -> L139
    L139:
        e = e;
        r111 = 7;
    L141:
        r35.b(r111, e);
    L137:
        e = e;
        goto L141
    L144:
        throw new IllegalStateException("This device doesn't support aot. Did you call deviceSupportsAotProfile()?");
    L308:
        FileInputStream r53 = r24.a(r29, "dexopt/baseline.profm");     // Catch: IllegalStateException -> L106 IOException -> L108 FileNotFoundException -> L110
        if (r53 != null) goto L277;
        if (r53 == null) goto L113;
        r53.close();     // Catch: IllegalStateException -> L106 IOException -> L108 FileNotFoundException -> L110
    L113:
        androidx.profileinstaller.b r54 = null;
    L114:
        if (r54 == null) goto L116;
        r24 = r54;
        goto L116
    L277:
    L95:
        th = move-exception;
        r53.close();     // Catch: Throwable -> L99
        throw th;     // Catch: IllegalStateException -> L106 IOException -> L108 FileNotFoundException -> L110
    L99:
        th = move-exception;
        th.addSuppressed(th);     // Catch: IllegalStateException -> L106 IOException -> L108 FileNotFoundException -> L110
        throw th;     // Catch: IllegalStateException -> L106 IOException -> L108 FileNotFoundException -> L110
    L89:
        if (Arrays.equals(g.f12693b, l6.a.C0(r53, 4)) == false) goto L94;
        r24.f2222g = g.e(r53, l6.a.C0(r53, 4), r34, r33);     // Catch: Throwable -> L95
        r53.close();     // Catch: IllegalStateException -> L106 IOException -> L108 FileNotFoundException -> L110
        r54 = r24;
        goto L114
    L94:
        throw new IllegalStateException("Invalid magic");     // Catch: Throwable -> L95
    L110:
        e = e;
        int r55 = 9;
    L112:
        r30.b(r55, e);
    L108:
        e = e;
        r55 = 7;
    L106:
        e = move-exception;
        r24.f2222g = null;
        r30.b(8, e);
        goto L113
    L271:
    L62:
        e = move-exception;
        r30.b(8, e);     // Catch: Throwable -> L64
        int r56 = 7;
    L273:
        r31.close();     // Catch: IOException -> L75
    L77:
        v0.b[] r57 = null;
    L78:
        r24.f2222g = r57;
    L75:
        e = move-exception;
        r30.b(r56, e);
    L66:
        e = move-exception;
        r56 = 7;
        r30.b(7, e);     // Catch: Throwable -> L64
        goto L273
    L56:
        if (Arrays.equals(r32, l6.a.C0(r31, 4)) == false) goto L69;
        r57 = g.h(r31, l6.a.C0(r31, 4), r24.f2220e);     // Catch: IllegalStateException -> L62 Throwable -> L64 IOException -> L66
        r31.close();     // Catch: IOException -> L60
    L60:
        e = move-exception;
        r30.b(7, e);
        goto L78
    L69:
        throw new IllegalStateException("Invalid magic");     // Catch: IllegalStateException -> L62 Throwable -> L64 IOException -> L66
    L64:
        th = move-exception;
        r31.close();     // Catch: IOException -> L81
        throw th;
    L81:
        e = move-exception;
        r30.b(7, e);
        throw th;
    L50:
        e = e;
        int r58 = 6;
    L52:
        r30.b(r58, e);
        r31 = null;
    L48:
        e = e;
        r58 = 7;
        goto L52
    L254:
        throw new IllegalStateException("This device doesn't support aot. Did you call deviceSupportsAotProfile()?");
    L39:
        r24.f2221f = true;
        r25 = true;
    L40:
        r24.b(4, null);
        goto L41
    L33:
        if (r23.canWrite() == true) goto L39;
    L255:
        e = move-exception;
        r18.b(7, e);
        d.b(r16, false);
    }
}
