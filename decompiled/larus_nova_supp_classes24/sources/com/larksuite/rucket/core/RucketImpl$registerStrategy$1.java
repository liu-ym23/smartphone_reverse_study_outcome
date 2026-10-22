package com.larksuite.rucket.core;

import c38.b;
import com.larksuite.component.blockit.sub_process.IP0SubProcess;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.larksuite.rucket.core.proxymethod.a;
import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public /* synthetic */ class RucketImpl$registerStrategy$1 extends FunctionReferenceImpl implements Function1<Method, a> {
    public RucketImpl$registerStrategy$1(Object r8) {
        super(1, r8, b.class, "proxyMethod", "proxyMethod(Ljava/lang/reflect/Method;)Lcom/larksuite/rucket/core/proxymethod/AbstractProxyMethod;", 0);
    }

    public final a invoke(Method r2) {
        Intrinsics.checkNotNullParameter(r2, IP0SubProcess.P0_PROCESS_NAME);
        return ((b) ((CallableReference) this).receiver).b(r2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((Method) r1);
    }
}
