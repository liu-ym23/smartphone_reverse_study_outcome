package com.obric.aikernel.res.downloader;

import com.ss.android.socialbase.downloader.constants.DownloadStatus;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u001aE\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000bH\u0000¢\u0006\u0002\u0010\f\u001a \u0010\r\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u00012\u0006\u0010\u0010\u001a\u00020\u0001H\u0000\u001a\u0010\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u0006H\u0000¨\u0006\u0012"}, d2 = {"buildDownloadActionLog", "", "action", "file", "Lcom/obric/aikernel/res/downloader/DownloadTask$FileInfo;", "downloadId", "", "status", "downloaded", "", "localState", "Lcom/obric/aikernel/res/downloader/DownloadLocalState;", "(Ljava/lang/String;Lcom/obric/aikernel/res/downloader/DownloadTask$FileInfo;ILjava/lang/Integer;Ljava/lang/Boolean;Lcom/obric/aikernel/res/downloader/DownloadLocalState;)Ljava/lang/String;", "inspectDownloadLocalState", "savePath", "fileName", "tmpPath", "shouldRestartDownloaderForStatus", "resource_manager_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class m {
    public static final f a(String r7, String r8, String r9) {
        Intrinsics.checkNotNullParameter(r7, "savePath");
        Intrinsics.checkNotNullParameter(r8, "fileName");
        Intrinsics.checkNotNullParameter(r9, "tmpPath");
        File r0 = new File(r7);
        File r10 = new File(r0, r8);
        File r11 = new File(r9);
        boolean r2 = r0.exists();
        boolean r3 = r10.exists();
        if (r10.exists() == true) goto L6;
        r10 = null;
    L6:
        if (r10 == null) goto L8;
        long r1 = r10.length();
    L10:
        return new f(r2, r3, r1, r11.exists());
    L8:
        r1 = 0;
        goto L10
    }

    public static final String a(String r2, j.b r3, int r4, Integer r5, Boolean r6, f r7) {
        Intrinsics.checkNotNullParameter(r2, "action");
        Intrinsics.checkNotNullParameter(r3, "file");
        Intrinsics.checkNotNullParameter(r7, "localState");
        StringBuilder r0 = new StringBuilder();
        r0.append("model download ");
        r0.append(r2);
        r0.append(" name=");
        r0.append(r3.a());
        r0.append(" downloadId=");
        r0.append(r4);
        if (r5 == null) goto L5;
        int r8 = ((Number) ZeusTransformUtils.preCheckCast(r5, Number.class, "com.obric.memorydata.plugin")).intValue();
        r0.append(" status=");
        r0.append(r8);
    L5:
        if (r6 == null) goto L7;
        boolean r9 = r6.booleanValue();
        r0.append(" downloaded=");
        r0.append(r9);
    L7:
        r0.append(" savePath=");
        r0.append(r3.d());
        r0.append(" tmpPath=");
        r0.append(r3.e());
        r0.append(" url=");
        r0.append(r3.c());
        r0.append(" saveDirExists=");
        r0.append(r7.a());
        r0.append(" saveFileExists=");
        r0.append(r7.b());
        r0.append(" saveFileBytes=");
        r0.append(r7.c());
        r0.append(" tmpDirExists=");
        r0.append(r7.d());
        String r10 = r0.toString();
        Intrinsics.checkNotNullExpressionValue(r10, "StringBuilder().apply(builderAction).toString()");
        return r10;
    }

    public static final boolean a(int r0) {
        return DownloadStatus.isFailedStatus(r0);
    }
}
