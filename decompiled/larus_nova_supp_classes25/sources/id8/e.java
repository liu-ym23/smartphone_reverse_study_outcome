package id8;

import android.net.Uri;
import com.larus.im.bean.message.Image;
import com.larus.im.bean.message.UplinkEntityContent;
import com.larus.im.bean.message.UplinkFileEntity;
import com.larus.im.bean.message.UplinkFileInfo;
import com.larus.im.bean.message.VideoExtension;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class e {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static a a(a r13, a r14) {
        if (r13 != null) goto L4;
        return r14;
    L4:
        if (r14 != null) goto L6;
        return r13;
    L6:
        String r3 = d(r14.a, r13.a);
        String r4 = d(r14.b, r13.b);
        b r5 = b(r13.c, r14.c);
        b r6 = b(r13.d, r14.d);
        String r7 = d(r14.e, r13.e);
        String r8 = d(r14.f, r13.f);
        String r9 = d(r14.getIdentifier(), r13.getIdentifier());
        Map<String, String> r0 = r14.h;
        Map<String, String> r1 = r13.h;
        if (r0 != null) goto L9;
    L12:
        boolean r2 = true;
    L13:
        if (r2 == true) goto L15;
        Map<String, String> r10 = MapsKt.toMap(r0);
    L16:
        Boolean r11 = r14.i;
        if (r11 != null) goto L19;
        r11 = r13.i;
    L19:
        Boolean r12 = r11;
        Boolean r15 = r14.j;
        if (r15 != null) goto L22;
        Boolean r16 = r13.j;
    L24:
        return new a(r3, r4, r5, r6, r7, r8, r9, r10, r12, r16);
    L22:
        r16 = r15;
        goto L24
    L15:
        r10 = r1;
        goto L16
    L9:
        if (r0.isEmpty() == true) goto L12;
        r2 = false;
        goto L13
    }

    public static b b(b r4, b r5) {
        if (r4 != null) goto L4;
        return r5;
    L4:
        if (r5 != null) goto L6;
        return r4;
    L6:
        String r0 = d(r5.a, r4.a);
        int r1 = r5.b;
        int r2 = r4.b;
        if (r1 > 0) goto L10;
        r1 = r2;
    L10:
        int r3 = r5.c;
        int r6 = r4.c;
        if (r3 > 0) goto L15;
        r3 = r6;
    L15:
        return new b(r0, r1, r3, d(r5.d, r4.d));
    }

    public static Integer c(Integer r1, Integer r2) {
        if (r1 == null) goto L4;
        int r0 = r1.intValue();
    L5:
        if (r0 == 0) goto L8;
        return r1;
    L8:
        return r2;
    L4:
        r0 = 0;
        goto L5
    }

    public static String d(String r1, String r2) {
        if (r1 != null) goto L4;
    L7:
        boolean r0 = true;
    L8:
        if (r0 == true) goto L11;
        return r1;
    L11:
        return r2;
    L4:
        if (r1.length() == 0) goto L7;
        r0 = false;
        goto L8
    }

    public static List e(List r47, List r48) {
        Intrinsics.checkNotNullParameter(r47, "previous");
        String r2 = "incoming";
        Intrinsics.checkNotNullParameter(r48, "incoming");
        List r0 = r47;
        LinkedHashMap r5 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r0, 10)), 16));
        Iterator r1 = r0.iterator();
    L3:
        String r6 = "";
        if (r1.hasNext() == false) goto L10;
        Object r4 = r1.next();
        String r7 = ((f) r4).c;
        if (r7 == null) goto L9;
        r6 = r7;
    L9:
        r5.put(r6, r4);
        goto L3
    L10:
        ArrayList r3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r48, 10));
        Iterator r8 = r48.iterator();
    L12:
        if (r8.hasNext() == false) goto L113;
        UplinkFileEntity r9 = (UplinkFileEntity) r8.next();
        String r10 = r9.getFileIdentifier();
        if (r10 != null) goto L16;
        r10 = "";
    L16:
        f r11 = (f) r5.get(r10);
        Intrinsics.checkNotNullParameter(r9, r2);
        int r12 = d.a;
        Intrinsics.checkNotNullParameter(r9, "entity");
        Integer r13 = r9.getEntityType();
        UplinkEntityContent r14 = r9.getUplinkEntityContent();
        String r20 = null;
        if (r14 == null) goto L35;
        UplinkFileInfo r15 = r14.getUplinkFileInfo();
        if (r15 == null) goto L29;
        String r22 = r15.getFileName();
        String r23 = r15.getTosKey();
        String r24 = r15.getMd5();
        Integer r25 = r15.getFileType();
        Long r26 = r15.getSize();
        VideoExtension r16 = r15.getVideo();
        if (r16 == null) goto L27;
        String r28 = r16.getVid();
        String r29 = r16.getPath();
        Image r17 = r16.getCover();
        if (r17 == null) goto L25;
        a r30 = d.a(r17);
    L26:
        h r27 = new h(r28, r29, r30, r16.getFormat(), r16.getDownloadUrl(), r16.getDuration(), r16.getHeight(), r16.getWidth(), r16.getSource());
    L28:
        g r18 = new g(r22, r23, r24, r25, r26, r27, r15.getMimeType(), r15.getLocalResPath(), r15.getResourceId(), r15.getDuration());
    L30:
        Image r19 = r14.getUplinkImageInfo();
        if (r19 == null) goto L33;
        a r21 = d.a(r19);
    L34:
        c r110 = new c(r18, r21);
    L36:
        String r111 = r9.getFileIdentifier();
        Integer r112 = r9.getFileReviewStatus();
        Integer r113 = r9.getFileParsedStatus();
        Integer r114 = r9.getUpLinkProcess();
        Integer r115 = r9.getUpLinkStatus();
        Boolean r210 = r9.isFromDraft();
        Uri r211 = r9.getUri();
        Boolean r212 = r9.isOriginalImageChecked();
        Iterator r213 = r8;
        String r214 = r2;
        LinkedHashMap r215 = r5;
        c r31 = r110;
        f r216 = new f(r13, r110, r111, r112, r113, r114, r115, r210, r211, r212, r9.getExtra());
        if (r11 == null) goto L112;
        Integer r32 = c(r13, r11.a);
        c r33 = r11.b;
        if (r33 != null) goto L42;
        c r34 = r31;
    L83:
        String r35 = d(r111, r11.c);
        Integer r36 = c(r112, r11.d);
        Integer r37 = c(r113, r11.e);
        Integer r38 = c(r114, r11.f);
        Integer r39 = c(r115, r11.g);
        if (r210 != null) goto L86;
        Boolean r310 = r11.h;
    L87:
        Uri r40 = r11.i;
        if (r211 == null) goto L90;
        r20 = r211.toString();
    L90:
        boolean r41 = false;
        if (r20 != null) goto L93;
    L96:
        boolean r42 = true;
    L97:
        if (r42 == true) goto L99;
        Uri r311 = r211;
    L100:
        if (r212 != null) goto L102;
        Boolean r312 = r11.j;
    L103:
        Map r43 = r9.getExtra();
        Map<String, String> r44 = r11.k;
        if (r43 != null) goto L106;
    L107:
        r41 = true;
    L108:
        if (r41 == true) goto L110;
        Map<String, String> r45 = MapsKt.toMap(r43);
    L111:
        r216 = new f(r32, r34, r35, r36, r37, r38, r39, r310, r311, r312, r45);
        goto L112
    L110:
        r45 = r44;
        goto L111
    L106:
        if (r43.isEmpty() == false) goto L108;
    L102:
        r312 = r212;
        goto L103
    L99:
        r311 = r40;
        goto L100
    L93:
        if (r20.length() == 0) goto L96;
        r42 = false;
        goto L97
    L86:
        r310 = r210;
        goto L87
    L42:
        if (r31 == null) goto L82;
        g r46 = r33.a;
        g r49 = r31.a;
        if (r46 != null) goto L47;
        r46 = r49;
    L81:
        r33 = new c(r46, a(r33.b, r31.b));
        goto L82
    L47:
        if (r49 == null) goto L81;
        String r313 = d(r49.a, r46.a);
        String r314 = d(r49.b, r46.b);
        String r315 = d(r49.c, r46.c);
        Integer r316 = c(r49.d, r46.d);
        Long r116 = r49.e;
        Long r117 = r46.e;
        if (r116 == null) goto L52;
        long r118 = r116.longValue();
    L54:
        if (r118 <= 0) goto L56;
        Long r317 = r116;
    L57:
        h r119 = r46.f;
        h r120 = r49.f;
        if (r119 != null) goto L60;
        h r318 = r120;
    L72:
        String r319 = d(r49.g, r46.g);
        String r320 = d(r49.h, r46.h);
        String r410 = d(r49.i, r46.i);
        Float r50 = r49.j;
        Float r51 = r46.j;
        if (r50 == null) goto L75;
        float r121 = r50.floatValue();
    L77:
        if (r121 <= 0.0f) goto L79;
        Float r411 = r50;
    L80:
        r46 = new g(r313, r314, r315, r316, r317, r318, r319, r320, r410, r411);
        goto L81
    L79:
        r411 = r51;
        goto L80
    L75:
        r121 = 0.0f;
        goto L77
    L60:
        if (r120 == null) goto L71;
        String r321 = d(r120.a, r119.a);
        String r322 = d(r120.b, r119.b);
        a r412 = a(r119.c, r120.c);
        String r413 = d(r120.d, r119.d);
        String r414 = d(r120.e, r119.e);
        Float r122 = r120.f;
        Float r123 = r119.f;
        if (r122 == null) goto L65;
        float r124 = r122.floatValue();
    L67:
        if (r124 <= 0.0f) goto L69;
        Float r415 = r122;
    L70:
        r119 = new h(r321, r322, r412, r413, r414, r415, c(r120.g, r119.g), c(r120.h, r119.h), d(r120.i, r119.i));
        goto L71
    L69:
        r415 = r123;
        goto L70
    L65:
        r124 = 0.0f;
    L71:
        r318 = r119;
        goto L72
    L56:
        r317 = r117;
        goto L57
    L52:
        r118 = 0;
    L82:
        r34 = r33;
    L112:
        r3.add(r216);
        r8 = r213;
        r2 = r214;
        r5 = r215;
        goto L12
    L33:
        r21 = null;
        goto L34
    L25:
        r30 = null;
        goto L26
    L27:
        r27 = null;
        goto L28
    L29:
        r18 = null;
        goto L30
    L35:
        r110 = null;
        goto L36
    L113:
        return r3;
    }
}
