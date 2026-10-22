package com.bytedance.android.ec.core.imagex.opt;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendFunction;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.AdaptedFunctionReference;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u0086@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/bytedance/android/shopping/api/image/a0;", "p1", "", "invoke", "(Lcom/bytedance/android/shopping/api/image/a0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 3})
public final /* synthetic */ class ImageDomainPreConnectConfig$config$3 extends AdaptedFunctionReference implements Function2<com.bytedance.android.shopping.api.image.a0, Continuation<? super Unit>, Object>, SuspendFunction {
    public ImageDomainPreConnectConfig$config$3(DomainPreConnect r10) {
        super(2, r10, DomainPreConnect.class, "initConfig", "initConfig(Lcom/bytedance/android/shopping/api/image/ImageDomainPreConnectModel;)V", 4);
    }

    public final Object invoke(com.bytedance.android.shopping.api.image.a0 r10, Continuation<? super Unit> r11) {
        ((DomainPreConnect) ((AdaptedFunctionReference) this).receiver).getClass();
        Intrinsics.checkNotNullParameter(r10, "config");
        HashMap<String, DomainPreConnect.a> r12 = new HashMap();
        List r13 = r10.b();
        if (r13 == null) goto L15;
        Iterator r14 = r13.iterator();
    L6:
        if (r14.hasNext() == false) goto L15;
        com.bytedance.android.shopping.api.image.z r0 = (com.bytedance.android.shopping.api.image.z) r14.next();
        Long r1 = r0.b();
        if (r1 == null) goto L10;
        long r15 = r1.longValue();
    L11:
        String r16 = r0.a();
        if (r16 == null) goto L6;
        r12.put(r16, new DomainPreConnect.a("https://" + r0.a(), r15 * 1000000));
        goto L6
    L10:
        r15 = 1000;
    L15:
        if ((!r12.isEmpty()) == false) goto L18;
        DomainPreConnect.a = r12;
    L18:
        return Unit.INSTANCE;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r10) {
        return invoke((com.bytedance.android.shopping.api.image.a0) r1, (Continuation) r10);
    }
}
