package id8;

import com.larus.im.bean.message.Image;
import com.larus.im.bean.message.ImageObj;
import com.larus.im.bean.message.UplinkEntityContent;
import com.larus.im.bean.message.UplinkFileEntity;
import com.larus.im.bean.message.UplinkFileInfo;
import com.larus.im.bean.message.VideoExtension;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class d {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static a a(Image r12) {
        String r1 = r12.key;
        String r2 = r12.md5;
        ImageObj r0 = r12.imageThumb;
        if (r0 == null) goto L5;
        b r4 = new b(r0.url, r0.width, r0.height, r0.format);
    L6:
        ImageObj r3 = r12.imageOri;
        if (r3 == null) goto L9;
        b r5 = new b(r3.url, r3.width, r3.height, r3.format);
    L10:
        String r6 = r12.resourceId;
        String r7 = r12.localResPath;
        String r8 = r12.identifier;
        Map r9 = r12.ext;
        if (r9 == null) goto L13;
        Map r10 = MapsKt.toMap(r9);
    L15:
        return new a(r1, r2, r4, r5, r6, r7, r8, r10, r12.isMarked(), r12.isCropped());
    L13:
        r10 = null;
        goto L15
    L9:
        r5 = null;
        goto L10
    L5:
        r4 = null;
        goto L6
    }

    public static Image b(a r19) {
        String r2 = r19.a;
        String r3 = r19.b;
        b r1 = r19.c;
        if (r1 == null) goto L5;
        ImageObj r5 = new ImageObj(r1.a, r1.b, r1.c, null, r1.d, 8, null);
    L6:
        b r4 = r19.d;
        if (r4 == null) goto L9;
        ImageObj r6 = new ImageObj(r4.a, r4.b, r4.c, null, r4.d, 8, null);
    L10:
        String r7 = r19.e;
        String r8 = r19.f;
        String r9 = r19.getIdentifier();
        Map<String, String> r10 = r19.h;
        if (r10 == null) goto L13;
        Map r18 = MapsKt.toMap(r10);
    L15:
        return new Image(r2, r3, r5, r6, r7, r8, r9, r18, null, null, null, r19.i, r19.j, null, 9984, null);
    L13:
        r18 = null;
        goto L15
    L9:
        r6 = null;
        goto L10
    L5:
        r5 = null;
        goto L6
    }

    public static UplinkFileEntity c(f r26) {
        Intrinsics.checkNotNullParameter(r26, "entity");
        Integer r3 = r26.a;
        c r1 = r26.b;
        if (r1 == null) goto L21;
        g r4 = r1.a;
        if (r4 == null) goto L15;
        String r6 = r4.a;
        String r7 = r4.b;
        String r8 = r4.c;
        Integer r9 = r4.d;
        Long r10 = r4.e;
        h r5 = r4.f;
        if (r5 == null) goto L13;
        String r12 = r5.a;
        String r13 = r5.b;
        a r11 = r5.c;
        if (r11 == null) goto L11;
        Image r14 = b(r11);
    L12:
        VideoExtension r15 = new VideoExtension(r12, r13, r14, r5.d, r5.e, null, r5.f, r5.g, r5.h, r5.i, 32, null);
    L14:
        String r16 = r4.g;
        String r17 = r4.h;
        UplinkFileInfo r0 = new UplinkFileInfo(r6, r7, r8, r9, r10, r4.i, r15, r16, r17, r4.j);
    L16:
        a r2 = r1.b;
        if (r2 == null) goto L19;
        Image r18 = b(r2);
    L20:
        UplinkEntityContent r19 = new UplinkEntityContent(r0, r18);
    L22:
        Integer r20 = r3;
        return new UplinkFileEntity(r20, r19, r26.c, null, r26.d, r26.e, r26.f, r26.g, r26.h, false, r26.i, null, r26.j, r26.k, 2568, null);
    L19:
        r18 = null;
        goto L20
    L11:
        r14 = null;
        goto L12
    L13:
        r15 = null;
        goto L14
    L15:
        r3 = r3;
        r0 = null;
        goto L16
    L21:
        r3 = r3;
        r19 = null;
        goto L22
    }
}
