package com.larus.uaigc.chat.markdown.image;

import androidx.recyclerview.widget.RecyclerView;
import com.larus.bmhome.bigimg.n1;
import com.larus.platform.api.Image;
import com.larus.platform.api.ImageInfo;
import com.larus.uaigc.impl.databinding.LarusWidgetMarkdownCreationImageScrollBinding;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class d0 implements com.larus.bmhome.bigimg.e {
    public final /* synthetic */ MDImageScrollWidget a;

    public d0(MDImageScrollWidget r1) {
        this.a = r1;
    }

    public final void b(int r6, zo8.a r7) {
        if ((r7 instanceof zo8.b) == false) goto L5;
        zo8.b r8 = (zo8.b) r7;
    L6:
        if (r8 == null) goto L44;
        n1 r9 = r8.a;
        if (r9 == null) goto L45;
        String r10 = r9.c;
        if (r10 == null) goto L49;
        MDImageScrollAdapter r11 = this.a.r;
        if (r11 == null) goto L34;
        List<? extends fz9.c> r12 = r11.j;
        if (r12 == null) goto L34;
        Iterator<? extends fz9.c> r13 = r12.iterator();
        int r2 = 0;
    L18:
        if (r13.hasNext() == false) goto L34;
        fz9.c r3 = r13.next();
        if ((r3 instanceof fz9.d) == false) goto L22;
        fz9.d r4 = (fz9.d) r3;
    L23:
        if (r4 == null) goto L29;
        ImageInfo r5 = r4.f;
        if (r5 == null) goto L29;
        Image r14 = r5.a;
        if (r14 == null) goto L29;
        String r15 = r14.a;
    L31:
        if (Intrinsics.areEqual(r15, r10) == true) goto L35;
        r2 = r2 + 1;
    L35:
        if (r2 <= (-1)) goto L46;
        LarusWidgetMarkdownCreationImageScrollBinding r16 = this.a.d;
        if (r16 == null) goto L47;
        RecyclerView r17 = r16.b;
        if (r17 == null) goto L48;
        r17.scrollToPosition(r2);
        return;
    L48:
        return;
    L47:
        return;
    L46:
        return;
    L29:
        r15 = null;
        goto L31
    L22:
        r4 = null;
    L34:
        r2 = -1;
        goto L35
    L49:
        return;
    L45:
        return;
    L44:
        return;
    L5:
        r8 = null;
        goto L6
    }
}
