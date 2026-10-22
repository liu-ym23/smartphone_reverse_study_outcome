package com.larus.bmhome.chat.component.bottom.attachment;

import com.larus.im.bean.message.Image;
import com.larus.im.bean.message.UplinkEntityContent;
import com.larus.im.bean.message.UplinkFileEntity;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import yc9.n1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class e1 implements com.larus.bmhome.chat.component.bottom.core.speaker.n {
    public final g1 a;

    @Override // com.larus.bmhome.chat.component.bottom.core.speaker.n
    public final List<String> E9() {
        List<UplinkFileEntity> r0 = this.a.q1();
        if (r0 == null) goto L21;
        ArrayList r1 = new ArrayList();
        Iterator<T> r2 = r0.iterator();
    L6:
        if (r2.hasNext() == false) goto L10;
        Object r3 = r2.next();
        if (n1.d((UplinkFileEntity) r3) == false) goto L6;
        r1.add(r3);
        goto L6
    L10:
        List<String> r4 = new ArrayList();
        Iterator r5 = r1.iterator();
    L12:
        if (r5.hasNext() == false) goto L22;
        UplinkEntityContent r6 = ((UplinkFileEntity) r5.next()).getUplinkEntityContent();
        if (r6 == null) goto L18;
        Image r7 = r6.getUplinkImageInfo();
        if (r7 == null) goto L18;
        String r8 = r7.key;
    L19:
        if (r8 == null) goto L12;
        r4.add(r8);
    L18:
        r8 = null;
    L22:
        FLogger.a.i("ChatUploadedImageProvider", "getImageUriList size=" + r4.size());
        return r4;
    L21:
        r4 = CollectionsKt.emptyList();
        goto L22
    }

    @Override // com.larus.bmhome.chat.component.bottom.core.speaker.n
    public final List<String> L0() {
        return CollectionsKt.emptyList();
    }

    public e1(g1 r2) {
        Intrinsics.checkNotNullParameter(r2, "attachmentPanelAbility");
        this.a = r2;
    }
}
