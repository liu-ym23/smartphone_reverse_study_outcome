package com.bytedance.android.ec.core.utils;

import com.bytedance.android.ec.core.abtest.ECSettingKeys;
import com.bytedance.android.ec.model.BenefitLabelSetting;
import com.bytedance.android.ec.model.ColorPattern;
import com.bytedance.android.ec.model.DivLinePattern;
import com.bytedance.android.ec.model.PromotionBenefitLabel;
import com.bytedance.android.ec.model.TextPattern;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class r {
    public static BenefitLabelSetting a;

    static {
    }

    public static void a(PromotionBenefitLabel r10) {
        Intrinsics.checkNotNullParameter(r10, "benefitLabel");
        if (r10.getTextPattern() != null) goto L5;
    L9:
        BenefitLabelSetting r0 = a;
        DivLinePattern r1 = null;
        if (r0 != null) goto L29;
        int r11 = w0.a;
        Lazy r12 = ECSettingKeys.a;
        int r13 = com.bytedance.android.ec.core.opt.ab.p.a;
        Object r14 = "";
        Result.Companion r15 = Result.Companion;     // Catch: Throwable -> L16
        jj4.b r16 = jj4.b.b;     // Catch: Throwable -> L16
        Object r17 = jj4.a.a("iesec_benefit_label_setting", String.class, "", false);     // Catch: Throwable -> L16
        if (r17 != null) goto L22;
        Intrinsics.throwNpe();     // Catch: Throwable -> L16
    L22:
        String r18 = (String) r17;
        if ((!StringsKt.isBlank(r18)) == true) goto L26;
        r18 = null;
    L26:
        if (r18 != null) goto L28;
        r18 = "{  \"text_style\": {    \"1\": {      \"height\": 16,      \"text_size\": 10,      \"inner_padding\": 4    },    \"2\": {      \"height\": 20,      \"text_size\": 11,      \"inner_padding\": 4    }  },  \"color_style\": {    \"1\": {      \"left_text_color\": \"#FFFE2C55\",      \"right_text_color\": \"#FFFE2C55\",      \"left_bg_color\": \"\",      \"right_bg_color\": \"\",      \"border_color\": \"#33FE2C55\"    },    \"2\": {      \"left_text_color\": \"#FFFE2C55\",      \"right_text_color\": \"#FFFE2C55\",      \"left_bg_color\": \"\",      \"right_bg_color\": \"#14FE2C55\",      \"border_color\": \"#33FE2C55\"    },    \"3\": {      \"left_text_color\": \"#FFFE522C\",      \"right_text_color\": \"#FFFE522C\",      \"left_bg_color\": \"#14FE522C\",      \"right_bg_color\": \"#14FE522C\",      \"border_color\": \"#33FE522C\"    },    \"4\": {      \"left_text_color\": \"\",      \"right_text_color\": \"#FFAE7228\",      \"left_bg_color\": \"\",      \"right_bg_color\": \"#14AE7228\",      \"border_color\": \"#33AE7228\"    },    \"5\": {      \"left_text_color\": \"#FFFE522C\",      \"right_text_color\": \"#FFFE522C\",      \"left_bg_color\": \"#29FE522C\",      \"right_bg_color\": \"#14FE522C\",      \"border_color\": \"#33FE522C\"    },    \"6\": {      \"left_text_color\": \"#FFFF6B00\",      \"right_text_color\": \"#FFFF6B00\",      \"left_bg_color\": \"#14FF7A00\",      \"right_bg_color\": \"#14FF7A00\",      \"border_color\": \"#33FF7A00\"    },    \"7\": {      \"left_text_color\": \"#FFFE2C55\",      \"right_text_color\": \"#FFFE2C55\",      \"left_bg_color\": \"#21FE2C55\",      \"right_bg_color\": \"#0DFE2C55\",      \"border_color\": \"#33FE2C55\"    }  },  \"div_line\": {    \"1\": {      \"div_line_color\": \"#33FE2C55\",      \"div_line_style\": 1,      \"div_line_height\": 16    },    \"2\": {      \"div_line_color\": \"#33FE2C55\",      \"div_line_style\": 0,      \"div_line_height\": 16    },    \"3\": {      \"div_line_color\": \"#33FE522C\",      \"div_line_style\": 1,      \"div_line_height\": 16    },    \"4\": {      \"div_line_color\": \"#00000000\",      \"div_line_style\": 1,      \"div_line_height\": 16    },    \"5\": {      \"div_line_color\": \"#33FF7A00\",      \"div_line_style\": 1,      \"div_line_height\": 16    },    \"6\": {      \"div_line_color\": \"#33FE2C55\",      \"div_line_style\": 0,      \"div_line_height\": 10    },    \"7\": {      \"div_line_color\": \"#33FE522C\",      \"div_line_style\": 0,      \"div_line_height\": 10    }  }}";
    L28:
        r0 = (BenefitLabelSetting) w0.b(r18, BenefitLabelSetting.class);
    L16:
        th = move-exception;
        Result.Companion r19 = Result.Companion;
        Object r20 = Result.constructor-impl(ResultKt.createFailure(th));
        if (Result.isFailure-impl(r20) == true) goto L21;
        r14 = r20;
    L21:
        r17 = r14;
    L29:
        if (r0 != null) goto L31;
        return;
    L31:
        if (a != null) goto L33;
        a = r0;
    L33:
        Map r21 = r0.getTextStyleMap();
        if (r21 == null) goto L36;
        TextPattern r22 = (TextPattern) r21.get(Integer.valueOf(r10.getTextStyle()));
    L37:
        r10.setTextPattern(r22);
        Map r23 = r0.getColorStyleMap();
        if (r23 == null) goto L40;
        ColorPattern r24 = (ColorPattern) r23.get(Integer.valueOf(r10.getColorStyle()));
    L41:
        r10.setColorPattern(r24);
        Map r25 = r0.getDivLineMap();
        if (r25 == null) goto L44;
        r1 = (DivLinePattern) r25.get(Integer.valueOf(r10.getDivLineStyle()));
    L44:
        r10.setDivLinePattern(r1);
        return;
    L40:
        r24 = null;
        goto L41
    L36:
        r22 = null;
        goto L37
    L5:
        if (r10.getColorPattern() == null) goto L9;
        if (r10.getDivLinePattern() == null) goto L9;
    }
}
