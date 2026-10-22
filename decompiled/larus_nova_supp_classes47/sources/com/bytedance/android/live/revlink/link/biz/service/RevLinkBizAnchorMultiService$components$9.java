package com.bytedance.android.live.revlink.link.biz.service;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 5, 1})
public final /* synthetic */ class RevLinkBizAnchorMultiService$components$9 extends FunctionReferenceImpl implements Function0<Unit> {
    public RevLinkBizAnchorMultiService$components$9(RevLinkBizAnchorMultiService r8) {
        super(0, r8, RevLinkBizAnchorMultiService.class, "joinChannel", "joinChannel()V", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m922invoke() {
        ((RevLinkBizAnchorMultiService) ((CallableReference) this).receiver).joinChannel();
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m922invoke();
        return Unit.INSTANCE;
    }
}
