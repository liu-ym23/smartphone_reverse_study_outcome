package com.bytedance.android.livesdk.gift.platform.business.tray2.manager;

import android.os.Message;
import com.bytedance.android.live.core.utils.v;
import com.bytedance.android.livesdk.gift.platform.business.normal.model.NormalGiftMessage;
import com.bytedance.android.livesdk.gift.platform.core.c0;
import com.bytedance.android.livesdk.gift.platform.core.utils.recorder.ErrorNo;
import com.bytedance.android.livesdkapi.depend.handler.WeakHandler;
import com.bytedance.bdlocation.BuildConfig;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public abstract class a<T> implements f<T>, WeakHandler.IHandler, y02.e {
    public String a;
    public g b;
    public final WeakHandler c;
    public final int d;
    public int e;
    public final y02.f<T> f;
    public boolean g;
    public String h;

    public abstract y02.f<T> f();

    public final void k() {
        l(true, "turn true from release");
        this.f.clear();
        com.bytedance.android.livesdk.gift.platform.core.utils.c.a(this.a, "unregisterConsumer ");
        this.e = -1;
        this.b = null;
        this.c.removeCallbacksAndMessages(null);
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.tray2.manager.f
    public T c() {
        int r0 = com.bytedance.android.livesdk.gift.platform.core.utils.c.a;
        if (this.g == true) goto L7;
        com.bytedance.android.livesdk.gift.platform.core.utils.c.c(this.a, "MsgManager is disabled,pollNextMessage return null " + this.h);
        return null;
    L7:
        return this.f.pollFirst();
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.tray2.manager.f
    public final void e() {
        this.c.removeMessages(this.d);
    }

    public final int g() {
        return this.f.size();
    }

    public final void i() {
        if (this.g == true) goto L6;
        com.bytedance.android.livesdk.gift.platform.core.utils.c.c(this.a, "notifyConsumeMessage MsgManager is disabled,reason:" + this.h);
        return;
    L6:
        g r0 = this.b;
        if (r0 == null) goto L10;
        r0.og();
    L10:
        if (this.b != null) goto L13;
        com.bytedance.android.livesdk.gift.platform.core.utils.recorder.e.a r1 = com.bytedance.android.livesdk.gift.platform.core.utils.recorder.e.d;
        String r2 = this.a + ' ' + this + " ERROR!!! messageConsumer is null!!!!";
        com.bytedance.android.livesdk.gift.platform.core.utils.recorder.d r3 = new com.bytedance.android.livesdk.gift.platform.core.utils.recorder.d(ErrorNo.NO_CONSUMER, this.a + " consumer is null");
        r1.getClass();
        com.bytedance.android.livesdk.gift.platform.core.utils.recorder.e.a.a("110", r2, "-1", r3);
        return;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.tray2.manager.f
    public final y02.g<T> iterator() {
        return this.f.iterator();
    }

    public a() {
        this.a = "BaseMsgManager";
        this.c = new WeakHandler(this);
        this.d = 2;
        this.e = -1;
        this.g = true;
        this.h = BuildConfig.FLAVOR;
        y02.f<T> r0 = f();
        this.f = r0;
        r0.c(this);
    }

    @Override // y02.e
    public final void b() {
        i();
        int r0 = com.bytedance.android.livesdk.gift.platform.core.utils.c.a;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.tray2.manager.f
    public final boolean d(NormalGiftMessage r2) {
        return this.f.d(r2);
    }

    public void h(Message r17) {
        c0 r1 = c0.a;
        Object r2 = null;
        if (r17 == null) goto L5;
        Object r3 = r17.obj;
    L7:
        if ((r3 instanceof Map) == true) goto L9;
        r3 = null;
    L9:
        Map r4 = (Map) r3;
        if (r4 == null) goto L12;
        r2 = r4.get("assetId");
    L12:
        if (r2 == null) goto L18;
        c0.b(false, ((Long) r2).longValue(), BuildConfig.FLAVOR, -114514, "consume_time_out", 0, BuildConfig.FLAVOR, BuildConfig.FLAVOR, MapsKt.emptyMap(), MapsKt.emptyMap(), g02.a.e(), false, false);
        g r5 = this.b;
        if (r5 == null) goto L19;
        r5.Ge(r17);
        return;
    L19:
        return;
    L18:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Long");
    L5:
        r3 = null;
        goto L7
    }

    public final void handleMsg(Message r3) {
        if (r3 == null) goto L4;
        Integer r0 = Integer.valueOf(r3.what);
    L5:
        int r1 = this.d;
        if (r0 != null) goto L9;
        return;
    L9:
        if (r0.intValue() != r1) goto L12;
        h(r3);
        return;
    L12:
        return;
    L4:
        r0 = null;
        goto L5
    }

    public final void j(g r4, int r5) {
        Intrinsics.checkNotNullParameter(r4, "consumer");
        com.bytedance.android.livesdk.gift.platform.core.utils.c.a(this.a, "registerConsumer " + r4 + " type " + r5);
        this.e = r5;
        this.b = r4;
    }

    public final void l(boolean r4, String r5) {
        Intrinsics.checkNotNullParameter(r5, "reason");
        this.g = r4;
        this.h = r5;
        if (r5.length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L8;
    L12:
        com.bytedance.android.livesdk.gift.platform.core.utils.c.c(this.a, "Enable Changed:" + r4 + " reason:" + r5);
        return;
    L8:
        if (v.a() == false) goto L12;
        throw new IllegalArgumentException("change enable state queue must have a reason!");
    L5:
        r0 = false;
        goto L6
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.tray2.manager.f
    public final void a(long r5, String r7, long r8) {
        Intrinsics.checkNotNullParameter(r7, "msgId");
        if (this.g == true) goto L6;
        com.bytedance.android.livesdk.gift.platform.core.utils.c.c(this.a, "notifyConsumeMessageWhenTimeout MsgManager is disabled,reason:" + this.h);
        return;
    L6:
        Message r1 = Message.obtain();
        r1.what = this.d;
        r1.arg1 = this.e;
        r1.obj = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("msgId", r7), TuplesKt.to("assetId", Long.valueOf(r8))});
        e();
        this.c.sendMessageDelayed(r1, r5);
    }
}
