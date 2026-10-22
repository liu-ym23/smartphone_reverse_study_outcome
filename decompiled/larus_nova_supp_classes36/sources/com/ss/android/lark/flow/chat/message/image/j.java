package com.ss.android.lark.flow.chat.message.image;

import com.bytedance.ee.bear.drive.loader.download.model.drive.DriveImagePreviewResponse;
import com.ss.android.lark.log.Log;
import kotlin.Result;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class j implements h75.c {
    public final /* synthetic */ kotlinx.coroutines.i<String> a;

    public j(kotlinx.coroutines.j r1) {
        this.a = r1;
    }

    public final void a(DriveImagePreviewResponse r3) {
        Intrinsics.checkNotNullParameter(r3, "info");
        kotlinx.coroutines.i<String> r0 = this.a;
        Result.Companion r1 = Result.Companion;
        r0.resumeWith(Result.constructor-impl(r3.getUrl()));
    }

    public final void b(Throwable r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "e");
        Intrinsics.checkNotNullParameter(r4, "url");
        Log.e("FlowYunPanFileUtils", "fetchDriveImagePreview onError, " + r3.getMessage());
        this.a.resumeWith(Result.constructor-impl(r4));
    }
}
