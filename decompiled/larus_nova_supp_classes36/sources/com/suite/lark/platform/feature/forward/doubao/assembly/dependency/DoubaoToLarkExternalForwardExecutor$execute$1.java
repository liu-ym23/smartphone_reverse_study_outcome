package com.suite.lark.platform.feature.forward.doubao.assembly.dependency;

import com.bytedance.lark.pb.im.v1.Transmit2ThreadTarget;
import com.bytedance.lark.pb.im.v1.TransmitDoubaoMessagesResponse;
import com.bytedance.lark.pb.office_sdk.basic.DoubaoContent;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.ss.android.lark.forwardv3.dependency.IExternalForwardExecutor;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.search.dto.info.SearchBaseInfo;
import com.ss.android.lark.widget.richtext.RichText;
import com.suite.lark.platform.feature.forward.doubao.api.entity.ForwardDoubaoContent;
import com.suite.lark.platform.feature.forward.doubao.i;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
@DebugMetadata(c = "com.suite.lark.platform.feature.forward.doubao.assembly.dependency.DoubaoToLarkExternalForwardExecutor$execute$1", f = "DoubaoToLarkExternalForwardExecutor.kt", i = {0}, l = {69}, m = "invokeSuspend", n = {"targets"}, s = {"L$0"})
public final class DoubaoToLarkExternalForwardExecutor$execute$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ IExternalForwardExecutor.a $callback;
    final /* synthetic */ List<SearchBaseInfo> $items;
    final /* synthetic */ String $note;
    final /* synthetic */ RichText $richText;
    Object L$0;
    int label;
    final /* synthetic */ DoubaoToLarkExternalForwardExecutor this$0;

    public DoubaoToLarkExternalForwardExecutor$execute$1(IExternalForwardExecutor.a r1, DoubaoToLarkExternalForwardExecutor r2, List<? extends SearchBaseInfo> r3, String r4, RichText r5, Continuation<? super DoubaoToLarkExternalForwardExecutor$execute$1> r6) {
        this.$callback = r1;
        this.this$0 = r2;
        this.$items = r3;
        this.$note = r4;
        this.$richText = r5;
        super(2, r6);
    }

    public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
        return new DoubaoToLarkExternalForwardExecutor$execute$1(this.$callback, this.this$0, this.$items, this.$note, this.$richText, r9);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r13) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        String r5 = "transmit doubao messages failed";
        if (r1 == 0) goto L10;
        if (r1 != 1) goto L9;
        DoubaoToLarkExternalForwardExecutor.c r2 = (DoubaoToLarkExternalForwardExecutor.c) this.L$0;
        ResultKt.throwOnFailure(r13);     // Catch: Throwable -> L52 ErrorResult -> L58
    L38:
        DoubaoToLarkExternalForwardExecutor.b r14 = (DoubaoToLarkExternalForwardExecutor.b) r13;     // Catch: Throwable -> L52 ErrorResult -> L58
        if ((r14 instanceof DoubaoToLarkExternalForwardExecutor.b.C0247b) == false) goto L42;
        TransmitDoubaoMessagesResponse r15 = ((DoubaoToLarkExternalForwardExecutor.b.C0247b) r14).a;     // Catch: Throwable -> L52 ErrorResult -> L58
        DoubaoToLarkExternalForwardExecutor.d(this.this$0, r15, r2.c, r2.e, this.$note, this.$richText);     // Catch: Throwable -> L52 ErrorResult -> L58
        this.$callback.onSuccess(DoubaoToLarkExternalForwardExecutor.b(this.this$0, r15, r2.c, r2.d));     // Catch: Throwable -> L52 ErrorResult -> L58
    L68:
        return Unit.INSTANCE;
    L42:
        if ((r14 instanceof DoubaoToLarkExternalForwardExecutor.b.a) == false) goto L51;
        ErrorResult r16 = ((DoubaoToLarkExternalForwardExecutor.b.a) r14).a;     // Catch: Throwable -> L52 ErrorResult -> L58
        Log.e("DoubaoToLarkExternalForwardExecutor", "transmit doubao messages failed: " + r16, r16);     // Catch: Throwable -> L52 ErrorResult -> L58
        IExternalForwardExecutor.a r3 = this.$callback;     // Catch: Throwable -> L52 ErrorResult -> L58
        String r4 = r16.getDisplayMsg();     // Catch: Throwable -> L52 ErrorResult -> L58
        if (r4 != null) goto L48;
        r4 = r16.getMessage();     // Catch: Throwable -> L52 ErrorResult -> L58
        if (r4 != null) goto L48;
        r4 = "transmit doubao messages failed";
    L48:
        r3.onFailure(r4);     // Catch: Throwable -> L52 ErrorResult -> L58
        return Unit.INSTANCE;
    L51:
        throw new NoWhenBranchMatchedException();     // Catch: Throwable -> L52 ErrorResult -> L58
    L9:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        ResultKt.throwOnFailure(r13);
        i r17 = i.a;     // Catch: Throwable -> L52 ErrorResult -> L58
        ForwardDoubaoContent r18 = i.b;     // Catch: Throwable -> L52 ErrorResult -> L58
        List<Long> r6 = null;
        if (r18 == null) goto L14;
        byte[] r19 = r18.getDoubaoData();     // Catch: Throwable -> L52 ErrorResult -> L58
    L15:
        if (r19 == null) goto L17;
        ByteString r110 = ByteString.a.e(ByteString.Companion, r19);     // Catch: Throwable -> L52 ErrorResult -> L58
    L18:
        ForwardDoubaoContent r7 = i.b;     // Catch: Throwable -> L52 ErrorResult -> L58
        if (r7 == null) goto L21;
        r6 = r7.getDoubaoMsgIds();     // Catch: Throwable -> L52 ErrorResult -> L58
    L21:
        if (r6 != null) goto L23;
        r6 = CollectionsKt.emptyList();     // Catch: Throwable -> L52 ErrorResult -> L58
    L23:
        List<Long> r8 = r6;     // Catch: Throwable -> L52 ErrorResult -> L58
        ArrayList r9 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r8, 10));     // Catch: Throwable -> L52 ErrorResult -> L58
        Iterator<T> r10 = r8.iterator();     // Catch: Throwable -> L52 ErrorResult -> L58
    L25:
        if (r10.hasNext() == false) goto L31;
        DoubaoContent.Builder r11 = new DoubaoContent.Builder().doubao_msg_id(Boxing.boxLong(((Number) r10.next()).longValue()));     // Catch: Throwable -> L52 ErrorResult -> L58
        if (r110 == null) goto L29;
        r11.doubao_data(r110);     // Catch: Throwable -> L52 ErrorResult -> L58
    L29:
        r9.add(r11.build());     // Catch: Throwable -> L52 ErrorResult -> L58
        goto L25
    L31:
        if (r9.isEmpty() == false) goto L34;
        this.$callback.onFailure("doubao message is empty");     // Catch: Throwable -> L52 ErrorResult -> L58
        return Unit.INSTANCE;
    L34:
        DoubaoToLarkExternalForwardExecutor.c r111 = DoubaoToLarkExternalForwardExecutor.c(this.this$0, this.$items);     // Catch: Throwable -> L52 ErrorResult -> L58
        DoubaoToLarkExternalForwardExecutor r12 = this.this$0;     // Catch: Throwable -> L52 ErrorResult -> L58
        List<String> r20 = r111.a;     // Catch: Throwable -> L52 ErrorResult -> L58
        List<Transmit2ThreadTarget> r21 = r111.b;     // Catch: Throwable -> L52 ErrorResult -> L58
        String r112 = r12.a;     // Catch: Throwable -> L52 ErrorResult -> L58
        this.L$0 = r111;     // Catch: Throwable -> L52 ErrorResult -> L58
        this.label = 1;     // Catch: Throwable -> L52 ErrorResult -> L58
        Object r22 = DoubaoToLarkExternalForwardExecutor.g(r12, r20, r21, r9, r112, this);     // Catch: Throwable -> L52 ErrorResult -> L58
        if (r22 != r0) goto L37;
        return r0;
    L37:
        r2 = r111;
        r13 = r22;
        goto L38
    L17:
        r110 = null;
        goto L18
    L14:
        r19 = null;
    L58:
        e = move-exception;
        Log.e("DoubaoToLarkExternalForwardExecutor", "transmit doubao messages failed: " + e, e);
        IExternalForwardExecutor.a r23 = this.$callback;
        String r24 = e.getDisplayMsg();
        if (r24 != null) goto L65;
        String r113 = e.getMessage();
        if (r113 == null) goto L66;
        r5 = r113;
    L66:
        r23.onFailure(r5);
        goto L68
    L65:
        r5 = r24;
    L52:
        th = move-exception;
        Log.e("DoubaoToLarkExternalForwardExecutor", "transmit doubao messages failed", th);
        IExternalForwardExecutor.a r25 = this.$callback;
        String r114 = th.getMessage();
        if (r114 == null) goto L57;
        r5 = r114;
    L57:
        r25.onFailure(r5);
        goto L68
    }
}
