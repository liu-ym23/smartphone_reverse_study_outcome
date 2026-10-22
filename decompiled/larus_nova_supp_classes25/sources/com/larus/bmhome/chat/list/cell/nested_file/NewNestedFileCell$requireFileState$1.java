package com.larus.bmhome.chat.list.cell.nested_file;

import com.larus.bmhome.chat.api.ChatApi;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.resp.NestedFileRemoteState;
import com.larus.bmhome.nestedfile.FieldType;
import com.larus.network.http.HttpExtKt;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
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
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.list.cell.nested_file.NewNestedFileCell$requireFileState$1", f = "NewNestedFileCell.kt", i = {}, l = {384}, m = "invokeSuspend", n = {}, s = {})
final class NewNestedFileCell$requireFileState$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $localMsgID;
    int label;
    final /* synthetic */ NewNestedFileCell this$0;

    public NewNestedFileCell$requireFileState$1(NewNestedFileCell r1, String r2, Continuation<? super NewNestedFileCell$requireFileState$1> r3) {
        this.this$0 = r1;
        this.$localMsgID = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new NewNestedFileCell$requireFileState$1(this.this$0, this.$localMsgID, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r16) {
        Object r13 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r0 = this.label;
        if (r0 == 0) goto L8;
        if (r0 != 1) goto L7;
        ResultKt.throwOnFailure(r16);
        Object r1 = r16;
    L15:
        com.larus.network.http.y r2 = (com.larus.network.http.a) r1;
        if ((r2 instanceof com.larus.network.http.y) == false) goto L21;
        NestedFileRemoteState r3 = (NestedFileRemoteState) ((com.larus.network.http.a) r2).b;
        if (r3 == null) goto L21;
        r3.getData();
    L21:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r16);
        NewNestedFileCell r4 = this.this$0;
        String r5 = this.$localMsgID;
        int r6 = NewNestedFileCell.s;
        r4.getClass();
        com.larus.im.d.e().x(r5, new j(), null);
        Lazy<ChatApi> r7 = ChatApi.a;
        ChatApi r8 = ChatApi.a.a();
        String r9 = this.$localMsgID;
        List r10 = CollectionsKt.listOf(new FieldType[]{FieldType.REVIEW_STATE, FieldType.PARSE_STATE});
        this.label = 1;
        r8.getClass();
        JSONObject r11 = new JSONObject();
        r11.put("local_message_id", r9);
        JSONArray r12 = new JSONArray();
        Iterator r14 = r10.iterator();
    L10:
        if (r14.hasNext() == false) goto L12;
        r12.put((FieldType) r14.next());
        goto L10
    L12:
        Unit r15 = Unit.INSTANCE;
        r11.put("pos_index_list", r12);
        r1 = HttpExtKt.k("Message", NestedFileRemoteState.class, "/alice/message/entity_state", r11, null, null, false, null, null, null, this, 1008);
        if (r1 != r13) goto L15;
        return r13;
    }
}
