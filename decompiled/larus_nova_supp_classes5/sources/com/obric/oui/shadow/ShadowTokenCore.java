package com.obric.oui.shadow;

import android.text.TextUtils;
import com.obric.oui.material.OMaterialHelper;
import com.obric.oui.material.s;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class ShadowTokenCore {
    public static final b[] Oui_Shadow_Regular = null;
    static final b[] Oui_Shadow_Regular_V1 = null;
    static final b[] Oui_Shadow_Regular_V2 = null;
    public static final b[] Oui_Shadow_Text_Regular = null;
    public static final b[] Oui_Shadow_Thick = null;
    static final b[] Oui_Shadow_Thick_V1 = null;
    static final b[] Oui_Shadow_Thick_V2 = null;
    public static final b[] Oui_Shadow_Thin = null;
    public static final b[] Oui_Shadow_UltraThick = null;
    public static final b[] Shadow_1 = null;
    public static final b[] Shadow_2 = null;
    public static final b[] Shadow_3 = null;
    public static final b[] Shadow_Text = null;
    public static final b[] Shadow_Thick = null;
    private static final ConcurrentHashMap<String, b[]> tokens = null;

    static {
        Oui_Shadow_Thin = new b[]{new b(0.0f, 2.0f, 10.0f, 251658240, 0.0f, -1)};
        b[] r3 = {new b(0.0f, 8.0f, 20.0f, 335544320, 0.0f, -1), new b(0.0f, 2.0f, 10.0f, 134217728, 0.0f, -1)};
        Oui_Shadow_Regular_V2 = r3;
        b[] r4 = {new b(0.0f, 6.0f, 20.0f, 218103808, 0.0f, -1), new b(0.0f, 2.0f, 10.0f, 83886080, 0.0f, -1)};
        Oui_Shadow_Regular_V1 = r4;
        if (OMaterialHelper.f() >= 4) goto L6;
        r3 = r4;
    L6:
        Oui_Shadow_Regular = r3;
        b[] r5 = {new b(0.0f, 12.0f, 24.0f, 603979776, 0.0f, -1)};
        Oui_Shadow_Thick_V2 = r5;
        b[] r6 = {new b(0.0f, 12.0f, 24.0f, 520093696, 0.0f, -1)};
        Oui_Shadow_Thick_V1 = r6;
        if (OMaterialHelper.f() >= 4) goto L10;
        r5 = r6;
    L10:
        Oui_Shadow_Thick = r5;
        Oui_Shadow_UltraThick = new b[]{new b(0.0f, 16.0f, 60.0f, 687865856, 0.0f, -1)};
        Oui_Shadow_Text_Regular = new b[]{new b(0.0f, 1.0f, 2.5f, 167772160, 0.0f, -1), new b(0.0f, 0.0f, 1.0f, 167772160, 0.0f, -1)};
        Shadow_1 = new b[]{new b(0.0f, 2.0f, 10.0f, 251658240, 0.0f, -1)};
        Shadow_2 = new b[]{new b(0.0f, 6.0f, 20.0f, 218103808, 0.0f, -1), new b(0.0f, 2.0f, 10.0f, 83886080, 0.0f, -1)};
        Shadow_3 = new b[]{new b(0.0f, 12.0f, 24.0f, 520093696, 0.0f, -1)};
        Shadow_Thick = new b[]{new b(0.0f, 16.0f, 60.0f, 687865856, 0.0f, -1)};
        Shadow_Text = new b[]{new b(0.0f, 1.0f, 2.5f, 167772160, 0.0f, -1), new b(0.0f, 0.0f, 1.0f, 167772160, 0.0f, -1)};
        tokens = s.a(ShadowTokenCore.class, b[].class);
    }

    private ShadowTokenCore() {
    }

    public static b[] parse(String r1) {
        if (TextUtils.isEmpty(r1) == false) goto L7;
        return null;
    L7:
        return (b[]) s.c(r1, tokens);
    }
}
