package com.bytedance.android.live.revlink.link.domain.streammix;

import com.bytedance.android.live.revlink.impl.pk.service.IPKLinkBizDataService;
import com.bytedance.android.live.revlink.link.biz.service.j;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomKt_androidKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "p1", "", "invoke"}, k = 3, mv = {1, 5, 1})
public final /* synthetic */ class NormalStreamMixStrategy$mixSeiInfoGenerator$1 extends FunctionReferenceImpl implements Function1<String, Boolean> {
    public NormalStreamMixStrategy$mixSeiInfoGenerator$1(NormalStreamMixStrategy r8) {
        super(1, r8, NormalStreamMixStrategy.class, "queryIsLiveTypeAudio", "queryIsLiveTypeAudio(Ljava/lang/String;)Z", 0);
    }

    public final boolean invoke(String r4) {
        Intrinsics.checkNotNullParameter(r4, "p1");
        NormalStreamMixStrategy r0 = (NormalStreamMixStrategy) ((CallableReference) this).receiver;
        int r1 = NormalStreamMixStrategy.k;
        r0.getClass();
        IPKLinkBizDataService r2 = com.bytedance.android.live.revlink.link.biz.service.i.P(r0);
        if (r2 == null) goto L11;
        IRoom r3 = r2.getGuestRoom();
        if (r3 == null) goto L11;
        Intrinsics.checkNotNullParameter(r4, "$this$uid");
        Intrinsics.checkNotNullParameter(r4, "$this$uid");
        if ((!Intrinsics.areEqual(j.a.b(r0, r4), IRoomKt_androidKt.getOwnerUserIdString(r3))) == true) goto L11;
        return r3.isLiveTypeAudio();
    L11:
        return false;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return Boolean.valueOf(invoke((String) r1));
    }
}
