package com.obric.memorydata.middleware.impl.network.rpc;

import com.bytedance.rpc.RpcException;
import com.bytedance.rpc.RpcRequestModifier;
import com.bytedance.rpc.callback.RpcInterceptor;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\u0007¢\u0006\u0004\b\u0002\u0010\u0003JA\u0010\u0004\u001a\u00020\u00052\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u00072\u0006\u0010\b\u001a\u00020\t2\u000e\u0010\n\u001a\n\u0012\u0006\b\u0001\u0012\u00020\f0\u000b2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016¢\u0006\u0002\u0010\u0011JN\u0010\u0012\u001a\u00020\u00052\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\u0013\u001a\u0004\u0018\u00010\f2\n\u0010\u0014\u001a\u0006\u0012\u0002\b\u00030\u00152\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00100\u00172\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J,\u0010\u0018\u001a\u00020\u00192\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016¨\u0006\u001d"}, d2 = {"Lcom/obric/memorydata/middleware/impl/network/rpc/RpcLoggingInterceptor;", "Lcom/bytedance/rpc/callback/RpcInterceptor;", "<init>", "()V", "preHandle", "", "serviceClass", "Ljava/lang/Class;", "method", "Ljava/lang/reflect/Method;", "parameters", "", "", "modifier", "Lcom/bytedance/rpc/RpcRequestModifier;", "operationType", "", "(Ljava/lang/Class;Ljava/lang/reflect/Method;[Ljava/lang/Object;Lcom/bytedance/rpc/RpcRequestModifier;Ljava/lang/String;)Z", "postHandle", "result", "resultReset", "Ljava/lang/ThreadLocal;", "headers", "", "exceptionHandle", "", "error", "Lcom/bytedance/rpc/RpcException;", "Companion", "middleware_impl_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class b implements RpcInterceptor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f11785a = null;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/obric/memorydata/middleware/impl/network/rpc/RpcLoggingInterceptor$Companion;", "", "<init>", "()V", "TAG", "", "middleware_impl_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        f11785a = new a(null);
    }

    public b() {
    }

    @Override // com.bytedance.rpc.callback.RpcInterceptor
    public void exceptionHandle(Class<?> r7, Method r8, RpcException r9, String r10) {
        Intrinsics.checkNotNullParameter(r7, "serviceClass");
        Intrinsics.checkNotNullParameter(r8, "method");
        Intrinsics.checkNotNullParameter(r9, "error");
        Intrinsics.checkNotNullParameter(r10, "operationType");
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "RpcLoggingInterceptor", "<-- FAILED HTTP Method: " + r8.getName() + " Error: " + r9 + " OperationType: " + r10, null, 4, null);
    }

    @Override // com.bytedance.rpc.callback.RpcInterceptor
    public boolean postHandle(Class<?> r3, Method r4, Object r5, ThreadLocal<?> r6, Map<String, String> r7, String r8) {
        Map r2 = (Map) ZeusTransformUtils.wrapperContextForParams(r7, Map.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "serviceClass");
        Intrinsics.checkNotNullParameter(r4, "method");
        Intrinsics.checkNotNullParameter(r6, "resultReset");
        Intrinsics.checkNotNullParameter(r2, "headers");
        Intrinsics.checkNotNullParameter(r8, "operationType");
        Iterator r9 = r2.entrySet().iterator();
        String r10 = "[";
    L4:
        if (r9.hasNext() == false) goto L6;
        Map.Entry r11 = (Map.Entry) ZeusTransformUtils.preCheckCast(r9.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        r10 = r10 + '(' + ((String) ZeusTransformUtils.preCheckCast(r11.getKey(), String.class, "com.obric.memorydata.plugin")) + ", " + ((String) ZeusTransformUtils.preCheckCast(r11.getValue(), String.class, "com.obric.memorydata.plugin")) + ')';
        goto L4
    L6:
        RunLog.INSTANCE.debug("RpcLoggingInterceptor", "<-- END HTTP Method: " + r4.getName() + " Header: " + (r10 + ']') + " Result: " + r5 + " OperationType: " + r8);
        return true;
    }

    @Override // com.bytedance.rpc.callback.RpcInterceptor
    public boolean preHandle(Class<?> r4, Method r5, Object[] r6, RpcRequestModifier r7, String r8) {
        Intrinsics.checkNotNullParameter(r4, "serviceClass");
        Intrinsics.checkNotNullParameter(r5, "method");
        Intrinsics.checkNotNullParameter(r6, "parameters");
        Intrinsics.checkNotNullParameter(r7, "modifier");
        Intrinsics.checkNotNullParameter(r8, "operationType");
        int r3 = r6.length;
        String r9 = "[";
        int r0 = 0;
    L3:
        if (r0 >= r3) goto L5;
        r9 = r9 + '(' + r6[r0] + ')';
        r0 = r0 + 1;
        goto L3
    L5:
        RunLog.INSTANCE.debug("RpcLoggingInterceptor", "--> Method: " + r5.getName() + " Parameters: " + (r9 + ']') + "  Modifier: " + r7 + " OperationType: " + r8);
        return true;
    }
}
