package com.larus.bmhome.chat.component.list;

import androidx.fragment.app.Fragment;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.im.bean.message.Message;
import com.larus.platform.api.g1;
import com.larus.platform.service.i2;
import com.larus.utils.logger.FLogger;
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
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n"}, d2 = {"<anonymous>", "", "it", "Lcom/larus/im/bean/message/Message;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.component.list.ChatListComponent$observeStateChange$2", f = "ChatListComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class ChatListComponent$observeStateChange$2 extends SuspendLambda implements Function2<Message, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ ChatListComponent this$0;

    public static final class a implements g1.c {
        public final /* synthetic */ ChatListComponent a;

        public final void onGoSettingsDialogShow() {
        }

        public final void onSettingPageReturn() {
        }

        public a(ChatListComponent r1) {
            this.a = r1;
        }

        public final void onGoSettingsDialogDismiss(boolean r4) {
            FLogger.a.i("need_location", "onGoSettingsDialogDismiss: " + r4);
            if (r4 == true) goto L6;
            ChatListComponent.B3(this.a, false);
            return;
        }

        public final void onResult(boolean r2, List<String> r3, List<String> r4, boolean r5) {
            Intrinsics.checkNotNullParameter(r3, "grantedList");
            Intrinsics.checkNotNullParameter(r4, "deniedList");
            FLogger.a.i("need_location", "onResult: " + r2 + ", isGoSettingsDialogShown = " + r5);
            if (r5 == true) goto L6;
            ChatListComponent.B3(this.a, r2);
            return;
        }
    }

    public ChatListComponent$observeStateChange$2(ChatListComponent r1, Continuation<? super ChatListComponent$observeStateChange$2> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        ChatListComponent$observeStateChange$2 r0 = new ChatListComponent$observeStateChange$2(this.this$0, r4);
        r0.L$0 = r3;
        return r0;
    }

    public final Object invoke(Message r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((Message) r1, (Continuation) r2);
    }

    public final Object invokeSuspend(Object r11) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L33;
        ResultKt.throwOnFailure(r11);
        Message r12 = (Message) this.L$0;
        FLogger r0 = FLogger.a;
        StringBuilder r1 = new StringBuilder("messageNeedLocation changed: ");
        JSONObject r2 = null;
        if (r12 == null) goto L7;
        String r3 = r12.getMessageId();
    L8:
        r1.append(r3);
        r0.i("need_location", r1.toString());
        if (r12 == null) goto L30;
        ChatListComponent r4 = this.this$0;
        int r5 = ChatListComponent.W3;
        if (Intrinsics.areEqual(r4.G4(), r12.getConversationId()) == false) goto L30;
        List r6 = CollectionsKt.listOf("android.permission.ACCESS_FINE_LOCATION");
        Map r13 = r12.getExt();
        if (r13 == null) goto L27;
        String r14 = (String) r13.get("fpa_common_param");
        if (r14 == null) goto L27;
        ChatListComponent r7 = this.this$0;
        String r15 = new JSONObject(r14).optString("location_trace_info");     // Catch: JSONException -> L22
        Intrinsics.checkNotNull(r15);     // Catch: JSONException -> L22
        if ((!StringsKt.isBlank(r15)) == false) goto L24;
        r2 = new JSONObject(r15);     // Catch: JSONException -> L22
    L24:
        if (r2 == null) goto L27;
        JSONObject r8 = r2;
    L28:
        i2 r16 = i2.b;
        Fragment r9 = s1a.a.c(this.this$0);
        a r10 = new a(this.this$0);
        r8.put("trigger_from", "query");
        r8.put("auth_type", "foreground");
        Unit r17 = Unit.INSTANCE;
        g1.a.a(r9, r6, r10, null, r8, 8);
        FLogger.a.i("need_location", "request loc permission");
        return Unit.INSTANCE;
    L22:
        e = move-exception;
        FLogger.a.e(r7.n, "messageNeedLocation ext plugin_scene error", e);
        r2 = new JSONObject();
    L27:
        r8 = new JSONObject();
    L30:
        r0.i("need_location", "not valid messageNeedLocation");
        return Unit.INSTANCE;
    L7:
        r3 = null;
        goto L8
    L33:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
