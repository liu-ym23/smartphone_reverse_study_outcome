package com.ss.android.lark.framework.assembly.diskmanage;

import com.bytedance.lark.pb.basic.v1.TriggerDataCleanResponse;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.log.Log;
import java.util.concurrent.CountDownLatch;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, d2 = {"com/ss/android/lark/framework/assembly/diskmanage/RustCleanTask$onManualClean$1", "Lcom/larksuite/framework/callback/IGetDataCallback;", "Lcom/bytedance/lark/pb/basic/v1/TriggerDataCleanResponse;", "onSuccess", "", "data", "onError", "err", "Lcom/larksuite/framework/callback/Entity/ErrorResult;", "diskmanage-assembly_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class RustCleanTask$onManualClean$1 implements IGetDataCallback<TriggerDataCleanResponse> {
    final /* synthetic */ cbb.a $cleanResult;
    final /* synthetic */ CountDownLatch $countDownLatch;

    public void onError(ErrorResult r3) {
        Intrinsics.checkNotNullParameter(r3, "err");
        Log.e("RustCleanTask", "triggerDataClean error: " + r3.getDisplayMsg());
        this.$cleanResult.a = false;
        this.$countDownLatch.countDown();
    }

    public void onSuccess(TriggerDataCleanResponse r6) {
        if (r6 == null) goto L4;
        cbb.a r0 = this.$cleanResult;
        Log.i("RustCleanTask", "triggerDataClean success: " + r6);
        r0.b = r0.b + ((long) r6.cleaned.size());
    L4:
        this.$countDownLatch.countDown();
    }

    public /* bridge */ /* synthetic */ void onError(Object r1) {
        onError((ErrorResult) r1);
    }

    public /* bridge */ /* synthetic */ void onSuccess(Object r1) {
        onSuccess((TriggerDataCleanResponse) r1);
    }

    public RustCleanTask$onManualClean$1(CountDownLatch r1, cbb.a r2) {
        this.$countDownLatch = r1;
        this.$cleanResult = r2;
    }
}
