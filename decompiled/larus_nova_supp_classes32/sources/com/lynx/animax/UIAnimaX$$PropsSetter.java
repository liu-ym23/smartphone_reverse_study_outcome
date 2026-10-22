package com.lynx.animax;

import com.lynx.tasm.LynxError;
import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.ui.LynxUI$$PropsSetter;
import com.lynx.tasm.behavior.x0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class UIAnimaX$$PropsSetter extends LynxUI$$PropsSetter {
    public UIAnimaX$$PropsSetter() {
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI$$PropsSetter, com.lynx.tasm.behavior.ui.LynxBaseUI$$PropsSetter, com.lynx.tasm.behavior.utils.LynxUISetter
    public final void setProperty(LynxBaseUI r7, String r8, x0 r9) {
        UIAnimaX r0 = (UIAnimaX) r7;
        r8.getClass();
        switch(r8.hashCode()) {
            case -1673124846: goto L114;
            case -1489589134: goto L110;
            case -1426073969: goto L106;
            case -1340550148: goto L102;
            case -1162629129: goto L98;
            case -1001078227: goto L94;
            case -846027028: goto L90;
            case -839971427: goto L86;
            case -819151396: goto L82;
            case -795328846: goto L78;
            case -629825370: goto L74;
            case -303648977: goto L70;
            case -261882880: goto L66;
            case 114148: goto L62;
            case 114586: goto L58;
            case 3271912: goto L54;
            case 3327652: goto L50;
            case 104264043: goto L46;
            case 109641799: goto L42;
            case 508360187: goto L38;
            case 1068228937: goto L34;
            case 1327968322: goto L30;
            case 1352104895: goto L26;
            case 1439562083: goto L22;
            case 1502439180: goto L18;
            case 1568893902: goto L14;
            case 1821306136: goto L10;
            case 1978397892: goto L6;
            default: goto L4;
        };
    L4:
        byte r1 = -1;
    L118:
        switch(r1) {
            case 0: goto L175;
            case 1: goto L173;
            case 2: goto L171;
            case 3: goto L169;
            case 4: goto L167;
            case 5: goto L165;
            case 6: goto L163;
            case 7: goto L161;
            case 8: goto L159;
            case 9: goto L157;
            case 10: goto L155;
            case 11: goto L153;
            case 12: goto L151;
            case 13: goto L149;
            case 14: goto L147;
            case 15: goto L145;
            case 16: goto L143;
            case 17: goto L141;
            case 18: goto L139;
            case 19: goto L137;
            case 20: goto L135;
            case 21: goto L133;
            case 22: goto L131;
            case 23: goto L129;
            case 24: goto L127;
            case 25: goto L125;
            case 26: goto L123;
            case 27: goto L121;
            default: goto L119;
        };
    L119:
        super.setProperty(r7, r8, r9);
        return;
    L121:
        r0.setReverseMode(r9.b(r8, false));
        return;
    L123:
        r0.setSrcPolyfill(r9.g(r8));
        return;
    L125:
        r0.setDisplayMode(r9.h(r8));
        return;
    L127:
        r0.setEnableAudio(r9.b(r8, false));
        return;
    L129:
        r0.setAutoPlay(r9.b(r8, true));
        return;
    L131:
        r0.setIgnoreAttachStatus(r9.b(r8, false));
        return;
    L133:
        r0.setStartFrame(r9.f(r8, 0));
        return;
    L135:
        r0.setMaxFrameRate(r9.c(r8, 0.0d));
        return;
    L137:
        r0.setEndFrame(r9.f(r8, -1));
        return;
    L139:
        r0.setSpeed(r9.e(r8, 0.0f));
        return;
    L141:
        r0.setMuted(r9.b(r8, false));
        return;
    L143:
        r0.setLoop(r9.b(r8, false));
        return;
    L145:
        r0.setJson(r9.h(r8));
        return;
    L147:
        r0.setTag(r9.h(r8));
        return;
    L149:
        r0.setSrc(r9.h(r8));
        return;
    L151:
        r0.setSrcFormat(r9.h(r8));
        return;
    L153:
        r0.setVideoFrameTimeout(r9.f(r8, 0));
        return;
    L155:
        r0.setLoopCount(r9.f(r8, 1));
        return;
    L157:
        r0.setKeepLastFrame(r9.b(r8, true));
        return;
    L159:
        r0.setDynamicResource(r9.b(r8, false));
        return;
    L161:
        r0.setAntiAliasing(r9.h(r8));
        return;
    L163:
        r0.setMultiThreadAccelerate(r9.b(r8, true));
        return;
    L165:
        r0.setProgress(r9.e(r8, 0.0f));
        return;
    L167:
        r0.setObjectPosition(r9.h(r8));
        return;
    L169:
        r0.setFpsEventInterval(r9.f(r8, 0));
        return;
    L171:
        r0.setIgnoreLynxLifecycle(r9.b(r8, false));
        return;
    L173:
        r0.setObjectFit(r9.h(r8));
        return;
    L175:
        r0.setEnableScreenshot(r9.b(r8, false));
        return;
    L6:
        if (r8.equals("auto-reverse") == false) goto L4;
        r1 = 27;
        goto L118
    L10:
        if (r8.equals("src-polyfill") == false) goto L4;
        r1 = 26;
        goto L118
    L14:
        if (r8.equals("display-mode") == false) goto L4;
        r1 = 25;
        goto L118
    L18:
        if (r8.equals("enable-audio") == false) goto L4;
        r1 = 24;
        goto L118
    L22:
        if (r8.equals("autoplay") == false) goto L4;
        r1 = 23;
        goto L118
    L26:
        if (r8.equals("ignore-attach-status") == false) goto L4;
        r1 = 22;
        goto L118
    L30:
        if (r8.equals("start-frame") == false) goto L4;
        r1 = 21;
        goto L118
    L34:
        if (r8.equals("max-frame-rate") == false) goto L4;
        r1 = 20;
        goto L118
    L38:
        if (r8.equals("end-frame") == false) goto L4;
        r1 = 19;
        goto L118
    L42:
        if (r8.equals("speed") == false) goto L4;
        r1 = 18;
        goto L118
    L46:
        if (r8.equals("muted") == false) goto L4;
        r1 = 17;
        goto L118
    L50:
        if (r8.equals("loop") == false) goto L4;
        r1 = 16;
        goto L118
    L54:
        if (r8.equals("json") == false) goto L4;
        r1 = 15;
        goto L118
    L58:
        if (r8.equals("tag") == false) goto L4;
        r1 = 14;
        goto L118
    L62:
        if (r8.equals(LynxError.LYNX_ERROR_KEY_RESOURCE_URL) == false) goto L4;
        r1 = 13;
        goto L118
    L66:
        if (r8.equals("src-format") == false) goto L4;
        r1 = 12;
        goto L118
    L70:
        if (r8.equals("video-frame-timeout") == false) goto L4;
        r1 = 11;
        goto L118
    L74:
        if (r8.equals("loop-count") == false) goto L4;
        r1 = 10;
        goto L118
    L78:
        if (r8.equals("keeplastframe") == false) goto L4;
        r1 = 9;
        goto L118
    L82:
        if (r8.equals("dynamic-resource") == false) goto L4;
        r1 = 8;
        goto L118
    L86:
        if (r8.equals("anti-aliasing") == false) goto L4;
        r1 = 7;
        goto L118
    L90:
        if (r8.equals("multi-thread-accelerate") == false) goto L4;
        r1 = 6;
        goto L118
    L94:
        if (r8.equals("progress") == false) goto L4;
        r1 = 5;
        goto L118
    L98:
        if (r8.equals("object-position") == false) goto L4;
        r1 = 4;
        goto L118
    L102:
        if (r8.equals("fps-event-interval") == false) goto L4;
        r1 = 3;
        goto L118
    L106:
        if (r8.equals("ignore-lynx-lifecycle") == false) goto L4;
        r1 = 2;
        goto L118
    L110:
        if (r8.equals("objectfit") == false) goto L4;
        r1 = 1;
        goto L118
    L114:
        if (r8.equals("android-enable-screenshot") == false) goto L4;
        r1 = 0;
        goto L118
    }
}
