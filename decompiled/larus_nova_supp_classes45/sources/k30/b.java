package k30;

import com.bytedance.android.live.browser.jsbridge.base.TogetherSlotMethodResultModel;
import com.bytedance.android.livesdk.gift.platform.core.GiftContext;
import com.bytedance.android.scope.j;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.live.datacontext.k;
import i02.d;
import i02.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import w20.ff;
import w20.w6;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class b extends w6<ff, TogetherSlotMethodResultModel> {
    public final j a;

    public b(j r1) {
        this.a = r1;
    }

    public final void invoke(Object r5, CallContext r6) {
        ff r7 = (ff) r5;
        Intrinsics.checkNotNullParameter(r7, "params");
        Intrinsics.checkNotNullParameter(r6, "context");
        ArrayList r8 = new ArrayList();
        List<ff.a> r0 = r7.b();
        if (r0 == null) goto L11;
        Iterator<T> r1 = r0.iterator();
    L6:
        if (r1.hasNext() == false) goto L11;
        ff.a r2 = (ff.a) r1.next();
        List<Integer> r3 = r2.a();
        Integer r4 = r2.b();
        if (r3 == null) goto L6;
        if (r4 == null) goto L6;
        r8.add(new e(r3, r4.intValue()));
    L11:
        String r9 = r7.c();
        Integer r11 = r7.a();
        if (r11 == null) goto L14;
        int r12 = r11.intValue();
    L15:
        d r13 = new d(r9, r8, r12);
        GiftContext r14 = com.bytedance.android.livesdk.gift.util.b.b();
        if (r14 == null) goto L28;
        k r15 = r14.getSendTogetherSlotChangeEvent();
        if (r15 == null) goto L29;
        r15.post(r13);
        return;
    L29:
        return;
    L28:
        return;
    L14:
        r12 = 0;
        goto L15
    }
}
