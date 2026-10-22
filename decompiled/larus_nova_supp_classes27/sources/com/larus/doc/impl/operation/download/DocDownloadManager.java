package com.larus.doc.impl.operation.download;

import android.content.Context;
import android.net.Uri;
import com.bytedance.ee.docsdk.impl.base.DocumentType;
import com.bytedance.mt.protector.impl.PatternProtector;
import com.larus.common.apphost.AppHost;
import com.larus.common_ui.view.FileExportType;
import com.larus.doc.impl.DocumentApi;
import com.larus.doc.sdk.api.IDocSdkServiceV2;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class DocDownloadManager {
    public static final DocDownloadManager a = null;
    public static final j b = null;
    public static Job c;
    public static final Map<String, Boolean> d = null;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[FileExportType.values().length];
            r0[FileExportType.word.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[FileExportType.pdf.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[FileExportType.txt.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            a = r0;
        }
    }

    public DocDownloadManager() {
    }

    static {
        a = new DocDownloadManager();
        b = new j();
        d = new LinkedHashMap();
    }

    public static String e() {
        return "document_" + new SimpleDateFormat("MMdd", Locale.getDefault()).format(Long.valueOf(System.currentTimeMillis()));
    }

    public static final String a(DocDownloadManager r2) {
        r2.getClass();
        File r3 = AppHost.a.getApplication().getExternalFilesDir(null);
        StringBuilder r0 = new StringBuilder();
        r0.append(r3);
        String r4 = File.separator;
        r0.append(r4);
        r0.append("export");
        r0.append(r4);
        return r0.toString();
    }

    public static String g(FileExportType r1) {
        int r2 = a.a[r1.ordinal()];
        if (r2 != 1) goto L5;
    L11:
        return "docx";
    L5:
        if (r2 != 2) goto L7;
        return "pdf";
    L7:
        if (r2 != 3) goto L11;
        return "txt";
    }

    public static String f(Context r0, Uri r1) {
        if (r1 != null) goto L5;
        return "";
    L5:
        String r2 = com.larus.office.base.utils.b.c(r0, r1);
        if (r2 == null) goto L8;
        return r2;
    L8:
        return r1.toString();
    }

    public static final String b(DocDownloadManager r0, String r1, FileExportType r2) {
        r0.getClass();
        if (a.a[r2.ordinal()] != 3) goto L6;
        r1 = new Regex("\\.md$").replace(r1, ".txt");
    L6:
        if (r1.length() != 0) goto L8;
        boolean r3 = true;
    L9:
        if (r3 == false) goto L12;
        return e();
    L12:
        return PatternProtector.compile("[\\s\\\\/:\\*\\?\\\"<>\\|]").matcher(r1).replaceAll("_");
    L8:
        r3 = false;
        goto L9
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:45:0x0132 -> B:47:0x0136). Please report as a decompilation issue!!! */
    public static final Object c(DocDownloadManager r17, m r18, Continuation r110) {
        r17.getClass();
        if ((r110 instanceof DocDownloadManager$pollDownloadUrl$1) == false) goto L7;
        DocDownloadManager$pollDownloadUrl$1 r1 = (DocDownloadManager$pollDownloadUrl$1) r110;
        int r2 = r1.label;
        if ((r2 & Integer.MIN_VALUE) == 0) goto L7;
        r1.label = r2 - Integer.MIN_VALUE;
    L8:
        Object r0 = r1.result;
        Object r3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r4 = r1.label;
        if (r4 == 0) goto L16;
        if (r4 == 1) goto L15;
        if (r4 != 2) goto L14;
        int r5 = r1.I$4;
        int r8 = r1.I$3;
        int r9 = r1.I$2;
        int r10 = r1.I$1;
        int r11 = r1.I$0;
        Long r12 = (Long) r1.L$0;
        ResultKt.throwOnFailure(r0);
    L47:
        int r16 = r10;
        int r13 = r9;
        int r14 = r16;
        dm9.a.b r6 = (dm9.a) r0;
        FLogger.a.i("DocDownloadManager", "[pollDownloadUrl] response: " + r6);
        if ((r6 instanceof dm9.a.b) == false) goto L56;
        o r7 = (o) r6.a.getData();
        if (r7 == null) goto L56;
        if (o0.d(r7.c()) == false) goto L56;
        if (Intrinsics.areEqual(r7.b(), r12) == false) goto L56;
        String r15 = h.b;
        h.e = System.currentTimeMillis();
        h.f = r5;
        return r7;
    L56:
        r5 = r8 + 1;
        int r20 = r11;
        Long r21 = r12;
    L36:
        if (r5 >= r13) goto L57;
        if (r5 != 0) goto L39;
        int r111 = r20;
    L40:
        r1.L$0 = r21;
        r1.I$0 = r20;
        r1.I$1 = r14;
        r1.I$2 = r13;
        r1.I$3 = r5;
        r1.I$4 = r5;
        r1.label = 1;
        if (DelayKt.delay(((long) r111) * 1000, r1) == r3) goto L59;
        r12 = r21;
        r11 = r20;
        r8 = r5;
        int r112 = r13;
        r10 = r14;
        r9 = r112;
    L44:
        FLogger.a.i("DocDownloadManager", "[pollDownloadUrl] attempt " + r5);
        n r22 = new n(r12);
        DocumentApi.a r113 = DocumentApi.a;
        DocDownloadManager$pollDownloadUrl$2$response$1 r114 = new DocDownloadManager$pollDownloadUrl$2$response$1(r22, null);
        r1.L$0 = r12;
        r1.I$0 = r11;
        r1.I$1 = r10;
        r1.I$2 = r9;
        r1.I$3 = r8;
        r1.I$4 = r5;
        r1.label = 2;
        r113.getClass();
        r0 = DocumentApi.a.a(r114, r1);
        if (r0 != r3) goto L47;
    L59:
        return r3;
    L39:
        r111 = r14;
        goto L40
    L57:
        FLogger.a.i("DocDownloadManager", "[pollDownloadUrl] maxAttempts reached");
        return null;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r5 = r1.I$4;
        r8 = r1.I$3;
        r9 = r1.I$2;
        r10 = r1.I$1;
        r11 = r1.I$0;
        r12 = (Long) r1.L$0;
        ResultKt.throwOnFailure(r0);
        goto L44
    L16:
        ResultKt.throwOnFailure(r0);
        if (r18 == null) goto L19;
        r21 = r18.b();
    L20:
        if (r18 == null) goto L24;
        Integer r23 = r18.c();
        if (r23 == null) goto L24;
        int r24 = r23.intValue();
    L25:
        if (r18 == null) goto L29;
        Integer r25 = r18.a();
        if (r25 == null) goto L29;
        r20 = r25.intValue();
    L30:
        if (r18 == null) goto L34;
        Integer r26 = r18.d();
        if (r26 == null) goto L34;
        r14 = r26.intValue();
    L35:
        r13 = ((int) Math.ceil(((double) (r24 - r20)) / ((double) r14))) + 1;
        FLogger.a.i("DocDownloadManager", "[pollDownloadUrl] begin jobId:" + r21 + " timeout:" + r24 + " times:" + r13 + " firstQuerySec:" + r20 + " querySec:" + r14);
        r5 = 0;
    L34:
        r14 = 2;
    L29:
        r20 = 1;
    L24:
        r24 = 300;
        goto L25
    L19:
        r21 = null;
    L7:
        r1 = new DocDownloadManager$pollDownloadUrl$1(r17, r110);
        goto L8
    }

    public static void d(FileExportType r10, String r11, String r12, String r13, Function4 r14) {
        IDocSdkServiceV2 r1 = (IDocSdkServiceV2) ServiceManager.get().getService(IDocSdkServiceV2.class);
        if (r1 == null) goto L6;
        r1.startDocExport(AppHost.a.getApplication().getApplicationContext(), r12 + '.' + g(r10), g(r10), DocumentType.DOCX.type, r11, "41", r13, r14);
        return;
    }

    public static void h(FileExportType r11, String r12, String r13, String r14, Function4 r15) {
        if (z2.a.enableOfficeSdkInitOnEnterpriseOnline() == false) goto L6;
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new DocDownloadManager$realDownload$1(r11, r12, r13, r14, r15, null), 3, null);
        return;
    L6:
        d(r11, r12, r13, r14, r15);
    }
}
