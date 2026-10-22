package com.larksuite.component.card.component.personlist;

import android.graphics.Color;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.UIHelper;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class g {
    public static final g a = null;
    public static final int b = 0;
    public static final int c = 0;
    public static final int d = 0;
    public static final int e = 0;
    public static final int f = 0;
    public static final int g = 0;
    public static final int h = 0;
    public static final int i = 0;
    public static final int j = 0;

    public g() {
    }

    static {
        a = new g();
        b = UIHelper.dp2px(16.0f);
        c = UIHelper.dp2px(12.0f);
        d = UIHelper.dp2px(4.0f);
        e = UIHelper.dp2px(8.0f);
        UIHelper.dp2px(4.0f);
        f = UIHelper.dp2px(32.0f);
        g = UIHelper.dp2px(12.0f);
        h = UIHelper.dp2px(10.0f);
        i = UIHelper.dp2px(6.0f);
        j = UIHelper.dp2px(3.0f);
    }

    public static int a(PersonListProps r5) {
        boolean r0 = false;
        Integer r1 = null;
        if (r5 == null) goto L15;
        PersonStyle r3 = r5.getStyles();
        if (r3 == null) goto L15;
        Integer r4 = Integer.valueOf(r3.getAvatarSpace());
        if (r4.intValue() <= 0) goto L9;
        boolean r6 = true;
    L10:
        if (r6 == true) goto L13;
        r4 = null;
    L13:
        if (r4 == null) goto L15;
        float r7 = zz7.b.j(UIHelper.dp2px(r4.intValue()));
    L29:
        return (int) r7;
    L9:
        r6 = false;
    L15:
        if (r5 == null) goto L27;
        PersonStyle r8 = r5.getStyles();
        if (r8 == null) goto L27;
        Integer r9 = Integer.valueOf(r8.getAvatarSize());
        int r10 = r9.intValue();
        if (r10 > 0) goto L21;
    L23:
        if (r0 == false) goto L25;
        r1 = r9;
    L25:
        if (r1 == null) goto L27;
        r1.intValue();
        r7 = zz7.b.j(j);
        goto L29
    L21:
        if (r10 >= 32.0f) goto L23;
        r0 = true;
    L27:
        r7 = zz7.b.j(i);
        goto L29
    }

    public static int b(PersonListProps r2) {
        if (r2 == null) goto L20;
        PersonStyle r3 = r2.getStyles();
        if (r3 == null) goto L20;
        String r4 = r3.getMoreColor();
        if (r4 == null) goto L20;
        if (r4.length() <= 0) goto L10;
        boolean r0 = true;
    L11:
        if (r0 == true) goto L14;
        r4 = null;
    L14:
        if (r4 == null) goto L20;
        return Color.parseColor(r4);
    L17:
        th = move-exception;
        Log.e("PersonListUtils", "parse more bg Color failed", th);
        goto L20
    L10:
        r0 = false;
    L20:
        return UIHelper.getColor(2131100556);
    }

    public static int c(PersonListProps r5) {
        boolean r0 = false;
        Integer r1 = null;
        if (r5 == null) goto L15;
        PersonStyle r3 = r5.getStyles();
        if (r3 == null) goto L15;
        Integer r4 = Integer.valueOf(r3.getMoreMaxCount());
        if (r4.intValue() <= 0) goto L9;
        boolean r6 = true;
    L10:
        if (r6 == true) goto L13;
        r4 = null;
    L13:
        if (r4 == null) goto L15;
        return r4.intValue();
    L9:
        r6 = false;
    L15:
        if (r5 == null) goto L27;
        PersonStyle r7 = r5.getStyles();
        if (r7 == null) goto L27;
        Integer r8 = Integer.valueOf(r7.getAvatarSize());
        int r9 = r8.intValue();
        if (r9 > 0) goto L21;
    L23:
        if (r0 == false) goto L25;
        r1 = r8;
    L25:
        if (r1 == null) goto L27;
        r1.intValue();
        return 99;
    L21:
        if (r9 >= 32.0f) goto L23;
        r0 = true;
    L27:
        return 999;
    }

    public static int d(PersonListProps r1) {
        if (r1 == null) goto L14;
        PersonStyle r2 = r1.getStyles();
        if (r2 == null) goto L14;
        Integer r3 = Integer.valueOf(r2.getAvatarSize());
        if (r3.intValue() <= 0) goto L8;
        boolean r0 = true;
    L9:
        if (r0 == true) goto L12;
        r3 = null;
    L12:
        if (r3 == null) goto L14;
        float r4 = zz7.b.j(UIHelper.dp2px(r3.intValue()));
    L16:
        return (int) r4;
    L8:
        r0 = false;
    L14:
        r4 = zz7.b.j(f);
        goto L16
    }

    public static int e(PersonListProps r5) {
        boolean r0 = false;
        Integer r1 = null;
        if (r5 == null) goto L16;
        PersonStyle r3 = r5.getStyles();
        if (r3 == null) goto L16;
        Integer r4 = Integer.valueOf(r3.getMoreTextSize());
        if (r4.intValue() <= 0) goto L9;
        boolean r6 = true;
    L10:
        if (r6 == true) goto L13;
        r4 = null;
    L13:
        if (r4 == null) goto L16;
        return UIHelper.dp2px(r4.intValue());
    L9:
        r6 = false;
    L16:
        if (r5 == null) goto L30;
        PersonStyle r7 = r5.getStyles();
        if (r7 == null) goto L30;
        Integer r8 = Integer.valueOf(r7.getAvatarSize());
        int r9 = r8.intValue();
        if (r9 > 0) goto L22;
    L24:
        if (r0 == false) goto L26;
        r1 = r8;
    L26:
        if (r1 == null) goto L30;
        r1.intValue();
        return h;
    L22:
        if (r9 >= 32.0f) goto L24;
        r0 = true;
    L30:
        return g;
    }

    public static String f(PersonInfo r1) {
        Intrinsics.checkNotNullParameter(r1, "person");
        String r2 = r1.getContent();
        if (r2 != null) goto L5;
    L8:
        boolean r0 = true;
    L9:
        if (r0 == false) goto L12;
        String r3 = UIHelper.getString(2131890317);
        Intrinsics.checkNotNull(r3);
        return r3;
    L12:
        return r2;
    L5:
        if (r2.length() == 0) goto L8;
        r0 = false;
        goto L9
    }

    public static int g(PersonListProps r3) {
        if (r3 == null) goto L20;
        PersonStyle r0 = r3.getStyles();
        if (r0 == null) goto L20;
        String r1 = r0.getNameColor();
        if (r1 == null) goto L20;
        if (r1.length() <= 0) goto L10;
        boolean r2 = true;
    L11:
        if (r2 == true) goto L14;
        r1 = null;
    L14:
        if (r1 == null) goto L20;
        return Color.parseColor(r1);
    L17:
        th = move-exception;
        Log.e("PersonListUtils", "parse name Color failed", th);
        goto L20
    L10:
        r2 = false;
    L20:
        if (i(r3) == false) goto L23;
        return UIHelper.getColor(2131106622);
    L23:
        return UIHelper.getColor(2131106614);
    }

    public static float h(PersonListProps r2) {
        if (r2 == null) goto L16;
        PersonStyle r0 = r2.getStyles();
        if (r0 == null) goto L16;
        Integer r1 = Integer.valueOf(r0.getNameSize());
        if (r1.intValue() <= 0) goto L8;
        boolean r3 = true;
    L9:
        if (r3 == true) goto L12;
        r1 = null;
    L12:
        if (r1 == null) goto L16;
        return UIHelper.dp2px(zz7.b.j(r1.intValue()));
    L8:
        r3 = false;
    L16:
        if (i(r2) == false) goto L18;
        int r4 = UIHelper.dp2px(zz7.b.j(16));
    L20:
        return r4;
    L18:
        r4 = UIHelper.dp2px(zz7.b.j(14));
        goto L20
    }

    public static boolean i(PersonListProps r3) {
        if (r3 != null) goto L5;
    L7:
        boolean r2 = false;
    L8:
        if (r2 == false) goto L17;
        if (r3 != null) goto L11;
    L13:
        boolean r4 = false;
    L14:
        if (r4 == false) goto L18;
        return true;
    L18:
        return false;
    L11:
        if (r3.getShowName() != true) goto L13;
        r4 = true;
        goto L14
    L17:
        return false;
    L5:
        if (r3.getShowAvatar() != true) goto L7;
        r2 = true;
        goto L8
    }
}
