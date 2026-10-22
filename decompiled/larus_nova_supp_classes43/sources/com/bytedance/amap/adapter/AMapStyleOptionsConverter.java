package com.bytedance.amap.adapter;

import com.amap.api.maps.model.CustomMapStyleOptions;
import com.bytedance.map.api.model.BDMapStyleOptions;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class AMapStyleOptionsConverter {
    private AMapStyleOptionsConverter() {
    }

    public static CustomMapStyleOptions from(BDMapStyleOptions r10) {
        CustomMapStyleOptions r0 = new CustomMapStyleOptions();
        if (r10 != null) goto L5;
        return r0;
    L5:
        r0.setEnable(r10.isEnable());
        if (isEmpty(r10.getStyleId()) == true) goto L9;
        r0.setStyleId(r10.getStyleId());
    L9:
        if (r10.getStyleData() == null) goto L12;
        r0.setStyleData(r10.getStyleData());
    L15:
        if (r10.getStyleExtraData() == null) goto L18;
        r0.setStyleExtraData(r10.getStyleExtraData());
    L21:
        if (r10.getStyleTextureData() == null) goto L24;
        r0.setStyleTextureData(r10.getStyleTextureData());
    L27:
        if (r10.getStyleResData() == null) goto L30;
        r0.setStyleResData(r10.getStyleResData());
    L33:
        if (r10.getStyleDataOversea() == null) goto L36;
        r0.setStyleDataOversea(r10.getStyleDataOversea());
    L38:
        return r0;
    L36:
        if (isEmpty(r10.getStyleDataOverseaPath()) == true) goto L38;
        r0.setStyleDataOverseaPath(r10.getStyleDataOverseaPath());
        goto L38
    L30:
        if (isEmpty(r10.getStyleResDataPath()) == true) goto L33;
        r0.setStyleResDataPath(r10.getStyleResDataPath());
        goto L33
    L24:
        if (isEmpty(r10.getStyleTexturePath()) == true) goto L27;
        r0.setStyleTexturePath(r10.getStyleTexturePath());
        goto L27
    L18:
        if (isEmpty(r10.getStyleExtraPath()) == true) goto L21;
        r0.setStyleExtraPath(r10.getStyleExtraPath());
        goto L21
    L12:
        if (isEmpty(r10.getStyleDataPath()) == true) goto L15;
        r0.setStyleDataPath(r10.getStyleDataPath());
        goto L15
    }

    private static boolean isEmpty(String r0) {
        if (r0 != null) goto L4;
    L7:
        return true;
    L4:
        if (r0.isEmpty() == true) goto L7;
        return false;
    }
}
