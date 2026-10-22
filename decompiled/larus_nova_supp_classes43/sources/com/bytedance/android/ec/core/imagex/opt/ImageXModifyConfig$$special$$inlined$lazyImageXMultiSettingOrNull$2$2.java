package com.bytedance.android.ec.core.imagex.opt;

import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.google.gson.internal.LinkedTreeMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendFunction;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.AdaptedFunctionReference;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\n\u001a\u00020\u0006\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u00002\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002H\u0086@¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/ec/core/imagex/common/z;", "T", "Lcom/google/gson/internal/LinkedTreeMap;", "", "", "p1", "", "invoke", "(Lcom/google/gson/internal/LinkedTreeMap;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "com/bytedance/android/ec/core/imagex/opt/ImageXModifyConfig$lazyImageXMultiSettingOrNull$$inlined$lazyOptMultiHostSettingsOrNull$1$2", "<anonymous>"}, k = 3, mv = {1, 4, 3})
public final /* synthetic */ class ImageXModifyConfig$$special$$inlined$lazyImageXMultiSettingOrNull$2$2 extends AdaptedFunctionReference implements Function2<LinkedTreeMap<String, Object>, Continuation<? super Unit>, Object>, SuspendFunction {
    public ImageXModifyConfig$$special$$inlined$lazyImageXMultiSettingOrNull$2$2(ImageXModifyConfig.b r10) {
        super(2, r10, ImageXModifyConfig.b.class, "onConfigReady", "onConfigReady(Lcom/google/gson/internal/LinkedTreeMap;)V", 4);
    }

    public final Object invoke(LinkedTreeMap<String, Object> r10, Continuation<? super Unit> r11) {
        ImageXModifyConfig.b r12 = (ImageXModifyConfig.b) ((AdaptedFunctionReference) this).receiver;
        r12.d = true;
        int r0 = com.bytedance.android.ec.core.utils.t0.a;
        Gson r1 = com.bytedance.android.ec.core.utils.t0.a.a;
        r12.c = com.bytedance.android.ec.core.imagex.common.u.b((com.bytedance.android.ec.core.imagex.common.r) GsonProtectorUtils.fromJson(r1, GsonProtectorUtils.toJson(r1, r10), r12.a));
        return Unit.INSTANCE;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r10) {
        return invoke((LinkedTreeMap) r1, (Continuation) r10);
    }
}
