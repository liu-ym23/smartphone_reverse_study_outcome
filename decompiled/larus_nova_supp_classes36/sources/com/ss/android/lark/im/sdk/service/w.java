package com.ss.android.lark.im.sdk.service;

import com.larksuite.framework.callback.Entity.ErrorResult;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.MessageParams;
import com.ss.android.lark.chat.service.impl.MonitorMessageSendCallback;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class w implements n6b.c<o6b.b> {
    public final /* synthetic */ o a;
    public final /* synthetic */ ImSdkMessageServiceImplV2 b;
    public final /* synthetic */ MessageParams<?, ?> c;

    public final void g(Object r4) {
        Intrinsics.checkNotNullParameter((o6b.b) r4, "preMessageResponse");
        this.a.m(this);
        CopyOnWriteArrayList<d> r5 = this.b.d;
        MessageParams<?, ?> r0 = this.c;
        Iterator<d> r6 = r5.iterator();
    L4:
        if (r6.hasNext() == false) goto L6;
        d r1 = r6.next();
        Message.Type r2 = r0.e;
        r1.onSendSuccess();
        goto L4
    }

    public final void a(ErrorResult r3, Message r4) {
        Intrinsics.checkNotNullParameter(r3, "error");
        Intrinsics.checkNotNullParameter(r4, "preMessage");
        this.a.m(this);
        CopyOnWriteArrayList<d> r5 = this.b.d;
        MessageParams<?, ?> r6 = this.c;
        Iterator<d> r7 = r5.iterator();
    L4:
        if (r7.hasNext() == false) goto L6;
        d r0 = r7.next();
        Message.Type r1 = r6.e;
        r0.onSendFailed();
        goto L4
    }

    public final void k(jkb.e r3, Message r4) {
        Intrinsics.checkNotNullParameter(r3, "reason");
        this.a.m(this);
        CopyOnWriteArrayList<d> r5 = this.b.d;
        MessageParams<?, ?> r6 = this.c;
        Iterator<d> r7 = r5.iterator();
    L4:
        if (r7.hasNext() == false) goto L6;
        d r0 = r7.next();
        Message.Type r1 = r6.e;
        r0.onSendSuccess();
        goto L4
    }

    public w(MonitorMessageSendCallback r1, ImSdkMessageServiceImplV2 r2, MessageParams r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
