package com.bytedance.amap.model;

import com.amap.api.maps.model.Arc;
import com.bytedance.map.api.model.IArc;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public class AliArc implements IArc {
    private static final String TAG = "AliArc";
    private Arc mArc;
    private String mId;

    public int getColor() {
        Arc r0 = this.mArc;
        if (r0 != null) goto L5;
        return 0;
    L5:
        return r0.getStrokeColor();
    }

    public int getWidth() {
        Arc r0 = this.mArc;
        if (r0 != null) goto L5;
        return 0;
    L5:
        return (int) r0.getStrokeWidth();
    }

    public float getZIndex() {
        Arc r0 = this.mArc;
        if (r0 != null) goto L5;
        return 0.0f;
    L5:
        return r0.getZIndex();
    }

    public boolean isVisible() {
        Arc r0 = this.mArc;
        if (r0 != null) goto L5;
        return false;
    L5:
        return r0.isVisible();
    }

    public void remove() {
        Arc r0 = this.mArc;
        if (r0 == null) goto L6;
        r0.remove();
        return;
    }

    public String getId() {
        return this.mId;
    }

    public void setColor(int r10) {
        Arc r0 = this.mArc;
        if (r0 == null) goto L6;
        r0.setStrokeColor(r10);
        return;
    }

    public void setVisible(boolean r10) {
        Arc r0 = this.mArc;
        if (r0 == null) goto L6;
        r0.setVisible(r10);
        return;
    }

    public void setWidth(int r10) {
        Arc r0 = this.mArc;
        if (r0 == null) goto L6;
        r0.setStrokeWidth(r10);
        return;
    }

    public void setZIndex(float r10) {
        Arc r0 = this.mArc;
        if (r0 == null) goto L6;
        r0.setZIndex(r10);
        return;
    }

    public AliArc(Arc r1, String r10) {
        this.mArc = r1;
        this.mId = r10;
    }
}
