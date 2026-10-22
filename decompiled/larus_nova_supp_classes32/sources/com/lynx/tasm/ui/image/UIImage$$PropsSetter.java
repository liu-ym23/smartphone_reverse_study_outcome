package com.lynx.tasm.ui.image;

import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.ui.image.AbsUIImage$$PropsSetter;
import com.lynx.tasm.behavior.x0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class UIImage$$PropsSetter extends AbsUIImage$$PropsSetter {
    public UIImage$$PropsSetter() {
    }

    @Override // com.lynx.tasm.behavior.ui.image.AbsUIImage$$PropsSetter, com.lynx.tasm.behavior.ui.LynxUI$$PropsSetter, com.lynx.tasm.behavior.ui.LynxBaseUI$$PropsSetter, com.lynx.tasm.behavior.utils.LynxUISetter
    public void setProperty(LynxBaseUI r6, String r7, x0 r8) {
        UIImage r0 = (UIImage) r6;
        r7.getClass();
        byte r4 = -1;
        switch(r7.hashCode()) {
            case -1937917490: goto L126;
            case -1900756664: goto L122;
            case -1492006372: goto L118;
            case -1338903714: goto L114;
            case -1320385523: goto L110;
            case -1138223116: goto L106;
            case -1059824547: goto L102;
            case -931992873: goto L98;
            case -602643660: goto L94;
            case 259555579: goto L90;
            case 263914060: goto L86;
            case 305374695: goto L82;
            case 512852970: goto L78;
            case 516005201: goto L74;
            case 660415178: goto L70;
            case 828761943: goto L66;
            case 893413739: goto L62;
            case 902281110: goto L58;
            case 1090746891: goto L54;
            case 1145216977: goto L50;
            case 1245269388: goto L46;
            case 1282944765: goto L42;
            case 1338737543: goto L38;
            case 1439562083: goto L34;
            case 1672916293: goto L30;
            case 1739487650: goto L26;
            case 1856274660: goto L22;
            case 1860054545: goto L18;
            case 1941332754: goto L14;
            case 1998893929: goto L10;
            case 2141225912: goto L6;
            default: goto L129;
        };
    L129:
        switch(r4) {
            case 0: goto L192;
            case 1: goto L190;
            case 2: goto L188;
            case 3: goto L186;
            case 4: goto L184;
            case 5: goto L182;
            case 6: goto L180;
            case 7: goto L178;
            case 8: goto L176;
            case 9: goto L174;
            case 10: goto L172;
            case 11: goto L170;
            case 12: goto L168;
            case 13: goto L166;
            case 14: goto L164;
            case 15: goto L162;
            case 16: goto L160;
            case 17: goto L158;
            case 18: goto L156;
            case 19: goto L154;
            case 20: goto L152;
            case 21: goto L150;
            case 22: goto L148;
            case 23: goto L146;
            case 24: goto L144;
            case 25: goto L142;
            case 26: goto L140;
            case 27: goto L138;
            case 28: goto L136;
            case 29: goto L134;
            case 30: goto L132;
            default: goto L130;
        };
    L130:
        super.setProperty(r6, r7, r8);
        return;
    L132:
        r0.setExtraLoadInfo(r8.b(r7, false));
        return;
    L134:
        r0.setEnableCustomGifDecoder(r8.b(r7, false));
        return;
    L136:
        r0.setVisibility(r8.f(r7, 1));
        return;
    L138:
        r0.setTintColor(r8.h(r7));
        return;
    L140:
        r0.setCustomParams(r8.g(r7));
        return;
    L142:
        r0.setDeferInvalidation(r8.b(r7, false));
        return;
    L144:
        r0.fixFrescoWebPBug(r8.b(r7, false));
        return;
    L146:
        r0.setAutoPlay(r8.b(r7, true));
        return;
    L148:
        r0.setImagePlaceHolderHashConfig(r8.g(r7));
        return;
    L150:
        r0.setCacheKeyPathOnly(r8.b(r7, false));
        return;
    L152:
        r0.setFrescoAttach(r8.h(r7));
        return;
    L154:
        r0.setEnableSmoothAnimation(r8.b(r7, false));
        return;
    L156:
        r0.setFrescoVisible(r8.h(r7));
        return;
    L158:
        r0.setSuspendable(r8.d(r7));
        return;
    L160:
        r0.setImageTransitionStyle(r8.h(r7));
        return;
    L162:
        r0.setImageRequestPriority(r8.h(r7));
        return;
    L164:
        r0.setProgressiveRendering(r8.b(r7, false));
        return;
    L166:
        r0.setCapInsetsBackUp(r8.h(r7));
        return;
    L168:
        r0.setSubSample(r8.h(r7));
        return;
    L170:
        r0.setRegionToDecode(r8.g(r7));
        return;
    L172:
        r0.setImageCacheChoice(r8.h(r7));
        return;
    L174:
        r0.setImageSRScale(r8.e(r7, 0.0f));
        return;
    L176:
        r0.setFrescoNinePatch(r8.b(r7, false));
        return;
    L178:
        r0.setSimpleCacheKey(r8.b(r7, true));
        return;
    L180:
        r0.setEnableReportInfo(r8.b(r7, false));
        return;
    L182:
        r0.setImageConfig(r8.h(r7));
        return;
    L184:
        r0.setAsyncRedirect(r8.b(r7, false));
        return;
    L186:
        r0.setSkipRedirection(r8.b(r7, false));
        return;
    L188:
        r0.setEnableResourceHint(r8.b(r7, false));
        return;
    L190:
        r0.setImageSR(r8.b(r7, false));
        return;
    L192:
        r0.setCapInsetsScale(r8.h(r7));
        return;
    L6:
        if (r7.equals("extra-load-info") == false) goto L129;
        r4 = 30;
        goto L129
    L10:
        if (r7.equals("enable-custom-gif-decoder") == false) goto L129;
        r4 = 29;
        goto L129
    L14:
        if (r7.equals("visibility") == false) goto L129;
        r4 = 28;
        goto L129
    L18:
        if (r7.equals("tint-color") == false) goto L129;
        r4 = 27;
        goto L129
    L22:
        if (r7.equals("additional-custom-info") == false) goto L129;
        r4 = 26;
        goto L129
    L26:
        if (r7.equals("defer-src-invalidation") == false) goto L129;
        r4 = 25;
        goto L129
    L30:
        if (r7.equals("fix-fresco-bug") == false) goto L129;
        r4 = 24;
        goto L129
    L34:
        if (r7.equals("autoplay") == false) goto L129;
        r4 = 23;
        goto L129
    L38:
        if (r7.equals("placeholder-hash-config") == false) goto L129;
        r4 = 22;
        goto L129
    L42:
        if (r7.equals("android-cache-key-path-only") == false) goto L129;
        r4 = 21;
        goto L129
    L46:
        if (r7.equals("fresco-attach") == false) goto L129;
        r4 = 20;
        goto L129
    L50:
        if (r7.equals("android-enable-smooth-animation") == false) goto L129;
        r4 = 19;
        goto L129
    L54:
        if (r7.equals("fresco-visible") == false) goto L129;
        r4 = 18;
        goto L129
    L58:
        if (r7.equals("suspendable") == false) goto L129;
        r4 = 17;
        goto L129
    L62:
        if (r7.equals("image-transition-style") == false) goto L129;
        r4 = 16;
        goto L129
    L66:
        if (r7.equals("fetch-priority") == false) goto L129;
        r4 = 15;
        goto L129
    L70:
        if (r7.equals("progressive-rendering") == false) goto L129;
        r4 = 14;
        goto L129
    L74:
        if (r7.equals("cap-insets") == false) goto L129;
        r4 = 13;
        goto L129
    L78:
        if (r7.equals("subsample") == false) goto L129;
        r4 = 12;
        goto L129
    L82:
        if (r7.equals("region-to-decode") == false) goto L129;
        r4 = 11;
        goto L129
    L86:
        if (r7.equals("cache-choice") == false) goto L129;
        r4 = 10;
        goto L129
    L90:
        if (r7.equals("super-resolution-scale") == false) goto L129;
        r4 = 9;
        goto L129
    L94:
        if (r7.equals("fresco-nine-patch") == false) goto L129;
        r4 = 8;
        goto L129
    L98:
        if (r7.equals("android-simple-cache-key") == false) goto L129;
        r4 = 7;
        goto L129
    L102:
        if (r7.equals("enable-report-info") == false) goto L129;
        r4 = 6;
        goto L129
    L106:
        if (r7.equals("image-config") == false) goto L129;
        r4 = 5;
        goto L129
    L110:
        if (r7.equals("async-redirect") == false) goto L129;
        r4 = 4;
        goto L129
    L114:
        if (r7.equals("skip-redirection") == false) goto L129;
        r4 = 3;
        goto L129
    L118:
        if (r7.equals("enable-resource-hint") == false) goto L129;
        r4 = 2;
        goto L129
    L122:
        if (r7.equals("enable-super-resolution") == false) goto L129;
        r4 = 1;
        goto L129
    L126:
        if (r7.equals("cap-insets-scale") == false) goto L129;
        r4 = 0;
        goto L129
    }
}
