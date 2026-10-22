package com.obric.assistant.window.materials;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\f\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/obric/assistant/window/materials/MaterialSceneType;", "", "<init>", "(Ljava/lang/String;I)V", "INPUT", "ACTION_BAR", "ACTION_BAR_SELECTED", "ACTION_BAR_TASK_SKILL", "ACTION_BAR_TASK_SKILL_SELECTED", "BOTTOM_MENU", "WINDOW_BG", "WINDOW_BG_WITH_BOTTOM_RADIUS", "FLOATING_BG", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum MaterialSceneType extends Enum<MaterialSceneType> {
    public static final MaterialSceneType ACTION_BAR = null;
    public static final MaterialSceneType ACTION_BAR_SELECTED = null;
    public static final MaterialSceneType ACTION_BAR_TASK_SKILL = null;
    public static final MaterialSceneType ACTION_BAR_TASK_SKILL_SELECTED = null;
    public static final MaterialSceneType BOTTOM_MENU = null;
    public static final MaterialSceneType FLOATING_BG = null;
    public static final MaterialSceneType INPUT = null;
    public static final MaterialSceneType WINDOW_BG = null;
    public static final MaterialSceneType WINDOW_BG_WITH_BOTTOM_RADIUS = null;
    public static final /* synthetic */ MaterialSceneType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<MaterialSceneType> getEntries() {
        return b;
    }

    static {
        MaterialSceneType r0 = new MaterialSceneType("INPUT", 0);
        INPUT = r0;
        MaterialSceneType r1 = new MaterialSceneType("ACTION_BAR", 1);
        ACTION_BAR = r1;
        MaterialSceneType r3 = new MaterialSceneType("ACTION_BAR_SELECTED", 2);
        ACTION_BAR_SELECTED = r3;
        MaterialSceneType r5 = new MaterialSceneType("ACTION_BAR_TASK_SKILL", 3);
        ACTION_BAR_TASK_SKILL = r5;
        MaterialSceneType r7 = new MaterialSceneType("ACTION_BAR_TASK_SKILL_SELECTED", 4);
        ACTION_BAR_TASK_SKILL_SELECTED = r7;
        MaterialSceneType r9 = new MaterialSceneType("BOTTOM_MENU", 5);
        BOTTOM_MENU = r9;
        MaterialSceneType r11 = new MaterialSceneType("WINDOW_BG", 6);
        WINDOW_BG = r11;
        MaterialSceneType r13 = new MaterialSceneType("WINDOW_BG_WITH_BOTTOM_RADIUS", 7);
        WINDOW_BG_WITH_BOTTOM_RADIUS = r13;
        MaterialSceneType r15 = new MaterialSceneType("FLOATING_BG", 8);
        FLOATING_BG = r15;
        MaterialSceneType[] r14 = {r0, r1, r3, r5, r7, r9, r11, r13, r15};
        a = r14;
        b = EnumEntriesKt.enumEntries(r14);
    }

    public static MaterialSceneType[] values() {
        return (MaterialSceneType[]) a.clone();
    }

    public static MaterialSceneType valueOf(String r1) {
        return (MaterialSceneType) a.a(MaterialSceneType.class, r1);
    }

    public MaterialSceneType(String r1, int r2) {
        super(r1, r2);
    }
}
