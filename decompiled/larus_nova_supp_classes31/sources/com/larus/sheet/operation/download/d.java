package com.larus.sheet.operation.download;

import android.content.Context;
import com.bytedance.ee.docsdk.impl.base.DocumentType;
import com.larus.common_ui.view.FileExportType;
import com.larus.platform.service.z2;
import com.larus.sheet.sdk.api.ISheetSdkServiceV2;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.jvm.functions.Function4;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class d {
    public static boolean a;

    static {
    }

    public static void a(Context r10, FileExportType r11, String r12, String r13, Function4 r14) {
        if (StringsKt.isBlank(r12) == false) goto L6;
        a = false;
        r14.invoke(Boolean.FALSE, null, null, "token is empty");
        return;
    L6:
        ISheetSdkServiceV2 r3 = (ISheetSdkServiceV2) ServiceManager.get().getService(ISheetSdkServiceV2.class);
        if (r3 != null) goto L10;
        a = false;
        r14.invoke(Boolean.FALSE, new Throwable(), null, "slides sdk service is null");
        return;
    L10:
        String r6 = r11.getExtension();
        if (StringsKt.endsWith$default(r13, "." + r6, false, 2, null) == true) goto L14;
        r13 = r13 + '.' + r6;
    L14:
        r3.n(r10, r13, r6, DocumentType.SHEET.type, r12, new b(r10, r14));
    }

    public static void b(Context r11, FileExportType r12, String r13, String r14, Function4 r15) {
        if (z2.a.enableOfficeSdkInitOnEnterpriseOnline() == false) goto L5;
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new SheetDownloader$startDownloadIntervalV2$1(r11, r12, r13, r14, r15, null), 3, null);
        return;
    L5:
        a(r11, r12, r13, r14, r15);
    }
}
