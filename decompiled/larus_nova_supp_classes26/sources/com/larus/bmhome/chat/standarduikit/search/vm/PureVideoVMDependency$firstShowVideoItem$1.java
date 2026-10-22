package com.larus.bmhome.chat.standarduikit.search.vm;

import com.larus.bmhome.chat.bean.FpaCommonParam;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.block.SearchVideoItem;
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
import org.json.JSONObject;
import tx9.z3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.chat.standarduikit.search.vm.PureVideoVMDependency$firstShowVideoItem$1", f = "PureVideoVMDependency.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class PureVideoVMDependency$firstShowVideoItem$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Message $message;
    final /* synthetic */ int $position;
    final /* synthetic */ SearchVideoItem $videoItem;
    int label;

    public PureVideoVMDependency$firstShowVideoItem$1(Message r1, int r2, SearchVideoItem r3, Continuation<? super PureVideoVMDependency$firstShowVideoItem$1> r4) {
        this.$message = r1;
        this.$position = r2;
        this.$videoItem = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new PureVideoVMDependency$firstShowVideoItem$1(this.$message, this.$position, this.$videoItem, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r11) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L16;
        ResultKt.throwOnFailure(r11);
        JSONObject r5 = new JSONObject();
        SearchVideoItem r12 = this.$videoItem;
        Message r0 = this.$message;
        r5.put("item_id", r12.itemId);
        String r13 = com.larus.bmhome.chat.bean.d.x(r0).getVideoSource();
        String r1 = "";
        if (r13 != null) goto L7;
        r13 = "";
    L7:
        r5.put("show_source", r13);
        FpaCommonParam r14 = com.larus.bmhome.chat.bean.d.z(r0);
        if (r14 == null) goto L13;
        String r15 = r14.getAgentId();
        if (r15 == null) goto L13;
        r1 = r15;
    L13:
        r5.put("agent_id", r1);
        z3.a(this.$message.getSenderId(), "search_slide_card", this.$message.getMessageId(), Boxing.boxLong(((long) this.$position) + 1), r5, 32);
        return Unit.INSTANCE;
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
