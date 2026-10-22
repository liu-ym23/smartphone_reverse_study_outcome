package com.larus.bmhome.chat.component.showcase;

import android.content.Context;
import com.larus.avlink.model.DoraCallStateCode;
import com.larus.bmhome.chat.bean.ChatPassThroughParams;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.helper.ChatRouterHelper;
import com.larus.platform.model.showcase.Case;
import de8.c;
import ic8.n;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import s1a.d;
import tx9.k0;
import wc9.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.component.showcase.ChatCaseMessageComponent$onViewCreated$2$2$1$1", f = "ChatCaseMessageComponent.kt", i = {}, l = {DoraCallStateCode.DOUBAO_VUI_ERROR}, m = "invokeSuspend", n = {}, s = {})
public final class ChatCaseMessageComponent$onViewCreated$2$2$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ e $conv;
    final /* synthetic */ String $cvsId;
    int label;
    final /* synthetic */ ChatCaseMessageComponent this$0;

    public ChatCaseMessageComponent$onViewCreated$2$2$1$1(String r1, ChatCaseMessageComponent r2, e r3, Continuation<? super ChatCaseMessageComponent$onViewCreated$2$2$1$1> r4) {
        this.$cvsId = r1;
        this.this$0 = r2;
        this.$conv = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new ChatCaseMessageComponent$onViewCreated$2$2$1$1(this.$cvsId, this.this$0, this.$conv, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r32) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        if (r2 == 0) goto L8;
        if (r2 != 1) goto L7;
        ResultKt.throwOnFailure(r32);
        Object r3 = r32;
    L11:
        String r4 = (String) CollectionsKt.firstOrNull((List) r3);
        if (r4 != null) goto L14;
    L17:
        boolean r5 = true;
    L18:
        if (r5 == true) goto L43;
        ChatRouterHelper r6 = ChatRouterHelper.a;
        Context r7 = this.this$0.getContext();
        by7.e r8 = s1a.a.c(this.this$0);
        if ((r8 instanceof by7.e) == false) goto L22;
        by7.e r21 = r8;
    L23:
        ChatCaseMessageComponent r9 = this.this$0;
        int r10 = ChatCaseMessageComponent.z;
        String r13 = r9.Y2();
        Case r11 = this.this$0.mz(false);
        if (r11 == null) goto L26;
        String r14 = r11.getTitle();
    L27:
        Case r12 = this.this$0.mz(false);
        if (r12 == null) goto L30;
        String r30 = r12.getRequestId();
    L31:
        String r15 = r30;
        ChatRouterHelper.h(r7, r4, this.$conv, null, "user_case_click_continue_talk", "user_case_detail", this.this$0.h3(), null, null, r13, r14, r15, Boxing.boxBoolean(false), true, false, true, false, r21, null, (ChatPassThroughParams) d.a(this.this$0).a(ChatPassThroughParams.class), null, null, false, null, null, 32833928);
        ChatCaseMessageComponent r16 = this.this$0;
        r16.y = true;
        c r17 = r16.f1();
        if (r17 == null) goto L34;
        String r18 = r17.p();
    L35:
        String r19 = r18;
        String r110 = this.this$0.h3();
        String r111 = this.this$0.Y2();
        Case r20 = this.this$0.mz(false);
        if (r20 == null) goto L38;
        String r112 = r20.getRequestId();
    L39:
        k0.a(r4, "user_case_click_continue_talk", this.$cvsId, "user_case_detail", r19, null, null, null, null, null, null, r110, r111, r112, null, null, null, null, 1019841);
        com.larus.bmhome.chat.component.trace.z r22 = (com.larus.bmhome.chat.component.trace.z) this.this$0.s.getValue();
        if (r22 == null) goto L43;
        r22.DF("click_continue_talk", null);
        goto L43
    L38:
        r112 = null;
        goto L39
    L34:
        r18 = "";
        goto L35
    L30:
        r30 = null;
        goto L31
    L26:
        r14 = null;
        goto L27
    L22:
        r21 = null;
    L43:
        return Unit.INSTANCE;
    L14:
        if (StringsKt.isBlank(r4) == true) goto L17;
        r5 = false;
        goto L18
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r32);
        String r23 = this.$cvsId;
        this.label = 1;
        r3 = n.b(r23, this);
        if (r3 != r1) goto L11;
        return r1;
    }
}
