package org.apache.poi.ss.usermodel;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes7.dex */
public final enum IndexedColors extends Enum<IndexedColors> {
    private static final /* synthetic */ IndexedColors[] $VALUES = null;
    public static final IndexedColors AQUA = null;
    public static final IndexedColors AUTOMATIC = null;
    public static final IndexedColors BLACK = null;
    public static final IndexedColors BLACK1 = null;
    public static final IndexedColors BLUE = null;
    public static final IndexedColors BLUE1 = null;
    public static final IndexedColors BLUE_GREY = null;
    public static final IndexedColors BRIGHT_GREEN = null;
    public static final IndexedColors BRIGHT_GREEN1 = null;
    public static final IndexedColors BROWN = null;
    public static final IndexedColors CORAL = null;
    public static final IndexedColors CORNFLOWER_BLUE = null;
    public static final IndexedColors DARK_BLUE = null;
    public static final IndexedColors DARK_GREEN = null;
    public static final IndexedColors DARK_RED = null;
    public static final IndexedColors DARK_TEAL = null;
    public static final IndexedColors DARK_YELLOW = null;
    public static final IndexedColors GOLD = null;
    public static final IndexedColors GREEN = null;
    public static final IndexedColors GREY_25_PERCENT = null;
    public static final IndexedColors GREY_40_PERCENT = null;
    public static final IndexedColors GREY_50_PERCENT = null;
    public static final IndexedColors GREY_80_PERCENT = null;
    public static final IndexedColors INDIGO = null;
    public static final IndexedColors LAVENDER = null;
    public static final IndexedColors LEMON_CHIFFON = null;
    public static final IndexedColors LIGHT_BLUE = null;
    public static final IndexedColors LIGHT_CORNFLOWER_BLUE = null;
    public static final IndexedColors LIGHT_GREEN = null;
    public static final IndexedColors LIGHT_ORANGE = null;
    public static final IndexedColors LIGHT_TURQUOISE = null;
    public static final IndexedColors LIGHT_TURQUOISE1 = null;
    public static final IndexedColors LIGHT_YELLOW = null;
    public static final IndexedColors LIME = null;
    public static final IndexedColors MAROON = null;
    public static final IndexedColors OLIVE_GREEN = null;
    public static final IndexedColors ORANGE = null;
    public static final IndexedColors ORCHID = null;
    public static final IndexedColors PALE_BLUE = null;
    public static final IndexedColors PINK = null;
    public static final IndexedColors PINK1 = null;
    public static final IndexedColors PLUM = null;
    public static final IndexedColors RED = null;
    public static final IndexedColors RED1 = null;
    public static final IndexedColors ROSE = null;
    public static final IndexedColors ROYAL_BLUE = null;
    public static final IndexedColors SEA_GREEN = null;
    public static final IndexedColors SKY_BLUE = null;
    public static final IndexedColors TAN = null;
    public static final IndexedColors TEAL = null;
    public static final IndexedColors TURQUOISE = null;
    public static final IndexedColors TURQUOISE1 = null;
    public static final IndexedColors VIOLET = null;
    public static final IndexedColors WHITE = null;
    public static final IndexedColors WHITE1 = null;
    public static final IndexedColors YELLOW = null;
    public static final IndexedColors YELLOW1 = null;
    private static final IndexedColors[] _values = null;
    public final short index;

