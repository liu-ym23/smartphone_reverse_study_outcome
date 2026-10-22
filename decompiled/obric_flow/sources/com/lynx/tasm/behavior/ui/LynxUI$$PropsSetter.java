package com.lynx.tasm.behavior.ui;

import com.lynx.tasm.behavior.y0;

/* JADX INFO: loaded from: classes2.dex */
public class LynxUI$$PropsSetter extends LynxBaseUI$$PropsSetter {
    public LynxUI$$PropsSetter() {
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI$$PropsSetter, com.lynx.tasm.behavior.utils.LynxUISetter
    public void a(LynxBaseUI r10, String r11, y0 r12) {
        LynxUI r5 = (LynxUI) r10;
        r11.getClass();
        byte r13 = -1;
        switch(r11.hashCode()) {
            case -1970593579: goto L130;
            case -1796753876: goto L126;
            case -1757493843: goto L122;
            case -1649314686: goto L118;
            case -1613231517: goto L114;
            case -1297725862: goto L110;
            case -1274492040: goto L106;
            case -1267206133: goto L102;
            case -1091287993: goto L98;
            case -1087342188: goto L94;
            case -1013209314: goto L90;
            case -412530555: goto L86;
            case -397950676: goto L82;
            case -316342365: goto L78;
            case -127928127: goto L74;
            case -49240502: goto L70;
            case 37625839: goto L66;
            case 315007413: goto L62;
            case 374052076: goto L58;
            case 633600340: goto L54;
            case 714841829: goto L50;
            case 805728555: goto L46;
            case 839919573: goto L42;
            case 949630603: goto L38;
            case 985926797: goto L34;
            case 1052666732: goto L30;
            case 1229849887: goto L26;
            case 1372923181: goto L22;
            case 1485345550: goto L18;
            case 1941332754: goto L14;
            case 1998370329: goto L10;
            case 2022810070: goto L6;
            default: goto L133;
        };
    L133:
        switch(r13) {
            case 0: goto L198;
            case 1: goto L196;
            case 2: goto L194;
            case 3: goto L192;
            case 4: goto L190;
            case 5: goto L188;
            case 6: goto L186;
            case 7: goto L184;
            case 8: goto L182;
            case 9: goto L180;
            case 10: goto L178;
            case 11: goto L176;
            case 12: goto L174;
            case 13: goto L172;
            case 14: goto L170;
            case 15: goto L168;
            case 16: goto L166;
            case 17: goto L164;
            case 18: goto L162;
            case 19: goto L160;
            case 20: goto L158;
            case 21: goto L156;
            case 22: goto L154;
            case 23: goto L152;
            case 24: goto L150;
            case 25: goto L148;
            case 26: goto L146;
            case 27: goto L144;
            case 28: goto L142;
            case 29: goto L140;
            case 30: goto L138;
            case 31: goto L136;
            default: goto L134;
        };
    L134:
        super.a(r10, r11, r12);
        return;
    L136:
        r5.setLayoutAnimationCreateTimingFunc(r12.f10815a.getArray(r11));
        return;
    L138:
        r5.setLayoutAnimationCreateDuration(r12.a(r11, 0.0d));
        return;
    L140:
        r5.setVisibility(r12.c(r11, 1));
        return;
    L142:
        r5.setEnterTransitionName(r12.f10815a.getArray(r11));
        return;
    L144:
        r5.setLayoutAnimationUpdateProperty(r12.c(r11, 0));
        return;
    L146:
        r5.setOffsetPath(r12.f10815a.getArray(r11));
        return;
    L148:
        r5.setTransform(r12.f10815a.getArray(r11));
        return;
    L150:
        r5.setLayoutAnimationDeleteDelay(r12.a(r11, 0.0d));
        return;
    L152:
        r5.setLayoutAnimationDeleteProperty(r12.c(r11, 0));
        return;
    L154:
        r5.setOffsetRotate(r12.b(0.0f, r11));
        return;
    L156:
        r5.setLayoutAnimationUpdateDelay(r12.a(r11, 0.0d));
        return;
    L158:
        r5.setEnableReuseAnimationState(r12.e(r11, true));
        return;
    L160:
        r5.setExitTransitionName(r12.f10815a.getArray(r11));
        return;
    L162:
        r5.setLayoutAnimationUpdateDuration(r12.a(r11, 0.0d));
        return;
    L164:
        r5.setAccessibilityLabel(r12.f10815a.getDynamic(r11));
        return;
    L166:
        r5.setOffsetDistance(r12.b(0.0f, r11));
        return;
    L168:
        r5.setLayoutAnimationDeleteDuration(r12.a(r11, 0.0d));
        return;
    L170:
        r5.setAccessibilityElementsHidden(r12.e(r11, false));
        return;
    L172:
        r5.setLayoutAnimationUpdateTimingFunc(r12.f10815a.getArray(r11));
        return;
    L174:
        r5.setRenderToHardwareTexture(r12.e(r11, false));
        return;
    L176:
        r5.setLayoutAnimationDeleteTimingFunc(r12.f10815a.getArray(r11));
        return;
    L178:
        r5.setLayoutAnimationCreateDelay(r12.a(r11, 0.0d));
        return;
    L180:
        r5.setShareElement(r12.f10815a.getString(r11));
        return;
    L182:
        r5.setOverlap(r12.f10815a.getDynamic(r11));
        return;
    L184:
        r5.setAlpha(r12.b(1.0f, r11));
        return;
    L186:
        r5.setFilter(r12.f10815a.getArray(r11));
        return;
    L188:
        r5.setLayoutAnimationCreateProperty(r12.c(r11, 0));
        return;
    L190:
        r5.setResumeTransitionName(r12.f10815a.getArray(r11));
        return;
    L192:
        r5.setClipPath(r12.f10815a.getArray(r11));
        return;
    L194:
        r5.setTransformOrder(r12.f10815a.getDynamic(r11));
        return;
    L196:
        r5.setPauseTransitionName(r12.f10815a.getArray(r11));
        return;
    L198:
        r5.setTestID(r12.f10815a.getString(r11));
        return;
    L6:
        if (r11.equals("layout-animation-create-timing-function") == false) goto L133;
        r13 = 31;
        goto L133
    L10:
        if (r11.equals("layout-animation-create-duration") == false) goto L133;
        r13 = 30;
        goto L133
    L14:
        if (r11.equals("visibility") == false) goto L133;
        r13 = 29;
        goto L133
    L18:
        if (r11.equals("enter-transition-name") == false) goto L133;
        r13 = 28;
        goto L133
    L22:
        if (r11.equals("layout-animation-update-property") == false) goto L133;
        r13 = 27;
        goto L133
    L26:
        if (r11.equals("offset-path") == false) goto L133;
        r13 = 26;
        goto L133
    L30:
        if (r11.equals("transform") == false) goto L133;
        r13 = 25;
        goto L133
    L34:
        if (r11.equals("layout-animation-delete-delay") == false) goto L133;
        r13 = 24;
        goto L133
    L38:
        if (r11.equals("layout-animation-delete-property") == false) goto L133;
        r13 = 23;
        goto L133
    L42:
        if (r11.equals("offset-rotate") == false) goto L133;
        r13 = 22;
        goto L133
    L46:
        if (r11.equals("layout-animation-update-delay") == false) goto L133;
        r13 = 21;
        goto L133
    L50:
        if (r11.equals("enable-reuse-animation-state") == false) goto L133;
        r13 = 20;
        goto L133
    L54:
        if (r11.equals("exit-transition-name") == false) goto L133;
        r13 = 19;
        goto L133
    L58:
        if (r11.equals("layout-animation-update-duration") == false) goto L133;
        r13 = 18;
        goto L133
    L62:
        if (r11.equals("accessibility-label") == false) goto L133;
        r13 = 17;
        goto L133
    L66:
        if (r11.equals("offset-distance") == false) goto L133;
        r13 = 16;
        goto L133
    L70:
        if (r11.equals("layout-animation-delete-duration") == false) goto L133;
        r13 = 15;
        goto L133
    L74:
        if (r11.equals("accessibility-elements-hidden") == false) goto L133;
        r13 = 14;
        goto L133
    L78:
        if (r11.equals("layout-animation-update-timing-function") == false) goto L133;
        r13 = 13;
        goto L133
    L82:
        if (r11.equals("hardware-layer") == false) goto L133;
        r13 = 12;
        goto L133
    L86:
        if (r11.equals("layout-animation-delete-timing-function") == false) goto L133;
        r13 = 11;
        goto L133
    L90:
        if (r11.equals("layout-animation-create-delay") == false) goto L133;
        r13 = 10;
        goto L133
    L94:
        if (r11.equals("shared-element") == false) goto L133;
        r13 = 9;
        goto L133
    L98:
        if (r11.equals("overlap") == false) goto L133;
        r13 = 8;
        goto L133
    L102:
        if (r11.equals("opacity") == false) goto L133;
        r13 = 7;
        goto L133
    L106:
        if (r11.equals("filter") == false) goto L133;
        r13 = 6;
        goto L133
    L110:
        if (r11.equals("layout-animation-create-property") == false) goto L133;
        r13 = 5;
        goto L133
    L114:
        if (r11.equals("resume-transition-name") == false) goto L133;
        r13 = 4;
        goto L133
    L118:
        if (r11.equals("clip-path") == false) goto L133;
        r13 = 3;
        goto L133
    L122:
        if (r11.equals("transform-order") == false) goto L133;
        r13 = 2;
        goto L133
    L126:
        if (r11.equals("pause-transition-name") == false) goto L133;
        r13 = 1;
        goto L133
    L130:
        if (r11.equals("lynx-test-tag") == false) goto L133;
        r13 = 0;
        goto L133
    }
}
