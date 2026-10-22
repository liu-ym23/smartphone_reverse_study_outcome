package com.bytedance.amap.adapter;

import com.amap.api.maps.AMap;
import com.amap.api.maps.AMapOptions;
import com.amap.api.maps.UiSettings;
import com.bytedance.map.api.logger.MapLogger;
import com.bytedance.map.api.model.BDMapUiConfigs;
import com.bytedance.map.api.monitor.MapMonitor;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class AMapUiSettingsAdapter {
    private static final int AMAP_ZOOM_POSITION_RIGHT_BOTTOM = 0;
    private static final int AMAP_ZOOM_POSITION_RIGHT_CENTER = 0;
    private static final String TAG = "AMapUiSettingsAdapter";

    private AMapUiSettingsAdapter() {
    }

    static {
        AMAP_ZOOM_POSITION_RIGHT_CENTER = resolveAmapOptionConstant(1, new String[]{"ZOOM_POSITION_RIGHT_CENTER"});
        AMAP_ZOOM_POSITION_RIGHT_BOTTOM = resolveAmapOptionConstant(2, new String[]{"ZOOM_POSITION_RIGHT_BOTTOM", "ZOOM_POSITION_RIGHT_BUTTOM"});
    }

    public static int getLogoPosition(AMap r10) {
        UiSettings r11 = getUi(r10);
        if (r11 != null) goto L5;
        return 0;
    L5:
        int r12 = r11.getLogoPosition();
        int r1 = 1;
        if (r12 == 1) goto L10;
        r1 = 2;
        if (r12 == 2) goto L10;
        return 0;
    L10:
        return r1;
    }

    private static UiSettings getUi(AMap r0) {
        if (r0 != null) goto L5;
        return null;
    L5:
        return r0.getUiSettings();
    }

    public static int getZoomPosition(AMap r10) {
        UiSettings r11 = getUi(r10);
        if (r11 != null) goto L6;
        return 2;
    L6:
        if (r11.getZoomPosition() != AMAP_ZOOM_POSITION_RIGHT_CENTER) goto L9;
        return 1;
    L9:
        return 2;
    }

    public static boolean isCompassEnabled(AMap r0) {
        UiSettings r1 = getUi(r0);
        if (r1 != null) goto L7;
        return false;
    L7:
        return r1.isCompassEnabled();
    }

    public static boolean isGestureScaleByMapCenter(AMap r0) {
        UiSettings r1 = getUi(r0);
        if (r1 != null) goto L7;
        return false;
    L7:
        return r1.isGestureScaleByMapCenter();
    }

    public static boolean isIndoorSwitchEnabled(AMap r0) {
        UiSettings r1 = getUi(r0);
        if (r1 != null) goto L7;
        return false;
    L7:
        return r1.isIndoorSwitchEnabled();
    }

    public static boolean isMyLocationButtonEnabled(AMap r0) {
        UiSettings r1 = getUi(r0);
        if (r1 != null) goto L7;
        return false;
    L7:
        return r1.isMyLocationButtonEnabled();
    }

    public static boolean isRotateGesturesEnabled(AMap r0) {
        UiSettings r1 = getUi(r0);
        if (r1 != null) goto L7;
        return false;
    L7:
        return r1.isRotateGesturesEnabled();
    }

    public static boolean isScaleControlsEnabled(AMap r0) {
        UiSettings r1 = getUi(r0);
        if (r1 != null) goto L7;
        return false;
    L7:
        return r1.isScaleControlsEnabled();
    }

    public static boolean isScrollGesturesEnabled(AMap r0) {
        UiSettings r1 = getUi(r0);
        if (r1 != null) goto L7;
        return false;
    L7:
        return r1.isScrollGesturesEnabled();
    }

    public static boolean isTiltGesturesEnabled(AMap r0) {
        UiSettings r1 = getUi(r0);
        if (r1 != null) goto L7;
        return false;
    L7:
        return r1.isTiltGesturesEnabled();
    }

    public static boolean isZoomControlsEnabled(AMap r0) {
        UiSettings r1 = getUi(r0);
        if (r1 != null) goto L7;
        return false;
    L7:
        return r1.isZoomControlsEnabled();
    }

    public static boolean isZoomGesturesEnabled(AMap r0) {
        UiSettings r1 = getUi(r0);
        if (r1 != null) goto L7;
        return false;
    L7:
        return r1.isZoomGesturesEnabled();
    }

    public static void apply(AMap r10, BDMapUiConfigs r11) {
        if (r10 == null) goto L76;
        if (r11 == null) goto L78;
        UiSettings r12 = r10.getUiSettings();     // Catch: Exception -> L71
        if (r12 != null) goto L9;
        return;
    L9:
        if (r11.getScaleControlsEnabled() == null) goto L12;
        r12.setScaleControlsEnabled(r11.getScaleControlsEnabled().booleanValue());     // Catch: Exception -> L71
    L12:
        if (r11.getZoomControlsEnabled() == null) goto L15;
        r12.setZoomControlsEnabled(r11.getZoomControlsEnabled().booleanValue());     // Catch: Exception -> L71
    L15:
        if (r11.getMyLocationButtonEnabled() == null) goto L18;
        r12.setMyLocationButtonEnabled(r11.getMyLocationButtonEnabled().booleanValue());     // Catch: Exception -> L71
    L18:
        if (r11.getCompassEnabled() == null) goto L21;
        r12.setCompassEnabled(r11.getCompassEnabled().booleanValue());     // Catch: Exception -> L71
    L21:
        if (r11.getAllGesturesEnabled() == null) goto L24;
        r12.setAllGesturesEnabled(r11.getAllGesturesEnabled().booleanValue());     // Catch: Exception -> L71
    L24:
        if (r11.getRotateGesturesEnabled() == null) goto L27;
        r12.setRotateGesturesEnabled(r11.getRotateGesturesEnabled().booleanValue());     // Catch: Exception -> L71
    L27:
        if (r11.getZoomGesturesEnabled() == null) goto L30;
        r12.setZoomGesturesEnabled(r11.getZoomGesturesEnabled().booleanValue());     // Catch: Exception -> L71
    L30:
        if (r11.getScrollGesturesEnabled() == null) goto L33;
        r12.setScrollGesturesEnabled(r11.getScrollGesturesEnabled().booleanValue());     // Catch: Exception -> L71
    L33:
        if (r11.getTiltGesturesEnabled() == null) goto L36;
        r12.setTiltGesturesEnabled(r11.getTiltGesturesEnabled().booleanValue());     // Catch: Exception -> L71
    L36:
        if (r11.getGestureScaleByMapCenter() == null) goto L39;
        r12.setGestureScaleByMapCenter(r11.getGestureScaleByMapCenter().booleanValue());     // Catch: Exception -> L71
    L39:
        if (r11.getLogoPosition() == null) goto L52;
        int r0 = r11.getLogoPosition().intValue();     // Catch: Exception -> L71
        if (r0 == 1) goto L49;
        int r13 = 2;
        if (r0 != 2) goto L45;
    L50:
        r12.setLogoPosition(r13);     // Catch: Exception -> L71
        goto L52
    L45:
        if (r0 == 4) goto L49;
        if (r0 == 5) goto L50;
        r13 = 0;
    L49:
        r13 = 1;
    L52:
        if (r11.getZoomPosition() == null) goto L59;
        if (r11.getZoomPosition().intValue() == 1) goto L56;
        int r1 = AMAP_ZOOM_POSITION_RIGHT_BOTTOM;     // Catch: Exception -> L71
    L57:
        r12.setZoomPosition(r1);     // Catch: Exception -> L71
        goto L59
    L56:
        r1 = AMAP_ZOOM_POSITION_RIGHT_CENTER;     // Catch: Exception -> L71
    L59:
        if (r11.getIndoorSwitchEnabled() == null) goto L62;
        r12.setIndoorSwitchEnabled(r11.getIndoorSwitchEnabled().booleanValue());     // Catch: Exception -> L71
    L62:
        if (r11.getLogoLeftMargin() == null) goto L65;
        r12.setLogoLeftMargin(r11.getLogoLeftMargin().intValue());     // Catch: Exception -> L71
    L65:
        if (r11.getLogoBottomMargin() == null) goto L68;
        r12.setLogoBottomMargin(r11.getLogoBottomMargin().intValue());     // Catch: Exception -> L71
    L68:
        if (r11.getZoomInByScreenCenter() == null) goto L77;
        r12.setZoomInByScreenCenter(r11.getZoomInByScreenCenter().booleanValue());     // Catch: Exception -> L71
        return;
    L77:
        return;
    L71:
        e = move-exception;
        MapMonitor.amapExceptionMonitor(e);
        MapLogger.i(TAG, "apply ui settings error:" + e.getMessage());
        return;
    L78:
        return;
    }

    public static BDMapUiConfigs getUiSettings(AMap r10, int r11) {
        BDMapUiConfigs.Builder r0 = new BDMapUiConfigs.Builder();
        r0.setScaleControlsEnabled(isScaleControlsEnabled(r10));
        r0.setZoomControlsEnabled(isZoomControlsEnabled(r10));
        r0.setCompassEnabled(isCompassEnabled(r10));
        r0.setMyLocationButtonEnabled(isMyLocationButtonEnabled(r10));
        r0.setScrollGesturesEnabled(isScrollGesturesEnabled(r10));
        r0.setZoomGesturesEnabled(isZoomGesturesEnabled(r10));
        r0.setTiltGesturesEnabled(isTiltGesturesEnabled(r10));
        r0.setRotateGesturesEnabled(isRotateGesturesEnabled(r10));
        r0.setGestureScaleByMapCenter(isGestureScaleByMapCenter(r10));
        r0.setLogoPosition(r11);
        r0.setZoomPosition(getZoomPosition(r10));
        r0.setIndoorSwitchEnabled(isIndoorSwitchEnabled(r10));
        r0.setZoomInByScreenCenter(isGestureScaleByMapCenter(r10));
        return r0.build();
    }

    private static int resolveAmapOptionConstant(int r10, String... r11) {
        int r1 = 0;
    L3:
        if (r1 >= r11.length) goto L8;
        return AMapOptions.class.getField(r11[r1]).getInt(null);
    L7:
        r1 = r1 + 1;
        goto L3
    L8:
        MapLogger.i(TAG, "resolve AMap option constant failed, fallback=" + r10);
        return r10;
    }
}
