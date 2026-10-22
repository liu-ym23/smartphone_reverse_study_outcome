package com.larus.camera.impl.tile;

import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.service.quicksettings.Tile;
import android.service.quicksettings.TileService;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.common.apphost.AppHost;
import com.larus.platform.service.i3;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\b\b\u0007\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\u0007\u001a\u00020\u0005H\u0016J\b\u0010\b\u001a\u00020\u0005H\u0016J\b\u0010\t\u001a\u00020\u0005H\u0016J\b\u0010\n\u001a\u00020\u0005H\u0002J\b\u0010\u000b\u001a\u00020\u0005H\u0002¨\u0006\r"}, d2 = {"Lcom/larus/camera/impl/tile/CameraTileService;", "Landroid/service/quicksettings/TileService;", "<init>", "()V", "onTileAdded", "", "onTileRemoved", "onStartListening", "onStopListening", "onClick", "updateState", "handleClick", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CameraTileService extends TileService {

    public static final class a {
    }

    static {
    }

    @Override // android.service.quicksettings.TileService
    public final void onClick() {
        super.onClick();
        AppHost.Companion r1 = AppHost.a;     // Catch: Exception -> L11
        Intent r2 = r1.getApplication().getPackageManager().getLaunchIntentForPackage(r1.getApplication().getPackageName());     // Catch: Exception -> L11
        if (r2 != null) goto L6;
        FLogger.a.e("CameraTileService", "handleClick error, intent is null");     // Catch: Exception -> L11
    L14:
        return;
    L6:
        r2.setAction("android.intent.action.VIEW");     // Catch: Exception -> L11
        r2.setData(UriProtector.parse("sslocal://flow/chat?is_from_outer=true&auto_open_plus_camera=1&open_method=shortcuts&enter_method=shortcuts"));     // Catch: Exception -> L11
        r2.setFlags(268468224);     // Catch: Exception -> L11
        i3 r3 = i3.a;     // Catch: Exception -> L11
        r2.putExtra("is_tourist_mode", r3.f());     // Catch: Exception -> L11
        r2.putExtra("show_tourist_mode_toast", r3.f());     // Catch: Exception -> L11
        if (Build.VERSION.SDK_INT < 34) goto L9;
        startActivityAndCollapse(PendingIntent.getActivity(this, 0, r2, 67108864));     // Catch: Exception -> L11
        goto L14
    L9:
        startActivityAndCollapse(r2);     // Catch: Exception -> L11
    L11:
        e = move-exception;
        FLogger.a.e("CameraTileService", "handleClick error", e);
    }

    @Override // android.service.quicksettings.TileService
    public final void onStartListening() {
        super.onStartListening();
        Tile r0 = getQsTile();
        if (r0 != null) goto L6;
        return;
    L6:
        if (AppHost.a.isOversea() == false) goto L8;
        String r1 = getString(2131914247);
    L9:
        r0.setLabel(r1);
        r0.updateTile();
        return;
    L8:
        r1 = getString(2131910341);
        goto L9
    }

    public CameraTileService() {
    }

    @Override // android.service.quicksettings.TileService
    public final void onStopListening() {
        super.onStopListening();
    }

    @Override // android.service.quicksettings.TileService
    public final void onTileAdded() {
        super.onTileAdded();
    }

    @Override // android.service.quicksettings.TileService
    public final void onTileRemoved() {
        super.onTileRemoved();
    }
}
