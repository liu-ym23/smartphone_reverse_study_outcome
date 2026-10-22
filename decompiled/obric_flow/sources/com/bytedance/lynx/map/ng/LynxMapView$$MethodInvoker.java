package com.bytedance.lynx.map.ng;

import androidx.annotation.Keep;
import com.lynx.react.bridge.Callback;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.utils.a;

/* JADX INFO: loaded from: classes2.dex */
@Keep
public class LynxMapView$$MethodInvoker implements a {
    public LynxMapView$$MethodInvoker() {
    }

    @Override // com.lynx.tasm.behavior.utils.a
    public /* bridge */ /* synthetic */ void invoke(LynxBaseUI r5, String r10, ReadableMap r11, Callback r12) {
        invoke((LynxMapView) r5, r10, r11, r12);
    }

    public void invoke(LynxMapView r5, String r10, ReadableMap r11, Callback r12) {
        r10.getClass();
        byte r13 = -1;
        switch(r10.hashCode()) {
            case -2101427557: goto L138;
            case -1778114336: goto L134;
            case -1344993529: goto L130;
            case -1227886261: goto L126;
            case -1073110391: goto L122;
            case -992733175: goto L118;
            case -713000806: goto L114;
            case -591316042: goto L110;
            case -527962973: goto L106;
            case -447172068: goto L102;
            case -357431021: goto L98;
            case -196434654: goto L94;
            case -74937271: goto L90;
            case 117384023: goto L86;
            case 194959693: goto L82;
            case 291402627: goto L78;
            case 332001099: goto L74;
            case 647572392: goto L70;
            case 692239790: goto L66;
            case 849322739: goto L62;
            case 1109563931: goto L58;
            case 1160671884: goto L54;
            case 1388640828: goto L50;
            case 1389419468: goto L46;
            case 1419773105: goto L42;
            case 1431967330: goto L38;
            case 1495013418: goto L34;
            case 1576700140: goto L30;
            case 1663855148: goto L26;
            case 1848904985: goto L22;
            case 1908871954: goto L18;
            case 1949753288: goto L14;
            case 1985172309: goto L10;
            case 2041298082: goto L6;
            default: goto L141;
        };
    L141:
        switch(r13) {
            case 0: goto L210;
            case 1: goto L208;
            case 2: goto L206;
            case 3: goto L204;
            case 4: goto L202;
            case 5: goto L200;
            case 6: goto L198;
            case 7: goto L196;
            case 8: goto L194;
            case 9: goto L192;
            case 10: goto L190;
            case 11: goto L188;
            case 12: goto L186;
            case 13: goto L184;
            case 14: goto L182;
            case 15: goto L180;
            case 16: goto L178;
            case 17: goto L176;
            case 18: goto L174;
            case 19: goto L172;
            case 20: goto L170;
            case 21: goto L168;
            case 22: goto L166;
            case 23: goto L164;
            case 24: goto L162;
            case 25: goto L160;
            case 26: goto L158;
            case 27: goto L156;
            case 28: goto L154;
            case 29: goto L152;
            case 30: goto L150;
            case 31: goto L148;
            case 32: goto L146;
            case 33: goto L144;
            default: goto L142;
        };
    L142:
        r12.invoke(new Object[]{3});
        return;
    L144:
        r5.startPolygonEdit(r11, r12);
        return;
    L146:
        r5.setZoom(r11, r12);
        return;
    L148:
        r5.getBound(r12);
        return;
    L150:
        r5.scrollIntoView(r11, r12);
        return;
    L152:
        r5.requestAccessibilityFocus(r11, r12);
        return;
    L154:
        r5.setAllGesturesEnable(r11, r12);
        return;
    L156:
        r5.setRotationDegree(r11, r12);
        return;
    L158:
        r5.setRotateGesturesEnable(r11, r12);
        return;
    L160:
        r5.updatePolygons(r11, r12);
        return;
    L162:
        r5.requestUIInfo(r11, r12);
        return;
    L164:
        r5.deselectAnnotation(r11, r12);
        return;
    L166:
        r5.setBound(r11, r12);
        return;
    L168:
        r5.setTiltGesturesEnable(r11, r12);
        return;
    L170:
        r5.lnglatToPoint(r11, r12);
        return;
    L172:
        r5.setCenterAndZoom(r11, r12);
        return;
    L174:
        r5.fetchAccessibilityTargets(r11, r12);
        return;
    L176:
        r5.startMarkerAnimation(r11, r12);
        return;
    L178:
        r5.getCenter(r12);
        return;
    L180:
        r5.getBoundWithPadding(r11, r12);
        return;
    L182:
        r5.takeScreenshot(r11, r12);
        return;
    L184:
        r5.setCenter(r11, r12);
        return;
    L186:
        r5.getZoom(r12);
        return;
    L188:
        r5.setZoomGesturesEnable(r11, r12);
        return;
    L190:
        r5.boundingClientRect(r11, r12);
        return;
    L192:
        r5.setScrollGesturesEnable(r11, r12);
        return;
    L194:
        r5.innerText(r11, r12);
        return;
    L196:
        r5.updateLines(r11, r12);
        return;
    L198:
        r5.updateCircles(r11, r12);
        return;
    L200:
        r5.latLngToPx(r11, r12);
        return;
    L202:
        r5.endPolygonEdit(r11, r12);
        return;
    L204:
        r5.selectAnnotation(r11, r12);
        return;
    L206:
        r5.getPolygonPoints(r11, r12);
        return;
    L208:
        r5.getRotationDegree(r12);
        return;
    L210:
        r5.updateAnnotations(r11, r12);
        return;
    L6:
        if (r10.equals("startPolygonEdit") == false) goto L141;
        r13 = 33;
        goto L141
    L10:
        if (r10.equals("setZoom") == false) goto L141;
        r13 = 32;
        goto L141
    L14:
        if (r10.equals("getBound") == false) goto L141;
        r13 = 31;
        goto L141
    L18:
        if (r10.equals("scrollIntoView") == false) goto L141;
        r13 = 30;
        goto L141
    L22:
        if (r10.equals("requestAccessibilityFocus") == false) goto L141;
        r13 = 29;
        goto L141
    L26:
        if (r10.equals("setAllGesturesEnable") == false) goto L141;
        r13 = 28;
        goto L141
    L30:
        if (r10.equals("setRotationDegree") == false) goto L141;
        r13 = 27;
        goto L141
    L34:
        if (r10.equals("setRotateGesturesEnable") == false) goto L141;
        r13 = 26;
        goto L141
    L38:
        if (r10.equals("updatePolygons") == false) goto L141;
        r13 = 25;
        goto L141
    L42:
        if (r10.equals("requestUIInfo") == false) goto L141;
        r13 = 24;
        goto L141
    L46:
        if (r10.equals("deselectAnnotation") == false) goto L141;
        r13 = 23;
        goto L141
    L50:
        if (r10.equals("setBound") == false) goto L141;
        r13 = 22;
        goto L141
    L54:
        if (r10.equals("setTiltGesturesEnable") == false) goto L141;
        r13 = 21;
        goto L141
    L58:
        if (r10.equals("lnglatToPoint") == false) goto L141;
        r13 = 20;
        goto L141
    L62:
        if (r10.equals("setCenterAndZoom") == false) goto L141;
        r13 = 19;
        goto L141
    L66:
        if (r10.equals("fetchAccessibilityTargets") == false) goto L141;
        r13 = 18;
        goto L141
    L70:
        if (r10.equals("startMarkerAnimation") == false) goto L141;
        r13 = 17;
        goto L141
    L74:
        if (r10.equals("getCenter") == false) goto L141;
        r13 = 16;
        goto L141
    L78:
        if (r10.equals("getBoundWithPadding") == false) goto L141;
        r13 = 15;
        goto L141
    L82:
        if (r10.equals("takeScreenshot") == false) goto L141;
        r13 = 14;
        goto L141
    L86:
        if (r10.equals("setCenter") == false) goto L141;
        r13 = 13;
        goto L141
    L90:
        if (r10.equals("getZoom") == false) goto L141;
        r13 = 12;
        goto L141
    L94:
        if (r10.equals("setZoomGesturesEnable") == false) goto L141;
        r13 = 11;
        goto L141
    L98:
        if (r10.equals("boundingClientRect") == false) goto L141;
        r13 = 10;
        goto L141
    L102:
        if (r10.equals("setScrollGesturesEnable") == false) goto L141;
        r13 = 9;
        goto L141
    L106:
        if (r10.equals("innerText") == false) goto L141;
        r13 = 8;
        goto L141
    L110:
        if (r10.equals("updateLines") == false) goto L141;
        r13 = 7;
        goto L141
    L114:
        if (r10.equals("updateCircles") == false) goto L141;
        r13 = 6;
        goto L141
    L118:
        if (r10.equals("latLngToPx") == false) goto L141;
        r13 = 5;
        goto L141
    L122:
        if (r10.equals("endPolygonEdit") == false) goto L141;
        r13 = 4;
        goto L141
    L126:
        if (r10.equals("selectAnnotation") == false) goto L141;
        r13 = 3;
        goto L141
    L130:
        if (r10.equals("getPolygonPoints") == false) goto L141;
        r13 = 2;
        goto L141
    L134:
        if (r10.equals("getRotationDegree") == false) goto L141;
        r13 = 1;
        goto L141
    L138:
        if (r10.equals("updateAnnotations") == false) goto L141;
        r13 = 0;
        goto L141
    }
}
