package com.bytedance.android.livesdk.jsbridge.methods.draft;

import com.bytedance.android.live.core.utils.s1;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class h {
    public h() {
    }

    public static final int a(h r11, String r13, String r14, Function1 r15) {
        r11.getClass();
        e r6 = new e(0);
        r15.invoke(r6);
        DownloadTask r8 = Downloader.with(s1.getContext()).url(r13);
        Intrinsics.checkNotNullParameter(r14, "$this$fileName");
        int r0 = StringsKt.lastIndexOf$default(r14, "/", 0, false, 6, null);
        String r9 = null;
        if (r0 == (-1)) goto L5;
        String r1 = r14.substring(r0);
    L6:
        DownloadTask r10 = r8.name(r1);
        Intrinsics.checkNotNullParameter(r14, "$this$filePath");
        int r2 = StringsKt.lastIndexOf$default(r14, "/", 0, false, 6, null);
        if (r2 == (-1)) goto L10;
        r9 = r14.substring(0, r2);
    L10:
        return r10.savePath(r9).monitorScene("live_draft").mainThreadListener(new g(r6)).download();
    L5:
        r1 = null;
        goto L6
    }
}
