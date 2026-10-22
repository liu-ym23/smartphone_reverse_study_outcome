package r5;

import android.net.Uri;
import com.bytedance.ai.resource.m;
import com.bytedance.ai.resource.n;
import com.bytedance.ai.utils.g;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.bytedance.security.android.aopcheck.PolarisZipFileWrapper;
import java.io.ByteArrayInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipEntry;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.io.FilesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class c {
    public final String a;

    public static final class a {
    }

    static {
    }

    public c(String r10) {
        Intrinsics.checkNotNullParameter(r10, "storeDir");
        this.a = r10;
    }

    public static void a(String r10) {
        g.a.i("AppletResourceLoader", "read file from fallback, url: " + r10);
        n5.a.a.getClass();
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_URL);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r15v2, types: [r5.b] */
    /* JADX WARN: Type inference failed for: r7v1 */
    /* JADX WARN: Type inference failed for: r7v2 */
    /* JADX WARN: Type inference failed for: r7v26 */
    /* JADX WARN: Type inference failed for: r7v27 */
    /* JADX WARN: Type inference failed for: r7v3, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r7v31 */
    /* JADX WARN: Type inference failed for: r7v32 */
    /* JADX WARN: Type inference failed for: r7v5 */
    /* JADX WARN: Type inference failed for: r7v7 */
    /* JADX WARN: Type inference failed for: r9v1 */
    /* JADX WARN: Type inference failed for: r9v18 */
    /* JADX WARN: Type inference failed for: r9v19 */
    /* JADX WARN: Type inference failed for: r9v2 */
    /* JADX WARN: Type inference failed for: r9v20 */
    /* JADX WARN: Type inference failed for: r9v21 */
    /* JADX WARN: Type inference failed for: r9v22 */
    /* JADX WARN: Type inference failed for: r9v3, types: [com.bytedance.ai.resource.n] */
    /* JADX WARN: Type inference failed for: r9v4, types: [com.bytedance.ai.resource.m] */
    /* JADX WARN: Type inference failed for: r9v5 */
    /* JADX WARN: Type inference failed for: r9v6 */
    /* JADX WARN: Type inference failed for: r9v7, types: [com.bytedance.ai.resource.n] */
    /* JADX WARN: Type inference failed for: r9v8 */
    public final void b(String r27, String r28, m r29, n r30, final boolean r31, Map r32) {
        Intrinsics.checkNotNullParameter(r28, com.bytedance.android.ec.core.event.a.KEY_URL);
        Intrinsics.checkNotNullParameter(r29, "resolve");
        Intrinsics.checkNotNullParameter(r30, "reject");
        Uri r10 = UriProtector.parse(r28);
        g r11 = g.a;
        r11.i("AppletResourceLoader", "start to async load AI Resource; " + r28);
        String r12 = this.a;
        String r1 = r10.getHost();
        Intrinsics.checkNotNull(r10);
        String r13 = q5.a.a(r10, "packageVersion");
        if (r13 == null) goto L5;
        long r16 = CastLongProtector.parseLong(r13);
    L7:
        if (Intrinsics.areEqual(r1, "app.aisdk.local") == true) goto L10;
        r11.i("AppletResourceLoader", "AIResourceLoader async load failed. Support aiapp ONLY: " + r28);
        r30.invoke(new Exception("Support aiapp ONLY"));
        return;
    L10:
        String r14 = r10.getPath();
        if (r14 != null) goto L13;
    L16:
        boolean r15 = true;
    L17:
        if (r15 == false) goto L20;
        r11.i("AppletResourceLoader", "AIResourceLoader async load failed. Path is null: " + r28);
        r30.invoke(new Exception("Path is null"));
        return;
    L20:
        List r17 = StringsKt.split$default(r14, new String[]{"/"}, false, 0, 6, null);
        if (r17.size() >= 4) goto L113;
        r11.i("AppletResourceLoader", "AIResourceLoader async load failed. Invalid path: " + r28);
        r30.invoke(new Exception("Invalid path"));
        return;
    L113:
        Result.Companion r18 = Result.Companion;     // Catch: Throwable -> L104
        final String r19 = r10.buildUpon().clearQuery().build().toString();     // Catch: Throwable -> L104
        final String r20 = (String) ListProtector.get(r17, 1);     // Catch: Throwable -> L104
        String r21 = (String) ListProtector.get(r17, 2);     // Catch: Throwable -> L104
        final long r22 = r16;
        String r110 = "AppletResourceLoader";
        final String r23 = r28;
        final ?? r24 = r29;
        ?? r111 = new b(r20, r22, r19, this, r31, r23, r24);     // Catch: Throwable -> L102
        d r25 = f.a;     // Catch: Throwable -> L102
        Intrinsics.checkNotNullParameter(r19, "cacheKey");     // Catch: Throwable -> L102
        d r26 = f.a;     // Catch: Throwable -> L102
        if (r26 == null) goto L30;
        r5.a r33 = r26.get(r19);     // Catch: Throwable -> L102
        if (r33 == null) goto L30;
    L31:
        if (r33 == null) goto L34;
        r11.i(r110, "Hit memory cache: " + r28);     // Catch: Throwable -> L102
        r111.invoke(new ByteArrayInputStream(r33.a.a), r33.c, Boolean.TRUE);     // Catch: Throwable -> L102
        return;
    L34:
        String r34 = StringsKt.substringAfter$default(r14, "/" + r20 + '/' + r21 + '/', null, 2, null);     // Catch: Throwable -> L102
        StringBuilder r0 = new StringBuilder();     // Catch: Throwable -> L102
        r0.append(r21);     // Catch: Throwable -> L102
        r0.append('/');     // Catch: Throwable -> L102
        r0.append(r34);     // Catch: Throwable -> L102
        String r35 = r0.toString();     // Catch: Throwable -> L102
        Uri r36 = r10;
        String r37 = UriProtector.getQueryParameter(r36, "storeDir");     // Catch: Throwable -> L102
        ?? r38 = r36;
        if (r37 != null) goto L119;
        r38 = 2;
        r37 = StringsKt.substringBeforeLast$default(r21, "_", null, 2, null);     // Catch: Throwable -> L102
    L119:
        String r39 = r37 + '/' + r34;     // Catch: Throwable -> L102
        PolarisFileWrapper r40 = new PolarisFileWrapper(r12);     // Catch: Throwable -> L102
        String r41 = FilesKt.resolve(FilesKt.resolve(r40, r20), r21 + ".zip").getPath();     // Catch: Throwable -> L102
        String r42 = r40.getPath() + r14;     // Catch: Throwable -> L102
        Ref.ObjectRef r43 = new Ref.ObjectRef();     // Catch: Exception -> L95 Throwable -> L102
        PolarisFileWrapper r44 = new PolarisFileWrapper(r42);     // Catch: Exception -> L95 Throwable -> L102
        if (Boolean.valueOf(r44.exists()).booleanValue() == false) goto L41;
        PolarisFileWrapper r45 = r44;
    L42:
        if (r45 == null) goto L44;
        r23 = new PolarisFileInputStreamWrapper(r45);     // Catch: Exception -> L95 Throwable -> L102
    L45:
        r43.element = r23;     // Catch: Exception -> L95 Throwable -> L102
        if (r23 == null) goto L128;
        r111.invoke(r23, r42, Boolean.FALSE);     // Catch: Exception -> L95 Throwable -> L102
        ?? r46 = r30;
        r23 = ". url: ";
        PolarisFileWrapper r47 = "Fail to load resource: ";
    L98:
        Object r48 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L100
        ?? r49 = r47;
        ?? r50 = r46;
    L107:
        Throwable r51 = Result.exceptionOrNull-impl(r48);
        if (r51 == null) goto L131;
        g.a.e(r110, r49 + r51.getMessage() + r23 + r28);
        r50.invoke(r51);
        return;
    L131:
        return;
    L128:
        PolarisZipFileWrapper r52 = new PolarisZipFileWrapper(r41);     // Catch: Exception -> L95 Throwable -> L102
        ZipEntry r53 = r52.getEntry(r39);     // Catch: Throwable -> L80
        if (r53 != null) goto L123;
        r53 = r52.getEntry(r35);     // Catch: Throwable -> L55
        if (r53 != null) goto L123;
        r53 = r52.getEntry(r34);     // Catch: Throwable -> L55
    L55:
        th = move-exception;
        Throwable r54 = th;
    L126:
        throw r54;     // Catch: Throwable -> L89
    L89:
        th = move-exception;
        CloseableKt.closeFinally(r52, r54);     // Catch: Exception -> L93 Throwable -> L100
        throw th;     // Catch: Exception -> L93 Throwable -> L100
    L123:
        if (r53 == null) goto L82;
        InputStream r55 = r52.getInputStream(r53);     // Catch: Throwable -> L80
        r43.element = r55;     // Catch: Throwable -> L80
        if (r55 == null) goto L64;
        r111.invoke(r55, r41, Boolean.FALSE);     // Catch: Throwable -> L55
        n r56 = r30;
        r23 = ". url: ";
        PolarisFileWrapper r57 = "Fail to load resource: ";
    L83:
        Unit r58 = Unit.INSTANCE;     // Catch: Throwable -> L86
        CloseableKt.closeFinally(r52, null);     // Catch: Exception -> L93 Throwable -> L100
        r47 = r57;
        r46 = r56;
        goto L98
    L64:
        a(r28);     // Catch: Throwable -> L80
        StringBuilder r59 = new StringBuilder("File is not found: ");     // Catch: Throwable -> L80
        r59.append(r34);     // Catch: Throwable -> L80
        r59.append(" in ");     // Catch: Throwable -> L77
        r59.append(r41);     // Catch: Throwable -> L77
        String r60 = r59.toString();     // Catch: Throwable -> L77
        PolarisFileWrapper r61 = "Fail to load resource: ";
        StringBuilder r62 = new StringBuilder(r61);     // Catch: Throwable -> L75
        r62.append(r60);     // Catch: Throwable -> L75
        r23 = ". url: ";
        r62.append(r23);     // Catch: Throwable -> L73
        r62.append(r28);     // Catch: Throwable -> L73
        r11.e(r110, r62.toString());     // Catch: Throwable -> L73
        n r63 = r30;
        r63.invoke(new FileNotFoundException(r60));     // Catch: Throwable -> L86
        r57 = r61;
        r56 = r63;
    L73:
        th = th;
    L87:
        r54 = th;
    L75:
        th = th;
    L77:
        th = th;
        goto L87
    L82:
        n r64 = r30;
        r23 = ". url: ";
        PolarisFileWrapper r65 = "Fail to load resource: ";
        a(r28);     // Catch: Throwable -> L86
        String r66 = "File is not found: " + r34 + " in " + r41;     // Catch: Throwable -> L86
        r11.e(r110, r65 + r66 + r23 + r28);     // Catch: Throwable -> L86
        r64.invoke(new FileNotFoundException(r66));     // Catch: Throwable -> L86
        r57 = r65;
        r56 = r64;
    L86:
        th = th;
    L80:
        th = th;
    L93:
        e = e;
    L97:
        a(r28);     // Catch: Throwable -> L100
        String r67 = "Fail to read file: " + r34 + r43 + r41 + 12290 + e.getMessage();     // Catch: Throwable -> L100
        g.a.e(r110, "Fail to read file: " + r67 + r23 + r28);     // Catch: Throwable -> L100
        r24.invoke(new FileNotFoundException(r67));     // Catch: Throwable -> L100
        r47 = r45;
        r46 = r24;
        goto L98
    L44:
        r23 = null;
        goto L45
    L41:
        r45 = null;
    L95:
        e = e;
        r24 = r30;
        r23 = ". url: ";
        r43 = " in ";
        r45 = "Fail to load resource: ";
    L100:
        th = th;
    L106:
        Result.Companion r68 = Result.Companion;
        r48 = Result.constructor-impl(ResultKt.createFailure(th));
        r49 = r38;
        r50 = r24;
    L30:
        r33 = null;
    L102:
        th = th;
        r24 = r30;
        r23 = ". url: ";
        r38 = "Fail to load resource: ";
    L104:
        th = th;
        r24 = r30;
        r23 = ". url: ";
        r38 = "Fail to load resource: ";
        r110 = "AppletResourceLoader";
        goto L106
    L13:
        if (r14.length() == 0) goto L16;
        r15 = false;
        goto L17
    L5:
        r16 = 0;
        goto L7
    }
}
