package com.larksuite.component.card.utils;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class d {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static int a(String r7, Context r8) {
        Intrinsics.checkNotNullParameter(r8, "context");
        int r0 = 0;
        if (r7 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L12;
        return 0;
    L12:
        if (StringsKt.endsWith$default(r7, "colorful", false, 2, null) == false) goto L75;
        int r2 = edb.d.a;
        if (r7 != null) goto L16;
    L74:
        String r3 = r7;
        if (r0 == 0) goto L97;
        return r0;
    L97:
        return r8.getResources().getIdentifier("ud_icon_" + StringsKt.replace$default(r3, "-", "_", false, 4, null), "drawable", r8.getPackageName());
    L16:
        switch(r7.hashCode()) {
            case -1866560241: goto L71;
            case -1693849154: goto L67;
            case -1385021371: goto L63;
            case -593312209: goto L59;
            case -532962475: goto L55;
            case -23381368: goto L51;
            case -17791761: goto L47;
            case 33345732: goto L43;
            case 320841946: goto L39;
            case 1073675035: goto L35;
            case 1210408388: goto L31;
            case 1441268064: goto L27;
            case 1585297171: goto L23;
            case 1966089654: goto L19;
            default: goto L74;
        };
    L19:
        if (r7.equals("approval_colorful") == false) goto L74;
        r0 = 2131253652;
        goto L74
    L23:
        if (r7.equals("todo_colorful") == false) goto L74;
        r0 = 2131256015;
        goto L74
    L27:
        if (r7.equals("calendar-disable_colorful") == false) goto L74;
        r0 = 2131253978;
        goto L74
    L31:
        if (r7.equals("file-form_colorful") == false) goto L74;
        r0 = kac.a.b(2131254460);
        goto L74
    L35:
        if (r7.equals("calendar_colorful") == false) goto L74;
        r0 = 2131253976;
        goto L74
    L39:
        if (r7.equals("hirelogo_colorful") == false) goto L74;
        r0 = 2131254873;
        goto L74
    L43:
        if (r7.equals("meego_colorful") == false) goto L74;
        r0 = 2131255088;
        goto L74
    L47:
        if (r7.equals("vote_colorful") == false) goto L74;
        r0 = 2131256171;
        goto L74
    L51:
        if (r7.equals("file-lark-minutes_colorful") == false) goto L74;
        r0 = kac.a.b(2131254480);
        goto L74
    L55:
        if (r7.equals("apaas_colorful") == false) goto L74;
        r0 = 2131253638;
        goto L74
    L59:
        if (r7.equals("lark-logo_colorful") == false) goto L74;
        r0 = 2131254979;
        goto L74
    L63:
        if (r7.equals("myai_colorful") == false) goto L74;
        r0 = 2131255192;
        goto L74
    L67:
        if (r7.equals("larkcommunity_colorful") == false) goto L74;
        r0 = 2131254982;
        goto L74
    L71:
        if (r7.equals("wiki-bitable_colorful") == false) goto L74;
        r0 = kac.a.b(2131256218);
        goto L74
    L75:
        int r4 = r7.hashCode();
        if (r4 == (-1063346260)) goto L91;
        if (r4 == (-804307457)) goto L87;
        if (r4 == 17629049) goto L83;
    L94:
        r0 = edb.a.a(r7);
        goto L74
    L83:
        if (r7.equals("error_filled") == false) goto L94;
        r7 = "close_filled";
        goto L94
    L87:
        if (r7.equals("succeed_filled") == false) goto L94;
        r7 = "yes_filled";
        goto L94
    L91:
        if (r7.equals("icon_video_filled") == false) goto L94;
        r7 = "video_filled";
        goto L94
    L5:
        if (r7.length() == 0) goto L8;
        r1 = false;
        goto L9
    }
}
