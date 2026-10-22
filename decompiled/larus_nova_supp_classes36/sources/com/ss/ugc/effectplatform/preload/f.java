package com.ss.ugc.effectplatform.preload;

import bytekn.foundation.logger.Logger;
import com.ss.ugc.effectplatform.model.net.Busi_info;
import com.ss.ugc.effectplatform.model.net.PreloadResourceList;
import com.ss.ugc.effectplatform.model.net.PreloadResponseModel;
import com.ss.ugc.effectplatform.task.a1;
import com.ss.ugc.effectplatform.task.b1;
import com.ss.ugc.effectplatform.task.q1;
import com.ss.ugc.effectplatform.util.q;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class f implements a1 {
    public final /* synthetic */ PreloadResponseModel a;
    public final /* synthetic */ g b;

    @Override // com.ss.ugc.effectplatform.task.a1
    public final void a() {
        if (h.d == true) goto L6;
        Logger.INSTANCE.w("JKL", "[预加载][暂停][不继续下载资源文件]");
        return;
    L6:
        Busi_info r0 = this.a.getBusi_info();
        if (r0 == null) goto L9;
        long r1 = r0.getNet_speed_limit();
    L10:
        long r2 = r1 * ((long) 1024);
        List<PreloadResourceList> r3 = this.a.getPreload_resource_list();
        if (r3 == null) goto L18;
        Iterator<T> r4 = r3.iterator();
    L14:
        if (r4.hasNext() == false) goto L24;
        PreloadResourceList r6 = (PreloadResourceList) r4.next();
        g r5 = this.b;
        b1 r7 = new b1(r5.c, r6, r5.b, r2, q.a(), this.b.a);
        h.a.add(r7);
        q1 r8 = this.b.c.D;
        if (r8 == null) goto L14;
        r8.a(r7);
        goto L14
    L24:
        return;
    L18:
        return;
    L9:
        r1 = 0;
        goto L10
    }

    public f(PreloadResponseModel r1, g r2) {
        this.a = r1;
        this.b = r2;
    }
}
