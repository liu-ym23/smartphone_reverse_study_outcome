package com.larksuite.component.card.utils;

import com.larksuite.component.ui.display.manager.zoom.LarkFont;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class f {

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[LarkFont.values().length];
            r0[LarkFont.TITLE0.ordinal()] = 1;     // Catch: NoSuchFieldError -> L18
        L37:
            r0[LarkFont.TITLE1.ordinal()] = 2;     // Catch: NoSuchFieldError -> L19
        L55:
            r0[LarkFont.TITLE2.ordinal()] = 3;     // Catch: NoSuchFieldError -> L20
        L41:
            r0[LarkFont.TITLE3.ordinal()] = 4;     // Catch: NoSuchFieldError -> L21
        L45:
            r0[LarkFont.TITLE4.ordinal()] = 5;     // Catch: NoSuchFieldError -> L22
        L31:
            r0[LarkFont.HEADLINE.ordinal()] = 6;     // Catch: NoSuchFieldError -> L23
        L47:
            r0[LarkFont.BODY0.ordinal()] = 7;     // Catch: NoSuchFieldError -> L24
        L49:
            r0[LarkFont.BODY1.ordinal()] = 8;     // Catch: NoSuchFieldError -> L25
        L39:
            r0[LarkFont.BODY2.ordinal()] = 9;     // Catch: NoSuchFieldError -> L26
        L43:
            r0[LarkFont.CAPTION0.ordinal()] = 10;     // Catch: NoSuchFieldError -> L27
        L33:
            r0[LarkFont.CAPTION1.ordinal()] = 11;     // Catch: NoSuchFieldError -> L28
        L35:
            r0[LarkFont.CAPTION2.ordinal()] = 12;     // Catch: NoSuchFieldError -> L29
        L53:
            r0[LarkFont.CAPTION3.ordinal()] = 13;     // Catch: NoSuchFieldError -> L30
        L16:
            a = r0;
        }
    }

    static {
    }

    @JvmStatic
    public static final String a(LarkFont r1) {
        Intrinsics.checkNotNullParameter(r1, "font");
        switch(a.a[r1.ordinal()]) {
            case 1: goto L18;
            case 2: goto L17;
            case 3: goto L16;
            case 4: goto L15;
            case 5: goto L14;
            case 6: goto L13;
            case 7: goto L12;
            case 8: goto L11;
            case 9: goto L10;
            case 10: goto L9;
            case 11: goto L8;
            case 12: goto L7;
            case 13: goto L6;
            default: goto L5;
        };
    L6:
        return "caption3";
    L7:
        return "caption2";
    L8:
        return "caption1";
    L9:
        return "caption0";
    L10:
        return "body2";
    L11:
        return "body1";
    L12:
        return "body0";
    L13:
        return "headline";
    L14:
        return "title4";
    L15:
        return "title3";
    L16:
        return "title2";
    L17:
        return "title1";
    L18:
        return "title0";
    L5:
        throw new NoWhenBranchMatchedException();
    }
}
