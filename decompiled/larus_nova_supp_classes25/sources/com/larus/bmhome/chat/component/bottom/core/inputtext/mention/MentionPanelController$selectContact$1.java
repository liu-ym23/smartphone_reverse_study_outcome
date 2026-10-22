package com.larus.bmhome.chat.component.bottom.core.inputtext.mention;

import android.text.Editable;
import android.widget.EditText;
import com.larus.avlink.model.DoraCallStateCode;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.component.bottom.core.inputtext.ChatInputWithMentionDelegate;
import com.larus.bmhome.chat.component.bottom.core.inputtext.InputReferenceType;
import com.larus.bmhome.chat.component.bottom.core.inputtext.k1;
import com.larus.platform.exp.LarkSocialExp;
import com.larus.platform.service.AccountService;
import hq9.v2;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.JobKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.component.bottom.core.inputtext.mention.MentionPanelController$selectContact$1", f = "MentionPanelController.kt", i = {}, l = {1103}, m = "invokeSuspend", n = {}, s = {})
final class MentionPanelController$selectContact$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $accountId;
    final /* synthetic */ qp8.c $contact;
    final /* synthetic */ EditText $editText;
    final /* synthetic */ long $generation;
    final /* synthetic */ String $originalText;
    final /* synthetic */ k1 $queryRange;
    final /* synthetic */ v2 $session;
    int label;
    final /* synthetic */ MentionPanelController this$0;

    public MentionPanelController$selectContact$1(MentionPanelController r1, k1 r2, long r3, EditText r5, String r6, String r7, v2 r8, qp8.c r9, Continuation<? super MentionPanelController$selectContact$1> r10) {
        this.this$0 = r1;
        this.$queryRange = r2;
        this.$generation = r3;
        this.$editText = r5;
        this.$originalText = r6;
        this.$accountId = r7;
        this.$session = r8;
        this.$contact = r9;
        super(2, r10);
    }

    public final Continuation<Unit> create(Object r12, Continuation<?> r13) {
        return new MentionPanelController$selectContact$1(this.this$0, this.$queryRange, this.$generation, this.$editText, this.$originalText, this.$accountId, this.$session, this.$contact, r13);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r19) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        if (r2 == 0) goto L8;
        if (r2 != 1) goto L7;
        ResultKt.throwOnFailure(r19);
        Object r3 = r19;
    L11:
        String r4 = (String) r3;
        if (r4 != null) goto L14;
    L16:
        String r7 = null;
    L17:
        JobKt.ensureActive(getContext());
        if (Intrinsics.areEqual(this.this$0.n, this.$queryRange) == false) goto L98;
        if (this.$generation != this.this$0.B) goto L98;
        if (Intrinsics.areEqual(this.$editText.getText().toString(), this.$originalText) == false) goto L98;
        if (Intrinsics.areEqual(AccountService.a.getUserId(), this.$accountId) == false) goto L98;
        LarkSocialExp.a.getClass();
        if (Intrinsics.areEqual(LarkSocialExp.a(), this.$session) == false) goto L98;
        if (LarkSocialExp.f() == false) goto L98;
        if (r7 != null) goto L33;
        t19.s.j(t19.s.a, this.$editText.getContext(), this.$editText.getContext().getString(2131907052), null, false, 28);
        return Unit.INSTANCE;
    L33:
        ChatInputWithMentionDelegate r5 = this.this$0.a;
        k1 r6 = this.$queryRange;
        int r15 = r6.a;
        int r8 = r6.b;
        qp8.c r9 = this.$contact;
        String r10 = r9.b;
        String r11 = r9.c;
        String r12 = r9.a;
        r5.getClass();
        Intrinsics.checkNotNullParameter(r7, "id");
        Intrinsics.checkNotNullParameter(r10, "name");
        Editable r13 = r5.e.getEditableText();
        if (r13 != null) goto L37;
    L95:
        this.this$0.q();
        MentionPanelController r14 = this.this$0;
        r14.n = null;
        r14.l.invoke();
        return Unit.INSTANCE;
    L37:
        if (r15 < 0) goto L40;
        if (r15 > r8) goto L40;
        boolean r16 = true;
    L41:
        if (r16 == false) goto L95;
        if (r8 > r13.length()) goto L95;
        if (StringsKt.startsWith$default(r13.subSequence(r15, r8).toString(), "@", false, 2, null) == false) goto L95;
        Regex r17 = com.larus.bmhome.chat.component.bottom.core.inputtext.f0.a;
        Intrinsics.checkNotNullParameter(r7, "id");
        Intrinsics.checkNotNullParameter(r10, "name");
        if (new Regex("ou_[A-Za-z0-9]+").matches(r7) == false) goto L55;
        String r18 = StringsKt.trim(StringsKt.trimStart(StringsKt.trim(r10).toString(), new char[]{'@'})).toString();
        if (r18.length() != 0) goto L53;
        boolean r20 = true;
    L54:
        if (r20 == true) goto L55;
        if (r12 == null) goto L67;
        Long r21 = StringsKt.toLongOrNull(r12);
        if (r21 == null) goto L60;
        long r110 = r21.longValue();
    L62:
        if (r110 <= 0) goto L64;
        boolean r22 = true;
    L65:
        if (r22 == false) goto L67;
    L68:
        if (r11 != null) goto L70;
    L76:
        String r23 = null;
    L77:
        String r24 = "";
        if (r23 == null) goto L84;
        StringBuilder r111 = new StringBuilder(" avatar_key=\"");
        r111.append(com.larus.bmhome.chat.component.bottom.core.inputtext.f0.a(r23));
        r111.append("\" entity_id=\"");
        if (r12 == null) goto L83;
        r24 = r12;
    L83:
        r111.append(com.larus.bmhome.chat.component.bottom.core.inputtext.f0.a(r24));
        r111.append('\"');
        r24 = r111.toString();
    L84:
        InputReferenceType r112 = InputReferenceType.CONTACT;
        String r113 = "<at user_id=\"" + com.larus.bmhome.chat.component.bottom.core.inputtext.f0.a(r7) + '\"' + r24 + '>' + com.larus.bmhome.chat.component.bottom.core.inputtext.f0.b(r18) + "</at>";
        if (r23 == null) goto L87;
        boolean r25 = true;
    L88:
        if (r25 == false) goto L90;
        String r114 = r12;
    L91:
        com.larus.bmhome.chat.component.bottom.core.inputtext.d0 r26 = new com.larus.bmhome.chat.component.bottom.core.inputtext.d0(r7, r18, r112, null, null, null, r113, null, r23, r114, DoraCallStateCode.ENV_OBSERVE_USER_TIMER_END);
    L92:
        if (r26 == null) goto L95;
        r5.j(r15, r8, CollectionsKt.listOf(r26), true);
        goto L95
    L90:
        r114 = null;
        goto L91
    L87:
        r25 = false;
        goto L88
    L70:
        if ((!StringsKt.isBlank(r11)) == false) goto L73;
        if (r12 == null) goto L73;
        boolean r27 = true;
    L74:
        if (r27 == false) goto L76;
        r23 = r11;
    L73:
        r27 = false;
        goto L74
    L64:
        r22 = false;
        goto L65
    L60:
        r110 = 0;
    L67:
        r12 = null;
        goto L68
    L53:
        r20 = false;
    L55:
        r26 = null;
    L40:
        r16 = false;
    L98:
        return Unit.INSTANCE;
    L14:
        if (new Regex("ou_[A-Za-z0-9]+").matches(r4) == false) goto L16;
        r7 = r4;
        goto L17
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r19);
        MentionPanelController r28 = this.this$0;
        MentionPanelController$selectContact$1$openId$1 r29 = new MentionPanelController$selectContact$1$openId$1(this.$contact, r28, null);
        this.label = 1;
        r3 = MentionPanelController.a(r28, r29, this);
        if (r3 != r1) goto L11;
        return r1;
    }
}
