package com.ss.android.lark.flow.feed.data;

import com.bytedance.lark.pb.basic.v1.Command;
import com.bytedance.lark.pb.feed.v1.GetDoubaoFeedMigrateStatusRequest;
import com.bytedance.lark.pb.feed.v1.GetDoubaoFeedMigrateStatusResponse;
import com.bytedance.lark.rustclient.api.c;
import com.bytedance.lark.rustclient.api.d;
import com.bytedance.lark.rustclient.api.x;
import com.ss.android.lark.flow.feed.utils.b;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.log.Log;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
@DebugMetadata(c = "com.ss.android.lark.flow.feed.data.DoubaoFeedMigrateStatus$ensureSubscribed$1", f = "DoubaoFeedMigrateStatus.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class DoubaoFeedMigrateStatus$ensureSubscribed$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ DoubaoFeedMigrateStatus this$0;

    public DoubaoFeedMigrateStatus$ensureSubscribed$1(DoubaoFeedMigrateStatus r1, Continuation<? super DoubaoFeedMigrateStatus$ensureSubscribed$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new DoubaoFeedMigrateStatus$ensureSubscribed$1(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r18) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L25;
        ResultKt.throwOnFailure(r18);
        DoubaoFeedMigrateStatus r2 = this.this$0;
        List<com.bytedance.lark.pb.feed.v1.DoubaoFeedMigrateStatus> r0 = DoubaoFeedMigrateStatus.j;
        r2.getClass();
        Result.Companion r6 = Result.Companion;     // Catch: Throwable -> L17
        x r5 = r2.b.h(new d(new GetDoubaoFeedMigrateStatusRequest.Builder(), GetDoubaoFeedMigrateStatusResponse.ADAPTER, Command.GET_DOUBAO_FEED_MIGRATE_STATUS, null, null, null, null, 248)).execute();     // Catch: Throwable -> L17
        if ((r5 instanceof x) == false) goto L12;
        com.bytedance.lark.pb.feed.v1.DoubaoFeedMigrateStatus r4 = ((GetDoubaoFeedMigrateStatusResponse) r5.c).status;     // Catch: Throwable -> L17
        b.d("DoubaoFeedMigrateStatus", "GET_MIGRATE_STATUS success, status=" + r4);     // Catch: Throwable -> L17
        if (DoubaoFeedMigrateStatus.j.contains(r4) == false) goto L10;
        r2.g();     // Catch: Throwable -> L17
    L14:
        Object r1 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L17
    L19:
        Throwable r3 = Result.exceptionOrNull-impl(r1);
        if (r3 == null) goto L23;
        int r7 = b.a;
        Intrinsics.checkNotNullParameter("DoubaoFeedMigrateStatus", "tag");
        Log.e("DoubaoFeedMigrateStatus", r3, true);
        r2.g.set(false);
    L23:
        return Unit.INSTANCE;
    L10:
        b.d("DoubaoFeedMigrateStatus", "migrate finish reset false by fetch");     // Catch: Throwable -> L17
        r2.f().set(false);     // Catch: Throwable -> L17
        r2.e().putBoolean("mixed_feed_migrate", false);     // Catch: Throwable -> L17
        goto L14
    L12:
        if ((r5 instanceof c) == false) goto L16;
        b.d("DoubaoFeedMigrateStatus", "GET_MIGRATE_STATUS failed, error=" + ((c) r5).c.b);     // Catch: Throwable -> L17
        r2.g.set(false);     // Catch: Throwable -> L17
        goto L14
    L16:
        throw new NoWhenBranchMatchedException();     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        Result.Companion r8 = Result.Companion;
        r1 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L19
    L25:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
