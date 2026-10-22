package com.ss.android.lark.chat.export.ui.message.style;

import android.view.View;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class BubbleStyle {
    public static final BubbleStyle h = null;
    public int[] a;
    public WeakReference<View> b;
    public int c;
    public int d;
    public int e;
    public int f;
    public boolean g;

    public @interface ColorType {
        public static final int BLUE = 0;
        public static final int BLUE_BORDER = 8;
        public static final int BLUE_HEADER_WHITE_BORDER = 101;
        public static final int BLUE_WHITE_BORDER = 3;
        public static final int CARD_CELL_DEFAULT_NO_BORDER = 16;
        public static final int CARD_WHITE = 17;
        public static final int CARMINE_HEADER_WHITE_BORDER = 109;
        public static final int FLOAT_WHITE = 12;
        public static final int FLOAT_WHITE_AND_HEADER_CUSTOM = 13;
        public static final int FLOAT_WHITE_PIN = 19;
        public static final int GREEN_HEADER_WHITE_BORDER = 104;
        public static final int GREY = 1;
        public static final int GREY_BORDER = 7;
        public static final int GREY_WHITE_BORDER = 4;
        public static final int INDIGO_HEADER_WHITE_BORDER = 112;
        public static final int LIME_HEADER_WHITE_BORDER = 105;
        public static final int NEUTRAL_BORDER = 15;
        public static final int NEUTRAL_BORDER_PIN = 18;
        public static final int NEUTRAL_HEADER_WHITE_BORDER = 100;
        public static final int NEUTRAL_WHITE_BORDER = 14;
        public static final int NONE = 9;
        public static final int ORANGE_HEADER_WHITE_BORDER = 107;
        public static final int PURPLE_HEADER_WHITE_BORDER = 111;
        public static final int RED_HEADER_WHITE_BORDER = 108;
        public static final int SINGLE_URL_CARD = 113;
        public static final int SINGLE_URL_CARD_IN_THREAD_CHAT = 114;
        public static final int SINGLE_URL_CARD_WITH_THREAD_REPLY = 115;
        public static final int STATIC_WHITE = 10;
        public static final int STATIC_WHITE_AND_HEADER_CUSTOM = 11;
        public static final int TURQUOISE_HEADER_WHITE_BORDER = 103;
        public static final int VIOLET_HEADER_WHITE_BORDER = 110;
        public static final int WATHET_HEADER_WHITE_BORDER = 102;
        public static final int WHITE = 2;
        public static final int WHITE_AND_HEADER_CUSTOM = 6;
        public static final int YELLOW_HEADER_WHITE_BORDER = 106;
    }

    public final void b() {
        this.a = new int[]{0, 0, 0, 0};
    }

    static {
        h = new BubbleStyle();
    }

    public BubbleStyle() {
        this.c = -1;
        this.d = -1;
    }

    public static void a(int r3, View r4, int[] r5) {
        BubbleStyle r0 = h;
        r0.b = null;
        r0.e = 0;
        r0.f = 0;
        r0.b();
        r0.c = -1;
        r0.d = -1;
        r0.g = false;
        r0.e = r3;
        r0.b = new WeakReference(r4);
        if (r5.length == 4) goto L5;
        r0.b();
        return;
    L5:
        r0.a = r5;
    }
}
