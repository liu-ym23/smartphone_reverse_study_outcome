package com.bytedance.android.btm.impl.page.lifecycle.layer1_inner;

import android.app.Activity;
import com.bytedance.android.btm.api.inner.ALogger;
import com.bytedance.android.btm.api.inner.g$a;
import com.bytedance.android.btm.impl.monitor.BtmMonitor;
import com.bytedance.android.btm.impl.page.PageWoods;
import com.bytedance.android.btm.impl.page.lifecycle.ResumeFuncOrigin;
import com.bytedance.android.btm.impl.page.lifecycle.layer2.FilterDispatcher;
import com.bytedance.android.btm.impl.page.model.d;
import com.bytedance.android.btm.impl.page.model.h;
import com.bytedance.android.btm.impl.setting.BtmSetting;
import com.bytedance.android.btm.impl.util.f;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class BackActivityResumer extends BaseBackResumer {
    public static final String e = "BackActivityResumer_tryResumePageWhenPaused";
    public static final BackActivityResumer f = null;

    static {
        f = new BackActivityResumer();
        e = "BackActivityResumer_tryResumePageWhenPaused";
    }

    public BackActivityResumer() {
        super(ResumeFuncOrigin.BackActivity, 1027, 1024);
    }

    public static void k(final Activity r16) {
        if (BtmSetting.d.c().b().B() == 1) goto L5;
        return;
    L5:
        boolean r0 = com.bytedance.android.btm.impl.b.a;
        final Set r10 = com.bytedance.android.btm.impl.b.b().i();
        final int r1 = r10.size();
        if (r1 != 1) goto L18;
        final boolean r11 = r16.isFinishing();
        ALogger r12 = ALogger.d;
        String r13 = e;
        ALogger.e(r12, r13, new BackActivityResumer$tryResumePageWhenPaused$1(r11));
        ConcurrentHashMap<f<Activity>, h> r14 = PageWoods.a;
        Set r15 = r10;
        final h r17 = PageWoods.a(CollectionsKt.last(r15));
        if (r17 == null) goto L21;
        d r18 = r17.m(r17.e);
        if (r18 == null) goto L12;
        Object r19 = r18.a();
    L13:
        if (r19 == null) goto L17;
        String r20 = FilterDispatcher.a;
        if (FilterDispatcher.e(r19, f.b) != null) goto L17;
        ALogger.e(r12, r13, BackActivityResumer$tryResumePageWhenPaused$2$1.INSTANCE);
        return;
    L17:
        final String r21 = r16.getClass().getName();
        final String r22 = CollectionsKt.last(r15).getClass().getName();
        Lazy r23 = BtmMonitor.a;
        BtmMonitor.j(1043, null, null, null, new BackActivityResumer$tryResumePageWhenPaused$$inlined$let$lambda$1(r21, r22, r16, r10, r11), new BackActivityResumer$tryResumePageWhenPaused$2$3(r17), 62);
        return;
    L12:
        r19 = null;
        goto L13
    L21:
        return;
    L18:
        if (r1 <= 1) goto L24;
        final String r24 = r16.getClass().getName();
        g$a.a(BtmMonitor.c, 1043, null, null, new BackActivityResumer$tryResumePageWhenPaused$3(r24, r1), 30);
        return;
    }

    @Override // com.bytedance.android.btm.impl.page.lifecycle.layer1_inner.BaseBackResumer
    public final void e(Activity r10, h r11) {
        boolean r1 = true;
        if (BtmSetting.d.c().b().o() != 1) goto L6;
        super.e(r10, r11);
        return;
    L6:
        if (h(r10, r11) == false) goto L8;
        return;
    L8:
        if (j(r10, r11) == true) goto L32;
        ALogger.e(ALogger.d, "BaseBackResumer_tryResumeTopOrPrePages", new BaseBackResumer$tryResumeTopOrPrePages$1(this));
        d r12 = r11.m(r11.e);
        final Ref.IntRef r0 = new Ref.IntRef();
        r0.element = 0;
    L10:
        if (r12 == null) goto L20;
        if (r0.element >= 5) goto L20;
        Object r13 = r12.a();
        if (r13 == null) goto L19;
        String r14 = FilterDispatcher.a;
        if (FilterDispatcher.e(r13, this.b) != null) goto L19;
        ALogger.e(ALogger.d, "BaseBackResumer_tryResumeTopOrPrePages", new BaseBackResumer$tryResumeTopOrPrePages$2(r0));
    L21:
        if (r1 == true) goto L33;
        c(r10, "");
        return;
    L33:
        return;
    L19:
        r12 = r12.j();
        r0.element++;
    L20:
        r1 = false;
        goto L21
    }
}
