package com.larus.voicecall.impl.tile;

import android.app.PendingIntent;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.service.quicksettings.Tile;
import android.service.quicksettings.TileService;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.bmhome.chat.api.AuthModelDelegate;
import com.larus.common.apphost.AppHost;
import com.larus.platform.service.i3;
import com.larus.platform.service.o;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import com.larus.utils.y0;
import com.obric.aivoice.core.data.NameKeys;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import wc9.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\b\b\u0007\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\u0007\u001a\u00020\u0005H\u0016J\b\u0010\b\u001a\u00020\u0005H\u0016J\b\u0010\t\u001a\u00020\u0005H\u0016J\b\u0010\n\u001a\u00020\u0005H\u0002J\b\u0010\u000b\u001a\u00020\u0005H\u0002¨\u0006\r"}, d2 = {"Lcom/larus/voicecall/impl/tile/RealtimeVideoTileService;", "Landroid/service/quicksettings/TileService;", "<init>", "()V", "onTileAdded", NameKeys.UnloadStrategy_No_Strategy, "onTileRemoved", "onStartListening", "onStopListening", "onClick", "handleClick", "updateState", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class RealtimeVideoTileService extends TileService {

    public static final class a {
    }

    static {
    }

    @Override // android.service.quicksettings.TileService
    public final void onClick() {
        super.onClick();
        e r1 = (e) AuthModelDelegate.b.y().getValue();     // Catch: Exception -> L18
        if (r1 == null) goto L6;
        String r2 = r1.a;     // Catch: Exception -> L18
    L7:
        Uri r3 = UriProtector.parse("sslocal://flow/realtime_chat?is_from_outer=true&bot_id=7234781073513644036&open_method=shortcuts&open_vlm=1&sec_scene=shortcuts_video_call&enter_method=shortcuts");     // Catch: Exception -> L18
        if (o0.d(r2) == false) goto L10;
        r3 = y0.b(r3, "conversation_id", r2);     // Catch: Exception -> L18
    L10:
        AppHost.Companion r4 = AppHost.a;     // Catch: Exception -> L18
        Intent r5 = r4.getApplication().getPackageManager().getLaunchIntentForPackage(r4.getApplication().getPackageName());     // Catch: Exception -> L18
        if (r5 != null) goto L13;
        FLogger.a.e("RealtimeVideoTileService", "handleClick error, intent is null");     // Catch: Exception -> L18
    L20:
        int r0 = z3a.a.a;
        Intrinsics.checkNotNullParameter("video_call", "modalType");
        o r6 = o.a;
        JSONObject r7 = new JSONObject();
        r7.put("modal_type", "video_call");
        Unit r8 = Unit.INSTANCE;
        r6.reportEvent("flow_rd_tile_click", r7);
        return;
    L13:
        r5.setAction("android.intent.action.VIEW");     // Catch: Exception -> L18
        r5.setData(r3);     // Catch: Exception -> L18
        r5.setFlags(268468224);     // Catch: Exception -> L18
        i3 r9 = i3.a;     // Catch: Exception -> L18
        r5.putExtra("is_tourist_mode", r9.f());     // Catch: Exception -> L18
        r5.putExtra("show_tourist_mode_toast", r9.f());     // Catch: Exception -> L18
        if (Build.VERSION.SDK_INT < 34) goto L16;
        startActivityAndCollapse(PendingIntent.getActivity(this, 0, r5, 67108864));     // Catch: Exception -> L18
        goto L20
    L16:
        startActivityAndCollapse(r5);     // Catch: Exception -> L18
        goto L20
    L6:
        r2 = null;
    L18:
        e = move-exception;
        FLogger.a.e("RealtimeVideoTileService", "handleClick error", e);
        goto L20
    }

    @Override // android.service.quicksettings.TileService
    public final void onStartListening() {
        super.onStartListening();
        FLogger.a.i("RealtimeVideoTileService", "onStartListening");
        Tile r0 = getQsTile();
        if (r0 == null) goto L7;
        r0.setLabel(getString(2131910342));
        r0.updateTile();
        return;
    }

    @Override // android.service.quicksettings.TileService
    public final void onStopListening() {
        super.onStopListening();
        FLogger.a.i("RealtimeVideoTileService", "onStopListening");
    }

    @Override // android.service.quicksettings.TileService
    public final void onTileAdded() {
        super.onTileAdded();
        FLogger.a.i("RealtimeVideoTileService", "onTileAdded");
        int r0 = z3a.a.a;
        Intrinsics.checkNotNullParameter("video_call", "modalType");
        o r1 = o.a;
        JSONObject r2 = new JSONObject();
        r2.put("modal_type", "video_call");
        Unit r3 = Unit.INSTANCE;
        r1.reportEvent("flow_rd_tile_add", r2);
    }

    @Override // android.service.quicksettings.TileService
    public final void onTileRemoved() {
        super.onTileRemoved();
        FLogger.a.i("RealtimeVideoTileService", "onTileRemoved");
        int r0 = z3a.a.a;
        Intrinsics.checkNotNullParameter("video_call", "modalType");
        o r1 = o.a;
        JSONObject r2 = new JSONObject();
        r2.put("modal_type", "video_call");
        Unit r3 = Unit.INSTANCE;
        r1.reportEvent("flow_rd_tile_remove", r2);
    }

    public RealtimeVideoTileService() {
    }
}
