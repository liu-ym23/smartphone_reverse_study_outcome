package com.bytedance.android.live.revlink.link.biz.doublecomponent;

import android.net.Uri;
import com.bytedance.android.live.revlink.impl.multianchor.dynamic.h;
import com.bytedance.android.live.revlink.scopeui.LynxBizType;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u000e\u001a\u0004\u0018\u00010\u000b2\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00002\u000e\u0010\u0005\u001a\n\u0018\u00010\u0003j\u0004\u0018\u0001`\u00042\u0019\u0010\n\u001a\u0015\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0006¢\u0006\u0002\b\t¢\u0006\u0004\b\f\u0010\r"}, d2 = {"Lvy0/a;", "", "p1", "Landroid/net/Uri;", "Lcom/bytedance/revenue/platform/api/core/Uri;", "p2", "Lkotlin/Function1;", "Lyy0/c;", "", "Lkotlin/ExtensionFunctionType;", "p3", "Lzy0/b;", "invoke", "(Lvy0/a;Landroid/net/Uri;Lkotlin/jvm/functions/Function1;)Lzy0/b;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
public final /* synthetic */ class DoubleNativeComponent$loadWidgetByJsb$1 extends FunctionReferenceImpl implements Function3<vy0.a<Object>, Uri, Function1<? super yy0.c, ? extends Unit>, zy0.b> {
    public DoubleNativeComponent$loadWidgetByJsb$1(LynxUIOperationImpl r8) {
        super(3, r8, LynxUIOperationImpl.class, "createCardFunc", "createCardFunc(Lcom/bytedance/android/live/revenue/platform/hybrid/api/HybridCardType;Landroid/net/Uri;Lkotlin/jvm/functions/Function1;)Lcom/bytedance/android/live/revenue/platform/hybrid/api/ui/IHybridCard;", 0);
    }

    public final zy0.b invoke(vy0.a<Object> r8, Uri r9, final Function1<? super yy0.c, Unit> r10) {
        Intrinsics.checkNotNullParameter(r8, "p1");
        LynxUIOperationImpl r0 = (LynxUIOperationImpl) ((CallableReference) this).receiver;
        r0.getClass();
        Intrinsics.checkNotNullParameter(r8, "type");
        jy0.b.c("DoubleNativeComponent", "createCardFunc with url: " + r9, null, 4);
        r0.removeAll();
        r0.c = r0.getContext().k4().c(LynxBizType.Hybrid, h.b.b, r9, new LynxUIOperationImpl$createCardFunc$1(r10));
        jy0.b.c("DoubleNativeComponent", "createCardFunc with card: " + r0.c, null, 4);
        return r0.c;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2, Object r3) {
        return invoke((vy0.a) r1, (Uri) r2, (Function1) r3);
    }
}
