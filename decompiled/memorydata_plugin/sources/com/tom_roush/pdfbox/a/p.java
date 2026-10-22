package com.tom_roush.pdfbox.a;

import com.obric.cae.userAware.datacollection.AwareStateListener;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.Map;
import kotlin.text.Typography;
import okio.Utf8;

/* JADX INFO: loaded from: classes6.dex */
final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int[] f16071a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Map<Character, Integer> f16072b = null;

    static {
        f16071a = new int[256];
        f16072b = new HashMap(256);
        int r1 = 0;
    L3:
        if (r1 >= 256) goto L19;
        if (r1 <= 23) goto L10;
        if (r1 >= 32) goto L10;
    L18:
        r1 = r1 + 1;
    L10:
        if (r1 <= 126) goto L15;
        if (r1 < 161) goto L18;
    L15:
        if (r1 == 173) goto L18;
        a(r1, (char) r1);
        goto L18
    L19:
        a(24, 728);
        a(25, 711);
        a(26, 710);
        a(27, 729);
        a(28, 733);
        a(29, 731);
        a(30, 730);
        a(31, 732);
        a(127, Utf8.REPLACEMENT_CHARACTER);
        a(128, Typography.bullet);
        a(129, Typography.dagger);
        a(130, Typography.doubleDagger);
        a(131, Typography.ellipsis);
        a(132, Typography.mdash);
        a(133, Typography.ndash);
        a(134, 402);
        a(135, 8260);
        a(136, 8249);
        a(137, 8250);
        a(138, 8722);
        a(139, 8240);
        a(140, Typography.lowDoubleQuote);
        a(141, Typography.leftDoubleQuote);
        a(142, Typography.rightDoubleQuote);
        a(143, Typography.leftSingleQuote);
        a(144, Typography.rightSingleQuote);
        a(145, Typography.lowSingleQuote);
        a(146, Typography.tm);
        a(147, 64257);
        a(148, 64258);
        a(149, 321);
        a(AwareStateListener.DEFAULT_POI_WALK_STEP_THRESHOLD, 338);
        a(151, 352);
        a(152, 376);
        a(153, 381);
        a(154, 305);
        a(155, 322);
        a(156, 339);
        a(157, 353);
        a(158, 382);
        a(159, Utf8.REPLACEMENT_CHARACTER);
        a(160, Typography.euro);
    }

    public static String a(byte[] r6) {
        StringBuilder r0 = new StringBuilder();
        int r1 = r6.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L10;
        int r3 = r6[r2] & 255;
        int[] r4 = f16071a;
        if (r3 < r4.length) goto L7;
        char r5 = '?';
    L8:
        r0.append(r5);
        r2 = r2 + 1;
        goto L3
    L7:
        r5 = (char) r4[r3];
        goto L8
    L10:
        return r0.toString();
    }

    private static void a(int r1, char r2) {
        f16071a[r1] = r2;
        f16072b.put(Character.valueOf(r2), Integer.valueOf(r1));
    }

    public static boolean a(char r1) {
        return f16072b.containsKey(Character.valueOf(r1));
    }

    public static byte[] a(String r7) {
        ByteArrayOutputStream r0 = new ByteArrayOutputStream();
        char[] r8 = r7.toCharArray();
        int r1 = r8.length;
        int r3 = 0;
    L3:
        if (r3 >= r1) goto L10;
        Integer r4 = (Integer) ZeusTransformUtils.preCheckCast(f16072b.get(Character.valueOf(r8[r3])), Integer.class, "com.obric.memorydata.plugin");
        if (r4 != null) goto L7;
        r0.write(0);
    L8:
        r3 = r3 + 1;
        goto L3
    L7:
        r0.write(r4.intValue());
        goto L8
    L10:
        return r0.toByteArray();
    }
}
