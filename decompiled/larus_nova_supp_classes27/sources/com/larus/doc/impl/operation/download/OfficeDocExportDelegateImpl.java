package com.larus.doc.impl.operation.download;

import android.content.Context;
import android.os.Build;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import com.larus.common_ui.view.FileExportType;
import com.larus.doc.sdk.api.IDocSdkServiceV2;
import com.larus.office.base.export.IOfficeDocExportDelegate;
import com.larus.platform.service.i2;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010#\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u008b\u0001\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u00062\b\u0010\r\u001a\u0004\u0018\u00010\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00062\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122*\u0010\u0014\u001a&\u0012\u0004\u0012\u00020\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u0017\u0012\u0006\u0012\u0004\u0018\u00010\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\u0004\u0012\u00020\b0\u0015H\u0016¢\u0006\u0002\u0010\u0018J\u0010\u0010\u0019\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\u0006H\u0016R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/larus/doc/impl/operation/download/OfficeDocExportDelegateImpl;", "Lcom/larus/office/base/export/IOfficeDocExportDelegate;", "<init>", "()V", "cancelledResourceIds", "", "", "startOfficeExport", "", "format", "type", "token", "eventSource", "passback", "context", "Landroid/content/Context;", "docTitle", "resourceType", "", "resourceVersion", "callback", "Lkotlin/Function4;", "", "Landroid/net/Uri;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/content/Context;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Lkotlin/jvm/functions/Function4;)V", "cancelDocExport", "resourceId", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OfficeDocExportDelegateImpl implements IOfficeDocExportDelegate {
    public final Set<String> a;

    public static final class a {
    }

    static {
    }

    public OfficeDocExportDelegateImpl() {
        this.a = new LinkedHashSet();
    }

    public final void a(String r6) {
        Intrinsics.checkNotNullParameter(r6, "resourceId");
        Set<String> r0 = this.a;
        monitor-enter(r0);
        this.a.add(r6);     // Catch: Throwable -> L18
        monitor-exit(r0);
        DocDownloadManager.a.getClass();
        Intrinsics.checkNotNullParameter(r6, "resourceId");
        FLogger r1 = FLogger.a;
        StringBuilder r2 = new StringBuilder("[cancelDownload] job is null:");
        if (DocDownloadManager.c != null) goto L9;
        boolean r3 = true;
    L10:
        r2.append(r3);
        r1.i("DocDownloadManager", r2.toString());
        Job r4 = DocDownloadManager.c;
        if (r4 == null) goto L13;
        Job.DefaultImpls.cancel$default(r4, null, 1, null);
    L13:
        DocDownloadManager.c = null;
        IDocSdkServiceV2 r5 = (IDocSdkServiceV2) ServiceManager.get().getService(IDocSdkServiceV2.class);
        if (r5 == null) goto L16;
        r5.cancelDocExport();
    L16:
        DocDownloadManager.d.remove(r6);
        h.a = 0;
        h.b = "";
        h.c = "";
        h.d = 0;
        h.e = 0;
        h.f = 0;
        return;
    L9:
        r3 = false;
    L18:
        th = move-exception;
        throw th;
    }

    public final void b(String r21, String r22, final String r23, final String r24, final Context r25, String r26, Integer r27, Integer r28, final com.larus.office.card.doc.download.g r210) {
        Intrinsics.checkNotNullParameter(r21, "format");
        Intrinsics.checkNotNullParameter(r22, "type");
        Intrinsics.checkNotNullParameter(r23, "token");
        Intrinsics.checkNotNullParameter("41", "eventSource");
        Intrinsics.checkNotNullParameter(r210, "callback");
        if (r27 == null) goto L75;
        if (r28 == null) goto L75;
        Set<String> r6 = this.a;
        monitor-enter(r6);
        this.a.remove(r23);     // Catch: Throwable -> L72
        monitor-exit(r6);
        String r7 = r21.toLowerCase(Locale.ROOT);
        switch(r7.hashCode()) {
            case 99640: goto L28;
            case 110834: goto L24;
            case 115312: goto L20;
            case 3088960: goto L17;
            case 3655434: goto L14;
            default: goto L70;
        };
    L70:
        r210.invoke(Boolean.FALSE, null, null, "Unsupported export format: ".concat(r21));
        return;
    L14:
        if (r7.equals("word") == false) goto L70;
    L30:
        FileExportType r8 = FileExportType.word;
    L31:
        final FileExportType r12 = r8;
        FLogger r9 = FLogger.a;
        r9.i("OfficeDocExportDelegateImpl", "startOfficeExport, format=" + r21 + " type=" + r22 + " token=" + r23 + " eventSource=41 resourceType=" + r27 + " resourceVersion=" + r28);
        DocDownloadManager r0 = DocDownloadManager.a;
        if (r26 != null) goto L34;
        String r13 = "";
    L35:
        p r14 = new OfficeDocExportDelegateImpl$startOfficeExport$2(this, r210, r23, r25);
        int r15 = r27.intValue();
        int r10 = r28.intValue();
        r0.getClass();
        Intrinsics.checkNotNullParameter(r23, "resourceId");
        Intrinsics.checkNotNullParameter(r13, "docTitle");
        Intrinsics.checkNotNullParameter(r12, "downloadType");
        Intrinsics.checkNotNullParameter(r14, "callback");
        r9.i("DocDownloadManager", "[startDownload] begin, resourceId:" + r23 + ", downloadType:" + r12 + ", resourceType:" + r15 + ", resourceVersion:" + r10);
        final g r11 = new g(r14, new com.larus.platform.audit.b(r23, r13, null, null, DocDownloadManager.g(r12), 12), "doc");
        if (r15 != 10) goto L52;
        Map<String, Boolean> r1 = DocDownloadManager.d;
        Object r2 = ((LinkedHashMap) r1).get(r23);
        Boolean r3 = Boolean.TRUE;
        if (Intrinsics.areEqual(r2, r3) == false) goto L40;
        r11.a(null, "current is downloading");
        return;
    L40:
        r1.put(r23, r3);
        if (Build.VERSION.SDK_INT <= 28) goto L43;
    L51:
        DocDownloadManager.h(r12, r23, r13, r24, new b(r23, r25, r11));
        return;
    L43:
        if (ContextCompat.checkSelfPermission(r25, "android.permission.WRITE_EXTERNAL_STORAGE") == 0) goto L51;
        if ((r25 instanceof FragmentActivity) == false) goto L47;
        FragmentActivity r16 = (FragmentActivity) r25;
    L48:
        if (r16 == null) goto L84;
        final String r5 = r13;
        i2.b.a(r16, CollectionsKt.listOf(new String[]{"android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE"}), new com.larus.doc.impl.operation.download.a(r12, r23, r5, r24, r11, r25));
        return;
    L84:
        return;
    L47:
        r16 = null;
        goto L48
    L52:
        String r4 = h.b;
        String r17 = r12.toFileTypeStr();
        Intrinsics.checkNotNullParameter(r23, "resourceId");
        Intrinsics.checkNotNullParameter(r17, "fileType");
        h.a = System.currentTimeMillis();
        h.b = r23;
        h.c = r17;
        int r18 = DocDownloadManager.a.a[r12.ordinal()];
        boolean r20 = true;
        if (r18 != 1) goto L55;
        int r30 = 1;
    L63:
        if (r23.length() == 0) goto L66;
        r20 = false;
    L66:
        if (r20 == false) goto L68;
        r11.a(null, "resourceId error");
        return;
    L68:
        DocDownloadManager.c = BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new DocDownloadManager$startDownloadInternalV1$1(r23, r30, r15, r10, r11, r12, null), 3, null);
        return;
    L55:
        if (r18 != 2) goto L57;
        r30 = 2;
        goto L63
    L57:
        if (r18 == 3) goto L59;
        r11.a(null, "type error");
        return;
    L59:
        r30 = 3;
        goto L63
    L34:
        r13 = r26;
        goto L35
    L17:
        if (r7.equals("docx") == false) goto L70;
    L20:
        if (r7.equals("txt") == false) goto L70;
        r8 = FileExportType.txt;
        goto L31
    L24:
        if (r7.equals("pdf") == false) goto L70;
        r8 = FileExportType.pdf;
        goto L31
    L28:
        if (r7.equals("doc") == true) goto L30;
    L72:
        th = move-exception;
        throw th;
    L75:
        r210.invoke(Boolean.FALSE, null, null, "Missing Doubao export params");
    }
}
