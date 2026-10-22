package com.larus.bmhome.chat.list.cell.text.user;

import android.app.Activity;
import android.content.Context;
import com.larus.bmhome.chat.layout.item.i4;
import com.larus.bmhome.view.MessageMenu;
import java.lang.ref.WeakReference;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class p implements Function0 {
    public final /* synthetic */ UserTextCell a;

    public /* synthetic */ p(UserTextCell r1) {
        this.a = r1;
    }

    public final Object invoke() {
        UserTextCell r0 = this.a;
        i4 r1 = r0.e;
        Activity r2 = null;
        if (r1 == null) goto L5;
        Context r3 = r1.getContext();
    L7:
        if ((r3 instanceof Activity) == false) goto L9;
        r2 = (Activity) r3;
    L9:
        if (r2 == null) goto L12;
        WeakReference r4 = MessageMenu.x;
        r0.y = MessageMenu.a.b(r2);
    L12:
        return Boolean.FALSE;
    L5:
        r3 = null;
        goto L7
    }
}
