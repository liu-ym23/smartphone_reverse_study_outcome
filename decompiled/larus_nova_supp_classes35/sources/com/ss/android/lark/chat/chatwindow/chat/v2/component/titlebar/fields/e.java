package com.ss.android.lark.chat.chatwindow.chat.v2.component.titlebar.fields;

import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.passportc.api.ContainerConstsKt;
import com.ss.android.lark.passportc.api.j;
import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.lark.passportc.internal.v;
import e0c.k;
import f0c.g;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class e extends c0c.b implements b {
    public final /* synthetic */ b b;
    public final v c;
    public final com.ss.android.lark.passportc.convention.b<b> d;

    public static final class a {
    }

    static {
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.titlebar.fields.b
    public final c Eb(String r2) {
        Intrinsics.checkNotNullParameter(r2, "userId");
        return this.b.Eb(r2);
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.titlebar.fields.b
    public final boolean O8() {
        return this.b.O8();
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.titlebar.fields.b
    public final void X7(String r2, IGetDataCallback<c> r3) {
        Intrinsics.checkNotNullParameter(r2, "userId");
        Intrinsics.checkNotNullParameter(r3, "callback");
        this.b.X7(r2, r3);
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.titlebar.fields.b
    public final void w3(String r2, IGetDataCallback<c> r3) {
        Intrinsics.checkNotNullParameter(r2, "userId");
        Intrinsics.checkNotNullParameter(r3, "callback");
        this.b.w3(r2, r3);
    }

    public e(j r4, v r5) {
        UserSession r1 = r4.b();
        if (r1 != null) goto L5;
        r1 = ContainerConstsKt.a();
    L5:
        com.ss.android.lark.passportc.convention.b<b> r0 = new com.ss.android.lark.passportc.convention.b(k.b(r5.c(r1), b.class), b.class);
        Intrinsics.checkNotNullParameter(r4, "passport");
        Intrinsics.checkNotNullParameter(r5, "accessor");
        Intrinsics.checkNotNullParameter(r0, "instanceHolder");
        super(r4);
        this.b = (b) r0.b();
        this.c = r5;
        this.d = r0;
    }

    public final void qf(g r2, g r3) {
        Log.i("UserFieldsServiceProxy", "preparing IUserFieldsService");
        v r4 = this.c;
        if (r3 == null) goto L6;
        UserSession r5 = r3.b;
        if (r5 == null) goto L6;
    L7:
        b r6 = (b) k.b(r4.c(r5), b.class);
        this.d.e(r6);
        return;
    L6:
        r5 = ContainerConstsKt.a();
        goto L7
    }
}
