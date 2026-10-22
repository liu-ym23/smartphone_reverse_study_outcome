package com.larus.bmhome.chat.list.cell.video;

import com.larus.bmhome.chat.layout.item.l4;
import com.larus.bmhome.chat.search.VideoInfo;
import com.larus.flow.video.bean.CommonVideoModel;
import com.larus.network.http.AsyncThrowable;
import com.larus.platform.api.z3;
import com.larus.platform.service.q3;
import com.larus.platform.uimodel.MediaEntity;
import com.larus.platform.uimodel.MediaEntityContainer;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import kotlin.Lazy;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class l implements CommonVideoModel.b {
    public final /* synthetic */ ArrayList<MediaEntity> a;
    public final /* synthetic */ VideoInfo b;
    public final /* synthetic */ AwemeVideoListCell c;

    public final void a(MediaEntityContainer r4) {
        String r0 = null;
        if (r4 == null) goto L5;
        ArrayList r1 = r4.getVideo_list();
    L6:
        if (r1 != null) goto L8;
    L11:
        boolean r2 = true;
    L12:
        if (r2 == false) goto L14;
        FLogger.a.d(l4.class.getSimpleName(), "[preloadMediaDetailData] error!!!  media list is empty ");
        return;
    L14:
        this.a.clear();
        if (r4 == null) goto L19;
        ArrayList r5 = r4.getVideo_list();
        if (r5 == null) goto L19;
        this.a.addAll(r5);
    L19:
        this.b.setPreloadMediaEntityList(new ArrayList(this.a));
        AwemeVideoListCell r6 = this.c;
        ArrayList<MediaEntity> r3 = this.a;
        int r7 = AwemeVideoListCell.j;
        r6.getClass();
        if (r3.isEmpty() == true) goto L31;
        Lazy r8 = q3.a;
        z3 r9 = q3.a();
        if (r9 == null) goto L30;
        MediaEntity r10 = (MediaEntity) CollectionsKt.firstOrNull(r3);
        if (r10 == null) goto L27;
        r0 = r10.getVideo_model();
    L27:
        r9.f(r0, new m(r3));
        return;
    L30:
        return;
    L31:
        return;
    L8:
        if (r1.isEmpty() == true) goto L11;
        r2 = false;
        goto L12
    L5:
        r1 = null;
        goto L6
    }

    public final void b(AsyncThrowable r7) {
        boolean r0 = false;
        if (r7 != null) goto L5;
    L7:
        if (r0 == false) goto L10;
        FLogger.a.w("AwemeVideoListHolder", "search preload video error: " + r7.getMessage());
        return;
    L10:
        return;
    L5:
        if (r7.getCode() != 710012017) goto L7;
        r0 = true;
        goto L7
    }

    public l(ArrayList<MediaEntity> r1, VideoInfo r2, AwemeVideoListCell r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
