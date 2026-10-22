package com.lynx.textra;

import android.content.Context;
import android.provider.Settings;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.obric.aiagent.assistant.idl.bean.MessageContentType;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
class XiaomiFontCaps implements PlatformFontCaps {
    public static int[] MIUI_WGHT = null;
    public static final int[][] NORAML_RULES = null;
    public static int[] WEIGHT_ARRAY = null;
    public static final int WEIGHT_IDX_BOLD = 8;
    public static final int WEIGHT_IDX_DEMI_BOLD = 6;
    public static final int WEIGHT_IDX_EXTRA_LIGHT = 1;
    public static final int WEIGHT_IDX_HEAVY = 9;
    public static final int WEIGHT_IDX_LIGHT = 2;
    public static final int WEIGHT_IDX_MEDIUM = 5;
    public static final int WEIGHT_IDX_NORMAL = 3;
    public static final int WEIGHT_IDX_REGULAR = 4;
    public static final int WEIGHT_IDX_SEMI_BOLD = 7;
    public static final int WEIGHT_IDX_THIN = 0;
    private final Context mContext;
    public int mFontScale;
    private Map<Integer, Integer> mUserToMIUI;

    @Override // com.lynx.textra.PlatformFontCaps
    public final /* synthetic */ short clamp(int r1) {
        return PlatformFontCaps.CC.$default$clamp(this, r1);
    }

    @Override // com.lynx.textra.PlatformFontCaps
    public String defaultFamilyName() {
        return PlatformFontCaps.DEFAULT_FAMILY_NAME;
    }

    static {
        NORAML_RULES = new int[][]{new int[]{0, 5}, new int[]{0, 5}, new int[]{1, 6}, new int[]{2, 6}, new int[]{2, 7}, new int[]{3, 8}, new int[]{4, 8}, new int[]{5, 9}, new int[]{6, 9}, new int[]{7, 9}};
        WEIGHT_ARRAY = new int[]{100, 200, 300, 350, 400, 500, 700, MessageContentType.OTHER, 900, 950};
        MIUI_WGHT = new int[]{150, 200, 250, 305, 330, 380, 450, 520, 630, 700};
    }

    public XiaomiFontCaps(Context r7) {
        this.mUserToMIUI = new LinkedHashMap();
        this.mFontScale = 50;
        this.mContext = r7;
        String r1 = Settings.Global.getString(r7.getContentResolver(), "key_miui_font_var_weight");
        int r2 = 0;
        if (r1 == null) goto L11;
        String[] r3 = r1.split(",");
        if (r3.length == MIUI_WGHT.length) goto L7;
        return;
    L7:
        int r4 = 0;
    L9:
        if (r4 >= r3.length) goto L11;
        MIUI_WGHT[r4] = CastIntegerProtector.parseInt(r3[r4]);
        r4 = r4 + 1;
    L11:
        int[] r5 = WEIGHT_ARRAY;
        if (r2 >= r5.length) goto L14;
        this.mUserToMIUI.put(Integer.valueOf(r5[r2]), Integer.valueOf(MIUI_WGHT[r2]));
        r2 = r2 + 1;
        goto L11
    L14:
        this.mFontScale = Settings.System.getInt(r7.getContentResolver(), "key_miui_font_weight_scale", 50);
    }

    private int ToUserWeight(int r7) {
        Iterator<Map.Entry<Integer, Integer>> r0 = this.mUserToMIUI.entrySet().iterator();
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
    public short adjust(short r1) {
        return clamp(ToUserWeight(getWght(r1)));
    }

    public int getWeightIdx(int r4) {
        if (r4 < WEIGHT_ARRAY[9]) goto L5;
        return 9;
    L5:
        int r0 = 0;
    L6:
        int[] r1 = WEIGHT_ARRAY;
        if (r0 >= r1.length) goto L12;
        if (r4 <= r1[r0]) goto L10;
        r0 = r0 + 1;
        goto L6
    L10:
        return r0;
    L12:
        return 4;
    }

    public int getWght(int r7) {
        int r8 = getWeightIdx(r7);
        int[] r0 = MIUI_WGHT;
        int[] r1 = NORAML_RULES[r8];
        int r2 = r0[r1[0]];
        int r9 = r0[r8];
        int r3 = r0[r1[1]];
        int r4 = this.mFontScale;
        if (r4 >= 50) goto L5;
        float r5 = r4 / 50.0f;
        float r6 = ((1.0f - r5) * r2) + (r5 * r9);
    L7:
        return (int) r6;
    L5:
        float r10 = (r4 - 50.0f) / 50.0f;
        r6 = ((1.0f - r10) * r9) + (r10 * r3);
        goto L7
    }
}
