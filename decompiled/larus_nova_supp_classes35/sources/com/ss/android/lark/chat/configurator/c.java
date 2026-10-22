package com.ss.android.lark.chat.configurator;

import androidx.recyclerview.widget.RecyclerView;
import com.ss.android.lark.biz.im.api.extension.scroll.ScrollEvent;
import com.ss.android.lark.chat.base.view.recycleview.ItemShineManager;
import com.ss.android.lark.chat.constant.ChatFromType;
import com.ss.android.lark.log.Log;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import s2b.q;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class c implements com.ss.android.lark.biz.im.api.extension.scroll.b {
    public final /* synthetic */ a a;
    public final /* synthetic */ int b;
    public final /* synthetic */ q c;

    public final void a(String r7, ScrollEvent r8) {
        Intrinsics.checkNotNullParameter(r7, "taskId");
        Intrinsics.checkNotNullParameter(r8, "event");
        a r9 = this.a;
        int r10 = this.b;
        q r0 = this.c;
        RecyclerView r1 = r9.a.Et();
        if (r1 == null) goto L20;
        int r2 = r0.b();
        boolean r3 = r9.a.sX();
        boolean r4 = o2b.a.a;
        if (o2b.a.a(r9.d) == false) goto L15;
        y6b.c r5 = (y6b.c) CollectionsKt.getOrNull(r9.a.Tc().getData(), r2);
        if (r5 != null) goto L10;
    L12:
        boolean r6 = false;
    L13:
        if (r6 == false) goto L15;
        r3 = false;
        goto L15
    L10:
        if (r5.j() != true) goto L12;
        r6 = true;
    L15:
        r9.a.Cs(r3);
        Log.i("InitialPositionHandler", "onScrollDone messagePosition:" + r10 + ",position:" + r2 + ",allowItemShine:" + r3);
        if (r3 == false) goto L19;
        ItemShineManager<?> r11 = r9.a.oV();
        int r12 = !Intrinsics.areEqual(r9.c, ChatFromType.REPLY_IN_THREAD) ? 1 : 0;
        ItemShineManager<?> r13 = new ItemShineManager(r1, new e(r2), f.a);
        r13.d = r12;
        r13.a();
        r9.a.CU(r13);
        r1.post(new d(r11, r13));
        return;
    L19:
        return;
    }

    public final void b(String r1, ScrollEvent r2) {
        com.ss.android.lark.biz.im.api.extension.scroll.b.a.c(r1, r2);
    }

    public final void c(String r2, ScrollEvent r3) {
        Intrinsics.checkNotNullParameter(r2, "taskId");
        Intrinsics.checkNotNullParameter(r3, "event");
    }

    public final void d(String r1, ScrollEvent r2) {
        com.ss.android.lark.biz.im.api.extension.scroll.b.a.b(r1, r2);
    }

    public final void e(String r1, ScrollEvent r2) {
        com.ss.android.lark.biz.im.api.extension.scroll.b.a.a(r1, r2);
    }

    public c(a r1, int r2, q r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
