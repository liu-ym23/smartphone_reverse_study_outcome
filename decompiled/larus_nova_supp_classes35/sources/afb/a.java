package afb;

import com.ss.android.lark.feed.app.entity.IBadgeable;
import com.ss.android.lark.feed.shared.fg.c;
import com.ss.android.lark.utils.UIHelper;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a {
    public static final ThreadLocal<tdb.a> a = null;

    static {
        a = new ThreadLocal();
    }

    public static tdb.a a(IBadgeable r10, boolean r11) {
        boolean r0 = b.a;
        ThreadLocal<tdb.a> r1 = a;
        tdb.a r2 = r1.get();
        if (r2 != null) goto L5;
        r2 = new tdb.a();
        r1.set(r2);
    L5:
        int r3 = 0;
        r2.b = 0;
        r2.a = 0;
        r2.c = 8;
        r2.d = null;
        if (r10.getBadgeCount() != 0) goto L8;
        r2.c = 8;
    L68:
        return r2;
    L8:
        r2.c = 0;
        boolean r4 = r10.isRemind();
        boolean r5 = r10.isRedBadge();
        int r6 = Math.abs(r10.getBadgeCount());
        if (c.a.isEnable("lark.im.group_auto_mute_gray_config") == false) goto L15;
        if (r5 == false) goto L13;
        if (r4 == false) goto L13;
        r4 = true;
    L13:
        r4 = false;
    L15:
        if (r4 == true) goto L20;
        if (r11 == true) goto L18;
        if (r0 == false) goto L18;
    L19:
        int r7 = 0;
    L26:
        if (r11 == false) goto L29;
        if (r4 == false) goto L33;
        r3 = 1;
    L33:
        int r8 = (r7 + (r3 * 10)) + 100;
        String r12 = String.valueOf(Math.abs(r10.getBadgeCount()));
        if (r8 != 0) goto L36;
        r2.a = 2131231798;
        goto L68
    L36:
        if (r8 == 1) goto L66;
        if (r8 == 2) goto L65;
        if (r8 != 3) goto L40;
        r2.a = 2131231796;
        goto L68
    L40:
        switch(r8) {
            case 11: goto L48;
            case 12: goto L47;
            case 13: goto L46;
            default: goto L41;
        };
    L41:
        switch(r8) {
            case 20: goto L52;
            case 21: goto L51;
            case 22: goto L50;
            case 23: goto L49;
            default: goto L42;
        };
    L42:
        switch(r8) {
            case 100: goto L56;
            case 101: goto L55;
            case 102: goto L54;
            case 103: goto L53;
            default: goto L43;
        };
    L43:
        switch(r8) {
            case 111: goto L59;
            case 112: goto L58;
            case 113: goto L57;
            default: goto L44;
        };
    L44:
        switch(r8) {
            case 120: goto L63;
            case 121: goto L62;
            case 122: goto L61;
            case 123: goto L60;
            default: goto L68;
        };
    L60:
        r2.a = 2131231803;
        goto L68
    L61:
        r2.d = r12;
        r2.a = 2131231807;
        r2.b = -1;
        goto L68
    L62:
        r2.d = r12;
        r2.a = 2131231809;
        r2.b = -1;
        goto L68
    L63:
        r2.a = 2131231805;
        goto L68
    L57:
        r2.a = 2131231811;
        goto L68
    L58:
        r2.d = r12;
        r2.a = 2131231813;
        r2.b = UIHelper.getColor(2131103493);
        goto L68
    L59:
        r2.d = r12;
        r2.a = 2131231815;
        r2.b = UIHelper.getColor(2131103493);
        goto L68
    L53:
        r2.a = 2131231795;
        goto L68
    L54:
        r2.d = r12;
        r2.a = 2131231799;
        r2.b = -1;
        goto L68
    L55:
        r2.d = r12;
        r2.a = 2131231801;
        r2.b = -1;
        goto L68
    L56:
        r2.a = 2131231797;
        goto L68
    L49:
        r2.a = 2131231804;
        goto L68
    L50:
        r2.d = r12;
        r2.a = 2131231808;
        r2.b = -1;
        goto L68
    L51:
        r2.d = r12;
        r2.a = 2131231810;
        r2.b = -1;
        goto L68
    L52:
        r2.a = 2131231806;
        goto L68
    L46:
        r2.a = 2131231812;
        goto L68
    L47:
        r2.d = r12;
        r2.a = 2131231814;
        r2.b = UIHelper.getColor(2131103493);
        goto L68
    L48:
        r2.d = r12;
        r2.a = 2131231816;
        r2.b = UIHelper.getColor(2131103493);
        goto L68
    L65:
        r2.d = r12;
        r2.a = 2131231800;
        r2.b = -1;
        goto L68
    L66:
        r2.d = r12;
        r2.a = 2131231802;
        r2.b = -1;
        goto L68
    L29:
        if (r4 == true) goto L32;
        if (r0 == false) goto L33;
    L32:
        r3 = 2;
    L18:
        if (r11 == true) goto L19;
    L20:
        if (r6 >= 10) goto L23;
        r7 = 1;
        goto L26
    L23:
        if (r6 >= 1000) goto L25;
        r7 = 2;
        goto L26
    L25:
        r7 = 3;
        goto L26
    }
}
