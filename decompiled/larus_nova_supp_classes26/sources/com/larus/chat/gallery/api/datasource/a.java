package com.larus.chat.gallery.api.datasource;

import com.larus.bmhome.chat.tips.GuidePriority;
import com.larus.chat.gallery.api.bean.GalleryChatType;
import com.larus.im.bean.message.Message;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class a {
    public final List<String> a;
    public final Message b;
    public final long c;
    public String d;
    public String e;
    public boolean f;
    public boolean g;

    /* JADX INFO: renamed from: com.larus.chat.gallery.api.datasource.a$a, reason: collision with other inner class name */
    public static final class C0097a {
    }

    static {
    }

    public final List<Long> b() {
        ArrayList r0 = new ArrayList();
        Iterator<T> r1 = this.a.iterator();
    L4:
        if (r1.hasNext() == false) goto L23;
        String r2 = (String) r1.next();
        int r3 = r2.hashCode();
        if (r3 != (-958719347)) goto L8;
        if (r2.equals(GalleryChatType.HOMEWORK_CORRECTION) == false) goto L4;
        r0.add(10101L);
        goto L4
    L8:
        if (r3 != (-357806106)) goto L10;
        if (r2.equals(GalleryChatType.CHAT_CREATION) == false) goto L4;
        r0.add(10100L);
        r0.add(20100L);
        goto L4
    L10:
        if (r3 != 1620069391) goto L4;
        if (r2.equals(GalleryChatType.CHAT_SEND) == false) goto L4;
        r0.add(10200L);
        r0.add(20200L);
        goto L4
    L23:
        return r0;
    }

    public a(List<String> r3, Message r4) {
        Intrinsics.checkNotNullParameter(r3, "messageTypeList");
        this.a = r3;
        this.b = r4;
        if (r4 == null) goto L5;
        long r5 = r4.getCreateTime();
    L6:
        this.c = r5 * ((long) GuidePriority.COMMERCE_CREDIT_PRIORITY);
        return;
    L5:
        r5 = 0;
        goto L6
    }

    public static final void a(a r2, List r3) {
        r2.getClass();
        StringBuilder r4 = new StringBuilder("list print:size: ");
        if (r3 == null) goto L5;
        Integer r0 = Integer.valueOf(r3.size());
    L6:
        r4.append(r0);
        r4.append("; ");
        String r5 = r4.toString();
        if (r3 == null) goto L12;
        Iterator r6 = r3.iterator();
    L10:
        if (r6.hasNext() == false) goto L12;
        r5 = r5 + ((Message) r6.next()).getMessageId() + ", ";
    L12:
        FLogger.a.i("GalleryMessageLoadProcessor", r5 + "; print end");
        return;
    L5:
        r0 = null;
        goto L6
    }
}
