package com.bytedance.android.live.revlink.impl.control;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u0004\u0018\u00010\u0000¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lfr2/v;", "invoke", "()Lfr2/v;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
public final /* synthetic */ class LinkRevControlWidget$launchOrSwitchRevLinkService$1$revLinkAnchorWidget$2 extends FunctionReferenceImpl implements Function0<fr2.v> {
    public LinkRevControlWidget$launchOrSwitchRevLinkService$1$revLinkAnchorWidget$2(com.bytedance.android.live.revlink.impl.b r8) {
        super(0, r8, com.bytedance.android.live.revlink.impl.b.class, "getLiveVideoClientFactory", "getLiveVideoClientFactory()Lcom/bytedance/android/livesdk/revenue/service/livecore/ILiveVideoClientFactory;", 0);
    }

    public final fr2.v invoke() {
        return ((com.bytedance.android.live.revlink.impl.b) ((CallableReference) this).receiver).getLiveVideoClientFactory();
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m486invoke() {
        return invoke();
    }
}
