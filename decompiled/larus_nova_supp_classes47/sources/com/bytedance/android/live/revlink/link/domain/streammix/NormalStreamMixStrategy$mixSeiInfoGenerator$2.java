package com.bytedance.android.live.revlink.link.domain.streammix;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lcom/bytedance/android/live/revlink/link/domain/streammix/GridWindowType;", "p1", "", "invoke"}, k = 3, mv = {1, 5, 1})
public final /* synthetic */ class NormalStreamMixStrategy$mixSeiInfoGenerator$2 extends FunctionReferenceImpl implements Function1<String, GridWindowType> {
    public NormalStreamMixStrategy$mixSeiInfoGenerator$2(NormalStreamMixStrategy r8) {
        super(1, r8, NormalStreamMixStrategy.class, "queryWindowType", "queryWindowType(Ljava/lang/String;)Lcom/bytedance/android/live/revlink/link/domain/streammix/GridWindowType;", 0);
    }

    public final GridWindowType invoke(String r3) {
        Intrinsics.checkNotNullParameter(r3, "p1");
        NormalStreamMixStrategy r0 = (NormalStreamMixStrategy) ((CallableReference) this).receiver;
        int r1 = NormalStreamMixStrategy.k;
        r0.getClass();
        if (com.bytedance.android.live.revlink.link.biz.service.i.t(r0).getGuestInfo(null, r3) == null) goto L6;
        return GridWindowType.Anchor;
    L6:
        if (n41.a.a(r3) == null) goto L9;
        return GridWindowType.Audience;
    L9:
        if (Intrinsics.areEqual(r3, "pk_cloud_game_id") == false) goto L12;
        return GridWindowType.Game;
    L12:
        return GridWindowType.Anchor;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((String) r1);
    }
}
