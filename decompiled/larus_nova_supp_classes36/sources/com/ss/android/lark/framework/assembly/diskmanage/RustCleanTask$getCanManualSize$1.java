package com.ss.android.lark.framework.assembly.diskmanage;

import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.log.Log;
import java.util.concurrent.CountDownLatch;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0017\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, d2 = {"com/ss/android/lark/framework/assembly/diskmanage/RustCleanTask$getCanManualSize$1", "Lcom/larksuite/framework/callback/IGetDataCallback;", "", "onSuccess", "", "sizeInMB", "(Ljava/lang/Float;)V", "onError", "err", "Lcom/larksuite/framework/callback/Entity/ErrorResult;", "diskmanage-assembly_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class RustCleanTask$getCanManualSize$1 implements IGetDataCallback<Float> {
    final /* synthetic */ Ref.DoubleRef $canManualSize;
    final /* synthetic */ CountDownLatch $countDownLatch;

    public void onError(ErrorResult r3) {
        Intrinsics.checkNotNullParameter(r3, "err");
        Log.e("RustCleanTask", "getCanManualSize error: " + r3.getDisplayMsg());
        this.$canManualSize.element = 0.0d;
        this.$countDownLatch.countDown();
    }

    public void onSuccess(Float r4) {
        if (r4 == null) goto L4;
        Ref.DoubleRef r0 = this.$canManualSize;
        r4.floatValue();
        Log.i("RustCleanTask", "getCanManualSize success");
        r0.element = (r4.floatValue() * 1024.0f) * 1024.0f;
    L4:
        this.$countDownLatch.countDown();
    }

    public /* bridge */ /* synthetic */ void onError(Object r1) {
        onError((ErrorResult) r1);
    }

    public /* bridge */ /* synthetic */ void onSuccess(Object r1) {
        onSuccess((Float) r1);
    }

    public RustCleanTask$getCanManualSize$1(CountDownLatch r1, Ref.DoubleRef r2) {
        this.$countDownLatch = r1;
        this.$canManualSize = r2;
    }
}
