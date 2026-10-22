package com.larus.bmhome.upload.sdk;

import com.larus.bmhome.upload.ResourceUploader;
import com.larus.utils.logger.FLogger;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import mr9.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class i {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static Object a(j r3, String r4, Continuation r5) {
        FLogger.a.i("UploadFacadeBridge", "[upload] source=" + r4 + ", identifier=" + r3.l + ", scene=" + r3.b + ", dataType=" + r3.c + ", resourceCenterEnabled=" + r3.o.a);
        Object r6 = ResourceUploader.a.j(r3, r5);
        if (r6 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r6;
    L6:
        return Unit.INSTANCE;
    }
}
