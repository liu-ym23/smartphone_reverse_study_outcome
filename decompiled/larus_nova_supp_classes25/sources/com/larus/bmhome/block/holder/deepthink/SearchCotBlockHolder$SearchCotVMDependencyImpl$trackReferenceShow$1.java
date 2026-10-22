package com.larus.bmhome.block.holder.deepthink;

import com.larus.bmhome.chat.ChatParam;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.Reference;
import com.larus.im.bean.message.TextCard;
import com.larus.im.bean.message.VideoCard;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.block.holder.deepthink.SearchCotBlockHolder$SearchCotVMDependencyImpl$trackReferenceShow$1", f = "SearchCotBlockHolder.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class SearchCotBlockHolder$SearchCotVMDependencyImpl$trackReferenceShow$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Integer $index;
    final /* synthetic */ Reference $reference;
    final /* synthetic */ Integer $searchPosition;
    final /* synthetic */ String $toolType;
    int label;
    final /* synthetic */ SearchCotBlockHolder.SearchCotVMDependencyImpl this$0;

    public SearchCotBlockHolder$SearchCotVMDependencyImpl$trackReferenceShow$1(SearchCotBlockHolder.SearchCotVMDependencyImpl r1, Reference r2, String r3, Integer r4, Integer r5, Continuation<? super SearchCotBlockHolder$SearchCotVMDependencyImpl$trackReferenceShow$1> r6) {
        this.this$0 = r1;
        this.$reference = r2;
        this.$toolType = r3;
        this.$index = r4;
        this.$searchPosition = r5;
        super(2, r6);
    }

    public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
        return new SearchCotBlockHolder$SearchCotVMDependencyImpl$trackReferenceShow$1(this.this$0, this.$reference, this.$toolType, this.$index, this.$searchPosition, r9);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r22) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L78;
        ResultKt.throwOnFailure(r22);
        kn8.a r1 = this.this$0.b;
        if (r1 == null) goto L76;
        Message r2 = r1.b;
        if (r2 == null) goto L76;
        int r3 = oi8.n.a;
        ri8.c r4 = ri8.c.a;
        String r9 = ri8.c.g(Boxing.boxBoolean(true));
        String r5 = r2.getSenderId();
        if (r5 != null) goto L12;
        String r8 = "";
    L13:
        ChatParam r6 = this.this$0.f();
        Reference r7 = this.$reference;
        if (r7 == null) goto L21;
        TextCard r10 = r7.getTextCard();
        if (r10 == null) goto L21;
        Long r11 = r10.getId();
        if (r11 == null) goto L21;
        String r12 = r11.toString();
        if (r12 == null) goto L21;
    L29:
        String r13 = r12;
    L30:
        Reference r14 = this.$reference;
        if (r14 == null) goto L36;
        TextCard r15 = r14.getTextCard();
        if (r15 == null) goto L36;
        String r16 = r15.getUrl();
        if (r16 == null) goto L36;
    L41:
        String r17 = r16;
    L43:
        Reference r18 = this.$reference;
        if (r18 == null) goto L49;
        TextCard r19 = r18.getTextCard();
        if (r19 == null) goto L49;
        String r20 = r19.getDocId();
        if (r20 == null) goto L49;
    L54:
        String r110 = r20;
    L56:
        String r21 = this.$toolType;
        if (r21 != null) goto L59;
        String r111 = "";
    L60:
        Reference r23 = this.$reference;
        if (r23 == null) goto L66;
        TextCard r24 = r23.getTextCard();
        if (r24 == null) goto L66;
        String r25 = r24.getSearchId();
        if (r25 == null) goto L66;
    L71:
        String r26 = r25;
    L73:
        oi8.n.b(r2, r6, this.$index, this.$searchPosition, r13, "link", r8, r9, Boxing.boxBoolean(true), null, r110, r17, r111, null, null, null, r26, 115840);
        return Unit.INSTANCE;
    L66:
        Reference r27 = this.$reference;
        if (r27 == null) goto L72;
        VideoCard r28 = r27.getVideoCard();
        if (r28 == null) goto L72;
        r25 = r28.getSearchId();
    L72:
        r26 = null;
        goto L73
    L59:
        r111 = r21;
    L49:
        Reference r29 = this.$reference;
        if (r29 == null) goto L55;
        VideoCard r30 = r29.getVideoCard();
        if (r30 == null) goto L55;
        r20 = r30.getItemId();
    L55:
        r110 = null;
    L36:
        Reference r31 = this.$reference;
        if (r31 == null) goto L42;
        VideoCard r32 = r31.getVideoCard();
        if (r32 == null) goto L42;
        r16 = r32.getMainSiteUrl();
    L42:
        r17 = null;
    L21:
        Reference r33 = this.$reference;
        if (r33 == null) goto L26;
        VideoCard r34 = r33.getVideoCard();
        if (r34 == null) goto L26;
        r12 = r34.getId();
    L27:
        if (r12 != null) goto L29;
        r13 = "";
    L26:
        r12 = null;
        goto L27
    L12:
        r8 = r5;
    L76:
        return Unit.INSTANCE;
    L78:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
