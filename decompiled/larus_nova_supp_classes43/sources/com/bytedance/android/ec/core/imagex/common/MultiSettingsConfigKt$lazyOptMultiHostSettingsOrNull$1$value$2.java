package com.bytedance.android.ec.core.imagex.common;

import com.bytedance.android.ec.core.utils.t0;
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
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\t\u001a\u00020\u0006\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u00002\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002H\u0086@¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"Lcom/bytedance/android/ec/core/imagex/common/z;", "T", "Lcom/google/gson/internal/LinkedTreeMap;", "", "", "p1", "", "invoke", "(Lcom/google/gson/internal/LinkedTreeMap;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 3})
public final /* synthetic */ class MultiSettingsConfigKt$lazyOptMultiHostSettingsOrNull$1$value$2 extends AdaptedFunctionReference implements Function2<LinkedTreeMap<String, Object>, Continuation<? super Unit>, Object>, SuspendFunction {
    public MultiSettingsConfigKt$lazyOptMultiHostSettingsOrNull$1$value$2(t r10) {
        super(2, r10, t.class, "onConfigReady", "onConfigReady(Lcom/google/gson/internal/LinkedTreeMap;)V", 4);
    }

    public final Object invoke(LinkedTreeMap<String, Object> r10, Continuation<? super Unit> r11) {
        ((t) ((AdaptedFunctionReference) this).receiver).a = true;
        int r12 = t0.a;
        Gson r13 = t0.a.a;
        u.b((r) GsonProtectorUtils.fromJson(r13, GsonProtectorUtils.toJson(r13, r10), null));
        return Unit.INSTANCE;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r10) {
        return invoke((LinkedTreeMap) r1, (Continuation) r10);
    }
}
