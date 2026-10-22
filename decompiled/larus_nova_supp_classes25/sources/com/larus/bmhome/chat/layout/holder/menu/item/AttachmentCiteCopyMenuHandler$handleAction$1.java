package com.larus.bmhome.chat.layout.holder.menu.item;

import android.content.Context;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.layout.holder.helper.MessageCopyHelper;
import com.larus.bmhome.chat.trace.ChatControlTrace;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.UplinkFileEntity;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.layout.holder.menu.item.AttachmentCiteCopyMenuHandler$handleAction$1", f = "AttachmentCiteMenuHandler.kt", i = {0, 1}, l = {117, 123}, m = "invokeSuspend", n = {"entity", "entity"}, s = {"L$0", "L$0"})
public final class AttachmentCiteCopyMenuHandler$handleAction$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Context $ctx;
    final /* synthetic */ Message $data;
    final /* synthetic */ Function1<UplinkFileEntity, UplinkFileEntity> $entityMapper;
    final /* synthetic */ UplinkFileEntity $fallback;
    final /* synthetic */ ef8.b $menuContext;
    final /* synthetic */ String $targetFileIdentifier;
    Object L$0;
    int label;

    public AttachmentCiteCopyMenuHandler$handleAction$1(Message r1, String r2, UplinkFileEntity r3, ef8.b r4, Function1<? super UplinkFileEntity, UplinkFileEntity> r5, Context r6, Continuation<? super AttachmentCiteCopyMenuHandler$handleAction$1> r7) {
        this.$data = r1;
        this.$targetFileIdentifier = r2;
        this.$fallback = r3;
        this.$menuContext = r4;
        this.$entityMapper = r5;
        this.$ctx = r6;
        super(2, r7);
    }

    public final Continuation<Unit> create(Object r9, Continuation<?> r10) {
        return new AttachmentCiteCopyMenuHandler$handleAction$1(this.$data, this.$targetFileIdentifier, this.$fallback, this.$menuContext, this.$entityMapper, this.$ctx, r10);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r21) {
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r0 = this.label;
        JSONObject r6 = null;
        if (r0 == 0) goto L18;
        if (r0 == 1) goto L13;
        if (r0 != 2) goto L12;
        UplinkFileEntity r3 = (UplinkFileEntity) this.L$0;
        ResultKt.throwOnFailure(r21);     // Catch: Throwable -> L9
        Object r1 = r21;
    L51:
        Result.constructor-impl(Boxing.boxBoolean(((Boolean) r1).booleanValue()));     // Catch: Throwable -> L9
        UplinkFileEntity r7 = r3;
    L56:
        ChatControlTrace r4 = ChatControlTrace.b;
        Message r9 = this.$data;
        ef8.b r5 = this.$menuContext;
        by7.e r10 = r5.d;
        Function0<Long> r8 = r5.e;
        if (r8 == null) goto L59;
        long r11 = ((Number) r8.invoke()).longValue();
    L60:
        long r12 = r11;
        List r13 = CollectionsKt.emptyList();
        if (r7 != null) goto L63;
        r7 = this.$fallback;
    L63:
        if (r7 == null) goto L65;
        ic8.o.a.getClass();
        String r17 = ic8.o.b(r7);
    L66:
        JSONObject r14 = this.$menuContext.l;
        if (r14 == null) goto L76;
        String r15 = r14.optString("creation_task_id");
        if (r15 == null) goto L76;
        if ((!StringsKt.isBlank(r15)) == true) goto L74;
        r15 = null;
    L74:
        if (r15 == null) goto L76;
        r6 = new JSONObject();
        r6.put("creation_task_id", r15);
    L76:
        r4.getClass();
        Intrinsics.checkNotNullParameter("long_press_answer", "clickFrom");
        Intrinsics.checkNotNullParameter(r9, "msg");
        Intrinsics.checkNotNullParameter(r13, "markdownContentList");
        ChatControlTrace.c0("long_press_answer", r9, r10, r12, r13, null, "", null, r17, null, r6);
        return Unit.INSTANCE;
    L65:
        r17 = null;
        goto L66
    L59:
        r11 = -1;
    L9:
        th = th;
        r7 = r3;
    L55:
        Result.Companion r16 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L56
    L12:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L13:
        r7 = (UplinkFileEntity) this.L$0;
        ResultKt.throwOnFailure(r21);     // Catch: Throwable -> L16
        Object r18 = r21;
    L34:
        boolean r19 = ((Boolean) r18).booleanValue();     // Catch: Throwable -> L16
    L36:
        Object r20 = Result.constructor-impl(Boxing.boxBoolean(r19));     // Catch: Throwable -> L16
    L39:
        Boolean r22 = Boxing.boxBoolean(false);
        if (Result.isFailure-impl(r20) == false) goto L43;
        r20 = r22;
    L43:
        if (((Boolean) r20).booleanValue() == true) goto L56;
        UplinkFileEntity r23 = this.$fallback;
        if (r23 == null) goto L56;
        Context r24 = this.$ctx;
        MessageCopyHelper r25 = MessageCopyHelper.a;     // Catch: Throwable -> L54
        this.L$0 = r7;     // Catch: Throwable -> L54
        this.label = 2;     // Catch: Throwable -> L54
        r1 = r25.i(r24, r23, this);     // Catch: Throwable -> L54
        if (r1 != r2) goto L50;
        return r2;
    L50:
        r3 = r7;
    L54:
        th = th;
        goto L55
    L18:
        ResultKt.throwOnFailure(r21);
        ic8.u r26 = ic8.u.a;
        Message r27 = this.$data;
        String r28 = this.$targetFileIdentifier;
        r26.getClass();
        UplinkFileEntity r29 = ic8.u.b(r27, r28);
        if (r29 == null) goto L27;
        Function1<UplinkFileEntity, UplinkFileEntity> r30 = this.$entityMapper;
        if (r30 == null) goto L26;
        UplinkFileEntity r31 = (UplinkFileEntity) r30.invoke(r29);
        if (r31 == null) goto L26;
        r29 = r31;
    L26:
        r7 = r29;
    L28:
        Context r32 = this.$ctx;
        Result.Companion r33 = Result.Companion;     // Catch: Throwable -> L16
        if (r7 == null) goto L35;
        MessageCopyHelper r34 = MessageCopyHelper.a;     // Catch: Throwable -> L16
        this.L$0 = r7;     // Catch: Throwable -> L16
        this.label = 1;     // Catch: Throwable -> L16
        r18 = r34.i(r32, r7, this);     // Catch: Throwable -> L16
        if (r18 != r2) goto L34;
        return r2;
    L35:
        r19 = false;
        goto L36
    L27:
        r7 = null;
    L16:
        th = move-exception;
        Result.Companion r35 = Result.Companion;
        r20 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L39
    }
}
