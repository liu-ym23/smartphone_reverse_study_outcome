package com.lynx.textra;

import android.content.ContentResolver;
import android.content.Context;
import android.os.Build;
import android.provider.Settings;
import com.obric.aiagent.assistant.idl.bean.MessageContentType;
import f06.b;
import f06.c;
import f06.d;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
class OppoFontCaps implements PlatformFontCaps {
    private static int FONT_VARIATION_STEP = 10;
    private final Map<Integer, Integer> FONT_WEIGHT_CAST_WGHT;
    private final Context mContext;

    @Override // com.lynx.textra.PlatformFontCaps
    public final /* synthetic */ short clamp(int r1) {
        return PlatformFontCaps.CC.$default$clamp(this, r1);
    }

    @Override // com.lynx.textra.PlatformFontCaps
    public String defaultFamilyName() {
        String r0 = com_lynx_textra_OppoFontCaps_android_provider_Settings$System_getString(this.mContext.getContentResolver(), "current_typeface_name");
        if (Objects.equals(r0, "OPPO Sans") == false) goto L7;
        return "sys-sans-en";
    L7:
        if (Objects.equals(r0, "One Sans") == false) goto L10;
        return "op-sans-en";
    L10:
        return PlatformFontCaps.DEFAULT_FAMILY_NAME;
    }

    public OppoFontCaps(Context r14) {
        this.mContext = r14;
        LinkedHashMap r15 = new LinkedHashMap();
        this.FONT_WEIGHT_CAST_WGHT = r15;
        int r0 = Build.VERSION.SDK_INT;
        Integer r2 = Integer.valueOf(MessageContentType.OTHER);
        if (r0 < 35) goto L6;
        r15.put(100, 100);
        r15.put(200, 200);
        r15.put(300, 300);
        r15.put(400, 400);
        r15.put(500, 500);
        r15.put(600, 600);
        r15.put(700, 700);
        r15.put(r2, r2);
        r15.put(900, 900);
        r15.put(1000, 1000);
        return;
    L6:
        if (r0 < 34) goto L8;
        r15.put(100, 100);
        r15.put(200, 200);
        r15.put(300, 300);
        r15.put(400, 550);
        r15.put(500, 700);
        r15.put(600, 900);
        r15.put(700, 1000);
        r15.put(r2, 1000);
        r15.put(900, 1000);
        r15.put(1000, 1000);
        return;
    L8:
        r15.put(100, 200);
        r15.put(200, 250);
        r15.put(300, 350);
        r15.put(400, 550);
        r15.put(500, 700);
        r15.put(600, 700);
        r15.put(700, 700);
        r15.put(r2, 850);
        r15.put(900, 1000);
        r15.put(1000, 1000);
    }

    private int ToUserWeight(int r7) {
        Iterator<Map.Entry<Integer, Integer>> r0 = this.FONT_WEIGHT_CAST_WGHT.entrySet().iterator();
        Integer r1 = null;
        Integer r2 = null;
    L4:
        if (r0.hasNext() == false) goto L21;
        Map.Entry<Integer, Integer> r3 = r0.next();
        int r4 = r3.getValue().intValue();
        if (r7 == r4) goto L8;
        if (r2 != null) goto L13;
        if (r7 >= r4) goto L13;
        return r3.getKey().intValue();
    L13:
        if (r2 == null) goto L19;
        if (r7 <= r2.intValue()) goto L19;
        if (r7 >= r4) goto L19;
        return r1.intValue() + ((int) ((((r7 - r2.intValue()) * 1.0f) / (r4 - r2.intValue())) * (r3.getKey().intValue() - r1.intValue())));
    L19:
        r2 = Integer.valueOf(r4);
        r1 = r3.getKey();
        goto L4
    L8:
        return r3.getKey().intValue();
    L21:
        return r1.intValue();
    }

    @Override // com.lynx.textra.PlatformFontCaps
    public short adjust(short r5) {
        int r0 = Settings.System.getInt(this.mContext.getContentResolver(), "font_variation_settings", 550);
        if (((61440 & r0) >> 12) != 1) goto L10;
        int r1 = FONT_VARIATION_STEP;
        int r2 = ((r0 & 4095) / r1) * r1;
        Integer r3 = this.FONT_WEIGHT_CAST_WGHT.get(Integer.valueOf(r5));
        int r6 = r5;
        if (r3 == null) goto L9;
        r6 = r3.intValue();
    L9:
        return (short) ToUserWeight(clamp(r2 + (r6 - 550)));
    L10:
        return r5;
    }

    private static String com_lynx_textra_OppoFontCaps_android_provider_Settings$System_getString(ContentResolver r12, String r13) {
        c r8 = new c();
        Object[] r9 = {r12, r13};
        b r10 = new b();
        d r11 = r8.b(102003, "android/provider/Settings$System", "getString", Settings.System.class, r9, "java.lang.String", r10);
        if (r11.a == false) goto L6;
        r8.a(102003, "android/provider/Settings$System", "getString", Settings.System.class, r9, null, r10, false);
        return (String) r11.b;
    L6:
        String r14 = Settings.System.getString(r12, r13);
        r8.a(102003, "android/provider/Settings$System", "getString", Settings.System.class, r9, r14, r10, true);
        return r14;
    }
}
