package com.larus.uaigc.createpage.utils;

import com.larus.platform.model.upload.ResourceUploadError;
import com.larus.utils.logger.FLogger;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class n implements Function1<ResourceUploadError, Unit> {
    public final /* synthetic */ String a;
    public final /* synthetic */ AtomicBoolean b;
    public final /* synthetic */ kotlinx.coroutines.i<mr9.l> c;

    public n(String r1, AtomicBoolean r2, kotlinx.coroutines.j r3, ImageEditSendMessageStrategy r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final Object invoke(Object r4) {
        ResourceUploadError r5 = (ResourceUploadError) r4;
        Intrinsics.checkNotNullParameter(r5, "it");
        FLogger.a.e("ImageEditSendMessageStrategy", "submitLocalImageResourceAccess failed, curUploaderIdentifier:" + this.a, r5);
        ImageEditSendMessageStrategy.e(this.b, this.a, this.c, null);
        return Unit.INSTANCE;
    }
}
