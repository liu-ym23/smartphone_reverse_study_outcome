package bb8;

import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.flow.video.bean.CommonVideoModel;
import com.larus.platform.uimodel.MediaEntity;
import com.larus.platform.uimodel.MediaEntityContainer;
import com.larus.utils.k0;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class m {
    public static final HashMap<String, MediaEntity> a = null;

    static {
        a = new HashMap();
    }

    public static String a(String r3) {
        if (r3 != null) goto L6;
        return null;
    L6:
        if (Intrinsics.areEqual(k0.a(r3), "//flow/open_video") == true) goto L8;
        return null;
    L8:
        return UriProtector.getQueryParameter(UriProtector.parse(r3), "item_id");
    }

    public static void b(List r43) {
        if (r43 == null) goto L22;
        ArrayList r2 = new ArrayList();
        Iterator r1 = r43.iterator();
    L6:
        if (r1.hasNext() == false) goto L10;
        String r3 = ((i) r1.next()).c();
        if (r3 == null) goto L6;
        r2.add(r3);
        goto L6
    L10:
        ArrayList r4 = new ArrayList();
        Iterator r5 = r2.iterator();
    L12:
        if (r5.hasNext() == false) goto L16;
        Object r6 = r5.next();
        if (Intrinsics.areEqual(k0.a((String) r6), "//flow/open_video") == false) goto L12;
        r4.add(r6);
        goto L12
    L16:
        ArrayList r7 = new ArrayList();
        Iterator r8 = r4.iterator();
    L18:
        if (r8.hasNext() == false) goto L24;
        String r9 = UriProtector.getQueryParameter(UriProtector.parse((String) r8.next()), "item_id");
        if (r9 == null) goto L18;
        r7.add(r9);
    L24:
        if (r7 != null) goto L26;
    L29:
        boolean r10 = true;
    L30:
        if (r10 == true) goto L68;
        ArrayList r11 = new ArrayList();
        Iterator r12 = r7.iterator();
    L34:
        if (r12.hasNext() == false) goto L38;
        Object r13 = r12.next();
        if ((!a.containsKey((String) r13)) == false) goto L34;
        r11.add(r13);
        goto L34
    L38:
        ArrayList r14 = new ArrayList();
        Iterator r15 = r11.iterator();
    L40:
        if (r15.hasNext() == false) goto L42;
        r14.add(new MediaEntity(null, (String) r15.next(), null, null, null, null, null, null, null, null, null, null, null, null, null, null, 0, null, null, null, null, null, null, null, 16777213, null));
        goto L40
    L42:
        ArrayList r16 = new ArrayList(r14);
        if (r16.isEmpty() == true) goto L69;
        MediaEntityContainer r17 = new MediaEntityContainer(null, r16, null, null, false, 0, 0, null, 253, null);
        CommonVideoModel r18 = new CommonVideoModel(null);
        r18.setLoadMoreContainer(r17);
        r18.setUseNewApiGetVideoModel(true);
        r18.requestPreloadVideoByItemIds(r17, new k());
        return;
    L69:
        return;
    L68:
        return;
    L26:
        if (r7.isEmpty() == true) goto L29;
        r10 = false;
        goto L30
    L22:
        r7 = null;
        goto L24
    }
}
