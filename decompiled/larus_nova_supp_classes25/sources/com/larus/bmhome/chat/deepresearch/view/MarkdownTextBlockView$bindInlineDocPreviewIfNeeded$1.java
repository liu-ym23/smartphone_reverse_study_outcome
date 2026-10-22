package com.larus.bmhome.chat.deepresearch.view;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.doclink.MessageDocPreviewRepository;
import com.larus.bmhome.view.textview.impl.CustomMarkdownTextView;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.deepresearch.view.MarkdownTextBlockView$bindInlineDocPreviewIfNeeded$1", f = "MarkdownMessageBlockView.kt", i = {}, l = {299}, m = "invokeSuspend", n = {}, s = {})
public final class MarkdownTextBlockView$bindInlineDocPreviewIfNeeded$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Map<CustomMarkdownTextView, CharSequence> $baseTexts;
    final /* synthetic */ String $bindKey;
    final /* synthetic */ com.larus.bmhome.chat.markdown.richtext.i $parseResult;
    final /* synthetic */ List<String> $previewUrls;
    final /* synthetic */ String $requestMessageId;
    int label;
    final /* synthetic */ MarkdownTextBlockView this$0;

    /* JADX WARN: Multi-variable type inference failed */
    public MarkdownTextBlockView$bindInlineDocPreviewIfNeeded$1(String r1, List<String> r2, MarkdownTextBlockView r3, String r4, com.larus.bmhome.chat.markdown.richtext.i r5, Map<CustomMarkdownTextView, ? extends CharSequence> r6, Continuation<? super MarkdownTextBlockView$bindInlineDocPreviewIfNeeded$1> r7) {
        this.$requestMessageId = r1;
        this.$previewUrls = r2;
        this.this$0 = r3;
        this.$bindKey = r4;
        this.$parseResult = r5;
        this.$baseTexts = r6;
        super(2, r7);
    }

    public final Continuation<Unit> create(Object r9, Continuation<?> r10) {
        return new MarkdownTextBlockView$bindInlineDocPreviewIfNeeded$1(this.$requestMessageId, this.$previewUrls, this.this$0, this.$bindKey, this.$parseResult, this.$baseTexts, r10);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r5) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        boolean r2 = true;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r5);
    L11:
        MessageDocPreviewRepository.a r6 = (MessageDocPreviewRepository.a) r5;
        MarkdownTextBlockView r3 = this.this$0;
        String r4 = this.$bindKey;
        int r7 = MarkdownTextBlockView.l;
        if (Intrinsics.areEqual(r3.k, r4) == true) goto L14;
    L16:
        r2 = false;
    L17:
        if (r2 == false) goto L19;
        this.this$0.d(this.$parseResult, r6, this.$baseTexts, "remote");
        return Unit.INSTANCE;
    L19:
        return Unit.INSTANCE;
    L14:
        if (r3.getParent() == null) goto L16;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r5);
        MessageDocPreviewRepository r8 = MessageDocPreviewRepository.a;
        String r9 = this.$requestMessageId;
        List<String> r10 = this.$previewUrls;
        this.label = 1;
        r5 = r8.a(r9, r10, this);
        if (r5 != r0) goto L11;
        return r0;
    }
}
