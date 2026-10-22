package com.ss.android.lark.chat.api.service.impl;

import com.bytedance.lark.pb.basic.v1.SyncDataStrategy;
import com.larksuite.framework.callback.IGetDataCallback;
import com.larksuite.framework.callback.UIGetDataCallback;
import com.ss.android.lark.biz.im.api.ThreadTopic;
import com.ss.android.lark.chat.core.model.ChannelDataFetcherStrategy;
import com.ss.android.lark.chat.core.model.MessageFetchScene;
import com.ss.android.lark.flow.replyinthread.pages.plugin.ReplyInThreadTitleBarPlugin;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.passportc.api.ContainerConstsKt;
import com.ss.android.lark.passportc.entity.UserSession;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class u1 extends c0c.b implements com.ss.android.lark.biz.im.api.o0 {
    public final /* synthetic */ com.ss.android.lark.biz.im.api.o0 b;
    public final com.ss.android.lark.passportc.internal.v c;
    public final com.ss.android.lark.passportc.convention.b<com.ss.android.lark.biz.im.api.o0> d;

    public static final class a {
    }

    static {
    }

    public final void Dd(String r2, UIGetDataCallback r3) {
        this.b.Dd(r2, r3);
    }

    public final void J7(String r2, boolean r3, ReplyInThreadTitleBarPlugin.showMoreOperationMenu.1.2 r4) {
        this.b.J7(r2, r3, r4);
    }

    public final void N6(String r2, SyncDataStrategy r3, IGetDataCallback r4) {
        this.b.N6(r2, r3, r4);
    }

    public final l5b.a Qb(String r11, MessageFetchScene r12, int r13, int r14, int r15, ChannelDataFetcherStrategy r16, int r17, boolean r18) {
        return this.b.Qb(r11, r12, r13, r14, r15, r16, r17, true);
    }

    public final ThreadTopic Vd(String r2) {
        return this.b.Vd(r2);
    }

    public final void ja(String r2, boolean r3, ReplyInThreadTitleBarPlugin.showMoreOperationMenu.2.1 r4) {
        this.b.ja(r2, r3, r4);
    }

    public final void q5(List r2, int r3, int r4) {
        this.b.q5(r2, r3, r4);
    }

    public u1(com.ss.android.lark.passportc.api.j r4, com.ss.android.lark.passportc.internal.v r5) {
        UserSession r1 = r4.b();
        if (r1 != null) goto L5;
        r1 = ContainerConstsKt.a();
    L5:
        com.ss.android.lark.passportc.convention.b<com.ss.android.lark.biz.im.api.o0> r0 = new com.ss.android.lark.passportc.convention.b(e0c.k.b(r5.c(r1), com.ss.android.lark.biz.im.api.o0.class), com.ss.android.lark.biz.im.api.o0.class);
        Intrinsics.checkNotNullParameter(r4, "passport");
        Intrinsics.checkNotNullParameter(r5, "accessor");
        Intrinsics.checkNotNullParameter(r0, "instanceHolder");
        super(r4);
        this.b = (com.ss.android.lark.biz.im.api.o0) r0.b();
        this.c = r5;
        this.d = r0;
    }

    public final void qf(f0c.g r2, f0c.g r3) {
        Log.i("ThreadServiceProxy", "preparing IThreadService");
        com.ss.android.lark.passportc.internal.v r4 = this.c;
        if (r3 == null) goto L6;
        UserSession r5 = r3.b;
        if (r5 == null) goto L6;
    L7:
        com.ss.android.lark.biz.im.api.o0 r6 = (com.ss.android.lark.biz.im.api.o0) e0c.k.b(r4.c(r5), com.ss.android.lark.biz.im.api.o0.class);
        this.d.e(r6);
        return;
    L6:
        r5 = ContainerConstsKt.a();
        goto L7
    }
}
