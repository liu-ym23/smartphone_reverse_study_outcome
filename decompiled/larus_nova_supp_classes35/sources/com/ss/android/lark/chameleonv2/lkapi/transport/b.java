package com.ss.android.lark.chameleonv2.lkapi.transport;

import android.app.Application;
import com.bytedance.lark.pb.basic.v1.Command;
import com.bytedance.lark.rustclient.api.l;
import com.ss.android.lark.chameleon.AbsChameleonHandler;
import com.ss.android.lark.chameleon.Callback;
import com.ss.android.lark.chameleon.IChameleonHandlerContext;
import com.ss.android.lark.chameleon.LKAPIError;
import com.ss.android.lark.chameleon.LKAPIModules;
import com.ss.android.lark.utils.LarkContext;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import e0c.k;
import io.reactivex.disposables.Disposable;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class b extends AbsChameleonHandler<ITransport$Internal$SubscribeRustPushRequest> {
    public final WeakReference<c> a;
    public final String b;
    public final Set<Integer> c;

    @Override // com.ss.android.lark.chameleon.AbsChameleonHandler
    public final String getName() {
        return this.b;
    }

    public b(WeakReference<c> r2) {
        Intrinsics.checkNotNullParameter(r2, "transport");
        this.a = r2;
        this.b = LKAPIModules.Internal.Transport.SubscribeRustPush.getValue();
        this.c = new LinkedHashSet();
    }

    public final <T> void a(int r6, T r7) {
        IChameleonHandlerContext r0 = getContext();
        if (r0 == null) goto L6;
        r0.sendEvent(ITransport$Ipc$EventType.SDK_PUSH.getValue(), new ITransport$Ipc$TransportPushDetail(r6, r7, new ITransport$Ipc$RustSdkPacketDetail(BuildConfig.FLAVOR)));
        return;
    }

    @Override // com.ss.android.lark.chameleon.AbsChameleonHandler
    public final void handle(ITransport$Internal$SubscribeRustPushRequest r6, Callback r7) {
        ITransport$Internal$SubscribeRustPushRequest r8 = r6;
        Intrinsics.checkNotNullParameter(r8, "req");
        Intrinsics.checkNotNullParameter(r7, "callback");
        if (getContext() != null) goto L5;
        r7.error(new LKAPIError(-1, "context is null"));
        return;
    L5:
        IChameleonHandlerContext r0 = getContext();
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type com.ss.android.lark.chameleon.IChameleonHandlerContext");
        String r1 = r0.getBizName();
        Iterator<ITransport$Internal$SubscribePushInfo> r9 = r8.getCommands().iterator();
    L7:
        if (r9.hasNext() == false) goto L34;
        ITransport$Internal$SubscribePushInfo r2 = r9.next();
        int r3 = WhiteMap.a;
        if (WhiteMap.a(r1, r2.getCommand()) == false) goto L7;
        if (this.c.contains(Integer.valueOf(r2.getCommand())) == true) goto L7;
        Command r4 = Command.fromValue(r2.getCommand());
        if (r4 == null) goto L25;
        this.c.add(Integer.valueOf(r2.getCommand()));
        c r5 = this.a.get();
        if (r5 == null) goto L25;
        Intrinsics.checkNotNullParameter(r4, "cmd");
        Application r10 = LarkContext.getApplication();
        if (r10 == null) goto L25;
        q1b.a r11 = (q1b.a) k.a(r10, q1b.a.class);
        if (r11 == null) goto L25;
        l r12 = r11.g();
        if (r12 == null) goto L25;
        Disposable r13 = r12.a(r4).subscribe(new d(r5));
        Set<Disposable> r14 = r5.b;
        Intrinsics.checkNotNull(r13);
        r14.add(r13);
    L25:
        r7.success(null);
        goto L7
    }
}
