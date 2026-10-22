package com.ss.android.lark.flow.group;

import android.content.Context;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.List;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class f implements Runnable {
    public final /* synthetic */ Context a;
    public final /* synthetic */ String b;
    public final /* synthetic */ List<String> c;
    public final /* synthetic */ String d;
    public final /* synthetic */ String e;
    public final /* synthetic */ FlowJoinGroupChatUtil.CallbackWrap f;

    public f(Context r1, String r2, List<String> r3, String r4, String r5, FlowJoinGroupChatUtil.CallbackWrap r6) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
    }

    public final void a() {
        int r0 = FlowJoinGroupChatUtil.a;
        Context r1 = this.a;
        final String r2 = this.b;
        final List<String> r3 = this.c;
        final String r5 = this.d;
        final String r6 = this.e;
        final FlowJoinGroupChatUtil.CallbackWrap r7 = this.f;
        final Ref.ObjectRef r4 = new Ref.ObjectRef();
        com.larksuite.component.ui.dialog.d r8 = new com.larksuite.component.ui.dialog.d(r1);
        r8.c.contentLayoutRes(2131561142);
        r8.c.style(2131953930);
        r8.b = 2131953930;
        g r9 = new g(r7);
        r8.c.onCancelListener(r9);
        r8.g(new h(r4, r1));
        r8.a(2131378550, 2131891541, new i(r7));
        r8.a(2131378551, 2131891623, new FlowJoinGroupChatUtil$showChatChatterApplyDialog$4(r2, r3, r4, r5, r6, r7));
        r8.i();
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
