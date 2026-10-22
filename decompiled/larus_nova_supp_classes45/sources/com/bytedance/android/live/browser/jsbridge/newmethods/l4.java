package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.android.annie.bridge.method.abs.GetDownloadGiftAssetsResultModel;
import kotlin.ExceptionsKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class l4 implements com.bytedance.android.livesdk.gift.platform.business.effect.assets.f {
    public final /* synthetic */ k4 a;

    public final void b(boolean r1) {
    }

    public final void onProgress(int r1) {
    }

    public l4(k4 r1) {
        this.a = r1;
    }

    public final void a(long r3) {
        k4 r4 = this.a;
        GetDownloadGiftAssetsResultModel r5 = new GetDownloadGiftAssetsResultModel();
        r5.a(GetDownloadGiftAssetsResultModel.Code.Success);
        r5.c("cancel");
        GetDownloadGiftAssetsResultModel.a r0 = new GetDownloadGiftAssetsResultModel.a();
        r0.a(1);
        Unit r1 = Unit.INSTANCE;
        r5.b(r0);
        r4.finishWithResult(r5);
    }

    public final void onFailed(Throwable r5) {
        Intrinsics.checkNotNullParameter(r5, "t");
        k4 r0 = this.a;
        GetDownloadGiftAssetsResultModel r1 = new GetDownloadGiftAssetsResultModel();
        r1.a(GetDownloadGiftAssetsResultModel.Code.Success);
        r1.c("failed, " + ExceptionsKt.stackTraceToString(r5));
        GetDownloadGiftAssetsResultModel.a r6 = new GetDownloadGiftAssetsResultModel.a();
        r6.a(2);
        Unit r2 = Unit.INSTANCE;
        r1.b(r6);
        r0.finishWithResult(r1);
    }

    public final void c(long r4, String r6) {
        Intrinsics.checkNotNullParameter(r6, "path");
        k4 r5 = this.a;
        GetDownloadGiftAssetsResultModel r7 = new GetDownloadGiftAssetsResultModel();
        r7.a(GetDownloadGiftAssetsResultModel.Code.Success);
        r7.c("success");
        GetDownloadGiftAssetsResultModel.a r0 = new GetDownloadGiftAssetsResultModel.a();
        r0.a(0);
        r0.b("file://" + r6);
        Unit r8 = Unit.INSTANCE;
        r7.b(r0);
        r5.finishWithResult(r7);
    }
}
