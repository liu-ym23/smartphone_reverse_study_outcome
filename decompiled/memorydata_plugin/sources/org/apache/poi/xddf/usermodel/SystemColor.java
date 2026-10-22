package org.apache.poi.xddf.usermodel;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;
import org.openxmlformats.schemas.drawingml.x2006.main.STSystemColorVal;

/* JADX INFO: loaded from: classes7.dex */
public final enum SystemColor extends Enum<SystemColor> {
    private static final /* synthetic */ SystemColor[] $VALUES = null;
    public static final SystemColor ACTIVE_BORDER = null;
    public static final SystemColor ACTIVE_CAPTION = null;
    public static final SystemColor APPLICATION_WORKSPACE = null;
    public static final SystemColor BACKGROUND = null;
    public static final SystemColor BUTTON_FACE = null;
    public static final SystemColor BUTTON_HIGHLIGHT = null;
    public static final SystemColor BUTTON_SHADOW = null;
    public static final SystemColor BUTTON_TEXT = null;
    public static final SystemColor CAPTION_TEXT = null;
    public static final SystemColor GRADIENT_ACTIVE_CAPTION = null;
    public static final SystemColor GRADIENT_INACTIVE_CAPTION = null;
    public static final SystemColor GRAY_TEXT = null;
    public static final SystemColor HIGHLIGHT = null;
    public static final SystemColor HIGHLIGHT_TEXT = null;
    public static final SystemColor HOT_LIGHT = null;
    public static final SystemColor INACTIVE_BORDER = null;
    public static final SystemColor INACTIVE_CAPTION = null;
    public static final SystemColor INACTIVE_CAPTION_TEXT = null;
    public static final SystemColor INFO_BACKGROUND = null;
    public static final SystemColor INFO_TEXT = null;
    public static final SystemColor MENU = null;
    public static final SystemColor MENU_BAR = null;
    public static final SystemColor MENU_HIGHLIGHT = null;
    public static final SystemColor MENU_TEXT = null;
    public static final SystemColor SCROLL_BAR = null;
    public static final SystemColor WINDOW = null;
    public static final SystemColor WINDOW_FRAME = null;
    public static final SystemColor WINDOW_TEXT = null;
    public static final SystemColor X_3D_DARK_SHADOW = null;
    public static final SystemColor X_3D_LIGHT = null;
    private static final HashMap<STSystemColorVal.Enum, SystemColor> reverse = null;
    final STSystemColorVal.Enum underlying;

