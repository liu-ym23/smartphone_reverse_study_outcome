package com.ss.android.lark.contact.customized.myqrcode.view;

import com.ss.android.lark.image.api.DataSource;
import com.ss.android.lark.image.entity.ListenerParams;
import com.ss.android.lark.log.Log;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class b implements ListenerParams.b {
    public final /* synthetic */ OfficeInviteExternalCardView a;

    public b(OfficeInviteExternalCardView r1) {
        this.a = r1;
    }

    public final void a(Exception r3) {
        Log.i("Contact_InviteCardView", "onException: " + r3);
        Function2<? super Boolean, ? super DataSource, Unit> r4 = this.a.b;
        if (r4 == null) goto L6;
        r4.invoke(Boolean.FALSE, null);
        return;
    }

    public final void b(Object r1, Object r2, DataSource r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r3, "dataSource");
        Log.i("Contact_InviteCardView", "onResourceReady: " + r4);
        Function2<? super Boolean, ? super DataSource, Unit> r5 = this.a.b;
        if (r5 == null) goto L6;
        r5.invoke(Boolean.TRUE, r3);
        return;
    }
}
