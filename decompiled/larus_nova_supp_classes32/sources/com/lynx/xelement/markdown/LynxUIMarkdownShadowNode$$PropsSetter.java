package com.lynx.xelement.markdown;

import com.lynx.jsbridge.LynxAccessibilityModule;
import com.lynx.tasm.behavior.shadow.ShadowNode;
import com.lynx.tasm.behavior.shadow.ShadowNode$$PropsSetter;
import com.lynx.tasm.behavior.x0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class LynxUIMarkdownShadowNode$$PropsSetter extends ShadowNode$$PropsSetter {
    public LynxUIMarkdownShadowNode$$PropsSetter() {
    }

    @Override // com.lynx.tasm.behavior.shadow.ShadowNode$$PropsSetter, com.lynx.tasm.behavior.utils.ShadowNodeSetter
    public final void a(ShadowNode r5, String r6, x0 r7) {
        LynxUIMarkdownShadowNode r0 = (LynxUIMarkdownShadowNode) r5;
        r6.getClass();
        switch(r6.hashCode()) {
            case -2003776663: goto L102;
            case -1993305778: goto L98;
            case -1787558626: goto L94;
            case -1493293085: goto L90;
            case -1416592663: goto L86;
            case -1157887457: goto L82;
            case -1145258555: goto L78;
            case -1116605419: goto L74;
            case -1043245271: goto L70;
            case -775988986: goto L66;
            case -691933460: goto L62;
            case -412316625: goto L58;
            case -350684741: goto L54;
            case -215582707: goto L50;
            case 263767276: goto L46;
            case 264504047: goto L42;
            case 387245343: goto L38;
            case 951530617: goto L34;
            case 1108442963: goto L30;
            case 1137695781: goto L26;
            case 1214647014: goto L22;
            case 1257322832: goto L18;
            case 1587844870: goto L14;
            case 1629007544: goto L10;
            case 1916500116: goto L6;
            default: goto L105;
        };
    L105:
        byte r1 = -1;
    L107:
        switch(r1) {
            case 0: goto L158;
            case 1: goto L156;
            case 2: goto L154;
            case 3: goto L152;
            case 4: goto L150;
            case 5: goto L148;
            case 6: goto L146;
            case 7: goto L144;
            case 8: goto L142;
            case 9: goto L140;
            case 10: goto L138;
            case 11: goto L136;
            case 12: goto L134;
            case 13: goto L132;
            case 14: goto L130;
            case 15: goto L128;
            case 16: goto L126;
            case 17: goto L124;
            case 18: goto L122;
            case 19: goto L120;
            case 20: goto L118;
            case 21: goto L116;
            case 22: goto L114;
            case 23: goto L112;
            case 24: goto L110;
            default: goto L108;
        };
    L108:
        super.a(r5, r6, r7);
        return;
    L110:
        r0.setEnableRegionView(r7.b(r6, false));
        return;
    L112:
        r0.setTextMaxLine(r7.f(r6, 0));
        return;
    L114:
        r0.setTypewriterHeightTransitionDuration(r7.e(r6, 0.0f));
        return;
    L116:
        r0.setTextMarkAttachments(r7.a(r6));
        return;
    L118:
        r0.setImageSyncLoad(r7.b(r6, false));
        return;
    L120:
        r0.setSelectionBackgroundColor(r7.f(r6, 0));
        return;
    L122:
        r0.setStyleSheet(r7.g(r6));
        return;
    L124:
        r0.setContent(r7.h(r6));
        return;
    L126:
        r0.setExposureTags(r7.a(r6));
        return;
    L128:
        r0.setContentID(r7.h(r6));
        return;
    L130:
        r0.setEnableTextSelection(r7.b(r6, false));
        return;
    L132:
        r0.setContentComplete(r7.b(r6, false));
        return;
    L134:
        r0.setImageDownSampling(r7.b(r6, false));
        return;
    L136:
        r0.setMarkdownEffect(r7.g(r6));
        return;
    L138:
        r0.setAllowBreakAroundPunctuation(r7.b(r6, false));
        return;
    L140:
        r0.setAnimationVelocity(r7.e(r6, 0.0f));
        return;
    L142:
        r0.setAnimationFrameRate(r7.e(r6, 0.0f));
        return;
    L144:
        r0.setTypewriterAutoHeight(r7.b(r6, false));
        return;
    L146:
        r0.setSelectionHandleSize(r7.f(r6, 0));
        return;
    L148:
        r0.setSelectionHandleColor(r7.f(r6, 0));
        return;
    L150:
        r0.setMarkdownContentRange(r7.a(r6));
        return;
    L152:
        r0.setAnimationType(r7.h(r6));
        return;
    L154:
        r0.setInitialAnimationStep(r7.f(r6, 0));
        return;
    L156:
        r0.setMarkdownMaxHeight(r7.e(r6, 0.0f));
        return;
    L158:
        r0.setTypewriterHeightTransitionPrefetch(r7.b(r6, false));
        return;
    L6:
        if (r6.equals("enable-region-view") == false) goto L105;
        r1 = 24;
        goto L107
    L10:
        if (r6.equals("text-maxline") == false) goto L105;
        r1 = 23;
        goto L107
    L14:
        if (r6.equals("typewriter-height-transition-duration") == false) goto L105;
        r1 = 22;
        goto L107
    L18:
        if (r6.equals("text-mark-attachments") == false) goto L105;
        r1 = 21;
        goto L107
    L22:
        if (r6.equals("image-sync-load") == false) goto L105;
        r1 = 20;
        goto L107
    L26:
        if (r6.equals("selection-background-color") == false) goto L105;
        r1 = 19;
        goto L107
    L30:
        if (r6.equals("markdown-style") == false) goto L105;
        r1 = 18;
        goto L107
    L34:
        if (r6.equals(LynxAccessibilityModule.MSG_CONTENT) == false) goto L105;
        r1 = 17;
        goto L107
    L38:
        if (r6.equals("exposure-tags") == false) goto L105;
        r1 = 16;
        goto L107
    L42:
        if (r6.equals("content-id") == false) goto L105;
        r1 = 15;
        goto L107
    L46:
        if (r6.equals("text-selection") == false) goto L105;
        r1 = 14;
        goto L107
    L50:
        if (r6.equals("content-complete") == false) goto L105;
        r1 = 13;
        goto L107
    L54:
        if (r6.equals("image-downsampling") == false) goto L105;
        r1 = 12;
        goto L107
    L58:
        if (r6.equals("markdown-effect") == false) goto L105;
        r1 = 11;
        goto L107
    L62:
        if (r6.equals("allow-break-around-punctuation") == false) goto L105;
        r1 = 10;
        goto L107
    L66:
        if (r6.equals("animation-velocity") == false) goto L105;
        r1 = 9;
        goto L107
    L70:
        if (r6.equals("animation-frame-rate") == false) goto L105;
        r1 = 8;
        goto L107
    L74:
        if (r6.equals("typewriter-dynamic-height") == false) goto L105;
        r1 = 7;
        goto L107
    L78:
        if (r6.equals("selection-handle-size") == false) goto L105;
        r1 = 6;
        goto L107
    L82:
        if (r6.equals("selection-handle-color") == false) goto L105;
        r1 = 5;
        goto L107
    L86:
        if (r6.equals("content-range") == false) goto L105;
        r1 = 4;
        goto L107
    L90:
        if (r6.equals("animation-type") == false) goto L105;
        r1 = 3;
        goto L107
    L94:
        if (r6.equals("initial-animation-step") == false) goto L105;
        r1 = 2;
        goto L107
    L98:
        if (r6.equals("markdown-max-height") == false) goto L105;
        r1 = 1;
        goto L107
    L102:
        if (r6.equals("typewriter-height-transition-prefetch") == false) goto L105;
        r1 = 0;
        goto L107
    }
}
