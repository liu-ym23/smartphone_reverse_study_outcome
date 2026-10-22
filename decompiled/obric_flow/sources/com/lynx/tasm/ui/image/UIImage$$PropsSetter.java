package com.lynx.tasm.ui.image;

import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.ui.image.AbsUIImage$$PropsSetter;

/* JADX INFO: loaded from: classes2.dex */
public class UIImage$$PropsSetter extends AbsUIImage$$PropsSetter {
    public UIImage$$PropsSetter() {
    }

    @Override // com.lynx.tasm.behavior.ui.image.AbsUIImage$$PropsSetter, com.lynx.tasm.behavior.ui.LynxUI$$PropsSetter, com.lynx.tasm.behavior.ui.LynxBaseUI$$PropsSetter, com.lynx.tasm.behavior.utils.LynxUISetter
    public void a(LynxBaseUI r10, String r11, com.lynx.tasm.behavior.y0 r12) {
        UIImage r5 = (UIImage) r10;
        r11.getClass();
        byte r13 = -1;
        switch(r11.hashCode()) {
            case -1937917490: goto L106;
            case -1900756664: goto L102;
            case -1492006372: goto L98;
            case -1338903714: goto L94;
            case -1320385523: goto L90;
            case -1138223116: goto L86;
            case -931992873: goto L82;
            case -602643660: goto L78;
            case 259555579: goto L74;
            case 263914060: goto L70;
            case 512852970: goto L66;
            case 516005201: goto L62;
            case 828761943: goto L58;
            case 893413739: goto L54;
            case 902281110: goto L50;
            case 1090746891: goto L46;
            case 1245269388: goto L42;
            case 1338737543: goto L38;
            case 1439562083: goto L34;
            case 1672916293: goto L30;
            case 1739487650: goto L26;
            case 1856274660: goto L22;
            case 1860054545: goto L18;
            case 1941332754: goto L14;
            case 1998893929: goto L10;
            case 2141225912: goto L6;
            default: goto L109;
        };
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
        r5.setExtraLoadInfo(r12.e(r11, false));
        return;
    L114:
        r5.setEnableCustomGifDecoder(r12.e(r11, false));
        return;
    L116:
        r5.setVisibility(r12.c(r11, 1));
        return;
    L118:
        r5.setTintColor(r12.f10815a.getString(r11));
        return;
    L120:
        r5.setCustomParams(r12.f10815a.getMap(r11));
        return;
    L122:
        r5.setDeferInvalidation(r12.e(r11, false));
        return;
    L124:
        r5.fixFrescoWebPBug(r12.e(r11, false));
        return;
    L126:
        r5.setAutoPlay(r12.e(r11, true));
        return;
    L128:
        r5.setImagePlaceHolderHashConfig(r12.f10815a.getMap(r11));
        return;
    L130:
        r5.setFrescoAttach(r12.f10815a.getString(r11));
        return;
    L132:
        r5.setFrescoVisible(r12.f10815a.getString(r11));
        return;
    L134:
        r5.setSuspendable(r12.f10815a.getDynamic(r11));
        return;
    L136:
        r5.setImageTransitionStyle(r12.f10815a.getString(r11));
        return;
    L138:
        r5.setImageRequestPriority(r12.f10815a.getString(r11));
        return;
    L140:
        r5.setCapInsetsBackUp(r12.f10815a.getString(r11));
        return;
    L142:
        r5.setSubSample(r12.f10815a.getString(r11));
        return;
    L144:
        r5.setImageCacheChoice(r12.f10815a.getString(r11));
        return;
    L146:
        r5.setImageSRScale(r12.b(0.0f, r11));
        return;
    L148:
        r5.setFrescoNinePatch(r12.e(r11, false));
        return;
    L150:
        r5.setSimpleCacheKey(r12.e(r11, true));
        return;
    L152:
        r5.setImageConfig(r12.f10815a.getString(r11));
        return;
    L154:
        r5.setAsyncRedirect(r12.e(r11, false));
        return;
    L156:
        r5.setSkipRedirection(r12.e(r11, false));
        return;
    L158:
        r5.setEnableResourceHint(r12.e(r11, false));
        return;
    L160:
        r5.setImageSR(r12.e(r11, false));
        return;
    L162:
        r5.setCapInsetsScale(r12.f10815a.getString(r11));
        return;
    L6:
        if (r11.equals("extra-load-info") == false) goto L109;
        r13 = 25;
        goto L109
    L10:
        if (r11.equals("enable-custom-gif-decoder") == false) goto L109;
        r13 = 24;
        goto L109
    L14:
        if (r11.equals("visibility") == false) goto L109;
        r13 = 23;
        goto L109
    L18:
        if (r11.equals("tint-color") == false) goto L109;
        r13 = 22;
        goto L109
    L22:
        if (r11.equals("additional-custom-info") == false) goto L109;
        r13 = 21;
        goto L109
    L26:
        if (r11.equals("defer-src-invalidation") == false) goto L109;
        r13 = 20;
        goto L109
    L30:
        if (r11.equals("fix-fresco-bug") == false) goto L109;
        r13 = 19;
        goto L109
    L34:
        if (r11.equals("autoplay") == false) goto L109;
        r13 = 18;
        goto L109
    L38:
        if (r11.equals("placeholder-hash-config") == false) goto L109;
        r13 = 17;
        goto L109
    L42:
        if (r11.equals("fresco-attach") == false) goto L109;
        r13 = 16;
        goto L109
    L46:
        if (r11.equals("fresco-visible") == false) goto L109;
        r13 = 15;
        goto L109
    L50:
        if (r11.equals("suspendable") == false) goto L109;
        r13 = 14;
        goto L109
    L54:
        if (r11.equals("image-transition-style") == false) goto L109;
        r13 = 13;
        goto L109
    L58:
        if (r11.equals("fetch-priority") == false) goto L109;
        r13 = 12;
        goto L109
    L62:
        if (r11.equals("cap-insets") == false) goto L109;
        r13 = 11;
        goto L109
    L66:
        if (r11.equals("subsample") == false) goto L109;
        r13 = 10;
        goto L109
    L70:
        if (r11.equals("cache-choice") == false) goto L109;
        r13 = 9;
        goto L109
    L74:
        if (r11.equals("super-resolution-scale") == false) goto L109;
        r13 = 8;
        goto L109
    L78:
        if (r11.equals("fresco-nine-patch") == false) goto L109;
        r13 = 7;
        goto L109
    L82:
        if (r11.equals("android-simple-cache-key") == false) goto L109;
        r13 = 6;
        goto L109
    L86:
        if (r11.equals("image-config") == false) goto L109;
        r13 = 5;
        goto L109
    L90:
        if (r11.equals("async-redirect") == false) goto L109;
        r13 = 4;
        goto L109
    L94:
        if (r11.equals("skip-redirection") == false) goto L109;
        r13 = 3;
        goto L109
    L98:
        if (r11.equals("enable-resource-hint") == false) goto L109;
        r13 = 2;
        goto L109
    L102:
        if (r11.equals("enable-super-resolution") == false) goto L109;
        r13 = 1;
        goto L109
    L106:
        if (r11.equals("cap-insets-scale") == false) goto L109;
        r13 = 0;
        goto L109
    }
}
