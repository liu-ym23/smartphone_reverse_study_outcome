package com.obric.memorydata.sdk.server;

import android.content.Intent;
import android.os.IBinder;
import com.obric.capabilitykit.entity.memory.MemorySourceLinkType;
import com.obric.memorydata.sdk.service.BinderCode;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016J\u0010\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\u000e"}, d2 = {"Lcom/obric/memorydata/sdk/server/IPoolService;", "", "provideBinderCode", "Lcom/obric/memorydata/sdk/service/BinderCode;", "provideBinder", "Landroid/os/IBinder;", "onCreate", "", "onDestroy", "onBind", MemorySourceLinkType.INTENT, "Landroid/content/Intent;", "onUnbind", "", "memoryDataSDKServer_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface IPoolService {

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        public static void a(IPoolService r2) {
            IPoolService r3 = (IPoolService) ZeusTransformUtils.wrapperContextForParams(r2, IPoolService.class, "com.obric.memorydata.plugin");
        }

        public static void a(IPoolService r2, Intent r3) {
            IPoolService r4 = (IPoolService) ZeusTransformUtils.wrapperContextForParams(r2, IPoolService.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, MemorySourceLinkType.INTENT);
        }

        public static void b(IPoolService r2) {
            IPoolService r3 = (IPoolService) ZeusTransformUtils.wrapperContextForParams(r2, IPoolService.class, "com.obric.memorydata.plugin");
        }

        public static boolean b(IPoolService r2, Intent r3) {
            IPoolService r4 = (IPoolService) ZeusTransformUtils.wrapperContextForParams(r2, IPoolService.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, MemorySourceLinkType.INTENT);
            return false;
        }
    }

    void onBind(Intent r1);

    void onCreate();

    void onDestroy();

    boolean onUnbind(Intent r1);

    IBinder provideBinder();

    BinderCode provideBinderCode();
}
