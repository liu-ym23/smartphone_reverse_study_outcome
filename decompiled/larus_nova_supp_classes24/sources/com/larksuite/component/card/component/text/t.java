package com.larksuite.component.card.component.text;

import android.os.Build;
import android.view.View;
import com.larksuite.component.card.protocol.context.ICardDependency;
import com.larksuite.component.card.protocol.data.CardAttachment;
import com.larksuite.component.card.protocol.data.CardContent;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.widget.richtext.Image;
import com.ss.android.lark.widget.richtext.RichTextElement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class t implements mcc.g {
    public final /* synthetic */ UniversalCardTextLynxUI a;
    public final /* synthetic */ TextProps b;

    public t(UniversalCardTextLynxUI r1, TextProps r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void j(View r12, mcc.p r13) {
        Intrinsics.checkNotNullParameter(r12, "view");
        Intrinsics.checkNotNullParameter(r13, "imageClickInfo");
        if (Build.VERSION.SDK_INT < 33) goto L5;
        ImageClickExtra r14 = (ImageClickExtra) r13.a.getSerializable("EXTRA_KEY_ID", ImageClickExtra.class);
    L6:
        if (r14 != null) goto L8;
        return;
    L8:
        if (com.larksuite.component.card.utils.k.b(r14.getImageId()) == false) goto L47;
        UniversalCardTextLynxUI r15 = this.a;
        int r0 = UniversalCardTextLynxUI.g;
        com.larksuite.component.card.cardcontainer.c r16 = r15.O();
        if (r16 != null) goto L13;
        Log.e("UniversalCardTextLynxUI", "cardShareData null");
        return;
    L13:
        RichTextElement.ImageProperty r1 = null;
        if (Intrinsics.areEqual(this.b.isTranslateElement(), Boolean.TRUE) == false) goto L19;
        CardContent r2 = r16.b.getTranslateContent();
        if (r2 == null) goto L18;
        CardAttachment r3 = r2.getAttachment();
    L20:
        if (r3 == null) goto L24;
        HashMap<String, RichTextElement.ImageProperty> r4 = r3.getImages();
        if (r4 == null) goto L24;
        r1 = r4.get(r14.getImageId());
    L24:
        if (r1 == null) goto L48;
        ArrayList r17 = new ArrayList();
        Image r5 = com.ss.android.lark.widget.richtext.d.h(r1, 1);
        Iterator r6 = ((ArrayList) this.a.e).iterator();
    L27:
        if (r6.hasNext() == false) goto L34;
        String r7 = (String) r6.next();
        HashMap<String, RichTextElement.ImageProperty> r8 = r3.getImages();
        if (r8 == null) goto L27;
        RichTextElement.ImageProperty r9 = r8.get(r7);
        if (r9 == null) goto L27;
        r17.add(com.ss.android.lark.widget.richtext.d.h(r9, 0));
        goto L27
    L34:
        if ((!r17.isEmpty()) == false) goto L36;
        ICardDependency r10 = r16.c.getDependency();
        View r11 = UniversalCardTextLynxUI.N(this.a);
        Intrinsics.checkNotNull(r5);
        r10.previewImage(r11, r17, r5);
    L36:
        if (r5 == null) goto L49;
        com.larksuite.component.card.monitor.a.b(r16.b.getVersion(), "view_image", "markdown", r16.c.getMonitorData(), r16.b.getCardID(), null, r16.b.isStreamingMode(), MapsKt.mapOf(TuplesKt.to("picture_id", com.larksuite.component.card.utils.e.b(r5.getKey()))), 32);
        return;
    L49:
        return;
    L48:
        return;
    L18:
        r3 = null;
        goto L20
    L19:
        r3 = r16.b.getCardContent().getAttachment();
        goto L20
    L47:
        return;
    L5:
        r14 = (ImageClickExtra) r13.a.get("EXTRA_KEY_ID");
        goto L6
    }
}
