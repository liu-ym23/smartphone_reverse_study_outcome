package com.bytedance.amap.model;

import com.amap.api.maps.model.TileOverlay;
import com.bytedance.map.api.model.IHeatMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public class AliHeatMap implements IHeatMap {
    private static final String TAG = "AliHeatMap";
    private final String mId;
    private final TileOverlay tileOverlay;

    public void clearTileCache() {
        TileOverlay r0 = this.tileOverlay;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.clearTileCache();
    }

    public float getZIndex() {
        TileOverlay r0 = this.tileOverlay;
        if (r0 != null) goto L7;
        return 0.0f;
    L7:
        return r0.getZIndex();
    }

    public boolean isVisible() {
        TileOverlay r0 = this.tileOverlay;
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.isVisible();
    }

    public void remove() {
        TileOverlay r0 = this.tileOverlay;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.remove();
    }

    public String getId() {
        return this.mId;
    }

    public void setVisible(boolean r10) {
        TileOverlay r0 = this.tileOverlay;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.setVisible(r10);
    }

    public void setZIndex(float r10) {
        TileOverlay r0 = this.tileOverlay;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.setZIndex(r10);
    }

    public AliHeatMap(TileOverlay r1, String r10) {
        this.tileOverlay = r1;
        this.mId = r10;
    }
}
