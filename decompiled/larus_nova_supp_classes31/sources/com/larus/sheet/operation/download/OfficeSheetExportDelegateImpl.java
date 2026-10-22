package com.larus.sheet.operation.download;

import android.content.Context;
import android.os.Build;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.docsdk.impl.export.ExportManager;
import com.larus.common_ui.view.FileExportType;
import com.larus.office.base.export.IOfficeSheetExportDelegate;
import com.larus.office.card.sheet.download.e;
import com.larus.platform.service.i2;
import com.larus.utils.logger.FLogger;
import com.tencent.open.log.TraceLevel;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010#\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\b\u0007\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0007¢\u0006\u0004\b\u0002\u0010\u0003JN\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\f2*\u0010\r\u001a&\u0012\u0004\u0012\u00020\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0011\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\u0004\u0012\u00020\b0\u000eH\u0016J\u0010\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u0006H\u0016R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/larus/sheet/operation/download/OfficeSheetExportDelegateImpl;", "Lcom/larus/office/base/export/IOfficeSheetExportDelegate;", "<init>", "()V", "cancelledTokens", "", "", "startSheetExport", "", "token", "fileName", "context", "Landroid/content/Context;", "callback", "Lkotlin/Function4;", "", "Landroid/net/Uri;", "", "cancelSheetExport", "resourceId", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class OfficeSheetExportDelegateImpl implements IOfficeSheetExportDelegate {
    public static final /* synthetic */ int b = 0;
    public final Set<String> a;

    public static final class a {
    }

    static {
    }

    public OfficeSheetExportDelegateImpl() {
        this.a = new LinkedHashSet();
    }

    public final void c(String r4) {
        Intrinsics.checkNotNullParameter(r4, "resourceId");
        Set<String> r0 = this.a;
        monitor-enter(r0);
        this.a.add(r4);     // Catch: Throwable -> L8
        monitor-exit(r0);
        boolean r1 = d.a;
        Intrinsics.checkNotNullParameter(r4, "token");
        FLogger.a.i("SheetDownloader", "cancelDownload: token:" + r4);
        ExportManager.INSTANCE.cancelExport(r4);
        d.a = false;
        return;
    L8:
        th = move-exception;
        throw th;
    }

    /* JADX WARN: Type inference failed for: r7v0, types: [com.larus.sheet.operation.download.a, java.lang.Object, kotlin.jvm.functions.Function4] */
    public final void b(final String r10, final String r11, final Context r12, final e r13) {
        Intrinsics.checkNotNullParameter(r10, "token");
        Intrinsics.checkNotNullParameter(r11, "fileName");
        Intrinsics.checkNotNullParameter(r13, "callback");
        FragmentActivity r0 = null;
        if (r12 != null) goto L6;
        r13.invoke(Boolean.FALSE, null, null, "Missing sheet export context");
        return;
    L6:
        Set<String> r1 = this.a;
        monitor-enter(r1);
        this.a.remove(r10);     // Catch: Throwable -> L25
        monitor-exit(r1);
        boolean r2 = d.a;
        final FileExportType r4 = FileExportType.excel;
        final ?? r7 = new com.larus.sheet.operation.download.a(this, r13, r10, r12);
        Intrinsics.checkNotNullParameter(r12, "context");
        Intrinsics.checkNotNullParameter(r4, "downloadType");
        Intrinsics.checkNotNullParameter(r10, "token");
        Intrinsics.checkNotNullParameter(r11, "fileName");
        Intrinsics.checkNotNullParameter(r7, "callback");
        FLogger.a.i("SheetDownloader", "[startDownload] isDownloading:" + d.a + ", token:" + r10 + ' ');
        if (d.a == false) goto L13;
        r7.invoke(Boolean.FALSE, null, null, "current is downloading");
        return;
    L13:
        d.a = true;
        if (Build.VERSION.SDK_INT <= 28) goto L16;
    L23:
        d.b(r12, r4, r10, r11, r7);
        return;
    L16:
        if (ContextCompat.checkSelfPermission(r12, "android.permission.WRITE_EXTERNAL_STORAGE") == 0) goto L23;
        if ((r12 instanceof FragmentActivity) == false) goto L20;
        r0 = (FragmentActivity) r12;
    L20:
        if (r0 == null) goto L32;
        i2.b.a(r0, CollectionsKt.listOf(new String[]{"android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE"}), new c(r12, r4, r10, r11, r7));
        return;
    L32:
        return;
    L25:
        th = move-exception;
        throw th;
    }
}
