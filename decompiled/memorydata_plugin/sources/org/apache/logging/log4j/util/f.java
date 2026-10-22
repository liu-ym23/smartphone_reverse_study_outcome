package org.apache.logging.log4j.util;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.logging.log4j.message.Message;

/* JADX INFO: loaded from: classes6.dex */
public final class f {
    public static Object a(t<?> r2) {
        t r3 = (t) ZeusTransformUtils.wrapperContextForParams(r2, t.class, "com.obric.memorydata.plugin");
        if (r3 != null) goto L6;
        return null;
    L6:
        Object r4 = r3.get();
        if (ZeusTransformUtils.instanceOf(r4, Message.class) == true) goto L9;
        return r4;
    L9:
        return ((Message) ZeusTransformUtils.preCheckCast(r4, Message.class, "com.obric.memorydata.plugin")).getFormattedMessage();
    }

    public static Message a(i r2) {
        i r3 = (i) ZeusTransformUtils.wrapperContextForParams(r2, i.class, "com.obric.memorydata.plugin");
        if (r3 != null) goto L7;
        return null;
    L7:
        return r3.a();
    }

    public static Message a(t<?> r2, org.apache.logging.log4j.message.d r3) {
        t r4 = (t) ZeusTransformUtils.wrapperContextForParams(r2, t.class, "com.obric.memorydata.plugin");
        org.apache.logging.log4j.message.d r5 = (org.apache.logging.log4j.message.d) ZeusTransformUtils.wrapperContextForParams(r3, org.apache.logging.log4j.message.d.class, "com.obric.memorydata.plugin");
        if (r4 != null) goto L6;
        return null;
    L6:
        Object r6 = r4.get();
        if (ZeusTransformUtils.instanceOf(r6, Message.class) == false) goto L10;
        return (Message) ZeusTransformUtils.preCheckCast(r6, Message.class, "com.obric.memorydata.plugin");
    L10:
        return r5.newMessage(r6);
    }

    public static Object[] a(t<?>... r4) {
        if (r4 != null) goto L5;
        return null;
    L5:
        int r0 = r4.length;
        Object[] r1 = new Object[r0];
        int r2 = 0;
    L6:
        if (r2 >= r0) goto L8;
        r1[r2] = a(r4[r2]);
        r2 = r2 + 1;
        goto L6
    L8:
        return r1;
    }
}
