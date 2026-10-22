package com.lynx.tasm.ui.image;

import com.lynx.tasm.LynxError;
import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.ui.LynxFlattenUI$$PropsSetter;
import com.lynx.tasm.behavior.x0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class FlattenUIImage$$PropsSetter extends LynxFlattenUI$$PropsSetter {
    public FlattenUIImage$$PropsSetter() {
    }

    @Override // com.lynx.tasm.behavior.ui.LynxFlattenUI$$PropsSetter, com.lynx.tasm.behavior.ui.LynxBaseUI$$PropsSetter, com.lynx.tasm.behavior.utils.LynxUISetter
    public final void setProperty(LynxBaseUI r6, String r7, x0 r8) {
        FlattenUIImage r0 = (FlattenUIImage) r6;
        r7.getClass();
        byte r4 = -1;
        switch(r7.hashCode()) {
            case -1937917490: goto L158;
            case -1900756664: goto L154;
            case -1492006372: goto L150;
            case -1338903714: goto L146;
            case -1320385523: goto L142;
            case -1138223116: goto L138;
            case -1059824547: goto L134;
            case -934531685: goto L130;
            case -931992873: goto L126;
            case -629825370: goto L122;
            case -602643660: goto L118;
            case -320982203: goto L114;
            case -256430480: goto L110;
            case 114148: goto L106;
            case 3357091: goto L102;
            case 108305470: goto L98;
            case 207594941: goto L94;
            case 259555579: goto L90;
            case 263914060: goto L86;
            case 305374695: goto L82;
            case 512852970: goto L78;
            case 516005201: goto L74;
            case 598246771: goto L70;
            case 660415178: goto L66;
            case 681292984: goto L62;
            case 828761943: goto L58;
            case 893413739: goto L54;
            case 902281110: goto L50;
            case 1145216977: goto L46;
            case 1282944765: goto L42;
            case 1338737543: goto L38;
            case 1439562083: goto L34;
            case 1515751784: goto L30;
            case 1615092063: goto L26;
            case 1739487650: goto L22;
            case 1856274660: goto L18;
            case 1860054545: goto L14;
            case 1998893929: goto L10;
            case 2141225912: goto L6;
            default: goto L161;
        };
    L161:
        switch(r4) {
            case 0: goto L240;
            case 1: goto L238;
            case 2: goto L236;
            case 3: goto L234;
            case 4: goto L232;
            case 5: goto L230;
            case 6: goto L228;
            case 7: goto L226;
            case 8: goto L224;
            case 9: goto L222;
            case 10: goto L220;
            case 11: goto L218;
            case 12: goto L216;
            case 13: goto L214;
            case 14: goto L212;
            case 15: goto L210;
            case 16: goto L208;
            case 17: goto L206;
            case 18: goto L204;
            case 19: goto L202;
            case 20: goto L200;
            case 21: goto L198;
            case 22: goto L196;
            case 23: goto L194;
            case 24: goto L192;
            case 25: goto L190;
            case 26: goto L188;
            case 27: goto L186;
            case 28: goto L184;
            case 29: goto L182;
            case 30: goto L180;
            case 31: goto L178;
            case 32: goto L176;
            case 33: goto L174;
            case 34: goto L172;
            case 35: goto L170;
            case 36: goto L168;
            case 37: goto L166;
            case 38: goto L164;
            default: goto L162;
        };
    L162:
        super.setProperty(r6, r7, r8);
        return;
    L164:
        r0.setExtraLoadInfo(r8.b(r7, false));
        return;
    L166:
        r0.setEnableCustomGifDecoder(r8.b(r7, false));
        return;
    L168:
        r0.setTintColor(r8.h(r7));
        return;
    L170:
        r0.setCustomParams(r8.g(r7));
        return;
    L172:
        r0.setDeferInvalidation(r8.b(r7, false));
        return;
    L174:
        r0.setAutoSize(r8.b(r7, false));
        return;
    L176:
        r0.setCapInsets(r8.h(r7));
        return;
    L178:
        r0.setAutoPlay(r8.b(r7, true));
        return;
    L180:
        r0.setImagePlaceHolderHashConfig(r8.g(r7));
        return;
    L182:
        r0.setCacheKeyPathOnly(r8.b(r7, false));
        return;
    L184:
        r0.setEnableSmoothAnimation(r8.b(r7, false));
        return;
    L186:
        r0.setSuspendable(r8.d(r7));
        return;
    L188:
        r0.setImageTransitionStyle(r8.h(r7));
        return;
    L190:
        r0.setImageRequestPriority(r8.h(r7));
        return;
    L192:
        r0.setBlurRadius(r8.h(r7));
        return;
    L194:
        r0.setProgressiveRendering(r8.b(r7, false));
        return;
    L196:
        r0.setPlaceholder(r8.h(r7));
        return;
    L198:
        r0.setCapInsetsBackUp(r8.h(r7));
        return;
    L200:
        r0.setSubSample(r8.b(r7, false));
        return;
    L202:
        r0.setRegionToDecode(r8.g(r7));
        return;
    L204:
        r0.setImageCacheChoice(r8.h(r7));
        return;
    L206:
        r0.setImageSRScale(r8.e(r7, 0.0f));
        return;
    L208:
        r0.setPreFetchHeight(r8.h(r7));
        return;
    L210:
        r0.setAsyncRequest(r8.b(r7, false));
        return;
    L212:
        r0.setObjectFit(r8.h(r7));
        return;
    L214:
        r0.setSource(r8.h(r7));
        return;
    L216:
        r0.setPreFetchWidth(r8.h(r7));
        return;
    L218:
        r0.setDisableDefaultResize(r8.b(r7, false));
        return;
    L220:
        r0.setFrescoNinePatch(r8.b(r7, false));
        return;
    L222:
        r0.setLoopCount(r8.f(r7, 0));
        return;
    L224:
        r0.setSimpleCacheKey(r8.b(r7, false));
        return;
    L226:
        r0.setRepeat(r8.b(r7, false));
        return;
    L228:
        r0.setEnableReportInfo(r8.b(r7, false));
        return;
    L230:
        r0.setImageConfig(r8.h(r7));
        return;
    L232:
        r0.setAsyncRedirect(r8.b(r7, false));
        return;
    L234:
        r0.setSkipRedirection(r8.b(r7, false));
        return;
    L236:
        r0.setEnableResourceHint(r8.b(r7, false));
        return;
    L238:
        r0.setImageSR(r8.b(r7, false));
        return;
    L240:
        r0.setCapInsetsScale(r8.h(r7));
        return;
    L6:
        if (r7.equals("extra-load-info") == false) goto L161;
        r4 = 38;
        goto L161
    L10:
        if (r7.equals("enable-custom-gif-decoder") == false) goto L161;
        r4 = 37;
        goto L161
    L14:
        if (r7.equals("tint-color") == false) goto L161;
        r4 = 36;
        goto L161
    L18:
        if (r7.equals("additional-custom-info") == false) goto L161;
        r4 = 35;
        goto L161
    L22:
        if (r7.equals("defer-src-invalidation") == false) goto L161;
        r4 = 34;
        goto L161
    L26:
        if (r7.equals("auto-size") == false) goto L161;
        r4 = 33;
        goto L161
    L30:
        if (r7.equals("capInsets") == false) goto L161;
        r4 = 32;
        goto L161
    L34:
        if (r7.equals("autoplay") == false) goto L161;
        r4 = 31;
        goto L161
    L38:
        if (r7.equals("placeholder-hash-config") == false) goto L161;
        r4 = 30;
        goto L161
    L42:
        if (r7.equals("android-cache-key-path-only") == false) goto L161;
        r4 = 29;
        goto L161
    L46:
        if (r7.equals("android-enable-smooth-animation") == false) goto L161;
        r4 = 28;
        goto L161
    L50:
        if (r7.equals("suspendable") == false) goto L161;
        r4 = 27;
        goto L161
    L54:
        if (r7.equals("image-transition-style") == false) goto L161;
        r4 = 26;
        goto L161
    L58:
        if (r7.equals("fetch-priority") == false) goto L161;
        r4 = 25;
        goto L161
    L62:
        if (r7.equals("blur-radius") == false) goto L161;
        r4 = 24;
        goto L161
    L66:
        if (r7.equals("progressive-rendering") == false) goto L161;
        r4 = 23;
        goto L161
    L70:
        if (r7.equals("placeholder") == false) goto L161;
        r4 = 22;
        goto L161
    L74:
        if (r7.equals("cap-insets") == false) goto L161;
        r4 = 21;
        goto L161
    L78:
        if (r7.equals("subsample") == false) goto L161;
        r4 = 20;
        goto L161
    L82:
        if (r7.equals("region-to-decode") == false) goto L161;
        r4 = 19;
        goto L161
    L86:
        if (r7.equals("cache-choice") == false) goto L161;
        r4 = 18;
        goto L161
    L90:
        if (r7.equals("super-resolution-scale") == false) goto L161;
        r4 = 17;
        goto L161
    L94:
        if (r7.equals("prefetch-height") == false) goto L161;
        r4 = 16;
        goto L161
    L98:
        if (r7.equals("async-request") == false) goto L161;
        r4 = 15;
        goto L161
    L102:
        if (r7.equals("mode") == false) goto L161;
        r4 = 14;
        goto L161
    L106:
        if (r7.equals(LynxError.LYNX_ERROR_KEY_RESOURCE_URL) == false) goto L161;
        r4 = 13;
        goto L161
    L110:
        if (r7.equals("prefetch-width") == false) goto L161;
        r4 = 12;
        goto L161
    L114:
        if (r7.equals("disable-default-resize") == false) goto L161;
        r4 = 11;
        goto L161
    L118:
        if (r7.equals("fresco-nine-patch") == false) goto L161;
        r4 = 10;
        goto L161
    L122:
        if (r7.equals("loop-count") == false) goto L161;
        r4 = 9;
        goto L161
    L126:
        if (r7.equals("android-simple-cache-key") == false) goto L161;
        r4 = 8;
        goto L161
    L130:
        if (r7.equals("repeat") == false) goto L161;
        r4 = 7;
        goto L161
    L134:
        if (r7.equals("enable-report-info") == false) goto L161;
        r4 = 6;
        goto L161
    L138:
        if (r7.equals("image-config") == false) goto L161;
        r4 = 5;
        goto L161
    L142:
        if (r7.equals("async-redirect") == false) goto L161;
        r4 = 4;
        goto L161
    L146:
        if (r7.equals("skip-redirection") == false) goto L161;
        r4 = 3;
        goto L161
    L150:
        if (r7.equals("enable-resource-hint") == false) goto L161;
        r4 = 2;
        goto L161
    L154:
        if (r7.equals("enable-super-resolution") == false) goto L161;
        r4 = 1;
        goto L161
    L158:
        if (r7.equals("cap-insets-scale") == false) goto L161;
        r4 = 0;
        goto L161
    }
}
