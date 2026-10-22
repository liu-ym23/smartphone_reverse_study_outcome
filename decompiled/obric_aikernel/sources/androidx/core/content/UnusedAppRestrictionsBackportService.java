package androidx.core.content;

import android.annotation.SuppressLint;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.unusedapprestrictions.IUnusedAppRestrictionsBackportService;

/* JADX INFO: loaded from: classes.dex */
public abstract class UnusedAppRestrictionsBackportService extends Service {

    @SuppressLint({"ActionValue"})
    public static final String ACTION_UNUSED_APP_RESTRICTIONS_BACKPORT_CONNECTION = "android.support.unusedapprestrictions.action.CustomUnusedAppRestrictionsBackportService";
    private IUnusedAppRestrictionsBackportService.Stub mBinder;

    public UnusedAppRestrictionsBackportService() {
        this.mBinder = new AnonymousClass1(this);
    }

    protected abstract void isPermissionRevocationEnabled(@NonNull UnusedAppRestrictionsBackportCallback r10);

    @Override // android.app.Service
    @Nullable
    public IBinder onBind(@Nullable Intent r10) {
        return this.mBinder;
    }
}
