package com.obric.mcpclient.complextasksdk;

import android.os.IInterface;
import android.util.Log;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\"\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/obric/mcpclient/complextasksdk/ScheduleProxy;", "Lcom/obric/mcpclient/complextasksdk/IScheduleProxy;", "api", "Lcom/obric/mcpclient/complextasksdk/IComplexTaskHandle;", "(Lcom/obric/mcpclient/complextasksdk/IComplexTaskHandle;)V", "getApi", "()Lcom/obric/mcpclient/complextasksdk/IComplexTaskHandle;", "mApi", "executeTask", "", "taskData", "", "isShow", "", "callback", "Lcom/obric/mcpclient/complextasksdk/IComplexTaskCallback;", "Companion", "complextasksdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class f implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f8289a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final d f8290b;
    private final d c;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/obric/mcpclient/complextasksdk/ScheduleProxy$Companion;", "", "()V", "TAG", "", "complextasksdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        f8289a = new a(null);
    }

    public f(d r7) {
        d r8 = (d) ZeusTransformUtils.wrapperContextForParams(r7, d.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r8, "api");
        this.f8290b = r8;
        BinderExceptionHandlerProxy.Companion r0 = BinderExceptionHandlerProxy.Companion;
        IInterface r9 = (IInterface) ZeusTransformUtils.preCheckCast(r8, IInterface.class, "com.obric.memorydata.plugin");
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L8
        Object r3 = Proxy.newProxyInstance(d.class.getClassLoader(), new Class[]{d.class}, (InvocationHandler) ZeusTransformUtils.preCheckCast(new BinderExceptionHandlerProxy(r9, "ScheduleProxy", d.class), InvocationHandler.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L8
        if (r3 == null) goto L7;
        r9 = (IInterface) ZeusTransformUtils.preCheckCast((d) ZeusTransformUtils.preCheckCast(r3, d.class, "com.obric.memorydata.plugin"), IInterface.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L8
    L12:
        this.c = (d) ZeusTransformUtils.preCheckCast(r9, d.class, "com.obric.memorydata.plugin");
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type com.obric.mcpclient.complextasksdk.IComplexTaskHandle");     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        Result.Companion r4 = Result.Companion;
        Throwable r5 = Result.m1424exceptionOrNullimpl(Result.m1421constructorimpl(ResultKt.createFailure(th)));
        if (r5 == null) goto L12;
        Log.e("ScheduleProxy", "BinderExceptionHandlerProxy createProxyInstance for " + r9.getClass() + " fail", r5);
        goto L12
    }

    @Override // com.obric.mcpclient.complextasksdk.e
    public void a(String r3, boolean r4, c r5) {
        c r6 = (c) ZeusTransformUtils.wrapperContextForParams(r5, c.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "taskData");
        this.c.a(r3, r4, r6);
    }
}
