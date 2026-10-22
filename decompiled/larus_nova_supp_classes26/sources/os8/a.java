package os8;

import com.larus.im.bean.message.Image;
import com.larus.im.bean.message.ImageObj;
import com.larus.im.bean.message.UplinkEntityContent;
import com.larus.im.bean.message.UplinkFileEntity;
import com.larus.im.bean.message.UplinkFileInfo;
import com.larus.im.bean.message.VideoExtension;
import kotlin.jvm.internal.Intrinsics;
import nr9.f;
import nr9.g;
import yc9.l1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class a {
    public static final g a(UplinkFileEntity r20) {
        Intrinsics.checkNotNullParameter(r20, "<this>");
        UplinkEntityContent r0 = r20.getUplinkEntityContent();
        String r2 = null;
        if (r0 == null) goto L9;
        UplinkFileInfo r1 = r0.getUplinkFileInfo();
        if (r1 == null) goto L9;
        VideoExtension r3 = r1.getVideo();
        if (r3 == null) goto L9;
        String r4 = r3.getVid();
    L10:
        UplinkEntityContent r5 = r20.getUplinkEntityContent();
        if (r5 == null) goto L17;
        UplinkFileInfo r6 = r5.getUplinkFileInfo();
        if (r6 == null) goto L17;
        VideoExtension r7 = r6.getVideo();
        if (r7 == null) goto L17;
        String r8 = r7.getDownloadUrl();
    L18:
        UplinkEntityContent r9 = r20.getUplinkEntityContent();
        if (r9 == null) goto L25;
        UplinkFileInfo r10 = r9.getUplinkFileInfo();
        if (r10 == null) goto L25;
        VideoExtension r11 = r10.getVideo();
        if (r11 == null) goto L25;
        String r12 = r11.getDownloadFilehash();
    L26:
        UplinkEntityContent r13 = r20.getUplinkEntityContent();
        if (r13 == null) goto L35;
        UplinkFileInfo r14 = r13.getUplinkFileInfo();
        if (r14 == null) goto L35;
        VideoExtension r15 = r14.getVideo();
        if (r15 == null) goto L35;
        Float r16 = r15.getDuration();
        if (r16 == null) goto L35;
        Double r17 = Double.valueOf(r16.floatValue());
    L36:
        UplinkEntityContent r18 = r20.getUplinkEntityContent();
        if (r18 == null) goto L43;
        UplinkFileInfo r19 = r18.getUplinkFileInfo();
        if (r19 == null) goto L43;
        VideoExtension r21 = r19.getVideo();
        if (r21 == null) goto L43;
        String r22 = r21.getFormat();
    L44:
        UplinkEntityContent r23 = r20.getUplinkEntityContent();
        if (r23 == null) goto L51;
        UplinkFileInfo r24 = r23.getUplinkFileInfo();
        if (r24 == null) goto L51;
        VideoExtension r25 = r24.getVideo();
        if (r25 == null) goto L51;
        String r110 = r25.getPath();
    L52:
        UplinkEntityContent r26 = r20.getUplinkEntityContent();
        if (r26 == null) goto L63;
        UplinkFileInfo r27 = r26.getUplinkFileInfo();
        if (r27 == null) goto L63;
        VideoExtension r28 = r27.getVideo();
        if (r28 == null) goto L63;
        Image r29 = r28.getCover();
        if (r29 == null) goto L63;
        ImageObj r30 = r29.imageOri;
        if (r30 == null) goto L63;
        String r111 = r30.url;
    L64:
        UplinkEntityContent r31 = r20.getUplinkEntityContent();
        if (r31 == null) goto L73;
        UplinkFileInfo r32 = r31.getUplinkFileInfo();
        if (r32 == null) goto L73;
        VideoExtension r33 = r32.getVideo();
        if (r33 == null) goto L73;
        Image r34 = r33.getCover();
        if (r34 == null) goto L73;
        r2 = r34.key;
    L73:
        String r112 = r2;
        UplinkEntityContent r35 = r20.getUplinkEntityContent();
        int r36 = 0;
        if (r35 == null) goto L84;
        UplinkFileInfo r37 = r35.getUplinkFileInfo();
        if (r37 == null) goto L84;
        VideoExtension r38 = r37.getVideo();
        if (r38 == null) goto L84;
        Image r39 = r38.getCover();
        if (r39 == null) goto L84;
        ImageObj r40 = r39.imageOri;
        if (r40 == null) goto L84;
        int r41 = r40.height;
    L85:
        Integer r113 = Integer.valueOf(r41);
        UplinkEntityContent r42 = r20.getUplinkEntityContent();
        if (r42 == null) goto L97;
        UplinkFileInfo r43 = r42.getUplinkFileInfo();
        if (r43 == null) goto L97;
        VideoExtension r44 = r43.getVideo();
        if (r44 == null) goto L97;
        Image r45 = r44.getCover();
        if (r45 == null) goto L97;
        ImageObj r46 = r45.imageOri;
        if (r46 == null) goto L97;
        r36 = r46.width;
    L97:
        return new g(r4, null, r8, r12, r17, r22, new f(null, r111, r112, r113, Integer.valueOf(r36), null, 33), r110, l1.g(r20), null, 514);
    L84:
        r41 = 0;
    L63:
        r111 = null;
    L51:
        r110 = null;
    L43:
        r22 = null;
    L35:
        r17 = null;
    L25:
        r12 = null;
    L17:
        r8 = null;
    L9:
        r4 = null;
        goto L10
    }
}
