package com.lynx.animax;

import androidx.core.app.NotificationCompat;
import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.ui.LynxUI$$PropsSetter;
import com.lynx.tasm.behavior.y0;

/* JADX INFO: loaded from: classes2.dex */
public class UIAnimaX$$PropsSetter extends LynxUI$$PropsSetter {
    public UIAnimaX$$PropsSetter() {
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI$$PropsSetter, com.lynx.tasm.behavior.ui.LynxBaseUI$$PropsSetter, com.lynx.tasm.behavior.utils.LynxUISetter
    public final void a(LynxBaseUI r10, String r11, y0 r12) {
        UIAnimaX r5 = (UIAnimaX) r10;
        r11.getClass();
        switch(r11.hashCode()) {
            case -1673124846: goto L106;
            case -1489589134: goto L102;
            case -1426073969: goto L98;
            case -1340550148: goto L94;
            case -1162629129: goto L90;
            case -1001078227: goto L86;
            case -846027028: goto L82;
            case -839971427: goto L78;
            case -819151396: goto L74;
            case -795328846: goto L70;
            case -629825370: goto L66;
            case -303648977: goto L62;
            case -261882880: goto L58;
            case 114148: goto L54;
            case 114586: goto L50;
            case 3271912: goto L46;
            case 3327652: goto L42;
            case 109641799: goto L38;
            case 508360187: goto L34;
            case 1068228937: goto L30;
            case 1327968322: goto L26;
            case 1352104895: goto L22;
            case 1439562083: goto L18;
            case 1568893902: goto L14;
            case 1821306136: goto L10;
            case 1978397892: goto L6;
            default: goto L4;
        };
    L4:
        byte r13 = -1;
    L109:
        switch(r13) {
            case 0: goto L162;
            case 1: goto L160;
            case 2: goto L158;
            case 3: goto L156;
            case 4: goto L154;
            case 5: goto L152;
            case 6: goto L150;
            case 7: goto L148;
            case 8: goto L146;
            case 9: goto L144;
            case 10: goto L142;
            case 11: goto L140;
            case 12: goto L138;
            case 13: goto L136;
            case 14: goto L134;
            case 15: goto L132;
            case 16: goto L130;
            case 17: goto L128;
            case 18: goto L126;
            case 19: goto L124;
            case 20: goto L122;
            case 21: goto L120;
            case 22: goto L118;
            case 23: goto L116;
            case 24: goto L114;
            case 25: goto L112;
            default: goto L110;
        };
    L110:
        super.a(r10, r11, r12);
        return;
    L112:
        r5.setReverseMode(r12.e(r11, false));
        return;
    L114:
        r5.setSrcPolyfill(r12.f10815a.getMap(r11));
        return;
    L116:
        r5.setDisplayMode(r12.f10815a.getString(r11));
        return;
    L118:
        r5.setAutoPlay(r12.e(r11, true));
        return;
    L120:
        r5.setIgnoreAttachStatus(r12.e(r11, false));
        return;
    L122:
        r5.setStartFrame(r12.c(r11, 0));
        return;
    L124:
        r5.setMaxFrameRate(r12.a(r11, 0.0d));
        return;
    L126:
        r5.setEndFrame(r12.c(r11, -1));
        return;
    L128:
        r5.setSpeed(r12.b(0.0f, r11));
        return;
    L130:
        r5.setLoop(r12.e(r11, false));
        return;
    L132:
        r5.setJson(r12.f10815a.getString(r11));
        return;
    L134:
        r5.setTag(r12.f10815a.getString(r11));
        return;
    L136:
        r5.setSrc(r12.f10815a.getString(r11));
        return;
    L138:
        r5.setSrcFormat(r12.f10815a.getString(r11));
        return;
    L140:
        r5.setVideoFrameTimeout(r12.c(r11, 0));
        return;
    L142:
        r5.setLoopCount(r12.c(r11, 1));
        return;
    L144:
        r5.setKeepLastFrame(r12.e(r11, true));
        return;
    L146:
        r5.setDynamicResource(r12.e(r11, false));
        return;
    L148:
        r5.setAntiAliasing(r12.f10815a.getString(r11));
        return;
    L150:
        r5.setMultiThreadAccelerate(r12.e(r11, true));
        return;
    L152:
        r5.setProgress(r12.b(0.0f, r11));
        return;
    L154:
        r5.setObjectPosition(r12.f10815a.getString(r11));
        return;
    L156:
        r5.setFpsEventInterval(r12.c(r11, 0));
        return;
    L158:
        r5.setIgnoreLynxLifecycle(r12.e(r11, false));
        return;
    L160:
        r5.setObjectFit(r12.f10815a.getString(r11));
        return;
    L162:
        r5.setEnableScreenshot(r12.e(r11, false));
        return;
    L6:
        if (r11.equals("auto-reverse") == false) goto L164;
        r13 = 25;
        goto L109
    L164:
        r13 = -1;
        goto L109
    L10:
        if (r11.equals("src-polyfill") == false) goto L165;
        r13 = 24;
        goto L109
    L165:
        r13 = -1;
        goto L109
    L14:
        if (r11.equals("display-mode") == false) goto L166;
        r13 = 23;
        goto L109
    L166:
        r13 = -1;
        goto L109
    L18:
        if (r11.equals("autoplay") == false) goto L167;
        r13 = 22;
        goto L109
    L167:
        r13 = -1;
        goto L109
    L22:
        if (r11.equals("ignore-attach-status") == false) goto L168;
        r13 = 21;
        goto L109
    L168:
        r13 = -1;
        goto L109
    L26:
        if (r11.equals("start-frame") == false) goto L169;
        r13 = 20;
        goto L109
    L169:
        r13 = -1;
        goto L109
    L30:
        if (r11.equals("max-frame-rate") == false) goto L170;
        r13 = 19;
        goto L109
    L170:
        r13 = -1;
        goto L109
    L34:
        if (r11.equals("end-frame") == false) goto L171;
        r13 = 18;
        goto L109
    L171:
        r13 = -1;
        goto L109
    L38:
        if (r11.equals("speed") == false) goto L172;
        r13 = 17;
        goto L109
    L172:
        r13 = -1;
        goto L109
    L42:
        if (r11.equals("loop") == false) goto L173;
        r13 = 16;
        goto L109
    L173:
        r13 = -1;
        goto L109
    L46:
        if (r11.equals("json") == false) goto L174;
        r13 = 15;
        goto L109
    L174:
        r13 = -1;
        goto L109
    L50:
        if (r11.equals("tag") == false) goto L175;
        r13 = 14;
        goto L109
    L175:
        r13 = -1;
        goto L109
    L54:
        if (r11.equals("src") == false) goto L176;
        r13 = 13;
        goto L109
    L176:
        r13 = -1;
        goto L109
    L58:
        if (r11.equals("src-format") == false) goto L177;
        r13 = 12;
        goto L109
    L177:
        r13 = -1;
        goto L109
    L62:
        if (r11.equals("video-frame-timeout") == false) goto L178;
        r13 = 11;
        goto L109
    L178:
        r13 = -1;
        goto L109
    L66:
        if (r11.equals("loop-count") == false) goto L179;
        r13 = 10;
        goto L109
    L179:
        r13 = -1;
        goto L109
    L70:
        if (r11.equals("keeplastframe") == false) goto L180;
        r13 = 9;
        goto L109
    L180:
        r13 = -1;
        goto L109
    L74:
        if (r11.equals("dynamic-resource") == false) goto L181;
        r13 = 8;
        goto L109
    L181:
        r13 = -1;
        goto L109
    L78:
        if (r11.equals("anti-aliasing") == false) goto L182;
        r13 = 7;
        goto L109
    L182:
        r13 = -1;
        goto L109
    L82:
        if (r11.equals("multi-thread-accelerate") == false) goto L183;
        r13 = 6;
        goto L109
    L183:
        r13 = -1;
        goto L109
    L86:
        if (r11.equals(NotificationCompat.CATEGORY_PROGRESS) == false) goto L184;
        r13 = 5;
        goto L109
    L184:
        r13 = -1;
        goto L109
    L90:
        if (r11.equals("object-position") == false) goto L185;
        r13 = 4;
        goto L109
    L185:
        r13 = -1;
        goto L109
    L94:
        if (r11.equals("fps-event-interval") == false) goto L186;
        r13 = 3;
        goto L109
    L186:
        r13 = -1;
        goto L109
    L98:
        if (r11.equals("ignore-lynx-lifecycle") == false) goto L187;
        r13 = 2;
        goto L109
    L187:
        r13 = -1;
        goto L109
    L102:
        if (r11.equals("objectfit") == false) goto L188;
        r13 = 1;
        goto L109
    L188:
        r13 = -1;
        goto L109
    L106:
        if (r11.equals("android-enable-screenshot") == false) goto L189;
        r13 = 0;
        goto L109
    L189:
        r13 = -1;
        goto L109
    }
}
