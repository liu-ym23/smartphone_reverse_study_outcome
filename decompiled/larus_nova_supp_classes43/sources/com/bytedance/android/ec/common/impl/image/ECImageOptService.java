package com.bytedance.android.ec.common.impl.image;

import android.graphics.drawable.Animatable;
import android.os.Handler;
import android.os.Looper;
import com.bytedance.android.ec.common.api.image.IECImageOptService;
import com.bytedance.android.ec.core.imagex.d0;
import com.bytedance.android.ec.core.imagex.opt.ECImageMainHandlerOpt;
import com.bytedance.android.ec.core.imagex.u;
import com.bytedance.crash.d;
import com.facebook.common.executors.UiThreadImmediateExecutorService;
import com.facebook.datasource.BaseDataSubscriber;
import com.facebook.datasource.DataSubscriber;
import com.facebook.imagepipeline.request.ImageRequest;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\u0012\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J6\u0010\t\u001a\u00020\u00062\n\u0010\n\u001a\u0006\u0012\u0002\b\u00030\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00062\b\u0010\u0010\u001a\u0004\u0018\u00010\bH\u0016JB\u0010\u0011\u001a\u00020\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\b2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0010\u0010\u0019\u001a\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\u001aH\u0016¨\u0006\u001b"}, d2 = {"Lcom/bytedance/android/ec/common/impl/image/ECImageOptService;", "Lcom/bytedance/android/ec/common/api/image/IECImageOptService;", "()V", "initMainHandlerOptConfig", "", "isUseNetworkPriorityOpt", "", "imageCallerContext", "", "notifyDataSubscriber", "dataSubscriber", "Lcom/facebook/datasource/DataSubscriber;", "executor", "Ljava/util/concurrent/Executor;", "isFailure", "isCancellation", "dataSource", "onFinalImageSet", "id", "", "image", "animatable", "Landroid/graphics/drawable/Animatable;", "imageRequest", "Lcom/facebook/imagepipeline/request/ImageRequest;", "extra", "", "ec-common-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECImageOptService implements IECImageOptService {
    public static final ECImageOptService INSTANCE = null;

    private ECImageOptService() {
    }

    static {
        INSTANCE = new ECImageOptService();
    }

    @Override // com.bytedance.android.ec.common.api.image.IECImageOptService
    public void initMainHandlerOptConfig() {
        ECImageMainHandlerOpt r0 = ECImageMainHandlerOpt.f;
        r0.getClass();
        List r1 = (List) ECImageMainHandlerOpt.d.getValue(r0, ECImageMainHandlerOpt.a[0]);
    }

    @Override // com.bytedance.android.ec.common.api.image.IECImageOptService
    public boolean isUseNetworkPriorityOpt(Object r10) {
        if ((r10 instanceof u) == true) goto L7;
        return false;
    L7:
        return ((u) r10).n;
    }

    @Override // com.bytedance.android.ec.common.api.image.IECImageOptService
    public boolean notifyDataSubscriber(DataSubscriber<?> r10, Executor r11, boolean r12, boolean r13, Object r14) {
        Intrinsics.checkNotNullParameter(r10, "dataSubscriber");
        Intrinsics.checkNotNullParameter(r11, "executor");
        ECImageMainHandlerOpt r15 = ECImageMainHandlerOpt.f;
        r15.getClass();
        Intrinsics.checkNotNullParameter(r10, "dataSubscriber");
        Intrinsics.checkNotNullParameter(r11, "executor");
        if (((Boolean) ECImageMainHandlerOpt.c.getValue()).booleanValue() == false) goto L28;
        if (r12 == true) goto L25;
        if (r13 == false) goto L9;
        return false;
    L9:
        if ((r10 instanceof BaseDataSubscriber) == true) goto L11;
        return false;
    L11:
        if ((r11 instanceof UiThreadImmediateExecutorService) == false) goto L30;
    L20:
        th = move-exception;
        d.c(th);
        return false;
    L14:
        if (ThreadMethodProxy.currentThread() != ThreadMethodProxy.getLooperThread(new Handler(Looper.getMainLooper()).getLooper())) goto L16;
        boolean r16 = true;
    L17:
        if (r16 == true) goto L27;
        return r15.a((BaseDataSubscriber) r10, r14);
    L27:
        return false;
    L16:
        r16 = false;
        goto L17
    L30:
        return false;
    L25:
        return false;
    L28:
        return false;
    }

    @Override // com.bytedance.android.ec.common.api.image.IECImageOptService
    public void onFinalImageSet(String r1, Object r10, Animatable r11, ImageRequest r12, Map<?, ?> r13) {
        if (r13 == null) goto L4;
        Object r14 = r13.get("scene_tag");
    L5:
        d0.a(r10, r12, r14);
        return;
    L4:
        r14 = null;
        goto L5
    }
}
