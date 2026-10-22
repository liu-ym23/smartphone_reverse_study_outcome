package com.ss.android.lark.officesdk.minutes.service.foundation.network.core;

import com.bytedance.lark.rustclient.api.t;
import com.squareup.wire.ProtoAdapter;
import com.ss.android.lark.pb.improto.Command;
import io.reactivex.disposables.Disposable;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import kotlinx.coroutines.flow.d1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class e implements com.ss.android.lark.officesdk.minutes.service.foundation.network.a {
    public final /* synthetic */ d a;

    public e(d r1) {
        this.a = r1;
    }

    @Override // com.ss.android.lark.officesdk.minutes.service.foundation.network.a
    public final void c(Command r6) {
        Intrinsics.checkNotNullParameter(r6, "command");
        Disposable r0 = this.a.e.remove(r6);
        if (r0 == null) goto L5;
        lvb.a.e("MmNetPushHandler", "unRegisterServerPush command=" + r6 + ", disposable=" + r0);
        r0.dispose();
    L5:
        MutableSharedFlow<?> r1 = this.a.g.remove(r6);
        if (r1 == null) goto L9;
        lvb.a.e("MmNetPushHandler", "unRegisterServerPush command=" + r6 + ", flow=" + r1);
        return;
    }

    @Override // com.ss.android.lark.officesdk.minutes.service.foundation.network.a
    public final void d(com.bytedance.lark.pb.basic.v1.Command r6) {
        Intrinsics.checkNotNullParameter(r6, "command");
        Disposable r0 = this.a.d.remove(r6);
        if (r0 == null) goto L5;
        lvb.a.e("MmNetPushHandler", "unRegisterPush command=" + r6 + ", disposable=" + r0);
        r0.dispose();
    L5:
        MutableSharedFlow<?> r1 = this.a.f.remove(r6);
        if (r1 == null) goto L9;
        lvb.a.e("MmNetPushHandler", "unRegisterPush command=" + r6 + ", flow=" + r1);
        return;
    }

    @Override // com.ss.android.lark.officesdk.minutes.service.foundation.network.a
    public final <R> d1<R> a(Command r5, Class<R> r6) {
        Intrinsics.checkNotNullParameter(r5, "command");
        Intrinsics.checkNotNullParameter(r6, "respType");
        MutableSharedFlow r0 = this.a.g.get(r5);
        if ((r0 instanceof MutableSharedFlow) == false) goto L5;
        MutableSharedFlow r1 = r0;
    L6:
        if (r1 != null) goto L10;
        lvb.a.e("MmNetPushHandler", "registerServerPush new, command=" + r5 + ", respType=" + r6);
        final d r2 = this.a;
        ProtoAdapter r7 = ProtoAdapter.get(r6);
        r2.getClass();
        final MutableSharedFlow<?> r3 = SharedFlowKt.MutableSharedFlow(0, 64, BufferOverflow.SUSPEND);
        Disposable r8 = t.g(r2.a.c(r5, r7), new MmNetPushHandler$transformServerFlow$subtitleDisposable$1(r2, r3), MmNetPushHandler$transformServerFlow$subtitleDisposable$2.INSTANCE);
        r2.g.put(r5, r3);
        r2.e.put(r5, r8);
        return r3;
    L10:
        return r1;
    L5:
        r1 = null;
        goto L6
    }

    @Override // com.ss.android.lark.officesdk.minutes.service.foundation.network.a
    public final <R> d1<R> b(com.bytedance.lark.pb.basic.v1.Command r5, Class<R> r6) {
        Intrinsics.checkNotNullParameter(r5, "command");
        Intrinsics.checkNotNullParameter(r6, "respType");
        MutableSharedFlow r0 = this.a.f.get(r5);
        if ((r0 instanceof MutableSharedFlow) == false) goto L5;
        MutableSharedFlow r1 = r0;
    L6:
        if (r1 != null) goto L10;
        lvb.a.e("MmNetPushHandler", "registerClientPush new, command=" + r5 + ", respType=" + r6);
        final d r2 = this.a;
        ProtoAdapter r7 = ProtoAdapter.get(r6);
        r2.getClass();
        final MutableSharedFlow<?> r3 = SharedFlowKt.MutableSharedFlow(0, 64, BufferOverflow.SUSPEND);
        Disposable r8 = t.g(r2.a.i(r5, r7), new MmNetPushHandler$transformFlow$subtitleDisposable$1(r2, r3), MmNetPushHandler$transformFlow$subtitleDisposable$2.INSTANCE);
        r2.f.put(r5, r3);
        r2.d.put(r5, r8);
        return r3;
    L10:
        return r1;
    L5:
        r1 = null;
        goto L6
    }
}
