package com.ss.android.lark.message.card.view.richtext;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.text.Layout;
import android.text.TextPaint;
import android.text.TextUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastFloatProtector;
import com.facebook.yoga.YogaAlign;
import com.facebook.yoga.YogaDisplay;
import com.facebook.yoga.YogaFlexDirection;
import com.facebook.yoga.YogaJustify;
import com.facebook.yoga.YogaPositionType;
import com.facebook.yoga.YogaWrap;
import com.larksuite.component.ui.display.manager.zoom.LarkFont;
import com.larksuite.component.ui.display.manager.zoom.ZoomLevel6;
import com.larksuite.component.universe_design.color.UDColorUtils;
import com.larksuite.framework.utils.CollectionUtils;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.widget.richtext.RichText;
import com.ss.android.lark.widget.richtext.RichTextElement;
import com.ss.android.lark.widget.span.RecogniseSpansResult;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class b {

    public static /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[RichTextElement.RichTextTag.values().length];
            a = r0;
            r0[RichTextElement.RichTextTag.ANCHOR.ordinal()] = 1;     // Catch: NoSuchFieldError -> L20
        L56:
            a[RichTextElement.RichTextTag.AT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L21
        L40:
            a[RichTextElement.RichTextTag.EMOTION.ordinal()] = 3;     // Catch: NoSuchFieldError -> L22
        L52:
            a[RichTextElement.RichTextTag.ITALIC.ordinal()] = 4;     // Catch: NoSuchFieldError -> L23
        L58:
            a[RichTextElement.RichTextTag.BOLD.ordinal()] = 5;     // Catch: NoSuchFieldError -> L24
        L42:
            a[RichTextElement.RichTextTag.UNDERLINE.ordinal()] = 6;     // Catch: NoSuchFieldError -> L25
        L46:
            a[RichTextElement.RichTextTag.TEXT.ordinal()] = 7;     // Catch: NoSuchFieldError -> L26
        L66:
            a[RichTextElement.RichTextTag.TEXTABLEAREA.ordinal()] = 8;     // Catch: NoSuchFieldError -> L27
        L36:
            a[RichTextElement.RichTextTag.IMG.ordinal()] = 9;     // Catch: NoSuchFieldError -> L28
        L60:
            a[RichTextElement.RichTextTag.DATETIMEPICKER.ordinal()] = 10;     // Catch: NoSuchFieldError -> L29
        L62:
            a[RichTextElement.RichTextTag.TIMEPICKER.ordinal()] = 11;     // Catch: NoSuchFieldError -> L30
        L48:
            a[RichTextElement.RichTextTag.DATEPICKER.ordinal()] = 12;     // Catch: NoSuchFieldError -> L31
        L54:
            a[RichTextElement.RichTextTag.OVERFLOWMENU.ordinal()] = 13;     // Catch: NoSuchFieldError -> L32
        L38:
            a[RichTextElement.RichTextTag.SELECTMENU.ordinal()] = 14;     // Catch: NoSuchFieldError -> L33
        L44:
            a[RichTextElement.RichTextTag.BUTTON.ordinal()] = 15;     // Catch: NoSuchFieldError -> L34
        L64:
            a[RichTextElement.RichTextTag.TIME.ordinal()] = 16;     // Catch: NoSuchFieldError -> L35
            return;
        }
    }

    public static YogaProperty c(Map<String, String> r16) {
        YogaProperty r1 = new YogaProperty();
        if (CollectionUtils.isEmpty(r16) == false) goto L5;
        return r1;
    L5:
        Iterator<String> r2 = r16.keySet().iterator();
    L7:
        if (r2.hasNext() == false) goto L504;
        String r0 = r2.next();
        String r4 = r16.get(r0);
        if (TextUtils.isEmpty(r4) == true) goto L14;
        int r5 = r4.indexOf("%");
        if ((-1) == r5) goto L14;
        String r6 = r4.substring(0, r5);
    L15:
        r0.getClass();
        switch(r0.hashCode()) {
            case -1783760955: goto L143;
            case -1501175880: goto L139;
            case -1383228885: goto L135;
            case -1375815020: goto L131;
            case -1221029593: goto L127;
            case -1081309778: goto L123;
            case -1063257157: goto L119;
            case -1044792121: goto L115;
            case -975171706: goto L111;
            case -906066005: goto L107;
            case -806339567: goto L103;
            case -752601676: goto L99;
            case -289173127: goto L95;
            case -133587431: goto L91;
            case 115029: goto L87;
            case 3317767: goto L83;
            case 90130308: goto L79;
            case 108511772: goto L75;
            case 113126854: goto L71;
            case 202355100: goto L67;
            case 400381634: goto L63;
            case 713848971: goto L59;
            case 747804969: goto L55;
            case 975087886: goto L51;
            case 1031115618: goto L47;
            case 1092174483: goto L43;
            case 1671764162: goto L39;
            case 1743739820: goto L35;
            case 1744216035: goto L31;
            case 1767100401: goto L27;
            case 1860657097: goto L23;
            case 1970934485: goto L19;
            default: goto L146;
        };
    L146:
        byte r3 = -1;
    L147:
        float r15 = 1.0E21f;
        switch(r3) {
            case 0: goto L507;
            case 1: goto L498;
            case 2: goto L497;
            case 3: goto L491;
            case 4: goto L484;
            case 5: goto L482;
            case 6: goto L435;
            case 7: goto L432;
            case 8: goto L398;
            case 9: goto L392;
            case 10: goto L390;
            case 11: goto L343;
            case 12: goto L340;
            case 13: goto L333;
            case 14: goto L331;
            case 15: goto L330;
            case 16: goto L329;
            case 17: goto L328;
            case 18: goto L322;
            case 19: goto L320;
            case 20: goto L314;
            case 21: goto L312;
            case 22: goto L302;
            case 23: goto L299;
            case 24: goto L509;
            case 25: goto L292;
            case 26: goto L282;
            case 27: goto L505;
            case 28: goto L248;
            case 29: goto L201;
            case 30: goto L154;
            case 31: goto L151;
            default: goto L7;
        };
    L505:
        float r7 = CastFloatProtector.parseFloat(r4);     // Catch: NumberFormatException -> L279
    L281:
        r1.flexGrow = r7;
    L279:
        e = move-exception;
        e.printStackTrace();
        r7 = 0.0f;
        goto L281
    L507:
        r15 = CastFloatProtector.parseFloat(r4);     // Catch: NumberFormatException -> L501
    L503:
        r1.flexBasis = r15;
    L501:
        e = move-exception;
        e.printStackTrace();
        goto L503
    L509:
        float r8 = CastFloatProtector.parseFloat(r4);     // Catch: NumberFormatException -> L295
    L297:
        r1.flexShrink = r8;
    L295:
        e = move-exception;
        e.printStackTrace();
        r8 = 1.0f;
        goto L297
    L151:
        if (TextUtils.isEmpty(r6) == true) goto L152;
        r1.marginLeftPercent = a(r6, 1.0E21f);
        goto L7
    L152:
        r1.marginLeft = g(r4);
        goto L7
    L154:
        r4.getClass();
        switch(r4.hashCode()) {
            case -1767512087: goto L178;
            case -1364013995: goto L174;
            case -783548382: goto L170;
            case -775036382: goto L166;
            case 1897612915: goto L162;
            case 2015518925: goto L158;
            default: goto L181;
        };
    L181:
        byte r9 = -1;
    L182:
        if (r9 != 0) goto L184;
        YogaJustify r10 = YogaJustify.FLEX_START;
    L200:
        r1.justifyContent = r10.intValue();
        goto L7
    L184:
        if (r9 != 1) goto L186;
        r10 = YogaJustify.CENTER;
        goto L200
    L186:
        if (r9 != 2) goto L188;
        r10 = YogaJustify.SPACE_BETWEEN;
        goto L200
    L188:
        if (r9 != 3) goto L190;
        r10 = YogaJustify.FLEX_END;
        goto L200
    L190:
        if (r9 != 4) goto L192;
        r10 = YogaJustify.SPACE_AROUND;
        goto L200
    L192:
        if (r9 == 5) goto L194;
        r10 = YogaJustify.FLEX_START;
        goto L200
    L194:
        r10 = YogaJustify.SPACE_EVENLY;
        goto L200
    L158:
        if (r4.equals("spaceEvenly") == false) goto L181;
        r9 = 5;
        goto L182
    L162:
        if (r4.equals("spaceAround") == false) goto L181;
        r9 = 4;
        goto L182
    L166:
        if (r4.equals("flexEnd") == false) goto L181;
        r9 = 3;
        goto L182
    L170:
        if (r4.equals("spaceBetween") == false) goto L181;
        r9 = 2;
        goto L182
    L174:
        if (r4.equals("center") == false) goto L181;
        r9 = 1;
        goto L182
    L178:
        if (r4.equals("flexStart") == false) goto L181;
        r9 = 0;
        goto L182
    L201:
        r4.getClass();
        switch(r4.hashCode()) {
            case -1881872635: goto L233;
            case -1767512087: goto L229;
            case -1721738651: goto L225;
            case -1364013995: goto L221;
            case -783548382: goto L217;
            case -775036382: goto L213;
            case 3005871: goto L209;
            case 1897612915: goto L205;
            default: goto L236;
        };
    L236:
        byte r11 = -1;
    L237:
        switch(r11) {
            case 0: goto L246;
            case 1: goto L245;
            case 2: goto L244;
            case 3: goto L243;
            case 4: goto L242;
            case 5: goto L241;
            case 6: goto L240;
            case 7: goto L239;
            default: goto L238;
        };
    L238:
        YogaAlign r12 = YogaAlign.AUTO;
    L247:
        r1.alignSelf = r12.intValue();
        goto L7
    L239:
        r12 = YogaAlign.SPACE_AROUND;
        goto L247
    L240:
        r12 = YogaAlign.AUTO;
        goto L247
    L241:
        r12 = YogaAlign.FLEX_END;
        goto L247
    L242:
        r12 = YogaAlign.SPACE_BETWEEN;
        goto L247
    L243:
        r12 = YogaAlign.CENTER;
        goto L247
    L244:
        r12 = YogaAlign.BASELINE;
        goto L247
    L245:
        r12 = YogaAlign.FLEX_START;
        goto L247
    L246:
        r12 = YogaAlign.STRETCH;
        goto L247
    L205:
        if (r4.equals("spaceAround") == false) goto L236;
        r11 = 7;
        goto L237
    L209:
        if (r4.equals("auto") == false) goto L236;
        r11 = 6;
        goto L237
    L213:
        if (r4.equals("flexEnd") == false) goto L236;
        r11 = 5;
        goto L237
    L217:
        if (r4.equals("spaceBetween") == false) goto L236;
        r11 = 4;
        goto L237
    L221:
        if (r4.equals("center") == false) goto L236;
        r11 = 3;
        goto L237
    L225:
        if (r4.equals("baseLine") == false) goto L236;
        r11 = 2;
        goto L237
    L229:
        if (r4.equals("flexStart") == false) goto L236;
        r11 = 1;
        goto L237
    L233:
        if (r4.equals("stretch") == false) goto L236;
        r11 = 0;
        goto L237
    L248:
        r4.getClass();
        int r13 = r4.hashCode();
        if (r13 == (-1040545365)) goto L264;
        if (r13 == 3657802) goto L260;
        if (r13 == 1144787768) goto L256;
    L265:
        byte r14 = -1;
    L267:
        if (r14 != 0) goto L269;
        YogaWrap r17 = YogaWrap.NO_WRAP;
    L276:
        r1.flexWrap = r17.intValue();
        goto L7
    L269:
        if (r14 != 1) goto L271;
        r17 = YogaWrap.WRAP;
        goto L276
    L271:
        if (r14 == 2) goto L273;
        r17 = YogaWrap.NO_WRAP;
        goto L276
    L273:
        r17 = YogaWrap.WRAP_REVERSE;
        goto L276
    L256:
        if (r4.equals("wrapReverse") == false) goto L265;
        r14 = 2;
        goto L267
    L260:
        if (r4.equals("wrap") == false) goto L265;
        r14 = 1;
        goto L267
    L264:
        if (r4.equals("noWrap") == false) goto L265;
        r14 = 0;
        goto L267
    L282:
        YogaDisplay r18 = YogaDisplay.FLEX;
        if (TextUtils.isEmpty(r4) == false) goto L286;
    L291:
        r1.display = r18.intValue();
        goto L7
    L286:
        if (r4.trim().equals("flex") == true) goto L291;
        if (r4.trim().equals("none") == false) goto L291;
        r18 = YogaDisplay.NONE;
        goto L291
    L292:
        r1.aspectRatio = a(r4, 1.0E21f);
        goto L7
    L299:
        if (TextUtils.isEmpty(r6) == true) goto L300;
        r1.marginRightPercent = a(r6, 1.0E21f);
        goto L7
    L300:
        r1.marginRight = g(r4);
        goto L7
    L302:
        YogaPositionType r19 = YogaPositionType.RELATIVE;
        if (TextUtils.isEmpty(r4) == false) goto L306;
    L311:
        r1.position = r19.intValue();
        goto L7
    L306:
        if (r4.trim().equals("relative") == true) goto L311;
        if (r4.trim().equals("absolute") == false) goto L311;
        r19 = YogaPositionType.ABSOLUTE;
        goto L311
    L312:
        r1.paddingRight = g(r4);
        goto L7
    L314:
        if (TextUtils.isEmpty(r4) == true) goto L7;
        int r20 = r4.indexOf("%");
        if ((-1) == r20) goto L318;
        r1.maxWidthPercent = a(r4.substring(0, r20), 1.0E21f);
        goto L7
    L318:
        r1.maxWidth = m(r4);
        goto L7
    L320:
        r1.paddingBottom = g(r4);
        goto L7
    L322:
        if (TextUtils.isEmpty(r4) == true) goto L7;
        int r21 = r4.indexOf("%");
        if ((-1) == r21) goto L326;
        r1.widthPercent = a(r4.substring(0, r21), 1.0E21f);
        goto L7
    L326:
        r1.width = m(r4);
        goto L7
    L328:
        r1.right = h(r4);
        goto L7
    L329:
        r1.paddingTop = g(r4);
        goto L7
    L330:
        r1.left = h(r4);
        goto L7
    L331:
        r1.top = h(r4);
        goto L7
    L333:
        if (TextUtils.isEmpty(r4) == true) goto L7;
        int r22 = r4.indexOf("%");
        if ((-1) == r22) goto L337;
        r1.minHeightPercent = a(r4.substring(0, r22), 1.0E21f);
        goto L7
    L337:
        r1.minHeight = m(r4);
        goto L7
    L340:
        if (TextUtils.isEmpty(r6) == true) goto L341;
        r1.marginBottomPercent = a(r6, 1.0E21f);
        goto L7
    L341:
        r1.marginBottom = g(r4);
        goto L7
    L343:
        r4.getClass();
        switch(r4.hashCode()) {
            case -1881872635: goto L375;
            case -1767512087: goto L371;
            case -1721738651: goto L367;
            case -1364013995: goto L363;
            case -783548382: goto L359;
            case -775036382: goto L355;
            case 3005871: goto L351;
            case 1897612915: goto L347;
            default: goto L378;
        };
    L378:
        byte r23 = -1;
    L379:
        switch(r23) {
            case 0: goto L388;
            case 1: goto L387;
            case 2: goto L386;
            case 3: goto L385;
            case 4: goto L384;
            case 5: goto L383;
            case 6: goto L382;
            case 7: goto L381;
            default: goto L380;
        };
    L380:
        YogaAlign r24 = YogaAlign.AUTO;
    L389:
        r1.alignContent = r24.intValue();
        goto L7
    L381:
        r24 = YogaAlign.SPACE_AROUND;
        goto L389
    L382:
        r24 = YogaAlign.AUTO;
        goto L389
    L383:
        r24 = YogaAlign.FLEX_END;
        goto L389
    L384:
        r24 = YogaAlign.SPACE_BETWEEN;
        goto L389
    L385:
        r24 = YogaAlign.CENTER;
        goto L389
    L386:
        r24 = YogaAlign.BASELINE;
        goto L389
    L387:
        r24 = YogaAlign.FLEX_START;
        goto L389
    L388:
        r24 = YogaAlign.STRETCH;
        goto L389
    L347:
        if (r4.equals("spaceAround") == false) goto L378;
        r23 = 7;
        goto L379
    L351:
        if (r4.equals("auto") == false) goto L378;
        r23 = 6;
        goto L379
    L355:
        if (r4.equals("flexEnd") == false) goto L378;
        r23 = 5;
        goto L379
    L359:
        if (r4.equals("spaceBetween") == false) goto L378;
        r23 = 4;
        goto L379
    L363:
        if (r4.equals("center") == false) goto L378;
        r23 = 3;
        goto L379
    L367:
        if (r4.equals("baseLine") == false) goto L378;
        r23 = 2;
        goto L379
    L371:
        if (r4.equals("flexStart") == false) goto L378;
        r23 = 1;
        goto L379
    L375:
        if (r4.equals("stretch") == false) goto L378;
        r23 = 0;
        goto L379
    L390:
        float[] r25 = f(r4);
        r1.paddingTop = r25[0];
        r1.paddingRight = r25[1];
        r1.paddingBottom = r25[2];
        r1.paddingLeft = r25[3];
        goto L7
    L392:
        if (TextUtils.isEmpty(r4) == true) goto L7;
        int r26 = r4.indexOf("%");
        if ((-1) == r26) goto L396;
        r1.maxHeightPercent = a(r4.substring(0, r26), 1.0E21f);
        goto L7
    L396:
        r1.maxHeight = m(r4);
        goto L7
    L398:
        r4.getClass();
        switch(r4.hashCode()) {
            case -1354837162: goto L414;
            case 113114: goto L410;
            case 13846440: goto L406;
            case 1902758572: goto L402;
            default: goto L417;
        };
    L417:
        byte r27 = -1;
    L418:
        if (r27 != 0) goto L420;
        YogaFlexDirection r28 = YogaFlexDirection.COLUMN;
    L430:
        r1.flexDirection = r28.intValue();
        goto L7
    L420:
        if (r27 != 1) goto L422;
        r28 = YogaFlexDirection.ROW;
        goto L430
    L422:
        if (r27 != 2) goto L424;
        r28 = YogaFlexDirection.ROW_REVERSE;
        goto L430
    L424:
        if (r27 == 3) goto L426;
        r28 = YogaFlexDirection.ROW;
        goto L430
    L426:
        r28 = YogaFlexDirection.COLUMN_REVERSE;
        goto L430
    L402:
        if (r4.equals("columnReverse") == false) goto L417;
        r27 = 3;
        goto L418
    L406:
        if (r4.equals("rowReverse") == false) goto L417;
        r27 = 2;
        goto L418
    L410:
        if (r4.equals("row") == false) goto L417;
        r27 = 1;
        goto L418
    L414:
        if (r4.equals("column") == false) goto L417;
        r27 = 0;
        goto L418
    L432:
        if (TextUtils.isEmpty(r6) == true) goto L433;
        r1.marginTopPercent = a(r6, 1.0E21f);
        goto L7
    L433:
        r1.marginTop = g(r4);
        goto L7
    L435:
        r4.getClass();
        switch(r4.hashCode()) {
            case -1881872635: goto L467;
            case -1767512087: goto L463;
            case -1721738651: goto L459;
            case -1364013995: goto L455;
            case -783548382: goto L451;
            case -775036382: goto L447;
            case 3005871: goto L443;
            case 1897612915: goto L439;
            default: goto L470;
        };
    L470:
        byte r29 = -1;
    L471:
        switch(r29) {
            case 0: goto L480;
            case 1: goto L479;
            case 2: goto L478;
            case 3: goto L477;
            case 4: goto L476;
            case 5: goto L475;
            case 6: goto L474;
            case 7: goto L473;
            default: goto L472;
        };
    L472:
        YogaAlign r30 = YogaAlign.STRETCH;
    L481:
        r1.alignItems = r30.intValue();
        goto L7
    L473:
        r30 = YogaAlign.SPACE_AROUND;
        goto L481
    L474:
        r30 = YogaAlign.AUTO;
        goto L481
    L475:
        r30 = YogaAlign.FLEX_END;
        goto L481
    L476:
        r30 = YogaAlign.SPACE_BETWEEN;
        goto L481
    L477:
        r30 = YogaAlign.CENTER;
        goto L481
    L478:
        r30 = YogaAlign.BASELINE;
        goto L481
    L479:
        r30 = YogaAlign.FLEX_START;
        goto L481
    L480:
        r30 = YogaAlign.STRETCH;
        goto L481
    L439:
        if (r4.equals("spaceAround") == false) goto L470;
        r29 = 7;
        goto L471
    L443:
        if (r4.equals("auto") == false) goto L470;
        r29 = 6;
        goto L471
    L447:
        if (r4.equals("flexEnd") == false) goto L470;
        r29 = 5;
        goto L471
    L451:
        if (r4.equals("spaceBetween") == false) goto L470;
        r29 = 4;
        goto L471
    L455:
        if (r4.equals("center") == false) goto L470;
        r29 = 3;
        goto L471
    L459:
        if (r4.equals("baseLine") == false) goto L470;
        r29 = 2;
        goto L471
    L463:
        if (r4.equals("flexStart") == false) goto L470;
        r29 = 1;
        goto L471
    L467:
        if (r4.equals("stretch") == false) goto L470;
        r29 = 0;
        goto L471
    L482:
        float[] r31 = f(r4);
        r1.marginTop = r31[0];
        r1.marginRight = r31[1];
        r1.marginBottom = r31[2];
        r1.marginLeft = r31[3];
        goto L7
    L484:
        if (TextUtils.isEmpty(r4) == true) goto L7;
        int r32 = r4.indexOf("%");
        if ((-1) == r32) goto L488;
        r1.heightPercent = a(r4.substring(0, r32), 1.0E21f);
        goto L7
    L488:
        r1.height = m(r4);
        goto L7
    L491:
        if (TextUtils.isEmpty(r4) == true) goto L7;
        int r33 = r4.indexOf("%");
        if ((-1) == r33) goto L495;
        r1.minWidthPercent = a(r4.substring(0, r33), 1.0E21f);
        goto L7
    L495:
        r1.minWidth = m(r4);
        goto L7
    L497:
        r1.bottom = h(r4);
        goto L7
    L498:
        r1.paddingLeft = g(r4);
        goto L7
    L19:
        if (r0.equals("marginLeft") == false) goto L146;
        r3 = 31;
        goto L147
    L23:
        if (r0.equals("justifyContent") == false) goto L146;
        r3 = 30;
        goto L147
    L27:
        if (r0.equals("alignSelf") == false) goto L146;
        r3 = 29;
        goto L147
    L31:
        if (r0.equals("flexWrap") == false) goto L146;
        r3 = 28;
        goto L147
    L35:
        if (r0.equals("flexGrow") == false) goto L146;
        r3 = 27;
        goto L147
    L39:
        if (r0.equals("display") == false) goto L146;
        r3 = 26;
        goto L147
    L43:
        if (r0.equals("aspectRatio") == false) goto L146;
        r3 = 25;
        goto L147
    L47:
        if (r0.equals("flexShrink") == false) goto L146;
        r3 = 24;
        goto L147
    L51:
        if (r0.equals("marginRight") == false) goto L146;
        r3 = 23;
        goto L147
    L55:
        if (r0.equals("position") == false) goto L146;
        r3 = 22;
        goto L147
    L59:
        if (r0.equals("paddingRight") == false) goto L146;
        r3 = 21;
        goto L147
    L63:
        if (r0.equals("maxWidth") == false) goto L146;
        r3 = 20;
        goto L147
    L67:
        if (r0.equals("paddingBottom") == false) goto L146;
        r3 = 19;
        goto L147
    L71:
        if (r0.equals("width") == false) goto L146;
        r3 = 18;
        goto L147
    L75:
        if (r0.equals("right") == false) goto L146;
        r3 = 17;
        goto L147
    L79:
        if (r0.equals("paddingTop") == false) goto L146;
        r3 = 16;
        goto L147
    L83:
        if (r0.equals("left") == false) goto L146;
        r3 = 15;
        goto L147
    L87:
        if (r0.equals("top") == false) goto L146;
        r3 = 14;
        goto L147
    L91:
        if (r0.equals("minHeight") == false) goto L146;
        r3 = 13;
        goto L147
    L95:
        if (r0.equals("marginBottom") == false) goto L146;
        r3 = 12;
        goto L147
    L99:
        if (r0.equals("alignContent") == false) goto L146;
        r3 = 11;
        goto L147
    L103:
        if (r0.equals("padding") == false) goto L146;
        r3 = 10;
        goto L147
    L107:
        if (r0.equals("maxHeight") == false) goto L146;
        r3 = 9;
        goto L147
    L111:
        if (r0.equals("flexDirection") == false) goto L146;
        r3 = 8;
        goto L147
    L115:
        if (r0.equals("marginTop") == false) goto L146;
        r3 = 7;
        goto L147
    L119:
        if (r0.equals("alignItems") == false) goto L146;
        r3 = 6;
        goto L147
    L123:
        if (r0.equals("margin") == false) goto L146;
        r3 = 5;
        goto L147
    L127:
        if (r0.equals("height") == false) goto L146;
        r3 = 4;
        goto L147
    L131:
        if (r0.equals("minWidth") == false) goto L146;
        r3 = 3;
        goto L147
    L135:
        if (r0.equals("bottom") == false) goto L146;
        r3 = 2;
        goto L147
    L139:
        if (r0.equals("paddingLeft") == false) goto L146;
        r3 = 1;
        goto L147
    L143:
        if (r0.equals("flexBasis") == false) goto L146;
        r3 = 0;
    L14:
        r6 = "";
        goto L15
    L504:
        return r1;
    }

    public static int d(String r3) {
        if (TextUtils.isEmpty(r3) == false) goto L11;
        return 0;
    L11:
        return Color.parseColor(r3.trim());
    L8:
        e = move-exception;
        int r0 = UIHelper.getColor(2131103463);
        Log.e("CardRichTextParser", "parse color error", e);
        return r0;
    }

    public static float[] f(String r5) {
        float[] r1 = new float[4];
        if (TextUtils.isEmpty(r5) == false) goto L5;
        return r1;
    L5:
        String[] r6 = r5.trim().split(" ");
        int r2 = 0;
    L7:
        if (r2 >= r6.length) goto L12;
        float r3 = a(r6[r2], 0.0f);
        if (r2 >= 4) goto L11;
        r1[r2] = UIHelper.dp2px(r3);
    L11:
        r2 = r2 + 1;
        goto L7
    L12:
        return r1;
    }

    public static float g(String r1) {
        return UIHelper.dp2px(a(r1, 0.0f));
    }

    public static float h(String r1) {
        float r2 = a(r1, 1.0E21f);
        if (Float.compare(r2, 1.0E21f) != 0) goto L6;
        return r2;
    L6:
        return UIHelper.dp2px(r2);
    }

    public static int k(String r7) {
        if (TextUtils.isEmpty(r7) == true) goto L36;
        String[] r8 = r7.split("\\|");
        if (r8 != null) goto L7;
        return 3;
    L7:
        if (r8.length <= 0) goto L44;
        int r0 = r8.length;
        int r2 = 0;
        int r3 = 0;
    L9:
        if (r2 >= r0) goto L34;
        String r4 = r8[r2];
        if (TextUtils.isEmpty(r4) == true) goto L13;
        r4 = r4.toLowerCase();
    L13:
        r4.getClass();
        byte r6 = -1;
        switch(r4.hashCode()) {
            case -1364013995: goto L25;
            case 3317767: goto L21;
            case 108511772: goto L17;
            default: goto L28;
        };
    L28:
        switch(r6) {
            case 0: goto L32;
            case 1: goto L31;
            case 2: goto L30;
            default: goto L33;
        };
    L30:
        r3 = r3 | 5;
        goto L33
    L31:
        r3 = r3 | 3;
        goto L33
    L32:
        r3 = r3 | 1;
    L33:
        r2 = r2 + 1;
        goto L9
    L17:
        if (r4.equals("right") == false) goto L28;
        r6 = 2;
        goto L28
    L21:
        if (r4.equals("left") == false) goto L28;
        r6 = 1;
        goto L28
    L25:
        if (r4.equals("center") == false) goto L28;
        r6 = 0;
        goto L28
    L34:
        if (r3 == 0) goto L45;
        return r3;
    L45:
        return 3;
    L44:
        return 3;
    L36:
        return 3;
    }

    public static float m(String r1) {
        float r2 = a(r1, 1.0E21f);
        if (Float.compare(r2, 1.0E21f) != 0) goto L6;
        return r2;
    L6:
        return UIHelper.dp2px(r2);
    }

    public static float a(String r1, float r2) {
        if (TextUtils.isEmpty(r1) == false) goto L10;
        return r2;
    L10:
        return CastFloatProtector.parseFloat(r1);
    L7:
        e = move-exception;
        e.printStackTrace();
        return r2;
    }

    public static String b(String r1, long r2) {
        Date r0 = new Date(r2);     // Catch: Exception -> L4
        return new SimpleDateFormat(r1).format(r0);
    L4:
        e = move-exception;
        e.printStackTrace();
        return "";
    }

    public static int e(Map<String, String> r6, String r7) {
        Context r0 = com.ss.android.lark.message.card.b.a().getContext();
        int r1 = d(r6.get(r7));
        String r3 = String.format("%sToken", new Object[]{r7});
        String r8 = String.format("%sDarkMode", new Object[]{r7});
        String r2 = r6.get(r3);
        if (TextUtils.isEmpty(r2) == true) goto L9;
        int r4 = UDColorUtils.getColorIdByToken(r0, r2);
        if (r4 > 0) goto L7;
        Log.w("CardRichTextParser", "token color id is invalid colorTokenKey=" + r3 + " colorTokenValue=" + r2);
        goto L9
    L7:
        return UDColorUtils.getColor(r0, r4);
    L9:
        String r9 = r6.get(r8);
        if (TextUtils.isEmpty(r9) == true) goto L14;
        int r10 = d(r9);
        if (h18.f.a(r0) == false) goto L14;
        return r10;
    L14:
        return r1;
    }

    public static void i(NodeParams r43, String r44) {
        Context r10 = com.ss.android.lark.message.card.b.a().getContext();
        ArrayList r13 = new ArrayList();
        ArrayList r12 = new ArrayList();
        ArrayList r16 = new ArrayList();
        ArrayList r22 = new ArrayList();
        StringBuilder r38 = new StringBuilder();
        if (r43 == null) goto L28;
        RichTextElement.RichTextTag r0 = r43.mRichTextTag;
        if (r0 == null) goto L28;
        switch(a.a[r0.ordinal()]) {
            case 1: goto L20;
            case 2: goto L20;
            case 3: goto L20;
            case 4: goto L20;
            case 5: goto L20;
            case 6: goto L20;
            case 7: goto L20;
            case 8: goto L9;
            default: goto L8;
        };
    L8:
        Iterator<NodeParams> r1 = r43.mChildParams.iterator();
    L26:
        if (r1.hasNext() == false) goto L40;
        i(r1.next(), r44);
        goto L26
    L40:
        return;
    L9:
        List<NodeParams> r2 = r43.mChildParams;
        if (CollectionUtils.isNotEmpty(r2) == false) goto L33;
        Iterator<NodeParams> r14 = r2.iterator();
    L13:
        if (r14.hasNext() == false) goto L15;
        c0.o(r10, r13, r12, r16, r22, r38, r14.next(), r44);
        goto L13
    L15:
        new ArrayList();
        new ArrayList();
        ArrayList r3 = new ArrayList();
        ArrayList r4 = new ArrayList();
        new ArrayList();
        ArrayList r5 = new ArrayList();
        ArrayList r6 = new ArrayList();
        ArrayList r7 = new ArrayList();
        ArrayList r8 = new ArrayList();
        ArrayList r9 = new ArrayList();
        new ArrayList();
        List r11 = new RecogniseSpansResult(r12, r13, r3, r4, r16, r5, r6, r7, r8, r9, r22, new ArrayList(), new ArrayList(), new ArrayList(), new ArrayList(), new ArrayList(), new ArrayList(), new ArrayList(), new ArrayList(), new ArrayList(), new ArrayList(), new ArrayList(), new ArrayList(), new ArrayList(), new ArrayList(), new ArrayList()).getAllSpanInfos();
        com.ss.android.lark.widget.light.e.a r15 = new com.ss.android.lark.widget.light.e.a(r10);
        float r17 = r43.mTextSize;
        if (r17 > 0.0f) goto L19;
        r17 = 14.0f;
    L19:
        r15.g = UIUtils.dp2px(r10, r17);
        r15.a(com.ss.android.lark.message.card.b.a().getLoginUserId());
        r15.c = false;
        r15.u = UIHelper.getColor(2131103404);
        r15.t = UIHelper.getColor(2131103449);
        com.ss.android.lark.widget.light.e r18 = new com.ss.android.lark.widget.light.e(r15);
        r43.mSpannableString = com.ss.android.lark.widget.light.f.a.a.b(r10, r38.toString(), r11, r18);
        return;
    L33:
        return;
    L20:
        c0.o(r10, r13, r12, r16, r22, r38, r43, r44);
        new ArrayList();
        new ArrayList();
        ArrayList r19 = new ArrayList();
        ArrayList r20 = new ArrayList();
        new ArrayList();
        ArrayList r21 = new ArrayList();
        ArrayList r23 = new ArrayList();
        ArrayList r24 = new ArrayList();
        ArrayList r25 = new ArrayList();
        ArrayList r26 = new ArrayList();
        new ArrayList();
        List r27 = new RecogniseSpansResult(r12, r13, r19, r20, r16, r21, r23, r24, r25, r26, r22, new ArrayList(), new ArrayList(), new ArrayList(), new ArrayList(), new ArrayList(), new ArrayList(), new ArrayList(), new ArrayList(), new ArrayList(), new ArrayList(), new ArrayList(), new ArrayList(), new ArrayList(), new ArrayList(), new ArrayList()).getAllSpanInfos();
        com.ss.android.lark.widget.light.e.a r28 = new com.ss.android.lark.widget.light.e.a(r10);
        float r29 = r43.mTextSize;
        if (r29 > 0.0f) goto L24;
        r29 = 14.0f;
    L24:
        r28.g = UIUtils.dp2px(r10, r29);
        r28.a(com.ss.android.lark.message.card.b.a().getLoginUserId());
        r28.c = false;
        r28.u = UIHelper.getColor(2131103404);
        r28.t = UIHelper.getColor(2131103449);
        com.ss.android.lark.widget.light.e r30 = new com.ss.android.lark.widget.light.e(r28);
        r43.mSpannableString = com.ss.android.lark.widget.light.f.a.a.b(r10, r38.toString(), r27, r30);
        return;
    L28:
        if (r43 == null) goto L39;
        Iterator<NodeParams> r31 = r43.mChildParams.iterator();
    L31:
        if (r31.hasNext() == false) goto L41;
        i(r31.next(), r44);
        goto L31
    L41:
        return;
    }

    public static long l(String r3, String r4) {
        return new SimpleDateFormat(r4.concat(" Z")).parse(r3).getTime();
    L5:
        e = move-exception;
        Log.e("msg_card", e.getMessage(), e);
        return new SimpleDateFormat(r4).parse(r3).getTime();
    L9:
        e = move-exception;
        e.printStackTrace();
        return -1;
    }

    public static void j(NodeParams r8, Map<String, String> r9, int r10) {
        if (CollectionUtils.isEmpty(r9) == false) goto L5;
        return;
    L5:
        r8.mBgColor = e(r9, "backgroundColor");
        r8.mTextColor = e(r9, "color");
        String r0 = r9.get("fontWeight");
        String r1 = r9.get("fontStyle");
        int r4 = 0;
        if (TextUtils.isEmpty(r0) == false) goto L11;
        if (TextUtils.isEmpty(r1) == false) goto L11;
    L25:
        int r2 = 0;
    L28:
        r8.mFontStyleAndWeight = r2;
        String r3 = r9.get("fontSize");
        if (TextUtils.isEmpty(r3) == false) goto L83;
    L35:
        float r5 = -1.0f;
    L36:
        r8.mTextSize = r5;
        if (x0.a(r10) == false) goto L54;
        float r11 = r8.mTextSize;
        r8.mDefaultTextSize = r11;
        if (r11 <= 0.0f) goto L54;
        NodeParams r6 = r8.mParents;
        if (r6 != null) goto L44;
    L53:
        r8.mTextSize = zz7.b.j((int) r11);
        goto L54
    L44:
        if (r6.mRichTextTag != RichTextElement.RichTextTag.BUTTON) goto L53;
        int r12 = (int) r11;
        ZoomLevel6 r7 = zz7.b.a;
        LarkFont[] r13 = LarkFont.values();
        int r14 = r13.length;
        int r15 = 0;
    L46:
        if (r15 >= r14) goto L51;
        LarkFont r16 = r13[r15];
        if (r16.getNormal() == r12) goto L49;
        r15 = r15 + 1;
        goto L46
    L49:
        Intrinsics.checkNotNullParameter(r16, "larkFont");
        float r17 = zz7.b.c(r16);
    L52:
        r8.mTextSize = r17;
        goto L54
    L51:
        r17 = r12 * zz7.b.e().getMultiplier();
    L54:
        int r18 = a.a[r8.mRichTextTag.ordinal()];
        if (r18 == 1) goto L74;
        switch(r18) {
            case 7: goto L74;
            case 8: goto L74;
            case 9: goto L68;
            case 10: goto L59;
            case 11: goto L59;
            case 12: goto L59;
            case 13: goto L59;
            case 14: goto L59;
            case 15: goto L59;
            case 16: goto L74;
            default: goto L93;
        };
    L93:
        return;
    L59:
        if (r8.mExtraProperties != null) goto L61;
        r8.mExtraProperties = new HashMap(RichTextStyle.a.length);
    L61:
        String[] r19 = RichTextStyle.a;
        int r20 = r19.length;
    L62:
        if (r4 >= r20) goto L94;
        String r21 = r19[r4];
        if (r9.get(r21) == null) goto L66;
        r8.mExtraProperties.put(r21, r9.get(r21));
    L66:
        r4 = r4 + 1;
        goto L62
    L94:
        return;
    L68:
        if (r9.get("borderRadius") != null) goto L70;
        return;
    L70:
        if (r8.mExtraProperties != null) goto L72;
        r8.mExtraProperties = new HashMap(1);
    L72:
        r8.mExtraProperties.put("borderRadius", r9.get("borderRadius"));
        return;
    L74:
        if (r8.mExtraProperties != null) goto L77;
        r8.mExtraProperties = new HashMap(2);
    L77:
        if (r9.get("textDecoration") == null) goto L80;
        r8.mExtraProperties.put("textDecoration", r9.get("textDecoration"));
    L80:
        if (r9.get("textAlign") == null) goto L92;
        r8.mExtraProperties.put("textAlign", r9.get("textAlign"));
        return;
    L92:
        return;
    L83:
        r5 = CastFloatProtector.parseFloat(r3);     // Catch: NumberFormatException -> L33
    L33:
        e = move-exception;
        e.printStackTrace();
    L11:
        if (TextUtils.isEmpty(r0) == false) goto L13;
    L15:
        int r22 = 0;
    L17:
        if (TextUtils.isEmpty(r1) == false) goto L19;
    L21:
        if (r22 == 1) goto L27;
        if (r22 == 2) goto L26;
        r2 = 3;
        if (r22 == 3) goto L28;
    L26:
        r2 = 2;
        goto L28
    L27:
        r2 = 1;
        goto L28
    L19:
        if (r1.trim().equals("italic") == false) goto L21;
        r22 = r22 + 2;
        goto L21
    L13:
        if (r0.trim().equals("bold") == false) goto L15;
        r22 = 1;
        goto L17
    }

    public static NodeParams o(com.ss.android.lark.message.card.view.a r23, RichText r24, int r25) {
        if (r24 != null) goto L6;
        Log.d("RichText is null");
        return null;
    L6:
        NodeParams r4 = new NodeParams(r25);
        List r5 = r24.getElementIds();
        Map r6 = r24.getElements().getDictionary();
        Log.i("CardRichTextParser", "cardVersion:" + r25 + ", zoom level" + zz7.b.d());
        int r8 = 0;
    L8:
        if (r8 >= r5.size()) goto L15;
        RichTextElement r9 = (RichTextElement) r6.get((String) ListProtector.get(r5, r8));
        if (r9 == null) goto L12;
        NodeParams r10 = new NodeParams(r25);
        r10.mParents = r4;
        r10.mRichTextProperty = r9.getProperty();
        r10.mRichTextTag = r9.getTag();
        r10.mStyleKeys = r9.getStyleKeys();
        x0.e(r24, r25, r10);
        r10.mYogaProperty = c(r9.getStyle());
        j(r10, r9.getStyle(), r25);
        r4.mChildParams.add(r10);
        n(r10, r9, r6, r24, r25);
    L13:
        r8 = r8 + 1;
        goto L8
    L12:
        Log.e("Wrong rich text data structure");
        goto L13
    L15:
        if (com.ss.android.lark.message.card.b.a().getFgValue("lark.card.message.lightview") == false) goto L20;
        if (r23 != null) goto L18;
        String r0 = null;
    L19:
        i(r4, r0);
        goto L20
    L18:
        r0 = ((com.ss.android.lark.chat.base.view.vo.message.f) r23).b;
    L20:
        Map<RichText, Integer> r1 = x0.b;
        monitor-enter(x0.class);
    L146:
        th = move-exception;
        throw th;
    L23:
        if (x0.a(r25) == true) goto L26;
        monitor-exit(x0.class);
    L145:
        return r4;
    L26:
        Map<RichText, List<NodeParams>> r2 = x0.d;     // Catch: Throwable -> L146
        if (((HashMap) r2).get(r24) != null) goto L30;
        monitor-exit(x0.class);
        goto L145
    L30:
        Iterator r3 = ((List) ((HashMap) r2).get(r24)).iterator();     // Catch: Throwable -> L146
        NodeParams r7 = null;
    L32:
        if (r3.hasNext() == false) goto L132;
        NodeParams r11 = (NodeParams) r3.next();     // Catch: Throwable -> L146
        ArrayList r12 = new ArrayList();     // Catch: Throwable -> L146
        if (CollectionUtils.isEmpty(r11.mChildParams) == true) goto L54;
        ArrayList r13 = new ArrayList();     // Catch: Throwable -> L146
        r13.addAll(r11.mChildParams);     // Catch: Throwable -> L146
        Iterator r14 = r13.iterator();     // Catch: Throwable -> L146
        int r15 = 1;
    L37:
        if (r14.hasNext() == false) goto L55;
        NodeParams r16 = (NodeParams) r14.next();     // Catch: Throwable -> L146
        if (r16 == null) goto L37;
        RichTextElement.RichTextTag r17 = r16.mRichTextTag;     // Catch: Throwable -> L146
        if (r17 == RichTextElement.RichTextTag.BUTTON) goto L43;
        if (r17 != RichTextElement.RichTextTag.PARAGRAPH) goto L37;
        if (r7 != null) goto L51;
        if (r16.mStyleKeys.contains("block_action_placeholder_1") == false) goto L51;
        r7 = r16;
    L51:
        if (r16.mStyleKeys.contains("block_action_placeholder_2") == false) goto L37;
        if (r15 != 1) goto L37;
        r15 = r12.size();     // Catch: Throwable -> L146
        goto L37
    L43:
        r12.add(r16);     // Catch: Throwable -> L146
    L55:
        YogaProperty r18 = r11.mYogaProperty;     // Catch: Throwable -> L146
        float r19 = r18.marginLeft;     // Catch: Throwable -> L146
        float r20 = r18.marginRight;     // Catch: Throwable -> L146
        float r110 = 1.0E21f;
        if (r19 == 1.0E21f) goto L58;
        int r111 = (int) r19;     // Catch: Throwable -> L146
    L60:
        if (r20 == 1.0E21f) goto L62;
        int r21 = (int) r20;     // Catch: Throwable -> L146
    L63:
        int r112 = (com.ss.android.lark.message.card.b.a().getMaxMessageWidth(-1) - r111) - r21;     // Catch: Throwable -> L146
        if (r12.isEmpty() == true) goto L131;
        Map<RichText, List<NodeParams>> r22 = x0.c;     // Catch: Throwable -> L146
        List r113 = (List) ((HashMap) r22).get(r24);     // Catch: Throwable -> L146
        if (r113 != null) goto L68;
        r113 = new ArrayList();     // Catch: Throwable -> L146
        ((HashMap) r22).put(r24, r113);     // Catch: Throwable -> L146
    L68:
        Iterator r26 = r12.iterator();     // Catch: Throwable -> L146
    L70:
        if (r26.hasNext() == false) goto L131;
        NodeParams r27 = (NodeParams) r26.next();     // Catch: Throwable -> L146
        YogaProperty r114 = r27.mYogaProperty;     // Catch: Throwable -> L146
        int r28 = (int) r114.paddingLeft;     // Catch: Throwable -> L146
        int r29 = (int) r114.paddingRight;     // Catch: Throwable -> L146
        float r115 = r114.marginLeft;     // Catch: Throwable -> L146
        float r116 = r114.marginRight;     // Catch: Throwable -> L146
        if (r115 == r110) goto L74;
        int r117 = (int) r115;     // Catch: Throwable -> L146
    L76:
        if (r116 == r110) goto L78;
        int r118 = (int) r116;     // Catch: Throwable -> L146
    L79:
        TextPaint r119 = new TextPaint();     // Catch: Throwable -> L146
        Iterator<NodeParams> r30 = r27.mChildParams.iterator();     // Catch: Throwable -> L146
    L81:
        if (r30.hasNext() == false) goto L86;
        Iterator r120 = r3;
        NodeParams r31 = r30.next();     // Catch: Throwable -> L146
        Iterator r121 = r26;
        Iterator<NodeParams> r210 = r30;
        if (r31.mRichTextTag == RichTextElement.RichTextTag.TEXT) goto L84;
        r26 = r121;
        r3 = r120;
        r30 = r210;
        goto L81
    L84:
        r119.setTextSize(UIHelper.sp2px(r31.mTextSize));     // Catch: Throwable -> L146
        r119.setTypeface(Typeface.DEFAULT_BOLD);     // Catch: Throwable -> L146
        String r122 = r31.mRichTextProperty.getContent();     // Catch: Throwable -> L146
        r113.add(r31);     // Catch: Throwable -> L146
        String r32 = r122;
    L88:
        if (r15 != 2) goto L98;
        if (r7 == null) goto L97;
        YogaProperty r33 = r7.mYogaProperty;     // Catch: Throwable -> L146
        List r211 = r113;
        float r123 = r33.width;     // Catch: Throwable -> L146
        if (r123 == 1.0E21f) goto L93;
        float r34 = r112;
    L96:
        float r35 = r34 - r123;     // Catch: Throwable -> L146
    L108:
        r112 = (int) r35;     // Catch: Throwable -> L146
    L110:
        if (r15 > 0) goto L112;
        Log.w("ZoomRule", "adjustButtonTextFontSize buttonColumn <= 0");     // Catch: Throwable -> L146
        r15 = 1;
    L112:
        float r36 = (r112 / r15) - (((r28 + r29) + r117) + r118);     // Catch: Throwable -> L146
        if (Layout.getDesiredWidth(r32, r119) <= r36) goto L130;
        float r37 = 0.0f;
        if (r31 != null) goto L117;
        float r38 = 0.0f;
    L118:
        if (r31 == null) goto L122;
        r37 = r31.mDefaultTextSize;     // Catch: Throwable -> L146
    L122:
        if (r38 <= r37) goto L125;
        r38 = r38 - 1.0f;     // Catch: Throwable -> L146
        r119.setTextSize(UIHelper.sp2px(r38));     // Catch: Throwable -> L146
        if (Layout.getDesiredWidth(r32, r119) >= r36) goto L122;
    L125:
        Map<RichText, Integer> r39 = x0.b;     // Catch: Throwable -> L146
        if (((HashMap) r39).get(r24) != null) goto L128;
    L129:
        ((HashMap) r39).put(r24, Integer.valueOf((int) r38));     // Catch: Throwable -> L146
        goto L130
    L128:
        if (((Integer) ((HashMap) r39).get(r24)).intValue() <= r38) goto L130;
    L117:
        r38 = r31.mTextSize;     // Catch: Throwable -> L146
    L130:
        r26 = r121;
        r3 = r120;
        r113 = r211;
        r110 = 1.0E21f;
        goto L70
    L93:
        float r40 = r33.widthPercent;     // Catch: Throwable -> L146
        if (r40 == 1.0E21f) goto L110;
        float r124 = r112;
        r123 = (r40 * r124) / 100.0f;     // Catch: Throwable -> L146
        r34 = r124;
        goto L96
    L97:
        r211 = r113;
        goto L110
    L98:
        r211 = r113;
        if (r15 != 3) goto L110;
        if (r7 == null) goto L110;
        YogaProperty r41 = r7.mYogaProperty;     // Catch: Throwable -> L146
        float r125 = r41.width;     // Catch: Throwable -> L146
        if (r125 == 1.0E21f) goto L105;
        r35 = r112 - (r125 * 2.0f);     // Catch: Throwable -> L146
        goto L108
    L105:
        float r42 = r41.widthPercent;     // Catch: Throwable -> L146
        if (r42 == 1.0E21f) goto L110;
        r35 = r112 - (((r112 * 2) * r42) / 100.0f);     // Catch: Throwable -> L146
        goto L108
    L86:
        r120 = r3;
        r121 = r26;
        r32 = "";
        r31 = null;
        goto L88
    L78:
        r118 = 0;
        goto L79
    L74:
        r117 = 0;
    L131:
        r3 = r3;
        goto L32
    L62:
        r21 = 0;
        goto L63
    L58:
        r111 = 0;
        goto L60
    L54:
        r15 = 1;
        goto L55
    L132:
        ((HashMap) x0.d).remove(r24);     // Catch: Throwable -> L146
        List r43 = (List) ((HashMap) x0.c).get(r24);     // Catch: Throwable -> L146
        if (r43 != null) goto L135;
    L143:
        ((HashMap) x0.c).remove(r24);     // Catch: Throwable -> L146
        monitor-exit(x0.class);
        goto L145
    L135:
        if (r43.isEmpty() == true) goto L143;
        Iterator r44 = r43.iterator();     // Catch: Throwable -> L146
    L138:
        if (r44.hasNext() == false) goto L142;
        NodeParams r45 = (NodeParams) r44.next();     // Catch: Throwable -> L146
        Map<RichText, Integer> r46 = x0.b;     // Catch: Throwable -> L146
        if (((HashMap) r46).get(r24) == null) goto L138;
        r45.mTextSize = ((Integer) ((HashMap) r46).get(r24)).intValue();     // Catch: Throwable -> L146
        goto L138
    L142:
        x0.d(zz7.b.d().getLevel() + "", r24, r25);     // Catch: Throwable -> L146
        goto L143
    }

    public static void n(NodeParams r3, RichTextElement r4, Map<String, RichTextElement> r5, RichText r6, int r7) {
        List r8 = r4.getChildIds();
        if (CollectionUtils.isEmpty(r8) == false) goto L5;
        return;
    L5:
        Iterator r9 = r8.iterator();
    L7:
        if (r9.hasNext() == false) goto L11;
        String r0 = (String) r9.next();
        NodeParams r1 = new NodeParams(r7);
        r3.mChildParams.add(r1);
        r1.mParents = r3;
        RichTextElement r2 = r5.get(r0);
        if (r2 == null) goto L7;
        r1.mRichTextProperty = r2.getProperty();
        r1.mRichTextTag = r2.getTag();
        r1.mStyleKeys = r2.getStyleKeys();
        x0.e(r6, r7, r1);
        r1.mYogaProperty = c(r2.getStyle());
        j(r1, r2.getStyle(), r7);
        n(r1, r2, r5, r6, r7);
        goto L7
    }
}
