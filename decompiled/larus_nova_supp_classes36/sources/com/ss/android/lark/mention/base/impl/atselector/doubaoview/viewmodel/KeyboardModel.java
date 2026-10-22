package com.ss.android.lark.mention.base.impl.atselector.doubaoview.viewmodel;

import com.bytedance.lark.pb.basic.v1.SyncDataStrategy;
import com.bytedance.lark.pb.contact.v2.PullDoubaoChatterRequest;
import com.bytedance.lark.pb.contact.v2.PullDoubaoChatterResponse;
import com.larksuite.rucket.job.RucketJob;
import com.larksuite.rucket.job.base.b;
import com.ss.android.lark.chat.entity.chatter.Chatter;
import com.ss.android.lark.image.api.Target;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.parser.internal.j;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class KeyboardModel {

    public static final class a {
    }

    static {
    }

    public KeyboardModel() {
    }

    public final Object a(SyncDataStrategy r5, Continuation<? super Chatter> r6) {
        if ((r6 instanceof KeyboardModel$getDoubaoChatter$1) == false) goto L7;
        KeyboardModel$getDoubaoChatter$1 r0 = (KeyboardModel$getDoubaoChatter$1) r6;
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
    L17:
        b r8 = (b) r7;
        r8.getClass();
        if ((r8 instanceof b.b) == false) goto L22;
        Log.e("KeyboardModel", "getDoubaoChatter failed, " + r8.a());
        return null;
    L22:
        return j.a(((PullDoubaoChatterResponse) r8.b()).doubao);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r7);
        RucketJob<PullDoubaoChatterResponse> r9 = ((com.ss.android.lark.mention.base.impl.atselector.doubaoview.viewmodel.a) b38.b.a.create(com.ss.android.lark.mention.base.impl.atselector.doubaoview.viewmodel.a.class)).getDoubaoChatter(new PullDoubaoChatterRequest.Builder().sync_data_strategy(r5).build());
        r0.label = 1;
        r7 = r9.awaitGet(r0);
        if (r7 != r2) goto L17;
        return r2;
    L7:
        r0 = new KeyboardModel$getDoubaoChatter$1(this, r6);
        goto L8
    }
}
