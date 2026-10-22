package com.larus.bmhome.chat.layout.holder.helper;

import android.view.View;
import androidx.fragment.app.FragmentManager;
import com.larus.im.bean.message.Message;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class v1 {
    public static final void a(List r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        com.larus.bmhome.view.screenmenu.l0 r0 = com.larus.bmhome.chat.layout.holder.menu.item.l.a();
        if (r0 == null) goto L6;
        ((ArrayList) r1).add(r0);
        return;
    }

    public static final long c(View r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Intrinsics.checkNotNullParameter(r2, "<this>");     // Catch: Exception -> L5
        return FragmentManager.findFragment(r2).getChatUniqueKey();
    L5:
        FLogger.a.d("IPopMenuCreator", "getChatUniqueKey error");
        return -1;
    }

    public static final void b(List r3, com.larus.bmhome.chat.api.q0.a r4) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        if (r4 == null) goto L9;
        com.larus.bmhome.chat.component.collection.o r5 = r4.i2();
        if (r5 == null) goto L9;
        if (r5.i0() != true) goto L9;
        boolean r6 = true;
    L10:
        if (r6 == false) goto L13;
        final Integer[] r7 = {2131907401, 2131907410, 2131907407, 2131907402};
        com.larus.utils.h.e(r3, new t1(r7));
        return;
    L13:
        return;
    L9:
        r6 = false;
        goto L10
    }

    public static final void d(List r3, Message r4, wc9.e r5, com.larus.bmhome.chat.api.q0.a r6) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        Intrinsics.checkNotNullParameter(r4, "data");
        if (r6 == null) goto L9;
        com.larus.bmhome.chat.component.collection.o r2 = r6.i2();
        if (r2 == null) goto L9;
        if (r2.i0() != true) goto L9;
        boolean r7 = true;
    L10:
        if (r7 == false) goto L13;
        b(r3, r6);
        return;
    L13:
        final Integer[] r8 = {2131901131, 2131907410};
        if (r5 == null) goto L21;
        Long r9 = r5.p;
        if (r9 != null) goto L18;
        return;
    L18:
        if (r4.getServerIndex() >= r9.longValue()) goto L23;
        com.larus.utils.h.e(r3, new u1(r8));
        return;
    L23:
        return;
    L21:
        return;
    L9:
        r7 = false;
        goto L10
    }
}