    static {
        SystemColor r0 = new SystemColor("ACTIVE_BORDER", 0, STSystemColorVal.m);
        ACTIVE_BORDER = r0;
        SystemColor r1 = new SystemColor("ACTIVE_CAPTION", 1, STSystemColorVal.e);
        ACTIVE_CAPTION = r1;
        SystemColor r2 = new SystemColor("APPLICATION_WORKSPACE", 2, STSystemColorVal.o);
        APPLICATION_WORKSPACE = r2;
        SystemColor r4 = new SystemColor("BACKGROUND", 3, STSystemColorVal.d);
        BACKGROUND = r4;
        SystemColor r6 = new SystemColor("BUTTON_FACE", 4, STSystemColorVal.r);
        BUTTON_FACE = r6;
        SystemColor r8 = new SystemColor("BUTTON_HIGHLIGHT", 5, STSystemColorVal.w);
        BUTTON_HIGHLIGHT = r8;
        SystemColor r10 = new SystemColor("BUTTON_SHADOW", 6, STSystemColorVal.s);
        BUTTON_SHADOW = r10;
        SystemColor r12 = new SystemColor("BUTTON_TEXT", 7, STSystemColorVal.u);
        BUTTON_TEXT = r12;
        SystemColor r14 = new SystemColor("CAPTION_TEXT", 8, STSystemColorVal.l);
        CAPTION_TEXT = r14;
        SystemColor r13 = new SystemColor("GRADIENT_ACTIVE_CAPTION", 9, STSystemColorVal.C);
        GRADIENT_ACTIVE_CAPTION = r13;
        SystemColor r11 = new SystemColor("GRADIENT_INACTIVE_CAPTION", 10, STSystemColorVal.D);
        GRADIENT_INACTIVE_CAPTION = r11;
        SystemColor r9 = new SystemColor("GRAY_TEXT", 11, STSystemColorVal.t);
        GRAY_TEXT = r9;
        SystemColor r7 = new SystemColor("HIGHLIGHT", 12, STSystemColorVal.p);
        HIGHLIGHT = r7;
        SystemColor r5 = new SystemColor("HIGHLIGHT_TEXT", 13, STSystemColorVal.q);
        HIGHLIGHT_TEXT = r5;
        SystemColor r3 = new SystemColor("HOT_LIGHT", 14, STSystemColorVal.B);
        HOT_LIGHT = r3;
        SystemColor r15 = new SystemColor("INACTIVE_BORDER", 15, STSystemColorVal.n);
        INACTIVE_BORDER = r15;
        SystemColor r16 = new SystemColor("INACTIVE_CAPTION", 16, STSystemColorVal.f);
        INACTIVE_CAPTION = r16;
        SystemColor r17 = new SystemColor("INACTIVE_CAPTION_TEXT", 17, STSystemColorVal.v);
        INACTIVE_CAPTION_TEXT = r17;
        SystemColor r18 = new SystemColor("INFO_BACKGROUND", 18, STSystemColorVal.A);
        INFO_BACKGROUND = r18;
        SystemColor r19 = new SystemColor("INFO_TEXT", 19, STSystemColorVal.z);
        INFO_TEXT = r19;
        SystemColor r20 = new SystemColor("MENU", 20, STSystemColorVal.g);
        MENU = r20;
        SystemColor r21 = new SystemColor("MENU_BAR", 21, STSystemColorVal.F);
        MENU_BAR = r21;
        SystemColor r22 = new SystemColor("MENU_HIGHLIGHT", 22, STSystemColorVal.E);
        MENU_HIGHLIGHT = r22;
        SystemColor r23 = new SystemColor("MENU_TEXT", 23, STSystemColorVal.j);
        MENU_TEXT = r23;
        SystemColor r24 = new SystemColor("SCROLL_BAR", 24, STSystemColorVal.c);
        SCROLL_BAR = r24;
        SystemColor r25 = new SystemColor("WINDOW", 25, STSystemColorVal.h);
        WINDOW = r25;
        SystemColor r26 = new SystemColor("WINDOW_FRAME", 26, STSystemColorVal.i);
        WINDOW_FRAME = r26;
        SystemColor r27 = new SystemColor("WINDOW_TEXT", 27, STSystemColorVal.k);
        WINDOW_TEXT = r27;
        SystemColor r28 = new SystemColor("X_3D_DARK_SHADOW", 28, STSystemColorVal.x);
        X_3D_DARK_SHADOW = r28;
        SystemColor r29 = new SystemColor("X_3D_LIGHT", 29, STSystemColorVal.y);
        X_3D_LIGHT = r29;
        $VALUES = new SystemColor[]{r0, r1, r2, r4, r6, r8, r10, r12, r14, r13, r11, r9, r7, r5, r3, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29};
        reverse = new HashMap();
        SystemColor[] r30 = values();
        int r31 = r30.length;
        int r32 = 0;
    L3:
        if (r32 >= r31) goto L5;
        SystemColor r33 = r30[r32];
        reverse.put(r33.underlying, r33);
        r32 = r32 + 1;
        goto L3
    }

    private SystemColor(String r1, int r2, STSystemColorVal.Enum r3) {
        super(r1, r2);
        this.underlying = r3;
    }

    public static SystemColor valueOf(String r2) {
        return (SystemColor) ZeusTransformUtils.preCheckCast(Enum.valueOf(SystemColor.class, r2), SystemColor.class, "com.obric.memorydata.plugin");
    }

    static SystemColor valueOf(STSystemColorVal.Enum r2) {
        return (SystemColor) ZeusTransformUtils.preCheckCast(reverse.get(r2), SystemColor.class, "com.obric.memorydata.plugin");
    }

    public static SystemColor[] values() {
        return (SystemColor[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), SystemColor[].class, "com.obric.memorydata.plugin");
    }
}
