package com.obric.memorydata.recommend.tile;

import android.service.quicksettings.TileService;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public interface IScreenObservationTileDelegate {
    void onClick();

    void onCreate(TileService r1);

    void onDestroy();

    void onStartListening();

    void onStopListening();

    void onTileAdded();

    void onTileRemoved();
}
