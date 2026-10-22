package com.lynx.tasm.ui.image;

import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.ui.LynxFlattenUI$$PropsSetter;

/* JADX INFO: loaded from: classes2.dex */
public class FlattenUIImage$$PropsSetter extends LynxFlattenUI$$PropsSetter {
    public FlattenUIImage$$PropsSetter() {
    }

    @Override // com.lynx.tasm.behavior.ui.LynxFlattenUI$$PropsSetter, com.lynx.tasm.behavior.ui.LynxBaseUI$$PropsSetter, com.lynx.tasm.behavior.utils.LynxUISetter
    public final void a(LynxBaseUI r10, String r11, com.lynx.tasm.behavior.y0 r12) {
        FlattenUIImage r5 = (FlattenUIImage) r10;
        r11.getClass();
        byte r13 = -1;
        switch(r11.hashCode()) {
            case -1937917490: goto L134;
            case -1900756664: goto L130;
            case -1492006372: goto L126;
            case -1338903714: goto L122;
            case -1320385523: goto L118;
            case -1138223116: goto L114;
            case -934531685: goto L110;
            case -931992873: goto L106;
            case -629825370: goto L102;
            case -602643660: goto L98;
            case -320982203: goto L94;
            case -256430480: goto L90;
            case 114148: goto L86;
            case 3357091: goto L82;
            case 108305470: goto L78;
            case 207594941: goto L74;
            case 259555579: goto L70;
            case 263914060: goto L66;
            case 516005201: goto L62;
            case 598246771: goto L58;
            case 681292984: goto L54;
            case 828761943: goto L50;
            case 893413739: goto L46;
            case 902281110: goto L42;
            case 1338737543: goto L38;
            case 1439562083: goto L34;
            case 1515751784: goto L30;
            case 1615092063: goto L26;
            case 1739487650: goto L22;
            case 1856274660: goto L18;
            case 1860054545: goto L14;
            case 1998893929: goto L10;
            case 2141225912: goto L6;
            default: goto L137;
        };
    L137:
        switch(r13) {
            case 0: goto L204;
            case 1: goto L202;
            case 2: goto L200;
            case 3: goto L198;
            case 4: goto L196;
            case 5: goto L194;
            case 6: goto L192;
            case 7: goto L190;
            case 8: goto L188;
            case 9: goto L186;
            case 10: goto L184;
            case 11: goto L182;
            case 12: goto L180;
            case 13: goto L178;
            case 14: goto L176;
            case 15: goto L174;
            case 16: goto L172;
            case 17: goto L170;
            case 18: goto L168;
            case 19: goto L166;
            case 20: goto L164;
            case 21: goto L162;
            case 22: goto L160;
            case 23: goto L158;
            case 24: goto L156;
            case 25: goto L154;
            case 26: goto L152;
            case 27: goto L150;
            case 28: goto L148;
            case 29: goto L146;
            case 30: goto L144;
            case 31: goto L142;
            case 32: goto L140;
            default: goto L138;
        };
    L138:
        super.a(r10, r11, r12);
        return;
    L140:
        r5.setExtraLoadInfo(r12.e(r11, false));
        return;
    L142:
        r5.setEnableCustomGifDecoder(r12.e(r11, false));
        return;
    L144:
        r5.setTintColor(r12.f10815a.getString(r11));
        return;
    L146:
        r5.setCustomParams(r12.f10815a.getMap(r11));
        return;
    L148:
        r5.setDeferInvalidation(r12.e(r11, false));
        return;
    L150:
        r5.setAutoSize(r12.e(r11, false));
        return;
    L152:
        r5.setCapInsets(r12.f10815a.getString(r11));
        return;
    L154:
        r5.setAutoPlay(r12.e(r11, true));
        return;
    L156:
        r5.setImagePlaceHolderHashConfig(r12.f10815a.getMap(r11));
        return;
    L158:
        r5.setSuspendable(r12.f10815a.getDynamic(r11));
        return;
    L160:
        r5.setImageTransitionStyle(r12.f10815a.getString(r11));
        return;
    L162:
        r5.setImageRequestPriority(r12.f10815a.getString(r11));
        return;
    L164:
        r5.setBlurRadius(r12.f10815a.getString(r11));
        return;
    L166:
        r5.setPlaceholder(r12.f10815a.getString(r11));
        return;
    L168:
        r5.setCapInsetsBackUp(r12.f10815a.getString(r11));
        return;
    L170:
        r5.setImageCacheChoice(r12.f10815a.getString(r11));
        return;
    L172:
        r5.setImageSRScale(r12.b(0.0f, r11));
        return;
    L174:
        r5.setPreFetchHeight(r12.f10815a.getString(r11));
        return;
    L176:
        r5.setAsyncRequest(r12.e(r11, false));
        return;
    L178:
        r5.setObjectFit(r12.f10815a.getString(r11));
        return;
    L180:
        r5.setSource(r12.f10815a.getString(r11));
        return;
    L182:
        r5.setPreFetchWidth(r12.f10815a.getString(r11));
        return;
    L184:
        r5.setDisableDefaultResize(r12.e(r11, false));
        return;
    L186:
        r5.setFrescoNinePatch(r12.e(r11, false));
        return;
    L188:
        r5.setLoopCount(r12.c(r11, 0));
        return;
    L190:
        r5.setSimpleCacheKey(r12.e(r11, false));
        return;
    L192:
        r5.setRepeat(r12.e(r11, false));
        return;
    L194:
        r5.setImageConfig(r12.f10815a.getString(r11));
        return;
    L196:
        r5.setAsyncRedirect(r12.e(r11, false));
        return;
    L198:
        r5.setSkipRedirection(r12.e(r11, false));
        return;
    L200:
        r5.setEnableResourceHint(r12.e(r11, false));
        return;
    L202:
        r5.setImageSR(r12.e(r11, false));
        return;
    L204:
        r5.setCapInsetsScale(r12.f10815a.getString(r11));
        return;
    L6:
        if (r11.equals("extra-load-info") == false) goto L137;
        r13 = 32;
        goto L137
    L10:
        if (r11.equals("enable-custom-gif-decoder") == false) goto L137;
        r13 = 31;
        goto L137
    L14:
        if (r11.equals("tint-color") == false) goto L137;
        r13 = 30;
        goto L137
    L18:
        if (r11.equals("additional-custom-info") == false) goto L137;
        r13 = 29;
        goto L137
    L22:
        if (r11.equals("defer-src-invalidation") == false) goto L137;
        r13 = 28;
        goto L137
    L26:
        if (r11.equals("auto-size") == false) goto L137;
        r13 = 27;
        goto L137
    L30:
        if (r11.equals("capInsets") == false) goto L137;
        r13 = 26;
        goto L137
    L34:
        if (r11.equals("autoplay") == false) goto L137;
        r13 = 25;
        goto L137
    L38:
        if (r11.equals("placeholder-hash-config") == false) goto L137;
        r13 = 24;
        goto L137
    L42:
        if (r11.equals("suspendable") == false) goto L137;
        r13 = 23;
        goto L137
    L46:
        if (r11.equals("image-transition-style") == false) goto L137;
        r13 = 22;
        goto L137
    L50:
        if (r11.equals("fetch-priority") == false) goto L137;
        r13 = 21;
        goto L137
    L54:
        if (r11.equals("blur-radius") == false) goto L137;
        r13 = 20;
        goto L137
    L58:
        if (r11.equals("placeholder") == false) goto L137;
        r13 = 19;
        goto L137
    L62:
        if (r11.equals("cap-insets") == false) goto L137;
        r13 = 18;
        goto L137
    L66:
        if (r11.equals("cache-choice") == false) goto L137;
        r13 = 17;
        goto L137
    L70:
        if (r11.equals("super-resolution-scale") == false) goto L137;
        r13 = 16;
        goto L137
    L74:
        if (r11.equals("prefetch-height") == false) goto L137;
        r13 = 15;
        goto L137
    L78:
        if (r11.equals("async-request") == false) goto L137;
        r13 = 14;
        goto L137
    L82:
        if (r11.equals("mode") == false) goto L137;
        r13 = 13;
        goto L137
    L86:
        if (r11.equals("src") == false) goto L137;
        r13 = 12;
        goto L137
    L90:
        if (r11.equals("prefetch-width") == false) goto L137;
        r13 = 11;
        goto L137
    L94:
        if (r11.equals("disable-default-resize") == false) goto L137;
        r13 = 10;
        goto L137
    L98:
        if (r11.equals("fresco-nine-patch") == false) goto L137;
        r13 = 9;
        goto L137
    L102:
        if (r11.equals("loop-count") == false) goto L137;
        r13 = 8;
        goto L137
    L106:
        if (r11.equals("android-simple-cache-key") == false) goto L137;
        r13 = 7;
        goto L137
    L110:
        if (r11.equals("repeat") == false) goto L137;
        r13 = 6;
        goto L137
    L114:
        if (r11.equals("image-config") == false) goto L137;
        r13 = 5;
        goto L137
    L118:
        if (r11.equals("async-redirect") == false) goto L137;
        r13 = 4;
        goto L137
    L122:
        if (r11.equals("skip-redirection") == false) goto L137;
        r13 = 3;
        goto L137
    L126:
        if (r11.equals("enable-resource-hint") == false) goto L137;
        r13 = 2;
        goto L137
    L130:
        if (r11.equals("enable-super-resolution") == false) goto L137;
        r13 = 1;
        goto L137
    L134:
        if (r11.equals("cap-insets-scale") == false) goto L137;
        r13 = 0;
        goto L137
    }
}
