package com.larus.uaigc.chat.block.create.horizontal;

import com.larus.im.bean.message.CreationItem;
import com.larus.im.bean.message.ImageData;
import com.larus.im.bean.message.ImageObj;
import com.larus.im.bean.message.VideoData;
import com.larus.uaigc.chat.block.widget.container.CreationItemListAdapter;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class j implements com.larus.bmhome.bigimg.e {
    public final /* synthetic */ CreationHorizontalGroup a;

    public j(CreationHorizontalGroup r1) {
        this.a = r1;
    }

    public final void b(int r8, zo8.a r9) {
        if ((r9 instanceof zo8.b) == false) goto L32;
        String r10 = ((zo8.b) r9).a.c;
        CreationItemListAdapter r11 = this.a.t;
        if (r11 == null) goto L28;
        List<? extends cz9.b> r12 = r11.j;
        if (r12 == null) goto L28;
        Iterator<? extends cz9.b> r13 = r12.iterator();
        int r4 = 0;
    L10:
        if (r13.hasNext() == false) goto L28;
        cz9.b r5 = r13.next();
        if ((r5 instanceof cz9.h) == false) goto L24;
        CreationItem r6 = ((cz9.h) r5).d;
        if (r6 == null) goto L20;
        ImageData r7 = r6.image;
        if (r7 == null) goto L20;
        ImageObj r14 = r7.imageOrigin;
        if (r14 == null) goto L20;
        String r15 = r14.url;
    L22:
        if (Intrinsics.areEqual(r15, r10) == false) goto L24;
        boolean r16 = true;
    L25:
        if (r16 == true) goto L29;
        r4 = r4 + 1;
    L29:
        if (r4 <= (-1)) goto L63;
        this.a.r.b.scrollToPosition(r4);
        return;
    L63:
        return;
    L20:
        r15 = null;
    L24:
        r16 = false;
    L28:
        r4 = -1;
        goto L29
    L32:
        if ((r9 instanceof zo8.e) == false) goto L65;
        String r17 = ((zo8.e) r9).c.a;
        CreationItemListAdapter r18 = this.a.t;
        if (r18 == null) goto L55;
        List<? extends cz9.b> r19 = r18.j;
        if (r19 == null) goto L55;
        Iterator<? extends cz9.b> r20 = r19.iterator();
        int r21 = 0;
    L39:
        if (r20.hasNext() == false) goto L55;
        cz9.b r22 = r20.next();
        if ((r22 instanceof cz9.o) == false) goto L51;
        CreationItem r23 = ((cz9.o) r22).d;
        if (r23 == null) goto L47;
        VideoData r24 = r23.video;
        if (r24 == null) goto L47;
        String r25 = r24.vid;
    L49:
        if (Intrinsics.areEqual(r25, r17) == false) goto L51;
        boolean r26 = true;
    L52:
        if (r26 == true) goto L56;
        r21 = r21 + 1;
    L56:
        if (r21 <= (-1)) goto L66;
        this.a.r.b.scrollToPosition(r21);
        return;
    L66:
        return;
    L47:
        r25 = null;
    L51:
        r26 = false;
    L55:
        r21 = -1;
        goto L56
    }
}
