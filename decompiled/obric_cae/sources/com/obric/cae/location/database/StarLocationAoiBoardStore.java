package com.obric.cae.location.database;

import android.content.Context;
import com.obric.cae.libs.location.poi.AoiBoard;
import com.obric.cae.location.geosdk.poi.StarAoiBoardManager;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class StarLocationAoiBoardStore implements StarAoiBoardManager.AoiBoardStore {
    private final StarLocationDbManager mDbManager;

    public StarLocationAoiBoardStore(Context r8, int r10) {
        this.mDbManager = StarLocationDbManager.getInstance(r8, r10);
    }

    @Override // com.obric.cae.location.geosdk.poi.StarAoiBoardManager.AoiBoardStore
    public int deleteAllAoiBoards() {
        return this.mDbManager.deleteAllAoiBoards();
    }

    @Override // com.obric.cae.location.geosdk.poi.StarAoiBoardManager.AoiBoardStore
    public int deleteAoiBoardsByTypes(Set<AoiBoard.Type> r8) {
        return this.mDbManager.deleteAoiBoardsByTypes(r8);
    }

    @Override // com.obric.cae.location.geosdk.poi.StarAoiBoardManager.AoiBoardStore
    public List<AoiBoard> queryAllAoiBoards() {
        return this.mDbManager.queryAllAoiBoards();
    }

    @Override // com.obric.cae.location.geosdk.poi.StarAoiBoardManager.AoiBoardStore
    public AoiBoard queryAoiBoardByPoiId(String r8) {
        return this.mDbManager.queryAoiBoardByPoiId(r8);
    }

    @Override // com.obric.cae.location.geosdk.poi.StarAoiBoardManager.AoiBoardStore
    public boolean updateAoiBoardGeofenceId(String r8, String r10) {
        return this.mDbManager.updateAoiBoardGeofenceId(r8, r10);
    }

    @Override // com.obric.cae.location.geosdk.poi.StarAoiBoardManager.AoiBoardStore
    public boolean upsertAoiBoards(List<AoiBoard> r8) {
        return this.mDbManager.upsertAoiBoards(r8);
    }
}
