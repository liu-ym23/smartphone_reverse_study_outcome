package androidx.appcompat.app;

import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.os.IBinder;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

/* JADX INFO: loaded from: classes.dex */
public final class AppLocalesMetadataHolderService extends Service {

    @RequiresApi(24)
    public static class Api24Impl {
        private Api24Impl() {
        }

        @DoNotInline
        public static int getDisabledComponentFlag() {
            return 512;
        }
    }

    public AppLocalesMetadataHolderService() {
    }

    @NonNull
    public static ServiceInfo getServiceInfo(@NonNull Context r5) throws PackageManager.NameNotFoundException {
        int r10 = Api24Impl.getDisabledComponentFlag() | 128;
        return r5.getPackageManager().getServiceInfo(new ComponentName(r5, AppLocalesMetadataHolderService.class), r10);
    }

    @Override // android.app.Service
    @NonNull
    public IBinder onBind(@NonNull Intent r5) {
        throw new UnsupportedOperationException();
    }
}
