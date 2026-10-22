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
import com.lynx.jsbridge.LynxResourceModule;
import com.obric.aivoice.core.data.NameKeys;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import wc9.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\b\b\u0007\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\u0007\u001a\u00020\u0005H\u0016J\b\u0010\b\u001a\u00020\u0005H\u0016J\b\u0010\t\u001a\u00020\u0005H\u0002J\b\u0010\n\u001a\u00020\u0005H\u0016J\b\u0010\u000b\u001a\u00020\u0005H\u0002¨\u0006\r"}, d2 = {"Lcom/larus/voicecall/impl/tile/RealtimeCallTileService;", "Landroid/service/quicksettings/TileService;", "<init>", "()V", "onTileAdded", NameKeys.UnloadStrategy_No_Strategy, "onTileRemoved", "onStartListening", "onClick", "handleClick", "onStopListening", "updateState", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class RealtimeCallTileService extends TileService {

    public static final class a {
    }

    static {
    }

    @Override // android.service.quicksettings.TileService
    public final void onClick() {
        FLogger r0 = FLogger.a;
        r0.i("RealtimeCallTileService", "onClick");
        super.onClick();
        e r2 = (e) AuthModelDelegate.b.y().getValue();     // Catch: Exception -> L18
        if (r2 == null) goto L6;
        String r3 = r2.a;     // Catch: Exception -> L18
    L7:
        Uri r4 = UriProtector.parse("sslocal://flow/realtime_chat?is_from_outer=true&bot_id=7234781073513644036&open_method=shortcuts&sec_scene=shortcuts_call&enter_method=shortcuts");     // Catch: Exception -> L18
        if (o0.d(r3) == false) goto L10;
        r4 = y0.b(r4, "conversation_id", r3);     // Catch: Exception -> L18
    L10:
        AppHost.Companion r5 = AppHost.a;     // Catch: Exception -> L18
        Intent r6 = r5.getApplication().getPackageManager().getLaunchIntentForPackage(r5.getApplication().getPackageName());     // Catch: Exception -> L18
        if (r6 != null) goto L13;
        r0.e("RealtimeCallTileService", "handleClick error, intent is null");     // Catch: Exception -> L18
    L20:
        int r1 = z3a.a.a;
        Intrinsics.checkNotNullParameter(LynxResourceModule.AUDIO_TYPE, "modalType");
        o r7 = o.a;
        JSONObject r8 = new JSONObject();
        r8.put("modal_type", LynxResourceModule.AUDIO_TYPE);
        Unit r9 = Unit.INSTANCE;
        r7.reportEvent("flow_rd_tile_click", r8);
        return;
    L13:
        r6.setAction("android.intent.action.VIEW");     // Catch: Exception -> L18
        r6.setData(r4);     // Catch: Exception -> L18
        r6.setFlags(268468224);     // Catch: Exception -> L18
        i3 r10 = i3.a;     // Catch: Exception -> L18
        r6.putExtra("is_tourist_mode", r10.f());     // Catch: Exception -> L18
        r6.putExtra("show_tourist_mode_toast", r10.f());     // Catch: Exception -> L18
        if (Build.VERSION.SDK_INT < 34) goto L16;
        startActivityAndCollapse(PendingIntent.getActivity(this, 0, r6, 67108864));     // Catch: Exception -> L18
        goto L20
    L16:
        startActivityAndCollapse(r6);     // Catch: Exception -> L18
        goto L20
    L6:
        r3 = null;
    L18:
        e = move-exception;
        FLogger.a.e("RealtimeCallTileService", "handleClick error", e);
        goto L20
    }

    @Override // android.service.quicksettings.TileService
    public final void onStartListening() {
        super.onStartListening();
        FLogger.a.i("RealtimeCallTileService", "onStartListening");
        Tile r0 = getQsTile();
        if (r0 != null) goto L6;
        return;
    L6:
        if (AppHost.a.isOversea() == false) goto L8;
        String r1 = getString(2131914246);
    L9:
        r0.setLabel(r1);
        r0.updateTile();
        return;
    L8:
        r1 = getString(2131910340);
        goto L9
    }

    @Override // android.service.quicksettings.TileService
    public final void onStopListening() {
        super.onStopListening();
        FLogger.a.i("RealtimeCallTileService", "onStopListening");
    }

    @Override // android.service.quicksettings.TileService
    public final void onTileAdded() {
        super.onTileAdded();
        FLogger.a.i("RealtimeCallTileService", "onTileAdded");
        int r0 = z3a.a.a;
        Intrinsics.checkNotNullParameter(LynxResourceModule.AUDIO_TYPE, "modalType");
        o r1 = o.a;
        JSONObject r2 = new JSONObject();
        r2.put("modal_type", LynxResourceModule.AUDIO_TYPE);
        Unit r3 = Unit.INSTANCE;
        r1.reportEvent("flow_rd_tile_add", r2);
    }

    @Override // android.service.quicksettings.TileService
    public final void onTileRemoved() {
        super.onTileRemoved();
        FLogger.a.i("RealtimeCallTileService", "onTileRemoved");
        int r0 = z3a.a.a;
        Intrinsics.checkNotNullParameter(LynxResourceModule.AUDIO_TYPE, "modalType");
        o r1 = o.a;
        JSONObject r2 = new JSONObject();
        r2.put("modal_type", LynxResourceModule.AUDIO_TYPE);
        Unit r3 = Unit.INSTANCE;
        r1.reportEvent("flow_rd_tile_remove", r2);
    }

    public RealtimeCallTileService() {
    }
}
