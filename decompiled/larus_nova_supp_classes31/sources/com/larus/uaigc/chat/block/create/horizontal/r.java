package com.larus.uaigc.chat.block.create.horizontal;

import com.larus.im.bean.message.CreationItem;
import com.larus.platform.api.Image;
import com.larus.platform.api.ImageInfo;
import com.larus.uaigc.chat.block.widget.container.LocalCreationItemListAdapter;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class r implements com.larus.bmhome.bigimg.e {
    public final /* synthetic */ LocalCreationHorizontalGroup a;

    public r(LocalCreationHorizontalGroup r1) {
        this.a = r1;
    }

    public final void b(int r8, zo8.a r9) {
        if (r9 != null) goto L4;
        return;
    L4:
        LocalCreationHorizontalGroup r10 = this.a;
        int r0 = LocalCreationHorizontalGroup.w;
        r10.getClass();
        if ((r9 instanceof zo8.b) == false) goto L31;
        String r11 = ((zo8.b) r9).a.c;
        LocalCreationItemListAdapter r12 = r10.t;
        if (r12 == null) goto L54;
        List<? extends cz9.b> r13 = r12.j;
        if (r13 == null) goto L54;
        Iterator<? extends cz9.b> r14 = r13.iterator();
        int r1 = 0;
    L12:
        if (r14.hasNext() == false) goto L54;
        cz9.b r5 = r14.next();
        if ((r5 instanceof cz9.m) == false) goto L26;
        CreationItem r6 = ((cz9.m) r5).d;
        if (r6 == null) goto L22;
        ImageInfo r7 = bz9.c.o(r6);
        if (r7 == null) goto L22;
        Image r15 = r7.a;
        if (r15 == null) goto L22;
        String r16 = bz9.a.b(r15);
    L24:
        if (Intrinsics.areEqual(r16, r11) == false) goto L26;
        boolean r17 = true;
    L27:
        if (r17 == true) goto L55;
        r1 = r1 + 1;
    L55:
        if (r1 <= (-1)) goto L62;
        this.a.r.b.scrollToPosition(r1);
        return;
    L62:
        return;
    L22:
        r16 = null;
    L26:
        r17 = false;
    L54:
        r1 = -1;
        goto L55
    L31:
        if ((r9 instanceof zo8.e) == false) goto L54;
        String r18 = ((zo8.e) r9).c.a;
        LocalCreationItemListAdapter r19 = r10.t;
        if (r19 == null) goto L54;
        List<? extends cz9.b> r20 = r19.j;
        if (r20 == null) goto L54;
        Iterator<? extends cz9.b> r21 = r20.iterator();
        r1 = 0;
    L38:
        if (r21.hasNext() == false) goto L54;
        cz9.b r22 = r21.next();
        if ((r22 instanceof cz9.n) == false) goto L50;
        CreationItem r23 = ((cz9.n) r22).d;
        if (r23 == null) goto L46;
        nr9.g r24 = bz9.c.p(r23);
        if (r24 == null) goto L46;
        String r25 = r24.a;
    L48:
        if (Intrinsics.areEqual(r25, r18) == false) goto L50;
        boolean r26 = true;
    L51:
        if (r26 == true) goto L55;
        r1 = r1 + 1;
    L46:
        r25 = null;
    L50:
        r26 = false;
        goto L51
    }
}
