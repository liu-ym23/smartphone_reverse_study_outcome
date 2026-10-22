package com.larksuite.rucket.impl.base.request;

import com.bytedance.lark.sdk.StreamDataSource;
import com.larksuite.framework.callback.IGetDataCallback;
import com.larksuite.rucket.core.proxymethod.BaseProxyMethod;
import com.squareup.wire.Message;
import com.ss.android.lark.sdk.h;
import g38.c;
import g38.d;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public abstract class BaseCallProxyMethod<T extends Annotation> extends BaseProxyMethod<T> {

    public static final class a {
    }

    static {
    }

    public abstract void f(Message r1, IGetDataCallback r2, String r3, c r4, StreamDataSource r5, h r6);

    public BaseCallProxyMethod(Method r2) {
        Intrinsics.checkNotNullParameter(r2, "origin");
        super(r2);
    }

    @Override // com.larksuite.rucket.core.proxymethod.b
    public final void a(IGetDataCallback<?> r9, Object... r10) {
        Intrinsics.checkNotNullParameter(r9, "callback");
        Intrinsics.checkNotNullParameter(r10, "args");
        ArrayList r0 = new ArrayList();
        int r1 = r10.length;
        int r2 = 0;
        int r3 = 0;
    L3:
        if (r3 >= r1) goto L8;
        Object r4 = r10[r3];
        if (TypeIntrinsics.isFunctionOfArity(r4, 1) == false) goto L7;
        r0.add(r4);
    L7:
        r3 = r3 + 1;
        goto L3
    L8:
        Function1 r5 = (Function1) CollectionsKt.firstOrNull(r0);
        if (r5 != null) goto L11;
        r5 = BaseCallProxyMethod$invokeWithCallback$configHandler$1.INSTANCE;
    L11:
        ArrayList r6 = new ArrayList();
        int r7 = r10.length;
    L12:
        if (r2 >= r7) goto L17;
        Object r8 = r10[r2];
        if ((r8 instanceof Message) == false) goto L16;
        r6.add(r8);
    L16:
        r2 = r2 + 1;
        goto L12
    L17:
        Message r11 = (Message) CollectionsKt.first(r6);
        b r12 = new b();
        r5.invoke(r12);
        String r13 = r12.b;
        h r14 = r12.c;
        StreamDataSource r15 = r12.a.toSource();
        int r16 = d.a;
        Class<U> r17 = e();
        Intrinsics.checkNotNullParameter(r17, "clazz");
        f(r11, r9, r13, new c(r17), r15, r14);
    }
}
