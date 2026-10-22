package os8;

import com.larus.platform.api.Image;
import com.larus.platform.api.ImageInfo;
import com.larus.platform.api.creation.UnwatermarkedVideoInfo;
import com.larus.platform.api.creation.VideoInfo;
import com.larus.platform.api.creation.VideoUserContent;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import nr9.f;
import nr9.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class c {
    public static final String a(Image r3) {
        if (r3 == null) goto L13;
        String r1 = r3.a;
        if (r1 == null) goto L13;
        if ((!StringsKt.isBlank(r1)) == true) goto L10;
        r1 = null;
    L10:
        if (r1 == null) goto L13;
        return r1;
    L13:
        if (r3 == null) goto L21;
        String r4 = r3.b;
        if (r4 != null) goto L17;
        return null;
    L17:
        if ((!StringsKt.isBlank(r4)) == true) goto L19;
        return null;
    L19:
        return r4;
    L21:
        return null;
    }

    public static final Image b(Image r3) {
        String r0 = a(r3);
        boolean r1 = false;
        if (r0 != null) goto L5;
    L7:
        if (r1 == true) goto L11;
        return null;
    L11:
        return r3;
    L5:
        if ((!StringsKt.isBlank(r0)) != true) goto L7;
        r1 = true;
        goto L7
    }

    public static final g c(VideoUserContent r21) {
        Intrinsics.checkNotNullParameter(r21, "<this>");
        ImageInfo r1 = r21.b;
        if (r1 != null) goto L5;
        Image r3 = null;
    L8:
        ImageInfo r2 = r21.b;
        if (r2 != null) goto L11;
        Image r4 = null;
    L16:
        String r5 = a(r3);
        boolean r6 = true;
        if (r5 != null) goto L28;
        UnwatermarkedVideoInfo r7 = r21.f;
        if (r7 == null) goto L25;
        r5 = r7.b;
        if (r5 == null) goto L25;
        if ((!StringsKt.isBlank(r5)) == false) goto L25;
    L26:
        if (r5 != null) goto L28;
        r5 = a(r4);
    L25:
        r5 = null;
    L28:
        String r8 = r5;
        VideoInfo r9 = r21.a;
        if (r9 == null) goto L31;
        String r14 = r9.a;
    L32:
        if (r9 == null) goto L34;
        String r15 = r9.b;
    L35:
        if (r9 == null) goto L37;
        String r16 = r9.c;
    L38:
        if (r9 == null) goto L40;
        Double r17 = r9.d;
    L41:
        if (r9 == null) goto L43;
        String r10 = r9.e;
    L45:
        if (r3 == null) goto L55;
        Long r11 = Long.valueOf(r3.d);
        if (r11.longValue() <= 0) goto L49;
        boolean r12 = true;
    L50:
        if (r12 == true) goto L53;
        r11 = null;
    L53:
        if (r11 == null) goto L55;
        Integer r13 = Integer.valueOf((int) r11.longValue());
    L57:
        Integer r18 = r13;
    L59:
        if (r3 == null) goto L69;
        Long r19 = Long.valueOf(r3.c);
        if (r19.longValue() > 0) goto L64;
        r6 = false;
    L64:
        if (r6 == true) goto L67;
        r19 = null;
    L67:
        if (r19 == null) goto L69;
        Integer r20 = Integer.valueOf((int) r19.longValue());
    L71:
        Integer r110 = r20;
    L73:
        f r22 = new f(r8, r8, null, r18, r110, null, 36);
        UnwatermarkedVideoInfo r23 = r21.f;
        if (r23 == null) goto L79;
        VideoInfo r24 = r23.a;
        if (r24 == null) goto L79;
        String r25 = r24.f;
        if (r25 == null) goto L79;
    L84:
        return new g(r14, r25, r15, r16, r17, r10, r22, null, null, null, 896);
    L79:
        VideoInfo r0 = r21.a;
        if (r0 == null) goto L82;
        r25 = r0.f;
        goto L84
    L82:
        r25 = null;
    L69:
        if (r4 == null) goto L72;
        r20 = Integer.valueOf((int) r4.c);
        goto L71
    L72:
        r110 = null;
        goto L73
    L49:
        r12 = false;
    L55:
        if (r4 == null) goto L58;
        r13 = Integer.valueOf((int) r4.d);
        goto L57
    L58:
        r18 = null;
        goto L59
    L43:
        r10 = null;
        goto L45
    L40:
        r17 = null;
        goto L41
    L37:
        r16 = null;
        goto L38
    L34:
        r15 = null;
        goto L35
    L31:
        r14 = null;
        goto L32
    L11:
        r4 = b(r2.c);
        if (r4 != null) goto L16;
        r4 = b(r2.b);
        if (r4 != null) goto L16;
        r4 = b(r2.a);
        goto L16
    L5:
        r3 = b(r1.j);
        if (r3 != null) goto L8;
        r3 = b(r1.i);
        goto L8
    }

    public static final g d(VideoUserContent r20) {
        Intrinsics.checkNotNullParameter(r20, "<this>");
        ImageInfo r1 = r20.b;
        String r2 = null;
        if (r1 != null) goto L5;
        Image r3 = null;
    L10:
        VideoInfo r4 = r20.a;
        if (r4 == null) goto L13;
        String r6 = r4.a;
    L14:
        if (r4 == null) goto L16;
        String r8 = r4.b;
    L17:
        if (r4 == null) goto L19;
        String r9 = r4.c;
    L20:
        if (r4 == null) goto L22;
        Double r10 = r4.d;
    L23:
        if (r4 == null) goto L25;
        String r11 = r4.e;
    L26:
        String r13 = a(r3);
        String r14 = a(r3);
        if (r3 == null) goto L29;
        Integer r16 = Integer.valueOf((int) r3.d);
    L30:
        if (r3 == null) goto L32;
        Integer r17 = Integer.valueOf((int) r3.c);
    L33:
        f r5 = new f(r13, r14, null, r16, r17, null, 36);
        VideoInfo r0 = r20.a;
        if (r0 == null) goto L37;
        r2 = r0.f;
    L37:
        return new g(r6, r2, r8, r9, r10, r11, r5, null, null, null, 896);
    L32:
        r17 = null;
        goto L33
    L29:
        r16 = null;
        goto L30
    L25:
        r11 = null;
        goto L26
    L22:
        r10 = null;
        goto L23
    L19:
        r9 = null;
        goto L20
    L16:
        r8 = null;
        goto L17
    L13:
        r6 = null;
        goto L14
    L5:
        r3 = b(r1.c);
        if (r3 != null) goto L10;
        r3 = b(r1.b);
        if (r3 != null) goto L10;
        r3 = b(r1.a);
        goto L10
    }
}
