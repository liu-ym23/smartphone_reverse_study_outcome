package com.ss.ugc.live.sdk.msg.unify;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.ss.android.lark.lynxkit.xbridge.XBridgeLynxModule;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import com.ss.android.ugc.bytex.thread_rename.base.DefaultThreadFactory;
import com.ss.ugc.live.sdk.msg.unify.data.idl.UMGWCustomData;
import com.ss.ugc.live.sdk.msg.unify.network.UnifyWSState;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class d implements imc.b, com.ss.ugc.live.sdk.msg.unify.a {
    public PthreadHandlerThreadV2 a;
    public final com.ss.ugc.live.sdk.msg.utils.task.c b;
    public final kmc.d c;
    public final UnifyWSState d;
    public final b e;
    public f f;
    public final a g;
    public final i h;
    public final gmc.a i;

    public static final class a implements c.b {
        public final /* synthetic */ d a;

        public a(d r1) {
            this.a = r1;
        }

        @Override // com.ss.ugc.live.sdk.msg.unify.c.b
        public final void a(c r8) {
            Intrinsics.checkNotNullParameter(r8, XBridgeLynxModule.NAME);
            f r1 = this.a.f;
            if (r1 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("unifyMessageProvider");
        L5:
            r1.getClass();
            Intrinsics.checkNotNullParameter(r8, XBridgeLynxModule.NAME);
            com.ss.ugc.live.sdk.msg.utils.a.c(r1.n, "unregister bridge: " + r8.a());
            JSONObject r0 = new JSONObject();
            r0.put("service", r8.g());
            r0.put("method", r8.e());
            JSONObject r2 = new JSONObject();
            JSONObject r3 = new JSONObject();
            Iterator r4 = ((ArrayList) r8.f()).iterator();
        L7:
            if (r4.hasNext() == false) goto L9;
            UMGWCustomData r5 = (UMGWCustomData) r4.next();
            r3.put(r5.key, r5.value);
            goto L7
        L9:
            r1.n.e("ttlive_im_unified_channel_biz_unregister_" + r8.e(), r0, r2, r3);
            r1.b.sendMessage(r1.b.obtainMessage(112, r8));
        }
    }

    @Override // com.ss.ugc.live.sdk.msg.unify.a
    public final void onInit() {
        this.i.b();
        this.a = null;
        Looper r0 = Looper.getMainLooper();
        this.f = new f(r0, this.e, this.b, this.c, this.i, this.d);
        new Handler(r0);
    }

    @Override // com.ss.ugc.live.sdk.msg.unify.a
    public final void onRelease() {
        f r0 = this.f;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("unifyMessageProvider");
    L5:
        r0.b.removeCallbacksAndMessages(null);
        r0.c.removeCallbacksAndMessages(null);
        PthreadHandlerThreadV2 r1 = this.a;
        if (r1 == null) goto L9;
        r1.quit();
        return;
    }

    @Override // com.ss.ugc.live.sdk.msg.unify.a
    public final void onStart() {
        f r0 = this.f;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("unifyMessageProvider");
    L5:
        Message r1 = r0.c.obtainMessage(101);
        if (r1 == null) goto L9;
        r1.sendToTarget();
        return;
    }

    public d(gmc.a r4) {
        Intrinsics.checkNotNullParameter(r4, "unifyMessageConfig");
        this.i = r4;
        this.b = new com.ss.ugc.live.sdk.msg.utils.task.c(PThreadExecutorsUtils.newSingleThreadExecutor(new DefaultThreadFactory("SingleTaskExecutorServiceProvider")));
        kmc.d r0 = new kmc.d(r4.logger(), r4.monitor());
        this.c = r0;
        this.d = new UnifyWSState(r4.d(), r0);
        this.e = new b();
        this.g = new a(this);
        i r5 = new i(this, r0);
        this.h = r5;
        r5.a.d(i.a.C0224a.a);
    }

    @Override // imc.b
    public final imc.a registerBusiness(imc.d r9) {
        Intrinsics.checkNotNullParameter(r9, "config");
        if (Intrinsics.areEqual(this.h.a.b(), i.c.d.a) == true) goto L5;
        this.h.a.d(i.a.c.a);
    L5:
        c r0 = new c(Long.valueOf(kmc.c.a.incrementAndGet()).longValue(), this.d, r9, this.e, this.g);
        b r10 = this.e;
        r10.getClass();
        Intrinsics.checkNotNullParameter(r0, XBridgeLynxModule.NAME);
        r10.a.put(Long.valueOf(r0.d), r0);
        f r11 = this.f;
        if (r11 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("unifyMessageProvider");
    L8:
        r11.k();
        return r0;
    }
}
