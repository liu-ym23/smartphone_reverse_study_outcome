package com.bytedance.android.livesdk.interactivity.comment.newinput.provider;

import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.livesdk.interactivity.InteractivityPlatformContext;
import io.reactivex.functions.Consumer;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class f2<T> implements Consumer {
    public final /* synthetic */ t1.c a;

    public f2(t1.c r1) {
        this.a = r1;
    }

    public final void accept(Object r9) {
        com.bytedance.android.live.network.response.e r10 = (com.bytedance.android.live.network.response.e) r9;
        c32.c r0 = (c32.c) ((ExtraResponse) r10).data;
        Long r1 = null;
        if (r0 == null) goto L5;
        List<c32.d> r3 = r0.results;
    L6:
        List<c32.d> r2 = r3;
        if (r2 != null) goto L9;
    L12:
        boolean r4 = true;
    L13:
        if (r4 == false) goto L15;
        this.a.h();
        return;
    L15:
        Iterator<c32.d> r5 = r3.iterator();
    L17:
        if (r5.hasNext() == false) goto L19;
        c32.d r6 = r5.next();
        r6.b = false;
        r6.c = ((c32.c) ((ExtraResponse) r10).data).associationIdStr;
        goto L17
    L19:
        com.bytedance.android.livesdk.interactivity.api.h r7 = com.bytedance.android.livesdk.interactivity.api.q.g();
        if ((r7 instanceof InteractivityPlatformContext) == true) goto L22;
        r7 = null;
    L22:
        InteractivityPlatformContext r8 = (InteractivityPlatformContext) r7;
        if (r8 == null) goto L27;
        com.bytedance.live.datacontext.n<c32.c> r11 = r8.getWordAssociateResult();
        if (r11 == null) goto L27;
        r11.setValue(((ExtraResponse) r10).data);
    L27:
        t1.c r13 = this.a;
        c32.c r14 = (c32.c) ((ExtraResponse) r10).data;
        if (r14 == null) goto L30;
        r1 = Long.valueOf(r14.a);
    L30:
        r13.j(r3, r1.longValue(), false, ((c32.c) ((ExtraResponse) r10).data).associationIdStr);
        return;
    L9:
        if (r2.isEmpty() == true) goto L12;
        r4 = false;
        goto L13
    L5:
        r3 = null;
        goto L6
    }
}
