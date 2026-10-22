package com.ss.android.lark.chat.chatwindow.chat.v2.push;

import com.bytedance.lark.pb.basic.v1.Draft;
import com.bytedance.lark.pb.im.v1.PushDraftChange;
import com.ss.android.lark.log.Log;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.chat.chatwindow.chat.v2.push.DraftPushHandler$onStart$1", f = "DraftPushHandler.kt", i = {}, l = {40}, m = "invokeSuspend", n = {}, s = {})
final class DraftPushHandler$onStart$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    Object L$0;
    int label;
    final /* synthetic */ t this$0;

    public DraftPushHandler$onStart$1(t r1, Continuation<? super DraftPushHandler$onStart$1> r2) {
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new DraftPushHandler$onStart$1(null, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r8) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 != 0) goto L5;
        ResultKt.throwOnFailure(r8);
        int r9 = t.a;
        throw null;
    L5:
        if (r1 != 1) goto L25;
        com.larksuite.rucket.job.extension.a r2 = (com.larksuite.rucket.job.extension.a) this.L$0;
        ResultKt.throwOnFailure(r8);
    L8:
        if (((Boolean) r8).booleanValue() == false) goto L23;
        com.larksuite.rucket.job.base.b r10 = r2.a();
        if (((PushDraftChange) r10.b()).draft == null) goto L19;
        Iterator r11 = ((PushDraftChange) r10.b()).draft.iterator();
    L14:
        if (r11.hasNext() == false) goto L19;
        Draft r4 = (Draft) r11.next();
        Log.i("DraftPushHandler", "receive PUSH_DRAFT_CHANGE, draft id:" + r4.id);
        if (com.ss.android.lark.parser.internal.n.b(r4, Boxing.boxBoolean(true)) == null) goto L14;
        throw null;
    L19:
        this.L$0 = r2;
        this.label = 1;
        r8 = r2.hasNext(this);
        if (r8 != r0) goto L8;
        return r0;
    L23:
        return Unit.INSTANCE;
    L25:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
