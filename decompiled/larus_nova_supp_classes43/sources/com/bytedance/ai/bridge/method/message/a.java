package com.bytedance.ai.bridge.method.message;

import org.xmlpull.v1.XmlPullParserFactory;
import org.xmlpull.v1.XmlSerializer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a {
    public static final XmlPullParserFactory a = null;

    static {
        a = XmlPullParserFactory.newInstance();
    }

    public static final void a(XmlSerializer r10, String r11, String r12) {
        r10.startTag(null, r11);
        if (r12 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == true) goto L11;
        r10.text(r12);
    L11:
        r10.endTag(null, r11);
        return;
    L5:
        if (r12.length() == 0) goto L8;
        r1 = false;
        goto L9
    }
}