    static {
        int r2 = 0;
        BLACK1 = new IndexedColors("BLACK1", 0, 0);
        WHITE1 = new IndexedColors("WHITE1", 1, 1);
        RED1 = new IndexedColors("RED1", 2, 2);
        BRIGHT_GREEN1 = new IndexedColors("BRIGHT_GREEN1", 3, 3);
        BLUE1 = new IndexedColors("BLUE1", 4, 4);
        YELLOW1 = new IndexedColors("YELLOW1", 5, 5);
        PINK1 = new IndexedColors("PINK1", 6, 6);
        TURQUOISE1 = new IndexedColors("TURQUOISE1", 7, 7);
        BLACK = new IndexedColors("BLACK", 8, 8);
        WHITE = new IndexedColors("WHITE", 9, 9);
        RED = new IndexedColors("RED", 10, 10);
        BRIGHT_GREEN = new IndexedColors("BRIGHT_GREEN", 11, 11);
        BLUE = new IndexedColors("BLUE", 12, 12);
        YELLOW = new IndexedColors("YELLOW", 13, 13);
        PINK = new IndexedColors("PINK", 14, 14);
        TURQUOISE = new IndexedColors("TURQUOISE", 15, 15);
        DARK_RED = new IndexedColors("DARK_RED", 16, 16);
        GREEN = new IndexedColors("GREEN", 17, 17);
        DARK_BLUE = new IndexedColors("DARK_BLUE", 18, 18);
        DARK_YELLOW = new IndexedColors("DARK_YELLOW", 19, 19);
        VIOLET = new IndexedColors("VIOLET", 20, 20);
        TEAL = new IndexedColors("TEAL", 21, 21);
        GREY_25_PERCENT = new IndexedColors("GREY_25_PERCENT", 22, 22);
        GREY_50_PERCENT = new IndexedColors("GREY_50_PERCENT", 23, 23);
        CORNFLOWER_BLUE = new IndexedColors("CORNFLOWER_BLUE", 24, 24);
        MAROON = new IndexedColors("MAROON", 25, 25);
        LEMON_CHIFFON = new IndexedColors("LEMON_CHIFFON", 26, 26);
        LIGHT_TURQUOISE1 = new IndexedColors("LIGHT_TURQUOISE1", 27, 27);
        ORCHID = new IndexedColors("ORCHID", 28, 28);
        CORAL = new IndexedColors("CORAL", 29, 29);
        ROYAL_BLUE = new IndexedColors("ROYAL_BLUE", 30, 30);
        LIGHT_CORNFLOWER_BLUE = new IndexedColors("LIGHT_CORNFLOWER_BLUE", 31, 31);
        SKY_BLUE = new IndexedColors("SKY_BLUE", 32, 40);
        LIGHT_TURQUOISE = new IndexedColors("LIGHT_TURQUOISE", 33, 41);
        LIGHT_GREEN = new IndexedColors("LIGHT_GREEN", 34, 42);
        LIGHT_YELLOW = new IndexedColors("LIGHT_YELLOW", 35, 43);
        PALE_BLUE = new IndexedColors("PALE_BLUE", 36, 44);
        ROSE = new IndexedColors("ROSE", 37, 45);
        LAVENDER = new IndexedColors("LAVENDER", 38, 46);
        TAN = new IndexedColors("TAN", 39, 47);
        LIGHT_BLUE = new IndexedColors("LIGHT_BLUE", 40, 48);
        AQUA = new IndexedColors("AQUA", 41, 49);
        LIME = new IndexedColors("LIME", 42, 50);
        GOLD = new IndexedColors("GOLD", 43, 51);
        LIGHT_ORANGE = new IndexedColors("LIGHT_ORANGE", 44, 52);
        ORANGE = new IndexedColors("ORANGE", 45, 53);
        BLUE_GREY = new IndexedColors("BLUE_GREY", 46, 54);
        GREY_40_PERCENT = new IndexedColors("GREY_40_PERCENT", 47, 55);
        DARK_TEAL = new IndexedColors("DARK_TEAL", 48, 56);
        SEA_GREEN = new IndexedColors("SEA_GREEN", 49, 57);
        DARK_GREEN = new IndexedColors("DARK_GREEN", 50, 58);
        OLIVE_GREEN = new IndexedColors("OLIVE_GREEN", 51, 59);
        BROWN = new IndexedColors("BROWN", 52, 60);
        PLUM = new IndexedColors("PLUM", 53, 61);
        INDIGO = new IndexedColors("INDIGO", 54, 62);
        GREY_80_PERCENT = new IndexedColors("GREY_80_PERCENT", 55, 63);
        AUTOMATIC = new IndexedColors("AUTOMATIC", 56, 64);
        $VALUES = new IndexedColors[]{BLACK1, WHITE1, RED1, BRIGHT_GREEN1, BLUE1, YELLOW1, PINK1, TURQUOISE1, BLACK, WHITE, RED, BRIGHT_GREEN, BLUE, YELLOW, PINK, TURQUOISE, DARK_RED, GREEN, DARK_BLUE, DARK_YELLOW, VIOLET, TEAL, GREY_25_PERCENT, GREY_50_PERCENT, CORNFLOWER_BLUE, MAROON, LEMON_CHIFFON, LIGHT_TURQUOISE1, ORCHID, CORAL, ROYAL_BLUE, LIGHT_CORNFLOWER_BLUE, SKY_BLUE, LIGHT_TURQUOISE, LIGHT_GREEN, LIGHT_YELLOW, PALE_BLUE, ROSE, LAVENDER, TAN, LIGHT_BLUE, AQUA, LIME, GOLD, LIGHT_ORANGE, ORANGE, BLUE_GREY, GREY_40_PERCENT, DARK_TEAL, SEA_GREEN, DARK_GREEN, OLIVE_GREEN, BROWN, PLUM, INDIGO, GREY_80_PERCENT, AUTOMATIC};
        _values = new IndexedColors[65];
        IndexedColors[] r0 = values();
        int r1 = r0.length;
    L3:
        if (r2 >= r1) goto L5;
        IndexedColors r3 = r0[r2];
        _values[r3.index] = r3;
        r2 = r2 + 1;
        goto L3
    }

    private IndexedColors(String r1, int r2, int r3) {
        super(r1, r2);
        this.index = (short) r3;
    }

    public static IndexedColors fromInt(int r3) {
        if (r3 < 0) goto L12;
        IndexedColors[] r1 = _values;
        if (r3 >= r1.length) goto L12;
        IndexedColors r2 = r1[r3];
        if (r2 == null) goto L10;
        return r2;
    L10:
        throw new IllegalArgumentException("Illegal IndexedColor index: " + r3);
    L12:
        throw new IllegalArgumentException("Illegal IndexedColor index: " + r3);
    }

    public static IndexedColors valueOf(String r2) {
        return (IndexedColors) ZeusTransformUtils.preCheckCast(Enum.valueOf(IndexedColors.class, r2), IndexedColors.class, "com.obric.memorydata.plugin");
    }

    public static IndexedColors[] values() {
        return (IndexedColors[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), IndexedColors[].class, "com.obric.memorydata.plugin");
    }

    public short getIndex() {
        return this.index;
    }
}
