package com.obric.memorydata.init.tasks.rpc;

import android.app.Application;
import com.bytedance.lego.init.model.IInitTask;
import com.bytedance.news.common.service.manager.ext.ServiceManagerExtKt;
import com.bytedance.rpc.RpcConfig;
import com.bytedance.rpc.RpcService;
import com.bytedance.rpc.callback.RpcInterceptor;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.rpc.RpcApi;
import com.obric.memorydata.middleware.api.rpc.RpcInitHook;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \u00062\u00020\u0001:\u0001\u0006B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0007"}, d2 = {"Lcom/obric/memorydata/init/tasks/rpc/RpcInitTask;", "Lcom/bytedance/lego/init/model/IInitTask;", "<init>", "()V", "run", "", "Companion", "init_task_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class RpcInitTask extends IInitTask {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f9927a = null;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/obric/memorydata/init/tasks/rpc/RpcInitTask$Companion;", "", "<init>", "()V", "TAG", "", "init_task_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        f9927a = new a(null);
    }

    public RpcInitTask() {
    }

    @Override // java.lang.Runnable
    public void run() {
        RpcInitHook r7 = (RpcInitHook) ZeusTransformUtils.preCheckCast(ServiceManagerExtKt.impl(Reflection.getOrCreateKotlinClass(RpcInitHook.class)), RpcInitHook.class, "com.obric.memorydata.plugin");
        if (r7 == null) goto L5;
        r7.beforeInitRpc();
        RpcConfig r0 = RpcService.createRpcConfigBuilder().setBaseUrl(r7.rpcBaseUrl()).addHeader(r7.addRpcHeader()).addQuery(r7.addRpcCommonQuery()).setReadTimeout(TimeUnit.SECONDS.toMillis(30)).setConnectTimeout(TimeUnit.SECONDS.toMillis(30)).build(new RpcConfig[0]);
        RpcService.init((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getApplication(), "com.obric.memorydata.plugin"), Application.class, "com.obric.memorydata.plugin"), r0);
        Iterator r1 = ((Iterable) ZeusTransformUtils.preCheckCast(r7.addRpcInterceptors(), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L13:
        if (r1.hasNext() == false) goto L15;
        RpcService.addRpcInterceptor((RpcInterceptor) ZeusTransformUtils.preCheckCast(r1.next(), RpcInterceptor.class, "com.obric.memorydata.plugin"), new Class[0]);
        goto L13
    L15:
        r7.afterInitRpc();
        RpcApi.INSTANCE.rpcReady();
        return;
    L5:
        if (AppContext.INSTANCE.isDebug() == true) goto L10;
        if (AppContext.INSTANCE.isAdminMode() == true) goto L10;
        return;
    L10:
        throw new IllegalStateException("NetworkInitHook not impl");
    }
}
