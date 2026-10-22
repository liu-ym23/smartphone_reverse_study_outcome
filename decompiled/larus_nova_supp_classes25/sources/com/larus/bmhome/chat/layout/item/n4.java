package com.larus.bmhome.chat.layout.item;

import com.larus.flow.video.bean.CommonVideoModel;
import com.larus.network.http.AsyncThrowable;
import com.larus.platform.uimodel.MediaEntity;
import com.larus.platform.uimodel.MediaEntityContainer;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class n4 implements CommonVideoModel.b {
    public final /* synthetic */ l4 a;

    public n4(l4 r1) {
        this.a = r1;
    }

    public final void a(MediaEntityContainer r3) {
        if (r3 == null) goto L4;
        ArrayList r0 = r3.getVideo_list();
    L5:
        if (r0 != null) goto L7;
    L10:
        boolean r1 = true;
    L11:
        if (r1 == false) goto L13;
        FLogger.a.d(l4.class.getSimpleName(), "[preloadMediaDetailData] error!!!  media list is empty ");
        return;
    L13:
        ArrayList<MediaEntity> r2 = this.a.w;
        if (r2 == null) goto L16;
        r2.clear();
    L16:
        if (r3 == null) goto L22;
        ArrayList r4 = r3.getVideo_list();
        if (r4 == null) goto L22;
        ArrayList<MediaEntity> r5 = this.a.w;
        if (r5 == null) goto L22;
        r5.addAll(r4);
    L22:
        this.a.n();
        return;
    L7:
        if (r0.isEmpty() == true) goto L10;
        r1 = false;
        goto L11
    L4:
        r0 = null;
        goto L5
    }

    public final void b(AsyncThrowable r7) {
        boolean r0 = false;
        if (r7 != null) goto L5;
    L7:
        if (r0 == false) goto L10;
        l4 r1 = this.a;
        r1.z = r7.getMessage();
        return;
    L10:
        return;
    L5:
        if (r7.getCode() != 710012017) goto L7;
        r0 = true;
        goto L7
    }
}
