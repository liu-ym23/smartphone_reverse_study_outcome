package com.ss.android.lark.mention.base.impl.atselector.doubaoview;

import com.ss.android.lark.image.api.Target;
import com.ss.android.lark.pb.graph.PullClosestChattersRequest;
import com.ss.android.lark.pb.improto.Command;
import com.ss.android.lark.sdk.SdkSender;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugProbesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class g {
    public static final Object a(Continuation r6) {
        if ((r6 instanceof DoubaoMentionRecommendDataLoaderKt$requestClosestChatters$1) == false) goto L7;
        DoubaoMentionRecommendDataLoaderKt$requestClosestChatters$1 r0 = (DoubaoMentionRecommendDataLoaderKt$requestClosestChatters$1) r6;
        int r1 = r0.label;
        if ((r1 & Target.SIZE_ORIGINAL) == 0) goto L7;
        r0.label = r1 - Target.SIZE_ORIGINAL;
    L8:
        Object r7 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        ResultKt.throwOnFailure(r7);
    L20:
        return ((Result) r7).unbox-impl();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r7);
        r0.label = 1;
        final kotlinx.coroutines.j r8 = new kotlinx.coroutines.j(IntrinsicsKt.intercepted(r0), 1);
        r8.C();
        PullClosestChattersRequest.Builder r4 = new PullClosestChattersRequest.Builder().begin(Boxing.boxInt(0)).end(Boxing.boxInt(10)).is_need_department(Boxing.boxBoolean(true)).is_need_extended_fields(Boxing.boxBoolean(true));
        SdkSender.sendPassThroughRequest(Command.PULL_CLOSEST_CHATTERS, r4, new DoubaoMentionRecommendDataLoaderKt$requestClosestChatters$2$1(r8), f.a);
        r7 = r8.B();
        if (r7 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L17;
        DebugProbesKt.probeCoroutineSuspended(r0);
    L17:
        if (r7 != r2) goto L20;
        return r2;
    L7:
        r0 = new DoubaoMentionRecommendDataLoaderKt$requestClosestChatters$1(r6);
        goto L8
    }
}
