package com.bytedance.ies.xelement.input;

import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.ui.LynxUI$$PropsSetter;
import com.lynx.tasm.behavior.y0;

/* JADX INFO: loaded from: classes2.dex */
public class LynxBaseInputView$$PropsSetter extends LynxUI$$PropsSetter {
    public LynxBaseInputView$$PropsSetter() {
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI$$PropsSetter, com.lynx.tasm.behavior.ui.LynxBaseUI$$PropsSetter, com.lynx.tasm.behavior.utils.LynxUISetter
    public void a(LynxBaseUI r10, String r11, y0 r12) {
        LynxBaseInputView r5 = (LynxBaseInputView) r10;
        r11.getClass();
        byte r13 = -1;
        switch(r11.hashCode()) {
            case -2063037069: goto L138;
            case -1988401764: goto L134;
            case -1730062511: goto L130;
            case -1664091044: goto L126;
            case -1586082113: goto L122;
            case -962590849: goto L118;
            case -866730430: goto L114;
            case -865043584: goto L110;
            case -723781827: goto L106;
            case -525534091: goto L102;
            case -445272125: goto L98;
            case -140393755: goto L94;
            case 3575610: goto L90;
            case 94842723: goto L86;
            case 97604824: goto L82;
            case 103960492: goto L78;
            case 108532386: goto L74;
            case 111972721: goto L70;
            case 124732746: goto L66;
            case 270940796: goto L62;
            case 598246771: goto L58;
            case 598800822: goto L54;
            case 746232421: goto L50;
            case 1101235489: goto L46;
            case 1155760891: goto L42;
            case 1437560563: goto L38;
            case 1579804907: goto L34;
            case 1614704353: goto L30;
            case 1782197877: goto L26;
            case 1901673625: goto L22;
            case 2018420361: goto L18;
            case 2033358039: goto L14;
            case 2051146279: goto L10;
            case 2140607816: goto L6;
            default: goto L141;
        };
    L141:
        switch(r13) {
            case 0: goto L214;
            case 1: goto L212;
            case 2: goto L210;
            case 3: goto L208;
            case 4: goto L206;
            case 5: goto L204;
            case 6: goto L202;
            case 7: goto L200;
            case 8: goto L198;
            case 9: goto L196;
            case 10: goto L194;
            case 11: goto L192;
            case 12: goto L190;
            case 13: goto L188;
            case 14: goto L186;
            case 15: goto L184;
            case 16: goto L182;
            case 17: goto L180;
            case 18: goto L178;
            case 19: goto L176;
            case 20: goto L174;
            case 21: goto L169;
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
        super.a(r10, r11, r12);
        return;
    L144:
        r5.setPlaceholderFontFamily(r12.f10815a.getString(r11));
        return;
    L146:
        r5.setConfirmType(r12.f10815a.getString(r11));
        return;
    L148:
        r5.setPlaceHolderStyle(r12.f10815a.getMap(r11));
        return;
    L150:
        r5.setPlaceholderColor(r12.f10815a.getDynamic(r11));
        return;
    L152:
        r5.setCursorColor(r12.f10815a.getString(r11));
        return;
    L154:
        r5.setIsAutoFillEnabled(r12.e(r11, false));
        return;
    L156:
        r5.setAutoFill(r12.e(r11, false));
        return;
    L158:
        r5.setSelectionHighLightColor(r12.f10815a.getString(r11));
        return;
    L160:
        r5.setAutoFit(r12.e(r11, true));
        return;
    L162:
        r5.setBottomInset(r12.f10815a.getString(r11));
        return;
    L164:
        r5.setAdjustMode(r12.f10815a.getString(r11));
        return;
    L166:
        r5.setTextAlign(r12.c(r11, 0));
        return;
    L174:
        r5.setPlaceholder(r12.f10815a.getString(r11));
        return;
    L176:
        r5.setDisable(r12.e(r11, false));
        return;
    L178:
        r5.setMaxLength(r12.f10815a.getDynamic(r11));
        return;
    L180:
        r5.setInputValue(r12.f10815a.getString(r11));
        return;
    L182:
        r5.setFontFamily(r12.f10815a.getString(r11));
        return;
    L184:
        r5.setBlurKeyboardHide(r12.e(r11, false));
        return;
    L186:
        r5.setFocus(r12.e(r11, false));
        return;
    L188:
        r5.setFontColor(r12.f10815a.getDynamic(r11));
        return;
    L190:
        r5.setInputType(r12.f10815a.getString(r11));
        return;
    L192:
        r5.setPlaceholderTextSize(r12.f10815a.getDynamic(r11));
        return;
    L194:
        r5.setShowSoftInputOnFocus(r12.e(r11, true));
        return;
    L196:
        r5.setKeyBoardFullscreenMode(r12.e(r11, true));
        return;
    L198:
        r5.setSelectionHandleColor(r12.f10815a.getString(r11));
        return;
    L200:
        r5.setSoftInputMode(r12.f10815a.getString(r11));
        return;
    L202:
        r5.setIsReadOnly(r12.e(r11, false));
        return;
    L204:
        r5.setLynxDirection(r12.c(r11, 3));
        return;
    L206:
        r5.setFontTextSize(r12.f10815a.getDynamic(r11));
        return;
    L208:
        r5.setPlaceholderTextWeight(r12.f10815a.getDynamic(r11));
        return;
    L210:
        r5.setSmartScroll(r12.e(r11, true));
        return;
    L212:
        r5.setLetterSpacing(r12.b(0.0f, r11));
        return;
    L214:
        r5.setCompatNumberType(r12.e(r11, false));
        return;
    L169:
        if (r12.f10815a.isNull(r11) == false) goto L171;
        Integer r14 = null;
    L172:
        r5.setFontWeight(r14);
        return;
    L171:
        r14 = Integer.valueOf(r12.c(r11, 0));
        goto L172
    L6:
        if (r11.equals("placeholder-font-family") == false) goto L141;
        r13 = 33;
        goto L141
    L10:
        if (r11.equals("confirm-type") == false) goto L141;
        r13 = 32;
        goto L141
    L14:
        if (r11.equals("placeholder-style") == false) goto L141;
        r13 = 31;
        goto L141
    L18:
        if (r11.equals("placeholder-color") == false) goto L141;
        r13 = 30;
        goto L141
    L22:
        if (r11.equals("caret-color") == false) goto L141;
        r13 = 29;
        goto L141
    L26:
        if (r11.equals("enableAutoFill") == false) goto L141;
        r13 = 28;
        goto L141
    L30:
        if (r11.equals("auto-fill") == false) goto L141;
        r13 = 27;
        goto L141
    L34:
        if (r11.equals("android-selection-highlight-color") == false) goto L141;
        r13 = 26;
        goto L141
    L38:
        if (r11.equals("auto-fit") == false) goto L141;
        r13 = 25;
        goto L141
    L42:
        if (r11.equals("bottom-inset") == false) goto L141;
        r13 = 24;
        goto L141
    L46:
        if (r11.equals("adjust-mode") == false) goto L141;
        r13 = 23;
        goto L141
    L50:
        if (r11.equals("text-align") == false) goto L141;
        r13 = 22;
        goto L141
    L54:
        if (r11.equals("font-weight") == false) goto L141;
        r13 = 21;
        goto L141
    L58:
        if (r11.equals("placeholder") == false) goto L141;
        r13 = 20;
        goto L141
    L62:
        if (r11.equals("disabled") == false) goto L141;
        r13 = 19;
        goto L141
    L66:
        if (r11.equals("maxlength") == false) goto L141;
        r13 = 18;
        goto L141
    L70:
        if (r11.equals("value") == false) goto L141;
        r13 = 17;
        goto L141
    L74:
        if (r11.equals("font-family") == false) goto L141;
        r13 = 16;
        goto L141
    L78:
        if (r11.equals("keyboard-hide-blur") == false) goto L141;
        r13 = 15;
        goto L141
    L82:
        if (r11.equals("focus") == false) goto L141;
        r13 = 14;
        goto L141
    L86:
        if (r11.equals("color") == false) goto L141;
        r13 = 13;
        goto L141
    L90:
        if (r11.equals("type") == false) goto L141;
        r13 = 12;
        goto L141
    L94:
        if (r11.equals("placeholder-font-size") == false) goto L141;
        r13 = 11;
        goto L141
    L98:
        if (r11.equals("show-soft-input-onfocus") == false) goto L141;
        r13 = 10;
        goto L141
    L102:
        if (r11.equals("fullscreen-mode") == false) goto L141;
        r13 = 9;
        goto L141
    L106:
        if (r11.equals("android-selection-handle-color") == false) goto L141;
        r13 = 8;
        goto L141
    L110:
        if (r11.equals("android-set-soft-input-mode") == false) goto L141;
        r13 = 7;
        goto L141
    L114:
        if (r11.equals("readonly") == false) goto L141;
        r13 = 6;
        goto L141
    L118:
        if (r11.equals("direction") == false) goto L141;
        r13 = 5;
        goto L141
    L122:
        if (r11.equals("font-size") == false) goto L141;
        r13 = 4;
        goto L141
    L126:
        if (r11.equals("placeholder-font-weight") == false) goto L141;
        r13 = 3;
        goto L141
    L130:
        if (r11.equals("smart-scroll") == false) goto L141;
        r13 = 2;
        goto L141
    L134:
        if (r11.equals("letter-spacing") == false) goto L141;
        r13 = 1;
        goto L141
    L138:
        if (r11.equals("compat-number-type") == false) goto L141;
        r13 = 0;
        goto L141
    }
}
