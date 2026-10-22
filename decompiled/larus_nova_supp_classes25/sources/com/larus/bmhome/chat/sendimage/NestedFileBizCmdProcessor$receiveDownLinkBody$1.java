package com.larus.bmhome.chat.sendimage;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.model.ChatDraftItem;
import com.larus.bmhome.chat.model.t;
import com.larus.bmhome.chat.model.u;
import com.larus.bmhome.chat.model.x;
import com.larus.bmhome.nestedfile.EntityState;
import com.larus.bmhome.nestedfile.FieldType;
import com.larus.bmhome.nestedfile.NestedFileCacheManagerService;
import com.larus.bmhome.nestedfile.UpdateNestedMessageDownLinkInfo;
import com.larus.im.bean.message.NestedFileContent;
import com.larus.im.bean.message.UplinkFileEntity;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
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
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.sendimage.NestedFileBizCmdProcessor$receiveDownLinkBody$1", f = "NestedFileBizCmdProcessor.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class NestedFileBizCmdProcessor$receiveDownLinkBody$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ UpdateNestedMessageDownLinkInfo $downLinkInfo;
    int label;
    final /* synthetic */ NestedFileBizCmdProcessor this$0;

    public NestedFileBizCmdProcessor$receiveDownLinkBody$1(UpdateNestedMessageDownLinkInfo r1, NestedFileBizCmdProcessor r2, Continuation<? super NestedFileBizCmdProcessor$receiveDownLinkBody$1> r3) {
        this.$downLinkInfo = r1;
        this.this$0 = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new NestedFileBizCmdProcessor$receiveDownLinkBody$1(this.$downLinkInfo, this.this$0, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r18) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L116;
        ResultKt.throwOnFailure(r18);
        NestedFileCacheManagerService r0 = NestedFileCacheManagerService.b;
        UpdateNestedMessageDownLinkInfo r2 = this.$downLinkInfo;
        Intrinsics.checkNotNull(r2);
        r0.e(r2);
        NestedFileBizCmdProcessor r1 = this.this$0;
        final UpdateNestedMessageDownLinkInfo r3 = this.$downLinkInfo;
        Intrinsics.checkNotNull(r3);
        int r4 = NestedFileBizCmdProcessor.c;
        r1.getClass();
        String r5 = r3.getLocalMsgId();
        String r6 = null;
        if (r5 == null) goto L7;
        com.larus.im.d.e().x(r5, new f(r3), null);
    L7:
        x r7 = x.a;
        UpdateNestedMessageDownLinkInfo r8 = this.$downLinkInfo;
        Intrinsics.checkNotNull(r8);
        monitor-enter(r7);
        Intrinsics.checkNotNullParameter(r8, "info");     // Catch: Throwable -> L112
        FLogger.a.d("ChatDraftRepo", "updateNestedFileEntityItemFromCMD info:" + r8);     // Catch: Throwable -> L112
        String r9 = r8.getConversationId();     // Catch: Throwable -> L112
        final Ref.LongRef r10 = new Ref.LongRef();     // Catch: Throwable -> L112
        final Ref.LongRef r11 = new Ref.LongRef();     // Catch: Throwable -> L112
        int r12 = 2;
        List r13 = x.e(r7, r9, null, new t(r10, r11), 2);     // Catch: Throwable -> L112
        z2 r14 = z2.a;     // Catch: Throwable -> L112
        if (z2.c4() == true) goto L12;
    L37:
        List r15 = r13;
        String r16 = r9;
    L38:
        Iterator r17 = r15.iterator();     // Catch: Throwable -> L112
    L40:
        if (r17.hasNext() == false) goto L44;
        Object r19 = r17.next();     // Catch: Throwable -> L112
        if (Intrinsics.areEqual(((ChatDraftItem) r19).getType(), ChatDraftItem.TYPE_NESTED_FILE) == false) goto L40;
    L45:
        ChatDraftItem r20 = (ChatDraftItem) r19;     // Catch: Throwable -> L112
        if (r20 == null) goto L108;
        NestedFileContent r21 = r20.getNestedFileContent();     // Catch: Throwable -> L112
        if (r21 == null) goto L50;
        List r22 = r21.getEntities();     // Catch: Throwable -> L112
    L51:
        List r23 = r22;     // Catch: Throwable -> L112
        if (r23 != null) goto L54;
    L57:
        boolean r110 = true;
    L58:
        if (r110 == true) goto L108;
        if (o0.d(r8.getLocalMsgId()) == false) goto L108;
        if (Intrinsics.areEqual(r20.getKey(), r8.getLocalMsgId()) == false) goto L108;
        NestedFileContent r24 = r20.getNestedFileContent();     // Catch: Throwable -> L112
        if (r24 == null) goto L66;
        List r25 = r24.getEntities();     // Catch: Throwable -> L112
    L67:
        List r26 = r8.getEntityStateList();     // Catch: Throwable -> L112
        if (r26 == null) goto L108;
        List r27 = CollectionsKt.filterNotNull(r26);     // Catch: Throwable -> L112
        if (r27 == null) goto L108;
        Iterator r28 = r27.iterator();     // Catch: Throwable -> L112
    L73:
        if (r28.hasNext() == false) goto L108;
        EntityState r29 = (EntityState) r28.next();     // Catch: Throwable -> L112
        if (r25 == null) goto L84;
        Iterator r30 = r25.iterator();     // Catch: Throwable -> L112
    L78:
        if (r30.hasNext() == false) goto L82;
        Object r111 = r30.next();     // Catch: Throwable -> L112
        if (Intrinsics.areEqual(((UplinkFileEntity) r111).getFileIdentifier(), r29.getFileIdentifier()) == false) goto L78;
    L83:
        UplinkFileEntity r112 = (UplinkFileEntity) r111;     // Catch: Throwable -> L112
    L86:
        if (com.larus.bmhome.nestedfile.a.a(r29) == false) goto L73;
        List r31 = r29.getUpdateFields();     // Catch: Throwable -> L112
        if (r31 == null) goto L73;
        Iterator r32 = r31.iterator();     // Catch: Throwable -> L112
    L91:
        if (r32.hasNext() == false) goto L73;
        int r113 = ((Number) r32.next()).intValue();     // Catch: Throwable -> L112
        FieldType.a r114 = FieldType.Companion;     // Catch: Throwable -> L112
        Integer r115 = Integer.valueOf(r113);     // Catch: Throwable -> L112
        r114.getClass();     // Catch: Throwable -> L112
        int r116 = x.a.a[FieldType.a.a(r115).ordinal()];     // Catch: Throwable -> L112
        if (r116 != 1) goto L95;
        Integer r117 = r29.getParseState();     // Catch: Throwable -> L112
        if (r117 == null) goto L91;
        int r118 = r117.intValue();     // Catch: Throwable -> L112
        if (r112 == null) goto L91;
        r112.setFileParsedStatus(Integer.valueOf(r118));     // Catch: Throwable -> L112
        goto L91
    L95:
        if (r116 != 2) goto L91;
        Integer r119 = r29.getReviewState();     // Catch: Throwable -> L112
        if (r119 == null) goto L91;
        int r120 = r119.intValue();     // Catch: Throwable -> L112
        if (r112 == null) goto L91;
        r112.setFileReviewStatus(Integer.valueOf(r120));     // Catch: Throwable -> L112
        goto L91
    L82:
        r111 = null;
        goto L83
    L84:
        r112 = null;
        goto L86
    L66:
        r25 = null;
        goto L67
    L54:
        if (r23.isEmpty() == true) goto L57;
        r110 = false;
        goto L58
    L50:
        r22 = null;
    L108:
        long r33 = Math.max(System.currentTimeMillis(), Math.max(x.g + 1, r10.element + 1));     // Catch: Throwable -> L112
        x.g = r33;     // Catch: Throwable -> L112
        x.i(r7, r16, r15, r33, false, null, Long.valueOf(r10.element), r11.element, 24);     // Catch: Throwable -> L112
        monitor-exit(r7);
        return Unit.INSTANCE;
    L44:
        r19 = null;
        goto L45
    L12:
        if (o0.d(r8.getLocalMsgId()) == false) goto L37;
        Iterator r34 = CollectionsKt.distinct(CollectionsKt.listOf(new String[]{"__mobile_new_session_mode_draft_chat__", "__mobile_new_session_mode_draft_office__", r8.getConversationId()})).iterator();     // Catch: Throwable -> L112
    L15:
        if (r34.hasNext() == false) goto L37;
        String r121 = (String) r34.next();     // Catch: Throwable -> L112
        final Ref.LongRef r122 = new Ref.LongRef();     // Catch: Throwable -> L112
        final Ref.LongRef r123 = new Ref.LongRef();     // Catch: Throwable -> L112
        List r124 = x.e(r7, r121, r6, new u(r122, r123), r12);     // Catch: Throwable -> L112
        List r35 = r124;     // Catch: Throwable -> L112
        if ((r35 instanceof Collection) == true) goto L19;
    L21:
        Iterator r36 = r35.iterator();     // Catch: Throwable -> L112
    L23:
        if (r36.hasNext() == false) goto L33;
        ChatDraftItem r125 = (ChatDraftItem) r36.next();     // Catch: Throwable -> L112
        if (Intrinsics.areEqual(r125.getType(), ChatDraftItem.TYPE_NESTED_FILE) == true) goto L27;
    L29:
        boolean r37 = false;
    L30:
        if (r37 == false) goto L23;
        boolean r38 = true;
    L34:
        if (r38 == true) goto L35;
        r6 = null;
        r12 = 2;
        goto L15
    L35:
        r10.element = r122.element;     // Catch: Throwable -> L112
        r11.element = r123.element;     // Catch: Throwable -> L112
        r16 = r121;
        r15 = r124;
        goto L38
    L27:
        if (Intrinsics.areEqual(r125.getKey(), r8.getLocalMsgId()) == false) goto L29;
        r37 = true;
    L33:
        r38 = false;
        goto L34
    L19:
        if (r35.isEmpty() == false) goto L21;
    L112:
        th = move-exception;
        throw th;
    L116:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
