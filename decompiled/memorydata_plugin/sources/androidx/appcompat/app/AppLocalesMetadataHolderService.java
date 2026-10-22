package androidx.appcompat.app;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ServiceInfo;
import android.os.Build;
import android.os.IBinder;
import com.volcengine.zeus.service.PluginService;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public final class AppLocalesMetadataHolderService extends PluginService {

    private static class Api24Impl {
        private Api24Impl() {
        }

        static int getDisabledComponentFlag() {
            return 512;
        }
    }

    public AppLocalesMetadataHolderService() {
    }

    public static ServiceInfo getServiceInfo(Context r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
        if (Build.VERSION.SDK_INT < 24) goto L5;
        int r0 = Api24Impl.getDisabledComponentFlag() | 128;
    L7:
        return r5.getPackageManager().getServiceInfo(new ComponentName(r5, AppLocalesMetadataHolderService.class), r0);
    L5:
        r0 = 640;
        goto L7
    }

    public IBinder onBind(Intent r1) {
        throw new UnsupportedOperationException();
    }
}
