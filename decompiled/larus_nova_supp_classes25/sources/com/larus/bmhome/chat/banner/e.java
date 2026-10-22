package com.larus.bmhome.chat.banner;

import com.google.gson.Gson;
import com.larus.bmhome.chat.component.cvs.y;
import com.larus.im.FlowRuntime;
import com.larus.platform.service.AccountService;
import com.larus.utils.b0;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import fp8.b;
import java.util.Locale;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Job;
import s1a.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class e implements Function1 {
    public final /* synthetic */ ActiveSwitchBannerFeature a;
    public final /* synthetic */ String b;

    public /* synthetic */ e(ActiveSwitchBannerFeature r1, String r2) {
        this.a = r1;
        this.b = r2;
    }

    public final Object invoke(Object r15) {
        ActiveSwitchBannerFeature r7 = this.a;
        String r1 = this.b;
        String r10 = (String) r15;
        Gson r16 = ActiveSwitchBannerFeature.n;
        Intrinsics.checkNotNullParameter(r10, "botId");
        y r17 = (y) r7.i.getValue();
        if (r17 == null) goto L7;
        wc9.e r18 = r17.h();
        if (r18 == null) goto L7;
        String r19 = r18.a;
    L9:
        if (o0.d(r19) == false) goto L11;
        String r4 = r19;
    L12:
        if (r4 == null) goto L25;
        FLogger.a.d("ActiveSwitchBanner", "requestRemote source=" + r1 + ", botId:" + r10 + ", conversationId:" + r4);
        StringBuilder r110 = new StringBuilder();
        r110.append(AccountService.a.getUserId());
        r110.append('_');
        r110.append(r4);
        String r3 = r110.toString();
        FlowRuntime.a().isOversea();
        Locale r111 = Locale.CHINA;
        String r2 = b0.a;
        Intrinsics.checkNotNull(r111);
        String r9 = b0.c(r111);
        b r112 = d.a(r7).a(b.class);
        if (r112 == null) goto L17;
        String r113 = r112.b;
    L18:
        if (r113 != null) goto L20;
        r113 = "";
    L20:
        k r5 = new k(r9, r10, r4, r113, 16);
        r7.k = true;
        Job r6 = r7.j;
        if (r6 == null) goto L23;
        Job.DefaultImpls.cancel$default(r6, null, 1, null);
    L23:
        r7.j = BuildersKt.launch$default(r7.h, null, null, new ActiveSwitchBannerFeature$requestRemote$1$1(r1, r7, r3, r4, r5, null), 3, null);
        return Unit.INSTANCE;
    L17:
        r113 = null;
        goto L18
    L25:
        return Unit.INSTANCE;
    L11:
        r4 = null;
    L7:
        r19 = null;
        goto L9
    }
}
