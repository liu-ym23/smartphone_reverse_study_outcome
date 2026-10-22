package com.ss.android.lark.flow.chat.message.image;

import android.content.Context;
import com.ss.android.lark.biz.officesdk.im.mediapreview.GalleryItemType;
import com.ss.android.lark.biz.officesdk.im.mediapreview.GalleryType;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.message.m;
import com.ss.android.lark.chat.entity.message.content.TextContent;
import com.ss.android.lark.chat.export.entity.message.Content;
import com.ss.android.lark.chat.preview.entity.component.property.DocImageProperty;
import com.ss.android.lark.export.entity.PreviewHangPoint;
import com.ss.android.lark.export.entity.preview.BaseProperty;
import com.ss.android.lark.export.entity.preview.UrlPreviewComponent;
import com.ss.android.lark.flow.chat.message.image.model.FlowImageSet;
import com.ss.android.lark.flow.chat.message.image.model.FlowMediaMessageType;
import com.ss.android.lark.message.lynxcard.message.r;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kza.l;
import kza.p;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class h implements m {
    public final /* synthetic */ String a;
    public final /* synthetic */ List<Object> b;
    public final /* synthetic */ kza.d c;
    public final /* synthetic */ Context d;

    public final List a(String r13, Content r14) {
        ArrayList r0 = new ArrayList();
        if (r.a(r13) == true) goto L5;
    L18:
        List r15 = this.c.x0(r14);
        if (r15 == null) goto L28;
        Iterator r16 = r15.iterator();
    L22:
        if (r16.hasNext() == false) goto L28;
        kza.m r1 = (kza.m) r16.next();
        GalleryType r4 = r1.getType();
        l r5 = r1.b;
        p r6 = r1.c;
        if (r13 != null) goto L26;
        String r7 = "";
    L27:
        kza.m r11 = new kza.m(r4, r5, r6, r7, r1.e, r1.f, r1.g);
        r0.add(new FlowImageSet(FlowMediaMessageType.Doubao, r11));
        goto L22
    L26:
        r7 = r13;
    L28:
        return r0;
    L5:
        if (Intrinsics.areEqual(this.a, r13) == false) goto L18;
        List<Object> r2 = this.b;
        if (r2 == null) goto L18;
        Iterator<T> r17 = r2.iterator();
    L10:
        if (r17.hasNext() == false) goto L28;
        Object r3 = r17.next();
        if ((r3 instanceof kza.m) == false) goto L10;
        kza.m r8 = (kza.m) r3;
        GalleryType r9 = r8.getType();
        l r10 = r8.b;
        p r12 = r8.c;
        if (r13 != null) goto L16;
        String r18 = "";
    L17:
        kza.m r19 = new kza.m(r9, r10, r12, r18, r8.e, r8.f, r8.g);
        r0.add(new FlowImageSet(FlowMediaMessageType.Doubao, r19));
        goto L10
    L16:
        r18 = r13;
        goto L17
    }

    public final FlowImageSet b(String r18, Content r19) {
        if ((r19 instanceof TextContent) == false) goto L5;
        TextContent r1 = (TextContent) r19;
    L6:
        if (r1 == null) goto L28;
        Map r0 = ((TextContent) r19).getPreviewHangPoints();
        Context r3 = this.d;
        Iterator r2 = r0.entrySet().iterator();
        FlowImageSet r4 = null;
    L9:
        if (r2.hasNext() == false) goto L36;
        Map.Entry r5 = (Map.Entry) r2.next();
        UrlPreviewComponent r6 = edb.b.a((PreviewHangPoint) r5.getValue());
        if (r6 == null) goto L13;
        BaseProperty r7 = r6.getProperty();
    L15:
        if ((r7 instanceof DocImageProperty) == false) goto L17;
        DocImageProperty r8 = (DocImageProperty) r7;
    L18:
        if (r8 == null) goto L9;
        if (r8.getSupportPreview() == false) goto L9;
        l r9 = new l(null, null, new ogb.a(r8, 2), new FlowMediaPreviewUtils$getExternalHandler$1$transferYunPanDataToImageSet$1$1$imageItem$1(r3, r8, r5), false, null, 207);
        GalleryType r10 = GalleryType.Image;
        if (r18 != null) goto L24;
        String r12 = "";
    L25:
        r4 = new FlowImageSet(FlowMediaMessageType.Lark, new kza.m(r10, r9, null, r12, GalleryItemType.Lark, 0, null, 96));
        goto L9
    L24:
        r12 = r18;
        goto L25
    L17:
        r8 = null;
        goto L18
    L13:
        r7 = null;
        goto L15
    L36:
        return r4;
    L28:
        return null;
    L5:
        r1 = null;
        goto L6
    }

    public h(String r1, List<? extends Object> r2, kza.d r3, Context r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }
}
