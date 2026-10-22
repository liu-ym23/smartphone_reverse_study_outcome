package com.bytedance.lynx.map.ng;

import com.lynx.serval.svg.SVGRenderEngine;
import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.ui.view.UISimpleView$$PropsSetter;
import com.lynx.tasm.behavior.y0;

/* JADX INFO: loaded from: classes2.dex */
public class LynxMapView$$PropsSetter extends UISimpleView$$PropsSetter {
    public LynxMapView$$PropsSetter() {
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI$$PropsSetter, com.lynx.tasm.behavior.ui.LynxBaseUI$$PropsSetter, com.lynx.tasm.behavior.utils.LynxUISetter
    public final void a(LynxBaseUI r10, String r11, y0 r12) {
        LynxMapView r5 = (LynxMapView) r10;
        r11.getClass();
        byte r13 = -1;
        switch(r11.hashCode()) {
            case -1849556936: goto L98;
            case -1829331082: goto L94;
            case -1705603718: goto L90;
            case -1555043537: goto L86;
            case -1364013995: goto L82;
            case -1249080334: goto L78;
            case -1150747538: goto L74;
            case -999389744: goto L70;
            case -960769147: goto L66;
            case -944478312: goto L62;
            case -580870954: goto L58;
            case -496402379: goto L54;
            case -355555053: goto L50;
            case -40300674: goto L46;
            case 3321844: goto L42;
            case 3744723: goto L38;
            case 93927806: goto L34;
            case 197554645: goto L30;
            case 244318912: goto L26;
            case 301360997: goto L22;
            case 1308145008: goto L18;
            case 1363008100: goto L14;
            case 1810201766: goto L10;
            case 1971059331: goto L6;
            default: goto L101;
        };
    L101:
        switch(r13) {
            case 0: goto L150;
            case 1: goto L148;
            case 2: goto L146;
            case 3: goto L144;
            case 4: goto L142;
            case 5: goto L140;
            case 6: goto L138;
            case 7: goto L136;
            case 8: goto L134;
            case 9: goto L132;
            case 10: goto L130;
            case 11: goto L128;
            case 12: goto L126;
            case 13: goto L124;
            case 14: goto L122;
            case 15: goto L120;
            case 16: goto L118;
            case 17: goto L116;
            case 18: goto L114;
            case 19: goto L112;
            case 20: goto L110;
            case 21: goto L108;
            case 22: goto L106;
            case 23: goto L104;
            default: goto L102;
        };
    L102:
        super.a(r10, r11, r12);
        return;
    L104:
        r5.setNeedUserLocationHeading(r12.e(r11, false));
        return;
    L106:
        r5.setRestrictedRegion(r12.f10815a.getArray(r11));
        return;
    L108:
        r5.enableInitAllGestures(r12.e(r11, false));
        return;
    L110:
        r5.setBindZoomChange(r12.f10815a.getString(r11));
        return;
    L112:
        r5.setMinZoomLevel(r12.b(0.0f, r11));
        return;
    L114:
        r5.enableInitScrollGestures(r12.e(r11, false));
        return;
    L116:
        r5.setMapStyle(r12.f10815a.getString(r11));
        return;
    L118:
        r5.setInitBound(r12.f10815a.getMap(r11));
        return;
    L120:
        r5.setInitZoom(r12.b(0.0f, r11));
        return;
    L122:
        r5.showLine(r12.f10815a.getArray(r11));
        return;
    L124:
        r5.setRotation(r12.b(0.0f, r11));
        return;
    L126:
        r5.setMaxZoomLevel(r12.b(0.0f, r11));
        return;
    L128:
        r5.setCenterAndZoom(r12.f10815a.getMap(r11));
        return;
    L130:
        r5.setBindViewDraw(r12.f10815a.getString(r11));
        return;
    L132:
        r5.isBindSelectAnnotation(r12.f10815a.getString(r11));
        return;
    L134:
        r5.setUserLocationAnnotation(r12.f10815a.getMap(r11));
        return;
    L136:
        r5.enableInitTiltGestures(r12.e(r11, false));
        return;
    L138:
        r5.setHandleGesture(r12.e(r11, false));
        return;
    L140:
        r5.enableInitRotateGestures(r12.e(r11, false));
        return;
    L142:
        r5.setInitCenter(r12.f10815a.getArray(r11));
        return;
    L144:
        r5.showAnnotation(r12.f10815a.getArray(r11));
        return;
    L146:
        r5.enableInitZoomGestures(r12.e(r11, false));
        return;
    L148:
        r5.enableCollision(r12.e(r11, false));
        return;
    L150:
        r5.collisionPercent(r12.a(r11, 0.0d));
        return;
    L6:
        if (r11.equals("need_user_location_heading") == false) goto L101;
        r13 = 23;
        goto L101
    L10:
        if (r11.equals("restricted-region") == false) goto L101;
        r13 = 22;
        goto L101
    L14:
        if (r11.equals("enable_all_gestures") == false) goto L101;
        r13 = 21;
        goto L101
    L18:
        if (r11.equals("is_bind_zoomchange") == false) goto L101;
        r13 = 20;
        goto L101
    L22:
        if (r11.equals("min-zoom-level") == false) goto L101;
        r13 = 19;
        goto L101
    L26:
        if (r11.equals("enable_scroll_gestures") == false) goto L101;
        r13 = 18;
        goto L101
    L30:
        if (r11.equals("mapstyle") == false) goto L101;
        r13 = 17;
        goto L101
    L34:
        if (r11.equals("bound") == false) goto L101;
        r13 = 16;
        goto L101
    L38:
        if (r11.equals("zoom") == false) goto L101;
        r13 = 15;
        goto L101
    L42:
        if (r11.equals(SVGRenderEngine.LINE) == false) goto L101;
        r13 = 14;
        goto L101
    L46:
        if (r11.equals("rotation") == false) goto L101;
        r13 = 13;
        goto L101
    L50:
        if (r11.equals("max-zoom-level") == false) goto L101;
        r13 = 12;
        goto L101
    L54:
        if (r11.equals("centerAndZoom") == false) goto L101;
        r13 = 11;
        goto L101
    L58:
        if (r11.equals("is_bind_viewdraw") == false) goto L101;
        r13 = 10;
        goto L101
    L62:
        if (r11.equals("is_bind_selectannotation") == false) goto L101;
        r13 = 9;
        goto L101
    L66:
        if (r11.equals("user_location_annotation") == false) goto L101;
        r13 = 8;
        goto L101
    L70:
        if (r11.equals("enable_tilt_gestures") == false) goto L101;
        r13 = 7;
        goto L101
    L74:
        if (r11.equals("enable_handle_gesture") == false) goto L101;
        r13 = 6;
        goto L101
    L78:
        if (r11.equals("enable_rotate_gestures") == false) goto L101;
        r13 = 5;
        goto L101
    L82:
        if (r11.equals("center") == false) goto L101;
        r13 = 4;
        goto L101
    L86:
        if (r11.equals("annotation") == false) goto L101;
        r13 = 3;
        goto L101
    L90:
        if (r11.equals("enable_zoom_gestures") == false) goto L101;
        r13 = 2;
        goto L101
    L94:
        if (r11.equals("enable_collision") == false) goto L101;
        r13 = 1;
        goto L101
    L98:
        if (r11.equals("collision_percent") == false) goto L101;
        r13 = 0;
        goto L101
    }
}
