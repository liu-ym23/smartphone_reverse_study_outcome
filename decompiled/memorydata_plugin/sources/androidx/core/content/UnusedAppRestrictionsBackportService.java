package androidx.core.content;

import android.content.Intent;
import android.os.IBinder;
import androidx.core.app.unusedapprestrictions.IUnusedAppRestrictionsBackportService;
import com.volcengine.zeus.service.PluginService;

/* JADX INFO: loaded from: classes.dex */
public abstract class UnusedAppRestrictionsBackportService extends PluginService {
    public static final String ACTION_UNUSED_APP_RESTRICTIONS_BACKPORT_CONNECTION = "android.support.unusedapprestrictions.action.CustomUnusedAppRestrictionsBackportService";
    private IUnusedAppRestrictionsBackportService.Stub mBinder;

    public UnusedAppRestrictionsBackportService() {
        this.mBinder = new AnonymousClass1(this);
    }

    public abstract void isPermissionRevocationEnabled(UnusedAppRestrictionsBackportCallback r1);

    public IBinder onBind(Intent r1) {
        return this.mBinder;
    }
}
