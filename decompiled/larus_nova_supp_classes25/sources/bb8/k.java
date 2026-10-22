package bb8;

import com.larus.flow.video.bean.CommonVideoModel;
import com.larus.network.http.AsyncThrowable;
import com.larus.platform.api.z3;
import com.larus.platform.service.q3;
import com.larus.platform.uimodel.MediaEntity;
import com.larus.platform.uimodel.MediaEntityContainer;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.Lazy;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class k implements CommonVideoModel.b {
    public k() {
    }

    public final void a(MediaEntityContainer r8) {
        String r0 = null;
        if (r8 == null) goto L5;
        ArrayList r1 = r8.getVideo_list();
    L6:
        boolean r2 = true;
        if (r1 != null) goto L9;
    L12:
        boolean r3 = true;
    L13:
        if (r3 == false) goto L15;
        FLogger.a.d("BannerVideoPreloadManager", "[preloadVideoByItemIds] error:media list is empty ");
        return;
    L15:
        if (r8 == null) goto L26;
        ArrayList r4 = r8.getVideo_list();
        if (r4 == null) goto L26;
        Iterator r5 = r4.iterator();
    L20:
        if (r5.hasNext() == false) goto L26;
        MediaEntity r6 = (MediaEntity) r5.next();
        if (r6 == null) goto L20;
        String r7 = r6.getItem_id();
        if (r7 == null) goto L20;
        m.a.put(r7, r6);
    L26:
        HashMap<String, MediaEntity> r9 = m.a;
        if (r8 == null) goto L29;
        ArrayList r10 = r8.getVideo_list();
    L30:
        if (r10 != null) goto L32;
    L35:
        if (r2 == true) goto L53;
        Lazy r11 = q3.a;
        z3 r12 = q3.a();
        if (r12 == null) goto L52;
        MediaEntity r13 = (MediaEntity) CollectionsKt.firstOrNull(r10);
        if (r13 == null) goto L42;
        r0 = r13.getVideo_model();
    L42:
        r12.f(r0, new l(r10));
        return;
    L52:
        return;
    L53:
        return;
    L32:
        if (r10.isEmpty() == true) goto L35;
        r2 = false;
        goto L35
    L29:
        r10 = null;
        goto L30
    L9:
        if (r1.isEmpty() == true) goto L12;
        r3 = false;
        goto L13
    L5:
        r1 = null;
        goto L6
    }

    public final void b(AsyncThrowable r6) {
        FLogger r0 = FLogger.a;
        StringBuilder r1 = new StringBuilder("[preloadVideoByItemIds] error:");
        String r2 = null;
        if (r6 == null) goto L5;
        Long r3 = Long.valueOf(r6.getCode());
    L6:
        r1.append(r3);
        r1.append(':');
        if (r6 == null) goto L9;
        r2 = r6.getMessage();
    L9:
        r1.append(r2);
        r0.d("BannerVideoPreloadManager", r1.toString());
        return;
    L5:
        r3 = null;
        goto L6
    }
}
