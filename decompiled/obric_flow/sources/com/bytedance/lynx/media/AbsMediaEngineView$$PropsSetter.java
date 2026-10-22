package com.bytedance.lynx.media;

import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.ui.view.UISimpleView$$PropsSetter;
import com.lynx.tasm.behavior.y0;

/* JADX INFO: loaded from: classes2.dex */
public class AbsMediaEngineView$$PropsSetter extends UISimpleView$$PropsSetter {
    public AbsMediaEngineView$$PropsSetter() {
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI$$PropsSetter, com.lynx.tasm.behavior.ui.LynxBaseUI$$PropsSetter, com.lynx.tasm.behavior.utils.LynxUISetter
    public final void a(LynxBaseUI r10, String r11, y0 r12) {
        AbsMediaEngineView r5 = (AbsMediaEngineView) r10;
        r11.getClass();
        byte r13 = -1;
        switch(r11.hashCode()) {
            case -1869688179: goto L102;
            case -1768477940: goto L98;
            case -1600030548: goto L94;
            case -1489589134: goto L90;
            case -1326197564: goto L86;
            case -810883302: goto L82;
            case -642624357: goto L78;
            case -455669834: goto L74;
            case -51537065: goto L70;
            case -17124500: goto L66;
            case 114586: goto L62;
            case 116753: goto L58;
            case 3327652: goto L54;
            case 3493088: goto L50;
            case 104264043: goto L46;
            case 109641799: goto L42;
            case 110541305: goto L38;
            case 269397981: goto L34;
            case 510966438: goto L30;
            case 560180969: goto L26;
            case 795307910: goto L22;
            case 1065675907: goto L18;
            case 1261144289: goto L14;
            case 1877609302: goto L10;
            case 2096002969: goto L6;
            default: goto L105;
        };
    L105:
        switch(r13) {
            case 0: goto L156;
            case 1: goto L154;
            case 2: goto L152;
            case 3: goto L150;
            case 4: goto L148;
            case 5: goto L146;
            case 6: goto L144;
            case 7: goto L142;
            case 8: goto L140;
            case 9: goto L138;
            case 10: goto L136;
            case 11: goto L134;
            case 12: goto L132;
            case 13: goto L130;
            case 14: goto L128;
            case 15: goto L126;
            case 16: goto L124;
            case 17: goto L122;
            case 18: goto L120;
            case 19: goto L118;
            case 20: goto L116;
            case 21: goto L114;
            case 22: goto L112;
            case 23: goto L110;
            case 24: goto L108;
            default: goto L106;
        };
    L106:
        super.a(r10, r11, r12);
        return;
    L108:
        r5.setPauseOnHide(r12.e(r11, false));
        return;
    L110:
        r5.setPlayUrl(r12.f10815a.getString(r11));
        return;
    L112:
        r5.setPlayerOption(r12.f10815a.getMap(r11));
        return;
    L114:
        r5.setObjectFit(r12.f10815a.getString(r11));
        return;
    L116:
        r5.setHeaders(r12.f10815a.getMap(r11));
        return;
    L118:
        r5.setAutoPrepare(r12.e(r11, false));
        return;
    L120:
        r5.setPlayerType(r12.f10815a.getString(r11));
        return;
    L122:
        r5.setDeprecatedInitTime(r12.c(r11, 0));
        return;
    L124:
        r5.setToken(r12.f10815a.getString(r11));
        return;
    L126:
        r5.setSpeed(r12.b(0.0f, r11));
        return;
    L128:
        r5.setMuted(r12.e(r11, false));
        return;
    L130:
        r5.setRate(r12.c(r11, 0));
        return;
    L132:
        r5.setLoop(r12.e(r11, false));
        return;
    L134:
        r5.setVid(r12.f10815a.getString(r11));
        return;
    L136:
        r5.setVideoTag(r12.f10815a.getString(r11));
        return;
    L138:
        r5.setCacheSize(r12.c(r11, 0));
        return;
    L140:
        r5.setVideoModel(r12.f10815a.getString(r11));
        return;
    L142:
        r5.setInitTime(r12.c(r11, 0));
        return;
    L144:
        r5.setPreloadKey(r12.f10815a.getString(r11));
        return;
    L146:
        r5.setVolume(r12.b(0.0f, r11));
        return;
    L148:
        r5.setDomain(r12.f10815a.getString(r11));
        return;
    L150:
        r5.setDeprecatedObjectFit(r12.f10815a.getString(r11));
        return;
    L152:
        r5.setResolution(r12.f10815a.getString(r11));
        return;
    L154:
        r5.setForcePreparePlayAfterSurfaceAvailable(r12.f10815a.getString(r11));
        return;
    L156:
        r5.setVideoSubTag(r12.f10815a.getString(r11));
        return;
    L6:
        if (r11.equals("pause-on-hide") == false) goto L105;
        r13 = 24;
        goto L105
    L10:
        if (r11.equals("play-url") == false) goto L105;
        r13 = 23;
        goto L105
    L14:
        if (r11.equals("player-option") == false) goto L105;
        r13 = 22;
        goto L105
    L18:
        if (r11.equals("object-fit") == false) goto L105;
        r13 = 21;
        goto L105
    L22:
        if (r11.equals("headers") == false) goto L105;
        r13 = 20;
        goto L105
    L26:
        if (r11.equals("auto-prepare") == false) goto L105;
        r13 = 19;
        goto L105
    L30:
        if (r11.equals("player-type") == false) goto L105;
        r13 = 18;
        goto L105
    L34:
        if (r11.equals("inittime") == false) goto L105;
        r13 = 17;
        goto L105
    L38:
        if (r11.equals("token") == false) goto L105;
        r13 = 16;
        goto L105
    L42:
        if (r11.equals("speed") == false) goto L105;
        r13 = 15;
        goto L105
    L46:
        if (r11.equals("muted") == false) goto L105;
        r13 = 14;
        goto L105
    L50:
        if (r11.equals("rate") == false) goto L105;
        r13 = 13;
        goto L105
    L54:
        if (r11.equals("loop") == false) goto L105;
        r13 = 12;
        goto L105
    L58:
        if (r11.equals("vid") == false) goto L105;
        r13 = 11;
        goto L105
    L62:
        if (r11.equals("tag") == false) goto L105;
        r13 = 10;
        goto L105
    L66:
        if (r11.equals("cache-size") == false) goto L105;
        r13 = 9;
        goto L105
    L70:
        if (r11.equals("video-model") == false) goto L105;
        r13 = 8;
        goto L105
    L74:
        if (r11.equals("initial-time") == false) goto L105;
        r13 = 7;
        goto L105
    L78:
        if (r11.equals("preload-key") == false) goto L105;
        r13 = 6;
        goto L105
    L82:
        if (r11.equals("volume") == false) goto L105;
        r13 = 5;
        goto L105
    L86:
        if (r11.equals("domain") == false) goto L105;
        r13 = 4;
        goto L105
    L90:
        if (r11.equals("objectfit") == false) goto L105;
        r13 = 3;
        goto L105
    L94:
        if (r11.equals("resolution") == false) goto L105;
        r13 = 2;
        goto L105
    L98:
        if (r11.equals("experimental-force-prepare-play-after-surface-available") == false) goto L105;
        r13 = 1;
        goto L105
    L102:
        if (r11.equals("sub-tag") == false) goto L105;
        r13 = 0;
        goto L105
    }
}
