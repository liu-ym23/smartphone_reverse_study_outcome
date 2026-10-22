package com.larksuite.component.card.component.image;

import android.view.View;
import com.larksuite.component.card.protocol.data.CardAttachment;
import com.larksuite.component.card.utils.CardDataUtils;
import com.larksuite.component.card.utils.e;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.widget.richtext.Image;
import com.ss.android.lark.widget.richtext.RichTextElement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class d implements View.OnClickListener {
    public final /* synthetic */ UniversalCardLynxImageUI a;
    public final /* synthetic */ a b;

    public d(UniversalCardLynxImageUI r1, a r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r13) {
        Object r14 = this.a.getLynxContext().getSharedData("card_share_data");
        if ((r14 instanceof com.larksuite.component.card.cardcontainer.c) == false) goto L5;
        com.larksuite.component.card.cardcontainer.c r15 = (com.larksuite.component.card.cardcontainer.c) r14;
    L6:
        if (r15 != null) goto L9;
        Log.e("UniversalCardLynxImageUI", "setImageClick currentShareData is null");
        return;
    L9:
        UniversalCardLynxImageUI r0 = this.a;
        a r1 = this.b;
        int r2 = UniversalCardLynxImageUI.f;
        CardAttachment r3 = r0.Q(r1, r15);
        ArrayList r4 = new ArrayList();
        Iterator r5 = ((ArrayList) this.a.d).iterator();
    L11:
        if (r5.hasNext() == false) goto L21;
        String r6 = (String) r5.next();
        if (r3 == null) goto L11;
        HashMap<String, RichTextElement.ImageProperty> r7 = r3.getImages();
        if (r7 == null) goto L11;
        RichTextElement.ImageProperty r8 = r7.get(r6);
        if (r8 == null) goto L11;
        CardDataUtils.a.getClass();
        Image r9 = CardDataUtils.e(r8);
        if (r9 == null) goto L11;
        r4.add(r9);
        goto L11
    L21:
        UniversalCardLynxImageUI r10 = this.a;
        Image r11 = r10.a;
        if (r11 != null) goto L24;
        return;
    L24:
        if ((!r4.isEmpty()) == false) goto L39;
        r15.c.getDependency().previewImage(UniversalCardLynxImageUI.M(r10), r4, r11);
        com.larksuite.component.card.monitor.a.b(r15.b.getVersion(), "view_image", "img", r15.c.getMonitorData(), r15.b.getCardID(), null, r15.b.isStreamingMode(), MapsKt.mapOf(TuplesKt.to("picture_id", e.b(r11.getKey()))), 32);
        return;
    L39:
        return;
    L5:
        r15 = null;
        goto L6
    }
}
