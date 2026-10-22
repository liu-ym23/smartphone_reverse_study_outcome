package com.larus.drive.sdk.impl;

import androidx.fragment.app.Fragment;
import com.bytedance.ee.drive.preview.DrivePreviewOpenItem;
import com.bytedance.ee.drive.preview.DrivePreviewOpenRequest;
import com.bytedance.ee.drive.preview.DrivePreviewResType;
import com.bytedance.security.android.polaris.PolarisFile;
import com.larus.common.apphost.AppHost;
import com.larus.office.base.service.IOfficeSdkServiceV2;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.io.File;
import java.util.UUID;
import kotlin.coroutines.Continuation;
import kotlin.io.FilesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class DriveLocalFilePreviewDelegate {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static Object b(Continuation r3) {
        return BuildersKt.withContext(Dispatchers.getMain().getImmediate(), new DriveLocalFilePreviewDelegate$prepare$2(null), r3);
    }

    public static File c(String r4) {
        boolean r1 = false;
        if (StringsKt.startsWith$default(r4, File.separator, false, 2, null) == true) goto L17;
        return null;
    L17:
        File r5 = PolarisFile.getSafeFileOrNullUnderAllowedFolder(r4, FilesKt.resolve(AppHost.a.getApplication().getCacheDir(), "RemoteFiles"));     // Catch: SecurityException -> L14
        if (r5 != null) goto L8;
        return null;
    L8:
        if (r5.isFile() == false) goto L12;
        if (r5.canRead() == false) goto L12;
        r1 = true;
    L12:
        if (r1 == true) goto L21;
        return null;
    L21:
        return r5;
    L14:
        e = move-exception;
        FLogger.a.w("DriveLocalFilePreview", "file validation failed, errorType=".concat(e.getClass().getSimpleName()));
        return null;
    }

    public static Fragment a(String r25, String r26, String r27) {
        Intrinsics.checkNotNullParameter(r25, "filePath");
        Intrinsics.checkNotNullParameter(r26, "fileName");
        Intrinsics.checkNotNullParameter(r27, "localFileProviderAuthority");
        File r0 = c(r25);
        if (r0 != null) goto L5;
        return null;
    L5:
        IOfficeSdkServiceV2 r1 = (IOfficeSdkServiceV2) ServiceManager.get().getService(IOfficeSdkServiceV2.class);
        if (r1 == null) goto L19;
        gk5.e r2 = r1.q0();
        if (r2 == null) goto L19;
        com.bytedance.ee.drive.preview.d r14 = r2.Y2();
        if (r14 == null) goto L19;
        DrivePreviewResType r4 = DrivePreviewResType.LOCAL_FILE;
        String r5 = StringsKt.replace$default(UUID.randomUUID().toString(), "-", "", false, 4, null);
        String r9 = FilesKt.getExtension(r0);
        String r3 = r0.getAbsolutePath();
        if ((!StringsKt.isBlank(r27)) == false) goto L15;
        String r12 = r27;
    L17:
        return r14.Ae(new DrivePreviewOpenRequest(new DrivePreviewOpenItem("doubao_local", r4, r5, 12, r26, null, r9, null, null, r3, r12, null, 2464, null), null, null, null, 14, null), null, null, null);
    L15:
        r12 = null;
    L19:
        return null;
    }
}
