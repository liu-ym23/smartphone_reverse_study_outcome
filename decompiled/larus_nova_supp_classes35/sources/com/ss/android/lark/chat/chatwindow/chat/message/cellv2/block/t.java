package com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block;

import com.ss.android.lark.image.api.DataSource;
import com.ss.android.lark.image.entity.ListenerParams;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class t implements ListenerParams.b {
    public final /* synthetic */ com.ss.android.lark.chat.utils.v a;

    public t(u r1) {
        this.a = r1;
    }

    public final void a(Exception r1) {
        com.ss.android.lark.chat.utils.v r2 = this.a;
        if (r2 == null) goto L6;
        r2.onFinish();
        return;
    }

    public final void b(Object r1, Object r2, DataSource r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r3, "dataSource");
        com.ss.android.lark.chat.utils.v r5 = this.a;
        if (r5 == null) goto L6;
        r5.onFinish();
        return;
    }
}
