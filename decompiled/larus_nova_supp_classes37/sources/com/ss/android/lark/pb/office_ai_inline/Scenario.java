package com.ss.android.lark.pb.office_ai_inline;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final enum Scenario extends Enum<Scenario> implements WireEnum {
    private static final /* synthetic */ Scenario[] $VALUES = null;
    public static final ProtoAdapter<Scenario> ADAPTER = null;
    public static final Scenario BASE = null;
    public static final Scenario BOARD = null;
    public static final Scenario CALENDAR = null;
    public static final Scenario DOC = null;
    public static final Scenario EMAIL = null;
    public static final Scenario GROUP_CHAT = null;
    public static final Scenario IM = null;
    public static final Scenario MEEGO = null;
    public static final Scenario OPEN_WEB_CONTAINER = null;
    public static final Scenario P2P_CHAT = null;
    public static final Scenario PDF_VIEW = null;
    public static final Scenario SEARCH = null;
    public static final Scenario SHEET = null;
    public static final Scenario SLIDES = null;
    public static final Scenario VC = null;
    public static final Scenario VOICE_INPUT = null;
    public static final Scenario WIKI_SPACE = null;
    private final int value;

    static {
        Scenario r0 = new Scenario("IM", 0, 0);
        IM = r0;
        Scenario r1 = new Scenario("DOC", 1, 1);
        DOC = r1;
        Scenario r3 = new Scenario("SHEET", 2, 2);
        SHEET = r3;
        Scenario r5 = new Scenario("BASE", 3, 3);
        BASE = r5;
        Scenario r7 = new Scenario("VC", 4, 4);
        VC = r7;
        Scenario r9 = new Scenario("CALENDAR", 5, 5);
        CALENDAR = r9;
        Scenario r11 = new Scenario("EMAIL", 6, 6);
        EMAIL = r11;
        Scenario r13 = new Scenario("MEEGO", 7, 7);
        MEEGO = r13;
        Scenario r15 = new Scenario("OPEN_WEB_CONTAINER", 8, 8);
        OPEN_WEB_CONTAINER = r15;
        Scenario r14 = new Scenario("SEARCH", 9, 9);
        SEARCH = r14;
        Scenario r12 = new Scenario("SLIDES", 10, 10);
        SLIDES = r12;
        Scenario r10 = new Scenario("GROUP_CHAT", 11, 11);
        GROUP_CHAT = r10;
        Scenario r8 = new Scenario("P2P_CHAT", 12, 12);
        P2P_CHAT = r8;
        Scenario r6 = new Scenario("BOARD", 13, 13);
        BOARD = r6;
        Scenario r4 = new Scenario("PDF_VIEW", 14, 14);
        PDF_VIEW = r4;
        Scenario r2 = new Scenario("WIKI_SPACE", 15, 15);
        WIKI_SPACE = r2;
        Scenario r16 = new Scenario("VOICE_INPUT", 16, 16);
        VOICE_INPUT = r16;
        $VALUES = new Scenario[]{r0, r1, r3, r5, r7, r9, r11, r13, r15, r14, r12, r10, r8, r6, r4, r2, r16};
        ADAPTER = ProtoAdapter.newEnumAdapter(Scenario.class);
    }

    public static Scenario[] values() {
        return (Scenario[]) $VALUES.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static Scenario fromValue(int r0) {
        switch(r0) {
            case 0: goto L38;
            case 1: goto L36;
            case 2: goto L34;
            case 3: goto L32;
            case 4: goto L30;
            case 5: goto L28;
            case 6: goto L26;
            case 7: goto L24;
            case 8: goto L22;
            case 9: goto L20;
            case 10: goto L18;
            case 11: goto L16;
            case 12: goto L14;
            case 13: goto L12;
            case 14: goto L10;
            case 15: goto L8;
            case 16: goto L6;
            default: goto L3;
        };
    L3:
        return null;
    L6:
        return VOICE_INPUT;
    L8:
        return WIKI_SPACE;
    L10:
        return PDF_VIEW;
    L12:
        return BOARD;
    L14:
        return P2P_CHAT;
    L16:
        return GROUP_CHAT;
    L18:
        return SLIDES;
    L20:
        return SEARCH;
    L22:
        return OPEN_WEB_CONTAINER;
    L24:
        return MEEGO;
    L26:
        return EMAIL;
    L28:
        return CALENDAR;
    L30:
        return VC;
    L32:
        return BASE;
    L34:
        return SHEET;
    L36:
        return DOC;
    L38:
        return IM;
    }

    public static Scenario valueOf(String r1) {
        return (Scenario) a.a(Scenario.class, r1);
    }

    private Scenario(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
