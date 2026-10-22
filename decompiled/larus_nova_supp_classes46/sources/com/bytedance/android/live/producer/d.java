package com.bytedance.android.live.producer;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.core.content.ContextCompat;
import com.bytedance.android.live.core.utils.v;
import com.bytedance.android.live.room.api.base.alog.SimpleAlogArgsBuilder;
import com.bytedance.android.live.room.api.experience.context.PlatformExpRoomContext;
import com.bytedance.android.live.room.api.experience.log.ExpOptLog;
import com.bytedance.android.live.room.api.experience.utils.PlatformExpUtils;
import com.bytedance.crash.Npth;
import com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterLancet;
import df6.g;
import io.reactivex.disposables.Disposables;
import io.reactivex.functions.Action;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class d extends i61.a {
    public final Lazy c;
    public final Lazy d;
    public final Lazy e;

    public static final class a implements Action {
        public final /* synthetic */ d a;

        public a(d r1) {
            this.a = r1;
        }

        public final void run() {
            Context r0 = g.getContext();
            if (r0 == null) goto L18;
            BroadcastReceiver r1 = (BroadcastReceiver) this.a.e.getValue();
            ReceiverRegisterLancet.loge(r1, false);
            if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == true) goto L16;
            r0.unregisterReceiver(r1);
            return;
        L16:
        L10:
            e = move-exception;
            if (r1 == null) goto L13;
            Npth.addTag("unregisterReceiver", r1.toString());
        L13:
            e.printStackTrace();
            return;
        L7:
            if (ReceiverRegisterAnrOptimizer.unregisterReceiverHasNonScreenFilter(r1, r0) == false) goto L19;
            r0.unregisterReceiver(r1);     // Catch: Exception -> L10
            return;
        L19:
            return;
        }
    }

    public final String a() {
        return "LocalTestProducer";
    }

    public final void launch() {
        if (v.a() == true) goto L5;
        return;
    L5:
        if (PlatformExpUtils.c().e() == false) goto L46;
        SimpleAlogArgsBuilder r0 = new SimpleAlogArgsBuilder();
        r0.d((String) this.c.getValue());
        r0.c("监听本地广播，mock性能数据");
        ExpOptLog.d(r0.b());
        Context r1 = g.getContext();
        if (r1 == null) goto L40;
        BroadcastReceiver r8 = (BroadcastReceiver) this.e.getValue();
        IntentFilter r9 = new IntentFilter("android.intent.action.LIVE_EXP_OPT_TEST");
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L43;
        ReceiverRegisterCrashOptimizer.doHWReceiverFix();
    L43:
    L35:
        e = move-exception;
        e.toString();
        e.printStackTrace();
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L39;
        ReceiverRegisterCrashOptimizer.registerReceiver(r8, r9);
        goto L40
    L39:
        throw e;
    L13:
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == false) goto L26;
        if (ReceiverRegisterAnrOptimizer.hasScreenActions(r9) == false) goto L26;
        int r2 = ReceiverRegisterAnrOptimizer.handleScreenActionRegistration(r8, r9, 0, null, null, 2, r1).result;     // Catch: Exception -> L35
        if (r2 != 1) goto L19;
        r1.registerReceiver(r8, r9);     // Catch: Exception -> L35
    L42:
        goto L40
    L19:
        if (r2 != 2) goto L21;
        new Intent();     // Catch: Exception -> L35
        goto L42
    L21:
        if (r2 == 3) goto L42;
        r1.registerReceiver(r8, r9);     // Catch: Exception -> L35
    L26:
        if (ReceiverRegisterCrashOptimizer.doRegisterHandler() == false) goto L29;
        ReceiverRegisterLancet.initHandler();     // Catch: Exception -> L35
        r1.registerReceiver(r8, r9, null, ReceiverRegisterLancet.sReceiverHandler);     // Catch: Exception -> L35
        goto L42
    L29:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler() != null) goto L31;
    L33:
        r1.registerReceiver(r8, r9);     // Catch: Exception -> L35
        goto L42
    L31:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler().needHookFilter(r9) == false) goto L33;
        ReceiverRegisterLancet.initProxyHandler();     // Catch: Exception -> L35
        ContextCompat.registerReceiver(r1, r8, r9, null, ReceiverRegisterLancet.sProxyHandler, 2);     // Catch: Exception -> L35
    L40:
        ((i61.a) this).a.add(Disposables.fromAction(new a(this)));
        return;
    }

    public d(PlatformExpRoomContext r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        this.c = LazyKt.lazy(LocalTestProducer$tag$2.INSTANCE);
        this.d = LazyKt.lazy(LocalTestProducer$perfTypeMap$2.INSTANCE);
        this.e = LazyKt.lazy(new LocalTestProducer$br$2(this));
    }
}
