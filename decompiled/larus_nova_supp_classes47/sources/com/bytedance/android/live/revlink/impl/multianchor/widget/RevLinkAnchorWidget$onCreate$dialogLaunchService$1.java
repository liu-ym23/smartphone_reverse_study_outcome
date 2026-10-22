package com.bytedance.android.live.revlink.impl.multianchor.widget;

import com.bytedance.android.live.revlink.link.core.service.AnchorUILayoutManager;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/bytedance/android/live/revlink/link/core/service/AnchorUILayoutManager;", "invoke"}, k = 3, mv = {1, 5, 1})
public final /* synthetic */ class RevLinkAnchorWidget$onCreate$dialogLaunchService$1 extends FunctionReferenceImpl implements Function0<AnchorUILayoutManager> {
    public RevLinkAnchorWidget$onCreate$dialogLaunchService$1(RevLinkAnchorWidget r8) {
        super(0, r8, RevLinkAnchorWidget.class, "getUILayoutManager", "getUILayoutManager()Lcom/bytedance/android/live/revlink/link/core/service/AnchorUILayoutManager;", 0);
    }

    public final AnchorUILayoutManager invoke() {
        com.bytedance.android.live.revlink.widgetservice.a r0 = ((RevLinkAnchorWidget) ((CallableReference) this).receiver).b;
        if (r0 == null) goto L7;
        v51.d r1 = r0.a;
        if (r1 == null) goto L7;
        return com.bytedance.android.live.revlink.link.utils.a.b(r1);
    L7:
        return null;
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m739invoke() {
        return invoke();
    }
}
