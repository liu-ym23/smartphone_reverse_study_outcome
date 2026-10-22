package com.larus.bmhome.chat.list.cell.video;

import com.larus.flow.video.bean.CommonVideoModel;
import com.larus.im.bean.message.Message;
import com.larus.platform.uimodel.MediaEntity;
import com.larus.platform.uimodel.MediaEntityContainer;
import java.util.ArrayList;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class u extends xc8.b {
    public String e;

    @Override // xc8.b
    public final int d() {
        return com.larus.bmhome.chat.bean.d.G0(this.a) ? 1 : 0;
    }

    public final boolean i() {
        CommonVideoModel.a r0 = CommonVideoModel.Companion;
        String r1 = this.a.getContent();
        r0.getClass();
        MediaEntityContainer r2 = CommonVideoModel.a.a(r1);
        if (r2 != null) goto L5;
        return false;
    L5:
        ArrayList r3 = r2.getVideo_list();
        if (r3 == null) goto L13;
        MediaEntity r4 = (MediaEntity) CollectionsKt.firstOrNull(r3);
        if (r4 != null) goto L10;
        return false;
    L10:
        if (r4.getMedia_status() != 0) goto L15;
        return true;
    L15:
        return false;
    L13:
        return false;
    }

    public u(Message r2) {
        Intrinsics.checkNotNullParameter(r2, "message");
        super(r2);
    }
}
