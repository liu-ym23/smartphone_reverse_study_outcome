package com.bytedance.android.live.revenue.platform.container.impl;

import android.view.View;
import com.bytedance.badger.collect.impl.constants.Constants;
import com.bytedance.platform.aio.ServiceHub;
import com.bytedance.platform.aio.channel.AbstractChannelClient;
import com.bytedance.platform.aio.channel.js.model.BytesContentType;
import com.bytedance.platform.aio.settings.GiftPanelOptSettingsKt;
import io.reactivex.disposables.CompositeDisposable;
import java.util.Map;
import kotlin.Pair;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class h0<T, R> implements com.bytedance.platform.aio.channel.c<T, R> {
    public final CompositeDisposable a;
    public final com.bytedance.platform.aio.c b;
    public final b<T, R> c;
    public final i57.a d;
    public final Function0<Pair<View, String>> e;

    public static final class a<T> {
        public final T a;
        public final BytesContentType b;

        public a(T r2, BytesContentType r3) {
            Intrinsics.checkNotNullParameter(r2, Constants.Keys.DATA);
            Intrinsics.checkNotNullParameter(r3, "contentType");
            this.a = r2;
            this.b = r3;
        }
    }

    public interface b<T, R> {
        <V> a<T> a(V r1, BytesContentType r2);

        <W> Map<String, String> b(W r1);
    }

    public h0(ServiceHub r2, g0 r3, i57.a r4, Function0 r5) {
        Intrinsics.checkNotNullParameter(r2, "serviceHub");
        Intrinsics.checkNotNullParameter(r3, "typeAdapter");
        Intrinsics.checkNotNullParameter(r4, "aioCallContext");
        Intrinsics.checkNotNullParameter(r5, "getMonitorParams");
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.a = new CompositeDisposable();
        GiftPanelOptSettingsKt.a();
    }

    public final void a(String r12, String r13, AbstractChannelClient.a r14, BytesContentType r15) {
        Intrinsics.checkNotNullParameter(r12, "interfaceId");
        Intrinsics.checkNotNullParameter(r13, "methodId");
        Intrinsics.checkNotNullParameter(r14, "channel");
        Intrinsics.checkNotNullParameter(r15, "preferredContentType");
        jy0.b.d("RevenueJsMethodServer", "onAccept interfaceid: " + r12 + ", methodId: " + r13);
        com.bytedance.platform.aio.a r0 = this.b.b(r12);
        if (r0 != null) goto L5;
        r0 = new l();
    L5:
        com.bytedance.platform.aio.a r5 = r0;
        h57.a r1 = new h57.a();
        r14.c(r1);
        CompositeDisposable r8 = new CompositeDisposable();
        this.a.add(r8);
        r14.f = new i0(r8);
        com.bytedance.revenue.platform.api.core.rx.f.a(r1.b.take(1).subscribe(new j0(this, r15, r14, r5, r12, r13, r8), new k0(this, r14, r12, r13)), this.a);
    }
}
