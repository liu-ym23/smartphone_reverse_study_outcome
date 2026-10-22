package com.bytedance.ies.bullet.lynx;

import android.os.Looper;
import androidx.room.jarjarred.org.stringtemplate.v4.ST;
import com.bytedance.forest.chain.fetchers.GeckoFetcher;
import com.bytedance.ies.bullet.core.l;
import com.bytedance.ies.bullet.service.base.a0;
import com.bytedance.ies.bullet.service.base.o;
import com.bytedance.lynx.service.monitor.LynxMonitorService;
import com.lynx.tasm.LynxView;
import com.lynx.tasm.utils.k;
import java.io.File;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lcom/bytedance/ies/bullet/service/base/a0;", ST.IMPLICIT_ARG_NAME, "", "loadInMainThread", "", "invoke", "(Lcom/bytedance/ies/bullet/service/base/a0;Z)V", "<anonymous>"}, k = 3, mv = {1, 4, 3})
final class LynxKitView$loadResource$onSuccess$1 extends Lambda implements Function2<a0, Boolean, Unit> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ h f5585a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ boolean f5586b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f5587c;
    public final /* synthetic */ wc.g d;
    public final /* synthetic */ com.bytedance.ies.bullet.ui.common.loader.a e;

    public LynxKitView$loadResource$onSuccess$1(h r5, boolean r10, String r11, wc.g r12, com.bytedance.ies.bullet.ui.common.loader.a r13) {
        this.f5585a = r5;
        this.f5586b = r10;
        this.f5587c = r11;
        this.d = r12;
        this.e = r13;
        super(2);
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public final Unit mo2invoke(a0 r10, Boolean r11) {
        a0 r5 = r10;
        boolean r12 = r11.booleanValue();
        Intrinsics.checkNotNullParameter(r5, ST.IMPLICIT_ARG_NAME);
        h r13 = this.f5585a;
        r13.f5642k = r5;
        d r14 = r13.f5637b;
        Intrinsics.checkNotNullParameter(o.class, "clazz");
        tc.c r15 = tc.c.f22119c;
        if (tc.c.f22119c.a(o.class, r14.f22117a) != null) goto L80;
        if (this.f5585a.f5639h.length() <= 0) goto L14;
        LynxView r16 = this.f5585a.g;
        if (r16 == null) goto L9;
        com.bytedance.android.monitorV2.lynx.d r17 = com.bytedance.android.monitorV2.lynx.d.f3638a;
        String r18 = String.valueOf(r5.f);
        r17.getClass();
        com.bytedance.android.monitorV2.lynx.d.e(r16, "geckoId", r18);
        com.bytedance.android.monitorV2.lynx.d.e(r16, LynxMonitorService.KEY_CHANNEL, r5.s);
    L9:
        boolean r19 = com.bytedance.ies.bullet.service.base.b.f5956a;
        String r110 = this.f5585a.f5639h;
        StringBuilder r20 = new StringBuilder();
        if (this.f5586b == false) goto L12;
        String r21 = GeckoFetcher.GECKO_SDK_INVOKE_ASYNC_TAG;
    L13:
        r20.append(r21);
        r20.append(" finish loading template url: ");
        r20.append(this.f5587c);
        com.bytedance.ies.bullet.service.base.b.b(8, r110, r20.toString(), "XLynxKit");
        goto L14
    L12:
        r21 = "RL";
    L14:
        q7.a r111 = this.f5585a.e.f5663m;
        if (r111 == null) goto L69;
        Intrinsics.checkNotNullParameter(r5, "resourceInfo");
        com.bytedance.ies.bullet.core.e r22 = ((com.bytedance.ies.bullet.lynx.impl.e) r111.f21488b).f;
        String r23 = null;
        if (r22 == null) goto L19;
        l r24 = r22.f5309x;
    L20:
        if (r24 == null) goto L24;
        String r25 = r5.a();
        Intrinsics.checkNotNullParameter(r25, "<set-?>");
        r24.f5347b = r25;
    L24:
        if (k.o(r5.f5933b) == false) goto L32;
        com.bytedance.ies.bullet.core.e r26 = ((com.bytedance.ies.bullet.lynx.impl.e) r111.f21488b).f;
        if (r26 == null) goto L28;
        l r27 = r26.f5309x;
    L29:
        if (r27 == null) goto L32;
        String r28 = r5.f5933b;
        Intrinsics.checkNotNull(r28);
        r27.f5348c = k.a(new File(r28)) / ((double) 1024.0f);
        goto L32
    L28:
        r27 = null;
    L32:
        com.bytedance.ies.bullet.core.e r29 = ((com.bytedance.ies.bullet.lynx.impl.e) r111.f21488b).f;
        if (r29 == null) goto L35;
        l r30 = r29.f5309x;
    L36:
        if (r30 == null) goto L39;
        r30.d = r5.f;
    L39:
        if (r29 == null) goto L41;
        l r31 = r29.f5309x;
    L42:
        if (r31 == null) goto L45;
        r31.e = r5.f5940m;
    L45:
        if (r29 == null) goto L49;
        com.bytedance.ies.bullet.service.monitor.b r32 = r29.f5293c;
        if (r32 == null) goto L49;
        r32.C();
    L49:
        LinkedHashMap r33 = cd.a.f1171a;
        com.bytedance.ies.bullet.core.e r34 = ((com.bytedance.ies.bullet.lynx.impl.e) r111.f21488b).f;
        if (r34 == null) goto L52;
        String r35 = r34.getSessionId();
    L53:
        rb.b r36 = cd.a.a(r35);
        Intrinsics.checkNotNullParameter(com.bytedance.ies.bullet.core.o.class, "clazz");
        rb.a r37 = (rb.a) r36.f21717a.get(com.bytedance.ies.bullet.core.o.class);
        if (r37 != null) goto L57;
        r37 = null;
    L57:
        if (r37 != null) goto L59;
    L61:
        com.bytedance.ies.bullet.lynx.impl.e r38 = (com.bytedance.ies.bullet.lynx.impl.e) r111.f21488b;
        r38.g = r5;
        com.bytedance.ies.bullet.core.e r39 = r38.f;
        if (r39 == null) goto L64;
        r23 = r39.getSessionId();
    L64:
        cd.a.a(r23);
        d r112 = (d) r111.f21489c;
        Intrinsics.checkNotNullParameter(com.bytedance.ies.bullet.service.base.l.class, "clazz");
        if (tc.c.f22119c.a(com.bytedance.ies.bullet.service.base.l.class, r112.f22117a) == null) goto L69;
        throw new ClassCastException();
    L59:
        if (((com.bytedance.ies.bullet.core.o) r37.a()) == null) goto L61;
        Intrinsics.checkNotNullParameter(r5, "resourceInfo");
        Intrinsics.checkNotNullParameter(r5, "resourceInfo");
        goto L61
    L52:
        r35 = null;
        goto L53
    L41:
        r31 = null;
        goto L42
    L35:
        r30 = null;
        goto L36
    L19:
        r24 = null;
    L69:
        boolean r113 = Intrinsics.areEqual(Thread.currentThread(), Looper.getMainLooper().getThread());
        if (r12 == true) goto L74;
        if (r113 == false) goto L73;
        h.f.b(new e(this.f5585a, this.f5587c, r5, this.d, this.e, 0), h.f.g);
    L78:
        return Unit.INSTANCE;
    L73:
        h.d(this.f5585a, this.f5587c, r5, this.d, this.e);
        goto L78
    L74:
        if (r113 == false) goto L76;
        h.d(this.f5585a, this.f5587c, r5, this.d, this.e);
        goto L78
    L76:
        h.f.b(new e(this.f5585a, this.f5587c, r5, this.d, this.e, 1), h.f.f17263i);
        goto L78
    L80:
        throw new ClassCastException();
    }
}
