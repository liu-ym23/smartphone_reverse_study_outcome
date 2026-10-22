package com.larus.praise.base.impl;

import android.app.Activity;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.larus.bmhome.praise.IAiChatPraiseTriggerService;
import com.larus.common.apphost.AppHost;
import com.larus.platform.service.AccountService;
import com.larus.praise.IPraiseService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\b\u001a\u00020\tH\u0016J,\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u0005H\u0016J\u0018\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u0005H\u0016J\b\u0010\u0011\u001a\u00020\u000bH\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/larus/praise/base/impl/AiChatPraiseTriggerServiceImpl;", "Lcom/larus/bmhome/praise/IAiChatPraiseTriggerService;", "<init>", "()V", "mMarkFrom", "", "mMarkDelayMillSec", "", "isExpectShowPraiseDialog", "", "tryShowPraiseDialog", "", "delayMillSec", "from", "feedbackScene", "messageId", "markForPraiseDialog", "checkForPraiseDialog", "base-impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class AiChatPraiseTriggerServiceImpl implements IAiChatPraiseTriggerService {
    public String a;
    public long b;

    public AiChatPraiseTriggerServiceImpl() {
    }

    public final boolean a() {
        IPraiseService r0 = (IPraiseService) ServiceManager.get().getService(IPraiseService.class);
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.a();
    }

    public final void d() {
        String r3 = this.a;
        if (r3 == null) goto L6;
        b(this.b, r3, null, null);
        this.a = null;
        return;
    }

    public final void c(String r3) {
        Intrinsics.checkNotNullParameter(r3, "from");
        this.a = r3;
        this.b = 0;
    }

    public final void b(long r11, String r13, String r14, String r15) {
        Intrinsics.checkNotNullParameter(r13, "from");
        Activity r6 = AppHost.a.a().getCurrentActivity();
        if (r6 == null) goto L8;
        IPraiseService r1 = (IPraiseService) ServiceManager.get().getService(IPraiseService.class);
        if (r1 == null) goto L9;
        r1.b(CastLongProtector.parseLong(AccountService.a.getUserId()), r11, r6, r13, r14, r15);
        return;
    L9:
        return;
    }
}
