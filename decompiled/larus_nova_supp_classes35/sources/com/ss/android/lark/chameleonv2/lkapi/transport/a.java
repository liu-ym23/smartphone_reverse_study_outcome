package com.ss.android.lark.chameleonv2.lkapi.transport;

import android.app.Application;
import com.bytedance.lark.pb.basic.v1.Command;
import com.bytedance.lark.pb.contact.v1.MGetChattersRequest;
import com.bytedance.lark.pb.contact.v1.MGetChattersResponse;
import com.bytedance.lark.pb.openplatform.v1.PullOpenAppBadgeNodesRequest;
import com.bytedance.lark.pb.openplatform.v1.PullOpenAppBadgeNodesResponse;
import com.bytedance.lark.rustclient.api.l;
import com.bytedance.lark.rustclient.api.t;
import com.ss.android.lark.chameleon.AbsChameleonHandler;
import com.ss.android.lark.chameleon.Callback;
import com.ss.android.lark.chameleon.IChameleonHandlerContext;
import com.ss.android.lark.chameleon.LKAPIError;
import com.ss.android.lark.chameleon.LKAPIModules;
import com.ss.android.lark.passport.signinsdk_api.account.User;
import com.ss.android.lark.passportc.api.m;
import com.ss.android.lark.utils.LarkContext;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import e0c.k;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import o1b.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a extends AbsChameleonHandler<ITransport$Internal$CallRustApiRequest> {
    public final String a;

    public a() {
        this.a = LKAPIModules.Internal.Transport.CallRustApi.getValue();
    }

    @Override // com.ss.android.lark.chameleon.AbsChameleonHandler
    public final String getName() {
        return this.a;
    }

    @Override // com.ss.android.lark.chameleon.AbsChameleonHandler
    public final void handle(ITransport$Internal$CallRustApiRequest r18, final Callback r19) {
        final ITransport$Internal$CallRustApiRequest r1 = r18;
        Intrinsics.checkNotNullParameter(r1, "req");
        Intrinsics.checkNotNullParameter(r19, "callback");
        Application r2 = LarkContext.getApplication();
        MGetChattersRequest.Builder r3 = null;
        if (r2 == null) goto L7;
        q1b.a r4 = (q1b.a) k.a(r2, q1b.a.class);
        if (r4 == null) goto L7;
        l r5 = r4.g();
    L9:
        if (r5 != null) goto L11;
        r19.error(new LKAPIError(-1, "rustClient is null"));
        return;
    L11:
        IChameleonHandlerContext r6 = getContext();
        if (r6 != null) goto L14;
        r19.error(new LKAPIError(-1, "chameleonContext is null"));
        return;
    L14:
        Application r7 = LarkContext.getApplication();
        if (r7 == null) goto L24;
        q1b.a r8 = (q1b.a) k.a(r7, q1b.a.class);
        if (r8 == null) goto L24;
        m r9 = r8.r9();
        if (r9 == null) goto L24;
        User r10 = r9.getUser();
        if (r10 == null) goto L24;
        final String r11 = r10.userId;
        if (r11 == null) goto L24;
    L25:
        String r12 = r6.getBizName();
        int r13 = WhiteMap.a;
        if (WhiteMap.a(r12, r1.getCommand()) == true) goto L28;
        r19.error(new LKAPIError(-1, "not implement command=" + r1.getCommand() + " bizName=" + r12));
        return;
    L28:
        int r14 = r1.getCommand();
        Command r15 = Command.MGET_CHATTERS;
        if (r14 != r15.getValue()) goto L43;
        int r16 = f.a;
        String r17 = r1.getParams();
        if (Intrinsics.areEqual(MGetChattersRequest.Builder.class, MGetChattersRequest.Builder.class) == false) goto L34;
        r3 = o1b.b.a(r17);
    L36:
        MGetChattersRequest.Builder r20 = r3;
        if (r20 == null) goto L42;
        if (t.a(r5.h(new com.bytedance.lark.rustclient.api.d(r20, MGetChattersResponse.ADAPTER, r15, null, null, null, null, 248)).a(), new CallRustApiHandler$handle$1$1(r1, r11, r19), new CallRustApiHandler$handle$1$2(r19), new CallRustApiHandler$handle$1$3(r19)) == null) goto L42;
        return;
    L42:
        r19.error(new LKAPIError(-1, "invalid params"));
        Unit r0 = Unit.INSTANCE;
        return;
    L34:
        if (Intrinsics.areEqual(MGetChattersRequest.Builder.class, PullOpenAppBadgeNodesRequest.Builder.class) == false) goto L36;
        r3 = o1b.c.a(r17);
        goto L36
    L43:
        Command r110 = Command.PULL_OPEN_APP_BADGE_NODES;
        if (r14 != r110.getValue()) goto L56;
        int r21 = f.a;
        String r22 = r1.getParams();
        if (Intrinsics.areEqual(PullOpenAppBadgeNodesRequest.Builder.class, MGetChattersRequest.Builder.class) == false) goto L49;
        r3 = (PullOpenAppBadgeNodesRequest.Builder) o1b.b.a(r22);
    L51:
        MGetChattersRequest.Builder r23 = r3;
        if (r23 != null) goto L54;
    L55:
        r19.error(new LKAPIError(-1, "invalid params"));
        Unit r24 = Unit.INSTANCE;
        return;
    L54:
        if (t.a(r5.h(new com.bytedance.lark.rustclient.api.d(r23, PullOpenAppBadgeNodesResponse.ADAPTER, r110, null, null, null, null, 248)).a(), new CallRustApiHandler$handle$3$1(r1, r11, r19), new CallRustApiHandler$handle$3$2(r19), new CallRustApiHandler$handle$3$3(r19)) == null) goto L55;
        return;
    L49:
        if (Intrinsics.areEqual(PullOpenAppBadgeNodesRequest.Builder.class, PullOpenAppBadgeNodesRequest.Builder.class) == false) goto L51;
        r3 = o1b.c.a(r22);
        goto L51
    L56:
        r19.error(new LKAPIError(-1, "not implement command " + r1.getCommand()));
        Unit r25 = Unit.INSTANCE;
        return;
    L24:
        r11 = BuildConfig.FLAVOR;
    L7:
        r5 = null;
        goto L9
    }
}
