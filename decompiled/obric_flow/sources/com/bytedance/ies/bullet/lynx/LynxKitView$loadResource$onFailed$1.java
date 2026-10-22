package com.bytedance.ies.bullet.lynx;

import android.net.Uri;
import com.bytedance.forest.chain.fetchers.GeckoFetcher;
import com.bytedance.ies.bullet.core.o;
import com.bytedance.ies.bullet.service.base.api.LogLevel;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "e", "", "invoke"}, k = 3, mv = {1, 4, 3}, xi = 48)
final class LynxKitView$loadResource$onFailed$1 extends Lambda implements Function1<Throwable, Unit> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.ies.bullet.ui.common.loader.a f5582a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f5583b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ h f5584c;
    public final /* synthetic */ boolean d;

    public LynxKitView$loadResource$onFailed$1(com.bytedance.ies.bullet.ui.common.loader.a r5, String r10, h r11, boolean r12) {
        this.f5582a = r5;
        this.f5583b = r10;
        this.f5584c = r11;
        this.d = r12;
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(Throwable r5) {
        Throwable r10 = r5;
        Intrinsics.checkNotNullParameter(r10, "e");
        this.f5582a.r(Uri.parse(this.f5583b), r10);
        q7.a r11 = this.f5584c.e.f5663m;
        if (r11 == null) goto L13;
        String r12 = this.f5583b;
        Intrinsics.checkNotNullParameter(r12, "url");
        Intrinsics.checkNotNullParameter(r12, "url");
        LinkedHashMap r13 = cd.a.f1171a;
        com.bytedance.ies.bullet.core.e r14 = ((com.bytedance.ies.bullet.lynx.impl.e) r11.f21488b).f;
        rb.a r15 = null;
        if (r14 == null) goto L7;
        String r16 = r14.getSessionId();
    L8:
        rb.b r17 = cd.a.a(r16);
        Intrinsics.checkNotNullParameter(o.class, "clazz");
        rb.a r18 = (rb.a) r17.f21717a.get(o.class);
        if (r18 == null) goto L11;
        r15 = r18;
    L11:
        if (r15 == null) goto L13;
        o r19 = (o) r15.a();
        goto L13
    L7:
        r16 = null;
    L13:
        boolean r20 = com.bytedance.ies.bullet.service.base.b.f5956a;
        String r21 = this.f5584c.f5639h;
        StringBuilder r22 = new StringBuilder();
        if (this.d == false) goto L16;
        String r23 = GeckoFetcher.GECKO_SDK_INVOKE_ASYNC_TAG;
    L17:
        r22.append(r23);
        r22.append(" load template error. url: ");
        r22.append(this.f5583b);
        com.bytedance.ies.bullet.service.base.b.f(r21, r22.toString(), "XLynxKit", r10, LogLevel.d);
        return Unit.INSTANCE;
    L16:
        r23 = "RL";
        goto L17
    }
}
