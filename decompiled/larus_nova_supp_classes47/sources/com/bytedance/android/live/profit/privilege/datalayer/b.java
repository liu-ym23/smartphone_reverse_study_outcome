package com.bytedance.android.live.profit.privilege.datalayer;

import com.bytedance.android.live.base.model.message.ITextPieceImage;
import com.bytedance.android.live.base.model.message.a5;
import com.bytedance.android.live.base.model.message.b5;
import com.bytedance.android.live.base.model.message.c5;
import com.bytedance.android.live.profit.privilege.model.touch.GiftPanelEntranceDetail;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class b {
    public static final a5 a(List<? extends com.bytedance.android.live.profit.privilege.model.touch.n> r8) {
        if ((!r8.isEmpty()) == true) goto L6;
        return null;
    L6:
        StringBuilder r0 = new StringBuilder();
        b5 r1 = vh7.f.c(b5.class);
        ArrayList r2 = new ArrayList();
        Iterator<T> r9 = r8.iterator();
        int r3 = 0;
    L8:
        if (r9.hasNext() == false) goto L31;
        com.bytedance.android.live.profit.privilege.model.touch.n r4 = (com.bytedance.android.live.profit.privilege.model.touch.n) r9.next();
        int r5 = r4.getRichTextType();
        if (r5 == GiftPanelEntranceDetail.RichTextType.RichTextTypeText.getValue()) goto L11;
        if (r5 != GiftPanelEntranceDetail.RichTextType.RichTextTypeImg.getValue()) goto L8;
        py.k r6 = r4.getImg();
        if (r6 == null) goto L8;
        r0.append("{" + r3 + ":image}");
        c5 r7 = vh7.f.c(c5.class);
        c5 r10 = r7;
        r10.setType(15);
        ITextPieceImage r12 = vh7.f.c(ITextPieceImage.class);
        r12.setImageModel(r6);
        Unit r13 = Unit.INSTANCE;
        r10.setImageValue(r12);
        r2.add(r7);
        r3 = r3 + 1;
        goto L8
    L11:
        String r14 = r4.getFontColor();
        Intrinsics.checkNotNull(r14);
        r1.setColor(r14);
        Long r15 = r4.getFontSize();
        if (r15 != null) goto L14;
    L17:
        int r16 = 13;
    L18:
        r1.setFontSize(r16);
        Long r17 = r4.getWeight();
        if (r17 != null) goto L21;
    L24:
        int r18 = 500;
    L25:
        r1.setWeight(r18);
        r0.append(r4.getText());
        goto L8
    L21:
        if (((int) r17.longValue()) <= 0) goto L24;
        r18 = (int) r17.longValue();
        goto L25
    L14:
        if (((int) r15.longValue()) <= 0) goto L17;
        r16 = (int) r15.longValue();
        goto L18
    L31:
        a5 r19 = vh7.f.c(a5.class);
        r19.setDefaultPattern(r0.toString());
        r19.setDefaultFormat(r1);
        r19.setPieces(r2);
        return r19;
    }
}
