package oo8;

import com.larus.common.apphost.AppHost;
import com.larus.platform.service.z2;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class b {
    public static final Calendar a = null;
    public static final Calendar b = null;
    public static final SimpleDateFormat c = null;
    public static final SimpleDateFormat d = null;
    public static final SimpleDateFormat e = null;
    public static final SimpleDateFormat f = null;
    public static final SimpleDateFormat g = null;
    public static final SimpleDateFormat h = null;

    static {
        a = Calendar.getInstance();
        b = Calendar.getInstance();
        AppHost.Companion r0 = AppHost.a;
        if (r0.isPlugin() == false) goto L5;
        SimpleDateFormat r1 = new SimpleDateFormat("yyyy/MM/dd HH:mm");
    L6:
        c = r1;
        boolean r9 = false;
        if (r0.isPlugin() == false) goto L9;
        SimpleDateFormat r2 = new SimpleDateFormat("yyyy/M/d HH:mm");
    L23:
        d = r2;
        if (r0.isPlugin() == false) goto L26;
        SimpleDateFormat r3 = new SimpleDateFormat("MM/dd HH:mm");
    L27:
        e = r3;
        if (r0.isPlugin() == false) goto L30;
        SimpleDateFormat r4 = new SimpleDateFormat("M/d HH:mm");
    L44:
        f = r4;
        g = new SimpleDateFormat(b(r0.getApplication().getString(2131907425)) + " HH:mm");
        h = new SimpleDateFormat("HH:mm");
        return;
    L30:
        String r5 = r0.getApplication().getString(2131907418);
        String r6 = r0.getApplication().getString(2131907415);
        String r7 = b(r5);
        String r8 = b(r6);
        String[] r10 = {r5, r6};
        int r11 = 0;
    L31:
        if (r11 >= 2) goto L39;
        if (r10[r11].length() != 1) goto L35;
        boolean r12 = true;
    L36:
        if (r12 == false) goto L40;
        r11 = r11 + 1;
    L40:
        if (r9 == false) goto L42;
        String r13 = "M" + r7 + 'd' + r8 + " HH:mm";
    L43:
        r4 = new SimpleDateFormat(r13);
        goto L44
    L42:
        r13 = "M " + r7 + " d " + r8 + " HH:mm";
        goto L43
    L35:
        r12 = false;
        goto L36
    L39:
        r9 = true;
        goto L40
    L26:
        r3 = new SimpleDateFormat("MM " + b(r0.getApplication().getString(2131907418)) + " dd " + b(r0.getApplication().getString(2131907415)) + " HH:mm");
        goto L27
    L9:
        String r14 = r0.getApplication().getString(2131907424);
        String r15 = r0.getApplication().getString(2131907418);
        String r16 = r0.getApplication().getString(2131907415);
        String r17 = b(r14);
        String r18 = b(r15);
        String r19 = b(r16);
        String[] r20 = {r14, r15, r16};
        int r21 = 0;
    L10:
        if (r21 >= 3) goto L18;
        if (r20[r21].length() != 1) goto L14;
        boolean r22 = true;
    L15:
        if (r22 == false) goto L16;
        r21 = r21 + 1;
        goto L10
    L16:
        boolean r23 = false;
    L19:
        if (r23 == false) goto L21;
        String r24 = "yyyy" + r17 + 'M' + r18 + 'd' + r19 + " HH:mm";
    L22:
        r2 = new SimpleDateFormat(r24);
        goto L23
    L21:
        r24 = "yyyy " + r17 + " M " + r18 + " d " + r19 + " HH:mm";
        goto L22
    L14:
        r22 = false;
        goto L15
    L18:
        r23 = true;
        goto L19
    L5:
        r1 = new SimpleDateFormat("yyyy" + b(r0.getApplication().getString(2131907424)) + " MM " + b(r0.getApplication().getString(2131907418)) + " dd " + b(r0.getApplication().getString(2131907415)) + " HH:mm");
        goto L6
    }

    public static String b(String r8) {
        return "'" + StringsKt.replace$default(r8, "'", "''", false, 4, null) + '\'';
    }

    public static String a(long r6, boolean r8) {
        Calendar r0 = a;
        r0.setTimeInMillis(System.currentTimeMillis());
        Calendar r1 = b;
        r1.setTimeInMillis(r6);
        boolean r2 = z2.a.enableChatTimestampNoLeadingZero();
        if (r0.get(1) == r1.get(1)) goto L9;
        if (r2 == false) goto L6;
        SimpleDateFormat r9 = d;
    L8:
        return r9.format(Long.valueOf(r6));
    L6:
        r9 = c;
        goto L8
    L9:
        int r3 = r0.get(6) - r1.get(6);
        if (Math.abs(r3) <= 6) goto L17;
        if (r2 == false) goto L13;
        SimpleDateFormat r10 = f;
    L15:
        return r10.format(Long.valueOf(r6));
    L13:
        r10 = e;
        goto L15
    L17:
        if (Math.abs(r3) <= 1) goto L30;
        int r11 = r1.get(7);
        StringBuilder r4 = new StringBuilder();
        switch(r11) {
            case 1: goto L27;
            case 2: goto L26;
            case 3: goto L25;
            case 4: goto L24;
            case 5: goto L23;
            case 6: goto L22;
            case 7: goto L21;
            default: goto L20;
        };
    L20:
        String r12 = AppHost.a.getApplication().getString(2131907420);
    L28:
        r4.append(r12);
        r4.append(' ');
        r4.append(h.format(Long.valueOf(r6)));
        return r4.toString();
    L21:
        r12 = AppHost.a.getApplication().getString(2131907419);
        goto L28
    L22:
        r12 = AppHost.a.getApplication().getString(2131907416);
        goto L28
    L23:
        r12 = AppHost.a.getApplication().getString(2131907421);
        goto L28
    L24:
        r12 = AppHost.a.getApplication().getString(2131907423);
        goto L28
    L25:
        r12 = AppHost.a.getApplication().getString(2131907422);
        goto L28
    L26:
        r12 = AppHost.a.getApplication().getString(2131907417);
        goto L28
    L27:
        r12 = AppHost.a.getApplication().getString(2131907420);
        goto L28
    L30:
        if (r3 > 0) goto L32;
        String r7 = h.format(Long.valueOf(r6));
        if (r8 == true) goto L38;
        Intrinsics.checkNotNull(r7);
        return r7;
    L38:
        return AppHost.a.getApplication().getString(2131905623) + ' ' + r7;
    L32:
        return g.format(Long.valueOf(r6));
    }
}
