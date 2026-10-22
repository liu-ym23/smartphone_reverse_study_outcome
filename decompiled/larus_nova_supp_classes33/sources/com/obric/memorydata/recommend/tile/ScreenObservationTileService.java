package com.obric.memorydata.recommend.tile;

import android.service.quicksettings.TileService;
import com.volcengine.zeus.Zeus;
import java.util.ArrayList;
import java.util.List;
import oka.b;
import oka.c;
import oka.d;
import oka.e;
import oka.f;
import oka.g;
import oka.h;
import oka.i;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public class ScreenObservationTileService extends TileService {
    public static final /* synthetic */ int a = 0;

    public interface a {
        void a(IScreenObservationTileDelegate r1);
    }

    @Override // android.service.quicksettings.TileService
    public final void onClick() {
        super.onClick();
        a(new f());
    }

    @Override // android.app.Service
    public final void onCreate() {
        super.onCreate();
        a(new c(this));
    }

    @Override // android.service.quicksettings.TileService, android.app.Service
    public final void onDestroy() {
        super.onDestroy();
        IScreenObservationTileDelegate r0 = ScreenObservationTileRegistry.getDelegate();
        if (r0 == null) goto L6;
        r0.onDestroy();
        return;
    }

    @Override // android.service.quicksettings.TileService
    public final void onStartListening() {
        super.onStartListening();
        a(new g());
    }

    @Override // android.service.quicksettings.TileService
    public final void onStopListening() {
        super.onStopListening();
        a(new e());
    }

    @Override // android.service.quicksettings.TileService
    public final void onTileAdded() {
        super.onTileAdded();
        a(new d());
    }

    @Override // android.service.quicksettings.TileService
    public final void onTileRemoved() {
        super.onTileRemoved();
        a(new h());
    }

    public ScreenObservationTileService() {
    }

    public static void a(final a r1) {
        Runnable r0 = new i(r1);
        List<Runnable> r2 = b.a;
        if (Zeus.isPluginLoaded("com.obric.memorydata.plugin") == false) goto L5;
        r0.run();
        return;
    L5:
        ((ArrayList) b.a).add(r0);
        if (b.c == true) goto L11;
        b.c = true;
        Zeus.registerPluginStateListener(new oka.a());
        return;
    }
}
