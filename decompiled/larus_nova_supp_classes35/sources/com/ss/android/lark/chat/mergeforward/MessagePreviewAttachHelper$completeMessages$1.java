package com.ss.android.lark.chat.mergeforward;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.lark.chat.core.api.ChatCoreModule;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.content.MergeForwardContent;
import com.ss.android.lark.chat.entity.message.content.PostContent;
import com.ss.android.lark.chat.entity.message.content.TextContent;
import com.ss.android.lark.export.entity.PreviewHangPoint;
import com.ss.android.lark.export.entity.UrlCardPreviewEntity;
import com.ss.android.lark.parser.internal.r;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import w4b.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lcom/ss/android/lark/chat/entity/message/Message;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.chat.mergeforward.MessagePreviewAttachHelper$completeMessages$1", f = "MessagePreviewAttachHelper.kt", i = {}, l = {45}, m = "invokeSuspend", n = {}, s = {})
final class MessagePreviewAttachHelper$completeMessages$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends Message>>, Object> {
    final /* synthetic */ boolean $isCompleteInnerMergeForwardMsg;
    final /* synthetic */ List<Message> $messages;
    int label;

    /* JADX WARN: Multi-variable type inference failed */
    public MessagePreviewAttachHelper$completeMessages$1(List<? extends Message> r1, boolean r2, Continuation<? super MessagePreviewAttachHelper$completeMessages$1> r3) {
        this.$messages = r1;
        this.$isCompleteInnerMergeForwardMsg = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new MessagePreviewAttachHelper$completeMessages$1(this.$messages, this.$isCompleteInnerMergeForwardMsg, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super List<? extends Message>> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r10) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r10);
    L44:
        Map r11 = (Map) r10;
        int r2 = c.a;
        List<Message> r3 = this.$messages;
        boolean r4 = this.$isCompleteInnerMergeForwardMsg;
        if (r3 == null) goto L94;
        ArrayList r5 = new ArrayList();
        Iterator<T> r6 = r3.iterator();
    L48:
        if (r6.hasNext() == false) goto L61;
        Object r7 = r6.next();
        Message r8 = (Message) r7;
        if (r8.getType() != Message.Type.TEXT) goto L52;
    L58:
        boolean r9 = true;
    L59:
        if (r9 == false) goto L48;
        r5.add(r7);
        goto L48
    L52:
        if (r8.getType() == Message.Type.POST) goto L58;
        if (r8.getType() != Message.Type.MERGE_FORWARD) goto L57;
        if (r4 == true) goto L58;
    L57:
        r9 = false;
        goto L59
    L61:
        Iterator r12 = r5.iterator();
    L63:
        if (r12.hasNext() == false) goto L94;
        Message r13 = (Message) r12.next();
        if (r13.getType() == Message.Type.TEXT) goto L66;
        if (r13.getType() == Message.Type.POST) goto L75;
        if (r13.getType() != Message.Type.MERGE_FORWARD) goto L63;
        MergeForwardContent r14 = (MergeForwardContent) r13.getContent();
        List<Message> r15 = r14.getMessages();
        if (r15 == null) goto L87;
        Message r16 = (Message) ListProtector.get(r15, 0);
    L89:
        if (r14.getThread() == null) goto L92;
        if (r16 == null) goto L92;
        c.a(CollectionsKt.mutableListOf(new Message[]{r16}), true);
    L92:
        c.a(r14.getMessages(), false);
        goto L63
    L87:
        r16 = null;
        goto L89
    L75:
        PostContent r17 = (PostContent) r13.getContent();
        Iterator<Map.Entry<String, PreviewHangPoint>> r18 = r17.getPreviewHangPoints().entrySet().iterator();
    L77:
        if (r18.hasNext() == false) goto L81;
        PreviewHangPoint r19 = r18.next().getValue();
        String r20 = r19.getPreviewId();
        if (r20 == null) goto L77;
        r19.setUrlCardPreviewEntity((UrlCardPreviewEntity) r11.get(r20));
        goto L77
    L81:
        r.x(r17.getRichText(), r17.getPreviewHangPoints());
        goto L63
    L66:
        TextContent r21 = (TextContent) r13.getContent();
        Iterator<Map.Entry<String, PreviewHangPoint>> r22 = r21.getPreviewHangPoints().entrySet().iterator();
    L68:
        if (r22.hasNext() == false) goto L72;
        PreviewHangPoint r23 = r22.next().getValue();
        String r24 = r23.getPreviewId();
        if (r24 == null) goto L68;
        r23.setUrlCardPreviewEntity((UrlCardPreviewEntity) r11.get(r24));
        goto L68
    L72:
        r.x(r21.getRichText(), r21.getPreviewHangPoints());
    L94:
        return this.$messages;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r10);
        ArrayList r110 = new ArrayList();
        List<Message> r25 = this.$messages;
        if (r25 == null) goto L41;
        ArrayList r26 = new ArrayList();
        Iterator<T> r27 = r25.iterator();
    L12:
        if (r27.hasNext() == false) goto L22;
        Object r28 = r27.next();
        Message r29 = (Message) r28;
        if (r29.getType() != Message.Type.TEXT) goto L16;
    L19:
        boolean r30 = true;
    L20:
        if (r30 == false) goto L12;
        r26.add(r28);
        goto L12
    L16:
        if (r29.getType() == Message.Type.POST) goto L19;
        r30 = false;
        goto L20
    L22:
        Iterator r31 = r26.iterator();
    L24:
        if (r31.hasNext() == false) goto L41;
        Message r32 = (Message) r31.next();
        if (r32.getType() == Message.Type.TEXT) goto L27;
        if (r32.getType() != Message.Type.POST) goto L24;
        Iterator<Map.Entry<String, PreviewHangPoint>> r33 = ((PostContent) r32.getContent()).getPreviewHangPoints().entrySet().iterator();
    L37:
        if (r33.hasNext() == false) goto L24;
        com.bytedance.lark.pb.basic.v1.PreviewHangPoint r34 = r33.next().getValue().parseToPB();
        if (r34 == null) goto L37;
        r110.add(r34);
        goto L37
    L27:
        Iterator<Map.Entry<String, PreviewHangPoint>> r35 = ((TextContent) r32.getContent()).getPreviewHangPoints().entrySet().iterator();
    L29:
        if (r35.hasNext() == false) goto L24;
        com.bytedance.lark.pb.basic.v1.PreviewHangPoint r36 = r35.next().getValue().parseToPB();
        if (r36 == null) goto L29;
        r110.add(r36);
    L41:
        f r37 = ChatCoreModule.a().getUrlPreviewDependency();
        this.label = 1;
        r10 = r37.a(r110, this);
        if (r10 != r0) goto L44;
        return r0;
    }
}
