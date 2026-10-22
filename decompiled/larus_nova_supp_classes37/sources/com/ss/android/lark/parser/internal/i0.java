package com.ss.android.lark.parser.internal;

import com.ss.android.lark.image.entity.Image;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class i0 {
    public static Image a(com.ss.android.lark.widget.richtext.Image r2) {
        if (r2 != null) goto L5;
        return null;
    L5:
        Image r0 = new Image();
        r0.setHeight(r2.getHeight());
        r0.setWidth(r2.getWidth());
        r0.setKey(r2.getKey());
        r0.setToken(r2.getToken());
        r0.setCrypto(r2.getCrypto());
        r0.setFsUnit(r2.getFsUnit());
        r0.setResourceCleanScene(r2.getResourceCleanScene());
        r0.setResourceIsCleaned(r2.isResourceIsCleaned());
        com.ss.android.lark.widget.richtext.Image.Type r1 = r2.getType();
        if (r1 == null) goto L8;
        r0.setType(Image.Type.forNumber(r1.getNumber()));
    L8:
        r0.setUrls(r2.getUrls());
        return r0;
    }

    public static List<Image> b(List<com.ss.android.lark.widget.richtext.Image> r2) {
        ArrayList r0 = new ArrayList();
        if (r2 != null) goto L5;
        return r0;
    L5:
        Iterator<com.ss.android.lark.widget.richtext.Image> r3 = r2.iterator();
    L7:
        if (r3.hasNext() == false) goto L12;
        com.ss.android.lark.widget.richtext.Image r1 = r3.next();
        if (r1 == null) goto L7;
        r0.add(a(r1));
        goto L7
    L12:
        return r0;
    }
}
