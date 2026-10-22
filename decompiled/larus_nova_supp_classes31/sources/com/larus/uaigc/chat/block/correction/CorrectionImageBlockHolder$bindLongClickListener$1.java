package com.larus.uaigc.chat.block.correction;

import android.view.View;
import com.larus.bmhome.chat.ChatParam;
import com.larus.bmhome.chat.api.q0;
import com.larus.bmhome.chat.layout.holder.image.bean.ImageItem;
import com.larus.im.bean.message.Message;
import com.larus.platform.spi.IAIChatUgcAIGCService;
import com.tencent.open.log.TraceLevel;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.chat.block.correction.CorrectionImageBlockHolder$bindLongClickListener$1", f = "CorrectionImageBlockHolder.kt", i = {}, l = {117}, m = "invokeSuspend", n = {}, s = {})
final class CorrectionImageBlockHolder$bindLongClickListener$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ View $bindView;
    final /* synthetic */ String $currentBlockId;
    final /* synthetic */ ChatParam $currentChatParam;
    final /* synthetic */ String $currentMessageId;
    final /* synthetic */ q0.a $currentProvider;
    final /* synthetic */ ImageItem $imageItem;
    final /* synthetic */ Message $message;
    int label;
    final /* synthetic */ e this$0;

    public CorrectionImageBlockHolder$bindLongClickListener$1(e r1, String r2, Message r3, String r4, ImageItem r5, View r6, q0.a r7, ChatParam r8, Continuation<? super CorrectionImageBlockHolder$bindLongClickListener$1> r9) {
        this.this$0 = r1;
        this.$currentBlockId = r2;
        this.$message = r3;
        this.$currentMessageId = r4;
        this.$imageItem = r5;
        this.$bindView = r6;
        this.$currentProvider = r7;
        this.$currentChatParam = r8;
        super(2, r9);
    }

    public final Continuation<Unit> create(Object r11, Continuation<?> r12) {
        return new CorrectionImageBlockHolder$bindLongClickListener$1(this.this$0, this.$currentBlockId, this.$message, this.$currentMessageId, this.$imageItem, this.$bindView, this.$currentProvider, this.$currentChatParam, r12);
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
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r13);
    L11:
        Map r14 = (Map) r13;
        if (Intrinsics.areEqual(((jc8.b) this.this$0).b, this.$currentBlockId) == false) goto L26;
        if (Intrinsics.areEqual(this.$message.getMessageId(), this.$currentMessageId) == false) goto L26;
        IAIChatUgcAIGCService.Companion r4 = IAIChatUgcAIGCService.a;
        Integer r2 = this.$imageItem.getIndex();
        int r3 = 0;
        if (r2 == null) goto L19;
        int r5 = r2.intValue();
    L20:
        df8.a r8 = new df8.a(r5, this.$imageItem, null, r14);
        JSONObject r11 = new JSONObject();
        Integer r15 = this.$imageItem.getIndex();
        if (r15 == null) goto L23;
        r3 = r15.intValue();
    L23:
        r11.putOpt("position", Boxing.boxInt(r3 + 1));
        r4.C0(this.$bindView, this.$message, this.$currentProvider, r8, null, "homework_answer_action", r11);
        return Unit.INSTANCE;
    L19:
        r5 = 0;
    L26:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r13);
        CoroutineDispatcher r16 = Dispatchers.getIO();
        CorrectionImageBlockHolder$bindLongClickListener$1$commonParams$1 r6 = new CorrectionImageBlockHolder$bindLongClickListener$1$commonParams$1(this.$message, this.$currentChatParam, this.$currentProvider, null);
        this.label = 1;
        r13 = BuildersKt.withContext(r16, r6, this);
        if (r13 != r0) goto L11;
        return r0;
    }
}
